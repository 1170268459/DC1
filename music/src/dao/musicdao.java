package dao;

import domin.Music;

import java.awt.*;
import java.util.List;

public interface musicdao {
    List<Music> show();

    boolean add(Music music);

    boolean delete(int id);

    boolean select(Music music);

    boolean update(Music music);

    int selectAll();
    /*  List<Music> show();*/
}
