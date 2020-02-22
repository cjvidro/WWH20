package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller
{

    private boolean parent;

    private String password;

    private ArrayList<String> school;
    private ArrayList<String> chores;
    private ArrayList<String> sports;
    private ArrayList<String> other;

    @FXML
    private VBox schoolPane;
    @FXML
    private VBox chorePane;
    @FXML
    private VBox sportPane;
    @FXML
    private VBox otherPane;


    @FXML
    private TextField enterPassword;


    @FXML
    private TextArea output;


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
        school = new ArrayList<String>();
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
        TextField text = new TextField();
        text.setText("WORDS ON THE SCREEN!\n");
        schoolPane.getChildren().add(text);
        CheckBox tasks;
        String test[] = {"Art", "Math"};
        for(int i = 0; i < 2; i++)
        {
            tasks = new CheckBox(test[i]);
            schoolPane.getChildren().add(tasks);
        }

    }


    @FXML
    private void test()
    {

    }


    // For logging into the parent account.
    @FXML
    private void logIn()
    {
        parent = password.equals(enterPassword.getText());
        outputLogged();
    }

    private void outputLogged()
    {
        if(!parent)
        {
            output.setText("Password is incorrect.\n");
        }
        else
        {
            output.setText("Logged in.\n");
        }
    }

    @FXML
    private void outputSchool()
    {


    }
    // Checks to see if they are logged in.S
    private boolean loggedIn()
    {
        return parent;
    }
}

