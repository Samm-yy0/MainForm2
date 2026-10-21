
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

public class GradeLevelManager {

    private HashMap<Integer, GradeLevel> gradeLevels;
    private final String FILE_PATH = "gradelevels.ser";

    public GradeLevelManager() {
        gradeLevels = new HashMap<>();
        FileDBHelper.createFile(FILE_PATH);
    }

    public void addGradeLevel(GradeLevel gradeLevel) {
        gradeLevels.put(gradeLevel.getId(), gradeLevel);
    }

    public GradeLevel findGradeLevel(int id) {
        return gradeLevels.get(id);
    }

    public int saveGradeLevels() {
        int errorCode = 0;

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(
                    FileDBHelper.DIRECTORY + FILE_PATH);

            try (ObjectOutputStream oos =
                    new ObjectOutputStream(fos)) {

                oos.writeObject(gradeLevels);
            }

            fos.close();

        } catch (IOException e) {
            errorCode = 1;
            System.out.println("Error: " + e);
        }

        return errorCode;
    }

    @SuppressWarnings("unchecked")
    public void loadGradeLevels() {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(
                    FileDBHelper.DIRECTORY + FILE_PATH);

            try (ObjectInputStream ois =
                    new ObjectInputStream(fis)) {

                Object readObj = ois.readObject();

                this.gradeLevels =
                        (HashMap<Integer, GradeLevel>) readObj;
            }

            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Read: " + e);
        }
    }

    public HashMap<Integer, GradeLevel> findAll() {
        return gradeLevels;
    }
}