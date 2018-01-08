import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

;


public class canvasTest {
    public static int num;
    public static ArrayList<ball> al;
    public static Image image;
    public static GraphicsContext gc;

    public static void main(String[] args) {
        new JFXPanel();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        num = sc.nextInt();
        Platform.runLater(canvasTest::launch);
    }

    public static void launch() {
        Stage stage = new Stage();
        stage.setWidth(1000);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();

        Group group = new Group();
        Scene scene = new Scene(group);
        Canvas canvas = new Canvas();
        canvas.setWidth(1000);
        canvas.setHeight(500);
        group.getChildren().add(canvas);
        stage.setScene(scene);

        image = new Image("/yes.jpg");
        al = new ArrayList<>();
        for (int i = 0; i < num; i++) al.add(new ball(image, (i * 128 + 20), Math.random()));
        System.out.println(al);

        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.GREEN);
        gc.setFont(new Font("Comic Sans MS", 24));

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.fillRect(0, 0, 1000, 500);
                update(500, 0.05, now);
                if ((now / 100) % 1000000 == 0) System.out.println("n0");
                gc.strokeText("Time: " + now/1000000000%10, 10, 34);
            }
        };
        at.start();
    }

    public static void update(int a, double c, long now) {
        for (ball b : al) {
            gc.drawImage(b.getImage(), b.getX(), b.getCurrentHeight());
            b.update(a, c);
        }
        int time = (int) ((now / 100000000) % 10);
        if (time == 0) al.add(new ball(image, (int) (128 * now/1000000000%1000 + 30), Math.random()));
    }
}
