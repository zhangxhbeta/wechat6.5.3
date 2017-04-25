package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;

public final class a extends Drawable implements Animatable {
    private ac fnw;
    private final Paint ft;
    private long gCA;
    private long gCB;
    private int gCC;
    private boolean gCD;
    int gCE;
    private int gCF;
    e gCG;
    private final Runnable gCH;
    final Runnable gCI;
    private final Runnable gCJ;
    final Runnable gCK;
    private final Runnable gCL;
    private final Runnable gCM;
    boolean gCm;
    boolean gCn;
    private volatile long gCo;
    private final int[] gCp;
    private float gCq;
    private float gCr;
    private boolean gCs;
    private int[] gCt;
    private int gCu;
    private int gCv;
    private long gCw;
    private long gCx;
    private long gCy;
    private long gCz;
    private float mDensity;
    private final Rect tG;

    final void e(Runnable runnable, long j) {
        this.gCB = SystemClock.uptimeMillis() + j;
        if (this.fnw != null) {
            this.fnw.postAtTime(runnable, this.gCB);
        }
    }

    public a(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
    }

    public a(String str) {
        this.gCm = true;
        this.gCn = false;
        this.gCp = new int[6];
        this.gCq = 1.0f;
        this.gCr = 1.0f;
        this.tG = new Rect();
        this.ft = new Paint(6);
        this.gCu = 0;
        this.gCv = -1;
        this.gCw = 0;
        this.gCx = 0;
        this.gCy = 0;
        this.gCz = 0;
        this.gCB = 0;
        this.gCC = 120;
        this.gCD = false;
        this.gCE = 0;
        this.gCF = 0;
        this.fnw = new ac();
        this.gCH = new Runnable(this) {
            final /* synthetic */ a gCN;

            {
                this.gCN = r1;
            }

            public final void run() {
                if (this.gCN.gCG != null) {
                    this.gCN.gCG.onAnimationEnd();
                }
            }
        };
        this.gCI = new Runnable(this) {
            final /* synthetic */ a gCN;

            {
                this.gCN = r1;
            }

            public final void run() {
                if ((this.gCN.isRunning() || this.gCN.gCv == 0) && SystemClock.uptimeMillis() >= this.gCN.gCB) {
                    this.gCN.gCz = System.currentTimeMillis();
                    this.gCN.invalidateSelf();
                    if (this.gCN.gCG != null) {
                        this.gCN.gCG.invalidate();
                    }
                }
            }
        };
        this.gCJ = new Runnable(this) {
            final /* synthetic */ a gCN;

            {
                this.gCN = r1;
            }

            public final void run() {
                MMGIFJNI.restoreRemainder(this.gCN.gCo);
                this.gCN.e(this.gCN.gCI, this.gCN.gCy);
            }
        };
        this.gCK = new Runnable(this) {
            final /* synthetic */ a gCN;

            {
                this.gCN = r1;
            }

            public final void run() {
                MMGIFJNI.reset(this.gCN.gCo);
            }
        };
        this.gCL = new Runnable(this) {
            final /* synthetic */ a gCN;

            {
                this.gCN = r1;
            }

            public final void run() {
                MMGIFJNI.saveRemainder(this.gCN.gCo);
            }
        };
        this.gCM = new Runnable(this) {
            final /* synthetic */ a gCN;

            {
                this.gCN = r1;
            }

            public final void run() {
                if (this.gCN.gCn) {
                    v.i("MicroMsg.GIF.MMGIFDrawable", "This gif had been recycle.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (this.gCN.gCv + 1 > this.gCN.gCu - 1) {
                    this.gCN.gCv = -1;
                }
                this.gCN.gCv = this.gCN.gCv + 1;
                if (MMGIFJNI.drawFramePixels(this.gCN.gCo, this.gCN.gCt, this.gCN.gCp)) {
                    this.gCN.gCF = this.gCN.gCF + 1;
                }
                this.gCN.gCw = System.currentTimeMillis() - currentTimeMillis;
                if (this.gCN.gCx != 0) {
                    this.gCN.gCy = (this.gCN.gCx - this.gCN.gCw) - this.gCN.gCA;
                    if (this.gCN.gCy < 0) {
                        v.d("MicroMsg.GIF.MMGIFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", Long.valueOf(this.gCN.gCw), Long.valueOf(this.gCN.gCA), Long.valueOf(this.gCN.gCy), Long.valueOf(this.gCN.gCx), Integer.valueOf(this.gCN.gCp[5]));
                        g.iuh.a(401, 0, 1, false);
                        g.iuh.a(401, 1, Math.abs(this.gCN.gCy), false);
                    }
                }
                this.gCN.e(this.gCN.gCI, this.gCN.gCy > 0 ? this.gCN.gCy : 0);
                if (this.gCN.gCp[2] == 1) {
                    this.gCN.gCx = 5000;
                } else {
                    this.gCN.gCx = (long) this.gCN.gCp[4];
                }
            }
        };
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("file path is null.");
        }
        this.gCo = MMGIFJNI.openByFilePath(str, this.gCp);
        init();
    }

