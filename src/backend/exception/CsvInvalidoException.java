package backend.exception;

/**
 * Exceção para erros no CSV.
 * Autores: Rharume e Erick
 */
public class CsvInvalidoException extends QuizException {
    public CsvInvalidoException(String msg) {
        super(msg);
    }
}
