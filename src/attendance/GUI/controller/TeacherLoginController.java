/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import attendance.BE.Student;
import attendance.GUI.model.Model;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Frederik Tubæk
 */
public class TeacherLoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, Double> studentAbsenceColumn;
    @FXML
    private JFXTextField searchBar;
    @FXML
    private JFXComboBox<String> classComboBox;
    
    private Model model = new Model();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        rootPane.setOpacity(0);
        makeFadingTransmition();
        
        studentTableView.setItems(model.getListOfStudents());
        studentNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        studentAbsenceColumn.setCellValueFactory(new PropertyValueFactory("absence"));
        
        initializeClassComboBox();
        eventSearchSong();
    }    
    
       private void makeFadingTransmition() 
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(2500));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();        
    }


    @FXML
    private void editEvent(ActionEvent event) 
    {
    }

    @FXML
    private void viewDetailsEvent(ActionEvent event) 
    {
        loadNextScene();
    }
    
    public void loadNextScene()
    {
        try 
        {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/GUI/view/TeacherDetails.fxml"));        
            
            Parent nextView = (AnchorPane) fxmlLoader.load();
            
            TeacherDetailsController tdc = fxmlLoader.getController();
            tdc.setModel(model);
            tdc.setClass(classComboBox.getSelectionModel().getSelectedItem());
            Scene newScene = new Scene(nextView);          
            
            Stage curStage = (Stage) rootPane.getScene().getWindow();
  
            curStage.setScene(newScene);
        } catch (IOException ex) 
        {
            Logger.getLogger(StudentloginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    private void initializeClassComboBox() 
    {
        classComboBox.getItems().addAll(
            "All Students",
            "CS2017A",
            "CS2017B",
            "CS2016A",
            "CS2016B");
        classComboBox.getSelectionModel().select("All Students");
        classComboBox.valueProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                if(newValue.equalsIgnoreCase("CS2017A"))
                {
                    model.getCS2017A();
                }
                if(newValue.equalsIgnoreCase("CS2017B"))
                {
                    model.getCS2017B();
                }
                if(newValue.equalsIgnoreCase("CS2016A"))
                {
                    model.getCS2016A();
                }
                if(newValue.equalsIgnoreCase("CS2016B"))
                {
                    model.getCS2016B();
                }
                if(newValue.equalsIgnoreCase("All Students"))
                {
                    model.getAllStudents();
                }
            }
        });
    }
    
        private void eventSearchSong() 
    {   
        FilteredList filter = new FilteredList(studentTableView.getItems(),e ->true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            
            
            filter.setPredicate((Predicate<? super Student>) (Student Student) -> {
                
                
                if(newValue.isEmpty() || newValue==null) {
                    return true;
                }
                else if (Student.getName().toLowerCase().contains(newValue.toLowerCase())) 
                {
                    
                    return true;
                }
                
                return false;
            });
            SortedList sort= new SortedList(filter);
            sort.comparatorProperty().bind(studentTableView.comparatorProperty());
            studentTableView.setItems(sort);
        });
    }

    
    
    
}
