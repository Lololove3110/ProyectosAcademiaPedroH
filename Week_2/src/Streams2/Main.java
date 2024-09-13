package Streams2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
	private static Store[] storeArray = {
            new Store("Store1", "Mac Pro", 5, 3000),
            new Store("Store2", "Windows Surface", 12, 1500),
            new Store("Store3", "HP 640", 8, 800),
            new Store("Store4", "Mac Pro", 15, 3200),
            new Store("Store5", "Windows Surface", 7, 1400),
            new Store("Store6", "HP 640", 11, 900),
            new Store("Store7", "Windows Surface", 6, 1600),
            new Store("Store8", "HP 640", 14, 850),
            new Store("Store9", "Mac Pro", 9, 2800),
            new Store("Store10", "Windows Surface", 13, 1550),
            new Store("Store11", "HP 640", 2, 750),
            new Store("Store12", "Windows Surface", 3, 1450),
            new Store("Store13", "Mac Pro", 18, 3100),
            new Store("Store14", "HP 640", 1, 800),
            new Store("Store15", "Windows Surface", 20, 1700)
    };

    public static void main(String[] args) {

        // Print the initial list of stores
        System.out.println("Initial list of stores:");
        Arrays.stream(storeArray).forEach(System.out::println);

        List<Store> storeList = Arrays.stream(storeArray)
                // 1. Filter stores more than 10 km away
                .filter(s -> s.getDistance() <= 10)
                // 2. Remove stores selling Mac Pro
                .filter(s -> !"Mac Pro".equals(s.getProduct()))
                // 3. Remove stores with very high prices (e.g., more than 1600)
                .filter(s -> s.getPrice() <= 1600)
                // 4. Sort stores by distance from least to greatest
                .sorted(Comparator.comparingInt(Store::getDistance))
                .collect(Collectors.toList());

        // Print the final list of stores after applying filters and sorting
        System.out.println("\nFinal list of stores:");
        storeList.forEach(System.out::println);
    }

}
