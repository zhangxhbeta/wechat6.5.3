package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.e.a.dw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.aw.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    private static p dwg = null;
    private static boolean eut = false;

    public static void a(BizInfo bizInfo, Activity activity, u uVar, int i) {
        a(bizInfo, activity, uVar, false, null, i);
    }

    public static void a(BizInfo bizInfo, Activity activity, u uVar, boolean z, Runnable runnable, int i) {
        if (bizInfo == null || activity == null || uVar == null) {
            boolean z2;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            if (bizInfo == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (activity == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (uVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            v.e(str, str2, objArr);
            return;
        }
        String string;
        if (bizInfo.CA()) {
            string = activity.getString(2131231553);
        } else {
            string = activity.getString(2131231554, new Object[]{uVar.tU()});
        }
        final BizInfo bizInfo2 = bizInfo;
        final Activity activity2 = activity;
        final u uVar2 = uVar;
        final boolean z3 = z;
        final int i2 = i;
        final Runnable runnable2 = runnable;
        g.b((Context) activity, string, SQLiteDatabase.KeyEmpty, activity.getString(2131232145), activity.getString(2131231010), (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.a(bizInfo2, activity2, uVar2, z3, i2);
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }, null);
    }

    public static void a(BizInfo bizInfo, Activity activity, u uVar, boolean z) {
        a(bizInfo, activity, uVar, false, 0);
    }

    public static void a(BizInfo bizInfo, Activity activity, u uVar, boolean z, int i) {
        boolean z2 = true;
        if (bizInfo == null || activity == null || uVar == null) {
            boolean z3;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            if (bizInfo == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[0] = Boolean.valueOf(z3);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (uVar != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            v.e(str, str2, objArr);
            return;
        }
        final String str3 = uVar.field_username;
        uVar.tq();
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.c(str3, i));
        if (m.eA(str3)) {
            ak.yW();
            c.wH().Mc(str3);
            ak.yW().wO().LG(str3);
        } else {
            eut = false;
            activity.getString(2131231164);
            dwg = g.a((Context) activity, activity.getString(2131231182), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    b.eut = true;
                }
            });
            a anonymousClass3 = new a() {
                public final boolean zp() {
                    return b.eut;
                }

                public final void zo() {
                    com.tencent.mm.modelbiz.u.Dy().hp(str3);
                    if (b.dwg != null) {
                        b.dwg.dismiss();
                        b.dwg = null;
                    }
                }
            };
            ak.yW();
            c.wH().a(str3, uVar);
            if (bizInfo.Cz()) {
                e.hF(bizInfo.field_username);
            } else {
                aw.a(str3, anonymousClass3);
                ak.yW();
                c.wK().Mf(str3);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(bizInfo)) {
            com.tencent.mm.sdk.c.b dwVar = new dw();
            dwVar.bbP.aZU = str3;
            com.tencent.mm.sdk.c.a.nhr.z(dwVar);
        }
        h Dx = com.tencent.mm.modelbiz.u.Dx();
        if (!be.kS(str3)) {
            int delete = Dx.cie.delete("BizKF", "brandUsername = ?", new String[]{str3});
            v.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", str3, Integer.valueOf(delete));
        }
        if (z) {
            if (activity.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }
}
