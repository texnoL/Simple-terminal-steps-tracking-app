
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class StepTracker{
    private int ceil = 10000;
    private HashMap<Integer, MonthData> stepsByMonth = new HashMap<Integer, MonthData>();

    StepTracker(){
        for (int i = 0; i < 12; i++){
            stepsByMonth.put(i, new MonthData());
        }
    }

    public void stepsByDayIn(int month, int day, int numOfSteps){
       stepsByMonth.get(month).setDay(day, numOfSteps);
    }

    public void outStatisticsOfMonth(int month) {
        stepsByMonth.get(month).print();
    }

    public void newCeil(int ceil) {
        this.ceil = ceil;
    }
}

class MonthData{
   private int[] stepsByDays;
    MonthData(){
        stepsByDays = new int[30];
    }

    public void setDay(int day, int steps){
        stepsByDays[day] = steps;
    }
    public void print(){
        System.out.println(Arrays.toString(stepsByDays));
    }
}

public class Main {
    public static void printMenu(){
        System.out.println("Выберете действие:");
        System.out.println("1.Вввести количество шагов за определенный день");
        System.out.println("2.Вывести статистику за определенный месяц");
        System.out.println("3.Изменить цель по количеству шагов в день");
        System.out.println("0.Выйти из приложения");
    }

    public static void main(String[] args){
        System.out.println("Добро пожаловать в приложение трекер шагов)");
        Scanner scanner = new Scanner(System.in);
        int userInput;
        StepTracker app = new StepTracker();

        do {
            printMenu();
            userInput = scanner.nextInt();
            switch (userInput){
                case 1 -> {
                    System.out.println("Введите месяц:");
                    int month = scanner.nextInt();
                    System.out.println("Введите день:");
                    int day = scanner.nextInt();
                    System.out.println("Введите кол-во шагов:");
                    int steps = scanner.nextInt();
                    app.stepsByDayIn(month, day, steps);
                }
                case 2 ->{
                    System.out.println("Введите месяц:");
                    int month = scanner.nextInt();
                    app.outStatisticsOfMonth(month);
                }
                case 3 ->{
                    System.out.println("Введите новую цель по кол-ву шагов:");
                    int ceil = scanner.nextInt();
                    app.newCeil(ceil);
                }
                case 0 ->{break;}
                default -> {
                    System.out.println("Неверно введен параметр(от 0 до 3)");
                }
            }

        } while(userInput != 0);
    }


}
