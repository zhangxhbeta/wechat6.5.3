package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.jj;
import com.tencent.mm.e.a.nk;
import com.tencent.mm.e.a.nn;
import com.tencent.mm.e.a.oh;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.an;
import com.tencent.mm.plugin.sns.e.ao;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.ac.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;

public class OnlineVideoView extends RelativeLayout implements a, g.a {
    private String bde;
    private aib boL;
    private int bpk;
    private boolean bpl;
    private int bpm;
    private int cLB;
    private int duration;
    private ac eIU;
    private ah eJF;
    boolean eJx;
    private RelativeLayout hsA;
    private ProgressBar ilM;
    VideoTextureView jHA;
    private TextView jHB;
    private MMPinProgressBtn jHC;
    private TextView jHD;
    private ac jHE;
    private boolean jHF;
    private boolean jHG;
    private long jHH;
    private long jHI;
    private int jHJ;
    private ah jHK;
    private b jHL;
    private c jHM;
    c jHN;
    private VideoTextureView.a jHO;
    private long jHP;
    private int jHQ;
    private int jHv;
    boolean jHw;
    String jHx;
    private boolean jHy;
    ImageView jHz;
    private ak jdP;
    private c jnu;
    private Context mContext;
    private boolean pRl;

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i) {
        if (onlineVideoView.bpm > 0) {
            v.w("MicroMsg.OnlineVideoView", "send video now, do nothing.");
            return;
        }
        v.i("MicroMsg.OnlineVideoView", "%d retransmit video req code %d, download finish path %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), an.a(onlineVideoView.bde, onlineVideoView.boL)});
        if (be.kS(an.a(onlineVideoView.bde, onlineVideoView.boL))) {
            onlineVideoView.bpm = i;
            onlineVideoView.m(true, 33);
            onlineVideoView.aVV();
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 223, 1, false);
            return;
        }
        onlineVideoView.qM(i);
    }

    static /* synthetic */ void a(OnlineVideoView onlineVideoView, int i, boolean z) {
        if (onlineVideoView.bpk > 0) {
            v.w("MicroMsg.OnlineVideoView", "fav video now, do nothing.");
            return;
        }
        v.i("MicroMsg.OnlineVideoView", "%d fav video req code %d fromMain %b, download finish path %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), Integer.valueOf(i), Boolean.valueOf(z), an.a(onlineVideoView.bde, onlineVideoView.boL)});
        if (be.kS(an.a(onlineVideoView.bde, onlineVideoView.boL))) {
            onlineVideoView.bpk = i;
            onlineVideoView.bpl = z;
            onlineVideoView.m(true, 35);
            onlineVideoView.aVV();
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 224, 1, false);
            return;
        }
        onlineVideoView.K(i, z);
    }

    static /* synthetic */ void m(OnlineVideoView onlineVideoView) {
        v.i("MicroMsg.OnlineVideoView", "%d save video, download finish path %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), an.a(onlineVideoView.bde, onlineVideoView.boL)});
        if (be.kS(an.a(onlineVideoView.bde, onlineVideoView.boL))) {
            onlineVideoView.jHy = true;
            onlineVideoView.m(true, 34);
            onlineVideoView.aVV();
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 220, 1, false);
            return;
        }
        onlineVideoView.aVU();
    }

    public OnlineVideoView(Context context) {
        this(context, null);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OnlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jHv = 0;
        this.jHw = false;
        this.pRl = false;
        this.eJx = false;
        this.boL = null;
        this.jHy = false;
        this.jHE = null;
        this.jHG = false;
        this.duration = 0;
        this.jHH = 0;
        this.jHI = 0;
        this.jHJ = 0;
        this.eIU = new ac(Looper.getMainLooper());
        this.jHK = new ah(new ah.a(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final boolean oU() {
                boolean z = false;
                if (!(this.jHT.jHE == null || this.jHT.jHA == null)) {
                    try {
                        boolean z2;
                        if (be.kS(this.jHT.jHE.jop)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            z = this.jHT.jHE.qN(this.jHT.jHA.getCurrentPosition() / BaseReportManager.MAX_READ_COUNT);
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
                    }
                }
                return z;
            }
        }, true);
        this.eJF = new ah(new ah.a(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final boolean oU() {
                if (this.jHT.jHA == null) {
                    return false;
                }
                if (this.jHT.jHA.getAlpha() < 1.0f) {
                    this.jHT.a(true, 1.0f);
                }
                if (this.jHT.jHA.isPlaying()) {
                    this.jHT.jHA.getCurrentPosition();
                }
                return true;
            }
        }, true);
        this.jHL = new b(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final void Aa(String str) {
            }

            public final void ai(String str, boolean z) {
            }

            public final void aRc() {
            }

            public final void aj(final String str, final boolean z) {
                this.jHT.eIU.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass14 jHX;

                    public final void run() {
                        v.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[]{Integer.valueOf(this.jHX.jHT.hashCode()), Boolean.valueOf(z)});
                        if (this.jHX.jHT.boL != null && z && be.dC(this.jHX.jHT.boL.gID, str)) {
                            an.cC(this.jHX.jHT.bde, "");
                            String a = an.a(this.jHX.jHT.bde, this.jHX.jHT.boL);
                            if (!be.kS(a)) {
                                this.jHX.jHT.aq(a, false);
                            }
                        }
                    }
                }, 100);
            }
        };
        this.jHM = new c<oh>(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r2;
                this.nhz = oh.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                oh ohVar = (oh) bVar;
                v.i("MicroMsg.OnlineVideoView", "%d sns video menu event local id[%s, %s]", new Object[]{Integer.valueOf(this.jHT.hashCode()), ohVar.bpj.bde, this.jHT.bde});
                if (be.dC(ohVar.bpj.bde, this.jHT.bde)) {
                    if (ohVar.bpj.bdn == 1) {
                        OnlineVideoView.a(this.jHT, ohVar.bpj.bpm);
                    } else if (ohVar.bpj.bdn == 2) {
                        OnlineVideoView.a(this.jHT, ohVar.bpj.bpk, ohVar.bpj.bpl);
                    } else if (ohVar.bpj.bdn == 3) {
                        OnlineVideoView.m(this.jHT);
                    }
                }
                return false;
            }
        };
        this.jHN = new c<nn>(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r2;
                this.nhz = nn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                final nn nnVar = (nn) bVar;
                v.i("MicroMsg.OnlineVideoView", "%d sns flip ui event. local id[%s, %s] opcode %d hadUiEvent %b", new Object[]{Integer.valueOf(this.jHT.hashCode()), nnVar.boG.bde, this.jHT.bde, Integer.valueOf(nnVar.boG.bdn), Boolean.valueOf(this.jHT.jHG)});
                if (nnVar.boG.bdn == 2) {
                    this.jHT.jHG = false;
                    this.jHT.aVT();
                    this.jHT.onDestroy();
                } else if (nnVar.boG.bdn == 1) {
                    this.jHT.eIU.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 jHV;

                        public final void run() {
                            if (!be.dC(nnVar.boG.bde, this.jHV.jHT.bde)) {
                                this.jHV.jHT.jHG = false;
                                this.jHV.jHT.aVT();
                                this.jHV.jHT.onDestroy();
                            } else if (this.jHV.jHT.jHG) {
                                this.jHV.jHT.requestLayout();
                            } else {
                                this.jHV.jHT.jHG = true;
                                this.jHV.jHT.onResume();
                            }
                        }
                    });
                }
                return false;
            }
        };
        this.jnu = new c<jj>(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r2;
                this.nhz = jj.class.getName().hashCode();
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean a(com.tencent.mm.e.a.jj r11) {
                /*
                r10 = this;
                r3 = 2;
                r2 = 1;
                r9 = 0;
                r0 = r10.jHT;
                r0 = r0.jHE;
                if (r0 != 0) goto L_0x0023;
            L_0x000b:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d online video helper is null.";
                r2 = new java.lang.Object[r2];
                r3 = r10.jHT;
                r3 = r3.hashCode();
                r3 = java.lang.Integer.valueOf(r3);
                r2[r9] = r3;
                com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
            L_0x0022:
                return r9;
            L_0x0023:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHE;	 Catch:{ Exception -> 0x0066 }
                r1 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r1 = r1.mediaId;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.BW(r1);	 Catch:{ Exception -> 0x0066 }
                if (r0 == 0) goto L_0x0022;
            L_0x0033:
                r0 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.aYJ;	 Catch:{ Exception -> 0x0066 }
                if (r0 == 0) goto L_0x0082;
            L_0x0039:
                r0 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.aYJ;	 Catch:{ Exception -> 0x0066 }
                r1 = -21006; // 0xffffffffffffadf2 float:NaN double:NaN;
                if (r0 == r1) goto L_0x0082;
            L_0x0041:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d stream download online video error. retCode %d ";
                r2 = 2;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0066 }
                r3 = 0;
                r4 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                r3 = 1;
                r4 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.aYJ;	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x0066:
                r0 = move-exception;
                r1 = "MicroMsg.OnlineVideoView";
                r2 = new java.lang.StringBuilder;
                r3 = "online video callback error: ";
                r2.<init>(r3);
                r0 = r0.toString();
                r0 = r2.append(r0);
                r0 = r0.toString();
                com.tencent.mm.sdk.platformtools.v.e(r1, r0);
                goto L_0x0022;
            L_0x0082:
                r0 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.bdn;	 Catch:{ Exception -> 0x0066 }
                switch(r0) {
                    case 1: goto L_0x00af;
                    case 2: goto L_0x01b8;
                    case 3: goto L_0x0278;
                    case 4: goto L_0x027f;
                    case 5: goto L_0x036e;
                    case 6: goto L_0x03e0;
                    default: goto L_0x0089;
                };	 Catch:{ Exception -> 0x0066 }
            L_0x0089:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d unknown event opcode %d";
                r2 = 2;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0066 }
                r3 = 0;
                r4 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                r3 = 1;
                r4 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.bdn;	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x00af:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHE;	 Catch:{ Exception -> 0x0066 }
                r1 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r1 = r1.offset;	 Catch:{ Exception -> 0x0066 }
                r2 = (long) r1;	 Catch:{ Exception -> 0x0066 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r4 = "deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s";
                r5 = 3;
                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0066 }
                r6 = 0;
                r7 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0066 }
                r5[r6] = r7;	 Catch:{ Exception -> 0x0066 }
                r6 = 1;
                r7 = r0.jIc;	 Catch:{ Exception -> 0x0066 }
                r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0066 }
                r5[r6] = r7;	 Catch:{ Exception -> 0x0066 }
                r6 = 2;
                r7 = r0.jop;	 Catch:{ Exception -> 0x0066 }
                r5[r6] = r7;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r4, r5);	 Catch:{ Exception -> 0x0066 }
                r1 = r0.jIc;	 Catch:{ Exception -> 0x0066 }
                if (r1 == 0) goto L_0x00ef;
            L_0x00df:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "moov had callback, do nothing.";
                com.tencent.mm.sdk.platformtools.v.w(r0, r1);	 Catch:{ Exception -> 0x0066 }
            L_0x00e8:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.jHF = true;	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x00ef:
                r4 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ Exception -> 0x0066 }
                r0.jIl = r4;	 Catch:{ Exception -> 0x0066 }
                r1 = r0.jIa;	 Catch:{ Exception -> 0x0103 }
                if (r1 != 0) goto L_0x011f;
            L_0x00f9:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "parser is null, thread is error.";
                com.tencent.mm.sdk.platformtools.v.w(r0, r1);	 Catch:{ Exception -> 0x0103 }
                goto L_0x00e8;
            L_0x0103:
                r0 = move-exception;
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066 }
                r3 = "deal moov ready error: ";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0066 }
                r0 = r2.append(r0);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ Exception -> 0x0066 }
                goto L_0x00e8;
            L_0x011f:
                r1 = r0.jIa;	 Catch:{ Exception -> 0x0103 }
                r4 = r0.hqT;	 Catch:{ Exception -> 0x0103 }
                r1 = r1.k(r4, r2);	 Catch:{ Exception -> 0x0103 }
                if (r1 == 0) goto L_0x016a;
            L_0x0129:
                r1 = r0.jIa;	 Catch:{ Exception -> 0x0103 }
                r1 = r1.dfX;	 Catch:{ Exception -> 0x0103 }
                r0.jIc = r1;	 Catch:{ Exception -> 0x0103 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "mp4 parse moov success. duration %d cdnMediaId %s";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0103 }
                r4 = 0;
                r5 = r0.jIc;	 Catch:{ Exception -> 0x0103 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0103 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0103 }
                r4 = 1;
                r5 = r0.jop;	 Catch:{ Exception -> 0x0103 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0103 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ Exception -> 0x0103 }
                r1 = new com.tencent.mm.plugin.sns.ui.ac$1;	 Catch:{ Exception -> 0x0103 }
                r1.<init>(r0);	 Catch:{ Exception -> 0x0103 }
                com.tencent.mm.sdk.platformtools.ad.o(r1);	 Catch:{ Exception -> 0x0103 }
                r1 = r0.jIe;	 Catch:{ Exception -> 0x0103 }
                r2 = -1;
                if (r1 != r2) goto L_0x0166;
            L_0x0156:
                r1 = 1;
                r0.jHY = r1;	 Catch:{ Exception -> 0x0103 }
            L_0x0159:
                r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x0103 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0103 }
                goto L_0x00e8;
            L_0x0166:
                r1 = 2;
                r0.jHY = r1;	 Catch:{ Exception -> 0x0103 }
                goto L_0x0159;
            L_0x016a:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "mp4 parse moov error. cdnMediaId %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0103 }
                r4 = 0;
                r5 = r0.jop;	 Catch:{ Exception -> 0x0103 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0103 }
                com.tencent.mm.sdk.platformtools.v.w(r1, r2, r3);	 Catch:{ Exception -> 0x0103 }
                com.tencent.mm.modelcdntran.g.DY();	 Catch:{ Exception -> 0x0103 }
                r0 = r0.jop;	 Catch:{ Exception -> 0x0103 }
                r1 = 0;
                r2 = -1;
                r3 = 0;
                com.tencent.mm.modelcdntran.f.requestVideoData(r0, r1, r2, r3);	 Catch:{ Exception -> 0x0103 }
                r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x0103 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0103 }
                r0 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x0103 }
                r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
                r2 = 3;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0103 }
                r3 = 0;
                r4 = 402; // 0x192 float:5.63E-43 double:1.986E-321;
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0103 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0103 }
                r3 = 1;
                r4 = com.tencent.mm.sdk.platformtools.be.Nh();	 Catch:{ Exception -> 0x0103 }
                r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0103 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0103 }
                r3 = 2;
                r4 = "";
                r2[r3] = r4;	 Catch:{ Exception -> 0x0103 }
                r0.h(r1, r2);	 Catch:{ Exception -> 0x0103 }
                goto L_0x00e8;
            L_0x01b8:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r1 = r0.jHE;	 Catch:{ Exception -> 0x0066 }
                r0 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.mediaId;	 Catch:{ Exception -> 0x0066 }
                r2 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r2 = r2.offset;	 Catch:{ Exception -> 0x0066 }
                r3 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r3 = r3.length;	 Catch:{ Exception -> 0x0066 }
                if (r2 < 0) goto L_0x01ce;
            L_0x01cc:
                if (r3 >= 0) goto L_0x01f5;
            L_0x01ce:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r1 = "deal data available error offset[%d], length[%d]";
                r4 = 2;
                r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0066 }
                r5 = 0;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0066 }
                r4[r5] = r2;	 Catch:{ Exception -> 0x0066 }
                r2 = 1;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0066 }
                r4[r2] = r3;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.w(r0, r1, r4);	 Catch:{ Exception -> 0x0066 }
            L_0x01e8:
                r0 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.length;	 Catch:{ Exception -> 0x0066 }
                if (r0 <= 0) goto L_0x0022;
            L_0x01ee:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.aVW();	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x01f5:
                r0 = r1.BW(r0);	 Catch:{ Exception -> 0x0066 }
                if (r0 == 0) goto L_0x01e8;
            L_0x01fb:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066 }
                r0.<init>();	 Catch:{ Exception -> 0x0066 }
                r4 = r1.jop;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.append(r4);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x0066 }
                r4 = "_";
                r0 = r0.append(r4);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0066 }
                r4 = r1.jHZ;	 Catch:{ Exception -> 0x0066 }
                r0 = r4.get(r0);	 Catch:{ Exception -> 0x0066 }
                r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x0066 }
                if (r0 == 0) goto L_0x0253;
            L_0x0223:
                r4 = r0.intValue();	 Catch:{ Exception -> 0x0066 }
                if (r4 <= 0) goto L_0x0253;
            L_0x0229:
                r0 = r0.intValue();	 Catch:{ Exception -> 0x0066 }
                r1.jIg = r0;	 Catch:{ Exception -> 0x0066 }
            L_0x022f:
                r0 = "MicroMsg.OnlineVideoViewHelper";
                r4 = "deal data available. offset[%d] length[%d] cachePlayTime[%d]";
                r5 = 3;
                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0066 }
                r6 = 0;
                r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0066 }
                r5[r6] = r2;	 Catch:{ Exception -> 0x0066 }
                r2 = 1;
                r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0066 }
                r5[r2] = r3;	 Catch:{ Exception -> 0x0066 }
                r2 = 2;
                r1 = r1.jIg;	 Catch:{ Exception -> 0x0066 }
                r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0066 }
                r5[r2] = r1;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.i(r0, r4, r5);	 Catch:{ Exception -> 0x0066 }
                goto L_0x01e8;
            L_0x0253:
                r0 = r1.jIa;	 Catch:{ Exception -> 0x025c }
                r0 = r0.aR(r2, r3);	 Catch:{ Exception -> 0x025c }
                r1.jIg = r0;	 Catch:{ Exception -> 0x025c }
                goto L_0x022f;
            L_0x025c:
                r0 = move-exception;
                r4 = "MicroMsg.OnlineVideoViewHelper";
                r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066 }
                r6 = "deal data available file pos to video time error: ";
                r5.<init>(r6);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0066 }
                r0 = r5.append(r0);	 Catch:{ Exception -> 0x0066 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.e(r4, r0);	 Catch:{ Exception -> 0x0066 }
                goto L_0x022f;
            L_0x0278:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.aVW();	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x027f:
                r0 = "MicroMsg.OnlineVideoView";
                r1 = "%d download finish. cdnMediaId %s sendReqCode %d favFromScene %d";
                r2 = 4;
                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0066 }
                r3 = 0;
                r4 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.hashCode();	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                r3 = 1;
                r4 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.mediaId;	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                r3 = 2;
                r4 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.bpm;	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                r3 = 3;
                r4 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r4 = r4.bpk;	 Catch:{ Exception -> 0x0066 }
                r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0066 }
                r2[r3] = r4;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);	 Catch:{ Exception -> 0x0066 }
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHE;	 Catch:{ Exception -> 0x0066 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal stream finish. playStatus %d cdnMediaId %s";
                r3 = 2;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0066 }
                r4 = 0;
                r5 = r0.jHY;	 Catch:{ Exception -> 0x0066 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0066 }
                r4 = 1;
                r5 = r0.jop;	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ Exception -> 0x0066 }
                r1 = 3;
                r0.icJ = r1;	 Catch:{ Exception -> 0x0066 }
                r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x0066 }
                r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
                r4 = 206; // 0xce float:2.89E-43 double:1.02E-321;
                r6 = 1;
                r8 = 0;
                r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0066 }
                r1 = r0.jHY;	 Catch:{ Exception -> 0x0066 }
                if (r1 != 0) goto L_0x0312;
            L_0x02ec:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "it had not moov callback and download finish start to play video.";
                com.tencent.mm.sdk.platformtools.v.w(r1, r2);	 Catch:{ Exception -> 0x0066 }
                r0.aWg();	 Catch:{ Exception -> 0x0066 }
            L_0x02f8:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.bpm;	 Catch:{ Exception -> 0x0066 }
                if (r0 <= 0) goto L_0x0333;
            L_0x0300:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.avM();	 Catch:{ Exception -> 0x0066 }
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r1 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r1 = r1.bpm;	 Catch:{ Exception -> 0x0066 }
                r0.qM(r1);	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x0312:
                r1 = r0.jHY;	 Catch:{ Exception -> 0x0066 }
                r2 = 5;
                if (r1 != r2) goto L_0x02f8;
            L_0x0317:
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066 }
                r3 = "it had play error, it request all video data finish, start to play.";
                r2.<init>(r3);	 Catch:{ Exception -> 0x0066 }
                r3 = r0.jop;	 Catch:{ Exception -> 0x0066 }
                r2 = r2.append(r3);	 Catch:{ Exception -> 0x0066 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.w(r1, r2);	 Catch:{ Exception -> 0x0066 }
                r0.aWg();	 Catch:{ Exception -> 0x0066 }
                goto L_0x02f8;
            L_0x0333:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.bpk;	 Catch:{ Exception -> 0x0066 }
                if (r0 <= 0) goto L_0x0353;
            L_0x033b:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.avM();	 Catch:{ Exception -> 0x0066 }
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r1 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r1 = r1.bpk;	 Catch:{ Exception -> 0x0066 }
                r2 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r2 = r2.bpl;	 Catch:{ Exception -> 0x0066 }
                r0.K(r1, r2);	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x0353:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHy;	 Catch:{ Exception -> 0x0066 }
                if (r0 == 0) goto L_0x0367;
            L_0x035b:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.avM();	 Catch:{ Exception -> 0x0066 }
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.aVU();	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x0367:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0.aVW();	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x036e:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHv;	 Catch:{ Exception -> 0x0066 }
                if (r0 != r2) goto L_0x03c9;
            L_0x0376:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHE;	 Catch:{ Exception -> 0x0066 }
                r1 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r1 = r1.mediaId;	 Catch:{ Exception -> 0x0066 }
                r2 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r2 = r2.offset;	 Catch:{ Exception -> 0x0066 }
                r3 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r3 = r3.length;	 Catch:{ Exception -> 0x0066 }
                r1 = r0.BW(r1);	 Catch:{ Exception -> 0x0066 }
                if (r1 == 0) goto L_0x0022;
            L_0x038e:
                r0.progress = r2;	 Catch:{ Exception -> 0x0066 }
                r0.iJK = r3;	 Catch:{ Exception -> 0x0066 }
                r1 = r0.progress;	 Catch:{ Exception -> 0x0066 }
                r1 = r1 * 100;
                r2 = r0.iJK;	 Catch:{ Exception -> 0x0066 }
                r1 = r1 / r2;
                r0.jId = r1;	 Catch:{ Exception -> 0x0066 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal video[%s] progress callback[%d, %d]. downloadedPercent[%d]";
                r3 = 4;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0066 }
                r4 = 0;
                r5 = r0.jop;	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0066 }
                r4 = 1;
                r5 = r0.progress;	 Catch:{ Exception -> 0x0066 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0066 }
                r4 = 2;
                r5 = r0.iJK;	 Catch:{ Exception -> 0x0066 }
                r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0066 }
                r4 = 3;
                r0 = r0.jId;	 Catch:{ Exception -> 0x0066 }
                r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r0;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x03c9:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHv;	 Catch:{ Exception -> 0x0066 }
                if (r0 != r3) goto L_0x0022;
            L_0x03d1:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r1 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r1 = r1.offset;	 Catch:{ Exception -> 0x0066 }
                r2 = r11.bjO;	 Catch:{ Exception -> 0x0066 }
                r2 = r2.length;	 Catch:{ Exception -> 0x0066 }
                r0.eIU.post(new com.tencent.mm.plugin.sns.ui.OnlineVideoView.AnonymousClass9(r0, r1, r2));	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
            L_0x03e0:
                r0 = r10.jHT;	 Catch:{ Exception -> 0x0066 }
                r0 = r0.jHE;	 Catch:{ Exception -> 0x0066 }
                r1 = "MicroMsg.OnlineVideoViewHelper";
                r2 = "deal had dup video. cdnMediaId %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0066 }
                r4 = 0;
                r5 = r0.jop;	 Catch:{ Exception -> 0x0066 }
                r3[r4] = r5;	 Catch:{ Exception -> 0x0066 }
                com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ Exception -> 0x0066 }
                r0.aWg();	 Catch:{ Exception -> 0x0066 }
                goto L_0x0022;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.OnlineVideoView.4.a(com.tencent.mm.e.a.jj):boolean");
            }
        };
        this.jHO = new VideoTextureView.a(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final void aBK() {
                v.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[]{Integer.valueOf(this.jHT.hashCode())});
                try {
                    this.jHT.a(true, 1.0f);
                } catch (Exception e) {
                    v.e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
                }
            }
        };
        this.mContext = context;
        v.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(context).inflate(2130904520, this);
        this.jHz = (ImageView) findViewById(2131755865);
        this.hsA = (RelativeLayout) findViewById(2131755866);
        this.jHB = (TextView) findViewById(2131755867);
        this.jHB.setVisibility(8);
        this.jHC = (MMPinProgressBtn) findViewById(2131755868);
        this.ilM = (ProgressBar) findViewById(2131755870);
        this.jHD = (TextView) findViewById(2131755871);
        this.jHA = new VideoTextureView(context);
        this.jHA.iVc = this;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.hsA.addView(this.jHA, layoutParams);
    }

    public final void aVT() {
        v.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[]{Integer.valueOf(hashCode())});
        com.tencent.mm.sdk.c.a.nhr.f(this.jHN);
    }

    public final void a(aib com_tencent_mm_protocal_c_aib, String str, int i) {
        this.bde = str;
        this.cLB = i;
        ak bvV = ak.bvV();
        bvV.hrm = this.cLB;
        this.jdP = bvV;
        if (this.boL != com_tencent_mm_protocal_c_aib) {
            this.boL = com_tencent_mm_protocal_c_aib;
            boolean c = ad.aSB().c(this.boL, this.jHz, 2130837719, this.mContext.hashCode(), this.jdP);
            v.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(c)});
        }
        this.jHw = false;
        v.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", new Object[]{Integer.valueOf(hashCode()), this.bde, Integer.valueOf(this.cLB), Boolean.valueOf(this.jHw)});
    }

    public final void onResume() {
        v.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[]{Integer.valueOf(hashCode()), be.bur()});
        this.jHH = be.Ni();
        if (this.jHE == null) {
            v.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[]{Integer.valueOf(hashCode())});
            this.jHE = new ac(this);
            com.tencent.mm.sdk.c.a.nhr.e(this.jnu);
            com.tencent.mm.sdk.c.a.nhr.e(this.jHM);
            ad.aSz().a(this.jHL);
        }
        if (!this.pRl) {
            String a = !this.jHw ? an.a(this.bde, this.boL) : this.jHx;
            v.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[]{Integer.valueOf(hashCode()), this.bde, a, Boolean.valueOf(this.jHw)});
            if (be.kS(a)) {
                a(false, 0.0f);
                m(false, 0);
                aVV();
                return;
            }
            v.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[]{Integer.valueOf(hashCode())});
            aq(a, false);
        }
    }

    public final void onDestroy() {
        v.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[]{Integer.valueOf(hashCode()), be.bur()});
        this.jHI = be.Ni();
        v.i("MicroMsg.OnlineVideoView", "%d logic unInit", new Object[]{Integer.valueOf(hashCode())});
        aWa();
        this.jHA.stop();
        com.tencent.mm.sdk.c.a.nhr.f(this.jnu);
        com.tencent.mm.sdk.c.a.nhr.f(this.jHM);
        ad.aSz().b(this.jHL);
        this.jHK.QI();
        this.eJF.QI();
        if (this.jHE != null) {
            ac acVar = this.jHE;
            if (!be.kS(acVar.jop)) {
                boolean z;
                if (acVar.icJ == 3) {
                    z = true;
                } else {
                    z = false;
                }
                v.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[]{acVar.jop, Boolean.valueOf(z), Integer.valueOf(acVar.jId)});
                ao aSC = ad.aSC();
                String str = acVar.jop;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(acVar.jIb.aWb());
                if (acVar.jIm <= 0) {
                    acVar.jIm = be.Ni();
                }
                int i = (int) (acVar.jIm - acVar.jIk);
                if (i <= 0) {
                    i = 0;
                }
                objArr[1] = Integer.valueOf(i);
                if (acVar.jIl <= 0) {
                    acVar.jIl = be.Ni();
                }
                int i2 = (int) (acVar.jIl - acVar.jIk);
                if (i2 <= 0) {
                    i2 = 0;
                }
                objArr[2] = Integer.valueOf(i2);
                objArr[3] = Integer.valueOf(acVar.jIj);
                if (acVar.jIj > 0) {
                    if (acVar.jIo == 0) {
                        acVar.jIo = (int) (((long) acVar.jIo) + be.ay(acVar.jIn));
                    }
                    objArr[4] = Integer.valueOf(acVar.jIo / acVar.jIj);
                } else {
                    objArr[4] = Integer.valueOf(0);
                }
                objArr[5] = Integer.valueOf(acVar.jIb.aWd());
                objArr[6] = Integer.valueOf(acVar.jIb.aWc());
                if (!be.kS(str)) {
                    com.tencent.mm.model.ak.vA().x(new com.tencent.mm.plugin.sns.e.ao.AnonymousClass1(aSC, str, objArr));
                }
                if (acVar.jId >= acVar.jIp.jIt && !z) {
                    ad.aSC().a(acVar.boL, acVar.cLB, acVar.bap, false, false, 36);
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(354, 203, 1, false);
            }
            ac acVar2 = this.jHE;
            v.i("MicroMsg.OnlineVideoViewHelper", "clear");
            acVar2.reset();
            acVar2.jIb = null;
            acVar2.jIa = null;
        }
        this.boL = null;
        this.bde = null;
        this.jHE = null;
    }

    private void qM(int i) {
        String str = al.cA(ad.xh(), this.bde) + i.c(this.boL);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 11);
        v.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[]{str, Integer.valueOf(i)});
        com.tencent.mm.ay.c.a(this.mContext, ".ui.transmit.SelectConversationUI", intent, i);
        this.bpm = 0;
    }

    private void K(final int i, final boolean z) {
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView jHT;

            public final void run() {
                k Bq = ad.aSE().Bq(this.jHT.bde);
                if (Bq != null) {
                    v.i("MicroMsg.OnlineVideoView", "fav download video[%s] farFromScene %d isFromMain %b", new Object[]{this.jHT.bde, Integer.valueOf(i), Boolean.valueOf(z)});
                    bp bpVar = new bp();
                    bpVar.aZd.aZl = i;
                    bpVar.aZd.aXH = (Activity) this.jHT.mContext;
                    com.tencent.mm.plugin.sns.j.a.a(bpVar, Bq);
                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                    if (bpVar.aZe.ret == 0) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(354, 225, 1, false);
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.a(354, 226, 1, false);
                    }
                    if (z) {
                        nk nkVar = new nk();
                        nkVar.boD.bap = Bq.aUL();
                        nkVar.boD.boC = i.g(Bq);
                        com.tencent.mm.sdk.c.a.nhr.z(nkVar);
                    }
                    this.jHT.bpk = 0;
                    if (this.jHT.jHA == null) {
                        return;
                    }
                    if (be.kS(this.jHT.jHA.lUD)) {
                        v.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[]{Integer.valueOf(this.jHT.hashCode())});
                        String a = an.a(this.jHT.bde, this.jHT.boL);
                        if (!be.kS(a)) {
                            this.jHT.aq(a, false);
                        }
                    } else if (!this.jHT.jHA.isPlaying()) {
                        this.jHT.jHA.start();
                    }
                }
            }
        });
    }

    private void aVU() {
        long Nj = be.Nj();
        String lq = p.lq(an.a(this.bde, this.boL));
        if (be.kS(lq)) {
            Toast.makeText(this.mContext, this.mContext.getString(2131235794), 1).show();
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 222, 1, false);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(2131235795, new Object[]{lq}), 1).show();
            l.c(lq, this.mContext);
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 221, 1, false);
        }
        this.jHy = false;
        v.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(be.az(Nj)), r0});
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final void run() {
                if (this.jHT.jHA == null) {
                    return;
                }
                if (be.kS(this.jHT.jHA.lUD)) {
                    v.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[]{Integer.valueOf(this.jHT.hashCode())});
                    String a = an.a(this.jHT.bde, this.jHT.boL);
                    if (!be.kS(a)) {
                        this.jHT.aq(a, false);
                    }
                } else if (!this.jHT.jHA.isPlaying()) {
                    this.jHT.jHA.start();
                }
            }
        });
    }

    private void a(final boolean z, final float f) {
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView jHT;

            public final void run() {
                v.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.jHT.hashCode()), Boolean.valueOf(z), Float.valueOf(f)});
                if (z) {
                    this.jHT.jHA.setAlpha(f);
                    this.jHT.jHA.setVisibility(0);
                    if (((double) f) >= 1.0d) {
                        this.jHT.jHz.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.jHT.jHA.setVisibility(8);
                this.jHT.jHz.setVisibility(0);
            }
        });
    }

    private void m(boolean z, int i) {
        if (this.boL == null) {
            v.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.jHE == null) {
            v.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.boL.mHO == 2) {
            v.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[]{Integer.valueOf(hashCode())});
            this.jHv = 3;
            ad.aSz().a(this.boL, 4, null, this.jdP);
        } else {
            boolean z2;
            int i2;
            ac acVar;
            aib com_tencent_mm_protocal_c_aib;
            int i3;
            String str;
            if (!z) {
                com.tencent.mm.model.ak.yW();
                int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.ntj, Integer.valueOf(-1))).intValue();
                int i4 = 0;
                com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100153");
                if (Ls.isValid()) {
                    i4 = be.getInt((String) Ls.buX().get("snsStreamDownload"), 0);
                }
                v.i("MicroMsg.SnsVideoLogic", "check can sns online play video opcode : " + intValue + " abTestFlag : " + i4);
                Object obj = (intValue == 0 || i4 == -1) ? null : intValue > 0 ? 1 : (intValue == 0 || i4 <= 0) ? null : 1;
                if (obj != null) {
                    v.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[]{Integer.valueOf(hashCode())});
                    this.jHv = 1;
                    z2 = true;
                    if (i == 0) {
                        i = 30;
                    }
                    i2 = i;
                    acVar = this.jHE;
                    com_tencent_mm_protocal_c_aib = this.boL;
                    i3 = this.cLB;
                    str = this.bde;
                    acVar.boL = com_tencent_mm_protocal_c_aib;
                    acVar.cLB = i3;
                    acVar.bap = str;
                    acVar.hqT = an.D(com_tencent_mm_protocal_c_aib);
                    acVar.jop = an.ad(i3, com_tencent_mm_protocal_c_aib.glb);
                    if (!be.kS(acVar.hqT) && !be.kS(acVar.jop)) {
                        v.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[]{acVar.jop, Boolean.valueOf(z2)});
                        ad.aSC().a(com_tencent_mm_protocal_c_aib, i3, str, z2, true, i2);
                        acVar.icJ = 1;
                        acVar.jIk = be.Ni();
                        if (z2) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(354, 201, 1, false);
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.g.iuh.a(354, 202, 1, false);
                            return;
                        }
                    }
                }
            }
            v.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[]{Integer.valueOf(hashCode())});
            this.jHv = 2;
            z2 = false;
            if (i == 0) {
                i = 31;
            }
            i2 = i;
            acVar = this.jHE;
            com_tencent_mm_protocal_c_aib = this.boL;
            i3 = this.cLB;
            str = this.bde;
            acVar.boL = com_tencent_mm_protocal_c_aib;
            acVar.cLB = i3;
            acVar.bap = str;
            acVar.hqT = an.D(com_tencent_mm_protocal_c_aib);
            acVar.jop = an.ad(i3, com_tencent_mm_protocal_c_aib.glb);
            if (!be.kS(acVar.hqT)) {
            }
        }
    }

    final void aPy() {
        if (this.jHA.isPlaying()) {
            v.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[]{Integer.valueOf(hashCode())});
            aWa();
            this.jHA.pause();
        }
    }

    private void aVV() {
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final void run() {
                v.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(this.jHT.hashCode()), Integer.valueOf(this.jHT.jHv)});
                if (this.jHT.jHv == 1) {
                    if (!(this.jHT.ilM == null || this.jHT.ilM.getVisibility() == 0)) {
                        this.jHT.ilM.setVisibility(0);
                    }
                    if (!(this.jHT.jHC == null || this.jHT.jHC.getVisibility() == 8)) {
                        this.jHT.jHC.setVisibility(8);
                    }
                }
                if (this.jHT.jHv == 2) {
                    if (!(this.jHT.jHC == null || this.jHT.jHC.getVisibility() == 0)) {
                        this.jHT.jHC.setVisibility(0);
                    }
                    if (!(this.jHT.ilM == null || this.jHT.ilM.getVisibility() == 8)) {
                        this.jHT.ilM.setVisibility(8);
                    }
                }
                if (this.jHT.jHv == 3) {
                    if (!(this.jHT.jHC == null || this.jHT.jHC.getVisibility() == 0)) {
                        this.jHT.jHC.setVisibility(0);
                        this.jHT.jHC.bKj();
                    }
                    if (this.jHT.ilM != null && this.jHT.ilM.getVisibility() != 8) {
                        this.jHT.ilM.setVisibility(8);
                    }
                }
            }
        });
    }

    private void avM() {
        this.eIU.post(new Runnable(this) {
            final /* synthetic */ OnlineVideoView jHT;

            {
                this.jHT = r1;
            }

            public final void run() {
                v.d("MicroMsg.OnlineVideoView", "hide loading.");
                if (!(this.jHT.ilM == null || this.jHT.ilM.getVisibility() == 8)) {
                    this.jHT.ilM.setVisibility(8);
                }
                if (this.jHT.jHC != null && this.jHT.jHC.getVisibility() != 8) {
                    this.jHT.jHC.setVisibility(8);
                }
            }
        });
    }

    protected final void aVW() {
        if (this.jHF) {
            this.jHK.ea(500);
        } else {
            this.eJF.ea(500);
        }
    }

    public final void bp(int i, int i2) {
        boolean z;
        v.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.jHF)});
        if (this.jHF) {
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 230, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(354, 231, 1, false);
        }
        this.jHJ = i2;
        aWa();
        final String str = this.jHA.lUD;
        this.jHA.stop();
        if (this.jHF) {
            if (this.jHE != null) {
                ac acVar = this.jHE;
                z = !be.kS(acVar.jop) && acVar.icJ == 3;
                if (!z) {
                    aVV();
                    acVar = this.jHE;
                    String str2 = acVar.jop + 0 + "_-1";
                    if (!acVar.jHZ.containsKey(str2)) {
                        v.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[]{acVar.jop});
                        com.tencent.mm.modelcdntran.g.DY();
                        f.requestVideoData(acVar.jop, 0, -1, 0);
                        acVar.jHZ.put(str2, Integer.valueOf(0));
                        com.tencent.mm.plugin.report.service.g.iuh.a(354, 207, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13836, new Object[]{Integer.valueOf(403), Long.valueOf(be.Nh()), ""});
                    }
                    acVar.jHY = 5;
                    z = false;
                }
            }
            z = true;
        } else if (i == 100) {
            z = true;
        } else {
            z = false;
        }
        v.e("MicroMsg.OnlineVideoView", "%d on play video error but need try %b path %s", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), str});
        if (z) {
            this.eIU.post(new Runnable(this) {
                final /* synthetic */ OnlineVideoView jHT;

                {
                    this.jHT = r1;
                }

                public final void run() {
                    String a = an.a(this.jHT.bde, this.jHT.boL);
                    if (!be.kS(a)) {
                        this.jHT.aq(a, false);
                    }
                }
            });
            return;
        }
        this.pRl = true;
        a(false, 0.0f);
        if (!be.kS(str)) {
            v.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[]{Integer.valueOf(hashCode())});
            this.eIU.post(new Runnable(this) {
                final /* synthetic */ OnlineVideoView jHT;

                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(str)), "video/*");
                    try {
                        this.jHT.getContext().startActivity(intent);
                    } catch (Exception e) {
                        v.e("MicroMsg.OnlineVideoView", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.f(this.jHT.getContext(), 2131232691, 2131232692);
                    }
                }
            });
        }
    }

    public final void abH() {
        this.jHJ = 0;
        if (this.jHA != null) {
            this.jHA.lUM = this.jHO;
        }
        a(true, 0.0f);
        avM();
        aVZ();
        this.jHA.start();
        this.duration = this.jHA.getDuration() / BaseReportManager.MAX_READ_COUNT;
        v.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.bde});
        aVW();
    }

    public final void pa() {
        v.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        py(0);
    }

    public final int bq(int i, int i2) {
        return 0;
    }

    public final void br(int i, int i2) {
    }

    public final void aq(String str, boolean z) {
        v.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), str});
        if (be.kS(str)) {
            v.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        this.jHF = z;
        this.jHA.setVideoPath(str);
        com.tencent.mm.model.ak.yW();
        if (((Integer) com.tencent.mm.model.c.vf().get(t.a.ntB, Integer.valueOf(0))).intValue() == 1) {
            this.jHD.setText(d.wu(str));
            this.jHD.setVisibility(0);
        }
    }

    public final void aVX() {
        v.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[]{Integer.valueOf(hashCode())});
        if (!this.jHA.isPlaying()) {
            aVZ();
            this.jHA.start();
            avM();
        }
    }

    public final void aVY() {
        v.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[]{Integer.valueOf(hashCode())});
        aWa();
        aVV();
        aPy();
    }

    public final void py(int i) {
        v.i("MicroMsg.OnlineVideoView", "%d seek second %d ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i)});
        this.jHA.i((double) (i * BaseReportManager.MAX_READ_COUNT));
    }

    private void aVZ() {
        this.jHP = be.Ni();
        v.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.jHP)});
    }

    private void aWa() {
        if (this.jHP > 0) {
            this.jHQ = (int) (((long) this.jHQ) + ((be.Ni() - this.jHP) / 1000));
        }
        v.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.jHQ)});
        this.jHP = 0;
    }

    public final int aWb() {
        if (this.jHQ < 0) {
            this.jHQ = 0;
        }
        v.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.jHQ)});
        return this.jHQ;
    }

    public final int aWc() {
        return this.jHJ;
    }

    public final int aWd() {
        int i;
        if (this.jHI <= 0 || this.jHH <= 0) {
            i = 0;
        } else {
            i = (int) (this.jHI - this.jHH);
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
