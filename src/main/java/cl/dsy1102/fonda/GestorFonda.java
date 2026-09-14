package cl.dsy1102.fonda;

import java.util.List;
import java.util.ArrayList;

public class GestorFonda {

    /*Atributos*/
    private List<String> bebidas = new ArrayList<>();

    /*Constructor*/
    public GestorFonda(List<String> bebidas) {
        this.bebidas = bebidas;
    }

    /*Getters n Setters*/
    public List<String> getBebidas() {
        return bebidas;
    }
    public void setBebidas(List<String> bebidas) {
        this.bebidas = bebidas;
    }

    /*Comportamientos*/
    public void registrar(String bebida) {

        if (bebidas.contains(bebida)) {
            System.out.println("¡La bebida ya está registrada!");
        } else {
            this.bebidas.add(bebida);
            System.out.println("¡Bebida registrada correctamente!");
        }
    }

    public String buscarPorNombre(String bebida) {

    }
}
