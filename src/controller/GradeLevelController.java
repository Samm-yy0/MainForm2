/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.GradeLevel;
import model.GradeLevelManager;
import ui.GradeLevelUI;

public class GradeLevelController {

    private final GradeLevelManager model;
    private GradeLevelUI view;

    public GradeLevelController(GradeLevelManager model) {
        this.model = model;
    }

    public void setView(GradeLevelUI view) {
        this.view = view;
    }

    public boolean handleAddGradeLevel(int id, String name) {

        if (name.trim().isEmpty()) {
            return false;
        }

        GradeLevel gradeLevel = new GradeLevel(id, name);

        this.model.addGradeLevel(gradeLevel);

        int res = this.model.saveGradeLevels();

        if (res == -1) {
            return false;
        }

        if (this.view != null) {
            this.view.refreshGradeLevels();
        }

        return true;
    }

    public boolean handleUpdateGradeLevel(int id, String desc) {

        if (desc.trim().isEmpty()) {
            return false;
        }

        GradeLevel gradeLevel = this.model.findGradeLevel(id);

        if (gradeLevel == null) {
            return false;
        }

        gradeLevel.setDesc(desc);

        this.model.saveGradeLevels();

        if (this.view != null) {
            this.view.refreshGradeLevels();
        }

        return true;
    }

    public List<GradeLevel> getAllGradeLevels() {

        Collection<GradeLevel> gradeLevelsFromHash =
                this.model.findAll().values();

        ArrayList<GradeLevel> gradeLevelList =
                new ArrayList<>(gradeLevelsFromHash);

        return gradeLevelList;
    }

    public GradeLevel getGradeLevelDetails(int id) {
        return model.findGradeLevel(id);
    }

    public boolean handleAddStudent(String studentID, String fullName, String gradeLevel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}