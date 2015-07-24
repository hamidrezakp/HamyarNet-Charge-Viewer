package ir.FSco.HamyarNet_Charge_Viewer;

/**
 * Created by hamid on 05/19/2015.
 */
public class encrypt {
    public String encrypt(String text) {
        StringBuilder output = new StringBuilder();
        for (char ch : text.toCharArray()) {
            switch (ch){
                case '0':
                    output.append("q");
                    break;
                case '1':
                    output.append("w");
                    break;
                case '2':
                    output.append("e");
                    break;
                case '3':
                    output.append("r");
                    break;
                case '4':
                    output.append("t");
                    break;
                case '5':
                    output.append("y");
                    break;
                case '6':
                    output.append("u");
                    break;
                case '7':
                    output.append("i");
                    break;
                case '8':
                    output.append("o");
                    break;
                case '9':
                    output.append("p");
                    break;
                case 'a' :
                    output.append("a");
                    break;
                case 'A':
                    output.append("s");
                    break;
                case 'b' :
                    output.append("d");
                    break;
                case 'B' :
                    output.append("f");
                    break;
                case 'c' :
                    output.append("g");
                    break;
                case 'C' :
                    output.append("h");
                    break;
                case 'd' :
                    output.append("j");
                    break;
                case 'D' :
                    output.append("k");
                    break;
                case 'e' :
                    output.append("l");
                    break;
                case 'E':
                    output.append("z");
                    break;
                case 'f' :
                    output.append("x");
                    break;
                case 'F':
                    output.append("c");
                    break;
                case 'g' :
                    output.append("v");
                    break;
                case 'G':
                    output.append("b");
                    break;
                case 'h' :
                    output.append("n");
                    break;
                case 'H':
                    output.append("m");
                    break;
                case 'i' :
                    output.append("Q");
                    break;
                case 'I':
                    output.append("W");
                    break;
                case 'j' :
                    output.append("E");
                    break;
                case 'J':
                    output.append("R");
                    break;
                case 'k' :
                    output.append("T");
                    break;
                case 'K':
                    output.append("Y");
                    break;
                case 'l' :
                    output.append("U");
                    break;
                case 'L':
                    output.append("I");
                    break;
                case 'm' :
                    output.append("O");
                    break;
                case 'M':
                    output.append("P");
                    break;
                case 'n' :
                    output.append("A");
                    break;
                case 'N':
                    output.append("S");
                    break;
                case 'o' :
                    output.append("D");
                    break;
                case 'O':
                    output.append("F");
                    break;
                case 'p' :
                    output.append("G");
                    break;
                case 'P':
                    output.append("H");
                    break;
                case 'q' :
                    output.append("J");
                    break;
                case 'Q':
                    output.append("K");
                    break;
                case 'r' :
                    output.append("L");
                    break;
                case 'R':
                    output.append("Z");
                    break;
                case 's' :
                    output.append("X");
                    break;
                case 'S':
                    output.append("C");
                    break;
                case 't' :
                    output.append("V");
                    break;
                case 'T':
                    output.append("B");
                    break;
                case 'u' :
                    output.append("N");
                    break;
                case 'U':
                    output.append("M");
                    break;
                case 'v' :
                    output.append("1");
                    break;
                case 'V':
                    output.append("2");
                    break;
                case 'w' :
                    output.append("3");
                    break;
                case 'W':
                    output.append("4");
                    break;
                case 'y' :
                    output.append("5");
                    break;
                case 'Y':
                    output.append("6");
                    break;
                case 'z' :
                    output.append("7");
                    break;
                case 'Z':
                    output.append("8");
                    break;
                default:
                    output.append(ch);


            }
        }
        return output.toString();
    }

    public String decrypt(String text) {
        StringBuilder output = new StringBuilder();
        for (char ch : text.toCharArray()) {
            switch (ch){
                case 'q':
                    output.append("0");
                    break;
                case 'w':
                    output.append("1");
                    break;
                case 'e':
                    output.append("2");
                    break;
                case 'r':
                    output.append("3");
                    break;
                case 't':
                    output.append("4");
                    break;
                case 'y':
                    output.append("5");
                    break;
                case 'u':
                    output.append("6");
                    break;
                case 'i':
                    output.append("7");
                    break;
                case 'o':
                    output.append("8");
                    break;
                case 'p':
                    output.append("9");
                    break;
                case 'a' :
                    output.append("a");
                    break;
                case 's':
                    output.append("A");
                    break;
                case 'd' :
                    output.append("b");
                    break;
                case 'f' :
                    output.append("B");
                    break;
                case 'g' :
                    output.append("c");
                    break;
                case 'h' :
                    output.append("C");
                    break;
                case 'j' :
                    output.append("d");
                    break;
                case 'k' :
                    output.append("D");
                    break;
                case 'l' :
                    output.append("e");
                    break;
                case 'z':
                    output.append("E");
                    break;
                case 'x' :
                    output.append("f");
                    break;
                case 'c':
                    output.append("F");
                    break;
                case 'v' :
                    output.append("g");
                    break;
                case 'b':
                    output.append("G");
                    break;
                case 'n' :
                    output.append("h");
                    break;
                case 'm':
                    output.append("H");
                    break;
                case 'Q' :
                    output.append("i");
                    break;
                case 'W':
                    output.append("I");
                    break;
                case 'E' :
                    output.append("j");
                    break;
                case 'R':
                    output.append("J");
                    break;
                case 'T' :
                    output.append("k");
                    break;
                case 'Y':
                    output.append("K");
                    break;
                case 'U' :
                    output.append("l");
                    break;
                case 'I':
                    output.append("L");
                    break;
                case 'O' :
                    output.append("m");
                    break;
                case 'P':
                    output.append("M");
                    break;
                case 'A' :
                    output.append("n");
                    break;
                case 'S':
                    output.append("N");
                    break;
                case 'D' :
                    output.append("o");
                    break;
                case 'F':
                    output.append("O");
                    break;
                case 'G' :
                    output.append("p");
                    break;
                case 'H':
                    output.append("P");
                    break;
                case 'J' :
                    output.append("q");
                    break;
                case 'K':
                    output.append("Q");
                    break;
                case 'L' :
                    output.append("r");
                    break;
                case 'Z':
                    output.append("R");
                    break;
                case 'X' :
                    output.append("s");
                    break;
                case 'C':
                    output.append("S");
                    break;
                case 'V' :
                    output.append("t");
                    break;
                case 'B':
                    output.append("T");
                    break;
                case 'N' :
                    output.append("u");
                    break;
                case 'M':
                    output.append("U");
                    break;
                case '1' :
                    output.append("v");
                    break;
                case '2':
                    output.append("V");
                    break;
                case '3' :
                    output.append("w");
                    break;
                case '4':
                    output.append("W");
                    break;
                case '5' :
                    output.append("y");
                    break;
                case '6':
                    output.append("Y");
                    break;
                case '7' :
                    output.append("z");
                    break;
                case '8':
                    output.append("Z");
                    break;
                default:
                    output.append(ch);


            }
        }
        return output.toString();
    }
}
