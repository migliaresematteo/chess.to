public class Regina extends Pezzo {
    public Regina(boolean colore, int valore, Pezzo[][] scacchiera) {
        super(colore, valore, scacchiera);
    }
    public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }
    void movimento(int input, int direction) {
        switch (direction) {
            case 1 -> up_right(input);
            case 2 -> down_right(input);
            case 3 -> down_left(input);
            case 4 -> up_left(input);
            case 5 -> up(input);
            case 6 -> right(input);
            case 7 -> down(input);
            case 8 -> left(input);
        }
    }
    @Override
    public String toString() {
        return colore ?  "♕" :  "♛";
    }
}
