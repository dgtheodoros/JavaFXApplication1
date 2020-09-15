
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetPath extends Application{
@Override
public void start(Stage stage) { 
      //Drawing a Circle 
      Circle circle = new Circle(); 
         
      //Setting the properties of the circle 
      circle.setCenterX(300.0f); 
      circle.setCenterY(135.0f); 
      circle.setRadius(10.0f); 
      circle.setStroke(Color.BLACK); // sets the contour of the circle
      circle.setFill(Color.BEIGE);
      circle.getStrokeDashArray().addAll(3d); //Makes the line dashed .addAll(0, c)
      
      //Cteate self rotation of planet
      //Creating a rotate transition    
      RotateTransition rotateTransition = new RotateTransition(); 
      
      //Setting the duration for the transition 
      rotateTransition.setDuration(Duration.millis(3000)); 
      
      //Setting the node for the transition 
      rotateTransition.setNode(circle);       
      
      //Setting the angle of the rotation 
      rotateTransition.setByAngle(360); 
      
      //Setting the cycle count for the transition 
      rotateTransition.setCycleCount(Timeline.INDEFINITE); 
      rotateTransition.setInterpolator(Interpolator.LINEAR);
      
      //Setting auto reverse value to false 
      rotateTransition.setAutoReverse(false); 
      
      //Playing the animation 
      rotateTransition.play();
      
      
      Group root_c = new Group(circle);
      
   
      
       // Create the Path
        Circle path = new Circle(300, 300, 150);
        path.setFill(null);
        path.setStroke(Color.RED);
       
     
      
      // Set up a Path Transition for the Planet
        PathTransition trans = new PathTransition(Duration.seconds(30),path,root_c);
        trans.setInterpolator(Interpolator.LINEAR);
        trans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        // Let the animation run forever
        trans.setCycleCount(Timeline.INDEFINITE); //trans.setCycleCount(FadeTransition.INDEFINITE);
        // Reverse direction on alternating cycles
        trans.setAutoReverse(false);
        // Play the Animation
        trans.play();
      
    
     
   
      Group root = new Group(path,root_c);
     // root.getChildren().add(root_c);
     // root.getChildren().add(path);
     
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 600);  
      //Setting title to the Stage 
      stage.setTitle("Drawing a Planet Path"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show();
}
  
public static void main(String args[]){ 
       
      launch(args); 
      
   } 
  
}
