import javax.swing.*;

public class Camion extends Vehiculos {
    int capacidadCarga;

    public Camion(String marca, int ano, int capacidadCarga) {
        super(marca, ano);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String revisarPartes() {

        String resultado = "";

        String carga = revisarCarga();
        if (carga.equals("null")){
            return "cancel";
        }else {
            resultado+=carga + ", ";
        }

        String frenos = revisarFrenos();
        if (frenos.equals("null")){
            return "cancel";
        }else {
            resultado+=frenos;
        }

        return resultado;

    }

    private String revisarCarga() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Carga bien?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return "Carga bien";
        } else if (respuesta == JOptionPane.NO_OPTION) {
            return "Carga mal";
        }
        return "cancel";
    }

    private String revisarFrenos() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Frenos bien?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return "Frenos bien";
        } else if (respuesta == JOptionPane.NO_OPTION) {
            return "Frenos mal";
        }
        return "cancel";
    }

    @Override
    public String toString() {
        return "Camion{" +
                "capacidadCarga=" + capacidadCarga +
                "} " + super.toString();
    }
}
