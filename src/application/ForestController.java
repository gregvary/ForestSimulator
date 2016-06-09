package application;

import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 * 
 * @author Kevin Wolf, Gregor Rydzynski (44354)
 *
 */
public class ForestController {

	private Scene scene;
	private Rotate cameraRotateX = new Rotate(-45.0, Rotate.X_AXIS);
	private Rotate cameraRotateY = new Rotate(0.0, Rotate.Y_AXIS);
	private Rotate cameraRotateZ = new Rotate(0.0, Rotate.Z_AXIS);
	private Translate cameraTranslate = new Translate(100.0, -80.0, -300.0);

	public ForestController(Scene scene) {
		this.scene = scene;
		scene.setCamera(setUpCamera());
		this.scene.setOnScroll(new EventHandler<ScrollEvent>() {

			@Override
			public void handle(ScrollEvent event) {
				scene.getRoot().setRotationAxis(Rotate.X_AXIS);
				scene.getRoot().setRotate(event.getTotalDeltaY());
			}
		});
	}
	
	private final Camera setUpCamera() {
		PerspectiveCamera camera = new PerspectiveCamera(true);
		
		camera.setFieldOfView(45.0);
		camera.setFarClip(900.0);
		camera.getTransforms().addAll(cameraRotateY, cameraRotateX, cameraRotateZ,
				cameraTranslate);
		
		return camera;
	}
	
}
