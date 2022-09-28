import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {


    public static void errCheck(int a,int b) {
        if ((1<=a && a<=10) && (1<=b && b<=10)){
           // System.out.println("Корректные числа");
        }else {
            System.out.println("Ошибка! Введите числа от 1 до 10");
            System.exit(1);}
    }



    public static void main(String[] args) {

        char operation = 0;
        int operationCount=0;

        System.out.println("Ввод: ");
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();


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
                System.exit(1);
            }
        }

        String[] rome = { "0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI"};
        String[] arab = {"0","1","2","3","4","5","6","7","8","9","10","11"};

        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        boolean check=false;
        boolean check1=false;

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
            errCheck(num1,num2); //проверка на 1-10
            int c = num1 + num2;
            String sumstring = Integer.toString(c);
            String sumsum = null;
            if (check){
            for (int i=1; i < arab.length; i++){
                if (sumstring.equals(arab[i]) ) {
                    sumsum=sumstring.replace(sumstring,rome[i]);
                    System.out.println("Ответ: " + sumsum);
                }
            }
            }else {
                System.out.println("Ответ: "+ sumstring);
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

            errCheck(num1,num2); //проверка на 1-10
            int c = num1 - num2;
            String sumstring = Integer.toString(c);
            String sumsum = "Ошибка";
            if (check){
            for (int i=1; i < arab.length; i++){
                if (sumstring.equals(arab[i]) ) {
                    sumsum=sumstring.replace(sumstring,rome[i]);
                 //   System.out.println("замена значения обратно на римское (сумма)");
                }
            }
                if (sumsum !="null"){
                System.out.println("Ответ: " + sumsum);}

            }else{
                System.out.println("Ответ: " + sumstring);
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

            errCheck(num1,num2); //проверка на 1-10
            int c = num1 * num2;
            String sumstring = Integer.toString(c);
            String sumsum = null;
            if (check){
            for (int i=1; i < arab.length; i++){
                if (sumstring.equals(arab[i]) ) {
                    sumsum=sumstring.replace(sumstring,rome[i]);
                    System.out.println("Ответ: " + sumsum);
                    //    System.out.println("замена значения обратно на римское (сумма)");
                }
            }}else{
                System.out.println("Ответ: " + c);
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
            errCheck(num1,num2); //проверка на 1-10
            int c = num1 / num2;
            String sumstring = Integer.toString(c);
            String sumsum = null;
            if (check){
            for (int i=1; i < arab.length; i++){
                if (sumstring.equals(arab[i]) ) {
                    sumsum=sumstring.replace(sumstring,rome[i]);
                    System.out.println("Ответ: " + sumsum);
                    //    System.out.println("замена значения обратно на римское (сумма)");
                }}
            }else{
                    System.out.println("Ответ: " + sumstring);
                }

        }
    }

}
