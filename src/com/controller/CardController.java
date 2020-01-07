package com.controller;

import com.model.*;
import com.view.Fenetre;

import javax.swing.*;

public class CardController extends Thread {
    public JFrameButtonCards buttonView = null;

    private Moteur model = null;

    public CardController (Moteur model){
        this.model = model;
      /*  buttonView = new JFrameButtonCards(this, model.getSsListeJoueur(model.getIdJoueur()),model.getIdJoueur());
        addListenersToModel();*/
    }

    private void addListenersToModel() {
        model.addCardListener(buttonView);
        model.addPlayerListener(buttonView);
    }

    public void displayView(){
        buttonView.display();
    }

    public void notifyCardChanged(SousListe SsListeJoueur) {
        model.setSsListeJoueur(SsListeJoueur);
    }

    public void notifyIdJoueurChanged(int idj) {
        model.setIdJoueur(idj);
            System.out.println("CardController :: notifyIdJoueurChanged: id :  " + idj);
            model.setSsListeJoueur(model.getSsListeJoueur(idj));

    }

    public void wantRemoveCardChosen(Carte carte){
        model.remove1CardFromSousListe(carte);
    }

    //fonction pour changer l'argent sur le plateau
        //j'ai mis la fonction getGold dans Joueur mais je ne sais pas o� la mettre sinon ?
    /*
    public void showGold(Joueur j, JLabel label){
        label.setText(Integer.toString(j.getGold()));
    }
    */

   @Override
    public void run() {
       try {
           sleep(2000); //pour initialisation
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("controller :: run ");
       buttonView = new JFrameButtonCards(this, model.getSsListeJoueur(model.getIdJoueur()),model.getIdJoueur());
       addListenersToModel();

            while(true){
                displayView();
            }

    }

}
