import java.util.ArrayList;

public class Comptche extends CarteCommerce {
//        protected ArrayList<Integer> listeRessourceConcern;   /*fonctionalité non utilisée*/
        protected int voisinConcern; //1 pour le comptoir O. 2 pour le comptoir E. 3 pour le marché

    public Comptche(int n_costGold, String n_image, ArrayList<Integer> n_listeRessource, /*ArrayList<Integer> listeRessourceConcern,*/ int voisinConcern) {
        super(n_costGold, n_image, n_listeRessource, 2);
//        this.listeRessourceConcern = listeRessourceConcern;
        this.voisinConcern = voisinConcern;
    }
}
