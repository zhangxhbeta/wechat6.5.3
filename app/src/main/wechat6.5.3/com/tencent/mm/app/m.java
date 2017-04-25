package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.al.t;
import com.tencent.mm.c.a.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.CropImageNewUI;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

final class m implements g {
    m() {
    }

    public final void ow() {
        o.Ho().fP(7);
    }

    public final void cH(int i) {
        v.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", Integer.valueOf(i));
        o.Ho().fP(i);
    }

    public final com.tencent.mm.v.g ox() {
        return new a(aa.getContext());
    }

    public final String h(String str, int i) {
        if (com.tencent.mm.pluginsdk.model.app.g.bA(str, i) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.bA(str, i).field_packageName;
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final String bn(String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.aC(str, false) != null) {
            return com.tencent.mm.pluginsdk.model.app.g.aC(str, false).field_packageName;
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final String n(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.n(context, str);
    }

    public final boolean bo(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.bo(str);
    }

    public final boolean o(Context context, String str) {
        return com.tencent.mm.pluginsdk.model.app.g.o(context, str);
    }

    public final String e(Context context, String str, String str2) {
        return p.e(context, str, str2);
    }

    public final String s(String str, String str2) {
        return p.s(str, str2);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        r rVar = j.a.lxN;
        if (rVar != null) {
            rVar.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
        }
    }

    public final void a(Context context, String str, String str2, String str3, long j) {
        r rVar = j.a.lxN;
        if (rVar != null) {
            rVar.a(str, str2, 2, 4, str3, j);
        }
    }

    public final void oy() {
        b peVar = new pe();
        peVar.bqy.bqA = true;
        com.tencent.mm.sdk.c.a.nhr.z(peVar);
    }

    public final k ai(boolean z) {
        if (z) {
            t.HS().fT(4);
        }
        k kVar = new com.tencent.mm.al.k(4);
        ak.vy().a(kVar, 0);
        return kVar;
    }

    public final boolean bp(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.bp(str);
    }

    public final boolean a(Context context, int i, int i2, String str) {
        return com.tencent.mm.ui.o.a.a(context, i, i2, str, 4);
    }

    public final boolean b(Context context, int i, int i2, String str) {
        return com.tencent.mm.ui.o.a.a(context, i, i2, str, 7);
    }

    public final void oz() {
        MMAppMgr.oz();
    }

    public final boolean c(Activity activity) {
        if (f.sj()) {
            l.T(activity);
            return true;
        }
        s.ey(activity);
        return false;
    }

    public final void ah(Context context) {
        MMAppMgr.ek(context);
    }

    public final void d(Activity activity) {
        MMAppMgr.d(activity);
    }

    public final Bitmap a(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            return null;
        }
        String a;
        switch (i) {
            case 2:
                if (intent == null) {
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClass(activity, CropImageNewUI.class);
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", e.cgo + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, e.cgo, 4);
                return null;
            case 3:
                a = l.a(activity.getApplicationContext(), intent, e.cgo);
                if (a == null) {
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClass(activity, CropImageNewUI.class);
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", e.cgo + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", a);
                activity.startActivityForResult(intent3, 4);
                return null;
            case 4:
                if (intent == null) {
                    return null;
                }
                a = intent.getStringExtra("CropImage_OutputPath");
                if (a == null) {
                    v.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    return null;
                }
                v.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", a);
                return d.JV(a);
            default:
                return null;
        }
    }

    public final Intent oA() {
        Intent intent = new Intent(aa.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        return intent;
    }

    public final k a(com.tencent.mm.v.f fVar) {
        if (com.tencent.mm.modelmulti.l.Hm()) {
            return new com.tencent.mm.modelmulti.f(fVar);
        }
        o.Ho().fP(4);
        return null;
    }

    public final boolean a(u uVar) {
        return com.tencent.mm.modelmulti.a.a(uVar);
    }

    public final void a(BizInfo bizInfo, Activity activity, u uVar, boolean z, Runnable runnable) {
        com.tencent.mm.ui.tools.b.a(bizInfo, activity, uVar, z, runnable, 0);
    }

    public final void a(BizInfo bizInfo, Activity activity, u uVar) {
        com.tencent.mm.ui.tools.b.a(bizInfo, activity, uVar, false);
    }

    public final boolean oB() {
        return com.tencent.mm.pluginsdk.ui.d.l.oB();
    }

    public final void a(Intent intent, ars com_tencent_mm_protocal_c_ars, int i) {
        c.a(intent, com_tencent_mm_protocal_c_ars, i);
    }

    public final void oC() {
        com.tencent.mm.booter.p.oC();
    }

    public final void a(Context context, at.a aVar, Bundle bundle) {
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
    }

    public final void a(Context context, u uVar, at.a aVar, Bundle bundle, String str) {
        com.tencent.mm.ui.contact.e.a(context, uVar, aVar, true, true, bundle, str);
    }

    public final void a(Intent intent, String str) {
        com.tencent.mm.ui.contact.e.a(intent, str);
    }

    public final void bq(String str) {
        o.Hp().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
    }

    public final void a(ais com_tencent_mm_protocal_c_ais) {
        com.tencent.mm.plugin.f.a.a.a(com_tencent_mm_protocal_c_ais, null, true, false);
    }

    public final boolean oD() {
        return com.tencent.mm.modelmulti.l.Hm();
    }
}
