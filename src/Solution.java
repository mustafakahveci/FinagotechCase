import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {
    public static int uniqueWolfs(List<Integer> arr) {
        if (arr.size() < 5 || arr.size() > 200000) {
            throw new IllegalArgumentException("Liste (5 ≤ n ≤ 200000) şartını sağlamıyor..");
        } //liste uzunluğunu kontrol etmek için

        HashMap<Integer, Integer> idCounts = new HashMap<Integer, Integer>();
        //key:id value;adet bilgisini içeren boş hashmap

        for (int id : arr) {
            if (id < 1 || id > 5) {
                throw new IllegalArgumentException("(1,2,3,4,5)'den farklı ID giremezsiniz.");
            }// 1,2,3,4,5 den farklı ID var mı diye kontrol etmek için

            int count = idCounts.getOrDefault(id, 0) + 1;  //id leri key kabul edip sayılarını hesapladık.
            idCounts.put(id, count); //hashmap'e sıralı şekilde koyduk.
        }

        int maxValue = 0;
        int lowID = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : idCounts.entrySet()) {
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                lowID = entry.getKey();
            }
        } // hashmap'imizi dolaşıp max value'ye göre en küçük ID'yi alan kısım

     return lowID;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("deneme.txt"));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        int result = Result.uniqueWolfs(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
}
}