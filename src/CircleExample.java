import javafx.animation.RotateTransition;
import javafx.application.Application; 
import javafx.beans.property.ObjectProperty;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage; 
import javafx.scene.shape.Circle; 
import javafx.util.Duration;
         
public class CircleExample extends Application { 
   @Override 
   public void start(Stage stage) { 
      //Drawing a Circle 
      Circle circle = new Circle(); 
         
      //Setting the properties of the circle 
      circle.setCenterX(300.0f); 
      circle.setCenterY(135.0f); 
      circle.setRadius(100.0f); 
      circle.setStroke(Color.BLACK); // sets the contour of the circle
      circle.setFill(Color.BEIGE);
      circle.getStrokeDashArray().addAll(50d, 40d); //Makes the line dashed .addAll(0, c)
      
      
      //Creating a rotate transition    
      RotateTransition rotateTransition = new RotateTransition(); 
      
      //Setting the duration for the transition 
      rotateTransition.setDuration(Duration.millis(1000)); 
      
      //Setting the node for the transition 
      rotateTransition.setNode(circle);       
      
      //Setting the angle of the rotation 
      rotateTransition.setByAngle(360); 
      
      //Setting the cycle count for the transition 
      rotateTransition.setCycleCount(50); 
      
      //Setting auto reverse value to false 
      rotateTransition.setAutoReverse(false); 
      
      //Playing the animation 
      rotateTransition.play(); 
      
      
      //Creating a Group object  
      Group root = new Group(circle); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      //Setting title to the Stage 
      stage.setTitle("Drawing a Circle"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show();
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}       