package com.jinm.design.principle.demeter.best;


import java.util.ArrayList;
import java.util.List;

/**
 * boss .
 * Created by jinm on  2019/07/14.  contact: keanemer.gmail.com
 */

public class Boss {

    /**
     *  修改代码的实现方式，Boss类只与TeamLeader类相关联
     */
    public void checkCourseNum(TeamLeader teamLeader){
        teamLeader.checkCourseNum();
    }

}
