package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import b.a.d.i;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.QImageView;
import java.util.LinkedList;
import java.util.List;

public final class aa implements w {
    MMActivity aWn;
    private boolean aZW = false;
    String aZy = "";
    String bdZ = "";
    String bou = "";
    String desc = "";
    ProgressDialog dwR = null;
    private View edj = null;
    private int jEZ;
    private a jFg = null;
    SightPlayImageView jHi;
    boolean jHj = false;
    private Bitmap jHk = null;
    private c jHl = null;
    private ahn jHm = new ahn();
    private com.tencent.mm.sdk.c.c jHn = new com.tencent.mm.sdk.c.c<ne>(this) {
        final /* synthetic */ aa jHq;

        {
            this.jHq = r2;
            this.nhz = ne.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ne neVar = (ne) bVar;
            v.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(neVar.bor.type)});
            switch (neVar.bor.type) {
                case 1:
                    v.i("MicroMsg.SightWidget", "come event done");
                    this.jHq.bou = neVar.bor.bou;
                    this.jHq.aZy = neVar.bor.bov;
                    if (this.jHq.dwR != null) {
                        this.jHq.dwR.dismiss();
                    }
                    if (neVar.bor.bot && this.jHq.jHo != null) {
                        aa.a(this.jHq);
                    }
                    v.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(neVar.bor.bot), neVar.bor.bou, Long.valueOf(FileOp.jP(neVar.bor.bou)), this.jHq.aZy});
                    break;
            }
            return false;
        }
    };
    au jHo = null;
    Runnable jHp = new Runnable(this) {
        final /* synthetic */ aa jHq;

        {
            this.jHq = r1;
        }

        public final void run() {
            v.i("MicroMsg.SightWidget", "showProgress");
            aa aaVar = this.jHq;
            MMActivity mMActivity = this.jHq.aWn;
            this.jHq.aWn.getString(2131231164);
            aaVar.dwR = g.a(mMActivity, this.jHq.aWn.getString(2131235519), false, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass5 pRk;

                {
                    this.pRk = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.pRk.jHq.jHo = null;
                    this.pRk.jHq.jHj = false;
                    ad.B(this.pRk.jHq.pRj);
                }
            });
        }
    };
    private int pRi = 0;
    Runnable pRj = new Runnable(this) {
        final /* synthetic */ aa jHq;

        {
            this.jHq = r1;
        }

        public final void run() {
            aa.a(this.jHq);
        }
    };

    static /* synthetic */ void a(aa aaVar) {
        if (aaVar.jHo != null) {
            if (aaVar.dwR != null) {
                aaVar.dwR.dismiss();
            }
            v.i("MicroMsg.SightWidget", "commitDone");
            ne neVar = new ne();
            neVar.bor.type = 0;
            neVar.bor.bot = true;
            com.tencent.mm.sdk.c.a.nhr.z(neVar);
            aaVar.jHj = true;
            int commit = aaVar.jHo.commit();
            if (aaVar.jFg != null) {
                aaVar.jFg.gj(commit);
                e.jtT.c(aaVar.jFg);
            }
            com.tencent.mm.plugin.sns.e.ad.aSJ().jJu = 0;
            Intent intent = new Intent();
            intent.putExtra("sns_resume_state", false);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.setClass(aaVar.aWn, SnsTimeLineUI.class);
            intent.addFlags(67108864);
            aaVar.aWn.startActivity(intent);
            aaVar.aWn.setResult(-1);
            aaVar.aWn.finish();
        }
    }

    public aa(MMActivity mMActivity) {
        this.aWn = mMActivity;
    }

    public final void v(Bundle bundle) {
        this.jFg = a.m(this.aWn.getIntent());
        this.bdZ = this.aWn.getIntent().getStringExtra("KSightThumbPath");
        this.bou = this.aWn.getIntent().getStringExtra("KSightPath");
        this.aZy = this.aWn.getIntent().getStringExtra("sight_md5");
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
        byte[] byteArrayExtra = this.aWn.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.jHm.az(byteArrayExtra);
            } catch (Exception e) {
                v.i("MicroMsg.SightWidget", "error %s", new Object[]{e.getMessage()});
            }
        }
        if (this.jHm == null) {
            this.jHm = new ahn();
        }
        ne neVar = new ne();
        neVar.bor.type = 2;
        com.tencent.mm.sdk.c.a.nhr.z(neVar);
        if (be.kS(this.bou)) {
            this.bou = be.ah(neVar.bos.box, "");
            v.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.bou});
        }
        this.aZy = be.kS(this.aZy) ? be.ah(neVar.bos.bov, "") : this.aZy;
        v.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.bdZ, this.bou, this.aZy});
        com.tencent.mm.sdk.c.a.nhr.e(this.jHn);
    }

    public final void w(Bundle bundle) {
    }

    public final boolean aVy() {
        return true;
    }

    public final View aVz() {
        this.edj = View.inflate(this.aWn, 2130904564, null);
        this.jHi = (SightPlayImageView) this.edj.findViewById(2131755457);
        this.aWn.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.jHi.co(com.tencent.mm.bd.a.fromDPToPix(this.aWn, 64), com.tencent.mm.bd.a.fromDPToPix(this.aWn, 64));
        this.jHi.a(QImageView.a.pej);
        this.jHi.iVf = true;
        this.jHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ aa jHq;

            {
                this.jHq = r1;
            }

            public final void onClick(View view) {
                if (FileOp.aR(this.jHq.bou)) {
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationInWindow(iArr);
                    }
                    int width = view.getWidth();
                    int height = view.getHeight();
                    Intent intent = new Intent(this.jHq.aWn, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", this.jHq.bou);
                    intent.putExtra("intent_thumbpath", this.jHq.bdZ);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_ispreview", true);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    this.jHq.aWn.startActivity(intent);
                    this.jHq.aWn.overridePendingTransition(0, 0);
                    return;
                }
                v.i("MicroMsg.SightWidget", "click videopath is not exist " + this.jHq.bou);
            }
        });
        v.i("MicroMsg.SightWidget", "videoPath " + this.bou + " thumbPath " + this.bdZ + " " + FileOp.jP(this.bou) + " " + FileOp.jP(this.bdZ));
        if (FileOp.aR(this.bou)) {
            v.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.bou, this.aZy});
        }
        this.jHi.fB(false);
        this.jHi.ag(this.bou, false);
        return this.edj;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.jHo != null) {
            return false;
        }
        if (this.jHj) {
            return true;
        }
        this.jHj = true;
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List yv = m.yv();
            for (String str3 : list) {
                if (!yv.contains(str3)) {
                    axj com_tencent_mm_protocal_c_axj = new axj();
                    com_tencent_mm_protocal_c_axj.gln = str3;
                    linkedList.add(com_tencent_mm_protocal_c_axj);
                }
            }
        }
        this.jHo = new au(15);
        pInt.value = this.jHo.job;
        if (i3 > com.tencent.mm.plugin.sns.b.a.jdC) {
            this.jHo.qk(3);
        }
        au AG = this.jHo.AG(str);
        LinkedList linkedList3 = new LinkedList();
        AG.a(com_tencent_mm_protocal_c_agp).Y(linkedList).qm(i).qn(i2).bo(list2);
        if (z) {
            this.jHo.qp(1);
        } else {
            this.jHo.qp(0);
        }
        this.jHo.bo(list2);
        this.jHo.qo(this.jEZ);
        this.jHo.boZ = this.jHm;
        this.jHo.d(null, null, null, i4, i5);
        ad.g(this.jHp, 700);
        com.tencent.mm.sdk.i.e.a(new Runnable(this) {
            final /* synthetic */ aa jHq;

            {
                this.jHq = r1;
            }

            public final void run() {
                aa aaVar = this.jHq;
                long currentTimeMillis = System.currentTimeMillis();
                if (aaVar.jHo.i(aaVar.bou, aaVar.bdZ, aaVar.desc, aaVar.aZy)) {
                    v.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                } else {
                    v.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.jP(aaVar.bou) + " thumb: " + FileOp.jP(aaVar.bdZ));
                    ad.o(new Runnable(aaVar) {
                        final /* synthetic */ aa jHq;

                        {
                            this.jHq = r1;
                        }

                        public final void run() {
                            s.makeText(this.jHq.aWn, 2131234920, 0).show();
                        }
                    });
                }
                v.i("MicroMsg.SightWidget", "removeRunnable showProgress");
                ad.B(this.jHq.jHp);
                if (this.jHq.jHo != null) {
                    ad.o(this.jHq.pRj);
                }
            }
        }, "sight_send_ready");
        return true;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean aVA() {
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        this.jHi.ag(this.bou, true);
        com.tencent.mm.sdk.c.a.nhr.f(this.jHn);
        if (com.tencent.mm.plugin.sns.data.i.i(this.jHk)) {
            this.jHk.recycle();
        }
        return false;
    }
}
