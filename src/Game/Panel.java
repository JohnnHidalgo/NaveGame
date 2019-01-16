package Game;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    Nave[] obstaculos;//recepciona las figuar del panelTest
    Rectangulo nave;
    public Panel(Rectangulo nve,Nave[] obs){
        obstaculos = obs;//asigna
        nave=nve;
    }
    public void paintComponent (Graphics g){

        super.paintComponent(g);
        nave.dibujar(g);
        for(Nave o: obstaculos)
            o.dibujar(g);//dibuja las figuras recepcionadas
    }
}
