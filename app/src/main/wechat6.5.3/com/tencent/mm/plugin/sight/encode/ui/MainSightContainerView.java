package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.as.k;
import com.tencent.mm.e.a.hs;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.plugin.sight.encode.a.g;
import com.tencent.mm.plugin.sight.encode.a.h;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public class MainSightContainerView extends RelativeLayout implements OnTouchListener, AnimationListener, OnItemClickListener, a, a {
    private ah dwn;
    private boolean esC;
    private boolean gCX;
    private float gLd;
    public View hgp;
    public SightDraftContainerView iXC;
    public SightCameraView iXG;
    public b iXH;
    public MainContentImageView iXU;
    public boolean iXz;
    public MMFragmentActivity iYA;
    private boolean iYB;
    c iYC;
    public boolean iYD;
    private boolean iYE;
    public View iYF;
    private MediaPlayer iYG;
    private Animation iYH;
    private ac iYI;
    public View iYd;
    private MainSightSelectContactView iYe;
    public h iYf;
    private SightCameraView iYg;
    public boolean iYh;
    public b iYi;
    public View iYj;
    public TextView iYk;
    public View iYl;
    private g iYm;
    public MainSightContainerBottomView iYn;
    public View iYo;
    private final int iYp;
    public int iYq;
    private Dialog iYr;
    private Dialog iYs;
    private Runnable iYt;
    private boolean iYu;
    public boolean iYv;
    private String iYw;
    public boolean iYx;
    private boolean iYy;
    public boolean iYz;

    public MainSightContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iYf = new h();
        this.iXz = false;
        this.gLd = 0.0f;
        this.iYh = false;
        this.iYm = new g();
        this.iYp = 30;
        this.iYq = 0;
        this.iYr = null;
        this.iYs = null;
        this.iYt = new Runnable(this) {
            final /* synthetic */ MainSightContainerView iYJ;

            {
                this.iYJ = r1;
            }

            public final void run() {
                com.tencent.mm.sdk.c.b neVar = new ne();
                neVar.bor.type = 1;
                neVar.bor.bou = this.iYJ.iXG.aPR();
                neVar.bor.bov = com.tencent.mm.a.g.aX(this.iYJ.iXG.aPR());
                neVar.bor.bot = e.aR(neVar.bor.bou);
                com.tencent.mm.sdk.c.a.nhr.z(neVar);
            }
        };
        this.iYu = false;
        this.gCX = false;
        this.iYv = true;
        this.iYw = SQLiteDatabase.KeyEmpty;
        this.iYx = true;
        this.iYy = false;
        this.iYz = false;
        this.iYB = false;
        this.iYC = new c<ne>(this) {
            final /* synthetic */ MainSightContainerView iYJ;

            {
                this.iYJ = r2;
                this.nhz = ne.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                ne neVar = (ne) bVar;
                String str = "MicroMsg.MainSightContainerView";
                String str2 = "on sight send result back[%d], type %d, waitSend %B, waitSave %B, isForSns %B";
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = Integer.valueOf(neVar.bor.type);
                objArr[2] = Boolean.valueOf(this.iYJ.iYr != null);
                objArr[3] = Boolean.valueOf(this.iYJ.iYs != null);
                objArr[4] = Boolean.valueOf(this.iYJ.iYD);
                v.i(str, str2, objArr);
                switch (neVar.bor.type) {
                    case 0:
                        this.iYJ.iYB = false;
                        if (!this.iYJ.iYD) {
                            if (!neVar.bor.bot) {
                                this.iYJ.postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 iYK;

                                    {
                                        this.iYK = r1;
                                    }

                                    public final void run() {
                                        this.iYK.iYJ.aQf();
                                    }
                                }, 500);
                                break;
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0));
                            this.iYJ.fN(false);
                            this.iYJ.q(true, true);
                            break;
                        }
                        if (neVar.bor.bot) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0));
                            this.iYJ.fN(neVar.bor.bow);
                        }
                        this.iYJ.afF();
                        break;
                    case 1:
                        this.iYJ.iYu = true;
                        this.iYJ.iYw = neVar.bor.bov;
                        if (!this.iYJ.iYx) {
                            if (this.iYJ.iYs == null) {
                                if (this.iYJ.iYr == null) {
                                    if (!this.iYJ.iYD) {
                                        k.La().ac(neVar.bor.bou, neVar.bor.bov);
                                        this.iYJ.aQf();
                                        break;
                                    }
                                    k.La().ac(neVar.bor.bou, neVar.bor.bov);
                                    this.iYJ.q(false, false);
                                    break;
                                }
                                this.iYJ.iYr.dismiss();
                                this.iYJ.iYr = null;
                                this.iYJ.aQj();
                                break;
                            }
                            this.iYJ.iYs.dismiss();
                            this.iYJ.iYs = null;
                            this.iYJ.fN(true);
                            break;
                        }
                        v.w("MicroMsg.MainSightContainerView", "view has dismiss, dothing");
                        break;
                    case 2:
                        if (this.iYJ.iYu) {
                            neVar.bos.box = this.iYJ.iXG.aPR();
                            neVar.bos.bov = this.iYJ.iYw;
                            break;
                        }
                        break;
                }
                return false;
            }
        };
        this.iYD = false;
        this.iYE = false;
        this.esC = false;
        this.iYI = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ MainSightContainerView iYJ;

            public final void handleMessage(Message message) {
                v.i("MicroMsg.MainSightContainerView", "on animation callback type %d", Integer.valueOf(message.what));
                if (this.iYJ.iYi != null) {
                    if (message.what != 1) {
                        int i = message.what;
                    }
                    this.iYJ.iXU.clearAnimation();
                    this.iYJ.iXU.setVisibility(4);
                }
            }
        };
    }

    public MainSightContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void aPY() {
        if (!d.aOR()) {
            removeView(this.iXG);
            this.iXH.b(this.iXG);
            this.iXG = new SightCameraSurfaceView(this.iYA);
        } else if (this.iXG == null) {
            this.iXG = new SightCameraTextureView(this.iYA);
        } else {
            return;
        }
        this.iXG.setId(2131758008);
        addView(this.iXG, 1, new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(this.iYA, 240)));
        this.iXG.pL(com.tencent.mm.pluginsdk.n.a.lFo);
        this.iXG.a(this.iXH);
        this.iXG.a((a) this);
        this.iXG.Z(1.3333334f);
        if (d.aOR()) {
            this.iYg = (SightCameraView) ((ViewStub) findViewById(2131758007)).inflate();
            this.iYg.pL(com.tencent.mm.pluginsdk.n.a.lFo);
            this.iYg.Y(1.3333334f);
            this.iYg.setVisibility(0);
            return;
        }
        this.iYg = this.iXG;
    }

    public final void afF() {
        com.tencent.mm.sdk.c.a.nhr.f(this.iYC);
    }

    private void aPZ() {
        v.i("MicroMsg.MainSightContainerView", "ashutest::cancel record");
        this.iXG.aPZ();
        this.iYj.setEnabled(true);
    }

    private void oT() {
        v.i("MicroMsg.MainSightContainerView", "stop record: is finishRecord %B, is for Sns %B, SNS short video duration is %d", Boolean.valueOf(this.iXz), Boolean.valueOf(this.iYD), Integer.valueOf(this.iXG.getDuration()));
        if (!this.iXz) {
            v.d("MicroMsg.MainSightContainerView", "sight camera view try stop");
            this.iXG.oT();
            if (this.iYD) {
                fM(true);
            } else {
                this.iYF.setVisibility(4);
                aQf();
                if (this.iYe == null) {
                    this.iYe = (MainSightSelectContactView) findViewById(2131758003);
                    MainSightSelectContactView mainSightSelectContactView = this.iYe;
                    MMFragmentActivity mMFragmentActivity = this.iYA;
                    int height = this.iYn.getHeight();
                    getHeight();
                    mainSightSelectContactView.a(mMFragmentActivity, height, this, this);
                    this.iYe.bZ(findViewById(2131756534));
                    this.iYe.iZn = findViewById(2131758001);
                    this.iYe.iZo = this;
                }
                this.iXG.post(new Runnable(this) {
                    final /* synthetic */ MainSightContainerView iYJ;

                    {
                        this.iYJ = r1;
                    }

                    public final void run() {
                        this.iYJ.iYA.getWindow().setFlags(1024, 1024);
                        this.iYJ.iYA.cU().cV().hide();
                    }
                });
                fL(true);
                this.iXG.postDelayed(new Runnable(this) {
                    final /* synthetic */ MainSightContainerView iYJ;

                    {
                        this.iYJ = r1;
                    }

                    public final void run() {
                        this.iYJ.iYe.show();
                    }
                }, 50);
            }
        }
        this.iXz = true;
        this.iYj.setEnabled(true);
    }

    public final void aQf() {
        boolean z = true;
        if (this.iYu) {
            v.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, muxDone %B, mute %B, playing %B", this.iXG.aPR(), Boolean.valueOf(this.iYu), Boolean.valueOf(this.iYv), Boolean.valueOf(this.gCX));
            if (d.aOR()) {
                if (!this.iYg.isPlaying()) {
                    this.iYv = true;
                }
            } else if (!this.iXG.isPlaying()) {
                this.iYv = true;
            }
            boolean z2 = this.iYv;
            if (d.aOR()) {
                if (this.iYg.getVisibility() != 0) {
                    this.iYg.setVisibility(0);
                    this.iYg.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968622));
                }
                this.iYg.ah(this.iXG.aPR(), z2);
                if (this.iXG.getVisibility() == 0) {
                    this.iXG.setVisibility(8);
                    this.iXG.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968623));
                    aLn();
                }
            } else {
                this.iXG.Y(1.3333334f);
                this.iXG.ah(this.iXG.aPR(), z2);
            }
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
    }

    public final boolean tM() {
        return !this.iYv;
    }

    private void fK(boolean z) {
        if (this.iYg != null) {
            this.iYg.fK(z);
        }
    }

    private void aLn() {
        v.i("MicroMsg.MainSightContainerView", "hide recoder view, last time show %B", Boolean.valueOf(this.iYh));
        this.iYh = false;
        this.iXG.aLn();
    }

    public final void q(boolean z, boolean z2) {
        if (!this.iYx) {
            this.iYx = true;
            be.cw(this);
            if (d.aOR()) {
                this.iXG.setVisibility(0);
                this.iYg.setVisibility(8);
            } else {
                removeView(this.iXG);
                this.iXH.b(this.iXG);
            }
            this.iXC.clearCache();
            this.iYz = false;
            this.gCX = false;
            this.iYv = true;
            this.iXG.post(new Runnable(this) {
                final /* synthetic */ MainSightContainerView iYJ;

                {
                    this.iYJ = r1;
                }

                public final void run() {
                    this.iYJ.iYA.cU().cV().show();
                    this.iYJ.iYA.getWindow().clearFlags(1024);
                }
            });
            v.d("MicroMsg.MainSightContainerView", "dismiss sight view");
            this.iYB = false;
            aLn();
            this.iYg.aQz();
            if (this.iYi != null) {
                this.iYi.fJ(z);
            }
            if (this.iYe != null) {
                this.iYe.dismiss();
            }
            X(0.85f);
            aQg();
            fL(false);
            this.iYd.clearAnimation();
            this.iYd.setVisibility(8);
            this.iXz = false;
            this.iYw = SQLiteDatabase.KeyEmpty;
            if (z) {
                this.iYH = new TranslateAnimation(0.0f, 0.0f, this.iXU.getTop() != 0 ? (float) this.iXU.getTop() : (float) getBottom(), 0.0f);
                this.iYH.setDuration(300);
                this.iYH.setAnimationListener(this);
                this.iYI.sendEmptyMessageDelayed(0, 350);
                this.iXU.setVisibility(0);
                this.iXU.layout(getLeft(), 0, getRight(), getBottom());
                this.iXU.startAnimation(this.iYH);
            }
            if (z2) {
                afF();
            }
            if (VERSION.SDK_INT >= 21) {
                this.iYA.getWindow().setStatusBarColor(getResources().getColor(2131690051));
            }
        }
    }

    public final void fL(boolean z) {
        if (this.iYy != z) {
            this.iYy = z;
            if (!z) {
                this.iYj.setVisibility(8);
                this.hgp.setVisibility(8);
                this.iYk.setVisibility(8);
            } else if (this.iYj.getVisibility() != 0) {
                this.iXG.postDelayed(new Runnable(this) {
                    final /* synthetic */ MainSightContainerView iYJ;

                    {
                        this.iYJ = r1;
                    }

                    public final void run() {
                        if (!this.iYJ.iYy || (this.iYJ.iYe != null && this.iYJ.iYe.iZl.aQl())) {
                            this.iYJ.iYy = false;
                            return;
                        }
                        this.iYJ.iYj.setVisibility(0);
                        if (this.iYJ.iYe != null && !this.iYJ.iYe.aQt() && this.iYJ.hgp.getVisibility() != 0) {
                            this.iYJ.hgp.setVisibility(0);
                            this.iYJ.hgp.startAnimation(AnimationUtils.loadAnimation(this.iYJ.iYA, 2130968622));
                            this.iYJ.iYk.setText(2131235311);
                            this.iYJ.iYk.setVisibility(0);
                            this.iYJ.iYk.startAnimation(AnimationUtils.loadAnimation(this.iYJ.iYA, 2130968622));
                        }
                    }
                }, 100);
            }
        }
    }

    public final void aQb() {
        if (!this.iYx) {
            v.i("MicroMsg.MainSightContainerView", "readyCamera");
            if (this.iYd != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ MainSightContainerView iYJ;

                    {
                        this.iYJ = r1;
                    }

                    public final void run() {
                        this.iYJ.X(0.0f);
                        this.iYJ.iYd.clearAnimation();
                        this.iYJ.iYd.setVisibility(8);
                        this.iYJ.iYz = true;
                    }
                });
            } else {
                X(0.0f);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i - 1;
        if (MainSightSelectContactView.pJ(i2) && this.gCX) {
            aQf();
        } else if (this.iYe.pI(i2)) {
            this.iYe.iZl.aQm();
        } else if (this.iYe.pH(i2)) {
            if (c.iYV) {
                fM(false);
            }
        } else if (!c.zI(this.iYe.fo(i2))) {
            v.d("MicroMsg.MainSightContainerView", "on item click Item : %d", Integer.valueOf(i2));
            this.iYe.pG(i2);
            this.iYe.notifyDataSetChanged();
            if (!tM() && this.iYu) {
                aQf();
            } else if (this.iYe.aQt()) {
                if (this.hgp.getVisibility() == 0) {
                    this.hgp.setVisibility(8);
                    this.hgp.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968623));
                    this.iYk.setVisibility(8);
                    this.iYk.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968623));
                }
            } else if (this.hgp.getVisibility() != 0) {
                this.hgp.setVisibility(0);
                this.hgp.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968622));
                this.iYk.setText(2131235311);
                this.iYk.setVisibility(0);
                this.iYk.startAnimation(AnimationUtils.loadAnimation(this.iYA, 2130968622));
            }
            if (this.iYe.iZl.aQl() && this.iYe.pK(i2)) {
                this.iYe.iZl.aQm();
            }
        } else if (!c.iYW) {
            fN(true);
        }
    }

    private void fM(boolean z) {
        String aPR = this.iXG.aPR();
        this.iYB = true;
        this.iYg.aQz();
        if (this.iYE) {
            com.tencent.mm.sdk.c.b hsVar = new hs();
            hsVar.bhC.imagePath = d.zz(aPR);
            hsVar.bhC.bhD = aPR;
            com.tencent.mm.sdk.c.a.nhr.z(hsVar);
        } else {
            Context context = this.iYA;
            String zz = d.zz(aPR);
            if (!this.iYu) {
                aPR = SQLiteDatabase.KeyEmpty;
            }
            g.a(context, zz, aPR, this.iYw, z, this.iYq);
        }
        if (this.iYD) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(3), Integer.valueOf(3));
            return;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(1), Integer.valueOf(3));
    }

    public final void fN(final boolean z) {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do save to draft, muxDone %B, loadingDialog null %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.iYu);
        objArr[1] = Boolean.valueOf(this.iYs == null);
        v.i(str, str2, objArr);
        if (this.iYu) {
            final String aPR = this.iXG.aPR();
            str = d.zz(aPR);
            int duration = this.iXG.getDuration();
            if (!be.kS(aPR)) {
                k.La().a(aPR, str, this.iYw, duration, new com.tencent.mm.as.g.a(this) {
                    final /* synthetic */ MainSightContainerView iYJ;

                    public final void gu(int i) {
                        com.tencent.mm.loader.stub.b.deleteFile(aPR);
                        com.tencent.mm.loader.stub.b.deleteFile(str);
                        if (z) {
                            switch (i) {
                                case 0:
                                    com.tencent.mm.ui.base.g.bf(this.iYJ.getContext(), this.iYJ.getContext().getString(2131235345));
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                q(true, true);
            }
        } else if (this.iYs == null) {
            this.iYs = com.tencent.mm.ui.base.g.a(getContext(), getResources().getString(2131235341), false, null);
        }
    }

    public final void aQj() {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, muxDone %B, loadingDialog null %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.iYu);
        objArr[1] = Boolean.valueOf(this.iYr == null);
        v.i(str, str2, objArr);
        if (this.iYu) {
            str = this.iXG.aPR();
            str2 = d.zz(str);
            int duration = this.iXG.getDuration();
            if (!be.kS(str) && !this.iYe.aQt()) {
                final String str3;
                k.La().a(str, str2, this.iYw, duration, null);
                final List<String> aQs = this.iYe.aQs();
                com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(aQs.size()));
                g.a anonymousClass6 = new g.a(this) {
                    final /* synthetic */ MainSightContainerView iYJ;

                    public final void onError(int i) {
                        if (aQs.size() <= 1 || -1 == i) {
                            com.tencent.mm.ui.base.g.bf(this.iYJ.getContext(), this.iYJ.getContext().getString(2131234920));
                        }
                    }
                };
                if (aQs.size() == 1) {
                    this.iYm.a(str, duration, this.iYw, (String) aQs.get(0), anonymousClass6);
                } else {
                    this.iYm.a(str, duration, this.iYw, (List) aQs, anonymousClass6);
                }
                if (this.iYe.aQs().size() <= 1 && this.iYi != null) {
                    str3 = (String) this.iYe.aQs().get(0);
                    postDelayed(new Runnable(this) {
                        final /* synthetic */ MainSightContainerView iYJ;

                        public final void run() {
                            this.iYJ.iYi.zF(str3);
                        }
                    }, 300);
                }
                if (this.iYA != null) {
                    try {
                        AssetFileDescriptor openFd = this.iYA.getAssets().openFd("sight_send_song.wav");
                        this.iYG = new MediaPlayer();
                        this.iYG.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        this.iYG.setOnCompletionListener(new OnCompletionListener(this) {
                            final /* synthetic */ MainSightContainerView iYJ;

                            {
                                this.iYJ = r1;
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
                q(true, true);
                for (String str32 : aQs) {
                    if (str32.toLowerCase().endsWith("@chatroom")) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(1), Integer.valueOf(2));
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.h(11442, Integer.valueOf(1), Integer.valueOf(1));
                    }
                }
            }
        } else if (this.iYr == null) {
            this.iYr = com.tencent.mm.ui.base.g.a(getContext(), getResources().getString(2131235341), false, null);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iXU == null || !this.iXU.iXS || i2 != 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && !this.iYx && this.iYe != null) {
                v.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                this.iYe.aQq();
            }
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

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.iYz) {
            if (!this.iXz && !this.iXG.aQF()) {
                this.iXG.fP(false);
                switch (motionEvent.getAction()) {
                    case 0:
                        this.esC = false;
                        this.gLd = motionEvent.getY();
                        v.v("MicroMsg.MainSightContainerView", "ashutest::action down, status %s", this.iXG.aQA());
                        if (this.iXG.aQD()) {
                            if (this.dwn == null) {
                                this.dwn = new ah(new ah.a(this) {
                                    final /* synthetic */ MainSightContainerView iYJ;

                                    {
                                        this.iYJ = r1;
                                    }

                                    public final boolean oU() {
                                        int i;
                                        v.i("MicroMsg.MainSightContainerView", "ashutest::start record");
                                        MainSightContainerView mainSightContainerView = this.iYJ;
                                        com.tencent.mm.sdk.c.a.nhr.f(mainSightContainerView.iYC);
                                        com.tencent.mm.sdk.c.a.nhr.e(mainSightContainerView.iYC);
                                        this.iYJ.iYu = false;
                                        this.iYJ.iXG.u(this.iYJ.iYt);
                                        this.iYJ.iXG.auD();
                                        if (this.iYJ.iYD) {
                                            i = 3;
                                        } else {
                                            i = 1;
                                        }
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11443, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0));
                                        return false;
                                    }
                                }, false);
                            }
                            this.dwn.ea(30);
                            this.iYj.setEnabled(false);
                            break;
                        }
                        break;
                    case 1:
                    case 6:
                        v.i("MicroMsg.MainSightContainerView", "ashutest::action up, y delta %f, isTooShort %B, status %s", Float.valueOf(this.gLd - motionEvent.getY()), Boolean.valueOf(this.iXG.aQB()), this.iXG.aQA());
                        this.esC = true;
                        if (this.dwn != null) {
                            this.dwn.QI();
                        }
                        if (this.iXG.aQE()) {
                            aPZ();
                        } else if (!this.iXG.pq()) {
                            aPZ();
                        } else if (this.gLd - motionEvent.getY() > 150.0f) {
                            aPZ();
                        } else if (this.iXG.aQB()) {
                            com.tencent.mm.ui.base.g.bf(getContext(), getContext().getResources().getString(2131235350));
                            aPZ();
                        } else if (this.iXG.aQC()) {
                            com.tencent.mm.ui.base.g.bf(getContext(), getContext().getResources().getString(2131235342));
                            aPZ();
                        } else {
                            oT();
                        }
                        this.iYf.hide();
                        break;
                    case 2:
                        if (!this.esC) {
                            if (this.gLd - motionEvent.getY() <= 150.0f) {
                                this.iXG.fP(false);
                                this.iYf.aPV();
                                break;
                            }
                            this.iXG.fP(true);
                            this.iYf.aPW();
                            break;
                        }
                        break;
                    case 3:
                        this.esC = true;
                        if (this.dwn != null) {
                            this.dwn.QI();
                        }
                        if (!this.iXG.pq()) {
                            aPZ();
                            break;
                        }
                        aPZ();
                        this.iYf.hide();
                        break;
                    default:
                        break;
                }
            } else if (!this.iXz) {
                if (this.gLd - motionEvent.getY() > 150.0f) {
                    aPZ();
                } else {
                    v.i("MicroMsg.MainSightContainerView", "full stop");
                    oT();
                }
                this.iYf.hide();
            }
        }
        return true;
    }

    public final void aQd() {
        if (d.aOR()) {
            this.iYg.setVisibility(0);
        } else {
            this.iXG.setVisibility(0);
        }
        fL(true);
    }

    public final void aQe() {
        if (d.aOR()) {
            this.iYg.setVisibility(4);
        } else {
            this.iXG.setVisibility(4);
        }
        fL(false);
    }

    public void onAnimationStart(Animation animation) {
        v.d("MicroMsg.MainSightContainerView", "on animation start %s", animation);
    }

    public void onAnimationEnd(Animation animation) {
        v.d("MicroMsg.MainSightContainerView", "on animation end %s", animation);
    }

    public void onAnimationRepeat(Animation animation) {
        v.d("MicroMsg.MainSightContainerView", "on animation repeat %s", animation);
    }

    public final int aQc() {
        return getHeight();
    }

    public final boolean aQh() {
        return true;
    }
}
