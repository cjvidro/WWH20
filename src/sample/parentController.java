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
import java.util.Date;
import java.util.List;

public class parentController
{

    private ArrayList<tasks> school;
    private ArrayList<tasks> chore;
    private ArrayList<tasks> sport;
    private ArrayList<tasks> other;

    private ArrayList<TextField> schoolText;
    private ArrayList<TextField> choreText;
    private ArrayList<TextField> sportText;
    private ArrayList<TextField> otherText;

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
    private TextField task;

    @FXML
    private Date pick;

    public parentController()
    {
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        otherText = new ArrayList<>();
        schoolText = new ArrayList<>();
        choreText = new ArrayList<>();
        sportText = new ArrayList<>();
    }

    public parentController(ArrayList<tasks> homework, ArrayList<tasks> housework, ArrayList<tasks> sportwork, ArrayList<tasks> otherwork)
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        otherText = new ArrayList<>();
        schoolText = new ArrayList<>();
        choreText = new ArrayList<>();
        sportText = new ArrayList<>();

        school.addAll(homework);
        chore.addAll(housework);
        sport.addAll(sportwork);
        other.addAll(otherwork);

    }

    @FXML
    private void initialize()
    {
        outputSchool();
        outputChore();
        outputSport();
        outputOther();
    }

    @FXML
    private void createTask(ActionEvent event)
    {

        //tasks newTask = new tasks()
    }
    /* ============================= Output into VBoxes ==================================== */
    @FXML
    private void outputSchool()
    {
        TextField textBox;
        for(tasks element: school)
        {
            textBox = new TextField(element.getTask());

            if(textBox != null)
            {
                schoolText.add(textBox);
                schoolPane.getChildren().add(textBox);
            }
        }

    }

    @FXML
    private void outputChore()
    {
        TextField textBox;
        for(tasks element: chore)
        {
            textBox = new TextField(element.getTask());
            if(textBox != null)
            {
                choreText.add(textBox);
                chorePane.getChildren().add(textBox);
            }
        }

    }
    @FXML
    private void outputSport()
    {
        TextField textBox;
        for(tasks element: sport)
        {
            textBox = new TextField(element.getTask());
            if(textBox != null)
            {
                sportText.add(textBox);
                sportPane.getChildren().add(textBox);
            }
        }

    }
    @FXML
    private void outputOther()
    {
        TextField textBox;
        for(tasks element: other)
        {
            textBox = new TextField(element.getTask());
            if(textBox != null)
            {
                otherText.add(textBox);
                otherPane.getChildren().add(textBox);
            }
        }

    }
    /* ===================================================================================== */


    /* =================================== Change Scenes =================================== */
    @FXML
    private void StudentScene(ActionEvent event) throws IOException
    {
        update();
        studentController controller = new studentController(school, chore, sport, other);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        loader.setController(controller);
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();

    }

    /* ===================================================================================== */

    private void update()
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        Date temp = new Date();
        for(int i = 0; i < schoolText.size(); i++)
        {
            tasks newTask = new tasks(schoolText.get(i).getText(), temp);
            school.add(newTask);
        }
        for(int i = 0; i < choreText.size(); i++)
        {
            tasks newTask = new tasks(choreText.get(i).getText(), temp);
            chore.add(newTask);
        }

        for(int i = 0; i < sportText.size(); i++)
        {
            tasks newTask = new tasks(sportText.get(i).getText(), temp);
            sport.add(newTask);
        }

        for(int i = 0; i < otherText.size(); i++)
        {
            tasks newTask = new tasks(otherText.get(i).getText(), temp);
            other.add(newTask);
        }

    }

    @FXML
    private void addToSchool(ActionEvent action)
    {
        tasks newTask = new tasks("words", new Date());
        school.add(newTask);
        schoolText = new ArrayList<>();
        schoolPane.getChildren().clear();
        outputSchool();
    }

    @FXML
    private void addToChore(ActionEvent action)
    {
        tasks newTask = new tasks("words", new Date());
        chore.add(newTask);
        choreText = new ArrayList<>();
        chorePane.getChildren().clear();
        outputChore();
    }

    @FXML
    private void addToSport(ActionEvent action)
    {
        tasks newTask = new tasks("words", new Date());
        sport.add(newTask);
        sportText = new ArrayList<>();
        sportPane.getChildren().clear();
        outputSport();
    }

    @FXML
    private void addToOther(ActionEvent action)
    {
        tasks newTask = new tasks("words", new Date());
        other.add(newTask);
        otherText = new ArrayList<>();
        otherPane.getChildren().clear();
        outputOther();
    }

}
