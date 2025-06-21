import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinica {

    Scanner sc = new Scanner(System.in);
    int registed = 0;
    List<Paciente> listPacients = new ArrayList<>();
    boolean registeredPacient = false;
    int opcao = 0;

    public void createPacient() {
        registeredPacient = false;
        System.out.println("Digite os dados do paciente:");
        System.out.println("Nome:");
        String name = sc.nextLine();
        System.out.println("Idade:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("CPF:");
        long cpf = sc.nextLong();
        sc.nextLine();


        for (Paciente p : listPacients) {
            if (p.getCpf().longValue() == cpf) {
                registeredPacient = true;
                break;
            }
        }
        if (!registeredPacient) {
            listPacients.add(new Paciente(name, age, cpf));
            registed++;
            System.out.println("Paciente adicionado com sucesso ao sistema!!");

        } else {
            System.out.println("CPF já cadastrado");
        }

    }

    public void listPacient() {
        if (listPacients.isEmpty()) {
            System.out.println("Até o momento nenhum usuario foi cadastrado!");
        } else {
            System.out.println("Os usuarios são:");
            for (Paciente p : listPacients) {
                System.out.println(p);

            }
        }

    }

    public void searchByCpf() {
        System.out.println("Digite o CPF do usuario que está buscando:");
        long cpfProcurado = sc.nextLong();
        boolean encontrado = false;
        for (int i = 0; i < listPacients.size(); i++) {
            if (listPacients.get(i).getCpf().longValue() == cpfProcurado) {
                encontrado = true;
                System.out.println(listPacients.get(i).getNome());
                System.out.println(listPacients.get(i).getIdade());
                System.out.println(listPacients.get(i).getCpf());
            }

        }
        if (!encontrado) {
            System.out.println("O CPF não consta nos registros...");
        }

    }

    public void removePacient() {
        System.out.println("Digite o cpf do usuario que deseja remover:");
        long cpfProcurado = sc.nextLong();
        sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listPacients.size(); i++) {
            if (listPacients.get(i).getCpf().longValue() == cpfProcurado) {
                encontrado = true;
                listPacients.remove(i);
                break;
            }


        }
        if(!encontrado){
            System.out.println("o cpf buscado para remoção não consta em nossos registros");

        }
    }

    public void updatePacientData() {
        System.out.println("Digite o cpf do paciente que está querendo atualizar os dados:");
        Long cpfProcurado = sc.nextLong();
        sc.nextLine();
        for (int i = 0; i < listPacients.size(); i++) {
            if (cpfProcurado.equals(listPacients.get(i).getCpf())) {
                registeredPacient = true;
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
                            String attName = sc.nextLine();
                            if (attName.equals(listPacients.get(i).getNome())) {
                                System.out.println("O nome está igual ao nome já registrado!!");
                            } else {
                                listPacients.get(i).setNome(attName);
                            }
                            break;
                        case 2:
                            System.out.println("Digite a nova idade do paciente:");
                            int attAge = sc.nextInt();
                            if (attAge == listPacients.get(i).getIdade()) {
                                System.out.println("A idade está igual a idade já registrada!!");
                            } else {
                                listPacients.get(i).setIdade(attAge);
                            }
                            break;
                        case 3:
                            System.out.println("Digite o novo CPF do paciente:");
                            long attCpf = sc.nextLong();

                            if (attCpf == listPacients.get(i).getCpf()) {
                                System.out.println("O CPF está igual ao CPF já registrado");
                            } else {
                                listPacients.get(i).setCpf(attCpf);
                            }


                            break;
                        case 4:
                                System.out.println("Digite nome,idade e CPF que deseja atualizar ");
                                    System.out.println("Nome:");
                                    String atName = sc.nextLine();
                                    System.out.println("Idade:");
                                    int attIdade = sc.nextInt();
                                    System.out.println("CPF:");
                                    long attCPF = sc.nextLong();
                                    if (!atName.equals(listPacients.get(i).getNome())) {
                                        listPacients.get(i).setNome(atName);
                                    } else {
                                        System.out.println("Esse nome é o mesmo que ja está registrado");
                                    }
                                    if (attIdade != listPacients.get(i).getIdade()) {
                                        listPacients.get(i).setIdade(attIdade);
                                    } else {
                                        System.out.println("Essa idade é a mesma que ja está registrada");

                                    }
                                    if (attCPF != listPacients.get(i).getCpf()) {
                                        listPacients.get(i).setCpf(attCPF);
                                    } else {
                                        System.out.println("Esse CPF é o mesmo que ja está registrado");
                                    }
                                    System.out.println("Os dados atualizados são:" + listPacients.get(i));
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
            if(!registeredPacient){
                System.out.println("CPF Não consta nos registros");
            }
                    }
                }
            }






