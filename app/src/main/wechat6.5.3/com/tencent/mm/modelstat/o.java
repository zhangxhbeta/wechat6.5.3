package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.model.o.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class o {

    public enum a {
        Chat(1),
        TalkChat(2),
        Sns(3);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(azr com_tencent_mm_protocal_c_azr, c cVar) {
        if (com_tencent_mm_protocal_c_azr != null && cVar != null) {
            a(com_tencent_mm_protocal_c_azr.jGu, cVar);
        }
    }

    public static void a(String str, c cVar) {
        if (!be.kS(str) && cVar != null) {
            aya kw = kw(str);
            cVar.n("Source", (kw == null ? -1 : kw.bbT) + ",");
            cVar.n("SnsStatExt", a(kw));
        }
    }

    public static aya kw(String str) {
        if (be.kS(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        axz com_tencent_mm_protocal_c_axz = new axz();
        try {
            com_tencent_mm_protocal_c_axz.az(decode);
        } catch (Exception e) {
            v.e("MicroMsg.SnsStatExtUtil", SQLiteDatabase.KeyEmpty, e);
        }
        return com_tencent_mm_protocal_c_axz.mVt;
    }

    public static String b(String str, PString pString) {
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        byte[] decode = Base64.decode(str, 0);
        axz com_tencent_mm_protocal_c_axz = new axz();
        try {
            com_tencent_mm_protocal_c_axz.az(decode);
            String str2 = com_tencent_mm_protocal_c_axz.mVt.mVx;
            String str3 = com_tencent_mm_protocal_c_axz.mVt.mVw;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(com_tencent_mm_protocal_c_axz.mVt.bbT), URLEncoder.encode(a(com_tencent_mm_protocal_c_axz.mVt), "UTF-8")});
            pString.value = com_tencent_mm_protocal_c_axz.mVv.ghW;
            return str2;
        } catch (Throwable e) {
            v.a("MicroMsg.SnsStatExtUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public static String a(aya com_tencent_mm_protocal_c_aya) {
        if (com_tencent_mm_protocal_c_aya != null) {
            String str = com_tencent_mm_protocal_c_aya.mVx;
            String str2 = SQLiteDatabase.KeyEmpty;
            if (!be.kS(str)) {
                String[] split = str.split("\\|");
                if (split != null && split.length > 0) {
                    str2 = split[0];
                }
            }
            try {
                return String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aya.mVy), URLEncoder.encode(str2, "UTF-8"), com_tencent_mm_protocal_c_aya.mVw});
            } catch (UnsupportedEncodingException e) {
                v.e("MicroMsg.SnsStatExtUtil", SQLiteDatabase.KeyEmpty, e);
            }
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public static String w(at atVar) {
        if (atVar == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        String str = null;
        if (atVar.bvY()) {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
            if (dV == null || be.kS(dV.bnY)) {
                return SQLiteDatabase.KeyEmpty;
            }
            str = dV.bnY;
        }
        if (!atVar.bwo()) {
            return str;
        }
        n lp = p.lp(atVar.field_imgPath);
        if (lp == null || be.kS(lp.bnY)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return lp.bnY;
    }

    public static void a(String str, b bVar, at atVar) {
        if (atVar.bvY()) {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
            if (dV != null && !be.kS(dV.bnY)) {
                bVar.l(str, dV.bnY);
            }
        }
    }
}
