package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.concurrent.Callable;

public final class d implements Callable<Bitmap> {
    private a a;
    private Bitmap b = null;
    private a c;

    public interface a {
        void a(d dVar);

        void b(d dVar);
    }

    public d(a aVar, a aVar2) {
        this.a = aVar;
        this.c = aVar2;
    }

    private Bitmap d() {
        if (this.a != null) {
            this.a.b(this);
        }
        try {
            this.b = f();
            Bitmap bitmap = this.b;
            return bitmap;
        } finally {
            e();
        }
    }

    private void e() {
        if (this.a != null) {
            this.a.a(this);
        }
        this.a = null;
        if (!(this.b == null || this.b.isRecycled())) {
            this.b.recycle();
        }
        this.b = null;
    }

    private Bitmap f() {
        Bitmap decodeByteArray;
        Exception e;
        Exception exception;
        Exception exception2;
        int i = 0;
        Bitmap bitmap = null;
        while (i < 4) {
            try {
                byte[] g = this.c.g();
                if (g != null) {
                    try {
                        decodeByteArray = BitmapFactory.decodeByteArray(g, 0, g.length);
                        if (decodeByteArray != null) {
                            try {
                                if (g.length < 2097152) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    try {
                                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(g, this.c, stringBuilder);
                                        bitmap = decodeByteArray;
                                    } catch (Throwable th) {
                                        if (g.pAe != null) {
                                            g.pAe.collectErrorInfo("TileNetFetcher downLoad function occured exception when call CacheManager Put,the downloaded data length-" + g.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d() + ";CacheManager Put execute path:" + stringBuilder.toString() + ";exceptionInfo:" + th.toString());
                                        }
                                        bitmap = decodeByteArray;
                                    }
                                } else if (g.pAe != null) {
                                    g.pAe.collectErrorInfo("TileNetFetcher downLoad function,the downloaded data length-" + g.length + ";tileInfo:x=" + this.c.b() + ",y=" + this.c.c() + "z=" + this.c.d());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    new StringBuilder("decoder bitmap error:").append(e.getMessage());
                                    bitmap = decodeByteArray;
                                    if (bitmap == null) {
                                        this.c.e().getClass();
                                        return bitmap;
                                    } else if (i == 0) {
                                        Thread.sleep(300);
                                        i++;
                                    } else {
                                        if (i != 1) {
                                            Thread.sleep(500);
                                        } else if (i != 2) {
                                            Thread.sleep(700);
                                        }
                                        i++;
                                    }
                                } catch (Exception e3) {
                                    exception = e3;
                                    bitmap = decodeByteArray;
                                    exception2 = exception;
                                    new StringBuilder("Error occured:").append(exception2.getMessage());
                                    i++;
                                }
                            }
                        }
                        bitmap = decodeByteArray;
                    } catch (Exception exception22) {
                        exception = exception22;
                        decodeByteArray = bitmap;
                        e3 = exception;
                        new StringBuilder("decoder bitmap error:").append(e3.getMessage());
                        bitmap = decodeByteArray;
                        if (bitmap == null) {
                            this.c.e().getClass();
                            return bitmap;
                        } else if (i == 0) {
                            if (i != 1) {
                                Thread.sleep(500);
                            } else if (i != 2) {
                                Thread.sleep(700);
                            }
                            i++;
                        } else {
                            Thread.sleep(300);
                            i++;
                        }
                    }
                }
                if (bitmap == null) {
                    this.c.e().getClass();
                    break;
                } else if (i == 0) {
                    Thread.sleep(300);
                    i++;
                } else {
                    if (i != 1) {
                        Thread.sleep(500);
                    } else if (i != 2) {
                        Thread.sleep(700);
                    }
                    i++;
                }
            } catch (Exception e4) {
                exception22 = e4;
            }
        }
        this.c.e();
        return bitmap;
    }

    public final Bitmap a() {
        return this.b;
    }

    public final String b() {
        return this.c != null ? this.c.toString() : "";
    }

    public final void c() {
        if (this.b != null) {
            this.b.recycle();
        }
        this.b = null;
    }

    public final /* synthetic */ Object call() {
        return d();
    }
}
