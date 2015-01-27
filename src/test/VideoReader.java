package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VideoReader extends Application implements javafx.fxml.Initializable {

	@FXML
	private MediaView videoView;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(final Stage stage) throws Exception {
		
		Group root = new Group();
		//Parent root;
		
//		try {
//			root = FXMLLoader.load(getClass().getResource("Fenetre-test.fxml"));
//		} catch (IOException e) {
//			e.printStackTrace();
//			return;
//		}

		String trailer = getHostServices().getDocumentBase()+"res/Trojans.mp4";
        Media media = new Media(trailer);
        final MediaPlayer player = new MediaPlayer(media);
        MediaView videoView = new MediaView();
       // videoView.setMediaPlayer(player);
       // videoView.autosize();
        root.getChildren().add(videoView);
        
        
        
        
        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Movie Player");
        
        player.play();
        
		player.setOnReady(new Runnable() {
            @Override
            public void run() {
            	int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();
                stage.setMinWidth(w);
                stage.setMinHeight(h);
            }
        });
	}
	
	public static void main(String[] args) {
        launch();
    }

}
