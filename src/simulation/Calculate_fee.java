package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_fee {
    // 3ì§? ?ë¦¬ìˆ˜
    private int numofthirdposition;
    // 3ì§? ?ë¦¬ëŠ” ? œ?™¸?•œ ?ˆ˜
    private int num_remain;
    // 501?„ ì´ˆê³¼?–ˆ?„?•Œ ì²˜ë¦¬ë¥? ?œ„?•œ ?ˆ˜
    private int exceed;
    // ëª©í‘œ ê¸ˆì•¡
    private int goalfee;
    // ? „? ¥?Ÿ‰?š”ê¸?
    private double basicfee;
    // ë¶?ê°?ê°?ì¹˜ì„¸
    private int tax;
    // ? „? ¥?‚°?—…ê¸°ë°˜ê¸°ê¸ˆ
    private int ele_ind_fund;
    // ì²?êµ¬ê¸ˆ?•¡
    private int total_fee;


    public void setNumofthirdposition(int numofthirdposition, int exceed) {
        this.numofthirdposition = numofthirdposition;
        this.exceed = exceed;
    }

    public void setNum_remain(int num_remain) {
        this.num_remain = num_remain;
    }

    public void setGoalfee(int goalfee) {
        this.goalfee = goalfee;
    }

    // ? „? ¥?Ÿ‰ ?š”ê¸? ê³„ì‚°
    public double cal_Basic_Fee(){
        switch(numofthirdposition){
            // 0 ~ 100 kWh
            case 0:
                basicfee = 410 + num_remain*60.7;
                break;
            // 101 ~ 200 kWh
            case 1 :
                basicfee = 910 + 100*60.7 + num_remain*125.9;
                break;
            // 201 ~ 300 kWh
            case 2 :
                basicfee = 1600 + 100*60.7 + 100*125.9 + num_remain*187.9;
                break;
            // 301 ~ 400 kWh
            case 3 :
                basicfee = 3850 + 100*60.7 + 100*125.9 + 100*187.9 + num_remain*280.6;
                break;
            // 401 ~ 500 kWh
            case 4 :
                basicfee = 7300 + 100*60.7 + 100*125.9 + 100*187.9 + 100*280.6 + num_remain*417.7;
                break;
            // 501 ~
            case 5 :
                basicfee = 12940 + 100*60.7 + 100*125.9 + 100*187.9 + 100*280.6 + 100*417.7 + ((exceed-5)*100 + num_remain)*709.5;
                break;
        }
        // for confirmation
        System.out.println("ê¸°ë³¸?š”ê¸ˆì? " + basicfee);
        return basicfee;
    }

    // ë¶?ê°?ê°?ì¹˜ì„¸ ê³„ì‚° (?› ë¯¸ë§Œ 4?‚¬ 5?…)
    public void taxing(){
        tax = (int) (basicfee * 0.1);
        // for confimation
        System.out.println("ë¶?ê°?ê°?ì¹˜ì„¸?Š” " + tax);
    }

    // ? „? ¥?‚°?—…ê¸°ë°˜ê¸°ê¸ˆ ê³„ì‚° (10?› ë¯¸ë§Œ ? ˆ?‚¬)
    public void cal_elec_industry_fund(){
        double fund = basicfee *0.037;
        // 10?›?‹¨?œ„ ?•„?˜ ? ˆ?‚¬
        int rm_first_positon = (int)fund / 10 * 10;
        ele_ind_fund = rm_first_positon;
        // for confirmation
        System.out.println("? „? ¥ ë°œì „ ê¸°ê¸ˆ ê¸ˆì•¡?? " +  ele_ind_fund);
    }

    // ì²?êµ¬ìš”ê¸? ê³„ì‚°
    public int cal_total(){
        // ? „? ¥?Ÿ‰ ?š”ê¸? + ë¶?ê°?ê°?ì¹˜ì„¸ + ? „? ¥?‚°?—…ê¸°ë°˜ê¸°ê¸ˆ = ì²?êµ¬ê¸ˆ?•¡
        total_fee = ((int)basicfee + tax + ele_ind_fund ) /10 * 10;
        // for confirmation
        System.out.println("?˜„?¬ê¹Œì??˜ ì´? ê¸ˆì•¡?? " + total_fee);
        return total_fee;
    }
}
