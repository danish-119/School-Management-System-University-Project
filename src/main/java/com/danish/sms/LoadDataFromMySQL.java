package com.danish.sms;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LoadDataFromMySQL {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/academicDBHandler";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static ObservableList<Student> loadStudentData() {
        ObservableList<Student> studentList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Student";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setStudentId(Integer.parseInt(String.valueOf(resultSet.getInt("studentId"))));
                    student.setStudentName(resultSet.getString("studentName"));
                    student.setDob(resultSet.getString("dateOfBirth"));
                    student.setGender(resultSet.getString("gender"));
                    student.setCnicOrBForm(resultSet.getString("cnicOrBForm"));
                    student.setBloodGroup(resultSet.getString("bloodGroup"));
                    student.setEmail(resultSet.getString("email"));
                    student.setExtracurricularInterest(resultSet.getString("extracurricularInterest"));
                    student.setGuardianName(resultSet.getString("guardianName"));
                    student.setGuardianRelation(resultSet.getString("guardianRelation"));
                    student.setGuardianCnic(resultSet.getString("guardianCnic"));
                    student.setGuardianOccupation(resultSet.getString("guardianOccupation"));
                    student.setGuardianContact(resultSet.getString("guardianContact"));
                    student.setJobType(resultSet.getString("jobType"));
                    student.setAdmissionNumber(resultSet.getString("admissionNumber"));
                    student.setClassGrade(resultSet.getString("classGrade"));
                    student.setSection(resultSet.getString("section"));
                    student.setUsername(resultSet.getString("username"));
                    student.setPassword(resultSet.getString("password"));
                    student.setAdmissionDate(String.valueOf(resultSet.getDate("admissionDate")));
                    student.setMonthlyFee(resultSet.getDouble("monthlyFee"));
                    student.setScholarshipStatus(resultSet.getString("scholarshipStatus"));
                    student.setDocumentRequired(resultSet.getString("documentRequired"));
                    student.setDocumentStatus(resultSet.getString("documentStatus"));
                    studentList.add(student);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public static ObservableList<Teacher> loadTeacherData() {
        ObservableList<Teacher> teacherList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Teacher";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setTeacherId(resultSet.getInt("teacherId"));
                    teacher.setTeacherName(resultSet.getString("teacherName"));
                    teacher.setDob(String.valueOf(resultSet.getDate("dateOfBirth")));
                    teacher.setGender(resultSet.getString("gender"));
                    teacher.setCnic(resultSet.getString("cnicNumber"));
                    teacher.setBloodGroup(resultSet.getString("bloodGroup"));
                    teacher.setEmail(resultSet.getString("email"));
                    teacher.setExperience(resultSet.getString("experience"));
                    teacher.setExperienceYears(String.valueOf(resultSet.getInt("experienceYears")));
                    teacher.setUniversityGraduatedFrom(resultSet.getString("universityGraduatedFrom"));
                    teacher.setQualification(resultSet.getString("qualification"));
                    teacher.setMajorSubject(resultSet.getString("majorSubject"));
                    teacher.setJobTitle(resultSet.getString("jobTitle"));
                    teacher.setJobType(resultSet.getString("jobType"));
                    teacher.setDepartment(resultSet.getString("department"));
                    teacher.setJoiningDate(String.valueOf(resultSet.getTimestamp("joiningDate")));
                    teacher.setMonthlySalary(resultSet.getDouble("monthlySalary"));
                    teacher.setBankForDirectDeposit(resultSet.getString("bankForDirectDeposit"));
                    teacher.setDocumentRequired(resultSet.getString("documentRequired"));
                    teacher.setDocumentStatus(resultSet.getString("documentStatus"));
                    teacher.setUsername(resultSet.getString("username"));
                    teacher.setPassword(resultSet.getString("password"));
                    teacherList.add(teacher);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherList;
    }

    public static ObservableList<Staff> loadStaffData() {
        ObservableList<Staff> staffList = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM Staff";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Staff staff = new Staff();
                    staff.setEmployerId(resultSet.getInt("employerId"));
                    staff.setFullName(resultSet.getString("fullName"));
                    staff.setDateOfBirth(String.valueOf(resultSet.getDate("dateOfBirth")));
                    staff.setGender(resultSet.getString("gender"));
                    staff.setCnicNumber(resultSet.getString("cnicNumber"));
                    staff.setContact(resultSet.getString("contact"));
                    staff.setQualification(resultSet.getString("qualification"));
                    staff.setJobTitle(resultSet.getString("jobTitle"));
                    staff.setJobType(resultSet.getString("jobType"));
                    staff.setMonthlySalary(resultSet.getDouble("monthlySalary"));
                    staff.setJoiningDate(String.valueOf(resultSet.getTimestamp("joiningDate")));
                    staff.setWorkSchedule(resultSet.getString("workSchedule"));
                    staffList.add(staff);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }
}
