package MidExamFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03SchoolLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> bookShelf = Arrays.stream(sc.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Done")) {
            String[] inputLine = input.split(" \\| ");
            switch (inputLine[0]) {
                case "Add Book":
                    if (!bookShelf.contains(inputLine[1])) {
                        bookShelf.add(0, inputLine[1]);
                    }
                    break;
                case "Take Book":
                    if (bookShelf.contains(inputLine[1])) {
                        bookShelf.remove(inputLine[1]);
                    }
                    break;
                case "Swap Books":
                    int bookOne = bookShelf.indexOf(inputLine[1]);
                    int bookTwo = bookShelf.indexOf(inputLine[2]);
                    if (bookShelf.contains(inputLine[1]) && bookShelf.contains(inputLine[2])) {
                        String memory = bookShelf.get(bookOne);
                        bookShelf.set(bookOne, bookShelf.get(bookTwo));
                        bookShelf.set(bookTwo, memory);
                    }
                    break;
                case "Insert Book":
                    if (!bookShelf.contains(inputLine[1])) {
                        bookShelf.add(inputLine[1]);
                    }
                    break;
                case "Check Book":
                    int indexOfBook = Integer.parseInt(inputLine[1]);
                    if (indexOfBook >= 0 && indexOfBook < bookShelf.size()) {
                        System.out.println(bookShelf.get(indexOfBook));
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < bookShelf.size(); i++) {
            if (i == bookShelf.size()-1) {
                System.out.print(bookShelf.get(bookShelf.size()-1));
            } else {
                System.out.print(bookShelf.get(i) + ", ");
            }
        }
    }
}
