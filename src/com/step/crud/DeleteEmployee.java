package com.step.crud;

import com.step.employeeObj.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeleteEmployee {

    private static final Scanner sc         = new Scanner(System.in);
    static List<Employee> employeesFound    = new LinkedList<>();
//    private static ShowEmployees show = new ShowEmployees();

    public void deleteEmployee( List<Employee> employeesList ) {
        employeesFound = FindEmployee.findEmployee( employeesList );
        if( !employeesFound.isEmpty() ) {
            System.out.println();
            System.out.println("Next Employee(s) will be Deleted !!");
            ShowEmployees.showEmployees(employeesFound);
            //                                    for (Employee e: employeesList) {
            //                                        for ( Employee em: employeesFound) {
            //                                            if( e.equals( em ) ){
            //                                                employeesList.remove( e );
            //                                            }
            //                                        }
            //                                    }//dupa ideie treb sa mearga asta da nustiu dece nu merge
            //                                    (in caz ca sunt mai mult de un employee in Array se sterge doar primul employee
            //                                    for de mai jos merge),

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
