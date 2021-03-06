package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static javafx.scene.paint.Color.WHITE;

public class studentController
{

    /* Keep track of all the tasks via ArrayLists */
    private ArrayList<tasks> school;
    private ArrayList<tasks> chore;
    private ArrayList<tasks> sport;
    private ArrayList<tasks> other;
    private ArrayList<HBox> schoolCheck;
    private ArrayList<HBox> choreCheck;
    private ArrayList<HBox> sportCheck;
    private ArrayList<HBox> otherCheck;

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

    static SystemTray tray;
    static TrayIcon trayIcon;
    Timer timer;

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

        tray = SystemTray.getSystemTray();

        java.awt.Image image = Toolkit.getDefaultToolkit().createImage("hat.png");
        trayIcon = new TrayIcon(image, "Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Student Planner Reminder");
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println(e);
        }
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


            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Ran " + allComplete());

                    if(!allComplete()){
                        System.out.println("Running Reminder: " + new java.util.Date());
                        trayIcon.displayMessage("You still have tasks left to do!", "Planner Reminder", TrayIcon.MessageType.INFO);
                    }
                }
            }, 0, 180000);


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

    private void addToPane(ArrayList<tasks> tastList, ArrayList<HBox> check, VBox pane) {
        CheckBox checkbox;
        Text textBox;
        HBox newTask;

        for(tasks element: tastList) {
            newTask = new HBox();
            checkbox = new CheckBox();
            textBox = new Text(element.getTask());

            textBox.setFill(WHITE);

            CheckBox finalCheckbox = checkbox;
            Text finalTextBox = textBox;
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (finalCheckbox.isSelected()) {
                        finalTextBox.setStyle("-fx-strikethrough: true");
                    } else {
                        finalTextBox.setStyle("-fx-strikethrough: false");
                    }
                }
            };

            checkbox.setOnAction(event);

            if(checkbox != null) {
                if(element.getDone() == true)
                {
                    checkbox.setSelected(true);
                    finalTextBox.setStyle("-fx-strikethrough: true");
                }
                checkbox.setUserData("label");
                newTask.getChildren().addAll(checkbox, textBox);
                pane.getChildren().add(newTask);
                check.add(newTask);
            }
        }
    }

    @FXML
    private void outputSchool() {
        addToPane(school, schoolCheck, schoolPane);
    }

    @FXML
    private void outputChore() {
        addToPane(chore, choreCheck, chorePane);
    }

    @FXML
    private void outputSport() {
        addToPane(sport, sportCheck, sportPane);
    }

    @FXML
    private void outputOther() {
        addToPane(other, otherCheck, otherPane);
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

        if (timer != null) {
            timer.cancel();
        }
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

    @FXML
    private void checkEverything(ActionEvent event) {
        check(schoolCheck, school);
        check(choreCheck, chore);
        check(sportCheck, sport);
        check(otherCheck, other);
    }

    // Used to set the boolean of done inside of the tasks.
    // Does this based off of the if the checkbox has been ticked or not.
    private void check(ArrayList<HBox> checker, ArrayList<tasks> destination)
    {
        CheckBox marked;
        for(int i = 0; i < checker.size(); i++)
        {
            marked = checkHelper(checker.get(i));
            if(marked != null)
            {
                destination.get(i).setDone(marked.isSelected());
            }
        }
    }

    private CheckBox checkHelper(HBox checker)
    {
        for(Node n: checker.getChildren())
        {
            if("label".equals(n.getUserData()) == true)
            {
                CheckBox check = (CheckBox) n;
                return check;
            }
        }
        return null;
    }

    private Boolean allComplete(){
        for (tasks schoolTask: school ) {
            if(!schoolTask.getDone()) {
                return false;
            }
        }

        for (tasks choreTask: chore ) {
            if(!choreTask.getDone()) {
                return false;
            }
        }

        for (tasks sportTask: sport ) {
            if(!sportTask.getDone()) {
                return false;
            }
        }

        for (tasks otherTask: other ) {
            if(!otherTask.getDone()) {
                return false;
            }
        }

        return true;
    }
}

