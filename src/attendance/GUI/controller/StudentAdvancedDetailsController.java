/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
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
    private StackedBarChart<String, Number> barChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private JFXComboBox<String> absencePeriodComboBox;
    @FXML
    private JFXComboBox<String> classAbsenceComboBox; 
    
    private int absence = 14;
    private int presence = 86;
    
    private int absenceMonday;
    private int absenceThursday;
    private int absenceWednesday;
    private int absenceTuesday;
    private int absenceFriday;
    @FXML
    private NumberAxis yAxis;
            
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        initializeAbsencePeriodComboBox();
        initializePieChart();
        initializeBarChart();
        barChart.setVisible(false);
        barChart.setLegendVisible(false);
        
        
 
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

    private void initializeAbsencePeriodComboBox() 
    {
        absencePeriodComboBox.getItems().addAll(
            "Overall",
            "Week1",
            "Week2",
            "Week3",
            "Week4");
        absencePeriodComboBox.getSelectionModel().select("Overall"); 
        
        absencePeriodComboBox.valueProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                if(newValue.equalsIgnoreCase("Overall"))
                {
                    absence = 14;
                    presence = 86;
                    barChart.setVisible(false);
                }
                else if(newValue.equalsIgnoreCase("Week1"))
                {
                    absence = 25;
                    presence = 75;
                    absenceMonday = 100;
                    absenceThursday = 100;
                    absenceWednesday = 100;
                    absenceTuesday = 0;
                    absenceFriday = 100;
                    barChart.setVisible(true);

                }
                else if(newValue.equalsIgnoreCase("Weel2"))
                {
                    absence = 0;
                    presence = 100;
                    absenceMonday = 100;
                    absenceThursday = 100;
                    absenceWednesday = 100;
                    absenceTuesday = 100;
                    absenceFriday = 100;
                    barChart.setVisible(true);
                    
                }
                else if(newValue.equalsIgnoreCase("Week3"))
                {
                    absence = 80;
                    presence = 20;
                    absenceMonday = 0;
                    absenceThursday = 0;
                    absenceWednesday = 0;
                    absenceTuesday = 100;
                    absenceFriday = 100;
                    barChart.setVisible(true);
                    
                }
                else if(newValue.equalsIgnoreCase("Week4"))
                {
                    absence = 0;
                    presence = 100;
                    absenceMonday = 100;
                    absenceThursday = 100;
                    absenceWednesday = 100;
                    absenceTuesday = 100;
                    absenceFriday = 100;
                    barChart.setVisible(true);

                }
                
                initializePieChart();
                initializeBarChart();
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
    
    private void initializeBarChart()
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
        
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(0);
        yAxis.setTickUnit(0); 
        yAxis.setVisible(false);

    }

   
    
}
