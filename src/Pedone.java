public class Pedone extends Pezzo {
    private boolean primaMossa;
    public Pedone(boolean colore, int valore, Pezzo[][] scacchiera) {
        super(colore, valore, scacchiera);
        this.primaMossa = true;
    }
    void coveredSquares() {
        if(colore) {
            boolean isValid = true;
            int[] c = {(coordinates[0] - 1),(coordinates[1] - 1)};
            for (int k : c) {
                if (k < 0) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) coveredSquares.add(c);
            isValid = true;
            int[] d = {(coordinates[0] + 1),(coordinates[1] - 1)};
            for (int j : d) {
                if (j < 0) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) coveredSquares.add(d);
        } else {
            boolean isValid = true;
            int[] c = {(coordinates[0] - 1),(coordinates[1] + 1)};
            for (int k : c) {
                if (k < 0) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) coveredSquares.add(c);
            isValid = true;
            int[] d = {(coordinates[0] + 1),(coordinates[1] + 1)};
            for (int j : d) {
                if (j < 0) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) coveredSquares.add(d);
        }
    }
    void movimento(int input) {
        int distanza_percorribile = (primaMossa) ? 2 : 1;

        if (this.colore) {
            if (coordinates[1] - input >= 0 && Scacchiera.scacchiera[coordinates[0]][coordinates[1] - input ] == null) {
                if(Scacchiera.scacchiera[coordinates[0]][coordinates[1] - 1] != null && input == 2) {
                    System.err.println("Impossibile spostare di 2 posizioni il pezzo (CNL)");
                } else {
                    if(distanza_percorribile < input) {
                        System.err.println("Impossibile spostare di 2 posizioni il pezzo");
                    } else {
                        setCoordinates(coordinates[0], coordinates[1] - input);
                        Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                        Scacchiera.scacchiera[coordinates[0]][coordinates[1] + input] = null;
                    }
                }
            }
        } else {
            if (coordinates[1] + input < Scacchiera.scacchiera.length && Scacchiera.scacchiera[coordinates[0]][coordinates[1] + input] == null) {
                if(Scacchiera.scacchiera[coordinates[0]][coordinates[1] + 1] != null && input == 2) {
                    System.err.println("Impossibile spostare di 2 posizioni il pezzo (CNL)");
                } else {
                    if(distanza_percorribile < input) {
                        System.err.println("Impossibile spostare di 2 posizioni il pezzo");
                    } else {
                        setCoordinates(coordinates[0], coordinates[1] + input);
                        Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                        Scacchiera.scacchiera[coordinates[0]][coordinates[1] - input] = null;
                    }
                }
            }
        }
        if(primaMossa) primaMossa = false;
    }
    void cattura(boolean choice) {
          if(colore) {
              if(Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 1] != null && Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 1].colore != colore && Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 1] != null && Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 1].colore != colore) {
                  if(choice) {
                      setCoordinates((coordinates[0] + 1),(coordinates[1] - 1));
                      Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                      Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 1] = null;
                  } else {
                      setCoordinates((coordinates[0] - 1),(coordinates[1] - 1));
                      Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                      Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 1] = null;
                  }
              }
          } else {
              if(Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 1] != null && Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 1].colore != colore && Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 1] != null && Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 1].colore != colore) {
                  if(choice) {
                      setCoordinates((coordinates[0] + 1),(coordinates[1] + 1));
                      Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                      Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 1] = null;
                  } else {
                      setCoordinates((coordinates[0] - 1),(coordinates[1] + 1));
                      Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                      Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 1] = null;
                  }
              }
          }
    }
    void cattura() {
        if(colore) {
            if (Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 1] != null && Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 1].colore != colore) {
                setCoordinates((coordinates[0] + 1),(coordinates[1] - 1));
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 1] = null;
            } else if(Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 1] != null && Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 1].colore != colore) {
                setCoordinates((coordinates[0] - 1),(coordinates[1] - 1));
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 1] = null;
            }
        } else {
            if(Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 1] != null && Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] + 1].colore != colore) {
                setCoordinates((coordinates[0] + 1),(coordinates[1] + 1));
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] - 1] = null;
            } else if(Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 1] != null && Scacchiera.scacchiera[coordinates[0] - 1][coordinates[1] + 1].colore != colore) {
                setCoordinates((coordinates[0] - 1),(coordinates[1] + 1));
                Scacchiera.scacchiera[coordinates[0]][coordinates[1]] = this;
                Scacchiera.scacchiera[coordinates[0] + 1][coordinates[1] - 1] = null;
            }
        }
    }
    @Override
    public String toString() {
        return colore ?  "♙" :  "♟";
    }
}
