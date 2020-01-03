import java.util.ArrayList;

public class Carte {

    protected int costGold;
    protected String image;
    protected int carteType;
    protected ArrayList<Integer> listeRessource;

    public Carte() {
        this.image="a";
        this.costGold=0;
        this.carteType=0;
        this.listeRessource=new ArrayList<Integer>();
    }
    public Carte(int n_costGold, String n_image, int n_carteType, ArrayList<Integer> n_listeRessource) {
        this.costGold=n_costGold;
        this.image=n_image;
        this.carteType=n_carteType;
        this.listeRessource=n_listeRessource;
    }
}
