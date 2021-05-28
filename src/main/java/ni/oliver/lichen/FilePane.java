package ni.oliver.lichen;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * A file pane component with a simple code editor, and utilities to load files.
 */
public class FilePane extends VBox {
    @FXML
    private CodeArea codeArea;

    @FXML
    private Label label;

    @FXML
    private Label pathLabel;

    /**
     * Constructs a file pane with the given label text.
     * 
     * @param labelText the contents of the label.
     * @throws IOException if FXML file could not be loaded.
     */
    public FilePane(@NamedArg("labelText") String labelText) throws IOException {
        var loader = Utils.loadFXML(this);
        loader.setRoot(this);
        loader.setController(this);
        loader.load();

        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        label.setText(labelText);
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
            pathLabel.setText(file.getName());
        }
    }

    /**
     * Retrieves the code entered in the file pane.
     * 
     * @return the code.
     */
    public String getCode() {
        return codeArea.getText();
    }

    /**
     * Updates the UI, highlighting the given matches.
     * 
     * @param entries the list of positions (start and end) to highlight.
     */
    public void updateMatches(List<List<Integer>> entries) {
        entries = entries.stream().sorted((a, b) -> Integer.compare(a.get(1), b.get(1))).toList();

        var spansBuilder = new StyleSpansBuilder<Collection<String>>();
        var last = 0;
        for (var entry : entries) {
            var start = entry.get(0);
            var end = entry.get(1);
            spansBuilder.add(Collections.emptyList(), start - last);
            spansBuilder.add(Collections.singleton("match"), end - start);
            last = end;
        }

        codeArea.setStyleSpans(0, spansBuilder.create());
    }
}
