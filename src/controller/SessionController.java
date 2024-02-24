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
import javafx.scene.image.Image;
import model.*;

public class SessionController extends Controller<Session>
{
    @FXML private Button login;
    @FXML private Button exit;
    public final Session getSession()
    {
        return model;
    }
    
    @FXML private void handleClose()
    {
        javafx.application.Platform.exit();
    }
            
    @FXML private void handleOpen () throws Exception
    {
        Stage stage = new Stage(); 
        stage.getIcons().add(new Image("view/book.png"));
        stage.setX(ViewLoader.X);
        stage.setY(ViewLoader.Y);
        ViewLoader.showStage(getSession(), "/view/MMSlogin.fxml", "Sign In", stage);
    }
}
