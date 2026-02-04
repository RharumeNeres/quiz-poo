package test;

import backend.service.QuizService;
import backend.model.DBQuiz;

public class TesteBackend {

    public static void main(String[] args) {
        try {
            QuizService quiz = new QuizService(10);

            System.out.println("Perguntas do quiz:");
            for (DBQuiz q : quiz.getPerguntasQuiz()) {
                System.out.println(q.getId() + " - " + q.getQuestion());
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
