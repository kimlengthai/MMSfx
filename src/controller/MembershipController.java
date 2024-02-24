package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import model.*;
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

public class MembershipController extends Controller<Membership>
{
    @FXML private TextField name;
    @FXML private TextField phone;
    @FXML private TextField email;
    @FXML private TextField address;
    @FXML private TextField id;
    @FXML private TextField expense;
    @FXML private Text type;

    @FXML private Button add;
    @FXML private Button update;
    
    private Validator v = new Validator();
    
    @FXML private void handleAddM() throws Exception
    {
        if(v.isValid(name.getText(), email.getText(), phone.getText(), address.getText(), id.getText(), Double.parseDouble(expense.getText())))
        {    
        getMembership().updateDetails(name.getText(), email.getText(), phone.getText(), address.getText(), id.getText(), Double.parseDouble(expense.getText()));
        getMembership().getSuperMarket().addMembership(getMembership());
        stage.close();
        }
        else
        {
            v.generateErrors(name.getText(), email.getText(), phone.getText(), address.getText(), id.getText(), Double.parseDouble(expense.getText()));
            Stage stage = new Stage(); 
            stage.getIcons().add(new Image("view/error.png"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(v, "/view/error.fxml", "Input Exceptions", stage);
        }
       
    }
    
    @FXML private void handleUpdateM() throws Exception
    {
        if(v.isValid(name.getText(), email.getText(), phone.getText(), address.getText(), id.getText(), Double.parseDouble(expense.getText())))
        {    
        getMembership().updateDetails(name.getText(), email.getText(), phone.getText(), address.getText(), id.getText(), Double.parseDouble(expense.getText()));
        stage.close();
        }
        else
        {
            v.generateErrors(name.getText(), email.getText(), phone.getText(), address.getText(), id.getText(), Double.parseDouble(expense.getText()));
            Stage stage = new Stage(); 
            stage.getIcons().add(new Image("view/error.png"));
            stage.setX(ViewLoader.X);
            stage.setY(ViewLoader.Y);
            ViewLoader.showStage(v, "/view/error.fxml", "Input Exceptions", stage);
        }
    }
    
    @FXML private void handleCloseM() throws Exception
    {
        stage.close();
    }
    
    @FXML private void initialize()
    {
        name.setText(getMembership().getName());
        phone.setText(getMembership().getPhone());
        email.setText(getMembership().getEmail());
        address.setText(getMembership().getAddress());
        id.setText(getMembership().getID());
        expense.setText(String.format("%.1f", getMembership().getexpense()));
        type.setText(getMembership().getType()); 
        
        if(name.getText().isEmpty())
        {
            update.setDisable(true);
            add.setDisable(false);
        }
        else
        {
            update.setDisable(false);
            add.setDisable(true);
        }
    }
            
    public final Membership getMembership()
    {
        return model;
    }

}
