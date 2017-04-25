package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;
import java.util.List;

public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, a {
    private static final String[] kSO = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private String gYT;
    private String gYU;
    private Authen hdp = new Authen();
    private Orders ith = null;
    private Button kHi;
    private PayInfo kIA = null;
    private WalletFormView kKF;
    private int kKJ = 1;
    private ElementQuery kMo = new ElementQuery();
    private WalletFormView kRY;
    private WalletFormView kSA;
    private WalletFormView kSB;
    private WalletFormView kSC;
    private WalletFormView kSE = null;
    private WalletFormView kSF;
    private CheckBox kSJ;
    private String kSK;
    private TextView kSP;
    private MMScrollView kSQ;
    private Bankcard kSR = null;
    private CheckBox kSS;
    private BaseAdapter kST = new BaseAdapter(this) {
        final /* synthetic */ WalletCardImportUI kSU;

        {
            this.kSU = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return sr(i);
        }

        public final int getCount() {
            return this.kSU.kMo.bfN() != null ? this.kSU.kMo.bfN().size() : 0;
        }

        private Integer sr(int i) {
            return (Integer) this.kSU.kMo.bfN().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.kSU, 2130904652, null);
            checkedTextView.setText(k.bgi().E(this.kSU, sr(i).intValue()));
            if (this.kSU.kKJ == sr(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            checkedTextView.setBackgroundResource(2130838046);
            return checkedTextView;
        }
    };
    private WalletFormView kSr;
    private WalletFormView kSs;
    private WalletFormView kSt;
    private WalletFormView kSu;
    private WalletFormView kSv;
    private WalletFormView kSw;
    private WalletFormView kSx;
    private WalletFormView kSy;
    private WalletFormView kSz;
    private ac mHandler = new ac();
    private Dialog oy = null;

    static /* synthetic */ void c(WalletFormView walletFormView, int i) {
        b bVar = walletFormView.pkm;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).yE(i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236170);
        this.kMo = (ElementQuery) this.uA.getParcelable("elemt_query");
        this.ith = (Orders) this.uA.getParcelable("key_orders");
        this.kIA = (PayInfo) this.uA.getParcelable("key_pay_info");
        this.kSR = (Bankcard) this.uA.getParcelable("key_import_bankcard");
        if (this.kIA == null) {
            this.kIA = new PayInfo();
        }
        v.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.kIA);
        NI();
        this.kSQ.pageScroll(33);
        c.a(this, this.uA, 3);
    }

    protected final void NI() {
        this.kSF = (WalletFormView) findViewById(2131759850);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kSF);
        this.kSv = (WalletFormView) findViewById(2131759761);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.kSv);
        this.kRY = (WalletFormView) findViewById(2131759831);
        com.tencent.mm.wallet_core.ui.formview.a.d(this, this.kRY);
        this.kSu = (WalletFormView) findViewById(2131759857);
        this.kKF = (WalletFormView) findViewById(2131759858);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.kKF);
        this.kSr = (WalletFormView) findViewById(2131759760);
        this.kSt = (WalletFormView) findViewById(2131758528);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.kSt);
        this.kSs = (WalletFormView) findViewById(2131758530);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.kSs);
        this.kSP = (TextView) findViewById(2131758532);
        this.kSw = (WalletFormView) findViewById(2131759861);
        this.kSx = (WalletFormView) findViewById(2131759862);
        this.kSy = (WalletFormView) findViewById(2131759863);
        this.kSz = (WalletFormView) findViewById(2131759864);
        this.kSA = (WalletFormView) findViewById(2131759865);
        this.kSB = (WalletFormView) findViewById(2131759866);
        this.kSC = (WalletFormView) findViewById(2131759867);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.kSC);
        this.kSS = (CheckBox) findViewById(2131759869);
        this.kSJ = (CheckBox) findViewById(2131759870);
        this.kHi = (Button) findViewById(2131756365);
        this.kSQ = (MMScrollView) findViewById(2131758524);
        Object obj = this.kSQ;
        obj.a(obj, obj);
        this.kSQ.pjD = new MMScrollView.a(this) {
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void hm(boolean z) {
                final int i = z ? 8 : 0;
                v.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : " + z);
                this.kSU.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 kSW;

                    public final void run() {
                        if (i != this.kSW.kSU.kSP.getVisibility()) {
                            this.kSW.kSU.kSP.setVisibility(i);
                        }
                    }
                });
            }
        };
        this.kRY.pkk = this;
        this.kSF.pkk = this;
        this.kSu.pkk = this;
        this.kKF.pkk = this;
        this.kSv.pkk = this;
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
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", this.kSU.uA.getInt("key_support_bankcard", 3));
                bundle.putString("key_bank_type", this.kSU.kMo.hMt);
                bundle.putInt("key_bankcard_type", this.kSU.kMo.kOb);
                com.tencent.mm.wallet_core.a.ae(this.kSU).a(this.kSU, WalletCardSelectUI.class, bundle, 1);
            }
        });
        this.kSu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void onClick(View view) {
                this.kSU.showDialog(1);
            }
        });
        this.kSS.setChecked(true);
        this.kSS.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.kSU.Ox();
            }
        });
        this.kSJ.setChecked(true);
        findViewById(2131758286).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.kSU.getString(2131236058));
                linkedList2.add(Integer.valueOf(0));
                if (this.kSU.kMo != null && this.kSU.kMo.kOt) {
                    linkedList.add(this.kSU.getString(2131236057));
                    linkedList2.add(Integer.valueOf(1));
                }
                g.a(this.kSU, "", linkedList, linkedList2, "", new d(this) {
                    final /* synthetic */ AnonymousClass5 kSX;

                    {
                        this.kSX = r1;
                    }

                    public final void bw(int i, int i2) {
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", this.kSX.kSU.getString(2131235974, new Object[]{u.bsY()}));
                                break;
                            case 1:
                                if (this.kSX.kSU.kMo != null) {
                                    intent.putExtra("rawUrl", this.kSX.kSU.getString(2131235973, new Object[]{u.bsY(), this.kSX.kSU.kMo.hMt}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.ay.c.b(this.kSX.kSU.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
        });
        this.kSy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void onClick(View view) {
                this.kSU.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
            }
        });
        this.kHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardImportUI kSU;

            {
                this.kSU = r1;
            }

            public final void onClick(View view) {
                this.kSU.bgX();
            }
        });
        av();
        Ox();
    }

    private void av() {
        WalletFormView walletFormView = null;
        if (this.kSR != null) {
            WalletFormView walletFormView2;
            findViewById(2131759848).setVisibility(0);
            if (be.kS(this.uA.getString("key_bank_username"))) {
                this.kSJ.setVisibility(8);
            } else {
                CharSequence string = this.uA.getString("key_recommand_desc");
                if (be.kS(string)) {
                    this.kSJ.setText(getString(2131236091, new Object[]{this.kSR.field_bankName}));
                } else {
                    this.kSJ.setText(string);
                }
                this.kSJ.setVisibility(0);
            }
            this.kSw.setVisibility(8);
            this.kSx.setVisibility(8);
            this.kSy.setVisibility(8);
            this.kSz.setVisibility(8);
            this.kSA.setVisibility(8);
            this.kSB.setVisibility(8);
            this.kSC.setVisibility(8);
            if (be.kS(this.kSR.field_bankcardTail) || !b(this.kSF, this.kSR.kNr)) {
                this.kSF.setVisibility(8);
                walletFormView2 = null;
            } else {
                walletFormView2 = this.kSF;
                walletFormView = this.kSF;
            }
            String string2;
            if (this.kSR.bfH()) {
                string2 = getString(2131236153);
            } else {
                string2 = getString(2131236167);
            }
            if (be.kS(this.kSR.field_bankName) || !b(this.kSr, this.kSR.field_bankName + " " + r2)) {
                this.kSr.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kSr;
                }
                walletFormView = this.kSr;
            }
            if (b(this.kRY, this.kSR.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kRY;
                }
                walletFormView = this.kRY;
            }
            if (b(this.kSu, k.bgi().E(this.nDR.nEl, this.kSR.kMU))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kSu;
                }
                walletFormView = this.kSu;
            }
            if (b(this.kKF, this.kSR.kNq)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kKF;
                }
                walletFormView = this.kKF;
            }
            if (b(this.kSv, this.kSR.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kSv;
                }
                walletFormView = this.kSv;
            }
            if (b(this.kSt, this.kSR.kMW)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kSt;
                }
                walletFormView = this.kSt;
            }
            if (b(this.kSs, this.kSR.kNs)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.kSs;
                }
                walletFormView = this.kSs;
            }
            walletFormView2.setBackgroundResource(2130838046);
            walletFormView.setBackgroundResource(2130838046);
            if (k.bga().bgs()) {
                this.kHi.setText(2131236103);
            } else {
                this.kHi.setText(2131236101);
            }
        }
    }

    private static boolean b(WalletFormView walletFormView, String str) {
        if (be.kS(str)) {
            walletFormView.setVisibility(8);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        return true;
    }

    private void bgX() {
        if (Ox()) {
            c.bhu();
            this.hdp = new Authen();
            this.uA.putBoolean("key_is_follow_bank_username", this.kSJ.isChecked());
            if (this.kSR == null || be.kS(this.kSR.kNB)) {
                String text;
                boolean z;
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
                this.uA.putString("key_mobile", e.PT(this.hdp.kLp));
                Bundle bundle = this.uA;
                String str = "key_is_oversea";
                if (this.kMo.kLu == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.hdp.kMT = this.kKF.getText();
                this.hdp.kMS = this.kRY.getText();
                this.hdp.kMX = this.kSs.getText();
                v.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.hdp.imN + " elemt.bankcardTag : " + this.kMo.kLu);
            } else {
                this.hdp.kGo = this.kSR.kNB;
                this.hdp.hMu = this.kSR.field_bindSerial;
                this.hdp.hMt = this.kSR.field_bankcardType;
                this.hdp.kMU = this.kSR.kMU;
                this.hdp.kMR = this.uA.getString("key_pwd1");
                this.hdp.token = this.uA.getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.ae(this);
            if (bLD().j(this.hdp, this.ith)) {
                v.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                v.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.uA;
        v.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.kIA);
        if (!(kVar instanceof l)) {
            return false;
        }
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, bundle);
        g.bf(this, getString(2131236024));
        return true;
    }

    protected final int getLayoutId() {
        return 2130904628;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.kMo = (ElementQuery) intent.getParcelableExtra("elemt_query");
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
            }
            Ox();
        }
    }

    private boolean Ox() {
        boolean z;
        if (this.kSS.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.kHi.setEnabled(true);
            this.kHi.setClickable(true);
        } else {
            this.kHi.setEnabled(false);
            this.kHi.setClickable(false);
        }
        return z;
    }

    public final void fc(boolean z) {
        Ox();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        v.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.kSE == null) {
                    bgX();
                } else if (this.kSE.isEnabled() && !this.kSE.isClickable() && this.kSE.bLJ()) {
                    this.kSE.bLL();
                } else {
                    this.kSE.performClick();
                }
                return true;
            default:
                if (this.kSE == null) {
                    bgX();
                }
                return false;
        }
    }

    public void onDestroy() {
        if (this.oy != null && this.oy.isShowing()) {
            this.oy.dismiss();
            this.oy = null;
        }
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                i iVar = new i(this, 2131558996);
                iVar.setContentView(2130904651);
                ListView listView = (ListView) iVar.findViewById(2131755317);
                listView.setAdapter(this.kST);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletCardImportUI kSU;

                    {
                        this.kSU = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.kSU.dismissDialog(1);
                        int intValue = ((Integer) this.kSU.kMo.bfN().get(i)).intValue();
                        if (this.kSU.kKJ != intValue) {
                            this.kSU.kKJ = intValue;
                            this.kSU.kSu.setText(((CheckedTextView) view).getText().toString());
                            WalletCardImportUI.c(this.kSU.kKF, this.kSU.kKJ);
                            this.kSU.kKF.aJx();
                            this.kSU.av();
                        }
                    }
                });
                return iVar;
            default:
                return super.onCreateDialog(i);
        }
    }
}
