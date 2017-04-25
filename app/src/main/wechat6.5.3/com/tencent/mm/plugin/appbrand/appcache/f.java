package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

final class f {
    static final ByteOrder dAq = ByteOrder.BIG_ENDIAN;
    private volatile int ajd = -1;
    private final File dAr;
    private volatile FileChannel dAs = null;
    volatile boolean dAt = true;
    private volatile int dAu = 0;
    private volatile int dAv = 0;
    private volatile int dAw = -1;
    volatile List<a> dAx = null;

    public static final class a {
        public final String aST;
        public final int dAy;
        public final int dAz;

        public a(String str, int i, int i2) {
            this.aST = str;
            this.dAy = i;
            this.dAz = i2;
        }
    }

    f(File file) {
        int i;
        boolean z = true;
        this.dAr = file;
        if (this.dAr == null || !this.dAr.exists()) {
            i = 0;
        } else if (this.dAr.length() <= 14) {
            i = 0;
        } else {
            boolean z2 = true;
        }
        if (i == 0 || !OT()) {
            z = false;
        }
        this.dAt = z;
    }

    public final void close() {
        if (this.dAs != null) {
            try {
                this.dAs.close();
                this.dAs = null;
            } catch (IOException e) {
            }
        }
    }

    final boolean OS() {
        if (!this.dAt || this.dAs == null || this.dAu <= 4) {
            v.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[]{Boolean.valueOf(this.dAt), this.dAs, Integer.valueOf(this.dAv)});
            return false;
        } else if (!be.bP(this.dAx) && this.dAw == this.dAx.size()) {
            return true;
        } else {
            try {
                this.dAs.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.dAu);
                allocate.order(dAq);
                this.dAs.read(allocate);
                byte[] array = allocate.array();
                this.dAw = c.n(array, 0);
                LinkedList linkedList = new LinkedList();
                int i = 4;
                for (int i2 = 0; i2 < this.dAw; i2++) {
                    int n = c.n(array, i);
                    i += 4;
                    String str = new String(array, i, n);
                    i += n;
                    n = c.n(array, i);
                    i += 4;
                    int n2 = c.n(array, i);
                    i += 4;
                    linkedList.add(new a(str, n, n2));
                }
                this.dAx = linkedList;
                if (((long) (((a) linkedList.getLast()).dAz + ((a) linkedList.getLast()).dAy)) <= this.dAr.length()) {
                    return true;
                }
                v.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[]{Integer.valueOf(((a) linkedList.getLast()).dAy), Integer.valueOf(((a) linkedList.getLast()).dAz), Long.valueOf(this.dAr.length())});
                return false;
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[]{be.e(e)});
                return false;
            }
        }
    }

    private boolean OT() {
        if (this.dAs == null) {
            try {
                this.dAs = new RandomAccessFile(this.dAr, "r").getChannel();
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[]{be.e(e)});
            }
        }
        if (this.dAs == null) {
            return false;
        }
        try {
            this.dAs.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(dAq);
            this.dAs.read(allocate);
            if ((byte) -66 != allocate.get(0) || (byte) -19 != allocate.get(13)) {
                return false;
            }
            byte[] array = allocate.array();
            this.ajd = c.n(array, 1);
            this.dAu = c.n(array, 5);
            this.dAv = c.n(array, 9);
            return true;
        } catch (Throwable e2) {
            v.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[]{be.e(e2)});
        }
    }
}
