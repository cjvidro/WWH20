package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class studentController
{

    /* Keep track of all the tasks via ArrayLists */
    private ArrayList<tasks> school;
    private ArrayList<tasks> chore;
    private ArrayList<tasks> sport;
    private ArrayList<tasks> other;
    private ArrayList<CheckBox> schoolCheck;
    private ArrayList<CheckBox> choreCheck;
    private ArrayList<CheckBox> sportCheck;
    private ArrayList<CheckBox> otherCheck;

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

    @FXML
    private Label date;

    public studentController()
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        schoolCheck = new ArrayList<>();
        choreCheck = new ArrayList<>();
        sportCheck = new ArrayList<>();
        otherCheck = new ArrayList<>();
    }

    public studentController(ArrayList<tasks> homework, ArrayList<tasks> housework, ArrayList<tasks> sportwork, ArrayList<tasks> otherwork)
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        schoolCheck = new ArrayList<>();
        choreCheck = new ArrayList<>();
        sportCheck = new ArrayList<>();
        otherCheck = new ArrayList<>();

        school.addAll(homework);
        chore.addAll(housework);
        sport.addAll(sportwork);
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
        String pattern = "MMMMM dd, yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern, new Locale("en", "US"));
        String current = format.format(new Date());
        date.setText(current);
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
                schoolCheck.add(checkbox);
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
            if(checkbox != null)
            {
                choreCheck.add(checkbox);
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
            if(checkbox != null)
            {
                sportCheck.add(checkbox);
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
                otherCheck.add(checkbox);
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
        check(schoolCheck, school);
        check(choreCheck, chore);
        check(sportCheck, sport);
        check(otherCheck, other);

        loginController controller = new loginController(school, chore, sport, other);
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

    // Used to set the boolean of done inside of the tasks.
    // Does this based off of the if the checkbox has been ticked or not.
    private void check(ArrayList<CheckBox> checker, ArrayList<tasks> destination)
    {
        for(int i = 0; i < checker.size(); i++)
        {
            destination.get(i).setDone(checker.get(i).isSelected());
            System.out.println("Task: " + destination.get(i).getTask() + " is " + checker.get(i).isSelected());
        }
    }
}

