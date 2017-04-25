package com.tencent.mm.b;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

public final class c {
    private static final k aQe = new k(84298576);
    private static final k aQf = new k(50613072);
    private static int aQg = 0;
    private static final k aQh = new k(101010256);

    private static class a {
        Properties aQi;
        byte[] aQj;

        private a() {
            this.aQi = new Properties();
        }

        final void t(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                c.aQe.getBytes();
                byte[] bArr2 = new byte[4];
                wrap.get(bArr2);
                System.out.println("securityPart: " + new k(bArr2).value);
                int i;
                if (c.aQe.equals(new k(bArr2))) {
                    if (bArr.length - 4 <= 2) {
                        System.err.println("data.length - securityMarkLength <= 2");
                        return;
                    }
                    bArr2 = new byte[2];
                    wrap.get(bArr2);
                    i = new l(bArr2).value;
                    if ((bArr.length - 4) - 2 < i) {
                        System.err.println("data.length - securityMarkLength - 2 < len");
                        System.err.println("exit");
                        return;
                    }
                    byte[] bArr3 = new byte[i];
                    wrap.get(bArr3);
                    this.aQi.load(new ByteArrayInputStream(bArr3));
                    i = ((bArr.length - 4) - i) - 2;
                    if (i > 0) {
                        c.aQf.getBytes();
                        bArr3 = new byte[4];
                        wrap.get(bArr3);
                        if (!c.aQf.equals(new k(bArr3))) {
                            return;
                        }
                        if (i - 4 <= 2) {
                            System.err.println("data.length - oriMarkLength <= 2");
                            return;
                        }
                        bArr3 = new byte[2];
                        wrap.get(bArr3);
                        int i2 = new l(bArr3).value;
                        if ((i - 4) - 2 < i2) {
                            System.err.println("data.length - oriMarkLength - 2 < len");
                            System.err.println("exit");
                            return;
                        }
                        this.aQj = new byte[i2];
                        wrap.get(this.aQj);
                    }
                } else if (c.aQf.equals(new k(bArr2))) {
                    c.aQf.getBytes();
                    if (bArr.length - 4 <= 2) {
                        System.err.println("data.length - oriMarkLength <= 2");
                        return;
                    }
                    bArr2 = new byte[2];
                    wrap.get(bArr2);
                    i = new l(bArr2).value;
                    if ((bArr.length - 4) - 2 < i) {
                        System.err.println("data.length - oriMarkLength - 2 < len");
                        System.err.println("exit");
                        return;
                    }
                    this.aQj = new byte[i];
                    wrap.get(this.aQj);
                } else {
                    throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
                }
            }
        }

        final byte[] ob() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.aQi.size() > 0) {
                byteArrayOutputStream.write(c.aQe.getBytes());
                String str = SQLiteDatabase.KeyEmpty;
                String str2 = str;
                for (Object next : this.aQi.keySet()) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(next).append("=").append(this.aQi.getProperty((String) next)).append("\r\n").toString();
                }
                byte[] bytes = str2.getBytes();
                byteArrayOutputStream.write(new l(bytes.length).getBytes());
                byteArrayOutputStream.write(bytes);
            }
            if (this.aQj != null && this.aQj.length > 0) {
                byteArrayOutputStream.write(c.aQf.getBytes());
                byteArrayOutputStream.write(new l(this.aQj.length).getBytes());
                byteArrayOutputStream.write(this.aQj);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile) {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = aQh.getBytes();
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            System.err.println("archive is not a ZIP archive");
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((length + 16) + 4);
        if (((long) aQg) != (length + 16) + 4) {
            aQg = (int) ((length + 16) + 4);
        }
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        System.err.println("readComment:length bytes data = " + s(bArr));
        i = new l(bArr).value;
        if (i == 0) {
            return null;
        }
        bArr = new byte[i];
        randomAccessFile.read(bArr);
        return bArr;
    }

    public static void a(File file, String str) {
        Throwable th;
        byte[] bArr = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                byte[] a = a(randomAccessFile);
                if (a != null) {
                    ByteBuffer wrap = ByteBuffer.wrap(a);
                    aQe.getBytes();
                    byte[] bArr2 = new byte[4];
                    wrap.get(bArr2);
                    if (aQe.equals(new k(bArr2))) {
                        bArr = a;
                    } else if (aQf.equals(new k(bArr2))) {
                        bArr = a;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(aQf.getBytes());
                        byteArrayOutputStream.write(new l(a.length).getBytes());
                        byteArrayOutputStream.write(a);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                }
                a aVar = new a();
                aVar.t(bArr);
                aVar.aQi.setProperty("apkSecurityCode", str);
                a = aVar.ob();
                randomAccessFile.seek((long) aQg);
                randomAccessFile.write(new l(a.length).getBytes());
                randomAccessFile.write(a);
                randomAccessFile.setLength((long) ((a.length + aQg) + 2));
                System.err.println("file length is = " + randomAccessFile.length());
                randomAccessFile.close();
                System.err.println("exit writeSecurityCode");
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit writeSecurityCode");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit writeSecurityCode");
            throw th;
        }
    }

    public static String i(File file) {
        Throwable th;
        String str = null;
        System.err.println("enter getSecurityCode");
        System.err.println("apkFile filename:" + file.getName());
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] a = a(randomAccessFile);
                if (a == null) {
                    System.err.println("null == readComment");
                    System.err.println("exit");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                } else {
                    a aVar = new a();
                    aVar.t(a);
                    str = aVar.aQi.getProperty("apkSecurityCode");
                    randomAccessFile.close();
                    System.err.println("exit getSecurityCode");
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                System.err.println("exit getSecurityCode");
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            randomAccessFile = null;
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            System.err.println("exit getSecurityCode");
            throw th;
        }
    }

    private static String s(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(bArr[i]);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
