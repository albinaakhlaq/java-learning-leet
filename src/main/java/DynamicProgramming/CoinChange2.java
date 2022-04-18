package DynamicProgramming;

public class CoinChange2 {
        public int change(int amount, int[] coins) {
            int count =0;
            return dpChange(amount,coins,count);
        }

        public int dpChange(int amount, int[] coins,int count) {
            if (amount == 0) return 1;
            if (amount < 0) return 0;
            for(int coin : coins)
            {
                int remainder =amount-coin;
                int result =dpChange(remainder,coins,count);
                if (result ==1) {
                    count++;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        CoinChange2 change = new CoinChange2();
        int[] coins ={1,2,5};
        System.out.println("output : "+change.change(5,coins));
    }

}
