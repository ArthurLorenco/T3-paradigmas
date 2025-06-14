import java.util.List;
import java.util.Map;
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

    // Exercicio 6 - Calcule a média das distâncias dos planetas ao Sol.
    public static double media_distancia_do_sol(List<Planeta> planetas) {

        return planetas.stream()
                .mapToDouble(Planeta::getDistanciaSol)
                .average()
                .orElse(0.0);
    }

    // Exercicio 7 - Liste os planetas ordenados por massa em ordem decrescente.
    public static List<String> ordena_ordem_decrescente(List<Planeta> planetas) {

        return planetas.stream()
                .sorted(Comparator.comparing(Planeta::getMassa).reversed())
                .map(Planeta::getNome)
                .collect(Collectors.toList());

    }

    // Exercicio 8 - Agrupe os planetas de acordo com a presença ou ausência de atmosfera.
    public static Map<Boolean, List<Planeta>> Agrupamento_planetas(List<Planeta> planetas) {
        return planetas.stream()
                .collect(Collectors.groupingBy(Planeta::isTemAtmosfera));
    }

    // Exercicio 9 - Liste os nomes dos três planetas mais distantes do Sol.
    public static List<String> tres_planetas_mais_distantes(List<Planeta> planetas) {
        return planetas.stream()
                .sorted(Comparator.comparingDouble(Planeta::getDistanciaSol).reversed())
                .limit(3)
                .map(Planeta::getNome)
                .collect(Collectors.toList());
    }


    // Exercicio 10 - Crie uma única String com os nomes de todos os planetas, separados por vírgulas
    public static String nome_planetas(List<Planeta> planetas) {
        return planetas.stream()
                .map(Planeta::getNome)
                .collect(Collectors.joining(", "));
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

        // Exercicio 6
        System.out.println("Media da distancia: " + media_distancia_do_sol(planetas));

        // Exercicio 7
        System.out.println("Por massa decrescente: " + ordena_ordem_decrescente(planetas));

        // Exercicio 8
        Map<Boolean, List<Planeta>> mapa_atmosfera = Agrupamento_planetas(planetas);
        System.out.println("Agrupados por atmosfera:");

        System.out.println("False => " +  mapa_atmosfera.get(false)
                .stream().map(Planeta::getNome).collect(Collectors.toList()));;
        System.out.println("True => " +  mapa_atmosfera.get(true)
                .stream().map(Planeta::getNome).collect(Collectors.toList()));

        // Exercicio 9
        System.out.println("Top 3 distantes do sol: " + tres_planetas_mais_distantes(planetas));

        // Exercicio 10
        System.out.println("Todos os nomes: " + nome_planetas(planetas));


    }
}
