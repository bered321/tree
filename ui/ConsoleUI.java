package ui;
import java.io.IOException;
import java.util.Scanner;
import presenter.Presenter;
import tree.Tree;

public class ConsoleUI<T> implements View<T> {
    private Scanner scanner;
    private Presenter<T> presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    private int scan() {
        int n = 0;
        while (n <= 0 || n > 4) {
            System.out.println(
                    "\nВведите цифру варианта действия над фамильным деревом:\n1. Найти человека по имени\n" +
                            "2. Отсортировать фамильное дерево по имени\n" +
                            "3. Отсортировать фамильное дерево по дате смерти\n" +
                            "4. Выход");
            n = scanner.nextInt();
        }
        return n;
    }

    @Override
    public void setPresenter(Presenter<T> presenter) {
        this.presenter = presenter;
    }

    @Override
    public int start() throws ClassNotFoundException, IOException {
        int number = scan();
        String str = scanner.nextLine();
        if (number == 1) {
            System.out.println("Введите имя человека: ");
            str = scanner.nextLine();
            presenter.task(number, str);
        } else {
            if (number != 4) {
                print(presenter.task(number, str));
            }
        }
        return number;
    }

    @Override
    public void print(Tree<T> answer) {
        for (T human : answer) {
            System.out.println(human);
        }
    }
}
