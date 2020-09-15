import javafx.animation.RotateTransition;
import javafx.application.Application; 
import static javafx.application.Application.launch;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.shape.Polyline;
import javafx.util.Duration;


public class PolylineHexagon extends Application {  
   @Override 
   public void start(Stage stage) {        
      //Creating a polyline 
      Polyline polyline = new Polyline();  
       
      //Adding coordinates to the polygon 
      polyline.getPoints().addAll(new Double[]{        
         200.0, 50.0, 
         400.0, 50.0, 
         450.0, 150.0,          
         400.0, 250.0, 
         200.0, 250.0,                   
         150.0, 150.0, 
         200.0, 50.0,
      }); 
        
      
      
      //Creating a Group object  
      Group root = new Group(polyline); 
         
      //Creating a rotate transition    
      RotateTransition rotateTransition = new RotateTransition(); 
      
      //Setting the duration for the transition 
      rotateTransition.setDuration(Duration.millis(1000)); 
      
      //Setting the node for the transition 
      rotateTransition.setNode(polyline);       
      
      //Setting the angle of the rotation 
      rotateTransition.setByAngle(360); 
      
      //Setting the cycle count for the transition 
      rotateTransition.setCycleCount(50); 
      
      //Setting auto reverse value to false 
      rotateTransition.setAutoReverse(false); 
      
      //Playing the animation 
      rotateTransition.play(); 
         
       
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);   
      
      //Setting title to the Stage 
      stage.setTitle("Rotate  hexagon polyline transition example "); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
} 