package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.RandomAccessFile;

public final class a {
    private static final int gdq = (d.dX(14) ? 20 : 30);
    public b gdr = new b();
    private a gds = new a();
    private f<String> gdt = new f();
    private f<b> gdu = new f();
    private volatile boolean gdv = false;

    private class a {
        final /* synthetic */ a gdw;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.tencent.mm.sdk.platformtools.ap.a gdx;
            final /* synthetic */ a gdy;

            AnonymousClass1(a aVar, com.tencent.mm.sdk.platformtools.ap.a aVar2) {
                this.gdy = aVar;
                this.gdx = aVar2;
            }

            public final void run() {
                if (this.gdx.AZ()) {
                    this.gdx.Ba();
                }
                this.gdy.gdw.gdv = false;
                this.gdy.gdw.aqk();
            }

            public final String toString() {
                return super.toString() + "|QueueWorkerThreadForGallery";
            }
        }

        private a(a aVar) {
            this.gdw = aVar;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.ap.a {
        String aVL;
        private int bcp;
        private Bitmap bitmap;
        private long gdA;
        private int gdB;
        final /* synthetic */ a gdw;
        private String gdz;

        public b(a aVar, String str, int i, String str2, long j) {
            this(aVar, str, i, str2, j, (byte) 0);
        }

        private b(a aVar, String str, int i, String str2, long j, byte b) {
            this.gdw = aVar;
            this.aVL = str;
            this.gdA = j;
            this.gdz = str2;
            this.gdB = 12288;
            this.bcp = i;
        }

        public final boolean AZ() {
            b a = this.gdw.gdr;
            String str = this.aVL;
            String str2 = this.gdz;
            long j = this.gdA;
            this.bitmap = a.gdD == null ? null : a.gdD.le(String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)}).hashCode());
            if (this.bitmap != null) {
                v.d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", new Object[]{this.aVL});
                return true;
            }
            this.bitmap = j.a(this.gdA, this.bcp, this.aVL, this.gdz);
            if (this.bitmap == null) {
                return false;
            }
            a = this.gdw.gdr;
            str = this.aVL;
            str2 = this.gdz;
            j = this.gdA;
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
                if (a.gdD != null) {
                    d dVar = a.gdD;
                    int hashCode = str.hashCode();
                    if (dVar.gdN == null || dVar.gdN.size() <= 0) {
                        v.e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                    } else if (bitmap == null) {
                        v.e("MicroMsg.DiskCache", "put bmp, value error: null");
                    } else {
                        int i;
                        v.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[]{Integer.valueOf(hashCode), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                        if (dVar.gdN == null || dVar.gdN.size() <= 0) {
                            i = -1;
                        } else {
                            int aqw = dVar.aqw();
                            if (aqw < 0) {
                                v.d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", new Object[]{Integer.valueOf(dVar.gdP)});
                                aqw = dVar.gdP + 1 >= 25 ? 0 : dVar.gdP + 1;
                                v.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[]{Integer.valueOf(aqw)});
                                dVar.ld(aqw);
                                dVar.lc(aqw);
                            }
                            i = aqw;
                        }
                        if (i < 0) {
                            v.e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                        } else {
                            Object obj;
                            adb com_tencent_mm_protocal_c_adb = (adb) dVar.gdO.get(hashCode);
                            if (com_tencent_mm_protocal_c_adb == null) {
                                com_tencent_mm_protocal_c_adb = new adb();
                                com_tencent_mm_protocal_c_adb.key = hashCode;
                                obj = com_tencent_mm_protocal_c_adb;
                            } else {
                                adb com_tencent_mm_protocal_c_adb2 = com_tencent_mm_protocal_c_adb;
                            }
                            Closeable byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    RandomAccessFile randomAccessFile = (RandomAccessFile) dVar.gdN.get(i);
                                    obj.mEb = randomAccessFile.length();
                                    obj.mEc = i;
                                    obj.length = byteArrayOutputStream.size();
                                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                    randomAccessFile.seek(obj.mEb);
                                    randomAccessFile.write(toByteArray);
                                    dVar.gdP = i;
                                    v.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(obj.key), Long.valueOf(obj.mEb), Integer.valueOf(obj.length), Integer.valueOf(obj.mEc)});
                                    dVar.fKT = true;
                                    dVar.gdO.put(hashCode, obj);
                                } catch (Exception e) {
                                    obj = "write data error:%s";
                                    v.e("MicroMsg.DiskCache", obj, new Object[]{e.getMessage()});
                                } finally {
                                    d.d(byteArrayOutputStream);
                                }
                            } catch (Throwable e2) {
                                v.e("MicroMsg.DiskCache", "compress bmp error:%s", new Object[]{e2.getMessage()});
                                v.a("MicroMsg.DiskCache", e2, "", new Object[0]);
                                d.d(byteArrayOutputStream);
                            }
                        }
                    }
                }
            }
            return true;
        }

        public final boolean Ba() {
            v.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", new Object[]{this.aVL});
            this.gdw.gdt.aJ(this.aVL);
            v.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", new Object[]{Integer.valueOf(this.gdw.gdt.size())});
            if (this.bitmap == null) {
                v.e("MircoMsg.CacheService", "decode file failed, %s ", new Object[]{this.aVL});
                return false;
            }
            b a = this.gdw.gdr;
            String str = this.aVL;
            Bitmap bitmap = this.bitmap;
            int i = this.gdB;
            if (a.gdC == null) {
                v.e("MicroMsg.GalleryCache", "cache is null");
            } else {
                a.gdC.k(str, new a(a, bitmap, i));
                a.cye.bg(str);
                a.cye.Ls();
            }
            this.bitmap = null;
            return true;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return be.ah(this.aVL, "").equals(((b) obj).aVL);
        }

        public final int hashCode() {
            return be.ah(this.aVL, "").hashCode();
        }
    }

    public final Bitmap b(String str, int i, String str2, long j) {
        if (be.kS(str)) {
            v.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.gdr.getBitmap(str);
        if (bitmap != null) {
            v.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
            return bitmap;
        }
        v.v("MircoMsg.CacheService", "filePathInService size is : [%d]", new Object[]{Integer.valueOf(this.gdt.size())});
        if (this.gdt.aI(str)) {
            v.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", new Object[]{str});
            aqk();
            return null;
        }
        if (this.gdt.size() > gdq) {
            v.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one");
            v.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", new Object[]{Integer.valueOf(this.gdt.size()), Integer.valueOf(this.gdu.size())});
            if (!this.gdu.isEmpty()) {
                this.gdt.aJ(((b) this.gdu.aqD()).aVL);
            }
        }
        this.gdt.add(str);
        this.gdu.add(new b(this, str, i, str2, j));
        aqk();
        return null;
    }

    public final Bitmap tU(String str) {
        if (be.kS(str)) {
            v.w("MircoMsg.CacheService", "file path is null");
            return null;
        }
        Bitmap bitmap = this.gdr.getBitmap(str);
        if (bitmap == null) {
            return null;
        }
        v.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[]{str});
        return bitmap;
    }

    private void aqk() {
        if (this.gdv) {
            v.w("MircoMsg.CacheService", "is decoding now, wait a minute");
        } else if (this.gdu == null || this.gdu.size() <= 0) {
            v.i("MircoMsg.CacheService", "all job empty");
            if (c.aqo() != null) {
                c.aqo().n(new Runnable(this) {
                    final /* synthetic */ a gdw;

                    {
                        this.gdw = r1;
                    }

                    public final void run() {
                        b a = this.gdw.gdr;
                        if (a.gdD != null) {
                            d dVar = a.gdD;
                            if (dVar.fKT) {
                                dVar.fKT = false;
                                dVar.aqu();
                                dVar.aqv();
                                dVar.lc(-1);
                                dVar.aqx();
                            }
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|tryStartDocode";
                    }
                });
            }
        } else {
            this.gdv = true;
            b bVar = (b) this.gdu.aqD();
            if (bVar == null) {
                v.e("MircoMsg.CacheService", "obj is null");
                this.gdv = false;
                aqk();
                return;
            }
            a aVar = this.gds;
            if (c.aqo() == null) {
                v.w("MircoMsg.CacheService", "add thread object, but worker thread is null");
                return;
            }
            e aqo = c.aqo();
            Runnable anonymousClass1 = new AnonymousClass1(aVar, bVar);
            ac aqy = aqo.aqy();
            if (aqy == null) {
                v.e("MicroMsg.GalleryHandlerThread", "post at front of queue, but decode handler is null");
                return;
            }
            boolean postAtFrontOfQueueV2 = aqy.postAtFrontOfQueueV2(anonymousClass1);
            v.i("MicroMsg.GalleryHandlerThread", "postAtFrontOfQueue:[%b]", new Object[]{Boolean.valueOf(postAtFrontOfQueueV2)});
        }
    }
}
