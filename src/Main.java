import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente>listaPacientes = new ArrayList<>();
        int pacientesCadastrados = 0;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("---Bem vindo ao ClinicsMed---");
            System.out.println("--Escolha uma opção--");
            System.out.println("-1 Cadastrar um usuario");
            System.out.println("-2 Listar os usuarios");
            System.out.println("-3 Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:Main.cadastrarPaciente(scanner, listaPacientes);
                pacientesCadastrados++;
                    break;
                case 2:
                    System.out.println("A lista de pacientes é: " + listaPacientes);

                    break;
                case 3:
                    System.out.println("Finaliando...");
            }
        }
    }
    public static void listar(List<Paciente>listaPacientes){
        if (listaPacientes.isEmpty()){
            System.out.println("A lista está vazia,tente novamente mais tarde");
        }else{
            for (Paciente pacientes : listaPacientes){
                System.out.println(pacientes);
            }
        }

    }
    public static void cadastrarPaciente(Scanner scanner,List<Paciente>listaPacientes){
        System.out.println("Digite o nome do paciente,idade e cpf: ");
        String nomePaciente = scanner.nextLine();
        int idadPaciente = scanner.nextInt();
        Long cpfPaciente = scanner.nextLong();
        listaPacientes.add(new Paciente(nomePaciente,idadPaciente,cpfPaciente));

    }
    }




