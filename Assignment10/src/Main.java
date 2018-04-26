import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

	public final static int MOVES = 10;
	private ImageView imageViewDroid, imageViewMaze;
	
	
	public void start(Stage primaryStage) {
	
		Image imgDroid = new Image("robot.png");
		Image imgMaze = new Image("maze.png");
		
		imageViewMaze = new ImageView(imgMaze); 
		imageViewDroid = new ImageView(imgDroid);
		imageViewMaze.setFitWidth(620);
		imageViewMaze.setFitHeight(440);
		imageViewMaze.setPreserveRatio(true);
		//imageViewDroid.setY(260);
		//imageViewDroid.setX(10);
		
		imageViewDroid.setY(170);
		imageViewDroid.setX(429);
		
		/*-----------------------------------------------------*/
		// Obtain PixelReader
		
        PixelReader pixelReader = imgMaze.getPixelReader();
        // Determine the color of each pixel in the image
        for (int readY = 0; readY <imgMaze.getHeight(); readY++) {
            for (int readX = 0; readX <  imgMaze.getWidth(); readX++) {
                Color color = pixelReader.getColor(readX, readY);
                System.out.println("B = " + color.getBlue());

            }
        }
		/*-----------------------------------------------------*/

		Pane root = new Pane(imageViewMaze,imageViewDroid);
		Scene scene = new Scene(root, 620, 440, Color.WHITE);
        scene.setOnKeyPressed(this::processKeyPress);
		primaryStage.setTitle("Alien Direction");
	    primaryStage.setScene(scene);
	    primaryStage.show();
		
	    
	}

	public void processKeyPress(KeyEvent event)
	    {
	        switch (event.getCode())
	        {
	            case UP:
	            	imageViewDroid.setY(imageViewDroid.getY() - MOVES);
	                break;
	            case DOWN:
	            	imageViewDroid.setY(imageViewDroid.getY() + MOVES);
	                break;
	            case RIGHT:
	            	imageViewDroid.setX(imageViewDroid.getX() + MOVES);
	                break;
	            case LEFT:
	            	imageViewDroid.setX(imageViewDroid.getX() - MOVES);
	                break;
	            default:
	                break;  // do nothing if it's not an arrow key
	        }
	    }
    public static void main(String[] args)
    {
        launch(args);
    }

}
