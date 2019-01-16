package Game;

import java.awt.*;

public class Rectangulo extends Figura{
    /*Constructor*/
    public Rectangulo(int x, int y,int ancho, int alto, Color color){
        super(x,y,ancho,alto,color);
    }
    /*Constructor*/
    public Rectangulo(int x, int y,int ancho, int alto,int incx,int incy, Color color){
        super(x,y,ancho,alto,incx,incy, color);
    }
    /*Metodo para trazar en panel*/
    @Override
    public void trazar(Graphics g) {
        g.drawRect(getX(), getY(), getAncho(),getAlto());
    }
}//fin Rectangulo