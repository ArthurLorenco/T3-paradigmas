import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciciosPlanetasTest {

    // Método auxiliar: retorna a lista padrão de planetas
    private List<Planeta> criarListaPlanetas() {
        return Arrays.asList(
                new Planeta("Mercúrio", 0.33, 4879, 58, false),
                new Planeta("Vênus", 4.87, 12104, 108, true),
                new Planeta("Terra", 5.97, 12756, 150, true),
                new Planeta("Marte", 0.642, 6792, 228, true),
                new Planeta("Júpiter", 1898, 142984, 778, true),
                new Planeta("Saturno", 568, 120536, 1430, true),
                new Planeta("Urano", 86.8, 51118, 2870, true),
                new Planeta("Netuno", 102, 49528, 4490, true)
        );
    }

    @Test
    public void testFiltrarComAtmosfera() {
        List<Planeta> planetas = criarListaPlanetas();

        List<Planeta> comAtmosfera = ExerciciosPlanetas.filtrarComAtmosfera(planetas);
        List<String> nomesResultado = comAtmosfera.stream()
                .map(Planeta::getNome)
                .collect(Collectors.toList());

        List<String> nomesEsperados = Arrays.asList("Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno");

        assertEquals(nomesEsperados, nomesResultado);
    }

    @Test
    public void testNomesDiametroMaiorQue10000() {
        List<Planeta> planetas = criarListaPlanetas();

        List<String> resultado = ExerciciosPlanetas.nomesDiametroMaiorQue10000(planetas);
        List<String> esperado = Arrays.asList("Vênus", "Terra", "Júpiter", "Saturno", "Urano", "Netuno");

        assertEquals(esperado, resultado);
    }

    @Test
    public void testPlanetaMaisProximoDoSol() {
        List<Planeta> planetas = criarListaPlanetas();

        Planeta maisProximo = ExerciciosPlanetas.planetaMaisProximoDoSol(planetas);
        assertNotNull(maisProximo);
        assertEquals("Mercúrio", maisProximo.getNome());
    }

    @Test
    public void testExistePlanetaComMassaMaiorQue1000() {
        List<Planeta> planetas = criarListaPlanetas();

        boolean resultado = ExerciciosPlanetas.existePlanetaComMassaMaiorQue1000(planetas);
        assertTrue(resultado);
    }

    @Test
    public void testCalcularMassaTotal() {
        List<Planeta> planetas = criarListaPlanetas();

        double resultado = ExerciciosPlanetas.calcularMassaTotal(planetas);

        assertEquals(2666.612, resultado, 0.001);
    }

    @Test
    public void test_media_distancia_do_sol() {
        List<Planeta> planetas = criarListaPlanetas();

        double resultado = ExerciciosPlanetas.media_distancia_do_sol(planetas);

        assertEquals(1264, resultado, 0.001);
    }

    @Test
    public void test_ordena_ordem_decrescente() {
        List<Planeta> planetas = criarListaPlanetas();

        List<String> resultado = ExerciciosPlanetas.ordena_ordem_decrescente(planetas);
        List<String> esperado = Arrays.asList("Júpiter", "Saturno", "Netuno", "Urano", "Terra", "Vênus",
                "Marte", "Mercúrio");

        assertEquals(esperado, resultado);
    }

    @Test
    public void test_Agrupamento_planetas(){
        List<Planeta> planetas = criarListaPlanetas();

        Map<Boolean, List<Planeta>> agrupados = ExerciciosPlanetas.Agrupamento_planetas(planetas);

        List<String> comAtmosfera = agrupados.get(true).stream()
                .map(Planeta::getNome)
                .collect(Collectors.toList());

        assertTrue(comAtmosfera.contains("Vênus"));
        assertTrue(comAtmosfera.contains("Júpiter"));
        assertTrue(comAtmosfera.contains("Saturno"));
        assertTrue(comAtmosfera.contains("Urano"));
        assertTrue(comAtmosfera.contains("Netuno"));
        assertTrue(comAtmosfera.contains("Terra"));
        assertTrue(comAtmosfera.contains("Marte"));

        List<String> semAtmosfera = agrupados.get(false).stream()
                .map(Planeta::getNome)
                .collect(Collectors.toList());
        assertTrue(semAtmosfera.contains("Mercúrio"));

    }

    @Test
    public void test_tres_planetas_mais_distantes(){
        List<Planeta> planetas = criarListaPlanetas();

        List<String> resultado = ExerciciosPlanetas.tres_planetas_mais_distantes(planetas);
        List<String> esperado = Arrays.asList("Netuno", "Urano", "Saturno");

        assertEquals(esperado, resultado);
    }

    @Test
    public void test_nome_planetas(){
        List<Planeta> planetas = criarListaPlanetas();

        String resultado = ExerciciosPlanetas.nome_planetas(planetas);
        String esperado = "Mercúrio, Vênus, Terra, Marte, Júpiter, Saturno, Urano, Netuno";

        assertEquals(esperado, resultado);
    }





}
