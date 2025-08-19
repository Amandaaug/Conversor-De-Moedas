# Conversor de Moedas

## Descrição do Projeto
Este é um conversor de moedas interativo desenvolvido em Java. A aplicação permite a conversão de valores em tempo real, obtendo as taxas de câmbio de uma API externa. A interação com o usuário é feita através de um menu de opções na linha de comando.

## Funcionalidades
* **Conversão de Moedas:** Converte valores entre Dólar Americano (USD), Real Brasileiro (BRL), Peso Argentino (ARS) e Peso Colombiano (COP).
* **Taxas de Câmbio em Tempo Real:** Conecta-se à [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio mais atualizadas.
* **Interface Simples:** Utiliza uma interface de linha de comando (CLI) fácil de usar, com um menu numérico para a escolha da moeda.

## Tecnologias Utilizadas
* **Linguagem:** Java
* **Biblioteca:** [Gson](https://github.com/google/gson) (para desserialização de dados JSON)
* **API:** [ExchangeRate-API](https://www.exchangerate-api.com/)

## Como Usar

### Pré-requisitos

 Certifique-se de que você tem o ambiente de desenvolvimento Java configurado, incluindo o JDK.

1.  **Obtenha uma Chave de API:** Crie uma conta gratuita na [ExchangeRate-API](https://www.exchangerate-api.com/) para obter sua chave de acesso.
2.  **Adicione a Biblioteca Gson:** Baixe o arquivo `.jar` do [Gson](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar) e salve-o em uma pasta chamada `library` na raiz do projeto.

### Compilação e Execução
1.  Abra o terminal na pasta raiz do projeto (`ConversorDeMoedas`).
2.  Substitua `SUA_CHAVE_AQUI` no arquivo `Main.java` pela sua chave real da API.
3.  Compile os arquivos Java com o seguinte comando:
    ```bash
    javac -cp ".;library/gson-2.10.1.jar" src/main/java/com/alura/conversor/*.java
    ```
4.  Execute o programa:
    ```bash
    java -cp ".;library/gson-2.10.1.jar;src/main/java" com.alura.conversor.Main
    ```
5.  Siga as instruções do menu para realizar as conversões.

---

## Autor
**[Amanda A. da Silva ]**
