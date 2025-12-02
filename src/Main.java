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
                     calculatingTheTax(resultEarnings,
                             resultSpendings,
                             taxSixPersent,
                             taxFifteenPersent,
                             reslutOfTax);
                 }
             }
        }
    }

    public static void calculatingTheTax(int resultEarnings,
                                         int resultSpendings,
                                         double tax6,
                                         double tax15,
                                         double reslutOfTax) {

        tax6 = resultEarnings * 0.06; // вычисляем 6%-ый налог

        tax15 = (resultEarnings - resultSpendings) * 0.15; // вычисляем 15%-ый налог


        // Сравниваю
        if (tax6 < tax15) {

            reslutOfTax = tax15 - tax6;

            System.out.println("выгоднее УСН 6%");
            System.out.println("Ваш налог составит: " + tax6);
            System.out.println("Налог на другой системе: " + tax15);
            System.out.println("Экономия: " + reslutOfTax);
        }
        if (tax6 > tax15) {

            reslutOfTax = tax6 - tax15;

            System.out.println("выгоднее УСН 15%");
            System.out.println("Ваш налог составит: " + tax15);
            System.out.println("Налог на другой системе: " + tax6);
            System.out.println("Экономия: " + reslutOfTax);
        }
        if (tax6 == tax15) {
            System.out.println("Вы можете выбрать любую из систем налогообложения");
        }
    }


}