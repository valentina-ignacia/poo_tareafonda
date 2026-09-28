package cl.dsy1102.fonda;

public class BebidaSinAlcohol extends Bebida {

    /*Atributos*/
    private int azucarPorLitro;

    /*Constructor Vacío*/
    public BebidaSinAlcohol() {}

    /*Constructor Parámetros*/
    public BebidaSinAlcohol(String nombre, int volumenML, int stock, int azucarPorLitro) {
        super(nombre, volumenML, stock);
        this.azucarPorLitro = azucarPorLitro;
    }

    /*Getters n Setters*/
    public int getAzucarPorLitro() {
        return azucarPorLitro;
    }

    public void setAzucarPorLitro(int azucarPorLitro) {
        this.azucarPorLitro = azucarPorLitro;
    }

    /* Métodos Heredados */
    @Override
    public double calcularPrecio() {
        if (azucarPorLitro > 80) {
            return 2000 * 1.1;
        } else {
            return 2000;
        }
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Sin Alcohol | Nombre: "+getNombre()+" | Volumen: "+getVolumenML()+"| Stock: "+getStock()+" | Azucar Por Litro: "+azucarPorLitro+" | Precio: $"+ calcularPrecio();
    }
}
