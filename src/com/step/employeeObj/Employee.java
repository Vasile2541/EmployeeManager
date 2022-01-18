package com.step.employeeObj;

import com.step.currentDate.Date;
import com.step.department.Department;
import com.step.enums.EGender;

import java.util.List;

public class Employee {
    private String fName;
    private String lName;
    private String idnp;
    private EGender gender;
    private Department department;//
    private final List<String> dateOfHire;//
    private String email;
    private String phoneNumber;
//    private Address address;//

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }
    public EGender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

/////  / / // / / //// ///  //// // // //

    @Override
    public String toString() {
        return
              "\tFirst Name   = " + fName +
            "\n\tLast  Name   = " + lName +
            "\n\tGender       = " + gender +
            "\n\tIDNP         = " + idnp +
            "\n\temail        = " + email +
            "\n\tPhone Number = " + phoneNumber +
            "\n\tDepartment   = " + department  +
            "\n\tDate Of Hire = " + dateOfHire;
    }

    ///////  // // //// // /// //  / / / // / // / //// / /
//SET DATE
    public Employee() {
        this.dateOfHire  = setDateOfHire() ;
    }
    private List<String> setDateOfHire() {
        Date date = new Date();
        return date.currentDate() ;
    }
    public List<String> getDateOfHire() {
        return dateOfHire;
    }

}
