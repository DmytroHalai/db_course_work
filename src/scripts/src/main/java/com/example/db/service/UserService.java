public interface UserService {

    void create(User user);
    List<user> readAll();
    User read(int id);
    boolean update(User user, int id);
    boolean delete(int id);
}