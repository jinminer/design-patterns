package com.jinm.singleton.approach8;

public enum EnumSingleton {

    // enum singleton instance
    INSTANCE;

    /**
     * 单例资源：网络连接，数据库连接，线程池等等
     */
    private Resource resource;

    EnumSingleton(){

        // do something
        resource = new Resource();

    }

    public Resource getResource(){
        return resource;
    }

}

class Resource {
}
