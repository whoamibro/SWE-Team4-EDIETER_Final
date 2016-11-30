package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_fee {
    // 3�? ?��리수
    private int numofthirdposition;
    // 3�? ?��리는 ?��?��?�� ?��
    private int num_remain;
    // 501?�� 초과?��?��?�� 처리�? ?��?�� ?��
    private int exceed;
    // 목표 금액
    private int goalfee;
    // ?��?��?��?���?
    private double basicfee;
    // �?�?�?치세
    private int tax;
    // ?��?��?��?��기반기금
    private int ele_ind_fund;
    // �?구금?��
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

    // ?��?��?�� ?���? 계산
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
        System.out.println("기본?��금�? " + basicfee);
        return basicfee;
    }

    // �?�?�?치세 계산 (?�� 미만 4?�� 5?��)
    public void taxing(){
        tax = (int) (basicfee * 0.1);
        // for confimation
        System.out.println("�?�?�?치세?�� " + tax);
    }

    // ?��?��?��?��기반기금 계산 (10?�� 미만 ?��?��)
    public void cal_elec_industry_fund(){
        double fund = basicfee *0.037;
        // 10?��?��?�� ?��?�� ?��?��
        int rm_first_positon = (int)fund / 10 * 10;
        ele_ind_fund = rm_first_positon;
        // for confirmation
        System.out.println("?��?�� 발전 기금 금액?? " +  ele_ind_fund);
    }

    // �?구요�? 계산
    public int cal_total(){
        // ?��?��?�� ?���? + �?�?�?치세 + ?��?��?��?��기반기금 = �?구금?��
        total_fee = ((int)basicfee + tax + ele_ind_fund ) /10 * 10;
        // for confirmation
        System.out.println("?��?��까�??�� �? 금액?? " + total_fee);
        return total_fee;
    }
}
