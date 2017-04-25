package com.tencent.mm.an;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class c {
    private static c cUI;
    private ap cUJ = null;

    public interface a {
        void bd(boolean z);
    }

    class b implements com.tencent.mm.sdk.platformtools.ap.a {
        private boolean aZz = false;
        private String cPu;
        private String cUK;
        private a cUL;
        final /* synthetic */ c cUM;
        private String username;

        public b(c cVar, String str, String str2, a aVar) {
            this.cUM = cVar;
            this.username = str;
            this.cUK = str2;
            this.cUL = aVar;
        }

        public final boolean AZ() {
            t a;
            Throwable e;
            t tVar;
            OutputStream outputStream;
            InputStream inputStream = null;
            if (be.kS(this.username)) {
                return false;
            }
            this.cPu = c.jw(this.username);
            String str = SQLiteDatabase.KeyEmpty;
            if (ak.uz()) {
                r4 = new Object[4];
                ak.yW();
                r4[1] = o.getString(com.tencent.mm.model.c.ww());
                r4[2] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getNetTypeForStat(aa.getContext()));
                r4[3] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getStrength(aa.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r4);
            }
            v.d("MicroMsg.RemarkImageStorage", "get remark image user: %s referer: %s  url:%s", this.username, str, this.cUK);
            this.aZz = false;
            try {
                a = com.tencent.mm.network.b.a(this.cUK, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        v.e("MicroMsg.RemarkImageStorage", "checkHttpConnection failed! url:%s", this.cUK);
                        try {
                            a.dmc.disconnect();
                        } catch (Throwable e2) {
                            v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e2));
                        }
                        return true;
                    }
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            v.d("MicroMsg.RemarkImageStorage", "getInputStream failed. url:%s", this.cUK);
                            try {
                                a.dmc.disconnect();
                            } catch (Throwable e22) {
                                v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e22));
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable e222) {
                                    v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e222));
                                }
                            }
                            return true;
                        } catch (Exception e3) {
                            e222 = e3;
                            tVar = a;
                            inputStream = inputStream2;
                            Object obj = null;
                            try {
                                v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e222));
                                this.aZz = false;
                                if (tVar != null) {
                                    try {
                                        tVar.dmc.disconnect();
                                    } catch (Throwable e2222) {
                                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e2222));
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e22222) {
                                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e22222));
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e222222) {
                                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e222222));
                                    }
                                }
                                return true;
                            } catch (Throwable th) {
                                e222222 = th;
                                a = tVar;
                                if (a != null) {
                                    try {
                                        a.dmc.disconnect();
                                    } catch (Throwable e4) {
                                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e4));
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e5) {
                                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e5));
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e52) {
                                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e52));
                                    }
                                }
                                throw e222222;
                            }
                        } catch (Throwable th2) {
                            e222222 = th2;
                            InputStream inputStream3 = inputStream2;
                            outputStream = null;
                            inputStream = inputStream3;
                            if (a != null) {
                                a.dmc.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            throw e222222;
                        }
                    }
                    byte[] bArr = new byte[1024];
                    OutputStream fileOutputStream = new FileOutputStream(this.cPu + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception e6) {
                            e222222 = e6;
                            inputStream = inputStream2;
                            outputStream = fileOutputStream;
                            tVar = a;
                        } catch (Throwable th3) {
                            e222222 = th3;
                            inputStream = inputStream2;
                            outputStream = fileOutputStream;
                        }
                    }
                    this.aZz = true;
                    try {
                        a.dmc.disconnect();
                    } catch (Throwable e2222222) {
                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e2222222));
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e22222222) {
                            v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e22222222));
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e222222222) {
                        v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e222222222));
                    }
                    return true;
                } catch (Exception e7) {
                    e222222222 = e7;
                    outputStream = null;
                    tVar = a;
                    v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e222222222));
                    this.aZz = false;
                    if (tVar != null) {
                        tVar.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                } catch (Throwable th4) {
                    e222222222 = th4;
                    outputStream = null;
                    if (a != null) {
                        a.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw e222222222;
                }
            } catch (Exception e8) {
                e222222222 = e8;
                outputStream = null;
                tVar = null;
                v.e("MicroMsg.RemarkImageStorage", "exception:%s", be.e(e222222222));
                this.aZz = false;
                if (tVar != null) {
                    tVar.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return true;
            } catch (Throwable th5) {
                e222222222 = th5;
                outputStream = null;
                a = null;
                if (a != null) {
                    a.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e222222222;
            }
        }

        public final boolean Ba() {
            if (this.aZz) {
                com.tencent.mm.loader.stub.b.deleteFile(this.cPu);
                new File(this.cPu + ".tmp").renameTo(new File(this.cPu));
                this.cUL.bd(true);
                return true;
            }
            this.cUL.bd(false);
            return false;
        }
    }

    public static c HV() {
        if (cUI == null) {
            cUI = new c();
        }
        return cUI;
    }

    private c() {
    }

    public static String jw(String str) {
        if (be.kS(str)) {
            return null;
        }
        ak.yW();
        return h.b(com.tencent.mm.model.c.wS(), "remark_", g.m((str + "ZnVjaw==").getBytes()), ".png", 1);
    }

    public static boolean jx(String str) {
        v.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, jw(str));
        return new File(jw(str)).exists();
    }

    public static boolean jy(String str) {
        v.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, jw(str));
        return com.tencent.mm.loader.stub.b.deleteFile(jw(str));
    }

    public final Bitmap jz(String str) {
        int i = 0;
        Bitmap H = d.H(jw(str), 0, 0);
        if (!(H == null || H.isRecycled())) {
            i = 1;
        }
        return i != 0 ? H : null;
    }

    public final void a(String str, String str2, a aVar) {
        if (!be.kS(str2) && !jx(str)) {
            if (this.cUJ == null || this.cUJ.btK()) {
                this.cUJ = new ap(1, "download-remark-img", 1);
            }
            this.cUJ.c(new b(this, str, str2, aVar));
        }
    }
}
