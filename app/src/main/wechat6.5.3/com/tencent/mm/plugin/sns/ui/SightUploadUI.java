package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.bd.a;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.h.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics imb;
    private SnsEditText jJZ;
    private w jKa = null;
    private LinearLayout jKb;
    private SnsSightUploadSayFooter jKc;
    private boolean jKd = false;
    private long jKe = 0;
    private String jhM = "";
    private String jhN = "";
    private int jhO = 0;
    private int jhP = 0;
    private ArrayList<String> jhQ;
    private boolean jhR = false;
    private int jhS = 0;

    public void onCreate(Bundle bundle) {
        e.f(this);
        super.onCreate(bundle);
        this.imb = getResources().getDisplayMetrics();
        this.jKa = new ai(this);
        this.jKa.v(bundle);
        this.jKb = (LinearLayout) findViewById(2131759457);
        this.jKb.addView(this.jKa.aVz());
        vD(2131235562);
        cU().cV().setBackgroundDrawable(getResources().getDrawable(2131689547));
        this.jKd = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.jKe = getIntent().getLongExtra("KTouchCameraTime", 0);
        NI();
        e.g(this);
    }

    protected final int getLayoutId() {
        return 2130904494;
    }

    protected final void NI() {
        this.jJZ = (SnsEditText) findViewById(2131759456);
        this.jJZ.setTextSize(1, (u.ds(this.nDR.nEl) * this.jJZ.getTextSize()) / a.getDensity(this.nDR.nEl));
        final int paddingLeft = this.imb.widthPixels - (this.jJZ.getPaddingLeft() + this.jKb.getPaddingRight());
        this.jJZ.postDelayed(new Runnable(this) {
            final /* synthetic */ SightUploadUI jKg;

            public final void run() {
                this.jKg.jJZ.setWidth((int) (((double) paddingLeft) * 0.7d));
                this.jKg.jKb.setLayoutParams(new LayoutParams((int) (((double) paddingLeft) * 0.3d), this.jKg.jKb.getHeight()));
            }
        }, 100);
        if (!be.kS(getIntent().getStringExtra("Kdescription"))) {
            this.jJZ.setText(getIntent().getStringExtra("Kdescription"));
        }
        this.jJZ.pcr = new MMEditText.a(this) {
            final /* synthetic */ SightUploadUI jKg;

            {
                this.jKg = r1;
            }

            public final void ayj() {
                this.jKg.axg();
                ne neVar = new ne();
                neVar.bor.type = 0;
                neVar.bor.bot = false;
                com.tencent.mm.sdk.c.a.nhr.z(neVar);
                this.jKg.finish();
            }
        };
        this.jKc = (SnsSightUploadSayFooter) findViewById(2131757964);
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.jKc;
        SnsEditText snsEditText = this.jJZ;
        snsSightUploadSayFooter.jij = snsEditText;
        snsEditText.setOnClickListener(new OnClickListener(snsSightUploadSayFooter) {
            final /* synthetic */ SnsSightUploadSayFooter jTf;

            {
                this.jTf = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (this.jTf.getVisibility() == 8) {
                    this.jTf.setVisibility(0);
                }
                if (this.jTf.hhM.getVisibility() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    this.jTf.SR();
                }
            }
        });
        snsEditText.setOnEditorActionListener(new OnEditorActionListener(snsSightUploadSayFooter) {
            final /* synthetic */ SnsSightUploadSayFooter jTf;

            {
                this.jTf = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        ad.g(new Runnable(snsSightUploadSayFooter) {
            final /* synthetic */ SnsSightUploadSayFooter jTf;

            {
                this.jTf = r1;
            }

            public final void run() {
                this.jTf.jij.performClick();
                this.jTf.jij.requestFocus();
                this.jTf.aWn.aJs();
            }
        }, 200);
        this.jKc.setVisibility(0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SightUploadUI jKg;

            {
                this.jKg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ne neVar = new ne();
                neVar.bor.type = 0;
                neVar.bor.bot = false;
                com.tencent.mm.sdk.c.a.nhr.z(neVar);
                this.jKg.axg();
                this.jKg.finish();
                return true;
            }
        });
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            a(1, 2131165918, new OnMenuItemClickListener(this) {
                final /* synthetic */ SightUploadUI jKg;

                {
                    this.jKg = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    g.a(this.jKg.nDR.nEl, null, new String[]{this.jKg.getString(2131235346)}, null, new c(this) {
                        final /* synthetic */ AnonymousClass4 jKh;

                        {
                            this.jKh = r1;
                        }

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    ne neVar = new ne();
                                    neVar.bor.type = 0;
                                    neVar.bor.bow = true;
                                    neVar.bor.bot = true;
                                    com.tencent.mm.sdk.c.a.nhr.z(neVar);
                                    this.jKh.jKg.axg();
                                    this.jKh.jKg.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return false;
                }
            });
        }
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ SightUploadUI jKg;

            {
                this.jKg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.jKg.isFinishing()) {
                    this.jKg.desc = this.jKg.jJZ.getText().toString();
                    final int i = this.jKg.jJZ.jOn;
                    com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.jKg.jJZ).yn(b.sE());
                    yn.oWy = true;
                    yn.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                        final /* synthetic */ AnonymousClass5 jKj;

                        public final void qK(String str) {
                            PInt pInt = new PInt();
                            this.jKj.jKg.jKa.a(this.jKj.jKg.jhS, 0, null, this.jKj.jKg.desc, null, this.jKj.jKg.jKc.jTe.aVN(), i, this.jKj.jKg.jhR, this.jKj.jKg.jhQ, pInt, "", this.jKj.jKg.jhO, this.jKj.jKg.jhP);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            Object[] objArr = new Object[4];
                            objArr[0] = Long.valueOf(this.jKj.jKg.jKe);
                            objArr[1] = Long.valueOf(be.Nh());
                            objArr[2] = Integer.valueOf(this.jKj.jKg.jKd ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            gVar.h(13303, objArr);
                            String str2 = "MicroMsg.SightUploadUI";
                            String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                            objArr = new Object[4];
                            objArr[0] = Long.valueOf(this.jKj.jKg.jKe);
                            objArr[1] = Long.valueOf(be.Nh());
                            objArr[2] = Integer.valueOf(this.jKj.jKg.jKd ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            v.d(str2, str3, objArr);
                        }

                        public final void adq() {
                        }

                        public final void adr() {
                            g.f(this.jKj.jKg, 2131235575, 2131235576);
                        }
                    });
                }
                return false;
            }
        }, k.b.nEV);
        iT(true);
    }

    public void onResume() {
        super.onResume();
        v.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.jKc;
        if (snsSightUploadSayFooter.hhM.getVisibility() == 8) {
            snsSightUploadSayFooter.aWn.aJs();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.jKa.aVA();
        this.jKc.jTe.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.jKc;
        if (snsSightUploadSayFooter.hhM != null) {
            snsSightUploadSayFooter.hhM.ahl();
            snsSightUploadSayFooter.hhM.destroy();
        }
    }

    protected void onPause() {
        super.onPause();
        axg();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6 || i == 5 || i == 10) {
                SnsSightUploadSayFooter snsSightUploadSayFooter = this.jKc;
                if (intent != null) {
                    if (i == 10) {
                        snsSightUploadSayFooter.jTe.G(intent);
                    } else if (i == 5) {
                        snsSightUploadSayFooter.jik.a(i, i2, intent, null);
                    }
                }
            }
            if (i == 5 && intent != null) {
                int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                if (intExtra >= 2) {
                    this.jhM = intent.getStringExtra("Klabel_name_list");
                    this.jhN = intent.getStringExtra("Kother_user_name_list");
                    List<String> asList = Arrays.asList(this.jhM.split(","));
                    List list;
                    if (be.kS(this.jhN)) {
                        list = null;
                    } else {
                        list = Arrays.asList(this.jhN.split(","));
                    }
                    this.jhQ = new ArrayList();
                    if (asList != null && asList.size() > 0) {
                        for (String vv : asList) {
                            List<String> vy = j.a.bmu().vy(j.a.bmu().vv(vv));
                            if (vy == null || vy.size() == 0) {
                                v.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                                break;
                            }
                            for (String vv2 : vy) {
                                if (!this.jhQ.contains(vv2)) {
                                    this.jhQ.add(vv2);
                                    v.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[]{vv2});
                                }
                            }
                        }
                    }
                    if (asList != null) {
                        int i3 = 0;
                        for (String vv22 : asList) {
                            int i4;
                            if (be.kS(vv22)) {
                                i4 = i3;
                            } else {
                                i4 = i3 + 1;
                            }
                            i3 = i4;
                        }
                        this.jhO = i3;
                    }
                    this.jhP = 0;
                    if (r1 != null && r1.size() > 0) {
                        for (String vv222 : r1) {
                            if (!this.jhQ.contains(vv222)) {
                                this.jhQ.add(vv222);
                                this.jhP++;
                            }
                        }
                    }
                    if (intExtra == 2) {
                        this.jhR = false;
                    } else {
                        this.jhR = true;
                    }
                }
                if (1 == intExtra) {
                    this.jhS = 1;
                } else {
                    this.jhS = 0;
                }
            }
        }
    }
}
