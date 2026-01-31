package backend.util;

import java.io.*;

/**
 * Gerencia a configuração da quantidade de perguntas.
 * Autores: Rharume e Erick
 */
public class ConfiguracaoManager {

    private static final String FILE = "data/config.txt";

    public static void salvarQP(int qp) throws IOException {
        try (FileWriter fw = new FileWriter(FILE)) {
            fw.write(String.valueOf(qp));
        }
    }

    public static int carregarQP() throws IOException {
        File f = new File(FILE);
        if (!f.exists()) return 10; // valor padrão

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            return Integer.parseInt(br.readLine());
        }
    }
}
