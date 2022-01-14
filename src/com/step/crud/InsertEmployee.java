package com.step.crud;

import com.step.department.Department;
import com.step.department.EDepartment;
import com.step.employeeObj.Employee;
import com.step.enums.EGender;

import java.util.List;
import java.util.Scanner;

public class InsertEmployee {
    private static final Scanner sc  = new Scanner(System.in);

    public static List<Employee> insertEmployee( List<Employee> employeesList ){
        boolean outRunOneMoreTime;
        do {
            Employee e = new Employee();

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
                            outRunOneMoreTime = true;
                            break;
                        case 3:
                            employeesList.add(e);
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
