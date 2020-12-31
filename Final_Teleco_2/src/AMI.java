/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author DanceVangot
 */
public class AMI extends JFrame {

    static int matriz[];
    public AMI(int mat[])
{
     
super( "AMI RZ" );
 
setSize( 700, 380 );
setResizable(false);
setLocationRelativeTo(null);
setVisible( true );
matriz=mat;
}
 
// mostrar varias líneas, rectángulos y óvalos
public void paint( Graphics g ){
super.paint( g );  // llamar al método paint de la superclase
 int p=-1;

//g.drawLine( 5, 500, 35, 500 );
// g.drawLine( 35, 500, 35, 550 );//bajo
// g.drawLine( 35, 550, 65, 550 );//derecha
// g.drawLine( 65, 550, 65, 500 );
g.setColor( Color.BLACK );
g.drawString("Codificación AMI RZ", 300, 75);
 int x1=50;
 int y1=50;
 int x2=50;
 int y2=50;
for(int y=0;y<3;y++){
    g.setColor( Color.BLUE );
    g.drawLine( 5, 75+y1, 670, 75 +y1);
    g.drawString("1", 15, 50+y1);
    g.drawString("-1", 15, 100+y1);
    y1=y1+90;
}
g.setColor( Color.orange );
 for(int i=0;i<10;i++){
     if(matriz[i]==1){
         if(p==-1){
             
              g.drawLine( 5+x1, 75+y2, 5+x1, 100+y2 );
         g.drawLine( 5+x1, 100+y2, 35+x1, 100+y2 );
         g.drawLine( 35+x1, 100+y2, 35+x1, 75+y2 );
         g.drawLine( 35+x1, 75+y2, 65+x1, 75+y2 );
         
         p=p*(-1);
         }else{
             g.setColor( Color.orange );
          g.drawLine( 5+x1, 75+y2, 5+x1, 50+y2 );
         g.drawLine( 5+x1, 50+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 35+x1, 75+y2 ); 
         g.drawLine( 35+x1, 75+y2, 65+x1, 75+y2 ); 
         p=p*(-1);
        }
        g.drawString("1", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60;
     }else{
         
         g.drawLine( 5+x1, 75+y2, 65+x1, 75 +y2);
         g.drawString("0", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60; 
         }
         
 }
 y2=y2+90;
 x1=50;
 for(int i=10;i<20;i++){
     if(matriz[i]==1){
         if(p==-1){
             
              g.drawLine( 5+x1, 75+y2, 5+x1, 100+y2 );
         g.drawLine( 5+x1, 100+y2, 35+x1, 100+y2 );
          g.drawLine( 35+x1, 100+y2, 35+x1, 75+y2 );
         g.drawLine( 35+x1, 75+y2, 65+x1, 75+y2 );
         
         p=p*(-1);
         }else{
             
          g.drawLine( 5+x1, 75+y2, 5+x1, 50+y2 );
         g.drawLine( 5+x1, 50+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 35+x1, 75+y2 ); 
         g.drawLine( 35+x1, 75+y2, 65+x1, 75+y2 ); 
         p=p*(-1);
        }
        g.drawString("1", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60;
     }else{
        
         g.drawLine( 5+x1, 75+y2, 65+x1, 75+y2 );
         g.drawString("0", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60; 
         }
         
 }
 y2=y2+90;
 x1=50;
 for(int i=20;i<30;i++){
      if(matriz[i]==1){
         if(p==-1){
             
              g.drawLine( 5+x1, 75+y2, 5+x1, 100+y2 );
         g.drawLine( 5+x1, 100+y2, 35+x1, 100+y2 );
          g.drawLine( 35+x1, 100+y2, 35+x1, 75+y2 );
         g.drawLine( 35+x1, 75+y2, 65+x1, 75+y2 );
         
         p=p*(-1);
         }else{
             
          g.drawLine( 5+x1, 75+y2, 5+x1, 50+y2 );
         g.drawLine( 5+x1, 50+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 35+x1, 75+y2 ); 
         g.drawLine( 35+x1, 75+y2, 65+x1, 75+y2 );   
         p=p*(-1);
        }
        g.drawString("1", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60;
     }else{
          
         g.drawLine( 5+x1, 75+y2, 65+x1, 75+y2 );
         g.drawString("0", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60; 
         }
         
 }
// g.drawLine( 75, 550, 55, 500 );

 
} // fin del método paint
 
// ejecutar la aplicación

    
}
