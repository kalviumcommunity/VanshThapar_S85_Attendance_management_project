package com.School;

public class Main {
    public static void main(String[] args) {
        Std[] Students = new Std[2];
        Students[0] = new Std();
        Students[0].SetterFnx(1, "New student 1");
        Students[1] = new Std();
        Students[1].SetterFnx(2, "New student 2");
        for(int i=0;i<2;i++){
           Students[i].getterFnx();
        }
        Crs[] Courses = new Crs[2];
        Courses[0] = new Crs();
        Courses[0].SetterFnx(10, "New Course 1");
        Courses[1] = new Crs();
        Courses[1].SetterFnx(20, "New Course 2");
         for(int i=0;i<2;i++){
            Courses[i].getterFnx();
         }

    }
}




