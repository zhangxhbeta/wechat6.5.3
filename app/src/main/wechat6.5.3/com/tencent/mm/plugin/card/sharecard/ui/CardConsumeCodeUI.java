package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI extends MMActivity implements OnClickListener, a, d.a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private b eBg;
    private boolean eFA = false;
    private String eFo;
    private a eFp;
    private TextView eFq;
    private TextView eFr;
    private LinearLayout eFs;
    private ImageView eFt;
    private View eFu;
    private LinearLayout eFv;
    private View eFw;
    private TextView eFx;
    private TextView eFy;
    private TextView eFz;
    private Vibrator ewK;
    private int exT = 3;

    protected final int getLayoutId() {
        return 2130903211;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.eBg = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.exT = getIntent().getIntExtra("key_from_scene", 3);
        this.eFo = getIntent().getStringExtra("key_mark_user");
        if (this.eBg == null || this.eBg.Zv() == null || this.eBg.Zw() == null) {
            v.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        NI();
        af.aaq().l("", "", 3);
    }

    protected final void NI() {
        if (this.eBg.Zc()) {
            if (TextUtils.isEmpty(this.eBg.Zv().eCC)) {
                Fd(getString(2131231602, new Object[]{getString(2131231648)}));
            } else {
                Fd(getString(2131231602, new Object[]{this.eBg.Zv().eCC}));
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardConsumeCodeUI eFB;

            {
                this.eFB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eFB.setResult(-1);
                this.eFB.finish();
                return true;
            }
        });
        if (this.eFp == null) {
            this.eFp = new a(this, this.nDR.dtW);
            a aVar = this.eFp;
            aVar.eFk = aVar.eBk.getWindow().getAttributes().screenBrightness;
            a aVar2 = this.eFp;
            aVar2.eFd = (TextView) aVar2.eEX.findViewById(2131755773);
            aVar2.eFe = (TextView) aVar2.eEX.findViewById(2131755766);
            aVar2.eFf = (CheckBox) aVar2.eEX.findViewById(2131755777);
            aVar2.eFf.setChecked(true);
            aVar2.eFf.setOnClickListener(aVar2.eFl);
            if (aVar2.eFk < 0.8f) {
                aVar2.K(0.8f);
            }
            this.eFp.eFj = new a.a(this) {
                final /* synthetic */ CardConsumeCodeUI eFB;

                {
                    this.eFB = r1;
                }

                public final void ja(int i) {
                    af.aaw().v(this.eFB.eBg.Zz(), i, 1);
                }
            };
        }
        this.eFp.eBg = this.eBg;
        this.eFp.eFi = true;
        if (this.eBg.Zb()) {
            aVar = this.eFp;
            String str = this.eFo;
            aVar.eFh = 1;
            aVar.eFg = str;
        }
        this.ewK = (Vibrator) getSystemService("vibrator");
        this.eFq = (TextView) findViewById(2131755761);
        this.eFr = (TextView) findViewById(2131755226);
        this.eFs = (LinearLayout) findViewById(2131755762);
        this.eFt = (ImageView) findViewById(2131755763);
        this.eFu = findViewById(2131755764);
        this.eFv = (LinearLayout) findViewById(2131755765);
        if (this.eBg.Zc()) {
            findViewById(2131755759).setBackgroundColor(getResources().getColor(2131689900));
            k.b((MMActivity) this, getResources().getColor(2131689900));
        } else {
            findViewById(2131755759).setBackgroundColor(j.qv(this.eBg.Zv().coN));
            k.a((MMActivity) this, this.eBg);
        }
        if (!this.eBg.Zc() || TextUtils.isEmpty(this.eBg.Zv().eBM)) {
            this.eFq.setText(this.eBg.Zv().eCD);
            this.eFr.setText(this.eBg.Zv().title);
        } else {
            this.eFs.setVisibility(0);
            this.eFq.setVisibility(8);
            this.eFr.setVisibility(8);
            this.eFu.setVisibility(8);
            k.a(this.eFt, this.eBg.Zv().eBM, getResources().getDimensionPixelSize(2131493346), 2130838736, true);
        }
        if (this.eBg.Zv().mlr != null) {
            ld ldVar = this.eBg.Zv().mlr;
            if (!TextUtils.isEmpty(ldVar.title)) {
                if (this.eFw == null) {
                    this.eFw = ((ViewStub) findViewById(2131755774)).inflate();
                }
                this.eFw.setOnClickListener(this);
                this.eFx = (TextView) this.eFw.findViewById(2131755944);
                this.eFy = (TextView) this.eFw.findViewById(2131755943);
                this.eFz = (TextView) this.eFw.findViewById(2131755945);
                this.eFx.setVisibility(0);
                this.eFx.setText(ldVar.title);
                Drawable drawable = getResources().getDrawable(2130837841);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                drawable.setColorFilter(j.qv(this.eBg.Zv().coN), Mode.SRC_IN);
                this.eFx.setCompoundDrawables(null, null, drawable, null);
                this.eFx.setTextColor(j.qv(this.eBg.Zv().coN));
                this.eFx.setOnClickListener(this);
                if (TextUtils.isEmpty(ldVar.eBN)) {
                    this.eFy.setVisibility(0);
                    this.eFy.setText(getString(2131231649));
                } else {
                    this.eFy.setVisibility(0);
                    this.eFy.setText(ldVar.eBN);
                }
                if (!TextUtils.isEmpty(ldVar.eBO)) {
                    this.eFz.setVisibility(0);
                    this.eFz.setText(ldVar.eBO);
                }
                LayoutParams layoutParams = this.eFt.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(2131493347);
                layoutParams.width = getResources().getDimensionPixelSize(2131493347);
                this.eFt.setLayoutParams(layoutParams);
                layoutParams = this.eFs.getLayoutParams();
                layoutParams.height = com.tencent.mm.bd.a.fromDPToPix(this, 54);
                layoutParams.width = com.tencent.mm.bd.a.fromDPToPix(this, 54);
                this.eFs.setLayoutParams(layoutParams);
                k.a(this.eFt, this.eBg.Zv().eBM, getResources().getDimensionPixelSize(2131493347), 2130838736, true);
                this.eFv.setPadding(0, com.tencent.mm.bd.a.fromDPToPix(this, 10), 0, com.tencent.mm.bd.a.fromDPToPix(this, 30));
            }
        }
        af.aav().a((d.a) this);
        if (this.eBg.Zp()) {
            af.aax().a(this);
            if (af.aax().isEmpty()) {
                v.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                af.aax().pG(this.eBg.Zz());
                return;
            }
            af.aax().ZL();
        }
    }

    protected void onResume() {
        this.eFp.aaI();
        af.aav().a(this, true);
        super.onResume();
    }

    protected void onPause() {
        af.aav().a(this, false);
        super.onPause();
    }

    protected void onDestroy() {
        a aVar = this.eFp;
        aVar.K(aVar.eFk);
        j.l(aVar.eFb);
        j.l(aVar.eFc);
        aVar.eFj = null;
        aVar.eBk = null;
        af.aav().c(this);
        af.aav().b(this);
        if (this.eBg.Zp()) {
            af.aax().b(this);
            af.aax().ZM();
        }
        this.ewK.cancel();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            v.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void f(b bVar) {
        v.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (bVar != null && bVar.Zz() != null && bVar.Zz().equals(this.eBg.Zz())) {
            this.eBg = bVar;
            this.eFp.eBg = this.eBg;
            this.eFp.aaI();
        }
    }

    public final void ZS() {
        this.ewK.vibrate(300);
    }

    public final void ZT() {
        v.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
    }

    public final void pI(String str) {
        v.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.eFA) {
            v.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            return;
        }
        v.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.eFA = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.eBg.Zz());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.eBg.Zv().coN);
        intent.putExtra("key_stastic_scene", this.exT);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
    }

    public final void ZN() {
        this.eFp.aaI();
    }

    public final void pF(String str) {
        c.a(this, str, true);
    }

    public final void onSuccess() {
        this.eFp.aaI();
    }

    public void onClick(View view) {
        if (view.getId() == 2131755944 || view.getId() == 2131755775) {
            if (this.eBg.Zo()) {
                g.b bVar = new g.b();
                com.tencent.mm.plugin.card.b.b.a(this, bVar.eBz, bVar.eBA, false, this.eBg);
            } else {
                ld ldVar = this.eBg.Zv().mlr;
                if (!(ldVar == null || TextUtils.isEmpty(ldVar.url))) {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) this, j.o(ldVar.url, ldVar.mlB), 1);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11941, new Object[]{Integer.valueOf(9), this.eBg.Zz(), this.eBg.ZA(), "", ldVar.title});
                    if (j.a(ldVar, this.eBg.Zz())) {
                        String Zz = this.eBg.Zz();
                        String str = ldVar.title;
                        j.qB(Zz);
                        com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.eBg.Zv().eCD);
                    }
                }
            }
            finish();
        }
    }
}
