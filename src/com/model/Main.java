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

        System.out.println(" Main ok ");

        Moteur moteur1 = new Moteur(1);
       /* moteur1.setName("moteur");
        moteur1.start();*/
        CardController controller  = new CardController(moteur1);
        //controller.start();
        controller.displayView();




    }
}
