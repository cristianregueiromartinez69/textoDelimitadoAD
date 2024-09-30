
package textodeli;
import javax.swing.JOptionPane;

/**
 * clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {


    public static void main(String[] args) {

        //instanciamos el objeto
        EscrituraFichero ef = new EscrituraFichero();

        //pedimos al usuario que introduzca la ruta
        String ruta = JOptionPane.showInputDialog("Introduce la ruta del fichero, si no existe se creará automaticamente: ");

        ef.writeFile(ruta);
        ef.readFile(ruta);

    }
    
}
