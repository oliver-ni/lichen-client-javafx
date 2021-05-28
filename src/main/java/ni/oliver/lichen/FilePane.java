package ni.oliver.lichen;

import java.io.IOException;

import javafx.scene.layout.VBox;

public class FilePane extends VBox {
    public FilePane() throws IOException {
        var loader = Utils.loadFXML(this);
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
    }
}
