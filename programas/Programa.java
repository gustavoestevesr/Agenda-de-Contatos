package programas;

/*
  Faça um programa em Java para simular uma parte do funcionamento de
  uma agenda de contatos. Você deverá ter as opções de incluir uma pessoa
  e listar todas as pessoas cadastradas. Cada pessoa terá nome, sobrenome e
  telefone de contato. O número máximo de contatos que podem ser salvos é
  definido por você. Fique à vontade.
*/

import java.util.Scanner;

import classes.Pessoa;

public class Programa {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcao, qtdContatos = 0;
    Pessoa[] contatos = new Pessoa[10];

    do {
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Incluir pessoa");
      System.out.println("2 - Listar todos os cadastrados");
      System.out.print("Opção: ");

      opcao = sc.nextInt();
      sc.nextLine(); // Limpa o ENTER q fica na entrada

      switch (opcao) {
        case 0:
          System.out.println("Fim do programa!");
          break;
        case 1:
          if (contatos.length == qtdContatos) {
            System.out.println("Não há mais espaço na agenda.");
            continue;
          }

          Pessoa contato = new Pessoa();

          System.out.print("Nome: ");
          contato.setNome(sc.nextLine());

          System.out.print("Sobrenome: ");
          contato.setSobrenome(sc.nextLine());

          System.out.print("Telefone: ");
          contato.setTelefone(sc.nextLine());

          contatos[qtdContatos] = contato;
          qtdContatos = qtdContatos + 1;

          System.out.println("Contato cadastrado com sucesso!");
          break;
        case 2:
          if (qtdContatos == 0) {
            System.out.println("Não há pessoas cadastradas na agenda.");
            continue;
          }

          System.out.println("*******************");
          System.out.println("CONTATOS DA AGENDA:");
          System.out.println("*******************\n");

          for (int i = 0; i < qtdContatos; i++) {
            System.out.printf("%s - %s\n", contatos[i].getNomeCompleto(), contatos[i].getTelefone());
          }
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }
    } while (opcao != 0);

    sc.close();
  }
}