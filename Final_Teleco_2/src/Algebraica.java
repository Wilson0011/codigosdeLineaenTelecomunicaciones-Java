/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class Algebraica {
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
    public int locacion0=0;
    public int locacion1=0;
    public double total = 0;
    public double parcial = 0;
    public double div[] = new double[35];
    public double div2[] = new double[35];
    public double tam = 0;
    public int posi=0;
    double proba[];
    int lugar=0;
    double A_actual=0;
    double B_actual=1;
    double ai=0;
    double bi=0;
    String acumulador="";
    public String Alge(String Texto){
        Mensaje = Texto;//Obtiene el mensaje que ingreso el usuario
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
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            proba = new double[posi];//crea un arreglo llamado codigo de tamaño posi
            double sumaproba=0;//inicializa una variable que sumara las probabilidades
            for(int i=0; i<posi; i++){//ciclo para ir sumando las probabilidades
                sumaproba=sumaproba+div2[i];//Suma probabilidades
                proba[i]=sumaproba;//guarda la suma en el arreglo 
//                System.out.println(proba[i]+ " "+ alfabeto2[i]);//imprime la suma de las probabilidades
            }
            A_actual=0;//inicializa a_actual en 0
            B_actual=1;//inicializa b_actual en 1
            for(int i=0;i<tam;i++){//ciclo para hacer los calculos
                for (int j=0;j<posi;j++){//ciclo para identificar a que lugar de la linea pertenece el caracter
                    if(caracteres[i]==alfabeto2[j]){//identifica el caracter en el alfabeto
                        lugar=j;//guarda la posición
                    }
                }
                if(lugar==0){//si el caracter se encuentra en el comienzo de la linea
                    ai=A_actual+(B_actual-A_actual)*0;//calcula ai con a presente 0
                    bi=A_actual+(B_actual-A_actual)*proba[lugar];//calcula bi
                    A_actual=ai;//guarda ahora como a_actual el ai calculado
                    B_actual=bi;//guarda como b_actual el bi calculado
                }
                else{//si se encuentra en otra sección de la linea
                    ai=A_actual+(B_actual-A_actual)*proba[lugar-1];//calcula ai con el limite inferior del segmento
                    bi=A_actual+(B_actual-A_actual)*proba[lugar];//calcula bi con el limite superior del segmento
                    A_actual=ai;//guarda ahora como a_actual el ai calculado
                    B_actual=bi;//guarda como b_actual el bi calculado
                }
            }
//            System.out.println();
//            System.out.println();
//            System.out.println("El numero a codificar es= "+A_actual);//imprime el último ai correspondiente al número a codificar
            acumulador="El numero a codificar es= "+A_actual+" \nEl numero codificado es= ";//guarda el mensaje en acumulador            
            /////////////////////////////////////
            double Final=A_actual;//guarda a_actual como una variable tipo double
            double copia_Final=Final;//crea un backup de a_actual
            Finall=Final+"";//guarda el a_actual como string
            char Inicio_Esperado[]=new char [1000];
            char Final_Esperado[]=this.Finall.toCharArray();//pasa el string de finall a arreglo de char
            char Final_Bin[]=new char [1000];
            double sumadecimal=0;//inicia la sumadecimal en 0
            for(int i=0;i<1000;i++){//cilo para llenar el arreglo que guardara el numero en binario
                if(i==1){//si esta en la segunda posición del arreglo
                    Final_Bin[i]='.';//pone un . en esta posición
                    Inicio_Esperado[i]='.';//pone un . en esta posición
                }
                else{
                    Final_Bin[i]='0';//si no esta en la segunda posición guarda ceros
                    Inicio_Esperado[i]='0';//si no esta en la segunda posición guarda ceros
                }
            }
            int salir=0;
            int contadors=2;
            while(salir==0){//ciclo para convertir a binario y verificar igualdad
                
                copia_Final=copia_Final*2;//multiplica el decimal *2
                if(copia_Final>=1.0){//mira si es mayor que 1
                    Final_Bin[contadors]='1';//guarda en esa posición un 1
                    contadors++;//aumenta contadors
                    copia_Final=copia_Final-1;//le resta a copia final un 1 
                }
                else{
                    Final_Bin[contadors]='0';//si no guarda un 0
                    contadors++;//aumenta contadors
                }
                sumadecimal=0;//inicializa de nuevo sumadecimal en 0
                for(int i=2;i<1000;i++){//ciclo para verificar igualdad
                    if(Final_Bin[i]=='1'){//mira si hay un 1 en Final_bin
                        int elevado=-(i-1);//guarda la posicion en la que se encuentra pero negativa
                        sumadecimal=sumadecimal+(Math.pow(2, elevado));//realiza la potencia de 2 en la posicion y la suma
                    }
                }
//               System.out.println(sumadecimal);
                if(sumadecimal==Final){//verifica si esta suma es igual al número inicial
                    salir=1;//si es asi sale del ciclo
                }

            }
//            System.out.println();
            for(int i=0;i<contadors;i++){//ciclo para guardar el numero binario en el mensaje
                    acumulador=acumulador+Final_Bin[i];//guarda el numero binario en el mensaje
//                    System.out.print(Final_Bin[i]);
                    
                }
//            System.out.println();
            acumulador=acumulador+"\nReconstruccion del mensaje= ";//agrega al mensaje el texto
           /////// Reconstruir mensaje
            double an=A_actual;
            for(int i=0;i<posi;i++){//ciclo para reconstruir el mensaje
            if(i==0){//mira si estamos en la primera reconstruccion
                if(0<=an && proba[i]>an){//mira si a_actual es mayor que 0 pero menor que la suma de la probabilidad
                    lugar=i;//guarda el lugar
                }
            }
            else{
                if(proba[i-1]<=an && proba[i]>an){//mira si a_actal es mayor o igual que la suma anterior pero menor que la actual
                    lugar=i;//guarda el lugar
                }
            }
            }
            acumulador=acumulador+alfabeto2[lugar];//guarda en el mensaje el caracter
//            System.out.println(alfabeto2[lugar]);
            for(int i=1;i<tam;i++){//ciclo para hacer los calculos
                if(lugar==0){
                    an=an/(proba[lugar]);//si esta en la primera parte de la linea an sera el decimal / la suma de la probabilidad
                }
                else{
                    an=(an-proba[lugar-1])/(proba[lugar]-proba[lugar-1]);//si no calcula an con los limites del segmento
                }
                for(int j=0;j<posi;j++){
                    if(j==0){
                        if(0<=an && proba[j]>an){
                            lugar=j;
                        }
                    }
                    else{
                        if(proba[j-1]<=an && proba[j]>an){
                            lugar=j;
                        }
                
                    }
            }
                acumulador=acumulador+alfabeto2[lugar];
//                System.out.println(alfabeto2[lugar]);
            }
            ////////////////////// fin reconstruir mensaje
//            this.jTextArea1.setText(acumulador);//imprime ya el mensaje total
                String pre_salida="";
               for(int i=2;i<contadors;i++){
                   pre_salida=pre_salida+Final_Bin[i];
               }
               
               Texto=pre_salida;
        } else { // si el mensaje tiene mas de 35 caracteres no hace nada
        }
        return Texto;
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
}
