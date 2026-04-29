public interface Bolsa<T>  {

    void agregar (T elemento);

    int tamanio();

    boolean VerificarEstaVacia();

    void mostrarElementos();

    T ObtenerElemento(int indice);
    
} 