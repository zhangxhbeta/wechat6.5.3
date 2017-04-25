package com.tencent.mm.plugin.backup.backupmodel;

import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.zip.CRC32;

public final class e {
    public static void a(byte[] bArr, int i, short s, PByteArray pByteArray) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!(s == (short) 1 || s == (short) 2)) {
                bArr = k.c(bArr, b.UV());
            }
            byteArrayOutputStream.write("GSMW".getBytes());
            byteArrayOutputStream.write(n.cE(i));
            byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 1});
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) (s & WebView.NORMAL_MODE_ALPHA)});
            byteArrayOutputStream.write(n.cE(bArr.length + 20));
            byteArrayOutputStream.write(n.cE(0));
            byteArrayOutputStream.write(bArr);
            pByteArray.value = byteArrayOutputStream.toByteArray();
            if (com.tencent.mm.plugin.backup.b.b.getMode() == 1) {
                CRC32 crc32 = new CRC32();
                crc32.update(pByteArray.value);
                System.arraycopy(n.cE((int) crc32.getValue()), 0, pByteArray.value, 16, 4);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPacker", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static int a(byte[] bArr, int i, short s, short s2, int i2, int i3, byte[] bArr2, PByteArray pByteArray) {
        if (s != (short) 1) {
            String format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(s)});
            v.e("MicroMsg.BackupPacker", format);
            pByteArray.value = format.getBytes();
            return -1;
        }
        if (com.tencent.mm.plugin.backup.b.b.getMode() == 1) {
            b.UL().aB((long) bArr2.length);
            if (i3 != a(bArr, i, s, s2, i2, bArr2)) {
                new CRC32().update(bArr2);
                String N = N(bArr2);
                format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(i3), Integer.valueOf(i), Short.valueOf(s2), Integer.valueOf(i2), Integer.valueOf((int) r1.getValue()), N});
                v.e("MicroMsg.BackupPacker", format);
                pByteArray.value = format.getBytes();
                return -2;
            }
        }
        if (!(s2 == (short) 1 || s2 == (short) 2)) {
            bArr2 = k.b(bArr2, b.UV());
        }
        pByteArray.value = bArr2;
        return 0;
    }

    private static int a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(n.cE(i));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) (s & WebView.NORMAL_MODE_ALPHA)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) (s2 & WebView.NORMAL_MODE_ALPHA)});
            byteArrayOutputStream.write(n.cE(i2));
            byteArrayOutputStream.write(n.cE(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            return (int) crc32.getValue();
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPacker", e, SQLiteDatabase.KeyEmpty, new Object[i3]);
            return i3;
        }
    }

    private static String N(byte[] bArr) {
        String str = SQLiteDatabase.KeyEmpty;
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & WebView.NORMAL_MODE_ALPHA) + " ";
            r0++;
        }
        v.e("MicroMsg.BackupPacker", "dump errBuf: %s", str);
        return str;
    }
}
