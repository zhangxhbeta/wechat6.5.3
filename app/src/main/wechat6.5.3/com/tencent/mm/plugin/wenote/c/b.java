package com.tencent.mm.plugin.wenote.c;

import com.tencent.mm.a.e;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wenote.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class b implements ag {
    private static HashMap<Integer, c> bXq = new HashMap();
    private com.tencent.mm.plugin.wenote.a.c luo = new com.tencent.mm.plugin.wenote.a.c();
    private a lup = new a();
    private com.tencent.mm.plugin.wenote.a.b luq = new com.tencent.mm.plugin.wenote.a.b();
    public com.tencent.mm.plugin.wenote.b.b lur = null;

    public static b bma() {
        b bVar = (b) ak.yP().fY("plugin.wenote");
        if (bVar != null) {
            return bVar;
        }
        bVar = new b();
        ak.yP().a("plugin.wenote", bVar);
        return bVar;
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        InputStream open;
        v.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        com.tencent.mm.sdk.c.a.nhr.e(this.luo);
        com.tencent.mm.sdk.c.a.nhr.e(this.lup);
        com.tencent.mm.sdk.c.a.nhr.e(this.luq);
        File file = new File(j.xl());
        if (!(file.exists() && file.isDirectory())) {
            v.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
        File file2 = new File(com.tencent.mm.bj.a.bLM());
        v.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[]{file2.getAbsolutePath()});
        if (d.lWk || d.lWl) {
            v.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            e.e(file2);
        } else {
            com.tencent.mm.bj.a.pkr = com.tencent.mm.bj.a.Et();
            if (z) {
                v.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(com.tencent.mm.bj.a.Eu()), Integer.valueOf(com.tencent.mm.bj.a.pkr)});
                if (com.tencent.mm.bj.a.pkr < com.tencent.mm.bj.a.Eu()) {
                    e.e(file2);
                }
            } else if (com.tencent.mm.bj.a.pkr == 1) {
                v.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                e.e(file2);
            } else {
                v.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[]{Integer.valueOf(com.tencent.mm.bj.a.pkr)});
            }
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            open = aa.getContext().getAssets().open("WNNote.zip");
        } catch (Throwable e) {
            v.a("MicroMsg.SubCoreWNNoteMsg", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            v.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
            return;
        }
        File file3 = new File(file2, "WNNote.zip");
        if (file3.exists()) {
            v.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            e.c(open);
            return;
        }
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable e2) {
            v.a("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                a(open, fileOutputStream);
            } catch (Throwable e3) {
                v.a("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
            }
        }
        e.c(open);
        e.a(fileOutputStream);
        int dB = be.dB(file3.getAbsolutePath(), file3.getParent());
        if (dB < 0) {
            v.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + dB + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
        }
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        v.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        com.tencent.mm.sdk.c.a.nhr.f(this.luo);
        com.tencent.mm.sdk.c.a.nhr.f(this.lup);
        com.tencent.mm.sdk.c.a.nhr.f(this.luq);
    }

    public final com.tencent.mm.plugin.wenote.b.b bmb() {
        if (this.lur == null) {
            v.e("MicroMsg.SubCoreWNNoteMsg", "getWnNoteBase wnNoteBase=null");
        }
        return this.lur;
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
