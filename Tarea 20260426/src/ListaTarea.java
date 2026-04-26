public interface ListaTarea<G> {

    void AgregarTarea(G tarea);

    G ObtenerTarea(int indice);

    int TamanioTarea();

    boolean EstaVacia();

    void MostrarTareas();
    
}