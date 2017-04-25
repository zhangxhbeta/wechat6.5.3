package com.tencent.mm.svg.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.svg.WeChatSVG;
import com.tencent.mm.svg.c;
import com.tencent.mm.svg.c.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.EncodingUtils;

public final class a {
    private static String nyk = ".svg.code.drawable";
    protected static int nyl = 3;
    private static String nym = SQLiteDatabase.KeyEmpty;
    private static Map<Integer, c> nyn = new ConcurrentHashMap();
    private static Map<Integer, Picture> nyo = new ConcurrentHashMap();
    private static Map<String, Picture> nyp = new ConcurrentHashMap();
    private static Float nyq;
    private TypedValue nyi = new TypedValue();
    private byte[] nyj = new byte[0];

    public static void GT(String str) {
        nym = str;
    }

    public static Drawable c(Resources resources, int i) {
        return a(resources, i, 0.0f);
    }

    private static Drawable a(Resources resources, int i, float f) {
        String str;
        if (i == 0) {
            String str2;
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "getSVGDrawable a invalid resource!!! %s", Integer.valueOf(i));
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Why no log??", new Object[0]);
            String str3 = "MicroMsg.SVGCompat";
            str = "The stack : %s";
            Object[] objArr = new Object[1];
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 4) {
                str2 = SQLiteDatabase.KeyEmpty;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 3;
                while (i2 < stackTrace.length) {
                    if (stackTrace[i2].getClassName().contains("com.tencent.mm") && !stackTrace[i2].getClassName().contains("sdk.platformtools.Log")) {
                        stringBuilder.append("[");
                        stringBuilder.append(stackTrace[i2].getClassName().substring(15));
                        stringBuilder.append(":");
                        stringBuilder.append(stackTrace[i2].getMethodName());
                        stringBuilder.append("(" + stackTrace[i2].getLineNumber() + ")]");
                    }
                    i2++;
                }
                str2 = stringBuilder.toString();
            }
            objArr[0] = str2;
            com.tencent.mm.svg.c.c.e(str3, str, objArr);
            return new c(new Picture(), i);
        } else if (b.byi()) {
            return c(resources, i, f);
        } else {
            str = nym + nyk;
            float f2 = resources.getDisplayMetrics().density;
            float f3 = f > 0.0f ? f : 1.0f;
            Picture picture;
            if (f > 0.0f) {
                String str4 = i + "_scale_" + f;
                picture = (Picture) nyp.get(str4);
                if (picture == null) {
                    picture = a(f2, a(resources, i, str), f3);
                    nyp.put(str4, picture);
                }
                return new c(picture, i);
            }
            picture = (Picture) nyo.get(Integer.valueOf(i));
            if (picture == null) {
                picture = a(f2, a(resources, i, str), f3);
                nyo.put(Integer.valueOf(i), picture);
            }
            return new c(picture, i);
        }
    }

    public static Bitmap b(Resources resources, int i, float f) {
        Drawable a = a(resources, i, f);
        Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Config.ARGB_8888);
        a.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final boolean d(Resources resources, int i) {
        try {
            if (resources.getResourceTypeName(i).equals("raw")) {
                String charSequence;
                synchronized (this.nyj) {
                    TypedValue typedValue = this.nyi;
                    if (typedValue == null) {
                        typedValue = new TypedValue();
                        this.nyi = typedValue;
                    }
                    resources.getValue(i, typedValue, true);
                    charSequence = typedValue.string.toString();
                }
                if (charSequence.endsWith(".svg")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            com.tencent.mm.svg.c.c.a("MicroMsg.SVGCompat", e, "resource not found", new Object[0]);
            return false;
        }
    }

    public static Map<Integer, c> byb() {
        return nyn;
    }

    protected static boolean b(View view, Paint paint) {
        if (VERSION.SDK_INT <= 10) {
            return false;
        }
        if (view == null) {
            return false;
        }
        if (view.getLayerType() != 1) {
            view.setLayerType(1, paint);
        }
        if (!view.willNotCacheDrawing()) {
            return true;
        }
        view.setWillNotCacheDrawing(false);
        if (view.getWindowToken() == null) {
            return true;
        }
        view.buildLayer();
        return true;
    }

    protected static View t(Drawable drawable) {
        while (true) {
            Callback callback = drawable.getCallback();
            if (callback != null) {
                if (!(callback instanceof View)) {
                    if (!(callback instanceof Drawable)) {
                        break;
                    }
                    drawable = (Drawable) callback;
                } else {
                    return (View) callback;
                }
            }
            break;
        }
        return null;
    }

    private static Drawable c(Resources resources, int i, float f) {
        InputStream openRawResource = resources.openRawResource(i);
        try {
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e) {
                    v.a("MicroMsg.SVGCompat", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            long parse = WeChatSVG.parse(EncodingUtils.getString(bArr, "UTF-8").toString());
            if (parse == 0) {
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Parse SVG failed.", new Object[0]);
                return null;
            }
            float[] viewPort = WeChatSVG.getViewPort(parse);
            float f2 = resources.getDisplayMetrics().density;
            float f3 = (f > 0.0f ? f : 1.0f) * ((viewPort[0] / ((float) nyl)) * f2);
            float f4 = (viewPort[1] / ((float) nyl)) * f2;
            if (f <= 0.0f) {
                f = 1.0f;
            }
            float f5 = f4 * f;
            Picture picture = new Picture();
            int renderViewPort = WeChatSVG.renderViewPort(parse, picture.beginRecording((int) f3, (int) f5), (float) ((int) f3), (float) ((int) f5));
            picture.endRecording();
            WeChatSVG.release(parse);
            Drawable cVar = new c(picture, i);
            if (renderViewPort >= 0) {
                return cVar;
            }
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Render SVG failed. Reason : %s", Integer.valueOf(renderViewPort));
            return null;
        } catch (Throwable e2) {
            v.a("MicroMsg.SVGCompat", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Get SVGPictureDrawable failed. Reason : IOException", new Object[0]);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e22) {
                    v.a("MicroMsg.SVGCompat", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            return null;
        } catch (Throwable th) {
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e3) {
                    v.a("MicroMsg.SVGCompat", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        }
    }

    private static c a(Resources resources, int i, String str) {
        Object obj = SQLiteDatabase.KeyEmpty;
        try {
            if (nyn.containsKey(Integer.valueOf(i))) {
                return (c) nyn.get(Integer.valueOf(i));
            }
            String resourceName = resources.getResourceName(i);
            if (resourceName == null) {
                com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : resource not found", new Object[0]);
                return null;
            }
            String str2;
            int indexOf = resourceName.indexOf("/");
            if (indexOf > 0) {
                str2 = str + "." + resourceName.substring(indexOf + 1);
            } else {
                str2 = str + "." + resourceName;
            }
            c cVar = (c) Class.forName(str2).newInstance();
            nyn.put(Integer.valueOf(i), cVar);
            return cVar;
        } catch (Throwable e) {
            v.a("MicroMsg.SVGCompat", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : ClassNotFoundException %s", obj);
            return null;
        } catch (Throwable e2) {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : InstantiationException %s", obj);
            v.a("MicroMsg.SVGCompat", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        } catch (Throwable e22) {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : IllegalAccessException %s", obj);
            v.a("MicroMsg.SVGCompat", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    private static Picture a(float f, c cVar, float f2) {
        Picture picture = new Picture();
        if (cVar == null) {
            com.tencent.mm.svg.c.c.e("MicroMsg.SVGCompat", "fromCodeToPicture code is null!", new Object[0]);
        } else {
            if (nyq == null) {
                nyq = Float.valueOf(f / ((float) nyl));
            }
            float floatValue = nyq.floatValue() * f2;
            Canvas beginRecording = picture.beginRecording((int) (((float) cVar.j(0, new Object[0])) * floatValue), (int) (((float) cVar.j(1, new Object[0])) * floatValue));
            beginRecording.save();
            beginRecording.scale(floatValue, floatValue);
            Looper myLooper = Looper.myLooper();
            cVar.j(2, beginRecording, myLooper);
            beginRecording.restore();
            picture.endRecording();
        }
        return picture;
    }
}
