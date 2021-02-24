import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.mysql.cj.log.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final Logger log = LogFactory.getLogger(this.getClass());
    private final PostRepository postDao;
    private final UserRepository usersDao;

    @Value("{app.env}")
    private String environment;

    public DatabaseSeeder(PostRepository postDao, UserRepository usersDao){
        this.postDao = postDao;
        this.usersDao = usersDao;
    }

    private List<User> seedUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "Amber", "amber@email.com", "password"),
                new User(2L, "Bob", "bob@email.com", "password"),
                new User(3L, "Charlie", "charlie@email.com", "password")

        );

        usersDao.save(users);
        return users;
    }

        private void seedPosts(List<User> users){
            List<Post> posts = Arrays.asList(
                    new Post("Title 1","This is title one",2L),
                    new Post("Title 2","This is title two",2L),
                    new Post("Title 3","This is title three",2L)
            );

            Random r = new Random();
            for (Post p : posts) {
                User randomUser = users.get(r.nextInt(users.size()));
                p.setUser(randomUser);
            }
            postDao.save(posts);
        }





    @Override
    public void run(String... args) throws Exception {
        if (! environment.equals("development")) {
            log.info("app.env is not development, doing nothing.");
            return;
        }

        log.info("Deleting posts...");
        postDao.deleteAll();
        log.info("Deleting users...");
        usersDao.deleteAll();
        log.info("Seeding users...");
        List<User> users = seedUsers();
        log.info("Seeding posts...");
        seedPosts(users);
        log.info("Finished running seeders!");

    }
}
