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

import au.edu.uts.ap.javafx.Controller;

public class ErrorController extends Controller<Validator> 
{
@FXML private Text error;

@FXML private void initialize()
{
    String message="";
    for(String s : getValidator().errors())
    {
       
        message = message + s;
    }
    error.setText(message);
    getValidator().clear();
}

@FXML private void handleOkayError() throws Exception
    {
        stage.close();
    }

public final Validator getValidator()
{
    return model;
}

}
