package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.p.c;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.j.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;

public class CardIndexUI extends CardBaseUI {
    private final String TAG = "MicroMsg.CardIndexUI";
    private View eJZ;
    private TextView eKa;
    private f eKb;
    private TextView eKc;
    private TextView eKd;
    private ImageView eKe;
    private LinearLayout eKf;
    int eKg = -1;
    int fromScene = 0;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.CardIndexUI", "oncreate");
        this.mStartTime = System.currentTimeMillis();
        NI();
        ak.vy().a(984, this);
        af.aaj();
        b.iS(1);
        int i = af.aao().eBC;
        if (c.us().ax(262152, 266256) || i > 0) {
            g.iuh.h(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
            return;
        }
        g.iuh.h(11324, new Object[]{"CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), ""});
    }

    protected void onDestroy() {
        ak.vy().b(984, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        g.iuh.h(13219, new Object[]{"CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected final void NI() {
        if (getIntent() != null) {
            this.eKg = getIntent().getIntExtra("key_card_type", -1);
        }
        super.NI();
    }

    protected final void YN() {
        if (1 == this.eKg) {
            vD(2131231647);
        } else if (3 == this.eKg) {
            vD(2131231717);
        } else {
            vD(2131235051);
        }
        this.eKc = (TextView) findViewById(2131755726);
        this.eKd = (TextView) findViewById(2131755892);
        this.eKe = (ImageView) findViewById(2131755890);
        this.eJZ = findViewById(2131755893);
        this.eKa = (TextView) findViewById(2131755895);
        this.eKf = (LinearLayout) findViewById(2131755891);
        this.eJZ.setVisibility(8);
        this.eKd.setVisibility(0);
        this.eKc.setVisibility(0);
        this.eKe.setVisibility(8);
        LayoutParams layoutParams = (LayoutParams) this.eKf.getLayoutParams();
        layoutParams.topMargin = BackwardSupportUtil.b.a(this, 100.0f);
        this.eKf.setLayoutParams(layoutParams);
        if (1 == this.eKg) {
            this.eKd.setText(getString(2131231638));
            this.eKc.setText(getString(2131231637));
        } else if (3 == this.eKg) {
            this.eKd.setText(getString(2131231643));
            this.eKc.setText(getString(2131231642));
        } else {
            this.eKd.setText(getString(2131231668));
            this.eKc.setText(getString(2131231679));
        }
        this.eKa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardIndexUI eKh;

            {
                this.eKh = r1;
            }

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(this.eKh.eKb.eCI)) {
                    com.tencent.mm.plugin.card.b.b.a(this.eKh, this.eKh.eKb.eCI, 0);
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
    }

    protected final int YO() {
        if (1 == this.eKg) {
            return a.eDk;
        }
        if (3 == this.eKg) {
            return a.eDj;
        }
        return a.eDg;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            return;
        }
        if (kVar instanceof t) {
            ak.yW();
            this.eKb = com.tencent.mm.plugin.card.b.g.qs((String) com.tencent.mm.model.c.vf().get(282885, ""));
            if (this.eKb == null) {
                this.eKb = new f();
            }
            if (!(this.eKb == null || TextUtils.isEmpty(this.eKb.eCG))) {
                this.eKc.setText(this.eKb.eCG);
            }
            if (this.eKb == null || !this.eKb.eCJ) {
                this.eJZ.setVisibility(8);
                return;
            }
            this.eKa.setText(this.eKb.eCH);
            if (TextUtils.isEmpty(this.eKb.eCH) || TextUtils.isEmpty(this.eKb.eCI)) {
                this.eJZ.setVisibility(8);
            } else {
                this.eJZ.setVisibility(0);
            }
        } else if ((kVar instanceof z) && ((z) kVar).eDD && (this.eAB instanceof b)) {
            ((b) this.eAB).iQ(false);
            ((b) this.eAB).iQ(true);
            ((b) this.eAB).Ol();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
