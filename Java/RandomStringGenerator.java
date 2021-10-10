import java.util.Random;

class RandomStringGenerator {
    public static void main(String[] args) {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder stringBuilder = new StringBuilder();
        Random randomNum = new Random();

        int stringLength = 20;

        for(int i = 0; i < stringLength; i++) {
            int index = randomNum.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            stringBuilder.append(randomChar);
        }

        String randomString = stringBuilder.toString();
        System.out.println("Generated Random String : " + randomString);

    }
}
