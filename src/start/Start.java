
package start;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application{
    
    public static void main (String[] args){
        launch (args);
    }
 
    @Override
    public void start (Stage stage) throws IOException{ 
        
        stage.setResizable(false);
        stage.setTitle("Gestor World Data-Base");
        
        Parent root=FXMLLoader.load(getClass().getResource("../view/Start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        stage.show();
    }
}