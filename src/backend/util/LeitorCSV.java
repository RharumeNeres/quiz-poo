package backend.util;

import backend.exception.CsvInvalidoException;
import backend.model.DBQuiz;

import java.io.File;
import java.util.*;

/**
 * Classe para leitura de um CSV com frases do quiz.
 * Autores: Rharume e Erick
 */
public class LeitorCSV {

    private static final String FILE_NAME = "data/efeito-estufa.csv";

    public static List<DBQuiz> lerPerguntas() throws CsvInvalidoException {

        List<DBQuiz> lista = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();

        File arquivo = new File(FILE_NAME);
        if (!arquivo.exists())
            throw new CsvInvalidoException("Arquivo CSV não encontrado.");

        try (Scanner sc = new Scanner(arquivo)) {
            while (sc.hasNextLine()) {

                String linha = sc.nextLine().trim();
                if (linha.isEmpty()) continue;

                String[] d = linha.split(";");
                if (d.length != 5)
                    throw new CsvInvalidoException("Linha inválida: " + linha);

                int id = Integer.parseInt(d[0]);
                if (!ids.add(id))
                    throw new CsvInvalidoException("ID duplicado: " + id);

                String pergunta = d[1];
                int categoria = Integer.parseInt(d[2]);

                if (!d[3].equalsIgnoreCase("V") && !d[3].equalsIgnoreCase("F"))
                    throw new CsvInvalidoException("Resposta inválida: " + d[3]);

                boolean resposta = d[3].equalsIgnoreCase("V");

                char nivel = d[4].charAt(0);
                if (nivel != 'F' && nivel != 'M' && nivel != 'D')
                    throw new CsvInvalidoException("Nível inválido: " + nivel);

                lista.add(new DBQuiz(id, pergunta, categoria, resposta, nivel));
            }
        } catch (Exception e) {
            throw new CsvInvalidoException(e.getMessage());
        }

        return lista;
    }
}
