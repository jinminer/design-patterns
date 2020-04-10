package com.jinm.visitor;

public interface ItemElement {

    public int accept(ShoppingCartVisitor visitor);
}
