import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        int doorChange = 0;
        int withoutChangingTheDoor = 0;
        int quantity = 1000;

        Random random = new Random();
        Map<Integer, String> results = new HashMap<>();

        for (int i = 0; i < quantity; i++) {
            int carDoor = random.nextInt(3);
            int playerChoice = random.nextInt(3);
            int hostChoice = -1;

            for (int j = 0; j < 3; j++) {
                if (j != carDoor && j != playerChoice) {
                    hostChoice = j;
                    break;
                }
            }

            int remainingDoor = -1;
            for (int j = 0; j < 3; j++) {
                if (j != playerChoice && j != hostChoice) {
                    remainingDoor = j;
                    break;
                }
            }

            if (remainingDoor == carDoor) {
                doorChange++;
                results.put(i, "Победа при смене двери");
            } else if (playerChoice == carDoor) {
                withoutChangingTheDoor++;
                results.put(i, "Победа без смены двери");
            } else {
                results.put(i, "Поражение");
            }
        }

        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Попытка " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Количество выигрышей при смене двери: " + doorChange);
        System.out.println("Количество выигрышей без смены двери: " + withoutChangingTheDoor);
    }
}
