
package com.example.studentmanagementsystem;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class AdminMainFormController implements Initializable {

    @FXML
    private Label greet_username;

    @FXML
    private AnchorPane search_form;

    @FXML
    private Button search_form_btn;

    @FXML
    private Button addStudent_btn;

    @FXML
    private Button addTeacher_btn;

    @FXML
    private Button addCourse_btn;

    @FXML
    private Button addSubject_btn;


    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private AnchorPane addTeacher_form;

    @FXML
    private TableView<StudentData> addStudent_tableView;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_studentNumber;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_name;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_year;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_course;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_section;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_pay;


    @FXML
    private TableColumn<StudentData, String> addStudent_col_dateInsert;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_status;

    @FXML
    private Button addStudent_deleteBtn;

    @FXML
    private Button addStudent_updateBtn;

    @FXML
    private Button addStudent_addBtn;

    @FXML
    private TableView<TeacherData> addTeacher_tableView;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_teacherID;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_name;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_gender;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_yearExperience;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_experience;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_department;


    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_dateInsert;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_status;

    @FXML
    private TextField addTeacher_teacherID;

    @FXML
    private TextField addTeacher_fullName;

    @FXML
    private ComboBox<String> addTeacher_gender;

    @FXML
    private ComboBox<String> addTeacher_experienceYear;

    @FXML
    private TextField addTeacher_experience;

    @FXML
    private ComboBox<String> addTeacher_department;


    @FXML
    private ComboBox<String> addTeacher_status;

    @FXML
    private ImageView addTeacher_imageView;

    @FXML
    private Button addTeacher_importBtn;

    @FXML
    private Button addTeacher_addBtn;

    @FXML
    private Button addTeacher_updateBtn;

    @FXML
    private Button addTeacher_clearBtn;

    @FXML
    private Button addTeacher_deleteBtn;

    @FXML
    private TextField addCourse_course;

    @FXML
    private TextField addCourse_department;

    @FXML
    private TextField addCourse_price;

    @FXML
    private TextField update_course_id;

    @FXML
    private ComboBox<String> addCourse_status;

    @FXML
    private TableColumn<CourseData, String> addCourse_col_id;
    @FXML
    private Button addCourse_addBtn;

    @FXML
    private Button addCourse_updateBtn;

    @FXML
    private Button addCourse_clearBtn;

    @FXML
    private TextField search_teacher_id;

    @FXML
    private TableView<TeacherCourseData> teacher_subject_search_tableview;

    @FXML
    private TableColumn<TeacherCourseData, String> teacher_id_subject_col;

    @FXML
    private TableColumn<TeacherCourseData, String> subject_code_teacher_col;

    @FXML
    private Button addCourse_deleteBtn;

    @FXML
    private TableView<CourseData> addCourse_tableView;

    @FXML
    private TableColumn<CourseData, String> addCourse_col_course;

    @FXML
    private TableColumn<CourseData, String> addCourse_col_department;

    @FXML
    private TableColumn<CourseData, String> addCourse_col_dateInsert;

    @FXML
    private TableColumn<CourseData, String> addCourse_col_status;

    @FXML
    private AnchorPane addCourse_form;

    @FXML
    private AnchorPane addSubject_form;

    @FXML
    private TextField addSubject_code;

    @FXML
    private TextField addSubject_subject;
    // cai nay la cai gi v? o dau trong giao dien v???
    @FXML
    private TextField addSubject_course;

    @FXML
    private ComboBox<String> addSubject_status;

    @FXML
    private Button addSubject_addBtn;

    @FXML
    private Button addSubject_updateBtn;

    @FXML
    private Button addSubject_clearBtn;

    @FXML
    private Button addSubject_deleteBtn;

    @FXML
    private TableView<SubjectData> addSubject_tableView;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_code;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_subject;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_course;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_dateInsert;


    @FXML
    private Button payment_payBtn;

    @FXML
    private TextField teacher_id_subject;

    @FXML
    private Button payment_clearBtn;

    @FXML
    private TableView<StudentData> payment_tableView;

    @FXML
    private TableColumn<String, StudentData> payment_col_studentID;

    @FXML
    private TableColumn<String, StudentData> payment_col_name;

    @FXML
    private TableColumn<String, StudentData> payment_col_year;

    @FXML
    private TableColumn<String, StudentData> payment_col_section;

    @FXML
    private TableColumn<String, StudentData> payment_col_semester;

    @FXML
    private TableColumn<String, StudentData> payment_col_payment;

    @FXML
    private TableColumn<String, StudentData> payment_col_statusPayment;

    @FXML
    private AnchorPane salary_form;

    @FXML
    private DatePicker salary_fromDate;

    @FXML
    private DatePicker salary_toDate;

    @FXML
    private TextField salary_teacherID;

    @FXML
    private TextField salary_name;

    @FXML
    private TextField salary_salaryPerDay;

    @FXML
    private ComboBox<String> salary_status;

    @FXML
    private Label salary_totalDays;

    @FXML
    private Label salary_salary;

    @FXML
    private Button salary_payBtn;

    @FXML
    private Button salary_clearBtn;

    @FXML
    private TableView<TeacherData> salary_tableView;

    @FXML
    private TableColumn<TeacherData, String> salary_col_teacherID;

    @FXML
    private TableColumn<TeacherData, String> salary_col_fullName;

    @FXML
    private TableColumn<TeacherData, String> salary_col_salaryPerDay;

    @FXML
    private TableColumn<TeacherData, String> salary_col_gender;

    @FXML
    private TableColumn<TeacherData, String> salary_col_dateInsert;

    @FXML
    private TableColumn<TeacherData, String> salary_col_dateUpdate;

    @FXML
    private TableColumn<TeacherData, String> salary_col_status;


    @FXML
    private Label dashboard_TS;

    @FXML
    private Label dashboard_TT;

    @FXML
    private Label dashboard_SRT;

    @FXML
    private Label dashboard_TI;

    @FXML
    private Button searchBtn;

    @FXML
    private AreaChart<?, ?> dashboard_chart_DS;

    @FXML
    private BarChart<?, ?> dashboard_chart_DT;

    @FXML
    private LineChart<?, ?> dashboard_chart_DI;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    private Image image;

    public ObservableList<TeacherCourseData> getTeacherCourseData(String teacherID) {
        ObservableList<TeacherCourseData> listData = FXCollections.observableArrayList();
        String query = "SELECT * FROM teacher_subject WHERE teacher_id = ?";

        DatabaseConnection dbConnection = new DatabaseConnection();
        connect = dbConnection.getConnection();

        TeacherCourseData sData;

        try {
            prepare = connect.prepareStatement(query);
            prepare.setString(1, teacherID);
            result = prepare.executeQuery();

            while (result.next()) {
                // StudentData(Integer id, String studentID, String fullName, String year, String course, String section, Date dateInsert)
                sData = new TeacherCourseData(result.getString("teacher_id"), result.getString("subject_id"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void displayTeacherCourseData() {
        ObservableList<TeacherCourseData> addTeacherCourseData = getTeacherCourseData(search_teacher_id.getText());
        teacher_id_subject_col.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        subject_code_teacher_col.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        teacher_subject_search_tableview.setItems(addTeacherCourseData);
    }

    public void search_teacher_btn() {
        displayTeacherCourseData();
    }

    public ObservableList<StudentData> addStudentGetData() {
        ObservableList<StudentData> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM student WHERE date_delete IS NULL";

        DatabaseConnection dbConnection = new DatabaseConnection();
        connect = dbConnection.getConnection();

        StudentData sData;

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                // StudentData(Integer id, String studentID, String fullName, String year, String course, String section, Date dateInsert)
                sData = new StudentData(result.getInt("id"), result.getString("student_id"),
                        result.getString("full_name"), result.getString("year"),
                        result.getString("course"), result.getString("section"),
                        result.getDate("date_insert"));
                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<StudentData> addStudentListData;

    public void addStudentDisplayData() {
        addStudentListData = addStudentGetData();

        addStudent_col_studentNumber.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        addStudent_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        addStudent_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudent_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudent_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        addStudent_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));

        addStudent_tableView.setItems(addStudentListData);
    }

    public void addStudentAddBtn() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Student");
            stage.initModality(Modality.APPLICATION_MODAL); // Set the modality
            stage.showAndWait(); // Wait for the modal to close
            addStudentDisplayData(); // Refresh the table view

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentUpdateBtn() {

        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getSelectedIndex();
        if (num < 0) {
            alert.errorMessage("Please select the item first");
            return;
        } else {
            ListData.temp_studentNumber = sData.getStudentID();
            ListData.temp_studentName = sData.getFullName();
            ListData.temp_studentBirthDate = sData.getBirthDate();
            ListData.temp_studentYear = sData.getYear();
            ListData.temp_studentCourse = sData.getCourse();
            ListData.temp_studentGender = sData.getGender();
            ListData.temp_studentSection = sData.getSection();

            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
                Stage stage = new Stage();

                stage.setTitle("Update Student");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addStudentDeleteBtn() {
        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getSelectedIndex();

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        if (num < 0) {
            alert.errorMessage("Please select an item first");
            return;
        }

        if (alert.confirmMessage("Are you sure you want to delete Student ID: " + sData.getStudentID() + "?")) {
            String deleteData = "UPDATE student SET date_delete = ? WHERE student_id = ?";
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connect = dbConnection.getConnection();

            try (PreparedStatement prepare = connect.prepareStatement(deleteData)) {
                prepare.setString(1, String.valueOf(sqlDate));
                prepare.setString(2, sData.getStudentID());
                prepare.executeUpdate();
                alert.successMessage("Deleted successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                alert.errorMessage("An error occurred while deleting the student.");
            }
        } else {
            alert.errorMessage("Cancelled.");
        }

        addStudentDisplayData();
    }


    public ObservableList<TeacherData> addTeacherGetData() {

        ObservableList<TeacherData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM teacher WHERE date_delete IS NULL";

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connect = dbConnection.getConnection();

        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            TeacherData tData;

            while (result.next()) {
                // TeacherData(Integer id, String teacherID, String fullName, String gender,
                // String yearExperience, String experience, String department, Date dateInsert,
                // Date dateUpdate, Date dateDelete)
                tData = new TeacherData(result.getInt("id"),
                        result.getString("teacher_id"),
                        result.getString("full_name"), result.getString("gender"),
                        result.getString("year_experience"), result.getString("experience"),
                        result.getString("department"), result.getDate("date_insert"),
                        result.getDate("date_update"), result.getDate("date_delete"));

                listData.add(tData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<TeacherData> addTeacherListData;

    public void addTeacherDisplayData() {
        addTeacherListData = addTeacherGetData();

        addTeacher_col_teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        addTeacher_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        addTeacher_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addTeacher_col_yearExperience.setCellValueFactory(new PropertyValueFactory<>("yearExperience"));
        addTeacher_col_experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        addTeacher_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addTeacher_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));

        addTeacher_tableView.setItems(addTeacherListData);
    }

    public void addTeacherSelectItems() {

        TeacherData tData = addTeacher_tableView.getSelectionModel().getSelectedItem();
        int num = addTeacher_tableView.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }

        addTeacher_teacherID.setText(tData.getTeacherID());
        addTeacher_fullName.setText(tData.getFullName());
        addTeacher_gender.getSelectionModel().select(tData.getGender());
        addTeacher_experienceYear.getSelectionModel().select(tData.getYearExperience());
        addTeacher_experience.setText(tData.getExperience());
        addTeacher_department.getSelectionModel().select(tData.getDepartment());
    }

    public void addTeacherGenderList() {

        List<String> listG = new ArrayList<>();

        for (String data : ListData.gender) {
            listG.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listG);
        addTeacher_gender.setItems(listData);
    }

    public void addTeacherEYList() {

        List<String> listEY = new ArrayList<>();

        for (String data : ListData.yearExperience) {
            listEY.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listEY);
        addTeacher_experienceYear.setItems(listData);
    }


    public void addTeacherDepartmentList() {
        List<String> listD = new ArrayList<>();

        for (String data : ListData.department) {
            listD.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listD);
        addTeacher_department.setItems(listData);
    }

    private String teacherID;

    public void generateTeacherID() {
        String sql = "SELECT MAX(id) FROM teacher";

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connect = dbConnection.getConnection();
        String temp_teacherID = "TID-";
        int temp_count = 0;

        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                temp_count = result.getInt("MAX(id)");
            }

            if (temp_count == 0) {
                temp_count += 1;
                teacherID = temp_teacherID + temp_count;
            } else {
                teacherID = temp_teacherID + (temp_count + 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTeacherDisplayTeacherID() {
        generateTeacherID();
        addTeacher_teacherID.setText(teacherID);
    }

    public void addTeacherAddBtn() {
        if (addTeacher_teacherID.getText().isEmpty()
                || addTeacher_fullName.getText().isEmpty()
                || addTeacher_gender.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_experience.getText().isEmpty()
                || addTeacher_experienceYear.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_department.getSelectionModel().getSelectedItem().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            String insertData = "INSERT INTO teacher "
                    + "(teacher_id, full_name, gender, year_experience, experience"
                    + ", department, date_insert) "
                    + "VALUES(?,?,?,?,?,?,?)";

            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connect = dbConnection.getConnection();

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            try {
                PreparedStatement prepare = connect.prepareStatement(insertData);
                prepare.setString(1, addTeacher_teacherID.getText());
                prepare.setString(2, addTeacher_fullName.getText());
                prepare.setString(3, addTeacher_gender.getSelectionModel().getSelectedItem());
                prepare.setString(4, addTeacher_experienceYear.getSelectionModel().getSelectedItem());
                prepare.setString(5, addTeacher_experience.getText());
                prepare.setString(6, addTeacher_department.getSelectionModel().getSelectedItem());
                prepare.setString(7, String.valueOf(sqlDate));

                prepare.executeUpdate();

                addTeacherDisplayData();

                alert.successMessage("Added Successfully!");

                addTeacherClearBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addTeacherUpdateBtn() {
        if (addTeacher_teacherID.getText().isEmpty()
                || addTeacher_fullName.getText().isEmpty()
                || addTeacher_gender.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_experience.getText().isEmpty()
                || addTeacher_experienceYear.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_department.getSelectionModel().getSelectedItem().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmMessage("Are you sure you want to Update Teacher ID: "
                    + addTeacher_teacherID.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE teacher SET full_name = '"
                        + addTeacher_fullName.getText() + "', gender = '"
                        + addTeacher_gender.getSelectionModel().getSelectedItem() + "', experience = '"
                        + addTeacher_experience.getText() + "', year_experience = '"
                        + addTeacher_experienceYear.getSelectionModel().getSelectedItem() + "', department = '"
                        + addTeacher_department.getSelectionModel().getSelectedItem() + "', date_update = '"
                        + sqlDate + "' "
                        + "WHERE teacher_id = '"
                        + addTeacher_teacherID.getText() + "'";

                DatabaseConnection dbConnection = new DatabaseConnection();
                Connection connect = dbConnection.getConnection();

                try {
                    PreparedStatement prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    addTeacherDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addTeacherClearBtn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled.");
            }
        }
    }

    public void addTeacherDeleteBtn() {
        if (addTeacher_teacherID.getText().isEmpty()) {
            alert.errorMessage("Please select the item first");
        } else {
            if (alert.confirmMessage("Are you sure you want to Delete Teacher ID: "
                    + addTeacher_teacherID.getText() + "?")) {
                String deleteData = "UPDATE teacher SET date_delete = ? WHERE teacher_id = ?";
                DatabaseConnection dbConnection = new DatabaseConnection();
                Connection connect = dbConnection.getConnection();

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                try {
                    PreparedStatement prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, "" + sqlDate);
                    prepare.setString(2, addTeacher_teacherID.getText());

                    prepare.executeUpdate();

                    addTeacherDisplayData();

                    alert.successMessage("Deleted Successfully!");

                    addTeacherClearBtn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
    }

    public void addTeacherClearBtn() {
        addTeacherDisplayTeacherID();
        addTeacher_fullName.clear();
        addTeacher_gender.getSelectionModel().clearSelection();
        addTeacher_experienceYear.getSelectionModel().clearSelection();
        addTeacher_experience.clear();
        addTeacher_department.getSelectionModel().clearSelection();
    }

    private ObservableList<CourseData> addCourseListData;

    public ObservableList<CourseData> addCourseGetData() {
        ObservableList<CourseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course WHERE date_delete IS NULL";
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connect = dbConnection.getConnection();

        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            CourseData cData;

            while (result.next()) {
                cData = new CourseData(result.getInt("id"), result.getString("course"),
                        result.getString("department"),
                        result.getDate("date_insert"),
                        result.getDate("date_update"), result.getDate("date_delete"));

                listData.add(cData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void addCourseDisplayData() {
        addCourseListData = addCourseGetData();

        addCourse_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        addCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addCourse_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addCourse_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));

        addCourse_tableView.setItems(addCourseListData);
    }

    private int courseID = 0;

    public void addCourseSelectItem() {
        CourseData cData = addCourse_tableView.getSelectionModel().getSelectedItem();
        int num = addCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addCourse_course.setText(cData.getCourse());
        addCourse_department.setText(cData.getDepartment());

        courseID = cData.getId();
    }

    public void addCourseAddBtn() {
        if (addCourse_course.getText().isEmpty() || addCourse_department.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connect = dbConnection.getConnection();

            String checkCourse = "SELECT * FROM course WHERE course = '"
                    + addCourse_course.getText() + "' AND date_delete IS NULL";
            try {
                PreparedStatement statement = connect.prepareStatement(checkCourse);
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    alert.errorMessage(addCourse_course.getText() + " already exists");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    String insertData = "INSERT INTO course (course, department, date_insert) "
                            + "VALUES(?,?,?)";

                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addCourse_course.getText());
                    prepare.setString(2, addCourse_department.getText());
                    prepare.setDate(3, sqlDate);

                    prepare.executeUpdate();

                    addCourseDisplayData();

                    alert.successMessage("Added Successfully!");

                    addCourseClear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addCourseUpdateBtn() {
        if (addCourse_course.getText().isEmpty() || addCourse_department.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmMessage("Are you sure you want to update the course " + addCourse_course.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE course SET course = ?, department = ?, date_update = ? WHERE id = ?";

                DatabaseConnection dbConnection = new DatabaseConnection();
                Connection connect = dbConnection.getConnection();

                try {
                    PreparedStatement prepare = connect.prepareStatement(updateData);
                    // Assuming update_course_id is a TextField in the UI where the user enters the course ID to be updated
                    prepare.setString(1, addCourse_course.getText());
                    prepare.setString(2, addCourse_department.getText());
                    prepare.setDate(3, sqlDate);
                    prepare.setInt(4, Integer.parseInt(update_course_id.getText()));

                    prepare.executeUpdate();

                    addCourseDisplayData(); // Assuming this method refreshes your data view

                    alert.successMessage("Updated Successfully!");

                    addCourseClear();

                } catch (Exception e) {
                    e.printStackTrace();
                    alert.errorMessage("Error updating course");
                }
            } else {
                alert.errorMessage("Update cancelled");
            }
        }
    }
    public void addCourseDeleteBtn() {
        if (alert.confirmMessage("Are you sure you want to delete the course " + addCourse_course.getText() + "?")) {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String deleteData = "UPDATE course SET date_delete = ? WHERE id = ?";

            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connect = dbConnection.getConnection();

            try {
                PreparedStatement prepare = connect.prepareStatement(deleteData);
                prepare.setDate(1, sqlDate);
                prepare.setInt(2, Integer.parseInt(update_course_id.getText()));

                prepare.executeUpdate();

                addCourseDisplayData(); // Assuming this method refreshes your data view

                alert.successMessage("Deleted Successfully!");

                addCourseClear();
            } catch (Exception e) {
                e.printStackTrace();
                alert.errorMessage("Error deleting course");
            }
        } else {
            alert.errorMessage("Delete cancelled");
        }
    }


    public void addCourseClear() {
        addCourse_course.clear();
        addCourse_department.clear();
    }


    private ObservableList<SubjectData> addSubjectListData;

    public ObservableList<SubjectData> addSubjectGetData() {
        ObservableList<SubjectData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM subject WHERE date_delete IS NULL";

        DatabaseConnection dbConnection = new DatabaseConnection();
        connect = dbConnection.getConnection();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            SubjectData sData;
            while (result.next()) {
                sData = new SubjectData(result.getInt("id"),
                        result.getString("subject_code"),
                        result.getString("subject"),
                        result.getString("course"),
                        result.getDate("date_insert"),
                        result.getDate("date_update"),
                        result.getDate("date_delete"));

                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void addSubjectDisplayData() {
        addSubjectListData = addSubjectGetData();

        addSubject_col_code.setCellValueFactory(new PropertyValueFactory<>("subjectCode"));
        addSubject_col_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        addSubject_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addSubject_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));

        addSubject_tableView.setItems(addSubjectListData);
    }

    private int subjectID = 0;

    public void addSubjectSelectItem() {
        SubjectData sData = addSubject_tableView.getSelectionModel().getSelectedItem();
        int num = addSubject_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addSubject_code.setText(sData.getSubjectCode());
        addSubject_subject.setText(sData.getSubject());
        addSubject_course.setText(sData.getCourse());

        subjectID = sData.getId();
    }

    public void addSubjectAddBtn() {
        if (addSubject_code.getText().isEmpty()
                || addSubject_subject.getText().isEmpty()
                || addSubject_course.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            DatabaseConnection dbConnection = new DatabaseConnection();
            connect = dbConnection.getConnection();

            String checkSubject = "SELECT * FROM subject WHERE subject_code = '"
                    + addSubject_code.getText() + "' AND date_delete IS NULL";
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkSubject);

                if (result.next()) {
                    alert.errorMessage(addSubject_code.getText() + " is already exist");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    String insertData = "INSERT INTO subject "
                            + "(subject_code, subject, course, date_insert) "
                            + "VALUES(?,?,?,?)";

                    String insertTeacherSubject = "INSERT INTO teacher_subject (teacher_id, subject_id) VALUES (?, ?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addSubject_code.getText());
                    prepare.setString(2, addSubject_subject.getText());
                    prepare.setString(3, addSubject_course.getText());
                    prepare.setDate(4, sqlDate);

                    prepare.executeUpdate();

                    prepare = connect.prepareStatement(insertTeacherSubject);
                    prepare.setString(1, teacher_id_subject.getText());
                    prepare.setString(2, addSubject_code.getText());

                    prepare.executeUpdate();

                    addSubjectDisplayData();

                    alert.successMessage("Added Successfully!");

                    addSubjectClear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addSubjectUpdateBtn() {
        if (addSubject_code.getText().isEmpty() || addSubject_subject.getText().isEmpty() || addSubject_course.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
            return;
        }

        if (!alert.confirmMessage("Are you sure you want to Update the Subject Code: " + addSubject_code.getText() + "?")) {
            alert.errorMessage("Cancelled");
            return;
        }

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String updateData = "UPDATE subject SET subject = ?, course = ?, date_update = ? WHERE subject_code = ?";

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connect = dbConnection.getConnection();

        if (connect == null) {
            alert.errorMessage("Database connection failed!");
            return;
        }

        try {
            PreparedStatement prepare = connect.prepareStatement(updateData);
            prepare.setString(1, addSubject_subject.getText());
            prepare.setString(2, addSubject_course.getText());
            prepare.setDate(3, sqlDate);
            prepare.setString(4, addSubject_code.getText());

            System.out.println("Executing update with: " + updateData);
            System.out.println("Parameters: " + addSubject_code.getText() + ", " + addSubject_subject.getText() + ", " + addSubject_course.getText() + ", " + sqlDate + ", " + subjectID);

            int affectedRows = prepare.executeUpdate();
            if (affectedRows > 0) {
                alert.successMessage("Updated Successfully!");
                addSubjectDisplayData();
                addSubjectClear();
            } else {
                alert.errorMessage("Update failed! No rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            alert.errorMessage("Update failed! Error: " + e.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addSubjectDeleteBtn() {

        if (!alert.confirmMessage("Are you sure you want to Delete Subject Code: " + addSubject_code.getText() + "?")) {
            alert.errorMessage("Cancelled");
            return;
        }

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String deleteData = "UPDATE subject SET date_delete = ? WHERE subject_code = ?";

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connect = dbConnection.getConnection();

        if (connect == null) {
            alert.errorMessage("Database connection failed!");
            return;
        }

        try {
            PreparedStatement prepare = connect.prepareStatement(deleteData);
            prepare.setDate(1, sqlDate);
            prepare.setString(2, addSubject_code.getText());

            System.out.println("Executing delete with: " + deleteData);
            System.out.println("Parameters: " + sqlDate + ", " + subjectID);

            int affectedRows = prepare.executeUpdate();
            if (affectedRows > 0) {
                alert.successMessage("Deleted Successfully!");
                addSubjectDisplayData();
                addSubjectClear();
            } else {
                alert.errorMessage("Delete failed! No rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            alert.errorMessage("Delete failed! Error: " + e.getMessage());
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void addSubjectClear() {
        addSubject_code.clear();
        addSubject_subject.clear();
        addSubject_course.clear();
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == addStudent_btn) {
            addStudent_form.setVisible(true);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            search_form.setVisible(false);

            addStudentDisplayData();
        } else if (event.getSource() == addTeacher_btn) {
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(true);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            search_form.setVisible(false);


            addTeacherDisplayData();
            addTeacherGenderList();
            addTeacherEYList();
            addTeacherDepartmentList();
            addTeacherDisplayTeacherID();
        } else if (event.getSource() == addCourse_btn) {
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(true);
            addSubject_form.setVisible(false);
            search_form.setVisible(false);


            addCourseDisplayData();
        } else if (event.getSource() == addSubject_btn) {
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(true);
            search_form.setVisible(false);


            addSubjectDisplayData();
//            addSubjectCourseList();
        } else if (event.getSource() == search_form_btn) {
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            search_form.setVisible(true);

            displayTeacherCourseData();
        }
    }


    public void displayGreet() {
        String username = ListData.admin_username;
        username = username.substring(0, 1).toUpperCase() + username.substring(1);

        greet_username.setText("Welcome, " + username);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayGreet();
        addCourse_form.setVisible(false);

    }
}

