package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class l {
    public static void a(final Activity activity, final Runnable runnable, boolean z, final int i) {
        if (m.EY() == a.SUCC || m.EY() == a.SUCC_UNLOAD) {
            ak.yW();
            if (be.c((Boolean) c.vf().get(12322, null))) {
                v.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
            } else {
                if (!z) {
                    ak.yW();
                    if (be.c((Boolean) c.vf().get(12323, null))) {
                        v.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
                    }
                }
                ak.yW();
                c.vf().set(12322, Boolean.valueOf(false));
                String ma = be.ma(be.dY(activity));
                if (ma.length() > 0) {
                    ak.yW();
                    if (ma.equals(c.vf().get(6, null))) {
                        ak.yW();
                        c.vf().set(12322, Boolean.valueOf(true));
                        v.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
                    }
                }
                g.a((Context) activity, 2131231386, 2131231164, 2131231183, 2131231104, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(i));
                        com.tencent.mm.plugin.report.service.g.iuh.h(11438, Integer.valueOf(i));
                        ak.yW();
                        c.vf().set(12322, Boolean.valueOf(true));
                        l.g(true, false);
                        com.tencent.mm.modelfriend.a.Ew();
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(aa.bti(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ak.yW();
                        c.vf().set(12322, Boolean.valueOf(false));
                        l.g(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(aa.bti(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                });
                ak.yW();
                c.vf().set(12323, Boolean.valueOf(true));
                return;
            }
        }
        v.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void g(boolean z, boolean z2) {
        int xJ = k.xJ();
        if (z) {
            xJ &= -131073;
        } else {
            xJ |= 131072;
        }
        v.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + xJ);
        ak.yW();
        c.vf().set(7, Integer.valueOf(xJ));
        xJ = !z ? 1 : 2;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.g(17, xJ));
        if (z2) {
            com.tencent.mm.plugin.a.a.drq.ow();
        }
    }

    public static void lX(String str) {
        ai.cse.J("login_user_name", str);
    }

    public static void bl(final Context context) {
        String string = context.getString(2131230894);
        final String string2 = context.getString(2131230893);
        g.b(context, string, SQLiteDatabase.KeyEmpty, context.getString(2131231977), context.getString(2131231975), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string2);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                com.tencent.mm.plugin.a.a.drp.j(intent, context);
            }
        }, null);
    }

    public static void j(final Context context, String str, final String str2) {
        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
        if (dm != null) {
            dm.a(context, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    com.tencent.mm.plugin.a.a.drp.j(intent, context);
                }
            }, null);
        }
    }

    public static void a(Context context, s.a aVar, int i) {
        v.i("MicroMsg.PostLoginUtil", "summervoice showNeedVoicePrint jump VoiceHelpUI context[%s], info[%s], errCode[%d]", context, aVar, Integer.valueOf(i));
        Intent intent = new Intent();
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", aVar.bax);
        intent.putExtra("KVoiceHelpUrl", aVar.cYX);
        intent.putExtra("KVoiceHelpWording", aVar.bhe);
        intent.putExtra("Kusername", aVar.username);
        intent.putExtra("kscene_type", 73);
        com.tencent.mm.ay.c.b(context, "voiceprint", ".ui.VoiceHelpUI", intent, 1024);
    }

    public static void D(final Context context, String str) {
        final com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
        if (dm != null) {
            String string = context.getString(2131231107);
            String string2 = context.getString(2131231010);
            OnClickListener anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", dm.url);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    com.tencent.mm.plugin.a.a.drp.j(intent, context);
                }
            };
            OnClickListener anonymousClass6 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            };
            if (dm.aXx != 1 && dm.aXx != 4) {
                return;
            }
            if (be.kS(dm.url)) {
                g.A(context, dm.desc, dm.aXz);
                return;
            }
            g.b(context, dm.desc, dm.aXz, string, string2, anonymousClass5, anonymousClass6);
            return;
        }
        Map q = bf.q(str, "e");
        if (q == null) {
            v.d("MicroMsg.PostLoginUtil", "this is not errmsg");
            return;
        }
        String str2 = (String) q.get(".e.Url");
        if (!be.kS(str2)) {
            v.w("MicroMsg.PostLoginUtil", "url %s", str2);
            Intent intent = new Intent();
            intent.putExtra("Kvertify_key", str2);
            intent.putExtra("kscene_type", 73);
            com.tencent.mm.ay.c.b(context, "voiceprint", ".ui.VoicePrintFirstUI", intent);
        }
    }
}
