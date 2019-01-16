package Game;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
    /*Declaración de atributos*/
    private  int x,y;
    private  int ancho,alto;
    private  int incx,incy;
    Color color;
    /*Constructor*/
    public Figura(int x, int y, int ancho, int alto, Color color) {
        this(x,y,ancho,alto,0,0,color);
    }
    /*Constructor*/
    public Figura(int x, int y, int ancho, int alto, int incx, int incy, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.incx = incx;
        this.incy = incy;
        this.color = color;
    }
    /*Setters and Getters*/
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getIncx() {
        return incx;
    }
    public void setIncx(int incx) {
        this.incx = incx;
    }
    public int getIncy() {
        return incy;
    }
    public void setIncy(int incy) {
        this.incy = incy;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    /*Impression toString*/
    @Override
    public String toString() {
        return "Figura [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", color=" + color + "]";
    }

    public void dibujar (Graphics g)
    {
        g.setColor(color);
        trazar(g);
    }

    public abstract void trazar (Graphics g);

    /*Animation*/
    public void animar (int xmax,int ymax){
        x=x+incx;//incrementar a x para que haya movimiento
        if(incx!=0){
            if(x<0 || x>xmax-ancho){
                /*x<0 rebote con lado izquierdo; x>xmax-ancho rebote con lado derecho*/
                incx=-incx;//para que rebote se cambia la direccion
                x=(x<0)? 0: xmax-ancho;//rebote al cambiar tamño de pantalla
            }
        }//fin if
        y=y+incy;//incrementar a y para que haya movimiento

        if(incy!=0){
            if(y<0 || y>ymax-alto) {
                incy=-incy;
                y=(y<0)? 0: ymax-alto;
            }
        }//fin if
    }//fin animar

    public boolean colision(Figura f) {
        return interseccion(this.getX(),this.getY(),this.getAncho(),this.getAlto(),f.getX(),f.getY(),f.getAncho(),f.getAlto());
    }


    private boolean interseccion (int x1, int y1,int ancho1, int altura1, int x2, int y2, int ancho2, int altura2) {

        int xt1 = x1+ancho1;
        int yt1 = y1+altura1;

        int xt2 = x2+ancho2;
        int yt2 = y2+altura2;

        int xL = Math.max(x1,x2);
        int xR = Math.min(xt1,xt2);
        if(xL>=xR)
            return false;
        else {
            int yL = Math.max(y1, y2);
            int yR = Math.min(yt1, yt2);
            if(yL>=yR)
                return false;
            else
                return true;
        }
    }
}//fin Figura