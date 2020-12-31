/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class RLE {
    public String Mensaje = "";
    public String Total = "";
    public String Finall;
    public char caracteres[];
    public char alfabeto[] = new char[35];
    public char alfabeto2[] = new char[35];
    public double contadores[] = new double[35];
    public double contadores2[] = new double[35];
    public int cont = -1;
    public char temporal;
    public char temporal12;
    public double temporal2;
    public double temporal4;
    public double temporal5 = 0;
    public int temporal3;
    public double temporal22;
    public double temporal52 = 0;
    public int temporal32;
    public int saber = 0;
    public int locacion0 = 0;
    public int locacion1 = 0;
    public double total = 0;
    public double parcial = 0;
    public double div[] = new double[35];
    public double div2[] = new double[35];
    public double tam = 0;
    public int posi = 0;
    double proba[];
    int lugar = 0;
    double A_actual = 0;
    double B_actual = 1;
    double ai = 0;
    double bi = 0;
    public String acumulador = "";
    public String codigos[];
    public char asignar[];
    public String num_mensaje = "";
    public char num_base[];
    public double suma_base;
    public String numero_enbase = "";
    String Resumen2="";
    public String rles(String Texto,int boton){
        String Caso1 = ""; // String para el caso 1
        String Caso2 = ""; // String para el caso 2
        String Caso3 = ""; // String para el caso 3
        String Resumen = ""; // String para la extraccion del mensaje abreviado
        Resumen2=""; // Copia del String anterior
        Mensaje = Texto;//Obtiene el mensaje que ingreso el usuario
        caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
        tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
        if(tam<100){ // Si el mensaje ingresado tiene tamaño menor de 10
            for(int i=(int)tam;i<100;i++){ // for que recorre desde la ultima posicion del mensaje ingresado hasta 100
                Mensaje=Mensaje+"_"; // Agrega una "@" al mensaje para autocompletarlo
            }
        }
        caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
        tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
        String Matriz=" ";
        for(int i=0;i<100;i++){
                Matriz=Matriz+caracteres[i]+" ";
                if((i%10)==0 && i>1){
                    Matriz=Matriz+" \n ";
                }
            }
        Matriz=Matriz+" \n ";        
        if(boton==2){ //Lectura vertical
            Mensaje=""; // Reinicia el mensaje
            for(int j=0;j<10;j++){ // for de 1 a 10
            for(int i=j;i<100;i=i+10){ // for que va de i y suma de 10 en 10
                Mensaje=Mensaje+caracteres[i]; // arma el mensaje nuevamente con la nueva lectura
            }
            }
            caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
            tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres

     
        }
        if(boton==3){//Lectura vertical
            int esp[]={0,1,10,20,11,2,3,12,21,30,40,31,22,13,4,5,14,23,32,41,50,60,51,42,33,24,15,6,7,16,25,34,43,52,61,70,80,71,62,53,44,35,26,17,8,9,18,27,36,45,51,63,72,81,90,91,82,73,64,55,46,37,28,19,29,38,49,96,65,74,83,92,93,84,75,66,57,48,39,47,58,67,76,85,94,95,86,77,68,59,67,78,87,96,97,88,77,89,98,99};// arreglo con las posiciones de la lectura zig zag
            Mensaje=""; // Reinicia el mensaje
            int numero; 
            for(int i=0;i<100;i++){
                numero=esp[i]; // Variable que toma el espacio que debe tomar en zig zag
                Mensaje=Mensaje+caracteres[numero]; //Dice la posicion que va en zigzag
            }
            
            caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
            tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
     
        }
        
        
        

        if ( boton>0) {//Restringe que el mensaje no tenga mas de 100 caracteres
            char before = ' '; // Obtiene el caracter inmediatamente anterior
            char now; // Obtiene el caracter actual
            int contador = 0; //Contador de repeticiones
            for (int i = 0; i < tam; i++) { 
                now = caracteres[i]; // Caracter actual
                if (now == before) { // revisa si el anterior y el nuevo son iguales
                    contador++; // si es asi el contador aumenta
                } else if (contador > 1) { // si hay mas de una repeticion pero el nuevo es difernete del anterior entra aqui
                    Resumen = Resumen + contador + before; // agrega al resumen la repeticiones mas el caracter
                    contador = 1; // reinicia el conatdor
                } else if (contador == 1) { // si solo esta el caracter una vez
                    Resumen = Resumen + before;// agrega al resumen  el caracter
                    contador = 1;// reinicia el conatdor
                } else if (contador == 0) { // para el estado inicial
                    before = now; // coloca como anterior el nuevo
                    contador++; // contador aumenta
                }
                if (i == ((int) tam) - 1) { // si esta en la posicion final
                    if (contador > 1) { // si contador va mas de 1
                        Resumen = Resumen + contador + before; // agrega al resumen la repeticiones mas el caracter
                    } else if (contador == 1) { // si el contador es uno
                        Resumen = Resumen + before; //agrega al resumen  el caracter
                    }
                }
                before = now; // coloca como anterior el nuevo
            }

            
            char[] charresumen = Resumen.toCharArray();//Convierte el resumen en un arreglo de caracteres
            int tamresumen = charresumen.length;//obtiene el tamaño del arreglo de caracteres
            int conversion = 0; // variable para saber su valor a convertir
            for (int i = 0; i < tamresumen; i++) { // for recorre segun el tamaño del resumen
                if ((i % 8) == 0) { // para el caso 3 cada byte se manda un byte indentificador de caracter y repeticion
                    if ((i + 8) < tamresumen) { // revisa si el mensaje apartir de i + 8 exite
                        for (int j = i; j < i + 8; j++) {
                            conversion = charresumen[j]; //toma el caracter
                            if (conversion < 58) { // si el caracter es menor a 58 es porque es una repeticion
                                Caso3 = Caso3 + "1"; // si es repeticion coloca "1"
                            } else {
                                Caso3 = Caso3 + "0";// si es caracter coloca "0"
                            }
                        }

                    }
                    if ((i + 8) >= tamresumen) {// revisa si el mensaje apartir de i + 8 es mayor que el mensaje
                        for (int j = i; j < i + 8; j++) {
                            if (j < tamresumen) {
                                conversion = charresumen[j];//toma el caracter
                                if (conversion < 58) {// si el caracter es menor a 58 es porque es una repeticion
                                    Caso3 = Caso3 + "1";// si es repeticion coloca "1"
                                } else {
                                    Caso3 = Caso3 + "0";// si es caracter coloca "0"
                                }
                            } else {
                                Caso3 = Caso3 + "0";// todos los demas espacios vacios 
                            }
                        }
                    }
                }

                conversion = charresumen[i]; ////toma el caracter
                if (conversion < 58) { // si el caracter es menor a 58 es porque es una repeticion
                    conversion = conversion - 48; // resta 48 para saber el equivalente en numero
                    Caso1=Caso1+binario(conversion+128);// convierte la repeticion en binario pero se le suma 128 para dejar el ultimo bit en alto
                    Caso2=Caso2+"11111111"+binario(conversion);// convierte la repeticion en binario pero se le agrega un byte en alto para identificar que es una repeticion
                    Caso3=Caso3+binario(conversion);// convierte la repeticion en binario pero se le agrega un byte en alto para identificar que es una repeticion
                }
                else{
                    Caso1=Caso1+binario(conversion);// convierte el caracter en binario
                    Caso2=Caso2+binario(conversion);// convierte el caracter en binario
                    Caso3=Caso3+binario(conversion);// convierte el caracter en binario
                    
                }

                

            }
            Resumen2=Resumen;// copia el resumen
            caracteres = this.Resumen2.toCharArray();//Convierte el mensaje en un arreglo de caracteres
            tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
            double totales=(100/tam)*100;// saca el factor de compresion
//            this.jLabel3.setText("r = "+totales);// muestra el factor de compresion
            totales=((100-tam)/100)*100;// saca la eficiencia
//            this.jLabel4.setText("n = "+totales);// muestra la eficiencia
            
            
            
            
//            this.jTextArea1.setText(Matriz+Resumen+"\n Caso1="+Caso1+"\n Caso2="+Caso2+"\n Caso3="+Caso3+"\n");// muestra todos los casos en la pantalla
            Texto=Caso1;
        } else { // si el mensaje tiene mas de 35 caracteres no hace nada
        }
    
        return Texto;
    }
    
    public String binario(int a) {
        String bin = "";
        int binario = 0;
        int temporal = 0;
        for (int i = 7; i >= 0; i--) {
            temporal = (int) Math.pow(2, i);
            binario = binario + temporal;
            if (binario > a) {
                binario = binario - temporal;
                bin = bin + "0";
            } else {
                bin = bin + "1";
            }
        }
        return bin;
    }
    
}
