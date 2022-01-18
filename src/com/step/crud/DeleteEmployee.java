package com.step.crud;

import com.step.employeeObj.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeleteEmployee {

    private static final Scanner sc         = new Scanner(System.in);
    static List<Employee> employeesFound    = new LinkedList<>();

    public void deleteEmployee( List<Employee> employeesList ) {
        employeesFound = FindEmployee.findEmployee( employeesList );
        if( !employeesFound.isEmpty() ) {
            System.out.println();
            System.out.println("Next Employee(s) will be Deleted !!");
            ShowEmployees.showEmployees(employeesFound);
            System.out.print("\n\t\tIf you are positive for delete type: YES, else NO ??? :");
            String check = sc.nextLine();
            if( check.equalsIgnoreCase("YES") ){
                for (int i = 0; i < employeesList.size(); i++) {
                    for (Employee employee : employeesFound) {
                        if (employeesList.get(i).equals(employee)) {
                            employeesList.remove(i);
                        }
                    }
                }
                System.out.println("\t\tEmployee(s) deleted ! \n\t\tHit Enter to see Main Menu:");
                sc.nextLine();
            }
            else {
                System.out.print ("\n\t\tNo Delete action has occurred !, Enter to continue: "); sc.nextLine();
            }
        }
        employeesFound.clear();
    }
}
