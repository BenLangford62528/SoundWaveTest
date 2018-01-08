import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Test::Lunch);
    }

    public static void Lunch() {
        Stage bums = new Stage();
        bums.setTitle("ye mum");
        bums.setWidth(1000);
        bums.setHeight(500);
        bums.setResizable(false);
        bums.show();

        Group group = new Group();
        Scene scene = new Scene(group);
        bums.setScene(scene);
        Image image = new Image("yes.jpg");

        ArrayList<ImageView> al = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            al.add(new ImageView(image));
        }
        for (ImageView im : al) {
            im.setY(100);
            im.setX(al.indexOf(im)*130);
            System.out.println(im.getX());
            group.getChildren().add(im);
        }


        Button butt = new Button(":)");
        butt.setOnAction((ActionEvent) -> {
            System.out.println("no");
            activate();
        });
        group.getChildren().add(butt);
    }

    public static void activate() {
        System.out.println("also no!");
    }
}
