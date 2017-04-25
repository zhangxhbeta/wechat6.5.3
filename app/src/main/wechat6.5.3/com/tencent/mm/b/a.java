package com.tencent.mm.b;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class a {
    a aPS;
    public b aPT = null;

    public static class a {
        static final long aPU = ((long) "Micromsg".hashCode());
        public int aPV = 0;

        public a(int i) {
            this.aPV = i;
        }

        public static a r(byte[] bArr) {
            if (bArr.length == 8) {
                long j = 0;
                for (int i = 0; i < bArr.length; i++) {
                    j |= ((long) (bArr[i] & WebView.NORMAL_MODE_ALPHA)) << (i * 8);
                }
                if ((j >> 32) == aPU) {
                    return new a((int) j);
                }
            }
            return null;
        }

        static byte[] q(long j) {
            byte[] bArr = new byte[8];
            for (int i = 0; i < 8; i++) {
                bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
            }
            return bArr;
        }
    }

    public a(b bVar) {
        this.aPT = bVar;
    }

    public final int h(File file) {
        try {
            if (bb(file.getAbsolutePath()) != null) {
                System.out.println("Error: duplicate append apk external info!");
                return -1;
            }
            byte[] toByteArray = this.aPT.toByteArray();
            byte[] q = a.q((a.aPU << 32) | ((long) new a(toByteArray.length).aPV));
            byte[] bArr = new byte[]{(byte) ((toByteArray.length + 8) % FileUtils.S_IRUSR), (byte) ((toByteArray.length + 8) / FileUtils.S_IRUSR)};
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length() - 2);
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(toByteArray);
            fileOutputStream.write(q);
            fileOutputStream.flush();
            fileOutputStream.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public static a bb(String str) {
        int i = 0;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    i = (int) file.length();
                }
            } catch (Exception e) {
                return null;
            }
        }
        if (i < 8) {
            return null;
        }
        a r = a.r(d(str, i - 8, 8));
        if (r == null || r.aPV < 0) {
            return null;
        }
        b bVar = new b();
        bVar.az(d(str, (i - r.aPV) - 8, r.aPV));
        a aVar = new a(bVar);
        aVar.aPS = r;
        return aVar;
    }

    public static boolean bc(String str) {
        boolean z = false;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                a bb = bb(str);
                if (!(bb == null || bb.aPT == null)) {
                    try {
                        byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                        File file2 = new File(str);
                        if (file2.exists()) {
                            z = bb.aPT.apkMd5.equalsIgnoreCase(g.a(file2, (int) ((file.length() - ((long) (bb.aPS.aPV + 8))) - 2), bArr));
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return z;
    }

    private static byte[] d(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        int length;
        if (i2 == -1) {
            length = (int) file.length();
        } else {
            length = i2;
        }
        if (i < 0) {
            return null;
        }
        if (length <= 0) {
            return null;
        }
        if (i + length > ((int) file.length())) {
            length = ((int) file.length()) - i;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            byte[] bArr = new byte[length];
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
