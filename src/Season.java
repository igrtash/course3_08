import java.awt.Color;
import java.lang.reflect.Field;

public enum Season {
    SPRING(Color.GREEN),
    SUMMER(Color.RED),
    AUTUMN(Color.YELLOW),
    WINTER(Color.WHITE);

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    Season(Color color) {
        this.color = color;
    }

    public static String colorName(Color c) {
        for (Field f : Color.class.getDeclaredFields()) {
            //we want to test only fields of type Color
            if (f.getType().equals(Color.class))
                try {
                    if (f.get(null).equals(c))
                        return f.getName().toLowerCase();
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // shouldn't not be thrown, but just in case print its stacktrace
                    e.printStackTrace();
                }
        }
        return "";
    }
}
