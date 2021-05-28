package ni.oliver.lichen;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

/**
 * Miscellaneous utilities.
 */
public final class Utils {
    /**
     * Private constructor to prevent instantiation.
     */
    private Utils() {
    }

    /**
     * Loads the FXML file for a component.
     * 
     * @param component the component.
     * @return the FXMLLoader instance.
     * @throws IOException if FXML file could not be loaded.
     */
    public static FXMLLoader loadFXML(Object component) throws IOException {
        var cls = component.getClass();
        return new FXMLLoader(cls.getResource(String.format("%s.fxml", cls.getSimpleName())));
    }
}
