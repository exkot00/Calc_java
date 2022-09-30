import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void errCheck(int a,int b) throws IOException {
        if ((1<=a && a<=10) && (1<=b && b<=10)){
           // System.out.println("Корректные числа");
        }else {
            throw new IOException("Введите числа от 1 до 10");
    }
    }

    public static String calc(String input)  throws IOException {
        char operation = 0;
        int operationCount=0;

        System.out.print("Ввод: ");
        Scanner input1 = new Scanner(System.in);
        String string = input1.nextLine();


        char[] chars = new char[string.length()];
        for (int i=0; i< string.length(); i++) {
            chars[i] = string.charAt(i);

            if (chars[i] == '+') {
                operation = '+';
                operationCount = operationCount + 1;
            } else if (chars[i] == '-') {
                operation = '-';
                operationCount = operationCount + 1;
            } else if (chars[i] == '*') {
                operation = '*';
                operationCount = operationCount + 1;
            } else if (chars[i] == '/') {
                operation = '/';
                operationCount = operationCount + 1;
            }

            if (operationCount > 1) {
                throw new IOException("укажи только 1 знак операции");
            }
        }

        String[] rome = { "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] arab = {"0","1","2","3","4","5","6","7","8","9","10","11", "12", "13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};

        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        boolean check=false;
        boolean check1=false;
        String otvetstring = null;

        if (operation=='+') {
            String[] strings = string.split("\\+");
            for (int i=1; i < rome.length; i++){
                if (strings[0].equals(rome[i]) ){
                    num1=Integer.parseInt(arab[i]);
                    // System.out.println("замена значения на арабское (1переменная)");
                    check=true;
                }
            }

            if (!check) {
                num1 = Integer.parseInt(strings[0]);
            }

            for (int i=1; i < rome.length; i++){
                if (strings[1].equals(rome[i]) ){
                    num2=Integer.parseInt(arab[i]);
                    // System.out.println("замена значения на арабское(2переменная)");
                    check1=true;
                }
            }
            if (!check1) {
                num2 = Integer.parseInt(strings[1]);
            }

            if (check != check1){
                throw new IOException("Нельзя использовать одновременно римские и арабские числа");
            }
            errCheck(num1,num2); //проверка на 1-10
            int c = num1 + num2;
            String sumstring = Integer.toString(c);
            String sumsum = null;
            if (check){
                for (int i=1; i < arab.length; i++){
                    if (sumstring.equals(arab[i]) ) {
                        sumsum=sumstring.replace(sumstring,rome[i]);
                        otvetstring= sumsum;
                    }
                }
            }else {
                otvetstring=sumstring;
            }
        } else if (operation=='-') {
            String[] strings = string.split("\\-");
            for (int i=1; i < rome.length; i++){
                if (strings[0].equals(rome[i]) ){
                    num1=Integer.parseInt(arab[i]);
                    //System.out.println("замена значения на арабское (1переменная)");
                    check=true;
                }

            }
            if (!check) {
                num1 = Integer.parseInt(strings[0]);
            }

            for (int i=1; i < rome.length; i++){
                if (strings[1].equals(rome[i]) ){
                    num2=Integer.parseInt(arab[i]);
                    //  System.out.println("замена значения на арабское(2переменная)");
                    check1=true;
                }
            }
            if (!check1) {
                num2 = Integer.parseInt(strings[1]);
            }
            if (check != check1){
                throw new IOException("Нельзя использовать одновременно римские и арабские числа");
            }
            errCheck(num1,num2); //проверка на 1-10
            int c = num1 - num2;
            String sumstring = Integer.toString(c);
            String sumsum = "Ошибка";
            if (check ){
                if (c<1) {
                    throw new IOException("ответ не может быть отрицательным либо 0 (римские)");
                }
                for (int i=1; i < arab.length; i++){
                    if (sumstring.equals(arab[i]) ) {
                        sumsum=sumstring.replace(sumstring,rome[i]);
                        otvetstring=sumsum;
                    }
                }

            }else{
                otvetstring=sumstring;
            }


        }else   if (operation=='*') {
            String[] strings = string.split("\\*");
            for (int i=1; i < rome.length; i++){
                if (strings[0].equals(rome[i]) ){
                    num1=Integer.parseInt(arab[i]);
                    //   System.out.println("замена значения на арабское (1переменная)");
                    check=true;
                }
            }
            if (!check) {
                num1 = Integer.parseInt(strings[0]);
            }
            for (int i=1; i < rome.length; i++){
                if (strings[1].equals(rome[i]) ){
                    num2=Integer.parseInt(arab[i]);
                    //    System.out.println("замена значения на арабское(2переменная)");
                    check1=true;
                }
            }
            if (!check1) {
                num2 = Integer.parseInt(strings[1]);
            }
            if (check != check1){
                throw new IOException("Нельзя использовать одновременно римские и арабские числа");
            }
            errCheck(num1,num2); //проверка на 1-10
            int c = num1 * num2;
            String sumstring = Integer.toString(c);
            String sumsum = null;
            if (check){
                if (c<1) {
                    throw new IOException("ответ не может быть отрицательным либо 0 (римские)");
                }
                for (int i=1; i < arab.length; i++){
                    if (sumstring.equals(arab[i]) ) {
                        sumsum=sumstring.replace(sumstring,rome[i]);
                        otvetstring=sumsum;
                        //    System.out.println("замена значения обратно на римское (сумма)");
                    }
                }}else{
                otvetstring=sumstring;
            }


        } else   if (operation=='/') {
            String[] strings = string.split("\\/");
            for (int i=1; i < rome.length; i++){
                if (strings[0].equals(rome[i]) ){
                    num1=Integer.parseInt(arab[i]);
                    //   System.out.println("замена значения на арабское (1переменная)");
                    check=true;
                }
            }
            if (!check) {
                num1 = Integer.parseInt(strings[0]);
            }
            for (int i=1; i < rome.length; i++){
                if (strings[1].equals(rome[i]) ){
                    num2=Integer.parseInt(arab[i]);
                    //    System.out.println("замена значения на арабское(2переменная)");
                    check1=true;
                }
            }
            if (!check1) {
                num2 = Integer.parseInt(strings[1]);
            }
            if (check != check1){
                throw new IOException("Нельзя использовать одновременно римские и арабские числа");
            }
            errCheck(num1,num2); //проверка на 1-10
            int c = num1 / num2;
            String sumstring = Integer.toString(c);
            String sumsum = null;
            if (check){
                if (c<1) {
                    throw new IOException("ответ не может быть отрицательным либо 0 (римские)");
                }
                for (int i=1; i < arab.length; i++){
                    if (sumstring.equals(arab[i]) ) {
                        sumsum=sumstring.replace(sumstring,rome[i]);
                        otvetstring=sumsum;
                        //    System.out.println("замена значения обратно на римское (сумма)");
                    }}
            }else{
                otvetstring=sumstring;
            }
        }
       return otvetstring;
    }

    public static void main(String[] args)  throws IOException {

        String otvet=null;
        System.out.println( calc(otvet));
    }
}
