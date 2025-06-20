import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente>listaPacientes = new ArrayList<>();
        int pacientesCadastrados = 0;
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("---Bem vindo ao ClinicsMed---");
            System.out.println("--Escolha uma opção--");
            System.out.println("-1 Cadastrar um usuario");
            System.out.println("-2 Listar os usuarios");
            System.out.println("-3 Buscar por cpf");
            System.out.println("-4 sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:Main.cadastrarPaciente(scanner, listaPacientes);
                pacientesCadastrados++;
                    break;
                case 2:
                    System.out.println("A lista de pacientes é: " + listaPacientes);

                    break;
                case 3:Main.buscarPacientePorCpf(scanner,listaPacientes);
                    break;

                case 4:
                    System.out.println("Finaliando...");
                    break;
            }
        }
    }

    public static void listar(List<Paciente>listaPacientes){
        if (listaPacientes.isEmpty()){
            System.out.println("A lista está vazia,tente novamente mais tarde...");
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
    public static void buscarPacientePorCpf(Scanner scanner, List<Paciente> listaPacientes){
        System.out.println("Digite o cpf da pessoa que esta buscando: ");
        Long cpfBuscado = scanner.nextLong();
        boolean encontrou = false;
        for (Paciente p : listaPacientes){
            if(p.getCpf().equals(cpfBuscado)){
                System.out.println("O cpf é de : " + p + "\n" + ".");
                encontrou = true;
                break;
            }
            }
        if(!encontrou){
            System.out.println("Não possuimos esse cpf nos registros...");
        }
        }

    }






