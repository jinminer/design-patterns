package com.jinm.singleton.approach6;

public class InstructionRearrangementSingleton {

    /**
     * instance = new InstructionRearrangementSingleton();
     * 这个步骤，其实在jvm里面的执行分为三步：
     *      1.在堆内存开辟内存空间。
     *      2.在堆内存中实例化SingleTon里面的各个参数。
     *      3.把对象指向堆内存空间。
     *
     * 由于jvm存在乱序执行功能，所以可能在2还没执行时就先执行了3，
     * 如果此时再被切换到线程B上，由于执行了3，INSTANCE 已经非空了，
     * 会被直接拿出来用，这样的话，就会出现异常。这个就是著名的DCL失效问题。
     *
     * jdk 1.6 开始提供了 volatile 关键字（ <= 1.5，可使用静态内部类的方式防止多线程模式下的指令重排），
     * 确保INSTANCE每次均在主内存中读取，这样虽然会牺牲一点效率，但也无伤大雅。
     *
     *
     */
    private static volatile InstructionRearrangementSingleton instance;

    private InstructionRearrangementSingleton(){

    }

    private static synchronized InstructionRearrangementSingleton getInstance(){

        if (instance == null){

            synchronized (InstructionRearrangementSingleton.class){
                if (instance == null){
                    instance = new InstructionRearrangementSingleton();
                }

            }

        }

        return instance;

    }

}
