module ni.oliver.lichen {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive org.fxmisc.richtext;

    opens ni.oliver.lichen to javafx.fxml;

    exports ni.oliver.lichen;
}
