

package hanoitowerconsole;


public class Torre {
    //declaracion de objetos y variables
    private Disco top=new Disco();
    private int numDisco=0;
    private int numTorre;
    private String posx;

    //Este es el constructor
    public Torre(int n, String x) {
        top = null;
        numTorre = n;
        posx = x;
    }
    
    //declaracion de metodos
    public void apilar(int inf){
        Disco nuevodisc=new Disco();
        nuevodisc.info=inf;
        nuevodisc.ant=top;
        top=nuevodisc;
        numDisco++;
    }
    public int desapilar(){
        Disco delDisc;
        delDisc=top;
        top=top.ant;
        numDisco--;
        return delDisc.info;
    }
   
   
    public void imprimir(){
        Disco aux=new Disco();
        aux=top;
        while(aux!=null){
            System.out.print(posx);
            System.out.println(aux.info);
            aux=aux.ant;
        }
        System.out.print(posx);
        System.out.println("---------");//esto es para que se vea en una base
        System.out.print(posx);
        System.out.println("Torre #:"+numTorre);
        System.out.println();
    }

}
