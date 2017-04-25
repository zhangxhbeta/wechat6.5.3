package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.a.e;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class an {
    public static String ad(int i, String str) {
        String a = d.a("snsvideo", (long) i, "sns", str);
        if (be.kS(a)) {
            return null;
        }
        return a;
    }

    public static String lb(String str) {
        if (be.kS(str)) {
            return "";
        }
        v.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[]{str, "SNS_" + str});
        return "SNS_" + str;
    }

    public static String D(aib com_tencent_mm_protocal_c_aib) {
        if (com_tencent_mm_protocal_c_aib == null) {
            return null;
        }
        v.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[]{al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib)});
        return al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.i(com_tencent_mm_protocal_c_aib);
    }

    public static String a(String str, aib com_tencent_mm_protocal_c_aib) {
        String str2;
        if (com_tencent_mm_protocal_c_aib == null) {
            str2 = null;
        } else {
            str2 = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.o(com_tencent_mm_protocal_c_aib);
            v.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[]{str2});
        }
        if (e.aR(str2)) {
            v.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[]{str, str2});
            return str2;
        }
        str2 = D(com_tencent_mm_protocal_c_aib);
        boolean aR = e.aR(str2);
        n AB = AB(str);
        if (AB == null) {
            if (aR) {
                v.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[]{str, str2});
                return str2;
            }
            v.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[]{str});
            return null;
        } else if (aR && AB.Lh()) {
            v.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[]{str, str2});
            return str2;
        } else {
            v.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[]{str, Boolean.valueOf(aR), Integer.valueOf(AB.status)});
            return null;
        }
    }

    public static boolean cC(String str, String str2) {
        int i;
        boolean a;
        n AB = AB(str);
        if (AB == null) {
            AB = new n();
            AB.aST = lb(str);
            i = 1;
        } else {
            i = 0;
        }
        AB.dhH = be.Nh();
        AB.bov = str2;
        AB.status = 199;
        if (i != 0) {
            a = k.KV().a(AB);
        } else {
            AB.bkU = 33555200;
            a = k.KV().b(AB);
        }
        v.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[]{str, str2, Boolean.valueOf(a)});
        return a;
    }

    public static n AB(String str) {
        if (be.kS(str)) {
            return null;
        }
        return p.lp(lb(str));
    }
}
