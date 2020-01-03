import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeMap.size;

public class Plateau {

    protected char image;
    protected int ressource;
    protected String imageRessource;
    protected ArrayList<CarteRessource> listeRessource;

    public Plateau(char n_image, int n_ressource, String n_imageRessource) {
        this.image=n_image;
        this.imageRessource=n_imageRessource;
        this.ressource=n_ressource;
        this.listeRessource = new ArrayList<CarteRessource>();
    }

    public void afficherCarte(int type) {
    }

    public void updateListe(CarteRessource carteR) {
        this.listeRessource.add(carteR);
    }

}
