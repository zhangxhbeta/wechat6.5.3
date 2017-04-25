package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.g;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, a {
    private boolean aUP;
    private boolean gCX;
    public View hgp;
    public MMFragmentActivity iYA;
    private boolean iYB;
    private c iYC;
    private boolean iYD;
    private MediaPlayer iYG;
    public String iYP;
    public float iYQ;
    public MainSightSelectContactView iYe;
    public SightCameraView iYg;
    public b iYi;
    public View iYj;
    public View iYl;
    private g iYm;
    public View iYo;
    private Dialog iYr;
    private boolean iYv;
    public String iYw;
    private boolean iYx;
    private boolean iYy;
    private int lr;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iYr = null;
        this.gCX = false;
        this.iYv = true;
        this.iYw = SQLiteDatabase.KeyEmpty;
        this.iYx = false;
        this.iYP = SQLiteDatabase.KeyEmpty;
        this.lr = 1;
        this.iYQ = 1.0f;
        this.aUP = false;
        this.iYm = new g();
        this.iYy = false;
        this.iYB = false;
        this.iYC = new c<ne>(this) {
            final /* synthetic */ MainSightForwardContainerView iYR;

            {
                this.iYR = r2;
                this.nhz = ne.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ne neVar = (ne) bVar;
                String str = "MicroMsg.MainSightContainerView";
                String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = Integer.valueOf(neVar.bor.type);
                objArr[2] = Boolean.valueOf(this.iYR.iYr != null);
                objArr[3] = Boolean.valueOf(this.iYR.iYD);
                v.i(str, str2, objArr);
                switch (neVar.bor.type) {
                    case 0:
                        this.iYR.iYB = false;
                        if (!this.iYR.iYD) {
                            if (!neVar.bor.bot) {
                                this.iYR.postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass5 iYS;

                                    {
                                        this.iYS = r1;
                                    }

                                    public final void run() {
                                        this.iYS.iYR.aQf();
                                    }
                                }, 500);
                                break;
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0));
                            this.iYR.fO(true);
                            break;
                        }
                        if (neVar.bor.bot) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0));
                        }
                        this.iYR.afF();
                        break;
                }
                return false;
            }
        };
        this.iYD = false;
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void afF() {
        a.nhr.f(this.iYC);
    }

    public final void aQf() {
        boolean z = true;
        v.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", this.iYP, Boolean.valueOf(this.iYv), Boolean.valueOf(this.gCX));
        if (!this.iYg.isPlaying()) {
            this.iYv = true;
        }
        this.iYg.ah(this.iYP, this.iYv);
        if (this.iYv) {
            fL(true);
        } else {
            fL(false);
        }
        this.gCX = true;
        if (this.iYv) {
            z = false;
        }
        this.iYv = z;
    }

    public final boolean tM() {
        return !this.iYv;
    }

    private void fK(boolean z) {
        if (this.iYg != null) {
            this.iYg.fK(z);
        }
    }

    public final void fO(boolean z) {
        if (!this.iYx) {
            this.iYx = true;
            be.cw(this);
            this.gCX = false;
            this.iYv = true;
            v.d("MicroMsg.MainSightContainerView", "dismiss sight view");
            this.iYB = false;
            this.iYg.aQz();
            if (this.iYi != null && z) {
                this.iYi.fJ(false);
            }
            if (this.iYe != null) {
                this.iYe.dismiss();
            }
            X(0.85f);
            aQg();
            fL(false);
            this.iYw = SQLiteDatabase.KeyEmpty;
            afF();
        }
    }

    public final void fL(boolean z) {
        if (this.iYy != z) {
            this.iYy = z;
            if (!z) {
                this.iYj.setVisibility(8);
                this.hgp.setVisibility(8);
            } else if (this.iYj.getVisibility() != 0) {
                this.iYg.postDelayed(new Runnable(this) {
                    final /* synthetic */ MainSightForwardContainerView iYR;

                    {
                        this.iYR = r1;
                    }

                    public final void run() {
                        if (!this.iYR.iYy || (this.iYR.iYe != null && this.iYR.iYe.iZl.aQl())) {
                            this.iYR.iYy = false;
                            return;
                        }
                        this.iYR.iYj.setVisibility(0);
                        if (this.iYR.iYe != null && !this.iYR.iYe.aQt() && this.iYR.hgp.getVisibility() != 0) {
                            this.iYR.hgp.setVisibility(0);
                            this.iYR.hgp.startAnimation(AnimationUtils.loadAnimation(this.iYR.iYA, 2130968622));
                        }
                    }
                }, 100);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i - 1;
        if (MainSightSelectContactView.pJ(i2) && this.gCX) {
            aQf();
        } else if (this.iYe.pI(i2)) {
            this.iYe.iZl.aQm();
        } else if (!this.iYe.pH(i2)) {
            v.d("MicroMsg.MainSightContainerView", "on item click Item : %d", Integer.valueOf(i2));
            this.iYe.pG(i2);
            this.iYe.notifyDataSetChanged();
            if (!tM()) {
                aQf();
            } else if (this.iYe.aQt()) {
                if (this.hgp.getVisibility() == 0) {
                    this.hgp.setVisibility(8);
                    this.hgp.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968623));
                }
            } else if (this.hgp.getVisibility() != 0) {
                this.hgp.setVisibility(0);
                this.hgp.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968622));
            }
            if (this.iYe.iZl.aQl() && this.iYe.pK(i2)) {
                this.iYe.iZl.aQm();
            }
        } else if (c.iYV) {
            this.iYB = true;
            this.iYg.aQz();
            g.a(this.iYA, d.zz(this.iYP), this.iYP, this.iYw, false, 0);
            if (this.iYD) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(3), Integer.valueOf(3));
                return;
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(1), Integer.valueOf(3));
        }
    }

    public final void aQj() {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.iYr == null);
        v.i(str, str2, objArr);
        if (!be.kS(this.iYP) && !this.iYe.aQt()) {
            boolean z;
            final List<String> aQs = this.iYe.aQs();
            com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(aQs.size()));
            g.a anonymousClass6 = new g.a(this) {
                final /* synthetic */ MainSightForwardContainerView iYR;

                public final void onError(int i) {
                    if (aQs.size() <= 1 || -1 == i) {
                        com.tencent.mm.ui.base.g.bf(this.iYR.getContext(), this.iYR.getContext().getString(2131234920));
                    }
                }
            };
            if (aQs.size() == 1) {
                this.iYm.a(this.iYP, this.lr, this.iYw, (String) aQs.get(0), anonymousClass6);
            } else {
                this.iYm.a(this.iYP, this.lr, this.iYw, (List) aQs, anonymousClass6);
            }
            if (this.iYe.aQs().size() > 1 || this.iYi == null) {
                z = true;
            } else {
                this.iYi.zF((String) this.iYe.aQs().get(0));
                z = false;
            }
            if (this.iYA != null) {
                try {
                    AssetFileDescriptor openFd = this.iYA.getAssets().openFd("sight_send_song.wav");
                    this.iYG = new MediaPlayer();
                    this.iYG.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    this.iYG.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ MainSightForwardContainerView iYR;

                        {
                            this.iYR = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                        }
                    });
                    this.iYG.setLooping(false);
                    this.iYG.prepare();
                    this.iYG.start();
                } catch (Throwable e) {
                    v.a("MicroMsg.MainSightContainerView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            fO(z);
            for (String toLowerCase : aQs) {
                if (toLowerCase.toLowerCase().endsWith("@chatroom")) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(1), Integer.valueOf(2));
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
    }

    public final void onPause() {
        if (!this.iYB) {
            this.iYg.setVisibility(0);
            fL(false);
            this.iYg.aQz();
            this.aUP = true;
        }
    }

    public final void onResume() {
        if (!this.iYx) {
            a.nhr.f(this.iYC);
            a.nhr.e(this.iYC);
        } else {
            afF();
        }
        if (this.aUP) {
            aQf();
            this.aUP = false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.iYx && this.iYe != null) {
            v.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.iYe.aQq();
        }
    }

    @TargetApi(11)
    public final void X(float f) {
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (com.tencent.mm.compatible.util.d.dW(11)) {
            this.iYo.setAlpha(min);
        } else {
            Animation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.iYo.startAnimation(alphaAnimation);
        }
        v.d("MicroMsg.MainSightContainerView", "set alpha: %f", Float.valueOf(min));
        if (min <= 0.0f) {
            this.iYo.setVisibility(8);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.iYo.startAnimation(alphaAnimation2);
            return;
        }
        this.iYo.setVisibility(0);
    }

    public final void aQg() {
        this.iYl.setVisibility(8);
    }

    public final void fI(boolean z) {
        if (z) {
            this.iYl.setVisibility(0);
            fK(true);
            return;
        }
        aQg();
        fK(tM());
    }

    public final void aQd() {
        this.iYg.setVisibility(0);
        fL(true);
    }

    public final void aQe() {
        this.iYg.setVisibility(4);
        fL(false);
    }

    public final int aQc() {
        int height = getHeight();
        if (height <= 0) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }

    public final boolean aQh() {
        return false;
    }
}
