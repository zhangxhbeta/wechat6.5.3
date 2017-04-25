package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.e.a.pf;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.c.d;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import junit.framework.Assert;

@a(19)
public class RadarSearchUI extends MMBaseActivity {
    private RadarViewController ijp = null;
    private boolean ijq = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView(2130904219);
        this.ijp = (RadarViewController) findViewById(2131758747);
        RadarViewController radarViewController = this.ijp;
        RelativeLayout relativeLayout = (RelativeLayout) radarViewController.findViewById(2131758751);
        LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) radarViewController.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams);
        radarViewController.ikm = (RadarTipsView) radarViewController.findViewById(2131758758);
        RadarTipsView radarTipsView = radarViewController.ikm;
        Context context = radarTipsView.getContext();
        if (radarTipsView.ijN == null) {
            radarTipsView.ijN = AnimationUtils.loadAnimation(context, 2130968653);
        }
        if (radarTipsView.ijO == null) {
            radarTipsView.ijO = AnimationUtils.loadAnimation(context, 2130968654);
            radarTipsView.ijO.setAnimationListener(new AnimationListener(radarTipsView) {
                final /* synthetic */ RadarTipsView iki;

                {
                    this.iki = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (!this.iki.ijY) {
                        this.iki.ijM.sendEmptyMessage(0);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        radarTipsView.ijP = (TextView) radarTipsView.findViewById(2131758745);
        radarTipsView.ijQ = radarTipsView.findViewById(2131758744);
        radarTipsView.ijR = (LinearLayout) radarTipsView.findViewById(2131758746);
        radarTipsView.ijR.setOnClickListener(new OnClickListener(radarTipsView) {
            final /* synthetic */ RadarTipsView iki;

            {
                this.iki = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.RadarTipsView", "noviceEducationTips onclick");
                this.iki.aIW();
            }
        });
        RadarTipsView radarTipsView2 = radarViewController.ikm;
        radarTipsView2.ikh = 1;
        radarTipsView2.ijX.sendEmptyMessageDelayed(2, 1000);
        radarTipsView2.ijX.sendEmptyMessageDelayed(1, 9000);
        radarTipsView2 = radarViewController.ikm;
        if (radarTipsView2.ikd != 0) {
            radarTipsView2.ikh = 0;
            radarTipsView2.aIY();
            radarTipsView2.aIX();
            radarTipsView2.ijQ.setVisibility(8);
            radarTipsView2.ijR.setVisibility(8);
            radarTipsView2.setVisibility(8);
        }
        radarTipsView2.ikb = true;
        radarTipsView2.ikd = be.Nj();
        radarTipsView2.ike = true;
        radarTipsView2.ikc++;
        radarViewController.iko = (TextView) radarViewController.findViewById(2131758754);
        radarViewController.ikp = (ProgressBar) radarViewController.findViewById(2131758753);
        radarViewController.ikq = (Button) radarViewController.findViewById(2131758757);
        radarViewController.ikq.setOnClickListener(radarViewController.iky);
        radarViewController.ikr = radarViewController.findViewById(2131758748);
        radarViewController.ikj = (RadarWaveView) ((Activity) radarViewController.getContext()).findViewById(2131758749);
        RadarWaveView radarWaveView = radarViewController.ikj;
        radarWaveView.ikY = radarWaveView.findViewById(2131758750);
        radarWaveView.ikZ = AnimationUtils.loadAnimation(radarWaveView.getContext(), 2130968656);
        radarWaveView.ikZ.setInterpolator(new LinearInterpolator());
        b.a.m((ImageView) radarViewController.findViewById(2131758755), k.xF());
        radarViewController.ikk = (RadarMemberView) radarViewController.findViewById(2131758726);
        radarViewController.ikk.ijg = new RadarMemberView.a(radarViewController) {
            final /* synthetic */ RadarViewController ikC;

            {
                this.ikC = r1;
            }

            public final void b(apa com_tencent_mm_protocal_c_apa, d dVar) {
                String b = c.b(com_tencent_mm_protocal_c_apa);
                switch (dVar) {
                    case Stranger:
                        this.ikC.iks.aIK().put(Long.valueOf(this.ikC.ikt.yp(b)), new com.tencent.mm.plugin.radar.a.e.b(com_tencent_mm_protocal_c_apa, dVar));
                        this.ikC.d(b, d.Verifying);
                        return;
                    case NeedVerify:
                        long j;
                        com.tencent.mm.plugin.radar.a.c e = this.ikC.ikt;
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(b);
                        String str = be.ma(LX.field_username).equals("") ? b : LX.field_username;
                        String str2 = (String) e.ihL.get(str);
                        if (str2 == null || str2.equals("")) {
                            v.e("MicroMsg.RadarAddContact", "Verify Contact username(%s) error, verifyTicket is null", new Object[]{str});
                            e.yp(str);
                            j = -1;
                        } else {
                            at.d MB = at.d.MB(str2);
                            long currentTimeMillis = System.currentTimeMillis();
                            a aVar = new a(e, new com.tencent.mm.plugin.radar.a.c.AnonymousClass4(e, str2, currentTimeMillis));
                            String str3 = MB.hUb;
                            String str4 = "username is null";
                            boolean z = str != null && str.length() > 0;
                            Assert.assertTrue(str4, z);
                            aVar.onStart();
                            ak.vy().a(new m(str, str3, 48), 0);
                            j = currentTimeMillis;
                        }
                        this.ikC.iks.aIK().put(Long.valueOf(j), new com.tencent.mm.plugin.radar.a.e.b(com_tencent_mm_protocal_c_apa, dVar));
                        this.ikC.d(b, d.Verifying);
                        return;
                    default:
                        return;
                }
            }

            public final void c(apa com_tencent_mm_protocal_c_apa, d dVar) {
                View view = (View) this.ikC.iku.ikP.get(c.b(com_tencent_mm_protocal_c_apa));
                if (view != null) {
                    a aVar = (a) view.getTag();
                    if (dVar != d.Stranger) {
                        aVar.ikU.aIU();
                    }
                }
                this.ikC.ikj.aJb();
            }
        };
        radarViewController.ikl = (RadarSpecialGridView) radarViewController.findViewById(2131758756);
        radarViewController.iku = new b(radarViewController, radarViewController.ikl, radarViewController.getContext());
        radarViewController.ikl.a(new RadarSpecialGridView.a(radarViewController) {
            final /* synthetic */ RadarViewController ikC;

            {
                this.ikC = r1;
            }

            public final void e(int i, final View view) {
                final apa com_tencent_mm_protocal_c_apa = this.ikC.iku.ikK[i];
                if (com_tencent_mm_protocal_c_apa != null) {
                    switch (this.ikC.ikv) {
                        case SEARCHING:
                        case SEARCH_RETRUN:
                            String b = c.b(com_tencent_mm_protocal_c_apa);
                            if (!b.d(com_tencent_mm_protocal_c_apa)) {
                                View view2 = (View) this.ikC.iku.ikP.get(b);
                                final d a = this.ikC.iks.a(com_tencent_mm_protocal_c_apa, false);
                                if (view2 == null || a == d.Stranger) {
                                    this.ikC.ikk.a(view, com_tencent_mm_protocal_c_apa, a);
                                    this.ikC.ikj.aJc();
                                    return;
                                }
                                ((a) view2.getTag()).ikU.aIV();
                                new ac().postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 ikE;

                                    public final void run() {
                                        this.ikE.ikC.ikk.a(view, com_tencent_mm_protocal_c_apa, a);
                                        this.ikE.ikC.ikj.aJc();
                                    }
                                }, 300);
                                return;
                            }
                            return;
                        case RALATIONCHAIN_RETRUN:
                            if (!b.d(com_tencent_mm_protocal_c_apa)) {
                                int i2;
                                b b2 = this.ikC.iku;
                                if (b2.ikL == null) {
                                    b2.ikL = new HashMap();
                                }
                                if (com_tencent_mm_protocal_c_apa != null) {
                                    Object b3 = c.b(com_tencent_mm_protocal_c_apa);
                                    if (b2.ikC.iks.aIJ().containsKey(b3)) {
                                        b3 = (String) b2.ikC.iks.aIJ().get(b3);
                                    }
                                    if (b2.ikL.containsKey(b3)) {
                                        i2 = 1;
                                        if (i2 != 0) {
                                            this.ikC.iku.e(com_tencent_mm_protocal_c_apa);
                                        } else {
                                            this.ikC.iku.f(com_tencent_mm_protocal_c_apa);
                                        }
                                    }
                                }
                                boolean z = false;
                                if (i2 != 0) {
                                    this.ikC.iku.f(com_tencent_mm_protocal_c_apa);
                                } else {
                                    this.ikC.iku.e(com_tencent_mm_protocal_c_apa);
                                }
                            }
                            this.ikC.iks.a(com_tencent_mm_protocal_c_apa);
                            this.ikC.aIZ();
                            this.ikC.iku.aIO();
                            return;
                        default:
                            v.d("MicroMsg.Radar.RadarViewController", "unknow status for grid view %s", new Object[]{this.ikC.ikv});
                            return;
                    }
                }
            }
        });
        RadarViewController radarViewController2 = this.ijp;
        c cVar = radarViewController2.ikt;
        ak.yW();
        com.tencent.mm.model.c.wH().a(cVar);
        com.tencent.mm.sdk.c.a.nhr.e(cVar.ihN);
        ak.yU().a("addcontact", cVar.fvh, true);
        e eVar = radarViewController2.iks;
        ak.vy().a(425, eVar);
        ak.vy().a(602, eVar);
        ak.yW();
        int intValue = ((Integer) com.tencent.mm.model.c.vf().get(229377, Integer.valueOf(0))).intValue() + 1;
        ak.yW();
        com.tencent.mm.model.c.vf().set(229377, Integer.valueOf(intValue));
    }

    public void onResume() {
        super.onResume();
        if (this.ijq) {
            v.i("MicroMsg.RadarSearchUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                aIP();
            }
        }
    }

    private void aIP() {
        eY(true);
        com.tencent.mm.plugin.radar.a.d dVar = com.tencent.mm.plugin.radar.a.d.iie;
        dVar.bhN = 0;
        dVar.iii = 0;
        dVar.iii = com.tencent.mm.plugin.radar.a.d.aIF();
        dVar = com.tencent.mm.plugin.radar.a.d.iie;
        dVar.iij = 0;
        dVar.iih = 0;
        dVar.iif = 0;
        dVar.iig = 0;
        dVar.iih = com.tencent.mm.plugin.radar.a.d.aIF();
        if (this.ijp.ikv == e.d.SEARCHING || this.ijp.ikv == e.d.SEARCH_RETRUN) {
            e eVar = this.ijp.iks;
            if (eVar.cCR != null) {
                eVar.cCR.a(eVar.bYl, true);
            }
            this.ijp.iks.aIG();
            this.ijp.ikj.aJb();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.RadarSearchUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aIP();
                    return;
                }
                this.ijq = false;
                g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RadarSearchUI ijr;

                    {
                        this.ijr = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ijr.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.ijr.ijq = true;
                        this.ijr.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RadarSearchUI ijr;

                    {
                        this.ijr = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ijr.ijq = true;
                        this.ijr.finish();
                    }
                });
                return;
            default:
                return;
        }
    }

    public void onPause() {
        long aIF;
        int i;
        super.onPause();
        eY(false);
        com.tencent.mm.plugin.radar.a.d dVar = com.tencent.mm.plugin.radar.a.d.iie;
        if (dVar.iii != 0) {
            boolean z;
            aIF = com.tencent.mm.plugin.radar.a.d.aIF() - dVar.iii;
            if (aIF <= 500) {
                i = 1;
            } else {
                z = false;
            }
            if (i == 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                i = dVar.bhN;
                v.d("MicroMsg.RadarKvStatReport", "FoundFriendsCnt %d", new Object[]{Integer.valueOf(i)});
                com.tencent.mm.plugin.report.service.g.iuh.Y(10679, String.format("%d", new Object[]{Integer.valueOf(i)}));
                dVar.iif++;
                dVar.iig = aIF + dVar.iig;
                dVar.iii = 0;
            }
        }
        com.tencent.mm.plugin.radar.a.d dVar2 = com.tencent.mm.plugin.radar.a.d.iie;
        if (dVar2.iih != 0) {
            aIF = System.currentTimeMillis() - dVar2.iih;
            int i2 = dVar2.iif;
            float f = (((float) dVar2.iig) * 1.0f) / 1000.0f;
            i = dVar2.iij;
            float f2 = (((float) aIF) * 1.0f) / 1000.0f;
            v.d("MicroMsg.RadarKvStatReport", "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2)});
            com.tencent.mm.plugin.report.service.g.iuh.Y(10676, String.format("%d,%d,%s,%d,%s", new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2)}));
        }
        if (this.ijp.ikv == e.d.SEARCHING || this.ijp.ikv == e.d.SEARCH_RETRUN) {
            this.ijp.iks.aIH();
            e eVar = this.ijp.iks;
            if (eVar.cCR != null) {
                eVar.cCR.c(eVar.bYl);
            }
            this.ijp.ikj.aJc();
        }
    }

    public void onDestroy() {
        if (this.ijp != null) {
            RadarViewController radarViewController = this.ijp;
            c cVar = radarViewController.ikt;
            ak.yW();
            com.tencent.mm.model.c.wH().b(cVar);
            com.tencent.mm.sdk.c.a.nhr.f(cVar.ihN);
            ak.yU().b("addcontact", cVar.fvh, true);
            e eVar = radarViewController.iks;
            ak.vy().b(425, eVar);
            ak.vy().b(602, eVar);
            eVar.stop();
            if (eVar.cCR != null) {
                eVar.cCR.c(eVar.bYl);
            }
            RadarWaveView radarWaveView = radarViewController.ikj;
            try {
                if (radarWaveView.ikX != null) {
                    radarWaveView.ikX.stop();
                    radarWaveView.ikX.release();
                    radarWaveView.ikX = null;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.RadarWaveView", e, "", new Object[0]);
                v.e("MicroMsg.RadarWaveView", "stop() crash, because of the native mediaplay is null.");
                radarWaveView.ikX = null;
            }
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (this.ijp != null) {
            z = this.ijp.onKeyDown(i, keyEvent);
        }
        return z ? z : super.onKeyDown(i, keyEvent);
    }

    private static void eY(boolean z) {
        pf pfVar = new pf();
        pfVar.bqB.bqC = z;
        com.tencent.mm.sdk.c.a.nhr.z(pfVar);
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            return q.b((LayoutInflater) systemService);
        }
        return systemService;
    }
}
