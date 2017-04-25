package com.tencent.tinker.c.b;

import com.tencent.tinker.c.c.f;
import com.tencent.tinker.c.c.g;
import com.tencent.tinker.c.c.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class a {
    public static void a(g gVar, f fVar, h hVar) {
        InputStream inputStream = null;
        try {
            inputStream = gVar.a(fVar);
            hVar.b(new f(fVar));
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                hVar.write(bArr, 0, read);
            }
            hVar.closeEntry();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void a(f fVar, File file, long j, h hVar) {
        FileInputStream fileInputStream;
        Throwable th;
        f fVar2 = new f(fVar);
        fVar2.setMethod(0);
        fVar2.setSize(file.length());
        fVar2.pFc = file.length();
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Bad CRC32: " + j);
        }
        fVar2.pFb = j;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                hVar.b(new f(fVar2));
                byte[] bArr = new byte[16384];
                for (int read = fileInputStream.read(bArr); read != -1; read = fileInputStream.read(bArr)) {
                    hVar.write(bArr, 0, read);
                }
                hVar.closeEntry();
                fileInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
