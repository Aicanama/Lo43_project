package com.model;

import com.observer.CardChangedEvent;
import com.observer.CardListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static jdk.nashorn.internal.objects.NativeMap.size;


public class Moteur{
    //le modèle

    private int ageActuel;
    private ImageIcon Imgcarte;
    private ImageIcon Imgcarte2;
    private Age age;

    protected ArrayList<Joueur> listeJoueur;
    protected  SousListe ssListeJoueur1;
    protected  SousListe ssListeJoueur2;
    protected  SousListe ssListeJoueur3;
    protected  SousListe ssListeJoueur4;


    private EventListenerList listeners;


    public Moteur(int n_id) {
        this.ageActuel = n_id;
    }

    public Moteur(int n_id, SousListe newCards){
        this.ageActuel = n_id;
        this.ssListeJoueur1 = newCards;

        //ecoute des changements = notofication aux autres composants
        listeners = new EventListenerList();

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

        //cartes
        //age I
        URL urlPizza = getClass().getResource("img/pizza.png");
        URL urlPuzzle = getClass().getResource("img/puzzle.png");
        URL urlBook = getClass().getResource("img/book.png");
        URL urlBrain = getClass().getResource("img/brain.png");
        URL urlBeer = getClass().getResource("img/beer.png");
        URL urlGlobe = getClass().getResource("img/globe.png");
        URL urlOrdi = getClass().getResource("img/ordi.png");
        URL urlPiOr = getClass().getResource("img/pizza_ordi.png");
        URL urlOrBr = getClass().getResource("img/ordi_brain.png");
        URL urlBrBe = getClass().getResource("img/brain_beer.png");
        URL urlMieE = getClass().getResource("img/mieCalinouEst.png");
        URL urlMieO = getClass().getResource("img/mieCalinouOuest.png");
        URL urlOne = getClass().getResource("img/oneShoot.png");
        URL urlBou = getClass().getResource("img/bouleDisco.png");
        URL urlSav = getClass().getResource("img/savoureuse.png");
        URL urlCuc = getClass().getResource("img/CUC.png");
        URL urlSte = getClass().getResource("img/steleBartholdi.png");
        URL urlCin = getClass().getResource("img/cinema.png");
        URL urlMat = getClass().getResource("img/matrice.png");
        URL urlAng = getClass().getResource("img/anglais.png");
        URL urlEtuEc = getClass().getResource("img/etudesEcrites.png");

        //Age II
        URL urlBe2 = getClass().getResource("img/beer2.png");
        URL urlBr2 = getClass().getResource("img/brain2.png");
        URL urlPi2 = getClass().getResource("img/pizza2.png");
        URL urlOr2 = getClass().getResource("img/ordi2.png");
        URL urlCave = getClass().getResource("img/caveAVins.png");
        URL urlNo = getClass().getResource("img/nooz.png");
        URL urlBar = getClass().getResource("img/bar.png");
        URL urlLitCar = getClass().getResource("img/littleCarouf.png");
        URL urlLion = getClass().getResource("img/lionBartholdi.png");
        URL urlPoud = getClass().getResource("img/poudriere.png");
        URL urlFont = getClass().getResource("img/fontaine.png");
        URL urlPalais = getClass().getResource("img/palaisJustice.png");
        URL urlCoda = getClass().getResource("img/codage.png");
        URL urlBula = getClass().getResource("img/bulats.png");
        URL urlLan2 = getClass().getResource("img/langue2.png");
        URL urlEloq = getClass().getResource("img/eloquence.png");
        //Age III
        URL urlFoy = getClass().getResource("img/foyer.png");
        URL urlLac = getClass().getResource("img/laclerc.png");
        URL urlCham = getClass().getResource("img/chambreCommerce.png");
        URL urlBas = getClass().getResource("img/basicFat.png");
        URL urlMai = getClass().getResource("img/mairie.png");
        URL urlBelf = getClass().getResource("img/belfortHotel.png");
        URL urlPol = getClass().getResource("img/police.png");
        URL urlMus = getClass().getResource("img/museum.png");
        URL urlCit = getClass().getResource("img/citadelle.png");
        URL urlBil = getClass().getResource("img/bilingue.png");
        URL urlEtuEt = getClass().getResource("img/etudeEtranger.png");
        URL urlLog = getClass().getResource("img/logiciel.png");
        URL urlScie = getClass().getResource("img/sciences2.png");
        URL urlHist = getClass().getResource("img/histoire2.png");

        //cartes ressources
        ImageIcon pizza = null,
                beer= null,
                ordi=null,
                brain=null,
                book=null,
                globe=null,
                puzzle=null,
                pizOrd=null,
                ordBra=null,
                braBee=null;
        //cartes commerce
         ImageIcon mieCalE = null,
                mieCalO=null, oneS=null, boulD=null, caveVin=null, nooz=null, bar=null, litCarouf=null, foyer=null, laclerc=null, chambC=null, basicFat=null;
        //cartes patrimoine
         ImageIcon savour=null, cuc=null, steleB=null, cine=null, lionB=null, poudr=null, fonta=null, palaisJ=null, mairie=null, belfHot=null, police=null, museum=null, citad=null;
        //cartes connaissances
         ImageIcon matrice=null, anglais=null, etudeEc=null, codage=null, bulats=null, langue2=null, eloque=null, bilingue=null, etudeEtr=null, logiciel=null, science2=null, histoire2=null;


        try {
            //Cartes Ressources
            pizza = new ImageIcon(ImageIO.read(urlPizza));
            beer = new ImageIcon(ImageIO.read(urlBeer));
            ordi = new ImageIcon(ImageIO.read(urlOrdi));
            brain = new ImageIcon(ImageIO.read(urlBrain));
            book = new ImageIcon(ImageIO.read(urlBook));
            globe = new ImageIcon(ImageIO.read(urlGlobe));
            puzzle = new ImageIcon(ImageIO.read(urlPuzzle));
            pizOrd = new ImageIcon(ImageIO.read(urlPiOr));
            ordBra = new ImageIcon(ImageIO.read(urlOrBr));
            braBee = new ImageIcon(ImageIO.read(urlBrBe));

            //Cartes Commerce
            mieCalE = new ImageIcon(ImageIO.read(urlMieE));
            mieCalO = new ImageIcon(ImageIO.read(urlMieO));
            oneS = new ImageIcon(ImageIO.read(urlOne));
            boulD = new ImageIcon(ImageIO.read(urlBou));
            caveVin = new ImageIcon(ImageIO.read(urlCave));
            nooz = new ImageIcon(ImageIO.read(urlNo));
            bar = new ImageIcon(ImageIO.read(urlBar));
            litCarouf = new ImageIcon(ImageIO.read(urlLitCar));
            foyer = new ImageIcon(ImageIO.read(urlFoy));
            laclerc = new ImageIcon(ImageIO.read(urlLac));
            chambC = new ImageIcon(ImageIO.read(urlCham));
            basicFat = new ImageIcon(ImageIO.read(urlBas));
            //Cartes Patrimoine
            savour = new ImageIcon(ImageIO.read(urlSav));
            cuc = new ImageIcon(ImageIO.read(urlCuc));
            steleB = new ImageIcon(ImageIO.read(urlSte));
            cine = new ImageIcon(ImageIO.read(urlCin));
            lionB = new ImageIcon(ImageIO.read(urlLion));
            poudr = new ImageIcon(ImageIO.read(urlPoud));
            fonta = new ImageIcon(ImageIO.read(urlFont));
            palaisJ = new ImageIcon(ImageIO.read(urlPalais));
            mairie = new ImageIcon(ImageIO.read(urlMai));
            belfHot = new ImageIcon(ImageIO.read(urlBelf));
            police = new ImageIcon(ImageIO.read(urlPol));
            museum = new ImageIcon(ImageIO.read(urlMus));
            citad = new ImageIcon(ImageIO.read(urlCit));
            //Cartes Connaissances
            matrice = new ImageIcon(ImageIO.read(urlMat));
            anglais = new ImageIcon(ImageIO.read(urlAng));
            etudeEc = new ImageIcon(ImageIO.read(urlEtuEc));
            codage = new ImageIcon(ImageIO.read(urlCoda));
            bulats = new ImageIcon(ImageIO.read(urlBula));
            langue2 = new ImageIcon(ImageIO.read(urlLan2));
            eloque = new ImageIcon(ImageIO.read(urlEloq));
            bilingue = new ImageIcon(ImageIO.read(urlBil));
            etudeEtr = new ImageIcon(ImageIO.read(urlEtuEt));
            logiciel = new ImageIcon(ImageIO.read(urlLog));
            science2 = new ImageIcon(ImageIO.read(urlScie));
            histoire2 = new ImageIcon(ImageIO.read(urlHist));
        }
        catch(IOException e){
            e.printStackTrace();
        }

        list.add(new CarteRessource(1, pizza, new ArrayList<Integer>(), 2, 7, 1));
        list.add(new CarteRessource(2, beer, new ArrayList<Integer>(), 2, 7,1));
        list.add(new CarteRessource(3, brain, new ArrayList<Integer>(), 1, 7,1));
        list.add(new CarteRessource(0, book, new ArrayList<Integer>(), 0, 7,1));
        list.add(new CarteRessource(0, globe, new ArrayList<Integer>(), 3, 7,1));
        list.add(new CarteRessource(0, puzzle, new ArrayList<Integer>(), 3, 7,1));
        list.add(new CarteRessource(0, pizOrd, new ArrayList<Integer>(), 4, 7,1));
        list.add(new CarteRessource(0, ordBra, new ArrayList<Integer>(), 5, 7,1));
        list.add(new CarteRessource(0, braBee, new ArrayList<Integer>(), 6, 7,1));
        list.add(new CarteRessource(1, mieCalE, new ArrayList<Integer>(), 2, 1,1));
        list.add(new CarteRessource(1, mieCalO, new ArrayList<Integer>(), 1, 0,1));
        list.add(new CarteRessource(1, mairie, new ArrayList<Integer>(), 0, 3,1));

        list.add(new CartePatrimoine(0,ordi,new ArrayList<Integer>(),3));
        list.add(new CartePatrimoine(0,ordi,new ArrayList<Integer>(),2));
        list.add(new CartePatrimoine(0,ordi,new ArrayList<Integer>(),2));
        list.add(new CartePatrimoine(0,ordi,r1,3));

        list.add(new CarteExamen(0,ordi,r2,1));
        list.add(new CarteExamen(0,ordi,r0,1));
        list.add(new CarteExamen(0,ordi,r0,1));
        list.add(new CarteExamen(0,ordi,r3,1));

        list.add(new CarteConnaissance(0,ordi,r5,1));
        list.add(new CarteConnaissance(0,ordi,r6,3));
        list.add(new CarteConnaissance(0,ordi,r4,2));
        list.add(new CarteConnaissance(0,ordi,r4,2));

       /* list.add(new GainG(0,ordi,new ArrayList<Integer>(),0));
        list.add(new Comptche(0,ordi,new ArrayList<Integer>(),1));
        list.add(new Comptche(0,ordi,new ArrayList<Integer>(),2));
        list.add(new Comptche(0,ordi,new ArrayList<Integer>(),3));*/
    }

