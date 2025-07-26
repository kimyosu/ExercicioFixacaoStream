## Exercicio de fixação Stream
# objetivo

Este projeto foi desenvolvido como exercício prático do curso de Java do professor Nélio Alves na Udemy. O objetivo principal é criar um programa capaz de:

- Leia dados de funcionários a partir de um arquivo CSV contendo nome, email e salário;

- Apresente, em ordem alfabética, os emails dos funcionários cujo salário seja superior a um valor informado pelo usuário;

- Calcule e exiba a soma dos salários dos funcionários cujo nome começa com a letra "M".

## Estrutura do Projeto

```
src/
├── employeers.csv
├── Main.java
└── model/
    └── entities/
        └── Employee.java
```

## Como Executar o Projeto

1. **Clone ou baixe o projeto** para sua máquina.

2. **Certifique-se de que você tem o Java instalado.**  
   Recomendado: JDK 17 ou superior.

3. **Compile os arquivos Java.**  
   Navegue até a pasta `src` pelo terminal e execute:

   ```bash
   javac model/entities/Employee.java Main.java
   ```
4. **Execute o programa:**  
   Ainda dentro da pasta `src`, rode:

   ```bash
   java Main
   ```
