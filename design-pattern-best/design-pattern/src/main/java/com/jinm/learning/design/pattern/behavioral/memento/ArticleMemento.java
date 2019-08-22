package com.jinm.learning.design.pattern.behavioral.memento;

/**
 * .
 * Created by jinm on  2019/08/22.  contact: keanemer.gmail.com
 */

public class ArticleMemento {

    private String title;
    private String content;
    private String imgs;

    public ArticleMemento(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public String getContent() {
        return this.content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImgs() {
        return this.imgs;
    }

    @Override
    public String toString() {
        return "ArticleMemento{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }

}
