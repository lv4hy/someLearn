package com.szx.netty.copy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeepCopyTest {

    @Test
    public void deepCopyGrade() throws CloneNotSupportedException {
        Grade grade = new Grade();
        grade.setGradeName("yiban");
        List<Student> list = new ArrayList<>();
        Student zhangsan = new Student();
        zhangsan.setName("zhangsan");
        list.add(zhangsan);
        grade.setStudents(list);
        Grade copided = grade.deepCopy(grade);
        grade.getStudents().get(0).setName("lisi");
        System.out.println(copided.getStudents().get(0).getName());

        System.out.println(grade.hashCode() == copided.hashCode());
        System.out.println(grade.getGradeName().hashCode() == copided.getGradeName().hashCode());
        System.out.println(grade.getStudents().get(0).hashCode() == copided.getStudents().get(0).hashCode());
    }

    @Test
    public void shadowCopy() throws CloneNotSupportedException {
        Grade grade = new Grade();
        grade.setGradeName("yiban");
        List<Student> list = new ArrayList<>();
        Student zhangsan = new Student();
        zhangsan.setName("zhangsan");
        list.add(zhangsan);
        grade.setStudents(list);
        Grade copided = grade.shadowCopy();
        grade.getStudents().get(0).setName("lisi");
        System.out.println(copided.getStudents().get(0).getName());

        System.out.println(grade.hashCode() == copided.hashCode());
        System.out.println(grade.getGradeName().hashCode() == copided.getGradeName().hashCode());
        System.out.println(grade.getStudents().get(0).hashCode() == copided.getStudents().get(0).hashCode());
    }
}