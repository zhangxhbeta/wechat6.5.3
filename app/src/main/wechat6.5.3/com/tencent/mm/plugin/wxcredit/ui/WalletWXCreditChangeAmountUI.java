package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private boolean lwA;
    private TextView lwB;
    private TextView lwC;
    private TextView lwD;
    private TextView lwE;
    private TextView lwF;
    private TextView lwG;
    private EditText lwH;
    private EditText lwI;
    private EditText lwJ;
    private EditText lwK;
    private BaseAdapter lwL = new BaseAdapter(this) {
        final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

        {
            this.lwN = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return tp(i);
        }

        public final int getCount() {
            return this.lwN.lwv != null ? this.lwN.lwv.size() : 0;
        }

        private l tp(int i) {
            return (l) this.lwN.lwv.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.lwN, 2130904652, null);
            l tp = tp(i);
            checkedTextView.setText(tp.desc);
            checkedTextView.setChecked(tp.lwk != 0);
            return checkedTextView;
        }
    };
    private BaseAdapter lwM = new BaseAdapter(this) {
        final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

        {
            this.lwN = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return (l) this.lwN.lwv.get(i);
        }

        public final int getCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.lwN, 2130904652, null);
            if (i == 0) {
                checkedTextView.setText(2131231183);
            } else {
                checkedTextView.setText(2131231104);
            }
            if (this.lwN.lwA) {
                if (this.lwN.lww.lwn == null || !"Y".equals(this.lwN.lww.hbw)) {
                    if (i == 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                } else {
                    if (i != 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                }
            } else if (this.lwN.lwx.lwn == null || !"Y".equals(this.lwN.lwx.hbw)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
            return checkedTextView;
        }
    };
    private List<l> lwu;
    private List<l> lwv = new ArrayList();
    private l lww;
    private l lwx;
    private int lwy = -1;
    private boolean lwz;

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        walletWXCreditChangeAmountUI.lwv.clear();
        if (walletWXCreditChangeAmountUI.lwz) {
            for (l lVar : walletWXCreditChangeAmountUI.lwu) {
                if (lVar.lwk != 2) {
                    walletWXCreditChangeAmountUI.lwv.add(lVar);
                }
            }
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.lwu) {
            if (lVar2.lwk != 1) {
                walletWXCreditChangeAmountUI.lwv.add(lVar2);
            }
        }
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        if (walletWXCreditChangeAmountUI.lww == null || walletWXCreditChangeAmountUI.lwx == null) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.lwH.getVisibility() == 0 && be.kS(walletWXCreditChangeAmountUI.lwH.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.lwI.getVisibility() == 0 && be.kS(walletWXCreditChangeAmountUI.lwI.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.lwF.getVisibility() == 0 && be.kS(walletWXCreditChangeAmountUI.lwF.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.lwJ.getVisibility() == 0 && be.kS(walletWXCreditChangeAmountUI.lwJ.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.lwK.getVisibility() == 0 && be.kS(walletWXCreditChangeAmountUI.lwK.getText().toString())) {
            return false;
        }
        return (walletWXCreditChangeAmountUI.lwG.getVisibility() == 0 && be.kS(walletWXCreditChangeAmountUI.lwG.getText().toString())) ? false : true;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate;
        ListView listView;
        a aVar;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(2130904651, null);
                listView = (ListView) inflate.findViewById(2131755317);
                listView.setAdapter(this.lwL);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

                    {
                        this.lwN = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.lwN.dismissDialog(1);
                        if (this.lwN.lwz) {
                            this.lwN.lww.lwk = 0;
                            this.lwN.lww = (l) this.lwN.lwv.get(i);
                            this.lwN.lww.lwk = 1;
                        } else {
                            this.lwN.lwx.lwk = 0;
                            this.lwN.lwx = (l) this.lwN.lwv.get(i);
                            this.lwN.lwx.lwk = 2;
                        }
                        this.lwN.av();
                    }
                });
                aVar = new a(this);
                aVar.wm(2131236579);
                aVar.cC(inflate);
                aVar.c(null);
                return aVar.RX();
            case 2:
                inflate = getLayoutInflater().inflate(2130904651, null);
                listView = (ListView) inflate.findViewById(2131755317);
                listView.setAdapter(this.lwM);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

                    {
                        this.lwN = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.lwN.dismissDialog(2);
                        if (this.lwN.lwA) {
                            if (i == 0) {
                                this.lwN.lww.hbw = "Y";
                            } else {
                                this.lwN.lww.hbw = "N";
                            }
                        } else if (i == 0) {
                            this.lwN.lwx.hbw = "Y";
                        } else {
                            this.lwN.lwx.hbw = "N";
                        }
                        this.lwN.av();
                    }
                });
                aVar = new a(this);
                aVar.wm(2131236575);
                aVar.cC(inflate);
                aVar.c(null);
                return aVar.RX();
            case 3:
                String string = getString(2131236578);
                if (this.lwy > 0) {
                    string = getString(2131236576, new Object[]{Integer.valueOf(this.lwy)});
                }
                return g.a(this, string, null, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

                    {
                        this.lwN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b ae = com.tencent.mm.wallet_core.a.ae(this.lwN);
                        if (ae != null) {
                            ae.d(this.lwN, this.lwN.uA);
                        } else {
                            this.lwN.finish();
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

                    {
                        this.lwN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.lwN.aJs();
                    }
                });
            default:
                return g.A(this, "", "");
        }
    }

    public final int getLayoutId() {
        return 2130904694;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        av();
    }

    protected final void NI() {
        vD(2131236581);
        this.lwB = (TextView) findViewById(2131760043);
        this.lwD = (TextView) findViewById(2131760046);
        this.lwC = (TextView) findViewById(2131760048);
        this.lwE = (TextView) findViewById(2131760051);
        this.lwH = (EditText) findViewById(2131760044);
        this.lwI = (EditText) findViewById(2131760047);
        this.lwJ = (EditText) findViewById(2131760049);
        this.lwK = (EditText) findViewById(2131760052);
        this.lwF = (TextView) findViewById(2131760045);
        this.lwG = (TextView) findViewById(2131760050);
        this.lwF.setOnClickListener(this);
        this.lwG.setOnClickListener(this);
        this.lwB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

            {
                this.lwN = r1;
            }

            public final void onClick(View view) {
                this.lwN.lwz = true;
                WalletWXCreditChangeAmountUI.a(this.lwN);
                this.lwN.showDialog(1);
            }
        });
        this.lwC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

            {
                this.lwN = r1;
            }

            public final void onClick(View view) {
                this.lwN.lwz = false;
                WalletWXCreditChangeAmountUI.a(this.lwN);
                this.lwN.showDialog(1);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

            {
                this.lwN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lwN.axg();
                this.lwN.showDialog(3);
                return true;
            }
        });
        findViewById(2131756365).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

            {
                this.lwN = r1;
            }

            public final void onClick(View view) {
                if (WalletWXCreditChangeAmountUI.b(this.lwN)) {
                    if (this.lwN.lww.lwn == null) {
                        this.lwN.lww.hbw = this.lwN.lwH.getText().toString();
                    } else if (this.lwN.lwI.getVisibility() == 0) {
                        this.lwN.lww.lwn.hbw = this.lwN.lwI.getText().toString();
                    }
                    if (this.lwN.lwx.lwn == null) {
                        this.lwN.lwx.hbw = this.lwN.lwJ.getText().toString();
                    } else if (this.lwN.lwK.getVisibility() == 0) {
                        this.lwN.lwx.lwn.hbw = this.lwN.lwK.getText().toString();
                    }
                    List arrayList = new ArrayList();
                    arrayList.add(this.lwN.lww);
                    arrayList.add(this.lwN.lwx);
                    String string = this.lwN.uA.getString("kreq_token");
                    this.lwN.uA.getString("key_bank_type");
                    this.lwN.p(new c(arrayList, string));
                    return;
                }
                s.makeText(this.lwN.nDR.nEl, 2131236577, 0).show();
            }
        });
    }

    private void av() {
        if (this.lww != null) {
            this.lwB.setText(this.lww.desc);
            if (this.lww.lwn != null) {
                this.lwF.setVisibility(0);
                this.lwH.setVisibility(8);
                this.lwD.setText(this.lww.lwn.desc);
                this.lwI.setHint(this.lww.lwn.eEL);
                if ("Y".equals(this.lww.hbw)) {
                    this.lwD.setVisibility(0);
                    this.lwI.setVisibility(0);
                    this.lwF.setText(2131231183);
                } else {
                    this.lwD.setVisibility(8);
                    this.lwI.setVisibility(8);
                    if ("N".equals(this.lww.hbw)) {
                        this.lwF.setText(2131231104);
                    }
                }
            } else {
                this.lwF.setVisibility(8);
                this.lwH.setVisibility(0);
                this.lwH.setHint(this.lww.eEL);
                this.lwD.setVisibility(8);
                this.lwI.setVisibility(8);
            }
        }
        if (this.lwx != null) {
            this.lwC.setText(this.lwx.desc);
            if (this.lwx.lwn != null) {
                this.lwG.setVisibility(0);
                this.lwJ.setVisibility(8);
                this.lwE.setText(this.lwx.lwn.desc);
                this.lwK.setHint(this.lwx.lwn.eEL);
                if ("Y".equals(this.lwx.hbw)) {
                    this.lwE.setVisibility(0);
                    this.lwK.setVisibility(0);
                    this.lwG.setText(2131231183);
                    return;
                }
                this.lwE.setVisibility(8);
                this.lwK.setVisibility(8);
                if ("N".equals(this.lwx.hbw)) {
                    this.lwG.setText(2131231104);
                    return;
                }
                return;
            }
            this.lwG.setVisibility(8);
            this.lwJ.setVisibility(0);
            this.lwJ.setHint(this.lwx.eEL);
            this.lwE.setVisibility(8);
            this.lwK.setVisibility(8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                this.lwu = ((e) kVar).lvR;
                this.lwy = ((e) kVar).lvS;
                if (this.lwu != null && this.lwu.size() >= 2) {
                    this.lww = (l) this.lwu.get(0);
                    this.lwx = (l) this.lwu.get(1);
                    this.lww.lwk = 1;
                    this.lwx.lwk = 2;
                }
                av();
                return true;
            }
        } else if (kVar instanceof c) {
            g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletWXCreditChangeAmountUI lwN;

                {
                    this.lwN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b ae = com.tencent.mm.wallet_core.a.ae(this.lwN);
                    if (ae != null) {
                        ae.d(this.lwN, this.lwN.uA);
                    } else {
                        this.lwN.finish();
                    }
                }
            });
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == 2131760045) {
            this.lwA = true;
            showDialog(2);
        } else if (view.getId() == 2131760050) {
            this.lwA = false;
            showDialog(2);
        }
    }
}
