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

        BebidaAlcoholica chichaAlcoholica = new BebidaAlcoholica("Chicha",1000,40,12.0,false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour",500,25,18.0,true);
        BebidaSinAlcohol chichasinAlcohol = new BebidaSinAlcohol("Chicha",1000,60,95);
        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol("Mote Con Huesillo",400,50,70);

        chichaAlcoholica.restringirVenta();

        GestorFonda gestor = new GestorFonda();

        gestor.registrar(chichaAlcoholica);
        gestor.registrar(piscoSour);
        gestor.registrar(chichasinAlcohol);
        gestor.registrar(moteConHuesillo);

        List<Bebida> resultados = gestor.buscarPorNombres("Chicha");
        for (Bebida bebida : resultados) {
            System.out.println(bebida.obtenerDetalle());
        }


    }
}
