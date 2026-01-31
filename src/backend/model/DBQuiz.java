package backend.model;

/**
 * TAD para as perguntas do quiz.
 * Autores: Rharume e Erick
 */
public class DBQuiz {
    private int id;
    private String question;
    private int category;
    private boolean answer;
    private char level;

    public DBQuiz(int id, String question, int category, boolean answer, char level) {
        this.id = id;
        this.question = question;
        this.category = category;
        this.answer = answer;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getCategory() {
        return category;
    }

    public boolean isAnswer() {
        return answer;
    }

    public char getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "DBQuiz{" + "id=" + id + ", question=" + question + ", category=" + category + ", answer=" + answer + ", level=" + level + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
        hash = 11 * hash + this.category;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DBQuiz other = (DBQuiz) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.category == other.category;
    }
}
