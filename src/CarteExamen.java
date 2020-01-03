import java.util.ArrayList;
//Type 4

public class CarteExamen extends Carte {
    protected int power;

    public CarteExamen(int n_costGold, String n_image, ArrayList n_listeRessource, int power) {
        super(n_costGold, n_image, 4, n_listeRessource);
        this.power = power;
    }
}
