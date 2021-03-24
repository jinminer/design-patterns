package com.jinm.pattern.proxy.dynamic.jdk.customize.proxy;

import java.io.*;

public class CustomizeClassLoader extends ClassLoader{


    private File classPathFile;

    public CustomizeClassLoader(){
        String classPath = CustomizeClassLoader.class.getResource("").getPath();
        classPathFile = new File(classPath);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = CustomizeClassLoader.class.getPackage().getName() + "." + name;
        FileInputStream in;
        ByteArrayOutputStream out = null;

        try {

            if (classPathFile != null){

                File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");

                if (!classFile.exists()){
                    return null;
                }

                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();

                byte[] buff = new byte[1024];
                int len = 0;
                while ((len = in.read(buff)) != -1){
                    out.write(buff, 0, len);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(className, out.toByteArray(), 0, out.size());
    }
}
