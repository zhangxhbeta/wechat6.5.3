package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.mmsight.model.a.i;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.encode.ui.CameraFrontSightView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult;
import com.tencent.mm.pluginsdk.ui.tools.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.w;
import com.tencent.mmdb.support.Log;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

@a(3)
public class SightCaptureUI extends MMActivity implements c.a, b.a {
    private com.tencent.mm.compatible.util.b djL;
    private int gFQ = -1;
    private View gXS;
    private d gZK = new d(aa.getContext());
    private VideoTransPara hnB;
    private SightParams hoH;
    private ObservableTextureView hwA;
    private MMSightRecordButton hwB;
    private View hwC;
    private View hwD;
    private ViewGroup hwE;
    private ViewGroup hwF;
    private ImageView hwG;
    private SurfaceTexture hwH;
    CameraFrontSightView hwI;
    private ViewGroup hwJ;
    private ImageView hwK;
    private MMSightCameraGLSurfaceView hwL;
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a hwM;
    private TextView hwN;
    private MMSightCaptureTouchView hwO;
    private View hwP;
    private VideoTextureView hwQ;
    private boolean hwR = true;
    private ahn hwS = new ahn();
    private byte[] hwT;
    private int hwU;
    private int hwV;
    private int hwW;
    private int hwX;
    private b hwY;
    private boolean hwZ = false;
    private int hwv = 1;
    private int hww = 2;
    private boolean hwx = true;
    private com.tencent.mm.plugin.mmsight.model.c hwy;
    private c hwz;
    private boolean hxa = false;
    private boolean hxb = false;
    private int hxc = 0;
    private boolean hxd = false;
    private int hxe = 0;
    private Thread hxf = null;
    private long hxg = -1;
    private Runnable hxh = new Runnable(this) {
        final /* synthetic */ SightCaptureUI hxk;

        {
            this.hxk = r1;
        }

        public final void run() {
            if (this.hxk.gFQ == 6 && this.hxk.hwB != null) {
                v.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
                MMSightRecordButton e = this.hxk.hwB;
                v.i("MicroMsg.MMSightRecordButton", "showProgressBar");
                e.hvW.setVisibility(0);
            }
        }
    };
    private Runnable hxi = new Runnable(this) {
        final /* synthetic */ SightCaptureUI hxk;

        {
            this.hxk = r1;
        }

        public final void run() {
            if (this.hxk.gFQ != 4) {
                v.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
                this.hxk.ni(8);
            }
        }
    };
    private g.a hxj = new g.a(this) {
        final /* synthetic */ SightCaptureUI hxk;

        {
            this.hxk = r1;
        }

        public final void bp(int i, int i2) {
            v.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[]{Integer.valueOf(this.hxk.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        }

        public final void abH() {
            if (this.hxk.hwQ != null) {
                this.hxk.hwQ.start();
                this.hxk.hwQ.fD(true);
            }
            ad.g(new Runnable(this) {
                final /* synthetic */ AnonymousClass16 hxs;

                {
                    this.hxs = r1;
                }

                public final void run() {
                    if (this.hxs.hxk.hwQ != null) {
                        this.hxs.hxk.hwQ.lUM = new VideoTextureView.a(this) {
                            final /* synthetic */ AnonymousClass1 hxt;

                            {
                                this.hxt = r1;
                            }

                            public final void aBK() {
                                v.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                                ad.B(this.hxt.hxs.hxk.hxi);
                                this.hxt.hxs.hxk.hwQ.setAlpha(1.0f);
                                this.hxt.hxs.hxk.ni(4);
                                SightCaptureUI.B(this.hxt.hxs.hxk);
                            }
                        };
                    }
                }
            }, 50);
        }

        public final void pa() {
        }

        public final int bq(int i, int i2) {
            return 0;
        }

        public final void br(int i, int i2) {
        }
    };
    private long pPR = -1;

    static /* synthetic */ void j(com.tencent.mm.plugin.mmsight.ui.SightCaptureUI r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = 1;
        r9 = 0;
        r0 = r10.hwy;
        if (r0 == 0) goto L_0x00b9;
    L_0x0006:
        r0 = r10.hwY;
        if (r0 == 0) goto L_0x00b9;
    L_0x000a:
        r0 = r10.hxd;
        if (r0 != 0) goto L_0x00b9;
    L_0x000e:
        r0 = r10.pPR;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x0022;
    L_0x0016:
        r0 = r10.pPR;
        r0 = com.tencent.mm.sdk.platformtools.be.az(r0);
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00b9;
    L_0x0022:
        r10.hxd = r8;
        r0 = r10.hwN;
        if (r0 == 0) goto L_0x0033;
    L_0x0028:
        r0 = r10.hwx;
        if (r0 == 0) goto L_0x0033;
    L_0x002c:
        r0 = r10.hwN;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0033:
        r0 = 6;
        r10.ni(r0);
        r0 = r10.hwB;
        r0.eu(r9);
        r0 = r10.hwY;
        r0 = r0.azQ();
        r10.hxb = r0;
        r6 = r10.hwy;
        r0 = new com.tencent.mm.plugin.mmsight.ui.SightCaptureUI$3;
        r0.<init>(r10);
        r1 = r10.hxb;
        r2 = r10.hwY;
        r5 = r2.getOrientation();
        r2 = "MicroMsg.MMSightCamera";
        r3 = "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r4[r9] = r0;
        r7 = r6.hmS;
        r4[r8] = r7;
        r7 = 2;
        r1 = java.lang.Boolean.valueOf(r1);
        r4[r7] = r1;
        r1 = 3;
        r7 = java.lang.Integer.valueOf(r5);
        r4[r1] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r1 = r6.hmS;
        if (r1 == 0) goto L_0x00b3;
    L_0x0077:
        r1 = 1;
        r6.hmT = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3 = new android.graphics.Point;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3.<init>();	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r6.hmG;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        if (r1 == 0) goto L_0x00ba;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
    L_0x0083:
        r1 = r6.hmG;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r1.x;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3.x = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r6.hmG;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r1.y;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3.y = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
    L_0x008f:
        r1 = com.tencent.mm.plugin.mmsight.model.a.h.hoF;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = r6.hmS;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = r2.length;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r1.h(r2);	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = r6.hmS;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r4 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r7 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r8 = r6.hmS;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r8 = r8.length;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        java.lang.System.arraycopy(r2, r4, r1, r7, r8);	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = r6.hmA;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r4 = r2.cdi;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = r3.x;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3 = r3.y;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r6.hmT = r9;
    L_0x00b3:
        r0 = com.tencent.mm.sdk.platformtools.be.Nj();
        r10.pPR = r0;
    L_0x00b9:
        return;
    L_0x00ba:
        r1 = r6.hmu;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r1.lFr;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3.x = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r6.hmu;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r1.lFq;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3.y = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        goto L_0x008f;
    L_0x00c7:
        r1 = move-exception;
        r2 = "MicroMsg.MMSightCamera";	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3 = "takePicture error: %s";	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r4 = 1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r5 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = r1.getMessage();	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r4[r5] = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r6.hmT = r1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r1 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r2 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r3 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r4 = -1;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r5 = 0;	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00c7, all -> 0x00e9 }
        r6.hmT = r9;
        goto L_0x00b3;
    L_0x00e9:
        r0 = move-exception;
        r6.hmT = r9;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.j(com.tencent.mm.plugin.mmsight.ui.SightCaptureUI):void");
    }

    static /* synthetic */ void B(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.hwC.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI hxk;

            {
                this.hxk = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.hxk.hwC.setEnabled(true);
            }

            public final void onAnimationStart(Animator animator) {
                this.hxk.hwC.setEnabled(false);
            }
        }).start();
        sightCaptureUI.gXS.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI hxk;

