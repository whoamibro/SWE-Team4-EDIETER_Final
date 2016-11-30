package simulation;

import controller.ProductController;

import java.util.Calendar;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_electric_usage {
    Calendar day = Calendar.getInstance();

    // forλ¬Έμ ?λ¦¬κΈ° ?? arraylist? sizeλ₯? ?΄κ³? ?? λ³??
    private int productCount;

    // ? ? ₯?¬?©?? ?΄κΈ? ?? λ³??
    private double total_usage;

    // ?΄λ²λ¬ ?? ? ? ₯?¬?©?? ?΄κΈ? ?? λ³??
    private double expect_total_usage;

    // ??¬κΉμ?? ? ? ₯?¬?©?? κ³μ°?κΈ? ?? ??Ό λ³??
    private int date_of_month = day.get(day.DAY_OF_MONTH);

    // ??¬ ?¬? λ§μ?λ§? ? μ§λ?? κ΅¬ν¨
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

    // static productlistλ³??λ₯? μ°Έμ‘°?΄? κ·? sizeλ₯? productCountλ³??? ?΄??€.
    public void setProductCount() {
        this.productCount = ProductController.productList.size();
    }

    // productcontrollerλ₯? ?΅?΄? productlist? ?? product?€? λͺ¨λ λ°μ??? 1?ΌλΆ??° ?΄?Ή ?Ό κΉμ? ?Όλ³? ?¬?©? * ?λΉμ ? ₯? ?΅?΄ ?Όλ§λ ? ? ₯? ?¬?©? μ§? ???? λ©μ?
    public double calc_ele_cur_usage(){
        // confirmation code
//        System.out.println(lastdate_of_month);
        for(int i=0;i<productCount;i++){
            total_usage += ProductController.productList.get(i).getPower()*
                    ProductController.productList.get(i).getUsingTime()*
                    date_of_month;
            // confirmation code
//            System.out.println(ProductController.productList.get(i).getPower() + " " + ProductController.productList.get(i).getUsingTime());
//            System.out.println(total_usage);
        }
        //confirmation code
//        System.out.println(total_usage);
        return total_usage;
    }

    // productcontrollerλ₯? ?΅?΄? productlist? ?? product?€? λͺ¨λ λ°μ??? ?΄?Ή ?¬?? ?Όλ³? ?¬?©? * ?λΉμ ? ₯? ?΅?΄ ?Όλ§λ ? ? ₯? ?¬?©? μ§? ???? λ©μ?
    public double cal_ele_expect_usage() {
        // confirmation code
//        System.out.println(lastdate_of_month);
        for (int i = 0; i < productCount; i++) {
            expect_total_usage += ProductController.productList.get(i).getPower() *
                    ProductController.productList.get(i).getUsingTime() *
                    lastdate_of_month;
            // confirmation code
//            System.out.println(ProductController.productList.get(i).getPower() + " " + ProductController.productList.get(i).getUsingTime());
//            System.out.println(expect_total_usage);
        }
        // confirmation code
//        System.out.println(expect_total_usage);
        return expect_total_usage;
    }

}
