package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

/**
 * Punto de entrada de la Tarea Fiestas Patrias - Fonda San Belarmino.
 *
 * Revisa el enunciado en README.md. Debes crear, en este mismo paquete,
 * las clases del diagrama: Bebida, BebidaAlcoholica, BebidaSinAlcohol,
 * la interfaz ConsumoResponsable y la clase GestorFonda.
 */
public class Main {

    public static void main(String[] args) {
        // TODO 1: instanciar las cuatro bebidas con los datos del enunciado.
        // TODO 2: marcar la bebida alcoholica 'Chicha' con la venta restringida.
        // TODO 3: registrarlas todas en el gestor.
        // TODO 4: solicitar las cuatro ventas indicadas en el enunciado.
        // TODO 5: buscar por nombre "Chicha" y listar todas las bebidas.

        System.out.println("Proyecto listo. Comienza por la clase Bebida.");

        /*Instanciar Bebidas*/
        BebidaAlcoholica chichaAlcoholica = new BebidaAlcoholica("Chicha",1000,40,12.0,false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour",500,25,18.0,true);
        BebidaSinAlcohol chichasinAlcohol = new BebidaSinAlcohol("Chicha",1000,60,95);
        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol("Mote Con Huesillo",400,50,70);

        /* Restringir venta Chicha */
        chichaAlcoholica.restringirVenta();

        /* Instanciar Gestor Fonda */
        GestorFonda gestor = new GestorFonda();

        System.out.println("\n");  // vacío para que se entienda el main cuando corra :)

        /* Registrar todas las bebidas en el Gestor Fonda*/
        gestor.registrar(chichaAlcoholica);
        gestor.registrar(piscoSour);
        gestor.registrar(chichasinAlcohol);
        gestor.registrar(moteConHuesillo);

        /*Buscar por Nombre */
        System.out.println("\n=== BUSQUEDA POR NOMBRE: \"Chicha\" ===");

        List<Bebida> resultados = gestor.buscarPorNombre("Chicha");
        for (Bebida bebida : resultados) {
            System.out.println(bebida.obtenerDetalle());
        }

        /*Ventas*/
        System.out.println("\n=== VENTAS ===");

        gestor.vender("Pisco Sour",2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);

        /*Lista bebiditas*/
        System.out.println("\n=== LISTADO DE BEBIDAS ===");

        for (Bebida bebida : gestor.getBebidas()) {
            System.out.println(bebida);
        }

    }
}
