import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.SocketPermission;

/**
 * @author Lev Zakharov
 *         11401
 *         Created on 10.09.2014.
 */
public class Task005 {
	public static void main(String[] args) {
        double x = 10.0;
        double y = 10.0;
        double z = 10.0;

        x += 2;
        z /= y;
        x -= z;
        y *= y;
        z *= y;
        x += z;
        System.out.println(x);
    }
}
