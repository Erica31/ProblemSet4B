
/**
 * Solution and Driver to ProblemSet4B
 *
 * @author Erica Lee
 * @version Oct 23, 2023
*/

import java.util.Scanner;
public class mySoln
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        //PALINDRONE PORTION
        System.out.print("Enter suspicious palindrome: ");
        String str = input.nextLine();
        String lc = str.toLowerCase();
        String end = "";
        
        String nonLetters = ",.:;()[]{}!?@#$%^&* ";
        for (int i=0; i<str.length(); i++){
            String letter = lc.substring(i,i+1);
            if (nonLetters.contains(letter)){
                end += letter.substring(0, letter.length()-1);
            }else end += letter;
        }
        
        //System.out.println(end);//should be purely letters
        
        String fwd = "";
        String back = "";
        boolean palindrome=false;
        for (int i=0; i<end.length(); i++){
            fwd = end.substring(i, i+1);
            back = end.substring(end.length()-i-1, end.length()-i);
            if(!fwd.equals(back)) palindrome = false;
            else palindrome = true;
        }
        System.out.print("Palindrome? ");
        System.out.println(palindrome+"!\n");
        
        
        //PIGLATIN TRANSLATION
        System.out.print("Enter to translate: ");
        String in = input.nextLine();
        int space = in.indexOf(" ");
        int last = 0;
        end = "";
        
        while(space != -1){
            String word = in.substring(last, space);
            last = space + 1;
            end+=translate(word);
            space = in.indexOf(" ", last);
        }
        System.out.println("Pig Latin: "+end+translate(in.substring(last, in.length()))+"\n");
        
        
        //STRICTLY ASCENDING NUMBERS
        System.out.println("Enter to find # of Strictly ascending numbers");
        System.out.print("Min: ");
        int min = input.nextInt();
        System.out.print("Max: ");
        int max = input.nextInt();
        int count = 0;
        
        for(int i=min; i<max; i++){
            int num = i;
            int digit = num %10;
            if(num==digit)
            count+=1;
            else{
                int compynum = num;
                while(num>0){
                    int digit2=num%10;
                    int nextdig = num/10%10;
                    if(digit2>nextdig)
                        num = num/10;
                    else num=-1;
                }
                if(num == 0) count +=1;
            }
        }
        System.out.println("COUNT = "+count+"\n");
        
        
        //TIMES TABLES
        System.out.print("Enter n for xTable: ");
        int n = input.nextInt();
        int i=1;
        String spa=" ";
        
        while(i<=n){
            for(int x=1;x<=n;x++){
                int num = x*i;
                if(n<10){
                    if(num<10)spa="  ";
                    else spa=" ";
                }else if(n<100){
                    if(num<10)spa="   ";
                    else if(num<100)spa="  ";
                    else spa=" ";
                }
                System.out.print(spa+num);
            }
            i++;
            System.out.println();
        }
    }
    
    public static String translate(String pig){
        String word = "";
        if(pig.length()>2){
            word = pig.substring(1, pig.length());
            word += pig.charAt(0)+"ay ";
            return word;
        }else return pig+" ";
    }
    
}
