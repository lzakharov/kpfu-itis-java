import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by lzakharov on 09.12.15.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
}
