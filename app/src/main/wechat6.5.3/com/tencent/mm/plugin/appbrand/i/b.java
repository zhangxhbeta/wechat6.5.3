package com.tencent.mm.plugin.appbrand.i;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.gw;
import com.tencent.mm.e.a.rh;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public class b {
    private static b dPV;
    private a dPW = new a();
    public c dPX = new c<ar>(this) {
        final /* synthetic */ b dPZ;

        {
            this.dPZ = r2;
            this.nhz = ar.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ar arVar = (ar) bVar;
            if (arVar.aYn.aYo == 40 && arVar.aYn.aYp == 1) {
                File file = new File(arVar.aYn.filePath);
                if (file.exists()) {
                    v.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(c.Ii(), "temp");
                    File file3 = new File(file2, "wxa_fts_template.zip");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    e.p(file.getAbsolutePath(), file3.getAbsolutePath());
                    int dB = be.dB(file3.getAbsolutePath(), file2.getAbsolutePath());
                    int i = 65300001;
                    if (dB >= 0) {
                        i = Integer.valueOf(c.o(new File(file2, "config.conf")).getProperty("version", "0")).intValue();
                    }
                    e.e(file2);
                    if (i > this.dPZ.dPW.ajd) {
                        v.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.dPZ.dPW.ajd), Integer.valueOf(i)});
                        if (b.a(file, new File(this.dPZ.dPW.dPU))) {
                            this.dPZ.refresh();
                        } else {
                            v.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                        }
                    } else {
                        v.i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", new Object[]{Integer.valueOf(this.dPZ.dPW.ajd), Integer.valueOf(i)});
                    }
                } else {
                    v.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };
    public c dPY = new c<gw>(this) {
        final /* synthetic */ b dPZ;

        {
            this.dPZ = r2;
            this.nhz = gw.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ((gw) bVar).bgz.bgA = this.dPZ.dPW.ajd;
            return true;
        }
    };
    public c owi = new c<rh>(this) {
        final /* synthetic */ b dPZ;

        {
            this.dPZ = r2;
            this.nhz = rh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            Object obj = ((rh) bVar).enc.aWW;
            if (TextUtils.isEmpty(obj)) {
                return false;
            }
            if (obj.replace("//wxafts ", "").contains("delete")) {
                b bVar2 = this.dPZ;
                e.e(new File(c.Ii()));
                v.i("MicroMsg.WxaFTSSearchCore", "forceUnzipBasicTemplate");
                bVar2.prepare();
            }
            return true;
        }
    };

    public static b RL() {
        if (dPV == null) {
            synchronized (b.class) {
                if (dPV == null) {
                    dPV = new b();
                }
            }
        }
        return dPV;
    }

    private b() {
    }

    public final void prepare() {
        a.nhr.e(this.dPX);
        a.nhr.e(this.dPY);
        a.nhr.e(this.owi);
        refresh();
        File file = new File(this.dPW.dPU);
        v.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", new Object[]{Integer.valueOf(this.dPW.ajd), Integer.valueOf(65300001)});
        if (this.dPW.ajd < 65300001 && b(file, "wxa_fts_template.zip")) {
            refresh();
        }
    }

    private void refresh() {
        this.dPW.ajd = c.RM();
        this.dPW.dPU = c.Ii();
    }

    private static boolean b(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                v.a("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        boolean aT = c.aT(absolutePath, str);
        if (aT) {
            if (be.dB(absolutePath, file3.getParent()) < 0) {
                v.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", new Object[]{Integer.valueOf(be.dB(absolutePath, file3.getParent())), absolutePath, file3.getParent()});
                return false;
            }
            v.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", new Object[]{file3.getAbsolutePath()});
        } else {
            v.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", new Object[]{file3.getAbsolutePath()});
        }
        return aT;
    }

    private static boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        e.e(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                v.a("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (be.dB(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            v.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", new Object[]{Integer.valueOf(be.dB(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath()});
            return false;
        }
        v.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", new Object[]{file2.getAbsolutePath()});
        return true;
    }
}
