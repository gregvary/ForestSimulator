package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * 
 * @author Kevin Wolf, Gregor Rydzynski (44354)
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final Group forest = (Group) FXMLLoader.load(getClass().getResource(
					"Forest.fxml"));
			
			Scene scene = new Scene(forest, 1024.0, 768.0, true, 
					SceneAntialiasing.BALANCED);
			ForestController controller = new ForestController(scene);
			
			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent event) {
					if (event.getCode() != KeyCode.SPACE)
						return; 
					
					try {
						final Group tree = (Group) FXMLLoader.load(getClass().getResource(
								"Tree.fxml"));
						Double x  = Math.random() * 200;
						Double z  = Math.random() * 200;
						
						tree.setTranslateX(x);
						tree.setTranslateZ(z);
						
						forest.getChildren().add(tree);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
			primaryStage.setTitle("Forest");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}