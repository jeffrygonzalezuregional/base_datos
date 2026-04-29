import java.util.ArrayList;

public class BolsaArray<T> implements Bolsa<T>  {

    private ArrayList<T> datos;

    public BolsaArray(){
        datos = new ArrayList<>();
        }

    @Override
    public void agregar(T elemento){
        datos.add(elemento);
    }
    @Override
    public int tamanio(){
        return datos.size();
    }
    @Override
    public boolean VerificarEstaVacia(){
        return datos.isEmpty();

    }
    @Override
    public void mostrarElementos(){
        for (int p = 0; p < datos.size(); p++){
            System.out.println("Posicion; " + p + "; Dato;"+ datos.get(p) );
        }
    }
    @Override
    public  T ObtenerElemento(int indice){
        return datos.get(indice);
    }
    
    
}
