public class Carte {

    protected int costGold;

    protected String image;

    protected int carteType;

    public Carte() {
        this.image="a";
        this.costGold=0;
        this.carteType=0;
    }
    public Carte(int n_costGold, String n_image, int n_carteType) {
        this.costGold=n_costGold;
        this.image=n_image;
        this.carteType=n_carteType;
    }
}
