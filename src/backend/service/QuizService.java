package backend.service;

import backend.exception.QuizException;
import backend.model.DBQuiz;
import backend.util.LeitorCSV;

import java.util.List;
import java.util.Random;

/**
 * API principal do Quiz.
 * Autores: Rharume e Erick
 */
public class QuizService {

    private List<DBQuiz> perguntas;
    private double pontuacao;
    private int totalPerguntas;

    /**
     * Construtor do QuizService.
     * Carrega as perguntas do CSV e define a quantidade de perguntas do quiz.
     *
     * @param totalPerguntas número de perguntas no quiz (entre 5 e 20)
     * @throws QuizException se totalPerguntas for inválido ou se CSV não puder ser lido
     */
    public QuizService(int totalPerguntas) throws QuizException {

        if (totalPerguntas < 5 || totalPerguntas > 20)
            throw new QuizException("Quantidade de perguntas inválida");

        try {
            this.perguntas = LeitorCSV.lerPerguntas(); // chama o método correto
        } catch (Exception e) {
            throw new QuizException("Erro ao carregar perguntas: " + e.getMessage());
        }

        this.totalPerguntas = totalPerguntas;
        this.pontuacao = 0.0;
    }

    /**
     * Sorteia aleatoriamente uma pergunta do banco.
     * @return pergunta sorteada
     */
    public DBQuiz sortearPergunta() {
        Random r = new Random();
        return perguntas.get(r.nextInt(perguntas.size()));
    }

    /**
     * Registra a resposta do usuário e atualiza a pontuação.
     * @param p pergunta respondida
     * @param respostaUsuario resposta do usuário (true/false)
     * @param tempo tempo gasto em segundos (1-60)
     */
    public void responder(DBQuiz p, boolean respostaUsuario, int tempo) {

        if (respostaUsuario == p.isAnswer()) {
            int nd = (p.getLevel() == 'F') ? 1 :
                    (p.getLevel() == 'M') ? 2 : 3;

            pontuacao += (1200.0 * nd) / (tempo * totalPerguntas);
        }
    }

    /**
     * Retorna a pontuação atual do usuário.
     * @return pontuação
     */
    public double getPontuacao() {
        return pontuacao;
    }

    /**
     * Retorna a lista de todas as perguntas carregadas.
     * @return lista de perguntas
     */
    public List<DBQuiz> getPerguntas() {
        return perguntas;
    }

    /**
     * Retorna a quantidade total de perguntas definidas para o quiz.
     * @return total de perguntas
     */
    public int getTotalPerguntas() {
        return totalPerguntas;
    }
}
