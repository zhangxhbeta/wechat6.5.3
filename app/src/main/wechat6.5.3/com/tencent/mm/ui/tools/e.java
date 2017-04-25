package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.StatFs;
import android.widget.Toast;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class e {
    private static int oSf = 0;

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String chj;
        final /* synthetic */ ProgressDialog ePM;
        final /* synthetic */ File idQ;
        final /* synthetic */ boolean oSg = true;
        final /* synthetic */ boolean oSh = false;
        final /* synthetic */ a oSi;

        AnonymousClass1(File file, String str, ProgressDialog progressDialog, boolean z, boolean z2, a aVar) {
            this.idQ = file;
            this.chj = str;
            this.ePM = progressDialog;
            this.oSi = aVar;
        }

        public final void run() {
            try {
                Thread.sleep(200);
            } catch (Throwable e) {
                v.a("MicroMsg.DBRecover", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder2 = stringBuilder.append(c.xp()).append(this.idQ.getName().replace(".db", "temp.db")).toString();
            v.i("MicroMsg.DBRecover", "temp db path is %s", stringBuilder2);
            e.d(new File(stringBuilder2), this.idQ);
            this.idQ.delete();
            stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder3 = stringBuilder.append(c.xp()).append("sqlTemp.sql").toString();
            List arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"}));
            e.oSf = 0;
            long currentTimeMillis = System.currentTimeMillis();
            ak.yW();
            final boolean a = c.wE().a(stringBuilder2, this.chj, stringBuilder3, arrayList, new ExecuteSqlCallback(this) {
                final /* synthetic */ AnonymousClass1 oSj;

                {
                    this.oSj = r1;
                }

                public final String preExecute(String str) {
                    e.ou();
                    return null;
                }
            });
            if (a) {
                ak.yW();
                c.wJ();
                au.bwT();
                ak.yW();
                c.wK().bvH();
                ((d) g.f(d.class)).azI().bwV();
                ak.yW();
                c.wJ().bwU();
            }
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            v.i("MicroMsg.DBRecover", "execute %d sql and last %d", Integer.valueOf(e.oSf), Long.valueOf(currentTimeMillis2));
            ak.vA().btw();
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 oSj;

                public final void run() {
                    int i;
                    if (this.oSj.ePM != null) {
                        this.oSj.ePM.dismiss();
                    }
                    if (!a) {
                        Toast.makeText(aa.getContext(), aa.getContext().getString(2131234367), 1).show();
                    } else if (this.oSj.oSg) {
                        Toast.makeText(aa.getContext(), aa.getContext().getString(2131234371), 1).show();
                    }
                    if (this.oSj.oSh) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(181, a ? 12 : 13, 1, false);
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.a(181, a ? 14 : 15, 1, false);
                    }
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    Object[] objArr = new Object[3];
                    if (a) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = Integer.valueOf(e.oSf);
                    objArr[2] = Long.valueOf(currentTimeMillis2);
                    gVar.h(11224, objArr);
                }
            });
        }
    }

    public interface a {
    }

    static /* synthetic */ int ou() {
        int i = oSf;
        oSf = i + 1;
        return i;
    }

    public static void d(File file, File file2) {
        InputStream fileInputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        FileOutputStream fileOutputStream2 = null;
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                v.e("MicroMsg.DBRecover", "copy file fail");
                return;
            }
        }
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                fileOutputStream = null;
                inputStream = fileInputStream;
                try {
                    v.e("MicroMsg.DBRecover", "copy file fail");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            return;
                        }
                    }
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = inputStream;
                    fileOutputStream2 = fileOutputStream;
                    th2 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            throw th2;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th2;
            }
            try {
                byte[] bArr = new byte[1024];
                while (fileInputStream.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            } catch (Exception e6) {
                inputStream = fileInputStream;
                v.e("MicroMsg.DBRecover", "copy file fail");
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream2 = fileOutputStream;
                th2 = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th2;
            }
        } catch (Exception e7) {
            fileOutputStream = null;
            v.e("MicroMsg.DBRecover", "copy file fail");
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        } catch (Throwable th6) {
            th2 = th6;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th2;
        }
    }

    public static boolean a(String str, a aVar) {
        if (be.kS(str)) {
            ak.yW();
            String str2 = "EnMicroMsg.db";
            for (String str3 : new File(c.xp()).list()) {
                if (str3.startsWith(str2 + "err") || str3.endsWith("temp.db")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    str = stringBuilder.append(c.xp()).append(str3).toString();
                    break;
                }
            }
        } else {
            str = str.replaceFirst(" ", SQLiteDatabase.KeyEmpty);
        }
        if (be.kS(str) || !new File(str).exists()) {
            Toast.makeText(aa.getContext(), aa.getContext().getString(2131234369), 1).show();
            v.i("MicroMsg.DBRecover", "crash file is not exists");
        } else {
            stringBuilder = new StringBuilder().append(p.rJ());
            ak.yW();
            String substring = com.tencent.mm.a.g.m(stringBuilder.append(c.ww()).toString().getBytes()).substring(0, 7);
            File file = new File(str);
            long length = file.length() * 2;
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            v.i("MicroMsg.DBRecover", "db recover needSize : %d blockSize:%d", Long.valueOf(length), Long.valueOf(((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())));
            if (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) < length) {
                com.tencent.mm.plugin.report.service.g.iuh.a(181, 3, 1, false);
                Toast.makeText(aa.getContext(), aa.getContext().getString(2131234370), 1).show();
            }
            Context bzB = LauncherUI.bzB();
            if (bzB != null) {
                aa.getContext().getString(2131231164);
                ProgressDialog a = com.tencent.mm.ui.base.g.a(bzB, aa.getContext().getString(2131234368), false, null);
                ak.vA().btu();
                ak.vA().x(new AnonymousClass1(file, substring, a, true, false, aVar));
                if (a != null) {
                    a.show();
                }
            }
        }
        return true;
    }
}
