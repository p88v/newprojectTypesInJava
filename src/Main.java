import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int resultEarnings = 0;
        int resultSpendings = 0;

        double taxSixPersent = 0; // Налог 6%
        double taxFifteenPersent = 0; // Налог 15%
        double reslutOfTax = 0; // Результат

        while (true) {

            System.out.println("\n\nВыберите опреацию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("4. Для завершения программы введите \"end\"");
            System.out.print("Укажите, что хотите выбрать: ");


            String input = scanner.nextLine();

             if(input.equals("end")){
                 System.out.println("Программа завершена.");
                 break;
             }

             if(input.equals("1") || input.equals("2") || input.equals("3")){
                 int chooseNumber = Integer.parseInt(input);

                 if (chooseNumber == 1) {
                     System.out.print("Введите сумму дохода: ");
                     int inputDohod = scanner.nextInt();
                     scanner.nextLine();
                     resultEarnings += inputDohod;


                 } else if (chooseNumber == 2) {

                     System.out.print("Введите сумму расхода: ");
                     int inputRashod = scanner.nextInt();
                     scanner.nextLine();
                     resultSpendings += inputRashod;


                 } else if (chooseNumber == 3) {
                    double ysn6 = calculatingYSN6((double) resultEarnings);
                    double ysn15 = calculatingYSN15((double) resultEarnings,  (double) resultSpendings);

                    if(ysn6 > ysn15){
                        double resultysn6 = ysn6 -  ysn15;
                        System.out.println("Мы советуем вам УСН доходы - расходы\n" +
                                "Ваш налог составит: " + ysn15 + "\n" +
                                "Налог на другой системе:" + ysn6 + "\n" +
                                "Экономия: " + resultysn6);
                    } else if (ysn6 < ysn15) {
                        double resultysn15 = ysn15 - ysn6;
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: " + ysn6 + "\n" +
                                "Налог на другой системе:" + ysn15 + "\n" +
                                "Экономия: " + resultysn15);

                    } else if (ysn6 == ysn15) {
                        System.out.println("Вы можете выбрать любую систему УСН");
                    }
                 }
             }
        }
    }




    public static double calculatingYSN6(double earnigs){
        return earnigs * 0.06;
    }

    public static double calculatingYSN15(double earning, double spendings){
        return (earning - spendings) * 0.15;
    }

}