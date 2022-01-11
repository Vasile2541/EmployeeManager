package com.step.menu;

public class MenuClass {

    public void mainMenu(){
        System.out.println("\n");
        System.out.println("********** AAA Employee Management System **********\n");
        System.out.println("\t1) Add new  Employee  :");
        System.out.println("\t2) Find     Employee  :");
        System.out.println("\t3) Edit     Employee  :");
        System.out.println("\t4) Delete   Employee  :");
        System.out.println("\t5) Show all Employees :");
        System.out.println("\t6) Exit Application   :");
        System.out.print("\n\t Choose your action(enter a number of your choice): ");
    }

    public void findEmployeeMenu() {
        System.out.println("\n");
        System.out.println("********** AAA Employee Management System **********\n");
        System.out.println("\t1) Find Employee by firstname  :");
        System.out.println("\t2) Find Employee by lastname   :");
        System.out.println("\t3) Find Employee by IDNP       :");
        System.out.println("\t4) Find Employee by department :");
        System.out.println("\t5) Exit :");
        System.out.print  ("\t   Enter your choice : ");

    }

    public void editEmployeeMenu(){
        System.out.println("\n");
        System.out.println("********** AAA Employee Management System **********\n");
        System.out.println("\t1) Edit Employee firstname    :");
        System.out.println("\t2) Edit Employee lastname     :");
        System.out.println("\t3) Edit Employee Gender       :");
        System.out.println("\t4) Edit Employee Department   :");
        System.out.println("\t5) Edit Employee Email        :");
        System.out.println("\t6) Edit Employee Phone Number :");
        System.out.println("\t7) Exit :");
        System.out.print  ("\t   Enter your choice : ");
    }
}
