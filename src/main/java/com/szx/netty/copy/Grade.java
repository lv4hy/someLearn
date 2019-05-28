package com.szx.netty.copy;

import java.util.ArrayList;
import java.util.List;


public class Grade implements Cloneable{
    private String gradeName;
    private List<Student> students = new ArrayList<>();


    public Grade deepCopy(Grade orignal) throws CloneNotSupportedException {
       Grade grade = (Grade) super.clone();
       List<Student> students = new ArrayList<>();
       if(orignal.getStudents() != null){
           for(Student student : orignal.getStudents()){
               students.add((Student) student.clone());
           }
           grade.setStudents(students);
       }

       return grade;
    }

    public Grade shadowCopy() throws CloneNotSupportedException {
        return (Grade) super.clone();
    }



    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
