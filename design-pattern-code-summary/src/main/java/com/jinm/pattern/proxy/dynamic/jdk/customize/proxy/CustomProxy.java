package com.jinm.pattern.proxy.dynamic.jdk.customize.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CustomProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(CustomizeClassLoader customizeClassLoader, Class<?>[] interfaces, CustomizeInvocationHandler customizeInvocationHandler) {

        try {
            // 1.动态生成 .java 源文件 字符集
            String source = genericSource(interfaces);
            System.out.println("==============================");
            System.out.println(source);
            System.out.println("==============================");

            // 2.将 .java 源文件字符集 序列号输出到磁盘上，形成 .java 文件
            String filePath = CustomProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter writer = new FileWriter(file);
            writer.write(source);
            writer.flush();
            writer.close();

            // 3. 对磁盘上的  .java 文件进行编译，生成 .class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4. 将  .class 文件加载到 jvm 中
            Class proxyClass = customizeClassLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(CustomizeInvocationHandler.class);
            file.delete();

            // 5. 生成 类的 实例化对象
            return constructor.newInstance(customizeInvocationHandler);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String genericSource(Class<?>[] interfaces) {

        StringBuilder builder = new StringBuilder();
        builder.append(CustomProxy.class.getPackage() + ";" + ln);
        builder.append("import java.lang.reflect.*;" + ln);
        builder.append(ln);
        builder.append("public class $Proxy0 implements " +interfaces[0].getName()+ " {" + ln);
        builder.append(ln);
            builder.append("CustomizeInvocationHandler h;" + ln);
            builder.append(ln);
            builder.append("public $Proxy0(CustomizeInvocationHandler h){");
                builder.append("this.h = h;" + ln);
            builder.append("    }" + ln);

            for (Method m : interfaces[0].getMethods()){

                Class<?>[] params = m.getParameterTypes();

                StringBuilder paramNames = new StringBuilder();
                StringBuilder paramValues = new StringBuilder();
                StringBuilder paramClasses = new StringBuilder();

                for (int i = 0; i< params.length; i++){

                    Class clazz = params[i];
                    String type = clazz.getName();
                    String paramName = toLowerFirstCase(clazz.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramValues.append(paramName);
                    paramClasses.append(clazz.getName() + ".class");
                    if (i > 0 && i < params.length -1){
                        paramNames.append(",");
                        paramValues.append(",");
                        paramClasses.append(",");
                    }

                }

                builder.append(ln);
                builder.append("public " + m.getReturnType().getName() + " " + m.getName() +"(" + paramNames.toString() + "){" + ln);
                builder.append(ln);
                    builder.append("try{" + ln);
                    builder.append(ln);
                        builder.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
                        builder.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",m.getReturnType()) + ";" + ln);
                    builder.append(ln);
                    builder.append("}catch(Error _ex){}");
                    builder.append("catch(Throwable e){" + ln);
                        builder.append("throw new UndeclaredThrowableException(e);" + ln);
                    builder.append("}" + ln);
                    builder.append(getReturnEmptyCode(m.getReturnType()) + ln);
                builder.append("}" + ln);

            }

        builder.append("}" + ln);

        return builder.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

}




