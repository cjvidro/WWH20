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

import java.awt.image.AreaAveragingScaleFilter;
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

    public studentController(ArrayList<tasks> homework, ArrayList<tasks> housework, ArrayList<tasks> sportwork, ArrayList<tasks> otherwork)
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chores = new ArrayList<>();
        sports = new ArrayList<>();
        other = new ArrayList<>();

        school.addAll(homework);
        chores.addAll(housework);
        sports.addAll(sportwork);
        other.addAll(otherwork);

    }

    // Needed to intialize
    @FXML
    private void initialize()
    {
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
        loginController controller = new loginController(school, chores, sports, other);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        loader.setController(controller);
        Parent loginView = loader.load();
        Scene loginScene = new Scene(loginView);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setWidth(((Node)event.getSource()).getScene().getWidth());
        window.setHeight(((Node)event.getSource()).getScene().getHeight());
        window.setScene(loginScene);
        window.show();
    }


    // TODO if there's time.
    @FXML
    private void StatScene(ActionEvent event) throws IOException
    {

    }
    /* ===================================================================================== */

}

