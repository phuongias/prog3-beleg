import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiDekoMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/DekoGui/DekoGui.fxml")); //https://stackoverflow.com/questions/50865133/communication-between-controller-and-main-class-in-javafx

        primaryStage.setTitle("Kuchenautomat");
        primaryStage.setScene(new Scene(root, 900, 570));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
