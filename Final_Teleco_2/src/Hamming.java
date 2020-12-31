/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class Hamming {
    public String Mensaje = "";
    public char caracteres[];
    public char caracteres2[];
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
    public char Mensaje2[];
    public String hamming(String Texto){
        
        Mensaje = Texto;//Obtiene el mensaje que ingreso el usuario

        caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
        tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
        int boton = 0; //Variable para saber que tipo de lectura
            int cantidad_paridades = 0;// Saber cantidad de bits de paridad
            int revisar = 0;// Variable que toma los valores de 2^n
            int cont = 0;//Contador del exponente n
            int tam_final = 0;// Tamaño total del mensaje
            int cambio = 0;// variable encargada de de saber el cambio de bit a tomar en cuenta o ignorar 
            Mensaje2 = new char[1000];//mensaje temporal de tamaño 100
            cont = 0;//Contador del exponente n
            revisar = (int) Math.pow(2, cont);// Variable que toma los valores de 2^n
            for (int i = 0, j = 0; i < tam; j++) {// ciclo que asigna x en los lugares de las paridades temporarlmente
                if (revisar - 1 == j) {//Si 2^n es igual a i coloca una 'x'
                    Mensaje2[j] = 'x';//coloca una 'x'
                    cont++;//Aumenta cont
                    cantidad_paridades++;//Aumenta cantidad_paridades
                    revisar = (int) Math.pow(2, cont);// Variable que toma los valores de 2^n
                } else {
                    Mensaje2[j] = caracteres[i];//Si no es 2^n coloca el siguiente caracter que sigue en el mensaje
                    i++;//aumneta el contador de poscicion del mensaje
                }

            }
            Mensaje = "";//Inicializa el string mensaje
            for(int i=0;i<tam+cantidad_paridades;i++){//Ciclo para llenar el string mensaje
                Mensaje=Mensaje+Mensaje2[i];
            }
            tam_final = (int) tam + cantidad_paridades;//Tamaño total del mensaje
            caracteres2=new char[tam_final];//mensaje final con el tamaño exacto
            for(int i=0;i<tam_final;i++){//asgnamos el mensaje final sin las paridades
                caracteres2[i]=Mensaje2[i];
            }
            int saltar_inicial = 0;//contador de bits a saltar
            int contar = 0;//saber la cantidad de veces que va a contar y a ignorar
            int lleva = 0;// variable que indica la cantidad restante a contar o ignorar
            int ceros = 0;// contador de unos
            for (int i = 0; i < cantidad_paridades; i++) {//ciclo para asignar paridades
                revisar = (int) Math.pow(2, i);// Variable que toma los valores de 2^n
                saltar_inicial = revisar - 1;//contador de bits a saltar
                contar = revisar;//saber la cantidad de veces que va a contar y a ignorar
                lleva=contar;// variable que indica la cantidad restante a contar o ignorar
                ceros=0;// inicializa al comienzo de cada ciclo en ceros
                for (int j = saltar_inicial; j < tam_final; j++) {
                    if (cambio == 0) {// si es cero cuenta
                        if (caracteres2[j] == '1') {// si es '1' entra
                            ceros++;//aumenta el contador ceros
                        }
                        lleva--;// disminuye el contador lleva
                        if(lleva==0){//si lleva es '0' entra
                            lleva=contar;// reinicia el valor de lleva
                            cambio=1;// cambio cambia, literal
                        }
                    }
                    else{// si es uno ignora
                        lleva--;// reinicia el valor de lleva
                        if(lleva==0){//si lleva es '0' entra
                            lleva=contar;
                            cambio=0;// cambio cambia, literal
                        }
                    }
                }
                if(ceros%2==0){// si ceros%2 es igual 0 coloca un '0' en el espacio de la paridad
                    caracteres2[revisar-1]='0';
                }
                else{// si ceros%2 es diferente 0 coloca un '1' en el espacio de la paridad
                    caracteres2[revisar-1]='1';
                }
                
            }
            Mensaje = "";

            for(int i=0;i<tam+cantidad_paridades;i++){//ciclo que construye el mensaje final
                Mensaje=Mensaje+caracteres2[i];
            }
            
            Texto=Mensaje;

        return Texto;
    }
    
}
