package kushcabbage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
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


        Scene scene = new Scene(new StackPane(l));

        stage.setScene(scene);
        stage.setFullScreen(true);

        stage.show();
    }
}
