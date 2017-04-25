package com.tencent.mm.plugin.wallet_core.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.g;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    private static c gZi;
    private static a kOA;
    private static f kOB;
    private static am kOC = null;
    public JSONArray kOD;

    private static class a implements com.tencent.mm.modelgeo.a.a {
        int cxZ = 0;
        WeakReference<Activity> kOE;

        public a(Activity activity) {
            this.kOE = new WeakReference(activity);
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (z) {
                if (f.kOC == null) {
                    f.kOC = new am();
                }
                String xF = k.xF();
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(xF);
                f.kOC.longitude = (double) f;
                f.kOC.latitude = (double) f2;
                f.kOC.bCl = LX.getCityCode();
                f.kOC.bCk = LX.bvq();
                f.kOC.maQ = f.FY().cJD;
                f.kOC.maR = i.bfT().CY(String.format("%.4f", new Object[]{Float.valueOf(f2)}));
                f.kOC.maS = i.bfT().CY(String.format("%.4f", new Object[]{Float.valueOf(f)}));
                v.i("MicroMsg.GpsReportHelper", "fLongitude=" + f + ";fLatitude=" + f2 + " tryCount: " + this.cxZ);
                this.cxZ++;
                if (this.cxZ <= 3) {
                    return true;
                }
                f.gZi.c(this);
                return true;
            }
            v.e("MicroMsg.GpsReportHelper", "get Location fail;isOk=" + z);
            f.gZi.c(this);
            if (!(this.kOE == null || this.kOE.get() == null)) {
                MMAppMgr.aj((Context) this.kOE.get());
            }
            return false;
        }
    }

    private f() {
        init();
    }

    private void init() {
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nsH, "");
        v.i("MicroMsg.GpsReportHelper", "GpsReportHelper " + str);
        if (!be.kS(str)) {
            try {
                this.kOD = new JSONArray(str);
            } catch (Throwable e) {
                v.a("MicroMsg.GpsReportHelper", e, "", new Object[0]);
                v.e("MicroMsg.GpsReportHelper", "parse lbs config error", new Object[]{e});
            }
        }
    }

    public static f bfO() {
        if (kOB == null) {
            kOB = new f();
        }
        return kOB;
    }

    private static c FY() {
        if (gZi == null) {
            gZi = c.FY();
        }
        return gZi;
    }

    public static void g(final Activity activity, final int i) {
        int i2 = 1;
        v.i("MicroMsg.GpsReportHelper", "reflashLocationInfo " + i);
        v.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((k.bga().bgz().kQP & 8192) > 0), Integer.valueOf(k.bga().bgz().kQP)});
        if (!((k.bga().bgz().kQP & 8192) > 0)) {
            kOA = null;
        } else if (c.FZ() || c.Ga()) {
            v.i("MicroMsg.GpsReportHelper", "reflashLocationInfo scene:%d", new Object[]{Integer.valueOf(i)});
            if (activity != null) {
                c FY = FY();
                if (kOA == null) {
                    kOA = new a(activity);
                } else {
                    a aVar = kOA;
                    if (activity == null || aVar.kOE == null || !activity.equals(aVar.kOE.get())) {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        kOA = new a(activity);
                    }
                }
                if (kOA != null) {
                    kOA.cxZ = 0;
                }
                FY.a(kOA, false);
                return;
            }
            kOA = null;
        } else if (bfO().sn(i)) {
            v.i("MicroMsg.GpsReportHelper", "should show lbs dialog,scene:%d", new Object[]{Integer.valueOf(i)});
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nsI, activity.getString(2131236457));
            ak.yW();
            String str2 = (String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nsJ, activity.getString(2131236456));
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nsG, Long.valueOf(be.Nh()));
            g.a(activity, str2, str, activity.getString(2131233450), activity.getString(2131231010), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    com.tencent.mm.plugin.report.service.g.iuh.h(13446, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(be.Nh())});
                    dialogInterface.dismiss();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }, 2131690123);
        } else {
            v.i("MicroMsg.GpsReportHelper", "should'n show lbs dialog,scene:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public static am bfP() {
        return kOC;
    }

    private boolean sn(int i) {
        if (i == 5) {
            return false;
        }
        boolean z;
        ak.yW();
        long longValue = ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nsG, Long.valueOf(0))).longValue();
        if (this.kOD == null) {
            init();
        }
        if (this.kOD != null) {
            z = false;
            for (int i2 = 0; i2 < this.kOD.length(); i2++) {
                JSONObject optJSONObject = this.kOD.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.optInt("scene") == i) {
                    int i3;
                    if (optJSONObject.optInt("is_show_tips", 0) == 1) {
                        i3 = 1;
                    } else {
                        boolean z2 = false;
                    }
                    int optInt = optJSONObject.optInt("show_interval", 0);
                    long Nh = be.Nh();
                    if (i3 != 0 && Nh - longValue > ((long) optInt)) {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        v.i("MicroMsg.GpsReportHelper", "shouldShow? %s mLbsConfig: %s ", new Object[]{Boolean.valueOf(z), this.kOD});
        return z;
    }
}
