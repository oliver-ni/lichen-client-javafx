package ni.oliver.lichen;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Stage stage;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        var loader = Utils.loadFXML(this);
        var scene = new Scene(loader.load());
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        App.stage = stage;
        App.scene = scene;
    }

    /**
     * Retrieves the current Application window (stage).
     * 
     * @return the current stage.
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * Retrieves the root scene of the app.
     * 
     * @return the root scene.
     */
    public static Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}