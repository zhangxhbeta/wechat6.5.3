package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class r extends SurfaceTexture {
    public SurfaceTexture nYd = null;

    public r() {
        super(0);
    }

    public final void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.nYd.setOnFrameAvailableListener(onFrameAvailableListener);
    }

    public final void setDefaultBufferSize(int i, int i2) {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.nYd.setDefaultBufferSize(i, i2);
    }

    public final void updateTexImage() {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.nYd.updateTexImage();
    }

    public final void detachFromGLContext() {
        boolean z;
        String str;
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.nYd.detachFromGLContext();
            z = false;
        } catch (Throwable e) {
            v.a("MicroMsg.MMSurfaceTextureWrap", e, "%s", "detect texture problem, RuntimeException detachFromGLContext");
            z = true;
        }
        if (z) {
            String str2;
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = Ax() + " detect texture problem error code = " + ((Integer) declaredMethod.invoke(this.nYd, new Object[0])).intValue() + ", detach = true, and error = " + z;
                b.r(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str2);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(r0), Boolean.valueOf(true), Boolean.valueOf(z));
            } catch (Throwable e2) {
                v.a("MicroMsg.MMSurfaceTextureWrap", e2, "%s", "detect texture problem, IllegalArgumentException");
                str = Ax() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e22) {
                v.a("MicroMsg.MMSurfaceTextureWrap", e22, "%s", "detect texture problem, IllegalAccessException");
                str = Ax() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e222) {
                v.a("MicroMsg.MMSurfaceTextureWrap", e222, "%s", "detect texture problem, InvocationTargetException");
                str = Ax() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e2222) {
                v.a("MicroMsg.MMSurfaceTextureWrap", e2222, "%s", "detect texture problem, NoSuchMethodException");
                str = Ax() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e22222) {
                v.a("MicroMsg.MMSurfaceTextureWrap", e22222, "%s", "detect texture problem, Exception");
                str = Ax() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable th) {
                str2 = Ax() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                v.w("MicroMsg.MMSurfaceTextureWrap", str2);
                v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            }
        }
    }

    private static String Ax() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IRUSR);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = aa.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + e.cmU);
        stringBuilderPrinter.println("#accinfo.build=" + e.cmX + ":" + e.cmY + ":" + f.aPW);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.nhm);
        String str = SQLiteDatabase.KeyEmpty;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.cni);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.cni, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            v.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", e.getMessage());
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public final void attachToGLContext(int i) {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.nYd.attachToGLContext(i);
    }

    public final void getTransformMatrix(float[] fArr) {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.nYd.getTransformMatrix(fArr);
    }

    public final long getTimestamp() {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        return this.nYd.getTimestamp();
    }

    public final void release() {
        super.release();
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.nYd.release();
    }

    public final boolean equals(Object obj) {
        return this.nYd.equals(obj);
    }

    public final int hashCode() {
        return this.nYd.hashCode();
    }

    public final String toString() {
        return this.nYd.toString();
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.nYd.releaseTexImage();
    }
}
