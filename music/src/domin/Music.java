package domin;

public class Music {
    private int id;
    private String fen;
    private String min;

    public Music() {
    }

    public Music(int id, String fen, String min) {
        this.id = id;
        this.fen = fen;
        this.min = min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFen() {
        return fen;
    }

    public void setFen(String fen) {
        this.fen = fen;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", Fen='" + fen + '\'' +
                ", min='" + min + '\'' +
                '}';
    }
}
