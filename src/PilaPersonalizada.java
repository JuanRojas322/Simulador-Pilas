/**
 * Clase que implementa una Pila (Stack) manualmente usando Nodos.
 */
public class PilaPersonalizada {
        // Clase interna para los nodos de la pila
        private class Nodo {
            String texto;
            Nodo siguiente;

            public Nodo(String texto) {
                this.texto = texto;
                this.siguiente = null;
            }
        }

        private Nodo tope; // Apunta al elemento superior de la pila

        public PilaPersonalizada() {
            this.tope = null;
        }

        // Método push: inserta un elemento en la cima
        public void push(String texto) {
            Nodo nuevoNodo = new Nodo(texto);
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
        }

        // Método pop: elimina y devuelve el elemento en la cima
        public String pop() {
            if (isEmpty()) {
                return null;
            }
            String texto = tope.texto;
            tope = tope.siguiente;
            return texto;
        }

        // Método peek: devuelve el elemento en la cima sin eliminarlo
        public String peek() {
            if (isEmpty()) {
                return null;
            }
            return tope.texto;
        }

        // Método isEmpty: verifica si la pila está vacía
        public boolean isEmpty() {
            return tope == null;
        }

        // Método extra para mostrar todo el contenido (útil para el editor)
        public void mostrarContenidoInverso() {
            if (isEmpty()) {
                System.out.println("[El documento está vacío]");
                return;
            }
            // Para imprimir en el orden correcto de texto, necesitamos invertirlo temporalmente
            PilaPersonalizada temp = new PilaPersonalizada();
            Nodo actual = tope;
            while (actual != null) {
                temp.push(actual.texto);
                actual = actual.siguiente;
            }

            while (!temp.isEmpty()) {
                System.out.println(temp.pop());
            }
        }

        // Método para vaciar la pila (necesario para el redo cuando se escribe nuevo texto)
        public void vaciar() {
            tope = null;
        }
    }