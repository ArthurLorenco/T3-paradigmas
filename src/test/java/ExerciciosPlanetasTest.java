import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciciosPlanetasTest {

    @Test
    public void testFiltrarComAtmosfera() {
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

        List<Planeta> comAtmosfera = ExerciciosPlanetas.filtrarComAtmosfera(planetas);

        List<String> nomesResultado = comAtmosfera.stream()
                .map(Planeta::getNome)
                .collect(Collectors.toList());

        List<String> nomesEsperados = Arrays.asList("Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno");

        assertEquals(nomesEsperados, nomesResultado);
    }
    @Test
    public void testNomesDiametroMaiorQue10000() {
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

        List<String> resultado = ExerciciosPlanetas.nomesDiametroMaiorQue10000(planetas);
        List<String> esperado = Arrays.asList("Vênus", "Terra", "Júpiter", "Saturno", "Urano", "Netuno");

        assertEquals(esperado, resultado);
    }
}
