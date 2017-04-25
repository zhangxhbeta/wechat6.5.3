package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.as.f;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView;
import com.tencent.mm.plugin.sight.draft.ui.b.d;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.plugin.sight.encode.a.g;
import com.tencent.mm.plugin.sight.encode.a.h;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ChattingSightContainerView extends RelativeLayout implements com.tencent.mm.plugin.sight.encode.ui.SightCameraView.a {
    public String eSI;
    private int eSy;
    protected float gLd;
    private boolean iXA;
    private LinearLayout iXB;
    private SightDraftContainerView iXC;
    private LinearLayout iXD;
    private ImageView iXE;
    private h iXF;
    public SightCameraView iXG;
    public b iXH;
    private g iXI;
    public com.tencent.mm.plugin.sight.encode.a.b.a iXJ;
    public a iXK;
    private int iXL;
    private int iXM;
    protected boolean iXN;
    private c iXO;
    private Runnable iXP;
    private boolean iXz;
    private String mFileName;

    public interface a {
        void aEU();

        void onHide();
    }

    public final void J(int i, int i2, int i3) {
        this.iXL = i;
        this.eSy = i2;
        this.iXM = i3;
    }

    protected void onDetachedFromWindow() {
        v.i("MicroMsg.ChattingSightContainerView", "on detached from window");
        super.onDetachedFromWindow();
        com.tencent.mm.sdk.c.a.nhr.f(this.iXO);
    }

    protected void onAttachedToWindow() {
        v.i("MicroMsg.ChattingSightContainerView", "on attached from window");
        super.onAttachedToWindow();
        com.tencent.mm.sdk.c.a.nhr.e(this.iXO);
    }

    public ChattingSightContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iXz = false;
        this.iXA = false;
        this.iXF = new h();
        this.iXL = 0;
        this.eSy = 0;
        this.iXM = 0;
        this.eSI = SQLiteDatabase.KeyEmpty;
        this.mFileName = SQLiteDatabase.KeyEmpty;
        this.gLd = 0.0f;
        this.iXN = false;
        this.iXO = new c<pn>(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r2;
                this.nhz = pn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                v.d("MicroMsg.ChattingSightContainerView", "on chatting status callback, type %d", Integer.valueOf(((pn) bVar).bqP.type));
                switch (((pn) bVar).bqP.type) {
                    case 3:
                        this.iXQ.fH(true);
                        break;
                }
                return false;
            }
        };
        this.iXP = new Runnable(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r1;
            }

            public final void run() {
                int i;
                v.i("MicroMsg.ChattingSightContainerView", "on stop callback, send to %s, duration %d, fps %.2f", this.iXQ.eSI, Integer.valueOf(this.iXQ.iXH.getDuration()), Float.valueOf(this.iXQ.iXH.aAh()));
                k.KV();
                String lc = o.lc(this.iXQ.mFileName);
                k.KV();
                String ld = o.ld(this.iXQ.mFileName);
                int duration = this.iXQ.iXH.getDuration();
                k.La().a(lc, ld, null, duration, null);
                String a = this.iXQ.eSI;
                lc = this.iXQ.mFileName;
                if (be.kS(a)) {
                    v.w("MicroMsg.SightRecorderHelper", "want to mux and send, but talker is null");
                    i = 0;
                } else if (-1 == p.d(lc, duration, a)) {
                    v.e("MicroMsg.SightRecorderHelper", "prepare sight error");
                    i = 0;
                } else {
                    k.KV();
                    if (e.aQ(o.lc(lc)) <= 0) {
                        v.e("MicroMsg.SightRecorderHelper", "mux sight error: file length 0");
                        p.lj(lc);
                        i = 0;
                    } else {
                        p.f(lc, duration, 62);
                        i = p.lk(lc) < 0 ? 0 : 1;
                    }
                }
                this.iXQ.iXH.a(b.b.Sent);
                if (i != 0) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(2), Integer.valueOf(1));
                }
            }
        };
        inflate(getContext(), 2130903368, this);
        setBackgroundResource(2131689547);
        this.iXD = (LinearLayout) findViewById(2131756298);
        this.iXE = (ImageView) findViewById(2131756300);
        this.iXB = (LinearLayout) findViewById(2131756309);
        this.iXC = (SightDraftContainerView) findViewById(2131756313);
        this.iXC.a(new com.tencent.mm.plugin.sight.draft.ui.a(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r1;
            }

            public final void a(f fVar) {
                com.tencent.mm.as.g La = k.La();
                String a = this.iXQ.eSI;
                int i = fVar.field_fileNameHash;
                com.tencent.mm.as.g.a anonymousClass1 = new com.tencent.mm.as.g.a(this) {
                    final /* synthetic */ AnonymousClass2 iXR;

                    {
                        this.iXR = r1;
                    }

                    public final void gu(int i) {
                        v.i("MicroMsg.ChattingSightContainerView", "send sight result %d", Integer.valueOf(i));
                        switch (i) {
                            case 0:
                                return;
                            default:
                                com.tencent.mm.ui.base.g.bf(this.iXR.iXQ.getContext(), this.iXR.iXQ.getResources().getString(2131235335));
                                return;
                        }
                    }
                };
                Runnable dVar = new d();
                dVar.bdo = a;
                dVar.dgR = i;
                dVar.dgQ = anonymousClass1;
                ak.vA().x(dVar);
                this.iXQ.iXC.aPI();
            }

            public final void a(d dVar) {
                if (d.EDIT == dVar) {
                    ((TextView) this.iXQ.findViewById(2131756312)).setText(2131235331);
                    this.iXQ.findViewById(2131756312).setVisibility(0);
                    this.iXQ.findViewById(2131755284).setVisibility(0);
                    this.iXQ.findViewById(2131756311).setVisibility(8);
                } else {
                    ((TextView) this.iXQ.findViewById(2131756312)).setText(2131235332);
                    this.iXQ.findViewById(2131756312).setVisibility(8);
                    this.iXQ.findViewById(2131755284).setVisibility(8);
                    this.iXQ.findViewById(2131756311).setVisibility(0);
                }
                k.KX().KP();
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        this.iXF.e(this);
        this.iXI = new g();
        this.iXH = new com.tencent.mm.plugin.sight.encode.a.e();
        aPY();
        if (u.bsU()) {
            findViewById(2131756304).setVisibility(0);
            findViewById(2131756305).setVisibility(8);
        } else {
            findViewById(2131756304).setVisibility(8);
            findViewById(2131756305).setVisibility(0);
        }
        findViewById(2131756302).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r1;
            }

            public final void onClick(View view) {
                this.iXQ.iXB.setVisibility(0);
                this.iXQ.iXC.aPH();
                this.iXQ.iXC.aPG();
                this.iXQ.iXG.aLn();
            }
        });
        findViewById(2131756312).setVisibility(8);
        findViewById(2131756312).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r1;
            }

            public final void onClick(View view) {
                this.iXQ.iXC.aPK();
            }
        });
        findViewById(2131755284).setVisibility(8);
        findViewById(2131756311).setVisibility(0);
        findViewById(2131756310).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r1;
            }

            public final void onClick(View view) {
                this.iXQ.fH(false);
            }
        });
        findViewById(2131756303).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChattingSightContainerView iXQ;

            {
                this.iXQ = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
                /*
                r8 = this;
                r7 = 0;
                r6 = 1125515264; // 0x43160000 float:150.0 double:5.56078426E-315;
                r5 = 1;
                r0 = r8.iXQ;
                r0 = r0.iXz;
                if (r0 != 0) goto L_0x0018;
            L_0x000c:
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0 = r0.aQF();
                if (r0 == 0) goto L_0x0043;
            L_0x0018:
                r0 = r8.iXQ;
                r0 = r0.iXz;
                if (r0 == 0) goto L_0x0021;
            L_0x0020:
                return r5;
            L_0x0021:
                r0 = r8.iXQ;
                r0 = r0.gLd;
                r1 = r10.getY();
                r0 = r0 - r1;
                r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
                if (r0 <= 0) goto L_0x0034;
            L_0x002e:
                r0 = r8.iXQ;
                r0.aPZ();
                goto L_0x0020;
            L_0x0034:
                r0 = "MicroMsg.ChattingSightContainerView";
                r1 = "full stop";
                com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                r0 = r8.iXQ;
                r0.oT();
                goto L_0x0020;
            L_0x0043:
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0.fP(r7);
                r0 = r10.getAction();
                switch(r0) {
                    case 0: goto L_0x0054;
                    case 1: goto L_0x00a1;
                    case 2: goto L_0x006e;
                    case 3: goto L_0x0117;
                    default: goto L_0x0053;
                };
            L_0x0053:
                goto L_0x0020;
            L_0x0054:
                r0 = r8.iXQ;
                r1 = r10.getY();
                r0.gLd = r1;
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0 = r0.aQD();
                if (r0 == 0) goto L_0x0020;
            L_0x0068:
                r0 = r8.iXQ;
                r0.auD();
                goto L_0x0020;
            L_0x006e:
                r0 = r8.iXQ;
                r0 = r0.gLd;
                r1 = r10.getY();
                r0 = r0 - r1;
                r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
                if (r0 <= 0) goto L_0x008e;
            L_0x007b:
                r0 = r8.iXQ;
                r0 = r0.iXF;
                r0.aPW();
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0.fP(r5);
                goto L_0x0020;
            L_0x008e:
                r0 = r8.iXQ;
                r0 = r0.iXF;
                r0.aPV();
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0.fP(r7);
                goto L_0x0020;
            L_0x00a1:
                r0 = "MicroMsg.ChattingSightContainerView";
                r1 = "action up, y delta %f, isTooShort %B";
                r2 = 2;
                r2 = new java.lang.Object[r2];
                r3 = r8.iXQ;
                r3 = r3.gLd;
                r4 = r10.getY();
                r3 = r3 - r4;
                r3 = java.lang.Float.valueOf(r3);
                r2[r7] = r3;
                r3 = r8.iXQ;
                r3 = r3.iXG;
                r3 = r3.aQB();
                r3 = java.lang.Boolean.valueOf(r3);
                r2[r5] = r3;
                com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0 = r0.aQE();
                if (r0 != 0) goto L_0x0117;
            L_0x00d8:
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0 = r0.pq();
                if (r0 == 0) goto L_0x0117;
            L_0x00e4:
                r0 = r8.iXQ;
                r0 = r0.gLd;
                r1 = r10.getY();
                r0 = r0 - r1;
                r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
                if (r0 > 0) goto L_0x0117;
            L_0x00f1:
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0 = r0.aQB();
                if (r0 == 0) goto L_0x011e;
            L_0x00fd:
                r0 = r8.iXQ;
                r0 = r0.getContext();
                r1 = r8.iXQ;
                r1 = r1.getContext();
                r1 = r1.getResources();
                r2 = 2131235350; // 0x7f081216 float:1.8086891E38 double:1.0529701696E-314;
                r1 = r1.getString(r2);
                com.tencent.mm.ui.base.g.bf(r0, r1);
            L_0x0117:
                r0 = r8.iXQ;
                r0.aPZ();
                goto L_0x0020;
            L_0x011e:
                r0 = r8.iXQ;
                r0 = r0.iXG;
                r0 = r0.aQC();
                if (r0 == 0) goto L_0x0145;
            L_0x012a:
                r0 = r8.iXQ;
                r0 = r0.getContext();
                r1 = r8.iXQ;
                r1 = r1.getContext();
                r1 = r1.getResources();
                r2 = 2131235342; // 0x7f08120e float:1.8086875E38 double:1.0529701657E-314;
                r1 = r1.getString(r2);
                com.tencent.mm.ui.base.g.bf(r0, r1);
                goto L_0x0117;
            L_0x0145:
                r0 = r8.iXQ;
                r0.oT();
                goto L_0x0020;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.encode.ui.ChattingSightContainerView.6.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        v.d("MicroMsg.ChattingSightContainerView", "init concrol view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public ChattingSightContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void aPY() {
        if (!com.tencent.mm.plugin.sight.base.d.aOR()) {
            this.iXD.removeView(this.iXG);
            this.iXH.b(this.iXG);
            this.iXG = new SightCameraSurfaceView(getContext());
        } else if (this.iXG == null) {
            this.iXG = new SightCameraTextureView(getContext());
        } else {
            return;
        }
        this.iXG.setId(2131758008);
        this.iXD.addView(this.iXG, new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(getContext(), 240)));
        this.iXG.pL(com.tencent.mm.pluginsdk.n.a.lFo);
        this.iXG.a(this.iXH);
        this.iXG.a((com.tencent.mm.plugin.sight.encode.ui.SightCameraView.a) this);
        this.iXG.Z(1.3333334f);
    }

    protected final void auD() {
        this.mFileName = o.lb(this.eSI);
        v.i("MicroMsg.ChattingSightContainerView", "start record: talker[%s], fileName[%s]", this.eSI, this.mFileName);
        this.iXH.cv(this.eSI, this.mFileName);
        this.iXG.u(this.iXP);
        this.iXG.auD();
        com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(0));
    }

    protected final void aPZ() {
        v.i("MicroMsg.ChattingSightContainerView", "cancel record");
        this.iXF.hide();
        this.iXG.aPZ();
    }

    protected final void oT() {
        v.i("MicroMsg.ChattingSightContainerView", "stop record: is finishRecord %B. C2C short video duration: %d", Boolean.valueOf(this.iXz), Integer.valueOf(this.iXG.getDuration()));
        if (!this.iXz) {
            v.d("MicroMsg.ChattingSightContainerView", "sight camera view try stop");
            this.iXF.hide();
            this.iXG.oT();
            com.tencent.mm.sdk.c.b pnVar = new pn();
            pnVar.bqP.type = 7;
            pnVar.bqP.bqQ = this.eSy;
            pnVar.bqP.bqR = this.iXM;
            pnVar.bqP.bqS = this.iXL;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(1));
        }
        this.iXz = true;
    }

    public final boolean aQa() {
        return this.iXN;
    }

    public final void show() {
        v.d("MicroMsg.ChattingSightContainerView", "show recoder view, last time show %B", Boolean.valueOf(this.iXN));
        if (!this.iXN) {
            boolean se = com.tencent.mm.compatible.e.b.se();
            boolean sf = com.tencent.mm.compatible.e.b.sf();
            if (sf && se) {
                se = true;
            } else {
                v.e("MicroMsg.ChattingSightContainerView", "no permission video : %s audio %s", Boolean.valueOf(sf), Boolean.valueOf(se));
                String str = null;
                String str2 = null;
                if (!se && !sf) {
                    str = getContext().getString(2131231159);
                    str2 = getContext().getString(2131231097);
                } else if (!se) {
                    str = getContext().getString(2131231161);
                    str2 = getContext().getString(2131231098);
                } else if (!sf) {
                    str = getContext().getString(2131231160);
                    str2 = getContext().getString(2131231099);
                }
                com.tencent.mm.ui.base.g.a(getContext(), str, str2, getContext().getString(2131231100), true, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ ChattingSightContainerView iXQ;

                    {
                        this.iXQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.compatible.e.b.ay(this.iXQ.getContext());
                    }
                });
                se = false;
            }
            if (se) {
                aPY();
                this.iXB.setVisibility(8);
                if (k.KX().KN() > 0) {
                    findViewById(2131756302).setVisibility(0);
                } else {
                    findViewById(2131756302).setVisibility(8);
                }
                this.iXE.setVisibility(0);
                this.iXF.aPU();
                setVisibility(0);
                this.iXN = true;
                this.iXz = false;
                this.iXG.aQw();
                if (this.iXK != null) {
                    this.iXK.aEU();
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0));
            }
        }
    }

    public final void fH(boolean z) {
        v.i("MicroMsg.ChattingSightContainerView", "hide recoder view, last time show %B, force %B", Boolean.valueOf(this.iXN), Boolean.valueOf(z));
        if (z) {
            this.iXC.fG(true);
        } else if (this.iXC.fG(false)) {
            return;
        }
        findViewById(2131755284).setVisibility(8);
        findViewById(2131756311).setVisibility(0);
        setVisibility(8);
        this.iXN = false;
        this.iXG.aLn();
        this.iXC.clearCache();
        if (this.iXK != null) {
            this.iXK.onHide();
        }
        if (!com.tencent.mm.plugin.sight.base.d.aOR()) {
            this.iXD.removeView(this.iXG);
            this.iXH.b(this.iXG);
        }
    }

    public final void aQb() {
        this.iXE.setVisibility(8);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        if (!this.iXA && com.tencent.mm.plugin.sight.base.d.aOR()) {
            alphaAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ChattingSightContainerView iXQ;

                {
                    this.iXQ = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.iXQ.iXE.setBackgroundColor(-587202560);
                    this.iXQ.iXA = true;
                }
            });
        }
        this.iXE.startAnimation(alphaAnimation);
    }
}