            {
                this.hxk = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.hxk.gXS.setEnabled(true);
            }

            public final void onAnimationStart(Animator animator) {
                this.hxk.gXS.setEnabled(false);
            }
        }).start();
    }

    static /* synthetic */ void G(SightCaptureUI sightCaptureUI) {
        v.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.djL != null) {
            sightCaptureUI.djL.requestFocus();
        }
        sightCaptureUI.hwQ.setVisibility(0);
        sightCaptureUI.hwQ.setAlpha(0.0f);
        sightCaptureUI.hwQ.setVideoPath(sightCaptureUI.hwz.OZ());
        sightCaptureUI.hwQ.fD(true);
        sightCaptureUI.hwQ.lUO = true;
        sightCaptureUI.hwQ.iVc = sightCaptureUI.hxj;
    }

    static /* synthetic */ void I(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.gFQ == 1 || sightCaptureUI.gFQ == 2) {
            String azT = sightCaptureUI.hwy.azT();
            if (!be.kS(azT)) {
                StringBuilder append = new StringBuilder().append(azT + "\n" + String.format("CPU: cur %s max:%s", new Object[]{l.rA(), l.ry()})).append("\n");
                Object[] objArr = new Object[1];
                i.aAw();
                objArr[0] = i.aAA();
                azT = append.append(String.format("RecorderType %s", objArr)).toString() + "\n" + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.b.azK())});
                ad.o(new Runnable(sightCaptureUI) {
                    final /* synthetic */ SightCaptureUI hxk;

                    public final void run() {
                        v.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", new Object[]{azT});
                        i.aAw();
                        if (i.aAz()) {
                            TextView textView = (TextView) this.hxk.findViewById(2131755561);
                            textView.setVisibility(0);
                            textView.setText(azT);
                        }
                    }
                });
            }
        }
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.hoH == null) {
            v.e("MicroMsg.SightCaptureUI", "sightParams error!");
            return;
        }
        sightCaptureUI.hxc = com.tencent.mm.compatible.d.c.getNumberOfCameras();
        v.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", new Object[]{Integer.valueOf(sightCaptureUI.hxc)});
        sightCaptureUI.djL = new com.tencent.mm.compatible.util.b(sightCaptureUI);
        sightCaptureUI.hwx = sightCaptureUI.hoH.lUl;
        sightCaptureUI.hww = sightCaptureUI.hoH.hww;
        sightCaptureUI.hwR = sightCaptureUI.hww == 2;
        i.aAw().hoH = sightCaptureUI.hoH;
        sightCaptureUI.hwv = sightCaptureUI.hoH.mode;
        v.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", new Object[]{Integer.valueOf(sightCaptureUI.hwv), Boolean.valueOf(sightCaptureUI.hwx), Integer.valueOf(sightCaptureUI.hww), Integer.valueOf(sightCaptureUI.hoH.scene)});
        sightCaptureUI.hnB = sightCaptureUI.hoH.hnB;
        if (sightCaptureUI.hnB == null) {
            v.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            return;
        }
        v.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", new Object[]{sightCaptureUI.hnB});
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.dW(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.b.eh(true);
        } else {
            sightCaptureUI.getWindow().setFlags(1024, 1024);
            com.tencent.mm.plugin.mmsight.b.eh(false);
        }
        sightCaptureUI.hwY = new b(sightCaptureUI);
        sightCaptureUI.hwY.hmr = sightCaptureUI;
        sightCaptureUI.hwY.enable();
        sightCaptureUI.hwE = (ViewGroup) sightCaptureUI.findViewById(2131755557);
        sightCaptureUI.hwF = (ViewGroup) sightCaptureUI.findViewById(2131755567);
        sightCaptureUI.hwI = (CameraFrontSightView) sightCaptureUI.findViewById(2131755556);
        sightCaptureUI.hwA = (ObservableTextureView) sightCaptureUI.findViewById(2131755554);
        sightCaptureUI.hwB = (MMSightRecordButton) sightCaptureUI.findViewById(2131755568);
        sightCaptureUI.hwC = sightCaptureUI.findViewById(2131755563);
        sightCaptureUI.gXS = sightCaptureUI.findViewById(2131755564);
        sightCaptureUI.hwD = sightCaptureUI.findViewById(2131755562);
        sightCaptureUI.hwJ = (ViewGroup) sightCaptureUI.findViewById(2131755553);
        sightCaptureUI.hwN = (TextView) sightCaptureUI.findViewById(2131755569);
        if (sightCaptureUI.hwv == 2) {
            sightCaptureUI.hwN.setText(2131233845);
        } else if (sightCaptureUI.hwv == 1) {
            sightCaptureUI.hwN.setText(2131233844);
        }
        sightCaptureUI.hwQ = (VideoTextureView) sightCaptureUI.findViewById(2131755559);
        sightCaptureUI.hwG = (ImageView) sightCaptureUI.findViewById(2131755566);
        sightCaptureUI.hwK = (ImageView) sightCaptureUI.findViewById(2131755560);
        sightCaptureUI.hwL = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(2131755555);
        sightCaptureUI.hwO = (MMSightCaptureTouchView) sightCaptureUI.findViewById(2131755565);
        sightCaptureUI.hwP = sightCaptureUI.findViewById(2131755558);
        sightCaptureUI.hwM = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.hwL);
        if (sightCaptureUI.hwx) {
            sightCaptureUI.hwN.setVisibility(0);
        } else {
            sightCaptureUI.hwN.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(sightCaptureUI.nDR.nEl, 120);
        sightCaptureUI.hwI.cp(fromDPToPix, fromDPToPix);
        if (com.tencent.mm.compatible.util.d.dW(19)) {
            int en = w.en(sightCaptureUI);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.hwB.getLayoutParams();
            marginLayoutParams.bottomMargin += en;
            sightCaptureUI.hwB.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.hwD.getLayoutParams();
            marginLayoutParams.bottomMargin += en;
            sightCaptureUI.hwD.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.hwC.getLayoutParams();
            marginLayoutParams.bottomMargin += en;
            sightCaptureUI.hwC.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.gXS.getLayoutParams();
            marginLayoutParams.bottomMargin = en + marginLayoutParams.bottomMargin;
            sightCaptureUI.gXS.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.hwv == 1 || sightCaptureUI.hwv == 0) {
            sightCaptureUI.hwB.hwh = new MMSightRecordButton.b(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void aBy() {
                    v.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", new Object[]{Integer.valueOf(this.hxk.gFQ)});
                    if (this.hxk.gFQ != 0 && this.hxk.hwy != null && this.hxk.hwy.hmx) {
                        int[] iArr = new int[2];
                        this.hxk.hwB.getLocationOnScreen(iArr);
                        com.tencent.mm.plugin.mmsight.model.c d = this.hxk.hwy;
                        int i = iArr[1];
                        if (d.hmt <= 0) {
                            int i2 = w.ep(aa.getContext()).y;
                            v.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[]{Integer.valueOf(i), r2});
                            if (i2 / 2 < i) {
                                try {
                                    if (d.cdl != null) {
                                        d.hmt = ((int) (((double) d.cdl.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                                        v.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[]{Integer.valueOf(d.hmt), Integer.valueOf(r2)});
                                    }
                                } catch (Exception e) {
                                    v.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[]{e.getMessage()});
                                }
                            }
                        }
                        this.hxk.hxe = this.hxk.aBE();
                    }
                }

                public final void aBz() {
                    if (this.hxk.gFQ != 0 && this.hxk.hwy != null && this.hxk.hwy.hmx) {
                        SightCaptureUI.g(this.hxk);
                        v.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", new Object[]{be.bur().toString()});
                        SightCaptureUI.h(this.hxk);
                    }
                }

                public final void aBA() {
                    v.i("MicroMsg.TestCaptureUiEvent", "onLongPressFinish %s", new Object[]{be.bur().toString()});
                    if (this.hxk.hwz == null || this.hxk.hwz.aAi() > 1000 || this.hxk.hwz.aAk() != com.tencent.mm.plugin.sight.encode.a.b.b.iWE) {
                        this.hxk.oT();
                        return;
                    }
                    v.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
                    this.hxk.hwz.cancel();
                    SightCaptureUI.j(this.hxk);
                }
            };
            sightCaptureUI.hwB.hwj = new MMSightRecordButton.a(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void aBx() {
                    v.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", new Object[]{be.bur().toString()});
                    if (this.hxk.hwz != null) {
                        this.hxk.hwz.cancel();
                        SightCaptureUI.j(this.hxk);
                    }
                }
            };
            sightCaptureUI.hwB.hwi = new MMSightRecordButton.c(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void nf(int i) {
                    if (this.hxk.hwy != null) {
                        this.hxk.hwy.a(true, true, i);
                    }
                }

                public final void ng(int i) {
                    if (this.hxk.hwy != null) {
                        this.hxk.hwy.a(false, true, i);
                    }
                }
            };
        }
        if (sightCaptureUI.hwv == 0 || sightCaptureUI.hwv == 2) {
            sightCaptureUI.hwB.hwg = new MMSightRecordButton.d(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void aBB() {
                    v.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", new Object[]{be.bur().toString()});
                    if (this.hxk.hwz != null) {
                        v.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", new Object[]{this.hxk.hwz.aAk()});
                        this.hxk.hwz.cancel();
                    }
                    com.tencent.mm.plugin.mmsight.b.wv("TIME_RECODER_2_PLAY");
                    SightCaptureUI.j(this.hxk);
                }
            };
        }
        if (sightCaptureUI.hxc > 1) {
            sightCaptureUI.hwG.setOnClickListener(new OnClickListener(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void onClick(View view) {
                    if (this.hxk.hwy != null) {
                        SightCaptureUI.l(this.hxk);
                    }
                }
            });
        } else {
            sightCaptureUI.hwG.setVisibility(8);
        }
        sightCaptureUI.gXS.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI hxk;

            {
                this.hxk = r1;
            }

            public final void onClick(View view) {
                if (this.hxk.gFQ == 4) {
                    SightCaptureUI.m(this.hxk);
                } else if (this.hxk.gFQ == 3) {
                    SightCaptureUI.n(this.hxk);
                }
            }
        });
        sightCaptureUI.hwC.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI hxk;

            {
                this.hxk = r1;
            }

            public final void onClick(View view) {
                if (this.hxk.djL != null) {
                    this.hxk.djL.si();
                }
                this.hxk.aBD();
            }
        });
        sightCaptureUI.hwD.setOnClickListener(new OnClickListener(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI hxk;

            {
                this.hxk = r1;
            }

            public final void onClick(View view) {
                if (this.hxk.aBJ()) {
                    this.hxk.finish();
                    this.hxk.overridePendingTransition(-1, 2130968674);
                }
            }
        });
        sightCaptureUI.hwO.hvH = new MMSightCaptureTouchView.a(sightCaptureUI) {
            final /* synthetic */ SightCaptureUI hxk;

            {
                this.hxk = r1;
            }

            public final void v(float f, float f2) {
                if (this.hxk.gFQ != 0 && this.hxk.hwL != null) {
                    com.tencent.mm.plugin.mmsight.model.c d = this.hxk.hwy;
                    int width = this.hxk.hwL.getWidth();
                    int height = this.hxk.hwL.getHeight();
                    if (!com.tencent.mm.compatible.util.d.dX(14)) {
                        d.hmX.removeMessages(4354);
                        d.hmX.hnh = f;
                        d.hmX.gLd = f2;
                        d.hmX.hni = width;
                        d.hmX.hnj = height;
                        d.hmX.sendMessageDelayed(d.hmX.obtainMessage(4354, d.cdl), 400);
                    }
                    SightCaptureUI sightCaptureUI = this.hxk;
                    if (sightCaptureUI.hwI != null) {
                        LayoutParams layoutParams = (LayoutParams) sightCaptureUI.hwI.getLayoutParams();
                        layoutParams.leftMargin = ((int) f) - (sightCaptureUI.hwI.Zx / 2);
                        layoutParams.topMargin = ((int) f2) - (sightCaptureUI.hwI.QW / 2);
                        sightCaptureUI.hwI.setLayoutParams(layoutParams);
                        sightCaptureUI.hwI.aPX();
                    }
                }
            }

            public final void aBs() {
                if (this.hxk.gFQ != 0 && this.hxk.hxc > 1) {
                    this.hxk.hwy.hmX.removeMessages(4354);
                    SightCaptureUI.l(this.hxk);
                }
            }

            public final void aBt() {
                if (this.hxk.gFQ != 0 && this.hxk.hwy != null) {
                    this.hxk.hwy.a(true, false, 1);
                }
            }

            public final void aBu() {
                if (this.hxk.gFQ != 0 && this.hxk.hwy != null) {
                    this.hxk.hwy.a(false, false, 1);
                }
            }
        };
        sightCaptureUI.ni(0);
        sightCaptureUI.aBD();
    }

    static /* synthetic */ void g(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.hwN != null && sightCaptureUI.hwx) {
            sightCaptureUI.hwN.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    this.hxk.hwN.setVisibility(8);
                }
            }).start();
        }
    }

    static /* synthetic */ void h(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.hwz != null) {
            v.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", new Object[]{sightCaptureUI.hwz.aAk(), be.bur().toString()});
            sightCaptureUI.ni(5);
            if (sightCaptureUI.hwz.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.iWH) {
                sightCaptureUI.hxe = sightCaptureUI.aBE();
                if (sightCaptureUI.hxe < 0) {
                    sightCaptureUI.aBF();
                    return;
                }
            } else if (sightCaptureUI.hxe < 0) {
                sightCaptureUI.aBF();
                return;
            }
            sightCaptureUI.ni(2);
            if (sightCaptureUI.hwy != null) {
                com.tencent.mm.plugin.mmsight.model.c cVar = sightCaptureUI.hwy;
                v.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
                if (cVar.cdl != null && cVar.hmx) {
                    try {
                        Parameters parameters = cVar.cdl.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                            v.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                            parameters.setFocusMode("continuous-video");
                        }
                        cVar.cdl.setParameters(parameters);
                    } catch (Exception e) {
                        v.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[]{e.getMessage()});
                    }
                }
            }
            MMSightRecordButton mMSightRecordButton = sightCaptureUI.hwB;
            int i = (sightCaptureUI.hnB.duration * BaseReportManager.MAX_READ_COUNT) - 500;
            v.j("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[]{Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), new MMSightCircularProgressBar.a(sightCaptureUI) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void aBv() {
                    this.hxk.oT();
                }
            }});
            MMSightCircularProgressBar mMSightCircularProgressBar = mMSightRecordButton.hvX;
            Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(mMSightCircularProgressBar.bhY)});
            if (!mMSightCircularProgressBar.bhY) {
                mMSightCircularProgressBar.hvJ = 0;
            }
            mMSightCircularProgressBar = mMSightRecordButton.hvX;
            Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[]{Integer.valueOf(100)});
            mMSightCircularProgressBar.hvK = 100;
            mMSightCircularProgressBar = mMSightRecordButton.hvX;
            Log.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[]{Integer.valueOf(i)});
            mMSightCircularProgressBar.duration = i;
            mMSightRecordButton.hvX.setVisibility(0);
            mMSightRecordButton.hvX.hvN = new com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass1(mMSightRecordButton, r2);
            MMSightCircularProgressBar mMSightCircularProgressBar2 = mMSightRecordButton.hvX;
            Log.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", new Object[]{Integer.valueOf(mMSightCircularProgressBar2.hvJ), Integer.valueOf(mMSightCircularProgressBar2.hvK), Integer.valueOf(mMSightCircularProgressBar2.duration)});
            mMSightCircularProgressBar2.hvI = 0.0f;
            mMSightCircularProgressBar2.pPH = new a((float) mMSightCircularProgressBar2.hvJ, (float) mMSightCircularProgressBar2.hvK, mMSightCircularProgressBar2.duration);
            a aVar = mMSightCircularProgressBar2.pPH;
            v.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[]{new a.a(mMSightCircularProgressBar2) {
                final /* synthetic */ MMSightCircularProgressBar hvP;

                {
                    this.hvP = r1;
                }

                public final void am(float f) {
                    this.hvP.hvI = f;
                    this.hvP.invalidate();
                }

                public final void onAnimationEnd() {
                    Log.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 pPI;

                        {
                            this.pPI = r1;
                        }

                        public final void run() {
                            if (this.pPI.hvP.hvN != null) {
                                this.pPI.hvP.hvN.aBv();
                            }
                        }
                    });
                }
            }});
            aVar.pPO = r2;
            a aVar2 = mMSightCircularProgressBar2.pPH;
            v.i("MicroMsg.ProgressHandlerAnimator", "Start");
            aVar2.bhY = true;
            aVar2.pPM = be.Nj();
            aVar2.cSA.ea(20);
        }
    }

    static /* synthetic */ void l(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.hxg <= 0 || be.az(sightCaptureUI.hxg) > 500) {
            v.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[]{be.bur().toString(), Integer.valueOf(sightCaptureUI.gFQ)});
            sightCaptureUI.aBG();
            sightCaptureUI.hwZ = true;
            if (sightCaptureUI.gFQ == 2) {
                if (sightCaptureUI.hwz == null || !sightCaptureUI.hwz.aAo()) {
                    v.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    String str = "MicroMsg.SightCaptureUI";
                    String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(sightCaptureUI.gFQ);
                    objArr[1] = sightCaptureUI.hwz != null ? sightCaptureUI.hwz.aAk() : "";
                    v.i(str, str2, objArr);
                    if (sightCaptureUI.gFQ == 2 && sightCaptureUI.hwz != null && sightCaptureUI.hwz.aAk() == com.tencent.mm.plugin.sight.encode.a.b.b.iWE) {
                        sightCaptureUI.hwz.pause();
                        sightCaptureUI.hwy.a((Activity) sightCaptureUI, sightCaptureUI.hwH, false);
                        sightCaptureUI.hwR = sightCaptureUI.hwy.hmY;
                        if (sightCaptureUI.hwM != null) {
                            sightCaptureUI.hwM.F(sightCaptureUI.hwy.azU(), sightCaptureUI.hwy.azV(), sightCaptureUI.hwy.getOrientation());
                        }
                        if (sightCaptureUI.hwz.aAk() != com.tencent.mm.plugin.sight.encode.a.b.b.iWM) {
                            v.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[]{sightCaptureUI.hwz.aAk()});
                        } else {
                            int azU = sightCaptureUI.hwy.azU();
                            int azV = sightCaptureUI.hwy.azV();
                            int orientation = sightCaptureUI.hwy.getOrientation();
                            Point aAm = sightCaptureUI.hwz.aAm();
                            v.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[]{Integer.valueOf(azU), Integer.valueOf(azV), aAm, Integer.valueOf(orientation), Integer.valueOf(sightCaptureUI.hwz.aAn())});
                            if (!(sightCaptureUI.hwz.aAn() == orientation && aAm.x == azU && aAm.y == azV)) {
                                v.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
                            }
                            sightCaptureUI.hwz.i(sightCaptureUI.hwy.azU(), sightCaptureUI.hwy.azV(), sightCaptureUI.hwy.hmF.x, sightCaptureUI.hwy.hmF.y);
                            sightCaptureUI.hwz.D(orientation, sightCaptureUI.hwy.hmF.x, sightCaptureUI.hwy.hmF.y);
                        }
                    }
                    sightCaptureUI.hxa = true;
                }
            } else if (sightCaptureUI.gFQ == 1) {
                sightCaptureUI.ni(5);
                if (sightCaptureUI.ev(true)) {
                    sightCaptureUI.ni(1);
                }
            }
            sightCaptureUI.aBH();
            sightCaptureUI.hxg = be.Nj();
            return;
        }
        v.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
    }

    static /* synthetic */ void m(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.hoH.scene == 1 || sightCaptureUI.hoH.scene == 2) {
            int i = sightCaptureUI.hwZ ? sightCaptureUI.hxa ? 2 : 1 : 0;
            com.tencent.mm.plugin.report.service.g.iuh.h(13820, new Object[]{Integer.valueOf(i), Integer.valueOf(sightCaptureUI.hoH.scene)});
        }
        Intent intent = new Intent();
        String OZ = sightCaptureUI.hwz.OZ();
        String zz = com.tencent.mm.plugin.sight.base.d.zz(OZ);
        sightCaptureUI.Z(OZ, false);
        if (com.tencent.mm.plugin.mmsight.model.a.azP() != null) {
            sightCaptureUI.hwS.pRv = com.tencent.mm.plugin.mmsight.model.a.azP().bRQ();
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.hwy.hmY, OZ, zz, sightCaptureUI.hwz.getFileName(), sightCaptureUI.hwz.EB(), sightCaptureUI.hwz.aAl(), sightCaptureUI.hwS));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
    }

    static /* synthetic */ void n(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.hxf != null && sightCaptureUI.hxf.isAlive()) {
            try {
                sightCaptureUI.hxf.join();
            } catch (Throwable e) {
                v.a("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", new Object[]{e.getMessage()});
            }
        }
        if (sightCaptureUI.hoH.scene == 1 || sightCaptureUI.hoH.scene == 2) {
            int i = sightCaptureUI.hwZ ? 1 : 0;
            com.tencent.mm.plugin.report.service.g.iuh.h(13820, new Object[]{Integer.valueOf(i), Integer.valueOf(sightCaptureUI.hoH.scene)});
        }
        Intent intent = new Intent();
        sightCaptureUI.Z(sightCaptureUI.hwz.aAg(), true);
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.hwy.hmY, sightCaptureUI.hwz.aAg()));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
    }

    static /* synthetic */ void u(SightCaptureUI sightCaptureUI) {
        v.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        sightCaptureUI.hwO.setVisibility(8);
        Point ch = com.tencent.mm.plugin.mmsight.b.ch(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(2131493534);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(2131493536);
        sightCaptureUI.hwB.getX();
        sightCaptureUI.hwC.setTranslationX(((((float) ch.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.gXS.setTranslationX(((((float) (-ch.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.hwC.setEnabled(false);
        sightCaptureUI.gXS.setEnabled(false);
    }

    static /* synthetic */ void x(SightCaptureUI sightCaptureUI) {
        if (be.bl(sightCaptureUI.hwT) || sightCaptureUI.hwV <= 0 || sightCaptureUI.hwU <= 0) {
            v.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.hwT, 17, sightCaptureUI.hwU, sightCaptureUI.hwV, null);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.hwU, sightCaptureUI.hwV), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.hxb || sightCaptureUI.hwX == 180) {
                    int i = sightCaptureUI.hwW;
                    if (sightCaptureUI.hwX == 180) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.hwW - sightCaptureUI.hwX) == 0) {
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 90, CompressFormat.JPEG, sightCaptureUI.hwz.aAg(), false);
                    v.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", new Object[]{Long.valueOf(FileOp.jP(r1))});
                } catch (Exception e) {
                    v.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", new Object[]{e.getMessage()});
                }
                h.hoF.x(sightCaptureUI.hwT);
                sightCaptureUI.hwV = 0;
                sightCaptureUI.hwU = 0;
                sightCaptureUI.hwX = 0;
                sightCaptureUI.hwW = 0;
                sightCaptureUI.hwT = null;
            } catch (Throwable e2) {
                v.a("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", new Object[]{e2.getMessage()});
            }
        }
        sightCaptureUI.hxd = false;
    }

    public void onCreate(Bundle bundle) {
        aq(1);
        super.onCreate(bundle);
        this.hoH = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.hoH == null) {
            v.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gZK));
        final long Nj = be.Nj();
        this.gZK.z(new Runnable(this) {
            final /* synthetic */ SightCaptureUI hxk;

            public final void run() {
                v.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[]{Long.valueOf(be.az(Nj))});
                com.tencent.mm.plugin.mmsight.model.g.b(this.hxk.hoH.hnB);
                SightCaptureUI.b(this.hxk);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        v.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[]{nh(this.gFQ)});
        if (this.gFQ == 2) {
            oT();
        } else if (this.gFQ == 1) {
            aBI();
        } else if (this.gFQ == 4 && this.hwQ != null) {
            this.hwQ.pause();
        }
    }

    protected void onResume() {
        super.onResume();
        v.i("MicroMsg.SightCaptureUI", "onResume, currentState: %s", new Object[]{nh(this.gFQ)});
        if (this.gFQ == 2 || this.gFQ == 1) {
            aBD();
        } else if (this.gFQ == 4 && this.hwQ != null) {
            this.hwQ.start();
        }
    }

    protected final int NO() {
        return 1;
    }

    private void oT() {
        v.j("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[]{Integer.valueOf(this.gFQ)});
        if (this.gFQ == 2) {
            ni(6);
            this.hwB.eu(false);
            final int azU = this.hwy.azU();
            final int azV = this.hwy.azV();
            this.hwz.s(new Runnable(this) {
                final /* synthetic */ SightCaptureUI hxk;

                public final void run() {
                    v.j("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[]{SightCaptureUI.nh(this.hxk.gFQ)});
                    this.hxk.hwy.a(com.tencent.mm.plugin.mmsight.model.c.a.Stoping);
                    this.hxk.aBI();
                    final long ww = com.tencent.mm.plugin.mmsight.b.ww("TIME_RECODER_2_PLAY");
                    e.a(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 hxp;

                        public final void run() {
                            String OZ = this.hxp.hxk.hwz.OZ();
                            try {
                                if (!be.kS(OZ) && FileOp.aR(OZ)) {
                                    int i;
                                    int i2;
                                    int i3;
                                    int i4;
                                    int i5;
                                    com.tencent.mm.plugin.report.service.g.iuh.a(440, 87, 1, false);
                                    int i6 = (int) new JSONObject(SightVideoJNI.getSimpleMp4Info(OZ)).getDouble("videoFPS");
                                    v.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s", new Object[]{Integer.valueOf(i6)});
                                    com.tencent.mm.plugin.mmsight.model.a azP = com.tencent.mm.plugin.mmsight.model.a.azP();
                                    azP.hmc = com.tencent.mm.plugin.mmsight.model.g.hns.ceR;
                                    azP.cGx = com.tencent.mm.plugin.mmsight.model.g.hns.cGx;
                                    azP.ceS = com.tencent.mm.plugin.mmsight.model.g.hns.hnC ? 1 : 0;
                                    azP.hmd = com.tencent.mm.plugin.mmsight.model.g.hns.hnD ? 1 : 0;
                                    azP.hme = com.tencent.mm.plugin.mmsight.model.g.hns.hme;
                                    azP.hmf = i6;
                                    azP.fileSize = FileOp.jP(OZ);
                                    com.tencent.mm.plugin.sight.base.a zD = com.tencent.mm.plugin.sight.base.d.zD(OZ);
                                    if (zD != null) {
                                        azP.hmi = zD.width;
                                        azP.hmj = zD.height;
                                        azP.hmk = zD.cGx;
                                        azP.hmg = zD.hpy;
                                    }
                                    if (com.tencent.mm.plugin.mmsight.model.g.hns.ceR == 1) {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, 89, 1, false);
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, 49, (long) i6, false);
                                        i = 93;
                                        i2 = 73;
                                        i3 = 69;
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, 88, 1, false);
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, 48, (long) i6, false);
                                        i = 90;
                                        i2 = 54;
                                        i3 = 50;
                                    }
                                    if (com.tencent.mm.plugin.mmsight.model.g.hns.hme == 720) {
                                        i2 += 6;
                                        i4 = i + 1;
                                        i5 = i3 + 6;
                                    } else if (com.tencent.mm.plugin.mmsight.model.g.hns.aAd()) {
                                        i2 += 12;
                                        i4 = i + 2;
                                        i5 = i3 + 12;
                                    } else {
                                        i4 = i;
                                        i5 = i3;
                                    }
                                    com.tencent.mm.plugin.report.service.g.iuh.a(440, (long) i2, (long) i6, false);
                                    com.tencent.mm.plugin.report.service.g.iuh.a(440, (long) i4, 1, false);
                                    com.tencent.mm.plugin.report.service.g.iuh.a(440, 47, (long) i6, false);
                                    v.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[]{OZ, Integer.valueOf(i5)});
                                    if (i6 >= 0 && i6 <= 10) {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, (long) i5, 1, false);
                                    } else if (i6 > 10 && i6 <= 15) {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, (long) (i5 + 1), 1, false);
                                    } else if (i6 > 15 && i6 <= 20) {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, (long) (i5 + 2), 1, false);
                                    } else if (i6 > 20 && i6 <= 30) {
                                        com.tencent.mm.plugin.report.service.g.iuh.a(440, (long) (i5 + 3), 1, false);
                                    }
                                }
                            } catch (Exception e) {
                                v.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[]{e.getMessage()});
                            }
                            com.tencent.mm.plugin.mmsight.model.h.b(false, ww);
                        }
                    }, "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
                    v.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[]{be.bur().toString()});
                    v.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[]{this.hxk.hwz.OZ(), Long.valueOf(FileOp.jP(this.hxk.hwz.OZ())), Long.valueOf(ww)});
                    SightCaptureUI.u(this.hxk);
                    f.q(new Runnable(this.hxk) {
                        final /* synthetic */ SightCaptureUI hxk;

                        {
                            this.hxk = r1;
                        }

                        public final void run() {
                            String wu = com.tencent.mm.plugin.mmsight.b.wu(this.hxk.hwz.OZ());
                            if (!be.kS(wu)) {
                                wu = ((wu + "\n" + String.format("FPS: %s", new Object[]{Float.valueOf(this.hxk.hwz.aAh())})) + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(com.tencent.mm.plugin.mmsight.b.ww("TIME_RECODER_2_PLAY"))})) + "\n" + String.format("CPU: cur %s max:%s", new Object[]{l.rA(), l.ry()});
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass8 hxr;

                                    public final void run() {
                                        v.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", new Object[]{wu});
                                        i.aAw();
                                        if (i.aAz()) {
                                            TextView textView = (TextView) this.hxr.hxk.findViewById(2131755561);
                                            textView.setVisibility(0);
                                            textView.setText(wu);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    SightCaptureUI.G(this.hxk);
                    ad.g(this.hxk.hxi, 1000);
                    if (this.hxk.hoH.scene == 1 || this.hxk.hoH.scene == 2) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(13819, new Object[]{Integer.valueOf(2), Integer.valueOf(this.hxk.hoH.scene)});
                    }
                }
            });
        }
    }

    private void aBD() {
        ni(0);
        this.hxe = 0;
        this.hxd = false;
        this.hwQ.stop();
        this.hwQ.iVc = null;
        try {
            ViewGroup.LayoutParams layoutParams = this.hwQ.getLayoutParams();
            this.hwE.removeView(this.hwQ);
            this.hwE.addView(this.hwQ, 0, layoutParams);
        } catch (Exception e) {
            v.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[]{e.getMessage()});
        }
        this.hwK.setImageBitmap(null);
        aBI();
        this.hwy = new com.tencent.mm.plugin.mmsight.model.c(this.hnB, this.hoH.scene);
        this.hwy.a(this.hwM.hxE);
        if (this.hwy.f(this, this.hwR)) {
            if (this.hwA.isAvailable()) {
                v.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface");
                this.hwH = this.hwA.getSurfaceTexture();
                if (ev(false)) {
                    ni(1);
                } else {
                    ni(7);
                }
            } else {
                this.hwA.a(new com.tencent.mm.plugin.video.b(this) {
                    final /* synthetic */ SightCaptureUI hxk;

                    {
                        this.hxk = r1;
                    }

                    public final void a(SurfaceTexture surfaceTexture) {
                        v.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface");
                        this.hxk.hwH = surfaceTexture;
                        if (this.hxk.ev(false)) {
                            this.hxk.ni(1);
                        } else {
                            this.hxk.ni(7);
                        }
                    }
                });
            }
            if (this.hwN != null && this.hwx) {
                this.hwN.setAlpha(1.0f);
                this.hwN.setVisibility(0);
            }
            b bVar = this.hwY;
            v.i("MicroMsg.DeviceOrientationListener", "reset");
            bVar.hmo = -1;
            bVar.orientation = -1;
            bVar.hmn = -1;
            this.hwZ = false;
            this.hxa = false;
            return;
        }
        ni(7);
    }

    private boolean ev(boolean z) {
        v.h("MicroMsg.SightCaptureUI", "createRecorder", new Object[0]);
        if (this.hwz != null) {
            if (this.hwy != null) {
                com.tencent.mm.plugin.mmsight.model.c cVar = this.hwy;
                com.tencent.mm.plugin.mmsight.model.c.b aAj = this.hwz.aAj();
                if (aAj != null) {
                    cVar.hmJ.remove(aAj);
                }
            }
            this.hwz.cancel();
        }
        if (this.hwy == null) {
            return false;
        }
        this.hwS = new ahn();
        this.hwS.mHd = true;
        if (z) {
            boolean a = this.hwy.a((Activity) this, this.hwH, true);
            this.hwR = this.hwy.hmY;
            if (!a) {
                return false;
            }
        } else if (this.hwy.a(this.hwH, true) < 0) {
            return false;
        }
        if (this.hwy.hmF == null) {
            return false;
        }
        i.aAw();
        this.hwz = i.c(this.hnB);
        if (this.hwz == null) {
            v.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            return false;
        }
        com.tencent.mm.plugin.mmsight.b.a(this.hwz, this.hoH);
        this.hwz.a(this);
        this.hwy.a(this.hwz.aAj());
        if (this.hwM != null) {
            this.hwM.F(this.hwy.azU(), this.hwy.azV(), this.hwy.getOrientation());
        }
        this.hwz.i(this.hwy.azU(), this.hwy.azV(), this.hwy.hmF.x, this.hwy.hmF.y);
        v.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[]{Boolean.valueOf(this.hwz.mY(this.hwy.getOrientation()))});
        return this.hwz.mY(this.hwy.getOrientation());
    }

    private int aBE() {
        v.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int b = this.hwz.b(this.hwy.getOrientation(), this.hwY.azQ(), this.hwY.getOrientation());
        v.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[]{Integer.valueOf(b)});
        if (b >= 0) {
            this.hwy.a(com.tencent.mm.plugin.mmsight.model.c.a.Recording);
        }
        return b;
    }

    private void aBF() {
        ni(7);
        if (this.hwz != null) {
            try {
                this.hwz.cancel();
                this.hwz = null;
            } catch (Throwable e) {
                v.a("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
    }

    private void aBG() {
        i.aAw();
        if (i.aAz()) {
            TextView textView = (TextView) findViewById(2131755561);
            textView.setVisibility(8);
            textView.setText("");
        }
    }

    private void aBH() {
        i.aAw();
        if (i.aAz()) {
            v.i("MicroMsg.SightCaptureUI", "test for debug " + be.bur().toString());
            f.r(new Runnable(this) {
                final /* synthetic */ SightCaptureUI hxk;

                {
                    this.hxk = r1;
                }

                public final void run() {
                    SightCaptureUI.I(this.hxk);
                }
            });
        }
    }

    private void Z(String str, boolean z) {
        String lV;
        boolean booleanValue = ((Boolean) CaptureMMProxy.getInstance().get(t.a.nuh, Boolean.valueOf(true))).booleanValue();
        boolean booleanValue2 = ((Boolean) CaptureMMProxy.getInstance().get(t.a.nui, Boolean.valueOf(true))).booleanValue();
        if (z) {
            lV = com.tencent.mm.plugin.mmsight.b.lV("jpg");
        } else {
            lV = com.tencent.mm.plugin.mmsight.b.lV("mp4");
        }
        if ((booleanValue && z) || (booleanValue2 && !z)) {
            v.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[]{str, lV, Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2)});
            FileOp.p(str, lV);
            com.tencent.mm.platformtools.d.c(lV, this);
        }
    }

    private void aBI() {
        if (this.hwy != null) {
            this.hwR = this.hwy.hmY;
            this.hwy.azR();
            this.hxg = -1;
            this.pPR = -1;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        v.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.gZK.release();
        if (this.hwz != null) {
            this.hwz.s(null);
        }
        if ((this.gFQ == -1 ? 1 : null) == null) {
            aBI();
            if (this.hwQ != null) {
                this.hwQ.stop();
                this.hwQ.iVc = null;
            }
            if (this.djL != null) {
                this.djL.si();
            }
        }
        if (this.hwY != null) {
            this.hwY.disable();
            this.hwY = null;
        }
        h.hoF.wc();
    }

    protected final int getLayoutId() {
        return 2130903163;
    }

    private static String nh(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 5) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 6) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 7) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 8) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void ni(int i) {
        v.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[]{Integer.valueOf(this.gFQ), nh(this.gFQ), Integer.valueOf(i), nh(i)});
        v.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[]{Integer.valueOf(this.gFQ), nh(this.gFQ), Integer.valueOf(i), nh(i), be.bur().toString()});
        if (i != this.gFQ) {
            com.tencent.mm.plugin.mmsight.b.wv("TIME_RECODER_2_PLAY");
            this.gFQ = i;
            if (this.gFQ != 6) {
                ad.B(this.hxh);
            }
            if (this.gFQ == 0) {
                this.hwE.setVisibility(8);
                this.hwF.setVisibility(8);
                this.hwK.setVisibility(8);
                if (this.hxc > 1) {
                    this.hwG.setVisibility(0);
                }
                if (this.hwy != null) {
                    this.hwy.a(com.tencent.mm.plugin.mmsight.model.c.a.Preview);
                }
                com.tencent.mm.plugin.mmsight.model.a.reset();
                if (this.hxf != null) {
                    try {
                        this.hxf.interrupt();
                    } catch (Throwable e) {
                        v.a("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", new Object[]{e.getMessage()});
                    }
                    this.hxf = null;
                }
            } else if (this.gFQ == 1 || this.gFQ == 2) {
                this.hwE.setVisibility(0);
                this.hwF.setVisibility(0);
                this.hwF.setClipChildren(false);
                this.hwC.setVisibility(8);
                this.gXS.setVisibility(8);
                this.hwD.setVisibility(0);
                this.hwB.setVisibility(0);
                this.hwQ.setVisibility(8);
                if (this.gFQ == 1) {
                    this.hwB.reset();
                } else {
                    this.hwB.eu(true);
                    MMSightRecordButton mMSightRecordButton = this.hwB;
                    v.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
                    mMSightRecordButton.hvW.setVisibility(8);
                }
                this.hwP.setVisibility(8);
                this.hwK.setVisibility(8);
                this.hwO.setVisibility(0);
                if (this.hxc > 1) {
                    this.hwG.setVisibility(0);
                }
                this.hwO.bringToFront();
                this.hwG.bringToFront();
                aBG();
                aBH();
            } else if (this.gFQ == 4 || this.gFQ == 3) {
                this.hwE.setVisibility(0);
                this.hwF.setVisibility(0);
                this.hwF.setClipChildren(false);
                this.hwC.setVisibility(0);
                this.gXS.setVisibility(0);
                this.hwD.setVisibility(8);
                this.hwB.setVisibility(8);
                if (this.gFQ == 3) {
                    this.hwK.setVisibility(0);
                    this.hwQ.setVisibility(8);
                } else {
                    this.hwK.setVisibility(8);
                    this.hwQ.setVisibility(0);
                    if (this.hwz.azQ()) {
                        com.tencent.mm.plugin.mmsight.ui.cameraglview.a aVar = this.hwM;
                        if (aVar.hxF != null) {
                            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = aVar.hxF;
                            if (mMSightCameraGLSurfaceView.hyc != null) {
                                mMSightCameraGLSurfaceView.hyc.hya = true;
                                mMSightCameraGLSurfaceView.requestRender();
                            }
                        }
                    }
                }
                this.hwO.setVisibility(8);
            } else if (this.gFQ == 5) {
                this.hwC.setVisibility(8);
                this.gXS.setVisibility(8);
                this.hwD.setVisibility(8);
                this.hwB.setVisibility(8);
            } else if (this.gFQ == 6) {
                this.hwC.setVisibility(8);
                this.gXS.setVisibility(8);
                this.hwD.setVisibility(8);
                this.hwG.setVisibility(8);
                this.hwB.eu(false);
                ad.g(this.hxh, 1500);
                this.hwB.aBw();
            } else if (this.gFQ == 7) {
                this.hwE.setVisibility(0);
                this.hwF.setVisibility(0);
                this.hwF.setClipChildren(false);
                this.hwC.setVisibility(8);
                this.gXS.setVisibility(8);
                this.hwD.setVisibility(0);
                if (this.hxc > 1) {
                    this.hwG.setVisibility(0);
                }
                this.hwB.setVisibility(0);
                this.hwO.setVisibility(0);
                this.hwQ.setVisibility(8);
                this.hwP.setVisibility(8);
                this.hwK.setVisibility(8);
                Toast.makeText(this, 2131233846, 1).show();
                this.hwB.eu(false);
                this.hwB.setEnabled(false);
            } else if (this.gFQ == 8) {
                this.hwC.setVisibility(8);
                this.gXS.setVisibility(8);
                this.hwD.setVisibility(0);
                this.hwG.setVisibility(8);
                this.hwB.reset();
                this.hwB.eu(false);
                this.hwB.setEnabled(false);
                Toast.makeText(this, 2131233843, 1).show();
            }
        }
    }

    public void onBackPressed() {
        v.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[]{Integer.valueOf(this.gFQ)});
        if (aBJ()) {
            super.onBackPressed();
            overridePendingTransition(-1, 2130968674);
        }
    }

    private boolean aBJ() {
        return this.gFQ == 4 || this.gFQ == 3 || this.gFQ == 1 || this.gFQ == 7 || this.gFQ == 8;
    }

    public final void mW(int i) {
        if (this.hxc > 1 && this.gFQ != 2) {
            v.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[]{Integer.valueOf(i)});
            if (i >= 0) {
                float f;
                if (i != 90 && i != 270) {
                    f = (float) i;
                } else if (i == 270) {
                    f = 90.0f;
                } else {
                    f = -90.0f;
                }
                if (this.hwG.getRotation() != f) {
                    this.hwG.animate().rotation(f).setDuration(100).start();
                }
            }
        }
    }

    public final void aAp() {
        v.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[]{Integer.valueOf(1)});
        try {
            if (this.hwz != null) {
                this.hwz.reset();
            }
        } catch (Exception e) {
            v.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[]{e.getMessage()});
        }
        ni(8);
    }
}
