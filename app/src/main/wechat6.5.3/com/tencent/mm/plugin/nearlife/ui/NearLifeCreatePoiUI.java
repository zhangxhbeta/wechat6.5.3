package com.tencent.mm.plugin.nearlife.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.nearlife.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.v.e;
import java.util.LinkedList;

public class NearLifeCreatePoiUI extends MMActivity implements e {
    private TextWatcher abU = new TextWatcher(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.hHD.hHr.getText().toString().trim().length() == 0 || this.hHD.hHs.getText().toString().trim().length() == 0 || this.hHD.hHt.getText().toString().trim().length() == 0) {
                this.hHD.U(0, false);
            } else {
                this.hHD.U(0, true);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private String bpB;
    private p dFI;
    private OnMenuItemClickListener hHA = new OnMenuItemClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            g.iuh.h(11138, new Object[]{"2", "0", this.hHD.bpB});
            NearLifeCreatePoiUI nearLifeCreatePoiUI = this.hHD;
            ActionBarActivity actionBarActivity = this.hHD.nDR.nEl;
            this.hHD.getString(2131234045);
            nearLifeCreatePoiUI.dFI = com.tencent.mm.ui.base.g.a(actionBarActivity, this.hHD.getString(2131234046), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass4 hHE;

                {
                    this.hHE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(this.hHE.hHD.hHw);
                }
            });
            this.hHD.hHn = this.hHD.hHr.getText().toString();
            this.hHD.hHo = this.hHD.hHt.getText().toString();
            this.hHD.hHq = this.hHD.hHs.getText().toString();
            String obj = ((EditText) this.hHD.findViewById(2131758396)).getText().toString();
            LinkedList g = NearLifeCreatePoiUI.g(this.hHD);
            this.hHD.hHw = new a(this.hHD.hHn, this.hHD.hHo, this.hHD.hHq, this.hHD.hHm, g.size(), g, obj);
            ak.vy().a(this.hHD.hHw, 0);
            v.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
            return true;
        }
    };
    private b.a hHB = new b.a(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final void b(Addr addr) {
            CharSequence charSequence = be.ma(addr.cJi) + be.ma(addr.cJk);
            CharSequence charSequence2 = be.ma(addr.cJl) + be.ma(addr.cJm);
            v.d("MicroMsg.NearLifeCreatePoiUI", "get address:" + charSequence);
            if (be.kS(this.hHD.hHt.getText().toString())) {
                this.hHD.hHt.setText(charSequence);
            }
            if (be.kS(this.hHD.hHs.getText().toString()) && !be.kS(charSequence2)) {
                this.hHD.hHs.setText(charSequence2);
            }
            this.hHD.hHp = addr;
        }
    };
    private OnMenuItemClickListener hHC = new OnMenuItemClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.hHD.aDP();
            return true;
        }
    };
    private afu hHm;
    private String hHn;
    private String hHo;
    private Addr hHp;
    private String hHq;
    private EditText hHr;
    private EditText hHs;
    private TextView hHt;
    private TextView hHu;
    private b hHv;
    private a hHw;
    private OnClickListener hHx = new OnClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("ui_title", 2131234055);
            if (this.hHD.hHp != null) {
                intent.putExtra("extra_province", this.hHD.hHp.cJh);
                intent.putExtra("extra_city", this.hHD.hHp.cJi);
            }
            c.b(this.hHD.nDR.nEl, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
        }
    };
    private OnClickListener hHy = new OnClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.hHD.nDR.nEl, SelectPoiCategoryUI.class);
            this.hHD.startActivityForResult(intent, 2);
        }
    };
    private OnClickListener hHz = new OnClickListener(this) {
        final /* synthetic */ NearLifeCreatePoiUI hHD;

        {
            this.hHD = r1;
        }

        public final void onClick(View view) {
            this.hHD.findViewById(2131758392).setVisibility(8);
            this.hHD.findViewById(2131758393).setVisibility(0);
            this.hHD.findViewById(2131758395).setVisibility(0);
        }
    };

    static /* synthetic */ LinkedList g(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        String charSequence = ((TextView) nearLifeCreatePoiUI.findViewById(2131758394)).getText().toString();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new arf().JF(charSequence));
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(650, this);
        this.hHm = new afu();
        this.hHm.mjN = getIntent().getFloatExtra("get_lat", -1000.0f);
        this.hHm.mjM = getIntent().getFloatExtra("get_lng", -1000.0f);
        this.hHm.mrA = getIntent().getIntExtra("get_preci", 0);
        this.hHm.mrC = "";
        this.hHm.mrD = 0;
        this.hHm.mrB = "";
        this.hHv = b.FW();
        if (this.hHv != null) {
            this.hHv.a((double) this.hHm.mjN, (double) this.hHm.mjM, this.hHB);
        }
        this.bpB = getIntent().getStringExtra("search_id");
        v.d("MicroMsg.NearLifeCreatePoiUI", "tofuliutest searchid: %s", new Object[]{this.bpB});
        NI();
    }

    protected final int getLayoutId() {
        return 2130904109;
    }

    protected final void NI() {
        vD(2131234045);
        ((ViewGroup) findViewById(2131758389)).setOnClickListener(this.hHx);
        ((ViewGroup) findViewById(2131758393)).setOnClickListener(this.hHy);
        ((TextView) findViewById(2131758392)).setOnClickListener(this.hHz);
        findViewById(2131758392).setVisibility(8);
        findViewById(2131758393).setVisibility(0);
        findViewById(2131758395).setVisibility(0);
        this.hHr = (EditText) findViewById(2131758388);
        this.hHs = (EditText) findViewById(2131758391);
        this.hHt = (TextView) findViewById(2131758390);
        this.hHu = (TextView) findViewById(2131758394);
        this.hHr.addTextChangedListener(this.abU);
        this.hHs.addTextChangedListener(this.abU);
        this.hHt.addTextChangedListener(this.abU);
        Object ah = be.ah(getIntent().getStringExtra("get_poi_name"), "");
        if (ah.length() != 0) {
            this.hHr.setText(ah);
            this.hHr.setSelection(ah.length());
        }
        com.tencent.mm.ui.tools.a.c.b(this.hHr).yn(100).a(null);
        com.tencent.mm.ui.tools.a.c.b(this.hHs).yn(400).a(null);
        com.tencent.mm.ui.tools.a.c.b((EditText) findViewById(2131758396)).yn(100).a(null);
        a(0, getString(2131231065), this.hHA, k.b.nET);
        U(0, false);
        b(this.hHC);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                String stringExtra = intent.getStringExtra("karea_result");
                if (!be.kS(stringExtra)) {
                    ((TextView) findViewById(2131758390)).setText(stringExtra.replace(" ", ""));
                    return;
                }
                return;
            case 2:
                if (-1 == i2 && intent != null) {
                    this.hHu.setText(be.ma(intent.getStringExtra("poi_category")));
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(650, this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != keyEvent.getKeyCode()) {
            return super.onKeyDown(i, keyEvent);
        }
        aDP();
        return true;
    }

    private void aDP() {
        com.tencent.mm.ui.base.g.a(this, 2131234039, 2131234045, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ NearLifeCreatePoiUI hHD;

            {
                this.hHD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                g.iuh.h(11138, new Object[]{"3", "0", this.hHD.bpB});
                this.hHD.setResult(0, new Intent());
                this.hHD.finish();
            }
        }, null);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.NearLifeCreatePoiUI", "errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.dFI.dismiss();
            a aVar = (a) kVar;
            Intent intent = new Intent();
            if (this.hHm != null) {
                intent.putExtra("get_lat", this.hHm.mjN);
                intent.putExtra("get_lng", this.hHm.mjM);
            }
            if (this.hHp != null) {
                intent.putExtra("get_city", this.hHp.cJi);
            }
            intent.putExtra("get_poi_address", this.hHo);
            intent.putExtra("get_poi_classify_id", aVar.hGd);
            intent.putExtra("get_poi_name", this.hHn);
            intent.putExtra("get_poi_classify_type", 1);
            setResult(-1, intent);
            finish();
            return;
        }
        this.dFI.dismiss();
        Toast.makeText(this.nDR.nEl, getString(2131234043), 1).show();
        this.hHw = null;
    }
}
