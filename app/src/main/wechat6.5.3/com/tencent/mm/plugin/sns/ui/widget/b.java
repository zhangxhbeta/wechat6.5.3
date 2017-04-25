package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;

public final class b {
    public static CharSequence a(Context context, avr com_tencent_mm_protocal_c_avr, as asVar, int i) {
        CharSequence charSequence;
        int i2;
        String str;
        String str2 = "";
        CharSequence a = a(com_tencent_mm_protocal_c_avr);
        if (be.kS(com_tencent_mm_protocal_c_avr.mTc)) {
            charSequence = null;
            CharSequence charSequence2 = a;
            i2 = 0;
        } else {
            u LW = ad.aSs().LW(com_tencent_mm_protocal_c_avr.mTc);
            String tU = LW == null ? com_tencent_mm_protocal_c_avr.mTc : LW.tU();
            str = a + context.getString(2131235510);
            int length = str.length();
            str = str + tU;
            int i3 = length;
            charSequence = tU;
            i2 = i3;
        }
        SpannableString a2 = e.a(context, (str2 + str + ": ") + com_tencent_mm_protocal_c_avr.hQP, a.fromDPToPix(context, (int) (14.0f * a.ds(context))), 2);
        int i4 = i == 21 ? 3 : 2;
        CharSequence fVar = new f(a2);
        fVar.a(new j(com_tencent_mm_protocal_c_avr.mdw, asVar.jMK, i4), a, 0, 33);
        if (charSequence != null) {
            fVar.a(new j(com_tencent_mm_protocal_c_avr.mTc, asVar.jMK, i4), charSequence, i2, 33);
        }
        return fVar;
    }

    public static String a(avr com_tencent_mm_protocal_c_avr) {
        u LW = ad.aSs().LW(com_tencent_mm_protocal_c_avr.mdw);
        if (LW != null) {
            return LW.tU();
        }
        return com_tencent_mm_protocal_c_avr.mGq != null ? com_tencent_mm_protocal_c_avr.mGq : com_tencent_mm_protocal_c_avr.mdw;
    }
}
