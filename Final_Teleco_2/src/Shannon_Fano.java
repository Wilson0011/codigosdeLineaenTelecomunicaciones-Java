
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DanceVangot
 */
public class Shannon_Fano {
    public String Mensaje = "";
    public String Total = "";
    public char caracteres[];
    public char alfabeto[] = new char[35];
    public char alfabeto2[] = new char[35];
    public double contadores[] = new double[35];
    public double contadores2[] = new double[35];
    public int cont = 0;
    public char temporal;
    public double temporal2;
    public double temporal4;
    public double temporal5 = 0;
    public int temporal3;
    public int saber = 0;
    public int locacion0 = 0;
    public int locacion1 = 0;
    public double total = 0;
    public double parcial = 0;
    public double div[] = new double[35];
    public double div2[] = new double[35];
    public double tam = 0;
    public int posi = 0;
    String codigo[];
    public String Shannon(String Texto){
        Mensaje = "";
        Total = "";
        alfabeto = new char[35];
        alfabeto2 = new char[35];
        contadores = new double[35];
        contadores2 = new double[35];
        cont = 1;
        temporal5 = 0;
        locacion0 = 0;
        locacion1 = 0;
        saber = 0;
        total = 0;
        parcial = 0;
        tam = 0;
        posi = 0;
        div = new double[35];
        div2 = new double[35];
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
//            this.jLabel1.setText("H(x) = " + total + ".");//imprime la entropia en el jLabel1
            posi = cont + 1;//Se le asigna este valor para saber hasta donde recorrer los arreglos
            ordenar();//Llama a la función ordenar, para ordenar las probabilidades de mayor a menor
            codigo = new String[posi];//crea un arreglo llamado codigo de tamaño posi
            int orden[] = new int[posi];//crea un arreglo de enteros llamado codigo de tamaño posi
            int saber = 0;//crea variable para saber si ya tomo un o dos numero para sumar
            int saber2 = 0;//crea variable para saber si ya se sumaron
            int revisar = 0;//Saber cuando salir del ciclo
            double mitad = 0;//crea variable para guardar la suma 
            double sumamitad = 0;//crea variable para guardar la mitad de la suma
            double aproxima_0_1 = 100;//crea variable para la resta de de la suma y la mitad con valor de referencia 100
            double aproxima_0_2 = 100;
            int devolvio[];
            int ii = 0;//variable para guardar la posición en la que se encuentra
            int ii_real = 0;//guarda la posició que realmente se necesita
            for (int i = 0; i < posi; i++) {//ciclo para recorrer codigo y orden
                orden[i] = i;//asigna valores de 0 hasta n para el orden
                codigo[i] = "";//crea vacios en el arreglo codigo
            }
            while (saber != 5) {
                aproxima_0_1 = 100;
                aproxima_0_2 = 100;
                sumamitad = 0;
                mitad = 0;
                
                    devolvio = decidir();

                    if (devolvio[2] == 1) {

                        for (int i = devolvio[0]; i <= devolvio[1]; i++) {//ciclo que va desde lo que esta en devolvio[0] hasta lo que esta en devolvio[1] para sumar
                            sumamitad = sumamitad + div[i];//Va sumando cada valor que se encuentra en div[i]
                        }
                        sumamitad = sumamitad / 2;//halla mitad de la suma de los valores

                        for (int i = devolvio[0]; i <= devolvio[1]; i++) {//ciclo que va desde lo que esta en devolvio[0] hasta lo que esta en devolvio[1] para asignar "0" y "1"
                            mitad = mitad + div[i];//suma los valores de div
                            ii = i;//guarda la posición
                            aproxima_0_1 = sumamitad - mitad;//resta la suma de todo div con la mitad de esta y lo guarda en aproxima_0_1

                            if (aproxima_0_1 < 0) {//si este valor es menor de 0
                                aproxima_0_1 = (aproxima_0_1-0.00000000001) * (-1);//a esta resta se le resta 0.00000000001 para una aproximación y se multiplica por -1 ya que la resta es negativa
                            }

                            if (aproxima_0_1 < aproxima_0_2) { //mira si aproxima_0_1 es menor a aproxima_0_2 que es de referencia
                                aproxima_0_2 = aproxima_0_1; //si es asi el nuevo valor de referencia sera aproxima_0_1 
                                ii_real = ii;//guarda la posición en la que se encuentra 
                            }

                            if (aproxima_0_2 < aproxima_0_1) {//si aproxima dos es menor que aproxima 1 
                                i = posi;//i sera de una vez posi
                            }


                        }
                        for (int i = devolvio[0]; i <= devolvio[1]; i++) {//ciclo para asginar 0 y 1 que va de 0 a 1
                             if (i <= ii_real) {//mira si i es menor o igual a ii_real
                                codigo[i] = codigo[i] + "0";//asigna un "0" en codigo
                            } else if (i > ii_real) {//si no se cumple y es mayor
                                codigo[i] = codigo[i] = codigo[i] + "1";//asgina "1" en codigo
                            }

                        }


                    } else if (devolvio[2] == 0) {//si devolio en la posicion 2 es 0    
                        saber = 5;//saber se vuelve 5 para salirse del ciclo
                    }

            }

//
            longitudprom(); // llama la funcion longitudprom
            tasacompresion(); // llama la funcion tasacompresion
            eficacia(); // llama la funcion eficacia
            mostartodo(); // llama la funcion mostrar todo
        } else { // si el mensaje tiene mas de 35 caracteres no hace nada
            //JOptionPane.showMessageDialog(this,"El mensaje es demasiado largo", "Error",JOptionPane.ERROR_MESSAGE);//imprime un mensaje de error si el mensaje es mayor a 35 caracteres
        }
        
