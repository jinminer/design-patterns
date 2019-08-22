package com.jinm.learning.design.pattern.behavioral.memento;

import java.util.Stack;

/**
 * article memento manager.
 * Created by jinm on  2019/08/22.  contact: keanemer.gmail.com
 */

public class ArticleMementoManager {

    /**
     *  使用stack的先进后出机制，保证每次ctrl + z 动作都回退到最近修改的一个版本
     */
    private final Stack<ArticleMemento> ARTICLE_MEMENTO_STACK = new Stack<>();

    /**
     *  版本回退
     */
    public ArticleMemento getMemento(){
        ArticleMemento articleMemento = ARTICLE_MEMENTO_STACK.pop();
        return articleMemento;
    }

    /**
     *
     */
    public void addMemento(ArticleMemento articleMemento){
        ARTICLE_MEMENTO_STACK.push(articleMemento);
    }

}
