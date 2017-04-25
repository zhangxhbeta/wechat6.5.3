package com.tencent.mm.plugin.sns.a.a;

import android.util.Base64;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class f {
    public static void b(String str, c cVar) {
        k Bp = ad.aSE().Bp(str);
        if (Bp != null) {
            azr aUp = Bp.aUp();
            if (aUp != null) {
                o.a(aUp, cVar);
                return;
            }
            v.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[]{str});
            return;
        }
        v.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[]{str});
    }

    public static String a(long j, Object... objArr) {
        ad.aSy();
        StringBuilder stringBuilder = new StringBuilder(i.k(objArr));
        a(j, stringBuilder);
        return stringBuilder.toString();
    }

    public static void a(long j, StringBuilder stringBuilder) {
        com.tencent.mm.plugin.sns.storage.c cV = ad.aSF().cV(j);
        if (cV != null) {
            azr aUp = cV.aUp();
            if (aUp == null) {
                v.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[]{Long.valueOf(j)});
                return;
            } else if (aUp != null) {
                aya kw = o.kw(aUp.jGu);
                stringBuilder.append(",").append(kw == null ? -1 : kw.bbT);
                stringBuilder.append(",").append(o.a(kw));
                return;
            } else {
                return;
            }
        }
        v.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[]{Long.valueOf(j)});
    }

    public static String zJ(String str) {
        if (be.kS(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        axz com_tencent_mm_protocal_c_axz = new axz();
        try {
            com_tencent_mm_protocal_c_axz.az(decode);
            return o.a(com_tencent_mm_protocal_c_axz.mVt);
        } catch (IOException e) {
            v.e("SnsAdExtUtil", "", new Object[]{e});
            return "";
        }
    }
}
