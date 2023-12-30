public class Cavallo extends Pezzo {
    public int[] coordinates;

    public Cavallo(boolean colore, int valore, Pezzo[][] scacchiera) {
        super(colore, valore, scacchiera);
        this.coordinates = Scacchiera.coordinate(this);
    }

    public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }

    void movimento(int direction, boolean specification) {
        switch (direction) {
            case 1 -> upk(specification);
            case 2 -> rightk(specification);
            case 3 -> downk(specification);
            case 4 -> leftk(specification);
        }
    }
    void coveredSquares(Pezzo p) {
        if(coordinates[0] + 2 < Scacchiera.scacchiera.length && coordinates[1] - 1 >= 0) coveredSquares.add(new int[]{coordinates[0] + 2,coordinates[1] - 1});
        if(coordinates[0] + 2 < Scacchiera.scacchiera.length && coordinates[1] + 1 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] + 2,coordinates[1] + 1});
        if(coordinates[0] - 2 >= 0 && coordinates[1] - 1 >= 0) coveredSquares.add(new int[]{coordinates[0] - 2,coordinates[1] - 1});
        if(coordinates[0] - 2 >= 0 && coordinates[1] + 1 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] - 2,coordinates[1] + 1});
        if(coordinates[0] + 1 < Scacchiera.scacchiera.length && coordinates[1] - 2 >= 0) coveredSquares.add(new int[]{coordinates[0] + 1,coordinates[1] - 2});
        if(coordinates[0] + 1 < Scacchiera.scacchiera.length && coordinates[1] + 2 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] + 1,coordinates[1] + 2});
        if(coordinates[0] - 1 >= 0 && coordinates[1] - 2 >= 0) coveredSquares.add(new int[]{coordinates[0] - 1,coordinates[1] - 2});
        if(coordinates[0] - 1 >= 0 && coordinates[1] + 2 < Scacchiera.scacchiera.length) coveredSquares.add(new int[]{coordinates[0] - 1,coordinates[1] + 2});
    }
    private void upk(boolean specification) {
        boolean isValid = true;
        if (specification) {
            if ((this.coordinates[0] - 2) >= 0 && (this.coordinates[1] - 1) >= 0) {
                if (Scacchiera.scacchiera[this.coordinates[0] - 2][this.coordinates[1] - 1] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] - 2][this.coordinates[1] - 1].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] - 2, coordinates[1] - 1);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] + 2][coordinates[1] + 1] = null;
                }
            }
        } else {
            if ((this.coordinates[0] - 2) >= 0 && (this.coordinates[1] + 1) < Scacchiera.scacchiera.length) {
                if (Scacchiera.scacchiera[this.coordinates[0] - 2][this.coordinates[1] + 1] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] - 2][this.coordinates[1] + 1].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] - 2, coordinates[1] + 1);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] + 2][coordinates[1] - 1] = null;
                }
            }
        }
    }
    private void rightk(boolean specification) {
        boolean isValid = true;
        if (specification) {
            if ((this.coordinates[0] - 1) >= 0 && (this.coordinates[1] + 2) < Scacchiera.scacchiera.length) {
                if (Scacchiera.scacchiera[this.coordinates[0] - 1][this.coordinates[1] + 2] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] - 1][this.coordinates[1] + 2].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] - 1, coordinates[1] + 2);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 2] = null;
                }
            }
        } else {
            if ((this.coordinates[0] + 1) < Scacchiera.scacchiera.length && (this.coordinates[1] + 2) < Scacchiera.scacchiera.length) {
                if (Scacchiera.scacchiera[this.coordinates[0] + 1][this.coordinates[1] + 2] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] + 1][this.coordinates[1] + 2].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] + 1, coordinates[1] + 2);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 2] = null;
                }
            }
        }
    }
    private void downk(boolean specification) {
        boolean isValid = true;
        if (specification) {
            if ((this.coordinates[0] + 2) >= 0 && (this.coordinates[1] - 1) >= 0) {
                if (Scacchiera.scacchiera[this.coordinates[0] + 2][this.coordinates[1] - 1] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] + 2][this.coordinates[1] - 1].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] + 2, coordinates[1] - 1);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] - 2][coordinates[1] + 1] = null;
                }
            }
        } else {
            if ((this.coordinates[0] + 2) < Scacchiera.scacchiera.length && (this.coordinates[1] + 1) < Scacchiera.scacchiera.length) {
                if (Scacchiera.scacchiera[this.coordinates[0] + 2][this.coordinates[1] + 1] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] + 2][this.coordinates[1] + 1].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] + 2, coordinates[1] + 1);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] - 2][coordinates[1] - 1] = null;
                }
            }
        }
    }
    private void leftk(boolean specification) {
        boolean isValid = true;
        if (specification) {
            if ((this.coordinates[0] + 1) < Scacchiera.scacchiera.length && (this.coordinates[1] - 2) >= 0) {
                if (Scacchiera.scacchiera[this.coordinates[0] + 1][this.coordinates[1] - 2] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] + 1][this.coordinates[1] - 2].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] + 1, coordinates[1] - 2);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 2] = null;
                }
            }
        } else {
            if ((this.coordinates[0] - 1) >= 0 && (this.coordinates[1] - 2) >= 0) {
                if (Scacchiera.scacchiera[this.coordinates[0] - 1][this.coordinates[1] - 2] != null) {
                    isValid = Scacchiera.scacchiera[this.coordinates[0] - 1][this.coordinates[1] - 2].colore != colore;
                }
                if (isValid) {
                    setCoordinates(coordinates[0] - 1, coordinates[1] - 2);
                    Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                    Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 2] = null;
                }
            }
        }
    }
    @Override
    public String toString() {
        return colore ?  "♘" :  "♞";
    }
}
