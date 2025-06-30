import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        Clinica clinica = new Clinica();

        while (opcao != 6) {
            System.out.println("---Bem vindo ao ClinicsMed---");
            System.out.println("--Escolha uma opção--");
            System.out.println("1 Cadastrar um usuario");
            System.out.println("2 Listar os usuarios");
            System.out.println("3 Buscar por cpf");
            System.out.println("4 Remover paciente pelo cpf");
            System.out.println("5 atualizar paciente");
            System.out.println("6 Sair ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:clinica.criarPaciente();
                    break;

                case 2:clinica.listarPacientes();
                    break;

                case 3:clinica.buscaPorCpf();
                    break;

                case 4:clinica.removerPaciente();
                    break;
                case 5:clinica.atualizarDadosPacient();
                    break;
                case 6:
                    System.out.println("Finaliando...");
                    break;
                default:
                    System.out.println("Escolha uma opção valida!!");
                    break;
            }

            }
        }

    }






