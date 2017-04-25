package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.d;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sns.a.a.h;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements b.a, b.b {
    private String bdZ = "";
    private String bea = "";
    private String bnY;
    private String bssid;
    private String cPu = "";
    private String cqj = "";
    private String cqk = "";
    private d iVr;
    private boolean iyR = false;
    private h jSS = new h("VideoAdPlayerUI");
    private VideoPlayView jZA;
    private com.tencent.mm.modelsns.a jZB = null;
    private String jZC = "";
    private int jZD = 0;
    private String jZE = "";
    public String jZF = "";
    public String jZG = "";
    private int jZH = 0;
    private int jZI = 0;
    private String jZJ = "";
    private String jZK;
    private String jZL = "";
    private long jZM = 0;
    private int jZN = 0;
    private int jZO = 0;
    private boolean jZP = false;
    private aib jZQ = null;
    private String jZR;
    private int jZS;
    private String[] jZT = null;
    private String[] jZU = null;
    private String jbF = "";
    private boolean jdE = false;
    private String mediaId = "";
    private String ssid;
    private String url = "";

    static /* synthetic */ void n(VideoAdPlayerUI videoAdPlayerUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.jZC);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.jZE);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.bea);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.jZQ.jZD);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.cqj);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.cqk);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.jZF);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.jZG);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.bnY);
        String str = "sns_";
        if (videoAdPlayerUI.jZI == j.b.Sight.value || videoAdPlayerUI.jZI == j.b.AdUrl.value) {
            str = "sns_" + videoAdPlayerUI.jZL;
        } else if (videoAdPlayerUI.jZI == j.b.Chat.value || videoAdPlayerUI.jZI == j.b.TalkChat.value) {
            str = "msg_" + videoAdPlayerUI.jZM;
        } else if (videoAdPlayerUI.jZI == j.b.Fav.value) {
            str = "fav_" + k.xF() + "_" + videoAdPlayerUI.jZN;
        }
        String fz = o.fz(str);
        o.yx().n(fz, true).l("prePublishId", str);
        intent.putExtra("reportSessionId", fz);
        c.b(videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.jZS != 0) {
            int i = videoAdPlayerUI.jSS.jcB.jdx;
            if (videoAdPlayerUI.iyR && videoAdPlayerUI.jSS.jcB.jdB != 0) {
                i += (int) (be.az(videoAdPlayerUI.jSS.jcB.jdB) / 1000);
            }
            ak.vy().a(new com.tencent.mm.modelstat.h(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + be.Nh() + "," + videoAdPlayerUI.jZR + "," + videoAdPlayerUI.jZD, (int) be.Nh()), 0);
        }
    }

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        bp bpVar = new bp();
        int i = videoAdPlayerUI.jZQ.jZD;
        String str = videoAdPlayerUI.jZE;
        String str2 = videoAdPlayerUI.jZQ.mHW;
        String str3 = videoAdPlayerUI.cqj;
        String str4 = videoAdPlayerUI.cqk;
        String str5 = videoAdPlayerUI.bea;
        String str6 = videoAdPlayerUI.bdZ;
        String str7 = videoAdPlayerUI.jZJ;
        String str8 = videoAdPlayerUI.jZF;
        String str9 = videoAdPlayerUI.jZG;
        String str10 = videoAdPlayerUI.bnY;
        qf qfVar = new qf();
        qg qgVar = new qg();
        pw pwVar = new pw();
        pwVar.uG(5);
        pwVar.IL(str6);
        pwVar.IC(str2);
        pwVar.uF(i);
        pwVar.Iw(str);
        pwVar.Ix("");
        pwVar.IU(str10);
        pz pzVar = new pz();
        pzVar.cqi = str;
        pzVar.mtD = i;
        pzVar.cqg = str2;
        pzVar.cqk = str4;
        pzVar.cqj = str3;
        pzVar.cql = str5;
        pzVar.cqm = str8;
        pzVar.cqn = str9;
        pwVar.a(pzVar);
        qgVar.Jn(str7);
        qgVar.Jo(k.xF());
        qgVar.uN(0);
        qgVar.dV(be.Ni());
        qfVar.a(qgVar);
        qfVar.mtR.add(pwVar);
        bpVar.aZd.title = pwVar.title;
        bpVar.aZd.desc = pwVar.title;
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 4;
        bpVar.aZd.aXH = videoAdPlayerUI;
        bpVar.aZd.aZl = 24;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        if (bpVar.aZe.ret == 0 && videoAdPlayerUI.jZI != 0) {
            j.a(j.c.Fav, videoAdPlayerUI.jZG, videoAdPlayerUI.jZF, videoAdPlayerUI.jZH, videoAdPlayerUI.jZI, videoAdPlayerUI.jZJ, videoAdPlayerUI.jZK, videoAdPlayerUI.jZL, videoAdPlayerUI.jZM, videoAdPlayerUI.jZN, videoAdPlayerUI.jZO, 0);
        }
        if (videoAdPlayerUI.jdE) {
            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(videoAdPlayerUI.jbF, 11, 6, "", 2), 0);
        }
        if (videoAdPlayerUI.jZS != 0) {
            int i2 = videoAdPlayerUI.jSS.jcB.jdx;
            if (videoAdPlayerUI.iyR && videoAdPlayerUI.jSS.jcB.jdB != 0) {
                i2 += (int) (be.az(videoAdPlayerUI.jSS.jcB.jdB) / 1000);
            }
            ak.vy().a(new com.tencent.mm.modelstat.h(13228, "1,5," + i2 + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + be.Nh() + "," + videoAdPlayerUI.jZR + "," + videoAdPlayerUI.jZD, (int) be.Nh()), 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        getWindow().setFlags(1024, 1024);
        this.jZT = new String[]{getString(2131235368), getString(2131235369), getString(2131235367)};
        this.jZU = new String[]{getString(2131235368), getString(2131235369)};
        this.iVr = new d();
        this.jZB = com.tencent.mm.modelsns.a.m(getIntent());
        this.cPu = getIntent().getStringExtra("KFullVideoPath");
        this.jZC = getIntent().getStringExtra("KStremVideoUrl");
        this.bea = getIntent().getStringExtra("KThumUrl");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.jdE = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.jZE = be.ah(getIntent().getStringExtra("KMediaTitle"), "");
        this.jZD = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.jZP = getIntent().getBooleanExtra("KBlockFav", false);
        this.cqj = getIntent().getStringExtra("StreamWording");
        this.cqk = getIntent().getStringExtra("StremWebUrl");
        this.jZF = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.jZG = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.jZH = getIntent().getIntExtra("KSta_SourceType", 0);
        this.jZI = getIntent().getIntExtra("KSta_Scene", 0);
        this.jZJ = getIntent().getStringExtra("KSta_FromUserName");
        this.jZK = getIntent().getStringExtra("KSta_ChatName");
        this.jZL = getIntent().getStringExtra("KSta_SnSId");
        this.jZM = getIntent().getLongExtra("KSta_MsgId", 0);
        this.jZN = getIntent().getIntExtra("KSta_FavID", 0);
        this.jZO = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.bnY = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.jbF = be.ah(getIntent().getStringExtra("KViewId"), "");
        this.jZR = be.ah(getIntent().getStringExtra("ReportArgs"), "");
        this.jZS = getIntent().getIntExtra("NeedReportData", 0);
        if (this.jZS != 0) {
            WifiInfo connectionInfo = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
            this.ssid = connectionInfo.getSSID();
            this.bssid = connectionInfo.getBSSID();
        }
        this.jZQ = new aib();
        this.jZQ.mHP = this.bea;
        this.jZQ.mHW = this.jZC;
        this.jZQ.gID = this.mediaId;
        this.jZQ.glb = this.url;
        this.jZQ.mHO = 1;
        this.jZQ.jZD = this.jZD;
        this.jSS.jcz = be.Nj();
        v.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.jZQ.gID + " attachurl:" + this.jZQ.mHW + " videoattachTotalTime:" + this.jZQ.jZD + " streamvideowording: " + this.cqj + " streamvideoweburl: " + this.cqk + " mediaTitle: " + this.jZE + " thumburl " + this.bea + " streamvideoaduxinfo " + this.jZF + " streamvideopublishid " + this.jZG);
        if (be.kS(this.cPu)) {
            String cA = al.cA(ad.xh(), this.jZQ.gID);
            this.cPu = cA + i.j(this.jZQ);
        }
        if (be.kS(this.bdZ) || !e.aR(this.bdZ)) {
            cA = "attach" + this.jZQ.gID;
            this.bdZ = al.cA(ad.xh(), cA) + i.zK(cA);
        }
        if (!e.aR(this.bdZ)) {
            try {
                aib com_tencent_mm_protocal_c_aib = new aib();
                com_tencent_mm_protocal_c_aib.az(this.jZQ.toByteArray());
                com_tencent_mm_protocal_c_aib.gID = "attach" + com_tencent_mm_protocal_c_aib.gID;
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.jZQ);
                eVar.jdO = 1;
                eVar.jdN = this.jZQ.gID;
                ad.aSz().a(com_tencent_mm_protocal_c_aib, 7, eVar, com.tencent.mm.storage.ak.nvx);
            } catch (Exception e) {
                v.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(128);
        }
        this.jZA = (VideoPlayView) findViewById(2131759620);
        VideoPlayView videoPlayView = this.jZA;
        AdVideoPlayerLoadingBar adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.nDR.nEl);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BackwardSupportUtil.b.a(videoPlayView.getContext(), videoPlayView.getContext().getResources().getDimension(2131493158));
        videoPlayView.iVD = adVideoPlayerLoadingBar;
        videoPlayView.eJz.fE(true);
        videoPlayView.addView((View) videoPlayView.iVD, layoutParams);
        videoPlayView.iVD.a(new com.tencent.mm.plugin.sight.decode.ui.b(videoPlayView) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final void aPv() {
                this.iVS.cnC.removeCallbacks(this.iVS.iVQ);
                this.iVS.aPz();
            }

            public final void pB(int i) {
                v.i("MicroMsg.VideoPlayView", "onSeek time " + i);
                this.iVS.iVE = (double) i;
                this.iVS.eJz.i((double) i);
                this.iVS.cnC.removeCallbacks(this.iVS.iVQ);
                this.iVS.cnC.postDelayed(this.iVS.iVQ, 3000);
            }
        });
        videoPlayView.iVD.d(new OnClickListener(videoPlayView) {
            final /* synthetic */ VideoPlayView iVS;

            {
                this.iVS = r1;
            }

            public final void onClick(View view) {
                this.iVS.cnC.removeCallbacks(this.iVS.iVQ);
                this.iVS.cnC.postDelayed(this.iVS.iVQ, 3000);
                if (this.iVS.eJz.isPlaying()) {
                    this.iVS.pC(-1);
                    if (this.iVS.iVD != null) {
                        this.iVS.iVD.fA(false);
                        return;
                    }
                    return;
                }
                this.iVS.fC(false);
                this.iVS.eJz.i(this.iVS.iVE);
                if (this.iVS.iVD != null) {
                    this.iVS.iVD.fA(true);
                }
            }
        });
        videoPlayView.iVD.fA(videoPlayView.eJz.isPlaying());
        if (videoPlayView.iVD != null) {
            ((View) videoPlayView.iVD).setVisibility(8);
        }
        adVideoPlayerLoadingBar.py(0);
        this.jZA.iVB = new VideoPlayView.a(this) {
            final /* synthetic */ VideoAdPlayerUI jZV;

            {
                this.jZV = r1;
            }

            public final void fF(boolean z) {
                if (z) {
                    this.jZV.jSS.jcB.jdA = this.jZV.getResources().getConfiguration().orientation == 2 ? 2 : 1;
                    this.jZV.jSS.jcB.jdB = be.Nj();
                    this.jZV.jSS.jcB.jdz = 2;
                    this.jZV.jSS.jcB.jdx = 0;
                }
                this.jZV.jSS.jcB.jdB = be.Nj();
                this.jZV.iVr.a(this.jZV.jZA);
                if (this.jZV.jZS != 0) {
                    ak.vy().a(new com.tencent.mm.modelstat.h(13227, "1,1,0," + this.jZV.ssid + "," + this.jZV.bssid + "," + be.Nh() + "," + this.jZV.jZR + "," + this.jZV.jZD, (int) be.Nh()), 0);
                }
                this.jZV.iyR = true;
            }

            public final void aPD() {
                this.jZV.iVr.aN(false);
                com.tencent.mm.plugin.sns.a.a.a.a aVar = this.jZV.jSS.jcB;
                aVar.jdx += (int) be.az(this.jZV.jSS.jcB.jdB);
                this.jZV.iyR = false;
            }

            public final void aPE() {
                v.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
                com.tencent.mm.plugin.sns.a.a.a.a aVar = this.jZV.jSS.jcB;
                aVar.jdw++;
                this.jZV.iyR = false;
                if (this.jZV.jZS != 0) {
                    ak.vy().a(new com.tencent.mm.modelstat.h(13227, "1,2," + this.jZV.jZD + "," + this.jZV.ssid + "," + this.jZV.bssid + "," + be.Nh() + "," + this.jZV.jZR + "," + this.jZV.jZD, (int) be.Nh()), 0);
                }
            }

            public final void pD(int i) {
                if (this.jZV.jZD == 0) {
                    this.jZV.jZD = i;
                    this.jZV.jZQ.jZD = i;
                }
            }
        };
        VideoPlayView videoPlayView2 = this.jZA;
        int i = this.jZQ.jZD;
        if (videoPlayView2.iVD.aPr() != i) {
            videoPlayView2.iVD.pz(i);
        }
        if (e.aR(this.cPu)) {
            this.jSS.jcx = 1;
            this.jZA.setVideoPath(this.cPu);
        } else {
            this.jZA.fpm.setVisibility(0);
            this.jZA.iVM = true;
            ad.aSz().a(this.jZQ, 6, null, com.tencent.mm.storage.ak.nvx);
        }
        videoPlayView2 = this.jZA;
        videoPlayView2.iVH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoAdPlayerUI jZV;

            {
                this.jZV = r1;
            }

            public final void onClick(View view) {
                this.jZV.finish();
            }
        });
        videoPlayView2 = this.jZA;
        videoPlayView2.iVI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoAdPlayerUI jZV;

            {
                this.jZV = r1;
            }

            public final void onClick(View view) {
                String[] k;
                Object obj = this.jZV;
                if (this.jZV.jZP) {
                    k = this.jZV.jZU;
                } else {
                    k = this.jZV.jZT;
                }
                g.a(obj, null, k, null, new g.c(this) {
                    final /* synthetic */ AnonymousClass3 jZW;

                    {
                        this.jZW = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("ad_video_title", this.jZW.jZV.jZE);
                                intent.putExtra("Retr_Msg_Type", 2);
                                c.a(this.jZW.jZV, ".ui.transmit.SelectConversationUI", intent, 4097);
                                return;
                            case 1:
                                VideoAdPlayerUI.n(this.jZW.jZV);
                                return;
                            case 2:
                                VideoAdPlayerUI.o(this.jZW.jZV);
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        });
        videoPlayView2 = this.jZA;
        CharSequence charSequence = this.cqj;
        OnClickListener anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ VideoAdPlayerUI jZV;

            {
                this.jZV = r1;
            }

            public final void onClick(View view) {
                if (this.jZV.jZI != 0) {
                    j.a(j.a.DetailInVideo, this.jZV.jZG, this.jZV.jZF, this.jZV.jZH, this.jZV.jZI, this.jZV.jZJ, this.jZV.jZK, this.jZV.jZL, this.jZV.jZM, this.jZV.jZN, this.jZV.jZO);
                }
                if (this.jZV.jZS != 0) {
                    int i = this.jZV.jSS.jcB.jdx;
                    if (this.jZV.iyR && this.jZV.jSS.jcB.jdB != 0) {
                        i += (int) (be.az(this.jZV.jSS.jcB.jdB) / 1000);
                    }
                    ak.vy().a(new com.tencent.mm.modelstat.h(13228, "1,1," + i + "," + this.jZV.ssid + "," + this.jZV.bssid + "," + be.Nh() + "," + this.jZV.jZR + "," + this.jZV.jZD, (int) be.Nh()), 0);
                }
                this.jZV.finish();
                final Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", this.jZV.bnY);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", this.jZV.cqk);
                intent.putExtra("useJs", true);
                if (this.jZV.jdE) {
                    ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jZV.jbF, 18, 6, "", 2), 0);
                }
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 jZX;

                    public final void run() {
                        com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.jZX.jZV);
                    }
                });
            }
        };
        videoPlayView2.iVG = charSequence;
        videoPlayView2.iVF.setText(charSequence);
        videoPlayView2.iVF.setOnClickListener(anonymousClass4);
        this.jZA.aPA();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.jZA;
            if (videoPlayView2.iVI != null) {
                videoPlayView2.iVJ = false;
                videoPlayView2.iVI.setVisibility(4);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[]{Integer.valueOf(i)});
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : be.g(stringExtra.split(","))) {
                    String str2;
                    int i3;
                    v.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[]{str});
                    com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                    aVar.title = this.jZE;
                    aVar.type = 4;
                    if (be.kS(this.jZQ.glb)) {
                        aVar.url = this.jZQ.mHW;
                    } else {
                        aVar.url = this.jZQ.glb;
                    }
                    if (be.kS(this.jZQ.mHZ)) {
                        str2 = this.jZQ.mHP;
                    } else {
                        str2 = this.jZQ.mHZ;
                    }
                    aVar.thumburl = str2;
                    aVar.cqg = this.jZQ.mHW;
                    aVar.cqh = this.jZQ.jZD;
                    aVar.cqi = this.jZE;
                    aVar.cqk = this.cqk;
                    aVar.cqj = this.cqj;
                    aVar.cql = this.bea;
                    aVar.cqm = this.jZF;
                    aVar.cqn = this.jZG;
                    aVar.bnY = this.bnY;
                    byte[] c = FileOp.c(this.bdZ, 0, -1);
                    String str3 = "MicroMsg.VideoPlayerUI";
                    String str4 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    if (c == null) {
                        i3 = 0;
                    } else {
                        i3 = c.length;
                    }
                    objArr[0] = Integer.valueOf(i3);
                    v.i(str3, str4, objArr);
                    l.a(aVar, "", "", str, "", c);
                    if (this.jZS != 0) {
                        int i4 = this.jSS.jcB.jdx;
                        if (this.iyR && this.jSS.jcB.jdB != 0) {
                            i4 += (int) (be.az(this.jSS.jcB.jdB) / 1000);
                        }
                        ak.vy().a(new com.tencent.mm.modelstat.h(13228, "1,3," + i4 + "," + this.ssid + "," + this.bssid + "," + be.Nh() + "," + this.jZR + "," + this.jZD, (int) be.Nh()), 0);
                    }
                    com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra2, str);
                    if (this.jdE) {
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jbF, 12, 6, "", 2), 0);
                    }
                    if (this.jZI != 0) {
                        j.c cVar;
                        int el;
                        boolean dE = m.dE(str);
                        if (dE) {
                            cVar = j.c.Chatroom;
                        } else {
                            cVar = j.c.Chat;
                        }
                        str2 = this.jZG;
                        str3 = this.jZF;
                        int i5 = this.jZH;
                        int i6 = this.jZI;
                        String str5 = this.jZJ;
                        String str6 = this.jZK;
                        String str7 = this.jZL;
                        long j = this.jZM;
                        int i7 = this.jZN;
                        int i8 = this.jZO;
                        if (dE) {
                            el = com.tencent.mm.model.i.el(str);
                        } else {
                            el = 0;
                        }
                        j.a(cVar, str2, str3, i5, i6, str5, str6, str7, j, i7, i8, el);
                    }
                }
                com.tencent.mm.ui.snackbar.a.f(this, getString(2131233278));
            } else if (this.jdE) {
                ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jbF, 13, 6, "", 2), 0);
            }
        }
        if (4098 == i) {
            if (this.jZI != 0) {
                j.a(j.c.Sns, this.jZG, this.jZF, this.jZH, this.jZI, this.jZJ, this.jZK, this.jZL, this.jZM, this.jZN, this.jZO, 0);
            }
            if (-1 == i) {
                if (this.jdE) {
                    ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jbF, 15, 6, "", 2), 0);
                }
            } else if (this.jdE) {
                ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(this.jbF, 16, 6, "", 2), 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(128);
        if (this.jZI != 0) {
            j.a(j.a.LeaveCompleteVideo, this.jZG, this.jZF, this.jZH, this.jZI, this.jZJ, this.jZK, this.jZL, this.jZM, this.jZN, this.jZO);
        }
        if (this.jdE) {
            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.d(this.jbF, 6, this.jSS.jcy, null, null, 2, this.jSS.aQV()), 0);
        }
        if (this.jZS != 0) {
            int i = this.jSS.jcB.jdx;
            if (this.iyR && this.jSS.jcB.jdB != 0) {
                i += (int) (be.az(this.jSS.jcB.jdB) / 1000);
            }
            ak.vy().a(new com.tencent.mm.modelstat.h(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + be.Nh() + "," + this.jZR + "," + this.jZD, (int) be.Nh()), 0);
        }
    }

    protected void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        v.i("MicroMsg.VideoPlayerUI", "onpause  " + i);
        re(i);
        if (this.jZA != null && this.jZA.isPlaying()) {
            this.jZA.pause();
        }
        if (this.jZA != null) {
            v.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.jZA.onDetach();
        }
        ad.aSz().jiM.remove(this);
        ad.aSz().b((b.b) this);
    }

    protected void onResume() {
        super.onResume();
        ad.aSz().jiM.add(this);
        ad.aSz().a((b.b) this);
    }

    protected final int getLayoutId() {
        return 2130904572;
    }

    public final void cx(String str, String str2) {
        v.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.jZA.isPlaying());
        if (!this.jZA.isPlaying()) {
            this.jZA.fD(false);
            if (str2.equals(this.jZA.cPu)) {
                this.jZA.i(this.jZA.aPB());
                this.jZA.start();
                v.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
                return;
            }
            this.jZA.setVideoPath(str2);
            this.jZA.i(this.jZA.aPB());
            v.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        }
    }

    public final void Aa(String str) {
    }

    public final void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    public final void aj(String str, boolean z) {
        v.i("MicroMsg.VideoPlayerUI", "onSightFinish " + str);
        this.jZA.iVM = false;
        this.jZA.setVideoPath(this.cPu);
        this.jZA.i(this.jZA.aPB());
        this.jZA.fD(false);
        if (this.jdE && !be.kS(str) && this.jZQ != null && str.equals(this.jZQ.gID) && FileOp.aR(this.cPu)) {
            this.jSS.jcx = 1;
        }
    }

    protected final int NO() {
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.jZA;
        v.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.iVR);
        if (videoPlayView.iVR != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.iVR = configuration.orientation;
            if (videoPlayView.iVR == 2) {
                videoPlayView.fIV.setVisibility(8);
            }
        }
        re(configuration.orientation);
    }

    private void re(int i) {
        if (this.jdE) {
            this.jSS.pP(this.jZA.getDuration());
            this.jSS.jcB.jdB = be.Nj();
            this.jSS.jcB.jdA = i == 2 ? 2 : 1;
            this.jSS.jcB.jdz = 2;
            v.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.jSS.jcB.jdA);
        }
    }
}
