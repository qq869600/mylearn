package com.wjq.springcloud.api;
/**
 * @author wu-junqiang
 * @date 2019/7/10
 */
public class Dept {
    /**
     * id
     */
    private String id;
    /**
     * 部门编号
     */
    private String name;

    public Dept() {
    }

    public Dept(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
