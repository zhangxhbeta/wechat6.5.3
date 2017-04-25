package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    private String aQp;
    private boolean cRi = false;
    private int knN = 0;
    private com.tencent.mm.sandbox.b.a nfM;
    private String[] nfS;
    private a nfT = null;
    private boolean nfU = false;
    private String nfV;
    private ac nfW = new ac(this) {
        final /* synthetic */ c nfY;

        {
            this.nfY = r1;
        }

        public final void handleMessage(Message message) {
            if (1 == message.what && !this.nfY.cRi) {
                new File(this.nfY.aAF()).delete();
                if (message.arg1 == 0) {
                    v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                    this.nfY.nfM.a(200, 0, (aqx) message.obj);
                } else if (message.arg1 == 3) {
                    this.nfY.nfM.a(3, -1, (aqx) message.obj);
                } else if (message.arg1 == 4) {
                    this.nfY.nfM.a(4, -1, (aqx) message.obj);
                }
            }
            super.handleMessage(message);
        }
    };
    private com.tencent.mm.sandbox.b.a nfX = new com.tencent.mm.sandbox.b.a(this) {
        final /* synthetic */ c nfY;

        {
            this.nfY = r1;
        }

        public final void bY(int i, int i2) {
            v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
            this.nfY.nfM.bY(i, i2);
        }

        public final void a(int i, int i2, aqx com_tencent_mm_protocal_c_aqx) {
            if (i != 0) {
                v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + i);
                if (i == -2) {
                    new File(this.nfY.aAF()).delete();
                }
                this.nfY.knN = this.nfY.knN + 1;
                this.nfY.a(this.nfY.nfM);
                return;
            }
            v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
            try {
                if (e.aQ(this.nfY.aAF()) < this.nfY.nfq) {
                    v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                    this.nfY.a(this.nfY.nfM);
                } else if (this.nfY.nfU) {
                    if (this.nfY.aQp.equalsIgnoreCase(g.aX(this.nfY.aAF()))) {
                        c.a(this.nfY, com_tencent_mm_protocal_c_aqx);
                        return;
                    }
                    v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                    new File(this.nfY.aAF()).delete();
                    this.nfY.nfM.a(2, -1, com_tencent_mm_protocal_c_aqx);
                } else if (this.nfY.nfs.equalsIgnoreCase(g.aX(this.nfY.aAF()))) {
                    e.h(com.tencent.mm.sandbox.monitor.c.nfo, this.nfY.nfs + ".temp", this.nfY.nfs + ".apk");
                    this.nfY.nfM.a(200, 0, com_tencent_mm_protocal_c_aqx);
                } else {
                    v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                    new File(this.nfY.aAF()).delete();
                    this.nfY.nfM.a(-1, -1, com_tencent_mm_protocal_c_aqx);
                }
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
                v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                this.nfY.nfM.a(-1, -1, com_tencent_mm_protocal_c_aqx);
            }
        }

        public final void dW(long j) {
            this.nfY.nfM.dW(j);
        }

        public final void dX(long j) {
            this.nfY.nfM.dX(j);
        }
    };

    private class a extends AsyncTask<String, Integer, Integer> {
        private int aNr;
        private HttpClient iaD = null;
        private com.tencent.mm.sandbox.b.a nfM;
        final /* synthetic */ c nfY;
        private HttpPost nga = null;
        private HttpResponse ngb = null;
        private HttpEntity ngc = null;
        private OutputStream ngd = new OutputStream(this) {
            private ac handler = new ac(Looper.getMainLooper());
            private ByteArrayOutputStream nge = new ByteArrayOutputStream();
            final /* synthetic */ a ngf;

            {
                this.ngf = r3;
            }

            public final void write(byte[] bArr, int i, int i2) {
                this.nge.write(bArr, i, i2);
                if (this.nge.size() >= 131072 || this.ngf.aNr + this.nge.size() >= this.ngf.size) {
                    final int size = this.nge.size();
                    int a = e.a(this.ngf.nfY.aAF(), this.nge.toByteArray(), size);
                    this.nge.reset();
                    if (a != 0) {
                        throw new IOException("appendToFile failed :" + a);
                    }
                    a.a(this.ngf, size);
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 ngh;

                        public final void run() {
                            if (this.ngh.ngf.aNr <= this.ngh.ngf.size) {
                                this.ngh.ngf.nfM.bY(this.ngh.ngf.size, this.ngh.ngf.aNr);
                            }
                            this.ngh.ngf.nfM.dX((long) size);
                        }
                    });
                    if (this.ngf.nfY.cRi) {
                        throw new IOException("manual force cancel!");
                    }
                }
            }

            public final void write(int i) {
                throw new IOException("unexpected operation");
            }
        };
        private int size;

        static /* synthetic */ int a(a aVar, int i) {
            int i2 = aVar.aNr + i;
            aVar.aNr = i2;
            return i2;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return C((String[]) objArr);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            this.nfM.a(((Integer) obj).intValue(), 0, null);
        }

        public a(c cVar, int i, int i2, com.tencent.mm.sandbox.b.a aVar) {
            this.nfY = cVar;
            this.size = i;
            this.aNr = i2;
            this.nfM = aVar;
        }

        private Integer C(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                return Integer.valueOf(-1);
            }
            v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.aNr);
            this.iaD = new DefaultHttpClient();
            this.iaD.getParams().setIntParameter("http.connection.timeout", 15000);
            this.nga = new HttpPost(str);
            this.nga.addHeader("RANGE", "bytes=" + this.aNr + "-" + (this.size - this.aNr > 1048576 ? Integer.valueOf((this.aNr + 1048576) - 1) : SQLiteDatabase.KeyEmpty));
            this.nfM.dW(50);
            this.ngb = this.iaD.execute(this.nga);
            int statusCode = this.ngb.getStatusLine().getStatusCode();
            Integer valueOf;
            if (statusCode == 200 || statusCode == 206) {
                try {
                    if (this.nfY.nfU && q.dpY && Math.random() > 0.2d) {
                        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                        valueOf = Integer.valueOf(-1);
                        if (this.nga != null) {
                            this.nga.abort();
                        }
                        if (this.ngc != null) {
                            try {
                                this.ngc.consumeContent();
                            } catch (Throwable e) {
                                v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        if (this.iaD == null) {
                            return valueOf;
                        }
                        this.iaD.getConnectionManager().shutdown();
                        return valueOf;
                    }
                    this.ngb.getHeaders("Content-Length");
                    if (this.aNr > this.size) {
                        v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                        valueOf = Integer.valueOf(-2);
                        if (this.nga != null) {
                            this.nga.abort();
                        }
                        if (this.ngc != null) {
                            try {
                                this.ngc.consumeContent();
                            } catch (Throwable e2) {
                                v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                        if (this.iaD == null) {
                            return valueOf;
                        }
                        this.iaD.getConnectionManager().shutdown();
                        return valueOf;
                    }
                    this.ngc = this.ngb.getEntity();
                    this.ngc.writeTo(this.ngd);
                    this.ngc.consumeContent();
                    valueOf = Integer.valueOf(0);
                    if (this.nga != null) {
                        this.nga.abort();
                    }
                    if (this.ngc != null) {
                        try {
                            this.ngc.consumeContent();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    if (this.iaD == null) {
                        return valueOf;
                    }
                    this.iaD.getConnectionManager().shutdown();
                    return valueOf;
                } catch (Throwable e3) {
                    v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                    if (this.nga != null) {
                        this.nga.abort();
                    }
                    if (this.ngc != null) {
                        try {
                            this.ngc.consumeContent();
                        } catch (Throwable e32) {
                            v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    if (this.iaD != null) {
                        this.iaD.getConnectionManager().shutdown();
                    }
                    return Integer.valueOf(-1);
                } catch (Throwable th) {
                    if (this.nga != null) {
                        this.nga.abort();
                    }
                    if (this.ngc != null) {
                        try {
                            this.ngc.consumeContent();
                        } catch (Throwable e222) {
                            v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    if (this.iaD != null) {
                        this.iaD.getConnectionManager().shutdown();
                    }
                }
            } else {
                v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + statusCode);
                if (statusCode == 416) {
                    valueOf = Integer.valueOf(-2);
                    if (this.nga != null) {
                        this.nga.abort();
                    }
                    if (this.ngc != null) {
                        try {
                            this.ngc.consumeContent();
                        } catch (Throwable e2222) {
                            v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    if (this.iaD == null) {
                        return valueOf;
                    }
                    this.iaD.getConnectionManager().shutdown();
                    return valueOf;
                }
                valueOf = Integer.valueOf(-1);
                if (this.nga != null) {
                    this.nga.abort();
                }
                if (this.ngc != null) {
                    try {
                        this.ngc.consumeContent();
                    } catch (Throwable e22222) {
                        v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                if (this.iaD == null) {
                    return valueOf;
                }
                this.iaD.getConnectionManager().shutdown();
                return valueOf;
            }
        }

        protected final void onCancelled() {
            v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
            if (this.nga != null) {
                this.nga.abort();
            }
            if (this.ngc != null) {
                try {
                    this.ngc.consumeContent();
                } catch (Throwable e) {
                    v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            if (this.iaD != null) {
                v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
                this.iaD.getConnectionManager().shutdown();
            }
        }
    }

    static /* synthetic */ void a(c cVar, final aqx com_tencent_mm_protocal_c_aqx) {
        try {
            v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            com.tencent.mm.sdk.i.e.a(new Runnable(cVar) {
                final /* synthetic */ c nfY;

                public final void run() {
                    v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = com_tencent_mm_protocal_c_aqx;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    int e = h.e(aa.getContext(), this.nfY.aAF(), this.nfY.bsf(), this.nfY.nfV);
                    v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
                    if (e == 0) {
                        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
                        obtain.arg1 = 0;
                        this.nfY.nfW.sendMessage(obtain);
                        return;
                    }
                    v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
                    File file = new File(this.nfY.bsf());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (e == -1) {
                        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
                        obtain.arg1 = 3;
                        this.nfY.nfW.sendMessage(obtain);
                    } else if (e == -2) {
                        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
                        obtain.arg1 = 4;
                        this.nfY.nfW.sendMessage(obtain);
                    }
                }
            }, "NetSceneGetUpdatePackFromCDN_genApk");
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            v.a("MicroMsg.NetSceneGetUpdatePackFromCDN", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = com_tencent_mm_protocal_c_aqx;
            cVar.nfW.sendMessage(obtain);
        }
    }

    public c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.nfS = strArr;
    }

    public c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        this.nfS = new String[]{str2};
        this.nfU = true;
        this.aQp = str3;
        this.nfV = str4;
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        this.nfM = aVar;
        if (!h.getExternalStorageState().equals("mounted")) {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.a(-1, -1, null);
        } else if (this.cRi) {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.a(-1, -1, null);
        } else if (bsg() || bsn() >= this.nfS.length) {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.nfS.length);
            if (this.nfU) {
                aVar.a(1, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        } else if (f.G((long) this.nfq)) {
            this.nfT = new a(this, this.nfq, e.aQ(aAF()), this.nfX);
            this.nfT.execute(new String[]{this.nfS[bsn()]});
        } else {
            v.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.nfU) {
                aVar.a(13, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        }
    }

    protected final String aAF() {
        if (this.nfU) {
            return nfo + this.aQp + ".temp";
        }
        return super.aAF();
    }

    public final String bsf() {
        if (this.nfU) {
            return nfo + this.nfV + ".apk";
        }
        return nfo + this.nfs + ".apk";
    }

    public final void cancel() {
        v.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.cRi = true;
        if (this.nfT != null && !this.nfT.isCancelled()) {
            this.nfT.cancel(true);
        }
    }

    private int bsn() {
        v.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.knN + ", curLinkIdx = " + (this.knN / 5));
        return this.knN / 5;
    }
}
