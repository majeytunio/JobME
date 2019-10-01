package pk.jobme.projectmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FXMLController implements Initializable {
    
    @FXML
    private Button sideBarHomeBtn;
    
    @FXML
    private void sideBarHomeBtnMouseEnter(Event evt){
        slideInFromLeft(100, sideBarHomeBtn);
    }
    
    
    
    // Rough
    private double perValue = 0;
    private double perShowingValue = 0;
    @FXML
    private Pane usedStorageBarFill;
    @FXML
    private Label spaceTakenPer;
    @FXML
    private void takeSpaceAction(Event evt){
        perShowingValue++;
        if (perShowingValue < 100) {
            perValue += 2.38;
            usedStorageBarFill.setPrefWidth(perValue);
            spaceTakenPer.setText(perShowingValue + "%");
        }else{
            usedStorageBarFill.setPrefWidth(238);
            spaceTakenPer.setText(100 + "%");
        }
    }
    // Rough
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        spaceTakenPer.setText("0%");
//        usedStorageBarFill.setPrefWidth(0);
    }

    @FXML
    private void slideInFromLeft(double duration, Node node){
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        
        translateTransition.setByX(30);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        
        translateTransition.play();
    }
}
