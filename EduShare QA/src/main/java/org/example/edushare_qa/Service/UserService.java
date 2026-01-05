package org.example.edushare_qa.Service;

import org.example.edushare_qa.Pojo.LoginParam;
import org.example.edushare_qa.Pojo.User;
import org.example.edushare_qa.Pojo.UserAndToken;

public interface UserService {
    void Register(User user);

    UserAndToken login(LoginParam loginParam);

    Object getUsername(Long id);

    User findInfo(Long id);

    void update(User user);
}
