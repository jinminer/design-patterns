package com.jinm.learning.design.pattern.behavioral.command;


import java.util.ArrayList;
import java.util.List;

/**
 * staff.
 * Created by jinm on  2019/08/23.  contact: keanemer.gmail.com
 */

public class Staff {

    private List<Command>  commandList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void executeCommands(){
        for (Command command : commandList){
            command.execute();
        }

        commandList.clear();

    }

}
