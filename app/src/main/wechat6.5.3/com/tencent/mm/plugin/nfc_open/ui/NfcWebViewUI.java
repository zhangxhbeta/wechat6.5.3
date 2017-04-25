package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private String hIk = null;
    private boolean hIl = false;
    private a hIm = new a();

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] enx = new int[AutoLoginActivity.a.values().length];

        static {
            try {
                enx[AutoLoginActivity.a.lFV.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                enx[AutoLoginActivity.a.lFW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                enx[AutoLoginActivity.a.lFX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.c.a.nhr.e(this.hIm);
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.NfcWebViewUI", "onCreate intent is null");
            finish();
            return;
        }
        c.brh();
        v.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NfcWebViewUI hIn;

            {
                this.hIn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.hIn.hIl) {
                    this.hIn.aDZ();
                } else {
                    this.hIn.finish();
                }
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        hz(false);
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.hIm);
    }

    protected final void aqj() {
        if (aDX()) {
            finish();
            v.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            return;
        }
        super.aqj();
        a(AutoLoginActivity.a.lFV, getIntent());
    }

    public void onNewIntent(Intent intent) {
        if (intent == null) {
            v.i("MicroMsg.NfcWebViewUI", "onNewIntent, intent null");
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        int a = r.a(intent, "wizard_activity_result_code", Integer.MAX_VALUE);
        v.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = " + a);
        if (a != Integer.MAX_VALUE) {
            this.hIl = true;
        }
        switch (a) {
            case -1:
                a(AutoLoginActivity.a.lFV, intent);
                break;
            case 0:
                aDX();
                return;
            case 1:
                a(AutoLoginActivity.a.lFX, intent);
                break;
        }
        eI(true);
        v.i("Foreground dispatch", "Discovered tag with intent: " + intent);
    }

    private boolean aDX() {
        try {
            if (!this.liH.bjE()) {
                return false;
            }
            v.w("MicroMsg.NfcWebViewUI", "not login");
            Intent intent = new Intent(this, getClass());
            intent.putExtras(getIntent());
            intent.addFlags(67108864);
            this.liH.N(intent);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            return true;
        }
    }

    private void a(AutoLoginActivity.a aVar, Intent intent) {
        switch (AnonymousClass3.enx[aVar.ordinal()]) {
            case 1:
                Tag tag;
                Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
                if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) parcelableExtra;
                }
                if (tag == null) {
                    v.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.b.a.a.aDU().a(tag);
                    v.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : " + com.tencent.mm.plugin.nfc.b.a.a.aDU().cm(this.nDR.nEl));
                    return;
                } catch (Exception e) {
                    v.e("MicroMsg.NfcWebViewUI", "exp protect");
                    return;
                }
            default:
                finish();
                return;
        }
    }

    protected final void eI(boolean z) {
        if (this.liH == null) {
            v.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            return;
        }
        a(AutoLoginActivity.a.lFV, getIntent());
        String aDY = aDY();
        String str = this.bpX;
        if (!z || be.kS(this.bpX) || this.bpX.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error")) {
            this.bpX = aDY;
            if (be.kS(this.bpX)) {
                this.bpX = nF(0);
                v.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
            }
            getIntent().putExtra("rawUrl", this.bpX);
            if (!this.bpX.equals(str)) {
                v.i("MicroMsg.NfcWebViewUI", "lo-nfc-dealwithNFC: onNewIntent load:" + this.bpX);
                this.igd.loadUrl(this.bpX);
                return;
            }
            return;
        }
        try {
            int i;
            if (!be.kS(aDY)) {
                try {
                    Uri parse = Uri.parse(aDY);
                    Uri parse2 = Uri.parse(this.bpX);
                    aDY = parse.getHost();
                    str = parse2.getHost();
                    v.i("MicroMsg.NfcWebViewUI", "targetHost=" + aDY + ", curHost=" + str);
                    if (aDY.equals(str)) {
                        i = 1;
                        if (i != 0) {
                            this.leB.g(4007, new Bundle());
                        }
                        v.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
                    }
                } catch (Exception e) {
                }
            }
            i = 0;
            if (i != 0) {
                this.leB.g(4007, new Bundle());
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
        v.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
    }

    private static String nF(int i) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!f.nia && u.bsY().equals("zh_CN")) {
            str = "zh_CN";
        } else if (u.bsW()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        return stringBuilder.toString();
    }

    private String aDY() {
        String str = null;
        v.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle i = this.liH.i(4006, null);
            if (i == null) {
                v.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                return str;
            }
            i.setClassLoader(getClass().getClassLoader());
            String string = i.getString("debugConfig");
            String string2 = i.getString("config");
            if (string != null) {
                str = xl(string);
            } else {
                str = xm(string2);
            }
            v.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + be.ma(str));
            return str;
        } catch (Throwable e) {
            v.e("MicroMsg.NfcWebViewUI", e.toString());
            v.a("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
        }
    }

    private String xl(String str) {
        v.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.hIk = "";
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    String str2 = split[i];
                    String str3 = split[i + 1];
                    v.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.xk(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.hIk = split[split.length - 1];
                    v.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.hIk);
                    return this.hIk;
                }
            }
            return this.hIk;
        } catch (Throwable e) {
            v.a("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            v.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            v.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.b.a.a.aDU().cl(this.nDR.nEl));
            this.hIk = nF(1);
            return this.hIk;
        }
    }

    private String xm(String str) {
        v.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.hIk = "";
        aki com_tencent_mm_protocal_c_aki = new aki();
        if (!be.kS(str)) {
            try {
                com_tencent_mm_protocal_c_aki.az(str.getBytes("ISO-8859-1"));
                if (com_tencent_mm_protocal_c_aki.mov != null) {
                    int i = 0;
                    int i2 = 0;
                    while (i2 < com_tencent_mm_protocal_c_aki.mov.size()) {
                        it itVar = (it) com_tencent_mm_protocal_c_aki.mov.get(i2);
                        if (!(itVar == null || be.kS(itVar.lYG) || be.bP(itVar.mkd))) {
                            String str2;
                            int i3 = 0;
                            int i4 = i;
                            while (i3 < itVar.mkd.size()) {
                                if (!be.bP(((lv) itVar.mkd.get(i3)).moy)) {
                                    int i5 = 0;
                                    while (i5 < ((lv) itVar.mkd.get(i3)).moy.size()) {
                                        if (((lv) itVar.mkd.get(i3)).moy.get(i5) != null && !be.kS(((ky) ((lv) itVar.mkd.get(i3)).moy.get(i5)).aWW) && !be.kS(((ky) ((lv) itVar.mkd.get(i3)).moy.get(i5)).hbw)) {
                                            String str3 = ((ky) ((lv) itVar.mkd.get(i3)).moy.get(i5)).aWW;
                                            str2 = ((ky) ((lv) itVar.mkd.get(i3)).moy.get(i5)).hbw;
                                            v.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str3 + " anwser = " + str2);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.xk(str3)), str2)) {
                                                i = 0;
                                                break;
                                            }
                                            i = 1;
                                        } else {
                                            i = i4;
                                        }
                                        i5++;
                                        i4 = i;
                                    }
                                    i = i4;
                                    if (i != 0) {
                                        break;
                                    }
                                } else {
                                    i = i4;
                                }
                                i3++;
                                i4 = i;
                            }
                            i = i4;
                            if (i != 0) {
                                str2 = itVar.lYG;
                                v.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                e.a(new Runnable(this) {
                                    final /* synthetic */ NfcWebViewUI hIn;

                                    public final void run() {
                                        g.iuh.h(12794, new Object[]{str2, Integer.valueOf(0)});
                                        v.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + str2);
                                    }
                                }, getClass().getName());
                                return itVar.lYG;
                            }
                        }
                        i2++;
                        i = i;
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                v.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                v.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.b.a.a.aDU().cl(this.nDR.nEl));
                this.hIk = nF(1);
                return this.hIk;
            }
        }
        return this.hIk;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        boolean z;
        v.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        CharSequence cVar = com.tencent.mm.plugin.nfc.b.a.a.aDU().a(aVar).toString();
        if (!be.kS(cVar)) {
            v.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + be.ma(str) + " resp = " + be.ma(cVar));
            if (Pattern.compile(str, 2).matcher(cVar).find()) {
                z = true;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        if (this.hIl) {
            aDZ();
        } else {
            super.onBackPressed();
        }
    }

    private void aDZ() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        c.a(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(2130968589, 2130968642);
        v.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    }
}
