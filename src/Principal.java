import java.util.Scanner;

/**
 * Classe principal responsável por interagir com o usuário
 */
public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Mensagem de boas-vindas
        System.out.println("\n" + "\uD83D\uDCB1 BEM VINDO AO CONVERSOR DE MOEDAS " + "\uD83D\uDCB1" + "\n");

        // Loop infinito para permitir múltiplas conversões
        while (true) {
            // Exibe o menu de opções
            System.out.println("\nEscolha uma opção:");
            System.out.println("1) Dólar Americano =>>> Euro");
            System.out.println("2) Euro =>>> Dólar Americano");
            System.out.println("3) Dólar Americano =>>> Real");
            System.out.println("4) Real =>>> Dólar Americano");
            System.out.println("5) Libra Esterlina =>>> Real");
            System.out.println("6) Real =>>> Libra Esterlina");
            System.out.println("7) Libra Esterlina =>>> Dólar Americano");
            System.out.println("8) Dólar Americano =>>> Libra Esterlina");
            System.out.println("9) Sair");

            int opcao = 0;
            try {
                // Lê a opção escolhida pelo usuário
                System.out.print("Digite a opção: ");
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                // Se o valor não for numérico
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            // Encerra o programa se o usuário digitar 9
            if (opcao == 9) {
                System.out.println("Programa encerrado. Obrigado por usar o conversor!");
                break;
            }

            // Variáveis para armazenar as moedas escolhidas
            String moedaBase = "";
            String moedaDestino = "";

            // Define as moedas de acordo com a opção escolhida
            switch (opcao) {
                case 1 -> { moedaBase = "USD"; moedaDestino = "EUR"; }
                case 2 -> { moedaBase = "EUR"; moedaDestino = "USD"; }
                case 3 -> { moedaBase = "USD"; moedaDestino = "BRL"; }
                case 4 -> { moedaBase = "BRL"; moedaDestino = "USD"; }
                case 5 -> { moedaBase = "GBP"; moedaDestino = "BRL"; }
                case 6 -> { moedaBase = "BRL"; moedaDestino = "GBP"; }
                case 7 -> { moedaBase = "GBP"; moedaDestino = "USD"; }
                case 8 -> { moedaBase = "USD"; moedaDestino = "GBP"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            // Cria o objeto de consulta e busca a taxa de conversão
            ConsultaMoeda consulta = new ConsultaMoeda();
            Rates baseCambio = consulta.BuscaMoeda(moedaBase);

            // Obtém a taxa de conversão para a moeda destino
            Double taxa = baseCambio.conversion_rates().get(moedaDestino);
            if (taxa == null) {
                System.out.println("Não foi possível obter a taxa para a moeda destino.");
                continue;
            }

            // Solicita o valor a ser convertido
            System.out.print("Digite o valor a ser convertido: ");
            try {
                double valor = Double.parseDouble(leitura.nextLine());
                // Calcula o valor convertido
                double valorConvertido = taxa * valor;
                // Exibe a taxa e o resultado
                System.out.printf("Taxa de conversão: 1 %s = %.2f %s%n", moedaBase, taxa, moedaDestino);
                System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, moedaBase, valorConvertido, moedaDestino);
            } catch (NumberFormatException e) {
                // Caso o valor informado não seja válido
                System.out.println("Valor inválido para conversão.");
            }
        }

        leitura.close();
    }
}
