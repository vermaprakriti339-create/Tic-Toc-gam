import java.io.IOException;
import java.util.*;
public class Main {

    static String[]board;
    static String turn;
    static String checkWinner(){
        for(int a=0;a<8;a++){
            String line=null;
         switch (a) {
            case 0:
                line=board[0]+board[1]+board[2];

                
                break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                    case 2:
                        line=board[6]+board[7]+board[8];
                        break;
                        case 3:
                            line=board[0]+board[3]+board[6];
                            break;
                            case 4:
                            line=board[1]+board[4]+board[7];
                            break;
                            case 5:
                                line=board[2]+board[5]+board[8];
                                break;
                                case 6:
                                  line=board[0]+board[4]+board[8];
                                  break;
                                  case 7:
                                    line=board[2]+board[4]+board[6];
                                    break;

         
            
         }
         if(line.equals("xxx")){
            return "x";
         }else if(line.equals("ooo")){
            return "o";

         }
        }
        for(int a=0;a<9;a++){
            if(Arrays.asList(board).contains(String.valueOf(a+1))){
                break;

            }else if(a==8){
                return "draw";

            }
        }
        System.out.println(turn+"turn a slot a two plce" +turn+"in");
        return null;
    }
        static void printBoard(){
            System.out.println("| - | - |- |");
            System.out.println("|" +board[0] +"|" +board[1] +"|"+board[2]+"|");
            System.out.println("|- - - -|");
            System.out.println("|"+board[3]+"|"+board[4]+"|"+board[5]+"|");
            System.out.println("|- - - -|");
            System.out.println("|"+board[6]+"|"+board[7]+"|"+board[8]+"|");
            System.out.println("| - | - | - |");

        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            board=new String[9];
            turn="x";
            String winner=null;
              for(int a=0;a<9;a++){
         board[a]=String.valueOf((a+1));

    }
    System.out.println("welcome to tic toc game ");
    printBoard();
    System.out.println("x will be first enter the slot number to place X in");
    while (winner==null) {
        int numinput;
        try{
            numinput=sc.nextInt();
            if(!(numinput>0&&numinput<=9)){
                System.out.println("invaild input -resttre slot number");
                continue;
            }
            
            if(board[numinput-1].equals(String.valueOf(numinput))){
                board[numinput-1]=turn;
                turn=turn.equals("x")?"o":"x";
                printBoard();
                winner=checkWinner();
            } else{
                System.out.println("slot already taken re-enter the slot num");
            }
        } catch(InputMismatchException e){
            System.out.println("invaild input re=enter the slot number ");
            sc.nextLine();
        }
        
    }
    if(winner.equalsIgnoreCase(" draw ")){
      System.out.println(" it is draw ");
    }else{
        System.out.println(" congratulation " +  winner + " won ");
    }
    sc.close();
    
        }
  
}