package search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MinimumLoss {

    private static class Price{
        int year;
        long price;

        public Price(int year, long price) {
            this.year = year;
            this.price = price;
        }

        public long getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Price> priceList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++){
            priceList.add(new Price(i, in.nextLong()));
        }
        priceList.sort(Comparator.comparingLong(Price::getPrice));
        long loss = Long.MAX_VALUE;
        for(int i = 0; i < priceList.size()-1; i++){
            if(priceList.get(i).year > priceList.get(i+1).year
                    && priceList.get(i+1).price > priceList.get(i).price
                    && loss > (priceList.get(i+1).price - priceList.get(i).price)){
                loss = priceList.get(i+1).price - priceList.get(i).price;
            }
        }
        System.out.println(loss);
    }

}
