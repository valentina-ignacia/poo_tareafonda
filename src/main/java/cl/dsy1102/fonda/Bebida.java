package cl.dsy1102.fonda;

public abstract class Bebida {

    /* Atributos */
    private String nombre;
    private int volumenML;
    private int stock;

    /* Constructor Vacío */
    public Bebida() {}

    /* Constructor Parámetros */
    public Bebida(String nombre, int volumenML, int stock) {
        setNombre(nombre);
        setVolumenML(volumenML);
        setStock(stock);
    }

    /* Getters n Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        } else {
        this.nombre = nombre;
        }
    }

    public int getVolumenML() {
        return volumenML;
    }

    public void setVolumenML(int volumenML) {
        if (volumenML < 100 || volumenML > 3000) {
            throw new IllegalArgumentException("El volumen debe estar entre 100ml y 3000ml");
        } else {
            this.volumenML = volumenML;}
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a cero.");
        } else {
            this.stock = stock;
        }
    }

    /* Comportamientos */
    public abstract double calcularPrecio();

    public abstract String obtenerDetalle();

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Volumen: " + volumenML + " ml";
    }
}
