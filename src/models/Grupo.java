package models;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public enum Grupo {
    MARRON(2),
    CIELO(3),
    ROSA(3),
    NARANJA(3),
    ROJO(3),
    AMARRILLO(3),
    VERDE(3),
    AZUL(2);

    public final int maxGrupo;
    
    Grupo (int maxGrupo){
        this.maxGrupo = maxGrupo;
    }
}
