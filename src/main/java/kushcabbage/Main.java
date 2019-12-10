package kushcabbage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class Main extends Application {
    static HotwordListener iHotwordClass;



    public static void main(String[] args) {

        iHotwordClass = new HotwordListener();
        Thread t = new Thread(iHotwordClass);
        t.start();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");


        StackPane root = new StackPane(l);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK,  CornerRadii.EMPTY,  Insets.EMPTY)));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setFullScreen(true);

        stage.show();
    }
}
