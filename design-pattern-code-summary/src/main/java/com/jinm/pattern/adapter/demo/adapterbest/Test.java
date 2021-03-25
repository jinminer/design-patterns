package com.jinm.pattern.adapter.demo.adapterbest;

import com.jinm.pattern.adapter.demo.adapterbest.adapters.ILoginAdapter;
import com.jinm.pattern.adapter.demo.adapterbest.adapters.QQLoginAdapter;

public class Test {

    public static void main(String[] args) {

        ThirdPartyAdapter adapter = new ThirdPartyAdapter();
        adapter.qqLogin("123456");

    }

}
