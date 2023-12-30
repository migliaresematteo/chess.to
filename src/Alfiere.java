public class Alfiere extends Pezzo {

    public Alfiere(boolean colore, int valore, Pezzo[][] scacchiera) {
        super(colore, valore, scacchiera);
    }
    void movimento(int input, int direction) {
        switch (direction) {
            case 1 -> up_right(input);
            case 2 -> down_right(input);
            case 3 -> down_left(input);
            case 4 -> up_left(input);
        }
    }
    @Override
    public String toString() {
        return colore ?  "♗" :  "♝";
    }
}
