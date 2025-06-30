import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinica {

    Scanner sc = new Scanner(System.in);
    int registrado = 0;
    List<Paciente> listaPacientes = new ArrayList<>();
    boolean pacienteRegistrado = false;
    int opcao = 0;

    public void criarPaciente() {
        pacienteRegistrado = false;
        System.out.println("Digite os dados do paciente:");
        System.out.println("Nome:");
        String name = sc.nextLine();
        System.out.println("Idade:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("CPF:");
        long cpf = sc.nextLong();
        sc.nextLine();


        for (Paciente p : listaPacientes) {
            if (p.getCpf().longValue() == cpf) {
                pacienteRegistrado = true;
                break;
            }
        }
        if (!pacienteRegistrado) {
            listaPacientes.add(new Paciente(name, age, cpf));
            registrado++;
            System.out.println("Paciente adicionado com sucesso ao sistema!!");

        } else {
            System.out.println("CPF já cadastrado");
        }

    }

    public void listarPacientes() {
        if (listaPacientes.isEmpty()) {
            System.out.println("Até o momento nenhum usuario foi cadastrado!");
        } else {
            System.out.println("Os usuarios são:");
            for (Paciente p : listaPacientes) {
                System.out.println(p);

            }
        }

    }

    public void buscaPorCpf() {
        System.out.println("Digite o CPF do usuario que está buscando:");
        long cpfProcurado = sc.nextLong();
        boolean encontrado = false;
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i).getCpf().longValue() == cpfProcurado) {
                encontrado = true;
                System.out.println(listaPacientes.get(i).getNome());
                System.out.println(listaPacientes.get(i).getIdade());
                System.out.println(listaPacientes.get(i).getCpf());
            }

        }
        if (!encontrado) {
            System.out.println("O CPF não consta nos registros...");
        }

    }

    public void removerPaciente() {
        System.out.println("Digite o cpf do usuario que deseja remover:");
        long cpfProcurado = sc.nextLong();
        sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i).getCpf().longValue() == cpfProcurado) {
                encontrado = true;
                listaPacientes.remove(i);
                break;
            }


        }
        if(!encontrado){
            System.out.println("o cpf buscado para remoção não consta em nossos registros");

        }
    }

    public void atualizarDadosPacient() {
        System.out.println("Digite o cpf do paciente que está querendo atualizar os dados:");
        Long cpfProcurado = sc.nextLong();
        sc.nextLine();
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (cpfProcurado.equals(listaPacientes.get(i).getCpf())) {
                pacienteRegistrado = true;
                opcao = 0;

                while (opcao != 5) {
                    System.out.println("Quais dados deseja atualizar ?");
                    System.out.println("1 - Nome");
                    System.out.println("2 - idade");
                    System.out.println("3 - cpf");
                    System.out.println("4 - todos os dados");
                    System.out.println("5 - sair desta pagina");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao) {

                        case 1:

                            System.out.println("Digite o novo nome do paciente:");
                            String attNome = sc.nextLine();
                            if (attNome.equals(listaPacientes.get(i).getNome())) {
                                System.out.println("O nome está igual ao nome já registrado!!");
                            } else {
                                listaPacientes.get(i).setNome(attNome);
                            }
                            break;
                        case 2:
                            System.out.println("Digite a nova idade do paciente:");
                            int attIdade = sc.nextInt();
                            if (attIdade == listaPacientes.get(i).getIdade()) {
                                System.out.println("A idade está igual a idade já registrada!!");
                            } else {
                                listaPacientes.get(i).setIdade(attIdade);
                            }
                            break;
                        case 3:
                            System.out.println("Digite o novo CPF do paciente:");
                            long attCpf = sc.nextLong();

                            if (attCpf == listaPacientes.get(i).getCpf()) {
                                System.out.println("O CPF está igual ao CPF já registrado");
                            } else {
                                listaPacientes.get(i).setCpf(attCpf);
                            }


                            break;
                        case 4:
                                System.out.println("Digite nome,idade e CPF que deseja atualizar ");
                                    System.out.println("Nome:");
                                    String atName = sc.nextLine();
                                    System.out.println("Idade:");
                                    int atualizaIdade = sc.nextInt();
                                    System.out.println("CPF:");
                                    long attCPF = sc.nextLong();
                                    if (!atName.equals(listaPacientes.get(i).getNome())) {
                                        listaPacientes.get(i).setNome(atName);
                                    } else {
                                        System.out.println("Esse nome é o mesmo que ja está registrado");
                                    }
                                    if (atualizaIdade != listaPacientes.get(i).getIdade()) {
                                        listaPacientes.get(i).setIdade(atualizaIdade);
                                    } else {
                                        System.out.println("Essa idade é a mesma que ja está registrada");

                                    }
                                    if (attCPF != listaPacientes.get(i).getCpf()) {
                                        listaPacientes.get(i).setCpf(attCPF);
                                    } else {
                                        System.out.println("Esse CPF é o mesmo que ja está registrado");
                                    }
                                    System.out.println("Os dados atualizados são:" + listaPacientes.get(i));
                                    break;
                        case 5:
                            System.out.println("Finalizando...");
                            break;
                        default:
                            System.out.println("Escolha uma opção valida...");
                            break;


                                }

                                }


                            }
            if(!pacienteRegistrado){
                System.out.println("CPF Não consta nos registros");
            }
                    }
                }
            }






