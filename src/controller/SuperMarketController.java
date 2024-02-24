package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.scene.image.Image;



public class SuperMarketController extends Controller<SuperMarket> 
{              
    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TableView<Membership> membershipTv;
    @FXML private TableView<Membership> reportTv;
    @FXML private TableColumn<Membership, String> NameC;
    @FXML private TableColumn<Membership, String> EmailC;
    @FXML private TableColumn<Membership, String> PhoneC;
   
    @FXML private Button add;
    @FXML private Button delete;
    @FXML private Button select;
    @FXML private Button slip;
    @FXML private Button report;
    @FXML private Button close;
    
    
    
    public final SuperMarket getSuperMarket()
    {
        return model;
        
    }
    
    @FXML private void initialize()
    {
        membershipTv.setItems(getSuperMarket().getMemberships());
        membershipTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        NameC.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        
        membershipTv.getSelectionModel().selectedItemProperty().addListener(
        (o,old,newItem)->delete.setDisable(newItem == null)
        );
        
        membershipTv.getSelectionModel().selectedItemProperty().addListener(
        (o,old,newItem)->select.setDisable(newItem == null)
        );
        
        membershipTv.getSelectionModel().selectedItemProperty().addListener(
        (o,old,newItem)->slip.setDisable(newItem == null)
        );                
        
        EmailC.setCellValueFactory(cellData->cellData.getValue().emailProperty());
        PhoneC.setCellValueFactory(cellData->cellData.getValue().phoneProperty());
        name.textProperty().addListener((o,old,newText)->getSuperMarket().filterList(name.getText(), "+="));
        email.textProperty().addListener((o,old,newText)->getSuperMarket().filterList("+=", email.getText()));
    }
    
    @FXML private void HandleAdd () throws Exception
    {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("view/edit.png"));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        Membership m = new Membership("", "", "", "", "", 0.0);
        m.setSuperMarket(getSuperMarket());
        ViewLoader.showStage(m, "/view/Membership.fxml", "Adding New Membership", stage);
    }
    
    @FXML private void HandleDelete() throws Exception
    {
        membershipTv.getItems().removeAll(membershipTv.getSelectionModel().getSelectedItem());
    }
    
    private Membership getMembership()
    {
        return membershipTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void HandleSelect() throws Exception
    {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("view/edit.png"));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(getMembership(), "/view/Membership.fxml", "Accessing File: "+ membershipTv.getSelectionModel().getSelectedItem().getName(), stage);
    }
    
    @FXML private void HandleSLIP() throws Exception
    {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("view/edit.png"));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(getMembership(), "/view/slip.fxml", membershipTv.getSelectionModel().getSelectedItem().getName() +" SLIP Report", stage);
        
    }
    
    @FXML private void HandleReport() throws Exception
    {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("view/uts.jpeg"));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(getSuperMarket(), "/view/mms.fxml", "MMS Report", stage);
        
    }
    
    @FXML private void HandleClose() throws Exception
    {
        stage.close();
    }
}
