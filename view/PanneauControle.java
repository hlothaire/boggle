package boggle.view;

import boggle.Observateur;
import boggle.ecouteur.EcouteurEffacer;
import boggle.ecouteur.EcouteurQuitter;
import boggle.ecouteur.EcouteurValider;
import boggle.model.Boggle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PanneauControle extends VBox implements Observateur {
    private Button valider ;
    private Button effacer ;
    private Button quitter ;
    private Boggle boggle;

    public PanneauControle(Boggle bog){
        super();
        this.boggle = bog;
        this.valider = new Button("Valider");
        this.valider.setOnAction(new EcouteurValider(this.boggle));
        this.effacer = new Button("Effacer");
        this.effacer.setOnAction(new EcouteurEffacer(this.boggle));
        this.quitter = new Button("Quitter");
        this.quitter.setOnAction(new EcouteurQuitter());
        this.getChildren().addAll(this.valider, this.effacer, this.quitter);
        this.setAlignment(Pos.CENTER_RIGHT);
        this.boggle.ajouterObservateur(this);
    }

    public void reagir(){}
}
