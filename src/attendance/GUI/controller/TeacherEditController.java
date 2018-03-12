/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import attendance.BE.Student;
import attendance.GUI.model.Model;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frederik Tubæk
 */
public class TeacherEditController implements Initializable {

    private Model model;

    @FXML
    private Label classLbl;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentColumn;
    @FXML
    private JFXComboBox<String> periodComboBox;
    @FXML
    private JFXComboBox<String> mondayComboBox;
    @FXML
    private JFXComboBox<String> thursdayComboBox;
    @FXML
    private JFXComboBox<String> wednesdayComboBox;
    @FXML
    private JFXComboBox<String> tuesdayComboBox;
    @FXML
    private JFXComboBox<String> fridayComboBox;
    @FXML
    private AnchorPane attendanceInfo;
    
    
    private String mondayAttendance  = "Present";
    private String thursdayAttendance = "Present";
    private String wednesdayAttendance = "Present";
    private String tuesdayAttendance = "Present";
    private String fridayAttendance = "Present";
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        studentColumn.setCellValueFactory(new PropertyValueFactory("name"));
        initializeComboBoxes();
        initializeTableView(); 
        comboBoxListeners();
        attendanceInfo.setVisible(false);
       
    }    

    void setModel(Model model) 
    {
       this.model = model;        
       studentTableView.getItems().addAll(model.getListOfStudents());
    }

    void setClass(String selectedItem) 
    {
      classLbl.setText(selectedItem);
    }

    private void initializeComboBoxes() 
    {
        periodComboBox.getItems().addAll(
            "Week1",
            "Week2",
            "Week3",
            "Week4",
            "This week");
        periodComboBox.getSelectionModel().select("This week");    
        
        mondayComboBox.getItems().addAll("Present", "Absent");
        thursdayComboBox.getItems().addAll("Present", "Absent");
        wednesdayComboBox.getItems().addAll("Present", "Absent");
        tuesdayComboBox.getItems().addAll("Present", "Absent");
        fridayComboBox.getItems().addAll("Present", "Absent");
        
        
    }
    
    private void initializeTableView() 
    {
        Random rand = new Random();
        
       studentTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() 
       {
           @Override
           public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) 
           {
               attendanceInfo.setVisible(true);
               generateAttendance();
               setGenereratedAttendance();
               setAttendanceColor();
               
               
               
           }
       }); 
 
    }    
    
    
    private void setGenereratedAttendance() 
    {
        mondayComboBox.getSelectionModel().select(mondayAttendance);
        thursdayComboBox.getSelectionModel().select(thursdayAttendance);
        wednesdayComboBox.getSelectionModel().select(wednesdayAttendance);
        tuesdayComboBox.getSelectionModel().select(tuesdayAttendance);
        fridayComboBox.getSelectionModel().select(fridayAttendance);
        
    }
    
    
    private void setAttendanceColor()
    {
         if(mondayAttendance.equalsIgnoreCase("Absent"))
        {
            mondayComboBox.setStyle("-fx-border-color: red");
        } else
        {
            mondayComboBox.setStyle("-fx-border-color: green");
        }
        if(thursdayAttendance.equalsIgnoreCase("Absent"))
        {
            thursdayComboBox.setStyle("-fx-border-color: red");
        } else
        {
            thursdayComboBox.setStyle("-fx-border-color: green");
        } 
        if(wednesdayAttendance.equalsIgnoreCase("Absent"))
        {
            wednesdayComboBox.setStyle("-fx-border-color: red");
        } else
        {
            wednesdayComboBox.setStyle("-fx-border-color: green");
        }    
        if(tuesdayAttendance.equalsIgnoreCase("Absent"))
        {
            tuesdayComboBox.setStyle("-fx-border-color: red");
        } else
        {
            tuesdayComboBox.setStyle("-fx-border-color: green");
        } 
        if(fridayAttendance.equalsIgnoreCase("Absent"))
        {
            fridayComboBox.setStyle("-fx-border-color: red");
        } else
        {
            fridayComboBox.setStyle("-fx-border-color: green");
        }        
                   
    }
    
    private void generateAttendance()
    {
        Random rand = new Random();
        
        int m = rand.nextInt(5)+1;
        int t = rand.nextInt(5)+1;
        int w = rand.nextInt(5)+1;
        int t2 = rand.nextInt(5)+1;
        int f = rand.nextInt(5)+1;
        
        if(m < 2)
        {
            mondayAttendance = "Absent";
        }
        else
        {
            mondayAttendance = "Present";
        }
        
        if(t < 2)
        {
            thursdayAttendance = "Absent";
        }
        else
        {
            thursdayAttendance = "Present";
        }
        
        if(w < 2)
        {
            wednesdayAttendance = "Absent";
        }
        else
        {
            wednesdayAttendance = "Present";
        }
            
        if(t2 < 2)
        {
            tuesdayAttendance = "Absent";
        }   
        else
        {
            tuesdayAttendance = "Present";
        }
        
        if(f < 2)
        {
            fridayAttendance = "Absent";
        }
        else
        {
            fridayAttendance = "Present";
        }
    }

    private void comboBoxListeners() 
    {
        periodComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                generateAttendance();
                setGenereratedAttendance();
                setAttendanceColor();
            }
        });
        
        mondayComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                mondayAttendance = newValue;
                setAttendanceColor();
            }
        });
        
        thursdayComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                thursdayAttendance = newValue;
                setAttendanceColor();
            }
        });
        
        wednesdayComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                wednesdayAttendance = newValue;
                setAttendanceColor();
            }
        });
        
        tuesdayComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tuesdayAttendance = newValue;
                setAttendanceColor();
            }
        });
        
        fridayComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                fridayAttendance = newValue;
                setAttendanceColor();
            }
        });
        
        
        
    }

    @FXML
    private void goBackEvent(ActionEvent event) 
    {
        try 
        {
            Parent nextView = (AnchorPane) FXMLLoader.load(getClass().getResource("/attendance/GUI/view/TeacherLogin.fxml"));
            Scene newScene = new Scene(nextView);
            Stage curStage = (Stage) rootPane.getScene().getWindow();
            
            curStage.setScene(newScene);
        } catch (IOException ex) 
        {
            Logger.getLogger(StudentloginController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
    }
    
    
}
