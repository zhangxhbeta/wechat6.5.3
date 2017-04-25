package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ShareSecurityCheck {
    private static PublicKey pHc = null;
    private final Context mContext;
    public final HashMap<String, String> pHd = new HashMap();
    private HashMap<String, String> pHe;

    public ShareSecurityCheck(Context context) {
        Throwable e;
        this.mContext = context;
        if (pHc == null) {
            Context context2 = this.mContext;
            Closeable closeable = null;
            Closeable byteArrayInputStream;
            try {
                PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 64);
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                try {
                    pHc = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                    SharePatchFileUtil.c(byteArrayInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", e);
                    } catch (Throwable th) {
                        e = th;
                        closeable = byteArrayInputStream;
                        SharePatchFileUtil.c(closeable);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayInputStream = null;
                throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", e);
            } catch (Throwable th2) {
                e = th2;
                SharePatchFileUtil.c(closeable);
                throw e;
            }
        }
    }

    public final HashMap<String, String> bPa() {
        if (this.pHe != null) {
            return this.pHe;
        }
        String str = (String) this.pHd.get("assets/package_meta.txt");
        if (str == null) {
            return null;
        }
        for (String str2 : str.split("\n")) {
            if (!(str2 == null || str2.length() <= 0 || str2.startsWith("#"))) {
                String[] split = str2.split("=", 2);
                if (split != null && split.length >= 2) {
                    if (this.pHe == null) {
                        this.pHe = new HashMap();
                    }
                    this.pHe.put(split[0].trim(), split[1].trim());
                }
            }
        }
        return this.pHe;
    }

    public final boolean T(File file) {
        Throwable e;
        JarFile jarFile;
        if (file == null || !file.isFile() || !file.exists() || file.length() == 0) {
            return false;
        }
        JarFile jarFile2;
        try {
            jarFile2 = new JarFile(file);
            try {
                Enumeration entries = jarFile2.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (jarEntry != null) {
                        String name = jarEntry.getName();
                        if (!name.startsWith("META-INF/") && name.endsWith("meta.txt")) {
                            this.pHd.put(name, SharePatchFileUtil.a(jarFile2, jarEntry));
                            Certificate[] certificates = jarEntry.getCertificates();
                            if (certificates == null) {
                                try {
                                    jarFile2.close();
                                } catch (IOException e2) {
                                    file.getAbsolutePath();
                                }
                                return false;
                            } else if (!a(file, certificates)) {
                                try {
                                    jarFile2.close();
                                } catch (IOException e3) {
                                    file.getAbsolutePath();
                                }
                                return false;
                            }
                        }
                    }
                }
                try {
                    jarFile2.close();
                } catch (IOException e4) {
                    file.getAbsolutePath();
                }
                return true;
            } catch (Exception e5) {
                e = e5;
                jarFile = jarFile2;
            } catch (Throwable th) {
                e = th;
            }
        } catch (Exception e6) {
            e = e6;
            jarFile = null;
            try {
                throw new TinkerRuntimeException(String.format("ShareSecurityCheck file %s, size %d verifyPatchMetaSignature fail", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length())}), e);
            } catch (Throwable th2) {
                e = th2;
                jarFile2 = jarFile;
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (IOException e7) {
                        file.getAbsolutePath();
                    }
                }
                throw e;
            }
        } catch (Throwable th3) {
            e = th3;
            jarFile2 = null;
            if (jarFile2 != null) {
                jarFile2.close();
            }
            throw e;
        }
    }

    private static boolean a(File file, Certificate[] certificateArr) {
        if (certificateArr.length > 0) {
            int length = certificateArr.length - 1;
            while (length >= 0) {
                try {
                    certificateArr[length].verify(pHc);
                    return true;
                } catch (Exception e) {
                    file.getAbsolutePath();
                    length--;
                }
            }
        }
        return false;
    }
}
