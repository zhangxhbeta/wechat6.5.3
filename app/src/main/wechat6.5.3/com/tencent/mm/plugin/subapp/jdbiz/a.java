package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a implements b {
    c keR = new c<iw>(this) {
        final /* synthetic */ a keS;

        {
            this.keS = r2;
            this.nhz = iw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            iw iwVar = (iw) bVar;
            if ((iwVar instanceof iw) && iwVar.bjn.bjp != null && iwVar.bjn.bjo != null && "bizjd".equals(iwVar.bjn.bjo)) {
                String ah = be.ah(iwVar.bjn.bjp.getString("activity_id"), SQLiteDatabase.KeyEmpty);
                String ah2 = be.ah(iwVar.bjn.bjp.getString("jump_url"), SQLiteDatabase.KeyEmpty);
                g.iuh.h(11179, ah2, c.aZi().aZn().keV, Integer.valueOf(4));
                b aZn = c.aZi().aZn();
                if (!(aZn == null || aZn.keV == null || !aZn.keV.equals(ah))) {
                    c.aZi().aZm();
                    c.aZi().aZl();
                }
                com.tencent.mm.sdk.c.a.nhr.f(this.keS.keR);
            }
            return false;
        }
    };

    public final void a(com.tencent.mm.v.d.a aVar) {
        v.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        final b bVar = new b();
        bVar.Bc(m.a(bmVar.mbW));
        v.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + be.ah(bVar.keU, SQLiteDatabase.KeyEmpty));
        if (be.kS(bVar.keU)) {
            v.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (be.kS(bVar.keV)) {
            v.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!bVar.a(c.aZi().aZn())) {
            v.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!c.aZq()) {
            v.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
        } else if (bVar.keU.equals("3")) {
            bmVar.mca = null;
            if (be.kS(bVar.kff) || be.kS(bVar.jumpUrl) || be.kS(bVar.kfg) || be.kS(bVar.kfh) || be.kS(bVar.kfe)) {
                v.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (bVar.aZc()) {
                v.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                c aZi = c.aZi();
                String str = bVar.keV;
                if (be.kS(str) ? false : aZi.kfk.containsKey(str)) {
                    v.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + bVar.keV);
                } else if (bVar.a(c.aZi().aZn())) {
                    aZi = c.aZi();
                    str = bVar.keV;
                    if (!be.kS(str)) {
                        aZi.kfk.put(str, Integer.valueOf(1));
                    }
                    v.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + bVar.keV);
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ a keS;

                        public final void run() {
                            a aVar = this.keS;
                            b bVar = bVar;
                            ak.yW();
                            int intValue = ((Integer) com.tencent.mm.model.c.vf().get(15, Integer.valueOf(0))).intValue();
                            String bc;
                            if (ak.vy().foreground && 1 == intValue) {
                                JDRemindDialog.a(aa.getContext(), bVar.kff, bVar.kfg, bVar.kfh, c.bc(bVar.jumpUrl, 5), bVar.keV);
                                g.iuh.h(11178, bc, c.aZi().aZn().keV, Integer.valueOf(5));
                                return;
                            }
                            bc = c.bc(bVar.jumpUrl, 4);
                            Bundle bundle = new Bundle();
                            bundle.putString("activity_id", bVar.keV);
                            bundle.putString("jump_url", bc);
                            ((com.tencent.mm.model.ac) ak.oH()).a(37, aa.getContext().getString(2131231134), bVar.kfe, bc, "bizjd", bundle);
                            com.tencent.mm.sdk.c.a.nhr.e(aVar.keR);
                            g.iuh.h(11178, bc, c.aZi().aZn().keV, Integer.valueOf(4));
                        }
                    });
                } else {
                    v.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                }
            }
            c.b(bVar);
        } else if (bVar.keU.equals("1")) {
            c.b(bVar);
        } else if (bVar.keU.equals("2")) {
            c.b(bVar);
        }
        ak.yW();
        com.tencent.mm.model.c.vf().iB(true);
    }
}
