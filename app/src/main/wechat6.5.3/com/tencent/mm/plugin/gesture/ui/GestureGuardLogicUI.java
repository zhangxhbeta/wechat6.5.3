package com.tencent.mm.plugin.gesture.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.plugin.gesture.a.b;
import com.tencent.mm.plugin.gesture.a.c;
import com.tencent.mm.plugin.gesture.a.d;
import com.tencent.mm.plugin.gesture.a.e;
import com.tencent.mm.plugin.gesture.ui.widget.PatternLockView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.akt;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, com.tencent.mm.plugin.gesture.ui.widget.PatternLockView.a {
    private String cKN = null;
    private int gBb = 0;
    private int gBc = 0;
    private int gBd = 0;
    private a[] gBe = null;
    private Animation gBf = null;
    private List<c> gBg = null;
    private List<c> gBh = null;
    private boolean gBi = false;
    private int gBj = 0;
    private k gBk = null;
    private k gBl = null;
    private String gBm = null;
    private ViewFlipper gBn = null;
    private Dialog gBo = null;
    private boolean gBp = true;
    private boolean gBq = false;
    private ac mHandler = new ac(Looper.getMainLooper());
    private int mStatus;

    private interface a {
        void onDone();
    }

    static /* synthetic */ void ats() {
        ae.a(com.tencent.mm.model.k.xF(), 9, "PatternLockUpdate", "");
        g.iuh.h(11473, new Object[0]);
    }

    static /* synthetic */ int k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.gBj + 1;
        gestureGuardLogicUI.gBj = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!aa.getPackageName().equals(intent.getPackage()) || be.kS(intent.getAction()) || be.kS(intent.getStringExtra("next_action"))) {
            v.w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            return;
        }
        this.gBn = new ViewFlipper(this);
        this.gBe = new a[]{new a(this), new a(this), new a(this)};
        a[] aVarArr = this.gBe;
        int length = aVarArr.length;
        while (i < length) {
            a aVar = aVarArr[i];
            this.gBn.addView(aVar.mView);
            aVar.gBz.gCb = this;
            aVar.gBA.setOnClickListener(this);
            i++;
        }
        setContentView(this.gBn);
        this.cKN = getIntent().getStringExtra("token");
        this.gBm = getIntent().getStringExtra("type");
        NI();
    }

    protected void onResume() {
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            d.ath();
            e atb = b.atb();
            if (atb.gAZ != -1) {
                d.a(atb);
                if (atb.gBa / 1000 < 600) {
                    b.j(atb.gAZ, atb.gBa);
                    i = 1;
                    if (i != 0) {
                        this.gBj = b.atf();
                        if (this.gBj != -1) {
                            return;
                        }
                    }
                    this.gBj = 0;
                }
                b.atc();
            }
            i = 0;
            if (i != 0) {
                this.gBj = b.atf();
                if (this.gBj != -1) {
                    return;
                }
            }
            this.gBj = 0;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gBk != null) {
            ak.vy().c(this.gBk);
            this.gBk = null;
        }
        if (this.gBl != null) {
            ak.vy().c(this.gBl);
            this.gBl = null;
        }
        if (this.gBo != null && this.gBo.isShowing()) {
            this.gBo.dismiss();
        }
        this.gBn.removeAllViews();
        this.gBn = null;
        for (int i = 0; i < this.gBe.length; i++) {
            a aVar = this.gBe[i];
            aVar.gBz.setOnClickListener(null);
            aVar.gBA.setOnClickListener(null);
            aVar.mView = null;
            aVar.gBx = null;
            aVar.gBy = null;
            aVar.gBz = null;
            aVar.gBA = null;
            this.gBe[i] = null;
        }
        this.gBe = null;
    }

    protected final void NI() {
        axg();
        vE(2131236646);
        this.gBf = AnimationUtils.loadAnimation(this, 2130968663);
        this.gBb = getResources().getColor(2131689764);
        this.gBc = getResources().getColor(2131689765);
        Intent intent = getIntent();
        String action = intent.getAction();
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(action)) {
            this.mStatus = 16;
            C(1, false);
        } else if ("action.verify_pattern".equals(action)) {
            d.ath();
            if (d.atj()) {
                this.gBi = true;
                this.mStatus = 20;
            } else {
                this.gBi = false;
                this.mStatus = 0;
            }
            C(0, false);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GestureGuardLogicUI gBr;

            {
                this.gBr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!this.gBr.atn()) {
                    this.gBr.finish();
                }
                return true;
            }
        });
        v.i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        ato();
    }

    protected final int getLayoutId() {
        return 2130903803;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (intent == null) {
            v.e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
            return;
        }
        int intExtra = intent.getIntExtra("key_result", 0);
        if (intExtra == 0) {
            this.cKN = intent.getStringExtra("key_token");
            this.gBm = intent.getStringExtra("key_type");
            String stringExtra = getIntent().getStringExtra("next_action");
            if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                if ("next_action.modify_pattern".equals(stringExtra)) {
                    this.gBq = true;
                }
                this.gBp = false;
                b(null);
                iV(false);
                this.mStatus = 16;
                C(1, false);
            } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                String str = this.cKN;
                final AnonymousClass12 anonymousClass12 = new com.tencent.mm.v.u.a(this) {
                    final /* synthetic */ GestureGuardLogicUI gBr;

                    {
                        this.gBr = r1;
                    }

                    public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                        if (i2 == 0) {
                            b.atg();
                            b.asY();
                            b.atc();
                            Toast.makeText(this.gBr, this.gBr.getString(2131233181), 0).show();
                        } else {
                            Toast.makeText(this.gBr, this.gBr.getString(2131233165), 0).show();
                        }
                        this.gBr.cKN = null;
                        this.gBr.gBm = null;
                        this.gBr.finish();
                        return 0;
                    }
                };
                a(new OnCancelListener(this) {
                    final /* synthetic */ GestureGuardLogicUI gBr;

                    {
                        this.gBr = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.gBr.gBe[this.gBr.gBd].gBz.atv();
                        if (this.gBr.gBk != null && !this.gBr.gBk.czH) {
                            ak.vy().c(this.gBr.gBk);
                        }
                    }
                });
                if (str == null) {
                    atr();
                    anonymousClass12.a(3, -6, getString(2131233167), null, null);
                } else {
                    com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                    aVar.czn = new aqc();
                    aVar.czo = new aqd();
                    aVar.czm = 688;
                    aVar.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                    com.tencent.mm.v.b Bv = aVar.Bv();
                    aqc com_tencent_mm_protocal_c_aqc = (aqc) Bv.czk.czs;
                    com_tencent_mm_protocal_c_aqc.mPw = new are().ba(str.getBytes());
                    com_tencent_mm_protocal_c_aqc.of = 3;
                    u.a(Bv, new com.tencent.mm.v.u.a(this) {
                        final /* synthetic */ GestureGuardLogicUI gBr;

                        public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                            v.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                            this.gBr.atr();
                            if (i == 0 && i2 == 0) {
                                b.a(((aqd) bVar.czl.czs).mLI);
                                GestureGuardLogicUI.ats();
                            }
                            d.ath().atm();
                            if (anonymousClass12 != null) {
                                return anonymousClass12.a(i, i2, str, bVar, kVar);
                            }
                            return 0;
                        }
                    }, false);
                }
            } else {
                this.mStatus = 1;
            }
            ato();
        } else if (intExtra == -1) {
            Toast.makeText(this, getString(2131233165), 0).show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == 2131757497) {
            com.tencent.mm.ay.c.b(this, "wallet", ".pwd.ui.WalletGestureCheckPwdUI", 1001);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && atn()) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean atn() {
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            atq();
            return false;
        }
        if (this.gBp) {
            String stringExtra = getIntent().getStringExtra("next_action");
            stringExtra = ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) ? getString(2131233162) : getString(2131233163);
            new com.tencent.mm.ui.base.h.a(this).jk(false).Oq(stringExtra).wp(2131233160).a(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI gBr;

                {
                    this.gBr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.gBr.atq();
                    this.gBr.finish();
                }
            }).wq(2131233158).b(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI gBr;

                {
                    this.gBr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).RX().show();
        } else {
            new com.tencent.mm.ui.base.h.a(this).jk(true).wn(2131233164).wp(2131233159).a(new DialogInterface.OnClickListener(this) {
                final /* synthetic */ GestureGuardLogicUI gBr;

                {
                    this.gBr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).RX().show();
        }
        return true;
    }

    private void ato() {
        while (true) {
            final a aVar = this.gBe[this.gBd];
            String stringExtra;
            List list;
            com.tencent.mm.v.b.a aVar2;
            aks com_tencent_mm_protocal_c_aks;
            long elapsedRealtime;
            switch (this.mStatus) {
                case 0:
                    Fd(getString(2131233178));
                    this.gBi = false;
                    aVar.gBz.gBP = true;
                    aVar.gBz.gCb = this;
                    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        aVar.gBx.setText(getString(2131233177));
                    } else {
                        aVar.gBx.setText(getString(2131233176));
                    }
                    aVar.gBx.setTextColor(this.gBb);
                    if (aVar.gBA.getVisibility() != 0) {
                        aVar.gBA.setVisibility(0);
                        return;
                    }
                    return;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        aVar.gBz.atv();
                        C(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        list = this.gBh;
                        final AnonymousClass26 anonymousClass26 = new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233181), 0).show();
                                } else {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233165), 0).show();
                                }
                                this.gBr.gBh = null;
                                this.gBr.finish();
                                return 0;
                            }
                        };
                        a(new OnCancelListener(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.gBr.gBe[this.gBr.gBd].gBz.atv();
                                if (this.gBr.gBl != null && !this.gBr.gBl.czH) {
                                    ak.vy().c(this.gBr.gBl);
                                }
                            }
                        });
                        aVar2 = new com.tencent.mm.v.b.a();
                        aVar2.czn = new aks();
                        aVar2.czo = new akt();
                        aVar2.czm = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.v.b Bv = aVar2.Bv();
                        com_tencent_mm_protocal_c_aks = (aks) Bv.czk.czs;
                        com_tencent_mm_protocal_c_aks.of = 3;
                        are com_tencent_mm_protocal_c_are = new are();
                        d.ath();
                        com_tencent_mm_protocal_c_aks.mLG = com_tencent_mm_protocal_c_are.ba(d.aA(list));
                        u.a(Bv, new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                v.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                this.gBr.atr();
                                if (i == 0 && i2 == 0) {
                                    b.a(((akt) bVar.czl.czs).mLI);
                                    this.gBr.gBi = false;
                                    GestureGuardLogicUI.ats();
                                }
                                if (anonymousClass26 != null) {
                                    return anonymousClass26.a(i, i2, str, bVar, kVar);
                                }
                                return 0;
                            }
                        }, false);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        b.bY(SystemClock.elapsedRealtime());
                        atp();
                        return;
                    } else {
                        return;
                    }
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    b.j(elapsedRealtime, 0);
                    b.lJ(this.gBj);
                    b.ata();
                    if (this.gBj == 5) {
                        this.gBi = true;
                        b.i(elapsedRealtime, 0);
                        aVar.gBz.atv();
                        aVar.gBz.gBP = false;
                        this.mStatus = 20;
                        ato();
                        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(this);
                        aVar3.jk(false).Oq(String.format(getString(2131233161), new Object[]{Long.valueOf(10)}));
                        aVar3.wp(2131233157).a(new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.gBr.onClick(this.gBr.gBe[this.gBr.gBd].gBA);
                            }
                        });
                        aVar3.wq(2131233156).b(new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.gBr.atq();
                                this.gBr.finish();
                            }
                        });
                        aVar3.RX().show();
                        return;
                    }
                    aVar.gBz.gBP = false;
                    aVar.gBz.a(PatternLockView.b.Wrong);
                    a(String.format(getResources().getString(2131233168, new Object[]{Integer.valueOf(5 - this.gBj)}), new Object[0]), new a(this) {
                        final /* synthetic */ GestureGuardLogicUI gBr;

                        public final void onDone() {
                            this.gBr.mStatus = 0;
                            aVar.gBz.atv();
                            aVar.gBz.gBP = true;
                        }
                    });
                    return;
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
                        Fd(getString(2131233179));
                    } else {
                        Fd(getString(2131233180));
                    }
                    this.gBi = false;
                    aVar.gBz.gBP = true;
                    aVar.gBz.gCb = this;
                    aVar.gBx.setText(getString(2131233175));
                    aVar.gBx.setTextColor(getResources().getColor(2131689764));
                    if (aVar.gBA.getVisibility() != 8) {
                        aVar.gBA.setVisibility(8);
                        return;
                    }
                    return;
                case 17:
                    aVar.gBx.setText(getResources().getString(2131233173));
                    aVar.gBx.setTextColor(this.gBb);
                    aVar.gBz.atv();
                    aVar.gBz.gBP = true;
                    if (aVar.gBA.getVisibility() != 8) {
                        aVar.gBA.setVisibility(8);
                        return;
                    }
                    return;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.gBq) {
                            this.gBq = false;
                            a(this.cKN, this.gBg, new com.tencent.mm.v.u.a(this) {
                                final /* synthetic */ GestureGuardLogicUI gBr;

                                {
                                    this.gBr = r1;
                                }

                                public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                    if (i2 == 0) {
                                        Toast.makeText(this.gBr, this.gBr.getString(2131233183), 0).show();
                                        g.iuh.h(11474, new Object[0]);
                                    } else {
                                        Toast.makeText(this.gBr, this.gBr.getString(2131233165), 0).show();
                                    }
                                    this.gBr.cKN = null;
                                    this.gBr.gBg = null;
                                    this.gBr.finish();
                                    return 0;
                                }
                            });
                            return;
                        }
                        list = this.gBh;
                        List list2 = this.gBg;
                        final AnonymousClass22 anonymousClass22 = new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233183), 0).show();
                                } else {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233165), 0).show();
                                }
                                this.gBr.gBh = null;
                                this.gBr.gBg = null;
                                this.gBr.finish();
                                return 0;
                            }
                        };
                        aVar2 = new com.tencent.mm.v.b.a();
                        a(new OnCancelListener(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.gBr.gBe[this.gBr.gBd].gBz.atv();
                                if (this.gBr.gBl != null && !this.gBr.gBl.czH) {
                                    ak.vy().c(this.gBr.gBl);
                                }
                            }
                        });
                        aVar2.czn = new aks();
                        aVar2.czo = new akt();
                        aVar2.czm = 689;
                        aVar2.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                        com.tencent.mm.v.b Bv2 = aVar2.Bv();
                        com_tencent_mm_protocal_c_aks = (aks) Bv2.czk.czs;
                        com_tencent_mm_protocal_c_aks.of = 1;
                        are com_tencent_mm_protocal_c_are2 = new are();
                        d.ath();
                        com_tencent_mm_protocal_c_aks.mLG = com_tencent_mm_protocal_c_are2.ba(d.aA(list));
                        are com_tencent_mm_protocal_c_are3 = new are();
                        d.ath();
                        com_tencent_mm_protocal_c_aks.mLH = com_tencent_mm_protocal_c_are3.ba(d.aA(list2));
                        u.a(Bv2, new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                v.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                this.gBr.atr();
                                if (i == 0 && i2 == 0) {
                                    b.a(((akt) bVar.czl.czs).mLI);
                                    GestureGuardLogicUI.ats();
                                }
                                d.ath().atm();
                                if (anonymousClass22 != null) {
                                    return anonymousClass22.a(i, i2, str, bVar, kVar);
                                }
                                return 0;
                            }
                        }, false);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        a(this.cKN, this.gBg, new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                if (i2 == 0) {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233182), 0).show();
                                } else {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233165), 0).show();
                                }
                                this.gBr.cKN = null;
                                this.gBr.gBg = null;
                                this.gBr.finish();
                                return 0;
                            }
                        });
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        a(this.cKN, this.gBg, new com.tencent.mm.v.u.a(this) {
                            final /* synthetic */ GestureGuardLogicUI gBr;

                            {
                                this.gBr = r1;
                            }

                            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                                if (i2 == 0) {
                                    b.bY(SystemClock.elapsedRealtime());
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233183), 0).show();
                                    this.gBr.atp();
                                } else {
                                    Toast.makeText(this.gBr, this.gBr.getString(2131233165), 0).show();
                                }
                                this.gBr.cKN = null;
                                this.gBr.gBg = null;
                                return 0;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                case 19:
                    aVar.gBz.gBP = false;
                    aVar.gBz.a(PatternLockView.b.Wrong);
                    a(getResources().getString(2131233174), new a(this) {
                        final /* synthetic */ GestureGuardLogicUI gBr;

                        public final void onDone() {
                            this.gBr.mHandler.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass25 gBw;

                                {
                                    this.gBw = r1;
                                }

                                public final void run() {
                                    this.gBw.gBr.mHandler.removeCallbacks(this);
                                    aVar.gBz.atv();
                                    this.gBw.gBr.mStatus = 16;
                                    this.gBw.gBr.C(1, true);
                                    this.gBw.gBr.ato();
                                }
                            }, 500);
                        }
                    });
                    return;
                case 20:
                    Fd(getString(2131233178));
                    this.gBi = true;
                    aVar.gBz.gBP = false;
                    aVar.gBz.gCb = null;
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (b.asX().gBa / 1000))) / 60.0d);
                    aVar.gBx.setText(String.format(getString(2131233171), new Object[]{Long.valueOf(elapsedRealtime)}));
                    aVar.gBx.setTextColor(getResources().getColor(2131689765));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(final PatternLockView patternLockView, final List<c> list) {
        boolean z = true;
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.gBP = false;
                patternLockView.a(PatternLockView.b.Wrong);
                a(String.format(getString(2131233169), new Object[]{Integer.valueOf(4)}), new a(this) {
                    final /* synthetic */ GestureGuardLogicUI gBr;

                    public final void onDone() {
                        patternLockView.atv();
                        patternLockView.gBP = true;
                    }
                });
                return;
            }
            this.gBg = list;
            patternLockView.atv();
            this.mStatus = 17;
            C(2, true);
        } else if (this.mStatus == 0) {
            final AnonymousClass3 anonymousClass3 = new com.tencent.mm.v.u.a(this) {
                final /* synthetic */ GestureGuardLogicUI gBr;

                public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                    if (i2 == 0) {
                        this.gBr.gBi = false;
                        this.gBr.gBj = 0;
                        b.atg();
                        b.asY();
                        b.atc();
                        this.gBr.gBh = list;
                        this.gBr.mStatus = 1;
                        this.gBr.ato();
                    } else if (i2 == -3) {
                        GestureGuardLogicUI.k(this.gBr);
                        this.gBr.mStatus = 2;
                        this.gBr.ato();
                    } else {
                        Toast.makeText(this.gBr, this.gBr.getString(2131233166), 0).show();
                    }
                    return 0;
                }
            };
            alk ate = b.ate();
            alj atd = b.atd();
            g.iuh.h(11453, new Object[0]);
            a(new OnCancelListener(this) {
                final /* synthetic */ GestureGuardLogicUI gBr;

                {
                    this.gBr = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.gBr.gBe[this.gBr.gBd].gBz.atv();
                    if (this.gBr.gBl != null && !this.gBr.gBl.czH) {
                        ak.vy().c(this.gBr.gBl);
                    }
                }
            });
            d.ath();
            boolean b = d.b(ate);
            d.ath();
            boolean z2 = d.b(atd) ? b ? atd.version < ate.mMl : false : true;
            v.i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(b), Boolean.valueOf(d.b(atd)), Boolean.valueOf(z2)}));
            if (z2) {
                com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                aVar.czn = new aks();
                aVar.czo = new akt();
                aVar.czm = 689;
                aVar.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                com.tencent.mm.v.b Bv = aVar.Bv();
                aks com_tencent_mm_protocal_c_aks = (aks) Bv.czk.czs;
                com_tencent_mm_protocal_c_aks.of = 2;
                are com_tencent_mm_protocal_c_are = new are();
                d.ath();
                com_tencent_mm_protocal_c_aks.mLG = com_tencent_mm_protocal_c_are.ba(d.aA(list));
                u.a(Bv, new com.tencent.mm.v.u.a(this) {
                    final /* synthetic */ GestureGuardLogicUI gBr;

                    public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                        v.i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                        this.gBr.atr();
                        if (i == 0 && i2 == 0) {
                            b.a(((akt) bVar.czl.czs).mLI);
                        }
                        if (anonymousClass3 != null) {
                            return anonymousClass3.a(i, i2, str, bVar, kVar);
                        }
                        return 0;
                    }
                }, false);
                return;
            }
            atr();
            d.ath();
            alj atd2 = b.atd();
            if (atd2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                stringBuilder.append(new o(com.tencent.mm.model.c.ww()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(d.aA(list)));
                z = new String(atd2.mMi.mQw.lVU).equals(com.tencent.mm.a.g.m(stringBuilder.toString().getBytes()));
            }
            if (z) {
                anonymousClass3.a(3, 0, null, null, null);
                return;
            } else {
                anonymousClass3.a(3, -3, null, null, null);
                return;
            }
        } else if (this.mStatus != 17) {
            return;
        } else {
            if (this.gBg.equals(list)) {
                patternLockView.atv();
                this.gBi = false;
                this.gBj = 0;
                b.atg();
                b.asY();
                b.atc();
                b.ata();
                this.mStatus = 18;
            } else {
                this.mStatus = 19;
            }
        }
        ato();
    }

    private void a(String str, List<c> list, final com.tencent.mm.v.u.a aVar) {
        a(new OnCancelListener(this) {
            final /* synthetic */ GestureGuardLogicUI gBr;

            {
                this.gBr = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.gBr.gBe[this.gBr.gBd].gBz.atv();
                if (this.gBr.gBk != null && !this.gBr.gBk.czH) {
                    ak.vy().c(this.gBr.gBk);
                }
            }
        });
        if (str == null) {
            atr();
            aVar.a(3, -6, getString(2131233167), null, null);
            return;
        }
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new aqc();
        aVar2.czo = new aqd();
        aVar2.czm = 688;
        aVar2.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        com.tencent.mm.v.b Bv = aVar2.Bv();
        aqc com_tencent_mm_protocal_c_aqc = (aqc) Bv.czk.czs;
        com_tencent_mm_protocal_c_aqc.mPw = new are().ba(str.getBytes());
        are com_tencent_mm_protocal_c_are = new are();
        d.ath();
        com_tencent_mm_protocal_c_aqc.mPx = com_tencent_mm_protocal_c_are.ba(d.aA(list));
        u.a(Bv, new com.tencent.mm.v.u.a(this) {
            final /* synthetic */ GestureGuardLogicUI gBr;

            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                v.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                this.gBr.atr();
                if (i == 0 && i2 == 0) {
                    b.a(((aqd) bVar.czl.czs).mLI);
                    GestureGuardLogicUI.ats();
                }
                d.ath().atm();
                if (aVar != null) {
                    return aVar.a(i, i2, str, bVar, kVar);
                }
                return 0;
            }
        }, false);
    }

    private void atp() {
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            d.ath().dr(true);
            d.ath().ds(true);
            intent.addFlags(131072);
            startActivity(intent);
        } else {
            v.i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
    }

    private void atq() {
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            Iterator it = d.ath().gAS.iterator();
            while (it.hasNext()) {
                Activity activity = (Activity) ((WeakReference) it.next()).get();
                if (!(activity == null || activity.isFinishing())) {
                    activity.finish();
                }
                it.remove();
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.gBe[this.gBd];
        if (motionEvent.getAction() != 2 && motionEvent.getAction() != 7) {
            return super.dispatchTouchEvent(motionEvent);
        }
        motionEvent.offsetLocation((float) (-aVar.gBy.getLeft()), (float) ((-aVar.gBy.getTop()) - getWindow().findViewById(16908290).getTop()));
        return aVar.gBy.dispatchTouchEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        a aVar = this.gBe[this.gBd];
        if (aVar.gBz != null) {
            PatternLockView patternLockView = aVar.gBz;
            boolean z2 = z && !this.gBi;
            patternLockView.gBP = z2;
        }
    }

    public final void a(PatternLockView patternLockView) {
        patternLockView.a(PatternLockView.b.Correct);
    }

    private void C(int i, boolean z) {
        int i2 = i - this.gBd;
        if (i2 != 0) {
            this.gBd = i;
            if (!z) {
                this.gBn.setInAnimation(null);
                this.gBn.setOutAnimation(null);
            } else if (i2 > 0) {
                this.gBn.setInAnimation(this, 2130968680);
                this.gBn.setOutAnimation(this, 2130968677);
            } else {
                this.gBn.setInAnimation(this, 2130968676);
                this.gBn.setOutAnimation(this, 2130968681);
            }
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    this.gBn.showNext();
                }
                return;
            }
            while (i2 < 0) {
                this.gBn.showPrevious();
                i2++;
            }
        }
    }

    private void a(String str, final a aVar) {
        TextView textView = this.gBe[this.gBd].gBx;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.gBc);
        textView.startAnimation(this.gBf);
        this.gBf.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ GestureGuardLogicUI gBr;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.gBr.gBf.setAnimationListener(null);
                if (aVar != null) {
                    aVar.onDone();
                }
            }
        });
    }

    private void a(OnCancelListener onCancelListener) {
        if (this.gBo == null) {
            this.gBo = com.tencent.mm.ui.base.g.a(this, getString(2131233170), false, onCancelListener);
        } else {
            this.gBo.show();
        }
    }

    private void atr() {
        if (this.gBo != null && this.gBo.isShowing()) {
            this.gBo.dismiss();
        }
    }

    protected final int NO() {
        return 1;
    }
}
