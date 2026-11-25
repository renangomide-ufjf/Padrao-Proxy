package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Prontuario> prontuarios = new HashMap<>();

    public static Prontuario getProntuario(Integer codigo) {
        return prontuarios.get(codigo);
    }

    public static void addProntuario(Prontuario prontuario) {
        prontuarios.put(prontuario.getCodigo(), prontuario);
    }
}
