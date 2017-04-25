package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.qs;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.plugin.wallet.pay.a.b.d;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.a {
    public static int kIv = 1;
    protected TextView eJM;
    public Orders ith = null;
    public k kFo;
    public ArrayList<Bankcard> kFq;
    public Bankcard kFr = null;
    public Authen kHn = null;
    public PayInfo kIA = null;
    protected String kIB = null;
    public String kIC;
    public FavorPayInfo kID;
    private a kIE;
    c kIF = null;
    private com.tencent.mm.sdk.c.c kIG = new com.tencent.mm.sdk.c.c<qs>(this) {
        final /* synthetic */ WalletChangeBankcardUI kIH;

        {
            this.kIH = r2;
            this.nhz = qs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            v.i("MicroMsg.WalletSelectUseBankcardUI", "realnameNotifyListener %s", new Object[]{Integer.valueOf(((qs) bVar).bsl.bpc)});
            if (-1 == ((qs) bVar).bsl.bpc) {
                this.kIH.si(-1);
            }
            return false;
        }
    };
    protected ListView kIw;
    protected Button kIx;
    public int kIy;
    public f kIz = null;

    private void si(int i) {
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
        if (ae != null) {
            ae.d(this, 1);
        } else {
            finish();
        }
        qt qtVar = new qt();
        qtVar.bsm.bpc = -1;
        com.tencent.mm.sdk.c.a.nhr.z(qtVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.WalletSelectUseBankcardUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == kIv) {
            si(-1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236467);
        Bundle bundle2 = this.uA;
        bundle2.putInt("key_err_code", 0);
        this.kIy = bundle2.getInt("key_support_bankcard", 1);
        this.kHn = (Authen) bundle2.getParcelable("key_authen");
        this.ith = (Orders) bundle2.getParcelable("key_orders");
        this.kIA = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.kID = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        if (this.uA.getBoolean("key_is_filter_bank_type")) {
            he(true);
        } else {
            boolean beU = beU();
            com.tencent.mm.plugin.wallet.a.k.beN();
            this.kFq = com.tencent.mm.plugin.wallet.a.k.beO().hk(beU);
        }
        if (!(this.ith == null || this.ith.kPm == null || this.ith.kPm.size() <= 0)) {
            this.kIB = getString(2131236136, new Object[]{e.d(this.ith.kOU, this.ith.hNg), ((Commodity) this.ith.kPm.get(0)).desc});
        }
        beV();
        NI();
        n.dB(7, 0);
        com.tencent.mm.sdk.c.a.nhr.e(this.kIG);
    }

    public void onDestroy() {
        if (this.kIE != null) {
            this.kIE.beT();
            this.kIE.release();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.kIG);
        this.kIF = null;
        super.onDestroy();
    }

    private boolean beU() {
        return (this.kIA == null || this.kIA.bkq == 11) ? false : true;
    }

    protected final void beV() {
        if (this.kFq != null) {
            Collections.sort(this.kFq, new Comparator<Bankcard>(this) {
                final /* synthetic */ WalletChangeBankcardUI kIH;

                {
                    this.kIH = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    Bankcard bankcard = (Bankcard) obj;
                    Bankcard bankcard2 = (Bankcard) obj2;
                    if (be.KB(bankcard.field_forbidWord) < be.KB(bankcard2.field_forbidWord)) {
                        return 1;
                    }
                    return be.KB(bankcard.field_forbidWord) > be.KB(bankcard2.field_forbidWord) ? -1 : 0;
                }
            });
        }
    }

    public final void NI() {
        this.kIx = (Button) findViewById(2131759877);
        this.kIx.setEnabled(false);
        this.kIx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletChangeBankcardUI kIH;

            {
                this.kIH = r1;
            }

            public final void onClick(View view) {
                this.kIH.beX();
            }
        });
        if (be.kS(this.uA.getString("key_pwd1"))) {
            this.kIx.setText(2131231107);
        } else {
            this.kIx.setText(2131236402);
        }
        this.kIw = (ListView) findViewById(2131759770);
        this.kIz = beW();
        this.kIw.setAdapter(this.kIz);
        this.kIw.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletChangeBankcardUI kIH;

            {
                this.kIH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.kIH.sj(i);
            }
        });
        av();
    }

    public f beW() {
        return new f(this, this.kFq, this.kIy, this.ith);
    }

    public final void av() {
        this.eJM = (TextView) findViewById(2131759758);
        if (this.kID != null && !be.kS(this.kID.kOz)) {
            this.eJM.setVisibility(0);
            this.eJM.setText(this.kID.kOz);
        } else if (this.uA.getInt("key_main_bankcard_state", 0) != 0) {
            this.eJM.setVisibility(0);
            this.eJM.setText(this.kIB);
        } else {
            this.eJM.setVisibility(8);
        }
    }

    protected void sj(int i) {
        int size = this.kFq != null ? this.kFq.size() : 0;
        if (this.kFq != null && i < size) {
            Bankcard bankcard = (Bankcard) this.kFq.get(i);
            this.kFr = bankcard;
            this.kIz.kTm = bankcard.field_bindSerial;
            this.kIx.setEnabled(true);
            this.kIz.notifyDataSetChanged();
            beX();
        } else if (size == i) {
            this.uA.putInt("key_err_code", -1003);
            com.tencent.mm.wallet_core.a.k(this, this.uA);
        }
    }

    public void onResume() {
        this.uA.putInt("key_err_code", 0);
        super.onResume();
        if (this.kIF != null) {
            this.kIF.bgV();
        }
    }

    public final boolean ayJ() {
        if (super.ayJ()) {
            return true;
        }
        if (this.kIA == null || !this.kIA.lVz) {
            return false;
        }
        if (this.kIA.lVz) {
            return true;
        }
        com.tencent.mm.plugin.wallet.a.k.beN();
        if (com.tencent.mm.plugin.wallet.a.k.beO().bgv()) {
            return false;
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904631;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.kID != null && this.kFq.size() == 0) {
            FavorPayInfo favorPayInfo = this.kID;
            boolean z = (favorPayInfo == null || favorPayInfo.kOw == 0) ? false : true;
            if (z) {
                v.i("MicroMsg.WalletSelectUseBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.uA.getString("key_is_cur_bankcard_bind_serial");
                if (be.kS(string)) {
                    v.e("MicroMsg.WalletSelectUseBankcardUI", "curBankcardBindSerial null & finish");
                    return super.onKeyUp(i, keyEvent);
                }
                com.tencent.mm.plugin.wallet.a.k.beN();
                List hk = com.tencent.mm.plugin.wallet.a.k.beO().hk(true);
                if (this.kFr == null) {
                    for (int i2 = 0; i2 < hk.size(); i2++) {
                        if (string.equals(((Bankcard) hk.get(i2)).field_bindSerial)) {
                            v.i("MicroMsg.WalletSelectUseBankcardUI", "get cur bankcard, bind_serial:" + string);
                            this.kFr = (Bankcard) hk.get(i2);
                            break;
                        }
                    }
                    if (this.kFr == null) {
                        v.e("MicroMsg.WalletSelectUseBankcardUI", "mDefaultBankcard still null & finish");
                        return super.onKeyUp(i, keyEvent);
                    }
                }
                beX();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putString("pwd", this.kIC);
            j.a.lxX.a(this.kHn.imN.lVE == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                    this.kIA.lVG = i2;
                    beX();
                    return true;
                case 100100:
                case 100101:
                    this.kIA.lVG = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.kIE == null) {
                        this.kIE = new a(this, this);
                    }
                    this.kIE.b(z, this.kIA.bfq, this.kIA.fTG);
                    v.i("MicroMsg.WalletSelectUseBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof d) {
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                Bundle bundle2 = this.uA;
                com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                if (!be.kS(this.kIC)) {
                    bundle2.putString("key_pwd1", this.kIC);
                }
                bundle2.putString("kreq_token", bVar.token);
                bundle2.putParcelable("key_authen", bVar.hdp);
                String str2 = "key_need_verify_sms";
                if (!bVar.hdm) {
                    z = true;
                }
                bundle2.putBoolean(str2, z);
                bundle2.putParcelable("key_pay_info", this.kIA);
                bundle2.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = bVar.hKv;
                if (realnameGuideHelper != null) {
                    bundle2.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.kIC);
                j.a.lxX.a(bVar.beS(), true, bundle3);
                if (bVar.hdn) {
                    bundle2.putParcelable("key_orders", bVar.hdo);
                }
                com.tencent.mm.wallet_core.a.k(this, bundle2);
                return true;
            }
        }
        return false;
    }

    public void beX() {
        v.d("MicroMsg.WalletSelectUseBankcardUI", "pay with old bankcard!");
        String string = this.uA.getString("key_pwd1");
        if (be.kS(string)) {
            oa(4);
            this.kFo = k.a(this, this.ith, this.kID, this.kFr, this.kIA, new k.c(this) {
                final /* synthetic */ WalletChangeBankcardUI kIH;

                {
                    this.kIH = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.kIH.kID = favorPayInfo;
                    this.kIH.uA.putParcelable("key_favor_pay_info", this.kIH.kID);
                    if (this.kIH.kID == null || !z) {
                        this.kIH.kIC = str;
                        this.kIH.axg();
                        this.kIH.CV(str);
                        this.kIH.kIF = null;
                        return;
                    }
                    if (this.kIH.kID != null) {
                        this.kIH.he(true);
                        this.kIH.kIz.R(this.kIH.kFq);
                    }
                    if (this.kIH.kFo != null) {
                        this.kIH.kFo.dismiss();
                    }
                    this.kIH.av();
                    this.kIH.oa(0);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletChangeBankcardUI kIH;

                {
                    this.kIH = r1;
                }

                public final void onClick(View view) {
                    if (this.kIH.kFo != null) {
                        this.kIH.kFo.dismiss();
                    }
                    this.kIH.he(false);
                    this.kIH.kIz.R(this.kIH.kFq);
                    this.kIH.kID = (FavorPayInfo) view.getTag();
                    if (this.kIH.kID != null) {
                        this.kIH.kID.kOz = "";
                    }
                    this.kIH.uA.putParcelable("key_favor_pay_info", this.kIH.kID);
                    this.kIH.av();
                    this.kIH.oa(0);
                    this.kIH.kIF = null;
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletChangeBankcardUI kIH;

                {
                    this.kIH = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.kIH.kIC = null;
                    if (this.kIH.nDR.dtW.getVisibility() != 0) {
                        this.kIH.beZ();
                    }
                    this.kIH.kIF = null;
                }
            });
            this.kIF = this.kFo;
            return;
        }
        CV(string);
    }

    public void CV(String str) {
        this.kHn.kMR = str;
        if (this.kFr != null) {
            this.uA.putString("key_mobile", this.kFr.field_mobile);
            this.uA.putParcelable("key_bankcard", this.kFr);
            this.kHn.hMu = this.kFr.field_bindSerial;
            this.kHn.hMt = this.kFr.field_bankcardType;
            if (this.kID != null) {
                this.kHn.kNe = this.kID.kOv;
            } else {
                this.kHn.kNe = null;
            }
            if (this.ith.kPn != null) {
                this.kHn.kNd = this.ith.kPn.kHB;
            }
            if (this.ith != null && this.ith.kLu == 3) {
                boolean z;
                if (this.kFr.bfI()) {
                    this.kHn.bkU = 3;
                } else {
                    this.kHn.bkU = 6;
                }
                Bundle bundle = this.uA;
                String str2 = "key_is_oversea";
                if (this.kFr.bfI()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.uA.putString("key_pwd1", str);
        this.uA.putParcelable("key_authen", this.kHn);
        com.tencent.mm.plugin.wallet.pay.a.a.b a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.kHn, this.ith, false);
        if (a != null) {
            a.mProcessName = "PayProcess";
            a.uA = this.uA;
            if (this.kIA.bkq == 6 && this.kIA.lVy == 100) {
                a.cVh = 100;
            } else {
                a.cVh = this.kIA.bkq;
            }
            j(a);
        }
    }

    protected final boolean beY() {
        return true;
    }

    public final void nU(int i) {
        if (i == 0) {
            beZ();
        } else if (i == 1) {
            this.uA.putString("key_pwd1", "");
            beX();
        } else {
            v.w("MicroMsg.WalletSelectUseBankcardUI", "hy: clean ui data not handled");
        }
    }

    public final void beZ() {
        bLz();
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
        if (ae != null) {
            ae.d(this, this.uA);
        } else {
            finish();
        }
    }

    protected int NO() {
        return 1;
    }

    protected final void he(boolean z) {
        boolean beU = beU();
        com.tencent.mm.plugin.wallet.a.k.beN();
        this.kFq = com.tencent.mm.plugin.wallet.a.k.beO().hk(beU);
        if (this.kID != null) {
            Object obj;
            if (this.kID.kOw != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && z) {
                String str = this.kID.kOx;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.kFq.size(); i++) {
                    Bankcard bankcard = (Bankcard) this.kFq.get(i);
                    if (be.kS(str)) {
                        if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                            arrayList.add(bankcard);
                        }
                    } else if (bankcard.field_bankcardType.equals(str)) {
                        arrayList.add(bankcard);
                    }
                }
                this.kFq = arrayList;
                beV();
            }
        }
    }

    protected final boolean ayL() {
        return true;
    }

    public final void a(boolean z, String str, String str2) {
        v.i("MicroMsg.WalletSelectUseBankcardUI", "onGenFinish callback");
        if (z) {
            v.i("MicroMsg.WalletSelectUseBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.kIA.bfs = str;
            this.kIA.bft = str2;
            CV(this.kIC);
            return;
        }
        v.e("MicroMsg.WalletSelectUseBankcardUI", "onGenFinish callback, result.isSuccess is false");
        CV(this.kIC);
    }

    public void onPause() {
        super.onPause();
        if (this.kIF != null) {
            this.kIF.bgW();
        }
    }
}
