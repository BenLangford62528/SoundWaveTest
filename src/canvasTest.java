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
import javafx.stage.Stage;;import java.util.ArrayList;


public class canvasTest {
    public static void main(String[] args) {
        new JFXPanel();
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

        Image image = new Image("/yes.jpg");
        ImageView im = new ImageView(image);
        im.setPreserveRatio(true);
        im.setFitWidth(60);

        ArrayList<ball> al = new ArrayList<>();
        for (int i = 0; i < 5; i++) al.add(new ball(image, (i * 128 +20), Math.random()));
        System.out.println(al);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.GREEN);
        gc.setFont(new Font("Comic Sans MS", 24));
        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.fillRect(0, 0, 1000, 500);
                for (ball b : al) {
                    b.update(500, 0.05);
                    gc.drawImage(b.getImage(), b.getX(), b.getCurrentHeight());
                }
            }
        };
        at.start();
    }
}
