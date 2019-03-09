import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void sceneInitializer(Stage stage, String resource) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(resource));
        Scene mainScene = new Scene(root, 875, 410);
        stage.setTitle("Matlab Calc");
        stage.setScene(mainScene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        sceneInitializer(primaryStage, "/view/app.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
