public class No {
    private int numero; // Armazena o número do nó

    // Método para obter o número armazenado no nó
    public int getDado() {
        return numero;
    }

    private No aponta; // Referência para o próximo nó na lista

    // Método para obter o próximo nó na lista
    public No getProximo() {
        return aponta;
    }

    // Método para definir o próximo nó na lista
    public void setProximo(No proximo) {
        this.aponta = proximo;
    }

    // Construtor da classe No, inicializa o número do nó e define o próximo nó como
    // nulo
    public No(int numero) {
        this.numero = numero;
        this.aponta = null;
    }
}
