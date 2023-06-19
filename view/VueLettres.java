package boggle.view;

import boggle.Observateur;
import boggle.ecouteur.EcouteurLettre;
import boggle.model.Boggle;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class VueLettres extends GridPane implements Observateur {

    private Button[][] carres ;
    private Boggle boggle;

    public VueLettres(Boggle bog){
        super();
        this.boggle = bog;
        this.carres = new Button[4][4];
        for(int i =0;i<4;i++) {
            for (int j = 0; j<4;j++) {
                this.carres[i][j] = new Button();
                String lettres = Character.toString(this.boggle.getLettre(i,j));
                this.carres[i][j].setText(lettres);
                this.carres[i][j].setPrefSize(90,90);
                this.carres[i][j].setOnAction(new EcouteurLettre(i,j,this.boggle));
                GridPane.setConstraints(this.carres[i][j], i, j);
                this.getChildren().add(this.carres[i][j]);
            }
        }
        this.setAlignment(Pos.CENTER);
        this.boggle.ajouterObservateur(this);
    }



    public void reagir(){}
}
