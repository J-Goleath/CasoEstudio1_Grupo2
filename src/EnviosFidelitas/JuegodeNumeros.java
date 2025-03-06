package EnviosFidelitas;

/**
 *
 * @author jgoleath
 */
import javax.swing.JOptionPane;

public class JuegodeNumeros {

    public void iniciarJuego() {
        String input = JOptionPane.showInputDialog("Ingrese un número:");
        try {
            int numero = Integer.parseInt(input);
            if (numero < 0) {
                JOptionPane.showMessageDialog(null, "El número tiene que ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int suma = sumaDigitos(numero);
            JOptionPane.showMessageDialog(null, "La suma de los dígitos de " + numero + " es:" + suma, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private int sumaDigitos(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sumaDigitos(n / 10);
    }
}