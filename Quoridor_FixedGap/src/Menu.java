/**
 * Menu.java
 *
 * makeup a menu with options for player to select option with number 1-N
 * Some static functions serve as tools for other classes that need to handle IO
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String header;
    private List<String> options;

    public Menu(){
        this.header = "";
        options = new ArrayList<>();
    }

    public Menu(String header){
        this.header = header;
        options = new ArrayList<>();

    }

    // add option to menu
    public void addOption(String option){
        options.add(option);
    }

    // print menu with options
    public void printMenu(){
        System.out.println(header);
        int i = 1;

        for(String option: options){
            System.out.println(String.format("%d. %s",i++,option));
        }
    }

    // ask user to input 1-size
    public int selectOption(){
        int select = readInt(1,options.size());
        return  select;
    }

    // tool function
    // ask user to input an integer between start and end
    // Integer that is Not in this rang is valid
    public static int readInt(int start, int end){
        String message = "Please input "+start+" - " + end + ": ";
        int n = 0;

        while (true){
            System.out.print(message);
            boolean flag = false;
            try{
                n = new Scanner(System.in).nextInt();
            }catch(Exception e){
                System.out.print("Invalid. ");
                flag = true;
            }
            if(flag){
                continue;
            }
            if(n >= start && n <= end){
                break;
            }
            System.out.print("Invalid. ");
        }
       return n;
    }

    // tool function
    // read a line from console, then get the first character,
    // and return it with lower case.
    public static char readAChar(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        String c = sc.next().toLowerCase();

        return c.charAt(0);
    }
}