        Texto=salida;
        return Texto;
    }
     public double longiprom;
     public String salida="";
        public void RE_organizar(){
        for(int i=0;i<caracteres.length;i++){
            for(int j=0;j<codigo.length;j++){
                if(caracteres[i]==alfabeto2[j]){
                    salida=salida+codigo[j];
                }
            }
            
        }
//        System.out.println(salida);
        
    }
    public int[] decidir() { //Indica si hay ceros o unos repetidos 
        int repeticion = 0; // indica si hay uno repetido
        int inicio = 0; // Da la Posicion inicial de donde esta repetido
        int fin = 0; // Da la posicion final de donde esta repetido
        int saber1 = 0; //Identifica las fases de repeticion
        int manda[] = new int[3]; // Arreglo para devolver los datos del analisiis a realizae  
        for (int i = 1; i < posi; i++) { //Recorre todo el arreglo de codigo para analizar si esta repetido
            if (codigo[i].equals(codigo[i - 1])) { //Compara el string con el string de la posicion anterior 
                if (saber1 == 0) { // Fase de identificacion la posicion inicial
                    inicio = i  + 1; //Dice donde esta el primero de los repetidos
                    saber1 = 1; //Pasa a la siguiente fase
                    fin = i; //Dice parcialmente cual es la posicion final donde esta repetido
                    repeticion = 1; //Indica que como minimo hay uno repetido
                } else { // Si saber no es igual a 1:
                    fin++; // aumenta la posicion final
                }

            } else if (saber1 == 1) { //Cuando saber sea igual a 1 va a terminar el for
                i = posi - 1; // Convierte a i para salirse del ciclo
            }
            if (i == posi - 1) { // Cuando esta en la ultima posicion del vector le asigna a manda el inicio, el fin y el indicador de si esta repetido o no.
                manda[0] = inicio;  //En la posicion 0 le asigna incio 
                manda[1] = fin; // En la posicion 1 le asigna fin
                manda[2] = repeticion; // en la posicion 2 le asigna repeticion
            }

        }
        return manda; // Retorna el Vector manda 
    }
    public void longitudprom() {
        double sumas = 0;
        char numbits[]; // crea un arreglo de chars
        for (int i = 0; i < posi; i++) {  //ciclo que va de 0 a poscicion 
            numbits = codigo[i].toCharArray(); // se le asigna numbits el arreglo de chars lo que tenga el arrglo codigo en la posicion i
            sumas = sumas + (numbits.length * div[i]); // suma los valores de la multiplicacionn por la cantidad de bits del codigo
        }
        longiprom = sumas; // se le asigna a longitudprom el resultado de sumas 
//        this.jLabel2.setText("l = " + sumas + "."); // modifica jlabel2 con el valor de sumas 
    }

    public void tasacompresion() {
        double sumas = 0;
        sumas = ((Math.log(posi)) / Math.log(2)) / longiprom; //calcula la tasa de compresion 

//        this.jLabel3.setText("r = " + sumas + "."); //modifica el jlabel3 con el valor de la tasa de compresion
//        System.out.println(sumas);
    }

    public void eficacia() {
        double sumas = 0;
        sumas = total / longiprom; // calcula el valor de la eficacia
//        this.jLabel4.setText("n = " + sumas + "."); //modifica el jlabel4 con el valor de la tasa de la eficacia
//        System.out.println(sumas);
    }

    public void mostartodo() { // imprime el resultado de todas las operaciones anteriores
        String acumulador = " Caracter       |  Numero de Veces       | Probabilidad \n";
        for (int i = 0; i < posi; i++) {
            acumulador = acumulador + ("       " + alfabeto2[i] + "                               " + contadores[i] + "                             " + codigo[i] + " \n");
        }
        RE_organizar();
//        this.jTextArea1.setText(acumulador);
    }

    public void ordenar() {
        double conta = 0;
        for (int i = 0; i < caracteres.length; i++) {
            for (int j = 0; j < caracteres.length; j++) {
                temporal4 = div[j];
                if (temporal4 > temporal5) {
                    temporal5 = temporal4;
                    temporal3 = j;
                    temporal2 = div[j];
                    temporal = alfabeto[j];
                    conta = contadores[j];
                }
            }
            contadores2[i] = conta;
            div2[i] = temporal2;
            alfabeto2[i] = temporal;
            div[temporal3] = 0;
            temporal5 = 0;
        }
        for (int i = 0; i < caracteres.length; i++) {
            div[i] = div2[i];
            contadores[i] = contadores2[i];
        }
    }

    public void revertir() {
        for (int i = 0; i < posi; i++) {
            char tempo[] = codigo[i].toCharArray();
            int longitud = tempo.length;
            char tempo2[] = new char[longitud];
            int k = longitud - 1;
            for (int j = 0; j < longitud; j++) {
                tempo2[j] = tempo[k];
                k--;
            }
            codigo[i] = "";
            for (int a = 0; a < longitud; a++) {
                codigo[i] = codigo[i] + tempo2[a];
            }
        }
    }
}
