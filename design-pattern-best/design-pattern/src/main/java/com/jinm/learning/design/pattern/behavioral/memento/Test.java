package com.jinm.learning.design.pattern.behavioral.memento;

/**
 * test.
 * Created by jinm on  2019/08/22.  contact: keanemer.gmail.com
 */

public class Test {

    public static void main(String[] args) {

        ArticleMementoManager manager = new ArticleMementoManager();

        //笔记版本v1
        Article article = new Article("v1：设计模式要点", "v1：设计模式在于抽象模型的建立", "v1：抽象模型示例图");

        //组装快照版本v1
        ArticleMemento memento = article.saveToMemento();

        //记录日志，存档
        manager.addMemento(memento);

        System.out.println("标题：" + article.getTitle() + "   " + article.getContent() + "    " + article.getImgs() + "暂存成功");

        System.out.println("笔记完整信息：" + article);

        System.out.println("修改笔记    start......");

        article.setTitle("v2：设计模式要点");
        article.setContent("v2：设计模式在于抽象模型的建立");
        article.setImgs("v2：抽象模型示例图");

        System.out.println("修改笔记    end......");
        System.out.println("笔记完整信息：" + article);

        //组装快照版本v2
        memento = article.saveToMemento();

        //记录日志，存档
        manager.addMemento(memento);

        article.setTitle("v3：设计模式要点");
        article.setContent("v3：设计模式在于抽象模型的建立");
        article.setImgs("v3：抽象模型示例图");

        System.out.println("暂存回退    start......");

        //笔记内容回退1次，到v2版本
        System.out.println("回退出栈1次");
        memento = manager.getMemento();
        article.undoFromMemento(memento);

        //笔记内容回退1次，到v1版本
        System.out.println("回退出栈2次");
        memento = manager.getMemento();
        article.undoFromMemento(memento);

        System.out.println("暂存回退    end......");

        System.out.println("笔记完整信息：" + article);


    }

}
