import ru.kpfu.itis.lzakharov.models.Article;
import ru.kpfu.itis.lzakharov.models.Book;
import ru.kpfu.itis.lzakharov.respository.ArticleRepository;
import ru.kpfu.itis.lzakharov.respository.BookRepository;
import ru.kpfu.itis.lzakharov.respository.Repository;

import java.util.LinkedList;

/**
 * Created by lzakharov on 07.11.15.
 */
public class Test {
    public static void main(String[] args) {
        Repository repository = new Repository();

        System.out.println(ArticleRepository.getArticlesCut(1).toString());
    }
}
