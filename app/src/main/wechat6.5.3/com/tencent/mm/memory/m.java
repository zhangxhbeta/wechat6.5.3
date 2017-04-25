package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class m extends l {
    private static int cnB = -1;

    public final Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger) {
        InputStream openRead;
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        try {
            openRead = FileOp.openRead(str);
            try {
                bitmap = a(openRead, null, options, decodeResultLogger);
                e.c(openRead);
            } catch (Exception e2) {
                e = e2;
                try {
                    v.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
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
            v.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
            e.c(openRead);
            return bitmap;
        } catch (Throwable th3) {
            openRead = bitmap;
            th = th3;
            e.c(openRead);
            throw th;
        }
        return bitmap;
    }

    public final Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        InputStream openRead;
        Exception e;
        Throwable th;
        Bitmap bitmap = null;
        try {
            openRead = FileOp.openRead(str);
            try {
                bitmap = a(openRead, rect, options, decodeResultLogger);
                e.c(openRead);
            } catch (Exception e2) {
                e = e2;
                try {
                    v.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
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
            v.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e.getMessage());
            e.c(openRead);
            return bitmap;
        } catch (Throwable th3) {
            openRead = bitmap;
            th = th3;
            e.c(openRead);
            throw th;
        }
        return bitmap;
    }

    private static Bitmap a(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        Object obj;
        Exception exception;
        Throwable th;
        Bitmap bitmap = null;
        try {
            ByteBuffer byteBuffer = (ByteBuffer) h.cnw.bJ();
            if (options == null) {
                try {
                    options = new Options();
                } catch (Exception e) {
                    Exception exception2 = e;
                    obj = byteBuffer;
                    exception = exception2;
                    try {
                        v.e("MicroMsg.PurgeableBitmapFactory", "error decode bitmap %s", exception.getMessage());
                        if (obj != null) {
                            h.cnw.i(obj);
                        }
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        if (obj != null) {
                            h.cnw.i(obj);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    ByteBuffer byteBuffer2 = byteBuffer;
                    th = th3;
                    if (obj != null) {
                        h.cnw.i(obj);
                    }
                    throw th;
                }
            }
            if (byteBuffer != null) {
                options.inTempStorage = byteBuffer.array();
            }
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options, 0);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new IllegalArgumentException("cannot get the bitmap size!");
            }
            v.i("MicroMsg.PurgeableBitmapFactory", "mimetype: %s", options.outMimeType);
            options.inDither = true;
            options.inMutable = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inJustDecodeBounds = false;
            d.a(options);
            l.f(inputStream);
            bitmap = b(inputStream, rect, options, decodeResultLogger);
            if (byteBuffer != null) {
                h.cnw.i(byteBuffer);
            }
            return bitmap;
        } catch (Exception e2) {
            exception = e2;
            Bitmap bitmap2 = bitmap;
            v.e("MicroMsg.PurgeableBitmapFactory", "error decode bitmap %s", exception.getMessage());
            if (obj != null) {
                h.cnw.i(obj);
            }
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

    private static Bitmap b(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        byte[] bArr;
        Exception exception;
        Throwable th;
        int i = -1;
        if (inputStream != null) {
            try {
                Bitmap decodeByteArray;
                i = inputStream.available();
                byte[] bArr2 = (byte[]) g.cnv.b(Integer.valueOf(i));
                if (bArr2 == null) {
                    try {
                        bArr2 = new byte[i];
                    } catch (Exception e) {
                        Exception exception2 = e;
                        bArr = bArr2;
                        exception = exception2;
                        try {
                            v.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", exception.getMessage());
                            e.c(inputStream);
                            if (i > 0 && bArr != null) {
                                g.cnv.x(bArr);
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            e.c(inputStream);
                            g.cnv.x(bArr);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        bArr = bArr2;
                        th = th4;
                        e.c(inputStream);
                        if (i > 0 && bArr != null) {
                            g.cnv.x(bArr);
                        }
                        throw th;
                    }
                }
                inputStream.read(bArr2);
                if (rect == null) {
                    decodeByteArray = MMBitmapFactory.decodeByteArray(bArr2, 0, i, options, decodeResultLogger, 0, new int[0]);
                } else {
                    decodeByteArray = MMBitmapFactory.decodeRegion(bArr2, 0, i, rect, options, decodeResultLogger);
                }
                decodeByteArray = MMBitmapFactory.pinBitmap(decodeByteArray);
                e.c(inputStream);
                if (i > 0 && bArr2 != null) {
                    g.cnv.x(bArr2);
                }
                return decodeByteArray;
            } catch (Exception e2) {
                exception = e2;
                bArr = null;
                v.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", exception.getMessage());
                e.c(inputStream);
                g.cnv.x(bArr);
                return null;
            } catch (Throwable th5) {
                th = th5;
                bArr = null;
                e.c(inputStream);
                g.cnv.x(bArr);
                throw th;
            }
        }
        e.c(inputStream);
        return null;
    }

    public final void e(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    v.i("MicroMsg.PurgeableBitmapFactory", "bitmap recycle %s", bitmap.toString());
                    bitmap.recycle();
                }
            } catch (Exception e) {
                v.e("MicroMsg.PurgeableBitmapFactory", "recycle error: %s", e.getMessage());
            }
        }
    }
}
