package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.h.j;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.c.ab;
import com.tencent.mm.plugin.luckymoney.c.ae;
import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.k;
import java.io.IOException;

@a(3)
public class LuckyMoneyReceiveUI extends LuckyMoneyBaseUI {
    private p dwg = null;
    private TextView eWQ;
    private long evC = 0;
    private String gjd;
    private ae hcx;
    private ImageView hdW;
    private TextView hdY;
    private Button heB;
    private ImageView heC;
    private View heE;
    private String hei;
    private String hek;
    private TextView hey;
    private View hhk;
    private ImageView hhl;
    private TextView hhm;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hek = getIntent().getStringExtra("key_native_url");
        v.i("MicroMsg.LuckyMoneyReceiveUI", "nativeUrl= " + be.ma(this.hek));
        NI();
        Uri parse = Uri.parse(be.ma(this.hek));
        try {
            this.hei = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        if (be.kS(this.hei)) {
            finish();
            v.w("MicroMsg.LuckyMoneyReceiveUI", "sendid null & finish");
            return;
        }
        int i = be.getInt(parse.getQueryParameter("channelid"), 1);
        this.gjd = parse.getQueryParameter("sendusername");
        b(new ae(i, this.hei, this.hek, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
        if (this.dwg != null) {
            this.dwg.show();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        this.evC = be.Nh();
    }

    protected void onPause() {
        super.onPause();
        d.d("LuckyMoneyReceiveUI", this.evC, be.Nh());
    }

    protected final void NI() {
        this.heE = findViewById(2131757918);
        this.hdW = (ImageView) findViewById(2131757921);
        this.hey = (TextView) findViewById(2131757922);
        this.eWQ = (TextView) findViewById(2131757923);
        this.hdY = (TextView) findViewById(2131757924);
        this.heB = (Button) findViewById(2131757925);
        this.hhm = (TextView) findViewById(2131757928);
        this.hhk = findViewById(2131757927);
        this.hhl = (ImageView) findViewById(2131757926);
        this.heC = (ImageView) findViewById(2131757929);
        this.heC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyReceiveUI hhn;

            {
                this.hhn = r1;
            }

            public final void onClick(View view) {
                this.hhn.finish();
            }
        });
        this.nDR.dtW.setVisibility(8);
        this.dwg = g.a(this.nDR.nEl, getString(2131233521), true, new OnCancelListener(this) {
            final /* synthetic */ LuckyMoneyReceiveUI hhn;

            {
                this.hhn = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.hhn.dwg != null && this.hhn.dwg.isShowing()) {
                    this.hhn.dwg.dismiss();
                }
                this.hhn.hdT.axF();
                if (this.hhn.nDR.dtW.getVisibility() == 8 || this.hhn.nDR.dtW.getVisibility() == 4) {
                    v.i("MicroMsg.LuckyMoneyReceiveUI", "user cancel & finish");
                    this.hhn.finish();
                }
            }
        });
        if (this.heB != null) {
            String d = u.d(aa.getContext().getSharedPreferences(aa.bti(), 0));
            if (d == null || d.length() <= 0 || !(d.equals("zh_CN") || d.equals("zh_TW") || d.equals("zh_HK"))) {
                this.heB.setBackgroundResource(2130838584);
                this.heB.setText(2131233642);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903900;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        LayoutParams layoutParams;
        if (!(kVar instanceof ae)) {
            Intent intent;
            if (kVar instanceof ab) {
                n.c(this.heB);
                if (i == 0 && i2 == 0) {
                    final ab abVar = (ab) kVar;
                    e eVar = abVar.hbH;
                    if (eVar.haN == 2) {
                        intent = new Intent();
                        intent.setClass(this.nDR.nEl, LuckyMoneyDetailUI.class);
                        try {
                            intent.putExtra("key_detail_info", abVar.hbH.toByteArray());
                            intent.putExtra("key_jump_from", 2);
                        } catch (IOException e) {
                            v.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                        }
                        intent.putExtra("key_native_url", abVar.cCj);
                        intent.putExtra("key_sendid", abVar.haB);
                        if (j.sU().getInt("PlayCoinSound", 0) > 0) {
                            intent.putExtra("play_sound", true);
                        }
                        if (abVar.hbI != null) {
                            intent.putExtra("key_realname_guide_helper", abVar.hbI);
                        }
                        startActivity(intent);
                        finish();
                        return true;
                    }
                    this.heB.setBackgroundResource(2130838577);
                    this.heB.setText(2131233639);
                    this.heB.setOnClickListener(null);
                    this.heB.setVisibility(8);
                    if (be.kS(eVar.haX)) {
                        this.eWQ.setVisibility(8);
                    } else {
                        this.eWQ.setText(eVar.haX);
                        this.eWQ.setVisibility(0);
                    }
                    this.hdY.setText(eVar.haw);
                    layoutParams = (LayoutParams) this.hhk.getLayoutParams();
                    layoutParams.bottomMargin = b.a(this.nDR.nEl, 30.0f);
                    this.hhk.setLayoutParams(layoutParams);
                    if (com.tencent.mm.model.k.xF().equals(this.gjd) || eVar.hau == 1) {
                        this.hhk.setVisibility(0);
                        this.hhk.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyReceiveUI hhn;

                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                if (abVar.hbI != null) {
                                    intent.putExtra("key_realname_guide_helper", abVar.hbI);
                                }
                                intent.setClass(this.hhn.nDR.nEl, LuckyMoneyDetailUI.class);
                                intent.putExtra("key_native_url", abVar.cCj);
                                intent.putExtra("key_sendid", abVar.haB);
                                this.hhn.startActivity(intent);
                                this.hhn.finish();
                            }
                        });
                        this.hhl.setVisibility(8);
                        return true;
                    }
                    this.hhk.setVisibility(8);
                    this.hhl.setVisibility(0);
                    return true;
                } else if (i2 == 416) {
                    if (this.dwg != null && this.dwg.isShowing()) {
                        this.dwg.hide();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    this.heB.setBackgroundResource(2130838226);
                    return n.a(this, i2, kVar, bundle, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyReceiveUI hhn;

                        {
                            this.hhn = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, null, 1003);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.c.u) {
                if (this.dwg != null && this.dwg.isShowing()) {
                    this.dwg.hide();
                }
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.luckymoney.c.u uVar = (com.tencent.mm.plugin.luckymoney.c.u) kVar;
                    intent = new Intent();
                    intent.setClass(this.nDR.nEl, LuckyMoneyDetailUI.class);
                    try {
                        intent.putExtra("key_detail_info", uVar.hbH.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        v.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    intent.putExtra("key_native_url", this.hek);
                    intent.putExtra("key_sendid", this.hei);
                    startActivity(intent);
                    finish();
                    return true;
                }
                g.bf(this, str);
                finish();
                return true;
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            this.hcx = (ae) kVar;
            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(mI(this.hcx.hau)), Integer.valueOf(ayw()), Integer.valueOf(0), Integer.valueOf(1)});
            if (this.hcx.haN == 2) {
                b(new com.tencent.mm.plugin.luckymoney.c.u(this.hei, this.hek, "v1.0"), false);
                return true;
            }
            boolean z;
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.hide();
            }
            n.h(this.hdW, this.hcx.haA);
            n.a(this.nDR.nEl, this.hey, this.hcx.hcq);
            if (this.hcx.haN == 1 || this.hcx.hav == 4 || this.hcx.hav == 5 || this.hcx.hav == 1) {
                this.heB.setBackgroundResource(2130838577);
                this.heB.setText(2131233639);
                this.heB.setOnClickListener(null);
                this.heB.setVisibility(8);
                if (be.kS(this.hcx.haX)) {
                    this.eWQ.setVisibility(8);
                } else {
                    this.eWQ.setText(this.hcx.haX);
                    this.eWQ.setVisibility(0);
                }
                this.hdY.setText(this.hcx.haw);
                layoutParams = (LayoutParams) this.hhk.getLayoutParams();
                layoutParams.bottomMargin = b.a(this.nDR.nEl, 30.0f);
                this.hhk.setLayoutParams(layoutParams);
                z = true;
            } else {
                if (!be.kS(this.hcx.haw)) {
                    this.eWQ.setText(this.hcx.haw);
                    this.eWQ.setVisibility(0);
                }
                if (!be.kS(this.hcx.hay)) {
                    n.a(this.nDR.nEl, this.hdY, this.hcx.hay);
                    this.hdY.setVisibility(0);
                }
                this.heB.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyReceiveUI hhn;

                    {
                        this.hhn = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(LuckyMoneyReceiveUI.mI(this.hhn.hcx.hau)), Integer.valueOf(this.hhn.ayw()), Integer.valueOf(0), Integer.valueOf(2)});
                        if ("0".equals(this.hhn.hcx.hbN)) {
                            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this.hhn, this.hhn.hdT, this.hhn.hcx.hbO, this.hhn.hcx.hbP, this.hhn.hcx.hbQ, this.hhn.hcx.hbR, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                                final /* synthetic */ AnonymousClass3 hho;

                                {
                                    this.hho = r1;
                                }

                                public final boolean a(int i, int i2, String str, boolean z) {
                                    v.i("MicroMsg.LuckyMoneyReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                                    if (i == 1) {
                                        v.i("MicroMsg.LuckyMoneyReceiveUI", "showDisclaimerDialog cancel");
                                    } else if (z || i == 2) {
                                        this.hho.hhn.ayx();
                                    }
                                    return true;
                                }
                            }, false, 1003);
                        } else {
                            this.hhn.ayx();
                        }
                    }
                });
                z = false;
            }
            if (com.tencent.mm.model.k.xF().equals(this.gjd) || (this.hcx.hau == 1 && z)) {
                if (this.hcx.hau == 1) {
                    this.hhm.setText(2131233608);
                }
                this.hhk.setVisibility(0);
                this.hhk.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyReceiveUI hhn;

                    public final void onClick(View view) {
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(6), Integer.valueOf(LuckyMoneyReceiveUI.mI(this.hhn.hcx.hau)), Integer.valueOf(this.hhn.ayw()), Integer.valueOf(0), Integer.valueOf(1)});
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.hhn.nDR.nEl, LuckyMoneyDetailUI.class);
                        intent.putExtra("key_native_url", this.hhn.hcx.cCj);
                        intent.putExtra("key_sendid", this.hhn.hcx.haB);
                        this.hhn.startActivity(intent);
                        this.hhn.finish();
                    }
                });
                this.hhl.setVisibility(8);
            } else {
                this.hhk.setVisibility(8);
                this.hhl.setVisibility(0);
            }
            n.a(this.heE, null);
            this.nDR.dtW.setVisibility(0);
            return true;
        } else {
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.hide();
            }
            return false;
        }
    }

    private int ayw() {
        if (com.tencent.mm.model.k.xF().equals(this.gjd)) {
            return 1;
        }
        return 0;
    }

    private static int mI(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 2;
        }
        return 0;
    }

    public final void ayx() {
        b(new ab(this.hcx.msgType, this.hcx.aPW, this.hcx.haB, this.hcx.cCj, n.axJ(), com.tencent.mm.model.k.xH(), getIntent().getStringExtra("key_username"), "v1.0"), false);
        n.b(this.heB);
    }
}
