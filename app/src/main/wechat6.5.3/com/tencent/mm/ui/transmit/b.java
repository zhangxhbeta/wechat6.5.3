package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class b implements n {
    public final void x(String str, String str2, int i) {
        if (str == null || str2 == null) {
            v.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", str, str2);
            return;
        }
        ak.vy().a(new i(str, str2, i), 0);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        a(context, str, str2, str3, i, i2, null, false, false, str4);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, ayk com_tencent_mm_protocal_c_ayk, boolean z, boolean z2, String str4) {
        int i3 = 1;
        if (context == null) {
            v.w("MicroMsg.SendMsgMgr", "send vedio context is null");
        } else if (str == null || str2 == null) {
            v.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", str, str2);
        } else {
            ak.yW();
            if (c.isSDCardAvailable()) {
                final a aVar = new a();
                context.getResources().getString(2131231164);
                Dialog a = g.a(context, context.getResources().getString(2131231151), true, new OnCancelListener(this) {
                    final /* synthetic */ b oXR;

                    public final void onCancel(DialogInterface dialogInterface) {
                        aVar.oXh = true;
                    }
                });
                aVar.context = context;
                aVar.aST = str2;
                aVar.oXi = str3;
                aVar.dxy = a;
                aVar.userName = str;
                aVar.bnY = str4;
                aVar.oXl = false;
                if (62 == i) {
                    aVar.dgq = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                aVar.oWJ = i3;
                aVar.dhK = i2;
                aVar.oXj = false;
                aVar.oXm = com_tencent_mm_protocal_c_ayk;
                aVar.execute(new Object[0]);
                return;
            }
            v.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, 2131233900, 1).show();
        }
    }

    public final void a(Context context, String str, String str2, int i, String str3, String str4) {
        if (str == null || str2 == null) {
            v.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", str, str2);
            return;
        }
        ak.yW();
        if (c.isSDCardAvailable()) {
            ak.vy().a(new k(4, com.tencent.mm.model.k.xF(), str, str2, i, null, 0, str3, str4, true, 2130837922), 0);
            bl.zQ().b(bl.cvm, null);
            return;
        }
        v.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, 2131233900, 1).show();
    }

    public final void a(String str, byte[] bArr, String str2, String str3) {
        if (str == null) {
            v.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            return;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(str2));
        if (dV == null) {
            v.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            return;
        }
        com.tencent.mm.pluginsdk.model.app.b bVar = new com.tencent.mm.pluginsdk.model.app.b();
        if (dV.aXa != null) {
            long j = be.getLong(dV.aXa, -1);
            if (j != -1) {
                am.Wf().b(j, (com.tencent.mm.sdk.h.c) bVar);
                if (bVar.nmb != j) {
                    bVar = am.Wf().Gu(dV.aXa);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(dV.aXa)) {
                        bVar = null;
                    }
                }
            } else {
                bVar = am.Wf().Gu(dV.aXa);
                if (bVar == null || !bVar.field_mediaSvrId.equals(dV.aXa)) {
                    bVar = null;
                }
            }
        }
        String str4 = SQLiteDatabase.KeyEmpty;
        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(SQLiteDatabase.KeyEmpty))) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            str4 = stringBuilder.append(c.xd()).append("da_").append(be.Ni()).toString();
            j.n(bVar.field_fileFullPath, str4, false);
        }
        com.tencent.mm.q.a.a a = com.tencent.mm.q.a.a.a(dV);
        a.coe = 3;
        l.a(a, dV.appId, dV.appName, str, str4, bArr, str3);
    }

    public final void m(String str, String str2, boolean z) {
        if (z) {
            ak.vy().a(new i(be.ah(str2, SQLiteDatabase.KeyEmpty), u.Pj(str), 42), 0);
            return;
        }
        List g = be.g(be.ah(str2, SQLiteDatabase.KeyEmpty).split(","));
        String Pj = u.Pj(str);
        for (int i = 0; i < g.size(); i++) {
            ak.vy().a(new i((String) g.get(i), Pj, 42), 0);
        }
    }

    public final void df(String str, String str2) {
        List<String> g = be.g(be.ah(str2, SQLiteDatabase.KeyEmpty).split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : g) {
                com.tencent.mm.sdk.c.b mrVar = new mr();
                mrVar.boa.bob = str3;
                mrVar.boa.content = str;
                mrVar.boa.type = m.fp(str3);
                mrVar.boa.flags = 0;
                com.tencent.mm.sdk.c.a.nhr.z(mrVar);
            }
        }
    }
}
