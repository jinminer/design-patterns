package com.jinm.pattern.singleton.register;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinm on  2018/10/29.
 */

public class RegisterMap {

    private RegisterMap() {}

    private static Map<String, Object> registers = new HashMap<String, Object>();

    public static RegisterMap getInstance(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }

        if (registers.get(name) == null) {
            registers.put(name , new RegisterMap());
        }

        return (RegisterMap) registers.get(name);

    }


}
