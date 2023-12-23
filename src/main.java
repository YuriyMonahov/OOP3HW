import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        //Создать список из 10-20 рандомных сотрудников
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            employees.add(new Employee("Employee" + i, (int) (Math.random() * 30 + 20),
                    Math.round(Math.random() * 100000 * 100) / 100.0));
        }
        System.out.println("Не отсортированный список сотрудников: \n" + employees);

        //Отсортировать его по убыванию возрастов (от большего к меньшему).
        Collections.sort(employees, Comparator.comparingInt(Employee::getAge).reversed());
        System.out.println(("Сортировка по убыванию возраста: \n") + employees);

        //Отсортировать его по возрастанию зарплаты.
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        System.out.println(("Сортировка по по возрастанию зарплаты: \n") + employees);

        //Вывести топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени в алфавитном порядке.
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary).reversed()
                .thenComparing(Employee::getName));
        List<Employee> top5 = new ArrayList<>(employees.subList(0, 5));
        System.out.println("Топ-5 сотрудников с наибольшей зарплатой, отсортированных по имени в алфавитном порядке:\n" + top5);

        //Отсортировать сотрудников по возрастанию возрастов. Если возрасты одинаковые - то по убыванию зарплаты.
        //Если и они равны - в алфавитном порядке.
        Collections.sort(employees, Comparator.comparingInt(Employee::getAge)
                .thenComparingDouble(Employee::getSalary).reversed()
                .thenComparing(Employee::getName));
        System.out.println("Сортировка по возрастанию возрастов, затем по убыванию зарплаты, затем в алфавитном порядке:\n" + employees);
    }
}


