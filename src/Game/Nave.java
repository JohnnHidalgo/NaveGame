package Game;

import java.awt.*;
import java.util.Random;

public class Nave extends Rectangulo{
    public static int ALTO = 10;
    public static int ANCHO = 20;
    private static final Random nal = new Random();

    public Nave(int xmax, int ymax) {
        super(nal.nextInt(xmax+ANCHO),nal.nextInt(ymax-ANCHO),ANCHO,ALTO,-1,0, Color.YELLOW);
    }

    public Nave(int x, int y, int ancho, int alto, int incx, int incy, Color color) {
        super(x, y, ancho, alto, incx, incy, color);
    }

    public void mover (int xmax, int ymax) {
        if(getX()> ANCHO)
            setX(getX()-1);
        else {
            setX(xmax+ANCHO);
            setY(nal.nextInt(ymax-ALTO));
        }
    }
}
