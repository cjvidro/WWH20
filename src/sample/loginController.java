package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class loginController
{

    private String password;
    private boolean parent;

    private ArrayList<tasks> school;
    private ArrayList<tasks> chore;
    private ArrayList<tasks> sport;
    private ArrayList<tasks> other;

    @FXML
    private PasswordField enterPassword;

    public loginController()
    {
        password = "1234";
        parent = false;
    }

    @FXML
    private void initialize()
    {

    }

    /* =================================== Change Scenes =================================== */
    @FXML
    private void StudentScene(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();

    }

    @FXML
    private void ParentScene(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("parent.fxml"));
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        parentController controller = loader.<parentController>getController();
        controller.passArrays(school, chore, sport, other);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();
    }

    /* ===================================================================================== */

    /* ============================== Login Section ======================================== */

    // For logging into the parent account.
    @FXML
    private void login(ActionEvent event)
    {
        parent = password.equals(enterPassword.getText());
    }

    // Checks to see if they are logged in.
    private boolean loggedIn()
    {
        return parent;
    }


    /* ===================================================================================== */

    public void passLists(ArrayList<tasks> school, ArrayList<tasks> chore, ArrayList<tasks> sport, ArrayList<tasks> other)
    {
        this.school = school;
        this.chore = chore;
        this.sport = sport;
        this.other = other;
    }
}
