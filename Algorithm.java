import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class Algorithm<Item> extends Stack<Item> {

    static Stack<Double> vs = new Stack<Double>(); //value stack
    static Stack<Character> os = new Stack<Character>(); //operator stack

    public static Double add(){
        return vs.pop() + vs.pop();
    }

    public static Double sub(){
        Double x = vs.pop();
        Double y = vs.pop();
        return y - x;
    }

    public static Double mul(){
        return vs.pop() * vs.pop();
    }

    public static Double div(){
        Double x = vs.pop();
        Double y = vs.pop();
        return y / x;
    }

    public static Double mod(){
        Double x = vs.pop();
        Double y = vs.pop();
        return y % x;
    }

    public static Double expPow(){
        Double exp = vs.pop();
        Double res = vs.pop();
        Math.pow(res, exp);
        return res;
    }

    public Double square(){
        return Math.sqrt(vs.pop());
    }

    public static Double calculate(String s1) {
        Double res;
        for(int i = 0; i < s1.length(); i++){
            if(isDigit(s1.charAt(i))){
                double digit = s1.charAt(i);
                vs.push(digit);
            }
            if(isDigit(s1.charAt(i)) && s1.charAt(i)!=')' && s1.charAt(i)!=' ' && s1.charAt(i)!='('){
                os.push(s1.charAt(i));
            }
            if(s1.charAt(i)==')'){
                switch (os.pop()) {
                    case '+' -> {
                        res = add();
                        vs.push(res);
                    }
                    case '-' -> {
                        res = sub();
                        vs.push(res);
                    }
                    case '*' -> {
                        res = mul();
                        vs.push(res);
                    }
                    case '/' -> {
                        res = div();
                        vs.push(res);
                    }
                    case '%' -> {
                        res = mod();
                        vs.push(res);
                    }
                    case '^' -> {
                        res = expPow();
                        vs.push(res);
                    }
                    default -> System.out.println("error");
                }
            }
        }
        return vs.pop();
    }

    public static ArrayList<Double> calculateFromFile(String filePath) throws IOException {
        ArrayList<String> expressions = readFile(filePath);
        ArrayList<Double> results = new ArrayList<>();
        for(String expr : expressions){
            for(int i = 0; i<expr.length(); i++){
                if(isDigit(i)){
                Double digit = (double) expr.charAt(i);
                vs.push(digit);
                }
                if(!isDigit(i) && i!=')' && i!=' ' && i!='('){
                os.push(expr.charAt(i));
                }
                if(i==')'){
                    switch (os.pop()) {
                        case '+' -> results.add(add());
                        case '-' -> results.add(sub());
                        case '*' -> results.add(mul());
                        case '/' -> results.add(div());
                        case '%' -> results.add(mod());
                        case '^' -> results.add(expPow());
                        default -> System.out.println("error");
                    }
                }
            }
        }
        return results;
    }

    // I can only extend one class and as I already extended the Stack class to use stacks,
    // I had to manually implement this method instead of using it from FileUtils.java
    public static ArrayList<String> readFile(String file_Path) throws IOException {
        ArrayList<String> stringArray = new ArrayList<String>(); // array holding strings
        BufferedReader bf = new BufferedReader(new FileReader(file_Path)); // load data from file
        String line = bf.readLine(); // read line as string
        // checking for end of file
        while (line != null) {
            stringArray.add(line);
            line = bf.readLine();
        }
        // closing buffer reader object
        bf.close();
        return stringArray;
    }
}