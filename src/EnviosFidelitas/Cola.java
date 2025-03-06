package EnviosFidelitas;
 
import javax.swing.JOptionPane;

public class Cola {

    private Nodo inicio;
    private Nodo fin;

    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insercion() {
        Paquete p = new Paquete();
        int nuevoId;
        do {
            nuevoId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paquete: "));
            if (buscarPaquete(nuevoId)) {
                JOptionPane.showMessageDialog(null, "ID de paquete ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (buscarPaquete(nuevoId));
        p.setId(nuevoId);
        p.setEstadoPaquete(JOptionPane.showInputDialog("Ingrese el estado del paquete (en buen estado/dañado): "));
        Nodo nuevo = new Nodo();
        nuevo.setElemento(p);
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public void eliminacion() {
    if (vacia()) {
        JOptionPane.showMessageDialog(null, "No hay paquetes en la cola.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    Nodo anterior = null;
    Nodo actual = inicio;
    while (actual != null) {
        if (actual.getElemento().getEstadoPaquete().equals("dañado")) {
            if (anterior == null) {
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            if (actual == fin) {
                fin = anterior;
            }
            System.out.println("Paquete dañado eliminado: " + actual.getElemento().getId());
            JOptionPane.showMessageDialog(null, "Paquete dañado eliminado.", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        anterior = actual;
        actual = actual.getSiguiente();
    }
    System.out.println("Paquete procesado: " + inicio.getElemento().getId());
    inicio = inicio.getSiguiente();
    if (inicio == null) {
        fin = null;
    }
    JOptionPane.showMessageDialog(null, "Paquete procesado y eliminado.", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
}
    public void mostrarDatos() {
        if (!vacia()) {
            String s = "";
            Nodo aux = inicio;
            while (aux != null) {
                s += "ID: " + aux.getElemento().getId() + ", Estado: " + aux.getElemento().getEstadoPaquete() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Paquetes en la cola:" + s, "Mostrar Datos", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay paquetes en la cola.", "Mostrar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean buscarPaquete(int id) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.getElemento().getId() == id) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
}
