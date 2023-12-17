

import java.util.Scanner;

public class P01ExperienceGaining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double neededExperience = Double.parseDouble(sc.nextLine());
        int countOfBattles = Integer.parseInt(sc.nextLine());
        double collectedExperience = 0;
        int numberOfBattles = 0;

        for (int i = 1; i <= countOfBattles; i++) {
            double currentBattleExp = Double.parseDouble(sc.nextLine());
            if (i%3 == 0) {
                currentBattleExp += currentBattleExp*0.15;
            } else if (i%5 == 0) {
                currentBattleExp -= currentBattleExp*0.1;
            } else if (i%15 == 0) {
                currentBattleExp += currentBattleExp*0.05;
            }
            collectedExperience += currentBattleExp;
            if (collectedExperience >= neededExperience) {
                numberOfBattles = i;
                break;
            }
        }
        if (collectedExperience >= neededExperience) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", numberOfBattles);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",
                    neededExperience - collectedExperience);
        }
    }
}
