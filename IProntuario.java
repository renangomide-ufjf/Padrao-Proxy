package padroesestruturais.proxy;

import java.util.List;

public interface IProntuario {
    List<String> obterDadosBasicos();
    List<String> obterHistoricoClinico(Medico medico);
}
