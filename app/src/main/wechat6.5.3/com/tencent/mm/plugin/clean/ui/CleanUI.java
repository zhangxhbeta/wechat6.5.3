package com.tencent.mm.plugin.clean.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.plugin.clean.b.e;
import com.tencent.mm.plugin.clean.b.f;
import com.tencent.mm.plugin.clean.b.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CleanUI extends MMActivity implements f, g {
    private ProgressDialog dwR;
    private e eVG;
    private c eVO;
    private View eVP;
    private PieView eVQ;
    private TextView eVR;
    private Button eVS;
    private Button eVT;
    private TextView eVU;
    private TextView eVV;
    private TextView eVW;
    private TextView eVX;
    private TextView eVY;
    private JSONObject eVZ;
    private long eWa;
    private String eWb = "com.tencent.qqpimsecure";
    private String eWc = "00B1208638DE0FCD3E920886D658DAF6";
    private String eWd = "11206657";

    static /* synthetic */ long adZ() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        if (d.Tu() == null) {
            return 0;
        }
        Iterator it = d.Tu().iterator();
        long j = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.eUn != null) {
                Iterator it2 = bVar.eUn.iterator();
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    if (aVar.dhI < timeInMillis) {
                        j += aVar.size;
                    }
                }
            }
            j = j;
        }
        return j;
    }

    static /* synthetic */ ArrayList aea() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (int size = d.Tu().size() - 1; size >= 0; size--) {
            b bVar = (b) d.Tu().get(size);
            for (int size2 = bVar.eUn.size() - 1; size2 >= 0; size2--) {
                if (((a) bVar.eUn.get(size2)).dhI < timeInMillis) {
                    arrayList.add(bVar.eUn.get(size2));
                    bVar.eUn.remove(size2);
                }
            }
            if (!bVar.adF()) {
                d.Tu().remove(size);
            }
        }
        return arrayList;
    }

    static /* synthetic */ void e(CleanUI cleanUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(cleanUI.getString(2131234285));
        arrayList2.add(Integer.valueOf(0));
        com.tencent.mm.ui.base.g.a(cleanUI, null, arrayList, arrayList2, null, false, new com.tencent.mm.ui.base.g.d(cleanUI) {
            final /* synthetic */ CleanUI eWe;

            {
                this.eWe = r1;
            }

            public final void bw(int i, int i2) {
                switch (i2) {
                    case 0:
                        if (CleanUI.adZ() > 0) {
                            com.tencent.mm.ui.base.g.b(this.eWe, this.eWe.getString(2131231936, new Object[]{be.aw(r2)}), "", this.eWe.getString(2131232277), this.eWe.getString(2131231565), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass7 eWg;

                                {
                                    this.eWg = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.eWg.eWe.eVG = new e(d.adN(), this.eWg.eWe, CleanUI.aea());
                                    this.eWg.eWe.eVG.start();
                                    this.eWg.eWe.dwR.show();
                                }
                            }, null);
                            return;
                        }
                        Toast.makeText(this.eWe, 2131234062, 0).show();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.iuh.a(282, 3, 1, false);
        if (getIntent().getBooleanExtra("had_detected_no_sdcard_space", false) && adY()) {
            finish();
            return;
        }
        d.adS();
        this.eVR = (TextView) findViewById(2131756340);
        this.eVQ = (PieView) findViewById(2131756339);
        this.eVS = (Button) findViewById(2131756356);
        this.eVT = (Button) findViewById(2131756357);
        this.eVP = findViewById(2131756341);
        this.eVU = (TextView) findViewById(2131756345);
        this.eVU.setTextSize(1, 20.0f);
        this.eVV = (TextView) findViewById(2131756349);
        this.eVV.setTextSize(1, 20.0f);
        this.eVW = (TextView) findViewById(2131756353);
        this.eVW.setTextSize(1, 20.0f);
        this.eVX = (TextView) findViewById(2131756354);
        this.eVY = (TextView) findViewById(2131756355);
        vD(2131231937);
        d.a(new com.tencent.mm.plugin.clean.b.a.b());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanUI eWe;

            {
                this.eWe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eWe.finish();
                return false;
            }
        });
        this.eVS.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CleanUI eWe;

            {
                this.eWe = r1;
            }

            public final void onClick(View view) {
                this.eWe.startActivityForResult(new Intent(this.eWe, CleanChattingUI.class), 0);
                com.tencent.mm.plugin.report.service.g.iuh.a(282, 4, 1, false);
            }
        });
        this.eVT.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ CleanUI eWe;

            {
                this.eWe = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.iuh.a(282, 5, 1, false);
                if (!this.eWe.adY()) {
                    if (this.eWe.adX()) {
                        com.tencent.mm.ui.base.g.b(this.eWe, this.eWe.getString(2131231929, new Object[]{be.ed(this.eWe.eWa)}), "", this.eWe.getString(2131231024), this.eWe.getString(2131231010), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 eWf;

                            {
                                this.eWf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    v.i("MicroMsg.CleanUI", "download url:%s, md5:%s", new Object[]{new URL(this.eWf.eWe.eVZ.getString("url")), this.eWf.eWe.eVZ.getString("md5")});
                                    com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
                                    aVar.GR("wesecure.apk");
                                    aVar.GQ(r0.toString());
                                    aVar.hO(true);
                                    aVar.GS(r1);
                                    aVar.tE(1);
                                    com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn);
                                } catch (Throwable e) {
                                    v.a("MicroMsg.CleanUI", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.iuh.a(282, 7, 1, false);
                            }
                        }, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(this.eWe.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        a(0, 2131165201, new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanUI eWe;

            {
                this.eWe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                CleanUI.e(this.eWe);
                return false;
            }
        });
        U(0, false);
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a(this, getString(2131231926), false, new OnCancelListener(this) {
            final /* synthetic */ CleanUI eWe;

            {
                this.eWe = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.dwR.dismiss();
        if (d.Tu() != null) {
            this.eVR.setVisibility(8);
            this.eVS.setEnabled(true);
            this.eVT.setEnabled(true);
            U(0, true);
            d.adP();
            aS(d.adO());
        } else {
            com.tencent.mm.plugin.clean.b.a.b adN = d.adN();
            if (adN != null) {
                this.eVO = new c(adN, this);
                com.tencent.mm.sdk.i.e.a(this.eVO, "CleanUI_clean");
                this.eVR.setText(getString(2131230897, new Object[]{"0%"}));
            }
        }
        if (be.bup() || com.tencent.mm.sdk.platformtools.f.aPW == 1) {
            this.eVT.setVisibility(8);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            com.tencent.mm.sdk.d.b.b bVar = new com.tencent.mm.sdk.d.b.b();
            bVar.nhG = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            com.tencent.mm.sdk.d.b aVar = new com.tencent.mm.sdk.d.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection());
            com.tencent.mm.sdk.i.e.a(new com.tencent.mm.sdk.d.b.AnonymousClass1(aVar, bVar, new com.tencent.mm.sdk.d.b.c(this, "") {
                final /* synthetic */ CleanUI eWe;

                public final void onComplete() {
                    v.d("MicroMsg.CleanUI", "request onComplete:%s", new Object[]{this.content});
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.nrM, this.content);
                    } catch (Throwable e) {
                        v.a("MicroMsg.CleanUI", e, "", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.iuh.a(282, 8, 1, false);
                    }
                }
            }, new ac()), aVar.getClass().getName());
        } catch (Throwable e) {
            v.a("MicroMsg.CleanUI", e, e.getMessage(), new Object[0]);
        }
    }

    private boolean adX() {
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(t.a.nrM, "");
        if (be.kS(str)) {
            return false;
        }
        try {
            this.eVZ = new JSONObject(str);
            this.eWb = this.eVZ.getString("packageName");
            this.eVZ.get("md5");
            this.eWd = this.eVZ.getString("launcherID");
            this.eWc = this.eVZ.getString("signature");
            this.eVZ.get("url");
            this.eWa = this.eVZ.getLong("size");
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.CleanUI", e, "", new Object[0]);
            return false;
        }
    }

    private boolean adY() {
        adX();
        if (!p.o(this.nDR.nEl, this.eWb)) {
            return false;
        }
        Signature[] aN = p.aN(this, this.eWb);
        if (aN == null || aN[0] == null) {
            return false;
        }
        String m = com.tencent.mm.a.g.m(aN[0].toByteArray());
        if (m == null || !m.equalsIgnoreCase(this.eWc)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.eWb);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                p.b(bundle, this.eWd);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(268435456);
                startActivity(launchIntentForPackage);
                com.tencent.mm.plugin.report.service.g.iuh.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.CleanUI", e, "", new Object[0]);
        }
        return true;
    }

    protected final int getLayoutId() {
        return 2130903382;
    }

    private void aS(long j) {
        int i = 5;
        long adI = (c.adI() - c.adJ()) - j;
        int adI2 = (int) ((360 * j) / c.adI());
        if (adI2 >= 5) {
            i = adI2;
        }
        this.eVQ.eWr = i;
        this.eVQ.eWs = (int) ((360 * adI) / c.adI());
        this.eVQ.dyp = 1;
        this.eVP.setVisibility(0);
        this.eVU.setText(be.aw(j));
        this.eVV.setText(be.aw(adI));
        this.eVW.setText(be.aw(c.adJ()));
        i = (int) ((100 * j) / c.adI());
        adI2 = (int) ((c.adJ() * 100) / c.adI());
        if (i < 10 && adI2 >= 30) {
            this.eVY.setText(getString(2131235596));
        } else if (i < 10 && adI2 < 30) {
            this.eVY.setText(getString(2131235594));
        } else if (adI2 < 30) {
            this.eVY.setText(getString(2131235595, new Object[]{i + "%"}));
        } else {
            this.eVY.setText(getString(2131235597, new Object[]{i + "%"}));
        }
        if (i <= 10 || adI2 >= 30) {
            this.eVS.setBackgroundResource(2130837802);
            this.eVS.setTextColor(getResources().getColorStateList(2131690144));
            this.eVT.setBackgroundResource(2130837799);
            this.eVT.setTextColor(getResources().getColorStateList(2131690182));
            return;
        }
        this.eVS.setBackgroundResource(2130837799);
        this.eVS.setTextColor(getResources().getColorStateList(2131690182));
        this.eVT.setBackgroundResource(2130837802);
        this.eVT.setTextColor(getResources().getColorStateList(2131690144));
    }

    protected void onDestroy() {
        if (this.eVO != null) {
            Runnable runnable = this.eVO;
            v.i("MicroMsg.CleanController", "stop CleanController");
            runnable.eUv = true;
            com.tencent.mm.sdk.i.e.H(runnable);
        }
        if (this.eVG != null) {
            this.eVG.adU();
        }
        if (d.adN() != null) {
            com.tencent.mm.plugin.clean.b.a.b adN = d.adN();
            for (ac removeCallbacksAndMessages : adN.eVg.values()) {
                removeCallbacksAndMessages.removeCallbacksAndMessages(null);
            }
            for (ac removeCallbacksAndMessages2 : adN.eVg.values()) {
                removeCallbacksAndMessages2.getLooper().getThread().interrupt();
                removeCallbacksAndMessages2.getLooper().quit();
            }
            v.i("MicroMsg.ThreadController", "finish thread controller");
        }
        d.adT();
        d.adR();
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        d.adP();
        aS(d.adO());
    }

    public final void bu(int i, int i2) {
        this.eVR.setText(getString(2131230897, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, ArrayList<b> arrayList) {
        v.i("MicroMsg.CleanUI", "onCleanResult: wechatSize:%d", new Object[]{Long.valueOf(j2)});
        this.eVR.setVisibility(8);
        this.eVS.setEnabled(true);
        this.eVT.setEnabled(true);
        U(0, true);
        aS(j2);
        if (j > 0) {
            this.eVX.setVisibility(0);
            this.eVX.setText(getString(2131231928, new Object[]{be.aw(j)}));
        } else {
            this.eVX.setVisibility(8);
            this.eVX.setText("");
        }
        d.aQ(j);
        d.aP(j2);
        d.s(arrayList);
    }

    public final void bv(int i, int i2) {
        this.dwR.setMessage(getString(2131231932, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void aR(long j) {
        this.dwR.dismiss();
        d.aP(d.adO() - j);
        d.aQ(d.adP() + j);
        d.adP();
        aS(d.adO());
    }
}
