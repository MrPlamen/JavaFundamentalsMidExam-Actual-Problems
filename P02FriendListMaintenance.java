package MidExamFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02FriendListMaintenance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> listOfPeople = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Report")) {
            String[] inputLine = input.split(" ");
            switch (inputLine[0]) {
                case "Blacklist":
                    if (listOfPeople.contains(inputLine[1])) {
                        int blacklistWho = listOfPeople.indexOf(inputLine[1]);
                        System.out.printf("%s was blacklisted.%n", listOfPeople.get(blacklistWho));
                        listOfPeople.set(blacklistWho, "Blacklisted");
                    } else {
                        System.out.printf("%s was not found.%n", inputLine[1]);
                    }
                    break;
                case "Error":
                    if (Integer.parseInt(inputLine[1]) >= 0 && Integer.parseInt(inputLine[1]) < listOfPeople.size()
                            && !listOfPeople.get(Integer.parseInt(inputLine[1])).equals("Blacklisted")
                            && !listOfPeople.get(Integer.parseInt(inputLine[1])).equals("Lost")) {
                        System.out.printf("%s was lost due to an error.%n", listOfPeople.get(Integer.parseInt(inputLine[1])));
                        listOfPeople.set(Integer.parseInt(inputLine[1]), "Lost");
                    }
                    break;
                case "Change":
                    int indexInScope = Integer.parseInt(inputLine[1]);
                    if (indexInScope >= 0 && indexInScope < listOfPeople.size()) {
                        System.out.printf("%s changed his username to %s.%n", listOfPeople.get(indexInScope), inputLine[2]);
                        listOfPeople.set(indexInScope, inputLine[2]);
                    }
                    break;
            }
            input = sc.nextLine();
        }
        int blacklistedCount = 0;
        int lostCount = 0;
        for (String name : listOfPeople) {
            if (name.equals("Blacklisted")) {
                blacklistedCount++;
            }
            if (name.equals("Lost")) {
                lostCount++;
            }
        }
        System.out.printf("Blacklisted names: %d%n", blacklistedCount);
        System.out.printf("Lost names: %d%n", lostCount);
        for (String name : listOfPeople) {
            System.out.print(name + " ");
        }
    }
}
