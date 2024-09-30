package textodeli;

import java.io.*;
import java.text.NumberFormat;

/**
* clase con los metodos de escribir y leer en el fichero
* @author cristian
* @version 1.0
*/
public class EscrituraFichero {

    /**
    *metodo para escribir en el fichero
    * @param el path del archivo
    */
    public void writeFile(String path) {

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        try {
            File file = new File(path);
            //preguntamos si el archivo existe para crearlo
            if (!file.exists()) {
                if (file.createNewFile()) {
                    //instanciamos los objetos
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                    NumberFormat format =  NumberFormat.getCurrencyInstance();

                    //hacemos un for como tanta sea la longitud del array
                    for (int i = 0; i < 3; i++) {
                        String formatoMoneda = format.format(prezo[i]);
                        pw.println("Codigo: " + "\t" + cod[i] + "\n" + "Descripcion: "  + desc[i] + "\n" + "precio: " + "\t" + formatoMoneda);
                    }
                    pw.close();
                }

            } else {
            //si el archio existe, lo sobreescribe
                  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

                    for (int i = 0; i < 3; i++) {

                        pw.println("Codigo: " + "\t" + cod[i] + "\n" + "Descripcion: "  + desc[i] + "\n" + "precio: " + "\t" + prezo[i]);
                    }
                    pw.close();
            }

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el archivo");
        }

    }

    /**
    *Metodo para leer el fichero
    * @param la ruta del fichero
    */
    public void readFile(String path){

        try{
            File file = new File(path);

            //si el archivo existe y si es un archivo se mete en la condicion
            if(file.exists() && file.isFile()){

                BufferedReader br = new BufferedReader(new FileReader(file));

                String linea;
                //mientras lo leido sea diferente de null, imprime el archivo
                while((linea = br.readLine()) != null){

                    System.out.println(linea);
                }
            }
            else{
                System.out.println("Ruta incorrecta");
            }

        }catch(IOException e){
            System.out.println("No existe el archivo");
        }
    }

}