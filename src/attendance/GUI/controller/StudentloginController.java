/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kent Juul
 */
public class StudentloginController implements Initializable
{

    @FXML
    private Label classLbl;
    @FXML
    private Label dateLbl;
    @FXML
    private Label welcomelbl;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton submitAttendanceBtn;
    @FXML
    private Label registerSuccesfulLbl;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        rootPane.setOpacity(0);
        registerSuccesfulLbl.setVisible(false);
        makeFadingTransmition();
        
        
        welcomelbl.setText("Welcome Daniel Saaby Rasmussen");
        dateLbl.setText("Current date: " + sdf.format(date));
        classLbl.setText("Current class: SCO");
        
  
        
    }    

    @FXML
    private void submitAttendanceEvent(ActionEvent event) 
    {
        submitAttendanceBtn.setVisible(false);
        registerSuccesfulLbl.setVisible(true);
        
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
    
}
