package com.jinm.design.principle.demeter.best;

/**
 * test.
 * Created by jinm on  2019/07/14.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *  老板boss向team leader提出统计课程数目的需求
         */
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.checkCourseNum(teamLeader);

    }

}
