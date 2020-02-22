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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class studentController
{

    /* Keep track of all the tasks via ArrayLists */
    private ArrayList<tasks> school;
    private ArrayList<tasks> chores;
    private ArrayList<tasks> sports;
    private ArrayList<tasks> other;

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

    public studentController()
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chores = new ArrayList<>();
        sports = new ArrayList<>();
        other = new ArrayList<>();
        Date date = new Date();
        tasks temp = new tasks("Art", date);
        school.add(temp);
        temp = new tasks("Math", date);
        school.add(temp);
        temp = new tasks("Dishes", date);
        chores.add(temp);
        temp = new tasks("Baseball Practice", date);
        sports.add(temp);
    }

    // Needed to intialize
    @FXML
    private void initialize()
    {
        System.out.println("Entered initialize.\n");
        outputSchool();
        outputChore();
        outputSport();
        outputOther();

    }




    /* ============================= Output into VBoxes ==================================== */
    @FXML
    private void outputSchool()
    {
        CheckBox checkbox;
        for(tasks element: school)
        {
            checkbox = new CheckBox(element.getTask());
            checkbox.setStyle("-fx-font-size: 18px; -fx-font-family: 'Segoe UI Semibold'; -fx-text-fill: WHITE;");

            if(checkbox != null)
            {
                schoolPane.getChildren().add(checkbox);
            }
        }

    }

    @FXML
    private void outputChore()
    {
        CheckBox checkbox;
        for(tasks element: chores)
        {
            checkbox = new CheckBox(element.getTask());
            checkbox.setStyle("-fx-font-size: 18px; -fx-font-family: 'Segoe UI Semibold'; -fx-text-fill: WHITE;");
            if(checkbox != null)
            {
                chorePane.getChildren().add(checkbox);
            }
        }

    }
    @FXML
    private void outputSport()
    {
        CheckBox checkbox;
        for(tasks element: sports)
        {
            checkbox = new CheckBox(element.getTask());
            checkbox.setStyle("-fx-font-size: 18px; -fx-font-family: 'Segoe UI Semibold'; -fx-text-fill: WHITE;");
            if(checkbox != null)
            {
                sportPane.getChildren().add(checkbox);
            }
        }

    }
    @FXML
    private void outputOther()
    {
        CheckBox checkbox;
        for(tasks element: other)
        {
            checkbox = new CheckBox(element.getTask());
            checkbox.setStyle("-fx-font-size: 18px; -fx-font-family: 'Segoe UI Semibold'; -fx-text-fill: WHITE;");
            if(checkbox != null)
            {
                otherPane.getChildren().add(checkbox);
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
    private void StatScene(ActionEvent event) throws IOException
    {

    }


    /* ===================================================================================== */
}

