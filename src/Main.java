import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente>listaPacientes = new ArrayList<>();
        int pacientesCadastrados = 0;
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("---Bem vindo ao ClinicsMed---");
            System.out.println("--Escolha uma opção--");
            System.out.println("-1 Cadastrar um usuario");
            System.out.println("-2 Listar os usuarios");
            System.out.println("-3 Buscar por cpf");
            System.out.println("-4 Remover paciente pelo cpf");
            System.out.println("-5 atualizar paciente");
            System.out.println("-6 Sair ");
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
                case 5:Main.atualizar(scanner,listaPacientes);
                    break;
                case 6:
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

        public static  void atualizar(Scanner sc,List<Paciente>listaPacientes){
            System.out.println("Digite o cpf do paciente que deseja atualizar os dados:");
            Long cpfBuscando = sc.nextLong();
            boolean pacienteEncontrado = false;
            int opcao = 0;
            for (int i = 0; i < listaPacientes.size(); i++) {
                if(listaPacientes.get(i).getCpf().equals(cpfBuscando)){
                    pacienteEncontrado = true;

                    while(opcao != 5){
                        System.out.println("Quais dados deseja atualizar ?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - idade");
                        System.out.println("3 - cpf");
                        System.out.println("4 - todos os dados");
                        System.out.println("5 - sair desta pagina");
                        opcao = sc.nextInt();
                        sc.nextLine();

                        switch (opcao){

                            case 1:
                                System.out.println("Digite o novo nome do paciente:");
                                String novoNome = sc.nextLine();

                                    listaPacientes.get(i).getNome();
                                    if (novoNome.equals(listaPacientes.get(i).getNome())){
                                        System.out.println("O nome está igual ao que era antes!!");
                                    }else{
                                        listaPacientes.get(i).setNome(novoNome);

                                    }

                                break;
                            case 2:
                                System.out.println("Digite a idade que deseja atribuir:");
                                int novaIdade = sc.nextInt();
                                    listaPacientes.get(i).getIdade();
                                    if (novaIdade == listaPacientes.get(i).getIdade()){
                                        System.out.println("Está ja era a idade do paciente!!");
                                    }else{
                                        listaPacientes.get(i).setIdade(novaIdade);

                                    }


                                break;
                            case 3:
                                System.out.println("Digite o cpf do paciente atualizado:");
                                Long cpfNovo = sc.nextLong();

                                    listaPacientes.get(i).getCpf();
                                    if (cpfNovo.equals(listaPacientes.get(i).getCpf())){
                                        System.out.println("O CPF Continua o mesmo!");
                                    }else{
                                        listaPacientes.get(i).setCpf(cpfNovo);

                                    }


                                break;
                            case 4:
                                System.out.println("Digite o nome atualizado:");
                                sc.nextLine();
                                String nomeNovo = sc.nextLine();
                                System.out.println("Digite a idade atualizada:");
                                int idadeNova = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Digite o cpf atualizado:");
                                Long cpfAtt = sc.nextLong();
                                sc.nextLine();

                                    if (!nomeNovo.equals(listaPacientes.get(i).getNome())){
                                        listaPacientes.get(i).setNome(nomeNovo);
                                    }else{
                                        System.out.println("O nome está igual");
                                    }
                                    if (idadeNova != listaPacientes.get(i).getIdade()) {
                                        listaPacientes.get(i).setIdade(idadeNova);
                                    }else{
                                        System.out.println("a idade esta igual!");
                                    }
                                    if (!cpfAtt.equals(listaPacientes.get(i).getCpf())) {
                                        listaPacientes.get(i).setCpf(cpfAtt);
                                    }else{
                                        System.out.println("o cpf esta igual");
                                    }
                                break;
                            case 5:
                                System.out.println("Saindo deste menu...");
                                break;
                        }
                    }
                }
            }
            if(!pacienteEncontrado){
                System.out.println("O cpf informado não está em nossos registros");

            }
        }

    }






