package com.tencent.mm.plugin.hp.a;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ha;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.b;
import com.tencent.mm.network.t;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.InputStream;
import java.io.OutputStream;

public final class a extends c<ha> implements com.tencent.mm.sdk.i.c {
    private static final String cQh = (e.cng + "_temp.hp");
    private a gDX = null;

    private static class a implements Runnable {
        private String aZy;
        private boolean cyo = true;
        private String dpj;
        private String url;

        public a(String str, String str2, String str3) {
            this.url = str;
            this.dpj = str2;
            this.aZy = str3;
        }

        public final void run() {
            Throwable e;
            t tVar;
            OutputStream outputStream;
            InputStream inputStream = null;
            try {
                t a = b.a(this.url, null);
                try {
                    a.setRequestMethod("GET");
                    a.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                    a.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                    if (b.a(a) != 0) {
                        v.e("Tinker.HotPatchApplyService", "checkHttpConnection failed! url:%s", new Object[]{this.url});
                        return;
                    }
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            v.d("Tinker.HotPatchApplyService", "getInputStream failed. url:%s", new Object[]{this.url});
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            tVar = a;
                            inputStream = inputStream2;
                            outputStream = null;
                            v.e("Tinker.HotPatchApplyService", "exception:%s", new Object[]{be.e(e)});
                            this.cyo = true;
                            if (tVar != null) {
                                try {
                                    tVar.dmc.disconnect();
                                } catch (Throwable e3) {
                                    v.e("Tinker.HotPatchApplyService", "exception:%s", new Object[]{be.e(e3)});
                                    v.e("Tinker.HotPatchApplyService", "close conn failed : %s", new Object[]{e3.getMessage()});
                                    return;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        }
                    }
                    byte[] bArr = new byte[1024];
                    OutputStream gt = FileOp.gt(this.dpj);
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            gt.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e3 = e4;
                            inputStream = inputStream2;
                            outputStream = gt;
                            tVar = a;
                        }
                    }
                    this.cyo = false;
                    gt.close();
                    a.dmc.disconnect();
                    try {
                        inputStream2.close();
                        if (!g.aX(this.dpj).equalsIgnoreCase(this.aZy)) {
                            v.d("Tinker.HotPatchApplyService", "hp_apply md5 mismatched, ignored");
                            this.cyo = true;
                        }
                        outputStream = null;
                        tVar = null;
                    } catch (Exception e5) {
                        e3 = e5;
                        tVar = null;
                        inputStream = inputStream2;
                        Object obj = null;
                        v.e("Tinker.HotPatchApplyService", "exception:%s", new Object[]{be.e(e3)});
                        this.cyo = true;
                        if (tVar != null) {
                            tVar.dmc.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    }
                    if (tVar != null) {
                        tVar.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Exception e6) {
                    e3 = e6;
                    outputStream = null;
                    tVar = a;
                    v.e("Tinker.HotPatchApplyService", "exception:%s", new Object[]{be.e(e3)});
                    this.cyo = true;
                    if (tVar != null) {
                        tVar.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            } catch (Exception e7) {
                e3 = e7;
                outputStream = null;
                tVar = null;
                v.e("Tinker.HotPatchApplyService", "exception:%s", new Object[]{be.e(e3)});
                this.cyo = true;
                if (tVar != null) {
                    tVar.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }

    public a() {
        com.tencent.mm.sdk.i.e.a(this);
        this.nhz = ha.class.getName().hashCode();
    }

    public static void uD(String str) {
        v.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[]{str});
        com.tencent.mm.plugin.hp.tinker.c.uF(str);
    }

    public final void p(Runnable runnable) {
        if (runnable == this.gDX) {
            v.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[]{this.gDX.url, this.gDX.dpj, Boolean.valueOf(this.gDX.cyo)});
            if (this.gDX.cyo) {
                b.atA();
            } else {
                b.dv(true);
                uD(this.gDX.dpj);
            }
            this.gDX = null;
        }
    }

    private boolean a(ha haVar) {
        if (this.gDX != null) {
            v.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
        } else if (1 == haVar.bgH.aYt) {
            com.tencent.mm.plugin.hp.tinker.c.atH();
        } else if (haVar.bgH.bgM != null) {
            uD(haVar.bgH.bgM);
        } else {
            b.du(true);
            if (haVar.bgH.bgK != null) {
                try {
                    byte[] decode = Base64.decode(haVar.bgH.bgK, 0);
                    haVar.bgH.bgK = new String(decode);
                } catch (Error e) {
                }
            }
            if (!be.kS(haVar.bgH.bgK) && !be.kS(haVar.bgH.bgL)) {
                v.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[]{haVar.bgH.bgK, haVar.bgH.bgL});
                this.gDX = new a(haVar.bgH.bgK, cQh, haVar.bgH.bgL);
            } else if (!be.kS(haVar.bgH.bgI)) {
                if (be.kS(haVar.bgH.bgJ)) {
                }
            }
            com.tencent.mm.sdk.i.e.a(this.gDX, "hp_apply_download");
        }
        return false;
    }
}
