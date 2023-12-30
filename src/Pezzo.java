import java.util.ArrayList;

abstract class Pezzo {
    protected boolean colore;
    protected int valore;
    public int[] coordinates;
    ArrayList<int[]> coveredSquares = new ArrayList<>();
    public Pezzo(boolean colore, int valore, Pezzo[][] scacchiera) {
        this.colore = colore;
        this.valore = valore;
        this.coordinates = Scacchiera.coordinate(this);
    }
    public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }
    void coveredSquaresAXIS(Pezzo p) {
        //x
        for (int i = p.coordinates[0] - 1; i >= 0; i--) {
            if(Scacchiera.scacchiera[i][p.coordinates[1]] != null) break;
            int[] c = {i,p.coordinates[1]};
            coveredSquares.add(c);
        }
        for (int i = p.coordinates[0] + 1; i < Scacchiera.scacchiera.length; i++) {
            if(Scacchiera.scacchiera[i][p.coordinates[1]] != null) break;
            int[] c = {i,p.coordinates[1]};
            coveredSquares.add(c);
        }
        //y
        for (int i = p.coordinates[1] - 1; i >= 0; i--) {
            if(Scacchiera.scacchiera[coordinates[0]][i] != null) break;
            int[] c = {p.coordinates[0],i};
            coveredSquares.add(c);
        }
        for (int i = p.coordinates[1] + 1; i < Scacchiera.scacchiera.length; i++) {
            if(Scacchiera.scacchiera[coordinates[0]][i] != null) break;
            int[] c = {p.coordinates[0],i};
            coveredSquares.add(c);
        }
    }
    //top-bottom-right
    void coveredSquaresDIAGONAL(Pezzo p) {
        for (int[] i = {p.coordinates[0] - 1, p.coordinates[1] + 1}; i[0] >= 0 && i[1] < Scacchiera.scacchiera.length; i[0] -= 1, i[1] += 1) {
            if(Scacchiera.scacchiera[i[0]][i[1]] != null) break;
            int[] c = {i[0],i[1]};
            coveredSquares.add(c);
        }
        for (int[] i = {p.coordinates[0] + 1, p.coordinates[1] + 1}; i[0] < Scacchiera.scacchiera.length && i[1] < Scacchiera.scacchiera.length; i[0] += 1, i[1] += 1) {
            if (Scacchiera.scacchiera[i[0]][i[1]] != null) break;
            int[] c = {i[0], i[1]};
            coveredSquares.add(c);
        }
        for (int[] i = {p.coordinates[0] + 1, p.coordinates[1] - 1}; i[0] < Scacchiera.scacchiera.length && i[1] >= 0; i[0] += 1, i[1] -= 1) {
            if (Scacchiera.scacchiera[i[0]][i[1]] != null) break;
            int[] c = {i[0], i[1]};
            coveredSquares.add(c);
        }
        for (int[] i = {p.coordinates[0] - 1, p.coordinates[1] - 1}; i[0] >= 0 && i[1] >= 0; i[0] -= 1, i[1] -= 1) {
            if (Scacchiera.scacchiera[i[0]][i[1]] != null) break;
            int[] c = {i[0], i[1]};
            coveredSquares.add(c);
        }
    }
    //top-boottom-left
    void up(int input) {
        boolean isValid = true;
        if(this.coordinates[0] - input >= 0) {
            for (int i = this.coordinates[0] - input; i < this.coordinates[0] ; i++)
                if (Scacchiera.scacchiera[i][coordinates[1]] != null && Scacchiera.scacchiera[i][coordinates[1]].colore==colore) {
                    isValid = false;
                    break;
                }
            if(isValid) {
                if (coordinates[0] - input >= 0) {
                    setCoordinates(coordinates[0] - input, coordinates[1]);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] + input][coordinates[1]] = null;
                }
            }
        }
    }
    void right(int input) {
        boolean isValid = true;
        if(this.coordinates[1] + input < Scacchiera.scacchiera.length) {
            for (int i = this.coordinates[1] + input; i > this.coordinates[1] ; i--)
                if (Scacchiera.scacchiera[coordinates[0]][i] != null && Scacchiera.scacchiera[coordinates[0]][i].colore==colore) {
                    isValid = false;
                    break;
                }
            if(isValid) {
                if (coordinates[1] + input <= Scacchiera.scacchiera.length) {
                    setCoordinates(coordinates[0], coordinates[1] + input);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1] - input] = null;
                }
            }
        }
    }
    void down(int input) {
        boolean isValid = true;
        if(this.coordinates[0] + input < Scacchiera.scacchiera.length) {
            for (int i = this.coordinates[0] + input; i > this.coordinates[0] ; i--)
                if (Scacchiera.scacchiera[i][coordinates[1]] != null && Scacchiera.scacchiera[i][coordinates[1]].colore==colore) {
                    isValid = false;
                    break;
                }
            if(isValid) {
                if (coordinates[0] + input <= Scacchiera.scacchiera.length) {
                    setCoordinates(coordinates[0] + input, coordinates[1]);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] - input][coordinates[1]] = null;
                }
            }
        }
    }
    void left(int input) {
        boolean isValid = true;
        if(this.coordinates[1] - input >= 0) {
            for (int i = this.coordinates[1] - input; i < this.coordinates[1] ; i++)
                if (Scacchiera.scacchiera[coordinates[0]][i] != null && Scacchiera.scacchiera[coordinates[0]][i].colore==colore) {
                    isValid = false;
                    break;
                }
            if(isValid) {
                if (coordinates[1] - input >= 0) {
                    setCoordinates(coordinates[0], coordinates[1] - input);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1] + input] = null;
                }
            }
        }
    }
    void up_right(int input) {
        if (coordinates[0] - input >= 0 && coordinates[1] + input < Scacchiera.scacchiera[0].length) {
            boolean isValid = true;

            for (int i = 1; i <= input; i++) {
                int newRow = coordinates[0] - i;
                int newCol = coordinates[1] + i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore ) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] - input, coordinates[1] + input);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void down_right(int input) {
        if (coordinates[0] + input < Scacchiera.scacchiera.length && coordinates[1] + input < Scacchiera.scacchiera[0].length) {
            boolean isValid = true;

            for (int i = 1; i <= input; i++) {
                int newRow = coordinates[0] + i;
                int newCol = coordinates[1] + i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] + input, coordinates[1] + input);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void down_left(int input) {
        if (coordinates[0] + input < Scacchiera.scacchiera.length && coordinates[1] - input >= 0) {
            boolean isValid = true;

            for (int i = 1; i <= input; i++) {
                int newRow = coordinates[0] + i;
                int newCol = coordinates[1] - i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] + input, coordinates[1] - input);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    void up_left(int input) {
        if (coordinates[0] - input >= 0 && coordinates[1] - input >= 0) {
            boolean isValid = true;

            for (int i = 1; i <= input; i++) {
                int newRow = coordinates[0] - i;
                int newCol = coordinates[1] - i;

                if (Scacchiera.scacchiera[newRow][newCol] != null && Scacchiera.scacchiera[newRow][newCol].colore==colore) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = null;
                setCoordinates(coordinates[0] - input, coordinates[1] - input);
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
            }
        }
    }
    @Override
    public String toString() {
        return "Pezzo{" +
                "colore=" + colore +
                '}';
    }
}
