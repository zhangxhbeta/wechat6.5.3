package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.ay.c;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.luckymoney.c.af;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.luckymoney.c.o;
import com.tencent.mm.plugin.luckymoney.c.r;
import com.tencent.mm.plugin.luckymoney.c.s;
import com.tencent.mm.plugin.luckymoney.c.t;
import com.tencent.mm.plugin.luckymoney.c.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(3)
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private p dwg = null;
    private ImageView hdW;
    private TextView heA;
    private Button heB;
    private ImageView heC;
    private View heD;
    private View heE;
    private ImageView heF;
    private TextView heG;
    private View heH;
    private TextView heI;
    private Button heJ;
    private TextView heK;
    private CheckBox heL;
    private int heM;
    private String heN = null;
    private int heO = 0;
    private t heP;
    private RealnameGuideHelper heQ;
    private TextView hea;
    private String hei = null;
    private String hek = null;
    private int hem = 0;
    private TextView hey;
    private TextView hez;

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        luckyMoneyBusiReceiveUI.b(new s(luckyMoneyBusiReceiveUI.heP.haB, luckyMoneyBusiReceiveUI.heP.cCj, luckyMoneyBusiReceiveUI.heP.hbJ, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        n.a(luckyMoneyBusiReceiveUI.heB);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hek = getIntent().getStringExtra("key_native_url");
        this.heM = getIntent().getIntExtra("key_way", 5);
        this.hem = getIntent().getIntExtra("key_static_from_scene", 0);
        v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + be.ma(this.hek) + ", mWay=" + this.heM);
        init();
        g.iuh.h(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        NI();
        gQ(BuildConfig.VERSION_CODE);
    }

    private void init() {
        this.dwg = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131233521), true, new OnCancelListener(this) {
            final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

            {
                this.heR = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.heR.dwg != null && this.heR.dwg.isShowing()) {
                    this.heR.dwg.dismiss();
                }
                this.heR.hdT.axF();
                if (this.heR.nDR.dtW.getVisibility() == 8 || this.heR.nDR.dtW.getVisibility() == 4) {
                    v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                    this.heR.finish();
                }
            }
        });
        if (this.heM == 3) {
            b(new r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
        } else if (this.heM == 4) {
            b(new r(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.hei = Uri.parse(be.ma(this.hek)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (be.kS(this.hei)) {
                finish();
                v.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
                return;
            }
            b(new t(this.hei, this.hek, this.heM, getIntent().getStringExtra("packageExt")), false);
        }
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                return;
            }
            v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            setResult(-1);
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        gR(BuildConfig.VERSION_CODE);
    }

    protected final void NI() {
        this.heE = findViewById(2131757791);
        this.hdW = (ImageView) findViewById(2131757794);
        this.hey = (TextView) findViewById(2131757795);
        this.heA = (TextView) findViewById(2131757803);
        this.hez = (TextView) findViewById(2131757796);
        this.heB = (Button) findViewById(2131757804);
        this.heC = (ImageView) findViewById(2131757808);
        this.heD = findViewById(2131757800);
        this.hea = (TextView) findViewById(2131757801);
        this.heF = (ImageView) findViewById(2131757793);
        this.heG = (TextView) findViewById(2131757807);
        this.heH = findViewById(2131757797);
        this.heI = (TextView) findViewById(2131757798);
        this.heJ = (Button) findViewById(2131757805);
        this.heK = (TextView) findViewById(2131757802);
        this.heL = (CheckBox) findViewById(2131757806);
        this.heC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

            {
                this.heR = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (this.heR.heQ == null || !this.heR.heQ.a(this.heR, bundle, null, true)) {
                    this.heR.finish();
                } else {
                    this.heR.heQ = null;
                }
            }
        });
        oa(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof t) {
            if (i != 0 || i2 != 0) {
                return false;
            }
            this.heP = (t) kVar;
            this.hei = this.heP.haB;
            this.heO = this.heP.hau;
            g.iuh.h(13050, new Object[]{Integer.valueOf(this.hem), Integer.valueOf(1), this.heP.hbF});
            if (this.heP.haN == 2) {
                b(new u(this.hei, this.hek, "v1.0"), false);
            } else {
                if (this.dwg != null && this.dwg.isShowing()) {
                    this.dwg.hide();
                }
                n.a(this.hdW, this.heP.hbK, true);
                n.a(this.nDR.nEl, this.hey, this.heP.hbz);
                n.e(this.heF, this.heP.haU);
                if (this.heP.haN == 1 || this.heP.hav == 4 || this.heP.hav == 5 || this.heP.hav == 1) {
                    g.iuh.h(11701, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                    this.hez.setVisibility(4);
                    this.heA.setText(this.heP.haw);
                    this.heB.setVisibility(8);
                    if (this.heO == 1) {
                        this.heG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                            {
                                this.heR = r1;
                            }

                            public final void onClick(View view) {
                                g.iuh.h(11701, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                                Intent intent = new Intent();
                                intent.setClass(this.heR.nDR.nEl, LuckyMoneyBusiDetailUI.class);
                                intent.putExtra("key_native_url", this.heR.hek);
                                intent.putExtra("key_sendid", this.heR.heP.haB);
                                intent.putExtra("key_static_from_scene", this.heR.hem);
                                this.heR.startActivity(intent);
                                this.heR.finish();
                            }
                        });
                        this.heG.setVisibility(0);
                    } else {
                        this.heG.setVisibility(8);
                    }
                } else {
                    if (!be.kS(this.heP.hbF)) {
                        this.heN = this.heP.hbF;
                        if (this.heP.hbG == 1) {
                            this.heL.setVisibility(8);
                        } else {
                            v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.heP.hbF);
                            if (this.heP.hbD == 1) {
                                this.heL.setChecked(true);
                            } else {
                                this.heL.setChecked(false);
                            }
                            this.heL.setText(this.heP.hbE);
                        }
                    }
                    this.heB.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                        {
                            this.heR = r1;
                        }

                        public final void onClick(View view) {
                            g.iuh.h(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                            if (this.heR.heL.isChecked()) {
                                g.iuh.h(13050, new Object[]{Integer.valueOf(this.heR.hem), Integer.valueOf(2), this.heR.heP.hbF});
                            } else {
                                g.iuh.h(13050, new Object[]{Integer.valueOf(this.heR.hem), Integer.valueOf(2), ""});
                            }
                            if ("0".equals(this.heR.heP.hbN)) {
                                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this.heR, this.heR.hdT, this.heR.heP.hbO, this.heR.heP.hbP, this.heR.heP.hbQ, this.heR.heP.hbR, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                                    final /* synthetic */ AnonymousClass4 heS;

                                    {
                                        this.heS = r1;
                                    }

                                    public final boolean a(int i, int i2, String str, boolean z) {
                                        v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                                        if (i == 0 || z) {
                                            LuckyMoneyBusiReceiveUI.i(this.heS.heR);
                                        }
                                        return true;
                                    }
                                }, false, 1005);
                            } else {
                                LuckyMoneyBusiReceiveUI.i(this.heR);
                            }
                        }
                    });
                    if (be.kS(this.heP.haw)) {
                        this.hez.setVisibility(8);
                    } else {
                        this.hez.setText(this.heP.haw);
                    }
                    if (be.kS(this.heP.hbL)) {
                        this.heA.setVisibility(8);
                    } else {
                        this.heA.setText(this.heP.hbL);
                    }
                }
                n.a(this.heE, null);
                this.nDR.dtW.setVisibility(0);
            }
            return true;
        } else if (kVar instanceof s) {
            n.c(this.heB);
            if (i == 0 && i2 == 0) {
                final s sVar = (s) kVar;
                if (sVar.haN != 2) {
                    this.hez.setVisibility(4);
                    this.heA.setText(sVar.haw);
                    this.heB.setVisibility(8);
                    if (this.heO == 1) {
                        this.heG.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                intent.setClass(this.heR.nDR.nEl, LuckyMoneyBusiDetailUI.class);
                                if (sVar.hbI != null) {
                                    intent.putExtra("key_realname_guide_helper", sVar.hbI);
                                }
                                intent.putExtra("key_native_url", this.heR.hek);
                                intent.putExtra("key_sendid", sVar.haB);
                                intent.putExtra("key_static_from_scene", this.heR.hem);
                                this.heR.startActivity(intent);
                                this.heR.finish();
                            }
                        });
                        this.heG.setVisibility(0);
                    } else {
                        this.heG.setVisibility(8);
                    }
                } else if (sVar.haG <= 1 || !(sVar.haP == null || sVar.haP.cdf == 1)) {
                    v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    r2 = new Intent();
                    r2.putExtra("key_sendid", sVar.haB);
                    r2.putExtra("key_static_from_scene", this.hem);
                    if (sVar.hbI != null) {
                        r2.putExtra("key_realname_guide_helper", sVar.hbI);
                    }
                    try {
                        r2.putExtra("key_detail_info", sVar.hbH.toByteArray());
                        r2.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        v.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (j.sU().getInt("PlayCoinSound", 0) > 0) {
                        r2.putExtra("play_sound", true);
                    }
                    c.b(this.nDR.nEl, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", r2);
                    finish();
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(2131757792);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            findViewById.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.hea.setText(e.m(((double) sVar.bst) / 100.0d));
                    this.hey.setText(sVar.hbz);
                    this.hez.setVisibility(8);
                    this.heA.setVisibility(8);
                    this.heD.setVisibility(0);
                    this.heB.setVisibility(8);
                    if (be.kS(sVar.hbC)) {
                        string = getString(2131233664);
                    } else {
                        string = sVar.hbC;
                    }
                    this.heJ.setText(string);
                    this.heK.setVisibility(0);
                    g.iuh.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + sVar.haG);
                    if (sVar.haG > 1 || (sVar.haP != null && sVar.haP.cdf == 1)) {
                        v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.heQ = sVar.hbI;
                        this.heJ.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                            public final void onClick(View view) {
                                CharSequence string;
                                this.heR.heE.setVisibility(4);
                                this.heR.heK.setVisibility(8);
                                this.heR.heD.setVisibility(8);
                                if (sVar.haP == null || be.kS(sVar.haP.haf)) {
                                    string = this.heR.getString(2131233665);
                                } else {
                                    string = sVar.haP.haf;
                                }
                                this.heR.heJ.setText(string);
                                this.heR.heI.setText(sVar.hbA);
                                this.heR.heH.setVisibility(0);
                                this.heR.heJ.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass7 heV;

                                    {
                                        this.heV = r1;
                                    }

                                    public final void onClick(View view) {
                                        g.iuh.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                                        n.c(this.heV.heR, 1);
                                    }
                                });
                                n.a(this.heR.heE, new AnimationListener(this) {
                                    final /* synthetic */ AnonymousClass7 heV;

                                    {
                                        this.heV = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                        this.heV.heR.heE.setVisibility(0);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                    }
                                });
                            }
                        });
                    } else {
                        this.heJ.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                            {
                                this.heR = r1;
                            }

                            public final void onClick(View view) {
                                this.heR.finish();
                            }
                        });
                    }
                    this.heJ.setVisibility(0);
                }
                return true;
            } else if (i2 != 416) {
                return false;
            } else {
                if (this.dwg != null && this.dwg.isShowing()) {
                    this.dwg.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.heB.setBackgroundResource(2130838226);
                return n.a(this, i2, kVar, bundle, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                    {
                        this.heR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new b.a(this) {
                    final /* synthetic */ LuckyMoneyBusiReceiveUI heR;

                    {
                        this.heR = r1;
                    }

                    public final Intent e(int i, Bundle bundle) {
                        v.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
                        return null;
                    }
                }, 1005);
            }
        } else if (kVar instanceof af) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.g.bf(this, getString(2131233278));
                g.iuh.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                finish();
                return true;
            }
            com.tencent.mm.ui.base.g.bf(this, str);
            return true;
        } else if (kVar instanceof r) {
            if (i == 0 && i2 == 0) {
                setResult(-1);
                j(new t(this.hei, this.hek, this.heM, getIntent().getStringExtra("packageExt")));
                return true;
            } else if (this.heM == 4) {
                finish();
                return false;
            } else {
                setResult(0);
                finish();
                return true;
            }
        } else if (kVar instanceof o) {
            return true;
        } else {
            if (!(kVar instanceof u)) {
                return false;
            }
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.hide();
            }
            if (i != 0 || i2 != 0) {
                return false;
            }
            u uVar = (u) kVar;
            r2 = new Intent();
            r2.setClass(this.nDR.nEl, LuckyMoneyBusiDetailUI.class);
            try {
                r2.putExtra("key_detail_info", uVar.hbH.toByteArray());
                r2.putExtra("key_jump_from", 2);
            } catch (IOException e2) {
                v.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
            }
            r2.putExtra("key_native_url", this.hek);
            r2.putExtra("key_sendid", this.hei);
            r2.putExtra("key_static_from_scene", this.hem);
            startActivity(r2);
            finish();
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    g.iuh.h(11701, new Object[]{Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra});
                    if (!be.kS(stringExtra)) {
                        j(new af(stringExtra, this.hei, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return 2130903886;
    }
}
