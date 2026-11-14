package servicio;

import modelo.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaEstudiantesTest {

    private SistemaEstudiantes sistema;

    @BeforeEach
    void preparar() {
        sistema = new SistemaEstudiantes();
    }

    @Test
    void registrarNuevoDevuelveTrue() {
        assertTrue(sistema.registrar(new Estudiante("A01", "Ana", 90)));
    }

    @Test
    void registrarCodigoDuplicadoDevuelveFalse() {
        sistema.registrar(new Estudiante("A01", "Ana", 90));
        assertFalse(sistema.registrar(new Estudiante("A01", "Luis", 80)));
    }

    @Test
    void buscarExistenteDevuelveEstudiante() {
        Estudiante ana = new Estudiante("A01", "Ana", 90);
        sistema.registrar(ana);
        assertEquals(ana, sistema.buscarPorCodigo("A01"));
    }

    @Test
    void buscarInexistenteDevuelveNull() {
        assertNull(sistema.buscarPorCodigo("X99"));
    }

    @Test
    void actualizarPromedioExistente() {
        sistema.registrar(new Estudiante("A01", "Ana", 70));
        assertTrue(sistema.actualizarPromedio("A01", 95));
        assertEquals(95, sistema.buscarPorCodigo("A01").getPromedio());
    }

    @Test
    void actualizarInexistenteDevuelveFalse() {
        assertFalse(sistema.actualizarPromedio("X99", 90));
    }

    @Test
    void eliminarExistenteLoQuitaDelRanking() {
        sistema.registrar(new Estudiante("A01", "Ana", 90));
        assertTrue(sistema.eliminar("A01"));
        assertEquals(0, sistema.cantidad());
        assertTrue(sistema.listarRanking().isEmpty());
    }

    @Test
    void listarRankingVacio() {
        assertTrue(sistema.listarRanking().isEmpty());
    }

    @Test
    void rankingOrdenDescendente() {
        sistema.registrar(new Estudiante("A01", "Ana", 80));
        sistema.registrar(new Estudiante("A02", "Luis", 95));
        sistema.registrar(new Estudiante("A03", "Maria", 88));

        assertEquals("A02", sistema.listarRanking().get(0).getCodigo());
        assertEquals("A03", sistema.listarRanking().get(1).getCodigo());
        assertEquals("A01", sistema.listarRanking().get(2).getCodigo());
    }

    @Test
    void topNMayorQueTotalDevuelveTodos() {
        sistema.registrar(new Estudiante("A01", "Ana", 80));
        sistema.registrar(new Estudiante("A02", "Luis", 95));
        assertEquals(2, sistema.topN(10).size());
    }
}
