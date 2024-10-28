public class Mecanicos {
    private String nombre;
    private Taller taller;

    public Mecanicos(String nombre, Taller taller) {
        this.nombre = nombre;
        this.taller = taller;
    }

    public String realizarRevision(Vehiculos vehiculo) {
        if (vehiculo!=null){
            return vehiculo.revisarPartes();
        }
        return "no hay vehiculos";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    @Override
    public String toString() {
        return "Mecanico{" +
                "nombre='" + nombre +
                "}\n";
    }
}
