package test;

import backend.model.DBQuiz;
import backend.service.QuizService;
import backend.exception.QuizException;

import java.util.List;

public class TesteBackend {

    public static void main(String[] args) {
        try {
            // Cria o QuizService com 10 perguntas
            QuizService quiz = new QuizService(10);

            // Pega todas as perguntas carregadas
            List<DBQuiz> perguntas = quiz.getPerguntas();
            System.out.println("Total de perguntas carregadas: " + perguntas.size());

            if (!perguntas.isEmpty()) {
                DBQuiz primeira = perguntas.get(0);
                System.out.println("Primeira pergunta:");
                System.out.println("ID: " + primeira.getId());
                System.out.println("Pergunta: " + primeira.getQuestion());
                System.out.println("Categoria: " + primeira.getCategory());
                System.out.println("Resposta correta: " + (primeira.isAnswer() ? "V" : "F"));
                System.out.println("Nível: " + primeira.getLevel());
            }

        } catch (QuizException e) {
            System.out.println("Erro ao inicializar o quiz: " + e.getMessage());
        }
    }
}
