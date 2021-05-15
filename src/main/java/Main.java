package main.java;

import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        // TODO Auto-generated method stub
        Button btn1 = new Button("Say, Hello World");

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("hello world");
            }
        });

        Circle circ = new Circle();
        circ.setCenterX(20);
        circ.setCenterY(20);
        circ.setRadius(20);
        circ.setFill(Color.RED);

        Rectangle rect = new Rectangle();
        rect.setX(5);
        rect.setY(20);
        rect.setWidth(100);
        rect.setHeight(100);

        StackPane root = new StackPane();
        root.getChildren().add(btn1);

        Scene scene = new Scene(root,600,400);

        primaryStage.setTitle("First JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    public static void main (String[] args)
//    {
//        launch(args);
//    }
}
