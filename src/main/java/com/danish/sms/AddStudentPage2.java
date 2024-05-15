package com.danish.sms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AddStudentPage2 {

    public void showAddStudentPage(Stage addStudentStage1, Student student) {
        Stage addStudentStage2 = new Stage();
        addStudentStage2.setFullScreen(true);
        addStudentStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Academic Information:", 30, 100, 50);
        TextField admissionNumberField = Utility.createTextField("Admission Number", 100, 100);
        List<String> classGradeOptions = List.of("Class/Grade", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th");
        HBox classGradeField = Utility.createSelect(classGradeOptions, 230, 45, 430, 100);
        TextField rollNumberField = Utility.createTextField("Roll Number", 100, 170);
        List<String> sectionOptions = List.of("Select Section", "Section A", "Section B", "Section C", "Section D");
        HBox sectionField = Utility.createSelect(sectionOptions, 230, 45, 430, 170);
        TextField usernameField = Utility.createTextField("Username", 100, 240);
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 240);
        passwordField.setPrefWidth(230);
        HBox admissionDateField = Utility.createDateField("Date of Admission", 100, 310);

        Label heading2 = Utility.createTextLabel("Other Information:", 30, 100, 380);
        TextField monthlyFeeField = Utility.createTextField("Monthly Fee", 100, 430);
        List<String> scholarshipStatusOptions = List.of("Scholarship Status","Not Applied", "Pending", "Approved", "Rejected");
        HBox scholarshipStatusField = Utility.createSelect(scholarshipStatusOptions, 230, 45, 430, 430);
        TextField documentField = Utility.createTextField("Document Required", 100, 500);
        documentField.setText("1. B-Form (Issued by NADRA) 2. Previous Class Certificate 3. Application Form 4. Passport-sized Photographs");
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 45, 430, 500);



        Button backBtn = Utility.createButton("Back", 100, 50, 20, 730);
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addStudentStage2.close();
            addStudentStage1.show();
        });

        final String FILE_PATH = "student_info.bin";
        Button saveBtn = Utility.createButton("Save", 100, 50, 360, 730);
        saveBtn.setOnAction(event -> {
            System.out.println("Save Button Clicked!");

            // Collect data entered on this page
            String admissionNumber = admissionNumberField.getText();
            String classGrade = UIControlUtils.extractValueFromComboBox(classGradeField);
            String rollNumber = rollNumberField.getText();
            String section = UIControlUtils.extractValueFromComboBox(sectionField);
            String username = usernameField.getText();
            String password = passwordField.getText();
            String admissionDate = UIControlUtils.extractValueFromDatePicker(admissionDateField);
            String monthlyFee = monthlyFeeField.getText();
            String scholarshipStatus = UIControlUtils.extractValueFromComboBox(scholarshipStatusField);
            String documentStatus = UIControlUtils.extractValueFromComboBox(documentStatusField);
            String documents = documentField.getText();

            student.setStudentDetails2(admissionNumber, classGrade, rollNumber, section, username, password, admissionDate, monthlyFee, scholarshipStatus, documentStatus, documents);

            StudentFileHandler.writeStudentToFile(student);
            StudentFileHandler.readStudentFromFile();

            addStudentStage2.close();
        });

        rightPane.getChildren().addAll(heading1,admissionNumberField,classGradeField,rollNumberField,sectionField,admissionDateField,usernameField,passwordField, heading2,monthlyFeeField,scholarshipStatusField,documentStatusField, documentField);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Student", 30, 140, 530), backBtn,saveBtn);
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addStudentStage2.setScene(scene);
        addStudentStage2.show();
    }
}
