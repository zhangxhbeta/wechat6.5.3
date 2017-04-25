package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.bhx;
import com.tencent.mm.storage.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11011));
        arrayList.add(Integer.valueOf(11010));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11010:
                bhx com_tencent_mm_protocal_c_bhx = new bhx();
                try {
                    com_tencent_mm_protocal_c_bhx.az(bArr);
                } catch (IOException e) {
                }
                a.bhH().laT.bj(com_tencent_mm_protocal_c_bhx.ncy, com_tencent_mm_protocal_c_bhx.ncK);
                break;
            case 11011:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                ak.yW();
                u LX = c.wH().LX(str);
                if (m.dE(str)) {
                    ak.yW();
                    LX = c.wH().LX(str);
                    LX.cZ(0);
                    ak.yW();
                    c.wH().a(str, LX);
                    ak.yW();
                    c.wG().b(new com.tencent.mm.ak.k(str, 0));
                } else {
                    m.l(LX);
                }
                com.tencent.mm.plugin.wear.model.c.a.cL(4, 0);
                break;
        }
        return null;
    }
}
