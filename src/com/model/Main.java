package com.model;

/* Types de ressource :
 - brique = cerveau = 0
 - pierre = ordi = 1
 - bois = pizza = 2
 - or = choppe = 3
 - papyrus = livre = 4
 - tissu = moodle = 5
 - verre = puzzle = 6*/

import com.controller.CardController;
import com.view.Fenetre;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Moteur moteur = new Moteur(1);
        Age age = new Age(1);
        moteur.age1Ini(age.cartes); //création du tas de l'âge
        //moteur.shuffle(age.cartes);

        //creation accès cartes d'un joueur
        SousListe ssListeJoueur1 = new SousListe(age.cartes,0); //sous liste joueur1
        SousListe  ssListeJoueur2 = new SousListe(age.cartes,1); //sous liste joueur2
        ArrayList<Joueur> listJoueur = new ArrayList<Joueur>();

        listJoueur.add( new Joueur(0,null,ssListeJoueur1));
        listJoueur.add( new Joueur(1,null,ssListeJoueur2));

        //listJoueur.get(0).showSousListe();
        System.out.println(" Main :: arraylist Joueur : " + listJoueur.get(0).sousListe.cartes.get(2).image );
        /* meme facon d'arriver aux cartes du joueur 0 avoir la 2ème carte
        listJoueur.get(0).sousListe.cartes.get(2).costGold
        = age.cartes.get(2).costGold
        = ssListeJoueur1.cartes.get(2).costGold
        */




        Moteur moteur1 = new Moteur(1,ssListeJoueur1);
        //moteur1.age1Ini(age.cartes);
        CardController controller  = new CardController(moteur1);
        controller.displayView();




    }
}
