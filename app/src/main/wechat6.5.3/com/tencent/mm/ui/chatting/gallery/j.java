package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.a.a.f;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.gallery.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;

public final class j {
    String bhM = SQLiteDatabase.KeyEmpty;
    String bhO;
    long dhH;
    public TextView fQK;
    int jzn = 0;
    public int kB;
    public View kad;
    public b oAb;
    public b oCO;
    public HashMap<String, Boolean> oCP = new HashMap();
    public RelativeLayout oCQ;
    public g oCR;
    public ImageView oCS;
    public ImageView oCT;
    public MMPinProgressBtn oCU;
    public View oCV;
    public RelativeLayout oCW;
    public ImageView oCX;
    public ImageView oCY;
    public g oCZ;
    public MMPinProgressBtn oDa;
    public TextView oDb;
    public LinearLayout oDc;
    public TextView oDd;
    public TextView oDe;
    public ImageView oDf;
    public ProgressBar oDg;
    public ProgressBar oDh;
    public LinearLayout oDi;
    public TextView oDj;
    public ImageView oDk;
    public MultiTouchImageView oDl;
    int oDm = 0;
    int oDn = 0;

    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] ozT = new int[b.values().length];

        static {
            try {
                ozT[b.image.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ozT[b.video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ozT[b.sight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ozT[b.unkown.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @TargetApi(11)
    public j(b bVar, View view) {
        this.kad = view;
        this.oAb = bVar;
        this.oDl = (MultiTouchImageView) view.findViewById(f.Jm);
        this.oDh = (ProgressBar) view.findViewById(2131757474);
        if (d.dW(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public static void G(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public final j bHc() {
        if (this.oDc == null) {
            this.oDc = (LinearLayout) ((ViewStub) this.kad.findViewById(2131757472)).inflate();
            this.oDg = (ProgressBar) this.oDc.findViewById(2131756219);
            this.oDd = (TextView) this.oDc.findViewById(2131756941);
            this.oDe = (TextView) this.oDc.findViewById(2131757476);
            this.oDf = (ImageView) this.oDc.findViewById(2131757475);
        }
        return this;
    }

    public final j bHd() {
        if (this.oDi == null) {
            this.oDi = (LinearLayout) ((ViewStub) this.kad.findViewById(2131757473)).inflate();
            this.oDk = (ImageView) this.oDi.findViewById(2131757477);
            this.oDj = (TextView) this.oDi.findViewById(2131756625);
        }
        return this;
    }

    public final j bHe() {
        if (this.oCQ == null) {
            this.oCQ = (RelativeLayout) ((ViewStub) this.kad.findViewById(2131757471)).inflate();
            this.oCR = o.do(this.kad.getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.oCQ.addView((View) this.oCR, layoutParams);
            ((View) this.oCR).setVisibility(8);
            this.oCV = this.oCQ.findViewById(2131757003);
            this.oCV.setVisibility(8);
            this.fQK = (TextView) this.oCQ.findViewById(2131759210);
            this.oCU = (MMPinProgressBtn) this.oCQ.findViewById(2131759193);
            this.oCU.setVisibility(8);
            this.oCS = (ImageView) this.oCQ.findViewById(2131759192);
            this.oCT = (ImageView) this.oCQ.findViewById(2131759194);
            this.oCR.a(new a(this) {
                final /* synthetic */ j oDo;

                {
                    this.oDo = r1;
                }

                public final void abH() {
                }

                public final void bp(int i, int i2) {
                    this.oDo.oCR.stop();
                    final String str = (String) ((View) this.oDo.oCR).getTag();
                    com.tencent.mm.sdk.b.b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.aOU() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + be.ah(str, SQLiteDatabase.KeyEmpty)).getBytes(), 2), "FullScreenPlaySight");
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 oDp;

                        public final void run() {
                            if (be.kS(str)) {
                                com.tencent.mm.ui.base.g.f(this.oDp.oDo.oAb.ozH, 2131235793, 2131231868);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(new File(str)), "video/*");
                            try {
                                this.oDp.oDo.oAb.ozH.startActivity(Intent.createChooser(intent, this.oDp.oDo.oAb.ozH.nDR.nEl.getString(2131232752)));
                            } catch (Exception e) {
                                v.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                                com.tencent.mm.ui.base.g.f(this.oDp.oDo.oAb.ozH, 2131232691, 2131232692);
                            }
                        }
                    });
                    this.oDo.oCP.put(str, Boolean.valueOf(true));
                }

                public final void pa() {
                    this.oDo.oCR.start();
                    this.oDo.oCV.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 oDp;

                        {
                            this.oDp = r1;
                        }

                        public final void run() {
                            if (this.oDp.oDo.oCV != null && this.oDp.oDo.oCV.getVisibility() != 0) {
                                if (this.oDp.oDo.oCV.getTag() != null && (this.oDp.oDo.oCV.getTag() instanceof n)) {
                                    n nVar = (n) this.oDp.oDo.oCV.getTag();
                                    if (nVar.dhT != null && !be.kS(nVar.dhT.cqg)) {
                                        this.oDp.oDo.oCV.setVisibility(8);
                                        return;
                                    } else if (!(nVar.dhT == null || be.kS(nVar.dhT.cqj) || be.kS(nVar.dhT.cqk))) {
                                        this.oDp.oDo.oCV.setVisibility(8);
                                        return;
                                    }
                                }
                                this.oDp.oDo.oCV.setVisibility(0);
                                this.oDp.oDo.oCV.startAnimation(AnimationUtils.loadAnimation(this.oDp.oDo.oCV.getContext(), 2130968622));
                            }
                        }
                    });
                }

                public final int bq(int i, int i2) {
                    return 0;
                }

                public final void br(int i, int i2) {
                }
            });
            this.fQK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j oDo;

                {
                    this.oDo = r1;
                }

                public final void onClick(View view) {
                    if (view.getTag() != null && (view.getTag() instanceof at)) {
                        at atVar = (at) view.getTag();
                        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, atVar);
                        n lp = p.lp(atVar.field_imgPath);
                        ayk com_tencent_mm_protocal_c_ayk = lp.dhT;
                        if (com_tencent_mm_protocal_c_ayk != null && !t.kS(com_tencent_mm_protocal_c_ayk.cqg)) {
                            int i;
                            k.KV();
                            String ld = com.tencent.mm.as.o.ld(atVar.field_imgPath);
                            Intent intent = new Intent();
                            intent.putExtra("IsAd", false);
                            intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_ayk.cqg);
                            intent.putExtra("KThumUrl", com_tencent_mm_protocal_c_ayk.cql);
                            intent.putExtra("KThumbPath", ld);
                            intent.putExtra("KMediaId", "fakeid_" + atVar.field_msgId);
                            intent.putExtra("KMediaVideoTime", com_tencent_mm_protocal_c_ayk.mtD);
                            intent.putExtra("KMediaTitle", com_tencent_mm_protocal_c_ayk.cqi);
                            intent.putExtra("StreamWording", com_tencent_mm_protocal_c_ayk.cqj);
                            intent.putExtra("StremWebUrl", com_tencent_mm_protocal_c_ayk.cqk);
                            String str = atVar.field_talker;
                            boolean endsWith = str.endsWith("@chatroom");
                            ld = endsWith ? aw.fL(atVar.field_content) : str;
                            intent.putExtra("KSta_StremVideoAduxInfo", com_tencent_mm_protocal_c_ayk.cqm);
                            intent.putExtra("KSta_StremVideoPublishId", com_tencent_mm_protocal_c_ayk.cqn);
                            intent.putExtra("KSta_SourceType", 1);
                            String str2 = "KSta_Scene";
                            if (endsWith) {
                                i = com.tencent.mm.ui.chatting.a.b.TalkChat.value;
                            } else {
                                i = com.tencent.mm.ui.chatting.a.b.Chat.value;
                            }
                            intent.putExtra(str2, i);
                            intent.putExtra("KSta_FromUserName", ld);
                            intent.putExtra("KSta_ChatName", str);
                            intent.putExtra("KSta_MsgId", atVar.field_msgSvrId);
                            intent.putExtra("KSta_SnsStatExtStr", lp.bnY);
                            if (endsWith) {
                                intent.putExtra("KSta_ChatroomMembercount", i.el(str));
                            }
                            c.b(this.oDo.oAb.ozH.nDR.nEl, "sns", ".ui.VideoAdPlayerUI", intent);
                        } else if (com_tencent_mm_protocal_c_ayk != null && !be.kS(com_tencent_mm_protocal_c_ayk.cqj) && !be.kS(com_tencent_mm_protocal_c_ayk.cqk)) {
                            v.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + com_tencent_mm_protocal_c_ayk.cqk);
                            final Intent intent2 = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", lp.bnY);
                            intent2.putExtra("jsapiargs", bundle);
                            intent2.putExtra("rawUrl", com_tencent_mm_protocal_c_ayk.cqk);
                            intent2.putExtra("useJs", true);
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(SQLiteDatabase.KeyEmpty, 18, 5, SQLiteDatabase.KeyEmpty, 2), 0);
                            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 oDq;

                                public final void run() {
                                    c.b(this.oDq.oDo.oAb.ozH.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
                                }
                            });
                        }
                    }
                }
            });
        }
        return this;
    }

    public final j bHf() {
        if (this.oCW == null) {
            this.oCW = (RelativeLayout) ((ViewStub) this.kad.findViewById(2131755866)).inflate();
            this.oCX = (ImageView) this.oCW.findViewById(2131757479);
            this.oCY = (ImageView) this.oCW.findViewById(2131757480);
            this.oCY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j oDo;

                {
                    this.oDo = r1;
                }

                public final void onClick(View view) {
                    if (this.oDo.oAb != null) {
                        v.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", Integer.valueOf(this.oDo.hashCode()), Integer.valueOf(this.oDo.kB));
                        this.oDo.oAb.xx(this.oDo.kB);
                    }
                }
            });
            if (d.dW(14)) {
                this.oCZ = new VideoTextureView(this.kad.getContext());
            } else {
                this.oCZ = new VideoSurfaceView(this.kad.getContext());
            }
            this.oDb = (TextView) this.kad.findViewById(2131757470);
            this.oCZ.fE(true);
            this.oCW.addView((View) this.oCZ, 2, new RelativeLayout.LayoutParams(-1, -1));
            this.oDa = (MMPinProgressBtn) this.oCW.findViewById(2131757481);
            this.oDa.setVisibility(8);
            ((View) this.oCZ).setVisibility(8);
            this.oCZ.a(new a(this) {
                final /* synthetic */ j oDo;

                {
                    this.oDo = r1;
                }

                public final void abH() {
                    if (this.oDo.oAb != null) {
                        this.oDo.oAb.ozN.bHa();
                    }
                }

                public final void bp(int i, int i2) {
                    v.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
                    if (this.oDo.oAb != null) {
                        this.oDo.oAb.ozN.dl(i, i2);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(12084, Integer.valueOf(this.oDo.oDm), Integer.valueOf(this.oDo.jzn * 1000), Integer.valueOf(0), Integer.valueOf(4), this.oDo.bhM, Integer.valueOf(this.oDo.oDn), this.oDo.bhO, Long.valueOf(this.oDo.dhH));
                }

                public final void pa() {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 oDr;

                        {
                            this.oDr = r1;
                        }

                        public final void run() {
                            this.oDr.oDo.oAb.ozH.jS(true);
                            b bVar = this.oDr.oDo.oAb;
                            bVar.ozN.xO(this.oDr.oDo.kB);
                            i iVar = this.oDr.oDo.oAb.ozN;
                            v.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + iVar.jHF);
                            iVar.bHb();
                            iVar.aWa();
                            ad.o(new Runnable(iVar) {
                                final /* synthetic */ i oCH;

                                {
                                    this.oCH = r1;
                                }

                                public final void run() {
                                    this.oCH.oCv = true;
                                    this.oCH.iVr.aN(false);
                                    this.oCH.aWa();
                                    if (this.oCH.jHF) {
                                        this.oCH.oCs.bHg();
                                        this.oCH.oCs.reset();
                                        this.oCH.jHF = false;
                                        this.oCH.oCE = false;
                                    }
                                    p.d(this.oCH.filename, 0, this.oCH.jHF);
                                    if (this.oCH.oBy != null) {
                                        a aVar = (a) this.oCH.oBy.get(this.oCH.filename);
                                        if (aVar != null) {
                                            j bGu = this.oCH.ozG.bGu();
                                            bGu.bHf().oCZ.stop();
                                            this.oCH.oCw = 0;
                                            if (this.oCH.ozG.ozH.oCd) {
                                                this.oCH.ozG.ozH.oCe.QI();
                                                this.oCH.xP(this.oCH.ozG.ozH.bGH().oBO.iUN);
                                            } else {
                                                this.oCH.a(bGu, aVar.aXd, aVar.pos);
                                                this.oCH.xP(0);
                                            }
                                            if (bGu.bHf().oDh.getVisibility() != 8) {
                                                bGu.bHf().oDh.setVisibility(8);
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    });
                }

                public final int bq(final int i, final int i2) {
                    v.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", Integer.valueOf(i), Integer.valueOf(this.oDo.jzn), Integer.valueOf(i2), Integer.valueOf(this.oDo.oDm), Integer.valueOf(this.oDo.oDn), this.oDo.bhM);
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 oDr;

                        public final void run() {
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(this.oDr.oDo.oDm);
                            objArr[1] = Integer.valueOf(i2 <= 0 ? this.oDr.oDo.jzn * 1000 : i2);
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = this.oDr.oDo.bhM;
                            objArr[5] = Integer.valueOf(this.oDr.oDo.oDn);
                            objArr[6] = this.oDr.oDo.bhO;
                            objArr[7] = Long.valueOf(this.oDr.oDo.dhH);
                            gVar.h(12084, objArr);
                        }
                    });
                    return 0;
                }

                public final void br(int i, int i2) {
                }
            });
        }
        return this;
    }

    public final void a(boolean z, float f) {
        if (z) {
            View view = (View) bHf().oCZ;
            view.setAlpha(f);
            G(view, 0);
            if (((double) f) >= 1.0d) {
                G(bHf().oCX, 8);
                G(bHf().oCY, 8);
                return;
            }
            return;
        }
        G((View) bHf().oCZ, 8);
        G(bHf().oCX, 0);
        G(bHf().oCY, 0);
    }
}
