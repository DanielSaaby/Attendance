/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Frederik Tubæk
 */
public class StudentAdvancedDetailsController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private JFXComboBox<String> absencePeriodComboBox;
    @FXML
    private JFXComboBox<?> classAbsenceComboBox; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Absence " + 13 + "%", 13),
                new PieChart.Data("Presence " + 87 + "%", 87));
        pieChart.setData(pieChartData);
        pieChart.setLegendVisible(false);
       
        
        applyCustomColorSequence(
            pieChartData, 
            "red", 
            "green"
            );
        
        
        absencePeriodComboBox.getItems().addAll(
            "Overall",
            "Week1",
            "Week2",
            "week3",
            "week4");
        absencePeriodComboBox.getSelectionModel().select("Overall");     
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
    
}
