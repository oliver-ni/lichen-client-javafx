package ni.oliver.lichen;

import java.io.IOException;
import java.nio.file.Files;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * A file pane component with a simple code editor, and utilities to load files.
 */
public class FilePane extends VBox {
    @FXML
    private CodeArea codeArea;

    /**
     * Constructs a file pane.
     * 
     * @throws IOException if FXML file could not be loaded.
     */
    public FilePane() throws IOException {
        var loader = Utils.loadFXML(this);
        loader.setRoot(this);
        loader.setController(this);
        loader.load();

        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    }

    /**
     * Handler triggered when the "Select File" button is pressed.
     * 
     * @param event the ActionEvent instance.
     * @throws IOException if the chosen file could not be opened.
     */
    @FXML
    private void handleSelectFile(ActionEvent event) throws IOException {
        var fileChooser = new FileChooser();
        var file = fileChooser.showOpenDialog(App.getStage());
        if (file != null) {
            var contents = Files.readString(file.toPath());
            codeArea.replaceText(contents);
        }
    }
}
