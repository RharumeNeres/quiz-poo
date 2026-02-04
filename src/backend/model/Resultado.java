package backend.model;

import java.time.LocalDateTime;

/**
 * Representa o resultado final de um jogador.
 * Autores: Rharume e Erick
 */
public class Resultado {

    private final String nickname;
    private final double pontos;
    private final LocalDateTime dataHora;

    public Resultado(String nickname, double pontos) {
        this.nickname = nickname;
        this.pontos = pontos;
        this.dataHora = LocalDateTime.now();
    }

    public String getNickname() { return nickname; }
    public double getPontos() { return pontos; }
    public LocalDateTime getDataHora() { return dataHora; }
}
