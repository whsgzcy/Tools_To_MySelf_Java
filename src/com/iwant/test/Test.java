package com.iwant.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
    private static TT tt = new TT();
	
	// 设置数据
    public void setData() {
        List<TT.DatasBean> mDatasBeanList = new ArrayList<TT.DatasBean>();
        for (int i = 0; i < 3; i++) {
            TT.DatasBean t = new TT.DatasBean();
            List<TT.DatasBean.DataBean> tList = new ArrayList<TT.DatasBean.DataBean>();

            if (i == 0) {
                t.setDepart("门诊部");
            } else if (i == 1) {
                t.setDepart("卫生部");
            } else if (i == 2) {
                t.setDepart("研发部");
            }
            
            for (int m = 0; m < 3; m++) {
                TT.DatasBean.DataBean d = new TT.DatasBean.DataBean();
                if (i == 0) {
                    d.setName("A" + m + 1);
                } else if (i == 1) {
                    d.setName("B" + m + 1);
                } else if (i == 2) {
                    d.setName("C" + m + 1);
                }
                tList.add(d);
            }
            t.setData(tList);
            mDatasBeanList.add(t);
        }
        tt.setName("测试数据");
        tt.setDatas(mDatasBeanList);
    }
    
    public static void main(String[] args) {
//    	Test t = new Test();
//    	t.setData();
//    	System.out.println(tt.getName().toString());
    	
    	String wayPointName = "nihao";
    	
    	String msg = "{" + "\"op\": \"public\"," + "\"topic\": \"/move_base/cancel\"," + "\"msg\": {" + "\"stamp\": \"0\"," + "\"id\":" + "\""+wayPointName +"\"" +"}" + "}";
    	
    	System.out.println(msg);
    	
    	String a = "2018-06-07 15:32:21";
    	String b = "2018-06-07 15:32:21";
    	String c = "2018-06-07 15:32:11";
    	
    	System.out.println(a.equals(b));
    	System.out.println(a.equals(c));
    	
    }

}
