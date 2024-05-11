import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dizi = new String[]{
                "Mustafa", "ozturk", "2003", "22", "Mart", "mart", "fenerbahçe",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
                "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "!", "@", "#", "$", "%", "^", "&", "*"


        };

        Random random = new Random();

        List<String> passwords = new ArrayList<>();
        int num, passwordLength;

        System.out.print("Kaç Şifre istiyorsunuz ? ");
        num = scanner.nextInt();
        System.out.print("Şifre Uzunluğu : ");
        passwordLength = scanner.nextInt();

        for (int j = 0; j < num; j++) {
            StringBuilder password = new StringBuilder();
            // Rastgele bir sıralama oluştur
            List<String> shuffledList = shuffleArray(dizi, random);
            // Şifreyi oluştur
            for (String item : shuffledList) {
                if (password.length() < passwordLength) {
                    int charsToAdd = Math.min(item.length(), passwordLength - password.length());
                    password.append(item.substring(0, charsToAdd));
                } else {
                    break;
                }
            }
            // Oluşturulan şifreyi listeye ekle
            passwords.add(password.toString());
        }

        // Oluşturulan şifreleri ekrana yazdır
        System.out.println("Oluşturulan Şifreler:");
        for (String password : passwords) {
            System.out.println(password);
        }
    }

    // Dizi elemanlarını karıştırır
    public static List<String> shuffleArray(String[] array, Random rnd) {
        List<String> shuffledList = new ArrayList<>();
        for (String element : array) {
            shuffledList.add(element);
        }
        for (int i = shuffledList.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Swap
            String temp = shuffledList.get(index);
            shuffledList.set(index, shuffledList.get(i));
            shuffledList.set(i, temp);
        }
        return shuffledList;
    }
}
