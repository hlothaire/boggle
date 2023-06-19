package boggle.view;

import boggle.Observateur;
import boggle.model.Boggle;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VueListe extends VBox implements Observateur {

    private Label liste;
    private Boggle boggle;


    public VueListe(Boggle bog){
        super();
        this.boggle = bog;
        this.liste = new Label();
        this.liste.setFont(new Font("Arial", 15));
        this.liste.setWrapText(true);
        this.getChildren().addAll(this.liste);
        this.setAlignment(Pos.CENTER_LEFT);
        this.boggle.ajouterObservateur(this);
    }

    public void reagir(){
        if(this.boggle.getValid() == 1) {
            this.liste.setText(this.liste.getText() + this.boggle.getMotValid() + "\n");
            this.boggle.resetMotValid();
        }
    }
}
