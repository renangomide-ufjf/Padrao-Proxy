package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProntuarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addProntuario(new Prontuario(1, "João", "Juiz de Fora", "Hipertensão", "Losartana"));
        BD.addProntuario(new Prontuario(2, "Maria", "Juiz de Fora", "Diabetes", "Metformina"));
    }

    @Test
    void deveRetornarDadosBasicosPaciente() {
        ProntuarioProxy prontuario = new ProntuarioProxy(1);

        assertEquals(Arrays.asList("João", "Juiz de Fora"), prontuario.obterDadosBasicos());
    }

    @Test
    void deveRetornarHistoricoClinicoPaciente() {
        Medico medico = new Medico("Ana", true);
        ProntuarioProxy prontuario = new ProntuarioProxy(2);

        assertEquals(Arrays.asList("Diabetes", "Metformina"), prontuario.obterHistoricoClinico(medico));
    }

    @Test
    void deveRetornarExcecaoMedicoNaoAutorizadoConsultarHistorico() {
        try {
            Medico medico = new Medico("Joana", false);
            ProntuarioProxy prontuario = new ProntuarioProxy(2);

            prontuario.obterHistoricoClinico(medico);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Médico não autorizado", e.getMessage());
        }
    }
}
