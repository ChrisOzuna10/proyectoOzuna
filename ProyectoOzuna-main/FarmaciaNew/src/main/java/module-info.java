module com.ozuna.farmacianew {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.ozuna.farmacianew to javafx.fxml;
    exports com.ozuna.farmacianew;
    exports com.ozuna.farmacianew.controllers;
    opens com.ozuna.farmacianew.controllers to javafx.fxml;
}