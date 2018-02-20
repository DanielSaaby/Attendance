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
    
    private int absenceSCO;
    private int absenceSDE;
    private int absenceDBO;
    private int absenceITO;
    @FXML
    private NumberAxis yAxis;
            
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        initializeAbsencePeriodComboBox();
        initializeClassAbsenceComboBox();
        initializePieChart();
        initializeBarChart();

        
        
 
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
                }
                else if(newValue.equalsIgnoreCase("Week1"))
                {
                    absence = 25;
                    presence = 75;
                }
                else if(newValue.equalsIgnoreCase("Weel2"))
                {
                    absence = 0;
                    presence = 100;
                }
                else if(newValue.equalsIgnoreCase("Week3"))
                {
                    absence = 50;
                    presence = 50;
                }
                else if(newValue.equalsIgnoreCase("Week4"))
                {
                    absence = 0;
                    presence = 100;
                }
                
                initializePieChart();
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
        series1.setName(absenceSCO + " %"); 
        series1.getData().add(new XYChart.Data("SCO", absenceSCO));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(absenceSDE + " %"); 
        series2.getData().add(new XYChart.Data("SDE", absenceSDE));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName(absenceDBO + " %"); 
        series3.getData().add(new XYChart.Data("SBO", absenceDBO));
        
        XYChart.Series series4 = new XYChart.Series();
        series4.setName(absenceITO + " %"); 
        series4.getData().add(new XYChart.Data("ITO", absenceITO));
        
        barChart.getData().addAll(series1, series2, series3, series4);
        
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(10);

    }

    private void initializeClassAbsenceComboBox() 
    {
        classAbsenceComboBox.getItems().addAll(
            "Overall",
            "Week1",
            "Week2",
            "Week3",
            "Week4");
        classAbsenceComboBox.getSelectionModel().select("Overall"); 
        
        classAbsenceComboBox.valueProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                if(newValue.equalsIgnoreCase("Overall"))
                {
                    absenceSCO = 14;
                    absenceSDE = 6;
                    absenceDBO = 10;
                    absenceITO = 4;
                   
                }
                else if(newValue.equalsIgnoreCase("Week1"))
                {
                    absenceSCO = 7;
                    absenceSDE = 2;
                    absenceDBO = 4;
                    absenceITO = 5;
                }
                else if(newValue.equalsIgnoreCase("Weel2"))
                {
                    absenceSCO = 10;
                    absenceSDE = 0;
                    absenceDBO = 3;
                    absenceITO = 12;
                }
                else if(newValue.equalsIgnoreCase("Week3"))
                {
                    absenceSCO = 0;
                    absenceSDE = 0;
                    absenceDBO = 0;
                    absenceITO = 15;
                }
                else if(newValue.equalsIgnoreCase("Week4"))
                {
                    absenceSCO = 4;
                    absenceSDE = 12;
                    absenceDBO = 0;
                    absenceITO = 0;
                }
                
                initializeBarChart();
            }
        });
        
    }
    
}
