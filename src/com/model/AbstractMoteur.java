package com.model;

import com.observer.Observable;
import com.observer.Observer;

import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeMap.size;

public abstract class AbstractMoteur implements Observable{

    private ArrayList<Observer> listObserver = new ArrayList<Observer>();

    protected ArrayList<Joueur> listeJoueur;


    public void run() {};

    public void iniAge() {};

    public void assignAge(ArrayList list) {};

    public void rotation() {};
    public void applyPower() {};
    public void comparPower (Joueur joueur1, Joueur joueur2) {};

    public void affichage() {};

    public void age1Ini(ArrayList list) {};
    public void age2Ini(ArrayList list) {};
    public void shuffle(ArrayList liste){};
    public void play(ArrayList<Carte> listCarte, int carteN, Joueur joueur) {};

    //Implémentation du pattern observer
   /**public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    public void notifyObserver(ArrayList Card) {
        for(Observer obs : listObserver)
            obs.update(str);
    }

    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }
*/
}
