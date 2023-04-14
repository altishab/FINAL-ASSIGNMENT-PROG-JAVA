package com.example.mymusicapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.InputStream;
import javafx.util.Callback;
import static java.util.Objects.requireNonNull;

public class Main extends Application {

    @FXML
    private ListView<Song> songListView;
    @FXML
    private ImageView songImageView;
    @FXML
    private TextField addSongTextField;
    @FXML
    private TextField addSongCreatorTextField;
    @FXML
    private TextField addSongDurationTextField;
    @FXML
    private Button addSongButton;
    @FXML
    private ListView<Song> addedSongsListView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(requireNonNull(getClass().getResource("/com/example/mymusicapp/Main.fxml")));
        primaryStage.setTitle("My Music App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void initialize() {

        ObservableList<Song> songs = FXCollections.observableArrayList(
                new Song("Champagne Poetry", "/com/example/mymusicapp/images/Drake1.jpg", "3:25", "Drake"),
                new Song("I Ain't Gonna Lie", "/com/example/mymusicapp/images/Clavish2.jpg", "4:10", "Clavish"),
                new Song("Like This", "/com/example/mymusicapp/images/Clavish1.jpg", "2:45", "Clavish")
        );
        songListView.setItems(songs);

        songListView.setCellFactory(new Callback<ListView<Song>, ListCell<Song>>() {
            @Override
            public ListCell<Song> call(ListView<Song> param) {
                return new ListCell<Song>() {
                    @Override
                    protected void updateItem(Song item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getTitle());
                        }
                    }
                };
            }
        });


        songListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                InputStream imageStream = getClass().getResourceAsStream(newValue.getImagePath());
                songImageView.setImage(new Image(imageStream));
                addSongCreatorTextField.setText(newValue.getCreator());
                addSongDurationTextField.setText(newValue.getDuration());
            }
        });


        addSongButton.setOnAction(event -> {


            String songName = addSongTextField.getText();


            Song newSong = new Song(songName, null, null, null);


            addedSongsListView.getItems().add(newSong);


            addSongTextField.setText("");
        });
    }
}
