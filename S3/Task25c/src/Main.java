import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by lzakharov on 09.12.15.
 */

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> authors = new HashSet<>();
        HashMap<String, List<Method>> map = new HashMap<>();

        Class $class = null;
        for (int i = 0; i < n; i++) {
            $class = Class.forName(scanner.nextLine());

            Method[] methods = $class.getMethods();

            for (Method method: methods) {
                Author annotation = method.getAnnotation(Author.class);
                if (annotation != null) {
                    String name = annotation.name();
                    if (!authors.contains(name)) {
                        authors.add(name);
                        map.put(name, new LinkedList<>());
                        map.get(name).add(method);
                    } else {
                        map.get(name).add(method);
                    }
                }
            }
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        Map<String, Integer> map4 = new HashMap<>();

        for (Map.Entry<String, List<Method>> entry: map.entrySet()) {
            int cnt1 = 0;

            int cnt2 = 0;
            int paramsCnt = 0;

            int cnt3 = 0;

            for (Method method: entry.getValue()) {
                cnt1 += method.getName().length();

                for (Parameter parameter: method.getParameters()) {
                    cnt2 += parameter.getName().length();
                }
                paramsCnt += method.getParameters().length;

                if (method.getReturnType().equals(Void.TYPE)) {
                    cnt3++;
                }
            }

            String name = entry.getKey();
            map1.put(name, cnt1 / entry.getValue().size());
            map2.put(name, cnt2 / paramsCnt);
            map3.put(name, cnt3);
            map4.put(name, paramsCnt);
        }

        List<Map.Entry<String, Integer>> list1 = new LinkedList<>(map1.entrySet());
        List<Map.Entry<String, Integer>> list2 = new LinkedList<>(map2.entrySet());
        List<Map.Entry<String, Integer>> list3 = new LinkedList<>(map3.entrySet());
        List<Map.Entry<String, Integer>> list4 = new LinkedList<>(map4.entrySet());

        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        Collections.sort(list1, cmp);
        Collections.sort(list2, cmp);
        Collections.sort(list3, cmp);
        Collections.sort(list4, cmp);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
    }
}