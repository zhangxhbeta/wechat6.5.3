package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import java.util.List;

public class b extends k {
    private b kZT;
    private int kZU = 0;
    private boolean kZV = false;
    private a kZW;

    private class a {
        public com.tencent.mm.plugin.wallet_core.ui.k.a kVd;
        public String kZY;
        public Bankcard kZZ;
        public FavorPayInfo laa;
        public boolean lab;
        public b lac;
        public OnCancelListener lad;
        final /* synthetic */ b lae;

        public a(b bVar, String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, com.tencent.mm.plugin.wallet_core.ui.k.a aVar, b bVar2) {
            this.lae = bVar;
            this.kZY = str;
            this.kZZ = bankcard;
            this.laa = favorPayInfo;
            this.lab = z;
            this.lad = onCancelListener;
            this.kVd = aVar;
            this.lac = bVar2;
        }
    }

    public interface b {
        void a(String str, String str2, FavorPayInfo favorPayInfo);
    }

    public b(Context context) {
        super(context);
    }

    protected final void bF(Context context) {
        cM(context);
        super.cN(context);
        if (this.kVi != null) {
            this.kVi.setVisibility(8);
        }
    }

    protected final void cN(Context context) {
        super.cN(context);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, b bVar, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        String au;
        List bgU;
        String str;
        String str2;
        String str3;
        CharSequence charSequence;
        boolean z2;
        com.tencent.mm.plugin.wallet_core.ui.a a = com.tencent.mm.plugin.wallet_core.ui.b.kRN.a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.kOx))) {
                    au = a.au(favorPayInfo.kOv, false);
                    com.tencent.mm.plugin.wallet_core.ui.a.a aVar = (com.tencent.mm.plugin.wallet_core.ui.a.a) a.at(au, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.kRK == null || be.kS(aVar.kRK.kHO)) {
                        favorPayInfo.kOv = au;
                    } else {
                        favorPayInfo.kOv = aVar.kRK.kHO;
                    }
                }
            } else if (orders.kPn != null) {
                favorPayInfo = a.Dq(a.Dr(orders.kPn.kHB));
            }
            bgU = a.bgU();
        } else {
            v.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            bgU = null;
        }
        Commodity commodity = (Commodity) orders.kPm.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (be.kS(commodity.hMV)) {
            str = "";
        } else {
            str = commodity.hMV + "\n";
        }
        String stringBuilder2 = stringBuilder.append(str).append(((Commodity) orders.kPm.get(0)).desc).toString();
        if (a == null || favorPayInfo == null) {
            str2 = null;
            str3 = null;
            charSequence = null;
            z2 = false;
        } else {
            e Dn = a.Dn(favorPayInfo.kOv);
            if (Dn != null && Dn.kHP > 0.0d) {
                String d = com.tencent.mm.wallet_core.ui.e.d(orders.kOU, orders.hNg);
                String d2 = com.tencent.mm.wallet_core.ui.e.d(Dn.kHA, orders.hNg);
                au = context.getString(2131236349, new Object[]{com.tencent.mm.wallet_core.ui.e.m(Dn.kHP)});
                str3 = d2;
                str2 = d;
                z2 = true;
                charSequence = au;
            } else if (bgU == null || bgU.size() <= 0) {
                charSequence = null;
                str2 = null;
                str3 = com.tencent.mm.wallet_core.ui.e.d(orders.kOU, orders.hNg);
                z2 = false;
            } else {
                z2 = true;
                str2 = null;
                str3 = null;
                Object string = context.getString(2131236400);
            }
        }
        if (bankcard == null) {
            str = "";
        } else {
            str = bankcard.field_desc;
        }
        b bVar2 = new b(context);
        bVar2.kVh = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.bhk();
        bVar2.b(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.Dv(stringBuilder2);
        bVar2.Dw(str3);
        bVar2.Dy(str2);
        bVar2.a(str, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence)) {
            bVar2.kUS.setVisibility(8);
        } else {
            bVar2.kUS.setVisibility(0);
            bVar2.kUS.setText(charSequence);
        }
        bVar2.kZV = z;
        bVar2.kUT.pkf = -10;
        bVar2.kZT = bVar;
        bVar2.show();
        g.a(context, bVar2);
        return bVar2;
    }

    protected final void bhl() {
        if (this.kVe != null) {
            this.kVe.onClick(this, 0);
        }
        dismiss();
        if (this.kZT == null) {
            return;
        }
        if (!this.kZV) {
            this.kZT.a(this.kUT.getText(), "", this.kID);
        } else if (this.kZU == 0) {
            Context context = getContext();
            final a aVar = new a(this, this.kUT.getText(), this.kVh, this.kID, this.kVf, this.Fe, this.kVd, this.kZT);
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                b anonymousClass1 = new b(context) {
                    public final int bhj() {
                        int i = 3;
                        if (aVar.kZZ != null && aVar.kZZ.field_bankcardClientType == 1) {
                            v.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                            i = new com.tencent.mm.plugin.wallet_core.model.a.b(aVar.kZZ).kRF;
                        }
                        if (i != 4) {
                            return 2130904151;
                        }
                        v.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                        return 2130904150;
                    }
                };
                anonymousClass1.kZU = 1;
                anonymousClass1.kZV = true;
                anonymousClass1.kZW = aVar;
                if (anonymousClass1.kZW != null) {
                    anonymousClass1.bhk();
                    anonymousClass1.b(anonymousClass1.kZW.lad);
                    anonymousClass1.setOnCancelListener(anonymousClass1.kZW.lad);
                    anonymousClass1.setCancelable(true);
                    anonymousClass1.Dw(anonymousClass1.kZW.kZZ == null ? "" : anonymousClass1.kZW.kZZ.field_desc);
                    anonymousClass1.ho(false);
                    anonymousClass1.kVd = anonymousClass1.kZW.kVd;
                    anonymousClass1.kZT = anonymousClass1.kZW.lac;
                    anonymousClass1.kUT.pkf = 30;
                    anonymousClass1.show();
                    g.a(context, anonymousClass1);
                }
            }
        } else if (this.kZU == 1) {
            this.kZT.a(this.kZW.kZY, this.kUT.getText(), this.kZW.laa);
        } else {
            v.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        }
    }
}
