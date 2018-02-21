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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    private Model model = new Model();

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentColumn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        studentTableView.getItems().addAll(model.getListOfStudents());
        studentColumn.setCellValueFactory(new PropertyValueFactory("name"));
    }    

  

}
