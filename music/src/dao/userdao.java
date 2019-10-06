package dao;


import domin.User;

import java.sql.SQLException;

public interface userdao {
    boolean login(User user);

    boolean regesit(User user);

    boolean deluser(String name);

    boolean updatau(User user);
}
