public class Torre extends Pezzo {
    public Torre(boolean colore, int valore, Pezzo[][] scacchiera) {
        super(colore, valore, scacchiera);
    }
    void movimento(int input, int direction) {
        switch (direction) {
            case 1 -> up(input);
            case 2 -> right(input);
            case 3 -> down(input);
            case 4 -> left(input);
        }
    }
    @Override
    public String toString() {
        return colore ?  "♖" :  "♜";
    }
}
