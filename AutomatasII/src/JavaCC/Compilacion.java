package JavaCC;

import static JavaCC.perl.mensajeLex;
import static JavaCC.perl.mensajeSem;
import static JavaCC.perl.mensajeSint;
import static JavaCC.perl.DIR;

/**
 *
 * @author Fernando Guerrero Montero
 */
public class Compilacion {
    
    public static String compilar(String archivo){
        String mensaje = "";
        perl analiza;
        mensajeSint = "";
        mensajeLex = "";
        mensajeSem = "";
        String ruta = DIR;
        String codigo = ruta + "\\" + archivo;
        Boolean band = true;
        if(!archivo.equals("")) {
            try{
                    analiza = new perl (new java.io.FileInputStream(codigo));
                    analiza.archSint_crear(ruta+"\\ErrorSint.txt");
                    analiza.perl();
                    analiza.archSint_escribe(mensajeSint);
                    analiza.archSint_cerrar();
                    analiza.archSem_crear(ruta+"\\ErrorSem.txt");
                    analiza.archSem_escribe(mensajeSem);
                    analiza.archSem_cerrar();
            }catch (java.io.FileNotFoundException e){
                    System.out.println("No se pudo leer el archivo :   " + archivo + " ");
                    band = false;
            } catch (ParseException ex) {
                System.out.println("Error ParseException");;
            }
            try{
                    analiza = new perl (new java.io.FileInputStream(codigo));
                    analiza.archtoken_crear(ruta+"\\Tokens.txt");
                    analiza.input(analiza);
                    analiza.archtoken_cerrar();
                    analiza.archtoken_crear(ruta+"\\ErrorLex.txt");
                    analiza.archtoken_escribe(mensajeLex);
                    analiza.archtoken_cerrar();
            } catch (java.io.FileNotFoundException e){
                    System.out.println("No se pudo leer el archivo :   " + archivo + " ");
                    band = false;
            } catch (ParseException ex) {
                System.out.println("Error ParseException");;
            }
        }
        else{
                System.out.println("Formato: java perl ejemplo.pl");
                mensaje = "No se selecciono ningun archivo!";
                band = false;
        }
        if(mensajeLex.isEmpty() && mensajeSint.isEmpty() && mensajeSem.isEmpty() && band){
                System.out.println("Compilacion exitosa.");
                mensaje = "Compilacion exitosa.";
        }
        else {
                if(!mensajeLex.isEmpty()) {System.out.println("Hay errores lexicos.");mensaje+="Hay errores lexicos.\n";}
                if(!mensajeSint.isEmpty()) {System.out.println("Hay errores sintacticos.");mensaje+="Hay errores sintacticos.\n";}
                if(!mensajeSem.isEmpty()) {System.out.println("Hay errores semanticos.");mensaje+="Hay errores semanticos.";}
        }
        return mensaje;
    }
}