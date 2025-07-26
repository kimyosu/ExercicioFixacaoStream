import model.entities.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        mostrar em ordem alfabetica o email dos funcionarios cujo salario seja superior a um dado(input do user)

        mostrar também a soma dos salarios dos funcionarios cujo nome começa com a letra "M"
         */

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("src/employeers.csv"); //Caminho do arquivo

        try (BufferedReader br = Files.newBufferedReader(path)) {
            List<Employee> employeeList = br.lines().filter(lines -> !lines.trim().isEmpty())
                    //isEmpty retorna true caso esteja vazia
                    .map(lines -> lines.split(","))
                    .map(x -> new Employee(x[0], x[1], Double.parseDouble(x[2])))
                    .toList();
           /*
            .filter -> filtra as linhas, pegando apenas as que não estão vazias
            .map -> corta a string por "," pegando o nome (index 0), email (index 1) e salário (index 2)
            .map -> transforma o array de strings em um objeto Employee com nome, email e salário
            .toList -> converte o stream final em uma lista de Employee
            comentarios gerado por A.I KKJJK sou burro demais :P
            */

            System.out.println("Insira o salario: ");
            double input = scanner.nextDouble();

            System.out.println("Email das pessoas que tem o salario acima de " + input);
            employeeList.stream()
                    .filter(x -> x.getSalary() > input)
                    .map(Employee::getEmail)
                    .sorted(String::compareToIgnoreCase)
                    .forEach(System.out::println);
            /*
            .filter -> filtrando apenas aqueles que tiverem o salario acima de valor digitado pelo usuario
            .map -> transforme os elementos pegando apenas o email
            .sorted -> ordenando a lista por ordem crescente
            .forEach -> imprime todos os elementos
             */

            Double sum = employeeList.stream()
                    .filter(x -> x.getName().toUpperCase().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0d, Double::sum);

            /*
            .map -> transformando os elementos pegando apenas o salario
            .filter -> filtramos apenas os nomes que começam com M
            .reduce -> soma todos os salarios 2
             */

            System.out.printf("Soma de salario das pessoas que o nome começa com \"M\": %.2f", sum);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}