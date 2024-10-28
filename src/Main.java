public class Main {
    public static void main(String[] args) {



        Taller taller = new Taller("Speed");


        String[] opc = {"agregar_mecanico", "agregar vehiculo", "revesar vehiculo"};
        Runnable[] ac = new Runnable[]{
                () -> taller.addMecanico(),
                () -> taller.addVehiculo(),
                () -> taller.revezarVehiculo(),
        };
        MisFunciones.interfaz(ac, opc, taller::toString);


    }
}