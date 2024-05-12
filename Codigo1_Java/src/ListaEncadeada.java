import java.util.ArrayList;
import java.util.List;

public class ListaEncadeada {
    private No cabeca;

    // Método para adicionar um número em uma posição específica na lista
    public void adicionar(int numero, int posicao) {
        No novo = new No(numero); // Cria um novo nó com o número fornecido
        if (this.cabeca == null) { // Verifica se a lista está vazia
            this.cabeca = novo; // Se estiver vazia, o novo nó é o primeiro da lista
        } else {
            No atual = this.cabeca;
            // Percorre a lista até a posição desejada (posicao - 1)
            for (int i = 0; i < posicao - 1; i++) {
                // Verifica se o próximo nó é nulo para evitar um erro ao tentar acessá-lo
                if (atual.getProximo() == null) {
                    break;
                }
                atual = atual.getProximo(); // Move para o próximo nó
            }
            novo.setProximo(atual.getProximo()); // Define o próximo do novo nó como o próximo do nó atual
            atual.setProximo(novo); // Define o próximo do nó atual como o novo nó
        }
    }

    // Método para remover um número da lista
    public void remover(int numero) {
        if (this.cabeca == null) { // Verifica se a lista está vazia
            return; // Se estiver vazia, não há nada a fazer
        }
        if (this.cabeca.getDado() == numero) { // Verifica se o número está na cabeça da lista
            this.cabeca = this.cabeca.getProximo(); // Se estiver na cabeça, remove a cabeça
            return;
        }
        if (this.cabeca.getProximo() == null) { // Verifica se a lista possui apenas um elemento
            this.cabeca = null; // Se tiver apenas um elemento e não for o número, a lista fica vazia
            return;
        }
        No atual = this.cabeca;
        // Percorre a lista até encontrar o número ou o final da lista
        while (atual.getProximo() != null) {
            if (atual.getProximo().getDado() == numero) { // Verifica se o próximo nó possui o número
                atual.setProximo(atual.getProximo().getProximo()); // Remove o próximo nó
                return;
            }
            atual = atual.getProximo(); // Move para o próximo nó
        }
    }

    // Método para imprimir os elementos da lista
    public void imprimir() {
        List<Integer> lista = new ArrayList<>(); // Cria uma lista auxiliar para armazenar os elementos da lista
                                                 // encadeada
        No atual = this.cabeca;
        // Percorre a lista e adiciona os elementos à lista auxiliar
        while (atual != null) {
            lista.add(atual.getDado());
            atual = atual.getProximo();
        }
        System.out.println(lista); // Imprime a lista auxiliar
    }
}
