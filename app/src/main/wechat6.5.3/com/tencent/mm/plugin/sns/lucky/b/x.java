package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.List;

public final class x {
    private static final ThreadLocal<HashMap<String, Long>> jfB = new ThreadLocal();

    public static boolean Ac(String str) {
        k Bq = ad.aSE().Bq(str);
        return a(Bq, ah.n(Bq));
    }

    public static boolean h(k kVar) {
        return a(kVar, ah.n(kVar));
    }

    public static boolean a(k kVar, awa com_tencent_mm_protocal_c_awa) {
        aic aUD = kVar.aUD();
        if (kVar.field_type != 21) {
            return true;
        }
        if (aUD.hav == 1) {
            return true;
        }
        if (com.tencent.mm.model.k.xF().equals(kVar.field_userName)) {
            return true;
        }
        if (com_tencent_mm_protocal_c_awa.mTz != null) {
            List<avx> list = com_tencent_mm_protocal_c_awa.mTz.mTZ;
            if (list == null || list.size() == 0) {
                return false;
            }
            String xF = com.tencent.mm.model.k.xF();
            for (avx com_tencent_mm_protocal_c_avx : list) {
                if (xF.equals(com_tencent_mm_protocal_c_avx.mdw)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(k kVar) {
        if (kVar == null) {
            return 0;
        }
        awa n = ah.n(kVar);
        if (n == null) {
            return 0;
        }
        awq com_tencent_mm_protocal_c_awq = n.mTz;
        return (com_tencent_mm_protocal_c_awq == null || com_tencent_mm_protocal_c_awq.mTZ.size() == 0) ? 0 : com_tencent_mm_protocal_c_awq.mTZ.size();
    }

    public static long j(k kVar) {
        return b(kVar, null);
    }

    public static long b(k kVar, awa com_tencent_mm_protocal_c_awa) {
        long j = 0;
        if (kVar == null) {
            return 0;
        }
        if (com_tencent_mm_protocal_c_awa == null) {
            com_tencent_mm_protocal_c_awa = ah.n(kVar);
        }
        if (com_tencent_mm_protocal_c_awa == null) {
            return 0;
        }
        awq com_tencent_mm_protocal_c_awq = com_tencent_mm_protocal_c_awa.mTz;
        if (com_tencent_mm_protocal_c_awq == null) {
            return 0;
        }
        List<avx> list = com_tencent_mm_protocal_c_awq.mTZ;
        if (list == null) {
            return 0;
        }
        String str = kVar.jBH;
        if (be.kS(str)) {
            Object obj = g.m(kVar.field_content) + g.m(kVar.field_attrBuf);
        } else {
            String str2 = str;
        }
        HashMap hashMap = (HashMap) jfB.get();
        if (hashMap != null && hashMap.containsKey(obj)) {
            return ((Long) hashMap.get(obj)).longValue();
        }
        for (avx com_tencent_mm_protocal_c_avx : list) {
            acc com_tencent_mm_protocal_c_acc = new acc();
            try {
                com_tencent_mm_protocal_c_acc.az(m.a(com_tencent_mm_protocal_c_avx.mSR));
            } catch (Exception e) {
                v.e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
            }
            j += com_tencent_mm_protocal_c_acc.bst;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put(obj, Long.valueOf(j));
        jfB.set(hashMap);
        return j;
    }
}
