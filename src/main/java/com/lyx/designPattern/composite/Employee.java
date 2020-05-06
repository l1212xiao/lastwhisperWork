package com.lyx.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @classname Employee
 * @description Employee
 * @date 2020/4/30
 */
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates; //属下

    //构造函数
    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString(){
        return ("Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]");
    }
}
