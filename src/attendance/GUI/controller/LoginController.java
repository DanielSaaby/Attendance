/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.GUI.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Daniels PC
 */
public class LoginController implements Initializable
{

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField userLbl;
    @FXML
    private JFXPasswordField passwordLbl;
    @FXML
    private Label loginErrorLbl;

    private Parent nextView;

    

      
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        loginErrorLbl.setVisible(false);
    }    

    @FXML
    private void loginEvent(ActionEvent event) throws IOException 
    {
        if(userLbl.getText().equalsIgnoreCase("StudentUser") && passwordLbl.getText().equalsIgnoreCase("testpassword1"))
        {
            loginErrorLbl.setVisible(false);
            nextView = (AnchorPane) FXMLLoader.load(getClass().getResource("/attendance/GUI/view/Studentlogin.fxml"));
            fadeOut();
            
        }
        else if (userLbl.getText().equalsIgnoreCase("TeacherUser") && passwordLbl.getText().equalsIgnoreCase("testpassword2"))
        {
            loginErrorLbl.setVisible(false);
            nextView = (AnchorPane) FXMLLoader.load(getClass().getResource("/attendance/GUI/view/TeacherLogin.fxml"));
            fadeOut();
        }
        else
        {
            loginErrorLbl.setVisible(true);
        }
        
    }
    
    public void fadeOut()
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                loadNextScene();
            }
        });
        fadeTransition.play();
    }
    
    public void loadNextScene()
    {     
        Scene newScene = new Scene(nextView);
        Stage curStage = (Stage) rootPane.getScene().getWindow();
        
        curStage.setScene(newScene);
                
    }
    
}
