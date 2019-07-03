package com.jinm.design.principle.singleresponsibility.single;

/**
 * test.
 * Created by jinm on  2019/07/04.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {




        /**
         *  根据业务模型对职责功能进行更加细致的划分，
         *  不同的功能职责由不同的类去承担，
         *  当新增业务或旧业务变更时，只需新增一个功能类或者修改需要变更业务类即可
         *  不会对其他平行业务造成影响
         */
        FlyBird bird = new FlyBird();
        bird.mainMoveMode("鸿雁");

        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("鸵鸟");

        SwimBird swimBird = new SwimBird();
        swimBird.mainMoveMode("企鹅");

    }

}
