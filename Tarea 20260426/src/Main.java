public class Main {

        public static void main(String[] args){


        System.out.println("******LISTA DE TAREAS 1******");

        ListaTarea<String> lista1 = new ListaTareaArray<>();

        lista1.AgregarTarea("Estudiar java"); //0
        lista1.AgregarTarea("Hacer tarea"); //1
        lista1.AgregarTarea("Que me explique la IA"); //2

        System.out.println("La lista de tareas es: ");
        lista1.MostrarTareas();

        System.out.println("El tamaño de la lista de tareas es: ");
        System.out.println(lista1.TamanioTarea());

        
        System.out.println("Verificar si la lista esta vacia es: ");
        System.out.println(lista1.EstaVacia());

        System.out.println("El valor de la posición 1 de la lista de tareas es: ");
        System.out.println(lista1.ObtenerTarea(1));


        System.out.println("******LISTA DE TAREAS 2******");

        ListaTarea<Integer> lista2 = new ListaTareaArray<>();

        System.out.println("Verificar si la lista esta vacia es: ");
        System.out.println(lista2.EstaVacia());

        System.out.println("El tamaño de la lista de tareas es: ");
        System.out.println(lista2.TamanioTarea());

        lista2.AgregarTarea(150); //0
        lista2.AgregarTarea(25); //1
        lista2.AgregarTarea(1513); //2
        lista2.AgregarTarea(12); //3

        System.out.println("La lista de tareas es: ");
        lista2.MostrarTareas();

        System.out.println("Verificar si la lista esta vacia es: ");
        System.out.println(lista2.EstaVacia());

        System.out.println("El tamaño de la lista de tareas es: ");
        System.out.println(lista2.TamanioTarea());

    }
    
} 
