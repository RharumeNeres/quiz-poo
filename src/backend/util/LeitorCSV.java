package backend.util;

import backend.model.DBQuiz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe para leitura de um CSV com frases do quiz.
 * Autores: Rharume e Erick
 */
public class LeitorCSV {

    // Caminho do CSV na pasta data
    private static final String FILE_NAME = "data/efeito-estufa.csv";

    public static List<DBQuiz> lerPerguntas() throws FileNotFoundException {
        List<DBQuiz> lista = new ArrayList<>();

        File arquivo = new File(FILE_NAME);
        if (!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo CSV não encontrado: " + FILE_NAME);
        }

        try (Scanner sc = new Scanner(arquivo)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) continue; // pula linha vazia

                String[] data = line.split(";");
                if (data.length < 5) {
                    throw new IllegalArgumentException("Linha do CSV inválida: " + line);
                }

                int id = Integer.parseInt(data[0]);
                String question = data[1];
                int category = Integer.parseInt(data[2]);
                boolean answer = data[3].equalsIgnoreCase("V");
                char level = data[4].charAt(0);

                DBQuiz quiz = new DBQuiz(id, question, category, answer, level);
                lista.add(quiz);
            }
        }

        return lista;
    }
}
