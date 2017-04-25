package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.StrictMode;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.be;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.a.a.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.ar;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.as.AnonymousClass7;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public final class h {
    public static List<j> jEv = new LinkedList();
    String bYE;
    private Context context;
    ClipboardManager fRJ;
    protected ListView gMx;
    p jEA = null;
    c jEB = new c<be>(this) {
        final /* synthetic */ h jED;

        {
            this.jED = r2;
            this.nhz = be.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.jED.jEw != null) {
                this.jED.jEw.aVG();
            }
            return false;
        }
    };
    OnLongClickListener jEC = new OnLongClickListener(this) {
        final /* synthetic */ h jED;

        {
            this.jED = r1;
        }

        public final boolean onLongClick(View view) {
            ak.yW();
            if (((Boolean) com.tencent.mm.model.c.vf().get(7490, Boolean.valueOf(true))).booleanValue()) {
                this.jED.context.startActivity(new Intent().setClass(this.jED.context, SnsLongMsgUI.class));
                ak.yW();
                com.tencent.mm.model.c.vf().set(7490, Boolean.valueOf(false));
            } else {
                Intent intent = new Intent();
                intent.setClass(this.jED.context, SnsCommentUI.class);
                intent.putExtra("sns_comment_type", 1);
                ((MMActivity) this.jED.context).startActivityForResult(intent, 9);
            }
            return true;
        }
    };
    public g jEn;
    public ar jEo;
    SnsCommentFooter jEp;
    bf jEq;
    al jEr;
    private boolean jEs = false;
    private String jEt = "";
    private boolean jEu = false;
    be jEw;
    b jEx;
    com.tencent.mm.plugin.sns.f.b jEy;
    public com.tencent.mm.plugin.sns.ui.b.b jEz;
    FrameLayout joW;
    public as jpB;

    public class a implements OnClickListener {
        private String caJ;
        private com.tencent.mm.plugin.sns.ui.a.a.c jDX;
        final /* synthetic */ h jED;
        private CharSequence jEG = "";
        private avr jkg;

        public a(h hVar, avr com_tencent_mm_protocal_c_avr, String str, CharSequence charSequence, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
            this.jED = hVar;
            this.caJ = str;
            this.jkg = com_tencent_mm_protocal_c_avr;
            this.jDX = cVar;
            this.jEG = charSequence;
        }

        public final void onClick(View view) {
            int i = 0;
            if (s.BM(this.jDX.boC)) {
                this.jDX.kau = view;
                if (this.jkg == null || this.jkg.mdw == null || !this.jkg.mdw.equals(this.jED.bYE)) {
                    k kVar = new k();
                    k qK = this.jED.jpB.qK(this.jDX.position);
                    if (!qK.aSn()) {
                        if (x.h(qK)) {
                            String str;
                            int i2;
                            com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(742);
                            awa n = ah.n(qK);
                            com.tencent.mm.modelsns.a kj = gh.kj(i.g(qK)).gk(qK.field_type).bg(qK.qC(32)).kj(qK.aUR());
                            if (this.jkg.mSN == 0) {
                                str = this.jkg.mSQ;
                            } else {
                                str = this.jkg.mSN;
                            }
                            kj = kj.kj(str).kj(this.jkg.mdw);
                            if (n == null) {
                                i2 = 0;
                            } else {
                                i2 = n.mTi;
                            }
                            com.tencent.mm.modelsns.a gk = kj.gk(i2);
                            if (n != null) {
                                i = n.mTl;
                            }
                            gk.gk(i);
                            gh.JF();
                            this.jED.a(this.jDX, qK, this.jED.context.getString(2131235510) + this.caJ, this.jkg);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.b.e(this.jDX.kaA.getContext(), this.jDX.kaA.qQ(0));
                        return;
                    }
                    return;
                }
                if (this.jED.jEq.jZp) {
                    this.jED.aVu();
                    this.jED.jEq.jZp = false;
                }
                Context b = this.jED.context;
                String[] strArr = new String[]{this.jED.context.getString(2131231773), this.jED.context.getString(2131231020)};
                this.jED.context.getString(2131231010);
                com.tencent.mm.ui.base.g.a(b, null, strArr, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ a jEH;

                    {
                        this.jEH = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                this.jEH.jED.fRJ.setText(this.jEH.jEG);
                                com.tencent.mm.ui.base.g.bf(this.jEH.jED.context, this.jEH.jED.context.getString(2131231016));
                                return;
                            case 1:
                                v.e("MicroMsg.BaseTimeLine", "del snsId:" + this.jEH.jDX.boC + " commentId:" + this.jEH.jkg);
                                final com.tencent.mm.plugin.sns.e.p pVar = new com.tencent.mm.plugin.sns.e.p(s.BK(this.jEH.jDX.boC), s.BJ(this.jEH.jDX.boC) ? 6 : 4, this.jEH.jkg);
                                ak.vy().a(pVar, 0);
                                h hVar = this.jEH.jED;
                                Context b = this.jEH.jED.context;
                                this.jEH.jED.context.getString(2131231164);
                                hVar.jEA = com.tencent.mm.ui.base.g.a(b, this.jEH.jED.context.getString(2131235388), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass1 jEJ;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(pVar);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    public h(Context context, int i, String str, int i2) {
        this.context = context;
        this.bYE = com.tencent.mm.model.k.xF();
        this.jEo = new ar();
        this.jEo.jmQ = new com.tencent.mm.plugin.sns.i.b(i, str, i2);
        this.jEz = new com.tencent.mm.plugin.sns.ui.b.b(this, (Activity) context, this.jEo) {
            final /* synthetic */ h jED;

            public final void b(View view, int i, int i2, int i3) {
                if (i2 < 0) {
                    final int i4 = i;
                    final int i5 = i2;
                    final int i6 = i3;
                    final View view2 = view;
                    new Runnable(this) {
                        int count = 20;
                        final /* synthetic */ AnonymousClass1 jEF;

                        public final void run() {
                            this.jEF.jED.gMx.setSelectionFromTop(i4 + this.jEF.jED.gMx.getHeaderViewsCount(), i5 + i6);
                            this.count--;
                            v.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", new Object[]{Integer.valueOf(this.count), Integer.valueOf(Math.abs(view2.getTop() - (i5 + i6)))});
                            if (this.count <= 0 || Math.abs(view2.getTop() - (i5 + i6)) < 5) {
                                v.d("MicroMsg.TimelineClickListener", "count: %s", new Object[]{Integer.valueOf(this.count)});
                                this.jEF.jED.jpB.notifyDataSetChanged();
                                return;
                            }
                            new ac().postDelayed(this, 5);
                        }
                    }.run();
                }
            }

            public final void aY(Object obj) {
                this.jED.jEr.a((View) obj, 1, this.jED.jEo);
            }

            public final void aVv() {
                if (this.jED.jpB != null) {
                    this.jED.jpB.aXA();
                }
            }

            public final void cf(View view) {
                int i = 0;
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                if (this.jED.jpB.aXx() != null) {
                    this.jED.jpB.aXx().aVG();
                    k kVar = new k();
                    k qK = this.jED.jpB.qK(cVar.position);
                    if (qK.isValid()) {
                        com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(741);
                        awa n = ah.n(qK);
                        com.tencent.mm.modelsns.a gk = gh.kj(i.g(qK)).gk(qK.field_type).bg(qK.qC(32)).kj(qK.aUR()).kj(qK.field_userName).gk(n == null ? 0 : n.mTi);
                        if (n != null) {
                            i = n.mTl;
                        }
                        gk.gk(i);
                        gh.JF();
                        this.jED.a(cVar, qK, "", new avr());
                        avr com_tencent_mm_protocal_c_avr = new avr();
                    }
                }
            }

            public final void cg(View view) {
                if (this.jED.jpB != null) {
                    this.jED.jpB.ck(view);
                }
            }

            public final void ch(View view) {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                k kVar = new k();
                kVar = ad.aSE().Bq(cVar.bap);
                if (!kVar.aSn()) {
                    if (this.jED.jEo != null) {
                        this.jED.jEo.jmQ.u(kVar);
                    }
                    if (cVar.kac == 0) {
                        awa n = ah.n(kVar);
                        com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(707);
                        gh.kj(i.g(kVar)).gk(kVar.field_type).bg(kVar.qC(32)).kj(kVar.aUR()).kj(kVar.field_userName).gk(n.mTi).gk(n.mTl);
                        gh.JF();
                        StrictMode.allowThreadDiskReads();
                        cVar.kac = 1;
                        kVar.field_likeFlag = cVar.kac;
                        f.a(kVar.aUq(), kVar);
                        ((TextView) view.findViewById(2131759312)).setText(2131235422);
                        com.tencent.mm.plugin.sns.e.ak.a.a(kVar, kVar.qC(32) ? 7 : 1, "");
                    } else {
                        cVar.kac = 0;
                        kVar.field_likeFlag = cVar.kac;
                        f.a(kVar.aUq(), kVar);
                        ((TextView) view.findViewById(2131759312)).setText(2131235460);
                        com.tencent.mm.plugin.sns.e.ak.a.Ay(kVar.aUq());
                    }
                    as asVar = this.jED.jpB;
                    LinearLayout linearLayout = (LinearLayout) view;
                    ImageView imageView = (ImageView) linearLayout.findViewById(2131759311);
                    Animation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(400);
                    scaleAnimation.setStartOffset(100);
                    scaleAnimation.setRepeatCount(0);
                    imageView.clearAnimation();
                    imageView.startAnimation(scaleAnimation);
                    scaleAnimation.setAnimationListener(new AnonymousClass7(asVar, linearLayout));
                }
            }

            public final void ci(View view) {
                this.jED.jEw.aVG();
                this.jED.jEx.ce(view);
            }

            public final void aVw() {
                this.jED.jEx.aTn();
            }
        };
        this.jEz.aYq();
        com.tencent.mm.sdk.c.a.nhr.e(this.jEB);
    }

    final void aVu() {
        if (this.jEs) {
            if (this.jEp.getVisibility() != 8) {
                this.jEp.setVisibility(8);
            }
            as asVar = this.jpB;
            if (asVar.jUh != null) {
                asVar.jUh.setVisibility(8);
            }
            asVar.jUh = null;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, k kVar, String str, avr com_tencent_mm_protocal_c_avr) {
        int i = 0;
        String str2 = cVar.boC + str;
        this.jEt = str2;
        v.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.jEt + " " + cVar.boC + " position:" + cVar.position);
        if (!this.jEs) {
            this.jEs = true;
            this.jEp.aWK();
            this.jEp.a(new c(this) {
                final /* synthetic */ h jED;

                {
                    this.jED = r1;
                }

                public final void BP(String str) {
                    k kVar = (k) this.jED.jEp.getTag();
                    v.d("MicroMsg.BaseTimeLine", "onCommentSend click");
                    if (str == null || str.trim().equals("")) {
                        v.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                        return;
                    }
                    avr aWN = this.jED.jEp.aWN();
                    awa n = ah.n(kVar);
                    int i = (aWN.mSN == 0 && aWN.mSQ == 0) ? 708 : 709;
                    com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(i);
                    if (gh.opType == 708) {
                        gh.kj(i.g(kVar)).gk(kVar.field_type).bg(kVar.qC(32)).kj(kVar.aUR()).kj(kVar.field_userName).gk(n.mTi).gk(n.mTl);
                    } else {
                        gh.kj(i.g(kVar)).gk(kVar.field_type).bg(kVar.qC(32)).kj(kVar.aUR()).kj(aWN.mdw).kj(aWN.mSN == 0 ? aWN.mSQ : aWN.mSN).gk(n.mTi).gk(n.mTl);
                    }
                    gh.JF();
                    if (this.jED.jEo != null) {
                        this.jED.jEo.jmQ.u(kVar);
                    }
                    com.tencent.mm.plugin.sns.e.ak.a.a(kVar, kVar.qC(32) ? 8 : 2, str, this.jED.jEp.aWN());
                    this.jED.jpB.w(this.jED.jEq.jZs);
                    this.jED.aVu();
                    if (com.tencent.mm.sdk.platformtools.be.kS(this.jED.jEt)) {
                        for (j jVar : h.jEv) {
                            if (this.jED.jEt.equals(jVar.apU)) {
                                v.d("MicroMsg.BaseTimeLine", "remove ct");
                                h.jEv.remove(jVar);
                                return;
                            }
                        }
                    }
                }
            });
            SnsCommentFooter snsCommentFooter = this.jEp;
            AnonymousClass4 anonymousClass4 = new com.tencent.mm.ui.widget.MMEditText.a(this) {
                final /* synthetic */ h jED;

                {
                    this.jED = r1;
                }

                public final void ayj() {
                    if (this.jED.jEp.getVisibility() == 0) {
                        this.jED.jEp.setVisibility(8);
                    } else {
                        ((Activity) this.jED.context).finish();
                    }
                }
            };
            if (snsCommentFooter.hhK != null) {
                snsCommentFooter.hhK.pcr = anonymousClass4;
            }
        }
        this.jEp.setTag(kVar);
        this.jEp.setVisibility(0);
        this.jEp.a(str, com_tencent_mm_protocal_c_avr);
        this.jEp.f(jEv, str2);
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.context, 8);
        if (cVar.kau != null) {
            i = (cVar.kaw.getHeight() - cVar.kau.getBottom()) + fromDPToPix;
            v.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.kau.getBottom());
        }
        this.jEq.position = cVar.position;
        this.jEq.jZm = cVar.kad.getHeight() - i;
        cVar.kau = null;
        this.jEq.jZn = cVar.kad.getTop();
        this.jEq.jMD = this.gMx.getBottom();
        v.e("MicroMsg.BaseTimeLine", "originalTop:" + this.jEq.jZn);
        bf bfVar = this.jEq;
        bfVar.jZp = true;
        bfVar.jZq = 20;
        new ac().postDelayed(bfVar.jZt, 100);
    }
}
