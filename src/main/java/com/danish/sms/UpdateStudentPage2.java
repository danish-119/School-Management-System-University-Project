package com.danish.sms;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UpdateStudentPage2 {

    public void showUpdateStudentPage2(Stage studentManagementStage, Stage updateStudentStage1 ,String studentId, Student updatedStudent) {
        Stage updateStudentStage2 = new Stage();
        updateStudentStage2.setFullScreen(true);
        updateStudentStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Student student = GetDataByIdFromMySQL.getStudentById(studentId);

        Label heading1 = Utility.createTextLabel("Academic Information:", 30, 100, 50);
//        TextField admissionNumberField = Utility.createTextField("Admission Number", 100, 100);
        List<String> classGradeOptions = List.of("Class/Grade", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th");
        HBox classGradeField = Utility.createSelect(classGradeOptions, 230, 45, 430, 100);
        List<String> sectionOptions = List.of("Select Section", "Section A", "Section B", "Section C", "Section D");
        HBox sectionField = Utility.createSelect(sectionOptions, 230, 45, 100, 240);
//        TextField usernameField = Utility.createTextField("Username? AutoGenerated", 100, 170);
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 170);
        passwordField.setPrefWidth(230);


        Label heading2 = Utility.createTextLabel("Other Information:", 30, 100, 310);
        TextField monthlyFeeField = Utility.createTextField("Monthly Fee", 100, 350);
        List<String> scholarshipStatusOptions = List.of("Scholarship Status","Not Applied", "Pending", "Approved", "Rejected");
        HBox scholarshipStatusField = Utility.createSelect(scholarshipStatusOptions, 230, 45, 430, 350);
        TextField documentField = Utility.createTextField("Document Required", 100, 410);
        documentField.setText("1. B-Form (Issued by NADRA) 2. Previous Class Certificate 3. Application Form 4. Passport-sized Photographs");
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 45, 430, 410);

        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            updateStudentStage1.show();
            updateStudentStage2.close();
        });

        Button updateBtn = Utility.createButton("Update", 120, 50, 360, 730);
        updateBtn.setOnAction(event -> {
            System.out.println("Update Button Clicked!");

            updateStudentStage2.close();
            studentManagementStage.show();
        });

        rightPane.getChildren().addAll(heading1,classGradeField,sectionField,passwordField, heading2,monthlyFeeField,scholarshipStatusField,documentStatusField, documentField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Update Student Info", 30, 100, 530), backBtn,updateBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        updateStudentStage2.setScene(scene);
        updateStudentStage2.show();
    }
}