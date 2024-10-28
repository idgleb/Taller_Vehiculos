public abstract class Vehiculos {
    private String marca;
    private int ano;

    public Vehiculos(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    public abstract String revisarPartes();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return  "marca='" + marca +
                ", ano=" + ano + "";
    }
}
