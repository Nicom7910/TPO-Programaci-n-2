package org.example.Ejercicio1.normal;


import org.example.Ejercicio1.definition.IQueue;
import org.example.Ejercicio1.definition.IStack;

public class QueueOfStacks {

    private final IQueue queue; // Cola para almacenar identificadores de pilas
    private final IStack[] stacks; // Arreglo para asociar identificadores con pilas
    private int idCounter; // Contador para generar identificadores únicos

    // Constructor
    public QueueOfStacks() {
        this.queue = new Queue();
        this.stacks = new Stack[10000]; // Límite máximo de pilas
        this.idCounter = 0; // Inicializamos el contador en 0
    }

    /**
     * Agrega una pila a la cola de pilas.
     *
     * @param stack La pila que se desea agregar.
     */
    public void addStack(IStack stack) {
        this.idCounter++; // Generamos un nuevo identificador único
        this.queue.add(this.idCounter); // Añadimos el identificador a la cola
        this.stacks[this.idCounter] = stack; // Asociamos el identificador con la pila
    }

    /**
     * Verifica si la estructura está vacía.
     *
     * @return true si está vacía, false en otro caso.
     */
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    /**
     * Obtiene la cantidad de pilas dentro de la cola.
     *
     * @return Número de pilas en la cola.
     */
    public int getNumberOfStacks() {
        IQueue auxQueue = copyQueue(this.queue);
        int count = 0;
        while (!auxQueue.isEmpty()) {
            auxQueue.remove();
            count++;
        }
        return count;
    }

    /**
     * Obtiene la pila asociada al primer elemento en la cola.
     *
     * @return La primera pila en la cola.
     */
    public IStack getFirstStack() {
        if (this.queue.isEmpty()) {
            return null; // Si la cola está vacía, retornamos null
        }
        int firstId = this.queue.getFirst(); // Obtenemos el primer identificador
        return this.stacks[firstId]; // Devolvemos la pila asociada
    }

    /**
     * Elimina la primera pila de la cola.
     */
    public void removeFirstStack() {
        if (!this.queue.isEmpty()) {
            int firstId = this.queue.getFirst(); // Obtenemos el identificador del primer elemento
            this.queue.remove(); // Quitamos el identificador de la cola
            this.stacks[firstId] = null; // Eliminamos la pila asociada
        }
    }

    /**
     * Calcula la traza de la matriz representada por QueueOfStacks.
     *
     * @return La suma de los elementos de la diagonal principal.
     */
    public int calculateTrace() {
        int trace = 0;
        IQueue auxQueue = copyQueue(this.queue); // Copiamos la cola original
        int index = 0;

        while (!auxQueue.isEmpty()) {
            int stackId = auxQueue.getFirst(); // Obtenemos el identificador de la pila
            IStack stack = this.stacks[stackId]; // Obtenemos la pila asociada
            if (index < countElements(stack)) { // Aseguramos que el índice esté dentro de rango
                trace += getElementAt(stack, index);
            }
            auxQueue.remove();
            index++;
        }

        return trace;
    }

    /**
     * Genera la matriz traspuesta de la actual QueueOfStacks.
     *
     * @return Una nueva instancia de QueueOfStacks que representa la traspuesta.
     */
    public QueueOfStacks transpose() {
        QueueOfStacks transposed = new QueueOfStacks(); // Nueva estructura para la traspuesta
        IQueue auxQueue = copyQueue(this.queue); // Copiamos la cola original

        // Determinamos el número máximo de elementos en cualquier pila
        int maxElements = 0;
        while (!auxQueue.isEmpty()) {
            int stackId = auxQueue.getFirst();
            IStack stack = this.stacks[stackId];
            maxElements = Math.max(maxElements, countElements(stack));
            auxQueue.remove();
        }

        // Creamos las pilas traspuestas
        for (int i = 0; i < maxElements; i++) {
            IStack newStack = new Stack();
            auxQueue = copyQueue(this.queue); // Volvemos a copiar la cola original

            while (!auxQueue.isEmpty()) {
                int stackId = auxQueue.getFirst();
                IStack stack = this.stacks[stackId];
                if (i < countElements(stack)) {
                    newStack.add(getElementAt(stack, i));
                }
                auxQueue.remove();
            }
            transposed.addStack(newStack); // Agregamos la nueva pila traspuesta
        }

        return transposed;
    }

