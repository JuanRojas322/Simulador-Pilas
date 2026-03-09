import java.util.Scanner;
public class SimuladorEditor {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Bienvenido al Simulador de Editor de Texto");

        while (opcion != 5) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingresa el texto: ");
                        String linea = scanner.nextLine();
                        editor.escribirTexto(linea);
                        break;
                    case 2:
                        editor.deshacer();
                        break;
                    case 3:
                        editor.rehacer();
                        break;
                    case 4:
                        editor.mostrarTexto();
                        break;
                    case 5:
                        System.out.println("Saliendo del editor...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingresa un número válido.");
            }
        }
        scanner.close();
    }
}
