package es.ieslosmontecillos.componentes_gomezantonio;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;

public class Temporizador extends AnchorPane {
    @FXML
    private Label lblEnun;
    @FXML
    private Label segLeft;
    @FXML
    private Label lblSeg;
    private boolean autoReverse;
    private IntegerProperty segundos;
    private Timeline temporizador;
    private EventHandler<ActionEvent> onFinished;

    public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        segundos = new SimpleIntegerProperty();

        segundos.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue.toString());
                segLeft.setText(newValue.toString());
            }

        });

    }
    public void play(){
        temporizador = new Timeline();
        temporizador.setAutoReverse(false);
        final KeyValue kvTemp = new KeyValue(segundos, 0);
        final KeyFrame kfTemp = new KeyFrame(Duration.seconds(segundos.doubleValue()), onFinished, kvTemp);
        temporizador.getKeyFrames().add(kfTemp);
        temporizador.play();
    }
    public void setOnFinished(EventHandler<ActionEvent> onFinished) {
        this.onFinished = onFinished;
    }
    public final ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
        return (ObjectProperty<EventHandler<ActionEvent>>) onFinished;
    }
    public final EventHandler<ActionEvent> getOnFinished() {
        return onFinishedProperty().get();
    }

    public int getSegundos() {
        return segundos.get();
    }

    public IntegerProperty segundosProperty() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos.set(segundos);
    }

    public boolean isAutoReverse() {
        return autoReverse;
    }

    public void setAutoReverse(boolean autoReverse) {
        this.autoReverse = autoReverse;
        temporizador.setAutoReverse(autoReverse);
    }

}
