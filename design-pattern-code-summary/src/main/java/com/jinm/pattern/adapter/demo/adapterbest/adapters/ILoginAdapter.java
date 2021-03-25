package com.jinm.pattern.adapter.demo.adapterbest.adapters;

import com.jinm.pattern.adapter.demo.ResultMsg;

public interface ILoginAdapter {

    public boolean supported(Object object);

    public ResultMsg login(String id, Object adapter);

}
