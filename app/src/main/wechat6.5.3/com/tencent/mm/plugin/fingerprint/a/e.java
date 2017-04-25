package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.t.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static boolean fTD = false;

    public static String getUserId() {
        return z.Kg(z.Kg(com.tencent.mm.wallet_core.ui.e.getUsername()) + z.Kg(p.rK()));
    }

    public static String anF() {
        return "WechatAuthKeyPay&" + k.xI();
    }

    public static void anG() {
        ak.yW();
        c.vf().a(a.npW, Boolean.valueOf(true));
    }

    public static boolean anH() {
        ak.yW();
        Object obj = c.vf().get(a.npW, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void anI() {
        ak.yW();
        c.vf().a(a.npX, Boolean.valueOf(true));
    }

    public static void dd(boolean z) {
        ak.yW();
        c.vf().a(a.npZ, Boolean.valueOf(z));
        ak.yW();
        c.vf().iB(true);
    }

    public static boolean anJ() {
        ak.yW();
        Object obj = c.vf().get(a.npZ, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void de(boolean z) {
        ak.yW();
        c.vf().a(a.nqa, Boolean.valueOf(z));
    }

    public static boolean anK() {
        ak.yW();
        Object obj = c.vf().get(a.nqa, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void df(boolean z) {
        fTD = z;
    }

    public static boolean anL() {
        return fTD;
    }

    public static boolean anx() {
        return c.anp() && anK() && fTD;
    }

    public static boolean anM() {
        v.i("MicroMsg.FingerPrintUtil", "isShowFPOpenGuide");
        if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgx()) {
            v.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.anp()) {
            v.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgs() || com.tencent.mm.plugin.wallet_core.model.k.bga().bgw()) {
            v.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgz().bgp()) {
            com.tencent.mm.plugin.fingerprint.a.ank();
            com.tencent.mm.plugin.fingerprint.a.anl();
            if (!c.anr() || anH()) {
                return false;
            }
            v.i("MicroMsg.FingerPrintUtil", "will showOpenFingerPrintPayGuide()");
            return true;
        } else {
            v.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static boolean anN() {
        v.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgx()) {
            v.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.anp()) {
            v.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgs() || com.tencent.mm.plugin.wallet_core.model.k.bga().bgw()) {
            v.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgz().bgp()) {
            c cVar = new c();
            if (!c.anr()) {
                boolean booleanValue;
                ak.yW();
                Object obj = c.vf().get(a.npX, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    v.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    return true;
                }
            }
            return false;
        } else {
            v.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static final String bL(Context context) {
        return context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    }

    public static int bM(Context context) {
        InputStream open;
        Throwable e;
        int i;
        InputStream open2;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        int read;
        Throwable e2;
        FileOutputStream fileOutputStream2 = null;
        String bL = bL(context);
        File file = new File(bL);
        if (file.exists()) {
            CharSequence g = g.g(file);
            CharSequence charSequence = "";
            try {
                open = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (open != null) {
                    try {
                        charSequence = g.a(open, 1024);
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            v.a("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e4) {
                                    v.a("MicroMsg.FingerPrintUtil", e4, "", new Object[0]);
                                }
                            }
                            if (!!TextUtils.isEmpty(g)) {
                            }
                            if (!TextUtils.isEmpty(g)) {
                            }
                            i = 1;
                            if (i != 0) {
                                return 0;
                            }
                            try {
                                open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bArr = new byte[1024];
                                        while (true) {
                                            read = open2.read(bArr);
                                            if (read != -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        fileOutputStream.flush();
                                        if (open2 != null) {
                                            try {
                                                open2.close();
                                            } catch (Throwable e22) {
                                                v.a("MicroMsg.FingerPrintUtil", e22, "", new Object[0]);
                                                v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e22.getMessage());
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                            i = 0;
                                        } catch (Throwable e222) {
                                            v.a("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                                            v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e222.getMessage());
                                            i = 0;
                                        }
                                    } catch (Exception e5) {
                                        e222 = e5;
                                        fileOutputStream2 = fileOutputStream;
                                        open = open2;
                                        try {
                                            v.a("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                                            v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e222.getMessage());
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable e2222) {
                                                    v.a("MicroMsg.FingerPrintUtil", e2222, "", new Object[0]);
                                                    v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e2222.getMessage());
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                    i = -1;
                                                } catch (Throwable e22222) {
                                                    v.a("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                                    v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e22222.getMessage());
                                                    i = -1;
                                                }
                                            } else {
                                                i = -1;
                                            }
                                            if (Runtime.getRuntime().exec("chmod 777 " + bL).waitFor() != 0) {
                                                v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                                return i;
                                            }
                                            v.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                            return i;
                                        } catch (Throwable th) {
                                            e22222 = th;
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable e6) {
                                                    v.a("MicroMsg.FingerPrintUtil", e6, "", new Object[0]);
                                                    v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e6.getMessage());
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Throwable e62) {
                                                    v.a("MicroMsg.FingerPrintUtil", e62, "", new Object[0]);
                                                    v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e62.getMessage());
                                                }
                                            }
                                            throw e22222;
                                        }
                                    } catch (Throwable th2) {
                                        e22222 = th2;
                                        fileOutputStream2 = fileOutputStream;
                                        open = open2;
                                        if (open != null) {
                                            open.close();
                                        }
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        throw e22222;
                                    }
                                } catch (Exception e7) {
                                    e22222 = e7;
                                    open = open2;
                                    v.a("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                    v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e22222.getMessage());
                                    if (open != null) {
                                        open.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        i = -1;
                                    } else {
                                        fileOutputStream2.close();
                                        i = -1;
                                    }
                                    if (Runtime.getRuntime().exec("chmod 777 " + bL).waitFor() != 0) {
                                        v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                        return i;
                                    }
                                    v.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                } catch (Throwable th3) {
                                    e22222 = th3;
                                    open = open2;
                                    if (open != null) {
                                        open.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    throw e22222;
                                }
                            } catch (Exception e8) {
                                e22222 = e8;
                                v.a("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                v.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e22222.getMessage());
                                if (open != null) {
                                    open.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                    i = -1;
                                } else {
                                    i = -1;
                                }
                                if (Runtime.getRuntime().exec("chmod 777 " + bL).waitFor() != 0) {
                                    v.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                }
                                v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            }
                            try {
                                if (Runtime.getRuntime().exec("chmod 777 " + bL).waitFor() != 0) {
                                    v.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                }
                                v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            } catch (Exception e9) {
                                v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e9.getMessage());
                                return i;
                            }
                        } catch (Throwable th4) {
                            e22222 = th4;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e622) {
                                    v.a("MicroMsg.FingerPrintUtil", e622, "", new Object[0]);
                                }
                            }
                            throw e22222;
                        }
                    }
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e42) {
                        v.a("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                    }
                }
            } catch (Throwable e6222) {
                e42 = e6222;
                open = null;
                v.a("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                if (open != null) {
                    open.close();
                }
                if (!TextUtils.isEmpty(g)) {
                }
                if (TextUtils.isEmpty(g)) {
                }
                i = 1;
                if (i != 0) {
                    return 0;
                }
                open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1024];
                while (true) {
                    read = open2.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (open2 != null) {
                    open2.close();
                }
                fileOutputStream.close();
                i = 0;
                if (Runtime.getRuntime().exec("chmod 777 " + bL).waitFor() != 0) {
                    v.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                    return i;
                }
                v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i;
            } catch (Throwable th5) {
                e22222 = th5;
                open = null;
                if (open != null) {
                    open.close();
                }
                throw e22222;
            }
            if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(r0) && g.equals(r0)) {
                i = 0;
            } else if (TextUtils.isEmpty(g) || !TextUtils.isEmpty(r0)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
            i = 1;
            open = null;
        }
        if (i != 0) {
            return 0;
        }
        open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
        fileOutputStream = new FileOutputStream(file);
        bArr = new byte[1024];
        while (true) {
            read = open2.read(bArr);
            if (read != -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        if (open2 != null) {
            open2.close();
        }
        fileOutputStream.close();
        i = 0;
        if (Runtime.getRuntime().exec("chmod 777 " + bL).waitFor() != 0) {
            v.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
            return i;
        }
        v.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
        return i;
    }
}
