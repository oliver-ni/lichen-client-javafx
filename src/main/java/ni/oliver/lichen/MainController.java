package ni.oliver.lichen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * The main controller of the application.
 */
public class MainController {
    private static final String INSTRUCTIONS = "This is a simple demo app for the Lichen Code Similarity Analyzer. Simply load in two files and select the language to make the request. The similarity score and matches will be visually displayed in this window.";

    @FXML
    private Label instructions;

    @FXML
    private ComboBox<String> languageSelect;

    @FXML
    private void initialize() {
        instructions.setText(INSTRUCTIONS);
    }

    @FXML
    private void handleRequest(ActionEvent event) {

    }
}
