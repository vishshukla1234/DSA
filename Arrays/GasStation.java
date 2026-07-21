public class GasStation {
        public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int reqGas = 0;
        int availGas = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            reqGas += cost[i];
        }
        if(reqGas > totalGas) return -1;
        int start = 0;
        for(int j = 0; j < gas.length; j++) {
            availGas += gas[j]-cost[j];
            if(availGas<0) {
                start = j+1;
                availGas = 0;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}