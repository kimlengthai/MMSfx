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

public class MMSlipController extends Controller<Membership>
{   
    @FXML private Text totalCredits;
    @FXML private Text expense;
    @FXML private Text GasdeductionRate;
    @FXML private Text payPerCredit;
    @FXML private Text DollarAvailable;
    @FXML private Text deductionRate;
    
    public final Membership getMMSlip()
    {
        return model;
    }
    
    @FXML private void initialize()
    {        
        totalCredits.setText(String.format("%.2f", getMMSlip().gettotalCredits()));
        expense.setText(String.format("$%.2f", getMMSlip().getexpense()));
        GasdeductionRate.setText(String.format("%.2f", getMMSlip().getGasdeductionRate()));
        payPerCredit.setText(String.format("%.2f", getMMSlip().getPayPerCredit()));
        DollarAvailable.setText(String.format("$%.2f", getMMSlip().getDollarAvailable()));
        deductionRate.setText(String.format("%.2f", getMMSlip().getdeductionRate()));
        
    }
    
    @FXML private void handleCloseSlip() throws Exception
    {
        stage.close();
    }
}
