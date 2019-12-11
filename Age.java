import java.util.ArrayList;


//         CarteRessource cr = (CarteRessource) cartes.get(4);
//         System.out.println("on a "+ cr.type);

public class Age {

    protected ArrayList<Carte> cartes;

    public Age(int ageNumber, Moteur moteur) {
        if(ageNumber==1) {
            cartes = new ArrayList();
            moteur.age1Ini(this.cartes);
        }
    }

    public void test() {

    }
}
