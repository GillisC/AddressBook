
package addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import se.chalmers.cse.dat215.lab1.Model;

import java.util.ResourceBundle;

public class AddressBook extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ResourceBundle bundle = java.util.ResourceBundle.getBundle("addressbook/resources/AddressBook");
        
        Parent root = FXMLLoader.load(getClass().getResource("address_book.fxml"), bundle);
        
        Scene scene = new Scene(root, 600, 400);
        
        stage.setTitle(bundle.getString("application.name"));
        stage.setScene(scene);
        stage.getIcons().add(new Image("addressbook/resources/frameIcon32.gif"));
        stage.show();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> Model.getInstance().shutDown()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
