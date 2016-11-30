package simulation;

import controller.ProductController;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_tem_plan {
    // cal
    private double kcal;
    // temperature variation
    private int delta_t;
    // square meter of house
    private double squaremeter;
    // volume of house
    private double V;
    // mass of air in the house
    private double m;
    // specific heat of air
    private double C = 0.716;
    // kelvin temperature
    private double K;
    // kwh
    private double kwh;
    // cool or heat power of airconditioner
    private double cool_heatpower;
    // remainday of this month
    private int remainday;
    // simulation result
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
    // change degrees celcius to kelvin temperature
    public void setK(double c) {
        K = c + 273.15;
    }
    // calculate volume of house air
    public double calculate_volume(){
        // 2 is interlayer height - thickness of wall
        V = squaremeter * 2 * 1000;
        // get mass of house air
        m = 1 * V /( 0.082057 * K )* 28.7 ;
        System.out.printf("Volume of User's space \t\t\t\t: %.2f liter\n",V);
        System.out.printf("Kelvin temperature of User's space \t\t\t\t: %.2f k\n",K);
        System.out.printf("Mass of User's space\t: %.2f g\n",m);
        return m;
    }
    // calculate calorie
    public double calculate_cal(){
        kcal = C * m * delta_t / 1000;
        return kcal;
    }
    // calculate calorie to wat
    public double calculate_w(){
        double result;
        kwh = kcal/861;
        // for confirmation
        System.out.printf("?��망하?�� ?��?���? ?��추거?�� ?��리기까�? ?��?��?�� ?��?���??�� ?��(cal?�� kwh�? �??��?��) : %.2f kwh\n",kwh);
        return result = kwh;
    }
    // kwh?�� ???��?�� ?��?��방기?�� ?��?��?�� ??비시켜서 ?��?? ?��?�� ?��?�� 몇시간을 ?�� 추�?�? ?��?��?�� ?�� ?��?���? ?��?���?
    public void calculate_t(){
        int length = ProductController.productList.size();
        double time;
        double timeperday;
        for(int i=0; i<length; i++){
            if(ProductController.productList.get(i).getType() == "Airconditioner"){
                cool_heatpower = ProductController.productList.get(i).getCool_heatpower();
                System.out.printf("?��?��?���? 보유?�� ?��?��방기?�� ?���?<?��??>?��방전?�� : %.2f\n",cool_heatpower);
            }
        }
        time = simul_result/cool_heatpower;
        timeperday = time/remainday;
        // for confirmation
        System.out.printf("?��뮬레?��?�� 결과 ?��번달 ?���? ?��?��방기�? ?? ?�� ?��?�� �? ?���? : %.2f\n", time);
        System.out.printf("?���? 추�?�? ?��?��방기�? ?? ?�� ?��?�� ?���? : %.2f\n", timeperday);
    }
}
