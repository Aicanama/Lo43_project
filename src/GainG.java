import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeSet.size;

public class GainG extends CarteCommerce {
    protected int gold;
    protected int type;

    public GainG(int n_costGold, String n_image, ArrayList<Integer> n_listeRessource, int type) {
        super(n_costGold, n_image, n_listeRessource, 1);
        this.type = type;
        this.gold=0;
    }

    public void calculGold(int type, ArrayList<Joueur> joueur, int id) {
        switch (type) {
            case 0:
                this.gold=5;
                break;
            case 1:
                int p, s;
                switch(joueur.get(id).id) { //défini quels sont les voisins du joueur
                    case 0:
                        p=3;
                        s=1;
                        break;
                    case 3:
                        s=0;
                        p=2;
                        break;
                    default:
                        p=id-1;
                        s=id+1;
                }
                this.gold=size(joueur.get(id).plateau.listeRessource)+size(joueur.get(s).plateau.listeRessource)+size(joueur.get(p).plateau.listeRessource);
        }
    }
}
