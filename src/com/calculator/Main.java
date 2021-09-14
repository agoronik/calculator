package com.calculator;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    static String defLang = "";
    static String [] ARA = {"1","2","3","4","5","6","7","8","9","0"};
    static String [] ROM = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
    static String[] OPR = new String[15];
    static String[] Numbers = new String[15];
    static int error = 0;
    static String [] errorText = {"Нет ошибок","Не правильный воод чисел","","","","","",};

    public static void main(String [] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String str = in.next();

        //System.out.print(str);

        Main.checkOperation(str);

        var c = Arrays.deepToString(OPR);
        System.out.print(c);

        var n = Arrays.deepToString(Numbers);
        System.out.print(n);




        if(!defLang.equals("err")) {

            System.out.println();
            System.out.println(defLang);

            Main.calc();

        } else {
            System.out.println();
            System.out.print(errorText[error]);
        }

        in.close();
    }

    static String checkOperation(String str) {
        String[] operators = {"-","+","/","*"};
        String curNumber = "";
        var index = str.length() - 1;
        var i = 0;

        var o = 0;

        while (i <= index) {
            var j = 0;
            var oper = Character.toString( str.charAt(i));
            //System.out.print(oper);

            while (j <= operators.length - 1) {
                var operToEq = operators[j];

                if(oper.equals(operToEq) ) {
                    OPR[o] = oper;
                    Numbers[o] = curNumber;
                    curNumber = "";
                    o++;
                }

                j++;
            }

            var v = Main.checkIsVal(oper);

            if (v >= 0) {
                curNumber += v;

                if(i == index) {
                    Numbers[o] = curNumber;
                }
            } else {
                System.out.println("Error charcters wrong");
                //errr
            }





            i++;
        }


        return "sdsd";
    }

    static int checkIsVal(String a) {
        var i = 0;
        var resStr = "";
        var is_rome = 0;
        var is_arab = 0;
        while(i <= ROM.length - 1) {
            if(a.equals(ROM[i])) {
                is_rome = 1;
                if(defLang.equals("arab")) {
                    defLang = "err";
                    error = 1;
                } else {
                    defLang = "rome";
                }

                resStr = ROM[i];
            }
            i++;
        }

        i = 0;
        while(i <= ARA.length - 1) {
            if(a.equals(ARA[i])) {
                is_arab = 1;
                if(defLang.equals("rome")) {
                    defLang = "err";
                    error = 1;
                } else {
                    defLang = "arab";
                }

                resStr = ARA[i];
            }
            i++;
        }

        if(resStr.equals("")) {
            return -1;
        }

        if(error == 0) {
           var res = parseInt(a);
            return res;
        } else {
            return -1;
        }


    }

    static void calc() {
        var i = 0;
        while (i <= OPR.length - 1) {

            if(OPR[i] != null) {

            }

            i++;
        }
    }
}
