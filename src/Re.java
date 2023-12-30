public class Re extends Pezzo {
    public Re(boolean colore, int valore, Pezzo[][] scacchiera) {
        super(colore, valore, scacchiera);
    }
    public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }
    void movimento(int direction) {
        switch (direction) {
            case 1 -> up_rightr();
            case 2 -> down_rightr();
            case 3 -> down_leftr();
            case 4 -> up_leftr();
            case 5 -> upr();
            case 6 -> rightr();
            case 7 -> downr();
            case 8 -> leftr();
        }
    }
    void coveredSquares(Pezzo p) {
        if(coordinates[1] + 1 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0], coordinates[1] + 1});
        if(coordinates[1] - 1 >= 0) coveredSquares.add(new int[]{coordinates[0], coordinates[1] - 1});
        if(coordinates[0] + 1 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] + 1, coordinates[1]});
        if(coordinates[0] - 1 >= 0) coveredSquares.add(new int[]{coordinates[0] - 1, coordinates[1]});
        if(coordinates[0] + 1 < Scacchiera.scacchiera.length && coordinates[1] + 1 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] + 1, coordinates[1] + 1});
        if(coordinates[0] + 1 < Scacchiera.scacchiera.length && coordinates[1] - 1 >= 0) coveredSquares.add(new int[]{coordinates[0] + 1, coordinates[1] - 1});
        if(coordinates[0] - 1 >= 0 && coordinates[1] + 1 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] - 1, coordinates[1] + 1});
        if(coordinates[0] - 1 >= 0 && coordinates[1] - 1 >= 0) coveredSquares.add(new int[]{coordinates[0] - 1, coordinates[1] - 1});
    }
    void up_rightr() {
        if (coordinates[0] - 1 >= 0 && coordinates[1] + 1 < Scacchiera.scacchiera[0].length) {
            boolean isValid = true;

            for (int i = 1; i <= 1; i++) {
                int newRow = coordinates[0] - i;
                int newCol = coordinates[1] + i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] - 1, coordinates[1] + 1);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void down_rightr() {
        if (coordinates[0] + 1 < Scacchiera.scacchiera.length && coordinates[1] + 1 < Scacchiera.scacchiera[0].length) {
            boolean isValid = true;

            for (int i = 1; i <= 1; i++) {
                int newRow = coordinates[0] + i;
                int newCol = coordinates[1] + i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] + 1, coordinates[1] + 1);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void down_leftr() {
        if (coordinates[0] + 1 < Scacchiera.scacchiera.length && coordinates[1] - 1 >= 0) {
            boolean isValid = true;

            for (int i = 1; i <= 1; i++) {
                int newRow = coordinates[0] + i;
                int newCol = coordinates[1] - i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] + 1, coordinates[1] - 1);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void up_leftr() {
        if (coordinates[0] - 1 >= 0 && coordinates[1] - 1 >= 0) {
            boolean isValid = true;

            for (int i = 1; i <= 1; i++) {
                int newRow = coordinates[0] - i;
                int newCol = coordinates[1] - i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] - 1, coordinates[1] - 1);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void upr() {
        boolean isValid = true;
        if (this.coordinates[0] - 1 >= 0) {
            for (int i = this.coordinates[0] - 1; i < this.coordinates[0]; i++)
                if (Scacchiera.scacchiera[i][coordinates[1]] != null && Scacchiera.scacchiera[i][coordinates[1]].colore==colore) {
                    isValid = false;
                    break;
                }
            if (isValid) {
                if (coordinates[0] - 1 >= 0) {
                    setCoordinates(coordinates[0] - 1, coordinates[1]);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1]] = null;
                }
            }
        }
    }
    void rightr() {
        boolean isValid = true;
        if (this.coordinates[1] + 1 < Scacchiera.scacchiera.length) {
            for (int i = this.coordinates[1] + 1; i > this.coordinates[1]; i--)
                if (Scacchiera.scacchiera[coordinates[0]][i] != null && Scacchiera.scacchiera[0][coordinates[i]].colore==colore) {
                    isValid = false;
                    break;
                }
            if (isValid) {
                if (coordinates[1] + 1 <= Scacchiera.scacchiera.length) {
                    setCoordinates(coordinates[0], coordinates[1] + 1);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1] - 1] = null;
                }
            }
        }
    }
    void downr() {
        boolean isValid = true;
        if (this.coordinates[0] + 1 < Scacchiera.scacchiera.length) {
            for (int i = this.coordinates[0] + 1; i > this.coordinates[0]; i--)
                if (Scacchiera.scacchiera[i][coordinates[1]] != null && Scacchiera.scacchiera[i][coordinates[1]].colore==colore) {
                    isValid = false;
                    break;
                }
            if (isValid) {
                if (coordinates[0] + 1 <= Scacchiera.scacchiera.length) {
                    setCoordinates(coordinates[0] + 1, coordinates[1]);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1]] = null;
                }
            }
        }
    }
    void leftr() {
        boolean isValid = true;
        if (this.coordinates[1] - 1 >= 0) {
            for (int i = this.coordinates[1] - 1; i < this.coordinates[1]; i++)
                if (Scacchiera.scacchiera[coordinates[0]][i] != null && Scacchiera.scacchiera[0][coordinates[i]].colore==colore) {
                    isValid = false;
                    break;
                }
            if (isValid) {
                if (coordinates[1] - 1 >= 0) {
                    setCoordinates(coordinates[0], coordinates[1] - 1);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1] + 1] = null;
                }
            }
        }
    }
    @Override
    public String toString() {
        return colore ?  "♔" :  "♚";
    }
}
