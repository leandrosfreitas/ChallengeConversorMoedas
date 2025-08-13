# 💱 Conversor de Moedas

## 📌 Descrição do Projeto
O **Conversor de Moedas** é uma aplicação Java que utiliza a API [ExchangeRate API](https://www.exchangerate-api.com/) para realizar conversões entre diferentes moedas.  
O programa roda no terminal, permitindo que o usuário selecione pares de moedas pré-definidos, insira o valor desejado e obtenha o resultado com base na taxa de câmbio atual.

---

## ⚙️ Como instalar e executar

### 1️⃣ **Pré-requisitos**
- **Java 17+** instalado ([Download](https://www.oracle.com/java/technologies/javase-downloads.html))
- Biblioteca **Gson** (Google Gson) para manipulação de JSON  
  Baixe o `.jar` em: [https://github.com/google/gson](https://github.com/google/gson) ou adicione via Maven/Gradle

### 2️⃣ **Clonar o repositório**
```bash
git clone https://github.com/usuario/conversor-moedas.git
cd conversor-moedas
```

### 3️⃣ **Compilar**
```bash
javac -cp gson-2.10.1.jar *.java
```

### 4️⃣ **Executar**
```bash
java -cp .:gson-2.10.1.jar Principal
```
> **Observação**: No Windows, troque `:` por `;` no classpath.

---

## 💻 Exemplo de uso
```plaintext
💱 BEM VINDO AO CONVERSOR DE MOEDAS 💱

Escolha uma opção:
1) Dólar Americano =>>> Euro
2) Euro =>>> Dólar Americano
3) Dólar Americano =>>> Real
4) Real =>>> Dólar Americano
5) Libra Esterlina =>>> Real
6) Real =>>> Libra Esterlina
7) Libra Esterlina =>>> Dólar Americano
8) Dólar Americano =>>> Libra Esterlina
9) Sair
Digite a opção: 3
Digite o valor a ser convertido: 100
Taxa de conversão: 1 USD = 4.95 BRL
Resultado: 100.00 USD = 495.00 BRL
```

---

## 🚀 Contribuições futuras
- ✅ Permitir que o usuário escolha **quaisquer moedas** disponíveis na API, sem opções pré-fixadas.  
- ✅ Criar uma **interface gráfica** para tornar a interação mais amigável.  
- ✅ Adicionar histórico de conversões em arquivo local.  
- ✅ Implementar **tratamento de erros** mais detalhado para problemas de rede e API.  
- ✅ Suporte a **múltiplos idiomas** na interface.
