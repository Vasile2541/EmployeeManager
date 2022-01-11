package com.step;

import com.step.department.*;
import com.step.editEmployee.EditEmployee;
import com.step.employeeObj.Employee;
import com.step.enums.EGender;
import com.step.findEmployee.FindEmployee;
import com.step.menu.MenuClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainEmployeeManagement {
    private static final Scanner sc         = new Scanner(System.in);
    static List<Employee> employeesList     = new LinkedList<>();
    static List<Employee> employeesFound    = new LinkedList<>();
    private static final MenuClass show     = new MenuClass();
    private static final EditEmployee edit  = new EditEmployee();


    static boolean runMainOneMoreTime;

    public static void main(String[] args) {
        do {
            runMainOneMoreTime = false;
            try {
                show.mainMenu();
                int x = sc.nextInt();    sc.nextLine();

                switch (x) {
                    case 1:     employeesList = insertEmployee(  );
                                break;

                    case 2:     employeesFound = FindEmployee.findEmployee( employeesList );
                                runMainOneMoreTime = showEmployees( employeesFound );
                                break;

                    case 3:     edit.editEmployee( employeesList );
                                runMainOneMoreTime = true;
                                break;

                    case 4:     employeesFound = FindEmployee.findEmployee( employeesList );
                                if( !employeesFound.isEmpty() ) {
                                    System.out.println();
                                    System.out.println("Next Employee(s) will be Deleted !!");
                                    runMainOneMoreTime = showEmployees(employeesFound);
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
                                runMainOneMoreTime = true;
                                break;

                    case 5:     System.out.println("\n\tFull Employee list:\n");
                                runMainOneMoreTime = showEmployees( employeesList );    break;

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
        }while(runMainOneMoreTime);

//////              /////           /////       ////


    }

    ////
    private static boolean showEmployees( List<Employee> employees ){
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
        return true;
    }


    ///  ///  /// / /// /// /// /// /// ///
    private static List<Employee> insertEmployee(  ){
        Employee e = new Employee();
        boolean outRunOneMoreTime;
        do {
            outRunOneMoreTime = false;
            //fName, lName
            System.out.println("\t1. Add new Employee:");
            String insert1 = "\t\t1.1 Insert Employee first   name: ";
            e.setfName(      checkForNotEmpty(insert1) );
            String insert2 = "\t\t1.2 Insert Employee last    name: ";
            e.setlName(      checkForNotEmpty(insert2) );
            //Email
            String insert3 = "\t\t1.3 Insert Employee        email: ";
            e.setEmail(      checkForNotEmpty(insert3) );
            //Phone
            String insert4 = "\t\t1.4 Insert Employee phone number: ";
            e.setPhoneNumber( checkForNotEmpty(insert4) );
            //Gender
            boolean oneMore;
                int intInput = 1;
                do {
                    oneMore = false;
                    System.out.print("\t\t1.5 Insert Employee gender (female-0/male-1): ");
                    try {
                        intInput = sc.nextInt(); sc.nextLine();
                    } catch (Exception ex) {
                        System.out.println("\t\t\t(Enter: 0 for Female, 1 for Male) ");
                        sc.nextLine();
                        oneMore = true;
                    }
                }while(oneMore);
            e.setGender( intInput == 0 ? EGender.FEMALE : EGender.MALE );
            //IDNP
            System.out.print("\t\t1.6 Insert IDNP for Employee    : ");
            String idnp = sc.nextLine();
            boolean isNumeric = idnp.chars().allMatch(Character::isDigit);
            while (idnp.length() != 13 || !isNumeric) {
                System.out.println("\t\t\t ***IDNP is not right format or length***");
                System.out.print("\t\t1.6 Insert IDNP for Employee    : ");
                idnp = sc.nextLine();
                isNumeric = idnp.chars().allMatch(Character::isDigit);
            }
            e.setIdnp(idnp);
            //DEPARTMENT,POSITION
            System.out.print("\t\t1.7 Insert Employee Department  : ");
            String dep = sc.nextLine();
            while (!containsInEnum( dep.toUpperCase() )) {
                System.out.print("\t\t *** Department not available, ");
                System.out.println("Choose one of available Departments ***");
                for (EDepartment department : EDepartment.values()) {
                    System.out.println("\t\t\t\t" + department.name());
                }
                System.out.print("\t\t1.7 Insert Employee Department : ");
                dep = sc.nextLine();
            }
            System.out.print("\t\t1.8 Insert Employee Position in  Department: ");
            String position = sc.nextLine();
            e.setDepartment( new Department(EDepartment.valueOf( dep.toUpperCase() ), position) );
            //check out recent added employee details
            boolean innerOneMoreTime;
            do{
                innerOneMoreTime = false;
                try{
                    System.out.println("\n\n\tCheck Out Added Employee Details !");
                    System.out.println(e);

                    System.out.println();
                    System.out.println("\t1) Edit just added Employee details      :");
                    System.out.println("\t2) Save Employee then Enter next Employee:");
                    System.out.println("\t3) Save and Go to MAIN MENU              :");
                    System.out.println();
                    System.out.print("\tEnter you choice then type Enter         : ");
                    int y = sc.nextInt(); sc.nextLine();

                    switch (y) {
                        case 1:
                            outRunOneMoreTime = true;
                            System.out.println();
                            break;
                        case 2:
                            employeesList.add(e);
//                            insertEmployee();///
                            outRunOneMoreTime = true;
                            break;
                        case 3:
                            employeesList.add(e);
                            runMainOneMoreTime = true;
                            break;
                        default: innerOneMoreTime = true;
                    }

                }catch (Exception x) {
                    System.out.print ("\n\t/// *****Please enter an available input !!");
                    System.out.println("\t(Available inputs are from zero to three) *****///");
                    sc.nextLine();
                    innerOneMoreTime = true;
                }
            }while( innerOneMoreTime );

        }while(outRunOneMoreTime);
        return employeesList;
    }

    private static String checkForNotEmpty( String insert ){
        String string;
        do {
            System.out.print( insert );
            string = sc.nextLine();
        }while( string.length() < 3 );
        return string;
    }

    private static boolean containsInEnum(String test) {
        for (EDepartment dep : EDepartment.values()) {
            if ( dep.name().equals(test) ) {
                return true;
            }
        }
        return false;
    }


}
