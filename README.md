# Lo43_project

projet LO43

src/com >> package : Modele + View + controller + Observer

dans View : utilisé seulement Plateau
-->Fenetre a suppr
//JFrameView = "la vue" utilisée est dans com.model (trop de souci quand elle etait dans la com.view)

dans Observer : les listerner et les events associés :  les observateurs/écouteurs qui sont "les oreilles" du modèle sur la vue par le controller (notification des changements de vue)

dans Controller : + AbstractViewCard classe abstraite utilisée par la suite pour mettre en place la vue et le lien avec le controller
                  + CardController est le controller qui permet de faire le lien entre la vue et le modèle avec des sortes de notifications au modèle

dans Model : + Moteur qui a le Moteur où tout va se passer
             + Main où tout va tourner et créer le lien entre Moteur et controller (for now)

-- > classe direct au niveau src sont a suppr
