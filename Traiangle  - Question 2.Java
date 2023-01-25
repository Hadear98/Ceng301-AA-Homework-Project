// 1st and 2nd codes couldn't be run in an online compiler because they need registered files that is why we couldn't provide an online link
import java.util.List;
import java.util.ArrayList;

public class Triangle {
    public static List<Integer> maxPerimeterTriangle(List<Integer> lines) {
        int max_perimeter = 0;
        List<Integer> max_triangle = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                for (int k = j + 1; k < lines.size(); k++) {
                    int a = lines.get(i), b = lines.get(j), c = lines.get(k);
                    if (a + b > c && a + c > b && b + c > a) {
                        int perimeter = a + b + c;
                        if (perimeter > max_perimeter) {
                            max_perimeter = perimeter;
                            max_triangle = List.of(a, b, c);
                        }
                    }
                }
            }
        }
        return max_triangle;
    }
}