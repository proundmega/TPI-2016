package data;

/**
 * Created by sakshi on 27/04/2016.
 */
public enum Color {
    BLANCO("blanco"),
    AZUL("azul"),
    NEGRO("negro"),
    AMARILLO("amarillo"),
    ROJO("rojo");

    private String nombreColor;

    private Color(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    public String getNombreColor() {
        return nombreColor;
    }


    @Override
    public String toString() {
        return getNombreColor();
    }

    public static Color getColorByNombre(String colorString) {
        for(Color color : Color.values()) {
            if(color.getNombreColor().equals(colorString)) {
                return color;
            }
        }
        throw new IllegalArgumentException("Este color no existe");
    }

}
