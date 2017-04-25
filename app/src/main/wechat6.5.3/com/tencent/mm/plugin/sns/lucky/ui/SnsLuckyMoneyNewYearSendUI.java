package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.nu;
import com.tencent.mm.e.a.qm;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.lucky.a.a.d;
import com.tencent.mm.plugin.sns.lucky.b.i;
import com.tencent.mm.plugin.sns.lucky.b.w;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.lucky.view.SnsLuckyMoneyAutoScrollItem;
import com.tencent.mm.plugin.sns.lucky.view.SnsLuckyMoneyScrollNumView;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(3)
public class SnsLuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private String bap;
    private Dialog dxy = null;
    private String fTG = "";
    private int hcP;
    private String hcT;
    private int hcU;
    private String hgv;
    private SnsLuckyMoneyScrollNumView jgA;
    private View jgB;
    private TextView jgC;
    private long jgD;
    boolean jgE;
    private w jgF = new w();
    private c jgG = new c<nu>(this) {
        final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

        {
            this.jgJ = r2;
            this.nhz = nu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nu nuVar = (nu) bVar;
            if (nuVar instanceof nu) {
                com.tencent.mm.plugin.sns.lucky.c.a.a(nuVar.boP.opType, ad.aSE().Bq(this.jgJ.bap));
            }
            return false;
        }
    };
    private e.a jgH = new e.a(this) {
        final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

        {
            this.jgJ = r1;
        }

        public final void b(String str, boolean z, String str2) {
            if (z) {
                if (this.jgJ.dxy != null && this.jgJ.dxy.isShowing()) {
                    this.jgJ.dxy.hide();
                }
                this.jgJ.wd(str2);
                if (com.tencent.mm.plugin.sns.lucky.a.a.b.TYPE.equals(str) || d.TYPE.equals(str)) {
                    this.jgJ.finish();
                }
            } else if (!com.tencent.mm.plugin.sns.lucky.a.a.b.TYPE.equals(str) && d.TYPE.equals(str)) {
                if (this.jgJ.dxy != null && this.jgJ.dxy.isShowing()) {
                    this.jgJ.dxy.hide();
                }
                if (z) {
                    v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "onStoreChange() NetSceneSnsPrepareLuckyMoneyNewYear failed!");
                    return;
                }
                v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "onStoreChange() NetSceneSnsPrepareLuckyMoneyNewYear success!");
                i iVar = this.jgJ.jgF.jfA;
                if (iVar != null) {
                    this.jgJ.hcT = iVar.hcj;
                    PayInfo payInfo = new PayInfo();
                    payInfo.fTG = iVar.hci;
                    this.jgJ.fTG = iVar.hci;
                    payInfo.bkq = 39;
                    payInfo.bkh = this.jgJ.hcU;
                    SnsLuckyMoneyNewYearSendUI snsLuckyMoneyNewYearSendUI = this.jgJ;
                    v.i("MicroMsg.WalletManager", "startPayFromSns()");
                    j.i iVar2 = j.a.lxZ;
                    if (iVar2 != null && iVar2.axV() && iVar2.axW()) {
                        v.i("MicroMsg.WalletManager", "startPayFromSns() dopay");
                        iVar2.a(payInfo);
                        return;
                    }
                    v.e("MicroMsg.WalletManager", "startPayFromSns() mgr is nulll or not white user or not open sns pay!");
                    com.tencent.mm.pluginsdk.wallet.e.a(snsLuckyMoneyNewYearSendUI, payInfo, 1);
                }
            }
        }
    };
    private c jgI = new c<qm>(this) {
        final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

        {
            this.jgJ = r2;
            this.nhz = qm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qm qmVar = (qm) bVar;
            v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "deal with lucky sns pay event WalletLuckySnsPayEvent");
            if (!(qmVar instanceof qm)) {
                return false;
            }
            int i = qmVar.brZ.errCode;
            int i2 = qmVar.brZ.errType;
            String str = qmVar.brZ.biS;
            int i3 = qmVar.brZ.bsa;
            v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "mLuckySnsPayListener errCode:" + i + " errType:" + i2 + " errMsg:" + str + " isLaunchPwdDialog:" + i3);
            if (i2 == 0 && i == 0) {
                v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "mLuckySnsPayListener callback do pay success!");
                k Bq = ad.aSE().Bq(this.jgJ.bap);
                if (Bq != null) {
                    String str2 = Bq.aUp().gID;
                    x.j(Bq);
                    System.currentTimeMillis();
                }
                g.bf(this.jgJ, this.jgJ.getString(2131233278));
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(125);
                this.jgJ.setResult(-1);
                this.jgJ.finish();
            } else if (i3 == 1) {
                v.e("MicroMsg.SnsLuckyMoneyNewYearSendUI", "mLuckySnsPayListener callback do pay failed!, launch pwd dialog to pay!");
                PayInfo payInfo = new PayInfo();
                payInfo.fTG = this.jgJ.fTG;
                payInfo.bkq = 39;
                payInfo.bkh = this.jgJ.hcU;
                com.tencent.mm.pluginsdk.wallet.e.a(this.jgJ, payInfo, 1);
            } else {
                v.e("MicroMsg.SnsLuckyMoneyNewYearSendUI", "mLuckySnsPayListener callback do pay failed! show error!");
                if (TextUtils.isEmpty(str)) {
                    str = this.jgJ.getString(2131236492);
                }
                g.a(this.jgJ, str, "", new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 jgK;

                    {
                        this.jgK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.jgK.jgJ.finish();
                    }
                });
            }
            return true;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgv = getIntent().getStringExtra("key_username");
        this.hcP = getIntent().getIntExtra("key_way", 0);
        this.hcU = getIntent().getIntExtra("pay_channel", -1);
        this.bap = getIntent().getStringExtra("key_feedid");
        this.jgD = getIntent().getLongExtra("key_lucky_money_value", 0);
        if (be.kS(this.hgv)) {
            v.w("MicroMsg.SnsLuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        NI();
        this.jgF.x(this);
        e eVar = e.had;
        e.a aVar = this.jgH;
        if (!eVar.eAR.contains(aVar)) {
            eVar.eAR.add(aVar);
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.jgI);
        com.tencent.mm.plugin.sns.lucky.b.v.aRm();
        if (this.dxy != null) {
            this.dxy.show();
        }
        SnsLuckyMoneyScrollNumView snsLuckyMoneyScrollNumView = this.jgA;
        String m = com.tencent.mm.wallet_core.ui.e.m(((double) this.jgD) / 100.0d);
        if (m != null) {
            snsLuckyMoneyScrollNumView.jix.removeAllViews();
            for (int i = 0; i < m.length(); i++) {
                View inflate;
                char charAt = m.charAt(i);
                if (charAt == '.') {
                    inflate = snsLuckyMoneyScrollNumView.dY.inflate(2130904468, snsLuckyMoneyScrollNumView.jix, false);
                } else {
                    snsLuckyMoneyScrollNumView.jiB.add(String.valueOf(charAt));
                    int i2 = be.getInt(String.valueOf(charAt), 0);
                    View inflate2 = snsLuckyMoneyScrollNumView.dY.inflate(2130904467, snsLuckyMoneyScrollNumView.jix, false);
                    SnsLuckyMoneyAutoScrollItem snsLuckyMoneyAutoScrollItem = (SnsLuckyMoneyAutoScrollItem) inflate2.findViewById(2131757661);
                    snsLuckyMoneyAutoScrollItem.hdu = i2;
                    snsLuckyMoneyAutoScrollItem.jit = snsLuckyMoneyScrollNumView;
                    snsLuckyMoneyScrollNumView.jiy.add(snsLuckyMoneyAutoScrollItem);
                    ImageView imageView = (ImageView) inflate2.findViewById(2131757755);
                    imageView.setImageResource(((Integer) SnsLuckyMoneyAutoScrollItem.hdy.get(i2)).intValue());
                    snsLuckyMoneyScrollNumView.jiz.add(imageView);
                    inflate = inflate2;
                }
                snsLuckyMoneyScrollNumView.jix.addView(inflate);
            }
        }
        SnsLuckyMoneyScrollNumView snsLuckyMoneyScrollNumView2 = this.jgA;
        snsLuckyMoneyScrollNumView2.jiA = new SnsLuckyMoneyScrollNumView.a(this) {
            final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

            {
                this.jgJ = r1;
            }

            public final void aye() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass4 jgL;

                    {
                        this.jgL = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                    }
                });
            }
        };
        com.tencent.mm.sdk.platformtools.ad.o(new Runnable(snsLuckyMoneyScrollNumView2) {
            final /* synthetic */ SnsLuckyMoneyScrollNumView jiC;

            {
                this.jiC = r1;
            }

            public final void run() {
                for (SnsLuckyMoneyAutoScrollItem snsLuckyMoneyAutoScrollItem : this.jiC.jiy) {
                    if (snsLuckyMoneyAutoScrollItem.hdv != null) {
                        snsLuckyMoneyAutoScrollItem.hdv.cancel();
                    }
                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(snsLuckyMoneyAutoScrollItem) {
                        final /* synthetic */ SnsLuckyMoneyAutoScrollItem jiu;

                        {
                            this.jiu = r1;
                        }

                        public final void run() {
                            this.jiu.hdv = new CountDownTimer(this) {
                                final /* synthetic */ AnonymousClass1 jiv;

                                {
                                    this.jiv = r5;
                                }

                                public final void onTick(long j) {
                                    this.jiv.jiu.smoothScrollToPosition(SnsLuckyMoneyAutoScrollItem.a(this.jiv.jiu));
                                }

                                public final void onFinish() {
                                    if (this.jiv.jiu.jit != null) {
                                        this.jiv.jiu.jit.ayd();
                                    }
                                }
                            }.start();
                        }
                    });
                }
            }
        });
        oa(0);
        this.jgB.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

            {
                this.jgJ = r1;
            }

            public final void onClick(View view) {
                String xF = com.tencent.mm.model.k.xF();
                k Bq = ad.aSE().Bq(this.jgJ.bap);
                com.tencent.mm.plugin.sns.lucky.c.a.a(6, Bq);
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(40);
                String cE = com.tencent.mm.plugin.sns.data.i.cE(Bq.field_snsId);
                long f = this.jgJ.jgD;
                long f2 = this.jgJ.jgD;
                String wa = n.wa(xF);
                xF = n.eq(xF);
                String g = this.jgJ.hgv;
                com.tencent.mm.plugin.luckymoney.b.b bVar = new com.tencent.mm.plugin.luckymoney.b.b(d.TYPE);
                Bundle bundle = new Bundle();
                bundle.putString("nickName", xF);
                bundle.putString("userName", g);
                bundle.putString("wishing", "");
                bundle.putString("headImg", wa);
                bundle.putString("feedId", cE);
                bundle.putInt("total_num", 1);
                bundle.putLong("total_amount", f);
                bundle.putLong("per_value", f2);
                bVar.s(bundle);
                com.tencent.mm.plugin.luckymoney.b.c cVar = com.tencent.mm.plugin.luckymoney.b.c.gZZ;
                com.tencent.mm.plugin.luckymoney.b.c.b(bVar);
                if (this.jgJ.dxy != null) {
                    this.jgJ.dxy.show();
                } else {
                    this.jgJ.dxy = com.tencent.mm.wallet_core.ui.g.a(this.jgJ.nDR.nEl, true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass5 jgM;

                        {
                            this.jgM = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.jgM.jgJ.dxy != null && this.jgM.jgJ.dxy.isShowing()) {
                                this.jgM.jgJ.dxy.hide();
                            }
                            if (this.jgM.jgJ.nDR.dtW.getVisibility() == 8 || this.jgM.jgJ.nDR.dtW.getVisibility() == 4) {
                                v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                                this.jgM.jgJ.finish();
                            }
                            this.jgM.jgJ.hdT.axF();
                        }
                    });
                }
            }
        });
        j.i iVar = j.a.lxZ;
        if (iVar == null || !iVar.axU()) {
            this.jgE = false;
        } else {
            this.jgE = iVar.axW();
        }
        aRA();
        com.tencent.mm.sdk.c.a.nhr.e(this.jgG);
    }

    private void aRA() {
        j.i iVar = j.a.lxZ;
        if (iVar == null || !iVar.axU()) {
            v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "updateFreePayBtn() not show free pwd setting");
            this.jgC.setVisibility(8);
            return;
        }
        v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "updateFreePayBtn() show free pwd setting");
        this.jgC.setVisibility(0);
        if (iVar.axW()) {
            this.jgC.setText(2131233612);
        } else {
            this.jgC.setText(2131233613);
        }
        this.jgC.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

            {
                this.jgJ = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.sns.lucky.c.a.a(22, ad.aSE().Bq(this.jgJ.bap));
                com.tencent.mm.ay.c.b(this.jgJ, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", new Intent());
            }
        });
    }

    protected void onResume() {
        j.i iVar = j.a.lxZ;
        if (iVar != null && iVar.axU()) {
            if (this.jgE && !iVar.axW()) {
                com.tencent.mm.plugin.sns.lucky.c.a.a(26, ad.aSE().Bq(this.bap));
            } else if (!this.jgE && iVar.axW()) {
                com.tencent.mm.plugin.sns.lucky.c.a.a(25, ad.aSE().Bq(this.bap));
            }
            this.jgE = iVar.axW();
        }
        aRA();
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = e.had;
        eVar.eAR.remove(this.jgH);
        com.tencent.mm.sdk.c.a.nhr.f(this.jgI);
        this.jgF.axD();
        if (this.dxy != null && this.dxy.isShowing()) {
            this.dxy.dismiss();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.jgG);
    }

    protected final void NI() {
        getWindow().setFlags(1024, 1024);
        oa(8);
        this.jgA = (SnsLuckyMoneyScrollNumView) findViewById(2131757883);
        this.jgB = findViewById(2131759396);
        this.jgC = (TextView) findViewById(2131759394);
        ((ImageView) findViewById(2131757874)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

            {
                this.jgJ = r1;
            }

            public final void onClick(View view) {
                this.jgJ.finish();
            }
        });
        this.nDR.dtW.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyNewYearSendUI jgJ;

            {
                this.jgJ = r1;
            }

            public final void onClick(View view) {
                this.jgJ.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904464;
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "onActivityResult sns pay success!!");
                    k Bq = ad.aSE().Bq(this.bap);
                    com.tencent.mm.plugin.sns.lucky.c.a.a(7, Bq);
                    com.tencent.mm.plugin.sns.lucky.b.b.kZ(41);
                    g.bf(this, getString(2131233278));
                    setResult(-1);
                    com.tencent.mm.plugin.sns.lucky.b.b.kZ(126);
                    j.i iVar = j.a.lxZ;
                    if (iVar == null || !iVar.axT()) {
                        v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "onActivityResult finish!");
                        finish();
                        return;
                    }
                    v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "onActivityResult show the sns pay guide dialog!");
                    findViewById(2131759393).setVisibility(8);
                    iVar.ah(this, this.fTG);
                    com.tencent.mm.plugin.sns.lucky.c.a.a(21, Bq);
                    return;
                }
                v.i("MicroMsg.SnsLuckyMoneyNewYearSendUI", "onActivityResult sns pay failed!!");
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(42);
                setResult(i2);
                finish();
                return;
            default:
                return;
        }
    }
}
