package com.School;

class Crs{
    int CourseId;
    String Coursename;

    void SetterFnx(int CourseId, String Coursename){
        this.CourseId = CourseId;
        this.Coursename = Coursename;
    }

    void getterFnx(){
        System.out.println(this.CourseId + " " + this.Coursename);
    }

}



public class Course {
        public static void main( String [] args){
        Crs c1 = new Crs();
        c1.SetterFnx(1608, "Vansh thapar");
        c1.getterFnx();

    } 
    
}
