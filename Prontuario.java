package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Prontuario implements IProntuario {

    private Integer codigo;
    private String nomePaciente;
    private String cidade;
    private String diagnostico;
    private String medicacao;

    public Prontuario(Integer codigo) {
        this.codigo = codigo;
        Prontuario objeto = BD.getProntuario(codigo);
        this.nomePaciente = objeto.nomePaciente;
        this.cidade = objeto.cidade;
        this.diagnostico = objeto.diagnostico;
        this.medicacao = objeto.medicacao;
    }

    public Prontuario(Integer codigo, String nomePaciente, String cidade, String diagnostico, String medicacao) {
        this.codigo = codigo;
        this.nomePaciente = nomePaciente;
        this.cidade = cidade;
        this.diagnostico = diagnostico;
        this.medicacao = medicacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosBasicos() {
        return Arrays.asList(this.nomePaciente, this.cidade);
    }

    @Override
    public List<String> obterHistoricoClinico(Medico medico) {
        return Arrays.asList(this.diagnostico, this.medicacao);
    }
}
