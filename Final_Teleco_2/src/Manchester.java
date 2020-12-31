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
public class Manchester extends JFrame {
static int matriz2[];
    public Manchester(int mat[])
{
     
super( "Manchester" );
 
setSize( 700, 380 );
setResizable(false);
setLocationRelativeTo(null);
setVisible( true );
matriz2=mat;
}
 
// mostrar varias líneas, rectángulos y óvalos
public void paint( Graphics g ){
    
    
super.paint( g );  // llamar al método paint de la superclase
g.setColor( Color.BLACK );
g.drawString("Codificación Manchester", 300, 75);
 int x1=50;
 int y1=65;
 int x2=50;
 int y2=65;
for(int y=0;y<3;y++){
    g.setColor( Color.BLUE );
    g.drawLine( 5, 75+y1, 670, 75 +y1);
    g.drawString("1", 15, 50+y1);
    g.drawString("-1", 15, 100+y1);
    y1=y1+90;
}
g.setColor( Color.orange );
 for(int i=0;i<10;i++){
     if(matriz2[i]==1){
         g.drawLine( 5+x1, 50+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 35+x1, 100+y2 );
         g.drawLine( 35+x1, 100+y2, 65+x1, 100+y2 );
         g.drawString("1", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60;
         if(i>0){
             if(matriz2[i]==matriz2[i-1]){
             g.drawLine( 5+x1-60, 50+y2, 5+x1-60, 100+y2 );
         }
         }
     }else{
         g.drawLine( 5+x1, 100+y2, 35+x1, 100+y2 );
         g.drawLine( 35+x1, 100+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 65+x1, 50+y2 );
         g.drawString("0", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60; 
         if(i>0){
             if(matriz2[i]==matriz2[i-1]){
             g.drawLine( 5+x1-60, 50+y2, 5+x1-60, 100 +y2);
         }
         }
     }
         
 }
 y2=y2+90;
 x1=50;
 for(int i=10;i<20;i++){
     if(matriz2[i]==1){
         g.drawLine( 5+x1, 50+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 35+x1, 100+y2 );
         g.drawLine( 35+x1, 100+y2, 65+x1, 100+y2 );
         g.drawString("1", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60;
         if(i>0){
             if(matriz2[i]==matriz2[i-1]){
             g.drawLine( 5+x1-60, 50+y2, 5+x1-60, 100 +y2);
         }
         }
     }else{
         g.drawLine( 5+x1, 100+y2, 35+x1, 100 +y2);
         g.drawLine( 35+x1, 100+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 65+x1, 50+y2 );
         g.drawString("0", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60; 
         if(i>0){
             if(matriz2[i]==matriz2[i-1]){
             g.drawLine( 5+x1-60, 50+y2, 5+x1-60, 100+y2 );
         }
         }
     }
         
 }
 y2=y2+90;
 x1=50;
 for(int i=20;i<30;i++){
     if(matriz2[i]==1){
         g.drawLine( 5+x1, 50+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 35+x1, 100+y2 );
         g.drawLine( 35+x1, 100+y2, 65+x1, 100+y2 );
         g.drawString("1", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60;
         if(i>0){
             if(matriz2[i]==matriz2[i-1]){
             g.drawLine( 5+x1-60, 50+y2, 5+x1-60, 100 +y2);
         }
         }
     }else{
         g.drawLine( 5+x1, 100+y2, 35+x1, 100 +y2);
         g.drawLine( 35+x1, 100+y2, 35+x1, 50+y2 );
         g.drawLine( 35+x1, 50+y2, 65+x1, 50+y2 );
         g.drawString("0", 35+x1, 120+y2);
         x1=x1+60;
         x2=x2+60; 
         if(i>0){
             if(matriz2[i]==matriz2[i-1]){
             g.drawLine( 5+x1-60, 50+y2, 5+x1-60, 100+y2 );
         }
         }
     }
         
 }
// g.drawLine( 75, 550, 55, 500 );

 
} // fin del método paint
 
// ejecutar la aplicación

    
}
