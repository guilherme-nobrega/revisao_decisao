import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args) {
        int horas;
        double valorHora;
        double salario;
        double salarioExtra;
        double salarioExtraDom = 0;
        char domFeriado;
        double salarioFinal;
        double inss;
        Scanner readernum = new Scanner(System.in);
        Scanner readerstr = new Scanner(System.in);
        System.out.println("PetShop FIAP - Cálculo da folha de pagamento\n");
        System.out.println("Digite a quantidade de horas trabalhadas: ");
        horas = readernum.nextInt();
        System.out.println("Digite o valor da horas: ");
        valorHora = readerstr.nextDouble();
        salario = horas * valorHora;
        System.out.println("Digite a quantidade de horas extras (exceto domingos e feriados): ");
        horas = readernum.nextInt();
        salarioExtra = ((valorHora * 0.5) + valorHora)*horas;
        System.out.println("Houve horas extras aos domingos ou feriado ? (Y/N): ");
        domFeriado = readernum.next().charAt(0);
        if (domFeriado == 'Y' || domFeriado == 'y'){
            System.out.println("Digite a quantidade de horas extras nos domingos e feriados: ");
            horas = readernum.nextInt();
            salarioExtraDom = (valorHora * 2) * horas;
        }
        salarioFinal = salarioExtra+salario+salarioExtraDom;

        if (salarioFinal <= 1302){
            inss = salarioFinal * 0.075;
        } else if (salarioFinal <= 2571.29) {
            inss = salarioFinal * 0.09;
        } else if (salarioFinal <= 3856.94) {
            inss = salarioFinal * 0.12;
        }else if (salarioFinal <= 7507.49) {
            inss = salarioFinal * 0.14;
        }else {
            inss = 877.24;
        }

        salarioFinal -= inss;

        System.out.println("\nValor do salário : "+salario);
        System.out.println("Valor do salário extra: "+salarioExtra);
        System.out.println("Valor do salário extra domingos e feriados: "+salarioExtraDom);
        System.out.println("Valor total a receber: "+salarioFinal);
        System.out.println("INSS retido : "+inss);

    }
}
