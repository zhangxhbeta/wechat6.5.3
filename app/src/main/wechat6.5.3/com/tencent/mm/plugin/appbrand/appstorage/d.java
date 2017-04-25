package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.loader.stub.b;
import java.io.File;
import java.io.FileFilter;

public final class d {
    public static final Runnable dAW = new Runnable() {
        public final void run() {
            File file = new File(c.dCi);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File n : listFiles) {
                        n(n);
                    }
                }
            }
        }

        private void n(File file) {
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles(new FileFilter(this) {
                    final /* synthetic */ AnonymousClass1 dCl;

                    {
                        this.dCl = r1;
                    }

                    public final boolean accept(File file) {
                        return (file.getName().endsWith(".dat") || file.getName().startsWith("store_") || file.getName().endsWith(".nomedia")) ? false : true;
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    for (File absolutePath : listFiles) {
                        b.deleteFile(absolutePath.getAbsolutePath());
                    }
                }
            }
        }
    };
}
