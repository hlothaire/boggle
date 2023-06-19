package boggle.view;

import boggle.Observateur;
import boggle.model.Boggle;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

public class VueInfos extends TilePane implements Observateur {

    private Label score, motChoisi;
    private Boggle boggle;

    public VueInfos(Boggle bog){
        super();
        this.boggle = bog ;
        this.score = new Label("score : " + Integer.toString(this.boggle.getScore()));
        this.score.setFont(new Font("Arial",24));
        this.motChoisi = new Label("mot choisi : "+ this.boggle.getMotChoisi());
        this.motChoisi.setFont(new Font("Arial",24));
        this.getChildren().addAll(this.motChoisi,this.score);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.boggle.ajouterObservateur(this);
    }


    public void reagir(){
        this.score.setText("score : " + Integer.toString(this.boggle.getScore()));
        this.motChoisi.setText("mot choisi :"+ this.boggle.getMotChoisi());
    }
}
