package es.ieslosmontecillos.componentes_gomezantonio;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CampoTextoNumerico extends TextField {

    public CampoTextoNumerico() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("campoTextoNumerico.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (!text.matches("[a-z, A-Z]"))
            super.replaceText(start, end, text);
    }

    @Override
    public void replaceSelection(String text) {
        if (!text.matches("[a-z, A-Z]"))
            super.replaceSelection(text);

    }
}
