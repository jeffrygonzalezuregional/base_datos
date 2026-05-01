public class Main {

    public static void main(String[] args) {

        MatrizADT<Integer> matriz = new MatrizArray<>(5, 5);

        
        matriz.agregar(0, 0, 10);
        matriz.agregar(0, 1, 20);
        matriz.agregar(1, 1, 30);
        matriz.agregar(2, 2, 40);
        matriz.agregar(3, 3, 50);
        matriz.agregar(4, 4, 60);

        
        System.out.println("Matriz:");
        matriz.mostrar();

        
        System.out.println("Valor en (1,1): " + matriz.obtener(1, 1));
        System.out.println("Valor en (2,2): " + matriz.obtener(2, 2));
    }

}