import java.util.ArrayList;
import java.util.List;

public class FirstMissingPositive {
    public static int findSmallestMissingPositive(List<Integer> orderNumbers) {
        if(orderNumbers.size()==1 || orderNumbers.isEmpty()) {
            return 1;
        }
    // Write your code here
        for(int i = 0; i < orderNumbers.size(); i++) {
            if(i+1 != orderNumbers.get(i)) {
                int curr = orderNumbers.get(i);

                int temp = orderNumbers.get(i);
                orderNumbers.set(i, orderNumbers.get(curr - 1));
                orderNumbers.set(curr - 1, temp);
            }
        }
        
        int i = orderNumbers.size()-1;
        while(i >= 0) {
            if(orderNumbers.get(i) != i+1) {
                return i+1;
            }
            i--;
        }
        return i+1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(findSmallestMissingPositive(list));
    }
}
