package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {

   /* Atributos */
   private static final int LIMITE_UNIDADES_POR_CLIENTE = 3;
   private double gradosAlcohol;
   private boolean certificada;
   private boolean ventaRestringida;

   /* Constructor Vacío */
   public BebidaAlcoholica() {}

   /* Constructor Parámetros */
   public BebidaAlcoholica(String nombre, int volumenML, int stock, double gradosAlcohol, boolean certificada) {
       super(nombre, volumenML, stock);
       setGradosAlcohol(gradosAlcohol);
       this.certificada = certificada;
       this.ventaRestringida = false;
   }

   /* Getters n Setters */

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        if (gradosAlcohol < 0.5 || gradosAlcohol > 45) {
            throw new IllegalArgumentException("Los grados de alcohol deben estar entre 0.5ml y 45ml");
        } else {
        this.gradosAlcohol = gradosAlcohol; }
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    public boolean isVentaRestringida() {
        return ventaRestringida;
    }

    public void setVentaRestringida(boolean ventaRestringida) {
        this.ventaRestringida = ventaRestringida;
    }

    /* Bebida Alcohólica: el precio base es $3.500. Si la bebida no cuenta con certificación del proveedor, ese precio se incrementa en un 20%.*/

    /* Comportamientos */
    @Override
    public double calcularPrecio() {
        double precio = 3500;
        if (!certificada) {
            precio = precio * 1.20;
        }
        return precio;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Alcohólica | Nombre: "+getNombre()+" | Volumen: "+getVolumenML()+"| Stock: "+getStock()+ " | Grados Alcohol: " + getGradosAlcohol()+ " | Certificada: "+ (certificada ? "Si" : "No ")+ " | Venta Restringida: "+(ventaRestringida ? "Si" : "No")+" | Precio: $"+ calcularPrecio();
    }

    /* Métodos Interfaz */
    @Override
    public boolean tieneVentaRestringida() {
        return ventaRestringida;
    }

    @Override
    public void restringirVenta() {
        if (ventaRestringida) {
            System.out.println("La venta ya está restringida.");
        } else {
            ventaRestringida = true;
            System.out.println("Se restringió la venta.");
        }
    }

    @Override
    public boolean superaLimite(int unidades) {
        return unidades > LIMITE_UNIDADES_POR_CLIENTE;
    }
}
