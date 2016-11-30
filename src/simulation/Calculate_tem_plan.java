package simulation;

import controller.ProductController;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_tem_plan {
    // cal
    private double kcal;
    // ?˜¨?„?˜ ë³??™”?Ÿ‰
    private int delta_t;
    // ?‹¨?œ„ ë©´ì 
    private double squaremeter;
    // ê³µê°„(ë¶??”¼)
    private double V;
    // ê³µê°„?— ì°¨ìˆ?Š” ê³µê¸°?— ???•œ ì§ˆëŸ‰
    private double m;
    // ê³µê¸°?˜ ë¹„ì—´
    private double C = 0.716;
    // ì¼ˆë¹ˆ?˜¨?„
    private double K;
    // ?ƒ‰ë°©ì „? ¥ ë°? ?‚œë°©ì „? ¥
    private double kwh;
    // ?—?–´ì»¨ì˜ ?ƒ‰?‚œë°? ? „? ¥
    private double cool_heatpower;
    // ?´ë²ˆë‹¬ ë§ì¼ ê¹Œì? ?‚¨?? ?¼?ˆ˜
    private int remainday;
    // ?‹œë®¬ë ˆ?´?…˜ ê²°ê³¼ ?‚¨?? ? „? ¥?Ÿ‰ ë°›ì•„?˜´
    private double simul_result;
    public void setSimul_result(double simul_result){
        this.simul_result = simul_result;
    }

    public int getDelta_t() {
        return delta_t;
    }

    public void setDelta_t(int delta_t) {
        this.delta_t = delta_t;
    }

    public double getSquaremeter() {
        return squaremeter;
    }

    public void setSquaremeter(double squaremeter) {
        this.squaremeter = squaremeter*3.3;
    }

    public void setRemainday(int remainday) {
        this.remainday = remainday;
    }

    public double getK() {
        return K;
    }
    // ?…? ¥ë°›ì? ?˜¨?„ë¥? ì¼ˆë¹ˆ?˜¨?„ë¡? ë³??™˜
    public void setK(double c) {
        K = c + 273.15;
    }
    // ë¶??”¼?— ???•œ ê³µê¸°?˜ ì§ˆëŸ‰?„ êµ¬í•˜?Š” ê³¼ì •
    public void calculate_volume(){
        // 2 ?Š” ?•„?ŒŒ?Š¸?˜ ì¸µê°„ ?†’?´ - ë²½ì˜ ?‘ê»? | 1000 ?? m^3?„ literë¡? ë³??™˜
        V = squaremeter * 2 * 1000;
        // n = PV/RT ê°? ? ?š©?œ ê²? ??ê¸°ì•• = 1, ê¸°ì²´?ƒ?ˆ˜ = 0.082057, ëª°ì§ˆ?Ÿ‰?„ g?œ¼ë¡? ë³??™˜ 28.7
        m = 1 * V /( 0.082057 * K )* 28.7 ;
        System.out.printf("?‚¬?š©? ê±°ì£¼ê³µê°„?˜ ë¶??”¼ \t\t\t\t: %.2f liter\n",V);
        System.out.printf("?‚¬?š©? ê±°ì£¼ê³µê°„?˜ ì¼ˆë¹ˆ?˜¨?„\t\t\t\t: %.2f k\n",K);
        System.out.printf("?‚¬?š©? ê±°ì£¼ê³µê°„?— ì¡´ì¬?•˜?Š” ê³µê¸°?˜ ì§ˆëŸ‰\t: %.2f g\n",m);
    }
    // ì¹¼ë¡œë¦¬ë?? ê³„ì‚° ?•˜?Š” ê³¼ì •
    public void calculate_cal(){
        kcal = C * m * delta_t / 1000;
    }
    // cal?‹¨?œ„?˜ ?ˆ˜ì¹˜ë?? Kwhë¡? ë³??™˜
    public double calculate_w(){
        double result;
        kwh = kcal/861;
        // for confirmation
        System.out.printf("?¬ë§í•˜?Š” ?˜¨?„ë¡? ?‚®ì¶”ê±°?‚˜ ?˜¬ë¦¬ê¸°ê¹Œì? ?•„?š”?•œ ?—?„ˆì§??˜ ?Ÿ‰(cal?„ kwhë¡? ë³??™˜?•¨) : %.2f kwh\n",kwh);
        return result = kwh;
    }
    // kwh?— ???•´?„œ ?ƒ‰?‚œë°©ê¸°?˜ ? „? ¥?„ ??ë¹„ì‹œì¼œì„œ ?‚¨?? ?¼?ˆ˜ ?™?•ˆ ëª‡ì‹œê°„ì„ ?” ì¶”ê?ë¡? ?‚¬?š©?•  ?ˆ˜ ?ˆ?Š”ì§? ?•Œ? ¤ì¤?
    public void calculate_t(){
        int length = ProductController.productList.size();
        double time;
        double timeperday;
        for(int i=0; i<length; i++){
            if(ProductController.productList.get(i).getType() == "Airconditioner"){
                cool_heatpower = ProductController.productList.get(i).getCool_heatpower();
                System.out.printf("?‚¬?š©?ê°? ë³´ìœ ?•œ ?ƒ‰?‚œë°©ê¸°?˜ ?ƒ‰ë°?<?˜¹??>?‚œë°©ì „? ¥ : %.2f\n",cool_heatpower);
            }
        }
        time = simul_result/cool_heatpower;
        timeperday = time/remainday;
        // for confirmation
        System.out.printf("?‹œë®¬ë ˆ?´?…˜ ê²°ê³¼ ?´ë²ˆë‹¬ ?‚´ë¡? ?ƒ‰?‚œë°©ê¸°ë¥? ?? ?ˆ˜ ?ˆ?Š” ì´? ?‹œê°? : %.2f\n", time);
        System.out.printf("?¼ë³? ì¶”ê?ë¡? ?ƒ‰?‚œë°©ê¸°ë¥? ?? ?ˆ˜ ?ˆ?Š” ?‹œê°? : %.2f\n", timeperday);
    }
}
