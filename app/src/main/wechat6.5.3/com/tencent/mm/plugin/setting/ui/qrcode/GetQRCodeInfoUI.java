package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class GetQRCodeInfoUI extends MMBaseActivity implements e {
    private ProgressDialog dwR = null;
    private y iJq;

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        if (!be.kS(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            ak.vy().a(106, getQRCodeInfoUI);
            getQRCodeInfoUI.iJq = new y(str2, 5);
            ak.vy().a(getQRCodeInfoUI.iJq, 0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903518);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            return;
        }
        String ma = be.ma(data.getHost());
        String ma2 = be.ma(data.getScheme());
        if (("http".equals(ma2) && "weixin.qq.com".equals(ma)) || ("weixin".equals(ma2) && "qr".equals(ma))) {
            ak.vy().a(new ay(new a(this) {
                final /* synthetic */ GetQRCodeInfoUI iJr;

                {
                    this.iJr = r1;
                }

                public final void a(com.tencent.mm.network.e eVar) {
                    if (eVar == null) {
                        this.iJr.finish();
                    } else if (!ak.uz() || ak.uG()) {
                        com.tencent.mm.plugin.setting.a.drp.t(new Intent(), this.iJr);
                        this.iJr.finish();
                    } else {
                        GetQRCodeInfoUI.a(this.iJr, this.iJr.getIntent().getDataString());
                    }
                }
            }), 0);
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        getString(2131231164);
        this.dwR = g.a(this, getString(2131230873), true, new OnCancelListener(this) {
            final /* synthetic */ GetQRCodeInfoUI iJr;

            {
                this.iJr = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.iJr.finish();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iJq != null) {
            ak.vy().c(this.iJq);
        }
        ak.vy().b(106, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 4 && i2 == -2004) {
            g.a(this, 2131234269, 2131231164, new OnClickListener(this) {
                final /* synthetic */ GetQRCodeInfoUI iJr;

                {
                    this.iJr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iJr.finish();
                }
            });
        } else if (i == 0 && i2 == 0) {
            ars Jx = ((y) kVar).Jx();
            String a = m.a(Jx.moM);
            n.AX().g(a, m.a(Jx.mbY));
            com.tencent.mm.plugin.setting.a.drq.a(new Intent(), Jx, 30);
            if (be.ma(a).length() > 0) {
                if ((Jx.mFu & 8) > 0) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10298, a + ",30");
                }
                c.b(this, "profile", ".ui.ContactInfoUI", 1);
            }
        } else {
            g.a(this, getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(2131231164), new OnClickListener(this) {
                final /* synthetic */ GetQRCodeInfoUI iJr;

                {
                    this.iJr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iJr.finish();
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.plugin.setting.a.drp.t(new Intent(), this);
        finish();
    }
}
