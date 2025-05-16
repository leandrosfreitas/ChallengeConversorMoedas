# 💱 Conversor de Moedas - Java

Este projeto é um conversor de moedas desenvolvido em Java, que utiliza a API pública [ExchangeRate-API](https://www.exchangerate-api.com/) para buscar taxas de câmbio em tempo real.

## 🧩 Funcionalidades

- Conversão entre as seguintes moedas:
  - Dólar Americano (USD)
  - Euro (EUR)
  - Real Brasileiro (BRL)
  - Libra Esterlina (GBP)
- Consulta de taxas atualizadas diretamente da API
- Interface de terminal simples e interativa
- Formatação de valores com duas casas decimais
- Loop de execução contínuo até o usuário optar por sair

## 🏗️ Tecnologias Utilizadas

- Java 17+
- API HTTP Nativa do Java (`java.net.http`)
- Gson (para parsear JSON)
- ExchangeRate-API (para obter as taxas de câmbio)
