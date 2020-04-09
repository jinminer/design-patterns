package com.jinm.proxy;

public class ProxyPatternTest {

    public static void main(String[] args) {

        CommandExecutor executor = new CommandExecutorProxy("jinm", "wrong");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand("rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }

    }

}
