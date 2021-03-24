package com.jinm.pattern.proxy.dynamic.jdk.customize;

import com.jinm.pattern.proxy.dynamic.jdk.customize.client.CustomizeJDKMeipo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {


        CustomizeJDKMeipo meipo = new CustomizeJDKMeipo();
        IPerson zhangSan = meipo.getInstance(new ZhangSan());
        zhangSan.findLove();

//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
//        try(FileOutputStream outputStream = new FileOutputStream("proxy-jdk-bytes-1.class");){
//            outputStream.write(bytes);
//        }catch  (IOException e) {
//            e.printStackTrace();
//        }

//        zhangSan.insure();

//        IPerson liSi = new JDKMeipo().getInstance(new LiSi());
//        liSi.findLove();
//        liSi.insure();

    }

}
