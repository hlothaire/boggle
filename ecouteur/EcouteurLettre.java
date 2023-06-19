package boggle.ecouteur;

import boggle.model.Boggle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurLettre implements EventHandler<ActionEvent> {

    private int lig;
    private int col;
    private Boggle boggle;

    public EcouteurLettre(int lig, int col, Boggle bog){
        this.lig = lig;
        this.col = col;
        this.boggle = bog;
    }

    @Override
    public void handle(ActionEvent event){
        boggle.ajouterLettre(lig,col);
    }


}
