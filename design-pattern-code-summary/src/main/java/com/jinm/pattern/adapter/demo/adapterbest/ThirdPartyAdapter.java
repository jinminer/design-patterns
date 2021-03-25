package com.jinm.pattern.adapter.demo.adapterbest;

import com.jinm.pattern.adapter.demo.ResultMsg;
import com.jinm.pattern.adapter.demo.adapterbest.adapters.*;

public class ThirdPartyAdapter implements IThirdPartyLogin{
    @Override
    public ResultMsg qqLogin(String openId) {
        return processLogin(openId, QQLoginAdapter.class);
    }

    @Override
    public ResultMsg wechatLogin(String openId) {
        return processLogin(openId, WechatLoginAdapter.class);
    }

    @Override
    public ResultMsg tokenLogin(String token) {
        return processLogin(token, TokenLoginAdapter.class);
    }

    @Override
    public ResultMsg telephoneLogin(String phone, String code) {
        return processLogin(phone, TelephoneLoginAdapter.class);
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz){

        try {
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.supported(adapter)){
                return adapter.login(id, adapter);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

}
