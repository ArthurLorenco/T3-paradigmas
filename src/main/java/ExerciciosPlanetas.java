import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ExerciciosPlanetas {

    // Exercício 1 – Filtra planetas com atmosfera
    public static List<Planeta> filtrarComAtmosfera(List<Planeta> planetas) {
        return planetas.stream()
                .filter(Planeta::isTemAtmosfera)
                .collect(Collectors.toList());
    }

    // Método main para imprimir o resultado
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

        List<Planeta> comAtmosfera = filtrarComAtmosfera(planetas);

        List<String> nomes = comAtmosfera.stream()
                .map(Planeta::getNome)
                .collect(Collectors.toList());

        System.out.println(nomes);
    }
}
