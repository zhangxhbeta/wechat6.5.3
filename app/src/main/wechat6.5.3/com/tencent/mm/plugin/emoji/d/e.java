package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.io.File;
import java.util.regex.Pattern;

public class e {
    public static e faX;
    public boolean faY = false;
    private Pattern faZ = Pattern.compile("_\\d");

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String dpu;
        final /* synthetic */ e fba;

        AnonymousClass1(e eVar, String str) {
            this.fba = eVar;
            this.dpu = str;
        }

        public final void run() {
            this.fba.re(this.dpu);
            if (this.fba.faY) {
                ak.yW();
                c.vf().a(a.noO, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static e aeU() {
        if (faX == null) {
            synchronized (e.class) {
                faX = new e();
            }
        }
        return faX;
    }

    public final void re(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (this.faY) {
                        if (file2.isDirectory()) {
                            re(file2.getPath());
                        } else {
                            Object name = file2.getName();
                            if (this.faZ.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        v.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        return;
                    }
                }
            }
        }
    }

    public final void rf(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        rf(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
    }
}
