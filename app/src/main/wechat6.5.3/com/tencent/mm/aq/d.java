package com.tencent.mm.aq;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.aq.c.a;
import com.tencent.mm.aq.c.b;
import com.tencent.mm.c.b.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;

public final class d {
    private static d daz = null;
    public ap cJw = new ap(1, "speex_worker");
    private byte[] ciN = new byte[0];
    private String daA;
    private e daB = new e(this) {
        final /* synthetic */ d daC;

        {
            this.daC = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.daC.daA != null) {
                v.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) kVar).filename + " filepath " + this.daC.daA + " errCode " + i2);
                if (((a) kVar).filename.equals(this.daC.daA)) {
                    ak.vy().b(240, this.daC.daB);
                    if (i2 == 0) {
                        c.JM();
                        c.JO();
                    }
                    try {
                        v.d("MicroMsg.SpeexUploadCore", "delete " + this.daC.daA + " delete " + new File(this.daC.daA).delete() + " errCode " + i2);
                    } catch (Throwable e) {
                        v.e("MicroMsg.SpeexUploadCore", "exception:%s", be.e(e));
                    } finally {
                        d.JU().start();
                        this.daC.daA = null;
                    }
                }
            }
        }
    };

    static /* synthetic */ void b(d dVar) {
        v.d("MicroMsg.SpeexUploadCore", "uploadOneFile");
        synchronized (dVar.ciN) {
            if (dVar.daA != null) {
                v.d("MicroMsg.SpeexUploadCore", "uploading...");
                return;
            }
            a JT = a.JT();
            if (JT != null) {
                Object obj;
                File aQ;
                File file;
                String name;
                b bVar;
                String[] split;
                if (1 != g.i("EnableSpeexVoiceUpload", 0)) {
                    if (JT.JR() == 0) {
                        obj = null;
                    } else if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                        ak.yW();
                        boolean z = JT.bBZ == 0 ? true : JT.bBZ == be.a((Integer) c.vf().get(12290, null), 0);
                        v.d("upload", "fitSex " + JT.bBZ + " " + z + " " + JT.bBZ);
                        if (!z) {
                            obj = null;
                        } else if (!JT.JQ()) {
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        aQ = aQ(JT.das, JT.dat);
                        if (aQ != null) {
                            v.d("MicroMsg.SpeexUploadCore", "no target to upload");
                            return;
                        }
                        try {
                            file = new File(aQ.getPath().replace(".spx", ".uploading"));
                            if (aQ.renameTo(file)) {
                                v.d("MicroMsg.SpeexUploadCore", "delete " + aQ.getPath());
                                aQ.delete();
                                return;
                            }
                            dVar.daA = file.getPath();
                            name = file.getName();
                            v.d("MicroMsg.SpeexUploadCore", "upload file " + dVar.daA);
                            bVar = new b();
                            split = name.substring(0, name.indexOf(46)).split("_");
                            if (split.length == 5) {
                                try {
                                    bVar.cXU = split[0];
                                    bVar.dad = be.getInt(split[1], 0);
                                    bVar.dae = be.getInt(split[2], 0);
                                    bVar.daf = be.getInt(split[3], 0);
                                } catch (NumberFormatException e) {
                                    v.e("upload", "wrong format", e);
                                }
                            }
                            ak.vy().a(240, dVar.daB);
                            ak.vy().a(new a(dVar.daA, c.ks(name), bVar.dad, bVar.dae, bVar.daf), 0);
                            return;
                        } catch (Throwable e2) {
                            v.e("MicroMsg.SpeexUploadCore", "exception:%s", be.e(e2));
                        }
                    }
                }
                int i = 1;
                if (obj != null) {
                    aQ = aQ(JT.das, JT.dat);
                    if (aQ != null) {
                        file = new File(aQ.getPath().replace(".spx", ".uploading"));
                        if (aQ.renameTo(file)) {
                            v.d("MicroMsg.SpeexUploadCore", "delete " + aQ.getPath());
                            aQ.delete();
                            return;
                        }
                        dVar.daA = file.getPath();
                        name = file.getName();
                        v.d("MicroMsg.SpeexUploadCore", "upload file " + dVar.daA);
                        bVar = new b();
                        split = name.substring(0, name.indexOf(46)).split("_");
                        if (split.length == 5) {
                            bVar.cXU = split[0];
                            bVar.dad = be.getInt(split[1], 0);
                            bVar.dae = be.getInt(split[2], 0);
                            bVar.daf = be.getInt(split[3], 0);
                        }
                        ak.vy().a(240, dVar.daB);
                        ak.vy().a(new a(dVar.daA, c.ks(name), bVar.dad, bVar.dae, bVar.daf), 0);
                        return;
                    }
                    v.d("MicroMsg.SpeexUploadCore", "no target to upload");
                    return;
                }
            }
            v.d("MicroMsg.SpeexUploadCore", "SpeexConfig not allow");
        }
    }

    public static d JU() {
        if (daz == null) {
            daz = new d();
        }
        return daz;
    }

    public final void b(ap.a aVar) {
        v.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.cJw.c(aVar);
    }

    public final void start() {
        if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
            new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ d daC;

                {
                    this.daC = r1;
                }

                public final void run() {
                    Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                        final /* synthetic */ AnonymousClass2 daD;

                        {
                            this.daD = r1;
                        }

                        public final boolean queueIdle() {
                            this.daD.daC.b(new ap.a(this) {
                                final /* synthetic */ AnonymousClass1 daE;

                                {
                                    this.daE = r1;
                                }

                                public final boolean AZ() {
                                    return true;
                                }

                                public final boolean Ba() {
                                    d.b(this.daE.daD.daC);
                                    return false;
                                }
                            });
                            return false;
                        }
                    });
                }
            }, 100);
        }
    }

    private static File aQ(int i, int i2) {
        ak.yW();
        File file = new File(c.wX());
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        int i3 = 0;
        file = null;
        while (listFiles != null && i3 < listFiles.length) {
            file = listFiles[i3];
            if (file != null && file.isFile()) {
                v.d("MicroMsg.SpeexUploadCore", "file " + file.getPath());
                String path = file.getPath();
                long length = file.length();
                if (!file.getName().endsWith(".spx")) {
                    file = null;
                } else if (length >= ((long) i) && length <= ((long) i2)) {
                    return file;
                } else {
                    v.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", path, Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.mm.loader.stub.b.deleteFile(path);
                    file = null;
                }
            }
            i3++;
        }
        return file;
    }
}
