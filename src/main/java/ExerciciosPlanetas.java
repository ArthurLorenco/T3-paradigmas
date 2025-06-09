import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;

public class ExerciciosPlanetas {

    // Exercício 1 – Filtra planetas com atmosfera
    public static List<Planeta> filtrarComAtmosfera(List<Planeta> planetas) {
        return planetas.stream()
                .filter(Planeta::isTemAtmosfera)
                .collect(Collectors.toList());
    }

    // Exercício 2 - Liste os nomes dos planetas com diâmetro maior que 10.000 km
    public static List<String> nomesDiametroMaiorQue10000(List<Planeta> planetas) {
        return planetas.stream()
                .filter(p -> p.getDiametro() > 10000)
                .map(Planeta::getNome)
                .collect(Collectors.toList());
    }

    // Exercício 3 - Encontre o planeta mais próximo do Sol
    public static Planeta planetaMaisProximoDoSol(List<Planeta> planetas) {
        return planetas.stream()
                .min(Comparator.comparingDouble(Planeta::getDistanciaSol))
                .orElse(null);
    }

    // Exercício 4 - Verifique se existe algum planeta com massa maior que 1000
    public static boolean existePlanetaComMassaMaiorQue1000(List<Planeta> planetas) {
        return planetas.stream()
                .anyMatch(p -> p.getMassa() > 1000);
    }

    // Exercício 5 - Calcule a massa total de todos os planetas da lista
    public static double calcularMassaTotal(List<Planeta> planetas) {
        return planetas.stream()
                .mapToDouble(Planeta::getMassa)
                .sum();
    }

    // Metodo main para imprimir o resultado
    public static void main(String[] args) {
        List<Planeta> planetas = Arrays.asList(
                new Planeta("Mercúrio", 0.33, 4879, 58, false),
                new Planeta("Vênus", 4.87, 12104, 108, true),
                new Planeta("Terra", 5.97, 12756, 150, true),
                new Planeta("Marte", 0.642, 6792, 228, true),
                new Planeta("Júpiter", 1898, 142984, 778, true),
                new Planeta("Saturno", 568, 120536, 1430, true),
                new Planeta("Urano", 86.8, 51118, 2870, true),
                new Planeta("Netuno", 102, 49528, 4490, true)
        );

        // Exercício 1
        List<Planeta> comAtmosfera = filtrarComAtmosfera(planetas);
        List<String> nomesComAtmosfera = comAtmosfera.stream()
                .map(Planeta::getNome)
                .collect(Collectors.toList());
        System.out.println("Planetas com atmosfera: " + nomesComAtmosfera);

        // Exercício 2
        List<String> nomesDiametro = nomesDiametroMaiorQue10000(planetas);
        System.out.println("Planetas com diâmetro > 10000 km: " + nomesDiametro);

        // Exercício 3
        Planeta maisProximo = planetaMaisProximoDoSol(planetas);
        System.out.println("Planeta mais próximo do Sol: " + maisProximo.getNome());

        // Exercício 4
        boolean existePesado = existePlanetaComMassaMaiorQue1000(planetas);
        System.out.println("Existe planeta com massa > 1000? " + existePesado);

        // Exercício 5
        double massaTotal = calcularMassaTotal(planetas);
        System.out.println("Massa total dos planetas: " + massaTotal);

    }
}
