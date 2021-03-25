package com.jinm.pattern.adapter.demo.adapterbest.adapters;

import com.jinm.pattern.adapter.demo.PassportService;
import com.jinm.pattern.adapter.demo.ResultMsg;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {

    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.signup(username,password);
        return super.login(username,password);
    }

}
