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
import android.widget.ProgressBar;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.a;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;
import java.util.List;

public final class ai implements w {
    MMActivity aWn;
    private boolean aZW = false;
    String aZy = "";
    String bdZ = "";
    String bou = "";
    private String desc = "";
    ProgressDialog dwR = null;
    private View edj = null;
    ProgressBar elJ;
    private int jEZ;
    private a jFg = null;
    private boolean jHj = false;
    private Bitmap jHk = null;
    c jHl = null;
    private com.tencent.mm.sdk.c.c jHn = new com.tencent.mm.sdk.c.c<ne>(this) {
        final /* synthetic */ ai jKp;

        {
            this.jKp = r2;
            this.nhz = ne.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ne neVar = (ne) bVar;
            v.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(neVar.bor.type)});
            switch (neVar.bor.type) {
                case 1:
                    v.i("MicroMsg.SightWidget", "come event done");
                    this.jKp.bou = neVar.bor.bou;
                    this.jKp.aZy = neVar.bor.bov;
                    if (this.jKp.dwR != null) {
                        this.jKp.dwR.dismiss();
                    }
                    this.jKp.jKo.ag(this.jKp.bou, false);
                    this.jKp.elJ.setVisibility(8);
                    if (neVar.bor.bot && this.jKp.jHo != null) {
                        this.jKp.aWo();
                    }
                    v.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(neVar.bor.bot), neVar.bor.bou, Long.valueOf(FileOp.jP(neVar.bor.bou)), this.jKp.aZy});
                    break;
            }
            return false;
        }
    };
    au jHo = null;
    com.tencent.mm.plugin.sight.decode.a.a jKo;

    public ai(MMActivity mMActivity) {
        this.aWn = mMActivity;
    }

    public final void v(Bundle bundle) {
        this.jFg = a.m(this.aWn.getIntent());
        this.bdZ = this.aWn.getIntent().getStringExtra("KSightThumbPath");
        this.bou = this.aWn.getIntent().getStringExtra("KSightPath");
        this.aZy = this.aWn.getIntent().getStringExtra("sight_md5");
        this.jEZ = this.aWn.getIntent().getIntExtra("Ksnsupload_source", 0);
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
        this.edj = View.inflate(this.aWn, 2130904565, null);
        this.jKo = (com.tencent.mm.plugin.sight.decode.a.a) this.edj.findViewById(2131755052);
        this.jKo.pv(com.tencent.mm.bd.a.fromDPToPix(this.aWn, 90));
        this.elJ = (ProgressBar) this.edj.findViewById(2131759601);
        this.aWn.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.edj.findViewById(2131756148).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ai jKp;

            {
                this.jKp = r1;
            }

            public final void onClick(View view) {
                if (FileOp.aR(this.jKp.bou)) {
                    if (this.jKp.jHl != null) {
                        this.jKp.jHl.dismiss();
                        this.jKp.jHl = null;
                    }
                    this.jKp.jHl = new c(this.jKp.aWn);
                    c cVar = this.jKp.jHl;
                    String str = this.jKp.bou;
                    String str2 = this.jKp.bdZ;
                    cVar.cPu = str;
                    cVar.imagePath = str2;
                    cVar = this.jKp.jHl;
                    cVar.bqS = 0;
                    cVar.iUu = 0;
                    cVar.fNz = 1;
                    this.jKp.jHl.show();
                    return;
                }
                v.i("MicroMsg.SightWidget", "click videopath is not exist " + this.jKp.bou);
            }
        });
        v.i("MicroMsg.SightWidget", "videoPath " + this.bou + " thumbPath " + this.bdZ + " " + FileOp.jP(this.bou) + " " + FileOp.jP(this.bdZ));
        if (FileOp.aR(this.bou)) {
            this.jKo.ag(this.bou, false);
            this.elJ.setVisibility(8);
            v.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.bou, this.aZy});
        } else {
            n zS = i.zS(this.bdZ);
            if (zS != null) {
                this.jHk = zS.wm();
                if (i.i(this.jHk)) {
                    this.jKo.s(this.jHk);
                }
            }
            this.elJ.setVisibility(0);
        }
        return this.edj;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, agp com_tencent_mm_protocal_c_agp, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.jHo != null) {
            return false;
        }
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
        this.jHo.d(null, null, null, i4, i5);
        if (FileOp.aR(this.bou)) {
            aWo();
            return true;
        }
        v.i("MicroMsg.SightWidget", "commit file is not exist " + this.bou);
        MMActivity mMActivity = this.aWn;
        this.aWn.getString(2131231164);
        this.dwR = g.a(mMActivity, this.aWn.getString(2131235519), true, new OnCancelListener(this) {
            final /* synthetic */ ai jKp;

            {
                this.jKp = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.jKp.jHo = null;
            }
        });
        return true;
    }

    final void aWo() {
        if (!this.jHj) {
            if (this.jHo.i(this.bou, this.bdZ, this.desc, this.aZy)) {
                ne neVar = new ne();
                neVar.bor.type = 0;
                neVar.bor.bot = true;
                com.tencent.mm.sdk.c.a.nhr.z(neVar);
                this.jHj = true;
                int commit = this.jHo.commit();
                if (this.jFg != null) {
                    this.jFg.gj(commit);
                    e.jtT.c(this.jFg);
                }
                ad.aSJ().jJu = 0;
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(this.aWn, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                this.aWn.startActivity(intent);
                this.aWn.setResult(-1);
                this.aWn.finish();
                return;
            }
            v.i("MicroMsg.SightWidget", "videopath " + FileOp.jP(this.bou) + " thumb: " + FileOp.jP(this.bdZ));
            s.makeText(this.aWn, 2131234920, 0).show();
        }
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean aVA() {
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.jHn);
        if (i.i(this.jHk)) {
            this.jHk.recycle();
        }
        return false;
    }
}
