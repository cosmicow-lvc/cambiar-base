import java.util.Scanner;
public class Main {
    static String[] digitos = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J"};
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
            System.out.println(cambiarBase(xd2,xd3,xd4));
        }
    }

    private static String cambiarBase(String original, String objetivo, String numero) {
        String numeroBase10 = cambiarBase10(original,numero);
        //Chequeamos si la base objetivo es 10 para no hacer el calculo extra
        if (objetivo.equals("10")){
            return numeroBase10;
        }
        String resultado = "";
        int baseObjetivo = Integer.valueOf(objetivo);
        //Chequeamos si el numero es decimal
        if (numero.contains(".")){
            String[] splitNumero = numeroBase10.split("\\.");
            int numeroEntero = Integer.valueOf(splitNumero[0]);
            double numeroDecimal = Double.valueOf("0."+splitNumero[1]);
            while (numeroEntero >= baseObjetivo) {
                String digitoConvertido = buscarIndice(digitos,String.valueOf(numeroEntero % baseObjetivo));
                resultado = digitoConvertido + resultado;
                numeroEntero = numeroEntero / baseObjetivo;
            }
            resultado = buscarIndice(digitos,String.valueOf(numeroEntero)) + resultado + ".";
            int decimales = 0;
            //Multiplicamos el numero decimal por la base objetivo hasta que sea 1
            while (numeroDecimal * Double.valueOf(baseObjetivo) != 1 & decimales < 6){
                numeroDecimal = numeroDecimal * Double.valueOf(baseObjetivo);
                //El resultado es el entero de la parte decimal
                String digitoConvertido = buscarIndice(digitos,String.valueOf(numeroDecimal).split("\\.")[0]);
                resultado += digitoConvertido;
                //Para pasar de base tenemos que seguir ocupando la parte decimal, quitandole la parte entera
                numeroDecimal = Double.valueOf("0."+String.valueOf(numeroDecimal).split("\\.")[1]);
                decimales++;
            }
            //Caso por si el numero es entero
        } else {
            int numeroEntero = Integer.valueOf(numeroBase10.split("\\.")[0]);
            while (numeroEntero >= baseObjetivo) {
                String digitoConvertido = buscarIndice(digitos,String.valueOf(numeroEntero % baseObjetivo));
                resultado = digitoConvertido + resultado;
                numeroEntero = numeroEntero / baseObjetivo;
            }
            resultado = buscarIndice(digitos,String.valueOf(numeroEntero)) + resultado;
        }
        return resultado;
    }


    private static String cambiarBase10(String original, String numero){
        double resultado1 = 0;
        //Chequeamos si el numero tiene decimales
        if (numero.contains(".")){
            String[] splitNumero = numero.split("\\.");
            int largoEntero = splitNumero[0].length(); //Largo de la parte entera del numero
            int largoDecimal = splitNumero[1].length(); //Largo de la parte decimal del numero
            //Usamos la formula de conversion digito * base^n
            for (int i = 0; i < largoEntero; i++){
                String digitoConvertido = buscarIndice(digitos,String.valueOf(splitNumero[0].charAt(i)));
                Double digito = Double.valueOf(digitoConvertido);
                resultado1 += digito*Math.pow(Double.valueOf(original),largoEntero-i-1);
            }
            for (int i = 0; i < largoDecimal; i++){
                String digitoConvertido = buscarIndice(digitos,String.valueOf(splitNumero[1].charAt(i)));
                Double digito = Double.valueOf(digitoConvertido);
                resultado1 += digito/Math.pow(Double.valueOf(original),i+1);
            }
            resultado1 = Math.round(resultado1*1000000.0)/1000000.0;
        //Caso por si el numero es entero
        } else {
            int largo = numero.length();
            for (int i = 0; i < largo; i++){
                String digitoConvertido = buscarIndice(digitos,String.valueOf(numero.charAt(i)));
                Double digito = Double.valueOf(digitoConvertido);
                resultado1 += digito*Math.pow(Double.valueOf(original),largo-i-1);
            }
        }
        return String.valueOf(resultado1);
    }

    private static String buscarIndice(String[] digitos, String digito){
        for (int i = 0; i < digitos.length; i++){
            if (String.valueOf(i).equals(digito)){
                return digitos[i];
            }
        }
        return "No se encontro el digito";
    }
}