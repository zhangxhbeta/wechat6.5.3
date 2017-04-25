package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.y;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Date;

public class WalletBankcardManageUI extends WalletBaseUI {
    private ListView Eq = null;
    private OnItemClickListener Xp = new OnItemClickListener(this) {
        final /* synthetic */ WalletBankcardManageUI kGY;

        {
            this.kGY = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            final Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
            e.yD(18);
            if (bankcard == null) {
                this.kGY.beG();
            } else if (!bankcard.bfF()) {
                v.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[]{Boolean.valueOf((k.bga().bgz().kQP & Downloads.RECV_BUFFER_SIZE) > 0), Integer.valueOf(k.bga().bgz().kQP)});
                if ((k.bga().bgz().kQP & Downloads.RECV_BUFFER_SIZE) > 0) {
                    v.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                    ak.yW();
                    r1 = (String) c.vf().get(a.nsA, "");
                    ak.yW();
                    long longValue = ((Long) c.vf().get(a.nsB, Long.valueOf(0))).longValue();
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (be.kS(r1) || currentTimeMillis - longValue >= 7200) {
                        v.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                        com.tencent.mm.sdk.c.a.nhr.e(new com.tencent.mm.sdk.c.c<y>(this) {
                            final /* synthetic */ AnonymousClass5 kHb;

                            public final /* synthetic */ boolean a(b bVar) {
                                com.tencent.mm.sdk.c.a.nhr.f(this);
                                v.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
                                this.kHb.kGY.b(bankcard);
                                return true;
                            }
                        });
                        return;
                    }
                    v.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                    this.kGY.b(bankcard);
                    return;
                }
                this.kGY.c(bankcard);
            } else if (bankcard.field_wxcreditState == 0) {
                if (b.a(bankcard) && bankcard != null) {
                    ak.yW();
                    r1 = (String) c.vf().get(196659, null);
                    StringBuilder stringBuilder = new StringBuilder();
                    if (TextUtils.isEmpty(r1)) {
                        stringBuilder.append(bankcard.field_bankcardType);
                    } else {
                        stringBuilder.append(r1);
                        stringBuilder.append("&");
                        stringBuilder.append(bankcard.field_bankcardType);
                    }
                    ak.yW();
                    c.vf().set(196659, stringBuilder.toString());
                }
                r1 = new Bundle();
                r1.putParcelable("key_bankcard", bankcard);
                r1.putString("key_bank_username", bankcard.field_bizUsername);
                r1.putString("key_bank_type", bankcard.field_bankcardType);
                com.tencent.mm.wallet_core.a.a(this.kGY, "WXCreditOpenProcess", r1, null);
            } else {
                r1 = new Bundle();
                r1.putParcelable("key_bankcard", bankcard);
                com.tencent.mm.wallet_core.a.a(this.kGY, "WXCreditManagerProcess", r1, null);
            }
        }
    };
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ WalletBankcardManageUI kGY;
        final int kGZ = 1000;

        {
            this.kGY = r2;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131759835) {
                e.yD(19);
                this.kGY.beG();
            } else if (view.getId() == 2131759837) {
                Object tag = view.getTag();
                long time = new Date().getTime();
                view.setTag(Long.valueOf(time));
                if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                    r0 = new Intent();
                    r0.putExtra("rawUrl", this.kGY.kGX.field_loan_jump_url);
                    com.tencent.mm.ay.c.b(this.kGY, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", r0);
                    ak.yW();
                    c.vf().a(a.nrk, Integer.valueOf(this.kGY.kGX.field_red_dot_index));
                    e.yD(6);
                }
            } else if (view.getId() == 2131759842) {
                r0 = new Intent();
                r0.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
                com.tencent.mm.ay.c.b(this.kGY, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", r0);
            }
        }
    };
    public ArrayList<Bankcard> kGO = new ArrayList();
    private ArrayList<Bankcard> kGP = new ArrayList();
    protected ab kGQ = null;
    private ListView kGR = null;
    private a kGS = null;
    private a kGT = null;
    private TextView kGU;
    private View kGV;
    private View kGW;
    private h kGX;

    protected final int getLayoutId() {
        return 2130904621;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oa(4);
        v.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        com.tencent.mm.plugin.wallet.a.k.beN();
        this.kGQ = com.tencent.mm.plugin.wallet.a.k.beO();
        vD(2131236206);
        NI();
        n.dB(5, 0);
        e.yD(27);
        this.kGX = k.bga().kQT;
    }

    public void onResume() {
        if (this.kGQ.bgu()) {
            hd(true);
        } else {
            this.kGQ.d(this.kGO, this.kGP);
            if (this.kGQ.kFU != null) {
                oa(0);
            }
            hd(false);
        }
        av();
        super.onResume();
    }

    public void hd(boolean z) {
        if (z) {
            p(new l(null, 0));
        } else {
            b(new l(null, 0), false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.kGS.kGr.destory();
        this.kGT.kGr.destory();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletBankcardManageUI kGY;

            {
                this.kGY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kGY.finish();
                return true;
            }
        });
        this.kGU = (TextView) findViewById(2131759836);
        this.kGU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBankcardManageUI kGY;

            {
                this.kGY = r1;
            }

            public final void onClick(View view) {
                this.kGY.beG();
                e.yD(19);
            }
        });
        this.Eq = (ListView) findViewById(2131759833);
        this.kGS = beF();
        this.Eq.setAdapter(this.kGS);
        this.Eq.setOnItemClickListener(this.Xp);
        this.kGR = (ListView) findViewById(2131759834);
        this.kGT = new a(this, this.kGP);
        this.kGR.setAdapter(this.kGT);
        this.kGR.setOnItemClickListener(this.Xp);
        this.kGV = findViewById(2131759835);
        this.kGV.setOnClickListener(this.eFl);
        this.kGW = findViewById(2131759837);
        this.kGW.setOnClickListener(this.eFl);
        findViewById(2131759842).setOnClickListener(this.eFl);
        final qk qkVar = new qk();
        qkVar.brG.brI = "4";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ WalletBankcardManageUI kGY;

            public final void run() {
                if (be.kS(qkVar.brH.brJ)) {
                    v.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
                } else {
                    e.a((TextView) this.kGY.findViewById(2131756367), qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }

    public a beF() {
        return new a(this, this.kGO);
    }

    public final void b(Bankcard bankcard) {
        ak.yW();
        String str = (String) c.vf().get(a.nsA, "");
        if (be.kS(str)) {
            v.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            return;
        }
        v.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
        Intent intent = new Intent();
        String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[]{bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial});
        if (str.contains("?")) {
            str = str + "&" + format;
        } else {
            str = str + "?" + format;
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("disable_bounce_scroll", true);
        com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, null);
    }

    private void av() {
        if (this.kGQ.bgu()) {
            this.kGU.setEnabled(false);
        } else {
            this.kGQ.bgs();
            this.kGU.setEnabled(true);
        }
        if (this.kGO == null || this.kGO.size() <= 0) {
            this.Eq.setVisibility(8);
        } else {
            this.Eq.setVisibility(0);
        }
        if (this.kGP == null || this.kGP.size() <= 0) {
            this.kGR.setVisibility(8);
        } else {
            this.kGR.setVisibility(0);
        }
        if (this.kGX == null || this.kGX.field_is_show_entry != 1) {
            this.kGW.setVisibility(8);
        } else {
            boolean z;
            ((TextView) this.kGW.findViewById(2131759839)).setText(this.kGX.field_title);
            h hVar = this.kGX;
            TextView textView = (TextView) findViewById(2131759841);
            int i = hVar.field_red_dot_index;
            ak.yW();
            if (((Integer) c.vf().get(a.nrk, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                v.i("MicroMsg.WalletBankcardManageUI", "red point update");
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView = (TextView) findViewById(2131759840);
            if (hVar.field_is_overdue == 1) {
                v.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
                textView.setText(2131236046);
                textView.setTextColor(2131689960);
            } else if (!be.kS(hVar.field_tips)) {
                v.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
                textView.setText(hVar.field_tips);
            } else if (be.kS(hVar.field_available_otb)) {
                textView.setVisibility(8);
                this.kGW.setVisibility(0);
            } else {
                v.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
                i = hVar.field_available_otb.indexOf(".");
                String str = hVar.field_available_otb;
                if (i > 0) {
                    str = str.substring(0, i);
                }
                textView.setText(getString(2131236045, new Object[]{str}));
            }
            textView.setVisibility(0);
            this.kGW.setVisibility(0);
        }
        this.kGS.P(this.kGO);
        this.kGS.notifyDataSetChanged();
        this.kGT.P(this.kGP);
        this.kGT.notifyDataSetChanged();
        this.kGU.setEnabled(true);
    }

    public void beG() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 0);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.a.b.class, bundle, null);
    }

    public final void beH() {
        oa(0);
        this.kGQ.d(this.kGO, this.kGP);
        av();
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i != 0 || i2 != 0 || !(kVar instanceof l)) {
            return false;
        }
        this.kGX = k.bga().kQT;
        beH();
        return true;
    }

    public final boolean ayM() {
        return false;
    }

    public void finish() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.ay.c.b(this, "mall", ".ui.MallIndexUI", intent);
        super.finish();
    }
}
