import java.io.*;
import java.util.*;
public class UWUSourceCode {
    //best interpreter guys
    private static int[] heapSpace = new int[64];
    private static int readLine=0;
    private static int memLoc=0;
    public static int evalExp(String expression){
        switch(expression){
            case "jacobisshort":
                System.out.println("jacob is short!!!");
                break;
            default:
                System.out.println("\033[1m\033[31mError\033[0m\033[0m: Syntax error on token: "+expression);
                return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String filename;
        try{
            filename = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Enter file name to be read from > ");
            filename = stdin.nextLine();
        }
        //code to be executed
        ArrayList<String> commands = new ArrayList<String>();
        //standard input scanner
        try{
            File readInput = new File(filename);
            //read file scanner
            Scanner fileIn = new Scanner(readInput);
            while (fileIn.hasNext()){
                //adds more commands (yayyyyy)
                commands.add(fileIn.next());
            }
            fileIn.close();
            for (readLine=0; readLine<commands.size(); readLine++){
                evalExp(commands.get(readLine));
            }
        }catch (IOException e){
            System.out.println("\033[1m\033[31mError\033[0m\033[0m: Unidentified input files for uwu: "+filename);
        }
        stdin.close();
    }
}
