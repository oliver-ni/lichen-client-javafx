module ni.oliver.lichen {
    requires java.net.http;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires org.fxmisc.richtext;
    requires com.google.gson;

    opens ni.oliver.lichen to javafx.fxml;
    opens ni.oliver.lichen.apiclient to com.google.gson, java.net.http;

    exports ni.oliver.lichen;
}
