package com.step.crud;

import com.step.employeeObj.Employee;

import java.util.List;
import java.util.Scanner;

public class ShowEmployees {
    private static final Scanner sc = new Scanner(System.in);

    public static void showEmployees( List<Employee> employees ){
        System.out.println();
        if( employees.isEmpty() ) {
            System.out.println("\t\tEmployee List is empty !!!");
        }else{
            for (Employee e : employees) {
                System.out.println();
                System.out.println(e);
            }
        }
        System.out.println();
        System.out.print("\t\tHit Enter to see Main Menu: ");
        sc.nextLine();
    }

}
