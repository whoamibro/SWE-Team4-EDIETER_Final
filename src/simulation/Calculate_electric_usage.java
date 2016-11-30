package simulation;

import controller.ProductController;

import java.util.Calendar;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_electric_usage {
    Calendar day = Calendar.getInstance();

    // forë¬¸ì„ ?Œë¦¬ê¸° ?œ„?•œ arraylist?˜ sizeë¥? ?‹´ê³? ?ˆ?Š” ë³??ˆ˜
    private int productCount;

    // ? „? ¥?‚¬?š©?Ÿ‰?„ ?‹´ê¸? ?œ„?•œ ë³??ˆ˜
    private double total_usage;

    // ?´ë²ˆë‹¬ ?˜ˆ?ƒ ? „? ¥?‚¬?š©?Ÿ‰?„ ?‹´ê¸? ?œ„?•œ ë³??ˆ˜
    private double expect_total_usage;

    // ?˜„?¬ê¹Œì??˜ ? „? ¥?‚¬?š©?Ÿ‰?„ ê³„ì‚°?•˜ê¸? ?œ„?•œ ?š”?¼ ë³??ˆ˜
    private int date_of_month = day.get(day.DAY_OF_MONTH);

    // ?˜„?¬ ?‹¬?˜ ë§ˆì?ë§? ?‚ ì§œë?? êµ¬í•¨
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

    // static productlistë³??ˆ˜ë¥? ì°¸ì¡°?•´?„œ ê·? sizeë¥? productCountë³??ˆ˜?— ?‹´?Š”?‹¤.
    public void setProductCount() {
        this.productCount = ProductController.productList.size();
    }

    // productcontrollerë¥? ?†µ?•´?„œ productlist?— ?ˆ?Š” product?“¤?„ ëª¨ë‘ ë°›ì•„???„œ 1?¼ë¶??„° ?•´?‹¹ ?¼ ê¹Œì? ?¼ë³? ?‚¬?š©?Ÿ‰ * ?†Œë¹„ì „? ¥?„ ?†µ?•´ ?–¼ë§ˆë‚˜ ? „? ¥?„ ?‚¬?š©?• ì§? ?˜ˆ?ƒ?•˜?Š” ë©”ì†Œ?“œ
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

    // productcontrollerë¥? ?†µ?•´?„œ productlist?— ?ˆ?Š” product?“¤?„ ëª¨ë‘ ë°›ì•„???„œ ?•´?‹¹ ?‹¬?™?•ˆ ?¼ë³? ?‚¬?š©?Ÿ‰ * ?†Œë¹„ì „? ¥?„ ?†µ?•´ ?–¼ë§ˆë‚˜ ? „? ¥?„ ?‚¬?š©?• ì§? ?˜ˆ?ƒ?•˜?Š” ë©”ì†Œ?“œ
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
