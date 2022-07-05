import java.util.*;
public class TicTacToe{

    static ArrayList<Integer> userPos = new ArrayList<Integer>();
    static ArrayList<Integer> machinPos = new ArrayList<Integer>();
    public static void main(String[] args) {
        char [] [] TicTacToeBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},                              // diagram for TicTacToe.
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};

        printTicTacToeBoard(TicTacToeBoard);
//reapiting user and cpu chance again n again 
        while(true){
// for user
                Scanner sc = new Scanner(System.in);
                System.out.println("enter your postion by pressing  from 1-9");
                int userPosition = sc.nextInt();
                while(userPos.contains(userPosition) || machinPos.contains(userPos)){  // if user overwrite position.
                System.out.println("it's taken postion ! please enter the currect postion");
                userPosition = sc.nextInt();
                }
      
                placepiece(TicTacToeBoard, userPosition, "player");
  // for cpu             
                String result = checkWinner();
                if(result.length() > 0){
                    System.out.println(result);
                    break ;
                }

                Random rand = new Random();
                int machinePosition = rand.nextInt(9) + 1;
                while(userPos.contains(machinePosition) || machinPos.contains(machinePosition)){ //if cpu overwrite position.
              
                machinePosition = rand.nextInt(9) + 1;
                }
                placepiece(TicTacToeBoard, machinePosition, "cpu");

                printTicTacToeBoard(TicTacToeBoard);

                result = checkWinner();
                if(result.length() > 0){
                    System.out.println(result);
                    break ;
                }

                System.out.println(result);

            }
    }
    public static void printTicTacToeBoard(char [] [] TicTacToeBoard){
        for (char[] row : TicTacToeBoard){
            for(char c : row){                      //for printing TicTacToeBoard running loop
                System.out.print(c);
            }
            System.out.println();

        }
    }

    public static void placepiece(char [] [] TicTacToeBoard , int pos, String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            userPos.add(pos);                       // placing condition for symbol 
        }else if (user.equals("cpu")){
            symbol = 'O';
            machinPos.add(pos);
        }
// putting value in this all selected box.
        switch(pos){
            case 1 :
                TicTacToeBoard [0][0]=symbol;
                break ;
            case 2 :
                TicTacToeBoard [0][2]=symbol;
                break ;
            case 3 :
                TicTacToeBoard [0][4]=symbol;
                break ;
            case 4 :
                TicTacToeBoard [2][0]=symbol;
                break ;
            case 5 :
                TicTacToeBoard [2][2]=symbol;
                break ;
            case 6 :
                TicTacToeBoard [2][4]=symbol;
                break ;
            case 7 :
                TicTacToeBoard [4][0]=symbol;
                break ;
            case 8 :
               TicTacToeBoard [4][2]=symbol;
                break ;
            case 9 :
                TicTacToeBoard [4][4]=symbol;
                break ;
        }
    }


    // Decalring all the winning positions
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List lowRow = Arrays.asList(7,8,9);
        List Col1 = Arrays.asList(1,4,7);
        List Col2 = Arrays.asList(2,5,8);
        List Col3 = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(lowRow);
        winning.add(Col1);
        winning.add(Col2);
        winning.add(Col3);
        winning.add(cross1);
        winning.add(cross2);
        
        for(List l : winning ){
            if(userPos.containsAll(l)){
                return "player Won ";
            }else if(machinPos.containsAll(l)){
                return "cpu Won";
            }else if(userPos.size() + machinPos.size() == 9){
                return "Match Tie";
            }            
        }

        return "";

    }

}