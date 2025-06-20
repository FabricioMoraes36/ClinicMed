public class Paciente {

    private String nome;
    private int idade;
    private Long cpf;

    public Paciente() {
    }

    public Paciente(String nome, int idade, Long cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Paciente: " + "nome : " + nome + ", idade: " + idade + ", cpf: " + cpf;
    }


    }


