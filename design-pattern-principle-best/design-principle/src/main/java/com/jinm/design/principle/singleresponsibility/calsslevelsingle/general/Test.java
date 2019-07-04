package com.jinm.design.principle.singleresponsibility.calsslevelsingle.general;

/**
 * test.
 * Created by jinm on  2019/07/04.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        Bird bird = new Bird();

        /**
         *  bird类未遵守单一职责原则，将鸟类移动的方式未进行细致的划分，
         *  具备飞行能力的鸟类和不具备飞行能力的鸟类调用了同一功能模块
         */
        bird.mainMoveMode("鸿雁");
        bird.mainMoveMode("鸵鸟");
        bird.mainMoveMode("企鹅");

        /**
         *  if-else分支进行职责区分处理（实际开发中最常用的方法）
         *  当不断有新增业务时，需要不断的对该功能模块进行修改（如：不断地在bird类中添加分支等）
         *  bird类承担了过多的职责，当某一职责发生变化或者新增一个职责时可能会对原有职责或其他平行功能造成影响
         */
        bird.mainMoveModeWithJudge("鸿雁");
        bird.mainMoveModeWithJudge("鸵鸟");
        bird.mainMoveModeWithJudge("企鹅");

    }

}
