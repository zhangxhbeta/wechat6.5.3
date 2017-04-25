package com.tencent.mm.plugin.f2f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.pluginsdk.j.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public class FaceToFaceVideoView extends TextureView implements SurfaceTextureListener {
    private boolean cXI = false;
    private ac cnC = new ac(Looper.getMainLooper());
    private int fET;
    private int fEU;
    private int fGk = 0;
    private Bitmap fIN;
    private Paint fIO;
    private Rect fIR = new Rect();
    private RectF fIS = new RectF();
    private m fIU = new m("FaceToFaceVideoView");
    boolean fIZ = false;
    private boolean fJA;
    private boolean fJB;
    private int[] fJC;
    private int fJD;
    private int fJE;
    private int fJF;
    private int fJG;
    private RectF fJH = new RectF();
    private boolean fJI = false;
    private float fJJ = 0.0f;
    private float fJK = 0.0f;
    float fJL = 0.0f;
    private int fJM = 0;
    int fJN = 0;
    int fJO = 0;
    private int fJP = 0;
    private int fJQ = 0;
    a fJR = null;
    private boolean fJS = false;
    private boolean fJu = false;
    private boolean fJv = false;
    private ad fJw = null;
    private b fJx = null;
    private Matrix fJy = new Matrix();
    private Matrix fJz;

    public interface a {
        void bC(int i, int i2);

        void d(int i, int i2, float f);
    }

    private class b implements Runnable {
        final /* synthetic */ FaceToFaceVideoView fJT;

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r1 = 0;
            r2 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
            java.lang.System.currentTimeMillis();
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r1 = r0.lockCanvas();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fJz;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r0 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x0015:
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fJJ;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r0 <= 0) goto L_0x0029;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x001f:
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fJK;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r0 > 0) goto L_0x002e;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x0029:
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0.ali();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x002e:
            java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r1 == 0) goto L_0x0086;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x0033:
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = 1;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0.fJS = r2;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r1.save();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fJC;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r0 == 0) goto L_0x0091;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x0044:
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            com.tencent.mm.plugin.f2f.FaceToFaceVideoView.g(r0);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fJH;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.left;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = -r0;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = r2.fJH;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = r2.top;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = -r2;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r1.translate(r0, r2);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fJy;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r1.concat(r0);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.fIN;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = r2.fIR;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r3 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r3 = r3.fIS;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r4 = 0;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r1.drawBitmap(r0, r2, r3, r4);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x007d:
            r1.restore();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = 0;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0.fJS = r2;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
        L_0x0086:
            java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r1 == 0) goto L_0x0090;
        L_0x008b:
            r0 = r6.fJT;
            r0.unlockCanvasAndPost(r1);
        L_0x0090:
            return;
        L_0x0091:
            r0 = r6.fJT;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.getResources();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r2 = 2131689781; // 0x7f0f0135 float:1.9008587E38 double:1.0531946884E-314;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.getColor(r2);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r1.drawColor(r0);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            goto L_0x007d;
        L_0x00a2:
            r0 = move-exception;
            r2 = "MicroMsg.FaceToFaceVideoView";	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r3 = "draw error: %s";	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r4 = 1;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r5 = 0;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r0 = r0.getMessage();	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            r4[r5] = r0;	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);	 Catch:{ Exception -> 0x00a2, all -> 0x00be }
            if (r1 == 0) goto L_0x0090;
        L_0x00b8:
            r0 = r6.fJT;
            r0.unlockCanvasAndPost(r1);
            goto L_0x0090;
        L_0x00be:
            r0 = move-exception;
            if (r1 == 0) goto L_0x00c6;
        L_0x00c1:
            r2 = r6.fJT;
            r2.unlockCanvasAndPost(r1);
        L_0x00c6:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.f2f.FaceToFaceVideoView.b.run():void");
        }

        private b(FaceToFaceVideoView faceToFaceVideoView) {
            this.fJT = faceToFaceVideoView;
        }
    }

    static /* synthetic */ void g(FaceToFaceVideoView faceToFaceVideoView) {
        if (faceToFaceVideoView.fIN == null) {
            faceToFaceVideoView.fIN = Bitmap.createBitmap(faceToFaceVideoView.fJD, faceToFaceVideoView.fJE, Config.ARGB_8888);
        }
        faceToFaceVideoView.fIN.setPixels(faceToFaceVideoView.fJC, 0, faceToFaceVideoView.fJD, 0, 0, faceToFaceVideoView.fJD, faceToFaceVideoView.fJE);
        if (faceToFaceVideoView.fJy == null) {
            faceToFaceVideoView.fJy = new Matrix();
        }
        faceToFaceVideoView.fJy.reset();
        if (faceToFaceVideoView.fJB) {
            faceToFaceVideoView.fJy.postRotate(90.0f, (float) (faceToFaceVideoView.fJD / 2), (float) (faceToFaceVideoView.fJE / 2));
        } else {
            faceToFaceVideoView.fJy.postRotate(-90.0f, (float) (faceToFaceVideoView.fJD / 2), (float) (faceToFaceVideoView.fJE / 2));
        }
        if (faceToFaceVideoView.fJA) {
            faceToFaceVideoView.fJy.postScale(-1.0f, 1.0f, (float) (faceToFaceVideoView.fJD / 2), (float) (faceToFaceVideoView.fJE / 2));
        }
        faceToFaceVideoView.fJM = (faceToFaceVideoView.fIN.getWidth() / 2) - (faceToFaceVideoView.fJF / 2);
        faceToFaceVideoView.fGk = (faceToFaceVideoView.fIN.getHeight() / 2) - (faceToFaceVideoView.fJG / 2);
        if (faceToFaceVideoView.fJL != 0.0f) {
            int width = faceToFaceVideoView.fIN.getWidth();
            int height = faceToFaceVideoView.fIN.getHeight();
            if (faceToFaceVideoView.fJB) {
                width = faceToFaceVideoView.fIN.getHeight();
                height = faceToFaceVideoView.fIN.getWidth();
            }
            faceToFaceVideoView.fJN = ((int) (((float) width) - (((float) faceToFaceVideoView.fET) / faceToFaceVideoView.fJL))) / 2;
            faceToFaceVideoView.fJO = ((int) (((float) height) - (((float) faceToFaceVideoView.fEU) / faceToFaceVideoView.fJL))) / 2;
        }
        if (!((faceToFaceVideoView.fJN == faceToFaceVideoView.fJP && faceToFaceVideoView.fJO == faceToFaceVideoView.fJQ) || faceToFaceVideoView.cnC == null)) {
            faceToFaceVideoView.cnC.post(new Runnable(faceToFaceVideoView) {
                final /* synthetic */ FaceToFaceVideoView fJT;

                {
                    this.fJT = r1;
                }

                public final void run() {
                    if (this.fJT.fJR != null) {
                        this.fJT.fJR.d(this.fJT.fJN, this.fJT.fJO, this.fJT.fJL);
                    }
                }
            });
            faceToFaceVideoView.fJP = faceToFaceVideoView.fJN;
            faceToFaceVideoView.fJQ = faceToFaceVideoView.fJO;
        }
        faceToFaceVideoView.fIR.left = faceToFaceVideoView.fJM;
        faceToFaceVideoView.fIR.top = faceToFaceVideoView.fGk;
        faceToFaceVideoView.fIR.right = faceToFaceVideoView.fJM + faceToFaceVideoView.fJF;
        faceToFaceVideoView.fIR.bottom = faceToFaceVideoView.fGk + faceToFaceVideoView.fJG;
        faceToFaceVideoView.fIS.left = 0.0f;
        faceToFaceVideoView.fIS.top = 0.0f;
        faceToFaceVideoView.fIS.right = (float) faceToFaceVideoView.fJF;
        faceToFaceVideoView.fIS.bottom = (float) faceToFaceVideoView.fJG;
        faceToFaceVideoView.fJH = new RectF();
        faceToFaceVideoView.fJy.mapRect(faceToFaceVideoView.fJH, faceToFaceVideoView.fIS);
    }

    public FaceToFaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FaceToFaceVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        v.d("MicroMsg.FaceToFaceVideoView", "init");
        setOpaque(true);
        setSurfaceTextureListener(this);
        this.fIO = new Paint();
        this.fIO.setAntiAlias(true);
        this.fJx = new b();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        v.d("MicroMsg.FaceToFaceVideoView", "onSurfaceTextureAvailable, width: %d, height: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.fET = i;
        this.fEU = i2;
        if (this.fJR != null) {
            this.fJR.bC(i, i2);
        }
        if (this.fJz == null) {
            ali();
        }
        if (this.fJR != null) {
            this.fJR.d(this.fJN, this.fJO, this.fJL);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        v.d("MicroMsg.FaceToFaceVideoView", "onSurfaceTextureSizeChanged");
        this.fET = i;
        this.fEU = i2;
        if (this.fJR != null) {
            this.fJR.bC(i, i2);
        }
        ali();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        v.d("MicroMsg.FaceToFaceVideoView", "onSurfaceTextureDestroyed");
        this.fJu = false;
        try {
            if (this.fJw != null) {
                this.fJw.htb.quit();
            }
            this.fIN = null;
            this.fJC = null;
        } catch (Throwable e) {
            v.a("MicroMsg.FaceToFaceVideoView", e, "", new Object[0]);
        }
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.fJz == null) {
            ali();
        }
    }

    private void ali() {
        if (this.fJF != 0 && this.fJG != 0) {
            if (this.fET == 0 || this.fEU == 0) {
                this.fET = getWidth();
                this.fEU = getHeight();
            }
            if (this.fEU != 0 && this.fET != 0) {
                this.fJz = new Matrix();
                this.fJJ = ((float) this.fET) / ((float) (this.fJI ? this.fJG : this.fJF));
                this.fJK = ((float) this.fEU) / ((float) (this.fJI ? this.fJF : this.fJG));
                this.fJL = Math.max(this.fJJ, this.fJK);
                this.fJz.setScale(this.fJL, this.fJL);
                setTransform(this.fJz);
                v.d("MicroMsg.FaceToFaceVideoView", "initTransformMatrix, viewWidth: %d, viewHeight: %d, clipImgWidth: %d, clipImgHeight: %d, scaleX: %f, scaleY: %f, finalScale: %f isLocal %b", new Object[]{Integer.valueOf(this.fET), Integer.valueOf(this.fEU), Integer.valueOf(this.fJF), Integer.valueOf(this.fJG), Float.valueOf(this.fJJ), Float.valueOf(this.fJK), Float.valueOf(this.fJL), Boolean.valueOf(this.fIZ)});
            }
        }
    }
}
