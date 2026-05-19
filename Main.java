import java.util.Scanner;

/**
 * 主程序：整合功能1 + 功能2
 */
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        ScoreStatistics stats = new ScoreStatistics();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==================== 学生信息与成绩管理系统 ====================");
            System.out.println("【功能1：学生信息管理】");
            System.out.println("1. 添加学生信息");
            System.out.println("2. 删除学生信息");
            System.out.println("3. 修改学生成绩");
            System.out.println("4. 查询所有学生");
            System.out.println("5. 根据学号查询学生");
            System.out.println("\n【功能2：成绩统计与排名】");
            System.out.println("6. 查看各科平均分");
            System.out.println("7. 查看最高分与最低分");
            System.out.println("8. 按总分排名");
            System.out.println("\n0. 退出系统");
            System.out.println("==============================================================");
            System.out.print("请输入功能编号：");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: manager.addStudent(); break;
                case 2: manager.deleteStudent(); break;
                case 3: manager.updateStudentScore(); break;
                case 4: manager.queryAllStudents(); break;
                case 5: manager.queryStudentById(); break;
                case 6: stats.showAverageScore(manager.getStudentList()); break;
                case 7: stats.showMaxMinScore(manager.getStudentList()); break;
                case 8: stats.sortByTotalScore(manager.getStudentList()); break;
                case 0:
                    System.out.println("系统已退出！");
                    scanner.close();
                    return;
                default: System.out.println("输入错误，请重新输入！");
            }
        }
    }
}