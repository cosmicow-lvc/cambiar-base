import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        String opcion = "-1";
        while (!opcion.equals("0")){
            System.out.println("OPcionxd");
            opcion = menu.next();
            System.out.println("base original");
            String xd2 = menu.next();
            System.out.println("base objetivo");
            String xd3 = menu.next();
            System.out.println("numero");
            String xd4 = menu.next();
            System.out.println();
        }
    }

    public static String cambiarBase10(String original, String numero){
        double resultado1 = 0;
        //Chequeamos si el numero tiene decimales
        if (numero.contains(".")){
            String[] splitNumero = numero.split("\\.");
            int largoEntero = splitNumero[0].length(); //Largo de la parte entera del numero
            int largoDecimal = splitNumero[1].length(); //Largo de la parte decimal del numero
            //Usamos la formula de conversion digito * base^n
            for (int i = 0; i < largoEntero; i++){
                Double digito = Double.valueOf(String.valueOf(numero.charAt(i)));
                resultado1 += digito*Math.pow(Double.valueOf(original),largoEntero-i-1);
            }
            for (int i = 0; i < largoDecimal; i++){
                Double digito = Double.valueOf(String.valueOf(numero.charAt(i)));
                resultado1 += digito/Math.pow(Double.valueOf(original),i+1);
            }
        //Caso por si el numero es entero
        } else {
            int largo = numero.length();
            for (int i = 0; i < largo; i++){
                Double digito = Double.valueOf(String.valueOf(numero.charAt(i)));
                resultado1 += digito*Math.pow(Double.valueOf(original),largo-i-1);
            }
        }
        return String.valueOf(resultado1);
    }
}