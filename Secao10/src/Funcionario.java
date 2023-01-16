public class Funcionario {
    private Double salario;
    private String nome;
    private Integer id;

    public Funcionario(Integer id, String nome, Double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentoSalario (Double porcentagem) {
        this.salario = this.salario * (1.0 + porcentagem/100.0);
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Double getSalario() {
        return this.salario;
    }
}
