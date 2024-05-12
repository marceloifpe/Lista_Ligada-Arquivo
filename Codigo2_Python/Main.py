import time
from ListaEncadeada import ListaEncadeada


class Main:
    @staticmethod
    def ler_entrada(nome):
        # Método para ler os dados do arquivo
        arq = open(nome, 'r')
        dat = arq.readlines()
        arq.close()
        return dat

    @staticmethod
    def processar(caminho):
        # Método para processar os comandos do arquivo
        dados_arquivo = Main.ler_entrada(caminho)
        # Primeira linha contém os números iniciais
        numeros = dados_arquivo[0].split()
        # Segunda linha contém o número total de comandos
        total_entradas = int(dados_arquivo[1])
        comandos = []
        for i in range(2, total_entradas+2):
            # Restante das linhas contém os comandos
            comandos.append(dados_arquivo[i].split())
        lista = ListaEncadeada()  # Cria uma instância da lista encadeada
        for dat in numeros:
            # Adiciona os números iniciais na lista
            lista.adicionar(int(dat), 999)
        for cmd in comandos:
            # Itera sobre os comandos e executa as ações correspondentes
            if cmd[0] == 'A':
                if len(cmd) == 2:
                    # Adiciona o número na posição indicada
                    lista.adicionar(int(cmd[1]), 0)
                else:
                    # Adiciona o número na posição indicada
                    lista.adicionar(int(cmd[1]), int(cmd[2]))
            elif cmd[0] == 'R':
                lista.remover(int(cmd[1]))  # Remove o número indicado
            elif cmd[0] == 'P':
                lista.imprimir()  # Imprime a lista


if __name__ == "__main__":
    # Função principal que executa o processamento do arquivo
    inicial = time.time()
    Main.processar("Arquivo/arq-novo.txt")
    tempo_total = time.time() - inicial
    print("Tempo total: ", tempo_total)
    # Salva as medições de desempenho em um arquivo
    arq = open("Desempenho/Medir Py.txt", 'a')
    arq.write("Tempo total: "+str(tempo_total * 1000)+" ms\n")
    arq.close()
