 
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.application.Application;  
import javafx.geometry.Point3D;
import javafx.scene.Group;  
import javafx.scene.PerspectiveCamera;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.CullFace;  
import javafx.scene.shape.Sphere;  
import javafx.stage.Stage;  
import javafx.scene.transform.Rotate; 
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.util.Duration;

public class Sphere3D extends Application{  
@Override  
public void start(Stage primaryStage) throws Exception {  
    // TODO Auto-generated method stub  
    //creating the sphere   
    Sphere s = new Sphere();  
  
    //setting the properties for the sphere object  
    s.setRadius(100);  
    s.setTranslateX(200);  
    s.setTranslateY(150);  
    s.setDrawMode(DrawMode.FILL);//setCullFace(CullFace.BACK);  
    //Preparing the phong material of type bump map  
      PhongMaterial material1 = new PhongMaterial();  
      Image img1 = new Image("images/earth_noClouds.0330.jpg");
      material1.setDiffuseMap(img1);  //   setBumpMap(img1);
      
      //Setting the bump map material to Cylinder1 
      s.setMaterial(material1); 
      
    //setting camera   
    PerspectiveCamera camera = new PerspectiveCamera();  
    camera.setTranslateX(-50);  
    camera.setTranslateY(0);  
    camera.setTranslateZ(0);  
    
    /*  // instantiating the Rotate class.   
    Rotate rotate = new Rotate();  
    Point3D p3d = new Point3D(0,150,0);
    
    //setting properties for the rotate object.   
    rotate.setAngle(360);  
    rotate.setPivotX(200);  
    rotate.setPivotY(150);  
    rotate.setAxis(p3d);
    
    s.getTransforms().add(rotate);
    */
    //Instantiating RotateTransition class   
        RotateTransition rotate = new RotateTransition();  
          
        //Setting Axis of rotation   
        rotate.setAxis(Rotate.Y_AXIS);  
          
        // setting the angle of rotation   
        rotate.setByAngle(360);  
          
        //setting cycle count of the rotation   
        rotate.setCycleCount(1);  
          
        //Setting duration of the transition   
        rotate.setDuration(Duration.millis(4000));  
          
       //Setting the cycle count for the transition 
      rotate.setCycleCount(Timeline.INDEFINITE); 
      rotate.setInterpolator(Interpolator.LINEAR); 
        
        //the transition will be auto reversed by setting this to true   
        rotate.setAutoReverse(false);  
              
        //setting Rectangle as the node onto which the   
// transition will be applied  
        rotate.setNode(s);  
          
        //playing the transition   
        rotate.play(); 
    
    
    //setting group and stage   
    Group root = new Group();  
    root.getChildren().addAll(s);  
    Scene scene = new Scene(root,500,300,Color.LIMEGREEN);  
    scene.setCamera(camera);  
    primaryStage.setScene(scene);  
    primaryStage.setTitle("Sphere Example");  
    primaryStage.show();  
}  
public static void main(String[] args) {  
    launch(args);  
}  
}  