import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeMap.size;

public class Joueur {

    protected int id;
    protected Plateau plateau;
    protected SousListe sousListe;
    protected int gold;
    protected int PV;
    protected int math1;
    protected int anglais2;
    protected int info3;
    protected boolean comptoirE;
    protected boolean comptoirO;;
    protected boolean marche;
    protected int power;

    public Joueur(int n_id, Plateau n_plateau, SousListe n_sousListe) {
        this.id=n_id;
        this.plateau=n_plateau;
        this.sousListe=n_sousListe;
        this.gold=3;
        this.PV=0;
        this.math1=0;
        this.anglais2=0;
        this.info3=0;
        this.comptoirE=false;
        this.comptoirO=false;
        this.marche=false;
        this.power=0;
    }

    public void showSousListe() {

    }

    public void hideSousListe() {

    }

    public int parcourir(ArrayList<Integer> checkList, ArrayList<CarteRessource> listeRessourceAC) {    //changer type des listeRessource
        int costp=0, j, i=0;
        ArrayList<CarteRessource> listeRessource = listeRessourceAC;
        while(i<size(checkList)){
            j=0;
            while(j<size(listeRessource)) {
                if (checkList.get(i) == listeRessource.get(j).type || checkList.get(i) == listeRessource.get(j).type2) {
                    checkList.remove(i);
                    costp=+2;
                    listeRessource.remove(j);
                    j = size(listeRessource); //Stop la boucle
                    --i; //puisque la valeur (i) a été retirée, on ne veut pas changer l'indice
                }
            }
            ++i;
        }
        return costp;
    }

    //checkPlay renvoie false si une carte est injouable
    //Si elle est jouable, en plus de renvoyer true
    //la fonction fait les échanges d'argent entre les joueurs
    //la fonction play ne devrait donc s'occuper que de jouer la carte
    public boolean checkPlay(ArrayList<Joueur> joueur, int id, Carte carte) { //vérifie la jouabilité d'une carte et fait les achats
        int cost=0, p=0, s=0;
        int prixp=0, prixs=0;
        ArrayList listC = carte.listeRessource;
        if(size(listC)!=0){
            parcourir(listC,joueur.get(id).plateau.listeRessource);
        }
        if(size(listC)!=0) {
            switch(id) { //défini quels sont les voisins du joueur
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
            if(joueur.get(id).comptoirO) {
                prixp =parcourir(listC, joueur.get(p).plateau.listeRessource) / 2; //On applique les effets du comptoirO
                prixs =parcourir(listC, joueur.get(s).plateau.listeRessource);
                if(joueur.get(id).marche || joueur.get(id).comptoirE) {
                    prixs = prixs / 2;
                }
                cost = prixs + prixp;
            }
            else {
                prixs = parcourir(listC, joueur.get(s).plateau.listeRessource);
                if (joueur.get(id).comptoirE || joueur.get(id).marche) {
                    prixs = prixs / 2;
                }
                prixp = parcourir(listC, joueur.get(p).plateau.listeRessource);
                if (joueur.get(id).marche) {
                    prixp = prixp / 2;
                }
                cost = prixs + prixp;
            }
        }
        if(size(listC)!=0 || joueur.get(id).gold < cost) {
            return false;
        }
        else {
            joueur.get(id).gold =- cost;
            joueur.get(p).gold =+ prixp;
            joueur.get(s).gold =+ prixs;
            return true;
        }
    }

    public void changeGold(int change) {
        this.gold=this.gold+change;
    }

    public void changePV(int change) {
        this.PV=this.PV+change;
    }

    public void changeConnaissance(int type) {
        switch(type) {
            case 1:
                this.math1++;
                break;
            case 2:
                this.anglais2++;
                break;
            case 3:
                this.info3++;
                break;
            default:
        }
    }

    public void changePower(int power) {
        this.power=this.power+power;
    }

    public void changeCompt(int voisinConcern) {
        switch (voisinConcern) {
            case 1:
                this.comptoirO = true;
                break;
            case 2:
                this.comptoirE = true;
                break;
            case 3:
                this.marche = true;
                break;
            default:
        }
    }
}
