package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDebug;

public final class c extends Drawable implements Animatable {
    private Resources BE;
    private int QW;
    private int Zx;
    private ac fnw = new ac(Looper.getMainLooper());
    public int fqz = 0;
    private final Paint ft = new Paint(6);
    private long gCB = 0;
    private final Runnable gCH = new Runnable(this) {
        final /* synthetic */ c gDb;

        {
            this.gDb = r1;
        }

        public final void run() {
            if (this.gDb.gDa != null) {
                this.gDb.gDa.onAnimationEnd();
            }
        }
    };
    private final Runnable gCI = new Runnable(this) {
        final /* synthetic */ c gDb;

        {
            this.gDb = r1;
        }

        public final void run() {
            if (SystemClock.uptimeMillis() >= this.gDb.gCB) {
                this.gDb.invalidateSelf();
            }
        }
    };
    private int gCS;
    private int gCT;
    private int[] gCU;
    private Bitmap gCV = null;
    private boolean gCW = false;
    public boolean gCX = true;
    private String gCY;
    public int gCZ = 0;
    private volatile boolean gCm = false;
    private float gCq = 1.0f;
    private float gCr = 1.0f;
    private boolean gCs;
    private e gDa;
    private Context mContext;
    private final Rect tG = new Rect();

    public c(Context context, boolean z, boolean z2, int i, int[] iArr, String str) {
        this.mContext = context;
        this.BE = this.mContext.getResources();
        this.gCW = false;
        this.gCX = z2;
        this.gCY = str;
        this.gCT = i;
        this.gCU = iArr;
        if (z2) {
            this.gCV = lM(this.gCU[0]);
        } else {
            this.gCV = lM(uy(str));
        }
        this.Zx = this.gCV.getWidth();
        this.QW = this.gCV.getHeight();
        if (this.gCU.length == 3) {
            this.gCS = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
        } else {
            this.gCS = 100;
        }
        this.gCZ = 0;
    }

    public final void draw(Canvas canvas) {
        if (this.gCs) {
            this.tG.set(getBounds());
            this.gCq = ((float) this.tG.width()) / ((float) this.Zx);
            this.gCr = ((float) this.tG.height()) / ((float) this.QW);
            this.gCs = false;
        }
        if (this.ft.getShader() == null) {
            canvas.scale(this.gCq, this.gCr);
            if (this.gCW) {
                this.gCV = lM(this.gCT);
                if (this.gCV != null && !this.gCV.isRecycled()) {
                    canvas.drawBitmap(this.gCV, 0.0f, 0.0f, this.ft);
                    return;
                }
                return;
            } else if (this.gCX) {
                v.i("MicroMsg.GIF.MMGIFGameDrawable", "mCurrentIndex:%d mNextInvaliteTime:%d mLoop:%d", Integer.valueOf(this.fqz), Integer.valueOf(this.gCS), Integer.valueOf(this.gCZ));
                this.gCV = lM(this.gCU[this.fqz]);
                if (!(this.gCV == null || this.gCV.isRecycled())) {
                    canvas.drawBitmap(this.gCV, 0.0f, 0.0f, this.ft);
                }
                this.fqz++;
                if (this.gCZ < 3) {
                    if (this.fqz >= this.gCU.length) {
                        this.fqz = 0;
                        this.gCZ++;
                    }
                    e(this.gCI, (long) this.gCS);
                    return;
                }
                this.gCX = false;
                e(this.gCI, (long) this.gCS);
                e(this.gCH, 0);
                return;
            } else {
                this.gCV = lM(uy(this.gCY));
                if (this.gCV != null && !this.gCV.isRecycled()) {
                    canvas.drawBitmap(this.gCV, 0.0f, 0.0f, this.ft);
                    return;
                }
                return;
            }
        }
        v.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
        canvas.drawRect(this.tG, this.ft);
    }

    private void e(Runnable runnable, long j) {
        this.gCB = SystemClock.uptimeMillis() + j;
        if (this.fnw != null) {
            this.fnw.postDelayed(runnable, j);
        }
    }

    public final int getIntrinsicHeight() {
        return this.QW;
    }

    public final int getIntrinsicWidth() {
        return this.Zx;
    }

    public final void setAlpha(int i) {
        this.ft.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.ft.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -2;
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.gCs = true;
    }

    public final void start() {
        this.gCm = true;
        this.fnw.post(this.gCI);
    }

    public final void stop() {
        this.gCm = false;
    }

    public final boolean isRunning() {
        return this.gCm;
    }

    private Bitmap lM(int i) {
        return BitmapFactory.decodeResource(this.BE, i);
    }

    private int uy(String str) {
        return this.BE.getIdentifier(str.split("\\.")[0], "drawable", this.mContext.getPackageName());
    }

    protected final void finalize() {
        this.gDa = null;
        super.finalize();
    }
}
