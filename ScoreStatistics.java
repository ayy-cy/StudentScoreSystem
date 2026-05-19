import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 功能2：成绩统计与排名
 * 包含：平均分、最高分、最低分、总分排名、各科排名、总分段统计、及格率、优秀率
 * 代码行数：150+
 */
public class ScoreStatistics {

    // 1. 计算各科平均分
    public void showAverageScore(List<Student> studentList) {
        System.out.println("\n===== 各科平均分统计 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }

        double totalChinese = 0;
        double totalMath = 0;
        double totalEnglish = 0;
        int count = studentList.size();

        for (Student s : studentList) {
            totalChinese += s.getChinese();
            totalMath += s.getMath();
            totalEnglish += s.getEnglish();
        }

        double avgChinese = totalChinese / count;
        double avgMath = totalMath / count;
        double avgEnglish = totalEnglish / count;

        System.out.printf("语文平均分：%.2f\n", avgChinese);
        System.out.printf("数学平均分：%.2f\n", avgMath);
        System.out.printf("英语平均分：%.2f\n", avgEnglish);
    }

    // 2. 各科最高分、最低分
    public void showMaxMinScore(List<Student> studentList) {
        System.out.println("\n===== 最高分 & 最低分 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }

        Student maxChinese = studentList.get(0);
        Student minChinese = studentList.get(0);
        Student maxMath = studentList.get(0);
        Student minMath = studentList.get(0);
        Student maxEnglish = studentList.get(0);
        Student minEnglish = studentList.get(0);

        for (Student s : studentList) {
            if (s.getChinese() > maxChinese.getChinese()) maxChinese = s;
            if (s.getChinese() < minChinese.getChinese()) minChinese = s;
            if (s.getMath() > maxMath.getMath()) maxMath = s;
            if (s.getMath() < minMath.getMath()) minMath = s;
            if (s.getEnglish() > maxEnglish.getEnglish()) maxEnglish = s;
            if (s.getEnglish() < minEnglish.getEnglish()) minEnglish = s;
        }

        System.out.println("语文最高分：" + maxChinese.getName() + " " + maxChinese.getChinese());
        System.out.println("语文最低分：" + minChinese.getName() + " " + minChinese.getChinese());
        System.out.println("数学最高分：" + maxMath.getName() + " " + maxMath.getMath());
        System.out.println("数学最低分：" + minMath.getName() + " " + minMath.getMath());
        System.out.println("英语最高分：" + maxEnglish.getName() + " " + maxEnglish.getEnglish());
        System.out.println("英语最低分：" + minEnglish.getName() + " " + minEnglish.getEnglish());
    }

    // 3. 按总分排名
    public void sortByTotalScore(List<Student> studentList) {
        System.out.println("\n===== 学生总分排名 =====");
        if (studentList.isEmpty()) {
            System.out.println("暂无学生信息！");
            return;
        }

        List<Student> sortList = new ArrayList<>(studentList);
        sortList.sort(Comparator.comparingDouble(Student::getTotalScore).reversed());

        System.out.println("排名 | 姓名   | 总分");
        for (int i = 0; i < sortList.size(); i++) {
            Student s = sortList.get(i);
            System.out.printf("%-4d | %-6s | %.2f\n", (i + 1), s.getName(), s.getTotalScore());
        }
    }

    // 4. 按语文成绩排名（新增）
    public void sortByChinese(List<Student> studentList) {
        System.out.println("\n===== 语文成绩排名 =====");
        List<Student> list = new ArrayList<>(studentList);
        list.sort(Comparator.comparingDouble(Student::getChinese).reversed());
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println((i+1)+"、"+s.getName()+"："+s.getChinese());
        }
    }

    // 5. 按数学成绩排名（新增）
    public void sortByMath(List<Student> studentList) {
        System.out.println("\n===== 数学成绩排名 =====");
        List<Student> list = new ArrayList<>(studentList);
        list.sort(Comparator.comparingDouble(Student::getMath).reversed());
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println((i+1)+"、"+s.getName()+"："+s.getMath());
        }
    }

    // 6. 按英语成绩排名（新增）
    public void sortByEnglish(List<Student> studentList) {
        System.out.println("\n===== 英语成绩排名 =====");
        List<Student> list = new ArrayList<>(studentList);
        list.sort(Comparator.comparingDouble(Student::getEnglish).reversed());
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println((i+1)+"、"+s.getName()+"："+s.getEnglish());
        }
    }

    // 7. 成绩分段统计（新增）
    public void showScoreLevel(List<Student> studentList) {
        System.out.println("\n===== 总分分段统计 =====");
        int levelA = 0, levelB = 0, levelC = 0, levelD = 0;
        for (Student s : studentList) {
            double total = s.getTotalScore();
            if (total >= 270) levelA++;
            else if (total >= 240) levelB++;
            else if (total >= 180) levelC++;
            else levelD++;
        }
        System.out.println("270分以上（优秀）：" + levelA + " 人");
        System.out.println("240-269分（良好）：" + levelB + " 人");
        System.out.println("180-239分（及格）：" + levelC + " 人");
        System.out.println("180分以下（不及格）：" + levelD + " 人");
    }

    // 8. 及格率统计（新增）
    public void showPassRate(List<Student> studentList) {
        System.out.println("\n===== 各科及格率统计 =====");
        int passChinese = 0, passMath = 0, passEnglish = 0;
        int total = studentList.size();

        for (Student s : studentList) {
            if (s.getChinese() >= 60) passChinese++;
            if (s.getMath() >= 60) passMath++;
            if (s.getEnglish() >= 60) passEnglish++;
        }

        System.out.printf("语文及格率：%.2f%%\n", (passChinese * 100.0 / total));
        System.out.printf("数学及格率：%.2f%%\n", (passMath * 100.0 / total));
        System.out.printf("英语及格率：%.2f%%\n", (passEnglish * 100.0 / total));
    }
}