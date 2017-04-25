package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class f {
    private boolean a = false;
    String b = null;

    f() {
    }

    private static boolean b(String str, String[] strArr) {
        for (String compareTo : strArr) {
            if (str.compareTo(compareTo) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void f(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel channel;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        Throwable th;
        FileChannel fileChannel = null;
        File file = new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString());
        File file2 = new File(new StringBuilder(String.valueOf(str3)).append("/").append(str).toString());
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    channel = fileInputStream.getChannel();
                    try {
                        fileChannel = fileOutputStream.getChannel();
                        channel.transferTo(0, channel.size(), fileChannel);
                        try {
                            fileInputStream.close();
                            channel.close();
                            fileOutputStream.close();
                            fileChannel.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        fileInputStream2 = fileInputStream;
                        try {
                            fileInputStream2.close();
                            channel.close();
                            fileOutputStream.close();
                            fileChannel.close();
                        } catch (IOException e3) {
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        try {
                            fileInputStream.close();
                            channel.close();
                            fileOutputStream2.close();
                            fileChannel.close();
                        } catch (IOException e4) {
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    channel = null;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    channel.close();
                    fileOutputStream.close();
                    fileChannel.close();
                } catch (Throwable th4) {
                    fileOutputStream2 = fileOutputStream;
                    th = th4;
                    channel = null;
                    fileInputStream.close();
                    channel.close();
                    fileOutputStream2.close();
                    fileChannel.close();
                    throw th;
                }
            } catch (IOException e6) {
                channel = null;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                channel.close();
                fileOutputStream.close();
                fileChannel.close();
            } catch (Throwable th5) {
                th = th5;
                channel = null;
                fileOutputStream2 = null;
                fileInputStream.close();
                channel.close();
                fileOutputStream2.close();
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            channel = null;
            fileOutputStream = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            channel.close();
            fileOutputStream.close();
            fileChannel.close();
        } catch (Throwable th6) {
            th = th6;
            channel = null;
            fileOutputStream2 = null;
            fileInputStream = null;
            fileInputStream.close();
            channel.close();
            fileOutputStream2.close();
            fileChannel.close();
            throw th;
        }
    }

    private static boolean k(String str, String str2) {
        return new File(new StringBuilder(String.valueOf(str2)).append("/").append(str).toString()).exists();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String l(java.lang.String r8, java.lang.String r9) {
        /*
        r4 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r1 = java.lang.String.valueOf(r9);
        r0.<init>(r1);
        r1 = "/";
        r0 = r0.append(r1);
        r0 = r0.append(r8);
        r0 = r0.toString();
        r4.<init>(r0);
        r6 = 0;
        r7 = new java.io.FileInputStream;
        r7.<init>(r4);
        r0 = r7.getChannel();	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r2 = 0;
        r4 = r4.length();	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r0 = r0.map(r1, r2, r4);	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r1 = "MD5";
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r1.update(r0);	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r0 = new java.math.BigInteger;	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r2 = 1;
        r1 = r1.digest();	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r0.<init>(r2, r1);	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r1 = 16;
        r0 = r0.toString(r1);	 Catch:{ Exception -> 0x0051, all -> 0x005a }
        r7.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0050:
        return r0;
    L_0x0051:
        r0 = move-exception;
        r7.close();	 Catch:{ IOException -> 0x0057 }
        r0 = r6;
        goto L_0x0050;
    L_0x0057:
        r0 = move-exception;
        r0 = r6;
        goto L_0x0050;
    L_0x005a:
        r0 = move-exception;
        r7.close();	 Catch:{ IOException -> 0x005f }
    L_0x005e:
        throw r0;
    L_0x005f:
        r1 = move-exception;
        goto L_0x005e;
    L_0x0061:
        r1 = move-exception;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.wx.voice.embed.recognizer.f.l(java.lang.String, java.lang.String):java.lang.String");
    }

    public final int b(Context context, String str, String str2, String str3) {
        if (this.a) {
            return 0;
        }
        if (!k("libwxvoiceembed.so", str)) {
            return -201;
        }
        if (!k("libwxvoiceembed.bin", str)) {
            return -202;
        }
        String stringBuilder = new StringBuilder(String.valueOf(context.getFilesDir().getAbsolutePath())).append("/NamesSearch/").toString();
        File file = new File(stringBuilder);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!k("libwxvoiceembed.so", stringBuilder)) {
            f("libwxvoiceembed.so", str, stringBuilder);
        }
        if (!k("libwxvoiceembed.bin", stringBuilder)) {
            f("libwxvoiceembed.bin", str, stringBuilder);
        }
        try {
            String l = l("libwxvoiceembed.so", stringBuilder);
            if (l.compareTo(l("libwxvoiceembed.so", str)) != 0) {
                f("libwxvoiceembed.so", str, stringBuilder);
            }
            if (!b(l, str2.split(";"))) {
                return -203;
            }
            try {
                String l2 = l("libwxvoiceembed.bin", stringBuilder);
                if (l2.compareTo(l("libwxvoiceembed.bin", str)) != 0) {
                    f("libwxvoiceembed.bin", str, stringBuilder);
                }
                if (!b(l2, str3.split(";"))) {
                    return -204;
                }
                this.b = stringBuilder;
                this.a = true;
                return 0;
            } catch (FileNotFoundException e) {
                return -204;
            }
        } catch (FileNotFoundException e2) {
            return -203;
        }
    }

    public final int e(String str, String str2, String str3) {
        if (this.a) {
            return 0;
        }
        if (!k("libwxvoiceembed.so", str)) {
            return -201;
        }
        if (!k("libwxvoiceembed.bin", str)) {
            return -202;
        }
        try {
            if (!b(l("libwxvoiceembed.so", str), str2.split(";"))) {
                return -203;
            }
            try {
                if (!b(l("libwxvoiceembed.bin", str), str3.split(";"))) {
                    return -204;
                }
                this.b = str;
                this.a = true;
                return 0;
            } catch (FileNotFoundException e) {
                return -204;
            }
        } catch (FileNotFoundException e2) {
            return -203;
        }
    }
}
