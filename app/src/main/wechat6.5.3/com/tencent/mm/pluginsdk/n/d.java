package com.tencent.mm.pluginsdk.n;

import android.content.ContentResolver;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class d {
    public static final String a(ContentResolver contentResolver, Uri uri, int i) {
        OutputStream fileOutputStream;
        InputStream openInputStream;
        Throwable e;
        if (uri == null) {
            return null;
        }
        String str;
        String type = contentResolver.getType(uri);
        File cacheDir = aa.getContext().getCacheDir();
        StringBuilder append = new StringBuilder("share_img_tmp_").append(i);
        if (be.kS(type)) {
            str = "";
        } else {
            str = MimeTypeMap.getSingleton().getExtensionFromMimeType(type);
            if (str == null || str.length() == 0) {
                String[] split = type.split("/");
                if (split != null && split.length > 1) {
                    str = split[1];
                }
            }
            str = "." + str;
        }
        str = new File(cacheDir, append.append(str).toString()).getAbsolutePath();
        if (FileOp.aR(str)) {
            FileOp.deleteFile(str);
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                openInputStream = contentResolver.openInputStream(uri);
            } catch (Exception e2) {
                e = e2;
                openInputStream = null;
                try {
                    v.a("MicroMsg.ShareImageUtil", e, "copy google photo img fail", new Object[0]);
                    e.c(openInputStream);
                    e.a(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    e.c(openInputStream);
                    e.a(fileOutputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                e.c(openInputStream);
                e.a(fileOutputStream);
                throw e;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        e.c(openInputStream);
                        e.a(fileOutputStream);
                        return str;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                v.a("MicroMsg.ShareImageUtil", e, "copy google photo img fail", new Object[0]);
                e.c(openInputStream);
                e.a(fileOutputStream);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            openInputStream = null;
            fileOutputStream = null;
            v.a("MicroMsg.ShareImageUtil", e, "copy google photo img fail", new Object[0]);
            e.c(openInputStream);
            e.a(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            e = th3;
            openInputStream = null;
            fileOutputStream = null;
            e.c(openInputStream);
            e.a(fileOutputStream);
            throw e;
        }
    }
}
