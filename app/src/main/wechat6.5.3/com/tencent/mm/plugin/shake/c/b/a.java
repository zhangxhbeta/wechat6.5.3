package com.tencent.mm.plugin.shake.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.mx;
import com.tencent.mm.e.a.my;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;

public final class a extends i {
    private static final String eDd = (e.cnj + "card");
    private Resources BE;
    private String eAS = "";
    private View eEX;
    private ImageView eFG;
    private Button eFH;
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ a iPC;

        {
            this.iPC = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131759118) {
                this.iPC.dismiss();
                if (this.iPC.iPA != null) {
                    this.iPC.iPA.aOd();
                }
                v.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
            } else if (view.getId() != 2131755728) {
            } else {
                if (this.iPC.iPz == a.iPE) {
                    this.iPC.iPz = a.iPF;
                    this.iPC.fpm.setVisibility(0);
                    this.iPC.aOb();
                    a.d(this.iPC);
                } else if (this.iPC.iPz == a.iPF) {
                } else {
                    if (this.iPC.iPz == a.iPH) {
                        a.d(this.iPC);
                    } else if (this.iPC.iPz == a.iPG) {
                        com.tencent.mm.sdk.c.a.nhr.e(this.iPC.iPB);
                        a.f(this.iPC);
                    }
                }
            }
        }
    };
    private ProgressBar fpm;
    private ImageView heC;
    private b iPA;
    private c iPB = new c<my>(this) {
        final /* synthetic */ a iPC;

        {
            this.iPC = r2;
            this.nhz = my.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.iPC.dismiss();
            if (this.iPC.iPA != null) {
                this.iPC.iPA.aOd();
            }
            v.i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
            return false;
        }
    };
    private com.tencent.mm.plugin.shake.c.a.e iPd;
    private View iPg;
    private TextView iPh;
    private TextView iPi;
    private TextView iPj;
    private TextView iPk;
    private View iPl;
    private View iPm;
    private View iPn;
    private TextView iPo;
    private TextView iPp;
    private TextView iPq;
    private View iPr;
    private ImageView iPs;
    private boolean iPt;
    public boolean iPu = false;
    private boolean iPw = false;
    private int iPx = 0;
    private com.tencent.mm.e.a.mx.b iPy;
    private int iPz = a.iPE;
    private TextView isF;

    private enum a {
        ;

        static {
            iPE = 1;
            iPF = 2;
            iPG = 3;
            iPH = 4;
            iPI = new int[]{iPE, iPF, iPG, iPH};
        }
    }

    public interface b {
        void aOd();
    }

    static /* synthetic */ void d(a aVar) {
        v.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(aVar.iPd.eBK)) {
            v.e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            return;
        }
        final mx mxVar = new mx();
        mxVar.bok = null;
        mxVar.boj.bol = aVar.iPd.eBK;
        mxVar.boj.bom = aVar.iPd.bom;
        mxVar.boj.bon = 15;
        mxVar.bpT = new Runnable(aVar) {
            final /* synthetic */ a iPC;

            public final void run() {
                v.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
                this.iPC.iPy = mxVar.bok;
                if (this.iPC.iPy != null) {
                    this.iPC.fpm.setVisibility(8);
                    if (this.iPC.iPy != null) {
                        this.iPC.eAS = this.iPC.iPy.bol;
                    }
                    if (this.iPC.iPy == null || !this.iPC.iPy.bbq) {
                        this.iPC.iPz = a.iPH;
                        this.iPC.aOa();
                        this.iPC.aOc();
                        return;
                    }
                    this.iPC.iPz = a.iPG;
                    this.iPC.aOa();
                    a.i(this.iPC);
                    this.iPC.iPu = true;
                    if (this.iPC.iPA != null) {
                        this.iPC.iPA.aOd();
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(mxVar, Looper.getMainLooper());
    }

    static /* synthetic */ void f(a aVar) {
        v.i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        g.iuh.Y(11665, aVar.eAS);
        com.tencent.mm.plugin.shake.c.c.a.p(aVar.getContext(), aVar.eAS, aVar.iPd.bom);
    }

    static /* synthetic */ void i(a aVar) {
        aVar.aOb();
        if (aVar.iPz == a.iPG) {
            aVar.isF.setText(2131235215);
            if (aVar.iPx == 1) {
                aVar.iPs.setImageResource(2131165911);
            } else {
                aVar.iPs.setImageResource(2131165912);
            }
        }
    }

    private a(Context context) {
        super(context, 2131559264);
        v.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.BE = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.eEX = View.inflate(context, 2130904365, null);
        this.iPg = this.eEX.findViewById(2131759109);
        this.iPh = (TextView) this.eEX.findViewById(2131759111);
        this.iPi = (TextView) this.eEX.findViewById(2131756003);
        this.iPj = (TextView) this.eEX.findViewById(2131759112);
        this.heC = (ImageView) this.eEX.findViewById(2131759118);
        this.eFH = (Button) this.eEX.findViewById(2131755728);
        this.iPk = (TextView) this.eEX.findViewById(2131759117);
        this.fpm = (ProgressBar) this.eEX.findViewById(2131759116);
        this.heC.setOnClickListener(this.eFl);
        this.eFH.setOnClickListener(this.eFl);
        this.iPl = this.eEX.findViewById(2131759110);
        this.iPm = this.eEX.findViewById(2131755786);
        this.iPn = this.eEX.findViewById(2131759119);
        this.eFG = (ImageView) this.eEX.findViewById(2131759120);
        this.iPo = (TextView) this.eEX.findViewById(2131755917);
        this.iPp = (TextView) this.eEX.findViewById(2131755714);
        this.iPq = (TextView) this.eEX.findViewById(2131759123);
        this.iPr = this.eEX.findViewById(2131759113);
        this.iPs = (ImageView) this.eEX.findViewById(2131759114);
        this.isF = (TextView) this.eEX.findViewById(2131759115);
        this.iPx = com.tencent.mm.plugin.shake.c.c.a.aOf();
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            v.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.iPA != null) {
                this.iPA.aOd();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.eEX);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.iPt = z;
        setCanceledOnTouchOutside(this.iPt);
    }

    public final void dismiss() {
        try {
            if (this.iPA != null) {
                this.iPA.aOd();
            }
            if (!(this.iPz == a.iPG || this.iPw)) {
                this.iPw = true;
                v.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                ak.vy().a(new com.tencent.mm.plugin.shake.c.a.a(this.iPd.eBK, this.iPd.bom), 0);
            }
            com.tencent.mm.sdk.c.a.nhr.f(this.iPB);
            v.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void aOa() {
        if (this.iPz == a.iPG) {
            this.iPl.setVisibility(8);
            this.iPr.setVisibility(0);
        } else if (this.iPz == a.iPE || this.iPz == a.iPF || this.iPz == a.iPH) {
            this.iPl.setVisibility(0);
            this.iPr.setVisibility(8);
        }
    }

    private void aOb() {
        if (this.iPz == a.iPE || this.iPz == a.iPH) {
            if (TextUtils.isEmpty(this.iPd.iON)) {
                this.eFH.setText(2131231590);
            } else {
                this.eFH.setText(this.iPd.iON);
            }
        } else if (this.iPz == a.iPF) {
            this.eFH.setText("");
        } else if (this.iPz == a.iPG) {
            this.eFH.setText(2131235226);
        }
    }

    private void aOc() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(2131493562);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.qv(this.iPd.coN));
        this.iPn.setBackgroundDrawable(shapeDrawable);
        aOb();
        if (!TextUtils.isEmpty(this.iPd.iOL)) {
            this.iPh.setText(this.iPd.iOL);
        }
        if (!TextUtils.isEmpty(this.iPd.iOP)) {
            this.iPi.setText(this.iPd.iOP);
            this.iPi.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.iPd.iOM)) {
            this.iPj.setText(this.iPd.iOM);
            this.iPj.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.iPd.eBM)) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelSize(2131493561);
            ImageView imageView = this.eFG;
            String str = this.iPd.eBM;
            if (!(imageView == null || TextUtils.isEmpty(str))) {
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(2131165910);
                } else {
                    com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                    aVar.cPv = e.cnj;
                    n.GM();
                    aVar.cPN = null;
                    aVar.cPu = String.format("%s/%s", new Object[]{eDd, com.tencent.mm.a.g.m(str.getBytes())});
                    aVar.cPs = true;
                    aVar.cPP = true;
                    aVar.cPq = true;
                    aVar.cPz = dimensionPixelOffset;
                    aVar.cPy = dimensionPixelOffset;
                    aVar.cPH = 2131165910;
                    n.GL().a(str, imageView, aVar.GU());
                }
            }
        }
        if (!TextUtils.isEmpty(this.iPd.title)) {
            this.iPo.setText(this.iPd.title);
        }
        if (!TextUtils.isEmpty(this.iPd.eCD)) {
            this.iPp.setText(this.iPd.eCD);
        }
        if (this.iPd.eBR > 0) {
            this.iPq.setText(getContext().getString(2131231719, new Object[]{com.tencent.mm.plugin.shake.c.c.a.ao((long) this.iPd.eBR)}));
        }
        if (this.iPz == a.iPH) {
            this.iPk.setVisibility(0);
        } else {
            this.iPk.setVisibility(8);
        }
    }

    public static a a(Context context, com.tencent.mm.plugin.shake.c.a.e eVar, OnCancelListener onCancelListener, b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.setOnCancelListener(onCancelListener);
        aVar.setCancelable(true);
        aVar.iPd = eVar;
        if (aVar.iPd == null) {
            v.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(aVar.iPd.title)) {
                aVar.iPh.setText(aVar.iPd.title);
            }
            v.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            aVar.iPz = a.iPE;
            aVar.aOa();
            aVar.aOc();
            if (aVar.iPx == 0) {
                aVar.iPg.setBackgroundResource(2130839105);
                aVar.iPm.setBackgroundResource(2130839106);
                aVar.iPh.setTextColor(aVar.BE.getColor(2131689547));
                aVar.iPi.setTextColor(aVar.BE.getColor(2131689899));
                aVar.iPj.setTextColor(aVar.BE.getColor(2131689899));
                aVar.isF.setTextColor(aVar.getContext().getResources().getColor(2131689547));
                aVar.eFH.setBackgroundResource(2130837799);
                aVar.eFH.setTextColor(aVar.getContext().getResources().getColor(2131690127));
                aVar.iPk.setTextColor(aVar.getContext().getResources().getColor(2131689905));
            }
        }
        aVar.iPA = bVar;
        aVar.show();
        com.tencent.mm.ui.base.g.a(context, aVar);
        return aVar;
    }
}
