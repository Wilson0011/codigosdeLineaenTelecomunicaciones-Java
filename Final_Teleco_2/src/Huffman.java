/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class Huffman {
    public String Mensaje = "";
    public String Total = "";
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
    public int locacion0=0;
    public int locacion1=0;
    public double total = 0;
    public double parcial = 0;
    public double div[] = new double[35];
    public double div2[] = new double[35];
    public double tam = 0;
    public int posi=0;
     String codigo[];
    public String Huffman(String texto){
        Mensaje = texto;//Obtiene el mensaje que ingreso el usuario
        caracteres = this.Mensaje.toCharArray();//Convierte el mensaje en un arreglo de caracteres
        tam = caracteres.length;//obtiene el tamaño del arreglo de caracteres
        cont = -1;//Variable que recorre el alfabeto
        if (tam <= 35) {//Restringe que el mensaje no tenga mas de 35 caracteres
            for (int i = 0; i < caracteres.length; i++) {//Ciclo que recorre el arreglo de caracteres
                if (caracteres[i] == ' ') {//Mira si en esa posicion hay un espacio
                    caracteres[i] = '_';//reemplaza esos espacios por _
                }
            }
            for (int i = 0; i < caracteres.length; i++) { //Ciclo que recorre el arreglo de caracteres para identificar el alfabeto
                temporal = caracteres[i];//asigna a la variable temporable el caracter a analizar 
                for (int j = 0; j < caracteres.length; j++) {//ciclo que recorre el arreglo de alfabeto
                    if (temporal == alfabeto[j]) {//mira si la variable a analizar se encuentra en el arreglo de alfabeto
                        saber = 1;//si esta en alfabeto le asigna a saber 1, por que estaria repetida
                    }
                }
                if (saber == 0) {//mira si el caracter no esta repetido
                    cont++;//aumenta para asignar en esa posición de alfabeto
                    alfabeto[cont] = temporal;//en la posicion que tiene cont en el arreglo alfabeto guarda la variable que se analizo
                } else {//si el caracter esta repetido
                    saber = 0;//se reinicia la variable saber para analizar otro caracter
                }
            }
            for (int i = 0; i < caracteres.length; i++) {//Ciclo que recorre el arreglo de alfabeto para saber cuantas veces se ha repetido un caracter
                for (int j = 0; j < caracteres.length; j++) {//Ciclo que recorre el arreglo de caracteres para saber cuantas veces se ha repetido un caracter
                    if (alfabeto[i] != ' ') {//mira si en la posición de alfabeto no esta " "
                        if (alfabeto[i] == caracteres[j]) {//mira si el caracter a analizar se encuentra en el arreglo caracteres
                            contadores[i] = contadores[i] + 1;//cuenta cuantas veces esta
                        }
                    }
                }
            }
//            for(int i=0;i<caracteres.length;i++){//Ciclo que recorre el arreglo de caracteres para imprimir el alfabeto y la cantidad de veces
//            if(contadores[i]!=0){//mira si lo que esta en esa posición es diferente de 0
////            System.out.println(alfabeto[i]+" "+contadores[i]);//imprime el alfabeto y la cantidad de veces
//            }
//            }
            for (int i = 0; i < caracteres.length; i++) {//Ciclo que recorre el arreglo de caracteres para hallar la probabilidad
                if (contadores[i] != 0) {//mira si lo que esta en esa posición es diferente de 0
                    div[i] = contadores[i] / tam;//halla la probabilidad de cada caracter y lo guarda en el arreglo div
                    parcial = div[i] * ((Math.log(div[i])) / Math.log(2));//halla la cantidad de información de cada caracter
                    total = total - (parcial);//suma las cantidades de información
                }
            }
//            System.out.println(total); //imprime la entropia por consola
//            this.jLabel1.setText("H(x) = "+total+".");
            posi=cont+1;//Se le asigna este valor para saber hasta donde recorrer los arreglos
            ordenar();//Llama a la función ordenar, para ordenar las probabilidades de mayor a menor
            codigo = new String[posi];//crea un arreglo llamado codigo de tamaño posi
            int orden[] = new int[posi];//crea un arreglo de enteros llamado codigo de tamaño posi
            int saber = 0;//crea variable para saber si ya tomo un o dos numero para sumar
            int saber2= 0;//crea variable para saber si ya se sumaron
            int revisar = 0;//Saber cuando salir del ciclo
            for(int i=0; i<posi;i++){//ciclo para recorrer codigo y orden
                orden[i]=i;//asigna valores de 0 hasta n para el orden
                codigo[i]="";//crea vacios en el arreglo codigo
            }
            while (saber != 5) {//inicia ciclo para hacer las sumas
                temporal5 = 10;//Comparar si hay mayores o menores iniciando con un valor grande
                temporal52 = 10;//Comparar si hay mayores o menores iniciando con un valor grande
                for (int j = posi - 1; j >= 0; j--) { //ciclo que recorre div para encontrar el menor
                    temporal4 = div2[j];//temporal4 guarda el valor que se esta analizando
                    if(saber2==0){ //mira el estado de saber 2 para el primer numero menor
                        if (temporal4 < temporal5 && temporal4 != 0 ) { //mira si temporal4 es menor a temporal5 y si temporal4 es diferente a 0
                            temporal5 = temporal4;//se le asigna a temporal5 lo que esta en temporal4
                            temporal3 = j;// guarda la posicion en la que esta el numero menor
                            temporal2 = div2[j]; //guarda el valor de la menor probabilidad 
                        }
                    }
                    if(saber2==1){ //mira el estado de saber 2 para el segundo numero menor
                        if (temporal4 < temporal52 && temporal4 != 0 ) { //mira si temporal4 es menor a temporal5 y si temporal4 es diferente a 0
                            temporal52 = temporal4; //se le asigna a temporal5 lo que esta en temporal4
                            temporal32 = j; // guarda la posicion en la que esta el numero menor
                            temporal22 = div2[j]; //guarda el valor de la menor probabilidad 
                        }
                    }
                    if(j==0 && saber2==0){ // antes de salir del for dice cual es el numero menor y lo vuelve 0
                        div2[temporal3] = 0; // le asigna en esa posicion un 0
                        saber2++;  // aumenta saber2 para buscar el siguiente numero menor 
                    }
                    else if(j==0 && saber2==1){ // antes de salir del for dice cual es el segundo numero menor y lo vuelve 0
                        div2[temporal32] = 0; // le asigna en esa posicion un 0
                        saber=1;  // para saber que ya encontro los dos numeros menores
                    }
//                    System.out.println(div2[j]);
                }
//                System.out.println();
                if (saber == 1) {   //mira si ya encontro los dos numeros menores
                    div2[temporal3] = temporal2 + temporal22;//suma los dos numeros menores
                    if(temporal22>=temporal2){  // mira si temporal22 es mayor o igual a temporal2
                        locacion0=orden[temporal32]; // le asigna el valor de orden en la posicion temporal32 para asignarle 0
                        locacion1=orden[temporal3]; // le asigna el valor de orden en la posicion temporal13 para asignarle 1
                        for(int i=0;i<posi;i++){ //ciclo que va desde 0 hasta posicion
                            if(orden[i]==locacion0){ // mira si orden en la posicion i es igual a lo que guardo locacion0 hara:
                                codigo[i]=codigo[i]+"0"; //a codigo en esa poicion se le asigna un 0
                                orden[i]=locacion0; // orden en la posicion i recibe el valor de locacion0
                            }
                            if(orden[i]==locacion1){ // mira si orden en la posicion i es igual a lo que guardo locacion1 hara:
                                codigo[i]=codigo[i]+"1"; ////a codigo en esa poicion se le asigna un 1
                                orden[i]=locacion0; // orden en la posicion i recibe el valor de locacion0
                            }
                        }
                    }
                    revisar = 0;  // reinicia la variable revisar 
                    saber = 0; // reinicia la variable saber 
                    saber2 =0; //reinicia la variable saber2
                    
                    for (int i = 0; i < posi; i++) { //ciclo que va de 0 hasta posicion 
                        if (div2[i] != 0) { // mira si div2 en la posicion i es diferente a 0 
                            revisar++; // aumenta revisar
                        }
                    }
                    if (revisar == 1) { // mira si solo hay un numero diferente de 0
                        saber = 5; // si solo hay un numero diferente de 0 le asigna a saber 5 para salirse 
                    }
                } 
            }
            revertir(); // llama la funcion revertit 
            
            longitudprom(); // llama la funcion longitudprom
            tasacompresion(); // llama la funcion tasacompresion
            eficacia(); // llama la funcion eficacia
            mostartodo(); // llama la funcion mostrar todo
        } else { // si el mensaje tiene mas de 35 caracteres no hace nada
        }
        
        texto=salida;
        return texto;
    }
    
    public double longiprom;
    public void longitudprom(){
        double sumas=0; 
        char numbits[]; // crea un arreglo de charsitos
        for(int i=0;i<posi;i++){  //ciclo que va de 0 a poscicion 
            numbits=codigo[i].toCharArray(); // se le asigna numbits el arreglo de chars lo que tenga el arrglo codigo en la posicion i
            sumas=sumas+(numbits.length*div[i]); // suma los valores de la multiplicacionn por la cantidad de bits del codigo
        }
        longiprom=sumas; // se le asigna a longitudprom el resultado de sumas 
//        this.jLabel2.setText("l = "+sumas+"."); // modifica jlabel2 con el valor de sumas 
//        System.out.println(sumas);
    }
        public void RE_organizar(){
        for(int i=0;i<caracteres.length;i++){
            for(int j=0;j<codigo.length;j++){
                if(caracteres[i]==alfabeto2[j]){
                    salida=salida+codigo[j];
                }
            }
            
        }
//       System.out.println(salida);
        
    }
        String salida="";
    public void tasacompresion(){
        double sumas=0;
        sumas=((Math.log(posi)) / Math.log(2))/longiprom; //calcula la tasa de compresion 

//        this.jLabel3.setText("r = "+sumas+"."); //modifica el jlabel3 con el valor de la tasa de compresion
//        System.out.println(sumas);
    }
    public void eficacia(){
        double sumas=0;
        sumas=total/longiprom; // calcula el valor de la eficacia
//        this.jLabel4.setText("n = "+sumas+"."); //modifica el jlabel4 con el valor de la tasa de la eficacia
//        System.out.println(sumas);
    }
    public void mostartodo(){ // imprime el resultado de todas las operaciones anteriores
        String acumulador=" Caracter       |  Numero de Veces       | Probabilidad \n";
        for (int i = 0; i < posi; i++) {
                acumulador=acumulador+("       "+alfabeto2[i]+"                               "+contadores[i]+"                             "+codigo[i]+" \n");
            }
        RE_organizar();
//        this.jTextArea1.setText(acumulador);
System.out.println(""+acumulador);
    }
    public void ordenar() {
        double conta=0;
        for (int i = 0; i < caracteres.length; i++) { //Ciclo que va desde 0 hasta la longitud del mensaje
            for (int j = 0; j < caracteres.length; j++) { //Ciclo que va desde 0 hasta la longitud del mensaje
                temporal4 = div[j]; // Guarda la probabilidad a analizar
                if (temporal4 > temporal5) { //Mira si es mayor a un punto de referencia que se tiene
                    temporal5 = temporal4; //Si es mayor se asigna como nuevo punto de referencia
                    temporal3 = j; // guarda la posición en la que se encuentra
                    temporal2 = div[j]; // guarda la probabilidad
                    temporal = alfabeto[j]; // guarda el caracter que se esta analizando
                    conta=contadores[j]; //guarda la cantidad de veces que esta ese contador
                }
            }
            contadores2[i]=conta; // guarda la ultima cantidad de caracter que se analizo
            
            div2[i] = temporal2; //guarda en div2 la probabilidad
            alfabeto2[i] = temporal; // guarda en alfabeto2 el caracter que se analizo
            div[temporal3] = 0; //guarda en div en la posición que se analizo por ultima vez un 0
            temporal5 = 0;//se reinicia temporal5
        }
        for (int i = 0; i < caracteres.length; i++) {  //Ciclo que va desde 0 hasta la longitud del mensaje
            div[i] = div2[i]; //guarda en div lo que esta en div2
            contadores[i]=contadores2[i];  //guarda en contadores lo que esta en contadores2
        }
    }
    public void revertir(){
        for(int i=0;i<posi;i++){ //Ciclo que va desde 0 hasta posi
            char tempo[]=codigo[i].toCharArray(); //crea un arreglo de char proveniente de lo que se encuentra en codigo en esa posición
            int longitud=tempo.length; //guarda la longitud del anterior arreglo
            char tempo2[]=new char [longitud]; //crea un arreglo tipo char de tamaño longitud
            int k=longitud-1;//se inicia una variable que va desde la ultima posición
            for(int j=0;j<longitud;j++){//Ciclo que va desde 0 hasta longitud
                tempo2[j]=tempo[k];//guarda en tempo2 lo que esta en tempo desde la posición k
                k--;//k ira disminuyendo para guardar el codigo de forma contraria
        }
            codigo[i]="";//se asigna "" a cada posición de codigo
            for(int a=0;a<longitud;a++){//Ciclo que va desde 0 hasta longitud
                codigo[i]=codigo[i]+tempo2[a];//se le asigna a cada posición de codigo lo que esta en codigo mas lo que esta en tempo2
            }
        }
    }
    
}
