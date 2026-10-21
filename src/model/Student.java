package model;

import java.io.Serializable;

public class Student implements Serializable {

    private String studentId;
    private String fullName;
    private String gradeLevel;

    public Student(String studentId, String fullName, String gradeLevel) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.gradeLevel = gradeLevel;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toString() {
        return studentId + " - " + fullName + " (" + gradeLevel + ")";
    }
}