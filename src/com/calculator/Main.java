package com.calculator;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    static String defLang = "";
    static String [] ARA = {"0","1","2","3","4","5","6","7","8","9","10"};
    static String [] ROM = {"", "I","II","III","IV","V","VI","VII","VIII","IX","X"};
    static String[] OPR = new String[5];
    static String[] Numbers = new String[5];
    static int error = 0;

    /* Сообщения об ошибках */
    static String [] errorText = {
    /*0*/       "Нет ошибок",
    /*1*/       "Не правильный ввод чисел",
    /*2*/       "Не правильный ввод чисел, допустимые значения для ввода от 1 до 10 или I II III ... X",
    /*3*/       "",
    /*4*/       "",
    /*5*/       "",
    /*6*/       ""
            };

    public static void main(String [] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        String str = in.next();

        // проверка ввода на знаки(+ - * /) и значения(цифры) собираем в массив
        Main.checkOperation(str);

        var c = Arrays.deepToString(OPR);
        System.out.print(c);

        var n = Arrays.deepToString(Numbers);
        System.out.print(n);

        if(OPR.length>=Numbers.length) {
            error = 2;
            ShowError();
        }

        if(!defLang.equals("err")) {

            System.out.println();
            System.out.println(defLang);

            Main.calc();

        } else {
            ShowError();
        }

        in.close();
    }

    static void ShowError() {
        System.out.println();
        System.out.print(errorText[error]);
    }

    //static boolean check_naumbers([] )

    static void checkOperation(String str) {
        String[] operators = {"-","+","/","*"};
        String curNumber = "";

        str = str.trim();

        var index = str.length() - 1;
        var i = 0;

        var o = 0;

        while (i <= index) {
            var j = 0;
            var oper = Character.toString( str.charAt(i));

            System.out.println("------------");
            System.out.println(oper);
            System.out.println(oper.length());
            System.out.println("------------");

            var v = Main.checkIsVal(oper);

            if (v >= 0) {

                if(defLang.equals("arab")) {
                    curNumber += v;
                }

                if(defLang.equals("rome")) {
                    curNumber += oper;
                }

                if(i == index) {
                    Numbers[o] = curNumber;
                }


            } else {

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
                //System.out.println("Error charcters wrong");
                //errr
            }





            i++;
        }


    }

    static int checkIsVal(String a) {
        var resStr = "";
        var is_rome = 0;
        var is_arab = 0;
        var i = 1;
        var romeIndex = 0;

        System.out.println("oper " + a);

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
                romeIndex = i;
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

            if(is_arab > 0) {
                return parseInt(a);
            }
            if(is_rome > 0) {
                return romeIndex;
            }

        } else {
            return -1;
        }

        return 0;
    }

    static void calc() {
        int result = 0;

        if(defLang.equals("arab")) {
            var i = 0;
            while (i <= OPR.length - 1) {
                //if(O)

                if(OPR[i] != null) {
                    int a = parseInt(Numbers[i]);
                    int b = parseInt(Numbers[i+1]);

                    if(OPR[i].equals("+")) result = result == 0 ? a + b : result + b;
                    if(OPR[i].equals("-")) result = result == 0 ? a - b : result - b;
                    if(OPR[i].equals("/")) result = result == 0 ? a / b : result / b;
                    if(OPR[i].equals("*")) result = result == 0 ? a * b : result * b;

                }
                i++;
            }

            System.out.println("Результат: " + result);
        }

        if(defLang.equals("rome")) {

        }

        var i = 0;
        while (i <= OPR.length - 1) {

            if(OPR[i] != null) {

            }

            i++;
        }
    }


}
