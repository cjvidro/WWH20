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

public class Controller
{

    private boolean parent;

    private String password;

    /* Keep track of all the tasks via ArrayLists */
    private ArrayList<String> school;
    private ArrayList<String> chores;
    private ArrayList<String> sports;
    private ArrayList<String> other;

    /* VBoxes to display tasks to be done */
    @FXML
    private VBox schoolPane;
    @FXML
    private VBox chorePane;
    @FXML
    private VBox sportPane;
    @FXML
    private VBox otherPane;


    @FXML
    private PasswordField enterPassword;

    @FXML
    private URL location;

    @FXML
    private Button button;

    public Controller()
    {
        // Default values.
        password = "1234";
        parent = false;
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chores = new ArrayList<>();
        sports = new ArrayList<>();
        other = new ArrayList<>();
        school.add("Art");
        school.add("Math");
        chores.add("Dishes");
        sports.add("Baseball Practice");
    }

    // Needed to intialize
    @FXML
    private void initialize()
    {
        schoolPane = new VBox();
        chorePane = new VBox();
        sportPane = new VBox();
        otherPane = new VBox();
        System.out.println("Entered initialize.\n");
        outputSchool();
        outputChore();
        outputSport();
        outputOther();

    }

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


    /* ============================= Output into VBoxes ==================================== */
    @FXML
    private void outputSchool()
    {
        CheckBox temp;
        for(String element: school)
        {
            temp = new CheckBox(element);
            if(temp != null)
            {
                schoolPane.getChildren().add(temp);
            }
        }

    }

    @FXML
    private void outputChore()
    {
        CheckBox temp;
        for(String element: chores)
        {
            temp = new CheckBox(element);
            if(temp != null)
            {
                chorePane.getChildren().add(temp);
            }
        }

    }
    @FXML
    private void outputSport()
    {
        CheckBox temp;
        for(String element: sports)
        {
            temp = new CheckBox(element);
            if(temp != null)
            {
                sportPane.getChildren().add(temp);
            }
        }

    }
    @FXML
    private void outputOther()
    {
        CheckBox temp;
        for(String element: other)
        {
            temp = new CheckBox(element);
            if(temp != null)
            {
                otherPane.getChildren().add(temp);
            }
        }

    }
    /* ===================================================================================== */

    /* =================================== Change Scenes =================================== */
    // Changes the scene to the login view
    @FXML
    private void LoginScene(ActionEvent event) throws IOException
    {
        Parent loginView = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene loginScene = new Scene(loginView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.show();
    }

    @FXML
    private void StudentScene(ActionEvent event) throws IOException
    {
        Parent studentView = FXMLLoader.load(getClass().getResource("student.fxml"));
        Scene studentScene = new Scene(studentView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();

    }

    @FXML
    private void StatScene(ActionEvent event) throws IOException
    {

    }

    @FXML
    private void ParentScene(ActionEvent event) throws IOException
    {

    }

    /* ===================================================================================== */
}

