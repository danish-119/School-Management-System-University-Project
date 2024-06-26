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

public class AddTeacherPage2 {

    public void showAddTeacherPage(Stage teacherManagementMenu, Stage addTeacherStage1, Teacher teacher) {
        Stage addTeacherStage2 = new Stage();
        addTeacherStage2.setFullScreen(true);
        addTeacherStage2.setFullScreenExitHint("");

        VBox mainLayout = Utility.createMainLayout();
        HBox contentLayout = Utility.createContentLayout();
        Pane leftPane = Utility.createLeftPane();
        Pane rightPane = Utility.createRightPane();

        Label heading1 = Utility.createTextLabel("Employment Information:", 30, "bold" ,100, 50);
        List<String> jobTitleOptions = List.of("Job Title", "Professor", "Assistant Professor", "Associate Professor", "Lab Attendant","Lecturer", "Researcher", "Adjunct Professor" );
        HBox jobTitleField = Utility.createSelect(jobTitleOptions, 300, 50, 100, 100);
        List<String> jobTypeOptions = List.of("Job Type", "Full-Time", "Part-Time", "Contract", "Internship");
        HBox jobTypeField = Utility.createSelect(jobTypeOptions, 230, 50, 430, 100);
        TextField usernameField = Utility.createTextField("Username", 100, 170);
        usernameField.setText(teacher.getUsername());
        PasswordField passwordField = Utility.createPasswordField("Password", 430, 170);
        passwordField.setPrefWidth(230);
        passwordField.setText(Utility.generateRandomPassword());
        List<String> departmentOptions = List.of("Department", "Computer Science", "Biology", "Physics", "Mathematics", "Chemistry", "English", "History", "Psychology", "Economics", "Engineering");
        HBox departmentField = Utility.createSelect(departmentOptions, 300, 50, 100, 240);


        Label heading2 = Utility.createTextLabel("Other Information:", 30, "bold" ,100, 310);
        TextField monthlySalaryField = Utility.createTextField("Monthly Salary", 100, 360);
        List<String> bankOptions = List.of("Select Bank for Direct Deposit ", "Allied Bank Limited", "Askari Bank Limited", "Bank Alfalah Limited", "Bank Al-Habib Limited", "Faysal Bank Limited", "Habib Bank Limited (HBL)", "MCB Bank Limited", "Meezan Bank Limited", "National Bank of Pakistan (NBP)", "United Bank Limited (UBL)");
        HBox bankField = Utility.createSelect(bankOptions,230,50,430,360);
        TextField documentField = Utility.createTextField("Document Required", 100, 430);
        List<String> documentStatusOptions = List.of("Document Status", "Pending", "Approved", "Under Review", "Processing","Archived", "On Hold");
        HBox documentStatusField = Utility.createSelect(documentStatusOptions, 230, 50, 430, 430);

        Label errorLabel = Utility.createTextLabel("", 18,"normal",200,500);



        Button backBtn = Utility.createBackButton();
        backBtn.setOnAction(event -> {
            System.out.println("Back Button Clicked!");
            addTeacherStage2.close();
            addTeacherStage1.show();
        });

        Button saveBtn = Utility.createSaveButton();
        saveBtn.setOnAction(event -> {
            System.out.println("Save Button Clicked!");
            // Collect data entered on this page
            String jobTitle = (String) UIControlUtils.HBoxToComboBox(jobTitleField).getValue();
            String jobType = (String) UIControlUtils.HBoxToComboBox(jobTypeField).getValue();
            String department = (String) UIControlUtils.HBoxToComboBox(departmentField).getValue();
            String password = passwordField.getText();
            double monthlySalary = Double.parseDouble(monthlySalaryField.getText());
            String bank = (String) UIControlUtils.HBoxToComboBox(bankField).getValue();
            String documentStatus = (String) UIControlUtils.HBoxToComboBox(documentStatusField).getValue();
            String documents = documentField.getText();

            teacher.setTeacherDetails2(jobTitle, jobType, department, password, monthlySalary, bank, documentStatus, documents);

            boolean isSave = SaveDataToMySQL.saveTeacherInfo(teacher);

            if(isSave)
            {
                addTeacherStage2.close();
                teacherManagementMenu.show();
            }
            else{
                errorLabel.setText("Please fill all the fields");
            }
        });


        rightPane.getChildren().addAll(heading1,jobTitleField, jobTypeField,departmentField, usernameField,passwordField,heading2,monthlySalaryField, bankField,documentField, documentStatusField, errorLabel);
        leftPane.getChildren().addAll(Utility.createTextLabel("Add New Teacher", 30, "bold" ,120, 530), backBtn,saveBtn, Utility.displayImage("/media/danish/8E20E81220E7FF59/Programming/Code/Java Code/IntelliJ IDEA/Projects/School Management System/src/main/resources/addStaff.png", 120,220));
        contentLayout.getChildren().addAll(leftPane, rightPane);
        mainLayout.getChildren().add(contentLayout);

        Scene scene = new Scene(mainLayout, 1200, 800);
        addTeacherStage2.setScene(scene);
        addTeacherStage2.show();
    }
}
