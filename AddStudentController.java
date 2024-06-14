
package com.example.studentmanagementsystem;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddStudentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField student_number;

    @FXML
    private TextField student_name;

    @FXML
    private DatePicker student_birthDate;

    @FXML
    private ComboBox<String> student_year;

    @FXML
    private ComboBox<String> student_course;

    @FXML
    private ComboBox<String> student_section;

    @FXML
    private Button student_addBtn;

    @FXML
    private Button student_updateBtn;

    @FXML
    private ComboBox<String> student_semester;

    @FXML
    private ComboBox<String> student_gender;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private AlertMessage alert = new AlertMessage();

    public void addBtn() {
        if (student_number.getText().isEmpty()
                || student_name.getText().isEmpty()
                || student_year.getSelectionModel().getSelectedItem() == null
                || student_course.getSelectionModel().getSelectedItem() == null
                || student_section.getSelectionModel().getSelectedItem() == null
                || student_birthDate.getValue() == null
                || student_semester.getSelectionModel().getSelectedItem() == null
                || student_gender.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields.");
        } else {
            DatabaseConnection dbConnection = new DatabaseConnection();
            connect = dbConnection.getConnection();

            String checkStudentNum = "SELECT * FROM student WHERE student_id = '"
                    + student_number.getText() + "'";

            try {
                prepare = connect.prepareStatement(checkStudentNum);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert.errorMessage("Student Number: " + student_number.getText() + " is already taken");
                } else {
                    String insertData = "INSERT INTO student "
                            + "(student_id, full_name, gender, birth_date, year, course, section, semester, date_insert) "
                            + "VALUES(?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, student_number.getText());
                    prepare.setString(2, student_name.getText());
                    prepare.setString(3, student_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(4, String.valueOf(student_birthDate.getValue()));
                    prepare.setString(5, student_year.getSelectionModel().getSelectedItem());
                    prepare.setString(6, student_course.getSelectionModel().getSelectedItem());
                    prepare.setString(7, student_section.getSelectionModel().getSelectedItem());
                    prepare.setString(8, student_semester.getSelectionModel().getSelectedItem());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(9, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert.successMessage("Added Successfully!");

                    clearFields();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBtn() {
        if (student_number.getText().isEmpty()
                || student_name.getText().isEmpty()
                || student_year.getSelectionModel().getSelectedItem() == null
                || student_course.getSelectionModel().getSelectedItem() == null
                || student_section.getSelectionModel().getSelectedItem() == null
                || student_birthDate.getValue() == null
                || student_semester.getSelectionModel().getSelectedItem() == null
                || student_gender.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields.");
        } else {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            if (alert.confirmMessage("Are you sure you want to Update Student ID: "
                    + student_number.getText())) {
                String updateData = "UPDATE student SET "
                        + "full_name = '"
                        + student_name.getText() + "', birth_date = '"
                        + student_birthDate.getValue()
                        + "', year = '"
                        + student_year.getSelectionModel().getSelectedItem() + "', gender = '"
                        + student_gender.getSelectionModel().getSelectedItem() + "', course = '"
                        + student_course.getSelectionModel().getSelectedItem() + "', semester = '"
                        + student_semester.getSelectionModel().getSelectedItem() + "', date_update = '"
                        + String.valueOf(sqlDate)
                        + "' WHERE student_id = '" + student_number.getText() + "'";

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    alert.successMessage("Updated Successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
    }

    public void clearFields() {
        displayStudentNumber();

        student_name.clear();
        student_birthDate.setValue(null);
        student_year.getSelectionModel().clearSelection();
        student_course.getSelectionModel().clearSelection();
        student_gender.getSelectionModel().clearSelection();
        student_section.getSelectionModel().clearSelection();
        student_semester.getSelectionModel().clearSelection();
    }

    private int getAge = 0;

    public void countAge() {
        if (student_birthDate.getValue() != null) {
            LocalDate birthDate = student_birthDate.getValue();
            int age = Period.between(birthDate, LocalDate.now()).getYears();

            getAge = age;

            System.out.println(getAge);
        }
    }

    public void displayStudentNumber() {
        FXMLLoginController control = new FXMLLoginController();

        int getnumber = control.studentIDGenerator();

        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy");

        String getyear = format.format(date) + "0000";

        int getStudentNum = Integer.parseInt(getyear) + getnumber;

        student_number.setText(String.valueOf(getStudentNum));
    }

    public void yearList() {
        List<String> listY = new ArrayList<>();

        for (String data : ListData.year) {
            listY.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listY);
        student_year.setItems(listData);
    }
    public void courseList() {
        List<String> listC = new ArrayList<>();

        for (String data : ListData.course) {
            listC.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listC);
        student_course.setItems(listData);
    }


    public void setFields() {
        try {
            if (ListData.temp_studentNumber != null) {
                String sql = "SELECT * FROM student WHERE student_id = '"
                        + ListData.temp_studentNumber + "'";
                DatabaseConnection dbConnection = new DatabaseConnection();
                connect = dbConnection.getConnection();

                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if (result.next()) {
                    if (result.getString("full_name") != null) {
                        student_number.setText(ListData.temp_studentNumber);
                        student_name.setText(result.getString("full_name"));
                        student_birthDate.setValue(LocalDate.parse(result.getString("birth_date")));
                        student_year.getSelectionModel().select(result.getString("year"));
                        student_course.getSelectionModel().select(result.getString("course"));
                        student_section.getSelectionModel().select(result.getString("section"));
                        student_gender.getSelectionModel().select(result.getString("gender"));
                        student_semester.getSelectionModel().select(result.getString("semester"));
                    } else {
                        student_number.setText(ListData.temp_studentNumber);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sectionList() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.section) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        student_section.setItems(listData);
    }

    public void semesterList() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.semester) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        student_semester.setItems(listData);
    }

    public void genderList() {
        List<String> listG = new ArrayList<>();

        for (String data : ListData.gender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        student_gender.setItems(listData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yearList();
        courseList();
        sectionList();
        semesterList();
        genderList();

        displayStudentNumber();

        setFields();
    }
}
