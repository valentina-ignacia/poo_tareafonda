package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {

    /*Atributos*/
    private ArrayList<Bebida> bebidas = new ArrayList<>();

    /*Constructor*/
    public GestorFonda() {}

    /*Comportamientos*/
    public void registrar(Bebida bebida) {

        if (bebidas.contains(bebida)) {
            System.out.println("¡La bebida ya está registrada!");
        } else {
            bebidas.add(bebida);
            System.out.println("¡Bebida registrada correctamente!");
        }
    }

    public String buscarPorNombre(String bebida) {
        ArrayList<Bebida> resultados = new ArrayList<>();

        for (Bebida bebida : bebidas) {
            if (bebida.getNombre())
        }
    }
}
