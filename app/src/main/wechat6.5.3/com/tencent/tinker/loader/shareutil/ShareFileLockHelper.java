package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class ShareFileLockHelper implements Closeable {
    private final FileOutputStream pGP;
    private final FileLock pGQ;

    public void close() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0012 in list [B:6:0x000d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.pGQ;	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0009;	 Catch:{ all -> 0x0013 }
    L_0x0004:
        r0 = r2.pGQ;	 Catch:{ all -> 0x0013 }
        r0.release();	 Catch:{ all -> 0x0013 }
    L_0x0009:
        r0 = r2.pGP;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r2.pGP;
        r0.close();
    L_0x0012:
        return;
    L_0x0013:
        r0 = move-exception;
        r1 = r2.pGP;
        if (r1 == 0) goto L_0x001d;
    L_0x0018:
        r1 = r2.pGP;
        r1.close();
    L_0x001d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareFileLockHelper.close():void");
    }

    private ShareFileLockHelper(File file) {
        this.pGP = new FileOutputStream(file);
        Throwable th = null;
        FileLock fileLock = null;
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            try {
                fileLock = this.pGP.getChannel().lock();
                if ((fileLock != null ? 1 : null) != null) {
                    break;
                }
                Thread.sleep(10);
                i = i2;
            } catch (Throwable e) {
                th = e;
                i = i2;
            }
        }
        if (fileLock == null) {
            throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), th);
        }
        this.pGQ = fileLock;
    }

    public static ShareFileLockHelper M(File file) {
        return new ShareFileLockHelper(file);
    }
}
