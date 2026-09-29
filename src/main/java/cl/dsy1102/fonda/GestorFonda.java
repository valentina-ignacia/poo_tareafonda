package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {

    /*Atributos*/
    private ArrayList<Bebida> bebidas;

    /*Constructor*/
    public GestorFonda() {
        bebidas = new ArrayList<>();
    }

    /*Getter*/
    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    /* Métodos */
    public void registrar(Bebida bebida) {
        if (bebida == null) {
            throw new IllegalArgumentException("No se puede registrar una bebida nula."
            );
        }
        bebidas.add(bebida);
        System.out.println(bebida.getNombre()+" ("+bebida.getClass().getSimpleName()+") registrada correctamente."
        );
    }

    public List<Bebida> buscarPorNombre(String nombre) {
        ArrayList<Bebida> bebidasEncontradas = new ArrayList<>();

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("¡El nombre no puede estar vacío!");
        } else {
            for (Bebida bebida : bebidas) {
                if (bebida.getNombre().equalsIgnoreCase(nombre)) {
                    bebidasEncontradas.add(bebida);
                }
            }
        }
        return bebidasEncontradas;

    }

    public void vender(String nombre, int cantidad) {

        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("¡El nombre no puede estar vacío!");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("¡La cantidad debe ser mayor que cero!");;
            return;
        }

        Bebida bebidaEncontrada = null;

        for (Bebida bebida : bebidas) {

            if (bebida.getNombre().equalsIgnoreCase(nombre.trim())) {
                bebidaEncontrada = bebida;
                break;
            }
        }

        if (bebidaEncontrada == null) {
            System.out.println("¡No existe una bebida con ese nombre!");
            return;
        }

        if (cantidad > bebidaEncontrada.getStock()) {
            System.out.println("¡Stock insuficiente!");
            return;
        }

        if (bebidaEncontrada instanceof ConsumoResponsable) {

            ConsumoResponsable consumo =
                    (ConsumoResponsable) bebidaEncontrada;

            if (consumo.tieneVentaRestringida()) {
                System.out.println("Venta rechazada: "+nombre+" tiene la venta restringida.");
                return;
            }

            if (consumo.superaLimite(cantidad)) {
                System.out.println( "Venta rechazada: "+cantidad+" unidades de "+nombre+" superan el límite de 3 por cliente." );
                return;
            }
        }

        bebidaEncontrada.setStock(
                bebidaEncontrada.getStock() - cantidad
        );

        int total = cantidad * (int)bebidaEncontrada.calcularPrecio();

        System.out.println("Venta autorizada: " + cantidad + " x " + bebidaEncontrada.getNombre() + " | Total: $" + total
        );

    }
}
