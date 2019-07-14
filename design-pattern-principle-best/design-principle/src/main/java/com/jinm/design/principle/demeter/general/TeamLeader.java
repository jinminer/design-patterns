package com.jinm.design.principle.demeter.general;

import java.util.List;

/**
 * team leader.
 * Created by jinm on  2019/07/14.  contact: keanemer.gmail.com
 */

public class TeamLeader {

    public void checkCourseNum(List<Course> courses){
        System.out.println("课程统计结果为：" + courses.size());
    }

}
