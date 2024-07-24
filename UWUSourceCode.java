import java.io.*;
import java.util.*;
public class UWUSourceCode {
    //best interpreter guys
    /*
     * heapSpace -> main memory
     * readLine -> command the interpreter is executing
     * memLoc -> where read and write will do their thing
     */
    private static int[] heapSpace = new int[64];
    private static int readLine=0;
    private static int memLoc=0;
    public static int evalExp(String expression){
        //commenting
        if (expression.charAt(0)=='~'){
            return 0;
        }
        //command execution
        switch(expression){
            case "jacobisshort":
                System.out.println("jacob is short!!!");
                break;
            default:
                System.out.println("\033[1m\033[31mError\033[0m\033[0m: Command not found error on token: "+ expression);
                return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        
        //standard input scanner
        Scanner stdin = new Scanner(System.in);
        String filename;
        //if you provided an argument for the interpreter, runs that file, else prompts for another file
        try{
            filename = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Enter file name to be read from > ");
            filename = stdin.nextLine();
        }
        //code to be executed
        ArrayList<String> commands = new ArrayList<String>();
        try{
            //initializes file reader
            File readInput = new File(filename);
            //read file scanner
            Scanner fileIn = new Scanner(readInput);
            while (fileIn.hasNext()){
                //adds more commands (yayyyyy)
                commands.add(fileIn.next());
            }
            //closes read input (whole thing has been read)
            fileIn.close();
            for (readLine=0; readLine<commands.size(); readLine++){
                //runs commands
                evalExp(commands.get(readLine));
            }
        }catch (IOException e){
            //if the file that we want to run doesn't exist, we throw an error.
            System.out.println("\033[1m\033[31mError\033[0m\033[0m: Unidentified input files for uwu: "+filename);
        }
        stdin.close();
    }
}
