package com.jinm.learning.design.pattern.behavioral.templatemethod;

/**
 * abstract course.
 * Created by jinm on  2019/08/18.  contact: keanemer.gmail.com
 */

/**
 *  场景：
 *      某网络课程平台，有不同的视频课程；
 *      视频课程包含各种资料如：视频、文档、源代码、图片等；
 *      对于所有的课程，课程制作的步骤都是一样的所以可定义为模板方法；
 *      对于不同的课程，配套的资料可能有所不同，这些差异性特点可交由子类去处理；
 */
public abstract class ACourse {

    /**
     *  模板方法：
     *      final修饰，不能被子类覆写，保证了算法逻辑流程不被修改
     */
    protected final void makeCourse(){

        /**
         *  模板方法的具体算法逻辑：
         *      逻辑步骤都是规定好的，而且是逻辑规则是不可更改的；
         *      如先制作ppt资料，再制作视频资料，最后打包所有的课程资料；
         */
        this.makePPT();
        this.makeVideo();

        /**
         *  钩子方法：由具体的实现子类来控制可选行为
         */
        if (needWriteArticle()){
            this.makeArticle();
        }

        this.packageCourse();

    }

    /**
     *  课程ppt：所有子类来说都适用，不需要个性化定制，所以声明为final型
     */
    final void makePPT(){
        System.out.println("制作PPT");
    }

    /**
     *  课程视频：所有子类通用方法，final修饰
     */
    final void makeVideo(){
        System.out.println("制作 Video");
    }

    /**
     *  课程笔记：
     *      对于编写笔记这个行为本身来说所以的课程编写的过程都是一样的，即内部实现都是相同的；
     *      但是并不是所有的课程都需要编写笔记，所以这个方法对于子类来讲是可选项；
     */
    final void makeArticle(){
        System.out.println("制作 笔记");
    }

    /**
     *  钩子方法：
     *      对于编写笔记这类可选行为，设置一个缺省的钩子方法，子类可以覆盖这个方法；
     *      即，添加一个权限控制方法，把控制逻辑交给子类，由子类决定是否执行；
     */
    protected boolean needWriteArticle(){
        return false;
    }

    /**
     *  包装课程：
     *      这个行为对于不同子类有不同的课程包装方式，所以声明为抽象方法，交由具体的子类去实现；
     *      如：前端课程需要打包ppt、视频、源码、图片素材等；设计模式课程需要打包ppt、源码、视频、笔记等；
     */
    abstract void packageCourse();

}
