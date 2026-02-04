package backend.util;

import backend.model.Resultado;

import java.io.*;
import java.util.*;

/**
 * Gerencia o arquivo de resultados.
 * Autores: Rharume e Erick
 */
public class ResultadoFileManager {

    private static final String FILE = "data/resultados.txt";

    public static void salvar(Resultado r) throws IOException {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(r.getNickname() + ";" + r.getPontos() + ";" + r.getDataHora() + "\n");
        }
    }

    public static List<Resultado> listar() throws IOException {
        List<Resultado> lista = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String l;
            while ((l = br.readLine()) != null) {
                String[] d = l.split(";");
                lista.add(new Resultado(d[0], Double.parseDouble(d[1])));
            }
        }
        return lista;
    }
}
