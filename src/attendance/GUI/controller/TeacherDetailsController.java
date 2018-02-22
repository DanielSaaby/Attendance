/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import attendance.BE.Student;
import attendance.GUI.model.Model;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
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
    private StackedBarChart<String, Number> barChart;
    @FXML
    private PieChart pieChart;
    
    private int absence;
    private int presence;
    
    private int absenceMonday;
    private int absenceThursday;
    private int absenceWednesday;
    private int absenceTuesday;
    private int absenceFriday;


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
       
        overallAttendance();
        initializePieChart();
        initializeBarchar();
    }

    private void initializeTableView() 
    {
        Random rand = new Random();
        
       studentTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() 
       {
           @Override
           public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) 
           {
               absence = rand.nextInt(50) + 5;
               presence = 100-absence;
               
               absenceMonday = rand.nextInt(30) +4;
               absenceThursday = rand.nextInt(30) +4;
               absenceWednesday = rand.nextInt(30) +4;
               absenceTuesday = rand.nextInt(30) +4;
               absenceFriday = rand.nextInt(30) +4;              
               
               
               initializePieChart();
               initializeBarchar();
               
               
           }
       });
               
       
 
    }

    private void initializePieChart() 
    {
        ObservableList<PieChart.Data> pieChartData =
        FXCollections.observableArrayList(
        new PieChart.Data("Absence " + absence + "%", absence),
        new PieChart.Data("Presence " + presence + "%", presence));
        pieChart.setData(pieChartData);
        pieChart.setLegendVisible(false);
       
        
        applyCustomColorSequence(
            pieChartData, 
            "red", 
            "green"
            );
    }
    
    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) 
    {
        int i = 0;
        for (PieChart.Data data : pieChartData) 
        {
            data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
            i++;
        }
        
    }

    private void initializeBarchar() 
    {
        barChart.getData().clear();
        
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(absenceMonday + " %"); 
        series1.getData().add(new XYChart.Data("Monday", absenceMonday));
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(absenceThursday + " %"); 
        series2.getData().add(new XYChart.Data("Thursday", absenceThursday));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(absenceWednesday + " %"); 
        series3.getData().add(new XYChart.Data("Wednesday", absenceWednesday));
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(absenceTuesday + " %"); 
        series4.getData().add(new XYChart.Data("Tuesday", absenceTuesday));
        
        XYChart.Series series5 = new XYChart.Series();
        series4.setName(absenceFriday + " %"); 
        series4.getData().add(new XYChart.Data("Friday", absenceFriday));
        
        barChart.getData().addAll(series1, series2, series3, series4, series5);
        
        for(Node n:barChart.lookupAll(".default-color0.chart-bar")) 
        {
            n.setStyle("-fx-bar-fill: green;");
        }
              

    }

    private void overallAttendance() 
    {
        if(classLbl.getText().equalsIgnoreCase("CS2017A"))
        {
            absence = 14;
            presence = 86;
            absenceMonday = 12;
            absenceThursday = 42;
            absenceWednesday =4;
            absenceTuesday =7;
            absenceFriday =22;
        }
        
        if(classLbl.getText().equalsIgnoreCase("CS2017B"))
        {
            absence = 9;
            presence = 91;
            absenceMonday =11;
            absenceThursday =25;
            absenceWednesday =6;
            absenceTuesday =34;
            absenceFriday =12;       

        }
        if(classLbl.getText().equalsIgnoreCase("CS2016A"))
        {
            absence = 21;
            presence = 79;
            absenceMonday =7;
            absenceThursday =12;
            absenceWednesday =32;
            absenceTuesday =4;
            absenceFriday =9;     
            
        }
        if(classLbl.getText().equalsIgnoreCase("CS2016B"))
        {
            absence = 4;
            presence = 96;
            absenceMonday =32;
            absenceThursday =8;
            absenceWednesday =12;
            absenceTuesday =22;
            absenceFriday =6;     
            
        }
        if(classLbl.getText().equalsIgnoreCase("All Students"))
        {
            absence = 8;
            presence = 92;
            absenceMonday =12;
            absenceThursday =32;
            absenceWednesday =6;
            absenceTuesday =4;
            absenceFriday =29;         
            
        }
    }

    @FXML
    private void overallEvent(ActionEvent event) 
    {
        overallAttendance();
        initializePieChart();
        initializeBarchar();
    }

    @FXML
    private void goBackEvent(ActionEvent event) {
        
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
