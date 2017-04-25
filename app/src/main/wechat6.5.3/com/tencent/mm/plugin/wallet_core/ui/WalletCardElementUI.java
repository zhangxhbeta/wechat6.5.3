package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.e.a.mg;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, a {
    private String gYT;
    private String gYU;
    private Authen hdp = new Authen();
    private Orders ith = null;
    private TextView jSa;
    private Button kHi;
    private PayInfo kIA = null;
    a kJf = null;
    private WalletFormView kKF;
    private TextView kKG;
    private TextView kKH;
    private int kKJ = 1;
    private c kKz = new c<mg>(this) {
        final /* synthetic */ WalletCardElementUI kSN;

        {
            this.kSN = r2;
            this.nhz = mg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mg mgVar = (mg) bVar;
            if (mgVar instanceof mg) {
                WalletCardElementUI.a(this.kSN, mgVar.bnr.bns, mgVar.bnr.bnt);
                return true;
            }
            v.f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    private ElementQuery kMo = new ElementQuery();
    private WalletFormView kRY;
    private Bankcard kRZ = null;
    private WalletFormView kSA;
    private WalletFormView kSB;
    private WalletFormView kSC;
    private ScrollView kSD;
    private WalletFormView kSE = null;
    private WalletFormView kSF;
    private Map<String, a.a> kSG = null;
    private boolean kSH = false;
    private CheckBox kSI;
    private CheckBox kSJ;
    private String kSK;
    private BaseAdapter kSL = new BaseAdapter(this) {
        final /* synthetic */ WalletCardElementUI kSN;

        {
            this.kSN = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return sr(i);
        }

        public final int getCount() {
            return this.kSN.kMo.bfN() != null ? this.kSN.kMo.bfN().size() : 0;
        }

        private Integer sr(int i) {
            return (Integer) this.kSN.kMo.bfN().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.kSN, 2130904652, null);
            checkedTextView.setText(k.bgi().E(this.kSN, sr(i).intValue()));
            if (this.kSN.kKJ == sr(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    };
    private OnClickListener kSM = new OnClickListener(this) {
        final /* synthetic */ WalletCardElementUI kSN;

        {
            this.kSN = r1;
        }

        public final void onClick(View view) {
            g.iuh.h(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
            e.d(this.kSN, k.bga().bgB());
        }
    };
    private TextView kSj;
    private TextView kSk;
    private TextView kSl;
    private TextView kSm;
    private TextView kSn;
    private TextView kSo;
    private TextView kSp;
    private TextView kSq;
    private WalletFormView kSr;
    private WalletFormView kSs;
    private WalletFormView kSt;
    private WalletFormView kSu;
    private WalletFormView kSv;
    private WalletFormView kSw;
    private WalletFormView kSx;
    private WalletFormView kSy;
    private WalletFormView kSz;

    static /* synthetic */ void a(WalletCardElementUI walletCardElementUI, String str, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putString("key_bankcard_id", str);
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(walletCardElementUI);
        if (ae != null) {
            ae.a((Activity) walletCardElementUI, WalletConfirmCardIDUI.class, bundle, 3);
        }
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(2130904651, null);
                ListView listView = (ListView) inflate.findViewById(2131755317);
                listView.setAdapter(this.kSL);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletCardElementUI kSN;

                    {
                        this.kSN = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.kSN.dismissDialog(1);
                        int intValue = ((Integer) this.kSN.kMo.bfN().get(i)).intValue();
                        if (this.kSN.kKJ != intValue) {
                            this.kSN.kKJ = intValue;
                            this.kSN.kSu.setText(((CheckedTextView) view).getText().toString());
                            WalletCardElementUI.a(this.kSN.kKF, this.kSN.kKJ);
                            this.kSN.kKF.aJx();
                            this.kSN.av();
                            this.kSN.sq(this.kSN.kKJ);
                        }
                    }
                });
                h.a aVar = new h.a(this);
                aVar.wm(2131236072);
                aVar.cC(inflate);
                aVar.c(null);
                return aVar.RX();
            default:
                return com.tencent.mm.ui.base.g.A(this, getString(2131236072), "");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236170);
        this.kMo = (ElementQuery) this.uA.getParcelable("elemt_query");
        this.ith = (Orders) this.uA.getParcelable("key_orders");
        this.kIA = (PayInfo) this.uA.getParcelable("key_pay_info");
        this.kKJ = k.bga().bgC();
        this.kRZ = (Bankcard) this.uA.getParcelable("key_history_bankcard");
        if (this.kIA == null) {
            this.kIA = new PayInfo();
        }
        v.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.kIA);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.uA.getParcelable("key_favor_pay_info");
        if (!(this.ith == null || favorPayInfo == null)) {
            this.kJf = b.kRN.a(this.ith);
            if (this.kJf != null) {
                this.kSG = this.kJf.Dl(this.kJf.Dp(favorPayInfo.kOv));
            } else {
                v.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        NI();
        this.kSD.pageScroll(33);
        com.tencent.mm.plugin.wallet_core.d.c.a(this, this.uA, 3);
        com.tencent.mm.sdk.c.a.nhr.e(this.kKz);
    }

    protected final void NI() {
        this.kSj = (TextView) findViewById(2131759849);
        this.kSF = (WalletFormView) findViewById(2131759850);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kSF);
        this.kSk = (TextView) findViewById(2131759851);
        this.kKG = (TextView) findViewById(2131759856);
        this.kRY = (WalletFormView) findViewById(2131759831);
        com.tencent.mm.wallet_core.ui.formview.a.d(this, this.kRY);
        this.kSv = (WalletFormView) findViewById(2131759761);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.kSv);
        this.kSu = (WalletFormView) findViewById(2131759857);
        this.kKF = (WalletFormView) findViewById(2131759858);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.kKF);
        this.kKH = (TextView) findViewById(2131759859);
        this.kSl = (TextView) findViewById(2131759852);
        this.kSr = (WalletFormView) findViewById(2131759760);
        this.kSm = (TextView) findViewById(2131759854);
        this.kSq = (TextView) findViewById(2131759853);
        this.kSn = (TextView) findViewById(2131759855);
        this.kSt = (WalletFormView) findViewById(2131758528);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.kSt);
        this.kSs = (WalletFormView) findViewById(2131758530);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.kSs);
        this.kSo = (TextView) findViewById(2131758529);
        this.jSa = (TextView) findViewById(2131759860);
        this.kSw = (WalletFormView) findViewById(2131759861);
        this.kSx = (WalletFormView) findViewById(2131759862);
        this.kSy = (WalletFormView) findViewById(2131759863);
        this.kSz = (WalletFormView) findViewById(2131759864);
        this.kSA = (WalletFormView) findViewById(2131759865);
        this.kSB = (WalletFormView) findViewById(2131759866);
        this.kSC = (WalletFormView) findViewById(2131759867);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.kSC);
        this.kSp = (TextView) findViewById(2131759868);
        this.kSI = (CheckBox) findViewById(2131759869);
        this.kSJ = (CheckBox) findViewById(2131759870);
        this.kHi = (Button) findViewById(2131756365);
        this.kSD = (ScrollView) findViewById(2131758524);
        this.kRY.pkk = this;
        this.kSF.pkk = this;
        this.kSu.pkk = this;
        this.kKF.pkk = this;
        this.kSv.pkk = new a(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void fc(boolean z) {
                if (!z) {
                    this.kSN.kRZ = null;
                    this.kSN.uA.putParcelable("key_history_bankcard", null);
                }
                this.kSN.Ox();
            }
        };
        this.kSt.pkk = this;
        this.kSs.pkk = this;
        this.kSw.pkk = this;
        this.kSx.pkk = this;
        this.kSy.pkk = this;
        this.kSz.pkk = this;
        this.kSA.pkk = this;
        this.kSB.pkk = this;
        this.kSC.pkk = this;
        this.kRY.setOnEditorActionListener(this);
        this.kSF.setOnEditorActionListener(this);
        this.kSu.setOnEditorActionListener(this);
        this.kKF.setOnEditorActionListener(this);
        this.kSv.setOnEditorActionListener(this);
        this.kSt.setOnEditorActionListener(this);
        this.kSs.setOnEditorActionListener(this);
        this.kSw.setOnEditorActionListener(this);
        this.kSx.setOnEditorActionListener(this);
        this.kSy.setOnEditorActionListener(this);
        this.kSz.setOnEditorActionListener(this);
        this.kSA.setOnEditorActionListener(this);
        this.kSB.setOnEditorActionListener(this);
        this.kSC.setOnEditorActionListener(this);
        this.kSr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", this.kSN.uA.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", this.kSN.uA.getInt("key_bind_scene", -1));
                if (!be.kS(this.kSN.kSr.getText())) {
                    bundle.putString("key_bank_type", this.kSN.kMo.hMt);
                    bundle.putInt("key_bankcard_type", this.kSN.kMo.kOb);
                }
                com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this.kSN);
                if (ae != null) {
                    ae.a(this.kSN, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.kSu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void onClick(View view) {
                this.kSN.showDialog(1);
            }
        });
        this.kSI.setChecked(true);
        this.kSI.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.kSN.Ox();
            }
        });
        findViewById(2131758286).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void onClick(View view) {
                e.a(this.kSN, this.kSN.kMo.hMt, this.kSN.kMo.kNS, false, this.kSN.kMo.kOt);
            }
        });
        this.kSy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void onClick(View view) {
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true);
                if (Bankcard.sm(this.kSN.kMo.kLu)) {
                    putExtra.putExtra("IsAutoPosition", false);
                }
                this.kSN.startActivityForResult(putExtra, 2);
            }
        });
        this.kHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardElementUI kSN;

            {
                this.kSN = r1;
            }

            public final void onClick(View view) {
                this.kSN.bgX();
            }
        });
        d(this.kSF, 0, false);
        d(this.kKF, 1, false);
        d(this.kSv, 0, false);
        if (this.kMo != null && !be.kS(this.kMo.kOh)) {
            com.tencent.mm.ui.base.g.a(this, this.kMo.kOh, null, true, null);
            this.kMo = null;
        } else if (this.uA.getInt("key_bind_scene", -1) == 5 && !this.kMo.kOu) {
            com.tencent.mm.ui.base.g.a(this, getString(2131236538), null, true, null);
            this.kMo.kNS = null;
        }
        av();
        Ox();
        com.tencent.mm.wallet_core.b ae = com.tencent.mm.wallet_core.a.ae(this);
        if (ae != null && ae.bKW()) {
            Orders orders = (Orders) this.uA.getParcelable("key_orders");
            if (orders == null || orders.kOW != 1) {
                this.kSH = false;
                return;
            }
            this.kSH = true;
            this.kRY.setText(e.PS(orders.kMS));
            this.kRY.setEnabled(false);
            this.kRY.setFocusable(false);
            this.kKJ = orders.kOY;
            this.kSu.setText(k.bgi().E(this, this.kKJ));
            this.kSu.setEnabled(false);
            this.kKF.setText(orders.kOX);
            this.kKF.setEnabled(false);
            this.kKF.setFocusable(false);
            this.kKG.setText(2131236063);
            this.kSv.bLL();
        }
    }

    private void av() {
        if (this.kMo == null) {
            this.kMo = new ElementQuery();
        }
        if (this.kMo == null || this.kSG == null || !this.kSG.containsKey(this.kMo.hMt)) {
            this.kSq.setVisibility(8);
        } else {
            double d;
            a.a aVar = (a.a) this.kSG.get(this.kMo.hMt);
            if (aVar == null || aVar.kRK == null) {
                d = 0.0d;
            } else {
                d = aVar.kRL;
            }
            this.kSq.setText(getString(2131236064, new Object[]{e.l(d)}));
            this.kSq.setVisibility(0);
        }
        com.tencent.mm.wallet_core.a.ae(this);
        Bankcard bankcard = (Bankcard) this.uA.getParcelable("key_bankcard");
        if (!bgY() || bankcard == null) {
            if (be.kS(this.kMo.kNS)) {
                this.kSr.setText("");
            } else if (!be.kS(this.kMo.kOc)) {
                this.kSr.setText(this.kMo.kNS + " " + this.kMo.kOc);
            } else if (2 == this.kMo.kOb) {
                this.kSr.setText(this.kMo.kNS + " " + getString(2131236153));
            } else {
                this.kSr.setText(this.kMo.kNS + " " + getString(2131236167));
            }
            a(new boolean[]{false}, new WalletFormView[]{this.kSF}, this.kSj, this.kSk, true);
            a(new boolean[]{true}, new WalletFormView[]{this.kSr}, this.kSl, this.kSm, true);
            this.kSF.k(this.kSM);
            if (k.bga().bgz().bgo()) {
                this.kSF.ioA.setImageResource(2131166019);
                this.kSF.ioA.setVisibility(0);
            } else {
                this.kSF.ioA.setVisibility(4);
            }
        } else {
            this.kSF.setHint(getString(2131236092, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.kSF}, this.kSj, this.kSk);
            a(new boolean[]{false}, new WalletFormView[]{this.kSr}, this.kSl, this.kSm);
        }
        if (Bankcard.sm(this.kMo.kLu)) {
            a(new boolean[]{false, false, false, false}, new WalletFormView[]{this.kRY, this.kSu, this.kKF, this.kSv}, this.kKG, this.kKH);
            hl(true);
        } else {
            boolean z = this.kMo.bfN() != null && this.kMo.bfN().size() > 0;
            if (bgY() || k.bga().bgs()) {
                if (be.kS(k.bga().bgB())) {
                    this.kRY.setHint(getString(2131236128));
                } else {
                    this.kRY.setHint(getString(2131236129, new Object[]{e.PS(k.bga().bgB())}));
                }
                a(new boolean[]{true, z, true, true}, new WalletFormView[]{this.kRY, this.kSu, this.kKF, this.kSv}, this.kKG, this.kKH);
            } else {
                boolean[] zArr = new boolean[4];
                zArr[0] = this.kMo.kNU;
                if (z && this.kMo.kNV) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[1] = z;
                zArr[2] = this.kMo.kNV;
                zArr[3] = true;
                a(zArr, new WalletFormView[]{this.kRY, this.kSu, this.kKF, this.kSv}, this.kKG, this.kKH);
                v.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.kMo.kNU + " canModifyIdentity:" + this.kMo.kNV);
            }
            if (this.kRZ != null) {
                if (!be.kS(this.kRZ.field_mobile)) {
                    a(this.kSv, this.kRZ.field_mobile);
                }
                if (!be.kS(this.kRZ.kMW)) {
                    a(this.kSt, this.kRZ.kMW);
                }
                if (!be.kS(this.kRZ.kNs)) {
                    a(this.kSs, this.kRZ.kNs);
                }
            }
            if (this.kMo.kNU) {
                this.kKH.setText(getString(2131236095));
            } else {
                this.kKH.setText(getString(2131236098));
            }
            if (!bgY() || k.bga().bgC() <= 0) {
                if (this.kSL.getCount() <= 1) {
                    this.kSu.setClickable(false);
                    this.kSu.setEnabled(false);
                } else {
                    this.kSu.setClickable(true);
                    this.kSu.setEnabled(true);
                }
                List bfN = this.kMo.bfN();
                if (bfN == null || !bfN.contains(Integer.valueOf(this.kKJ))) {
                    this.kKJ = 1;
                }
                this.kSu.setText(k.bgi().E(this, this.kKJ));
            } else {
                this.kSu.setClickable(false);
                this.kSu.setText(k.bgi().E(this, k.bga().bgC()));
                this.kSu.setEnabled(false);
                a(this.kKF, this.kKJ);
            }
            sq(this.kKJ);
            hl(false);
        }
        a(new boolean[]{this.kMo.kNW, this.kMo.kNX}, new WalletFormView[]{this.kSt, this.kSs}, this.kSn, this.kSo);
        if (this.kSr.getVisibility() == 0) {
            switch (this.kMo.kOa) {
                case 1:
                    this.kSm.setVisibility(8);
                    break;
                case 2:
                    this.kSm.setVisibility(8);
                    break;
                case 3:
                    this.kSm.setText(2131236069);
                    this.kSm.setVisibility(0);
                    break;
                case 4:
                    this.kSm.setVisibility(8);
                    break;
                default:
                    this.kSm.setVisibility(4);
                    break;
            }
            this.kSm.setTextColor(getResources().getColor(2131689906));
        } else {
            this.kSm.setVisibility(8);
        }
        if (be.kS(this.kMo.kOf) || !m.eC(this.kMo.kOf) || bgY()) {
            this.kSJ.setVisibility(8);
            return;
        }
        this.kSJ.setText(this.kMo.kOg);
        this.kSJ.setVisibility(0);
    }

    private static void a(WalletFormView walletFormView, String str) {
        if (be.kS(str)) {
            walletFormView.setVisibility(8);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
    }

    private void hl(boolean z) {
        int i = 0;
        if (z) {
            int i2;
            this.jSa.setVisibility(this.kMo.kOi ? 0 : 8);
            WalletFormView walletFormView = this.kSw;
            if (this.kMo.kOi) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.kSx;
            if (this.kMo.kOj) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.kSy;
            if (this.kMo.kOk) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.kSz;
            if (this.kMo.kOn) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.kSA;
            if (this.kMo.kOp) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.kSB;
            if (this.kMo.kOo) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.kSC;
            if (!this.kMo.kOq) {
                i = 8;
            }
            walletFormView2.setVisibility(i);
            this.kSp.setVisibility(4);
            return;
        }
        this.jSa.setVisibility(8);
        this.kSw.setVisibility(8);
        this.kSx.setVisibility(8);
        this.kSy.setVisibility(8);
        this.kSz.setVisibility(8);
        this.kSA.setVisibility(8);
        this.kSB.setVisibility(8);
        this.kSC.setVisibility(8);
        this.kSp.setVisibility(8);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        int length = zArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                i = 1;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
            }
        }
        if (i != 0) {
            textView.setVisibility(0);
            if (textView2 == null) {
                return;
            }
            if (z) {
                textView2.setVisibility(8);
                return;
            } else {
                textView2.setVisibility(4);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        a(zArr, walletFormViewArr, textView, textView2, false);
    }

    private void bgX() {
        if (Ox()) {
            String text;
            com.tencent.mm.plugin.wallet_core.d.c.bhu();
            if (!be.kS(this.kMo.kOf)) {
                Bundle bundle = this.uA;
                String str = "key_is_follow_bank_username";
                boolean z = this.kSJ.getVisibility() == 0 && this.kSJ.isChecked();
                bundle.putBoolean(str, z);
                this.uA.putString("key_bank_username", this.kMo.kOf);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) this.uA.getParcelable("key_favor_pay_info");
            if (!(this.kMo == null || favorPayInfo == null || this.kJf == null || this.kSG == null)) {
                if (this.kSG.containsKey(this.kMo.hMt)) {
                    favorPayInfo.kOv = ((a.a) this.kSG.get(this.kMo.hMt)).kRK.kHO;
                } else {
                    favorPayInfo.kOv = this.kJf.au(favorPayInfo.kOv, false);
                }
                this.uA.putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.hdp = new Authen();
            if (this.kRZ != null) {
                this.hdp.hMu = this.kRZ.kNt;
                this.hdp.kMY = this.kRZ.field_bankcardTail;
            }
            String string = this.uA.getString("key_card_id");
            if (this.kSF.getVisibility() == 0) {
                text = this.kSF.getText();
            } else {
                text = string;
            }
            this.hdp.imN = (PayInfo) this.uA.getParcelable("key_pay_info");
            this.hdp.kMV = text;
            this.hdp.hMt = this.kMo.hMt;
            this.hdp.kMU = this.kKJ;
            this.hdp.kMR = this.uA.getString("key_pwd1");
            if (!be.kS(this.kSt.getText())) {
                this.hdp.kMW = this.kSt.getText();
            }
            this.hdp.kLp = this.kSv.getText();
            this.hdp.kNa = this.kSw.getText();
            this.hdp.kNb = this.kSx.getText();
            this.hdp.cJg = this.kSK;
            this.hdp.bCk = this.gYT;
            this.hdp.bCl = this.gYU;
            this.hdp.cJf = this.kSz.getText();
            this.hdp.kNc = this.kSA.getText();
            this.hdp.dxo = this.kSB.getText();
            this.hdp.bCc = this.kSC.getText();
            text = e.PT(this.hdp.kLp);
            this.uA.putString("key_mobile", text);
            this.uA.putBoolean("key_is_oversea", this.kMo.kLu == 2);
            this.hdp.kMT = this.kKF.getText();
            this.hdp.kMS = this.kRY.getText();
            this.hdp.kMX = this.kSs.getText();
            favorPayInfo = (FavorPayInfo) this.uA.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                this.hdp.kNd = favorPayInfo.kOy;
                this.hdp.kNe = favorPayInfo.kOv;
            }
            v.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.hdp.imN + " elemt.bankcardTag : " + this.kMo.kLu);
            v.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.kMo.kLu);
            Bundle bundle2 = this.uA;
            bundle2.putString("key_mobile", text);
            bundle2.putParcelable("key_authen", this.hdp);
            bundle2.putString("key_bank_phone", this.kMo.kOe);
            if (bLD().j(this.hdp, this.ith)) {
                v.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                v.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.uA;
        v.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.kIA);
        if (!(kVar instanceof l)) {
            return false;
        }
        v.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.k(this, bundle);
        return true;
    }

    protected final int getLayoutId() {
        return 2130904627;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.kMo = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    this.kRZ = null;
                    av();
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("Country");
                    this.kSK = stringExtra + "|" + stringExtra2;
                    String stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!be.kS(intent.getStringExtra("Contact_City"))) {
                        this.gYT = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.gYU = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        this.kSy.setText(stringExtra + " " + stringExtra4);
                    } else if (be.kS(intent.getStringExtra("Contact_Province"))) {
                        this.gYU = this.kSK;
                        this.kSy.setText(stringExtra);
                    } else {
                        this.gYU = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.kSy.setText(stringExtra + " " + stringExtra3);
                    }
                    if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.kMo.kOo) {
                        this.kSB.setVisibility(8);
                        break;
                    } else {
                        this.kSB.setVisibility(0);
                        break;
                    }
                    break;
                case 3:
                    this.kSF.Qa(intent.getStringExtra("key_bankcard_id"));
                    break;
            }
            Ox();
        }
    }

    private boolean Ox() {
        boolean z;
        boolean z2;
        WalletFormView walletFormView = this.kSE;
        this.kSE = null;
        if (this.kSr.de(null)) {
            z = true;
        } else {
            if (this.kSE == null && walletFormView != this.kSr) {
                this.kSE = this.kSr;
            }
            this.kSm.setText(2131236065);
            this.kSm.setTextColor(getResources().getColor(2131689960));
            z = false;
        }
        if (!this.kRY.de(null)) {
            if (this.kSE == null && walletFormView != this.kRY) {
                this.kSE = this.kRY;
            }
            z = false;
        }
        if (!this.kSF.de(this.kSk)) {
            if (this.kSE == null && walletFormView != this.kSF) {
                this.kSE = this.kSF;
            }
            z = false;
        }
        if (this.kKF.de(this.kKH) || this.kSH) {
            z2 = z;
            z = false;
        } else {
            if (this.kSE == null && walletFormView != this.kKF) {
                this.kSE = this.kKF;
            }
            this.kKH.setText(2131236094);
            this.kKH.setTextColor(getResources().getColor(2131689960));
            z = true;
            z2 = false;
        }
        if (!this.kSv.de(this.kKH)) {
            if (z) {
                this.kKH.setText(2131236087);
                this.kKH.setTextColor(getResources().getColor(2131689960));
            } else {
                this.kKH.setText(2131236088);
                this.kKH.setTextColor(getResources().getColor(2131689960));
            }
            if (this.kSE == null && walletFormView != this.kSv) {
                this.kSE = this.kSv;
            }
            z2 = false;
        } else if (z) {
            this.kKH.setVisibility(0);
        }
        if (this.kKH.getVisibility() == 4) {
            if (this.kMo.kNU) {
                this.kKH.setText(getString(2131236095));
            } else {
                this.kKH.setText(getString(2131236098));
            }
            this.kKH.setTextColor(getResources().getColor(2131689792));
            this.kKH.setVisibility(0);
        }
        if (this.kSt.de(this.kSo)) {
            z = false;
        } else {
            if (this.kSE == null && walletFormView != this.kSt) {
                this.kSE = this.kSt;
            }
            z = true;
            z2 = false;
        }
        if (!this.kSs.de(this.kSo)) {
            if (this.kSE == null && walletFormView != this.kSs) {
                this.kSE = this.kSs;
            }
            z2 = false;
        } else if (z) {
            this.kSo.setVisibility(4);
        }
        if (!this.kSI.isChecked()) {
            z2 = false;
        }
        if (!this.kSw.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSw) {
                this.kSE = this.kSw;
            }
            z2 = false;
        }
        if (!this.kSx.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSx) {
                this.kSE = this.kSx;
            }
            z2 = false;
        }
        if (!this.kSy.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSy) {
                this.kSE = this.kSy;
            }
            z2 = false;
        }
        if (!this.kSz.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSz) {
                this.kSE = this.kSz;
            }
            z2 = false;
        }
        if (!this.kSA.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSA) {
                this.kSE = this.kSA;
            }
            z2 = false;
        }
        if (!this.kSB.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSB) {
                this.kSE = this.kSB;
            }
            z2 = false;
        }
        if (!this.kSC.de(this.kSp)) {
            if (this.kSE == null && walletFormView != this.kSC) {
                this.kSE = this.kSC;
            }
            z2 = false;
        }
        if (z2) {
            this.kHi.setEnabled(true);
            this.kHi.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(1073741824);
            }
        } else {
            this.kHi.setEnabled(false);
            this.kHi.setClickable(false);
        }
        return z2;
    }

    public final void fc(boolean z) {
        Ox();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        v.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.kSE != null) {
                    WalletFormView walletFormView = this.kSE;
                    if (walletFormView.pkj != null ? walletFormView.pkj.isFocusable() : false) {
                        walletFormView = this.kSE;
                        if (walletFormView.pkj != null) {
                            z = walletFormView.pkj.isClickable();
                        }
                        if (z && this.kSE.bLJ()) {
                            this.kSE.bLL();
                        }
                    }
                    this.kSE.performClick();
                } else {
                    bgX();
                }
                return true;
            default:
                if (this.kSE != null) {
                    return false;
                }
                bgX();
                return false;
        }
    }

    public void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kKz);
        super.onDestroy();
    }

    private static void a(WalletFormView walletFormView, int i) {
        com.tencent.mm.wallet_core.ui.formview.a.b bVar = walletFormView.pkm;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).yE(i);
        }
    }

    private void sq(int i) {
        if (i == 1) {
            d(this.kKF, 1, false);
        } else {
            d(this.kKF, 1, true);
        }
    }

    protected final int NO() {
        return 1;
    }

    private boolean bgY() {
        return this.uA.getBoolean("key_is_forgot_process", false);
    }
}
