import java.lang.reflect.Array;
import java.util.ArrayList;

public class SousListe {

    protected ArrayList<Carte> cartes;

    public SousListe(ArrayList liste, int idJoueur) {   //idJoueur est une variable qui devrait être comprise entre 0 et 3
        this.cartes = new ArrayList();                  //Donc potentiellement, faut faire '-1' à l'id
        for(int i = 7*idJoueur; i<7*idJoueur+7;++i) {
            this.cartes.add((Carte) liste.get(i));
        }
    }

}
