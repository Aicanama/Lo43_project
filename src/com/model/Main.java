package com.model;

/* Types de ressource :
 - brique = cerveau = 0
 - pierre = ordi = 1
 - bois = pizza = 2
 - or = choppe = 3
 - papyrus = livre = 4
 - tissu = moodle = 5
 - verre = puzzle = 6*/

public class Main {
    public static void main(String[] args) {
        Moteur moteur = new Moteur(1);
        Age age = new Age(1, moteur);
        moteur.shuffle(age.cartes);
        SousListe sliste = new SousListe(age.cartes, 0);
        System.out.println("test");
    }
}
