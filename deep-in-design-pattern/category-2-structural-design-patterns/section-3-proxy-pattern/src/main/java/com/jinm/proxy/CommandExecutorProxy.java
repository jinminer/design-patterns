package com.jinm.proxy;

/**
 * Proxy Design Pattern – Proxy Class
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd){
        if ("jinm".equals(user) && "jinm".equals(pwd)){
            isAdmin = true;
        }
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {

        if (isAdmin){
            executor.runCommand(cmd);
        }else {
            if (cmd.contains("rm")){
                throw new Exception("");
            }else {
                executor.runCommand(cmd);
            }
        }

    }

}