    private a(AssetFileDescriptor assetFileDescriptor) {
        this.gCm = true;
        this.gCn = false;
        this.gCp = new int[6];
        this.gCq = 1.0f;
        this.gCr = 1.0f;
        this.tG = new Rect();
        this.ft = new Paint(6);
        this.gCu = 0;
        this.gCv = -1;
        this.gCw = 0;
        this.gCx = 0;
        this.gCy = 0;
        this.gCz = 0;
        this.gCB = 0;
        this.gCC = 120;
        this.gCD = false;
        this.gCE = 0;
        this.gCF = 0;
        this.fnw = new ac();
        this.gCH = /* anonymous class already generated */;
        this.gCI = /* anonymous class already generated */;
        this.gCJ = /* anonymous class already generated */;
        this.gCK = /* anonymous class already generated */;
        this.gCL = /* anonymous class already generated */;
        this.gCM = /* anonymous class already generated */;
        if (assetFileDescriptor == null) {
            throw new NullPointerException("assert file descritptor is null.");
        }
        this.gCo = MMGIFJNI.openByFileDescroptor(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), this.gCp);
        init();
    }

    public a(InputStream inputStream) {
        this.gCm = true;
        this.gCn = false;
        this.gCp = new int[6];
        this.gCq = 1.0f;
        this.gCr = 1.0f;
        this.tG = new Rect();
        this.ft = new Paint(6);
        this.gCu = 0;
        this.gCv = -1;
        this.gCw = 0;
        this.gCx = 0;
        this.gCy = 0;
        this.gCz = 0;
        this.gCB = 0;
        this.gCC = 120;
        this.gCD = false;
        this.gCE = 0;
        this.gCF = 0;
        this.fnw = new ac();
        this.gCH = /* anonymous class already generated */;
        this.gCI = /* anonymous class already generated */;
        this.gCJ = /* anonymous class already generated */;
        this.gCK = /* anonymous class already generated */;
        this.gCL = /* anonymous class already generated */;
        this.gCM = /* anonymous class already generated */;
        if (inputStream == null) {
            throw new NullPointerException("input stream is null.");
        }
        this.gCo = MMGIFJNI.openByInputStrem(inputStream, this.gCp);
        init();
    }

    public a(byte[] bArr) {
        this.gCm = true;
        this.gCn = false;
        this.gCp = new int[6];
        this.gCq = 1.0f;
        this.gCr = 1.0f;
        this.tG = new Rect();
        this.ft = new Paint(6);
        this.gCu = 0;
        this.gCv = -1;
        this.gCw = 0;
        this.gCx = 0;
        this.gCy = 0;
        this.gCz = 0;
        this.gCB = 0;
        this.gCC = 120;
        this.gCD = false;
        this.gCE = 0;
        this.gCF = 0;
        this.fnw = new ac();
        this.gCH = /* anonymous class already generated */;
        this.gCI = /* anonymous class already generated */;
        this.gCJ = /* anonymous class already generated */;
        this.gCK = /* anonymous class already generated */;
        this.gCL = /* anonymous class already generated */;
        this.gCM = /* anonymous class already generated */;
        if (bArr == null) {
            throw new NullPointerException("bytes is null.");
        }
        this.gCo = MMGIFJNI.openByByteArray(bArr, this.gCp);
        init();
    }

    private void init() {
        v.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", Long.valueOf(this.gCo));
        this.gCu = this.gCp[2];
        if (this.gCp[0] > 1024 || this.gCp[1] > 1024) {
            v.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", Integer.valueOf(this.gCp[0]), Integer.valueOf(this.gCp[1]));
            this.gCt = new int[(this.gCC * this.gCC)];
            this.gCD = true;
            g.iuh.a(401, 2, 1, false);
        } else {
            this.gCt = new int[(this.gCp[0] * this.gCp[1])];
        }
        this.mDensity = com.tencent.mm.bd.a.getDensity(aa.getContext()) / 1.5f;
        if (this.mDensity < 1.0f) {
            this.mDensity = 1.0f;
        }
    }

    public final int getIntrinsicWidth() {
        return (int) (((float) this.gCp[0]) * this.mDensity);
    }

    public final int getIntrinsicHeight() {
        return (int) (((float) this.gCp[1]) * this.mDensity);
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.gCs = true;
    }

    public final void draw(Canvas canvas) {
        if (this.gCs) {
            this.tG.set(getBounds());
            this.gCq = ((float) this.tG.width()) / ((float) this.gCp[0]);
            this.gCr = ((float) this.tG.height()) / ((float) this.gCp[1]);
            this.gCs = false;
        }
        if (this.ft.getShader() == null) {
            if (this.gCz == 0) {
                this.gCz = System.currentTimeMillis();
            }
            canvas.scale(this.gCq, this.gCr);
            int[] iArr = this.gCt;
            if (iArr == null) {
                v.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
            } else if (iArr.length == this.gCp[0] * this.gCp[1]) {
                canvas.drawBitmap(iArr, 0, this.gCp[0], 0.0f, 0.0f, this.gCp[0], this.gCp[1], true, this.ft);
            } else {
                canvas.drawRGB(230, 230, 230);
                v.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", Integer.valueOf(iArr.length), Integer.valueOf(this.gCp[0]), Integer.valueOf(this.gCp[1]));
            }
            this.gCA = System.currentTimeMillis() - this.gCz;
            if (this.gCD || this.gCp[2] <= 0) {
                v.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", Integer.valueOf(this.gCp[2]), Integer.valueOf(this.gCp[4]), Boolean.valueOf(this.gCD));
                return;
            }
            if (this.gCp[4] < 0) {
                v.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
            }
            if (this.gCE == 0 || this.gCF <= this.gCE - 1) {
                com.tencent.mm.ac.a.a(this.gCM, 0);
                return;
            } else {
                e(this.gCH, 0);
                return;
            }
        }
        v.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
        canvas.drawRect(this.tG, this.ft);
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int i) {
        this.ft.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.ft.setColorFilter(colorFilter);
    }

    public final boolean isRunning() {
        return this.gCm;
    }

    public final void start() {
        this.gCm = true;
        com.tencent.mm.ac.a.a(this.gCJ, 0);
    }

    public final void stop() {
        v.d("MicroMsg.GIF.MMGIFDrawable", "stop");
        this.gCm = false;
        com.tencent.mm.ac.a.a(this.gCL, 300);
    }

    public final void recycle() {
        v.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
        this.gCn = true;
        this.gCm = false;
        long j = this.gCo;
        this.gCo = 0;
        MMGIFJNI.recycle(j);
        this.gCt = null;
    }

    protected final void finalize() {
        try {
            stop();
            recycle();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
