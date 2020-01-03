import java.util.ArrayList;
//Type 2

public class CartePatrimoine extends Carte {
    protected int PV;

    public CartePatrimoine(int n_costGold, String n_image, ArrayList n_listeRessource, int PV) {
        super(n_costGold, n_image, 2, n_listeRessource);
        this.PV = PV;
    }
}
