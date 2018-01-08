import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;;

public class Main {
    public static int windowWidth = 800;
    public static int windowHeight = 600;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::Launch);
    }


    public static void Launch() {
        Stage stage = new Stage();
        stage.setTitle("ya boi is doing some simulations of sound and/or light waves");
        stage.setWidth(windowWidth);
        stage.setHeight(windowHeight);
        stage.setResizable(false);
        stage.show();

        Group group = new Group();
        Scene scene = new Scene(group);
        Canvas canvas = new Canvas();
        canvas.setWidth(windowWidth);
        canvas.setHeight(windowHeight);
        group.getChildren().add(canvas);
        stage.setScene(scene);
        int radius = 500;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFont(new Font("Comic Sans MS", 24));
        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.GRAY);
                gc.fillRect(0, 0, windowWidth, windowHeight);
                gc.strokeText("Time: " + now/5000000,100,30);//(now % 500), 100, 30);
                int a = (int) (now/5000000) % radius;
                gc.strokeOval(400-a/2, 300-a/2, a, a);
                gc.strokeText("Radius: " + a, 100, 58);

            }
        };
        at.start();
    }
}
