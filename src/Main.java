

package hanoitowerconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HanoiTower {
    
    //declaracion de variables y objetos
    static Torre tOrigen=new Torre(1,"                   ");
    static Torre tAuxiliar=new Torre(2,"                                             ");
    static Torre tDestino=new Torre(3,"                                                                       ");
    static double numMiniMov=0;//cantidad minima de movimientos a hacer para terminar
    static int cantMovhecha=0;//cantidad de movimientos hechos
    static int cantDiscos=0;//cantidad de Discos
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader texto=new BufferedReader (isr);

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        setCantDisco();
        setNunMiMov();
        mostrarDatos();
        rellenarTorre();
        movimiento(tOrigen, tDestino, tAuxiliar, cantDiscos);
        System.out.println("Cantidad de mov. hechos: "+cantMovhecha);
    }    
    static void rellenarTorre(){
        int cont;//variable contadora
        for (cont=cantDiscos;cont>0;cont--)
            tOrigen.apilar(cont);
        tOrigen.imprimir();
    }
    static void setCantDisco() throws IOException{
        System.out.print("Favor ingrese la cantidad de disco(mayor que 2):");
        cantDiscos=Integer.valueOf(texto.readLine());
    }
    static void setNunMiMov(){ //calcula la minima cantidad de pasos para terminar el juego
        numMiniMov=((Math.pow(2,cantDiscos))-1);
    }
    static void mostrarDatos(){
        System.out.println("Cantidad de discos:"+cantDiscos+"            Cant. minima de mov. a hacer:"+numMiniMov);
        System.out.println();
    }
    static void movimiento(Torre tIni,Torre tDes,Torre tAux,int numDisc){
        int discMov;
        if(numDisc == 1){
            discMov=tIni.desapilar();
            tIni.imprimir();
            tDes.apilar(discMov);
            tDes.imprimir();
            cantMovhecha++;
        }
        else{
            movimiento(tIni, tAux, tDes,(numDisc-1));
            discMov=tIni.desapilar();
            tIni.imprimir();
            tDes.apilar(discMov);
            tDes.imprimir();
            cantMovhecha++;
            movimiento(tAux, tDes, tIni, (numDisc-1));
        }
     }
    
}
