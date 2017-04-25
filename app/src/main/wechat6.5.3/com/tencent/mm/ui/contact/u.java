package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class u {
    public static String Pj(String str) {
        String str2;
        h gQ = n.Bo().gQ(str);
        ak.yW();
        ab LX = c.wH().LX(str);
        int i = LX.bBY;
        if (gQ != null) {
            i = gQ.bBY;
        }
        BizInfo hw = LX.bvm() ? e.hw(LX.field_username) : null;
        String str3 = "<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>";
        Object[] objArr = new Object[15];
        objArr[0] = be.KJ(LX.field_username);
        objArr[1] = be.KJ(LX.tT());
        objArr[2] = be.KJ(LX.pD());
        objArr[3] = be.KJ(LX.tT());
        objArr[4] = be.KJ(LX.pE());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = be.KJ(LX.getProvince());
        objArr[7] = be.KJ(LX.getCity());
        objArr[8] = be.KJ(LX.bCj);
        objArr[9] = Integer.valueOf(LX.bCi);
        objArr[10] = Integer.valueOf(LX.bBZ);
        objArr[11] = Integer.valueOf(LX.field_verifyFlag);
        objArr[12] = be.KJ(LX.bCp);
        if (hw == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        } else {
            str2 = be.KJ(hw.field_brandIconURL);
        }
        objArr[13] = str2;
        objArr[14] = be.KJ(LX.bCq);
        return String.format(str3, objArr);
    }

    public static void a(final Activity activity, String str, List<String> list) {
        for (String Pj : list) {
            ak.vy().a(new i(str, Pj(Pj), 42), 0);
        }
        a.f(activity, activity.getString(2131233278));
        g.iuh.h(11003, str, Integer.valueOf(3), Integer.valueOf(list.size()));
        activity.setResult(-1);
        ad.g(new Runnable() {
            public final void run() {
                activity.finish();
            }
        }, 1800);
    }
}
