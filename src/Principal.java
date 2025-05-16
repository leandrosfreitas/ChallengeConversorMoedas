import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\n" + "\uD83D\uDCB1 BEM VINDO AO CONVERSOR DE MOEDAS " + "\uD83D\uDCB1" + "\n");

        while (true) {
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
                System.out.print("Digite a opção: ");
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            if (opcao == 9) {
                System.out.println("Programa encerrado. Obrigado por usar o conversor!");
                break;
            }

            String moedaBase = "";
            String moedaDestino = "";

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

            ConsultaMoeda consulta = new ConsultaMoeda();
            Rates baseCambio = consulta.BuscaMoeda(moedaBase);

            Double taxa = baseCambio.conversion_rates().get(moedaDestino);
            if (taxa == null) {
                System.out.println("Não foi possível obter a taxa para a moeda destino.");
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valorConvertido;
            try {
                double valor = Double.parseDouble(leitura.nextLine());
                valorConvertido = taxa * valor;
                System.out.printf("Taxa de conversão: 1 %s = %.2f %s%n", moedaBase, taxa, moedaDestino);
                System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, moedaBase, valorConvertido, moedaDestino);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido para conversão.");
            }
        }

        leitura.close();
    }
}

