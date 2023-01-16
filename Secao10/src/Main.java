import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> lista_funcionarios = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String aux_nome;
        Integer aux_ID, qtdFuncionarios;
        Double aux_salario;

        System.out.print("Quantos funcionários você irá cadastrar: ");
        qtdFuncionarios = Integer.valueOf(input.nextLine());

        for (int i = 0; i < qtdFuncionarios; i++) {
            System.out.print("Digite o ID do funcionário: ");
            aux_ID = Integer.valueOf(input.nextLine());
            System.out.print("Digite o nome do funcionário: ");
            aux_nome = input.nextLine();
            System.out.print("Digite o salario do funcionários: R$");
            aux_salario = Double.valueOf(input.nextLine());

            Funcionario newFuncionario = new Funcionario(aux_ID, aux_nome, aux_salario);
            lista_funcionarios.add(newFuncionario);
        }

        Boolean appRodando = true;

        while (appRodando) {
            System.out.println("1 - Aumentar salário do funcionário (%)");
            System.out.println("2 - Mostrar lista de funcionários");
            System.out.println("3 - Sair");

            switch (input.nextInt()) {
                case 1:
                    System.out.print("Digite o ID do salário que receberá o aumento: ");
                    Integer funcProcurado = input.nextInt();

                    System.out.print("Digite o aumento de salário (em %) que o funcionário irá receber");
                    Double aumentoRecebido = input.nextDouble();

                    Boolean opRealizada = false;

                    for (Funcionario func : lista_funcionarios) {
                        if (func.getId() == funcProcurado) {
                            func.aumentoSalario(aumentoRecebido);
                            opRealizada = true;
                        }
                    }

                    if (!opRealizada) System.out.println("FUNCIONÁRIO NÃO ENCONTRADO");
                    break;
                case 2:
                    System.out.println("--------------------------");
                    System.out.println("ID - FUNCIONÁRIO - SALÁRIO");
                    for (Funcionario func : lista_funcionarios) {
                        System.out.print(func.getId() + " - ");
                        System.out.print(func.getNome() + " - ");
                        System.out.print(func.getSalario() + "\n");
                    }
                    System.out.println("--------------------------");
                    break;
                case 3:
                    appRodando = false;
                    break;
            }
        }
    }
}
