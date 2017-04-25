package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.u;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.ai;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class o {
    static ProgressDialog dwR = null;
    static SecurityImage nFq = null;

    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ Activity dpq;
        final /* synthetic */ Intent nFr = null;

        AnonymousClass5(Intent intent, Activity activity) {
            this.dpq = activity;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            g.iuh.a(405, 39, 1, true);
            if (this.nFr != null) {
                this.dpq.finish();
                this.dpq.startActivity(this.nFr);
                b.x(this.dpq, this.nFr);
            }
        }
    }

    public static class a {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(final android.content.Context r9, int r10, int r11, java.lang.String r12, int r13) {
            /*
            r1 = 0;
            r8 = 2;
            r3 = 0;
            r2 = 1;
            switch(r10) {
                case 1: goto L_0x0009;
                case 2: goto L_0x00f8;
                case 3: goto L_0x0117;
                case 4: goto L_0x011a;
                default: goto L_0x0007;
            };
        L_0x0007:
            r0 = r3;
        L_0x0008:
            return r0;
        L_0x0009:
            r0 = r13 & 2;
            if (r0 == 0) goto L_0x0029;
        L_0x000d:
            r0 = com.tencent.mm.model.ak.vy();
            r0 = r0.BK();
            if (r0 == 0) goto L_0x0029;
        L_0x0017:
            r0 = com.tencent.mm.model.ak.vy();
            r0 = r0.getNetworkServerIp();
            r4 = java.lang.String.valueOf(r11);
            r0 = com.tencent.mm.pluginsdk.ui.i.u(r9, r0, r4);
            if (r0 != 0) goto L_0x0068;
        L_0x0029:
            r0 = r13 & 1;
            if (r0 == 0) goto L_0x0039;
        L_0x002d:
            r0 = com.tencent.mm.network.aa.bk(r9);
            if (r0 == 0) goto L_0x0039;
        L_0x0033:
            r0 = com.tencent.mm.pluginsdk.ui.i.dl(r9);
            if (r0 != 0) goto L_0x0068;
        L_0x0039:
            r0 = r13 & 4;
            if (r0 == 0) goto L_0x004c;
        L_0x003d:
            r0 = com.tencent.mm.sdk.platformtools.ak.isWap(r9);
            if (r0 == 0) goto L_0x004c;
        L_0x0043:
            r0 = com.tencent.mm.model.ak.uz();
            if (r0 != 0) goto L_0x006a;
        L_0x0049:
            r0 = r3;
        L_0x004a:
            if (r0 != 0) goto L_0x0068;
        L_0x004c:
            r0 = 2131232874; // 0x7f08086a float:1.808187E38 double:1.0529689463E-314;
            r1 = new java.lang.Object[r8];
            r4 = java.lang.Integer.valueOf(r2);
            r1[r3] = r4;
            r3 = java.lang.Integer.valueOf(r11);
            r1[r2] = r3;
            r0 = r9.getString(r0, r1);
            r0 = android.widget.Toast.makeText(r9, r0, r2);
            r0.show();
        L_0x0068:
            r0 = r2;
            goto L_0x0008;
        L_0x006a:
            com.tencent.mm.model.ak.yW();
            r0 = com.tencent.mm.model.c.vf();
            r4 = 61;
            r0 = r0.get(r4, r1);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.sdk.platformtools.be.c(r0);
            if (r0 == 0) goto L_0x0081;
        L_0x007f:
            r0 = r3;
            goto L_0x004a;
        L_0x0081:
            r0 = "show_wap_adviser";
            r0 = com.tencent.mm.sdk.platformtools.ab.Ki(r0);
            if (r0 != 0) goto L_0x008c;
        L_0x008a:
            r0 = r3;
            goto L_0x004a;
        L_0x008c:
            r0 = 2130904126; // 0x7f03043e float:1.741509E38 double:1.052806523E-314;
            r1 = android.view.View.inflate(r9, r0, r1);
            r0 = 2131758446; // 0x7f100d6e float:1.9147856E38 double:1.0532286134E-314;
            r0 = r1.findViewById(r0);
            r0 = (android.widget.TextView) r0;
            r4 = 2131234031; // 0x7f080cef float:1.8084216E38 double:1.052969518E-314;
            r0.setText(r4);
            r0 = 2131758448; // 0x7f100d70 float:1.914786E38 double:1.0532286144E-314;
            r0 = r1.findViewById(r0);
            r0 = (android.widget.CheckBox) r0;
            r4 = 2131234247; // 0x7f080dc7 float:1.8084654E38 double:1.0529696247E-314;
            r4 = r9.getString(r4);
            r0.setText(r4);
            r4 = new com.tencent.mm.ui.MMAppMgr$12;
            r4.<init>();
            r0.setOnCheckedChangeListener(r4);
            r0.setVisibility(r3);
            r0 = new com.tencent.mm.ui.base.h$a;
            r0.<init>(r9);
            r4 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
            r0.wm(r4);
            r0.cC(r1);
            r1 = 2131234249; // 0x7f080dc9 float:1.8084658E38 double:1.0529696257E-314;
            r1 = r0.wp(r1);
            r4 = new com.tencent.mm.ui.MMAppMgr$13;
            r4.<init>(r9);
            r1.a(r4);
            r0.jk(r3);
            r1 = 2131234248; // 0x7f080dc8 float:1.8084656E38 double:1.052969625E-314;
            r0.wq(r1);
            r1 = new com.tencent.mm.ui.MMAppMgr$14;
            r1.<init>();
            r0.a(r1);
            r0 = r0.RX();
            r0.show();
            r0 = r2;
            goto L_0x004a;
        L_0x00f8:
            r0 = 2131232875; // 0x7f08086b float:1.8081872E38 double:1.052968947E-314;
            r1 = new java.lang.Object[r8];
            r4 = java.lang.Integer.valueOf(r8);
            r1[r3] = r4;
            r3 = java.lang.Integer.valueOf(r11);
            r1[r2] = r3;
            r0 = r9.getString(r0, r1);
            r0 = android.widget.Toast.makeText(r9, r0, r2);
            r0.show();
            r0 = r2;
            goto L_0x0008;
        L_0x0117:
            r0 = r2;
            goto L_0x0008;
        L_0x011a:
            r4 = com.tencent.mm.f.a.dm(r12);
            if (r4 == 0) goto L_0x0007;
        L_0x0120:
            r0 = "MicroMsg.MMErrorProcessor";
            r5 = "summertips errCode[%d], showType[%d], url[%s], desc[%s]";
            r6 = 4;
            r6 = new java.lang.Object[r6];
            r7 = java.lang.Integer.valueOf(r11);
            r6[r3] = r7;
            r7 = r4.aXx;
            r7 = java.lang.Integer.valueOf(r7);
            r6[r2] = r7;
            r7 = r4.url;
            r6[r8] = r7;
            r7 = 3;
            r8 = r4.desc;
            r6[r7] = r8;
            com.tencent.mm.sdk.platformtools.v.i(r0, r5, r6);
            r0 = r4.url;
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r0 != 0) goto L_0x0159;
        L_0x014b:
            r0 = new com.tencent.mm.ui.o$a$1;
            r0.<init>(r4, r9);
        L_0x0150:
            r0 = r4.a(r9, r0, r1);
            if (r0 == 0) goto L_0x0007;
        L_0x0156:
            r0 = r2;
            goto L_0x0008;
        L_0x0159:
            r0 = r1;
            goto L_0x0150;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.o.a.a(android.content.Context, int, int, java.lang.String, int):boolean");
        }
    }

    public static boolean a(final Activity activity, int i, int i2, final Intent intent, String str) {
        if (i != 4) {
            return false;
        }
        v.d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                v.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                com.tencent.mm.ui.base.g.a((Context) activity, 2131233717, 2131231164, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.x(activity, intent);
                            d.aY(activity);
                        }
                    }
                });
                return true;
            case -140:
            case -104:
                v.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", Integer.valueOf(i2), str);
                if (be.kS(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == -104) {
                        v.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", str);
                        break;
                    }
                }
                str = str.substring(16);
                if (!be.kS(str) && str.startsWith("<")) {
                    Map q = bf.q(str, "e");
                    if (!(q == null || be.kS((String) q.get(".e.Content")))) {
                        str = (String) q.get(".e.Content");
                    }
                }
                if (be.kS(str)) {
                    str = aa.getContext().getString(2131233717);
                }
                com.tencent.mm.ui.base.g.a((Context) activity, str, aa.getContext().getString(2131231164), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.x(activity, intent);
                            d.aY(activity);
                        }
                    }
                });
                return true;
            case -100:
                String str2;
                String uA = ak.uA();
                v.e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + uA);
                com.tencent.mm.sdk.c.a.nhr.z(new u());
                com.tencent.mm.sdk.c.b hrVar = new hr();
                hrVar.bhA.status = 0;
                hrVar.bhA.bhB = 1;
                com.tencent.mm.sdk.c.a.nhr.z(hrVar);
                if (!be.kS(uA)) {
                    final com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(uA);
                    if (dm != null) {
                        v.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", Integer.valueOf(dm.aXx));
                        if ((dm.aXx == 3 || dm.aXx == 4) && dm.a(activity, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    ak.hold();
                                    if (be.kS(dm.url)) {
                                        activity.startActivity(intent);
                                        b.x(activity, intent);
                                    } else {
                                        Intent intent = new Intent();
                                        StringBuilder stringBuilder = new StringBuilder(dm.url);
                                        stringBuilder.append("&wechat_real_lang=" + com.tencent.mm.sdk.platformtools.u.bsY());
                                        intent.putExtra("rawUrl", stringBuilder.toString());
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("needRedirect", false);
                                        intent.putExtra("neverGetA8Key", true);
                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                                        c.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    d.aY(activity);
                                    com.tencent.mm.sdk.c.b vVar = new com.tencent.mm.e.a.v();
                                    vVar.aXi.aXj = true;
                                    com.tencent.mm.sdk.c.a.nhr.z(vVar);
                                }
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    activity.startActivity(intent);
                                    b.x(activity, intent);
                                    d.aY(activity);
                                }
                            }
                        })) {
                            return true;
                        }
                    }
                }
                if (!be.kS(uA) && uA.startsWith("<")) {
                    Map q2 = bf.q(uA, "e");
                    if (!(q2 == null || be.kS((String) q2.get(".e.Content")))) {
                        str2 = (String) q2.get(".e.Content");
                        v.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + q2);
                        v.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", str2);
                        if (be.kS(str2)) {
                            str2 = com.tencent.mm.bd.a.O(activity, 2131233716);
                        }
                        com.tencent.mm.ui.base.g.a((Context) activity, str2, activity.getString(2131231164), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    ak.hold();
                                    activity.startActivity(intent);
                                    b.x(activity, intent);
                                    d.aY(activity);
                                    com.tencent.mm.sdk.c.b vVar = new com.tencent.mm.e.a.v();
                                    vVar.aXi.aXj = true;
                                    com.tencent.mm.sdk.c.a.nhr.z(vVar);
                                }
                            }
                        }, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    activity.startActivity(intent);
                                    b.x(activity, intent);
                                    d.aY(activity);
                                }
                            }
                        });
                        return true;
                    }
                }
                str2 = uA;
                v.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", str2);
                if (be.kS(str2)) {
                    str2 = com.tencent.mm.bd.a.O(activity, 2131233716);
                }
                com.tencent.mm.ui.base.g.a((Context) activity, str2, activity.getString(2131231164), /* anonymous class already generated */, /* anonymous class already generated */);
                return true;
            case -75:
                v.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                com.tencent.mm.ui.base.g.a((Context) activity, 2131230894, 2131231164, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.x(activity, intent);
                            d.aY(activity);
                        }
                    }
                });
                return true;
        }
        return false;
    }

    public static h a(final Activity activity, String str, final String str2, final Intent intent) {
        com.tencent.mm.sdk.c.b hrVar = new hr();
        hrVar.bhA.status = 0;
        hrVar.bhA.bhB = 1;
        com.tencent.mm.sdk.c.a.nhr.z(hrVar);
        return com.tencent.mm.ui.base.g.a((Context) activity, str, activity.getString(2131231164), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.iuh.a(322, 23, 1, true);
                g gVar = g.iuh;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4023);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(be.kS(str2)), str2});
                gVar.h(11098, objArr);
                ak.hold();
                if (be.kS(str2)) {
                    activity.startActivity(intent);
                    b.x(activity, intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    c.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                }
                d.aY(activity);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.iuh.a(322, 24, 1, true);
                g gVar = g.iuh;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4024);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(be.kS(str2)), str2});
                gVar.h(11098, objArr);
                activity.startActivity(intent);
                b.x(activity, intent);
                d.aY(activity);
            }
        });
    }

    public static boolean Y(Activity activity) {
        boolean z = true;
        if (be.KL(j.sU().getValue("SilentDownloadApkAtWiFi")) != 0) {
            return false;
        }
        ak.yW();
        boolean z2 = (((Integer) com.tencent.mm.model.c.vf().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(com.tencent.mm.sdk.platformtools.ak.isWifi((Context) activity) && z2)) {
            z = false;
        }
        if ((f.aPY & 1) != 0) {
            v.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            v.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && s.Ng()) {
            return Z(activity);
        }
        return false;
    }

    public static boolean el(final Context context) {
        final String Nd = s.Nd();
        final int Ne = s.Ne();
        v.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", Nd, Integer.valueOf(Ne));
        if (be.kS(Nd) || s.Nf()) {
            return false;
        }
        ak.vA().x(new Runnable() {
            public final void run() {
                if (Ne == 4 && com.tencent.mm.pluginsdk.model.app.a.bne() == null) {
                    v.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
                } else if (ai.bmA() != null && ai.bmA().yO(Nd) != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 nFt;

                        {
                            this.nFt = r1;
                        }

                        public final void run() {
                            if (ai.bmA() != null) {
                                ai.bmA().ct(context);
                            }
                        }
                    });
                }
            }
        });
        return true;
    }

    public static boolean a(final Activity activity, int i, int i2) {
        v.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.lWh), Integer.valueOf(f.aPW), Integer.valueOf(f.aPY));
        if (i != 4) {
            return false;
        }
        com.tencent.mm.pluginsdk.j.ad b;
        switch (i2) {
            case -17:
                long j = aa.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                v.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", Long.valueOf(j), Long.valueOf(be.ax(j)));
                if (j != -1 && be.ax(j) < 86400) {
                    return true;
                }
                if ((f.aPY & 2) != 0) {
                    v.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    return true;
                }
                v.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                String value = j.sU().getValue("SilentDownloadApkAtWiFi");
                ak.yW();
                boolean z = ((((Integer) com.tencent.mm.model.c.vf().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (be.kS(value) || be.KL(value) == 0);
                if ((f.aPY & 1) != 0) {
                    v.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    z = false;
                } else {
                    v.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                }
                if (be.KL(value) != 0) {
                    v.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                }
                v.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", Boolean.valueOf(z));
                if (z) {
                    g.iuh.a(405, 40, 1, true);
                    return Z(activity);
                } else if (ai.bmA() == null) {
                    return false;
                } else {
                    b = ai.bmA().b(activity, new AnonymousClass5(null, activity));
                    g.iuh.a(405, 38, 1, true);
                    b.update(2);
                    return true;
                }
            case -16:
                if (ai.bmA() == null) {
                    return false;
                }
                b = ai.bmA().b(activity, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.iuh.a(405, 37, 1, true);
                        activity.finish();
                        MMAppMgr.a(activity, true);
                    }
                });
                g.iuh.a(405, 36, 1, true);
                b.update(1);
                return true;
            default:
                return false;
        }
    }

    private static boolean Z(Activity activity) {
        com.tencent.mm.pluginsdk.model.app.a bne = com.tencent.mm.pluginsdk.model.app.a.bne();
        if (bne != null) {
            bne.bni();
            v.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            return true;
        } else if (ai.bmA() == null) {
            return false;
        } else {
            ai.bmA().cs(activity).update(2);
            return true;
        }
    }
}
