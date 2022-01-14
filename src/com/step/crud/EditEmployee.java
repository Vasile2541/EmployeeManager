package com.step.crud;

import com.step.department.Department;
import com.step.department.EDepartment;
import com.step.employeeObj.Employee;
import com.step.enums.EGender;
import com.step.menu.MenuClass;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class EditEmployee {
    private static final Scanner sc     = new Scanner(System.in);
    private static final MenuClass show = new MenuClass();

///// / // /  // // ///
    public void editEmployee( List<Employee> employeesList ){
        Employee e = FindByIdnp( employeesList );
        if( Objects.isNull( e ) ){
            System.out.println("\t\t\tNo employee found with this specific IDNP !");
            System.out.print("\t\t\tEnter to continue: ");
            sc.nextLine();
        }else{
            boolean oneMoreTime;
            do{
                System.out.println("\n\tEmployee to edit:\n\n"+e);
                oneMoreTime = false;
                try {
                    show.editEmployeeMenu();
                    int input = sc.nextInt();   sc.nextLine();
                    switch (input) {
                        case 1:
                            System.out.println();
                            System.out.print("\t\tEmployee first name is: '" + e.getfName() + "',");
                            System.out.print("\tEdit Employee first name(or Enter to Skip) :");
                            String name = sc.nextLine();
                            if (name.isEmpty()) {
                                System.out.println("\t\tNo change has occurred, Employee name is '" + e.getfName() + "'");
                                System.out.println("\t\tEnter to continue: ");
                                sc.nextLine();
                            } else {
                                e.setfName(name);
                            }
                            oneMoreTime = true;
                            break;
                        case 2:
                            System.out.println();
                            System.out.print("\t\tEmployee last name is: '" + e.getlName() + "';");
                            System.out.print("\t\tEdit Employee last name(or Enter to Skip) :");
                            String lName = sc.nextLine();
                            if (lName.isEmpty()) {
                                System.out.println("\t\tNo change has occurred, Employee name is '" + e.getlName() + "'");
                                System.out.println("\t\tEnter to continue: ");
                                sc.nextLine();
                            } else {
                                e.setlName(lName);
                            }
                            oneMoreTime = true;
                            break;
                        case 3:
                            System.out.println();
                            System.out.print("\t\tEmployee Gender is: '" + e.getGender() + "',");
                            System.out.print("\tEdit Employee Gender(Type: yes)or( Enter to Skip) :");
                            String gender = sc.nextLine();
                            if (gender.isEmpty()) {
                                System.out.println("\t\tNo change has occurred, Employee Gender is '" + e.getGender() + "';");
                                System.out.println("\t\tEnter to continue: ");
                                sc.nextLine();
                            } else {
                                boolean oneMore;
                                int intInput = 1;
                                do {
                                    oneMore = false;
                                    System.out.print("\t\tInsert Employee gender (female-0/male-1): ");
                                    try {
                                        intInput = sc.nextInt();
                                        sc.nextLine();
                                    } catch (Exception ex) {
                                        System.out.println("\t\t\t(Enter: 0 for Female, 1 for Male) ");
                                        sc.nextLine();
                                        oneMore = true;
                                    }
                                } while (oneMore);
                                e.setGender(intInput == 0 ? EGender.FEMALE : EGender.MALE);
                            }
                            oneMoreTime = true;
                            break;
                        case 4:
                            System.out.println();
                            System.out.print("\t\tEmployee Department is: '" + e.getDepartment() + "';");
                            System.out.print("\t\tEdit Employee Department(Type : yes)or( Enter to Skip) :");
                            String department = sc.nextLine();
                            if ( department.isEmpty() ) {
                                System.out.println("\t\tNo change has occurred, Employee department is '" + e.getDepartment() + "';");
                                System.out.println("\t\tEnter to continue: ");
                                sc.nextLine();
                            } else {
                                System.out.print("\t\tInsert Employee Department  : ");
                                String dep = sc.nextLine();
                                while (!containsInEnum(dep.toUpperCase())) {
                                    System.out.print("\t\t *** Department not available, ");
                                    System.out.println("Choose one of available Departments ***");
                                    for (EDepartment d : EDepartment.values()) {
                                        System.out.println("\t\t\t\t" + d.name());
                                    }
                                    System.out.print("\t\tInsert Employee Department : ");
                                    dep = sc.nextLine();
                                }
                                System.out.print("\t\tInsert Employee Position in  Department: ");
                                String position = sc.nextLine();
                                e.setDepartment(new Department(EDepartment.valueOf(dep.toUpperCase()), position));
                            }
                            oneMoreTime = true;
                            break;
                        case 5:
                            System.out.println();
                            System.out.print("\t\tEmployee Email is: '" + e.getEmail() + "';");
                            System.out.print("\t\tEdit Employee Email(or Enter to Skip) :");
                            String email = sc.nextLine();
                            if (email.isEmpty()) {
                                System.out.println("\t\tNo change has occurred, Employee Email is '" + e.getEmail() + "'");
                                System.out.println("\t\tEnter to continue: ");
                                sc.nextLine();
                            } else {
                                e.setEmail(email);
                            }
                            oneMoreTime = true;
                            break;
                        case 6:
                            System.out.println();
                            System.out.print("\t\tEmployee Phone Number is: '" + e.getPhoneNumber() + "';");
                            System.out.print("\t\tEdit Employee Phone Number(or Enter to Skip) :");
                            String phoneNr = sc.nextLine();
                            if (phoneNr.isEmpty()) {
                                System.out.println("\t\tNo change has occurred, Employee Phone Number is '" + e.getPhoneNumber() + "'");
                                System.out.println("\t\tEnter to continue: ");
                                sc.nextLine();
                            } else {
                                e.setPhoneNumber(phoneNr);
                            }
                            oneMoreTime = true;
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("\t\tAvailable input (one to seven)!");
                    }
                }catch (Exception ex)
                  {
                    System.out.print ("\n\t/// *****Please enter an available input !!");
                    System.out.println("\t(Available inputs are from one to seven) *****///");
                    sc.nextLine();
                    oneMoreTime = true;
                  }
            }while( oneMoreTime );
        }
    }

    ///// / / // / /

    private static Employee FindByIdnp( List<Employee> employeesList ){
        System.out.print ("\n\tEnter IDNP to find Employee: ");
        String idnp = sc.nextLine();
        Employee e  = new Employee();
        boolean isNumeric = idnp.chars().allMatch(Character::isDigit);
        while (idnp.length() != 13 || !isNumeric) {
            System.out.println("\t\t\t ***IDNP is not right format or length***");
            System.out.print("\t\tEnter IDNP to find Employee (Enter to exit): ");
            idnp = sc.nextLine();
            if( idnp.isEmpty() ) break;
            isNumeric = idnp.chars().allMatch(Character::isDigit);
        }

        boolean notFound = true;
        for ( Employee employee : employeesList ) {
            if ( employee.getIdnp().equalsIgnoreCase( idnp ) ) {
                e = employee;
                notFound = false;
            }
        }
        if( notFound ){
            return null;
        }

        return e;
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
