public interface MatrizADT<M> {

    void agregar(int fila, int columna, M valor);

    M obtener(int fila, int columna);

    void mostrar();

}