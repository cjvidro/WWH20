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

    public loginController(ArrayList<tasks> homework, ArrayList<tasks> housework, ArrayList<tasks> sporter, ArrayList<tasks> otherwork)
    {
        password = "1234";
        parent = false;

        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();

        school.addAll(homework);
        chore.addAll(housework);
        sport.addAll(sporter);
        other.addAll(otherwork);
    }

    public loginController()
    {
        password = "1234";
        parent = false;

        school = new ArrayList<>();
        chore = new ArrayList<>();
        sport = new ArrayList<>();
        other = new ArrayList<>();

    }
    @FXML
    private void initialize()
    {
        System.out.println("Entered login initializer!");
        for(tasks element: school)
        {
            System.out.println("There are elements");
            System.out.println(element.getTask());
        }
    }

    /* =================================== Change Scenes =================================== */
    @FXML
    private void StudentScene(ActionEvent event) throws IOException
    {
        studentController controller = new studentController(school, chore, sport, other);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        loader.setController(controller);
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();

    }

    @FXML
    private void ParentScene(ActionEvent event) throws IOException
    {
        parentController controller = new parentController(school, chore, sport, other);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("parent.fxml"));
        loader.setController(controller);
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);


        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();
    }

    /* ===================================================================================== */

    /* ============================== Login Section ======================================== */

    // For logging into the parent account.
    @FXML
    private void login(ActionEvent event) throws IOException
    {
        parent = password.equals(enterPassword.getText());
        if(parent)
        {
            ParentScene(event);
        }

    }

    // Checks to see if they are logged in.
    private boolean loggedIn()
    {
        return parent;
    }


    /* ===================================================================================== */

    public void passLists(ArrayList<tasks> schools, ArrayList<tasks> chore, ArrayList<tasks> sport, ArrayList<tasks> other)
    {
        this.school.addAll(schools);
        this.chore.addAll(chore);
        this.sport.addAll(sport);
        this.other.addAll(other);
    }
}
