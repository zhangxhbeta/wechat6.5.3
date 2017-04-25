package com.tencent.mm.plugin.luckymoney.sns.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nu;
import com.tencent.mm.e.a.qm;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.luckymoney.sns.b.b;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.pluginsdk.j.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a implements i {

    class AnonymousClass3 implements e {
        final /* synthetic */ a hdg;
        final /* synthetic */ b hdh;

        AnonymousClass3(a aVar, b bVar) {
            this.hdg = aVar;
            this.hdh = bVar;
        }

        public final void a(final int i, final int i2, String str, k kVar) {
            v.i("MicroMsg.LuckyFreePwdPayMgr", "openSnsPay() onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
            if (kVar instanceof b) {
                ak.vy().b(this.hdh.getType(), this);
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 hdi;

                    public final void run() {
                        if (i == 0 && i2 == 0) {
                            v.i("MicroMsg.LuckyFreePwdPayMgr", "openSnsPay() success!");
                            a.a(this.hdi.hdg, true);
                            return;
                        }
                        v.i("MicroMsg.LuckyFreePwdPayMgr", "openSnsPay() failed!");
                        a.a(this.hdi.hdg, false);
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        String string;
        v.i("MicroMsg.LuckyFreePwdPayMgr", "openSnsPayResultDialog() result:" + z);
        if (z) {
            my(23);
            mx(111);
            string = aa.getResources().getString(2131233641);
        } else {
            mx(112);
            string = aa.getResources().getString(2131233640);
        }
        g.bf(aa.getContext(), string);
    }

    static void mx(int i) {
        nt ntVar = new nt();
        ntVar.boO.key = i;
        ntVar.boO.value = 1;
        ntVar.boO.bna = true;
        com.tencent.mm.sdk.c.a.nhr.z(ntVar);
    }

    static void my(int i) {
        nu nuVar = new nu();
        nuVar.boP.opType = i;
        com.tencent.mm.sdk.c.a.nhr.z(nuVar);
    }

    public final boolean axT() {
        v.i("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog()");
        ak.yW();
        if (((Boolean) c.vf().get(com.tencent.mm.storage.t.a.nsn, Boolean.valueOf(false))).booleanValue()) {
            v.e("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() has show the sns pay guide dialog! don't show again!");
            return false;
        }
        v.i("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() has not show the sns pay guide dialog");
        if (axV()) {
            boolean z;
            v.i("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() is white user");
            ak.yW();
            if (((Integer) c.vf().get(com.tencent.mm.storage.t.a.nsh, Integer.valueOf(0))).intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                v.i("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() can open sns pay");
                if (axW()) {
                    v.e("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() is open sns pay, don't open again!");
                    return false;
                }
                v.i("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() is not open sns pay, can do open!");
                return true;
            }
            v.e("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() can not open sns pay!");
            return false;
        }
        v.e("MicroMsg.LuckyFreePwdPayMgr", "isShowSnsPayGuideDialog() the user is not in white list!");
        return false;
    }

    public final void ah(final Context context, String str) {
        String string;
        String string2;
        v.i("MicroMsg.LuckyFreePwdPayMgr", "showSnsPayGuideDialog()");
        mx(ba.CTRL_INDEX);
        ak.yW();
        c.vf().a(com.tencent.mm.storage.t.a.nsn, Boolean.valueOf(true));
        ak.yW();
        c.vf().iB(true);
        ak.yW();
        String str2 = (String) c.vf().get(com.tencent.mm.storage.t.a.nsj, "");
        ak.yW();
        String str3 = (String) c.vf().get(com.tencent.mm.storage.t.a.nsk, "");
        if (TextUtils.isEmpty(str2)) {
            v.e("MicroMsg.LuckyFreePwdPayMgr", "showSnsPayGuideDialog  OpenSnsPayTitle is empty!");
            string = context.getString(2131233611);
        } else {
            string = str2;
        }
        if (TextUtils.isEmpty(str3)) {
            v.e("MicroMsg.LuckyFreePwdPayMgr", "showSnsPayGuideDialog  OpenSnsPayWording is empty!");
            string2 = context.getString(2131233610);
        } else {
            string2 = str3;
        }
        v.i("MicroMsg.LuckyFreePwdPayMgr", "showSnsPayGuideDialog title:" + string + " content:" + string2);
        final long currentTimeMillis = System.currentTimeMillis();
        final String str4 = str;
        final Context context2 = context;
        AnonymousClass1 anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ a hdg;

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                long currentTimeMillis = (System.currentTimeMillis() - currentTimeMillis) / 1000;
                a.mx(110);
                if (currentTimeMillis > 60) {
                    v.i("MicroMsg.LuckyFreePwdPayMgr", "showSnsPayGuideDialog, interval time > 60s, not to open sns pay!");
                    a.a(this.hdg, false);
                } else {
                    a aVar = this.hdg;
                    String str = str4;
                    v.i("MicroMsg.LuckyFreePwdPayMgr", "openSnsPay()");
                    b bVar = new b(1, "", str);
                    ak.vy().a(bVar.getType(), new AnonymousClass3(aVar, bVar));
                    ak.vy().a(bVar, 0);
                }
                if (context2 instanceof MMActivity) {
                    ((MMActivity) context2).finish();
                }
            }
        };
        g.a(context, string2, string, false, anonymousClass1, new OnClickListener(this) {
            final /* synthetic */ a hdg;

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.LuckyFreePwdPayMgr", "showSnsPayGuideDialog cancel open sns pay");
                dialogInterface.dismiss();
                a.mx(109);
                if (context instanceof MMActivity) {
                    a.my(24);
                    ((MMActivity) context).finish();
                }
            }
        });
    }

    public final boolean axU() {
        boolean axV = axV();
        v.i("MicroMsg.LuckyFreePwdPayMgr", "isShowFreePaySetting ret:" + axV);
        return axV;
    }

    public final boolean axV() {
        boolean z;
        ak.yW();
        if (((Integer) c.vf().get(com.tencent.mm.storage.t.a.nsi, Integer.valueOf(0))).intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.LuckyFreePwdPayMgr", "isWhiteUser ret:" + z);
        return z;
    }

    public final boolean axW() {
        boolean z = true;
        if (com.tencent.mm.plugin.luckymoney.sns.c.a.axZ() != 1) {
            z = false;
        }
        v.i("MicroMsg.LuckyFreePwdPayMgr", "isOpenSnsPay ret:" + z);
        return z;
    }

    public final boolean a(PayInfo payInfo) {
        v.i("MicroMsg.LuckyFreePwdPayMgr", "doPay()");
        Authen authen = new Authen();
        authen.imN = payInfo;
        authen.bkU = 3;
        authen.hMu = "CFT";
        authen.hMt = "CFT";
        final com.tencent.mm.plugin.luckymoney.sns.b.a aVar = new com.tencent.mm.plugin.luckymoney.sns.b.a(authen);
        ak.vy().a(aVar.getType(), new e(this) {
            final /* synthetic */ a hdg;

            public final void a(int i, int i2, String str, k kVar) {
                v.i("MicroMsg.LuckyFreePwdPayMgr", "doPay() onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
                if (kVar instanceof com.tencent.mm.plugin.luckymoney.sns.b.a) {
                    ak.vy().b(aVar.getType(), this);
                    qm qmVar = new qm();
                    qmVar.brZ = new com.tencent.mm.e.a.qm.a();
                    qmVar.brZ.bsa = aVar.hdq;
                    qmVar.brZ.errCode = i2;
                    qmVar.brZ.errType = i;
                    qmVar.brZ.biS = str;
                    if (i == 0 && i2 == 0) {
                        v.i("MicroMsg.LuckyFreePwdPayMgr", "do sns pay success!");
                    } else {
                        v.i("MicroMsg.LuckyFreePwdPayMgr", "do sns pay failed!");
                    }
                    com.tencent.mm.sdk.c.a.nhr.z(qmVar);
                    v.i("MicroMsg.LuckyFreePwdPayMgr", "doPay send WalletLuckySnsPayEvent");
                }
            }
        });
        ak.vy().a(aVar, 0);
        return true;
    }
}
