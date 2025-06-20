import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente>listaPacientes = new ArrayList<>();
        int pacientesCadastrados = 0;
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("---Bem vindo ao ClinicsMed---");
            System.out.println("--Escolha uma opção--");
            System.out.println("-1 Cadastrar um usuario");
            System.out.println("-2 Listar os usuarios");
            System.out.println("-3 Buscar por cpf");
            System.out.println("-4 Remover paciente pelo cpf");
            System.out.println("-5 sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:Main.cadastrarPaciente(scanner, listaPacientes);
                pacientesCadastrados++;
                    break;

                case 2:Main.listar(listaPacientes);
                    break;

                case 3:Main.buscarPacientePorCpf(scanner,listaPacientes);
                    break;

                case 4:Main.remover(scanner,listaPacientes);
                    break;
                case 5:
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
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = scanner.nextLine();
        System.out.println("A idade do paciente: ");
        int idadPaciente = scanner.nextInt();
        System.out.println("O cpf do paciente: ");
        boolean cpfBuscando = false;
        Long cpfPaciente = scanner.nextLong();

        for (Paciente p : listaPacientes){
            if (p.getCpf().equals(cpfPaciente)){
                cpfBuscando = true;
                break;
            }

        }
        if(!cpfBuscando){
            listaPacientes.add(new Paciente(nomePaciente,idadPaciente,cpfPaciente));
            System.out.println("Paciente cadastrado com sucesso!");
        }else{
            System.out.println("Esse cpf ja esta cadastrado \n");        }
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
        public static void remover(Scanner sc,List<Paciente>listaPacientes){
            System.out.println("Digite o cpf: ");
            Long cpfBuscado = sc.nextLong();
            boolean encontrou = false;
            for (int i = 0; i < listaPacientes.size() ; i++) {
                if (listaPacientes.get(i).getCpf().equals(cpfBuscado)){
                    listaPacientes.remove(i);
                    encontrou = true;
                    System.out.println("Paciente removido com sucesso!!");
                    break;
                }
            }
            if(!encontrou){
                System.out.println("Este cpf não está em nossos registros");
            }

        }

    }






