package com.bitedu.Main;

import com.bitedu.data.Student;

import static com.bitedu.db.DatabaseOperator.insertStudent;
import static com.bitedu.db.DatabaseOperator.selectStudent;

public class CourseSystem {
    public static void main(String[] args){
        Student stu = new Student();
        stu.setName("亚索");
        stu.setClassid(1);
        stu.setSno(2020001);
        insertStudent(stu);
        selectStudent(2020001);
        selectStudent(70);//查询成绩大于70分的
    }
}
