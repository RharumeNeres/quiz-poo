package backend.service;

import backend.exception.QuizException;
import backend.model.DBQuiz;
import backend.util.LeitorCSV;

import java.util.*;

/**
 * API principal do Quiz.
 * Autores: Rharume e Erick
 */
public class QuizService {

    private final List<DBQuiz> perguntasQuiz;
    private double pontuacao;
    private final int totalPerguntas;

    public QuizService(int totalPerguntas) throws QuizException {

        if (totalPerguntas < 5 || totalPerguntas > 20)
            throw new QuizException("Quantidade de perguntas inválida.");

        List<DBQuiz> todas = LeitorCSV.lerPerguntas();
        Collections.shuffle(todas);

        this.perguntasQuiz = todas.subList(0, totalPerguntas);
        this.totalPerguntas = totalPerguntas;
        this.pontuacao = 0;
    }

    public List<DBQuiz> getPerguntasQuiz() {
        return perguntasQuiz;
    }

    public void responder(DBQuiz p, boolean respostaUsuario, int tempo) {

        if (tempo < 1 || tempo > 60) return;

        if (respostaUsuario == p.isAnswer()) {
            int nd = p.getLevel() == 'F' ? 1 : p.getLevel() == 'M' ? 2 : 3;
            pontuacao += (1200.0 * nd) / (tempo * totalPerguntas);
        }
    }

    public double getPontuacao() {
        return pontuacao;
    }
}
