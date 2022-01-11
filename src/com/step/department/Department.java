package com.step.department;

public class Department {
    private EDepartment dep;
    private String position;

    public Department(EDepartment dep, String position) {
        this.dep = dep;
        this.position = position;
    }

    @Override
    public String toString() {
        return
            dep +
            "\n\tPosition     = " + position;
    }

    public EDepartment getDepartments() {
        return dep;
    }

    public void setDepartments(EDepartment dep) {
        this.dep = dep;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
