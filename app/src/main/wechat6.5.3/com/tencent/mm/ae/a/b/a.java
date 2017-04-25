package com.tencent.mm.ae.a.b;

import com.tencent.mm.a.e;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.a.c.f;
import com.tencent.mm.ae.a.g.b;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class a implements com.tencent.mm.ae.a.c.a {
    private f cPU;

    private String a(String str, c cVar) {
        String str2 = cVar.cPu;
        if (str2 == null || str2.length() == 0) {
            str2 = cVar.cPv;
            if (!(str2 == null || str2.length() == 0)) {
                str2 = str2 + File.separator + this.cPU.jj(str);
            }
        }
        if (cVar.cPr && be.kS(r0)) {
            str2 = b.GW() + File.separator + this.cPU.jj(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    private String b(String str, c cVar) {
        String str2 = cVar.cPw;
        if (str2 == null || str2.length() == 0) {
            String str3 = cVar.cPu;
            if (str3 != null && str3.length() > 0) {
                str2 = cVar.cPv;
                if (str2 == null || str2.length() == 0 || !str3.startsWith(str2)) {
                    v.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", str3);
                    throw new IllegalArgumentException("SFS can't deal with absolute path: " + str3);
                }
                str2 = str3.substring(str2.length());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
            }
        }
        if (str2 == null || str2.length() == 0) {
            str2 = this.cPU.jj(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    public final boolean a(String str, byte[] bArr, c cVar) {
        SFSContext sFSContext = cVar.cPN;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                String str2 = SQLiteDatabase.KeyEmpty;
                if (com.tencent.mm.modelsfs.f.jW(b)) {
                    str2 = com.tencent.mm.modelsfs.f.jZ(b);
                    b = com.tencent.mm.modelsfs.f.jX(b);
                }
                outputStream = sFSContext.Z(b, str2);
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (outputStream == null) {
                    return false;
                }
                try {
                    outputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } else {
            String a = a(str, cVar);
            if (a == null) {
                return false;
            }
            File parentFile = new File(a).getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            parentFile = new File(a);
            if (!parentFile.exists()) {
                try {
                    parentFile.createNewFile();
                } catch (Throwable e5) {
                    v.i("MicroMsg.imageloader.DefaultImageDiskCache", be.e(e5));
                }
            }
            if (bArr != null && e.b(a, bArr, bArr.length) < 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(String str, c cVar) {
        SFSContext sFSContext = cVar.cPN;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            return sFSContext.hc(b);
        }
        String a = a(str, cVar);
        if (a != null) {
            return new File(a).delete();
        }
        return false;
    }

    public final void GV() {
        b.GY();
    }

    public final InputStream d(String str, c cVar) {
        try {
            SFSContext sFSContext = cVar.cPN;
            String b;
            if (sFSContext != null) {
                b = b(str, cVar);
                if (b == null) {
                    return null;
                }
                return sFSContext.openRead(b);
            }
            b = a(str, cVar);
            if (b != null) {
                return new FileInputStream(b);
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public final void a(f fVar) {
        this.cPU = fVar;
    }
}
