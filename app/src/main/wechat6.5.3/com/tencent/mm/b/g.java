package com.tencent.mm.b;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public final class g {
    private static String a(InputStream inputStream, int i, int i2, byte[] bArr) {
        int i3 = 0;
        if (i2 <= 0) {
            return null;
        }
        try {
            if (inputStream.skip(0) < 0) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder(32);
            byte[] bArr2 = new byte[102400];
            int i4 = 0;
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1 || i4 >= i2) {
                    if (bArr != null && bArr.length > 0) {
                        instance.update(bArr);
                    }
                } else if (i4 + read <= i2) {
                    instance.update(bArr2, 0, read);
                    i4 += read;
                } else {
                    instance.update(bArr2, 0, i2 - i4);
                    i4 = i2;
                }
            }
            instance.update(bArr);
            byte[] digest = instance.digest();
            while (i3 < digest.length) {
                stringBuilder.append(Integer.toString((digest[i3] & WebView.NORMAL_MODE_ALPHA) + FileUtils.S_IRUSR, 16).substring(1));
                i3++;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static String a(InputStream inputStream, int i) {
        if (i <= 0) {
            return null;
        }
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
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
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

    private static String g(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        long j = 102400;
        if (!file.exists()) {
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

    public static String a(File file, int i, byte[] bArr) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        if (!file.exists() || i <= 0) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String a = a(fileInputStream, 0, i, bArr);
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
}
