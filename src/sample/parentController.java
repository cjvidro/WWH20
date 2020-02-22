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

    @FXML
    private ArrayList<tasks> school;
    @FXML
    private ArrayList<tasks> chore;
    @FXML
    private ArrayList<tasks> sport;
    @FXML
    private ArrayList<tasks> other;


    public parentController()
    {


    }

    @FXML
    private void initialize()
    {

    }

    public void passArrays(ArrayList<tasks> school, ArrayList<tasks> chore, ArrayList<tasks> sport, ArrayList<tasks> other)
    {
        this.school = school;
        this.chore = chore;
        this.sport = sport;
        this.other = other;

    }

    /* =================================== Change Scenes =================================== */
    @FXML
    private void StudentScene(ActionEvent event) throws IOException
    {
        Parent studentView = FXMLLoader.load(getClass().getResource("student.fxml"));
        Scene studentScene = new Scene(studentView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.show();

    }

    /* ===================================================================================== */
}
