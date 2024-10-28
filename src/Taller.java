import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Taller {
    private String nombre;
    private List<Mecanicos> mecanicos = new ArrayList<Mecanicos>();
    private List<Vehiculos> vehiculos = new ArrayList<>();
    private List<String> revisiones = new ArrayList<>();

    public Taller(String nombre) {
        this.nombre = nombre;
    }

    public void addMecanico() {
        String nombreMecanico = MisFunciones.pedirStrNoVacio("nombre de Mecanico?");
        if (nombreMecanico==null) return;
        mecanicos.add(new Mecanicos(nombreMecanico, this));
    }

    public void addVehiculo() {

        String[] opc = {"agregar_auto", "agregar_camion", "agregar_moto"};
        Runnable[] ac = new Runnable[]{
                () -> this.addAuto(this),
                () -> this.addCamion(this),
                () -> this.addMoto(this),
        };
        MisFunciones.interfaz(ac, opc, this::verVehiculos);
    }

    private String verVehiculos() {
        return vehiculos.toString();
    }

    private Auto addAuto(Taller taller) {
        String marca = MisFunciones.pedirStrNoVacio("marca?");
        if (marca==null) return null;
        int ano = MisFunciones.pedirNumeroMasCero("ano?");
        if (ano==-1) return null;
        int numeroPuertos = MisFunciones.pedirNumeroMasCero("numero puertos?");
        if (numeroPuertos==-1) return null;
        Auto auto = new Auto(marca, ano, numeroPuertos);
        taller.getVehiculos().add(auto);
        return auto;
    }

    private Camion addCamion(Taller taller) {
        String marca = MisFunciones.pedirStrNoVacio("marca?");
        if (marca==null) return null;
        int ano = MisFunciones.pedirNumeroMasCero("ano?");
        if (ano==-1) return null;
        int capacidadCarga = MisFunciones.pedirNumeroMasCero("capacidadCarga?");
        Camion camion = new Camion(marca, ano, capacidadCarga);
        taller.getVehiculos().add(camion);
        return camion;
    }

    private Moto addMoto(Taller taller) {
        String marca = MisFunciones.pedirStrNoVacio("marca?");
        if (marca==null) return null;
        int ano = MisFunciones.pedirNumeroMasCero("ano?");
        if (ano==-1) return null;
        boolean tieneSidecar;
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿tiene Sidecar?", null, JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            tieneSidecar = true;
        } else if (respuesta == JOptionPane.NO_OPTION) {
            tieneSidecar = false;
        } else {
            return null;
        }
        Moto moto = new Moto(marca, ano, tieneSidecar);
        taller.getVehiculos().add(moto);
        return moto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mecanicos> getMecanicos() {
        return mecanicos;
    }

    public List<Vehiculos> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "Taller{" + "nombre='" + nombre + "}\n" +
                mecanicos + "\n" +
                vehiculos + "\n" +
                "_______________\n" +
                "Revisiones" + "\n" + revisiones;
    }

    public void revezarVehiculo() {

        if (vehiculos.isEmpty() || mecanicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehiculos o mecanicos");
            return;
        }

        Vehiculos vehiculo = (Vehiculos) MisFunciones.eligirObjDeLista(vehiculos);
        if (vehiculo == null) {
            return;
        }
        Mecanicos mecanico = (Mecanicos) MisFunciones.eligirObjDeLista(mecanicos);
        if (vehiculo == null) {
            return;
        }

        String result = mecanico.realizarRevision(vehiculo);
        if (result.equals("no hay vehiculos")) {
            JOptionPane.showMessageDialog(null, result);
            return;
        }
        if (result != "cancel") {
            revisiones.add(mecanico + " " + vehiculo + ": " + result + "\n");

        }


    }
}
