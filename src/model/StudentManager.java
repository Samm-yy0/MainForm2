/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import utils.FileDBHelper;

public class StudentManager {

    private HashMap<String, Student> students;
    private final String FILE_PATH = "students.ser";

    public StudentManager() {
        students = new HashMap();
        FileDBHelper.createFile(FILE_PATH);
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public Student findStudent(String id) {
        return students.get(id);
    }

    public int saveStudents() {
        int errorCode = 0; // 0-success; -1-error

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(
                    FileDBHelper.DIRECTORY + this.FILE_PATH);

            try (ObjectOutputStream oos =
                    new ObjectOutputStream(fos)) {

                oos.writeObject(students);
            }

            fos.close();

        } catch (IOException e) {
            errorCode = -1;
            System.out.println("Error: " + e);
        }

        return errorCode;
    }

    public Student deleteStudent(String id) {
        Student student = students.remove(id);
        return student;
    }

    @SuppressWarnings("unchecked")
    public void loadStudents() {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(
                    FileDBHelper.DIRECTORY + FILE_PATH);

            try (ObjectInputStream ois =
                    new ObjectInputStream(fis)) {

                Object readObj = ois.readObject();

                this.students =
                        (HashMap<String, Student>) readObj;
            }

            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Read: " + e);
        }
    }

    public HashMap<String, Student> findAll() {
        return this.students;
    }
}
