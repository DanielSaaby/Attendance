/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import attendance.BE.Student;
import attendance.GUI.model.Model;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Frederik Tubæk
 */
public class TeacherDetailsController implements Initializable {
    
    private Model model;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentColumn;
    @FXML
    private Label classLbl;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private PieChart pieChart;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        studentColumn.setCellValueFactory(new PropertyValueFactory("name"));
        initializeTableView();
        
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

    private void initializeTableView() 
    {
       studentTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() 
       {
           @Override
           public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) 
           {
               
           }
       });
               
       
 
    }

  

}
