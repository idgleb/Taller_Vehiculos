import javax.swing.*;

public class Auto extends Vehiculos {
    private int numeroPuertos;


    public Auto(String marca, int ano, int numeroPuerto) {
        super(marca, ano);
        this.numeroPuertos = numeroPuerto;
    }

    public int getNumeroPuertos() {
        return numeroPuertos;
    }

    public void setNumeroPuertos(int numeroPuertos) {
        this.numeroPuertos = numeroPuertos;
    }


    @Override
    public String revisarPartes() {
        String resultado = "";

        String motor = revisarMotor();
        if (motor.equals("cancel")){
            return "cancel";
        }else {
            resultado+=motor + ", ";
        }

        String puertas = revisarPuertas();
        if (puertas.equals("cancel")){
            return "cancel";
        }else {
            resultado+=puertas;
        }

        return resultado;
    }

    private String revisarPuertas() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Puersas bien?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return "Puertas bien";
        } else if (respuesta == JOptionPane.NO_OPTION) {
            return "Puertas mal";
        }
        return "cancel";
    }

    private String revisarMotor() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Motor bien?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return "Motor bien";
        } else if (respuesta == JOptionPane.NO_OPTION) {
            return "Motor mal";
        }
        return "cancel";
    }

    @Override
    public String toString() {
        return "Auto{" +
                "numeroPuertos=" + numeroPuertos +
                "} " + super.toString();
    }
}
