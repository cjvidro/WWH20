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

public class parentController
{

    private ArrayList<tasks> school;
    private ArrayList<tasks> chore;
    private ArrayList<tasks> sport;
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


    public parentController()
    {
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();

    }

    @FXML
    private void initialize()
    {
        outputSchool();
        outputChore();
        outputSport();
        outputOther();
    }

    public void passArrays(ArrayList<tasks> school, ArrayList<tasks> chore, ArrayList<tasks> sport, ArrayList<tasks> other)
    {
        this.school.addAll(school);
        this.chore.addAll(chore);
        this.sport.addAll(sport);
        this.other.addAll(other);

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
        for(tasks element: chore)
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
        for(tasks element: sport)
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
    @FXML
    private void StudentScene(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        studentController controller = new studentController();
        controller.pass(school, chore, sport, other);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();

    }

    /* ===================================================================================== */
}
