import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 功能1：学生信息管理（增、删、改、查）
 */
public class Student {
    private String id;
    private String name;
    private int age;
    private String className;
    private double chinese;
    private double math;
    private double english;

    public Student(String id, String name, int age, String className, double chinese, double math, double english) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public double getTotalScore() {
        return chinese + math + english;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getClassName() { return className; }
    public double getChinese() { return chinese; }
    public double getMath() { return math; }
    public double getEnglish() { return english; }

    public void setChinese(double chinese) { this.chinese = chinese; }
    public void setMath(double math) { this.math = math; }
    public void setEnglish(double english) { this.english = english; }

    @Override
    public String toString() {
        return "学号：" + id +
                " | 姓名：" + name +
                " | 年龄：" + age +
                " | 班级：" + className +
                " | 语文：" + chinese +
                " | 数学：" + math +
                " | 英语：" + english +
                " | 总分：" + getTotalScore();
    }
}
// 学生管理功能：增删改查
class StudentManager {
    private List<Student> studentList;
    private Scanner scanner;

    public StudentManager() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.println("\n===== 添加学生信息 =====");
        System.out.print("请输入学号：");
        String id = scanner.next();

        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("该学号已存在！添加失败！");
                return;
            }
        }

        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入班级：");
        String className = scanner.next();
        System.out.print("请输入语文成绩：");
        double chinese = scanner.nextDouble();
        System.out.print("请输入数学成绩：");
        double math = scanner.nextDouble();
        System.out.print("请输入英语成绩：");
        double english = scanner.nextDouble();

        Student student = new Student(id, name, age, className, chinese, math, english);
        studentList.add(student);
        System.out.println("学生信息添加成功！");
    }

    public void deleteStudent() {
        System.out.println("\n===== 删除学生信息 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        System.out.print("请输入要删除的学生学号：");
        String id = scanner.next();
        boolean isDeleted = studentList.removeIf(s -> s.getId().equals(id));
        System.out.println(isDeleted ? "删除成功！" : "未找到该学号学生！");
    }

    public void updateStudentScore() {
        System.out.println("\n===== 修改学生成绩 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        System.out.print("请输入要修改的学生学号：");
        String id = scanner.next();

        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.print("请输入新的语文成绩：");
                double chinese = scanner.nextDouble();
                System.out.print("请输入新的数学成绩：");
                double math = scanner.nextDouble();
                System.out.print("请输入新的英语成绩：");
                double english = scanner.nextDouble();
                s.setChinese(chinese);
                s.setMath(math);
                s.setEnglish(english);
                System.out.println("成绩修改成功！");
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    public void queryAllStudents() {
        System.out.println("\n===== 所有学生信息 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public void queryStudentById() {
        System.out.println("\n===== 根据学号查询 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }
        System.out.print("请输入学号：");
        String id = scanner.next();
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                System.out.println("查询结果：");
                System.out.println(s);
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}

