package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.ad;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.o;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater extends LinearLayout implements ad, e {
    private boolean fJm;
    private int nfp;
    private boolean ngA = false;
    private e ngB;
    private p ngx = null;
    private boolean ngy = false;
    private boolean ngz = false;

    static /* synthetic */ void a(Updater updater, Intent intent, com.tencent.mm.network.e eVar, a aVar) {
        String string;
        String[] strArr;
        String str = "intent_short_ips";
        if (q.dpS == null || q.dpS.length() <= 0) {
            string = aa.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", SQLiteDatabase.KeyEmpty);
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List Iu = o.Iu(string);
            String[] strArr2 = new String[Iu.size()];
            for (int i = 0; i < Iu.size(); i++) {
                strArr2[i] = ((o) Iu.get(i)).gRG;
            }
            strArr = strArr2;
        } else {
            strArr = new String[]{q.dpS};
        }
        intent.putExtra(str, strArr);
        intent.putExtra("intent_client_version", d.lWh);
        intent.putExtra("intent_extra_session", eVar.BU().uT());
        intent.putExtra("intent_extra_cookie", eVar.BU().BP());
        intent.putExtra("intent_extra_ecdhkey", eVar.BU().BR());
        intent.putExtra("intent_extra_uin", eVar.BU().ww());
        intent.putExtra("intent_update_type", updater.nfp);
        intent.putExtra("intent_extra_desc", ((zv) aVar.cif.czl.czs).mBm);
        intent.putExtra("intent_extra_md5", aVar.bsc());
        intent.putExtra("intent_extra_size", aVar.bsb());
        intent.putExtra("intent_extra_download_url", aVar.bmy());
        intent.putExtra("intent_extra_patchInfo", aVar.bsd());
        intent.putExtra("intent_extra_updateMode", f.aPY);
        intent.putExtra("intent_extra_marketUrl", f.nhW);
        v.d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", be.ma(m.b(((zv) aVar.cif.czl.czs).mBt)), be.bur());
        intent.putExtra("intent_extra_extinfo", string);
    }

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        ak.vy().a(11, (e) this);
        g.iuh.a(405, 42, 1, true);
    }

    public final void onStop() {
        g.iuh.a(405, 43, 1, true);
        cancel();
    }

    public static Updater c(Context context, final OnCancelListener onCancelListener) {
        if (context == null) {
            return null;
        }
        if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            v.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            return null;
        }
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", be.Nh()).commit();
        ak.oH().cancel(34);
        v.i("MicroMsg.Updater", "showWithProgress");
        final Updater updater = (Updater) View.inflate(context, 2130904561, null);
        updater.onStart();
        p a = p.a(context, context.getString(2131235717), true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ak.oH().cancel(99);
                g.iuh.a(405, 47, 1, true);
                Updater.uT(2);
                updater.onStop();
                if (!updater.ngy && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        try {
            updater.ngx = a;
            updater.ngx.show();
            updater.fJm = true;
            g.iuh.a(405, 46, 1, true);
            return updater;
        } catch (Throwable e) {
            v.e("MicroMsg.Updater", "exception in showWithProgress, ", e.getMessage());
            v.a("MicroMsg.Updater", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public static Updater d(Context context, final OnCancelListener onCancelListener) {
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", be.Nh()).commit();
        ak.oH().cancel(34);
        v.i("MicroMsg.Updater", "show update dialog");
        final Updater updater = (Updater) View.inflate(context, 2130904561, null);
        updater.onStart();
        p a = p.a(context, SQLiteDatabase.KeyEmpty, true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ak.oH().cancel(99);
                g.iuh.a(405, 49, 1, true);
                Updater.uT(2);
                updater.onStop();
                if (!updater.ngy && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        g.iuh.a(405, 48, 1, true);
        updater.ngx = a;
        updater.fJm = false;
        return updater;
    }

    public static Updater dB(Context context) {
        aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", be.Nh()).commit();
        ak.oH().cancel(34);
        g.iuh.a(405, 50, 1, true);
        v.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.ngz = true;
        return updater;
    }

    public static void ct(Context context) {
        context.startActivity(new Intent(context, AppInstallerUI.class));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            g.iuh.a(405, 51, 1, true);
            v.i("MicroMsg.Updater", "isShow " + this.fJm);
            if (!(this.fJm || this.ngx == null)) {
                this.ngx.show();
            }
            this.ngy = true;
            if (this.ngx != null) {
                this.ngx.cancel();
            }
            final a aVar = (a) kVar;
            ak.vy().a(new ay(new ay.a(this) {
                final /* synthetic */ Updater ngF;

                public final void a(final com.tencent.mm.network.e eVar) {
                    long j;
                    String Nd;
                    if (eVar == null) {
                        g.iuh.a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    ak.oH().cancel(34);
                    v.i("MicroMsg.Updater", "go to update");
                    if (!h.getExternalStorageState().equals("mounted")) {
                        v.e("MicroMsg.Updater", "no sdcard.");
                        g.iuh.a(405, 53, 1, true);
                        this.ngF.ngz = false;
                    }
                    int bsb = aVar.bsb();
                    i be = i.be(aVar.bsd());
                    String dA = h.dA(this.ngF.getContext());
                    i.a aVar = null;
                    if (be != null) {
                        aVar = be.bd(dA);
                    }
                    if (aVar == null) {
                        j = (long) bsb;
                    } else {
                        j = (long) (aVar.size + bsb);
                    }
                    if (!com.tencent.mm.compatible.util.f.G(j)) {
                        v.e("MicroMsg.Updater", "no enough space.");
                        g.iuh.a(405, 54, 1, true);
                        this.ngF.ngz = false;
                    }
                    if ((f.aPY & 1) != 0) {
                        v.i("MicroMsg.Updater", "channel pack, not silence download.");
                        g.iuh.a(405, 55, 1, true);
                        this.ngF.ngz = false;
                    }
                    if (this.ngF.nfp == 2 && !this.ngF.ngA) {
                        Nd = h.Nd();
                        if (!(c.yO(aVar.bsc()) == null || be.kS(Nd) || !Nd.equals(aVar.bsc()))) {
                            v.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", Nd);
                            g.iuh.a(405, 56, 1, true);
                            return;
                        }
                    }
                    zv bmz = aVar.bmz();
                    if (bmz == null || bmz.mBq == 0 || be.kS(bmz.mBr)) {
                        if (this.ngF.ngz) {
                            v.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            g.iuh.a(405, 58, 1, true);
                            ak.vy().a(725, this.ngF.ngB = new e(this) {
                                final /* synthetic */ AnonymousClass3 ngG;

                                public final void a(int i, int i2, String str, k kVar) {
                                    ak.vy().b(221, this.ngG.ngF.ngB);
                                    this.ngG.ngF.ngB = null;
                                    if (i == 0 && i2 == 0) {
                                        long j;
                                        r rVar = (r) kVar;
                                        if (((ys) rVar.cYO.czk.czs).efm == 0) {
                                            String str2 = ((yt) rVar.cYO.czl.czs).hQP;
                                            if (!be.kS(str2)) {
                                                Map q = bf.q(str2, "resourcecontrolinfo");
                                                if (q != null) {
                                                    str2 = (String) q.get(".resourcecontrolinfo.enableupdate");
                                                    String str3 = (String) q.get(".resourcecontrolinfo.expiredtime");
                                                    v.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", q);
                                                    if (be.getInt(str2, 1) == 0) {
                                                        j = be.getLong(str3, 0);
                                                        if (j > System.currentTimeMillis() / 1000) {
                                                            v.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                                            g.iuh.a(405, 0, 1, true);
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        j = 0;
                                        if (j > System.currentTimeMillis() / 1000) {
                                            v.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                            g.iuh.a(405, 0, 1, true);
                                            return;
                                        }
                                    }
                                    v.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                                    g.iuh.a(405, 59, 1, true);
                                    Intent intent = new Intent(this.ngG.ngF.getContext(), UpdaterService.class);
                                    Updater.a(this.ngG.ngF, intent, eVar, aVar);
                                    intent.putExtra("intent_extra_run_in_foreground", true);
                                    intent.putExtra("intent_extra_download_mode", 2);
                                    this.ngG.ngF.getContext().startService(intent);
                                }
                            });
                            ak.vy().a(new r(), 0);
                        } else {
                            v.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(this.ngF.getContext(), AppUpdaterUI.class);
                            Updater.a(this.ngF, intent, eVar, aVar);
                            v.i("MicroMsg.Updater", "current updateType : %s", Integer.valueOf(this.ngF.nfp));
                            if (this.ngF.nfp == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                g.iuh.a(405, 60, 1, true);
                            } else {
                                g.iuh.a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            this.ngF.getContext().startActivity(intent);
                        }
                        com.tencent.mm.p.c.us().s(262145, true);
                        com.tencent.mm.pluginsdk.model.app.a.bng();
                        return;
                    }
                    Nd = bmz.mBr;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", Nd);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.ay.c.b(this.ngF.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    h.bsu();
                    g.iuh.a(405, 57, 1, true);
                }
            }), 0);
            onStop();
            return;
        }
        g.iuh.a(405, 62, 1, true);
        if (this.ngx != null) {
            p pVar = this.ngx;
            if (pVar.dVb != null) {
                pVar.dVb.setVisibility(8);
            }
            TextView textView = (TextView) this.ngx.findViewById(2131755640);
            if (i == 4 && i2 == -18) {
                if (textView != null) {
                    g.iuh.a(405, 63, 1, true);
                    textView.setText(2131235721);
                }
            } else if (textView != null) {
                g.iuh.a(405, 64, 1, true);
                textView.setText(2131235712);
                com.tencent.mm.pluginsdk.ui.d.e.e(textView, 1);
            }
        }
        h.bsy();
        cancel();
    }

    private void cancel() {
        ak.vy().b(11, (e) this);
    }

    public final void update(int i) {
        S(i, false);
    }

    public final void S(int i, boolean z) {
        v.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + i);
        this.nfp = i;
        this.ngA = z;
        g.iuh.a(405, 44, 1, true);
        ak.vy().a(new a(i), 0);
    }

    public static void c(String str, int i, String str2, String str3) {
        Intent intent = new Intent(aa.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", d.lWh);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", f.aPY);
        intent.putExtra("intent_extra_marketUrl", f.nhW);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        g.iuh.a(405, 45, 1, true);
        aa.getContext().startService(intent);
    }

    public static void uT(int i) {
        if (ak.uz()) {
            v.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + i);
            ak.yW();
            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.q(i));
        }
    }
}
