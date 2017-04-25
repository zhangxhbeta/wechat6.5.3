package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.as.j;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.jj;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.d;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.dx;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class i extends a implements com.tencent.mm.as.o.a, com.tencent.mm.model.d.a {
    public static boolean oqV = false;
    private ah eJF = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ i oCH;

        {
            this.oCH = r1;
        }

        public final boolean oU() {
            j bGu = this.oCH.ozG.bGu();
            if (bGu == null) {
                return false;
            }
            if (bGu.oCW == null) {
                return false;
            }
            if (bGu.bHf().oCW.getVisibility() != 0) {
                return false;
            }
            int bGP = this.oCH.ozG.ozH.bGP();
            if (((n) this.oCH.oCr.get(bGP)) == null) {
                this.oCH.xO(bGP);
                return false;
            } else if (bGu.bHf().oCZ.isPlaying()) {
                this.oCH.oCw = bGu.bHf().oCZ.getCurrentPosition();
                this.oCH.xP(this.oCH.oCw / 1000);
                return true;
            } else {
                v.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
                return false;
            }
        }
    }, true);
    String filename;
    private d iVr;
    boolean jHF;
    long jHH = 0;
    long jHI = 0;
    int jHJ = 0;
    private ah jHK = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ i oCH;

        {
            this.oCH = r1;
        }

        public final boolean oU() {
            boolean z;
            boolean z2 = true;
            k e = this.oCH.oCs;
            if (be.kS(e.mediaId) || !(e.icJ == 1 || e.icJ == 3)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            j bGu = this.oCH.ozG.bGu();
            if (bGu == null || bGu.oCW == null || bGu.bHf().oCW.getVisibility() != 0) {
                return false;
            }
            if (bGu.bHf().oCZ.isPlaying()) {
                z2 = this.oCH.b(bGu);
            }
            if (!z2) {
                return false;
            }
            return this.oCH.oCs.qN(bGu.bHf().oCZ.getCurrentPosition() / 1000);
        }
    }, true);
    private com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.a jHO = new com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.a(this) {
        final /* synthetic */ i oCH;

        {
            this.oCH = r1;
        }

        public final void aBK() {
            v.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", Integer.valueOf(this.oCH.hashCode()));
            try {
                this.oCH.ozG.bGu().a(true, 1.0f);
            } catch (Exception e) {
                v.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e.toString());
            }
        }
    };
    private long jHP;
    int jHQ;
    private HashMap<String, a> oBy = new HashMap();
    private int oCA = 0;
    private int oCB = 0;
    private b oCC = new b(this) {
        final /* synthetic */ i oCH;

        {
            this.oCH = r1;
        }

        public final void aPv() {
            if (this.oCH.ozG.bGu() != null) {
                this.oCH.a(this.oCH.ozG.bGu());
            }
            this.oCH.ozG.ozH.oCe.QI();
        }

        public final void pB(int i) {
            String str = null;
            try {
                str = this.oCH.ozG.bGu().bHf().oCZ.aOV();
            } catch (Throwable e) {
                v.a("MicroMsg.Imagegallery.handler.video", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e.toString());
            }
            v.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", Integer.valueOf(i), Boolean.valueOf(this.oCH.jHF), str);
            if (be.kS(str)) {
                bx bGt = this.oCH.ozG.bGt();
                if (bGt != null && bGt.bwn()) {
                    p.d(bGt.field_imgPath, i * 1000, this.oCH.jHF);
                }
                this.oCH.ozG.xx(this.oCH.ozG.ozH.bGP());
            } else {
                boolean xQ;
                if (this.oCH.jHF) {
                    xQ = this.oCH.oCs.xQ(i);
                } else {
                    this.oCH.py(i);
                    xQ = true;
                }
                if (xQ) {
                    this.oCH.aVW();
                }
            }
            this.oCH.ozG.ozH.bGM();
        }
    };
    private c<jj> oCD = new c<jj>(this) {
        final /* synthetic */ i oCH;

        {
            this.oCH = r2;
            this.nhz = jj.class.getName().hashCode();
        }

        private boolean a(jj jjVar) {
            if (!this.oCH.oCs.BW(jjVar.bjO.mediaId)) {
                return false;
            }
            if (jjVar.bjO.aYJ == 0 || jjVar.bjO.aYJ == -21006) {
                k e;
                String lc;
                int i;
                switch (jjVar.bjO.bdn) {
                    case 1:
                        e = this.oCH.oCs;
                        long j = (long) jjVar.bjO.offset;
                        v.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos : " + j + " needSeekTime : " + e.jIe + " timeDuration : " + e.jIc);
                        if (e.jIc != 0) {
                            v.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                        } else {
                            g.iuh.a(354, 5, 1, false);
                            e.jIl = be.Ni();
                            k.KV();
                            lc = o.lc(e.filename);
                            try {
                                if (e.jIa == null) {
                                    v.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                                } else if (e.jIa.k(lc, j)) {
                                    e.jIc = e.jIa.dfX;
                                    v.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s", Integer.valueOf(e.jIc), e.filename);
                                    ad.o(new Runnable(e) {
                                        final /* synthetic */ k oDx;

                                        {
                                            this.oDx = r1;
                                        }

                                        public final void run() {
                                            if (this.oDx.oDs != null) {
                                                if (this.oDx.qN(p.x(this.oDx.jIc, this.oDx.filename))) {
                                                    this.oDx.oDs.aq(this.oDx.filename, true);
                                                    this.oDx.jIi = true;
                                                }
                                            }
                                        }
                                    });
                                    if (e.jIe == -1) {
                                        e.jHY = 1;
                                    } else {
                                        e.jHY = 2;
                                    }
                                    g.iuh.a(354, 7, 1, false);
                                } else {
                                    v.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                    com.tencent.mm.modelcdntran.g.DY();
                                    f.requestVideoData(e.mediaId, 0, -1, 0);
                                    p.F(e.filename, 15);
                                    g.iuh.a(354, 8, 1, false);
                                    v.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", Integer.valueOf(e.hashCode()), e.filename);
                                    g.iuh.h(13836, Integer.valueOf(302), Long.valueOf(be.Nh()), SQLiteDatabase.KeyEmpty);
                                }
                            } catch (Throwable e2) {
                                v.a("MicroMsg.OnlineVideoUIHelper", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                v.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e2.toString());
                            }
                        }
                        this.oCH.jHF = true;
                        break;
                    case 2:
                        k e3 = this.oCH.oCs;
                        String str = jjVar.bjO.mediaId;
                        i = jjVar.bjO.offset;
                        int i2 = jjVar.bjO.length;
                        if (i < 0 || i2 < 0) {
                            v.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                        } else if (e3.BW(str)) {
                            Integer num = (Integer) e3.jHZ.get(e3.mediaId + i + "_" + i2);
                            if (num == null || num.intValue() <= 0) {
                                try {
                                    e3.jIg = e3.jIa.aR(i, i2);
                                } catch (Throwable e22) {
                                    v.a("MicroMsg.OnlineVideoUIHelper", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    v.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e22.toString());
                                }
                            } else {
                                e3.jIg = num.intValue();
                            }
                            v.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(e3.jIg));
                        }
                        if (jjVar.bjO.length > 0) {
                            this.oCH.aVW();
                            break;
                        }
                        break;
                    case 3:
                        this.oCH.aVW();
                        break;
                    case 4:
                        e = this.oCH.oCs;
                        v.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", Integer.valueOf(e.jHY));
                        e.icJ = 3;
                        if (e.jHY == 0) {
                            v.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                            e.aWg();
                            g.iuh.a(354, 6, 1, false);
                        } else if (e.jHY == 5) {
                            v.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + e.mediaId);
                            e.aWg();
                        }
                        this.oCH.aVW();
                        break;
                    case 5:
                        e = this.oCH.oCs;
                        lc = jjVar.bjO.mediaId;
                        i = jjVar.bjO.offset;
                        if (e.BW(lc)) {
                            e.oDu = i;
                            e.jId = (i * 100) / e.dAz;
                            v.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + e.jId);
                            break;
                        }
                        break;
                    case 6:
                        e = this.oCH.oCs;
                        v.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                        e.aWg();
                        break;
                    default:
                        v.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + jjVar.bjO.bdn);
                        break;
                }
                return false;
            }
            v.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + jjVar.bjO.aYJ);
            i.a(this.oCH, jjVar.bjO.mediaId, jjVar.bjO.aYJ);
            return false;
        }
    };
    private boolean oCE = false;
    private int oCF = 0;
    private int[] oCG = new int[]{-1000, -2000, 3400};
    private c oCq;
    final SparseArray<n> oCr = new SparseArray();
    private k oCs = new k(this);
    private boolean oCt = false;
    private boolean oCu = false;
    private boolean oCv = false;
    private int oCw = 0;
    private long oCx = 0;
    private long oCy = 0;
    private int oCz = 0;

    public static class a {
        public at aXd;
        public int pos;

        public a(at atVar, int i) {
            this.aXd = atVar;
            this.pos = i;
        }
    }

    static /* synthetic */ void a(i iVar, String str, final int i) {
        v.i("MicroMsg.Imagegallery.handler.video", "download online video error. mediaId: " + str);
        iVar.aWa();
        k kVar = iVar.oCs;
        v.i("MicroMsg.OnlineVideoUIHelper", "deal stream error.");
        if (kVar.BW(str)) {
            kVar.icJ = 2;
            com.tencent.mm.modelcdntran.g.DY().b(kVar.mediaId, kVar.bHi());
        }
        g.iuh.a(354, 9, 1, false);
        if (i == -10012) {
            v.w("MicroMsg.Imagegallery.handler.video", "download online video time out, quit imageGalleryUI.");
            ad.o(new Runnable(iVar) {
                final /* synthetic */ i oCH;

                {
                    this.oCH = r1;
                }

                public final void run() {
                    this.oCH.ozG.ozH.onBackPressed();
                }
            });
            return;
        }
        ad.o(new Runnable(iVar) {
            final /* synthetic */ i oCH;

            public final void run() {
                v.w("MicroMsg.Imagegallery.handler.video", "show play video error.");
                p.ls(this.oCH.filename);
                if (this.oCH.ozG != null) {
                    OnClickListener anonymousClass1;
                    j bGu = this.oCH.ozG.bGu();
                    bGu.bHf().oCZ.stop();
                    bGu.a(false, 0.0f);
                    String string = this.oCH.ozG.ozH.getString(2131235793);
                    if (i == -5103059 || i == -5103087) {
                        string = this.oCH.ozG.ozH.getString(2131235792);
                        anonymousClass1 = new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass14 oCM;

                            {
                                this.oCM = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (dialogInterface != null) {
                                    dialogInterface.cancel();
                                }
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 oCN;

                                    {
                                        this.oCN = r1;
                                    }

                                    public final void run() {
                                        this.oCN.oCM.oCH.ozG.ozH.onBackPressed();
                                    }
                                });
                            }
                        };
                    } else {
                        anonymousClass1 = new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass14 oCM;

                            {
                                this.oCM = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (dialogInterface != null) {
                                    dialogInterface.cancel();
                                }
                            }
                        };
                    }
                    com.tencent.mm.ui.base.g.a(this.oCH.ozG.ozH, string, this.oCH.ozG.ozH.getString(2131231868), anonymousClass1);
                    this.oCH.oCr.clear();
                }
            }
        });
    }

    public i(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.c.a aVar = com.tencent.mm.sdk.c.a.nhr;
        c dxVar = new dx(com.tencent.mm.ui.chatting.dx.a.VIDEO_GALLERY, bVar.ozH);
        this.oCq = dxVar;
        aVar.e(dxVar);
        com.tencent.mm.sdk.c.a.nhr.e(this.oCD);
        this.iVr = new d();
    }

    public final boolean a(j jVar, at atVar, int i) {
        super.a(jVar, atVar, i);
        n bb = bb(atVar);
        if (atVar == null) {
            v.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            return false;
        }
        if (this.oBy != null) {
            this.oBy.put(atVar.field_imgPath, new a(atVar, i));
        } else {
            v.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (bb == null) {
            return false;
        }
        k.KV();
        jVar.bHf().oCX.setImageBitmap(BackwardSupportUtil.b.c(o.ld(atVar.field_imgPath), 1.0f));
        if (jVar.bHf().oCZ.isPlaying()) {
            jVar.bHf().oCZ.stop();
        }
        jVar.oDb.setVisibility(8);
        jVar.bHf().oDa.setVisibility(8);
        jVar.bHf().oDh.setVisibility(8);
        jVar.a(false, 0.0f);
        this.oCz = 0;
        this.jHH = be.Ni();
        return true;
    }

    public static n bb(at atVar) {
        if (b.aI(atVar)) {
            return p.lp(atVar.field_imgPath);
        }
        return null;
    }

    public final void pause(int i) {
        a(xq(i));
        this.iVr.aN(false);
        this.ozG.ozH.jS(true);
    }

    public final void c(at atVar, int i) {
        int i2 = 0;
        v.i("MicroMsg.Imagegallery.handler.video", "toggle video");
        if (atVar != null) {
            if (b.aI(atVar) || b.aJ(atVar)) {
                n bb = bb(atVar);
                if (bb == null) {
                    return;
                }
                if (this.ozG.ozH.bGQ()) {
                    a(xq(i));
                    this.ozG.ozH.jS(true);
                    this.ozG.ozH.oCe.QI();
                    this.iVr.aN(false);
                    v.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
                    return;
                }
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    if (this.jHF) {
                        try {
                            if (this.ozG.bGu().oCZ != null) {
                                i2 = this.ozG.bGu().oCZ.getCurrentPosition() / 1000;
                            }
                        } catch (Throwable e) {
                            v.a("MicroMsg.Imagegallery.handler.video", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.e("MicroMsg.Imagegallery.handler.video", "toggle video error: " + e.toString());
                        }
                        if (this.oCs.qO(i2)) {
                            v.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                            a(atVar, bb, i, this.jHF);
                        } else {
                            v.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                            aVW();
                        }
                    } else {
                        if (atVar.field_isSend == 0) {
                            if (bb.status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON || bb.status == 198) {
                                a(atVar, bb);
                            } else {
                                if (bb.status == 199) {
                                    a(atVar, bb, i, false);
                                }
                                if (bb.status == MMGIFException.D_GIF_ERR_NOT_READABLE) {
                                    a(atVar, bb);
                                }
                                if (bb.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                                    a(atVar, bb);
                                }
                                if (bb.status == 121 || bb.status == 122) {
                                    a(atVar, bb);
                                }
                            }
                        }
                        if (atVar.field_isSend == 1) {
                            int i3 = bb.status;
                            if (i3 == MMGIFException.D_GIF_ERR_NOT_READABLE || i3 == 198 || i3 == MMGIFException.D_GIF_ERR_EOF_TOO_SOON || i3 == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i3 == 121 || i3 == 122) {
                                v.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", atVar.field_talker, Integer.valueOf(i3));
                                a(atVar, bb);
                            } else {
                                a(atVar, bb, i, false);
                            }
                        }
                    }
                    if (this.ozG.ozH.oCd) {
                        this.ozG.ozH.bGM();
                        return;
                    }
                    return;
                }
                s.ey(this.ozG.ozH.nDR.nEl);
            }
        }
    }

    public final void d(at atVar, int i) {
        v.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        n lp = p.lp(atVar.field_imgPath);
        if (lp != null && !lp.Lh()) {
            a(xq(i));
            this.ozG.ozH.jS(true);
            if (this.jHF) {
                this.oCs.bHg();
                this.oCs.reset();
            }
            a(atVar, lp);
            if (this.ozG.ozH.eD(atVar.field_msgId) == 2) {
                cj(atVar.field_imgPath, 8);
            } else {
                cj(atVar.field_imgPath, 5);
            }
        }
    }

    private void a(at atVar, n nVar, int i, boolean z) {
        if (atVar != null && nVar != null) {
            if (atVar.bwv()) {
                Toast.makeText(this.ozG.ozH, 2131235790, 0).show();
                return;
            }
            String lc;
            String Lf;
            if (nVar.dhR == -1) {
                Lf = nVar.Lf();
                if (!e.aR(Lf)) {
                    k.KV();
                    lc = o.lc(atVar.field_imgPath);
                }
                lc = Lf;
            } else {
                k.KV();
                Lf = o.lc(atVar.field_imgPath);
                if (atVar.field_isSend == 1 && nVar.dhU != null && nVar.dhU.mHd) {
                    try {
                        String jR = FileOp.jR(Lf);
                        if (!jR.endsWith("/")) {
                            jR = jR + "/";
                        }
                        jR = jR + e.aT(Lf) + "_hd.mp4";
                        v.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", jR, Boolean.valueOf(FileOp.aR(jR)));
                        if (!FileOp.aR(jR)) {
                            jR = Lf;
                        }
                        lc = jR;
                    } catch (Exception e) {
                        v.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", e.getMessage());
                    }
                }
                lc = Lf;
            }
            if (lc == null || !e.aR(lc)) {
                Toast.makeText(this.ozG.ozH, 2131235790, 0).show();
                return;
            }
            j xq = xq(i);
            if (xq != null) {
                int el;
                if (m.dE(nVar.Ld())) {
                    el = com.tencent.mm.model.i.el(nVar.Ld());
                } else {
                    el = 0;
                }
                boolean kX = com.tencent.mm.as.m.kX(lc);
                v.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d]", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.ozG.ozH.eD(atVar.field_msgId)));
                if (kX) {
                    g.iuh.h(12084, Integer.valueOf(nVar.cyu), Integer.valueOf(nVar.dhK * 1000), Integer.valueOf(0), Integer.valueOf(3), nVar.Ld(), Integer.valueOf(el), n.kY(nVar.Lg()), Long.valueOf(nVar.dhH));
                    if (!com.tencent.mm.pluginsdk.m.b.a.a.d(lc, this.ozG.ozH.nDR.nEl, kX)) {
                        Toast.makeText(this.ozG.ozH.nDR.nEl, this.ozG.ozH.getString(2131235797), 0).show();
                    }
                } else if (com.tencent.mm.compatible.d.p.ceJ.cdL != 1 || !com.tencent.mm.pluginsdk.m.b.a.a.c(nVar.getFileName(), this.ozG.ozH.nDR.nEl, kX)) {
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1 && xq.oDb != null) {
                        xq.oDb.setVisibility(0);
                        xq.oDb.setText(com.tencent.mm.plugin.sight.base.d.wu(lc));
                    }
                    int i2 = nVar.dhK;
                    int i3 = nVar.cyu;
                    String Ld = nVar.Ld();
                    String kY = n.kY(nVar.Lg());
                    long j = nVar.dhH;
                    xq.jzn = i2;
                    xq.oDm = i3;
                    xq.oDn = el;
                    xq.bhM = Ld;
                    xq.bhO = kY;
                    xq.dhH = j;
                    this.jHF = z;
                    this.oCt = true;
                    this.filename = nVar.getFileName();
                    if (r4 == 3) {
                        xq.bHf().oCZ.dJ(true);
                    } else {
                        xq.bHf().oCZ.dJ(false);
                    }
                    if (xq.bHf().oCZ.aOV() == null || !xq.bHf().oCZ.aOV().equals(lc) || xq.bHf().oCZ.isPlaying()) {
                        this.oCv = false;
                        xq.bHf().oCZ.setVideoPath(lc);
                        xq.a(true, 0.0f);
                    } else {
                        xq.a(true, 1.0f);
                        xq.bHf().oCZ.start();
                        aVZ();
                        if (!z) {
                            Pc(this.filename);
                        }
                        aVW();
                    }
                    this.oCr.put(i, nVar);
                    this.ozG.ozH.jS(false);
                    this.ozG.ozH.nDR.nEl.getWindow().addFlags(FileUtils.S_IWUSR);
                    if (com.tencent.mm.compatible.util.d.dX(17)) {
                        Pc(this.filename);
                    }
                    this.iVr.a(this);
                } else {
                    return;
                }
                xq.bHf().oDa.setVisibility(8);
            }
        }
    }

    private void a(final at atVar, final n nVar) {
        if (aa.bk(this.ozG.ozH.nDR.nEl) || oqV) {
            b(atVar, nVar);
        } else {
            com.tencent.mm.ui.base.g.a(this.ozG.ozH.nDR.nEl, 2131235789, 2131231164, new OnClickListener(this) {
                final /* synthetic */ i oCH;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.oqV = true;
                    this.oCH.b(atVar, nVar);
                }
            }, null);
        }
    }

    private void b(at atVar, n nVar) {
        v.i("MicroMsg.Imagegallery.handler.video", "startDownloading");
        if (atVar != null && nVar != null) {
            j bGu = this.ozG.bGu();
            if (bGu != null) {
                Object obj;
                String str;
                int eD = this.ozG.ozH.eD(atVar.field_msgId);
                v.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : " + eD);
                switch (eD) {
                    case 0:
                        break;
                    case 1:
                    case 2:
                        obj = (nVar.status == 121 || nVar.status == 122 || nVar.status == 120) ? 1 : null;
                        if (obj != null) {
                            v.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                            str = atVar.field_imgPath;
                            n lp = p.lp(str);
                            if (lp == null) {
                                v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " getinfo failed: " + str);
                                com.tencent.mm.compatible.util.g.sk();
                            } else if (lp.status == MMGIFException.D_GIF_ERR_NOT_READABLE || lp.status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON || lp.status == 121 || lp.status == 122) {
                                int i = FileUtils.S_IRUSR;
                                if (p.Lo()) {
                                    lp.status = 122;
                                } else {
                                    v.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                                    lp.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                                    lp.dhE = 0;
                                    i = 272;
                                }
                                lp.dhJ = be.Nh();
                                lp.dhI = be.Nh();
                                lp.bkU = (i | 2048) | 1024;
                                if (p.e(lp)) {
                                    k.KY().Lp();
                                    k.KY().run();
                                } else {
                                    v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " update failed: " + str);
                                    com.tencent.mm.compatible.util.g.sk();
                                }
                            } else {
                                v.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " get status failed: " + str + " status:" + lp.status);
                                com.tencent.mm.compatible.util.g.sk();
                            }
                        } else {
                            v.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                            cj(atVar.field_imgPath, 10);
                            p.ll(atVar.field_imgPath);
                        }
                        k.KV().a(this, Looper.getMainLooper());
                        this.ozG.ozH.bGO();
                        this.oCE = false;
                        bGu.bHf().oCY.setVisibility(8);
                        bGu.bHf().oDa.setVisibility(0);
                        bGu.bHf().oDa.setProgress(p.f(nVar));
                        if (eD == 2) {
                            g.iuh.a(354, 14, 1, false);
                            return;
                        } else {
                            g.iuh.a(354, 11, 1, false);
                            return;
                        }
                    case 3:
                        v.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", Integer.valueOf(hashCode()), Integer.valueOf(eD));
                        break;
                    default:
                        v.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(eD));
                        return;
                }
                k kVar = this.oCs;
                String str2 = atVar.field_imgPath;
                if (p.Lo()) {
                    kVar.reset();
                    n lp2 = p.lp(str2);
                    if (lp2 == null || lp2.cyu >= kVar.oDw.oDy) {
                        com.tencent.mm.modelcdntran.i iVar;
                        p.G(str2, 1);
                        j.KT();
                        com.tencent.mm.modelcdntran.g.DY();
                        if (be.kS(str2)) {
                            iVar = null;
                        } else {
                            n lp3 = p.lp(str2);
                            if (lp3 == null) {
                                iVar = null;
                            } else {
                                Map q = bf.q(lp3.Lg(), "msg");
                                if (q == null) {
                                    v.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                    iVar = null;
                                } else {
                                    String str3 = (String) q.get(".msg.videomsg.$cdnvideourl");
                                    if (be.kS(str3)) {
                                        v.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                        iVar = null;
                                    } else {
                                        int intValue = Integer.valueOf((String) q.get(".msg.videomsg.$length")).intValue();
                                        String str4 = (String) q.get(".msg.videomsg.$md5");
                                        str = (String) q.get(".msg.videomsg.$aeskey");
                                        String str5 = (String) q.get(".msg.videomsg.$fileparam");
                                        String a = com.tencent.mm.modelcdntran.d.a("downvideo", lp3.dhH, lp3.Ld(), lp3.getFileName());
                                        if (be.kS(a)) {
                                            v.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", lp3.getFileName());
                                            iVar = null;
                                        } else {
                                            k.KV();
                                            String lc = o.lc(str2);
                                            com.tencent.mm.modelcdntran.i iVar2 = new com.tencent.mm.modelcdntran.i();
                                            iVar2.filename = str2;
                                            iVar2.cFT = str4;
                                            iVar2.cFU = intValue;
                                            iVar2.cFV = true;
                                            iVar2.cFW = lp3.Ld();
                                            iVar2.bhN = m.dE(lp3.Ld()) ? com.tencent.mm.model.i.el(lp3.Ld()) : 0;
                                            iVar2.field_mediaId = a;
                                            iVar2.field_fullpath = lc;
                                            iVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                            iVar2.field_totalLen = intValue;
                                            iVar2.field_aesKey = str;
                                            iVar2.field_fileId = str3;
                                            iVar2.field_priority = com.tencent.mm.modelcdntran.b.cEA;
                                            iVar2.field_wxmsgparam = str5;
                                            iVar2.field_chattype = m.dE(lp3.Ld()) ? 1 : 0;
                                            iVar2.cFX = lp3.cFX;
                                            ak.yW();
                                            bx S = com.tencent.mm.model.c.wJ().S(lp3.Ld(), lp3.bmL);
                                            if (lp3.Ld().equals(S.field_talker)) {
                                                aw.b fP = aw.fP(S.bNo);
                                                iVar2.field_limitrate = fP == null ? 0 : fP.ctE / 8;
                                            }
                                            iVar2.field_autostart = false;
                                            iVar = iVar2;
                                        }
                                    }
                                }
                            }
                        }
                        if (iVar == null) {
                            obj = null;
                        } else {
                            eD = lp2.dhE;
                            kVar.oDu = eD;
                            kVar.oDt = eD;
                            kVar.mediaId = iVar.field_mediaId;
                            kVar.dAz = iVar.cFU;
                            kVar.filename = str2;
                            kVar.icJ = 1;
                            kVar.jIc = 0;
                            com.tencent.mm.modelcdntran.g.DY().a(iVar, k.KY().Lp());
                            kVar.jIk = be.Ni();
                            kVar.bhO = iVar.field_fileId;
                            kVar.oDv = iVar.field_aesKey;
                            g.iuh.a(354, 1, 1, false);
                            v.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", kVar.mediaId, str2, Long.valueOf(kVar.jIk));
                            obj = 1;
                        }
                    } else {
                        v.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", Integer.valueOf(lp2.cyu), Integer.valueOf(kVar.oDw.oDy));
                        p.b(lp2, 9);
                        g.iuh.a(354, 17, 1, false);
                        obj = null;
                    }
                } else {
                    obj = null;
                }
                if (obj != null) {
                    v.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
                    this.jHF = true;
                    k.KV().a((com.tencent.mm.as.o.a) this);
                    this.ozG.ozH.bGO();
                    this.oCE = false;
                    bGu.bHf().oCY.setVisibility(8);
                    bGu.bHf().oDa.setVisibility(8);
                    bGu.bHf().oDh.setVisibility(0);
                    return;
                }
                v.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
                this.jHF = false;
                k.KV().a(this, Looper.getMainLooper());
                p.ll(atVar.field_imgPath);
                this.ozG.ozH.bGO();
                this.oCE = false;
                bGu.bHf().oCY.setVisibility(8);
                bGu.bHf().oDa.setVisibility(0);
                bGu.bHf().oDa.setProgress(p.f(nVar));
            }
        }
    }

    private void cj(final String str, final int i) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i oCH;

            public final void run() {
                p.G(str, i);
            }
        });
    }

    private boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        k.KV().a((com.tencent.mm.as.o.a) this);
        if (this.ozG.ozH.bGP() == aVar.pos) {
            j xq = xq(aVar.pos);
            if (xq != null) {
                xq.bHf().oDh.setVisibility(8);
                xq.bHf().oDa.setVisibility(8);
                xq.bHf().oCY.setVisibility(8);
            }
            this.oCE = true;
            this.ozG.ozH.bGN();
            return true;
        }
        this.ozG.xz(aVar.pos);
        return false;
    }

    public final void bGF() {
        v.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.jHI = be.Ni();
        SparseArray sparseArray = this.ozG.nZE;
        int i = 0;
        boolean z = false;
        while (i < sparseArray.size()) {
            boolean z2;
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.oCW != null && jVar.bHf().oCW.getVisibility() == 0 && (((View) jVar.bHf().oCZ).getVisibility() == 0 || !be.kS(jVar.bHf().oCZ.aOV()))) {
                    v.i("MicroMsg.Imagegallery.handler.video", "stop");
                    bHb();
                    if (jVar != null) {
                        aWa();
                        if (this.jHF) {
                            this.oCs.bHg();
                        }
                        if (!this.oCu) {
                            p.d(this.filename, this.oCw - 1000, this.jHF);
                        }
                        jVar.bHf().oDa.setVisibility(8);
                        jVar.bHf().oCZ.stop();
                        xP(0);
                        jVar.a(false, 0.0f);
                        this.jHF = false;
                        this.oCE = false;
                        this.filename = null;
                        this.jHQ = 0;
                        this.jHP = 0;
                        this.oCF = 0;
                        this.oCB = 0;
                        this.oCA = 0;
                        this.oCz = 0;
                        this.oCx = 0;
                        this.oCy = 0;
                    }
                    z2 = true;
                    i++;
                    z = z2;
                }
            }
            z2 = z;
            i++;
            z = z2;
        }
        this.iVr.aN(false);
        if (!z && this.jHF) {
            this.oCs.bHg();
        }
        bHb();
        this.oCr.clear();
    }

    private void a(j jVar) {
        if (jVar != null) {
            bHb();
            v.d("MicroMsg.Imagegallery.handler.video", "pause video.");
            if (jVar.bHf().oCZ.isPlaying()) {
                jVar.bHf().oCZ.pause();
                aWa();
            }
        }
    }

    protected final void onResume() {
        v.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        com.tencent.mm.sdk.c.a.nhr.e(this.oCD);
        if (this.oCv) {
            xP(this.ozG.ozH.bGH().oBO.iUN);
        }
    }

    protected final void onPause() {
        v.i("MicroMsg.Imagegallery.handler.video", "ui on pause, pause video now.");
        j bGu = this.ozG.bGu();
        if (bGu != null) {
            if (!this.oCu) {
                p.d(this.filename, bGu.bHf().oCZ.getCurrentPosition(), this.jHF);
            }
            a(bGu);
            if (this.jHF) {
                com.tencent.mm.sdk.c.a.nhr.f(this.oCD);
                this.oCs.bHg();
                this.jHF = false;
            }
        }
        this.oCt = false;
    }

    public final void detach() {
        v.i("MicroMsg.Imagegallery.handler.video", "detach.");
        this.jHI = be.Ni();
        bHb();
        com.tencent.mm.sdk.c.a.nhr.f(this.oCq);
        com.tencent.mm.sdk.c.a.nhr.f(this.oCD);
        bGF();
        this.ozG.ozH.nDR.nEl.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.ozG.ozH.bGH().oBO.iUG = null;
        super.detach();
        this.oBy.clear();
        this.oBy = null;
        k.KV().a((com.tencent.mm.as.o.a) this);
        this.oCr.clear();
        k kVar = this.oCs;
        kVar.reset();
        kVar.jIa = null;
        kVar.oDs = null;
        kVar.oDw = null;
        k.KY().Lp();
        k.KY().run();
    }

    public final void bHa() {
        this.oCu = false;
        this.jHJ = 0;
        final j bGu = this.ozG.bGu();
        if (bGu == null) {
            v.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            return;
        }
        final int ee = be.ee((long) bGu.bHf().oCZ.getDuration());
        int i = this.ozG.ozH.bGH().oBO.iUN;
        v.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", Integer.valueOf(hashCode()), Integer.valueOf(ee), Integer.valueOf(i));
        if (i <= 0 || Math.abs(i - ee) >= 2) {
            this.ozG.ozH.bGH().oBO.pz(ee);
        }
        this.ozG.ozH.bGH().oBO.iUG = this.oCC;
        if (ee == 0 || ee >= 1800) {
            v.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", Integer.valueOf(hashCode()), Integer.valueOf(ee), this.filename);
        } else {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ i oCH;

                public final void run() {
                    String g = this.oCH.filename;
                    int i = ee;
                    n lp = p.lp(g);
                    if (lp != null) {
                        int i2 = lp.dhK;
                        if (i2 <= 0 || Math.abs(i2 - i) > 2) {
                            lp.dhK = i;
                            lp.bkU = 4096;
                            v.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", Boolean.valueOf(p.e(lp)), Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                }
            });
        }
        i = p.x(ee, this.filename);
        v.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", Boolean.valueOf(this.jHF), Integer.valueOf(i), Boolean.valueOf(this.oCt), Boolean.valueOf(this.oCu));
        if (bGu.bHf().oCZ instanceof VideoTextureView) {
            ((VideoTextureView) bGu.bHf().oCZ).lUM = this.jHO;
        }
        if (this.oCt) {
            if (this.jHF) {
                k kVar = this.oCs;
                if (i > 0) {
                    v.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : " + i);
                    kVar.jIe = i;
                    kVar.jIf = true;
                    kVar.jHY = 2;
                }
                this.oCs.qN(0);
            } else {
                this.oCs.reset();
                bGu.bHf().oCZ.start();
                aVZ();
                py(i);
            }
            aVW();
            return;
        }
        if (this.jHF) {
            bGu.bHf().oCZ.start();
            this.oCs.xQ(i);
        } else {
            bGu.bHf().oCZ.start();
            py(i);
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ i oCH;

            public final void run() {
                bGu.bHf().oCZ.pause();
            }
        });
        xP(i);
        this.ozG.ozH.jS(true);
        bHb();
    }

    public final void dl(int i, int i2) {
        v.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b playErrorTime %d", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.jHF), Boolean.valueOf(this.oCs.alC()), Integer.valueOf(this.oCB));
        this.oCu = true;
        this.jHJ = i2;
        if (this.jHF && this.oCs.alC()) {
            this.oCB++;
            int i3;
            a aVar;
            if (this.oCB < 3) {
                int currentPosition = this.ozG.bGu().oCZ.getCurrentPosition();
                i3 = this.oCG[this.oCF % this.oCG.length] + currentPosition;
                if (this.oCF > this.oCG.length) {
                    i3 = (this.oCF * 2000) + currentPosition;
                }
                if (i3 < 0) {
                    i3 = 0;
                }
                v.w("MicroMsg.Imagegallery.handler.video", "calc repairTime : " + currentPosition + " errorTime : " + this.oCF + " result : " + i3);
                this.oCF++;
                bHb();
                p.d(this.filename, i3, this.jHF);
                this.ozG.bGu().oCZ.stop();
                aVar = (a) this.oBy.get(this.filename);
                if (aVar != null && aVar.aXd != null) {
                    a(aVar.aXd, bb(aVar.aXd), aVar.pos, this.jHF);
                } else {
                    return;
                }
            }
            i3 = this.ozG.bGu().oCZ.getCurrentPosition();
            if (this.oCB > 3 && i3 > 1000) {
                i3 -= 1000;
            }
            v.w("MicroMsg.Imagegallery.handler.video", "online play video error, it request all video data to play. repairTime %d ", Integer.valueOf(i3));
            bHb();
            p.d(this.filename, i3, this.jHF);
            this.ozG.bGu().oCZ.stop();
            this.oCs.bHh();
            if (this.oCB <= 10) {
                aVar = (a) this.oBy.get(this.filename);
                if (aVar != null && aVar.aXd != null) {
                    a(aVar.aXd, bb(aVar.aXd), aVar.pos, this.jHF);
                } else {
                    return;
                }
            }
            return;
            g.iuh.a(354, 18, 1, false);
            return;
        }
        p.ls(this.filename);
        final String aOV = this.ozG.bGu().oCZ.aOV();
        this.ozG.bGv();
        this.ozG.bGu().oCZ.stop();
        if (this.oCv) {
            v.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", Integer.valueOf(hashCode()));
            return;
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ i oCH;

            public final void run() {
                if (this.oCH.ozG == null || this.oCH.ozG.bGu() == null || this.oCH.oBy == null) {
                    v.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
                    return;
                }
                this.oCH.ozG.bGu().a(false, 0.0f);
                if (!be.kS(aOV)) {
                    v.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", aOV);
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.fromFile(new File(aOV)), "video/*");
                        this.oCH.ozG.ozH.startActivity(intent);
                    } catch (Exception e) {
                        v.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.f(this.oCH.ozG.ozH, 2131232691, 2131232692);
                    }
                }
                a aVar = (a) this.oCH.oBy.get(this.oCH.filename);
                if (aVar != null && aVar.aXd != null) {
                    this.oCH.xO(aVar.pos);
                }
            }
        });
        g.iuh.a(354, 25, 1, false);
    }

    final void bHb() {
        v.i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.jHK.QI();
        this.eJF.QI();
    }

    protected final void aVW() {
        if (!this.oCu) {
            if (this.jHF) {
                this.jHK.ea(500);
            } else {
                this.eJF.ea(500);
            }
        }
    }

    public final void xO(int i) {
        this.oCr.remove(i);
    }

    public final void a(com.tencent.mm.as.o.a.a aVar) {
        String str = aVar.aST;
        if (!be.kS(str) && this.oBy != null) {
            a aVar2 = (a) this.oBy.get(str);
            if (aVar2 != null) {
                at atVar = aVar2.aXd;
                if (atVar != null && atVar.field_imgPath != null && atVar.field_imgPath.equals(str)) {
                    n bb = bb(atVar);
                    if (bb == null) {
                        return;
                    }
                    if (!atVar.bwv() && bb.status != 198) {
                        int f = p.f(bb);
                        j xq = xq(aVar2.pos);
                        if (this.ozG.ozH.bGP() == aVar2.pos && xq != null) {
                            this.ozG.ozH.bGO();
                            this.oCE = false;
                            xq.bHf().oDa.setVisibility(0);
                            xq.bHf().oDa.setProgress(f);
                        } else if (xq == null) {
                            return;
                        }
                        if (f >= xq.bHf().oDa.pcv) {
                            v.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", Integer.valueOf(bb.status));
                            if ((bb.status == 199 || bb.status == 199) && b(aVar2)) {
                                this.ozG.ozH.dm(true);
                                switch (this.ozG.ozH.eD(atVar.field_msgId)) {
                                    case 0:
                                    case 3:
                                        a(atVar, bb, this.ozG.ozH.bGP(), false);
                                        return;
                                    case 1:
                                        v.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                                        g.iuh.a(354, 15, 1, false);
                                        this.ozG.aP(atVar);
                                        this.jHF = false;
                                        this.ozG.ozH.eE(-1);
                                        return;
                                    case 2:
                                        g.iuh.a(354, 16, 1, false);
                                        b.a(this.ozG.ozH, atVar, true);
                                        this.jHF = false;
                                        this.ozG.ozH.eE(-1);
                                        return;
                                    default:
                                        v.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(this.ozG.ozH.eD(atVar.field_msgId)));
                                        return;
                                }
                            }
                        }
                    } else if (b(aVar2)) {
                        Toast.makeText(this.ozG.ozH, 2131235790, 0).show();
                    }
                }
            }
        }
    }

    protected final void aq(final String str, final boolean z) {
        ad.o(new Runnable(this) {
            final /* synthetic */ i oCH;

            public final void run() {
                v.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", str, Boolean.valueOf(z));
                if (this.oCH.oBy == null) {
                    v.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
                    return;
                }
                a aVar = (a) this.oCH.oBy.get(str);
                if (aVar != null && aVar.aXd != null) {
                    n bb = i.bb(aVar.aXd);
                    if (this.oCH.ozG.ozH.bGP() == aVar.pos) {
                        this.oCH.a(aVar.aXd, bb, aVar.pos, z);
                        this.oCH.Pc(str);
                        return;
                    }
                    v.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", Integer.valueOf(this.oCH.ozG.ozH.bGP()), Integer.valueOf(aVar.pos));
                }
            }
        });
    }

    protected final void py(int i) {
        j bGu = this.ozG.bGu();
        if (bGu != null) {
            aVZ();
            bGu.bHf().oDh.setVisibility(8);
            bGu.bHf().oCZ.i((double) (i * 1000));
            this.ozG.ozH.jS(false);
            aVW();
        }
    }

    protected final void aVY() {
        j bGu = this.ozG.bGu();
        if (bGu != null) {
            v.i("MicroMsg.Imagegallery.handler.video", "start to pause");
            this.ozG.ozH.jS(true);
            bGu.bHf().oDh.setVisibility(0);
            bGu.bHf().oCZ.pause();
            aWa();
        }
    }

    protected final void aVX() {
        j bGu = this.ozG.bGu();
        if (bGu != null) {
            if (!bGu.bHf().oCZ.isPlaying()) {
                v.i("MicroMsg.Imagegallery.handler.video", "start to play");
                this.ozG.ozH.jS(false);
                bGu.bHf().oDh.setVisibility(8);
                bGu.bHf().oCZ.start();
                aVZ();
            }
            if (bGu.bHf().oDh.getVisibility() != 8) {
                bGu.bHf().oDh.setVisibility(8);
            }
        }
    }

    protected final void xP(int i) {
        this.ozG.ozH.bGH().oBO.py(Math.max(0, i));
    }

    protected final void Pc(String str) {
        if (!this.oCE && !b((a) this.oBy.get(str))) {
            v.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
    }

    private void aVZ() {
        this.jHP = be.Ni();
        v.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", this.filename, Long.valueOf(this.jHP));
    }

    final void aWa() {
        if (this.jHP > 0) {
            this.jHQ = (int) (((long) this.jHQ) + ((be.Ni() - this.jHP) / 1000));
        }
        v.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", this.filename, Integer.valueOf(this.jHQ));
        this.jHP = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.tencent.mm.ui.chatting.gallery.j r13) {
        /*
        r12 = this;
        r6 = 0;
        r11 = 3;
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r0 = r12.oCw;
        r1 = r13.bHf();
        r1 = r1.oCZ;
        r1 = r1.getCurrentPosition();
        r12.oCw = r1;
        r1 = r12.oCw;
        if (r0 == r1) goto L_0x0186;
    L_0x0018:
        r0 = com.tencent.mm.sdk.platformtools.be.Ni();
        r12.oCy = r0;
        r0 = r13.bHf();
        r0 = r0.oCZ;
        r0 = r0.aPC();
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0096;
    L_0x002c:
        r2 = r12.oCx;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0096;
    L_0x0032:
        r12.oCx = r0;
        r1 = r12.oCz;
        switch(r1) {
            case 2: goto L_0x003d;
            case 3: goto L_0x0090;
            case 4: goto L_0x0093;
            default: goto L_0x0039;
        };
    L_0x0039:
        r12.oCz = r8;
    L_0x003b:
        r8 = r9;
    L_0x003c:
        return r8;
    L_0x003d:
        r0 = 21;
    L_0x003f:
        r2 = "MicroMsg.Imagegallery.handler.video";
        r3 = "%d rpt rptRepairEffect idKey %d errorTime %d filename %s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = r12.hashCode();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r8] = r5;
        r5 = java.lang.Integer.valueOf(r0);
        r4[r9] = r5;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r10] = r1;
        r1 = r12.filename;
        r4[r11] = r1;
        com.tencent.mm.sdk.platformtools.v.w(r2, r3, r4);
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = (long) r0;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = new java.lang.Object[r11];
        r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r3 = java.lang.Long.valueOf(r4);
        r2[r9] = r3;
        r3 = "";
        r2[r10] = r3;
        r0.h(r1, r2);
        goto L_0x0039;
    L_0x0090:
        r0 = 22;
        goto L_0x003f;
    L_0x0093:
        r0 = 23;
        goto L_0x003f;
    L_0x0096:
        r0 = r12.oCz;
        r1 = -1;
        if (r0 == r1) goto L_0x003b;
    L_0x009b:
        r0 = r12.oCz;
        r0 = r0 + 1;
        r12.oCz = r0;
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "media play is playing[%d], but surface is not update!! repair time[%d]";
        r2 = new java.lang.Object[r10];
        r3 = r12.oCz;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r3 = r12.oCA;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
        r0 = r12.oCA;
        if (r0 < r10) goto L_0x00c5;
    L_0x00c0:
        r0 = r12.oCs;
        r0.bHh();
    L_0x00c5:
        r0 = r12.oCz;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x003b;
            case 2: goto L_0x011c;
            case 3: goto L_0x013c;
            case 4: goto L_0x0161;
            default: goto L_0x00ca;
        };
    L_0x00ca:
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "rpt surface not update!!";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "%d rpt rptSurfaceNotUpdate %s";
        r2 = new java.lang.Object[r10];
        r3 = r12.hashCode();
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r3 = r12.filename;
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = new java.lang.Object[r11];
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r3 = java.lang.Long.valueOf(r4);
        r2[r9] = r3;
        r3 = "";
        r2[r10] = r3;
        r0.h(r1, r2);
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 20;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        r0 = -1;
        r12.oCz = r0;
        goto L_0x003b;
    L_0x011c:
        r0 = r12.oCw;
        r0 = r0 / 1000;
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.v.w(r1, r2, r3);
        r12.py(r0);
        r0 = r12.oCA;
        r0 = r0 + 1;
        r12.oCA = r0;
        goto L_0x003c;
    L_0x013c:
        r0 = r12.oCw;
        r0 = r0 + -2000;
        r0 = r0 / 1000;
        if (r0 >= 0) goto L_0x0145;
    L_0x0144:
        r0 = r8;
    L_0x0145:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.v.w(r1, r2, r3);
        r12.py(r0);
        r0 = r12.oCA;
        r0 = r0 + 1;
        r12.oCA = r0;
        goto L_0x003c;
    L_0x0161:
        r0 = r12.oCw;
        r0 = r0 + -4000;
        r0 = r0 / 1000;
        if (r0 >= 0) goto L_0x016a;
    L_0x0169:
        r0 = r8;
    L_0x016a:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.v.w(r1, r2, r3);
        r12.py(r0);
        r0 = r12.oCA;
        r0 = r0 + 1;
        r12.oCA = r0;
        goto L_0x003c;
    L_0x0186:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "check time[%d, %d], play time[%d, %d]";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = r12.oCy;
        r4 = java.lang.Long.valueOf(r4);
        r3[r8] = r4;
        r4 = com.tencent.mm.sdk.platformtools.be.Ni();
        r4 = java.lang.Long.valueOf(r4);
        r3[r9] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r10] = r0;
        r0 = r12.oCw;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r11] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        r0 = r12.oCy;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x003b;
    L_0x01b8:
        r0 = r12.oCy;
        r0 = com.tencent.mm.sdk.platformtools.be.ay(r0);
        r2 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x003b;
    L_0x01c4:
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "play time not update! request all video data to play. ";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        r0 = r12.ozG;
        r0 = r0.bGu();
        r0 = r0.oCZ;
        r0 = r0.getCurrentPosition();
        r12.bHb();
        r1 = r12.filename;
        r2 = r12.jHF;
        com.tencent.mm.as.p.d(r1, r0, r2);
        r0 = r12.ozG;
        r0 = r0.bGu();
        r0 = r0.oCZ;
        r0.stop();
        r0 = r12.oCs;
        r0.bHh();
        r0 = r12.oBy;
        r1 = r12.filename;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ui.chatting.gallery.i.a) r0;
        if (r0 == 0) goto L_0x003c;
    L_0x01ff:
        r1 = r0.aXd;
        if (r1 == 0) goto L_0x003c;
    L_0x0203:
        r1 = r0.aXd;
        r1 = bb(r1);
        r2 = r0.aXd;
        r0 = r0.pos;
        r3 = r12.jHF;
        r12.a(r2, r1, r0, r3);
        r12.oCy = r6;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.i.b(com.tencent.mm.ui.chatting.gallery.j):boolean");
    }
}
