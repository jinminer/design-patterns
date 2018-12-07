package com.jinm.pattern.factory.function;

import com.jinm.pattern.factory.Milk;
import com.jinm.pattern.factory.Telunsu;

/**
 * Created by jinm on  2018/10/23.
 */

public class TelunsuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }

}
