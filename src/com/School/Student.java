package com.School;

class Std{
    int StudentId;
    String name;

    void SetterFnx(int StudentId, String name){
        this.StudentId = StudentId;
        this.name = name;
    }

    void getterFnx(){
        System.out.println(this.StudentId + " " + this.name);
    }

}

public class Student {
    public static void main( String [] args){
        Std s1 = new Std();
        s1.SetterFnx(1608, "Vansh thapar");
        s1.getterFnx();

    } 
}
