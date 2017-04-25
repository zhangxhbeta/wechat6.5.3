package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public final class a extends o {
    public static boolean afA;
    private com.google.android.gms.a.a.a.a afB;
    private final j afC;
    private String afD;
    private boolean afE = false;
    private Object afF = new Object();

    a(q qVar) {
        super(qVar);
        this.afC = new j(qVar.agn);
    }

    private boolean a(com.google.android.gms.a.a.a.a aVar, com.google.android.gms.a.a.a.a aVar2) {
        String str = null;
        String str2 = aVar2 == null ? null : aVar2.afa;
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String ix = this.afY.ie().ix();
        synchronized (this.afF) {
            if (!this.afE) {
                this.afD = hr();
                this.afE = true;
            } else if (TextUtils.isEmpty(this.afD)) {
                if (aVar != null) {
                    str = aVar.afa;
                }
                if (str == null) {
                    boolean x = x(str2 + ix);
                    return x;
                }
                this.afD = w(str + ix);
            }
            Object w = w(str2 + ix);
            if (TextUtils.isEmpty(w)) {
                return false;
            } else if (w.equals(this.afD)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.afD)) {
                    str = ix;
                } else {
                    C("Resetting the client id because Advertising Id changed.");
                    str = this.afY.ie().iy();
                    d("New client Id", str);
                }
                x = x(str2 + str);
                return x;
            }
        }
    }

    private synchronized com.google.android.gms.a.a.a.a hp() {
        if (this.afC.f(1000)) {
            this.afC.start();
            com.google.android.gms.a.a.a.a hq = hq();
            if (a(this.afB, hq)) {
                this.afB = hq;
            } else {
                G("Failed to reset client id on adid change. Not using adid");
                this.afB = new com.google.android.gms.a.a.a.a("", false);
            }
        }
        return this.afB;
    }

    private com.google.android.gms.a.a.a.a hq() {
        com.google.android.gms.a.a.a.a aVar = null;
        try {
            aVar = com.google.android.gms.a.a.a.q(this.afY.mContext);
        } catch (IllegalStateException e) {
            F("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Throwable th) {
            if (!afA) {
                afA = true;
                f("Error getting advertiser id", th);
            }
        }
        return aVar;
    }

    private String hr() {
        Object obj;
        String str = null;
        try {
            FileInputStream openFileInput = this.afY.mContext.openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                F("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                this.afY.mContext.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                C("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    IOException iOException2 = iOException;
                    f("Error reading Hash file, deleting it", obj);
                    this.afY.mContext.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            obj = e4;
            f("Error reading Hash file, deleting it", obj);
            this.afY.mContext.deleteFile("gaClientIdData");
            return str;
        }
    }

    private static String w(String str) {
        if (k.A("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, k.A("MD5").digest(str.getBytes()))});
    }

    private boolean x(String str) {
        try {
            String w = w(str);
            C("Storing hashed adid.");
            FileOutputStream openFileOutput = this.afY.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(w.getBytes());
            openFileOutput.close();
            this.afD = w;
            return true;
        } catch (IOException e) {
            g("Error creating hash file", e);
            return false;
        }
    }

    protected final void hm() {
    }

    public final boolean hn() {
        hX();
        com.google.android.gms.a.a.a.a hp = hp();
        return (hp == null || hp.afb) ? false : true;
    }

    public final String ho() {
        hX();
        com.google.android.gms.a.a.a.a hp = hp();
        CharSequence charSequence = hp != null ? hp.afa : null;
        return TextUtils.isEmpty(charSequence) ? null : charSequence;
    }
}
