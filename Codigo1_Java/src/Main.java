import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Método para ler um arquivo e retornar seu conteúdo como uma lista de strings
    public static List<String> lerArquivo(File arq) {
        List<String> retorno = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(arq, "UTF-8");
            while (scan.hasNextLine()) {
                retorno.add(scan.nextLine());
            }
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public static void main(String[] args) {
        // Inicializa o tempo de início da execução do programa
        float tempo_inicial = System.nanoTime();

        // Define o caminho do arquivo a ser lido
        String arquivo = "Arquivo/arq-novo.txt";

        // Cria uma instância da ListaEncadeada
        ListaEncadeada lista = new ListaEncadeada();

        // Lê o conteúdo do arquivo e armazena em uma lista de strings
        List<String> filedata = lerArquivo(new File(arquivo));

        // Obtém os números da primeira linha do arquivo e os adiciona à lista
        String[] numeros = filedata.get(0).split(" ");
        for (String num : numeros) {
            lista.adicionar((Integer.parseInt(num)), 999);
        }

        // Obtém os comandos das linhas restantes do arquivo e executa-os na lista
        List<String> comandos = filedata.subList(1, filedata.size());
        for (String comando : comandos) {
            String[] cmd = comando.split(" ");
            if (cmd[0].equals("A")) {
                if (cmd.length == 2) {
                    lista.adicionar(Integer.parseInt(cmd[1]), 0);
                } else if (cmd.length == 3) {
                    lista.adicionar(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                }
            } else if (cmd[0].equals("R")) {
                lista.remover(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("P")) {
                lista.imprimir();
            }
        }

        // Calcula o tempo total de execução do programa
        float tempo_final = System.nanoTime();
        float tempo = (tempo_final - tempo_inicial) / 1000000;

        // Imprime o tempo total de execução do programa
        System.out.println("Tempo de execução: " + (tempo_final - tempo_inicial) / 1000000 + "ms");

        // Cria um arquivo de saída para armazenar as medições de desempenho
        File arquivo_saida = new File("Desempenho//Medir Java.txt");
        try {
            // Verifica se o arquivo de saída já existe; se não, cria um novo
            if (!arquivo_saida.exists()) {
                arquivo_saida.createNewFile();
            }

            // Escreve no arquivo de saída o tempo de execução do programa
            java.io.FileWriter fw = new java.io.FileWriter(arquivo_saida, true);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            bw.write("Java: " + tempo + "ms\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
