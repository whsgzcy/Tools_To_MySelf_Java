package t;

import java.util.ArrayList;
import java.util.List;

public class String2Handle {

	public static List<String> toBus(String str1) {

		List<String> list = new ArrayList<String>();

		// String str1 = "0512-87772520;0512-87772620;18561242573;13771832367";
		// String str1 = "0512-87772520;0512-87772620;18561242573";
		// String str1 = "0512-87772520;0512-87772620";
		// String str1 = "18561242573;13771832367";

		// À¹½ØÒ»¸öºÅÂë
		if (!str1.contains(";")) {
			if (str1.contains("-")) {
				list.add(str1);
				list.add("");
				list.add("");
				list.add("");
			} else {
				list.add("");
				list.add("");
				list.add(str1);
				list.add("");
			}
			System.out.println(list.toString());
			return list;
		}

		for (int i = 0; i < 4; i++) {

			if (str1.equals("")) {
				list.add("");
				continue;
			}

			if (!str1.contains(";")) {
				if (i == 3) {
					list.add(str1);
				} else {
					list.add("");
				}
				continue;
			}

			int m = str1.indexOf(";");
			String n = str1.substring(0, m);
			list.add(n);
			str1 = str1.substring(m + 1, str1.length());
		}

		System.out.println(list.toString());

		String g1 = "";
		String g2 = "";
		String m1 = "";
		String m2 = "";

		for (int m = 0; m < 4; m++) {
			if (list.get(m).contains("-")) {
				if (g1.equals("")) {
					g1 = list.get(m);
				}else if(g2.equals("")){
					g2 = list.get(m);
				}
			}
		}
		
		for (int m = 0; m < 4; m++) {
			if (!list.get(m).contains("-")) {
				if(!list.get(m).equals("")){
					if (m1.equals("")) {
						m1 = list.get(m);
					}else if(m2.equals("")){
						m2 = list.get(m);
					}
				}
			}
		}

		 List<String> list2 = new ArrayList<String>();
		 
		 list2.add(g1);
		 list2.add(g2);
		 list2.add(m1);
		 list2.add(m2);

		 System.out.println(list2.toString());
		 
		 return list2;
	}

	public static void main(String[] args) {
		
		toBus("0512-87772520;0512-87772620");

//		List<String> list = new ArrayList<String>();
//
//		// String str1 = "0512-87772520;0512-87772620;18561242573;13771832367";
//		// String str1 = "0512-87772520;0512-87772620;18561242573";
//		// String str1 = "0512-87772520;0512-87772620";
//		String str1 = "0512-87772520;13771832367";
//
//		// String str1 = "18561242573;13771832367";
//
//		// À¹½ØÒ»¸öºÅÂë
//		if (!str1.contains(";")) {
//			if (str1.contains("-")) {
//				list.add(str1);
//				list.add("");
//				list.add("");
//				list.add("");
//			} else {
//				list.add("");
//				list.add("");
//				list.add(str1);
//				list.add("");
//			}
//			System.out.println(list.toString());
//			return;
//		}
//
//		for (int i = 0; i < 4; i++) {
//
//			if (str1.equals("")) {
//				list.add("");
//				continue;
//			}
//
//			if (!str1.contains(";")) {
//				if (i == 3) {
//					list.add(str1);
//				} else {
//					list.add("");
//				}
//				continue;
//			}
//
//			int m = str1.indexOf(";");
//			String n = str1.substring(0, m);
//			list.add(n);
//			str1 = str1.substring(m + 1, str1.length());
//		}
//
//		System.out.println(list.toString());
//
//		String g1 = "";
//		String g2 = "";
//		String m1 = "";
//		String m2 = "";
//
//		for (int m = 0; m < 4; m++) {
//			if (list.get(m).contains("-")) {
//				if (g1.equals("")) {
//					g1 = list.get(m);
//				}else if(g2.equals("")){
//					g2 = list.get(m);
//				}
//			}
//		}
//		
//		for (int m = 0; m < 4; m++) {
//			if (!list.get(m).contains("-")) {
//				if(!list.get(m).equals("")){
//					if (m1.equals("")) {
//						m1 = list.get(m);
//					}else if(m2.equals("")){
//						m2 = list.get(m);
//					}
//				}
//			}
//		}
//
//		 List<String> list2 = new ArrayList<String>();
//		 
//		 list.add(g1);
//		 list.add(g2);
//		 list.add(m1);
//		 list.add(m2);

		 
		// List<String> list3 = new ArrayList<String>();
		//
		// for (int m = 0; m < 4; m++) {
		// // ×ù»ú
		// if (list.get(m).contains("-")) {
		// list2.add(list.get(m));
		// continue;
		// }
		// }
		//
		// for (int m = 0; m < 4; m++) {
		// // ×ù»ú
		// if (!list.get(m).contains("-")) {
		// if (!list.get(m).equals("")) {
		// list2.add(list.get(m));
		// }
		// continue;
		// }
		// }
		//
		// int size = list2.size();
		// for (int m = size; m < 4; m++) {
		// list2.add("");
		// }
		//
		// // for (int m = 0; m < 4; m++) {
		// //
		// // }
		//
		// System.out.println(list2.toString());

	}

}
