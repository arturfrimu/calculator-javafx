module com.arturfrimu.javafx.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.arturfrimu.javafx.testjavafx to javafx.fxml;
    exports com.arturfrimu.javafx.testjavafx;
}