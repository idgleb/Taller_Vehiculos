import javax.swing.*;

public class Moto extends Vehiculos {
    private boolean tieneSidecar;

    public Moto(String marca, int ano, boolean tieneSidecar) {
        super(marca, ano);
        this.tieneSidecar = tieneSidecar;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public String revisarPartes() {

        String resultado = "";

        String cadena = revisarCadena();
        if (cadena.equals("null")){
            return "cancel";
        }else {
            resultado+=cadena + ", ";
        }

        String neumaticos = revisarNeumaticos();
        if (neumaticos.equals("null")){
            return "cancel";
        }else {
            resultado+=neumaticos;
        }

        return resultado;

    }

    private String revisarCadena() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Cadena bien?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return "Cadena bien";
        } else if (respuesta == JOptionPane.NO_OPTION) {
            return "Cadena mal";
        }
        return "cancel";
    }

    private String revisarNeumaticos() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Neumaticos bien?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return "Neumaticos bien";
        } else if (respuesta == JOptionPane.NO_OPTION) {
            return "Neumaticos mal";
        }
        return "cancel";
    }

    @Override
    public String toString() {
        return "Moto{" +
                "tieneSidecar=" + tieneSidecar +
                "} " + super.toString();
    }
}
