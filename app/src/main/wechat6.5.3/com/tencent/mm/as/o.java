package com.tencent.mm.as;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class o {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[] )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[] )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
    private static long dhV = 0;
    public g cuX;
    h<a, a> cye = new h<a, a>(this) {
        final /* synthetic */ o dhW;

        {
            this.dhW = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((a) obj2);
        }
    };

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ o dhW;
        final /* synthetic */ String dhX;
        final /* synthetic */ String dhY;
        final /* synthetic */ String dhZ;

        AnonymousClass2(o oVar, String str, String str2, String str3) {
            this.dhW = oVar;
            this.dhX = str;
            this.dhY = str2;
            this.dhZ = str3;
        }

        public final void run() {
            FileInputStream fileInputStream;
            int i;
            Throwable th;
            FileInputStream fileInputStream2;
            Object obj;
            long Ni = be.Ni();
            int aQ = e.aQ(this.dhX);
            int aQ2 = e.aQ(this.dhY);
            v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff now:%s size:%s,%s path:%s,%s", Long.valueOf(Ni), Integer.valueOf(aQ), Integer.valueOf(aQ2), this.dhX, this.dhY);
            if (aQ2 != aQ) {
                int i2 = (aQ <= 0 ? 20 : 0) + ((aQ2 <= 0 ? 10 : 0) + MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(i2), this.dhZ, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, Integer.valueOf(aQ2));
                v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err File Size diff %d,%d path:%s org:%s", Integer.valueOf(aQ), Integer.valueOf(aQ2), this.dhX, this.dhY);
                return;
            }
            int i3;
            long ay;
            FileInputStream fileInputStream3 = null;
            FileInputStream fileInputStream4 = null;
            try {
                fileInputStream = new FileInputStream(this.dhX);
                try {
                    fileInputStream3 = new FileInputStream(this.dhY);
                    try {
                        byte[] bArr = new byte[4096];
                        byte[] bArr2 = new byte[4096];
                        i3 = 0;
                        Object obj2 = null;
                        while (true) {
                            try {
                                int read = fileInputStream.read(bArr);
                                if (read != fileInputStream3.read(bArr2)) {
                                    obj2 = 1;
                                }
                                if (read == -1) {
                                    break;
                                }
                                i2 = i3;
                                i3 = 0;
                                while (i3 < read) {
                                    try {
                                        if (bArr[i3] != bArr2[i3]) {
                                            i2++;
                                        }
                                        i3++;
                                    } catch (Throwable e) {
                                        Throwable th2 = e;
                                        fileInputStream4 = fileInputStream3;
                                        fileInputStream3 = fileInputStream;
                                        i = i2;
                                        th = th2;
                                    }
                                }
                                i3 = i2;
                            } catch (Exception e2) {
                                th = e2;
                                fileInputStream2 = fileInputStream3;
                                fileInputStream3 = fileInputStream;
                                i = i3;
                                fileInputStream4 = fileInputStream2;
                            }
                        }
                        obj = obj2;
                    } catch (Exception e3) {
                        th = e3;
                        fileInputStream4 = fileInputStream3;
                        fileInputStream3 = fileInputStream;
                        i = 0;
                        v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", be.e(th));
                        obj = 1;
                        fileInputStream2 = fileInputStream4;
                        i3 = i;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        fileInputStream3.close();
                        fileInputStream.close();
                        if (obj == null) {
                            ay = be.ay(Ni);
                            com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(400), this.dhZ, String.valueOf(i3), Long.valueOf(ay));
                            v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(ay), Integer.valueOf(i3), this.dhX, this.dhY);
                        }
                        v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aQ), Integer.valueOf(aQ2), this.dhX, this.dhY);
                        com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.dhZ);
                        return;
                    }
                } catch (Exception e4) {
                    th = e4;
                    fileInputStream3 = fileInputStream;
                    i = 0;
                    v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", be.e(th));
                    obj = 1;
                    fileInputStream2 = fileInputStream4;
                    i3 = i;
                    fileInputStream = fileInputStream3;
                    fileInputStream3 = fileInputStream2;
                    fileInputStream3.close();
                    fileInputStream.close();
                    if (obj == null) {
                        v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aQ), Integer.valueOf(aQ2), this.dhX, this.dhY);
                        com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.dhZ);
                        return;
                    }
                    ay = be.ay(Ni);
                    com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(400), this.dhZ, String.valueOf(i3), Long.valueOf(ay));
                    v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(ay), Integer.valueOf(i3), this.dhX, this.dhY);
                }
            } catch (Exception e5) {
                th = e5;
                i = 0;
                v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", be.e(th));
                obj = 1;
                fileInputStream2 = fileInputStream4;
                i3 = i;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                fileInputStream3.close();
                fileInputStream.close();
                if (obj == null) {
                    ay = be.ay(Ni);
                    com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(400), this.dhZ, String.valueOf(i3), Long.valueOf(ay));
                    v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(ay), Integer.valueOf(i3), this.dhX, this.dhY);
                }
                v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aQ), Integer.valueOf(aQ2), this.dhX, this.dhY);
                com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.dhZ);
                return;
            }
            try {
                fileInputStream3.close();
            } catch (Exception e6) {
            }
            try {
                fileInputStream.close();
            } catch (Exception e7) {
            }
            if (obj == null) {
                v.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aQ), Integer.valueOf(aQ2), this.dhX, this.dhY);
                com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.dhZ);
                return;
            }
            ay = be.ay(Ni);
            com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(400), this.dhZ, String.valueOf(i3), Long.valueOf(ay));
            v.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(ay), Integer.valueOf(i3), this.dhX, this.dhY);
        }
    }

    public interface a {

        public static final class a {
            public final String aST;
            public final long dgv;
            public final int dhR;
            public final int dia;
            public final int dib;

            public a(String str, int i, int i2, int i3, long j) {
                this.aST = str;
                this.dia = i;
                this.dib = i2;
                this.dhR = i3;
                this.dgv = j;
            }
        }

        public enum b {
            ;

            static {
                dic = 1;
                did = 2;
                die = 3;
                dif = new int[]{dic, did, die};
            }
        }

        public enum c {
            ;

            static {
                dig = 1;
                dih = 2;
                dii = 3;
                dij = new int[]{dig, dih, dii};
            }
        }

        void a(a aVar);
    }

    public static class b {
        public int aUT = 0;
        public byte[] buf = null;
        public int dik = 0;
        public int ret = 0;
    }

    public final void a(a aVar, Looper looper) {
        this.cye.a(aVar, looper);
    }

    public final void a(a aVar) {
        this.cye.remove(aVar);
    }

    public o(g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(n nVar) {
        nVar.bkU = -1;
        if (((int) this.cuX.insert("videoinfo2", "filename", nVar.py())) == -1) {
            return false;
        }
        this.cye.bg(new a(nVar.getFileName(), b.dic, c.dig, nVar.dhR, nVar.dgv));
        this.cye.Ls();
        return true;
    }

    public final n kZ(String str) {
        n nVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo from videoinfo2   where videoinfo2.filename = \"" + be.lZ(str) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                nVar = new n();
                nVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return nVar;
    }

    public final List<n> as(long j) {
        List<n> list = null;
        Cursor rawQuery = this.cuX.rawQuery("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo from videoinfo2   where videoinfo2.masssendid = " + j, null);
        if (rawQuery != null) {
            list = new LinkedList();
            if (rawQuery.moveToFirst()) {
                do {
                    n nVar = new n();
                    nVar.b(rawQuery);
                    list.add(nVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    public final List<n> Lj() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo from videoinfo2  " + " WHERE status=200 order by masssendid desc";
        List arrayList = new ArrayList();
        Cursor rawQuery = this.cuX.rawQuery(str, null);
        int count = rawQuery.getCount();
        v.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:" + count);
        if (count == 0) {
            rawQuery.close();
        } else {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                n nVar = new n();
                nVar.b(rawQuery);
                arrayList.add(nVar);
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public final List<n> Lk() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
        List arrayList = new ArrayList();
        Cursor rawQuery = this.cuX.rawQuery(str, null);
        int count = rawQuery.getCount();
        v.d("MicroMsg.VideoInfoStorage", "getFailMassInfo resCount:" + count);
        if (count == 0) {
            rawQuery.close();
        } else {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                n nVar = new n();
                nVar.b(rawQuery);
                arrayList.add(nVar);
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public final boolean b(n nVar) {
        boolean z;
        Assert.assertTrue(nVar != null);
        if (nVar.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues py = nVar.py();
        if (py.size() <= 0) {
            v.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.cuX.update("videoinfo2", py, "filename= ?", new String[]{nVar.getFileName()}) > 0) {
                int i = c.dig;
                if (nVar.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    i = c.dii;
                } else if (nVar.status == MMGIFException.D_GIF_ERR_NOT_GIF_FILE || nVar.status == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR) {
                    i = c.dih;
                }
                this.cye.bg(new a(nVar.getFileName(), b.die, i, nVar.dhR, nVar.dgv));
                this.cye.Ls();
                return true;
            }
        }
        return false;
    }

    public final List<String> Ll() {
        Throwable th;
        List<String> list = null;
        Cursor rawQuery;
        try {
            rawQuery = this.cuX.rawQuery("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + new StringBuilder(" LIMIT 10").toString(), null);
            try {
                if (rawQuery.moveToFirst()) {
                    list = new LinkedList();
                    do {
                        list.add(rawQuery.getString(0));
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final List<String> Lm() {
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10" + " )";
        Cursor rawQuery;
        try {
            rawQuery = this.cuX.rawQuery((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + str) + " ORDER BY downloadtime DESC", null);
            try {
                if (rawQuery.moveToFirst()) {
                    list = new LinkedList();
                    do {
                        list.add(rawQuery.getString(0));
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final List<String> Ln() {
        Cursor rawQuery;
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10" + " )";
        try {
            rawQuery = this.cuX.rawQuery((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + str) + " ORDER BY downloadtime DESC", null);
            try {
                if (rawQuery.moveToFirst()) {
                    list = new LinkedList();
                    do {
                        list.add(rawQuery.getString(0));
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    public final boolean la(String str) {
        if (this.cuX.delete("videoinfo2", "filename= ?", new String[]{str}) <= 0) {
            return false;
        }
        this.cye.bg(new a(str, b.did, c.dig, 1, -1));
        this.cye.Ls();
        return true;
    }

    public static String lb(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("HHmmssddMMyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + com.tencent.mm.a.g.m(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = dhV;
        dhV = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    public static String lc(String str) {
        if (be.kS(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(c.getAccVideoPath()).append(str).toString();
        return !e.aR(stringBuilder2) ? stringBuilder2 + ".mp4" : stringBuilder2;
    }

    public static String ld(String str) {
        if (be.kS(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.getAccVideoPath()).append(str).append(".jpg").toString();
    }

    public static int a(String str, int i, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        int filePointer;
        Exception e;
        Throwable th;
        if (be.kS(str)) {
            v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " invalid fileName");
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (i < 0) {
            v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "]  invalid startOffset:" + i);
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (be.bl(bArr)) {
            v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "]  invalid writeBuf");
            return 0 - com.tencent.mm.compatible.util.g.sk();
        } else {
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    long sn = aVar.sn();
                    randomAccessFile.seek((long) i);
                    long sn2 = aVar.sn();
                    randomAccessFile.write(bArr, 0, bArr.length);
                    long sn3 = aVar.sn();
                    filePointer = (int) randomAccessFile.getFilePointer();
                    long sn4 = aVar.sn();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    v.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "]  Offset:" + i + " buf:" + bArr.length);
                    v.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "] open:" + sn + " seek:" + sn2 + " write:" + sn3 + " close:" + sn4);
                    return filePointer;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                        filePointer = 0 - com.tencent.mm.compatible.util.g.sk();
                        if (randomAccessFile != null) {
                            return filePointer;
                        }
                        try {
                            randomAccessFile.close();
                            return filePointer;
                        } catch (Exception e4) {
                            return filePointer;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                filePointer = 0 - com.tencent.mm.compatible.util.g.sk();
                if (randomAccessFile != null) {
                    return filePointer;
                }
                randomAccessFile.close();
                return filePointer;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }
    }

    public static b e(String str, int i, int i2) {
        RandomAccessFile randomAccessFile;
        Exception e;
        Throwable th;
        int i3 = 0;
        b bVar = new b();
        if (be.kS(str)) {
            v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + " invalid fileName");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (i < 0) {
            v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "]  invalid readOffset:" + i);
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.sk();
        } else if (i2 <= 0) {
            v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "]  invalid readLen");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.sk();
        } else {
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            bVar.buf = new byte[i2];
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    long sn = aVar.sn();
                    randomAccessFile.seek((long) i);
                    long sn2 = aVar.sn();
                    int read = randomAccessFile.read(bVar.buf, 0, i2);
                    long sn3 = aVar.sn();
                    long sn4 = aVar.sn();
                    if (read >= 0) {
                        i3 = read;
                    }
                    bVar.aUT = i3;
                    bVar.dik = i3 + i;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    v.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "]  Offset:" + i + " readlen:" + i2);
                    v.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "] open:" + sn + " seek:" + sn2 + " write:" + sn3 + " close:" + sn4);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "] \t\tOffset:" + bVar.dik + " failed:[" + e.getMessage() + "]");
                        bVar.ret = 0 - com.tencent.mm.compatible.util.g.sk();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                v.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sm() + "[" + str + "] \t\tOffset:" + bVar.dik + " failed:[" + e.getMessage() + "]");
                bVar.ret = 0 - com.tencent.mm.compatible.util.g.sk();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }
        return bVar;
    }

    public static int le(String str) {
        if (be.kS(str)) {
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final boolean o(String str, String str2, String str3) {
        return ad(str, str2 + "##" + str3);
    }

    static int[] lf(String str) {
        Throwable e;
        int i = 0;
        int[] iArr = new int[33];
        long Ni = be.Ni();
        int aQ = e.aQ(str);
        if (aQ < 102400 || aQ >= 104857600) {
            int i2;
            v.e("MicroMsg.VideoInfoStorage", "genVideoHash file size :%d , give up. :%s ", Integer.valueOf(aQ), str);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
            Object[] objArr = new Object[2];
            if (aQ < 102400) {
                i2 = 10;
            } else {
                i2 = 20;
            }
            objArr[0] = Integer.valueOf(i2 + MMGIFException.D_GIF_ERR_OPEN_FAILED);
            objArr[1] = Integer.valueOf(aQ);
            gVar.h(12696, objArr);
            return null;
        }
        iArr[32] = aQ;
        int i3 = (aQ - 20480) / 32;
        byte[] bArr = new byte[512];
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            while (i < 32) {
                try {
                    randomAccessFile.seek((long) ((i * i3) + 10240));
                    randomAccessFile.readFully(bArr);
                    iArr[i] = (com.tencent.mm.a.h.b(bArr, 512) % Integer.MIN_VALUE) | Integer.MIN_VALUE;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            randomAccessFile.close();
            v.i("MicroMsg.VideoInfoStorage", "genVideoHash finish time:%d size:%d path:%s", Long.valueOf(be.ay(Ni)), Integer.valueOf(aQ), str);
            try {
                randomAccessFile.close();
                return iArr;
            } catch (Exception e3) {
                return iArr;
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            try {
                v.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", str, be.e(e));
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }

    private boolean ad(String str, String str2) {
        v.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", str, str2, be.bur());
        long Ni = be.Ni();
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", str, str2);
            return false;
        }
        int[] lf = lf(str);
        if (lf == null || lf.length < 33) {
            v.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", str);
            return false;
        }
        int i = lf[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 32; i2++) {
            stringBuffer.append(Integer.toHexString(lf[i2]));
        }
        Cursor rawQuery = this.cuX.rawQuery("select cdnxml from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"", null);
        Vector vector = new Vector();
        while (rawQuery.moveToNext()) {
            vector.add(rawQuery.getString(0));
            v.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", Integer.valueOf(vector.size()), vector.get(vector.size() - 1));
        }
        rawQuery.close();
        if (vector.size() == 1 && str2.equals(vector.get(0))) {
            v.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", Long.valueOf(be.ay(Ni)), str, str2);
            return true;
        }
        if (vector.size() > 0) {
            com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_READ_FAILED), Integer.valueOf(i), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, Integer.valueOf(vector.size()));
            v.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", Integer.valueOf(vector.size()), Integer.valueOf(i));
            this.cuX.dF("VideoHash", "delete from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("CreateTime", Long.valueOf(be.Nh()));
        contentValues.put("hash", stringBuffer.toString());
        contentValues.put("cdnxml", str2);
        contentValues.put("orgpath", str);
        v.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", Long.valueOf(be.ay(Ni)), Long.valueOf(this.cuX.insert("VideoHash", SQLiteDatabase.KeyEmpty, contentValues)), str, stringBuffer, str2);
        if (this.cuX.insert("VideoHash", SQLiteDatabase.KeyEmpty, contentValues) < 0) {
            com.tencent.mm.plugin.report.service.g.iuh.h(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Integer.valueOf(i));
            v.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", Long.valueOf(r0), str);
        }
        return true;
    }
}
