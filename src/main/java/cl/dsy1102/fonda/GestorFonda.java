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

        // Verifica nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("¡El nombre no puede estar vacío!");
            return;
        }

        // Verifica cantidad
        if (cantidad <= 0) {
            System.out.println("¡La cantidad debe ser mayor que cero!");;
            return;
        }

        // Verificar existencia de bebida
        Bebida bebidaEncontrada = null;

        for (Bebida bebida : bebidas) { //Esto recorre toda la lista de bebidas

            if (bebida.getNombre().equalsIgnoreCase(nombre.trim())) { // Compara nombre bebida de la lista con nombre del parámetro
                bebidaEncontrada = bebida;
                break;
            }
        }

        // Revisa que la variable después de buscar no esté vacío, sino, termina el método.
        if (bebidaEncontrada == null) {
            System.out.println("¡No existe una bebida con ese nombre!");
            return;
        }

        // Revisa si hay stock de la bebida encontrada, sino, acaba el método
        if (cantidad > bebidaEncontrada.getStock()) {
            System.out.println("¡Stock insuficiente!");
            return;
        }

        //* Revisa si la bebida es parte del interfaz ConsumoResponsable
        if (bebidaEncontrada instanceof ConsumoResponsable) {

            // Crea una variable consumo, que registra la bebida, que será tratada con la interfaz de consumo responsable
            ConsumoResponsable consumo =
                    (ConsumoResponsable) bebidaEncontrada;

            // Si la bebida solicitada tiene venta restringida, acaba el método
            if (consumo.tieneVentaRestringida()) {
                System.out.println("Venta rechazada: "+bebidaEncontrada+" tiene la venta restringida.");
                return;
            }

            // Revisa si la cantidad que se quiere vender supera la cantidad del límite
            if (consumo.superaLimite(cantidad)) {
                System.out.println( "Venta rechazada: "+cantidad+" unidades de "+bebidaEncontrada+" superan el límite de 3 por cliente." );
                return;
            }
        }

        // Cambia el Stock de la bebida solicitada
        bebidaEncontrada.setStock(
                bebidaEncontrada.getStock() - cantidad
        );

        // Se guarda en una variable el total de la venta calculando la cantidad por el valor de la bebida
        int total = cantidad * (int)bebidaEncontrada.calcularPrecio();

        //Mensaje final
        System.out.println("Venta autorizada: " + cantidad + " x " + bebidaEncontrada.getNombre() + " | Total: $" + total
        );

    }

    // Lista bebidas
    public List<Bebida> obtenerTodas() {
        return bebidas;
    }
}
