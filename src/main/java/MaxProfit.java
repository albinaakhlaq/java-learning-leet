public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min_price = Integer.MAX_VALUE;
        for (int price:prices)
        {
            if(price < min_price)
                min_price = price;
            else
                maxProfit =Math.max(price - min_price,maxProfit);
        }
        return maxProfit;
    }

}
