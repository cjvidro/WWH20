package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        studentController controller = new studentController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setTitle("Student Planner");
        primaryStage.getIcons().add(new Image("hat.png"));
        primaryStage.setScene(new Scene(root, 1024, 576));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
