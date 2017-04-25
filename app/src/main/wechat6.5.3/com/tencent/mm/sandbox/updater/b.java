package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.zw;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public final class b extends c {
    private byte[] cAN;
    private byte[] dlf;
    private byte[] dlh;
    private int nfI = 0;
    private final int nfJ = 5;
    private int nfK = 0;
    private String[] nfL;
    private com.tencent.mm.sandbox.b.a nfM;
    private a nfN = null;
    private com.tencent.mm.sandbox.b.a nfO = new com.tencent.mm.sandbox.b.a(this) {
        final /* synthetic */ b nfP;

        {
            this.nfP = r1;
        }

        public final void a(int i, int i2, aqx com_tencent_mm_protocal_c_aqx) {
            if (i == 200 && i2 == 0 && (com_tencent_mm_protocal_c_aqx == null || com_tencent_mm_protocal_c_aqx.mQl.mcj == 0)) {
                zx zxVar = (zx) com_tencent_mm_protocal_c_aqx;
                v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + e.cni);
                v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + zxVar.mdz);
                v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + zxVar.mdA);
                v.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + zxVar.mdB);
                if (zxVar.mdB <= 0 || zxVar.mfg == null) {
                    v.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                    this.nfP.nfM.a(i, -1, null);
                } else if (zxVar.mfg.mQu != zxVar.mdB) {
                    v.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + zxVar.mdB + " data buf len = " + zxVar.mfg.mQu);
                    this.nfP.nfM.a(4, -1, null);
                } else if (zxVar.mdA < 0 || zxVar.mdA + zxVar.mdB > zxVar.mdz) {
                    v.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + zxVar.mdA + " dataLen = " + zxVar.mdB + " totalLen = " + zxVar.mdz);
                    this.nfP.nfM.a(4, -1, null);
                } else if (zxVar.mdz <= 0) {
                    v.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + zxVar.mdz);
                    this.nfP.nfM.a(4, -1, null);
                } else {
                    int a = com.tencent.mm.a.e.a(c.nfo, this.nfP.nfs, ".temp", zxVar.mfg.mQw.toByteArray());
                    if (a != 0) {
                        v.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : " + a);
                        this.nfP.nfM.a(4, -1, null);
                        return;
                    }
                    this.nfP.nfr = zxVar.mdB + zxVar.mdA;
                    this.nfP.nfq = zxVar.mdz;
                    this.nfP.nfM.bY(zxVar.mdz, zxVar.mdA);
                    if (zxVar.mdA + zxVar.mdB >= zxVar.mdz) {
                        try {
                            if (this.nfP.nfs.equalsIgnoreCase(g.aX(this.nfP.aAF()))) {
                                com.tencent.mm.a.e.h(c.nfo, this.nfP.nfs + ".temp", this.nfP.nfs + ".apk");
                                this.nfP.nfM.a(200, 0, com_tencent_mm_protocal_c_aqx);
                                return;
                            }
                            v.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                            new File(this.nfP.aAF()).delete();
                            this.nfP.nfM.a(-1, -1, com_tencent_mm_protocal_c_aqx);
                            return;
                        } catch (Throwable e) {
                            v.a("MicroMsg.NetSceneGetUpdatePack", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return;
                        }
                    }
                    this.nfP.a(this.nfP.nfM);
                }
            } else if (this.nfP.bsg() || b.a(this.nfP) >= this.nfP.nfL.length * 5) {
                this.nfP.nfM.a(i, i2, com_tencent_mm_protocal_c_aqx);
            } else {
                this.nfP.a(this.nfP.nfM);
            }
        }

        public final void dW(long j) {
            this.nfP.nfM.dW(j);
        }

        public final void dX(long j) {
            this.nfP.nfM.dX(j);
        }

        public final void bY(int i, int i2) {
        }
    };
    private int uin;

    private class a extends AsyncTask<zw, Integer, zx> {
        private String host = null;
        private t ick = null;
        private com.tencent.mm.sandbox.b.a nfM = null;
        final /* synthetic */ b nfP;
        private int nfQ = 200;
        private PInt nfR = new PInt();

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((zw[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            zx zxVar = (zx) obj;
            v.d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.nfQ + ", svrRet=" + this.nfR.value + ", result=" + zxVar);
            this.nfM.a(this.nfQ, this.nfR.value, zxVar);
        }

        public a(b bVar, String str, com.tencent.mm.sandbox.b.a aVar) {
            this.nfP = bVar;
            this.host = str;
            this.nfM = aVar;
        }

        private zx a(zw... zwVarArr) {
            Throwable e;
            InputStream inputStream;
            InputStream inputStream2;
            OutputStream outputStream;
            if (zwVarArr.length == 0 || zwVarArr[0] == null) {
                this.nfQ = -1;
                return null;
            }
            v.d("MicroMsg.NetSceneGetUpdatePack", "doInBackground, params=" + zwVarArr[0]);
            zw zwVar = zwVarArr[0];
            PByteArray pByteArray = new PByteArray();
            try {
                MMProtocalJni.pack(zwVar.toByteArray(), pByteArray, this.nfP.dlf, this.nfP.cAN, p.rK(), this.nfP.uin, MMGIFException.D_GIF_ERR_EOF_TOO_SOON, 0, new byte[0], new byte[0], this.nfP.dlh, com.tencent.mm.sdk.b.b.foreground);
                OutputStream outputStream2 = null;
                InputStream inputStream3 = null;
                try {
                    this.ick = com.tencent.mm.network.b.a("http://" + this.host + "/cgi-bin/micromsg-bin/getupdatepack", null);
                    this.ick.setRequestMethod("POST");
                    this.ick.Mj();
                    this.ick.Mk();
                    this.ick.setUseCaches(false);
                    this.ick.setRequestProperty("User-Agent", "Android QQMail HTTP Client");
                    this.ick.setRequestProperty("Connection", "Keep-Alive");
                    this.ick.setRequestProperty("Cache-Control", "no-cache");
                    this.ick.setRequestProperty("Content-Type", "application/octet-stream");
                    this.ick.setRequestProperty("accept", "*/*");
                    this.ick.setRequestProperty("Accept-Charset", "UTF-8");
                    this.ick.setConnectTimeout(15000);
                    this.ick.connect();
                    OutputStream outputStream3 = this.ick.getOutputStream();
                    try {
                        outputStream3.write(pByteArray.value);
                        outputStream3.flush();
                        this.nfM.dW(150 + ((long) pByteArray.value.length));
                        this.nfQ = this.ick.getResponseCode();
                        if (this.nfQ != 200) {
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (Throwable e2) {
                                    v.a("MicroMsg.NetSceneGetUpdatePack", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            if (this.ick != null) {
                                this.ick.dmc.disconnect();
                                this.ick = null;
                            }
                            return null;
                        }
                        Object obj;
                        String headerField = this.ick.getHeaderField("Content-Encoding");
                        InputStream inputStream4 = this.ick.getInputStream();
                        long j = 150;
                        if (headerField == null || !headerField.contains("gzip")) {
                            obj = null;
                            inputStream = inputStream4;
                        } else {
                            inputStream = new GZIPInputStream(inputStream4);
                            obj = 1;
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                j += (long) read;
                            }
                            if (obj == null || !inputStream4.markSupported()) {
                                this.nfM.dX(j);
                            } else {
                                inputStream4.mark(1);
                                j = 150;
                                while (true) {
                                    int read2 = inputStream4.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    j += (long) read2;
                                }
                                this.nfM.dX(j);
                            }
                            PByteArray pByteArray2 = new PByteArray();
                            MMProtocalJni.unpack(pByteArray2, byteArrayOutputStream.toByteArray(), this.nfP.dlf, new PByteArray(), this.nfR, new PInt());
                            zx zxVar = (zx) new zx().az(pByteArray2.value);
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (Throwable e3) {
                                    v.a("MicroMsg.NetSceneGetUpdatePack", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e32) {
                                    v.a("MicroMsg.NetSceneGetUpdatePack", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            if (this.ick == null) {
                                return zxVar;
                            }
                            this.ick.dmc.disconnect();
                            this.ick = null;
                            return zxVar;
                        } catch (Exception e4) {
                            e2 = e4;
                            inputStream2 = inputStream;
                            outputStream = outputStream3;
                            try {
                                v.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e2.getMessage());
                                v.a("MicroMsg.NetSceneGetUpdatePack", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                this.nfQ = -1;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e22) {
                                        v.a("MicroMsg.NetSceneGetUpdatePack", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable e222) {
                                        v.a("MicroMsg.NetSceneGetUpdatePack", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                                if (this.ick != null) {
                                    this.ick.dmc.disconnect();
                                    this.ick = null;
                                }
                                return null;
                            } catch (Throwable th) {
                                e222 = th;
                                outputStream2 = outputStream;
                                inputStream3 = inputStream2;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Throwable e322) {
                                        v.a("MicroMsg.NetSceneGetUpdatePack", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable e3222) {
                                        v.a("MicroMsg.NetSceneGetUpdatePack", e3222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                                if (this.ick != null) {
                                    this.ick.dmc.disconnect();
                                    this.ick = null;
                                }
                                throw e222;
                            }
                        } catch (Throwable th2) {
                            e222 = th2;
                            inputStream3 = inputStream;
                            outputStream2 = outputStream3;
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            if (this.ick != null) {
                                this.ick.dmc.disconnect();
                                this.ick = null;
                            }
                            throw e222;
                        }
                    } catch (Exception e5) {
                        e222 = e5;
                        inputStream2 = null;
                        outputStream = outputStream3;
                        v.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e222.getMessage());
                        v.a("MicroMsg.NetSceneGetUpdatePack", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        this.nfQ = -1;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (this.ick != null) {
                            this.ick.dmc.disconnect();
                            this.ick = null;
                        }
                        return null;
                    } catch (Throwable th3) {
                        e222 = th3;
                        outputStream2 = outputStream3;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (this.ick != null) {
                            this.ick.dmc.disconnect();
                            this.ick = null;
                        }
                        throw e222;
                    }
                } catch (Exception e6) {
                    e222 = e6;
                    inputStream2 = null;
                    outputStream = null;
                    v.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e222.getMessage());
                    v.a("MicroMsg.NetSceneGetUpdatePack", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    this.nfQ = -1;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (this.ick != null) {
                        this.ick.dmc.disconnect();
                        this.ick = null;
                    }
                    return null;
                } catch (Throwable th4) {
                    e222 = th4;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (this.ick != null) {
                        this.ick.dmc.disconnect();
                        this.ick = null;
                    }
                    throw e222;
                }
            } catch (Throwable e2222) {
                v.e("MicroMsg.NetSceneGetUpdatePack", "Exception in MMProtocalJni.pack(), [%s]", e2222.getMessage());
                v.a("MicroMsg.NetSceneGetUpdatePack", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                return null;
            }
        }

        protected final void onCancelled() {
            v.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
            if (this.ick != null) {
                this.ick.dmc.disconnect();
            }
        }
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.nfK + 1;
        bVar.nfK = i;
        return i;
    }

    public b(int i, String str, int i2, int i3, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.nfL = strArr;
        if (strArr == null || strArr.length == 0) {
            this.nfL = new String[]{"short.weixin.qq.com"};
        }
        this.uin = i3;
        this.dlf = bArr;
        this.cAN = bArr2;
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        this.nfM = aVar;
        int i = this.nfI + 1;
        this.nfI = i;
        if (i > 1000) {
            v.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.nfM.a(-1, -1, null);
        } else if (f.G((long) this.nfq)) {
            aqp zwVar = new zw();
            en enVar = new en();
            enVar.mfB = d.lWh;
            enVar.mfA = com.tencent.mm.ba.b.aT(p.rK().getBytes()).uz(16);
            enVar.mfC = com.tencent.mm.ba.b.aT(d.cmW.getBytes()).uz(132);
            enVar.maG = 0;
            enVar.mfz = com.tencent.mm.ba.b.aT(this.dlf).uz(36);
            enVar.fvo = this.uin;
            zwVar.mPU = enVar;
            zwVar.mBi = this.nfp;
            zwVar.mdA = this.nfr;
            zwVar.mdz = this.nfq;
            a aVar2 = new a(this, this.nfL[this.nfK / 5], this.nfO);
            this.nfN = aVar2;
            aVar2.execute(new zw[]{zwVar});
        } else {
            v.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", Integer.valueOf(this.nfq));
            aVar.a(-1, -1, null);
        }
    }

    public final void cancel() {
        v.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.nfp);
        if (this.nfN != null && !this.nfN.isCancelled()) {
            this.nfN.cancel(true);
        }
    }
}
