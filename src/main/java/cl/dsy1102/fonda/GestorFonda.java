package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {

    /*Atributos*/
    private List<Bebida> bebidas;

    /*Constructor*/
    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    /*Getters n Setters*/
    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public void registrar(Bebida bebida) {
        this.bebidas.add(bebida);
        System.out.println("Bebida registrada.");
    }

    public List<Bebida> buscarPorNombres(String nombre) {
        ArrayList<Bebida> bebidasEncontradas = new ArrayList<>();

        for (Bebida bebida : this.getBebidas()) {
            if(bebida.getNombre().equalsIgnoreCase(nombre)) {
                bebidasEncontradas.add(bebida);
            }
        }

        return bebidasEncontradas;

    }

    public void vender(String nombre, int unidades) {
        List<Bebida> bebidasRespectivas = this.buscarPorNombres(nombre);

        for(Bebida bebida : bebidasRespectivas) {
            if(bebida.getStock() > unidades) {
                if (bebida instanceof ConsumoResponsable) {
                    boolean checked;
                    checked = ((ConsumoResponsable) bebida).superaLimite(unidades);
                    if(checked) {
                        throw new IllegalArgumentException("Se supera el límite de venta");
                    }
                }
            }
        }
    }
}
