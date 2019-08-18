package com.jinm.learning.design.pattern.behavioral.templatemethod;

/**
 * test.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("后端设计模式课程    start -------");
        ACourse designPatternCoures = new DesignPatternCourse();
        designPatternCoures.makeCourse();
        System.out.println("后端设计模式课程    end -------");
        System.out.println("--------------------------------------------------");

        System.out.println("前端课程 react    start -------");

        ACourse reactCourse = new FECourese(true);
        reactCourse.makeCourse();
        System.out.println("前端课程 react  end -------");
        System.out.println("--------------------------------------------------");

        System.out.println("前端课程 react    start -------");
        ACourse vueCourse = new FECourese(false);
        vueCourse.makeCourse();
        System.out.println("前端课程 react  end -------");

    }

}
