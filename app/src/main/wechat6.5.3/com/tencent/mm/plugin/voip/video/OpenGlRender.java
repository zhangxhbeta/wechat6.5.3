package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements Renderer {
    static String TAG = "OpenGlRender";
    public static int kBA = 1;
    public static int kBL = 0;
    static boolean kBN = false;
    public static int kBn = 0;
    public static int kBo = 1;
    public static int kBp = 2;
    public static int kBq = 0;
    public static int kBr = 1;
    public static int kBs = 0;
    public static int kBt = 1;
    public static int kBu = 2;
    public static int kBv = 3;
    public static int kBw = 4;
    public static int kBx = 12;
    public static int kBy = 16;
    public static int kBz = 0;
    boolean kAW = false;
    int kAX = 0;
    long kAY = 0;
    long kAZ = 0;
    int kBB = kBz;
    public boolean kBC = false;
    public Bitmap kBD = null;
    private int kBE = 0;
    private int kBF = 0;
    private byte[] kBG = null;
    private int[] kBH = null;
    private int kBI;
    private int kBJ;
    private int kBK;
    WeakReference<Object> kBM;
    int kBa = 0;
    a kBb;
    public float kBc = 1.2f;
    public float kBd = 1.93f;
    public float kBe = 1.05f;
    boolean kBf = false;
    public boolean kBg = false;
    boolean kBh = false;
    boolean kBi = false;
    boolean kBj = false;
    int kBk = 0;
    int kBl = 0;
    WeakReference<OpenGlView> kBm;

    private class a extends ac {
        final /* synthetic */ OpenGlRender kBO;

        public a(OpenGlRender openGlRender, Looper looper) {
            this.kBO = openGlRender;
            super(looper);
        }

        public final void handleMessage(Message message) {
            this.kBO.requestRender();
        }
    }

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    final native void Init(int i, Object obj, int i2);

    final native void Uninit(int i);

    final native void setMode(int i, int i2, int i3, int i4);

    final native void setParam(float f, float f2, float f3, int i);

    public static int bdM() {
        if (kBL == 0) {
            kBL = ((ActivityManager) aa.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == 131072 ? 2 : 1;
            if (Build.MODEL.equals("Nexus 6")) {
                kBL = 2;
            }
        }
        return kBL;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        if (!kBN) {
            k.b("mm_gl_disp", OpenGlRender.class.getClassLoader());
            kBN = true;
        }
        this.kBB = i;
        this.kBm = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.kBb = new a(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.kBb = new a(this, myLooper);
            } else {
                this.kBb = null;
            }
        }
        this.kBM = null;
    }

    public final void onDrawFrame(GL10 gl10) {
        if (this.kBg && this.kBf && this.kBm.get() != null) {
            if (this.kBG != null) {
                render8(this.kBG, this.kBI, this.kBJ, this.kBK, this.kBB);
                this.kBG = null;
            }
            if (this.kBH != null) {
                render32(this.kBH, this.kBI, this.kBJ, this.kBK, this.kBB);
                this.kBH = null;
                return;
            }
            return;
        }
        this.kBG = null;
        this.kBH = null;
    }

    public final void b(byte[] bArr, int i, int i2, int i3) {
        if (this.kBf && this.kBG == null) {
            this.kBI = i;
            this.kBJ = i2;
            this.kBK = i3;
            this.kBG = bArr;
            requestRender();
        }
    }

    public final void a(int[] iArr, int i, int i2, int i3) {
        if (this.kBf && this.kBH == null) {
            this.kBI = i;
            this.kBJ = i2;
            this.kBK = i3;
            this.kBH = iArr;
            requestRender();
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        v.i(TAG, "onSurfaceChanged, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.kBk != i || this.kBl != i2) {
            gl10.glViewport(0, 0, i, i2);
            this.kBk = i;
            this.kBl = i2;
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void bdN() {
        this.kBg = false;
        this.kBj = false;
    }

    public final void bdO() {
        v.i(TAG, "steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[]{Integer.valueOf(this.kBB), Boolean.valueOf(this.kBf), Boolean.valueOf(this.kBg)});
        if (this.kBf && this.kBg) {
            v.i(TAG, "steve: Reset GLRender first! mode=%d", new Object[]{Integer.valueOf(this.kBB)});
            this.kBf = false;
            this.kBg = false;
            Uninit(this.kBB);
        }
    }

    public final void requestRender() {
        if (this.kBf) {
            if (!this.kBj) {
                setMode(((OpenGlView) this.kBm.get()).getWidth(), ((OpenGlView) this.kBm.get()).getHeight(), 0, this.kBB);
                this.kBj = true;
            }
            if (this.kBm.get() != null) {
                OpenGlView openGlView = (OpenGlView) this.kBm.get();
                openGlView.kBP = true;
                openGlView.requestRender();
            }
        }
    }
}
