/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class DPCM {
    public String Mensaje = "";
    public char caracteres[];
    public char alfabeto[] = new char[35];
    public char alfabeto2[] = new char[35];
    public double contadores[] = new double[35];
    public double contadores2[] = new double[35];
    public char temporal;
    public double temporal2;
    public double temporal4;
    public double temporal5 = 0;
    public int temporal3;
    public double div[] = new double[35];
    public double div2[] = new double[35];
    public double tam = 0;
    public int posi = 0;
    public String codigos[];
    String Resumen2 = "";
    public String dpcm(String Texto, int boton){
        int Matrizdiferencia[] = new int[100];
        String Caso1 = ""; // String para el caso 1
        String Caso2 = ""; // String para el caso 2
        String Caso3 = ""; // String para el caso 3
        String Resumen = ""; // String para la extraccion del mensaje abreviado
        Resumen2 = ""; // Copia del String anterior
        Mensaje = Texto;//Obtiene el mensaje que ingreso el usuario
        caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
        tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
        if (tam < 100) { // Si el mensaje ingresado tiene tamaño menor de 10
            for (int i = (int) tam; i < 100; i++) { // for que recorre desde la ultima posicion del mensaje ingresado hasta 100
                Mensaje = Mensaje + " "; // Agrega una "@" al mensaje para autocompletarlo
            }
        }
        caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
        tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
        String Matriz = " ";
        for (int i = 0; i < 100; i++) {//ciclo para llenar la matriz
            Matrizdiferencia[i] = 0;//inicializa la matriz diferencial con 0
            Matriz = Matriz + caracteres[i] + " ";//llena la matriz principal con los caracteres del mensaje
            if ((i % 10) == 0 && i > 1) {//mira si estamos en el final de la lína
                Matriz = Matriz + " \n ";//introduce un salto de linea
            }
        }
        Matriz = Matriz + " \n "; //introduce un salto de línea al final de la matriz

        if (boton == 2) { //Lectura vertical
            Mensaje = ""; // Reinicia el mensaje
            for (int j = 0; j < 10; j++) { // for de 1 a 10
                for (int i = j; i < 100; i = i + 10) { // for que va de i y suma de 10 en 10
                    Mensaje = Mensaje + caracteres[i]; // arma el mensaje nuevamente con la nueva lectura
                }
            }
            caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
            tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres

        }
        if (boton == 1) {//Lectura zig zag
            int esp[] = {46, 37, 28, 19, 29, 38, 49, 96, 65, 74, 83, 92, 93, 84, 75, 66, 57, 48, 39, 47, 58, 67, 76, 85, 94, 95, 86, 77, 68, 59, 67, 78, 87, 96, 97, 88, 77, 89, 98, 99,0, 1, 10, 20, 11, 2, 3, 12, 21, 30, 40, 31, 22, 13, 4, 5, 14, 23, 32, 41, 50, 60, 51, 42, 33, 24, 15, 6, 7, 16, 25, 34, 43, 52, 61, 70, 80, 71, 62, 53, 44, 35, 26, 17, 8, 9, 18, 27, 36, 45, 51, 63, 72, 81, 90, 91, 82, 73, 64, 55};// arreglo con las posiciones de la lectura zig zag
            Mensaje = ""; // Reinicia el mensaje
            int numero;
            for (int i = 0; i < 100; i++) {
                numero = esp[i]; // Variable que toma el espacio que debe tomar en zig zag
                Mensaje = Mensaje + caracteres[numero]; //Dice la posicion que va en zigzag
            }

            caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
            tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres

        }

        if (boton > 0) {//Restringe que el mensaje no tenga mas de 100 caracteres
            int diferencia = 0;//inicializa la diferencia en 0
            Matrizdiferencia[0] = caracteres[0]; //pone en la posicion 0,0 de la matriz diferencia el mismo caracter del mensaje
            for (int i = 1; i < tam; i++) {//arreglo para llenar la matriz de diferencia
                if (caracteres[i] == 32) {//mira si el caracter es un espacio
                    diferencia = 0;//pone la diferencia en 0
                    Matrizdiferencia[i] = 0;//y lo pone en la matriz

                } else {
                    diferencia = caracteres[i] - caracteres[i - 1];//se mira cual es la diferencia con el caracter anterior
                    Matrizdiferencia[i] = diferencia;//lo ingresa en la matriz
                }

            }
        Matriz = " ";
        for (int i = 0; i < 100; i++) {//ciclo para llenar la matriz
            Matriz = Matriz + Matrizdiferencia[i] + " ";//llena la matriz principal con los caracteres del mensaje
            if ((i % 10) == 0 && i > 1) {//mira si estamos en el final de la lína
                Matriz = Matriz + " \n ";//introduce un salto de linea
            }
        }
        Matriz = Matriz + " \n "; //introduce un salto de línea al final de la matriz

            int numero_mayor = 0;
            int numero_temporal = 0;
            int cantidad_bits = 0;
            for (int i = 1; i < tam; i++) {//ciclo para mirar cual es el numero mayor en la matriz de diferencias
                numero_temporal = Matrizdiferencia[i];//se toma un numero de referecia
                if(numero_temporal<0){//se mira si el numero es menor de 0
                    numero_temporal=numero_temporal*(-1);//e multiplica por -1
                }
                if(numero_temporal>numero_mayor){//se mira si el numero de referencia es mayor al que se tenia
                    numero_mayor=numero_temporal;//se modifica el numero mayor por el numero tempora
                }
            }
            cantidad_bits=longbinario(numero_mayor);//se mira cuantos bits necesita para codificar el numero mayor
            String bin_temporal="";
            bin_temporal=binario(Matrizdiferencia[0],8);//se guarda en bin_temporal lo que devuelve la funcion
            Caso1=Caso1+bin_temporal;//se suma a lo que esta guardado en Casol
            for(int i=1;i<100;i++){//ciclo para codificar
                
                if(Matrizdiferencia[i]>=0){//mira si la diferencia es 0 o positiva
                    bin_temporal=binario(Matrizdiferencia[i],cantidad_bits);//codifica la diferencia con la cantidad de bits del numeromayor
                    Caso1=Caso1+"0"+bin_temporal;//y se le agrega el 0 del signo
                }
                else{
                    Matrizdiferencia[i]=Matrizdiferencia[i]*(-1);//si la diferencia es negativa se multiplica por -1
                    bin_temporal=binario(Matrizdiferencia[i],cantidad_bits);//se codifica la diferencia
                    Caso1=Caso1+"1"+bin_temporal;//se le agrega el 1 del signo
                }
                
                
            }
//            System.out.println(Caso1);//imrpime las codificaciones
            Texto=Caso1;

        } else { // si el mensaje tiene mas de 35 caracteres no hace nada
        }
        return Texto;
    }
    public String binario(int a,int b) {//funcion para codificar
        String bin = "";
        int binario = 0;
        b=b-1;//se le resta -1 a la cantidad de bits
        int temporal = 0;
        for (int i = b; i >= 0; i--) {//ciclo para codificar
            temporal = (int) Math.pow(2, i);//eleva 2^-i 
            binario = binario + temporal;//se va sumando para convertir
            if (binario > a) {//si el binario es mayor a a
                binario = binario - temporal;//se le resta temporal
                bin = bin + "0";//se le asigna a bin lo que tenia mas 0
            } else {
                bin = bin + "1";//si no se le asgina un 1
            }
        }
        return bin;//devuelve bin
    }
    
        public int longbinario(int a) {//funcion para saber cuantos bits necesita
        int longbin =0;
        int binario = 0;
        int temporal = 0;
        for (int i = 7; i >= 0; i--) {//ciclo para mirar cuantos bits se necesitan
            temporal = (int) Math.pow(2, i);//se eleva a 2^-i
            binario = binario + temporal;//se va sumando
            if (binario > a) {//si binario es mayor a a
                binario = binario - temporal;//se resta temporal
                if(longbin>0){//y si es mayor que 0 longbin
                    longbin++;//long bi aumenta
                }
                
            } else {
                longbin++;//si no long bin aumenta
            }
        }
        return longbin;//devuelve longbin
    }
    
}
