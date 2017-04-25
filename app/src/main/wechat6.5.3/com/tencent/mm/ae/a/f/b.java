package com.tencent.mm.ae.a.f;

import android.graphics.Bitmap;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.a.c.a;
import com.tencent.mm.ae.a.c.d;
import com.tencent.mm.ae.a.c.e;
import com.tencent.mm.ae.a.c.f;
import com.tencent.mm.ae.a.c.g;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.a.c.j;
import com.tencent.mm.ae.a.c.k;
import com.tencent.mm.ae.a.c.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;

public final class b implements Runnable {
    private final com.tencent.mm.ae.a.a.b cOM = this.cPZ.cOM;
    private final com.tencent.mm.ae.a.b cPZ;
    public final c cPf;
    private final l cPg;
    private final a cPh;
    private final com.tencent.mm.ae.a.c.b cPi;
    private final f cPj;
    private final j cPk;
    private final e cPm;
    public final com.tencent.mm.ae.a.c cQb;
    private final ac cQc;
    private final i cQd;
    private final g cQe;
    private final k cQf;
    private final d cQg;
    public final String url;

    public b(String str, com.tencent.mm.ae.a.c cVar, ac acVar, c cVar2, i iVar, j jVar, com.tencent.mm.ae.a.b bVar, g gVar, e eVar, d dVar) {
        this.url = str;
        this.cQb = cVar;
        this.cQc = acVar;
        this.cPZ = bVar;
        this.cQe = gVar;
        if (cVar2 == null) {
            this.cPf = this.cOM.cPf;
        } else {
            this.cPf = cVar2;
        }
        this.cQd = iVar;
        if (jVar == null) {
            this.cPk = this.cOM.cPk;
        } else {
            this.cPk = jVar;
        }
        if (this.cPf.cPi != null) {
            this.cPi = this.cPf.cPi;
        } else {
            this.cPi = this.cOM.cPi;
        }
        this.cPg = this.cOM.cPg;
        this.cPh = this.cOM.cPh;
        this.cPj = this.cOM.cPj;
        this.cQf = this.cOM.cPl;
        if (eVar == null) {
            this.cPm = this.cOM.cPm;
        } else {
            this.cPm = eVar;
        }
        this.cQg = dVar;
    }

