package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        studentController controller = new studentController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setTitle("Student Planner");
        primaryStage.getIcons().add(new Image("hat.png"));
        primaryStage.setScene(new Scene(root, 1024, 576));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(550);
        primaryStage.show();
    }


    public static void main(String[] args) {

//        // reminder system
//        if (SystemTray.isSupported()) {
//            try {
//                SystemTray tray = SystemTray.getSystemTray();
//
//                java.awt.Image image = Toolkit.getDefaultToolkit().createImage("hat.png");
//                TrayIcon trayIcon = new TrayIcon(image, "Demo");
//                trayIcon.setImageAutoSize(true);
//                trayIcon.setToolTip("Student Planner Reminder");
//                tray.add(trayIcon);
//
//                Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        System.out.println("Running Reminder: " + new java.util.Date());
////                        trayIcon.displayMessage("You still have tasks left to do!", "Planner Reminder", TrayIcon.MessageType.INFO);
//                    }
//                }, 0, 8000);
//            } catch (AWTException e) {
//                System.out.println(e);
//            }
//        }

        launch(args);
    }
}
