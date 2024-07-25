import java.io.*; 
import java.util.*;
public class UWUSourceCode {
    //best interpreter guys real
    /*
     * heapSpace -> main memory
     * readLine -> command the interpreter is executing
     * memLoc -> where read and write will do their thing
     * debugMode -> toggles debug mode 
     * stdin -> standard input scanner
     */
    private static int[] heapSpace = new int[8];
    private static int readLine=0;
    private static int memLoc=0;
    private static boolean debugMode = false;
    private static Scanner stdin = new Scanner(System.in);
    private static ArrayList<String> commands = new ArrayList<String>();
    //cleans up index errors
    public static int clamp(int val, int min, int max)
    {
        if (val > max)
        {
            val = min;
        }
        if (val < min)
        {
            val = max;
        }

        return val;
    }
    public static int evalExp(String expression){
        //commenting
        if (expression.charAt(0)=='~'){
            return 0;
        }
        //command execution
        switch(expression){
            case "UWU":
                memLoc = clamp(memLoc + 1, 0, heapSpace.length-1);
                break;
            case "UwU":
                memLoc = clamp(memLoc - 1, 0, heapSpace.length-1);
                break;
            case "uwu":
                heapSpace[memLoc] = clamp(heapSpace[memLoc] + 1, 0, 127);
                break;
            case "uWu":
                heapSpace[memLoc] = clamp(heapSpace[memLoc] - 1, 0, 127);
                break;
            case "uWU":
                heapSpace[memLoc]=stdin.nextInt();
                break;
            case "uwU":
                heapSpace[memLoc]=stdin.next().charAt(0);
                break;
            case "UWu":
                System.out.println(heapSpace[memLoc]);
                break;
            case "Uwu":
                System.out.printf("%c",heapSpace[memLoc]);
                break;
            case "owo":
                int loopStart=readLine+1;
                readLine++;
                while (heapSpace[memLoc]!=0){
                    int returnCode = evalExp(commands.get(readLine));
                    if (returnCode==2){
                        readLine=loopStart;
                    }else{
                        readLine++;
                    }
                }
                break;
            case "OWO":
                return 2;
            default:
                System.out.println("\033[1m\033[31mError\033[0m\033[0m: Command not found error on token: "+ expression);
                return 1;
        }

        if (debugMode)
        {
            System.out.print("<Debug statement for input:"+expression+"> memLoc: " + memLoc + ", heap: ");
            for (int num : heapSpace)
            {
                System.out.print(" " + num);
            }
            System.out.println();
        }
        return 0;
    }
    public static void main(String[] args){
        String filename;
        //if you provided an argument for the interpreter, runs that file, else prompts for another file
        try{
            filename = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.print("Enter file name to be read from > ");
            filename = stdin.nextLine();
        }
        //code to be executed
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
                //errorCode checks if the execution runs into errors 
                //1 -> error!
                //0 -> no error can continue execution
                int errorCode = evalExp(commands.get(readLine));
                if (errorCode==1){
                    break;
                }
            }
        }catch (IOException e){
            //if the file that we want to run doesn't exist, we throw an error.
            System.out.println("\033[1m\033[31mError\033[0m\033[0m: Unidentified input files for uwu: "+filename);
        }
        stdin.close();
    }
}
