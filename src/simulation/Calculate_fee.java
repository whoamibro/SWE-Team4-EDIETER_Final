package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_fee {
    // 3째 자리수
    private int numofthirdposition;
    // 3째 자리는 제외한 수
    private int num_remain;
    // 501을 초과했을때 처리를 위한 수
    private int exceed;
    // 목표 금액
    private int goalfee;
    // 전력량요금
    private double basicfee;
    // 부가가치세
    private int tax;
    // 전력산업기반기금
    private int ele_ind_fund;
    // 청구금액
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

    // 전력량 요금 계산
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
        System.out.println("기본요금은 " + basicfee);
        return basicfee;
    }

    // 부가가치세 계산 (원 미만 4사 5입)
    public void taxing(){
        tax = (int) (basicfee * 0.1);
        // for confimation
        System.out.println("부가가치세는 " + tax);
    }

    // 전력산업기반기금 계산 (10원 미만 절사)
    public void cal_elec_industry_fund(){
        double fund = basicfee *0.037;
        // 10원단위 아래 절사
        int rm_first_positon = (int)fund / 10 * 10;
        ele_ind_fund = rm_first_positon;
        // for confirmation
        System.out.println("전력 발전 기금 금액은 " +  ele_ind_fund);
    }

    // 청구요금 계산
    public int cal_total(){
        // 전력량 요금 + 부가가치세 + 전력산업기반기금 = 청구금액
        total_fee = ((int)basicfee + tax + ele_ind_fund ) /10 * 10;
        // for confirmation
        System.out.println("현재까지의 총 금액은 " + total_fee);
        return total_fee;
    }
}
