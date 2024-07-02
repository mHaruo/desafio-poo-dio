import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição Curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição Curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição Mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev = new Dev();
        System.out.print("Digite o nome do Dev: ");
        dev.setNome(scanner.nextLine());
        dev.inscreverBootcamp(bootcamp);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu de Progressão ===");
            System.out.println("1. Progredir");
            System.out.println("2. Exibir Conteúdos Inscritos");
            System.out.println("3. Exibir Conteúdos Concluídos");
            System.out.println("4. Exibir XP Total");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    if (dev.getConteudosInscritos().isEmpty()) {
                        System.out.println("Você não tem mais conteúdos inscritos.");
                    } else {
                        dev.progredir();
                        System.out.println("Progresso realizado.");
                    }
                    break;
                case 2:
                    System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
                    break;
                case 3:
                    System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
                    break;
                case 4:
                    System.out.println("XP Total: " + dev.calcularTotalXp());
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
