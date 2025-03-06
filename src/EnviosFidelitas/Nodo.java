
package EnviosFidelitas;

public class Nodo {
    
    private Paquete elemento;
    private Nodo  siguiente;
    
    public Nodo(){
        this.siguiente = null;
    }

    public Paquete getElemento() {
        return elemento;
    }

    public void setElemento(Paquete elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