    public final void run() {
        Bitmap bitmap = null;
        com.tencent.mm.ae.a.d.b bVar = new com.tencent.mm.ae.a.d.b();
        Exception e;
        Bitmap bitmap2;
        com.tencent.mm.ae.a.d.b bVar2;
        InputStream inputStream;
        try {
            Bitmap b;
            long currentTimeMillis;
            String jl = jl(this.url);
            v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", this.url);
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.cPf.cPx;
            boolean z = this.cPf.cPA;
            String str = this.cPf.aZy;
            v.d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:" + z);
            v.d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", Integer.valueOf(i));
            v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", Integer.valueOf(this.cQb.width), Integer.valueOf(this.cQb.height));
            switch (i) {
                case 1:
                    String str2 = this.cPf.bdZ;
                    if (!this.cPf.cPE || be.kS(str2) || !com.tencent.mm.a.e.aR(str2)) {
                        if (!be.kS(this.url)) {
                            if (!com.tencent.mm.a.e.aR(this.url)) {
                                if (this.cPf.cPF) {
                                    this.cPm.e(this.cPf.cPT);
                                }
                                v.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.cQf.V(str, this.url)) {
                                    v.w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.cPf.cPR) {
                                b = com.tencent.mm.ae.a.g.a.b(this.cQb, this.url, this.cPf.cPy, this.cPf.cPz);
                            } else if (this.cQg != null) {
                                b = com.tencent.mm.ae.a.g.a.a(this.cQb, this.cQg.f(this.cPf.cPT), this.cPf.cPy, this.cPf.cPz, this.cPf.cPG, this.cPf.alpha, this.cPf.cPB);
                            } else {
                                b = com.tencent.mm.ae.a.g.a.a(this.cQb, this.url, this.cPf.cPy, this.cPf.cPz);
                            }
                            if (this.cPf.density > 0) {
                                b.setDensity(this.cPf.density);
                            }
                            v.d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        v.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.cPf.cPR) {
                        b = com.tencent.mm.ae.a.g.a.b(this.cQb, str2, this.cPf.cPy, this.cPf.cPz);
                    } else {
                        b = com.tencent.mm.ae.a.g.a.a(this.cQb, str2, this.cPf.cPy, this.cPf.cPz);
                    }
                    try {
                        if (this.cPf.density <= 0) {
                            bitmap = b;
                            break;
                        }
                        b.setDensity(this.cPf.density);
                        bitmap = b;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        bitmap2 = b;
                        bVar2 = bVar;
                        break;
                    }
                case 2:
                    bitmap = com.tencent.mm.ae.a.g.a.c(this.cQb, this.url, this.cPf.cPy, this.cPf.cPz);
                    break;
                case 3:
                    bitmap = com.tencent.mm.ae.a.g.a.a(this.cQb, this.cOM.cPc.getIdentifier(this.url, "drawable", this.cOM.packageName), this.cPf.cPy, this.cPf.cPz);
                    break;
                case 4:
                    bitmap = com.tencent.mm.ae.a.g.a.a(this.cQb, Integer.valueOf(this.url).intValue(), this.cPf.cPy, this.cPf.cPz);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.cPh.d(this.url, this.cPf);
                    if (inputStream == null) {
                        bitmap2 = null;
                    } else if (!z || this.cQf.a(str, inputStream)) {
                        Bitmap a;
                        com.tencent.mm.ae.a.c cVar = this.cQb;
                        int i2 = this.cPf.cPy;
                        int i3 = this.cPf.cPz;
                        boolean z2 = this.cPf.cPG;
                        float f = this.cPf.alpha;
                        boolean z3 = this.cPf.cPB;
                        if (i2 > 0 && i3 > 0) {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, i2, i3);
                        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
                            a = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                        } else {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, cVar.width, cVar.height);
                        }
                        if (z2) {
                            a = com.tencent.mm.sdk.platformtools.d.a(a, i2, i3, false, true);
                        }
                        if (f > 0.0f) {
                            a = com.tencent.mm.sdk.platformtools.d.c(a, f);
                        }
                        if (z3) {
                            a = com.tencent.mm.sdk.platformtools.d.G(a);
                        }
                        bitmap2 = a;
                        obj = 1;
                    } else {
                        obj = 1;
                        bitmap2 = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (obj != null && bitmap2 == null) {
                        try {
                            this.cPh.c(this.url, this.cPf);
                            bitmap = bitmap2;
                            break;
                        } catch (Exception e4) {
                            e = e4;
                            bVar2 = bVar;
                            break;
                        }
                    }
                    bitmap = bitmap2;
                    break;
                    break;
                default:
                    v.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", Integer.valueOf(i));
                    break;
            }
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                bVar2 = bVar;
                bitmap2 = bitmap;
            }
            Bitmap bitmap3;
            String str3;
            int min;
            i iVar;
            com.tencent.mm.ae.a.b bVar3;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        v.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap3 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.cQe != null) {
                            g gVar = this.cQe;
                            str3 = this.url;
                            this.cQb.AR();
                            gVar.jk(str3);
                        }
                        bVar2 = this.cPi.ji(this.url);
                        if (bVar2 == null) {
                            try {
                                bVar = new com.tencent.mm.ae.a.d.b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                bitmap2 = bitmap;
                                break;
                            }
                        }
                        bVar = bVar2;
                        try {
                            if (bVar.data != null) {
                                if (z) {
                                    if (!this.cQf.j(str, bVar.data)) {
                                        bVar.status = 2;
                                        v.w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap3 = null;
                                        break;
                                    }
                                }
                                v.d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                b = com.tencent.mm.ae.a.g.a.a(this.cQb, bVar.data, this.cPf.cPy, this.cPf.cPz, this.cPf.cPG, this.cPf.alpha, this.cPf.cPB);
                                if (b != null) {
                                    byte[] bArr = bVar.data;
                                    if (this.cPf.cPs) {
                                        this.cPh.a(this.url, bArr, this.cPf);
                                    }
                                    if (this.cPf.cPr) {
                                        this.cPh.a(this.url, bArr, this.cPf);
                                    }
                                    if (this.cPf.cPP) {
                                        if (this.cPf.cPQ != 0.0f) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, this.cPf.cPQ);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, min, min, true);
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    i(jl, b);
                                    am(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap3 = b;
                                    break;
                                }
                                try {
                                    bVar.status = 3;
                                    bitmap3 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    bitmap2 = b;
                                    bVar2 = bVar;
                                    break;
                                }
                            }
                            bVar.status = 1;
                            bitmap3 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            bVar2 = bVar;
                            bitmap2 = bitmap;
                            break;
                        }
                    default:
                        v.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap3 = bitmap;
                        break;
                }
                v.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", e.toString());
                bVar = bVar2;
                bitmap3 = bitmap2;
                if (bitmap3 != null || bitmap3.isRecycled()) {
                    v.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.cPf.cPC) {
                        bitmap3 = com.tencent.mm.sdk.platformtools.d.c(bitmap3, this.cPf.cPD);
                    }
                    Runnable cVar2 = new c(this.url, this.cQb, bitmap3, this.cPZ, jl(this.url));
                    if (this.cQc != null) {
                        this.cQc.post(cVar2);
                    }
                    bVar.bitmap = bitmap3;
                }
                if (!(this.cQe == null || bVar == null)) {
                    bVar.bitmap = bitmap3;
                    this.cQe.a(this.url, this.cQb.AR(), bVar);
                }
                iVar = this.cQd;
                str3 = this.url;
                this.cQb.AR();
                iVar.a(str3, bitmap3, this.cPf.cPT);
                bVar3 = this.cPZ;
                if (bVar3.cOQ != null && this != null && this.cQb != null) {
                    bVar3.cOQ.remove(Integer.valueOf(this.cQb.GS()));
                    return;
                }
                return;
            }
            if (!this.cPf.cPP) {
                b = bitmap;
            } else if (this.cPf.cPQ != 0.0f) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, this.cPf.cPQ);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, min, min, true);
                b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
            }
            i(jl, b);
            am(currentTimeMillis - currentTimeMillis2);
            v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap3 = b;
            if (bitmap3 != null) {
            }
            v.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            bVar.bitmap = bitmap3;
            this.cQe.a(this.url, this.cQb.AR(), bVar);
            iVar = this.cQd;
            str3 = this.url;
            this.cQb.AR();
            iVar.a(str3, bitmap3, this.cPf.cPT);
            bVar3 = this.cPZ;
            if (bVar3.cOQ != null) {
            }
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            bitmap2 = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
        }
    }

    private void i(String str, Bitmap bitmap) {
        if (this.cPf.cPq) {
            v.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", this.url);
            this.cPg.b(str, bitmap);
        }
    }

    public final String jl(String str) {
        if (be.kS(str) || this.cPf == null) {
            return null;
        }
        if (this.cPf.cPP) {
            str = str + "round" + this.cPf.cPQ;
        }
        return str + "size" + this.cPf.cPy + this.cPf.cPz;
    }

    public final void am(long j) {
        if (this.cPk != null) {
            this.cPk.am(j);
        }
    }
}
