package ni.oliver.lichen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public final class Utils {

    /**
     * Private constructor to prevent instantiation.
     */
    private Utils() {
        // Do nothing
    }

    /**
     * Loads the FXML file for a component.
     * 
     * @param component the component
     * @return the FXMLLoader instance
     */
    public static FXMLLoader loadFXML(Object component) throws IOException {
        var cls = component.getClass();
        return new FXMLLoader(cls.getResource(String.format("%s.fxml", cls.getSimpleName())));
    }

}
