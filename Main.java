package boggle;

import boggle.model.Boggle;
import boggle.view.PanneauControle;
import boggle.view.VueInfos;
import boggle.view.VueLettres;
import boggle.view.VueListe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Boggle bog = new Boggle(4);
        primaryStage.setTitle("Boggle");
        BorderPane root = new BorderPane();
        root.setCenter(new VueLettres(bog));
        root.setBottom(new VueInfos(bog));
        root.setRight(new PanneauControle(bog));
        root.setLeft(new VueListe(bog));
        primaryStage.setScene(new Scene(root, 1000,700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}