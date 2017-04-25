package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.e.a.js;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.e.a.i;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class d extends c<qp> implements e {
    int kXo;
    int kXp;
    fz kXq;
    js kXr;
    long kXs;
    public c kXt;
    public c<js> kXu;

    public d() {
        this.kXp = 0;
        this.kXt = new c<fz>(this) {
            final /* synthetic */ d kXv;

            {
                this.kXv = r2;
                this.nhz = fz.class.getName().hashCode();
            }

            private boolean a(fz fzVar) {
                this.kXv.kXq = fzVar;
                String str = this.kXv.kXq.bfx.bfz;
                if (this.kXv.kXq.bfx.bfA != null) {
                    this.kXv.kXp = this.kXv.kXq.bfx.bfA.getInt("pay_channel", 0);
                }
                switch (this.kXv.kXq.bfx.actionCode) {
                    case 10:
                    case 11:
                        a.nhr.e(this.kXv);
                        v.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = " + str);
                        if (str == null) {
                            return true;
                        }
                        if (str.startsWith("weixin://wxpay")) {
                            this.kXv.kXo = 4;
                            ak.vy().a(233, this.kXv);
                            ak.vy().a(new l(str, this.kXv.kXq.bfx.username, 4), 0);
                            this.kXv.kXs = System.currentTimeMillis();
                        } else {
                            this.kXv.kXo = 1;
                            this.kXv.bi(str, this.kXv.kXp);
                        }
                        return true;
                    case 12:
                        d dVar = this.kXv;
                        v.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = " + str);
                        str = null;
                        Object obj = null;
                        String str2 = null;
                        for (String str3 : str.replace("http://p.weixin.qq.com?", "").split("&")) {
                            if (str3.startsWith("errcode=")) {
                                obj = str3.replace("errcode=", "");
                            } else if (str3.startsWith("errmsg=")) {
                                str = str3.replace("errmsg=", "");
                            } else if (str3.startsWith("importkey=")) {
                                str2 = str3.replace("importkey=", "");
                            }
                        }
                        if (!"0".equals(obj) || be.kS(str2)) {
                            if (be.kS(str)) {
                                str = dVar.kXq.bfx.context.getString(2131236492);
                            }
                            g.a(dVar.kXq.bfx.context, str, "", new OnClickListener(dVar) {
                                final /* synthetic */ d kXv;

                                {
                                    this.kXv = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.kXv.kXq.bpT != null) {
                                        this.kXv.kXq.bfy.ret = 1;
                                        this.kXv.kXq.bpT.run();
                                    }
                                }
                            });
                        } else {
                            Context context = dVar.kXq.bfx.context;
                            Intent intent = new Intent();
                            intent.putExtra("key_import_key", str2);
                            intent.putExtra("key_bind_scene", 2);
                            intent.putExtra("key_custom_bind_tips", null);
                            com.tencent.mm.ay.c.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                            if (dVar.kXq.bpT != null) {
                                dVar.kXq.bfy.ret = 1;
                                dVar.kXq.bpT.run();
                            }
                        }
                        return true;
                    default:
                        return false;
                }
            }
        };
        this.kXu = new c<js>(this) {
            final /* synthetic */ d kXv;

            {
                this.kXv = r2;
                this.nhz = js.class.getName().hashCode();
            }

            private boolean a(js jsVar) {
                this.kXv.kXr = jsVar;
                String str = jsVar.bkf.url;
                int i = jsVar.bkf.scene;
                int i2 = jsVar.bkf.bkh;
                int i3 = jsVar.bkf.aYX;
                String str2 = jsVar.bkf.aHM == null ? "" : jsVar.bkf.aHM;
                this.kXv.kXo = 1;
                v.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
                i iVar = new i(str, i, this.kXv.kXo, i2, i3, str2);
                ak.vy().a(385, this.kXv);
                ak.vy().a(iVar, 0);
                return false;
            }
        };
        this.nhz = qp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qp qpVar = (qp) bVar;
        n.bLg();
        if (qpVar instanceof qp) {
            v.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (qpVar.bsg.bpc == -1));
            a.nhr.f(this);
            if (qpVar.bsg.bpc != -1) {
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (qpVar.bsg.intent == null || qpVar.bsg.intent.getIntExtra("pay_channel", 0) != 13) {
                com.tencent.mm.ay.c.a(qpVar.bsg.context, ".ui.LauncherUI", intent);
                return true;
            }
            v.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
            return true;
        }
        v.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            long currentTimeMillis = System.currentTimeMillis() - this.kXs;
            com.tencent.mm.plugin.report.service.g.iuh.h(11170, new Object[]{Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getNetType(aa.getContext())), ""});
            b(i, i2, currentTimeMillis);
            v.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            ak.vy().b(233, this);
            if (i == 0 && i2 == 0) {
                bi(((l) kVar).IT(), this.kXp);
                return;
            }
            if (be.kS(str)) {
                str = this.kXq.bfx.context.getString(2131236492);
            }
            g.a(this.kXq.bfx.context, str, "", new OnClickListener(this) {
                final /* synthetic */ d kXv;

                {
                    this.kXv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.kXv.kXq.bpT != null) {
                        this.kXv.kXq.bfy.ret = 1;
                        this.kXv.kXq.bpT.run();
                    }
                }
            });
        } else if (kVar instanceof i) {
            v.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            ak.vy().b(385, this);
            if (i == 0 && i2 == 0 && "0".equals(((i) kVar).pjh)) {
                i iVar = (i) kVar;
                PayInfo payInfo = new PayInfo();
                payInfo.bkq = this.kXo;
                payInfo.fTG = iVar.fTG;
                payInfo.appId = iVar.appId;
                payInfo.kXn = iVar.kXn;
                payInfo.aZD = iVar.aZD;
                payInfo.bkh = iVar.bkh;
                v.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[]{payInfo.toString()});
                com.tencent.mm.pluginsdk.wallet.e.a(this.kXr.bkf.context, payInfo, 0);
                if (this.kXr.bpT != null) {
                    this.kXr.bkg.ret = 1;
                    this.kXr.bpT.run();
                    return;
                }
                return;
            }
            if (be.kS(str)) {
                if (be.kS(((i) kVar).gTq)) {
                    str = this.kXr.bkf.context.getString(2131236492);
                } else {
                    str = ((i) kVar).gTq;
                }
            }
            g.a(this.kXr.bkf.context, str, "", new OnClickListener(this) {
                final /* synthetic */ d kXv;

                {
                    this.kXv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.kXv.kXr.bpT != null) {
                        this.kXv.kXr.bkg.ret = 1;
                        this.kXv.kXr.bpT.run();
                    }
                }
            });
        } else {
            v.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
        }
    }

    private void bi(String str, int i) {
        String str2 = null;
        v.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = " + str);
        PayInfo payInfo = new PayInfo();
        payInfo.bkq = this.kXo;
        Object obj = null;
        for (String str3 : str.replace("http://p.qq.com?", "").split("&")) {
            if (str3.startsWith("errcode=")) {
                obj = str3.replace("errcode=", "");
            } else if (str3.startsWith("errmsg=")) {
                str2 = str3.replace("errmsg=", "");
            } else if (str3.startsWith("reqkey=")) {
                payInfo.fTG = str3.replace("reqkey=", "");
            } else if (str3.startsWith("uuid=")) {
                payInfo.gjT = str3.replace("uuid=", "");
            } else if (str3.startsWith("appid=")) {
                payInfo.appId = str3.replace("appid=", "");
            } else if (str3.startsWith("appsource=")) {
                payInfo.kXn = str3.replace("appsource=", "");
            } else if (str3.startsWith("productid=")) {
                payInfo.aZD = str3.replace("productid=", "");
            }
        }
        payInfo.bkh = i;
        if ("0".equals(obj)) {
            com.tencent.mm.pluginsdk.wallet.e.a(this.kXq.bfx.context, payInfo, 0);
            if (this.kXq.bpT != null) {
                this.kXq.bfy.ret = 1;
                this.kXq.bpT.run();
            }
        } else {
            if (be.kS(str2)) {
                str2 = this.kXq.bfx.context.getString(2131236492);
            }
            g.a(this.kXq.bfx.context, str2, "", new OnClickListener(this) {
                final /* synthetic */ d kXv;

                {
                    this.kXv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.kXv.kXq.bpT != null) {
                        this.kXv.kXq.bfy.ret = 1;
                        this.kXv.kXq.bpT.run();
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            b(0, Integer.valueOf(obj).intValue(), 0);
        }
    }

    private void b(int i, int i2, long j) {
        IDKey iDKey;
        int i3 = 132;
        if (this.kXo == 1) {
            i3 = 163;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetValue(1);
        iDKey2.SetKey(26);
        arrayList.add(iDKey2);
        if (!(i == 0 && i2 == 0)) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            iDKey2.SetKey(8);
            if (i2 < 0) {
                iDKey.SetKey(9);
            } else if (i2 > 0) {
                iDKey.SetKey(10);
            }
        }
        if (this.kXo == 4 && j > 0) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i3);
            iDKey3.SetValue((int) j);
            iDKey2.SetKey(0);
            if (j <= 1000) {
                iDKey.SetKey(1);
                iDKey3.SetKey(4);
            } else if (j > 1000 && j <= 3000) {
                iDKey.SetKey(2);
                iDKey3.SetKey(5);
            } else if (j > 3000) {
                iDKey.SetKey(3);
                iDKey3.SetKey(6);
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey);
            arrayList.add(iDKey3);
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
        com.tencent.mm.plugin.report.service.g.d(arrayList, true);
    }
}
