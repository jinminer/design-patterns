package com.jinm.pattern.factory.function;

import com.jinm.pattern.factory.Mengniu;
import com.jinm.pattern.factory.Milk;

/**
 *  事情变得越来越专业
 *
 * Created by jinm on  2018/10/23.
 */

public class MengniuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Mengniu();
    }

}
