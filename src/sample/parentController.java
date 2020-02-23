package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class parentController
{

    private ArrayList<tasks> school;
    private ArrayList<tasks> chore;
    private ArrayList<tasks> sport;
    private ArrayList<tasks> other;

    private ArrayList<HBox> schoolBox;
    private ArrayList<HBox> choreBox;
    private ArrayList<HBox> sportBox;
    private ArrayList<HBox> otherBox;

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
    private Label date;

    public parentController()
    {
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        otherBox = new ArrayList<>();
        schoolBox = new ArrayList<>();
        choreBox = new ArrayList<>();
        sportBox = new ArrayList<>();
    }

    public parentController(ArrayList<tasks> homework, ArrayList<tasks> housework, ArrayList<tasks> sportwork, ArrayList<tasks> otherwork)
    {
        // Test values for the ArrayLists.
        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();
        otherBox = new ArrayList<>();
        schoolBox = new ArrayList<>();
        choreBox = new ArrayList<>();
        sportBox = new ArrayList<>();

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
        String pattern = "MMMMM dd, yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern, new Locale("en", "US"));
        String current = format.format(new Date());
        date.setText(current);
    }
    
    /* ============================= Output into VBoxes ==================================== */
    private void outputHelper(ArrayList<HBox> boxes, ArrayList<tasks> source, VBox pane)
    {
        TextField textBox;
        HBox newItem;
        DatePicker date;
        for(tasks element: source)
        {
            newItem = new HBox();
            newItem.setSpacing(10);
            date = new DatePicker();
            textBox = new TextField(element.getTask());
            textBox.setUserData("label");

            if(textBox != null)
            {
                newItem.getChildren().addAll(textBox, date);
                boxes.add(newItem);
                pane.getChildren().add(newItem);
            }
        }
    }

    @FXML
    private void outputSchool()
    {
        outputHelper(schoolBox, school, schoolPane);
    }

    @FXML
    private void outputChore()
    {
        outputHelper(choreBox, chore, chorePane);
    }
    @FXML
    private void outputSport()
    {
        outputHelper(sportBox, sport, sportPane);
    }
    @FXML
    private void outputOther()
    {
        outputHelper(otherBox, other, otherPane);
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
        window.setWidth(((Node)event.getSource()).getScene().getWidth());
        window.setHeight(((Node)event.getSource()).getScene().getHeight());

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

        updateHelper(schoolBox, school);
        updateHelper(choreBox, chore);
        updateHelper(sportBox, sport);
        updateHelper(otherBox, other);

    }

    private void updateHelper(ArrayList<HBox> boxes, ArrayList<tasks> destination)
    {
        String words = new String();
        Date temp = new Date();
        tasks newTask;
        for(int i = 0; i < boxes.size(); i++)
        {
            for(Node n: boxes.get(i).getChildren())
            {
                if("label".equals(n.getUserData()))
                {
                    TextField text = (TextField) n;
                    words = text.getText();

                    newTask = new tasks(words, temp);

                    if(!(newTask.getTask().equals("") == true || newTask.getTask().equals("(Insert Task Here)") == true) )
                    {
                        destination.add(newTask);
                    }
                }

            }
        }
    }
    @FXML
    private void addToSchool(ActionEvent action)
    {
        tasks newTask = new tasks("(Insert Task Here)", new Date());
        school.add(newTask);
        for(int i = 0; i < schoolBox.size(); i++)
        {
            String text = obtainTask(schoolBox, i);
            newTask = new tasks(text, new Date());
            school.set(i, newTask);
        }
        schoolBox = new ArrayList<>();
        schoolPane.getChildren().clear();
        outputSchool();

    }

    @FXML
    private void addToChore(ActionEvent action)
    {
        tasks newTask;
        newTask = new tasks("(Insert Task Here)", new Date());
        chore.add(newTask);
        for(int i = 0; i < choreBox.size(); i++)
        {
            String text = obtainTask(choreBox, i);
            newTask = new tasks(text, new Date());
            chore.set(i, newTask);
        }
        choreBox = new ArrayList<>();
        chorePane.getChildren().clear();
        outputChore();
    }

    @FXML
    private void addToSport(ActionEvent action)
    {
        tasks newTask;
        newTask = new tasks("(Insert Task Here)", new Date());
        sport.add(newTask);
        for(int i = 0; i < sportBox.size(); i++)
        {
            String text = obtainTask(sportBox, i);
            newTask = new tasks(text, new Date());
            sport.set(i, newTask);
        }
        sportBox = new ArrayList<>();
        sportPane.getChildren().clear();
        outputSport();
    }

    @FXML
    private void addToOther(ActionEvent action)
    {
        tasks newTask = new tasks("(Insert Task Here)", new Date());
        other.add(newTask);
        for(int i = 0; i < otherBox.size(); i++)
        {
            String text = obtainTask(otherBox, i);
            newTask = new tasks(text, new Date());
            other.set(i, newTask);
        }
        otherBox = new ArrayList<>();
        otherPane.getChildren().clear();
        outputOther();
    }

    private String obtainTask(ArrayList<HBox> array, int i)
    {
        TextField text = new TextField();
        for(Node n: array.get(i).getChildren())
        {
            if("label".equals(n.getUserData()))
            {
                text = (TextField) n;
            }
        }
        return text.getText();
    }

}
