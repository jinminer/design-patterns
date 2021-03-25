package com.jinm.pattern.adapter.demo.adapterbest.adapters;

import com.jinm.pattern.adapter.demo.ResultMsg;

public class TokenLoginAdapter extends AbstractAdapter{
    @Override
    public boolean supported(Object object) {
        return object instanceof TokenLoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        if (! supported(adapter)){
            return new ResultMsg(500, "不支持当前登录方式", adapter);
        }
        return super.login(id, null);
    }
}
