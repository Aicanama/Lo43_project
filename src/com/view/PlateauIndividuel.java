package com.view;

import java.awt.*;

public class PlateauIndividuel extends Plateau{

    public PlateauIndividuel(){

       Dimension tailleIndiv = new Dimension(648,1266);
        int largeurPlat = tailleIndiv.width/3;
        int longueurPlat = tailleIndiv.height/3;

        setPreferredSize(tailleIndiv);
        setBackground(Color.black);

    }
}
