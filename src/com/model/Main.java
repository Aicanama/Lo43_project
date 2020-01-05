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
        //Age age = new Age(1);
        //moteur.age1Ini(age.cartes); //création du tas de l'âge
        //moteur.shuffle(age.cartes);

        System.out.println(" Main ok ");
        /* meme facon d'arriver aux cartes du joueur 1 avoir la 2ème carte
        listJoueur.get(0).sousListe.cartes.get(2).costGold
        = age.cartes.get(2).costGold
        = ssListeJoueur1.cartes.get(2).costGold
        */




        Moteur moteur1 = new Moteur(1);
        CardController controller  = new CardController(moteur1);
        controller.displayView();




    }
}
