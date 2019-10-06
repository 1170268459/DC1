package domin;

public class Fen {
    private int id;
    private String fen;

    public Fen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String  getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public Fen(int id, String fen) {
        this.id = id;
        this.fen = fen;
    }

    @Override
    public String toString() {
        return "Fen{" +
                "id=" + id +
                ", Fen='" + fen + '\'' +
                '}';
    }
}
