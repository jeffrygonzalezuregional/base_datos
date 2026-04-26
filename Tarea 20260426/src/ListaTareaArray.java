import java.util.ArrayList;

public class ListaTareaArray<G> implements ListaTarea<G> {

    private ArrayList<G> tareas;

    public ListaTareaArray(){
        tareas = new ArrayList<>();
    }


    @Override
    public void AgregarTarea(G tarea){
        tareas.add(tarea);
    }

    @Override
    public G ObtenerTarea(int indice){
        return tareas.get(indice);
    }

    @Override
    public int TamanioTarea(){
        return tareas.size();
    }

    @Override
    public boolean EstaVacia(){
        return tareas.isEmpty();
    }

    @Override
    public void MostrarTareas(){

        for ( int posicion = 0; posicion < tareas.size(); posicion++ ){
            System.out.println(tareas.get(posicion));
        }

    }

}