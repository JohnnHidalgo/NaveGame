package Game;

import javax.swing.*;
import java.awt.*;

public class FrameTest {
    public static void main (String args[]) {
        JLabel mensaje =new JLabel("Nombres:		Puntos:		Coliciones:	");
        Nave [] NaveBLoque = new Nave[10];
        for(int i=0 ; i<NaveBLoque.length;i++)
            NaveBLoque[i]= new Nave(500,200);
        Rectangulo nave = new Rectangulo(300,100,30,15,0,0, Color.BLUE);
        Panel panel = new Panel (nave,NaveBLoque);
        Frame ventana = new Frame(nave);

        ventana.setLayout(new BorderLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel,BorderLayout.CENTER);
        ventana.add(mensaje,BorderLayout.SOUTH);
        ventana.setSize(500,220);
        ventana.setVisible(true);
        panel.setBackground(Color.BLACK);
        String nombre = JOptionPane.showInputDialog(null,"Cual es tu nombre ?:","Identificador de usuario",JOptionPane.QUESTION_MESSAGE);
        nombre = (nombre == null)? "" :nombre;
        int puntos =0;
        int colisiones =0;
        while(puntos<=100 && colisiones <5) {
            for(Nave b : NaveBLoque)
                b.mover(panel.getWidth(), panel.getHeight());
            for(Nave b : NaveBLoque)
                if(nave.colision(b)) {
                    b.setX(-b.ANCHO);
                    colisiones++;
                }
                else
                if(b.getX()+Nave.ANCHO == nave.getX())
                    puntos++;
            mensaje.setText(String.format("Nombres : %s\t\tPuntos : %d\t\tColiciones : %d\t\t", nombre,puntos,colisiones));
            panel.repaint();

            try {
                Thread.sleep(10);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }//fin del catch
        }
        if(puntos >100)
            JOptionPane.showMessageDialog(null, "Ganaste :", "Resultado",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Perdiste :", "Resultado",JOptionPane.INFORMATION_MESSAGE);
        ventana.dispose();
    }

}
