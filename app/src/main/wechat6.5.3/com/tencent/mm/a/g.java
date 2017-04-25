package com.tencent.mm.a;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g {
    public static final String m(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static final byte[] n(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static final String a(InputStream inputStream, int i, int i2) {
        return a(inputStream, 102400, i, i2);
    }

    private static String a(InputStream inputStream, int i, int i2, int i3) {
        String str = null;
        int i4 = 0;
        if (inputStream != null && i2 >= 0 && i3 > 0) {
            try {
                if (inputStream.skip((long) i2) >= ((long) i2)) {
                    byte[] digest;
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    StringBuilder stringBuilder = new StringBuilder(32);
                    byte[] bArr = new byte[102400];
                    int i5 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1 || i5 >= i3) {
                            digest = instance.digest();
                        } else if (i5 + read <= i3) {
                            instance.update(bArr, 0, read);
                            i5 += read;
                        } else {
                            instance.update(bArr, 0, i3 - i5);
                            i5 = i3;
                        }
                    }
                    digest = instance.digest();
                    while (i4 < digest.length) {
                        stringBuilder.append(Integer.toString((digest[i4] & WebView.NORMAL_MODE_ALPHA) + FileUtils.S_IRUSR, 16).substring(1));
                        i4++;
                    }
                    str = stringBuilder.toString();
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static final String a(InputStream inputStream, int i) {
        String str = null;
        if (inputStream != null && i > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[i];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toString((b & WebView.NORMAL_MODE_ALPHA) + FileUtils.S_IRUSR, 16).substring(1));
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String aX(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return g(file);
        }
        return null;
    }

    public static String g(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        long j = 102400;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                if (102400 > file.length()) {
                    j = file.length();
                }
                String a = a(fileInputStream, (int) j);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                    return a;
                } catch (IOException e) {
                    return a;
                }
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static String aY(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return a(file, 0, (int) FileUtils.S_IRUSR);
        }
        return null;
    }

    private static String a(File file, int i, int i2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String a = a((InputStream) fileInputStream, 0, (int) FileUtils.S_IRUSR);
                fileInputStream.close();
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
                return a;
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    return null;
                }
                try {
                    fileInputStream2.close();
                    return null;
                } catch (IOException e3) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                return null;
            }
            fileInputStream2.close();
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
