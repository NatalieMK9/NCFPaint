module hellofx {
    requires javafx.controls;
    requires java.desktop;
    requires javafx.swing;

    opens sample to javafx.graphics;

}