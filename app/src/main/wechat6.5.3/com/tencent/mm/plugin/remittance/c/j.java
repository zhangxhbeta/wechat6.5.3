package com.tencent.mm.plugin.remittance.c;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.HashSet;

public final class j {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public String fgr;
    public HashSet<String> irR;
    public String irS;
    public Object lock;

    public j() {
        this.irR = null;
        this.irR = new HashSet();
        this.lock = new Object();
    }

    public final boolean yD(String str) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.irR.contains(str);
        }
        return contains;
    }

    private synchronized boolean yE(String str) {
        boolean z;
        if (this.irR.contains(str)) {
            v.i(TAG, "it is a duplicate msg");
            z = false;
        } else {
            z = this.irR.add(str);
        }
        return z;
    }

    public final boolean H(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            v.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            return false;
        } else if (!yE(str)) {
            return false;
        } else {
            at atVar = new at();
            atVar.setContent(str2);
            atVar.dh(2);
            atVar.cH(str3);
            atVar.z(aw.fN(str3));
            atVar.di(1);
            atVar.setType(419430449);
            ak.yW();
            long R = c.wJ().R(atVar);
            if (R < 0) {
                v.e(TAG, g.sm() + "insert msg failed :" + R);
                this.irR.remove(str);
                return false;
            }
            atVar.x(R);
            b.daJ.p(atVar);
            a aVar = new a();
            aVar.field_xml = atVar.field_content;
            String KK = be.KK(str2);
            if (KK != null) {
                a.a B = a.a.B(KK, atVar.field_reserved);
                if (B != null) {
                    aVar.field_title = B.title;
                    aVar.field_description = B.description;
                }
            }
            aVar.field_type = 2000;
            aVar.field_msgId = R;
            a dz = am.bnC().dz(R);
            if (dz != null && dz.field_msgId == R) {
                return am.bnC().a(aVar, new String[0]);
            }
            boolean b = am.bnC().b(aVar);
            if (b) {
                return b;
            }
            v.e(TAG, "SubCorePluginBase.getAppMsgStg().insert msg failed id:" + R);
            this.irR.remove(str);
            return b;
        }
    }
}