    // Métodos auxiliares privados
    private int countElements(IStack stack) {
        IStack auxStack = copyStack(stack);
        int count = 0;
        while (!auxStack.isEmpty()) {
            auxStack.remove();
            count++;
        }
        return count;
    }

    private int getElementAt(IStack stack, int index) {
        IStack auxStack = copyStack(stack);
        for (int i = 0; i < index; i++) {
            if (auxStack.isEmpty()) {
                return -1; // Índice fuera de rango
            }
            auxStack.remove();
        }
        return auxStack.getTop();
    }

    private IStack copyStack(IStack stack) {
        IStack copy = new Stack();
        IStack aux = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            int value = aux.getTop();
            aux.remove();
            stack.add(value);
            copy.add(value);
        }
        return copy;
    }

    private IQueue copyQueue(IQueue original) {
        IQueue copy = new Queue();
        IQueue aux = new Queue();
        while (!original.isEmpty()) {
            int value = original.getFirst();
            aux.add(value);
            copy.add(value);
            original.remove();
        }
        while (!aux.isEmpty()) {
            original.add(aux.getFirst());
            aux.remove();
        }
        return copy;
    }

    /**
     * Suma dos matrices representadas por instancias de QueueOfStacks.
     *
     * @param other Otra instancia de QueueOfStacks que se desea sumar.
     * @return Una nueva instancia de QueueOfStacks que representa la suma de ambas matrices.
     */
    public QueueOfStacks sumMatrices(QueueOfStacks other) {
        QueueOfStacks result = new QueueOfStacks(); // Nueva estructura para la matriz resultante
        IQueue auxQueue1 = copyQueue(this.queue); // Copia de la cola actual
        IQueue auxQueue2 = copyQueue(other.queue); // Copia de la cola de la otra matriz

        while (!auxQueue1.isEmpty() && !auxQueue2.isEmpty()) {
            int stackId1 = auxQueue1.getFirst(); // Identificador de la primera pila
            int stackId2 = auxQueue2.getFirst(); // Identificador de la segunda pila
            IStack stack1 = this.stacks[stackId1]; // Primera pila
            IStack stack2 = other.stacks[stackId2]; // Segunda pila

            // Creamos una nueva pila para almacenar la suma de las dos pilas
            IStack sumStack = sumStacks(stack1, stack2);

            // Agregamos la pila resultante a la matriz
            result.addStack(sumStack);

            // Eliminamos las pilas procesadas de las colas auxiliares
            auxQueue1.remove();
            auxQueue2.remove();
        }

        return result;
    }

    /**
     * Suma dos pilas elemento por elemento.
     *
     * @param stack1 La primera pila.
     * @param stack2 La segunda pila.
     * @return Una nueva pila con la suma de los elementos correspondientes.
     */
    private IStack sumStacks(IStack stack1, IStack stack2) {
        IStack result = new Stack();
        IStack aux1 = copyStack(stack1);
        IStack aux2 = copyStack(stack2);

        while (!aux1.isEmpty() || !aux2.isEmpty()) {
            int value1 = !aux1.isEmpty() ? aux1.getTop() : 0; // Si la pila está vacía, asumimos 0
            int value2 = !aux2.isEmpty() ? aux2.getTop() : 0; // Si la pila está vacía, asumimos 0

            result.add(value1 + value2); // Sumamos los valores
            if (!aux1.isEmpty()) aux1.remove();
            if (!aux2.isEmpty()) aux2.remove();
        }

        return reverseStack(result); // Invertimos la pila para mantener el orden correcto
    }

    /**
     * Invierte una pila.
     *
     * @param stack La pila que se desea invertir.
     * @return Una nueva pila con los elementos en orden inverso.
     */
    private IStack reverseStack(IStack stack) {
        IStack reversed = new Stack();
        IStack aux = copyStack(stack);

        while (!aux.isEmpty()) {
            reversed.add(aux.getTop());
            aux.remove();
        }

        return reversed;
    }

}
