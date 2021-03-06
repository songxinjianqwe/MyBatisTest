package me.newsong.domain.entity;

import java.io.Serializable;

public class EmployeeDO implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.last_name
     *
     * @mbggenerated
     */
    private String lastName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.dept
     *
     * @mbggenerated
     */
    private DepartmentDO dept;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated
     */
    public EmployeeDO(Integer id, String lastName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated
     */
    public EmployeeDO() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.id
     *
     * @return the value of emp.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.id
     *
     * @param id the value for emp.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.last_name
     *
     * @return the value of emp.last_name
     *
     * @mbggenerated
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.last_name
     *
     * @param lastName the value for emp.last_name
     *
     * @mbggenerated
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.gender
     *
     * @return the value of emp.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.gender
     *
     * @param gender the value for emp.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.email
     *
     * @return the value of emp.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.email
     *
     * @param email the value for emp.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.dept
     *
     * @return the value of emp.dept
     *
     * @mbggenerated
     */
    public DepartmentDO getDept() {
        return dept;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.dept
     *
     * @param dept the value for emp.dept
     *
     * @mbggenerated
     */
    public void setDept(DepartmentDO dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "EmployeeDO{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }
}