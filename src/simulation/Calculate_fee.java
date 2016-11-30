package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_fee {
    // 3rd position
    private int numofthirdposition;
    // except 3rdposition
    private int num_remain;
    // if exceed 501kwh
    private int exceed;
    // goal fee
    private int goalfee;
    // basic electric fee
    private double basicfee;
    // tax
    private int tax;
    // electric industry fund
    private int ele_ind_fund;
    // total fee
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

    // calculate electric basic fee
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
        System.out.println("basic fee : " + basicfee);
        return basicfee;
    }

    // calculate tax
    public int taxing(){
        tax = (int) (basicfee * 0.1);
        // for confimation
        System.out.println("tax : " + tax);
        return tax;
    }

    // calculate electric industry fund
    public int cal_elec_industry_fund(){
        double fund = basicfee *0.037;
        // 10?��?��?�� ?��?�� ?��?��
        int rm_first_positon = (int)fund / 10 * 10;
        ele_ind_fund = rm_first_positon;
        // for confirmation
        System.out.println("electric industry fund : " +  ele_ind_fund);
        return ele_ind_fund; 
    }

    // �?구요�? 계산
    public int cal_total(){
        // ?��?��?�� ?���? + �?�?�?치세 + ?��?��?��?��기반기금 = �?구금?��
        total_fee = ((int)basicfee + tax + ele_ind_fund ) /10 * 10;
        // for confirmation
        System.out.println("total fee : " + total_fee);
        return total_fee;
    }
}
