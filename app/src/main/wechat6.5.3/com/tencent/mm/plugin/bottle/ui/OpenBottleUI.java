package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.g;
import junit.framework.Assert;

public class OpenBottleUI extends FrameLayout implements OnClickListener, b, a, g.a, g.b {
    static SensorController evt;
    private com.tencent.mm.c.a.a aSS;
    at aXd;
    private boolean eut = false;
    TextView evA;
    MMActivity evB;
    long evC = 0;
    private boolean evD = false;
    BottleBeachUI evl;
    TextView evm;
    LinearLayout evn;
    FrameLayout evo;
    ImageView evp;
    TextView evq;
    TextView evr;
    TextView evs;
    ThrowBottleAnimUI evu;
    String evv;
    private boolean evw = true;
    private av evx;
    private long evy = -1;
    private boolean evz;

    public OpenBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evl = (BottleBeachUI) context;
        ak.yW();
        c.wH().a(this);
        if (evt == null) {
            evt = new SensorController(context.getApplicationContext());
        }
        if (this.evx == null) {
            this.evx = new av(context.getApplicationContext());
        }
        ak.yW();
        Boolean bool = (Boolean) c.vf().get(26, Boolean.valueOf(false));
        this.evz = bool.booleanValue();
        this.evw = !bool.booleanValue();
        if (this.aSS != null) {
            this.aSS.ak(this.evw);
        }
    }

    public final void onPause() {
        ak.yX().re();
        if (this.aXd != null && this.aXd.bwb()) {
            XT();
        }
        if (this.aSS != null) {
            if (this.aSS.isPlaying()) {
                XV();
            }
            this.aSS.ak(true);
        }
    }

    public final void XT() {
        if (evt != null) {
            evt.btX();
        }
        this.evx.btY();
    }

    public void onClick(View view) {
        if (2131755672 == view.getId()) {
            ThrowBottleAnimUI throwBottleAnimUI = this.evu;
            throwBottleAnimUI.ewA = this.aXd.bwb();
            throwBottleAnimUI.setVisibility(0);
            throwBottleAnimUI.evl.etS = false;
            throwBottleAnimUI.evl.iA(-1);
            throwBottleAnimUI.Yc();
            throwBottleAnimUI.Ya();
            throwBottleAnimUI.Yb();
            ak.yW();
            c.wG().b(new f(this.evv, 1));
            this.eut = false;
            Object obj = this.evl;
            this.evl.getString(2131231164);
            final p a = com.tencent.mm.ui.base.g.a(obj, this.evl.getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ OpenBottleUI evE;

                {
                    this.evE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.evE.eut = true;
                }
            });
            aw.a(this.evv, new aw.a(this) {
                final /* synthetic */ OpenBottleUI evE;

                public final boolean zp() {
                    return this.evE.eut;
                }

                public final void zo() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ak.yW();
            c.wK().Mf(this.evv);
            XT();
        } else if (2131755673 == view.getId()) {
            this.evl.iA(0);
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.evv);
            com.tencent.mm.plugin.bottle.a.drp.e(intent, this.evl);
            XT();
        } else if (2131755669 != view.getId()) {
            return;
        } else {
            if (this.aSS == null || !this.aSS.isPlaying()) {
                C(this.aXd);
                return;
            }
        }
        XV();
    }

    final void XU() {
        String str;
        ak.yW();
        u LX = c.wH().LX(this.evv);
        if (!(LX == null || this.evl == null)) {
            this.evr.setText(this.evl.getString(2131231521, new Object[]{com.tencent.mm.plugin.bottle.a.c.b(this.evl, LX)}));
            this.evr.setCompoundDrawablesWithIntrinsicBounds(LX.bBZ == 1 ? 2131165606 : 2131165605, 0, 0, 0);
            this.evr.setCompoundDrawablePadding(8);
            this.evs.setText(e.a(this.evl, LX.bCj, this.evs.getTextSize()));
        }
        String LM = u.LM(this.evv);
        if (be.kS(LM)) {
            str = this.evv;
        } else {
            str = LM;
        }
        com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) findViewById(2131755663), str);
    }

    static int iF(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return 204;
    }

    private void C(at atVar) {
        if (com.tencent.mm.as.u.bj(getContext()) || com.tencent.mm.ah.a.aT(this.evl)) {
            v.d("MM.Bottle_OpenBottleUI", "voip is running, can't use the feature");
            return;
        }
        boolean z = atVar != null && atVar.bwb();
        Assert.assertTrue(z);
        if (!(atVar == null || !atVar.bwb() || evt.nll)) {
            evt.a(this);
            if (this.evx.F(new Runnable(this) {
                final /* synthetic */ OpenBottleUI evE;

                {
                    this.evE = r1;
                }

                public final void run() {
                    this.evE.evy = be.Nj();
                }
            })) {
                this.evy = 0;
            } else {
                this.evy = -1;
            }
        }
        ak.yW();
        if (c.isSDCardAvailable() || be.kS(atVar.field_imgPath)) {
            if (this.aSS == null) {
                this.aSS = new com.tencent.mm.c.a.a(this.evl);
            }
            ab.Ki("keep_app_silent");
            q.A(atVar);
            this.aSS.stop();
            if (atVar == null || !this.aSS.h(atVar.field_imgPath, this.evw)) {
                Toast.makeText(this.evl, this.evl.getString(2131231868), 0).show();
                return;
            }
            ak.yX().d(this.evw, false);
            this.aSS.aTk = this;
            this.aSS.aTj = this;
            this.evp.setBackgroundResource(2130968602);
            ((AnimationDrawable) this.evp.getBackground()).start();
            return;
        }
        s.ey(this.evl);
    }

    private void XV() {
        ab.Kj("keep_app_silent");
        XT();
        if (this.evp.getBackground() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.evp.getBackground()).stop();
            this.evp.setBackgroundResource(2130837747);
        }
        if (this.aSS != null) {
            this.aSS.stop();
        }
        ca(true);
    }

    public final void pa() {
        v.v("MM.Bottle_OpenBottleUI", "voice play completion");
        XV();
    }

    public final void onError() {
        v.v("MM.Bottle_OpenBottleUI", "voice play error");
        XV();
    }

    public final void a(int i, j jVar, Object obj) {
        v.d("MM.Bottle_OpenBottleUI", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
        if (obj == null || !(obj instanceof String)) {
            v.e("MM.Bottle_OpenBottleUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
            return;
        }
        String str = (String) obj;
        if (!be.kS(this.evv) && u.LM(this.evv).equals(u.LM(str))) {
            XU();
        }
    }

    public final boolean XW() {
        if (this.aSS == null || !this.aSS.isPlaying() || this.evw) {
            return false;
        }
        return true;
    }

    public final void bZ(boolean z) {
        boolean z2 = true;
        if (this.aXd.bwb() && this.aSS != null) {
            if (this.evD) {
                if (z) {
                    z2 = false;
                }
                this.evD = z2;
            } else if (z || this.evy == -1 || be.az(this.evy) <= 400) {
                this.evD = false;
                if (be.Nj() - this.evC > 500 && (z || (!z && this.aSS.isPlaying()))) {
                    ca(z);
                }
                if (this.evz) {
                    this.aSS.ak(false);
                    ak.yX().d(false, false);
                    this.evw = false;
                } else if (this.aSS.isPlaying()) {
                    this.aSS.ak(z);
                    ak.yX().d(z, false);
                    this.evw = z;
                    if (!z) {
                        C(this.aXd);
                    }
                } else {
                    this.aSS.ak(true);
                    ak.yX().d(true, false);
                    this.evw = true;
                }
            } else {
                this.evD = true;
            }
        }
    }

    final void ca(boolean z) {
        this.evB.ca(z);
    }
}
