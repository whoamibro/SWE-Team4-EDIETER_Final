package simulation;

import controller.ProductController;

import java.util.Calendar;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 63
 */
public class Calculate_electric_usage {
    Calendar day = Calendar.getInstance();

 // for문을 돌리기 위한 arraylist의 size를 담고 있는 변수
    private int productCount;

 // 전력사용량을 담기 위한 변수
    private double total_usage;

 // 이번달 예상 전력사용량을 담기 위한 변수
    private double expect_total_usage;

 // 현재까지의 전력사용량을 계산하기 위한 요일 변수
    private int date_of_month = day.get(day.DAY_OF_MONTH);

 // 현재 달의 마지막 날짜를 구함
    private int lastdate_of_month = day.getActualMaximum(Calendar.DATE);

    public int getDate_of_month() {
        return date_of_month;
    }

    public int getLastdate_of_month() {
        return lastdate_of_month;
    }

    public int getProductCount() {
        return productCount;
    }

 // static productlist변수를 참조해서 그 size를 productCount변수에 담는다.
    public void setProductCount() {
        this.productCount = ProductController.productList.size();
        
    }

    // productcontroller를 통해서 productlist에 있는 product들을 모두 받아와서 1일부터 해당 일 까지 일별 사용량 * 소비전력을 통해 얼마나 전력을 사용할지 예상하는 메소드
    public double calc_ele_cur_usage(){
        for(int i=0;i<productCount;i++){
            total_usage += ProductController.productList.get(i).getPower()*
                    ProductController.productList.get(i).getUsingTime()*
                    date_of_month;
            System.out.println(ProductController.productList.get(i).getPower() + " " + ProductController.productList.get(i).getUsingTime());
          System.out.println(total_usage);
        }
        System.out.println(total_usage);
        return total_usage;
    }

    // productcontroller를 통해서 productlist에 있는 product들을 모두 받아와서 해당 달동안 일별 사용량 * 소비전력을 통해 얼마나 전력을 사용할지 예상하는 메소드
    public double cal_ele_expect_usage() {
        for (int i = 0; i < productCount; i++) {
            expect_total_usage += ProductController.productList.get(i).getPower() *
                    ProductController.productList.get(i).getUsingTime() *
                    lastdate_of_month;
          System.out.println(ProductController.productList.get(i).getPower() + " " + ProductController.productList.get(i).getUsingTime());
          System.out.println(expect_total_usage);
        }
        return expect_total_usage;
    }

}
