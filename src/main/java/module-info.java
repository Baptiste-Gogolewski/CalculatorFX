module src.calculatorfx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens src.calculatorfx to javafx.fxml;
    exports src.calculatorfx;
}