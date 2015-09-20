import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by lzakharov on 17.03.15.
 */

public class c15_16 {
    public static void main(String[] args) {
        String filename = "11401.txt";
        File file = new File(filename);
        HashSet<Student> students = new HashSet<>();
        ArrayList<String> tasks = new ArrayList<>();
        int taskNum = 0;

        try {
            BufferedReader input = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = input.readLine()) != null) {
                if (isInfo(s)) {
                    String[] t = s.split("(\t|\b)");
                    String name = t[0];
                    ArrayList<String> results = new ArrayList<>();
                    for (int i = 1; i < t.length; i++) {
                        results.add(t[i]);
                    }

                    Student student;

                    if ((student = getStudentByLastName(students, t[0])) != null) {
                        student.addData(results);
                        while (student.getResults().size() < taskNum) {
                            student.addTask(" ");
                        }
                    } else {
                        students.add(new Student(name, results));
                    }

                } else if (s.charAt(1) == '0') {
                    String[] t = s.split("(\t|\b)");
                    for (int i = 1; i < t.length; i++) {
                        tasks.add(t[i]);
                    }
                    taskNum += t.length - 1;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        for (Student student: students) {
//            System.out.print(student.getName() + " ");
//            ArrayList<String> res = student.getResults();
//            for (String result: res) {
//                System.out.print(result + " ");
//            }
//
//            System.out.println();
//        }


        // Task 16c
        HashMap<Student, Integer> studentSolvesCount = new HashMap<>();
        for (Student student: students) {
            Integer cnt = 0;
            for (String s: student.getResults()) {
                if (s.equals("1")) {
                    cnt++;
                }
            }

            studentSolvesCount.put(student, cnt);
        }

        for (Student student: students) {
            System.out.println(student.getName() + " " + studentSolvesCount.get(student));
        }

        HashMap<Student, Double> studentAverageScore = new HashMap<>();

        for (Student student: students) {
            Double average = 0.;
            for (String s: student.getResults()) {
                try {
                    Double x = Double.parseDouble(s);
                    average += x;
                } catch (NumberFormatException e) {
                }
            }

            studentAverageScore.put(student, average / taskNum);
        }

        for (Student student: students) {
            System.out.println(student.getName() + " " + studentAverageScore.get(student));
        }

        HashMap<String, Integer> numberOfSolutions = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            int cnt = 0;
            for (Student student: students) {
                if (student.getResults().get(i).equals("1")) {
                    cnt++;
                }
            }

            numberOfSolutions.put(tasks.get(i), cnt);
        }

        for (String task: tasks) {
            System.out.println(task + " " + numberOfSolutions.get(task));
        }

        HashMap<String, Double> taskAverageScore = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            double average = 0;
            for (Student student: students) {
                try {
                    Double x = Double.parseDouble(student.getResults().get(i));
                    average += x;
                } catch (NumberFormatException e) {
                }
            }

            taskAverageScore.put(tasks.get(i), average / students.size());

        }

        for (String task: tasks) {
            System.out.println(task + " " + taskAverageScore.get(task));
        }
    }

    private static Student getStudentByLastName(HashSet<Student> students, String name) {
        Iterator it = students.iterator();
        while (it.hasNext()) {
            Student student = (Student)it.next();
            if (student.getName().equals(name)) {
                return student;
            }
        }

        return null;
    }

    private static boolean isInfo(String s) {
        return s.charAt(0) >= 'А' && s.charAt(0) <= 'Я';
    }
}