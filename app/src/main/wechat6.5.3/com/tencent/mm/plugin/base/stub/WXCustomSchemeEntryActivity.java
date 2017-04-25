package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.fm;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.CheckSmsCanAddCardUI;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> enK;

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.enK = new ArrayList();
        this.enK.add("cardpackage");
        this.enK.add("connectToFreeWifi");
        this.enK.add("wap");
        super.onCreate(bundle);
        vB(0);
    }

    protected final int getLayoutId() {
        return 2130903183;
    }

    protected final boolean p(Intent intent) {
        Uri data;
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            v.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e.getMessage());
            data = null;
        }
        if (data != null) {
            if (d.Gb(data.toString())) {
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            v.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", data.toString(), scheme, host, query);
            if (!be.kS(host) && this.enK.contains(host)) {
                v.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    v.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", scheme);
                    if (!be.kS(scheme) && scheme.length() < 1024) {
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!be.kS(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        v.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                        if (!be.kS(scheme) && scheme.length() < 1024) {
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    v.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    return true;
                }
            }
        }
        finish();
        return false;
    }

    protected final void a(a aVar, Intent intent) {
        switch (aVar) {
            case LOGIN_OK:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    v.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                    data = null;
                }
                if (data != null) {
                    int i;
                    if (data != null) {
                        int a;
                        if (intent != null) {
                            a = r.a(intent, "translate_link_scene", 2);
                        } else {
                            a = 2;
                        }
                        String host;
                        if (!d.Gb(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            Object query = data.getQuery();
                            v.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", scheme, host, query);
                            if (!be.kS(host) && this.enK.contains(host)) {
                                if (host.equals("cardpackage") && !be.kS(data.getQueryParameter("encrystr"))) {
                                    intent.setClass(this, CheckSmsCanAddCardUI.class);
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!be.kS(query) && query.startsWith("apKey=")) {
                                        String queryParameter = data.getQueryParameter("apKey");
                                        v.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", queryParameter);
                                        scheme = data.getQueryParameter("ticket");
                                        if (!be.kS(queryParameter) && queryParameter.length() < 1024) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", queryParameter);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!be.kS(scheme)) {
                                                intent2.putExtra("free_wifi_schema_ticket", scheme);
                                            }
                                            if (queryParameter.startsWith("_") || be.kS(scheme)) {
                                                intent2.addFlags(67108864);
                                                c.b((Context) this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                b fmVar = new fm();
                                                fmVar.beQ.intent = intent2;
                                                com.tencent.mm.sdk.c.a.nhr.z(fmVar);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        c.b((Context) this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        v.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    v.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY");
                                    if (!TextUtils.isEmpty(query)) {
                                        e.a((Context) this, com.tencent.mm.pluginsdk.h.a.Gm(query), false);
                                    }
                                }
                            }
                        } else if (d.i(data)) {
                            v.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", data.toString(), Boolean.valueOf(d.j(data)));
                            if (d.j(data)) {
                                d.a(this, data.toString(), a, new d.a(this) {
                                    final /* synthetic */ WXCustomSchemeEntryActivity enL;

                                    {
                                        this.enL = r1;
                                    }

                                    public final void a(int i, int i2, String str, k kVar, boolean z) {
                                        v.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                        if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof af))) {
                                            bad Jy = ((af) kVar).Jy();
                                            if (!(Jy == null || this.enL.isFinishing())) {
                                                s.makeText(this.enL, this.enL.getString(2131231164) + " : " + be.ma(Jy.mWM), 0).show();
                                            }
                                        }
                                        this.enL.finish();
                                    }
                                });
                                i = 1;
                                if (i != 0) {
                                    return;
                                }
                            }
                            d.a(this, data.toString(), a, new d.a(this) {
                                final /* synthetic */ WXCustomSchemeEntryActivity enL;

                                {
                                    this.enL = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    this.enL.finish();
                                }
                            });
                        } else if (d.Gc(data.toString())) {
                            d.a((Context) this, data.toString(), a, new d.a(this) {
                                final /* synthetic */ WXCustomSchemeEntryActivity enL;

                                {
                                    this.enL = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    v.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof af))) {
                                        bad Jy = ((af) kVar).Jy();
                                        if (!(Jy == null || this.enL.isFinishing())) {
                                            s.makeText(this.enL, this.enL.getString(2131231164) + " : " + be.ma(Jy.mWM), 0).show();
                                        }
                                    }
                                    this.enL.finish();
                                }
                            }, intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            i = 1;
                            if (i != 0) {
                                return;
                            }
                        } else {
                            host = com.tencent.mm.model.k.xF();
                            v.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", data.toString());
                            d.a((Context) this, data.toString(), host, 23, data.toString(), new d.a(this) {
                                final /* synthetic */ WXCustomSchemeEntryActivity enL;

                                {
                                    this.enL = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    this.enL.finish();
                                }
                            });
                        }
                    }
                    boolean z = false;
                    if (i != 0) {
                        return;
                    }
                }
                break;
        }
        finish();
    }
}
