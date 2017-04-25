package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.al.n;
import com.tencent.mm.al.t;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.at;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.ui.r.a;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public class ArtistBrowseUI extends SnsBaseGalleryUI implements a {
    private String gRN = "";
    private String jDH = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        if (this.jMb != null) {
            this.jMb.aWV();
            this.jMb.onDestroy();
        }
        ad.aSB().M(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected final int getLayoutId() {
        return 2130904451;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.ArtistBrowseUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.jLY.jFZ);
        setResult(-1, intent);
        finish();
        return true;
    }

    protected final void NI() {
        this.gRN = getIntent().getStringExtra("sns_gallery_artist_lan");
        int intExtra = getIntent().getIntExtra("sns_gallery_position", 0);
        t.HS();
        this.jDH = n.HO();
        n(false, 2);
        this.jMb = new SnsInfoFlip(this);
        List cz = ah.cz(this.gRN, this.jDH);
        this.jMb.jOR = true;
        this.jMb.a(cz, "", intExtra, this.jLW, this);
        addView(this.jMb);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ArtistBrowseUI jDI;

            {
                this.jDI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jDI.jLY.aVE();
                return true;
            }
        });
        vD(2131235572);
        iU(false);
        this.jLW.jFE = new q.a(this) {
            final /* synthetic */ ArtistBrowseUI jDI;

            {
                this.jDI = r1;
            }

            public final void aVn() {
                aib aVD = this.jDI.jMb.aVD();
                if (aVD != null) {
                    v.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + aVD.gID);
                    com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(723);
                    gh.kj(aVD.glb);
                    gh.JF();
                    if (FileOp.aR(al.cA(ad.xh(), aVD.gID) + i.k(aVD))) {
                        at aSA = ad.aSA();
                        if (!(aSA.aSk() == null || aSA.aSk().equals(""))) {
                            String str = al.cA(ad.xh(), aVD.gID) + i.k(aVD);
                            String cA = al.cA(ad.xh(), aSA.aSk());
                            if (FileOp.aR(str)) {
                                v.d("MicroMsg.UploadManager", "bg file is exist!'");
                                FileOp.jS(cA);
                                FileOp.deleteFile(cA + aSA.aSk() + "bg_");
                                FileOp.deleteFile(cA + aSA.aSk() + "tbg_");
                                FileOp.p(str, cA + aSA.aSk() + "bg_");
                            } else {
                                FileOp.deleteFile(cA + aSA.aSk() + "bg_");
                                FileOp.deleteFile(cA + aSA.aSk() + "tbg_");
                                v.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                            }
                            j aSG = ad.aSG();
                            cA = aSA.aSk();
                            String str2 = aVD.gID;
                            com.tencent.mm.plugin.sns.storage.i Bu = aSG.Bu(cA);
                            Bu.field_bgId = str2;
                            aSG.c(Bu);
                        }
                        aSA.aTg();
                        au auVar = new au(7);
                        aVD.mHV = 1;
                        auVar.bpt.mWq.mom.add(aVD);
                        auVar.ql(2);
                        auVar.commit();
                        Intent intent = new Intent();
                        intent.setClass(this.jDI, SettingSnsBackgroundUI.class);
                        intent.setFlags(536870912);
                        intent.addFlags(67108864);
                        this.jDI.startActivity(intent);
                        this.jDI.finish();
                    }
                }
            }
        };
    }

    protected void onPause() {
        if (this.jMb != null) {
            this.jMb.onPause();
        }
        super.onPause();
    }

    public final void aY(String str, int i) {
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.ArtistBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            this.jLY.qJ(intent.getIntExtra("sns_gallery_op_id", 0));
        }
    }

    public final void aZ(String str, int i) {
    }
}
