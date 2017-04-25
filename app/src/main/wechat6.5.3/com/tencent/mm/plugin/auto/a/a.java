package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.ae;
import android.support.v4.app.w;
import android.support.v4.app.w.g;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.e.a.t;
import com.tencent.mm.h.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import java.util.List;

public final class a {
    c dZY = new c<t>(this) {
        final /* synthetic */ a dZZ;

        {
            this.dZZ = r2;
            this.nhz = t.class.getName().hashCode();
        }

        private static boolean a(t tVar) {
            if (tVar instanceof t) {
                try {
                    g gVar;
                    com.tencent.mm.e.a.t.a aVar = tVar.aXg;
                    String str = tVar.aXg.username;
                    String str2 = tVar.aXg.title;
                    v.i("MicroMsg.auto.AutoLogic", "isConnectedUSB %b", new Object[]{Boolean.valueOf(aa.getContext().registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE")).getExtras().getBoolean("connected"))});
                    if (aa.getContext().registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE")).getExtras().getBoolean("connected") && a.Ts()) {
                        PendingIntent broadcast = PendingIntent.getBroadcast(aa.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str), 134217728);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(aa.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str), 134217728);
                        android.support.v4.app.ae.a aVar2 = new android.support.v4.app.ae.a("key_voice_reply_text");
                        aVar2.sT = aa.getContext().getString(2131235510);
                        ae aeVar = new ae(aVar2.sS, aVar2.sT, aVar2.sU, aVar2.sV, aVar2.mExtras, (byte) 0);
                        android.support.v4.app.w.f.a.a aVar3 = new android.support.v4.app.w.f.a.a(str2);
                        aVar3.sl = broadcast;
                        aVar3.sj = aeVar;
                        aVar3.sk = broadcast2;
                        int dC = i.dC(str);
                        if (dC > 10) {
                            dC = 10;
                        }
                        ak.yW();
                        List bM = com.tencent.mm.model.c.wJ().bM(str, dC);
                        for (int size = bM.size() - 1; size >= 0; size--) {
                            int fK;
                            String trim;
                            Object obj;
                            Object string;
                            at atVar = (at) bM.get(size);
                            if (m.dE(atVar.field_talker)) {
                                String str3 = atVar.field_talker;
                                fK = aw.fK(atVar.field_content);
                                if (fK != -1) {
                                    trim = atVar.field_content.substring(0, fK).trim();
                                    if (trim != null && trim.length() > 0) {
                                        str3 = trim;
                                    }
                                }
                                ak.yW();
                                u LX = com.tencent.mm.model.c.wH().LX(str3);
                                trim = l.a(LX, str3);
                                if (m.dE(str3) && (LX.field_username.equals(trim) || be.kS(trim))) {
                                    trim = aa.getContext().getString(2131231879);
                                }
                                obj = trim;
                            } else {
                                obj = null;
                            }
                            if (atVar.bwj()) {
                                string = aa.getContext().getString(2131234087);
                            } else if (atVar.bwm()) {
                                if (!m.dE(atVar.field_talker) || atVar.field_isSend == 1) {
                                    string = atVar.field_content;
                                } else {
                                    fK = aw.fK(atVar.field_content);
                                    string = fK != -1 ? atVar.field_content.substring(fK + 1).trim() : atVar.field_content;
                                }
                            } else if (atVar.bwb()) {
                                string = aa.getContext().getString(2131234109);
                            } else if (atVar.bwn()) {
                                string = aa.getContext().getString(2131234108);
                            } else if (atVar.bwo()) {
                                string = aa.getContext().getString(2131234105);
                            } else {
                                if (atVar.bvY()) {
                                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
                                    if (dV != null) {
                                        switch (dV.type) {
                                            case 2:
                                                string = String.format(aa.getContext().getString(2131234087), new Object[0]);
                                                break;
                                            case 3:
                                                string = String.format(aa.getContext().getString(2131234075), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 4:
                                                string = String.format(aa.getContext().getString(2131234079), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 5:
                                                string = String.format(aa.getContext().getString(2131234072), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 6:
                                                string = String.format(aa.getContext().getString(2131234071), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 8:
                                                string = String.format(aa.getContext().getString(2131234083), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case NetStatusUtil.LTE /*10*/:
                                                string = String.format(aa.getContext().getString(2131234076), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 13:
                                                string = String.format(aa.getContext().getString(2131234074), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 15:
                                                string = String.format(aa.getContext().getString(2131234070), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 16:
                                                string = String.format(aa.getContext().getString(2131234082), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 19:
                                                string = String.format(aa.getContext().getString(2131234077), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 20:
                                                string = String.format(aa.getContext().getString(2131234078), new Object[]{be.ah(dV.title, "")});
                                                break;
                                            case 24:
                                                string = aa.getContext().getString(2131232757);
                                                break;
                                        }
                                    }
                                } else if (atVar.bwp()) {
                                    string = aa.getContext().getString(2131234084);
                                    f bmr = com.tencent.mm.pluginsdk.j.a.bmr();
                                    if (bmr != null) {
                                        com.tencent.mm.storage.a.c rg = bmr.rg(atVar.field_imgPath);
                                        string = be.kS(bmr.rk(rg.EB())) ? aa.getContext().getString(2131234084) : "[" + bmr.rk(rg.EB()) + "]";
                                    }
                                } else if (atVar.bwl()) {
                                    string = aa.getContext().getString(2131234088);
                                } else if (atVar.bwf() || atVar.bwg()) {
                                    if (!atVar.field_content.equals(at.nvB)) {
                                        trim = atVar.field_content;
                                        qi qiVar = new qi();
                                        qiVar.brC.bdn = 1;
                                        qiVar.brC.content = trim;
                                        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
                                        if ((qiVar.brD.type == 3 ? 1 : null) == null) {
                                            string = aa.getContext().getString(2131234110);
                                        }
                                    }
                                    string = aa.getContext().getString(2131234111);
                                } else if (atVar.bwk()) {
                                    ak.yW();
                                    com.tencent.mm.storage.at.a MU = com.tencent.mm.model.c.wJ().MU(atVar.field_content);
                                    string = String.format(aa.getContext().getString(2131234082), new Object[]{MU.getDisplayName()});
                                } else if (atVar.field_type == -1879048186) {
                                    string = aa.getContext().getString(2131234073);
                                }
                                trim = null;
                            }
                            if (string == null) {
                                string = aa.getContext().getString(2131234106);
                            }
                            if (obj != null) {
                                string = String.format("%s: %s", new Object[]{obj, string});
                            }
                            aVar3.sp.add(string);
                            if (size == 0) {
                                aVar3.sn = atVar.field_createTime;
                            }
                        }
                        w.f fVar = new w.f();
                        fVar.sh = new android.support.v4.app.w.f.a((String[]) aVar3.sp.toArray(new String[aVar3.sp.size()]), aVar3.sj, aVar3.sk, aVar3.sl, new String[]{aVar3.sq}, aVar3.sn);
                        gVar = fVar;
                    } else {
                        gVar = null;
                    }
                    aVar.aXh = gVar;
                } catch (Throwable th) {
                    v.a("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
                }
            }
            return false;
        }
    };

    static boolean Ts() {
        boolean z;
        try {
            aa.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        v.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
