package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.balance.a.b;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

@a(3)
public class WalletBalanceFetchUI extends WalletBaseUI implements WalletFormView.a {
    private String fTG = null;
    private Button fzj;
    private double irZ;
    private TextView kFA;
    private int kFB = 0;
    private int kFC = 0;
    private int kFD = 0;
    private double kFE = 0.0d;
    private int kFF = -1;
    private int kFG = 0;
    private DecimalFormat kFH = new DecimalFormat("0.00");
    private boolean kFI = false;
    private boolean kFJ = false;
    private boolean kFK = false;
    private boolean kFL = false;
    private boolean kFM = false;
    private ArrayList<Bankcard> kFq;
    private Bankcard kFr;
    private String kFs;
    private WalletFormView kFt;
    private WalletFormView kFu;
    private View kFv;
    private TextView kFw;
    private TextView kFx;
    private TextView kFy;
    private TextView kFz;

    static /* synthetic */ void c(WalletBalanceFetchUI walletBalanceFetchUI) {
        walletBalanceFetchUI.irZ = be.getDouble(walletBalanceFetchUI.kFt.getText(), 0.0d);
        String str = "";
        if (walletBalanceFetchUI.kFr != null) {
            str = walletBalanceFetchUI.kFr.field_bankcardType;
        }
        if (walletBalanceFetchUI.kFr != null && !be.kS(walletBalanceFetchUI.kFr.field_forbidWord)) {
            s.makeText(walletBalanceFetchUI.nDR.nEl, walletBalanceFetchUI.kFr.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.irZ <= 0.0d || !walletBalanceFetchUI.kFt.Ou()) {
            s.makeText(walletBalanceFetchUI.nDR.nEl, 2131236020, 0).show();
        } else {
            double d = walletBalanceFetchUI.irZ;
            k.beN();
            if (d > k.beO().kFU.kNv) {
                s.makeText(walletBalanceFetchUI.nDR.nEl, 2131235993, 0).show();
                return;
            }
            d = walletBalanceFetchUI.irZ;
            k.beN();
            if (d > k.beO().kFU.kNx) {
                s.makeText(walletBalanceFetchUI.nDR.nEl, 2131235994, 0).show();
            } else {
                walletBalanceFetchUI.j(new b(walletBalanceFetchUI.irZ, "CNY", str, walletBalanceFetchUI.kFG));
            }
        }
    }

    static /* synthetic */ void d(WalletBalanceFetchUI walletBalanceFetchUI) {
        double d;
        String str;
        if (!(walletBalanceFetchUI.kFr == null || walletBalanceFetchUI.kFB == 0 || ((walletBalanceFetchUI.kFB == 1 && walletBalanceFetchUI.kFr.field_fetch_charge_rate <= 0.0d) || (walletBalanceFetchUI.kFB == 1 && walletBalanceFetchUI.kFr.field_fetch_charge_rate > 0.0d && walletBalanceFetchUI.kFC == 0)))) {
            d = walletBalanceFetchUI.kFE;
            k.beN();
            if (d < k.beO().kFU.kNx) {
                if (walletBalanceFetchUI.kFr != null) {
                    k.beN();
                    d = k.beO().kFU.kNx - walletBalanceFetchUI.kFr.field_full_fetch_charge_fee;
                } else {
                    k.beN();
                    d = k.beO().kFU.kNx;
                }
                if (walletBalanceFetchUI.kFD != 1) {
                    v.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
                    walletBalanceFetchUI.kFG = 1;
                    if (walletBalanceFetchUI.kFr != null || be.kS(walletBalanceFetchUI.kFr.field_forbidWord)) {
                        str = "";
                        if (walletBalanceFetchUI.kFr != null) {
                            str = walletBalanceFetchUI.kFr.field_bankcardType;
                        }
                        walletBalanceFetchUI.j(new b(walletBalanceFetchUI.irZ, "CNY", str, walletBalanceFetchUI.kFG));
                    }
                    s.makeText(walletBalanceFetchUI.nDR.nEl, walletBalanceFetchUI.kFr.field_forbidWord, 0).show();
                    return;
                }
                walletBalanceFetchUI.kFt.setText(walletBalanceFetchUI.kFH.format(d));
                walletBalanceFetchUI.bev();
                walletBalanceFetchUI.kFG = 1;
                v.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
                return;
            }
        }
        k.beN();
        d = k.beO().kFU.kNx;
        if (walletBalanceFetchUI.kFD != 1) {
            walletBalanceFetchUI.kFt.setText(walletBalanceFetchUI.kFH.format(d));
            walletBalanceFetchUI.bev();
            walletBalanceFetchUI.kFG = 1;
            v.i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
            return;
        }
        v.i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
        walletBalanceFetchUI.kFG = 1;
        if (walletBalanceFetchUI.kFr != null) {
        }
        str = "";
        if (walletBalanceFetchUI.kFr != null) {
            str = walletBalanceFetchUI.kFr.field_bankcardType;
        }
        walletBalanceFetchUI.j(new b(walletBalanceFetchUI.irZ, "CNY", str, walletBalanceFetchUI.kFG));
    }

    protected final int getLayoutId() {
        return 2130904606;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L(getIntent());
        beu();
        this.kFs = getString(2131236016);
        NI();
        av();
        n.dB(4, 0);
    }

    public void onDestroy() {
        this.kFu.pkl = null;
        super.onDestroy();
    }

    private void beu() {
        k.beN();
        ab beO = k.beO();
        if (this.kFI) {
            int i;
            Bankcard bankcard;
            Bankcard bankcard2;
            v.i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.kFq != null && this.kFq.size() > 0) {
                arrayList.addAll(this.kFq);
            }
            this.kFq = beO.bgH();
            if (this.kFq != null && this.kFq.size() > 0) {
                arrayList2.addAll(this.kFq);
            }
            if (arrayList.size() > 0 && arrayList2.size() > 0) {
                Collection arrayList3 = new ArrayList();
                for (i = 0; i < arrayList.size(); i++) {
                    bankcard = (Bankcard) arrayList.get(i);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        bankcard2 = (Bankcard) arrayList2.get(i2);
                        if (!(bankcard == null || bankcard2 == null || !bankcard.field_bindSerial.equals(bankcard2.field_bindSerial))) {
                            arrayList3.add(bankcard2);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.removeAll(arrayList3);
                }
                if (arrayList2.size() > 0) {
                    bankcard = (Bankcard) arrayList2.get(0);
                    if (bankcard != null) {
                        bankcard2 = beO.a(this.kFq, null, false, true);
                    } else {
                        bankcard2 = bankcard;
                    }
                    i = 0;
                    while (this.kFq != null && i < this.kFq.size()) {
                        bankcard = (Bankcard) this.kFq.get(i);
                        if (bankcard2 == null && bankcard != null && bankcard2.field_bindSerial.equals(bankcard.field_bindSerial)) {
                            this.kFF = i;
                            break;
                        }
                        i++;
                    }
                    this.kFr = bankcard2;
                    this.kFI = false;
                }
            }
            bankcard = null;
            if (bankcard != null) {
                bankcard2 = bankcard;
            } else {
                bankcard2 = beO.a(this.kFq, null, false, true);
            }
            i = 0;
            while (this.kFq != null) {
                bankcard = (Bankcard) this.kFq.get(i);
                if (bankcard2 == null) {
                }
                i++;
            }
            this.kFr = bankcard2;
            this.kFI = false;
        } else {
            this.kFq = beO.bgH();
            this.kFr = beO.a(this.kFq, null, false, true);
        }
        if (beO.kQU != null) {
            this.kFB = beO.kQU.kFB;
            this.kFC = beO.kQU.kFC;
            this.kFE = beO.kQU.kFE;
            this.kFD = beO.kQU.kFD;
        } else {
            v.e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
        v.i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.kFB + " is_cal_charge:" + this.kFC + " min_charge_fee:" + this.kFE + " is_full_fetch_direct:" + this.kFD);
    }

    protected final void NI() {
        vD(2131235995);
        a(0, 2130839531, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e.l(this.kFN.nDR.nEl, "http://kf.qq.com/touch/product/wechatwallet_app.html?platform=15&scene_id=kf4&pass_ticket=zvBvzXwGuoqQlwgW%2F1zd9%2BpvXy7pNGb6AsRqHQ6NZozX9Z2%2FnyesIwMNv8Lth8Rz", false);
                return true;
            }
        });
        this.kFu = (WalletFormView) findViewById(2131759776);
        this.kFu.pkl = new com.tencent.mm.wallet_core.ui.formview.a.a(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
                return false;
            }

