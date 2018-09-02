import java.util.Scanner;

public class Game {
    public static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col, row;

    public static void input(){
        boolean canPut = true;

       do {
           System.out.print(ox.getCurrentPlayer() + " (col): ");
           col = sc.nextInt();
           System.out.print(ox.getCurrentPlayer() + " (row): ");
           row = sc.nextInt();

           canPut = ox.put(col, row);

           if (!canPut) {
               System.out.println("Please input number between 0-2");
           }
       } while(!canPut);

    }

    public static void main(String [] args){
        ox = new OX();
        while(true){
            System.out.print(ox.getTableString());
            input();
            if(ox.checkWin(col,row)){
                System.out.print(ox.getTableString());
                System.out.println(ox.getCurrentPlayer() + " " + "Win");
                System.out.println("X Win : " + ox.getScoreX());
                System.out.println("O Win : " + ox.getScoreO());
                System.out.println("Draw : " + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                System.out.print(ox.getTableString());
                System.out.println("Draw");
                System.out.println("X Win : " + ox.getScoreX());
                System.out.println("O Win : " + ox.getScoreO());
                System.out.println("Draw : " + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();

        }

    }
}
