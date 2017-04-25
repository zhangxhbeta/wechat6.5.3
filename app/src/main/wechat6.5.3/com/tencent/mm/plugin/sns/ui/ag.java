package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.f;
import com.tencent.mm.as.g;
import com.tencent.mm.as.k;
import com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView;
import com.tencent.mm.plugin.sight.draft.ui.b.d;
import com.tencent.mm.plugin.sight.encode.a.e;
import com.tencent.mm.plugin.sight.encode.ui.MainContentImageView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightContainerBottomView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightContainerView.1;
import com.tencent.mm.plugin.sight.encode.ui.MainSightContainerView.10;
import com.tencent.mm.plugin.sight.encode.ui.MainSightContainerView.11;
import com.tencent.mm.plugin.sight.encode.ui.MainSightContainerView.17;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.plugin.sight.main.ui.MainSightIconView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class ag {
    MMActivity eLn;
    private ViewGroup fqb;
    private com.tencent.mm.plugin.sight.draft.ui.a iWb = new com.tencent.mm.plugin.sight.draft.ui.a(this) {
        final /* synthetic */ ag jJO;

        {
            this.jJO = r1;
        }

        public final void a(f fVar) {
            this.jJO.iXC.aPI();
            Intent intent = new Intent(this.jJO.eLn, SightUploadUI.class);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", be.Nh());
            intent.putExtra("KSightPath", g.kV(fVar.field_fileName));
            intent.putExtra("KSightThumbPath", g.kW(fVar.field_fileName));
            intent.putExtra("sight_md5", fVar.field_fileMd5);
            intent.putExtra("KSightDraftEntrance", false);
            intent.putExtra("Ksnsupload_source", this.jJO.jJL);
            this.jJO.eLn.startActivityForResult(intent, 5985);
        }

        public final void a(d dVar) {
            if (d.iWk == dVar) {
                this.jJO.jJJ.setText(2131235331);
                this.jJO.jJJ.setVisibility(0);
                this.jJO.jJI.setTag(Boolean.valueOf(false));
            } else {
                this.jJO.jJJ.setText(2131235332);
                this.jJO.jJJ.setVisibility(4);
                this.jJO.jJI.setTag(Boolean.valueOf(true));
            }
            k.KX().KP();
        }
    };
    SightDraftContainerView iXC;
    MainSightContainerView jJC;
    MainSightIconView jJD;
    ViewGroup jJE;
    TransitionDrawable jJF;
    boolean jJG;
    private boolean jJH;
    ImageView jJI;
    TextView jJJ;
    a jJK;
    int jJL;
    private TranslateAnimation jJM;
    private TranslateAnimation jJN;

    public interface a {
        void amF();
    }

    public ag(ViewGroup viewGroup, ViewGroup viewGroup2, MMActivity mMActivity, a aVar) {
        this.eLn = mMActivity;
        this.fqb = viewGroup;
        this.jJE = viewGroup2;
        this.jJK = aVar;
        this.jJF = (TransitionDrawable) this.eLn.getResources().getDrawable(2130839237);
        if (this.jJC == null) {
            this.jJC = (MainSightContainerView) LayoutInflater.from(this.eLn).inflate(2130903920, this.fqb, false);
            this.jJD = (MainSightIconView) this.jJC.findViewById(2131758012);
            this.jJD.kO(this.fqb.getTop());
            MainSightIconView mainSightIconView = this.jJD;
            mainSightIconView.jaq = (int) (((float) mainSightIconView.jap) * 1.0f);
            if (VERSION.SDK_INT >= 11) {
                mainSightIconView.setAlpha(1.0f);
            }
            mainSightIconView.invalidate();
            this.jJC.iYd = this.jJD;
            this.jJC.iYi = new b(this) {
                final /* synthetic */ ag jJO;

                {
                    this.jJO = r1;
                }

                public final void zF(String str) {
                }

                public final void fJ(boolean z) {
                    v.i("MicroMsg.SendSightHelper", "on dissmiss callback, isNeedAnimation %B mIsSightViewShow %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.jJO.jJG)});
                    if (this.jJO.jJG) {
                        this.jJO.gq(true);
                        if (this.jJO.jJK != null) {
                            this.jJO.jJK.amF();
                        }
                    }
                }
            };
            this.fqb.addView(this.jJC, 0);
            MainSightContainerView mainSightContainerView = this.jJC;
            MMActivity mMActivity2 = this.eLn;
            mainSightContainerView.iYA = mMActivity2;
            long currentTimeMillis = System.currentTimeMillis();
            mainSightContainerView.iXH = new e();
            mainSightContainerView.aPY();
            mainSightContainerView.iYo = mainSightContainerView.findViewById(2131758000);
            mainSightContainerView.iYl = mainSightContainerView.findViewById(2131758004);
            mainSightContainerView.iYl.setLayoutParams(new LayoutParams(-1, mMActivity2.cU().cV().getHeight()));
            mainSightContainerView.iYn = (MainSightContainerBottomView) mainSightContainerView.findViewById(2131758009);
            mainSightContainerView.iXU = (MainContentImageView) mainSightContainerView.findViewById(2131758014);
            MainSightContainerBottomView mainSightContainerBottomView = mainSightContainerView.iYn;
            mainSightContainerBottomView.iXU = mainSightContainerView.iXU;
            mainSightContainerBottomView.iXU.iXT = mainSightContainerBottomView;
            mainSightContainerView.iYn.iXY = mainSightContainerView;
            mainSightContainerView.iYf.e(mainSightContainerView);
            mainSightContainerView.iYj = mainSightContainerView.findViewById(2131758005);
            mainSightContainerView.iYk = (TextView) mainSightContainerView.findViewById(2131758013);
            mainSightContainerView.hgp = mainSightContainerView.findViewById(2131758006);
            mainSightContainerView.iXC = (SightDraftContainerView) mainSightContainerView.findViewById(2131756313);
            mainSightContainerView.iYj.setOnClickListener(new 1(mainSightContainerView));
            mainSightContainerView.hgp.setOnClickListener(new 10(mainSightContainerView));
            if (u.bsU()) {
                mainSightContainerView.iYF = mainSightContainerView.findViewById(2131758010);
                mainSightContainerView.findViewById(2131758011).setVisibility(8);
            } else {
                mainSightContainerView.findViewById(2131758010).setVisibility(8);
                mainSightContainerView.iYF = mainSightContainerView.findViewById(2131758011);
            }
            mainSightContainerView.iYF.setOnTouchListener(mainSightContainerView);
            mainSightContainerView.aQg();
            v.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.jJC.iYD = true;
            this.jJC.iYq = this.jJL;
            this.jJC.setVisibility(8);
        }
        this.eLn.cU().cV().setBackgroundDrawable(this.jJF);
        this.jJM = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.jJM.setDuration(230);
        this.jJM.setRepeatCount(0);
        this.jJM.setInterpolator(new DecelerateInterpolator(DownloadHelper.SAVE_FATOR));
        this.jJM.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ag jJO;

            {
                this.jJO = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jJO.jJF.startTransition(350);
                MainSightIconView mainSightIconView = this.jJO.jJD;
                MainSightContainerView mainSightContainerView = this.jJO.jJC;
                mainSightIconView.jau = (mainSightContainerView.iXG == null ? 0 : mainSightContainerView.iXG.getHeight()) / 2;
                mainSightIconView.jav = 230;
                v.i("MicroMsg.MainSightIconView", "setEnd %s %s", new Object[]{Integer.valueOf(r0), Integer.valueOf(230)});
                MainSightIconView mainSightIconView2 = this.jJO.jJD;
                mainSightIconView2.jaw = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ((mainSightIconView2.jau - mainSightIconView2.getTop()) - (mainSightIconView2.getHeight() / 2)));
                mainSightIconView2.jaw.setFillAfter(true);
                mainSightIconView2.jaw.setDuration((long) mainSightIconView2.jav);
                mainSightIconView2.jaw.setAnimationListener(new AnimationListener(mainSightIconView2) {
                    final /* synthetic */ MainSightIconView jax;

                    {
                        this.jax = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                    }
                });
                mainSightIconView2.startAnimation(mainSightIconView2.jaw);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.jJO.jJE.setVisibility(8);
            }
        });
        this.jJN = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.jJN.setDuration(230);
        this.jJN.setRepeatCount(0);
        this.jJN.setInterpolator(new DecelerateInterpolator(1.0f));
        this.jJN.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ag jJO;

            {
                this.jJO = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jJO.jJF.reverseTransition(350);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.jJO.jJE.setVisibility(0);
            }
        });
    }

    private void gp(boolean z) {
        SwipeBackLayout swipeBackLayout = this.eLn.nFw;
        if (swipeBackLayout != null) {
            swipeBackLayout.hVC = z;
        }
    }

    public final void aWm() {
        String str = null;
        int Ed = com.tencent.mm.modelcontrol.b.Ed();
        if (this.jJC != null) {
            MainSightContainerView mainSightContainerView = this.jJC;
            if (mainSightContainerView.iXG != null) {
                mainSightContainerView.iXG.pM(Ed);
            }
        }
        gp(false);
        this.jJC.setVisibility(0);
        if (k.KX().KN() > 0) {
            MainSightContainerView mainSightContainerView2 = this.jJC;
            mainSightContainerView2.iXC.a(this.iWb);
            mainSightContainerView2.iXC.setVisibility(0);
            mainSightContainerView2.iXC.aPH();
            mainSightContainerView2.iXC.aPG();
            SightDraftContainerView sightDraftContainerView = mainSightContainerView2.iXC;
            if (sightDraftContainerView.iWs != null) {
                sightDraftContainerView.iWs.iWc = 2131235336;
            }
            this.iXC = mainSightContainerView2.iXC;
            this.eLn.cU().cV().setCustomView(q.em(this.eLn).inflate(2130904398, null));
            View customView = this.eLn.cU().cV().getCustomView();
            this.jJI = (ImageView) customView.findViewById(2131756310);
            this.jJI.setTag(Boolean.valueOf(true));
            this.jJI.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ag jJO;

                {
                    this.jJO = r1;
                }

                public final void onClick(View view) {
                    v.w("MicroMsg.SendSightHelper", "on click is quit ? %B", new Object[]{Boolean.valueOf(((Boolean) view.getTag()).booleanValue())});
                    if (((Boolean) view.getTag()).booleanValue()) {
                        this.jJO.gq(true);
                        if (this.jJO.jJK != null) {
                            this.jJO.jJK.amF();
                            return;
                        }
                        return;
                    }
                    this.jJO.iXC.fG(false);
                }
            });
            this.jJJ = (TextView) customView.findViewById(2131756312);
            this.jJJ.setVisibility(4);
            this.jJJ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ag jJO;

                {
                    this.jJO = r1;
                }

                public final void onClick(View view) {
                    this.jJO.iXC.aPK();
                }
            });
            this.jJH = true;
        } else {
            MainSightContainerView mainSightContainerView3 = this.jJC;
            v.i("MicroMsg.MainSightContainerView", "show recorder view, last time show %B", new Object[]{Boolean.valueOf(mainSightContainerView3.iYh)});
            if (!mainSightContainerView3.iYh) {
                mainSightContainerView3.aPY();
                mainSightContainerView3.iYx = false;
                mainSightContainerView3.iYz = false;
                boolean se = com.tencent.mm.compatible.e.b.se();
                boolean sf = com.tencent.mm.compatible.e.b.sf();
                if (sf && se) {
                    se = true;
                } else {
                    String string;
                    v.e("MicroMsg.MainSightContainerView", "no permission video : %s audio %s", new Object[]{Boolean.valueOf(sf), Boolean.valueOf(se)});
                    if (!se && !sf) {
                        string = mainSightContainerView3.getContext().getString(2131231159);
                        str = mainSightContainerView3.getContext().getString(2131231097);
                    } else if (!se) {
                        string = mainSightContainerView3.getContext().getString(2131231161);
                        str = mainSightContainerView3.getContext().getString(2131231098);
                    } else if (sf) {
                        string = null;
                    } else {
                        string = mainSightContainerView3.getContext().getString(2131231160);
                        str = mainSightContainerView3.getContext().getString(2131231099);
                    }
                    com.tencent.mm.ui.base.g.a(mainSightContainerView3.getContext(), string, str, mainSightContainerView3.getContext().getString(2131231100), true, new 11(mainSightContainerView3));
                    se = false;
                }
                if (se) {
                    mainSightContainerView3.iYh = true;
                    mainSightContainerView3.iXz = false;
                    mainSightContainerView3.iYv = true;
                    mainSightContainerView3.iYF.setVisibility(0);
                    mainSightContainerView3.iXG.aQw();
                    mainSightContainerView3.iYf.aPU();
                    mainSightContainerView3.fL(false);
                    Ed = mainSightContainerView3.iYD ? 3 : 1;
                    com.tencent.mm.plugin.report.service.g.iuh.h(11443, new Object[]{Integer.valueOf(Ed), Integer.valueOf(1), Integer.valueOf(0)});
                } else {
                    v.e("MicroMsg.MainSightContainerView", "no permission");
                    mainSightContainerView3.post(new 17(mainSightContainerView3));
                }
            }
            this.jJH = false;
        }
        this.jJG = true;
        this.jJD.kO(this.fqb.getTop());
        this.jJE.startAnimation(this.jJM);
    }

    public final boolean gq(boolean z) {
        if (this.jJH && this.iXC != null && this.iXC.fG(z)) {
            return true;
        }
        if (this.iXC != null) {
            this.iXC.clearCache();
            this.iXC.setVisibility(8);
        }
        this.jJG = false;
        this.jJC.q(false, true);
        this.jJC.setVisibility(8);
        gp(true);
        this.jJE.startAnimation(this.jJN);
        return false;
    }

    public final boolean aWn() {
        if (!this.jJH || this.iXC == null) {
            if (this.jJG) {
                this.jJM.cancel();
                this.jJN.cancel();
                this.jJE.setVisibility(0);
                this.jJC.setVisibility(8);
                this.jJF.reverseTransition(0);
                this.jJG = false;
                gp(true);
            }
            return true;
        }
        this.iXC.aPI();
        return false;
    }

    public final void clean() {
        if (this.jJC != null) {
            this.jJC.afF();
        }
    }
}
