package com.wjq.springcloud.api;

/**
 * @author wu-junqiang
 * @date 2019/7/11
 */
public class Employee {
    /**
     * id
     */
    private String id;
    /**
     * 人员名称
     */
    private String name;
    /**
     * 部门
     */
    private Dept dept;

    public Employee() {
    }

    public Employee(String id, String name, Dept dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
