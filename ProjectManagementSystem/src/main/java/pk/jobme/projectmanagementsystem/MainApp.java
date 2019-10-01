package pk.jobme.projectmanagementsystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApp extends Application {
    
    Stage finalStage;
    
    double mouseX = 0;
    double mouseY = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        finalStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        finalStage.setTitle("JobME Project Manager");
        finalStage.initStyle(StageStyle.UNDECORATED);
        finalStage.initStyle(StageStyle.TRANSPARENT);
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        
        finalStage.setWidth(primaryScreenBounds.getWidth() - (primaryScreenBounds.getWidth() / 10));
        finalStage.setHeight(primaryScreenBounds.getHeight()- (primaryScreenBounds.getHeight() / 14));
        
        scene.setFill(Color.TRANSPARENT);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mouseX = event.getX();
                mouseY = event.getY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double posX = event.getScreenX() - mouseX;
                double posY = event.getScreenY() - mouseY;
                
                finalStage.setX(posX);
                finalStage.setY(posY);
            }
        });
        
        finalStage.setScene(scene);
        finalStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
