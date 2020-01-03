package com.model;

import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeMap.size;

public class PVGold extends CarteCommerce {
    int PV;
    int gold;

    public PVGold(int n_costGold, String n_image, ArrayList<CarteRessource> n_listeRessource) {
        super(n_costGold, n_image, n_listeRessource, 3);
        this.PV=0;
        this.gold=0;
    }

    public void calculPvGold(Joueur joueur) {
        int x=0;
        for(int i=0; i<size(joueur.plateau.listeRessource); ++i) {
            if(joueur.plateau.listeRessource.get(i).type==4 || joueur.plateau.listeRessource.get(i).type==5 || joueur.plateau.listeRessource.get(i).type==6) {
                ++x;
            }
        }
        this.PV = x;
        this.gold = x;
    }
}
