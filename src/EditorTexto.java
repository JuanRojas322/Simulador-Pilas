import java.util.Scanner;
public class EditorTexto {


    private PilaPersonalizada pilaUndo; // Guarda las acciones realizadas
    private PilaPersonalizada pilaRedo; // Guarda las acciones deshechas

    public EditorTexto() {
        pilaUndo = new PilaPersonalizada();
        pilaRedo = new PilaPersonalizada();
    }

    public void escribirTexto(String texto) {
        pilaUndo.push(texto);
        // Cada vez que escribimos algo nuevo, el historial de "Rehacer" se borra
        pilaRedo.vaciar();
        System.out.println("Texto agregado con éxito.");
    }

    public void deshacer() {
        if (pilaUndo.isEmpty()) {
            System.out.println("No hay acciones para deshacer.");
        } else {
            String textoDeshecho = pilaUndo.pop();
            pilaRedo.push(textoDeshecho);
            System.out.println("Se deshizo la acción: '" + textoDeshecho + "'");
        }
    }

    public void rehacer() {
        if (pilaRedo.isEmpty()) {
            System.out.println("No hay acciones para rehacer.");
        } else {
            String textoRehecho = pilaRedo.pop();
            pilaUndo.push(textoRehecho);
            System.out.println("Se rehízo la acción: '" + textoRehecho + "'");
        }
    }

    public void mostrarTexto() {
        System.out.println("\n--- TEXTO ACTUAL ---");
        pilaUndo.mostrarContenidoInverso();
        System.out.println("--------------------\n");
    }
}
