package com.step;

import com.step.crud.*;
import com.step.employeeObj.Employee;
import com.step.menu.MenuClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainEmployeeManagement {
    private static final Scanner sc                 = new Scanner(System.in);
    private static List<Employee> employeesList     = new LinkedList<>();

    private static List<Employee> employeesFound    = new LinkedList<>();
    private static DeleteEmployee delete            = new DeleteEmployee();

    private static final MenuClass show             = new MenuClass();
    private static final EditEmployee edit          = new EditEmployee();


    public static void main(String[] args) {
        boolean runMainOneMoreTime;
        do {
            try {
                show.mainMenu();
                int x = sc.nextInt();    sc.nextLine();

                switch (x) {
                    case 1:     employeesList = InsertEmployee.insertEmployee( employeesList );
                                runMainOneMoreTime = true;
                                break;

                    case 2:     employeesFound = FindEmployee.findEmployee( employeesList );
                                ShowEmployees.showEmployees( employeesFound );
                                runMainOneMoreTime = true;
                                break;

                    case 3:     edit.editEmployee( employeesList );
                                runMainOneMoreTime = true;
                                break;

                    case 4:     delete.deleteEmployee( employeesList  );
                                runMainOneMoreTime = true;
                                break;

                    case 5:     System.out.println("\n\tFull Employee list:\n");
                                ShowEmployees.showEmployees( employeesList );
                                runMainOneMoreTime = true;
                                break;

                    case 6:     runMainOneMoreTime = false;                             break;
                    default:
                        System.out.println();
                        System.out.print ("\n\tPlease enter an available input !!");
                        System.out.println("\t(Available inputs are zero to six)");
                        System.out.print("\tHit Enter to see Main Menu: ");
                        sc.nextLine();
                        runMainOneMoreTime = true;
                }

            } catch (Exception e) {
                sc.nextLine();
                System.out.print ("\n\t/// *****Please enter an available input !!");
                System.out.println("\t(Available inputs are from zero to six) *****///");
                System.out.print("\t\t Hit Enter to see Main Menu: ");
                sc.nextLine();
                runMainOneMoreTime = true;
            }
        }while( runMainOneMoreTime );

    }

}
