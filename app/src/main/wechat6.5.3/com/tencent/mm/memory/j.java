package com.tencent.mm.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class j extends l {
    private Bitmap a(InputStream inputStream, Options options, DecodeResultLogger decodeResultLogger) {
        ByteBuffer byteBuffer;
        Exception exception;
        Object obj;
        Throwable th;
        Bitmap bitmap = null;
        try {
            ByteBuffer byteBuffer2 = (ByteBuffer) h.cnw.bJ();
            try {
                bitmap = a(inputStream, null, a(inputStream, options, byteBuffer2, false, null), decodeResultLogger);
                if (byteBuffer2 == null) {
                    return bitmap;
                }
                h.cnw.i(byteBuffer2);
                return bitmap;
            } catch (Exception e) {
                Exception exception2 = e;
                byteBuffer = byteBuffer2;
                exception = exception2;
                try {
                    v.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", exception.getMessage());
                    if (obj != null) {
                        return bitmap;
                    }
                    h.cnw.i(obj);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    if (obj != null) {
                        h.cnw.i(obj);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                byteBuffer = byteBuffer2;
                th = th3;
                if (obj != null) {
                    h.cnw.i(obj);
                }
                throw th;
            }
        } catch (Exception e2) {
            exception = e2;
            obj = bitmap;
            v.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", exception.getMessage());
            if (obj != null) {
                return bitmap;
            }
            h.cnw.i(obj);
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            obj = bitmap;
            if (obj != null) {
                h.cnw.i(obj);
            }
            throw th;
        }
    }

    public final Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger) {
        InputStream openRead;
        Throwable e;
        Throwable th;
        Bitmap bitmap = null;
        try {
            openRead = FileOp.openRead(str);
            try {
                bitmap = a(openRead, options, decodeResultLogger);
                e.c(openRead);
            } catch (Exception e2) {
                e = e2;
                try {
                    v.a("MicroMsg.InBitmapFactory", e, "error decode bitmap %s", e.getMessage());
                    e.c(openRead);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    e.c(openRead);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRead = bitmap;
            v.a("MicroMsg.InBitmapFactory", e, "error decode bitmap %s", e.getMessage());
            e.c(openRead);
            return bitmap;
        } catch (Throwable e4) {
            openRead = bitmap;
            th = e4;
            e.c(openRead);
            throw th;
        }
        return bitmap;
    }

    public final Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        InputStream inputStream;
        ByteBuffer byteBuffer;
        Exception exception;
        Object obj;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            InputStream openRead = FileOp.openRead(str);
            try {
                ByteBuffer byteBuffer2 = (ByteBuffer) h.cnw.bJ();
                try {
                    Bitmap a = a(openRead, rect, a(openRead, options, byteBuffer2, true, rect), decodeResultLogger);
                    if (byteBuffer2 != null) {
                        h.cnw.i(byteBuffer2);
                    }
                    e.c(openRead);
                    return a;
                } catch (Exception e) {
                    Exception exception2 = e;
                    inputStream = openRead;
                    byteBuffer = byteBuffer2;
                    exception = exception2;
                    try {
                        v.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", exception.getMessage());
                        if (obj != null) {
                            h.cnw.i(obj);
                        }
                        e.c(inputStream);
                        return inputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (obj != null) {
                            h.cnw.i(obj);
                        }
                        e.c(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    inputStream = openRead;
                    byteBuffer = byteBuffer2;
                    th = th3;
                    if (obj != null) {
                        h.cnw.i(obj);
                    }
                    e.c(inputStream);
                    throw th;
                }
            } catch (Exception e2) {
                exception = e2;
                inputStream = openRead;
                openRead = inputStream2;
                v.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", exception.getMessage());
                if (obj != null) {
                    h.cnw.i(obj);
                }
                e.c(inputStream);
                return inputStream2;
            } catch (Throwable th4) {
                th = th4;
                inputStream = openRead;
                openRead = inputStream2;
                if (obj != null) {
                    h.cnw.i(obj);
                }
                e.c(inputStream);
                throw th;
            }
        } catch (Exception e3) {
            exception = e3;
            inputStream = inputStream2;
            obj = inputStream2;
            v.e("MicroMsg.InBitmapFactory", "error decode bitmap %s", exception.getMessage());
            if (obj != null) {
                h.cnw.i(obj);
            }
            e.c(inputStream);
            return inputStream2;
        } catch (Throwable th5) {
            th = th5;
            inputStream = inputStream2;
            obj = inputStream2;
            if (obj != null) {
                h.cnw.i(obj);
            }
            e.c(inputStream);
            throw th;
        }
    }

    @TargetApi(19)
    private static Options a(InputStream inputStream, Options options, ByteBuffer byteBuffer, boolean z, Rect rect) {
        if (options == null) {
            options = new Options();
        }
        if (byteBuffer != null) {
            options.inTempStorage = byteBuffer.array();
        }
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeStream(inputStream, null, options, 0);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException("cannot get the bitmap size!");
        }
        int i;
        Bitmap bitmap;
        boolean z2;
        options.inJustDecodeBounds = false;
        options.inDither = true;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (rect == null) {
            v.i("MicroMsg.InBitmapFactory", "options.outWidth: %s, options.outHeight: %s, sampleSize: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(options.inSampleSize));
            i = i2;
            i2 = i3;
        } else {
            v.i("MicroMsg.InBitmapFactory", "region decode, width: %s, height: %s, rect: %s", Integer.valueOf(rect.right - rect.left), Integer.valueOf(rect.bottom - rect.top), rect);
            i = i2;
            i2 = i3;
        }
        c cVar;
        c cVar2;
        if (z) {
            cVar = c.cno;
            cVar2 = c.cno;
            bitmap = (Bitmap) cVar.c(c.d(Integer.valueOf(i * i2)));
            if (bitmap != null && d.dW(19)) {
                bitmap.reconfigure(i, i2, Config.ARGB_8888);
            }
        } else {
            cVar = c.cno;
            cVar2 = c.cno;
            bitmap = cVar.e(c.d(Integer.valueOf(i2 * i)));
        }
        String str = "MicroMsg.InBitmapFactory";
        String str2 = "bitmapToReuse: %s, isRecycle: %s, isRegionDecode: %s, width: %s, height: %s";
        Object[] objArr = new Object[5];
        objArr[0] = bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(bitmap != null ? bitmap.getWidth() : 0);
        objArr[4] = Integer.valueOf(bitmap != null ? bitmap.getHeight() : 0);
        v.i(str, str2, objArr);
        if (!(bitmap == null || !bitmap.isMutable() || bitmap.isRecycled())) {
            options.inBitmap = bitmap;
        }
        options.inMutable = true;
        com.tencent.mm.sdk.platformtools.d.a(options);
        v.i("MicroMsg.InBitmapFactory", "mimetype: %s", options.outMimeType);
        return options;
    }

    private static Bitmap a(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        Bitmap decodeStream;
        Exception e;
        Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            l.f(inputStream);
            inputStream.mark(25165824);
            if (rect == null) {
                try {
                    bitmap2 = MMBitmapFactory.decodeStream(inputStream, null, options, decodeResultLogger, 0, new int[0]);
                } catch (Throwable e2) {
                    int width;
                    String str = "MicroMsg.InBitmapFactory";
                    String str2 = "decode with inBitmap error: %s, outWidth: %s, outHeight: %s, sampleSize: %s, reuseBitmapWidth: %s, reuseBitmapHeight: %s";
                    Object[] objArr = new Object[6];
                    objArr[0] = e2.getMessage();
                    objArr[1] = Integer.valueOf(options.outWidth);
                    objArr[2] = Integer.valueOf(options.outHeight);
                    objArr[3] = Integer.valueOf(options.inSampleSize);
                    if (options.inBitmap != null) {
                        width = options.inBitmap.getWidth();
                    } else {
                        width = 0;
                    }
                    objArr[4] = Integer.valueOf(width);
                    if (options.inBitmap != null) {
                        width = options.inBitmap.getHeight();
                    } else {
                        width = 0;
                    }
                    objArr[5] = Integer.valueOf(width);
                    v.a(str, e2, str2, objArr);
                }
            } else {
                bitmap2 = MMBitmapFactory.decodeRegion(inputStream, rect, options, decodeResultLogger);
            }
            if (bitmap2 == null) {
                try {
                    v.i("MicroMsg.InBitmapFactory", "decode again");
                    l.f(inputStream);
                    options.inBitmap = null;
                    if (rect == null) {
                        decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options, decodeResultLogger, 0, new int[0]);
                    } else {
                        decodeStream = MMBitmapFactory.decodeRegion(inputStream, rect, options, decodeResultLogger);
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap = bitmap2;
                    v.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", e.getMessage());
                    decodeStream = bitmap;
                    if (decodeStream != null) {
                        v.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
                    }
                    return decodeStream;
                }
            }
            decodeStream = bitmap2;
            if (!(rect == null || decodeStream == null)) {
                try {
                    if (decodeStream.getWidth() > rect.right - rect.left && decodeStream.getHeight() > rect.bottom - rect.top) {
                        v.i("MicroMsg.InBitmapFactory", "fuck region decode size not match, clip it, reqWidth: %s, reqHeight: %s, resultWidth: %s, resultHeight: %s", Integer.valueOf(rect.right - rect.left), Integer.valueOf(rect.bottom - rect.top), Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
                        decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, rect.right - rect.left, rect.bottom - rect.top);
                    }
                } catch (Exception e4) {
                    Exception exception = e4;
                    bitmap = decodeStream;
                    e = exception;
                    v.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", e.getMessage());
                    decodeStream = bitmap;
                    if (decodeStream != null) {
                        v.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
                    }
                    return decodeStream;
                }
            }
        } catch (Exception e5) {
            e = e5;
            bitmap = bitmap2;
            v.e("MicroMsg.InBitmapFactory", "decodeInternal error: %s", e.getMessage());
            decodeStream = bitmap;
            if (decodeStream != null) {
                v.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
            }
            return decodeStream;
        }
        if (decodeStream != null) {
            v.i("MicroMsg.InBitmapFactory", "finish decode, decodedBitmap: %s, width: %s, height: %s", decodeStream, Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()));
        }
        return decodeStream;
    }

    public final void e(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            c.cno.d(bitmap);
        }
    }
}
