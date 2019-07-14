package com.jinm.design.principle.demeter.best;

import java.util.ArrayList;
import java.util.List;

/**
 * team leader.
 * Created by jinm on  2019/07/14.  contact: keanemer.gmail.com
 */

public class TeamLeader {

    /**
     *  统计何种课程，如果统计课程的业务都由TeamLeader类来做，Boss类不用关心这些问题；
     */
    public void checkCourseNum(){

        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        System.out.println("课程统计结果为：" + courses.size());

    }

}
