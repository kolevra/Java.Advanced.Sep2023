import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test {

    private static String TEST_INPUTS = "------------\n" +
                                        "------D-----\n" +
                                        "--T---------\n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(TEST_INPUTS);

//        Map<String, Integer> map = new HashMap<>();
//        map.put("Z", 12);
//        map.put("T", 7);
//        map.put("U", 12);
//        map.put("A", 19);
//        map.put("H", 1);
//
//        map.entrySet()
//                .stream()
//                .sorted((e1, e2) -> {
//                    int res = Integer.compare(e1.getValue(), e2.getValue());
//                    if(res == 0){
//                        res = e1.getKey().compareTo(e2.getKey());
//                    }
//                    return res;
//                });


//        int[] numbers = new int[]{15, 14, 6, 28, 4, 35, 24, 34};
//        int[] sorting = new int[40];
//
//        for (int n : numbers){
//            sorting[n]++;
//        }
//
//        for (int index = 0; index < sorting.length; index++) {
//            if(sorting[index] != 0){
//                for (int i = 0; i < sorting[index]; i++) {
//                    System.out.println(index + " ");
//                }
//            }
//        }

        List<Integer> list = List.of(13, 145, 65, 32, 16);

        list.stream()
            .map(e -> e*2)	// .map(e -> (Integer) e*2)
            .forEach(System.out::println);





    }
}
