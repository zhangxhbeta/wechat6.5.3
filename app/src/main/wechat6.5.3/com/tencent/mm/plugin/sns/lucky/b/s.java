package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.d.a;
import java.util.Map;

public final class s implements b {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    public final void a(a aVar) {
        v.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        b.kZ(74);
        if (aVar == null || aVar.czu == null) {
            v.e(TAG, "onPreAddMessage cmdAM is null");
            return;
        }
        r rVar = new r();
        String a = m.a(aVar.czu.mbW);
        rVar.eid = new StringBuffer();
        Map q = bf.q(a, "sysmsg");
        rVar.jfv.clear();
        if (q == null) {
            v.i("MicroMsg.NewYearSnsTips", "errr for paser %s", new Object[]{a});
            b.kZ(75);
        } else {
            int i = 0;
            while (true) {
                String str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr = new Object[2];
                objArr[0] = i == 0 ? "" : String.valueOf(i);
                objArr[1] = "BeginTime";
                long KM = be.KM((String) q.get(String.format(str, objArr)));
                rVar.eid.append("BeginTime:" + KM + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr2 = new Object[2];
                objArr2[0] = i == 0 ? "" : String.valueOf(i);
                objArr2[1] = "EndTime";
                long KM2 = be.KM((String) q.get(String.format(str, objArr2)));
                rVar.eid.append("EndTime:" + KM2 + ";");
                str = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr3 = new Object[2];
                objArr3[0] = i == 0 ? "" : String.valueOf(i);
                objArr3[1] = "ActionID";
                str = be.ah((String) q.get(String.format(str, objArr3)), "");
                rVar.eid.append("ActionID:" + str + ";");
                if (be.kS(str)) {
                    break;
                }
                String str2 = ".sysmsg.NewYearSNSTips2016.Tips%s.%s";
                Object[] objArr4 = new Object[2];
                objArr4[0] = i == 0 ? "" : String.valueOf(i);
                objArr4[1] = "TipsMessage";
                String ah = be.ah((String) q.get(String.format(str2, objArr4)), "");
                rVar.eid.append("TipsMessage:" + ah + ";\n");
                q qVar = new q();
                qVar.jfs = str;
                qVar.jer = KM;
                qVar.efw = KM2;
                qVar.jft = ah;
                rVar.jfv.add(qVar);
                i++;
            }
            if (rVar.jfv.size() == 0) {
                b.kZ(76);
            }
        }
        v.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + rVar.eid.toString());
        ak.yW();
        c.vf().a(t.a.nrS, a);
        ak.yW();
        c.vf().iB(true);
    }
}
