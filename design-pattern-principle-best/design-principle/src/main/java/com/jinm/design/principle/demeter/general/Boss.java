package com.jinm.design.principle.demeter.general;


import java.util.ArrayList;
import java.util.List;

/**
 * boss .
 * Created by jinm on  2019/07/14.  contact: keanemer.gmail.com
 */

public class Boss {

    /**
     *  从业务流程来看，boss向team leader提出一个统计课程数目的需求，boss类只需要和team leader类保持联系即可，
     *  老板不会关心具体的课程内容，以及team leader是用什么工具（无关类）什么方法实现的；
     *  从代码设计角度来看，boss类只与checkCourseNum方法的参数TeamLeader以及返回值void有直接的联系，
     *  对于方法内部的Course类并无直接的联系，至于使用ArrayList还是LinkedList、HashMap。。。等等都不需要去在意；
     *
     */
    public void checkCourseNum(TeamLeader teamLeader){
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        teamLeader.checkCourseNum(courseList);
    }

}
