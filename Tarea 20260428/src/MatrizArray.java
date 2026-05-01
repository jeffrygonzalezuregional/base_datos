public class MatrizArray<M> implements MatrizADT<M> {

    private Object[][] matriz;
    private int filas;
    private int columnas;

    public MatrizArray(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matriz = new Object[filas][columnas];
    }

    @Override
    public void agregar(int fila, int columna, M valor){
        matriz[fila][columna] = valor;
    }
    @SuppressWarnings("unchecked")
    @Override
    public M obtener(int fila, int columna){
        return (M) matriz[fila][columna];
    }

    @Override
    public void mostrar(){
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}