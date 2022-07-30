import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] goods = {"Хлеб", "Масло", "Молоко", "Яйца"};
        int[] prices = {45, 130, 100, 120};
        int[] countProduct = new int[goods.length];
        int[] costProduct = new int[goods.length];

        System.out.println("Список доступных товаров:");
        for (int i = 0; i < goods.length; i++) {
            System.out.println((i + 1) + ". " + goods[i] + " по цене: " + prices[i] + " руб./ед.");
        }
        while (true) {
            System.out.println("Введите номер товара и его количество. По заврешении заполнения корзины нажмите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Необходимо ввести 2 значения: номер товара и его количество. Вы ввели: " + parts.length);
                continue;
            } else {
                int numProduct;
                int count = 0;
                try {
                    numProduct = Integer.parseInt(parts[0]) - 1;
                    count += Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Введены некорректные данные: необходимо ввести числовые значения");
                    continue;
                }
                if ((numProduct + 1) > goods.length || numProduct < 0 || (countProduct[numProduct] + count) < 0) {
                    System.out.println("Вы ввели некорректные данные");
                    continue;
                } else if (count == 0) {
                    countProduct[numProduct] = 0;
                } else if (countProduct[numProduct] > 0) {
                    countProduct[numProduct] += count;
                } else {
                    countProduct[numProduct] = count;
                }
                costProduct[numProduct] = countProduct[numProduct] * prices[numProduct];
            }

        }
        int sum = 0;
        for (int totalSum : costProduct) {
            sum += totalSum;
        }
        System.out.println("В Вашей корзине товаров на сумму: ");
        for (int i = 0; i < goods.length; i++) {
            if (countProduct[i] > 0) {
                System.out.println(goods[i] + ": " + countProduct[i] + " ед. х " + prices[i] + " руб.ед. = " + costProduct[i] + " руб.");
            }
        }
        System.out.println("Итого к оплате: " + sum + " руб.");


    }
}
