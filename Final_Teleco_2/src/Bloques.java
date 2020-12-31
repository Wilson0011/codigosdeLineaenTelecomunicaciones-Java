/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class Bloques {
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
    public char num_mensaje_n[];
    public String numero_enbase = "";
    public char num_base_f[];
    public double num_decimal_espa = 0;
    public String num_base_s = "";
    public String Bloqueo (String Texto){
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
//            this.jLabel1.setText("H(x) = " + total + ".");
            posi = cont + 1;//Se le asigna este valor para saber hasta donde recorrer los arreglos
            ordenar();//Llama a la función ordenar, para ordenar las probabilidades de mayor a menor
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            codigos = new String[posi];// crea un arreglo de tamaño de caracteres del alfabetp
            for (int i = 0; i < posi; i++) {//ciclo para recorrer el arreglo creado
                codigos[i] = "";//inicializa el arreglo codigos
            }
            double n = Math.log(posi) / Math.log(2);//operacion para mirar que coificación usar
            int n_entera = (int) n;// saca la parte entera de la operación anterior
            int cont_unos = 2;//inicializa la variable cont_unos en 2
            int cont_unos2 = 0;//inicializa la variable cont_unos en 0
            int asigno = '0';//Crea una variable asigno que tendra guardado '0'

            if (n_entera == n) {//si el numero resultante de la operacion no tiene parte decimal se usa codificación de bloques

                for (int i = 0; i < n_entera; i++) {//ciclo que va desde 0 hasta la parte entera de la operacion

                    for (int j = 0; j < posi; j++) {//ciclo que va de 0 hasta el tamaño del alfabeto
                        if (cont_unos2 == cont_unos) {//mira si las dos variables son iguales
                            cont_unos2 = 0;//si es asi reiniciala variable cont_unos2
                        }
                        if (cont_unos2 >= (cont_unos / 2)) {//si cont_unos2 es mayor o igual que la mitad de cont_unos
                            codigos[j] = codigos[j] + "1";//asigna en codigos un 1 
                            cont_unos2++;//aumenta la variable cont_unos2
                        }
                        if (cont_unos2 < (cont_unos / 2)) {//si cont_unos2 es menor que la mitad que cont_unos 
                            codigos[j] = codigos[j] + "0";//asigna a codigos un 0
                            cont_unos2++;//aumenta la variable cont_unos2
                        }

                    }
                    cont_unos2 = 0;//reinicia cont_unos2
                    cont_unos = cont_unos * 2;//aumenta en dos veces cont_unos
                }
                revertir();//llama a la funcion revertir
                mostartodo();//llama a la funcion mostartodo
                Texto=salida;
                
            } else {//si tiene parte decimal se usa la codificacion aritmetica modificada
                num_mensaje = "";// vuelve a inicializar num_mensaje
                asignar = new char[posi];//le asigna un tamaño de posi a asignar
                asigno = '0';//vuelve a inicializar asigno

                for (int i = 0; i < posi; i++) {//ciclo de 0 a posi
                    asignar[i] = (char) asigno;//rellena asigno de 0 a posi(base)
                    asigno++;//aumenta asigno

                }
                char num_tempo;//crea un char num_tempo
                for (int i = 0; i < tam; i++) {//recorre de 0 hasta la cantidad total de caracteres
                    num_tempo = caracteres[i];//guarda en num_tempo el caracter
                    for (int j = 0; j < posi; j++) {//recorre el alfabeto
                        if (num_tempo == alfabeto[j]) {//mira si el caracter es igual al caracter del alfabeto
                            num_mensaje = num_mensaje + asignar[j];//va creando la trama en  base N
                        }
                    }
                }
                num_base = num_mensaje.toCharArray();//crea un arreglo de char con lo guardado en num_mensaje
                num_mensaje_n = num_mensaje.toCharArray();//crea una copia de lo anterior
                num_base_f = new char[num_mensaje_n.length];//crea un arreglo de char con longitud de num_mensaje_n
                suma_base = 0;//inicializa suma_base
                for (int i = 0; i < num_base.length; i++) {//ciclo que recorrera hasta la longitud del numero en base N
                    suma_base = suma_base + ((Math.pow(asigno - 48, -(i + 1)) * (num_base[i] - 48)));//pasa el número a decimal 
                }
                numero_enbase = "";//inicializa numero_enbase
                for (int k = 0; k < num_base.length; k++) {//ciclo que va de 0 a la longitud de num_base
                    numero_enbase = numero_enbase + num_base[k];//va uniendo los valores en base N 
                }
                acumulador = "El numero a codificar en base(" + (asigno - 48) + ") es = 0." + numero_enbase + "\nEl numero a codificar es= " + suma_base + " \nEl numero codificado es= ";//guarda el mensaje con la informacion de la base y en decimal
                double Final = suma_base;//crea una copia del numero en decimal
                double copia_Final = Final;//crea una copia del numero decimal
                Finall = Final + "";//pasa a string el numero decimal
                char Inicio_Esperado[] = new char[1000];//crea un arreglo de 1000 posiciones
                char Final_Esperado[] = this.Finall.toCharArray();//pasa de string a arreglo de char
                char Final_Bin[] = new char[1000];//crea un arreglo de 1000 posiciones
                double sumadecimal = 0;//inicializa suma decimal
                for (int i = 0; i < 1000; i++) {//ciclo que recorrera 1000 posiciones
                    if (i == 1) {//si se esta en la posicion numero 1 se coloca un char '.'
                        Final_Bin[i] = '.';
                        Inicio_Esperado[i] = '.';
                    } else {//si no se rellena de '0'
                        Final_Bin[i] = '0';
                        Inicio_Esperado[i] = '0';
                    }
                }
                int salir = 0;//inicializa salir
                int contadors = 2;//inicializa contadors
                while (salir == 0) {//ciclo que se saldra si salir no es 0

                    copia_Final = copia_Final * 2;//multiplica el numero decimal por dos
                    if (copia_Final >= 1.0) {//mira si es mayor a 1
                        Final_Bin[contadors] = '1';//guarda un 1 en Final_Bin el la posicion contadors
                        contadors++;//aumenta contadors
                        copia_Final = copia_Final - 1; //resta un 1 al numero decimal
                    } else {
                        Final_Bin[contadors] = '0';//si no pone un 0 en Final_bin
                        contadors++;//aumenta contadors

                    }
                    sumadecimal = 0;//inicializa suma decimal
                    for (int i = 2; i < 1000; i++) {//ciclo que va de 2 a 1000 para no tomar el 0 y el . del comienzo
                        if (Final_Bin[i] == '1') {//mira cada vez que haya un uno
                            int elevado = -(i - 1);//va poniendo los numeros negativos a elevar al dos
                            sumadecimal = sumadecimal + (Math.pow(2, elevado));//lo convierte a decimal
                        }
                    }
                    
                    num_decimal_espa = sumadecimal;//guarda suma decirmal en num_decimal_espa
                    int enter = 0;//inicializa enter
                    int contador_bien = 0;//inicializa contador_bien
                    double num_decimal_espa2=0;//inicializa num_decimal_espa2
                    char num_base_f2;//crea variable char
                    for (int i = 0; i < 1000; i++) {//ciclo que va de 0 a 1000
                        num_decimal_espa = num_decimal_espa * (asigno - 48);//multiplica por la base
                        enter = (int) num_decimal_espa;//guarda la parte entera
                        
                        num_base_f[i] = (char) (enter + 48);//pasa la parte entera a char
//                        System.out.println(num_base_f[i]);//imprime el numero en esa posicion
                        num_decimal_espa=num_decimal_espa-enter;//resta la parte entera

                        if (num_base_f[i] == num_mensaje_n[i]) {//mira si es igual al numero en base N
                            
                            if (i == (num_mensaje_n.length - 2)) {//mira si i esta en la penultima posicion
                                num_decimal_espa2=num_decimal_espa * (asigno - 48);//multiplica por la base
                                num_decimal_espa2=Math.round(num_decimal_espa2);//redondea el numero decimal
                                enter = (int) num_decimal_espa2;//mira la parte entera del redondeo
                                num_base_f2=(char) (enter + 48);//lo pasa a char
                                if(num_base_f2==num_mensaje_n[i+1]){//mira si es igual a la siguiente posicion de num_mensaje_n
                                    num_base_f[i+1]=num_base_f2;//iguala a num_base_f2
//                                    System.out.println(num_base_f[i+1]);//imprime la siguiente posicion
                                    salir=1;//cambia salir para que termine el ciclo
                                    i=1000;//pone i en 1000 para que se acabe el ciclo
                                }

                            }
                        } 
                        else {
                            i=1000;//si no se acaba el ciclo

                        }

                    }
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
                }
//                System.out.println();
                for (int i = 0; i < contadors; i++) {//ciclo que va de 0 a contadors
                    acumulador = acumulador + Final_Bin[i];//guarda en el mensaje el numero en binario
                    //System.out.print(Final_Bin[i]);

                }
                 String pre_salida="";
               for(int i=2;i<contadors;i++){
                   pre_salida=pre_salida+Final_Bin[i];
               }
//               System.out.print(pre_salida);
               Texto=pre_salida;
                //////////////////////////////////////////////////////////////////////////////////////////////////
//                this.jTextArea1.setText(acumulador);
            }

        } else { // si el mensaje tiene mas de 35 caracteres no hace nada
        }
        return Texto;
    }
           public void RE_organizar(){
        for(int i=0;i<caracteres.length;i++){
            for(int j=0;j<codigos.length;j++){
                if(caracteres[i]==alfabeto[j]){
                    salida=salida+codigos[j];
                }
            }
            
        }
//        System.out.println(salida);
        
    }
        String salida="";
    public void mostartodo() { // imprime el resultado de todas las operaciones anteriores
        String acumulador = " Caracter       |  Numero de Veces       | Codificacion \n";//mensaje en string 
        for (int i = 0; i < posi; i++) {
            acumulador = acumulador + ("       " + alfabeto[i] + "                               " + contadores[i] + "                             " + codigos[i] + " \n");//imrpime la informacion
        }
        RE_organizar();
//        this.jTextArea1.setText(acumulador);
    }

    public void ordenar() {
        double conta = 0;
        for (int i = 0; i < caracteres.length; i++) { //Ciclo que va desde 0 hasta la longitud del mensaje
            for (int j = 0; j < caracteres.length; j++) { //Ciclo que va desde 0 hasta la longitud del mensaje
                temporal4 = div[j]; // Guarda la probabilidad a analizar
                if (temporal4 > temporal5) { //Mira si es mayor a un punto de referencia que se tiene
                    temporal5 = temporal4; //Si es mayor se asigna como nuevo punto de referencia
                    temporal3 = j; // guarda la posición en la que se encuentra
                    temporal2 = div[j]; // guarda la probabilidad
                    temporal = alfabeto[j]; // guarda el caracter que se esta analizando
                    conta = contadores[j]; //guarda la cantidad de veces que esta ese contador
                }
            }
            contadores2[i] = conta; // guarda la ultima cantidad de caracter que se analizo

            div2[i] = temporal2; //guarda en div2 la probabilidad
            alfabeto2[i] = temporal; // guarda en alfabeto2 el caracter que se analizo
            div[temporal3] = 0; //guarda en div en la posición que se analizo por ultima vez un 0
            temporal5 = 0;//se reinicia temporal5
        }
        for (int i = 0; i < caracteres.length; i++) {  //Ciclo que va desde 0 hasta la longitud del mensaje
            div[i] = div2[i]; //guarda en div lo que esta en div2
            contadores[i] = contadores2[i];  //guarda en contadores lo que esta en contadores2
        }
    }

    public void revertir() {
        for (int i = 0; i < posi; i++) { //Ciclo que va desde 0 hasta posi
            char tempo[] = codigos[i].toCharArray(); //crea un arreglo de char proveniente de lo que se encuentra en codigo en esa posición
            int longitud = tempo.length; //guarda la longitud del anterior arreglo
            char tempo2[] = new char[longitud]; //crea un arreglo tipo char de tamaño longitud
            int k = longitud - 1;//se inicia una variable que va desde la ultima posición
            for (int j = 0; j < longitud; j++) {//Ciclo que va desde 0 hasta longitud
                tempo2[j] = tempo[k];//guarda en tempo2 lo que esta en tempo desde la posición k
                k--;//k ira disminuyendo para guardar el codigo de forma contraria
            }
            codigos[i] = "";//se asigna "" a cada posición de codigo
            for (int a = 0; a < longitud; a++) {//Ciclo que va desde 0 hasta longitud
                codigos[i] = codigos[i] + tempo2[a];//se le asigna a cada posición de codigo lo que esta en codigo mas lo que esta en tempo2
            }
        }
    }
    
}
