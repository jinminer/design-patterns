package com.jinm.pattern.adapter.demo.adapter;

import com.jinm.pattern.adapter.demo.PassportService;
import com.jinm.pattern.adapter.demo.ResultMsg;

public class LoginAdapter extends PassportService implements IThirdPartyLogin{


    @Override
    public ResultMsg qqLogin(String openId) {
        System.out.println("qq 登陆前置处理");
        return loginForRegist(openId, null);
    }

    @Override
    public ResultMsg wechatLogin(String openId) {
        System.out.println("微信 登陆前置处理");
        return loginForRegist(openId, null);
    }

    @Override
    public ResultMsg tokenLogin(String token) {
        System.out.println("token认证 登陆前置处理");
        return loginForRegist(token, null);
    }

    @Override
    public ResultMsg telephoneLogin(String phone, String code) {
        System.out.println("token认证 登陆前置处理");
        return loginForRegist(phone, code);
    }

    private ResultMsg loginForRegist(String username,String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.signup(username,password);
        return super.login(username,password);
    }

}