            public final void bex() {
                this.kFN.av();
            }
        };
        com.tencent.mm.wallet_core.ui.formview.a.g(this.kFu);
        OnClickListener anonymousClass9 = new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_scene_select_bankcard_mode_ui", 0);
                intent.putExtra("key_select_index", this.kFN.kFF);
                intent.setClass(this.kFN, WalletSelectBankcardModeUI.class);
                this.kFN.startActivityForResult(intent, 1);
            }
        };
        this.kFv = findViewById(2131759775);
        this.kFv.setOnClickListener(anonymousClass9);
        this.kFu.setOnClickListener(anonymousClass9);
        this.kFt = (WalletFormView) findViewById(2131759777);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.kFt);
        this.kFt.pkk = this;
        d(this.kFt, 2, false);
        this.fzj = (Button) findViewById(2131756365);
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final void onClick(View view) {
                WalletBalanceFetchUI.c(this.kFN);
            }
        });
        this.fzj.setEnabled(false);
        this.kFw = (TextView) findViewById(2131759773);
        this.kFx = (TextView) findViewById(2131759774);
        this.kFy = (TextView) findViewById(2131759780);
        this.kFz = (TextView) findViewById(2131759778);
        this.kFA = (TextView) findViewById(2131759779);
        this.kFA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final void onClick(View view) {
                WalletBalanceFetchUI.d(this.kFN);
            }
        });
        this.kFt.a(new TextWatcher(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                obj.length();
                int lastIndexOf = obj.lastIndexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (lastIndexOf != indexOf) {
                    editable.delete(lastIndexOf, length);
                }
                this.kFN.bev();
            }
        });
        final qk qkVar = new qk();
        qkVar.brG.brI = "3";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            public final void run() {
                if (be.kS(qkVar.brH.brJ)) {
                    v.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
                } else {
                    e.a(this.kFN.kFw, qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }

    public void onResume() {
        bew();
        super.onResume();
    }

    private void av() {
        if (this.kFt.eXB != null) {
            this.kFt.eXB.setText(String.format(getString(2131234519), new Object[]{q.bLm()}));
        } else {
            v.i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        if (this.kFr != null) {
            this.kFu.setText(this.kFr.field_desc);
            this.kFu.setVisibility(0);
            if (this.kFu.ioB == null) {
                v.i("MicroMsg.WalletBalanceFetchUI", "mBankcardEHV.getTipsTv() is null");
            } else if (this.kFB != 1 || this.kFr.field_fetch_charge_rate <= 0.0d) {
                this.kFu.ioB.setText("");
                this.kFu.ioB.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(this.kFr.field_fetch_charge_info)) {
                    this.kFu.ioB.setText(getString(2131235986) + (this.kFr.field_fetch_charge_rate * 100.0d) + "%");
                } else {
                    this.kFu.ioB.setText(this.kFr.field_fetch_charge_info);
                }
                this.kFu.ioB.setVisibility(0);
            }
            if (be.kS(this.kFr.field_fetchArriveTimeWording)) {
                this.kFy.setText("");
                this.kFy.setVisibility(8);
                ha(false);
            } else {
                this.kFy.setText(this.kFr.field_fetchArriveTimeWording);
                this.kFy.setVisibility(0);
                ha(true);
            }
        } else {
            this.kFu.setText(this.kFs);
            if (this.kFu.ioB != null) {
                this.kFu.ioB.setText("");
                this.kFu.ioB.setVisibility(8);
            }
            this.kFy.setVisibility(8);
            ha(false);
        }
        k.beN();
        CharSequence charSequence = k.beO().kFU.kNz;
        if (be.kS(charSequence)) {
            this.kFx.setVisibility(8);
        } else {
            this.kFx.setVisibility(0);
            this.kFx.setText(charSequence);
        }
        bev();
    }

    private void ha(boolean z) {
        LayoutParams layoutParams = (LayoutParams) this.fzj.getLayoutParams();
        if (z) {
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493152);
        } else {
            layoutParams.topMargin = getResources().getDimensionPixelOffset(2131493138);
        }
        this.fzj.setLayoutParams(layoutParams);
    }

    private void bev() {
        this.irZ = be.getDouble(this.kFt.getText(), 0.0d);
        if (this.irZ > 0.0d) {
            this.fzj.setEnabled(true);
        } else {
            this.fzj.setEnabled(false);
        }
        double d = this.irZ;
        k.beN();
        if (!(d == k.beO().kFU.kNx || this.kFr == null)) {
            d = this.irZ;
            k.beN();
            if (d != k.beO().kFU.kNx - this.kFr.field_full_fetch_charge_fee) {
                this.kFG = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        double d2 = this.irZ;
        k.beN();
        if (d2 > k.beO().kFU.kNv) {
            this.kFA.setVisibility(8);
            this.kFz.setTextColor(getResources().getColor(2131689960));
            stringBuilder.append(getString(2131235996));
        } else {
            String str;
            if (!(this.kFr == null || this.kFB == 0 || ((this.kFB == 1 && this.kFr.field_fetch_charge_rate <= 0.0d) || (this.kFB == 1 && this.kFr.field_fetch_charge_rate > 0.0d && this.kFC == 0)))) {
                d2 = this.kFE;
                k.beN();
                if (d2 < k.beO().kFU.kNx) {
                    if (this.kFB == 1 && this.kFr.field_fetch_charge_rate > 0.0d && this.kFC == 1 && (this.irZ <= 0.0d || !this.kFt.Ou())) {
                        this.kFA.setVisibility(0);
                        this.kFz.setTextColor(getResources().getColor(2131689792));
                        k.beN();
                        str = k.beO().kFU.kNA;
                        if (be.kS(str)) {
                            v.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                            k.beN();
                            stringBuilder.append(getString(2131235990, new Object[]{e.d(k.beO().kFU.kNx, "CNY")}));
                        } else {
                            stringBuilder.append(str);
                        }
                        stringBuilder.append("，");
                    } else if (this.kFB == 1 && this.kFr.field_fetch_charge_rate > 0.0d && this.kFC == 1) {
                        this.kFA.setVisibility(8);
                        this.kFz.setTextColor(getResources().getColor(2131689792));
                        d2 = this.irZ;
                        k.beN();
                        if (d2 != k.beO().kFU.kNx - this.kFr.field_full_fetch_charge_fee || this.kFr.field_full_fetch_charge_fee <= 0.0d) {
                            Object[] objArr = new Object[1];
                            double d3 = this.irZ;
                            k.beN();
                            ab beO = k.beO();
                            objArr[0] = e.d(Math.max(((double) Math.round(((d3 - beO.kQU.irs) * this.kFr.field_fetch_charge_rate) * 100.0d)) / 100.0d, beO.kQU.kFE), "CNY");
                            stringBuilder.append(getString(2131235980, objArr));
                        } else {
                            stringBuilder.append(getString(2131235980, new Object[]{e.d(this.kFr.field_full_fetch_charge_fee, "CNY")}));
                        }
                    }
                }
            }
            this.kFA.setVisibility(0);
            this.kFz.setTextColor(getResources().getColor(2131689792));
            k.beN();
            str = k.beO().kFU.kNA;
            if (be.kS(str)) {
                v.i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                k.beN();
                stringBuilder.append(getString(2131235990, new Object[]{e.d(k.beO().kFU.kNx, "CNY")}));
            } else {
                stringBuilder.append(str);
            }
            stringBuilder.append("，");
        }
        this.kFz.setText(stringBuilder.toString());
    }

    private void a(b bVar) {
        if (be.kS(this.fTG)) {
            v.w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
            return;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.fTG = this.fTG;
        payInfo.bkq = 21;
        this.uA.putParcelable("key_pay_info", payInfo);
        Parcelable orders = new Orders();
        orders.kOU = bVar.irx - bVar.iro;
        orders.kOV = bVar.irx - bVar.iro;
        orders.kPm.add(new Commodity());
        orders.iro = bVar.iro;
        this.uA.putParcelable("key_orders", orders);
        this.uA.putParcelable("key_bankcard", this.kFr);
        if (bLC() == null) {
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.b.class, this.uA, null);
            return;
        }
        bLD().j(this.uA);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            boolean a;
            if (kVar instanceof b) {
                b bVar = (b) kVar;
                this.kFJ = false;
                if (!this.kFM) {
                    this.kFK = false;
                }
                this.kFL = false;
                this.kFM = false;
                if ("1".equals(bVar.brU)) {
                    v.i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, bVar.brV, bVar.brW, bVar.brX, bundle, ayJ(), null, 0, 2);
                } else if ("2".equals(bVar.brU)) {
                    v.i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, bVar.brV, bVar.brY, bVar.brW, bVar.brX, ayJ(), null);
                } else {
                    v.i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + bVar.brU);
                    a = false;
                }
                if (a) {
                    return false;
                }
                if (!b(bVar)) {
                    this.fTG = bVar.bfr;
                    a(bVar);
                }
            } else if (kVar instanceof l) {
                beu();
                av();
                if (this.kFB != 0) {
                    v.i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.kFB);
                } else {
                    ak.yW();
                    a = ((Boolean) c.vf().get(t.a.nsx, Boolean.valueOf(false))).booleanValue();
                    k.beN();
                    if (!(k.beO().kQU == null || a)) {
                        g.a(this, getString(2131236350, new Object[]{e.l(r1.irs)}), getString(2131236351), getString(2131231075), getString(2131236352), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBalanceFetchUI kFN;

                            {
                                this.kFN = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ WalletBalanceFetchUI kFN;

                            {
                                this.kFN = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.kFN.getString(2131236180));
                                intent.putExtra("showShare", false);
                                com.tencent.mm.ay.c.b(this.kFN, "webview", ".ui.tools.WebViewUI", intent);
                                dialogInterface.dismiss();
                            }
                        }, 2131690123);
                        ak.yW();
                        c.vf().a(t.a.nsx, Boolean.valueOf(true));
                    }
                }
            }
        } else if (kVar instanceof b) {
            bew();
        }
        return false;
    }

    public final void fc(boolean z) {
        this.kFt.de(null);
    }

    protected final int NO() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 != -1 || intent == null) {
            v.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i3 = this.kFF;
            this.kFF = intExtra;
            v.i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is " + intExtra);
            if (this.kFq == null || intExtra < 0 || intExtra >= this.kFq.size()) {
                if (this.kFq == null || intExtra < 0 || intExtra > this.kFq.size()) {
                    this.kFr = null;
                } else {
                    this.kFF = i3;
                }
                Bundle bundle = new Bundle();
                Parcelable parcelable = (PayInfo) this.uA.get("key_pay_info");
                if (parcelable == null) {
                    parcelable = new PayInfo();
                    parcelable.fTG = this.fTG;
                    parcelable.bkq = 21;
                }
                if (parcelable != null) {
                    bundle.putParcelable("key_pay_info", parcelable);
                }
                bundle.putInt("key_scene", 21);
                bundle.putInt("key_bind_scene", 0);
                bundle.putBoolean("key_need_bind_response", true);
                bundle.putInt("key_bind_scene", 0);
                bundle.putBoolean("key_is_bind_bankcard", true);
                bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.kFh);
                com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
            } else {
                this.kFr = (Bankcard) this.kFq.get(intExtra);
            }
            av();
        }
    }

    private boolean b(final b bVar) {
        boolean z;
        com.tencent.mm.plugin.wallet_core.model.b bVar2;
        if (this.kFJ) {
            z = false;
        } else if (bVar.kFj) {
            this.kFJ = true;
            g.a(this, false, bVar.kFk, "", getString(2131231107), getString(2131231010), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchUI kFN;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (!this.kFN.b(bVar)) {
                        this.kFN.fTG = bVar.bfr;
                        this.kFN.a(bVar);
                    }
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchUI kFN;

                {
                    this.kFN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.kFN.bew();
                }
            });
            z = true;
        } else {
            z = false;
        }
        if (!(z || this.kFK)) {
            bVar2 = bVar.kFl;
            if (bVar2 == null || (TextUtils.isEmpty(bVar2.kNj) && (bVar2.kNk == null || bVar2.kNk.size() <= 0))) {
                z = false;
            } else {
                this.kFK = true;
                h.a(this, bVar2, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletBalanceFetchUI kFN;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (!this.kFN.b(bVar)) {
                            this.kFN.fTG = bVar.bfr;
                            this.kFN.a(bVar);
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletBalanceFetchUI kFN;

                    {
                        this.kFN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kFN.bew();
                    }
                });
                z = true;
            }
        }
        if (z || this.kFL) {
            return z;
        }
        bVar2 = bVar.kFm;
        if (bVar2 == null || (TextUtils.isEmpty(bVar2.kNj) && (bVar2.kNk == null || bVar2.kNk.size() <= 0))) {
            return false;
        }
        this.kFL = true;
        h.a(this, bVar2, true, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                String str = "";
                if (this.kFN.kFr != null) {
                    str = this.kFN.kFr.field_bankcardType;
                }
                this.kFN.kFG = 1;
                this.kFN.kFM = true;
                this.kFN.j(new b(this.kFN.irZ, "CNY", str, this.kFN.kFG));
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletBalanceFetchUI kFN;

            {
                this.kFN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.kFN.bew();
            }
        });
        return true;
    }

    private void bew() {
        this.kFJ = false;
        this.kFK = false;
        this.kFL = false;
        this.kFM = false;
    }

    protected void onNewIntent(Intent intent) {
        bew();
        L(intent);
    }

    private void L(Intent intent) {
        boolean z = false;
        if (intent != null && intent.getBooleanExtra("intent_bind_end", false)) {
            z = true;
        }
        this.kFI = z;
        if (this.kFI) {
            v.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) this.uA.get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.fTG = this.fTG;
                payInfo.bkq = 21;
            }
            p(new l(payInfo == null ? null : payInfo.fTG, 4));
            return;
        }
        p(new l(null, 4));
        v.i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card fail or from create call");
    }
}
