public class Main {
 
    public static void main(String[] args){

        Bolsa<String> bolsaNegra = new BolsaArray<>();

        bolsaNegra.agregar("Muerto");
        bolsaNegra.agregar("Corazonde mi ex");

        System.out.println("La posicion 1  es el siguiente dato:" + bolsaNegra.ObtenerElemento(1));
        System.out.println("El tamaño es el siguiente;" + bolsaNegra.tamanio());
  }
}
