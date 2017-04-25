package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.n;

@a(3)
public class OrderHandlerUI extends MMActivity implements e {
    private int cVh = 0;
    private String enO;
    private c hSc = new c<qp>(this) {
        final /* synthetic */ OrderHandlerUI kXD;

        {
            this.kXD = r2;
            this.nhz = qp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qp qpVar = (qp) bVar;
            if (qpVar instanceof qp) {
                this.kXD.kXB = true;
                v.e("MicroMsg.OrderHandlerUI", "onPayEnd, isOk = " + qpVar.bsg.bpc);
                if (qpVar.bsg.bpc == -1) {
                    Bundle extras = qpVar.bsg.intent.getExtras();
                    String string = extras.getString("intent_pay_app_url");
                    this.kXD.kXC = extras.getString("intent_wap_pay_jump_url");
                    v.d("MicroMsg.OrderHandlerUI", "onPayEnd, returnUrl = " + string);
                    this.kXD.kXz.errCode = 0;
                    this.kXD.kXz.nhR = string;
                } else {
                    this.kXD.kXz.errCode = -2;
                }
                if (this.kXD.cVh == 1) {
                    OrderHandlerUI.aE(qpVar.bsg.context, this.kXD.kXC);
                } else {
                    a.a(qpVar.bsg.context, this.kXD.enO, this.kXD.kXz, this.kXD.kXA);
                }
                this.kXD.finish();
            } else {
                v.f("MicroMsg.OrderHandlerUI", "mismatched event");
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.g.a.a kXA;
    private boolean kXB = false;
    private String kXC = "";
    private com.tencent.mm.sdk.g.a kXy;
    private com.tencent.mm.sdk.g.b kXz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(8);
        n.bLg();
        com.tencent.mm.sdk.c.a.nhr.e(this.hSc);
    }

    protected void onResume() {
        Throwable th;
        super.onResume();
        com.tencent.mm.sdk.g.a aVar = new com.tencent.mm.sdk.g.a();
        aVar.u(getIntent().getExtras());
        if (this.kXy == null || !(aVar.kXw == null || aVar.kXw.equals(this.kXy.kXw))) {
            this.kXy = aVar;
            this.cVh = getIntent().getIntExtra("key_scene", 0);
            v.i("MicroMsg.OrderHandlerUI", "onCreate() mScene is " + this.cVh);
            if (this.cVh == 0) {
                this.enO = getIntent().getStringExtra("_mmessage_appPackage");
                if (this.enO == null || this.enO.length() == 0) {
                    v.e("MicroMsg.OrderHandlerUI", "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    return;
                }
            }
            this.kXA = new com.tencent.mm.sdk.g.a.a();
            this.kXA.u(getIntent().getExtras());
            this.kXz = new com.tencent.mm.sdk.g.b();
            this.kXz.kXw = aVar.kXw;
            this.kXz.nhO = aVar.nhO;
            String str = "";
            if (this.cVh == 0) {
                boolean z;
                if (aVar.appId == null || aVar.appId.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid appId");
                    z = false;
                } else if (aVar.bkj == null || aVar.bkj.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid partnerId");
                    z = false;
                } else if (aVar.kXw == null || aVar.kXw.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid prepayId");
                    z = false;
                } else if (aVar.bkl == null || aVar.bkl.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid nonceStr");
                    z = false;
                } else if (aVar.bkm == null || aVar.bkm.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid timeStamp");
                    z = false;
                } else if (aVar.nhN == null || aVar.nhN.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid packageValue");
                    z = false;
                } else if (aVar.fZW == null || aVar.fZW.length() == 0) {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid sign");
                    z = false;
                } else if (aVar.nhO == null || aVar.nhO.length() <= 1024) {
                    z = true;
                } else {
                    v.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, extData length too long");
                    z = false;
                }
                if (!z) {
                    v.e("MicroMsg.OrderHandlerUI", "onCreate, PayReq checkArgs fail");
                    this.kXz.errCode = -1;
                    this.kXz.egi = getString(2131234141);
                    a.a(this, this.enO, this.kXz, this.kXA);
                    finish();
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    v.e("MicroMsg.OrderHandlerUI", "onCreate, checkAppResult fail");
                    this.kXz.errCode = -1;
                    a.a(this, this.enO, this.kXz, this.kXA);
                    finish();
                    return;
                }
            } else if (this.cVh == 1) {
                str = "WAP";
            }
            String stringExtra = getIntent().getStringExtra("_mmessage_appPackage");
            String str2 = "";
            String str3 = "";
            try {
                getPackageManager().getPackageInfo(stringExtra, 0);
                String str4 = (String) getPackageManager().getPackageInfo(stringExtra, 0).applicationInfo.loadLabel(getPackageManager());
                try {
                    Signature[] aN = p.aN(this, stringExtra);
                    if (aN == null || aN.length == 0) {
                        v.e("MicroMsg.AppUtil", "signs is null");
                        str2 = null;
                    } else {
                        str2 = g.m(aN[0].toByteArray());
                    }
                    str3 = str2;
                    str2 = str4;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    str2 = str4;
                    th = th2;
                    v.a("MicroMsg.OrderHandlerUI", th, "", new Object[0]);
                    v.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                    ak.vy().a(397, this);
                    ak.vy().a(new com.tencent.mm.plugin.wallet_index.c.b(aVar, str, stringExtra, str2, str3), 0);
                }
            } catch (NameNotFoundException e2) {
                th = e2;
                v.a("MicroMsg.OrderHandlerUI", th, "", new Object[0]);
                v.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                ak.vy().a(397, this);
                ak.vy().a(new com.tencent.mm.plugin.wallet_index.c.b(aVar, str, stringExtra, str2, str3), 0);
            }
            v.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
            ak.vy().a(397, this);
            ak.vy().a(new com.tencent.mm.plugin.wallet_index.c.b(aVar, str, stringExtra, str2, str3), 0);
        }
    }

    protected void onDestroy() {
        ak.vy().b(397, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.hSc);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904143;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 397) {
            ak.vy().b(397, this);
            v.i("MicroMsg.OrderHandlerUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            com.tencent.mm.plugin.wallet_index.c.b bVar = (com.tencent.mm.plugin.wallet_index.c.b) kVar;
            alm com_tencent_mm_protocal_c_alm = (alm) bVar.cif.czl.czs;
            this.kXC = com_tencent_mm_protocal_c_alm == null ? null : com_tencent_mm_protocal_c_alm.mMt;
            if (i == 4 && i2 == -5) {
                v.e("MicroMsg.OrderHandlerUI", "onSceneEnd, auth access denied");
                this.kXz.errCode = -1;
                av(str, true);
            } else if (i == 0 && i2 == 0) {
                com_tencent_mm_protocal_c_alm = (alm) bVar.cif.czl.czs;
                int i3 = com_tencent_mm_protocal_c_alm == null ? -1 : com_tencent_mm_protocal_c_alm.fvC;
                com_tencent_mm_protocal_c_alm = (alm) bVar.cif.czl.czs;
                String str2 = com_tencent_mm_protocal_c_alm == null ? null : com_tencent_mm_protocal_c_alm.fvD;
                com_tencent_mm_protocal_c_alm = (alm) bVar.cif.czl.czs;
                String str3 = com_tencent_mm_protocal_c_alm == null ? null : com_tencent_mm_protocal_c_alm.mvt;
                com_tencent_mm_protocal_c_alm = (alm) bVar.cif.czl.czs;
                v.d("MicroMsg.OrderHandlerUI", "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[]{Integer.valueOf(i3), str2, str3, com_tencent_mm_protocal_c_alm == null ? null : com_tencent_mm_protocal_c_alm.mvu});
                if (be.kS(str3)) {
                    v.e("MicroMsg.OrderHandlerUI", "onSceneEnd, respPrepayId is null");
                    this.kXz.errCode = -1;
                    av(str, true);
                    return;
                }
                PayInfo payInfo = new PayInfo();
                payInfo.appId = this.kXy.appId;
                payInfo.fTG = str3;
                payInfo.bkj = this.kXy.bkj;
                payInfo.lVB = this.kXy.fZW;
                if (this.cVh == 1) {
                    payInfo.bkq = 36;
                } else {
                    payInfo.bkq = 2;
                }
                payInfo.kXn = r0;
                payInfo.lVC = String.valueOf(i3);
                payInfo.biS = str2;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 123);
                this.kXB = false;
            } else {
                v.e("MicroMsg.OrderHandlerUI", "onSceneEnd,  PayAuthApp is failed!");
                this.kXz.errCode = -1;
                av(str, true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.kXz != null && !this.kXB) {
            v.e("MicroMsg.OrderHandlerUI", "onActivityResult, onPayEnd not called");
            this.kXz.errCode = -2;
            av("", false);
        }
    }

    private void av(String str, boolean z) {
        if (this.cVh != 1) {
            a.a(this, this.enO, this.kXz, this.kXA);
            finish();
        } else if (TextUtils.isEmpty(this.kXC) && z) {
            oa(0);
            if (TextUtils.isEmpty(str)) {
                str = getString(2131236492);
            }
            com.tencent.mm.ui.base.g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ OrderHandlerUI kXD;

                {
                    this.kXD = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kXD.finish();
                }
            });
        } else {
            aE(this, this.kXC);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v.i("MicroMsg.OrderHandlerUI", "onConfigurationChanged");
    }

    private static void aE(Context context, String str) {
        if (context == null) {
            v.e("MicroMsg.OrderHandlerUI", "startOuterApp context == null");
        } else if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is empty");
        } else {
            v.i("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (be.m(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
