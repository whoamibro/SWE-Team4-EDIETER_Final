package simulation;

import controller.ProductController;

import java.util.Calendar;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_electric_usage {
    Calendar day = Calendar.getInstance();

    // for문을 ?��리기 ?��?�� arraylist?�� size�? ?���? ?��?�� �??��
    private int productCount;

    // ?��?��?��?��?��?�� ?���? ?��?�� �??��
    private double total_usage;

    // ?��번달 ?��?�� ?��?��?��?��?��?�� ?���? ?��?�� �??��
    private double expect_total_usage;

    // ?��?��까�??�� ?��?��?��?��?��?�� 계산?���? ?��?�� ?��?�� �??��
    private int date_of_month = day.get(day.DAY_OF_MONTH);

    // ?��?�� ?��?�� 마�?�? ?��짜�?? 구함
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

    // static productlist�??���? 참조?��?�� �? size�? productCount�??��?�� ?��?��?��.
    public void setProductCount() {
        this.productCount = ProductController.productList.size();
    }

    // productcontroller�? ?��?��?�� productlist?�� ?��?�� product?��?�� 모두 받아???�� 1?���??�� ?��?�� ?�� 까�? ?���? ?��?��?�� * ?��비전?��?�� ?��?�� ?��마나 ?��?��?�� ?��?��?���? ?��?��?��?�� 메소?��
    public double calc_ele_cur_usage(){
        for(int i=0;i<productCount;i++){
            total_usage += ProductController.productList.get(i).getPower()*
                    ProductController.productList.get(i).getUsingTime()*
                    date_of_month;
        }
        return total_usage;
    }

    // productcontroller�? ?��?��?�� productlist?�� ?��?�� product?��?�� 모두 받아???�� ?��?�� ?��?��?�� ?���? ?��?��?�� * ?��비전?��?�� ?��?�� ?��마나 ?��?��?�� ?��?��?���? ?��?��?��?�� 메소?��
    public double cal_ele_expect_usage() {
        for (int i = 0; i < productCount; i++) {
            expect_total_usage += ProductController.productList.get(i).getPower() *
                    ProductController.productList.get(i).getUsingTime() *
                    lastdate_of_month;
        }
        return expect_total_usage;
    }

}
