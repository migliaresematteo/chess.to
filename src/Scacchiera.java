public class Scacchiera {
    static Pezzo[][] scacchiera = new Pezzo[8][8];
    public Scacchiera() {
        HelperResetPedoni();
        HelperResetTorri();
        HelperResetAlfieri();
        HelperResetRegine();
        HelperResetRe();
        HelperResetCavalli();
    }
    Pedone pedone_1 = new Pedone(true,1,scacchiera);
    Pedone pedone_2 = new Pedone(true,1,scacchiera);
    Pedone pedone_3 = new Pedone(true,1,scacchiera);
    Pedone pedone_4 = new Pedone(true,1,scacchiera);
    Pedone pedone_5 = new Pedone(true,1,scacchiera);
    Pedone pedone_6 = new Pedone(true,1,scacchiera);
    Pedone pedone_7 = new Pedone(true,1,scacchiera);
    Pedone pedone_8 = new Pedone(true,1,scacchiera);
    Torre torre_1 = new Torre(true,5,scacchiera);
    Torre torre_2 = new Torre(true,5,scacchiera);
    Cavallo cavallo_1 = new Cavallo(true,3,scacchiera);
    Cavallo cavallo_2 = new Cavallo(true,3,scacchiera);
    Alfiere alfiere_1 = new Alfiere(true,3,scacchiera);
    Alfiere alfiere_2 = new Alfiere(true,3,scacchiera);
    Regina regina_1 = new Regina(true,9,scacchiera);
    Re re1 = new Re(true,100,scacchiera);
    //Pezzi neri
    Pedone pedone_9 = new Pedone(false,1,scacchiera);
    Pedone pedone_10 = new Pedone(false,1,scacchiera);
    Pedone pedone_11 = new Pedone(false,1,scacchiera);
    Pedone pedone_12 = new Pedone(false,1,scacchiera);
    Pedone pedone_13 = new Pedone(false,1,scacchiera);
    Pedone pedone_14 = new Pedone(false,1,scacchiera);
    Pedone pedone_15 = new Pedone(false,1,scacchiera);
    Pedone pedone_16 = new Pedone(false,1,scacchiera);
    Torre torre_3 = new Torre(false,5,scacchiera);
    Torre torre_4 = new Torre(false,5,scacchiera);
    Cavallo cavallo_3 = new Cavallo(false,3,scacchiera);
    Cavallo cavallo_4 = new Cavallo(false,3,scacchiera);
    Alfiere alfiere_3 = new Alfiere(false,3,scacchiera);
    Alfiere alfiere_4 = new Alfiere(false,3,scacchiera);
    Regina regina_2 = new Regina(false,9,scacchiera);
    Re re2 = new Re(false,100,scacchiera);
    void resetScacchiera() {
        HelperResetPedoni();
        HelperResetTorri();
        HelperResetAlfieri();
        HelperResetRegine();
        HelperResetRe();
        HelperResetCavalli();
    }
    void HelperResetPedoni() {
        Pedone[] pedoni_bianchi = {pedone_1, pedone_2, pedone_3, pedone_4, pedone_5, pedone_6, pedone_7, pedone_8};
        Pedone[] pedoni_neri = {pedone_9, pedone_10, pedone_11, pedone_12, pedone_13, pedone_14, pedone_15, pedone_16};

        for (int i = 0; i < pedoni_bianchi.length; i++) {
            scacchiera[i][6] = pedoni_bianchi[i];
            pedoni_bianchi[i].setCoordinates(i,6);
        }
        for (int i = 0; i < pedoni_neri.length; i++) {
            scacchiera[i][1] = pedoni_neri[i];
            pedoni_neri[i].setCoordinates(i,1);

        }
    }
    void HelperResetTorri() {
        scacchiera[0][0] = torre_3;
        torre_3.setCoordinates(0,0);
        scacchiera[0][7] = torre_1;
        torre_1.setCoordinates(0,7);
        scacchiera[7][0] = torre_4;
        torre_4.setCoordinates(7,0);
        scacchiera[7][7] = torre_2;
        torre_2.setCoordinates(7,7);
    }
    void HelperResetAlfieri() {
        scacchiera[2][0] = alfiere_3;
        alfiere_3.setCoordinates(2,0);
        scacchiera[2][7] = alfiere_1;
        alfiere_1.setCoordinates(2,7);
        scacchiera[5][0] = alfiere_4;
        alfiere_4.setCoordinates(5,0);
        scacchiera[5][7] = alfiere_2;
        alfiere_2.setCoordinates(5,7);
    }
    void HelperResetRegine() {
        scacchiera[4][0] = regina_2;
        regina_2.setCoordinates(4,0);
        scacchiera[4][7] = regina_1;
        regina_1.setCoordinates(4,7);
    }
    void HelperResetRe() {
        scacchiera[3][0] = re2;
        re2.setCoordinates(3,0);
        scacchiera[3][7] = re1;
        re1.setCoordinates(3,7);
    }
    void HelperResetCavalli() {
        scacchiera[1][0] = cavallo_3;
        cavallo_3.setCoordinates(1,0);
        scacchiera[1][7] = cavallo_1;
        cavallo_1.setCoordinates(1,7);
        scacchiera[6][0] = cavallo_4;
        cavallo_4.setCoordinates(6,0);
        scacchiera[6][7] = cavallo_2;
        cavallo_2.setCoordinates(6,7);
    }
    static int[] coordinate(Pezzo p) {
        int[] coords = new int[2];
        coords[0] = HelperGetPosX(p);
        coords[1] = HelperGetPosY(p);
        return coords;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < scacchiera[0].length; i++) {
            for (int j = 0; j < scacchiera.length; j++) {
                Pezzo pezzo = scacchiera[i][j];
                if (pezzo != null) {
                    result.append(pezzo).append(" ");
                } else {
                    result.append("-  ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
    static int HelperGetPosX(Pezzo p) {
        for (int i = 0; i < scacchiera.length; i++) {
            for (int j = 0; j < scacchiera[i].length; j++) {
                if (scacchiera[i][j] == p) {
                    return j;
                }
            }
        }
        return 0;
    }
    static int HelperGetPosY(Pezzo p) {
        for (int i = 0; i < scacchiera.length; i++) {
            for (int j = 0; j < scacchiera[i].length; j++) {
                if (scacchiera[i][j] == p) {
                    return i;
                }
            }
        }
        return 0;
    }
}
