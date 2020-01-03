package com.model;

import com.observer.CardChangedEvent;
import com.observer.CardListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static jdk.nashorn.internal.objects.NativeMap.size;


public class Moteur{
    //le modèle

    private int ageActuel;
    private ImageIcon Imgcarte;
    private URL urlCarte = getClass().getResource("img/1Carte.png");
    private Age age;

    protected ArrayList<Joueur> listeJoueur;

    private EventListenerList listeners;

    public Moteur(int n_id) {
        this.ageActuel = n_id;


        //mise en place Image des cartes cartes
        try {
            Imgcarte = new ImageIcon(ImageIO.read(urlCarte));
        } catch (IOException e) {
            e.printStackTrace();
        }

        age = new Age(1);

        listeners = new EventListenerList();

        SousListe sousListeJoueur = new SousListe(listeJoueur,1); //sous liste par age
    }

    public void age1Ini(ArrayList list) {
        //le type 7 ne correspond à aucune ressource
        //Il est présent pour combler type2 lorsque la carte n'a qu'une ressource
        ArrayList<Integer> r0 = new ArrayList<Integer>();
        ArrayList<Integer> r1 = new ArrayList<Integer>();
        ArrayList<Integer> r2 = new ArrayList<Integer>();
        ArrayList<Integer> r3 = new ArrayList<Integer>();
        ArrayList<Integer> r4 = new ArrayList<Integer>();
        ArrayList<Integer> r5 = new ArrayList<Integer>();
        ArrayList<Integer> r6 = new ArrayList<Integer>();
        r0.add(0);
        r1.add(1);
        r2.add(2);
        r3.add(3);
        r4.add(4);
        r5.add(5);
        r6.add(6);

        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 2, 7, 1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 2, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 1, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 0, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 3, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 3, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 4, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 5, 7,1));
        list.add(new CarteRessource(0, Imgcarte, new ArrayList<Integer>(), 6, 7,1));
        list.add(new CarteRessource(1, Imgcarte, new ArrayList<Integer>(), 2, 1,1));
        list.add(new CarteRessource(1, Imgcarte, new ArrayList<Integer>(), 1, 0,1));
        list.add(new CarteRessource(1, Imgcarte, new ArrayList<Integer>(), 0, 3,1));

        list.add(new CartePatrimoine(0,Imgcarte,new ArrayList<Integer>(),3));
        list.add(new CartePatrimoine(0,Imgcarte,new ArrayList<Integer>(),2));
        list.add(new CartePatrimoine(0,Imgcarte,new ArrayList<Integer>(),2));
        list.add(new CartePatrimoine(0,Imgcarte,r1,3));

        list.add(new CarteExamen(0,Imgcarte,r2,1));
        list.add(new CarteExamen(0,Imgcarte,r0,1));
        list.add(new CarteExamen(0,Imgcarte,r0,1));
        list.add(new CarteExamen(0,Imgcarte,r3,1));

        list.add(new CarteConnaissance(0,Imgcarte,r5,1));
        list.add(new CarteConnaissance(0,Imgcarte,r6,3));
        list.add(new CarteConnaissance(0,Imgcarte,r4,2));
        list.add(new CarteConnaissance(0,Imgcarte,r4,2));

       /* list.add(new GainG(0,Imgcarte,new ArrayList<Integer>(),0));
        list.add(new Comptche(0,Imgcarte,new ArrayList<Integer>(),1));
        list.add(new Comptche(0,Imgcarte,new ArrayList<Integer>(),2));
        list.add(new Comptche(0,Imgcarte,new ArrayList<Integer>(),3));*/
    }


    public void shuffle(ArrayList liste) {
        Collections.shuffle(liste);
    }

    public SousListe getSsListeJoueur() {
        return listeJoueur;
    }

    public void setSsListeJoueur(SousListe ssListeJoueur) {
        this.listeJoueur = ssListeJoueur;

        fireCardChanged();
    }


    /// Les méthodes gérant les vues sous forme de listener :
    public void addCardListener(CardListener listener) {
        //enregistre une vue pour quelle soit avertie des changements
        listeners.add(CardListener.class, listener);
    }

    public void removeCardListener(CardListener l) {
        //dés-enregistre une vue
        listeners.remove(CardListener.class, l);
    }

    public void fireCardChanged() {
        CardListener[] listenerList = (CardListener[]) listeners.getListeners(CardListener.class);

        for (CardListener listener : listenerList) {
            listener.cardChangedRound(new CardChangedEvent(this, getSsListeJoueur()));
        }
    }


    //Léo

    public void gameStart() { //Fonction à finir
//        Ini joueur
        for (int i = 0; i < 3; ++i) {
            iniAge();
            //ini liste joueur
            while (size(this.listeJoueur.get(0).sousListe.cartes) != 0) {
                for (int j = 0; j < 4; ++j) {
                    //propose carte
                }
                //joue (fonction play à appeler avec la carte select)
                this.rotation();
            }
            this.applyPower();
            this.ageActuel = this.ageActuel + 1;
        }
        this.affichage();
    }

    public void iniAge() {
        ArrayList<Carte> carteList = new ArrayList<Carte>();
        switch (this.ageActuel) {
            case 1:
                age1Ini(carteList);
                break;
            case 2:
                //age2Ini(carteList);
                break;
            case 3:
                //age3Ini(carteList);
                break;
            default:
                System.out.println("age inconnu");
        }
    }

    public void assignAge(ArrayList list) {
        this.shuffle(list);
        for (int i = 0; i < 4; ++i) {
            this.listeJoueur.get(i).sousListe = new SousListe(list, i);
        }
    }

    public void rotation() {
        SousListe stock = this.listeJoueur.get(0).sousListe;
        for (int i = 0; i < 3; ++i) {
            this.listeJoueur.get(i).sousListe = this.listeJoueur.get(i + 1).sousListe;
        }
        this.listeJoueur.get(4).sousListe = stock;
    }

    public void applyPower() {
        for (int i = 0; i < 4; ++i) {
            if (i != 0) {
                comparPower(this.listeJoueur.get(i), this.listeJoueur.get(i - 1));
            } else {
                comparPower(this.listeJoueur.get(0), this.listeJoueur.get(4));
            }
        }
    }

    public void comparPower(Joueur joueur1, Joueur joueur2) {
        if (joueur1.power != joueur2.power) {
            if (joueur1.power > joueur2.power) {
                joueur1.changePV((this.ageActuel - 1) * 2 + 1);
                joueur2.changePV(-1);
            } else {
                joueur2.changePV((this.ageActuel - 1) * 2 + 1);
                joueur1.changePV(-1);
            }
        }
    }


    public void affichage() {
        for (int i = 0; i < 4; ++i) {
            System.out.println("score du joueur " + i + " : " + calculPV(this.listeJoueur.get(i)));
        }
    }


    public void play(ArrayList<Carte> listCarte, int carteN, Joueur joueur) {
        Carte carte = listCarte.get(carteN);
        if (joueur.checkPlay(this.listeJoueur, joueur.id, carte)) {
            switch (carte.carteType) {
                case 1: //carte ressource
                    CarteRessource CR = (CarteRessource) carte;
                    joueur.plateau.listeRessource.add(CR);
                    System.out.println("carte ressource ajoutée");
                    break;
                case 2: //carte patrimoine
                    CartePatrimoine CP = (CartePatrimoine) carte;
                    joueur.changePV(CP.PV);
                    System.out.println("carte patrimoine ajoutée");
                    break;
                case 3: //carte connaissance
                    CarteConnaissance CC = (CarteConnaissance) carte;
                    joueur.changeConnaissance(CC.type);
                    System.out.println("carte connaissance ajoutée");
                    break;
                case 4: //carte examen
                    CarteExamen CE = (CarteExamen) carte;
                    joueur.changePower(CE.power);
                    System.out.println("carte puissance ajoutée");
                case 5: //carte commerce
                    CarteCommerce CC2 = (CarteCommerce) carte;
                    switch (CC2.id) {
                        case 1: //GainG
                            GainG CCG = (GainG) CC2;
                            CCG.calculGold(CCG.type, this.listeJoueur, joueur.id);
                            joueur.changeGold(CCG.gold);
                            System.out.println("joueur " + joueur.id + " gagne " + CCG.gold + " euros !");
                            break;
                        case 2: //Comptche
                            Comptche CCC = (Comptche) CC2;
                            joueur.changeCompt(CCC.voisinConcern);
                            System.out.println("carte comptoir de type " + CCC.voisinConcern + " activée");
                            break;
                        case 3: //PVGold
                            PVGold CCP = (PVGold) CC2;
                            CCP.calculPvGold(joueur);
                            joueur.changeGold(CCP.gold);
                            joueur.changePV(CCP.PV);
                            break;
                    }
                default:
                    System.out.println("type de carte inconnu");
            }
            listCarte.remove(carteN); //retire la carte du deck du joueur
        } else {
            //Message erreur
            System.out.println("Carte injouable");
        }
    }

    public int calculPV(Joueur joueur) {
        int total = 0;
        total = total + joueur.PV;
        total = total + joueur.gold / 3;
        total = total + min(joueur.math1, joueur.anglais2, joueur.info3) * 7;
        if (joueur.math1 > 1) {
            total = total + joueur.math1 * joueur.math1;
        }
        if (joueur.anglais2 > 1) {
            total = total + joueur.anglais2 * joueur.anglais2;
        }
        if (joueur.info3 > 1) {
            total = total + joueur.info3 * joueur.info3;
        }
        return total;
    }

    private int min(int a, int b, int c) {
        int x = a;
        if (x >= b) {
            x = b;
        }
        if (x >= c) {
            x = c;
        }
        return x;
    }
}