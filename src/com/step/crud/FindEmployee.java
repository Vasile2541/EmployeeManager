package com.step.crud;

import com.step.employeeObj.Employee;
import com.step.menu.MenuClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindEmployee {
    private static final Scanner sc     = new Scanner(System.in);
    private static final MenuClass show = new MenuClass();
    private static List<Employee> employeesFound = new LinkedList<>();

    public static List<Employee> findEmployee( List<Employee> employees ){
        boolean runOneMoreTime;
        do {
            employeesFound.clear();
            show.findEmployeeMenu();
            try {
                runOneMoreTime = false;
                int x = sc.nextInt();    sc.nextLine();
                switch (x) {
                    case 1:  runOneMoreTime = byFirstName(employees);  break;
                    case 2:  runOneMoreTime = byLastName(employees);   break;
                    case 3:  runOneMoreTime = byIdnp(employees);       break;
                    case 4:  runOneMoreTime = byDepartment(employees); break;
                    case 5:                                            break;
                    default:
                        runOneMoreTime = true;
                        System.out.println();
                        System.out.print("\n\tPlease enter an available input !!");
                        System.out.println("\t(Available inputs are one to four)");
                        System.out.println("\tHit Enter to see Menu: ");
                        sc.nextLine();

                }
            }catch (Exception e) {
                runOneMoreTime = true;
                sc.nextLine();
                System.out.print ("\n\t/// *****Please enter an available input !!");
                System.out.println("\t(Available inputs are one to five) *****///");
                System.out.print("\t\t Hit Enter to see Menu: ");
                sc.nextLine();
            }
        }while( runOneMoreTime );
        return new LinkedList<>(employeesFound);
    }

////////
    private static boolean byFirstName( List<Employee> employeesList ){
        String fName = enterToFind("First Name");
        boolean notFound = true;
        for ( Employee employee : employeesList ) {
            if ( employee.getfName().equalsIgnoreCase( fName ) ) {
                employeesFound.add( employee );
                notFound = false;
            }
        }
        if( notFound ){
            System.out.println("\t'"+fName+"' not found in Employees list !");
            System.out.print("\tHit Enter for exit:  ");
            sc.nextLine();
        }
        return notFound;
    }

    private static boolean byLastName( List<Employee> employeesList ){
        String lName = enterToFind("Last Name");
        boolean notFound = true;
        for (Employee employee : employeesList) {
            if ( employee.getlName().equalsIgnoreCase( lName ) ) {
                employeesFound.add( employee );
                notFound = false;
            }
        }
        if( notFound ){
            System.out.println("\t'"+lName+"' not found in Employees list !");
            System.out.print("\tHit Enter for exit:  ");
            sc.nextLine();
        }
        return notFound;
    }

    private static boolean byIdnp( List<Employee> employeesList ){
        String idnp = enterToFind("IDNP");
        boolean notFound = true;
        for ( Employee employee : employeesList ) {
            if ( employee.getIdnp().equalsIgnoreCase( idnp ) ) {
                employeesFound.add( employee );
                notFound = false;
            }
        }
        if( notFound ){
            System.out.println("\t'"+idnp+"' not found in Employees list !");
            System.out.print("\tHit Enter for exit:  ");
            sc.nextLine();
        }
        return notFound;
    }


    private static boolean byDepartment( List<Employee> employeesList ){
        String dep = enterToFind("Department");
        boolean notFound = true;
        for ( Employee employee : employeesList ) {
            if ( employee.getDepartment().getDepartments().toString().equalsIgnoreCase(dep) ) {
                employeesFound.add( employee );
                notFound = false;
            }
        }
        if( notFound ){
            System.out.println("\t'"+dep+"' not found in Employees list !");
            System.out.print("\tHit Enter for exit:  ");
            sc.nextLine();
        }
        return notFound;
    }


    private static String enterToFind( String string ) {
        System.out.println();
        System.out.println("********** AAA Employee Management System **********\n");
        System.out.println();
        System.out.println("\tFind Employee by " + string + " !");
        System.out.print  ("\tEnter '" + string + "',then type Enter : ");
        String fName = sc.nextLine();
        return fName;
    }

}
