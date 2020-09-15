import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MoonPath extends Application{
    
   public  Group moonpath;
   public  Group rootmoon; 
   public  Group pmoon;
   
   
 @Override   
public void start(Stage stage) { 
      //Drawing a Circle 
      Circle moon = new Circle(); 
         
      //Setting the properties of the circle 
      moon.setCenterX(200.0f); 
      moon.setCenterY(135.0f); 
      moon.setRadius(2.0f); 
      moon.setStroke(Color.BLACK); // sets the contour of the circle
      moon.setFill(Color.CYAN);
      moon.getStrokeDashArray().addAll(3d); //Makes the line dashed .addAll(0, c)
      
      //Cteate self rotation of planet
      //Creating a rotate transition    
      RotateTransition rotateTransition = new RotateTransition(); 
      
      //Setting the duration for the transition 
      rotateTransition.setDuration(Duration.millis(3000)); 
      
      //Setting the node for the transition 
      rotateTransition.setNode(moon);       
      
      //Setting the angle of the rotation 
      rotateTransition.setByAngle(360); 
      
      //Setting the cycle count for the transition 
      rotateTransition.setCycleCount(Timeline.INDEFINITE); 
      rotateTransition.setInterpolator(Interpolator.LINEAR);
      
      //Setting auto reverse value to false 
      rotateTransition.setAutoReverse(false); 
      
      //Playing the animation 
      rotateTransition.play();
      Group rootmoon = new Group(moon);
   
      
       // Create the Path
        Circle moonpath = new Circle(300.0f, 135.0f, 15.0f);
        moonpath.setFill(null);
        moonpath.setStroke(Color.RED);

      
      
      // Set up a Path Transition for the Planet
        PathTransition moontrans = new PathTransition(Duration.seconds(30), moonpath,rootmoon);
        moontrans.setInterpolator(Interpolator.LINEAR);
        moontrans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        // Let the animation run forever
        moontrans.setCycleCount(Timeline.INDEFINITE); //trans.setCycleCount(FadeTransition.INDEFINITE);
        // Reverse direction on alternating cycles
        moontrans.setAutoReverse(false);
        // Play the Animation
        moontrans.play();
      
          //Creating a Group object  
      Group pmoon = new Group(moonpath,rootmoon);
     // Group moonroot = new Group(moonpath,root_m);
      
      //return moonroot;
      
     // moonroot.getChildren().add(moon);
 
      // moonroot.getChildren().add(moonpath);
        //root.getChildren().add(c_center);
        //Creating a scene object
        Scene scene = new Scene(pmoon, 600, 600);
        //Setting title to the Stage
        //stage.setTitle("Drawing a Planet Path");
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
     
    }


   // public static void main(String args[]){ 
   //   launch(args); 
   //} 
  


 
    public Group getpath_m (){
    
            return moonpath;
    }
    
    
    public Group getroot_m (){
    
            return rootmoon;
    }
    
    public Group getpmoon (){
    
            return pmoon;
    }

}