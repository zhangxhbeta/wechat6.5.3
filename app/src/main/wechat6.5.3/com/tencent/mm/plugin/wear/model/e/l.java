package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.ay.c;
import com.tencent.mm.ba.b;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.sdk.platformtools.aa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        return arrayList;
    }

    protected final boolean sz(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11032:
                bia com_tencent_mm_protocal_c_bia = new bia();
                if (j.sU().getInt("WearPayBlock", 0) == 0) {
                    a.cL(13, 0);
                    a.sy(15);
                    qv qvVar = new qv();
                    qvVar.bsq.action = 3;
                    com.tencent.mm.sdk.c.a.nhr.z(qvVar);
                    switch (qvVar.bsr.bss) {
                        case 1:
                            com_tencent_mm_protocal_c_bia.mVA = 0;
                            com_tencent_mm_protocal_c_bia.ncO = "";
                            com_tencent_mm_protocal_c_bia.ncP = new b(qvVar.bsr.bsw);
                            com_tencent_mm_protocal_c_bia.ncQ = new b(qvVar.bsr.bsx);
                            com_tencent_mm_protocal_c_bia.ncR = qvVar.bsr.bsy;
                            com_tencent_mm_protocal_c_bia.ncS = qvVar.bsr.bsz;
                            break;
                        case 2:
                            com_tencent_mm_protocal_c_bia.mVA = 196611;
                            com_tencent_mm_protocal_c_bia.ncO = aa.getContext().getString(2131236588);
                            break;
                        case 3:
                            com_tencent_mm_protocal_c_bia.mVA = 196609;
                            com_tencent_mm_protocal_c_bia.ncO = aa.getContext().getString(2131236587);
                            break;
                        case 4:
                            com_tencent_mm_protocal_c_bia.mVA = 196610;
                            com_tencent_mm_protocal_c_bia.ncO = aa.getContext().getString(2131236591);
                            break;
                        case 5:
                            com_tencent_mm_protocal_c_bia.mVA = 196612;
                            com_tencent_mm_protocal_c_bia.ncO = aa.getContext().getString(2131236589);
                            break;
                        default:
                            break;
                    }
                }
                com_tencent_mm_protocal_c_bia.mVA = 16777215;
                com_tencent_mm_protocal_c_bia.ncO = aa.getContext().getString(2131236590);
                try {
                    return com_tencent_mm_protocal_c_bia.toByteArray();
                } catch (IOException e) {
                    break;
                }
            case 11034:
                bil com_tencent_mm_protocal_c_bil = new bil();
                try {
                    com_tencent_mm_protocal_c_bil.az(bArr);
                } catch (IOException e2) {
                }
                c.w(aa.getContext(), com_tencent_mm_protocal_c_bil.ncW, com_tencent_mm_protocal_c_bil.ncX);
                break;
        }
        return new byte[0];
    }

    public final boolean sB(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
