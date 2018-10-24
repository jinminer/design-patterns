package com.jinm.pattern.factory.abs;

import com.jinm.pattern.factory.*;

/**
 * Created by jinm on  2018/10/24.
 */

public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getTelunsu() {
        //
        //return new TelunsuFactory().getMilk();
        return new Telunsu();
    }

    @Override
    public Milk getMengniu() {

        //return new MengniuFactory().getMilk();
        return new Mengniu();
    }

    @Override
    public Milk getYili() {

        //return new YiliFactory().getMilk();
        return new Yili();
    }

    @Override
    public Milk getSanlu() {
        return new Sanlu();
    }
}
