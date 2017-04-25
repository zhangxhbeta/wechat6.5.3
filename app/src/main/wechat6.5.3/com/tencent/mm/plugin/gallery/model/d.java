package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.ada;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    boolean fKT = true;
    private File gdM;
    List<RandomAccessFile> gdN;
    SparseArray<adb> gdO;
    int gdP;

    d(File file) {
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            v.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[]{file.getAbsolutePath(), Boolean.valueOf(mkdirs)});
        }
        this.gdM = file;
        this.gdO = new SparseArray();
    }

    final void aqt() {
        File file = new File(this.gdM, "cache.idx");
        ada com_tencent_mm_protocal_c_ada = new ada();
        String absolutePath = file.getAbsolutePath();
        if (!be.kS(absolutePath)) {
            try {
                com_tencent_mm_protocal_c_ada.az(be.readFromFile(absolutePath));
            } catch (Throwable e) {
                v.e("MicroMsg.DiskCache", "load index file error");
                v.a("MicroMsg.DiskCache", e, "", new Object[0]);
                ld(-1);
                com_tencent_mm_protocal_c_ada = new ada();
            } catch (Throwable e2) {
                v.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[]{Long.valueOf(file.length())});
                v.a("MicroMsg.DiskCache", e2, "", new Object[0]);
                ld(-1);
                com_tencent_mm_protocal_c_ada = new ada();
            }
        }
        this.gdO.clear();
        Iterator it = com_tencent_mm_protocal_c_ada.mEa.iterator();
        while (it.hasNext()) {
            adb com_tencent_mm_protocal_c_adb = (adb) it.next();
            this.gdO.put(com_tencent_mm_protocal_c_adb.key, com_tencent_mm_protocal_c_adb);
        }
    }

    final synchronized void lc(int i) {
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (this.gdN != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.gdM, lf(i)), "rw");
                        this.gdN.remove(i);
                        this.gdN.add(i, randomAccessFile);
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.DiskCache", "create data file error: %s", new Object[]{e.getMessage()});
                    v.a("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.gdN = null;
                }
            }
            this.gdN = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.gdN.add(new RandomAccessFile(new File(this.gdM, lf(i2)), "rw"));
            }
        }
    }

    final void ld(int i) {
        int i2 = 0;
        if (this.gdN != null && this.gdN.size() > 0) {
            if (i < 0) {
                new File(this.gdM, "cache.idx").delete();
                this.gdO.clear();
            } else {
                SparseArray sparseArray = new SparseArray();
                for (int i3 = 0; i3 < this.gdO.size(); i3++) {
                    adb com_tencent_mm_protocal_c_adb = (adb) this.gdO.valueAt(i3);
                    if (com_tencent_mm_protocal_c_adb.mEc != i) {
                        sparseArray.put(this.gdO.keyAt(i3), com_tencent_mm_protocal_c_adb);
                    }
                    v.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_adb.key), Long.valueOf(com_tencent_mm_protocal_c_adb.mEb), Integer.valueOf(com_tencent_mm_protocal_c_adb.length)});
                }
                this.gdO = sparseArray;
                aqu();
            }
            if (i < 0) {
                aqv();
                while (i2 < 25) {
                    new File(this.gdM, lf(25)).delete();
                    i2++;
                }
                return;
            }
            d((Closeable) this.gdN.get(i));
            new File(this.gdM, lf(i)).delete();
        }
    }

    static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                v.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[]{closeable.getClass().getName(), e.getMessage()});
                v.a("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
    }

    final void aqu() {
        ada com_tencent_mm_protocal_c_ada = new ada();
        for (int i = 0; i < this.gdO.size(); i++) {
            com_tencent_mm_protocal_c_ada.mEa.add(0, (adb) this.gdO.valueAt(i));
            v.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[]{Integer.valueOf(r0.key), Long.valueOf(r0.mEb), Integer.valueOf(r0.length), Integer.valueOf(r0.mEc)});
        }
        try {
            be.p(new File(this.gdM, "cache.idx").getAbsolutePath(), com_tencent_mm_protocal_c_ada.toByteArray());
        } catch (Throwable e) {
            v.e("MicroMsg.DiskCache", "save index data error: %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.DiskCache", e, "", new Object[0]);
        }
    }

    final synchronized void aqv() {
        if (this.gdN != null && this.gdN.size() > 0) {
            for (RandomAccessFile d : this.gdN) {
                d(d);
            }
        }
    }

    public final Bitmap le(int i) {
        if (this.gdN == null || this.gdN.size() <= 0) {
            v.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            return null;
        }
        adb com_tencent_mm_protocal_c_adb = (adb) this.gdO.get(i);
        if (com_tencent_mm_protocal_c_adb == null) {
            return null;
        }
        byte[] bArr = new byte[com_tencent_mm_protocal_c_adb.length];
        try {
            v.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_adb.mEb), Integer.valueOf(com_tencent_mm_protocal_c_adb.length)});
            RandomAccessFile randomAccessFile = (RandomAccessFile) this.gdN.get(com_tencent_mm_protocal_c_adb.mEc);
            randomAccessFile.seek(com_tencent_mm_protocal_c_adb.mEb);
            randomAccessFile.read(bArr, 0, com_tencent_mm_protocal_c_adb.length);
            Bitmap bc = com.tencent.mm.sdk.platformtools.d.bc(bArr);
            if (bc != null) {
                v.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[]{Integer.valueOf(bc.getWidth()), Integer.valueOf(bc.getHeight())});
                return bc;
            }
            this.gdO.remove(i);
            return bc;
        } catch (Throwable e) {
            v.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[]{Integer.valueOf(i), e.getMessage()});
            v.a("MicroMsg.DiskCache", e, "", new Object[0]);
            this.gdO.remove(i);
            return null;
        }
    }

    private static String lf(int i) {
        return "cache.data" + (i == 0 ? "" : "." + i);
    }

    public final synchronized int aqw() {
        int i = 0;
        synchronized (this) {
            if (this.gdN != null && this.gdN.size() > 0) {
                try {
                    int i2 = -1;
                    for (RandomAccessFile length : this.gdN) {
                        i2++;
                        if (length.length() < 2097152) {
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                } catch (Throwable e) {
                    v.a("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
            }
        }
        return i;
    }

    public final void aqx() {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.gdP).commit();
    }
}
