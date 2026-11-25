package padroesestruturais.proxy;

import java.util.List;

public class ProntuarioProxy implements IProntuario {

    private Prontuario prontuario;

    private Integer codigo;

    public ProntuarioProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosBasicos() {
        if (this.prontuario == null) {
            this.prontuario = new Prontuario(this.codigo);
        }
        return this.prontuario.obterDadosBasicos();
    }

    @Override
    public List<String> obterHistoricoClinico(Medico medico) {
        if (!medico.isAutorizado()) {
            throw new IllegalArgumentException("Médico não autorizado");
        }
        if (this.prontuario == null) {
            this.prontuario = new Prontuario(this.codigo);
        }
        return this.prontuario.obterHistoricoClinico(medico);
    }
}
