package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();

        // Adding some data
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));

        System.out.println(countMatches(items, "type", "phone"));
    }
    static public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> 0;
        };
        int count = 0;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
