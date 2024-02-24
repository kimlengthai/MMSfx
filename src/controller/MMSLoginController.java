package controller;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import model.*;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import model.Session;


public class MMSLoginController extends Controller<Session> 
{
    @FXML private Button login;
    @FXML private Button exit;
    @FXML private TextField email;
    @FXML private PasswordField password;
    
    @FXML private Label Email;
    @FXML private Label Password;
    @FXML private Label IncorrectMessage;
    
  
    public final Session getSession()
    {
        return model;
    }
    
    public String getEmail()
    {
        return email.getText();
    }
    private void setEmail()
    {
        email.setText("");
    }
    
    public String getPassword()
    {
        return password.getText();
    }
    private void setPassword()
    {
        password.setText("");
    }
    
    public final SuperMarket getSuperMarket(String email, String password)
    {
        return getSession().getSuperMarket(email, password);
    }
    
    @FXML private void handleOK () throws Exception
    {
        String email = getEmail();
        String password = getPassword();
        SuperMarket s = getSuperMarket(email, password);
        if (s!=null)            
            {
                Stage stage = new Stage();
                stage.getIcons().add(new Image("view/SuperMarket.png"));
                stage.setX(ViewLoader.X);
                stage.setY(ViewLoader.Y);
                ViewLoader.showStage(s, "/view/SuperMarket.fxml", "Session Admin: "+s.getName(), stage);
            }        
        else            
            {
                IncorrectMessage.setText("Incorrect login details");
            }
        setEmail();
        setPassword();
    }
    
    @FXML private void handleCancel () throws Exception
    {        
        stage.close();
    }
}

