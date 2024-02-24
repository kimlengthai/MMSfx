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
import javafx.beans.binding.Bindings;


public class MMSController extends Controller<SuperMarket>
{
    @FXML private TableView<Membership> reportTv;
    @FXML private TableColumn<Membership, String> NameA;
    @FXML private TableColumn<Membership, String> TypeA;
    @FXML private TableColumn<Membership, String> ExpenseA;
    @FXML private TableColumn<Membership, String> CreditsA;
    @FXML private TableColumn<Membership, String> GasdeductionRateA;
    @FXML private TableColumn<Membership, String> DeductionRateA;
    @FXML private TableColumn<Membership, String> payPerCreditA;
    @FXML private TableColumn<Membership, String> DollarAvailableA;
    
    
    @FXML private Text expense;
    @FXML private Text GasdeductionRate;
    @FXML private Text payPerCredit;
    @FXML private Text totalCredits;
    @FXML private Text deductionRate;
    @FXML private Text DollarAvailable;
    
    @FXML private void initialize()            
            {               
                MMS mms = new MMS(getSuperMarket());
                reportTv.setItems(getSuperMarket().getMemberships());
                reportTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                NameA.setCellValueFactory(cellData->cellData.getValue().nameProperty());
                TypeA.setCellValueFactory(cellData->cellData.getValue().typeProperty());
                ExpenseA.setCellValueFactory(cellData->cellData.getValue().expenseProperty().asString("$%.2f"));
                CreditsA.setCellValueFactory(cellData->cellData.getValue().totalCreditsProperty().asString("%.2f"));
                GasdeductionRateA.setCellValueFactory(cellData->cellData.getValue().GasdeductionRateProperty().asString("%.2f"));
                DeductionRateA.setCellValueFactory(cellData->cellData.getValue().deductionRateProperty().asString("%.2f"));
                payPerCreditA.setCellValueFactory(cellData->cellData.getValue().payPerCreditProperty().asString("%.2f"));
                DollarAvailableA.setCellValueFactory(cellData->Bindings.createStringBinding(()->"$ " + cellData.getValue().getDollarAvailable() + "0", cellData.getValue().DollarAvailableProperty()));
        
                totalCredits.setText(String.format("%.2f", mms.getTotalCredits()));
                expense.setText(String.format("$%.2f", mms.getTotalExpense()));
                GasdeductionRate.setText(String.format("%.2f", mms.getAvgGasdeductionRate()));
                payPerCredit.setText(String.format("%.2f", mms.getAvgPayPerCredit()));
                DollarAvailable.setText(String.format("$%.2f", mms.getTotalDollarAvailable()));
                deductionRate.setText(String.format("%.2f", mms.getAvgdeductionRate()));
            }
    
    @FXML private void handleCloseReport() throws Exception            
            {           
                stage.close();
            }
    
    public final SuperMarket getSuperMarket()            
            {
                return model;
            }

}
