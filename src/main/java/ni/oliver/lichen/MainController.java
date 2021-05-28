package ni.oliver.lichen;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import ni.oliver.lichen.apiclient.LichenClient;
import ni.oliver.lichen.apiclient.Request;
import ni.oliver.lichen.apiclient.Result;

/**
 * The main controller of the application.
 */
public class MainController {
    private static final String INSTRUCTIONS = "This is a simple demo app for the Lichen Code Similarity Analyzer. Simply load in two files and select the language to make the request. The similarity score and matches will be visually displayed in this window.";
    private LichenClient client;

    @FXML
    private Label instructions;

    @FXML
    private ComboBox<String> languageSelect;

    @FXML
    private FilePane filePane1;

    @FXML
    private FilePane filePane2;

    @FXML
    private Label score;

    public MainController() {
        client = new LichenClient();
    }

    @FXML
    private void initialize() {
        instructions.setText(INSTRUCTIONS);
    }

    @FXML
    private void handleRequest(ActionEvent event) throws IOException, InterruptedException {
        var request = new Request(languageSelect.getValue(), List.of(filePane1.getCode(), filePane2.getCode()));
        var result = client.request(request);
        updateUiForResult(result);
    }

    private void updateUiForResult(Result result) {
        score.setText(String.format("Similarity: %.2f", result.getScore()));
        filePane1.updateMatches(result.getMatches().stream().map(m -> m.get(0)).toList());
        filePane2.updateMatches(result.getMatches().stream().map(m -> m.get(1)).toList());
    }
}
