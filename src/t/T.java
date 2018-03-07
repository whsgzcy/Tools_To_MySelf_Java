package t;

import java.text.DecimalFormat;

public class T {
	
	
	static void a(String b){
		if(b.equals("1")){
			System.out.println("world");
		}else{
			System.out.println("hello");
			a("1");
		}
	}

	void test1(String mm) throws InterruptedException {
		int i = 0;
		while (mm.equals("ygo") || mm.equals("ngo")) {
			i++;
			Thread.sleep(1000);
			System.out.println(mm);
			if (i > 10) {
				mm = "ygo";
			}
		}
		;
	}

	void test2(String mm) throws InterruptedException {
		int i = 0;
		boolean is = true;
		while (is) {
			i++;
			Thread.sleep(1000);
			System.out.println(mm);
			if (mm.equals("ngo") || mm.equals("ygo")) {
				System.out.println(mm);
				is = false;
			}

			if (i > 10) {
				is = false;
				System.out.println("out");
			}
		}
		;
	}

	public static String msg = "0xB1 0xB2 0xB3 0xB4 0xB5 0xB6 0xB7 0xA8 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00 0x00";

	void lock() {
		String msg1 = msg.replaceAll(" ", "");
		String msg2 = msg1.substring(0, 32);
		String msg3 = msg2.valueOf(3);
		System.out.println(msg3);
	}

	public static boolean isPower(String ok) {

		ok = ok.replaceAll(" ", "");
		ok = ok.substring(0, 32);

		return ok.contains("1");
	}
	
	/**
     * 排除 若 move_base/status 3
     * @param reached
     * @param naving
     */
    public static String compare(String reached, String naving){
        if(reached.contains(naving)){
            if(reached.contains("_map")){

            }else{
                naving = naving + "_map";
            }
        }
        return naving;
    }
    
    public static String toPercent(String num) {
        if (num.equals("")) {
            return "--" + "%";
        }
        DecimalFormat df = new DecimalFormat("######0.0");
        double d = Double.valueOf(num).doubleValue() * 100;
        return df.format(d)  + "%";
    }
    
    public static void nav_ctrl( String name) {

        String json = "{\"op\": \"publish\",\"topic\": \"/nav_ctrl\",\"msg\": {\"control\": 0,\"goal_name\":" + "\"" +name +"\"" +"}}";
        System.out.println(json);
    }

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(toPercent("0.58"));
		
		nav_ctrl("cao");

		// T t = new T();
		// t.lock();

		// System.out.println(isPower(msg));

		// String msg = "power_78";
		//
		// int i = msg.indexOf("_");
		// int l = msg.length();
		//
		// System.out.println(msg.substring(i+1, l));

		// String msg = "123456";
		// System.out.println(msg.replace("C", ""));
		// System.out.println(msg.replaceFirst("C", ""));

		//{"position":{"z":6.747459214639928E-6,"x":-1.6425935884653398,"y":-4.383863426379336}}
		//{"position":{"z":0.0026421806146105647,"x":-0.06227523162422072,"y":-0.027651923778382936}}
		//{"position":{"z":7.133402698453195E-5,"x":-0.27111717537792224,"y":-0.020722042252648648}}
		
//		{"position":{"z":-3.506483755589401E-5,"x":-1.6335755252535962,"y":-4.4024164741998755}}
//		{"position":{"z":-3.493245948923973E-5,"x":-1.6335835196984463,"y":-4.4024238026605085}}
		
	   double A1 = -1.6335755252535962;
	   double A2 = -4.4024164741998755;
	   double A3 = -3.506483755589401E-5;
	   
//	   double B1 = -4.47474;
//	   double B2 = -0.99462;
//	   double B3 = -0.00011829;
	   
//	   {"orientation":{"z":-0.025523612486267857,"x":2.709426068657001E-4,"w":0.9996741600167522,"y":2.1351944980778606E-4},"position":{"z":7.13677498373061E-5,"x":-0.2711451661961892,"y":-0.020697573178632064}}
	   double B1 = -1.6335835196984463;
	   double B2 = -4.4024238026605085;
	   double B3 = -3.493245948923973E-5;
	   
//	   double B1 = 0;
//	   double B2 = 0;
//	   double B3 = 0;
	   
//	   double B1 = -3.7155258893031515;
//	   double B2 = -1.422908809928636;
//	   double B3 = 0;
	   
//	   double B1 = 2.5085357302011235;
//	   double B2 = 15.89195773995525410;
//	   double B3 = 0;
	   
	   double AX;
	   double AY;
	   double AZ;
	   
	   double A;
	   
	   AX = A1-B1;
	   AX = AX * AX;
	   
	   AY = A2-B2;
	   AY = AY * AY;
	   
	   AZ = A3-B3;
	   AZ = AZ * AZ;
	   
	   A = AX + AY + AZ;
	   
	   System.out.println(Math.sqrt(A));
	   
	   System.out.println(compare("map_4_O_000","map_4_A_402"));
	   
	   a("2");
	     

	}

}
