package com.jinm.pattern.adapter.demo.adapter;

import com.jinm.pattern.adapter.demo.ResultMsg;

public interface IThirdPartyLogin {

    ResultMsg qqLogin(String openId);

    ResultMsg wechatLogin(String openId);

    ResultMsg tokenLogin(String token);

    ResultMsg telephoneLogin(String phone, String code);

}
