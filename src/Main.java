import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scacchiera scacchiera = new Scacchiera();
        scacchiera.cavallo_1.coveredSquares(scacchiera.cavallo_1);
        for (int i = 0; i < scacchiera.cavallo_1.coveredSquares.size(); i++) {
            System.out.println(Arrays.toString(scacchiera.cavallo_1.coveredSquares.get(i)));
        }
        System.out.println(scacchiera);
    }
}