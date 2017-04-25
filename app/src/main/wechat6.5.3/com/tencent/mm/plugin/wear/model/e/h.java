package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.j.ai;
import com.tencent.mm.protocal.c.bhk;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11000));
        arrayList.add(Integer.valueOf(11003));
        arrayList.add(Integer.valueOf(11035));
        return arrayList;
    }

    public final boolean sC(int i) {
        if (i == 11035) {
            return false;
        }
        return super.sC(i);
    }

    protected final byte[] l(int i, byte[] bArr) {
        String str;
        String str2;
        if (i == 11000) {
            str = "";
            try {
                str2 = new String(bArr, "utf8");
            } catch (UnsupportedEncodingException e) {
                str2 = str;
            }
            v.e("MicroMsg.Wear.UEH", "crash report from wear:\n%s", new Object[]{str2});
            if (ai.bmA() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("exceptionPid", Process.myPid());
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", k.xF());
                try {
                    intent.putExtra("exceptionMsg", Base64.encodeToString(str2.getBytes("utf8"), 2));
                } catch (UnsupportedEncodingException e2) {
                }
                ai.bmA().o(aa.getContext(), intent);
            }
        } else if (i == 11003) {
            str = "";
            try {
                str2 = new String(bArr, "utf8");
            } catch (UnsupportedEncodingException e3) {
                str2 = str;
            }
            for (String i2 : r0.split("​​\n")) {
                v.i("MicroMsg.Wear.LOG", i2);
            }
        } else if (i == 11035) {
            bhk com_tencent_mm_protocal_c_bhk = new bhk();
            try {
                com_tencent_mm_protocal_c_bhk.az(bArr);
            } catch (IOException e4) {
            }
            if (a.bhH().laR.lbj.lcb != null) {
                v.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bhk.gof), a.bhH().laR.lbj.lcb.eeB, a.bhH().laR.lbj.lcb.ncr, Integer.valueOf(a.bhH().laR.lbj.lcb.mcM), a.bhH().laR.lbj.lcb.ncs, com_tencent_mm_protocal_c_bhk.naG});
                g.iuh.h(com_tencent_mm_protocal_c_bhk.gof, new Object[]{r1.eeB, r1.ncr, Integer.valueOf(r1.mcM), r1.ncs, com_tencent_mm_protocal_c_bhk.naG});
            }
        }
        return null;
    }
}
