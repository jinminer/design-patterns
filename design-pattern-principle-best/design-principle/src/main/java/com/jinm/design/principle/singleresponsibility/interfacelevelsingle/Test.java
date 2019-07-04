package com.jinm.design.principle.singleresponsibility.interfacelevelsingle;

/**
 * single responsibility test.
 * Created by jinm on  2019/07/05.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        /**
         *
         *  应用层根据不同的业务流程，选择不同的接口实现类；
         *  课程信息类行为和课程管理类行为即可以相互作用，又互不影响；
         *  将选择执行那种职责（接口）的业务流程交由应用层去处理；
         *  比如用户进行退款，在应用层的业务流程中排除课程信息获取类的调用即可（如：常用的打标记等方法）
         */

        //课程信息
        ContentCourse contentCourse = new ContentCourse();

        //课程管理
        ManageCourse manageCourse = new ManageCourse();

    }

}
