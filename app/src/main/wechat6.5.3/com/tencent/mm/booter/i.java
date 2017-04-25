package com.tencent.mm.booter;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;

public final class i {
    public static void run() {
        int i;
        LinkedList linkedList = new LinkedList();
        int a = be.a((Integer) ak.yT().get(19), 0);
        for (i = 0; i < a; i++) {
            afj com_tencent_mm_protocal_c_afj = new afj();
            com_tencent_mm_protocal_c_afj.itH = 31;
            com_tencent_mm_protocal_c_afj.itR = "0";
            linkedList.add(com_tencent_mm_protocal_c_afj);
        }
        a = be.a((Integer) ak.yT().get(20), 0);
        for (i = 0; i < a; i++) {
            com_tencent_mm_protocal_c_afj = new afj();
            com_tencent_mm_protocal_c_afj.itH = 31;
            com_tencent_mm_protocal_c_afj.itR = "1";
            linkedList.add(com_tencent_mm_protocal_c_afj);
        }
        if (linkedList.size() > 0) {
            bl.a(linkedList);
            ak.yT().set(19, Integer.valueOf(0));
            ak.yT().set(20, Integer.valueOf(0));
        }
    }
}
