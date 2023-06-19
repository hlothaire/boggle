package boggle.ecouteur;

import boggle.model.Boggle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurEffacer implements EventHandler<ActionEvent> {

    private Boggle boggle;

    public EcouteurEffacer(Boggle bog){
        this.boggle = bog;
    }

    @Override
    public void handle(ActionEvent event){
        boggle.effacer();
    }


}