    public void shuffle(ArrayList liste) {
        Collections.shuffle(liste);
    }

//----------------------------------------Listener handler---------------

    public SousListe getSsListeJoueur() {
        return ssListeJoueur1;
    }

    public void setSsListeJoueur(SousListe ssListeJoueur) {
        this.ssListeJoueur1 = ssListeJoueur;

        fireCardChanged();
    }
    public void remove1CardFromSousListe(Carte carte) {
        for (int i = 0; i<ssListeJoueur1.cartes.size();i++) {
            if (ssListeJoueur1.cartes.get(i).equals(carte))
                ssListeJoueur1.cartes.remove(i);
        }

    }

    /// Les méthodes gérant les vues sous forme de listener :
    public void addCardListener(CardListener listener) {
        //enregistre une vue pour quelle soit avertie des changements
        listeners.add(CardListener.class, listener);
    }

    public void removeCardListener(CardListener listener) {
        //dés-enregistre une vue
        listeners.remove(CardListener.class, listener);
    }

    public void fireCardChanged() {
        //Les méthodes fire~ permettent de lancer un
        //évènement qui sera distribué à l'ensemble des
        //listeners enregistrés
        CardListener[] listenerList = (CardListener[]) listeners.getListeners(CardListener.class);

        for (CardListener listener : listenerList) {
            listener.cardChangedRound(new CardChangedEvent(this, getSsListeJoueur()));
        }
    }
//-----------------------------------------------------------------------------------------------

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