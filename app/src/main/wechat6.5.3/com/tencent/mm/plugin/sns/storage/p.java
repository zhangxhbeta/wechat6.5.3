package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.h.j;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public final class p extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static int jbB = 0;
    private static int jco = 0;
    private static Point jgb = new Point();
    public com.tencent.mm.bg.g cuX;

    public p(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public static void cv(int i, int i2) {
        jco = i;
        jbB = i2;
        v.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static String BF(String str) {
        if (str == null) {
            return "";
        }
        String m = com.tencent.mm.a.g.m(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (m.length() > 0) {
            str2 = m.charAt(0) + "/";
        }
        if (m.length() >= 2) {
            str3 = m.charAt(1) + "/";
        }
        return ad.xh() + str2 + str3;
    }

    public final boolean a(String str, o oVar) {
        v.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList " + str);
        Cursor query = this.cuX.query("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null);
        if (query.getCount() == 0) {
            query.close();
            v.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
            if (oVar != null) {
                if (((int) this.cuX.insert("SnsMedia", "local_id", oVar.aVb())) != -1) {
                    return true;
                }
            }
            return false;
        }
        query.close();
        return this.cuX.update("SnsMedia", oVar.aVb(), "StrId=?", new String[]{str}) > 0;
    }

    public final int a(int i, o oVar) {
        return this.cuX.update("SnsMedia", oVar.aVb(), "local_id=?", new String[]{String.valueOf(i)});
    }

    public final o BG(String str) {
        o oVar = new o();
        Cursor query = this.cuX.query("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            oVar.b(query);
            query.close();
            return oVar;
        }
        query.close();
        return null;
    }

    public final o de(long j) {
        o oVar = new o();
        Cursor query = this.cuX.query("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query.getCount() == 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        oVar.b(query);
        query.close();
        return oVar;
    }

    public final List<h> bs(List<h> list) {
        List<h> linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (h hVar : list) {
            int a = a(hVar);
            if (a == -1) {
                return null;
            }
            h hVar2 = new h(a, hVar.type);
            hVar2.height = hVar.height;
            hVar2.width = hVar.width;
            hVar2.fileSize = hVar.fileSize;
            linkedList.add(hVar2);
        }
        return linkedList;
    }

    private static h a(h hVar, String str) {
        InputStream iVar;
        Throwable th;
        Throwable e;
        int i;
        int i2;
        InputStream inputStream = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream = FileOp.openRead(str);
            try {
                if (inputStream instanceof FileInputStream) {
                    iVar = new i((FileInputStream) inputStream);
                } else {
                    iVar = inputStream;
                }
            } catch (Throwable e2) {
                iVar = inputStream;
                th = e2;
                i = 0;
                try {
                    v.a("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                    if (iVar == null) {
                        i2 = 0;
                    } else {
                        try {
                            iVar.close();
                            i2 = 0;
                        } catch (IOException e3) {
                            i2 = 0;
                        }
                    }
                    hVar.width = i2;
                    hVar.height = i;
                    hVar.fileSize = (int) FileOp.jP(str);
                    return hVar;
                } catch (Throwable th2) {
                    e2 = th2;
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e2;
                }
            } catch (Throwable th3) {
                e2 = th3;
                iVar = inputStream;
                if (iVar != null) {
                    iVar.close();
                }
                throw e2;
            }
            try {
                iVar.mark(1048576);
                BitmapFactory.decodeStream(iVar, null, options);
                iVar.reset();
                Exif exif = new Exif();
                exif.parseFromStream(iVar);
                i = exif.getOrientationInDegree();
                int i3;
                if (i == 90 || i == 270) {
                    try {
                        i3 = options.outWidth;
                        i2 = options.outHeight;
                        i = i3;
                    } catch (Throwable e22) {
                        Throwable th4 = e22;
                        i = i2;
                        th = th4;
                        v.a("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                        if (iVar == null) {
                            iVar.close();
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                        hVar.width = i2;
                        hVar.height = i;
                        hVar.fileSize = (int) FileOp.jP(str);
                        return hVar;
                    }
                }
                i3 = options.outHeight;
                i2 = options.outWidth;
                i = i3;
                if (iVar != null) {
                    try {
                        iVar.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable e222) {
                th = e222;
                i = 0;
                v.a("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                if (iVar == null) {
                    i2 = 0;
                } else {
                    iVar.close();
                    i2 = 0;
                }
                hVar.width = i2;
                hVar.height = i;
                hVar.fileSize = (int) FileOp.jP(str);
                return hVar;
            }
        } catch (Throwable e2222) {
            iVar = inputStream;
            th = e2222;
            i = 0;
            v.a("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
            if (iVar == null) {
                iVar.close();
                i2 = 0;
            } else {
                i2 = 0;
            }
            hVar.width = i2;
            hVar.height = i;
            hVar.fileSize = (int) FileOp.jP(str);
            return hVar;
        } catch (Throwable th5) {
            e2222 = th5;
            iVar = inputStream;
            if (iVar != null) {
                iVar.close();
            }
            throw e2222;
        }
        hVar.width = i2;
        hVar.height = i;
        hVar.fileSize = (int) FileOp.jP(str);
        return hVar;
    }

    private int a(h hVar) {
        String xh = ad.xh();
        String xi = ad.xi();
        v.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[]{xh, xi});
        long currentTimeMillis = System.currentTimeMillis();
        String str = hVar.path;
        int i = hVar.type;
        if (!FileOp.aR(str)) {
            return -1;
        }
        String m = com.tencent.mm.a.g.m((str + System.currentTimeMillis()).getBytes());
        String zN = com.tencent.mm.plugin.sns.data.i.zN(m);
        v.d("MicroMsg.snsMediaStorage", "insert : original img path = " + str);
        if (!FileOp.aR(xi)) {
            v.i("MicroMsg.snsMediaStorage", "create snstmp path " + xi);
            FileOp.jS(xi);
        }
        if (!FileOp.aR(xh)) {
            v.i("MicroMsg.snsMediaStorage", "create snsPath " + xh);
            FileOp.jS(xh);
        }
        h a = a(hVar, str);
        if (!c(xi, str, zN, true)) {
            return -1;
        }
        v.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
        v.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = " + zN);
        int jP = (int) FileOp.jP(xi + zN);
        a = a(a, xi + zN);
        o oVar = new o();
        oVar.jCo = m;
        oVar.dhH = (long) ((int) be.Nh());
        oVar.type = i;
        aie com_tencent_mm_protocal_c_aie = new aie();
        com_tencent_mm_protocal_c_aie.mHR = a.jdU;
        com_tencent_mm_protocal_c_aie.mIm = a.jdT;
        com_tencent_mm_protocal_c_aie.token = a.jdW;
        com_tencent_mm_protocal_c_aie.mIu = a.jdX;
        com_tencent_mm_protocal_c_aie.mIG = 0;
        com_tencent_mm_protocal_c_aie.mIF = new ahz();
        com_tencent_mm_protocal_c_aie.cxZ = 0;
        com_tencent_mm_protocal_c_aie.gkC = a.desc;
        v.d("MicroMsg.snsMediaStorage", "upload.filterId " + a.jdS);
        com_tencent_mm_protocal_c_aie.mIl = a.jdS;
        com_tencent_mm_protocal_c_aie.mII = 2;
        com_tencent_mm_protocal_c_aie.aZy = com.tencent.mm.a.g.aX(xi + zN);
        try {
            oVar.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Exception e) {
            v.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        oVar.aVc();
        oVar.jCn = jP;
        v.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + jP + " filepath: " + xi + zN);
        int insert = (int) this.cuX.insert("SnsMedia", "local_id", oVar.aVb());
        v.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        str = "Locall_path" + insert;
        String zN2 = com.tencent.mm.plugin.sns.data.i.zN(str);
        m = BF(str);
        FileOp.jS(m);
        v.i("MicroMsg.snsMediaStorage", "checkcntpath " + m);
        FileOp.p(xi + zN, m + zN2);
        v.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + m + zN2);
        oVar.jCo = str;
        a(insert, oVar);
        return insert;
    }

    public final h a(h hVar, String str, String str2) {
        o oVar = new o();
        oVar.dhH = (long) ((int) be.Nh());
        oVar.type = hVar.type;
        aie com_tencent_mm_protocal_c_aie = new aie();
        com_tencent_mm_protocal_c_aie.mHR = hVar.jdU;
        com_tencent_mm_protocal_c_aie.mIm = hVar.jdT;
        com_tencent_mm_protocal_c_aie.token = hVar.jdW;
        com_tencent_mm_protocal_c_aie.mIu = hVar.jdX;
        com_tencent_mm_protocal_c_aie.mIG = 0;
        com_tencent_mm_protocal_c_aie.mIF = new ahz();
        com_tencent_mm_protocal_c_aie.cxZ = 0;
        com_tencent_mm_protocal_c_aie.gkC = hVar.desc;
        v.d("MicroMsg.snsMediaStorage", "upload.filterId " + hVar.jdS);
        com_tencent_mm_protocal_c_aie.mIl = hVar.jdS;
        com_tencent_mm_protocal_c_aie.mII = 2;
        com_tencent_mm_protocal_c_aie.bou = str;
        com_tencent_mm_protocal_c_aie.mIK = str2;
        com_tencent_mm_protocal_c_aie.aZy = hVar.jdY;
        try {
            oVar.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Exception e) {
            v.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        oVar.aVc();
        int insert = (int) this.cuX.insert("SnsMedia", "local_id", oVar.aVb());
        String str3 = "Locall_path" + insert;
        v.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        String zN = com.tencent.mm.plugin.sns.data.i.zN(str3);
        String zO = com.tencent.mm.plugin.sns.data.i.zO(str3);
        String zM = com.tencent.mm.plugin.sns.data.i.zM(str3);
        String zP = com.tencent.mm.plugin.sns.data.i.zP(str3);
        String BF = BF(str3);
        FileOp.jS(BF);
        FileOp.p(str2, BF + zN);
        FileOp.p(str2, BF + zO);
        FileOp.p(str2, BF + zM);
        FileOp.p(str, BF + zP);
        com_tencent_mm_protocal_c_aie.bou = BF + zP;
        com_tencent_mm_protocal_c_aie.mIK = BF + zO;
        com_tencent_mm_protocal_c_aie.aZy = hVar.jdY;
        try {
            oVar.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
        } catch (Exception e2) {
            v.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        oVar.jCo = str3;
        a(insert, oVar);
        h a = a(hVar, com_tencent_mm_protocal_c_aie.mIK);
        a.jdV = insert;
        return a;
    }

    public static boolean aVe() {
        if ("hevc".equals(q.dqZ)) {
            return true;
        }
        return ad.aSM();
    }

    public static boolean aVf() {
        if ("wxpc".equals(q.dqZ)) {
            return true;
        }
        return ad.aSN();
    }

    public static boolean Q(String str, String str2, String str3) {
        return c(str, str2, str3, true);
    }

    public static boolean aVg() {
        return jbB >= 1080 && jco >= 1080;
    }

    public static boolean c(String str, String str2, String str3, boolean z) {
        boolean z2;
        Throwable th;
        Throwable th2;
        int i = 0;
        try {
            com.tencent.mm.modelcdntran.g.DZ();
            int jP;
            int i2;
            int i3;
            String value;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            Options JS;
            String str4;
            boolean z3;
            Object obj;
            int i9;
            int i10;
            int i11;
            Exif fromFile;
            int i12;
            Options options;
            InputStream inputStream;
            InputStream iVar;
            DecodeResultLogger decodeResultLogger;
            Bitmap decodeStream;
            if (c.fk(64) || aVe() || aVf()) {
                if (ak.isWifi(aa.getContext())) {
                    i = Integer.valueOf(j.sU().getValue("SnsWebpCompressPicLevelForWifi")).intValue();
                } else if (ak.is2G(aa.getContext())) {
                    i = Integer.valueOf(j.sU().getValue("SnsWebpCompressPicLevelFor2G")).intValue();
                } else {
                    i = Integer.valueOf(j.sU().getValue("SnsWebpCompressPicLevelFor3G")).intValue();
                }
                v.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                if (i <= 10 || i > 100) {
                    i = 50;
                }
                jP = (int) FileOp.jP(str2);
                i2 = 0;
                i3 = 0;
                if (aVg()) {
                    try {
                        if (ak.isWifi(aa.getContext())) {
                            value = j.sU().getValue("SnsCompressResolutionForWifi");
                            i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (ak.is2G(aa.getContext())) {
                            value = j.sU().getValue("SnsCompressResolutionFor3G");
                            i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else {
                            value = j.sU().getValue("SnsCompressResolutionFor2G");
                            i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    try {
                        if (ak.isWifi(aa.getContext())) {
                            value = j.sU().getValue("SnsCompressResolution1080PForWifi");
                            i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else if (ak.is2G(aa.getContext())) {
                            value = j.sU().getValue("SnsCompressResolution1080PFor3G");
                            i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        } else {
                            value = j.sU().getValue("SnsCompressResolution1080PFor2G");
                            i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                            i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                        }
                    } catch (Exception e2) {
                    }
                }
                if (i2 >= i3) {
                    i4 = i3;
                    i3 = i2;
                    i2 = i4;
                }
                if (!z) {
                    i3 = 2048;
                    i2 = 2048;
                }
                v.i("MicroMsg.snsMediaStorage", "server target widht height %d %d screen %d %d comLev: %d is1080p:%s isUpload%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(jbB), Integer.valueOf(jco), Integer.valueOf(i), Boolean.valueOf(r5), Boolean.valueOf(z)});
                if (i3 <= 0 || i2 <= 0 || i3 * i2 > 4194304) {
                    i3 = 960;
                    i2 = 640;
                }
                i5 = be.getInt(j.sU().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i5 <= 0) {
                    i5 = 100;
                }
                i6 = i5 * 1024;
                i5 = be.getInt(j.sU().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
                if (i5 <= 0) {
                    i5 = 200;
                }
                i7 = i5 * 1024;
                i5 = be.getInt(j.sU().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i5 > 0 || i5 >= 100) {
                    i8 = 10;
                } else {
                    i8 = i5;
                }
                JS = d.JS(str2);
                if (JS != null) {
                    str4 = JS.outMimeType;
                    v.d("MicroMsg.snsMediaStorage", "mimetype: " + str4);
                    if (str4 != null) {
                        str4 = str4.toLowerCase();
                        if (str4.indexOf("jpg") >= 0) {
                            z3 = true;
                        } else if (str4.indexOf("jpeg") >= 0) {
                            z3 = true;
                        } else if (str4.indexOf("png") >= 0) {
                            z3 = true;
                        }
                        if (JS != null) {
                            str4 = JS.outMimeType;
                            if (str4 != null) {
                                str4 = str4.toLowerCase();
                                if (str4.indexOf("jpg") < 0) {
                                    obj = 1;
                                } else if (str4.indexOf("jpeg") >= 0) {
                                    i9 = 1;
                                }
                                i5 = -1;
                                if (obj != null) {
                                    i5 = MMNativeJpeg.queryQuality(str2);
                                    if (i5 < i && i5 > 25) {
                                        i10 = i5;
                                        i11 = i5;
                                        i = 0;
                                        if (obj != null) {
                                            try {
                                                fromFile = Exif.fromFile(str2);
                                                if (fromFile != null) {
                                                    i = fromFile.getOrientationInDegree() % 360;
                                                }
                                                i12 = i;
                                            } catch (Exception e3) {
                                                v.e("MicroMsg.snsMediaStorage", "get degree error " + e3.getMessage());
                                            }
                                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                            if ((JS.outWidth < JS.outHeight * 2 || JS.outHeight >= JS.outWidth * 2) && JS.outWidth * JS.outHeight <= 10240000) {
                                                if (jP >= i7 && z3 && i12 == 0) {
                                                    v.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i7);
                                                    if (FileOp.p(str2, str + str3) >= 0) {
                                                        return true;
                                                    }
                                                    return false;
                                                }
                                                options = new Options();
                                                d.a(options);
                                                inputStream = null;
                                                inputStream = FileOp.openRead(str2);
                                                if (inputStream.markSupported() && (inputStream instanceof FileInputStream)) {
                                                    iVar = new i((FileInputStream) inputStream);
                                                } else {
                                                    iVar = inputStream;
                                                }
                                                iVar.mark(1048576);
                                                decodeResultLogger = new DecodeResultLogger();
                                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                                iVar.reset();
                                                if (decodeStream != null) {
                                                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                                                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                                    }
                                                    if (iVar != null) {
                                                        try {
                                                            iVar.close();
                                                        } catch (IOException e4) {
                                                        }
                                                    }
                                                    return false;
                                                }
                                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                                if (z3 || i12 != 0) {
                                                    if (iVar != null) {
                                                        try {
                                                            iVar.close();
                                                        } catch (IOException e5) {
                                                        }
                                                    }
                                                    return true;
                                                }
                                                v.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(jP), Long.valueOf(FileOp.jP(str + str3)), Integer.valueOf(i8)});
                                                if ((((long) jP) - FileOp.jP(str + str3)) * 100 < ((long) (i8 * jP))) {
                                                    FileOp.deleteFile(str + str3);
                                                    z2 = FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                                    if (iVar == null) {
                                                        return z2;
                                                    }
                                                    try {
                                                        iVar.close();
                                                        return z2;
                                                    } catch (IOException e6) {
                                                        return z2;
                                                    }
                                                }
                                                if (iVar != null) {
                                                    try {
                                                        iVar.close();
                                                    } catch (IOException e7) {
                                                    }
                                                }
                                                return true;
                                            } else if (jP < i6 && z3 && i12 == 0) {
                                                v.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i6);
                                                return FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                            } else if ((JS.outWidth > i3 || JS.outHeight > i2) && (JS.outHeight > i3 || JS.outWidth > i2)) {
                                                i = JS.outWidth >= JS.outHeight ? i3 : i2;
                                                if (JS.outWidth < JS.outHeight) {
                                                    i2 = i3;
                                                }
                                                if (JS.outWidth >= JS.outHeight * 2 || JS.outHeight >= JS.outWidth * 2) {
                                                    v.i("MicroMsg.snsMediaStorage", "too max pic " + JS.outWidth + " " + JS.outHeight);
                                                    if (JS.outHeight <= 0) {
                                                        JS.outHeight = 1;
                                                    }
                                                    if (JS.outWidth <= 0) {
                                                        JS.outWidth = 1;
                                                    }
                                                    if (JS.outWidth > JS.outHeight) {
                                                        i = JS.outWidth / JS.outHeight;
                                                    } else {
                                                        i = JS.outHeight / JS.outWidth;
                                                    }
                                                    if (i == 0) {
                                                        i = 1;
                                                    }
                                                    i3 = (int) Math.sqrt((double) (10240000 / i));
                                                    if (JS.outWidth > JS.outHeight) {
                                                        i2 = i3 * i;
                                                    } else {
                                                        i4 = i3;
                                                        i3 *= i;
                                                        i2 = i4;
                                                    }
                                                    v.i("MicroMsg.snsMediaStorage", "new width height " + i2 + " " + i3 + " " + i);
                                                    i4 = i2;
                                                    i2 = i3;
                                                    i3 = i4;
                                                } else {
                                                    i3 = i;
                                                }
                                                z2 = a(str2, i2, i3, CompressFormat.JPEG, i11, str, str3, z);
                                                if (!z3 || i12 != 0) {
                                                    return z2;
                                                }
                                                v.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(jP), Long.valueOf(FileOp.jP(str + str3)), Integer.valueOf(i8)});
                                                if ((((long) jP) - FileOp.jP(str + str3)) * 100 >= ((long) (i8 * jP))) {
                                                    return z2;
                                                }
                                                FileOp.deleteFile(str + str3);
                                                if (FileOp.p(str2, str + str3) >= 0) {
                                                    return true;
                                                }
                                                return false;
                                            } else {
                                                v.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(jP), Integer.valueOf(JS.outWidth), Integer.valueOf(JS.outHeight)});
                                                if (FileOp.jP(str2) < 71680) {
                                                    if (z3) {
                                                        v.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                                                        return FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                                    } else if (JS.outWidth < br.CTRL_INDEX && JS.outHeight < br.CTRL_INDEX) {
                                                        return a(str2, JS.outHeight, JS.outWidth, CompressFormat.PNG, i11, str, str3, z);
                                                    }
                                                }
                                                z2 = a(str2, JS.outHeight, JS.outWidth, CompressFormat.JPEG, i11, str, str3, z);
                                                if (!z3 || i12 != 0) {
                                                    return z2;
                                                }
                                                v.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(jP), Long.valueOf(FileOp.jP(str + str3)), Integer.valueOf(i8)});
                                                if ((((long) jP) - FileOp.jP(str + str3)) * 100 >= ((long) (i8 * jP))) {
                                                    return z2;
                                                }
                                                FileOp.deleteFile(str + str3);
                                                return FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                            }
                                        }
                                        i12 = 0;
                                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                        if (JS.outWidth < JS.outHeight * 2) {
                                        }
                                        if (jP >= i7) {
                                        }
                                        options = new Options();
                                        d.a(options);
                                        inputStream = null;
                                        inputStream = FileOp.openRead(str2);
                                        if (inputStream.markSupported()) {
                                        }
                                        iVar = inputStream;
                                        iVar.mark(1048576);
                                        decodeResultLogger = new DecodeResultLogger();
                                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                        iVar.reset();
                                        if (decodeStream != null) {
                                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                            if (z3) {
                                            }
                                            if (iVar != null) {
                                                iVar.close();
                                            }
                                            return true;
                                        }
                                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                        }
                                        if (iVar != null) {
                                            iVar.close();
                                        }
                                        return false;
                                    }
                                }
                                i10 = i5;
                                i11 = i;
                                i = 0;
                                if (obj != null) {
                                    fromFile = Exif.fromFile(str2);
                                    if (fromFile != null) {
                                        i = fromFile.getOrientationInDegree() % 360;
                                    }
                                    i12 = i;
                                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                    if (JS.outWidth < JS.outHeight * 2) {
                                    }
                                    if (jP >= i7) {
                                    }
                                    options = new Options();
                                    d.a(options);
                                    inputStream = null;
                                    inputStream = FileOp.openRead(str2);
                                    if (inputStream.markSupported()) {
                                    }
                                    iVar = inputStream;
                                    iVar.mark(1048576);
                                    decodeResultLogger = new DecodeResultLogger();
                                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                    iVar.reset();
                                    if (decodeStream != null) {
                                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                        }
                                        if (iVar != null) {
                                            iVar.close();
                                        }
                                        return false;
                                    }
                                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                    if (z3) {
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return true;
                                }
                                i12 = 0;
                                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                if (JS.outWidth < JS.outHeight * 2) {
                                }
                                if (jP >= i7) {
                                }
                                options = new Options();
                                d.a(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported()) {
                                }
                                iVar = inputStream;
                                iVar.mark(1048576);
                                decodeResultLogger = new DecodeResultLogger();
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                    if (z3) {
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return true;
                                }
                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return false;
                            }
                        }
                        obj = null;
                        i5 = -1;
                        if (obj != null) {
                            i5 = MMNativeJpeg.queryQuality(str2);
                            i10 = i5;
                            i11 = i5;
                            i = 0;
                            if (obj != null) {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i = fromFile.getOrientationInDegree() % 360;
                                }
                                i12 = i;
                                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                if (JS.outWidth < JS.outHeight * 2) {
                                }
                                if (jP >= i7) {
                                }
                                options = new Options();
                                d.a(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported()) {
                                }
                                iVar = inputStream;
                                iVar.mark(1048576);
                                decodeResultLogger = new DecodeResultLogger();
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return false;
                                }
                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                if (z3) {
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return true;
                            }
                            i12 = 0;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                if (z3) {
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return true;
                            }
                            if (decodeResultLogger.getDecodeResult() >= 2000) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return false;
                        }
                        i10 = i5;
                        i11 = i;
                        i = 0;
                        if (obj != null) {
                            fromFile = Exif.fromFile(str2);
                            if (fromFile != null) {
                                i = fromFile.getOrientationInDegree() % 360;
                            }
                            i12 = i;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return false;
                            }
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        i12 = 0;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                }
                z3 = false;
                if (JS != null) {
                    str4 = JS.outMimeType;
                    if (str4 != null) {
                        str4 = str4.toLowerCase();
                        if (str4.indexOf("jpg") < 0) {
                            obj = 1;
                        } else if (str4.indexOf("jpeg") >= 0) {
                            i9 = 1;
                        }
                        i5 = -1;
                        if (obj != null) {
                            i5 = MMNativeJpeg.queryQuality(str2);
                            i10 = i5;
                            i11 = i5;
                            i = 0;
                            if (obj != null) {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i = fromFile.getOrientationInDegree() % 360;
                                }
                                i12 = i;
                                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                if (JS.outWidth < JS.outHeight * 2) {
                                }
                                if (jP >= i7) {
                                }
                                options = new Options();
                                d.a(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported()) {
                                }
                                iVar = inputStream;
                                iVar.mark(1048576);
                                decodeResultLogger = new DecodeResultLogger();
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return false;
                                }
                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                if (z3) {
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return true;
                            }
                            i12 = 0;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                if (z3) {
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return true;
                            }
                            if (decodeResultLogger.getDecodeResult() >= 2000) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return false;
                        }
                        i10 = i5;
                        i11 = i;
                        i = 0;
                        if (obj != null) {
                            fromFile = Exif.fromFile(str2);
                            if (fromFile != null) {
                                i = fromFile.getOrientationInDegree() % 360;
                            }
                            i12 = i;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return false;
                            }
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        i12 = 0;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                }
                obj = null;
                i5 = -1;
                if (obj != null) {
                    i5 = MMNativeJpeg.queryQuality(str2);
                    i10 = i5;
                    i11 = i5;
                    i = 0;
                    if (obj != null) {
                        fromFile = Exif.fromFile(str2);
                        if (fromFile != null) {
                            i = fromFile.getOrientationInDegree() % 360;
                        }
                        i12 = i;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            if (decodeResultLogger.getDecodeResult() >= 2000) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return false;
                        }
                        d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                        if (z3) {
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return true;
                    }
                    i12 = 0;
                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                    if (JS.outWidth < JS.outHeight * 2) {
                    }
                    if (jP >= i7) {
                    }
                    options = new Options();
                    d.a(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                        if (z3) {
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return true;
                    }
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return false;
                }
                i10 = i5;
                i11 = i;
                i = 0;
                if (obj != null) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i = fromFile.getOrientationInDegree() % 360;
                    }
                    i12 = i;
                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                    if (JS.outWidth < JS.outHeight * 2) {
                    }
                    if (jP >= i7) {
                    }
                    options = new Options();
                    d.a(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                    if (z3) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                i12 = 0;
                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                if (JS.outWidth < JS.outHeight * 2) {
                }
                if (jP >= i7) {
                }
                options = new Options();
                d.a(options);
                inputStream = null;
                try {
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    try {
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    } catch (Throwable e8) {
                        th = e8;
                        inputStream = iVar;
                        th2 = th;
                        try {
                            v.a("MicroMsg.snsMediaStorage", th2, "Decode bitmap failed: " + str2, new Object[0]);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e9) {
                                }
                            }
                            return false;
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e10) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable e82) {
                        th = e82;
                        inputStream = iVar;
                        th2 = th;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th2;
                    }
                } catch (IOException e11) {
                    th2 = e11;
                    v.a("MicroMsg.snsMediaStorage", th2, "Decode bitmap failed: " + str2, new Object[0]);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return false;
                }
            }
            if (ak.isWifi(aa.getContext())) {
                i = Integer.valueOf(j.sU().getValue("SnsCompressPicLevelForWifi")).intValue();
            } else if (ak.is2G(aa.getContext())) {
                i = Integer.valueOf(j.sU().getValue("SnsCompressPicLevelFor2G")).intValue();
            } else {
                i = Integer.valueOf(j.sU().getValue("SnsCompressPicLevelFor3G")).intValue();
            }
            v.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            i = 50;
            jP = (int) FileOp.jP(str2);
            i2 = 0;
            i3 = 0;
            if (aVg()) {
                if (ak.isWifi(aa.getContext())) {
                    value = j.sU().getValue("SnsCompressResolutionForWifi");
                    i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (ak.is2G(aa.getContext())) {
                    value = j.sU().getValue("SnsCompressResolutionFor3G");
                    i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else {
                    value = j.sU().getValue("SnsCompressResolutionFor2G");
                    i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
                }
            } else if (ak.isWifi(aa.getContext())) {
                value = j.sU().getValue("SnsCompressResolution1080PForWifi");
                i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
            } else if (ak.is2G(aa.getContext())) {
                value = j.sU().getValue("SnsCompressResolution1080PFor3G");
                i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
            } else {
                value = j.sU().getValue("SnsCompressResolution1080PFor2G");
                i2 = Integer.valueOf(value.split("\\*")[0]).intValue();
                i3 = Integer.valueOf(value.split("\\*")[1]).intValue();
            }
            if (i2 >= i3) {
                i4 = i3;
                i3 = i2;
                i2 = i4;
            }
            if (z) {
                i3 = 2048;
                i2 = 2048;
            }
            v.i("MicroMsg.snsMediaStorage", "server target widht height %d %d screen %d %d comLev: %d is1080p:%s isUpload%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(jbB), Integer.valueOf(jco), Integer.valueOf(i), Boolean.valueOf(r5), Boolean.valueOf(z)});
            i3 = 960;
            i2 = 640;
            i5 = be.getInt(j.sU().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
            if (i5 <= 0) {
                i5 = 100;
            }
            i6 = i5 * 1024;
            i5 = be.getInt(j.sU().getValue("PicCompressAvoidanceActiveSizeLong"), 200);
            if (i5 <= 0) {
                i5 = 200;
            }
            i7 = i5 * 1024;
            i5 = be.getInt(j.sU().getValue("PicCompressAvoidanceRemainderPerc"), 10);
            if (i5 > 0) {
            }
            i8 = 10;
            JS = d.JS(str2);
            if (JS != null) {
                str4 = JS.outMimeType;
                v.d("MicroMsg.snsMediaStorage", "mimetype: " + str4);
                if (str4 != null) {
                    str4 = str4.toLowerCase();
                    if (str4.indexOf("jpg") >= 0) {
                        z3 = true;
                    } else if (str4.indexOf("jpeg") >= 0) {
                        z3 = true;
                    } else if (str4.indexOf("png") >= 0) {
                        z3 = true;
                    }
                    if (JS != null) {
                        str4 = JS.outMimeType;
                        if (str4 != null) {
                            str4 = str4.toLowerCase();
                            if (str4.indexOf("jpg") < 0) {
                                obj = 1;
                            } else if (str4.indexOf("jpeg") >= 0) {
                                i9 = 1;
                            }
                            i5 = -1;
                            if (obj != null) {
                                i5 = MMNativeJpeg.queryQuality(str2);
                                i10 = i5;
                                i11 = i5;
                                i = 0;
                                if (obj != null) {
                                    fromFile = Exif.fromFile(str2);
                                    if (fromFile != null) {
                                        i = fromFile.getOrientationInDegree() % 360;
                                    }
                                    i12 = i;
                                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                    if (JS.outWidth < JS.outHeight * 2) {
                                    }
                                    if (jP >= i7) {
                                    }
                                    options = new Options();
                                    d.a(options);
                                    inputStream = null;
                                    inputStream = FileOp.openRead(str2);
                                    if (inputStream.markSupported()) {
                                    }
                                    iVar = inputStream;
                                    iVar.mark(1048576);
                                    decodeResultLogger = new DecodeResultLogger();
                                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                    iVar.reset();
                                    if (decodeStream != null) {
                                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                        }
                                        if (iVar != null) {
                                            iVar.close();
                                        }
                                        return false;
                                    }
                                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                    if (z3) {
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return true;
                                }
                                i12 = 0;
                                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                if (JS.outWidth < JS.outHeight * 2) {
                                }
                                if (jP >= i7) {
                                }
                                options = new Options();
                                d.a(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported()) {
                                }
                                iVar = inputStream;
                                iVar.mark(1048576);
                                decodeResultLogger = new DecodeResultLogger();
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                    if (z3) {
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return true;
                                }
                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return false;
                            }
                            i10 = i5;
                            i11 = i;
                            i = 0;
                            if (obj != null) {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i = fromFile.getOrientationInDegree() % 360;
                                }
                                i12 = i;
                                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                                if (JS.outWidth < JS.outHeight * 2) {
                                }
                                if (jP >= i7) {
                                }
                                options = new Options();
                                d.a(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported()) {
                                }
                                iVar = inputStream;
                                iVar.mark(1048576);
                                decodeResultLogger = new DecodeResultLogger();
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                    }
                                    if (iVar != null) {
                                        iVar.close();
                                    }
                                    return false;
                                }
                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                if (z3) {
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return true;
                            }
                            i12 = 0;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                                if (z3) {
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return true;
                            }
                            if (decodeResultLogger.getDecodeResult() >= 2000) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return false;
                        }
                    }
                    obj = null;
                    i5 = -1;
                    if (obj != null) {
                        i5 = MMNativeJpeg.queryQuality(str2);
                        i10 = i5;
                        i11 = i5;
                        i = 0;
                        if (obj != null) {
                            fromFile = Exif.fromFile(str2);
                            if (fromFile != null) {
                                i = fromFile.getOrientationInDegree() % 360;
                            }
                            i12 = i;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return false;
                            }
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        i12 = 0;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    i10 = i5;
                    i11 = i;
                    i = 0;
                    if (obj != null) {
                        fromFile = Exif.fromFile(str2);
                        if (fromFile != null) {
                            i = fromFile.getOrientationInDegree() % 360;
                        }
                        i12 = i;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            if (decodeResultLogger.getDecodeResult() >= 2000) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return false;
                        }
                        d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                        if (z3) {
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return true;
                    }
                    i12 = 0;
                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                    if (JS.outWidth < JS.outHeight * 2) {
                    }
                    if (jP >= i7) {
                    }
                    options = new Options();
                    d.a(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                        if (z3) {
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return true;
                    }
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return false;
                }
            }
            z3 = false;
            if (JS != null) {
                str4 = JS.outMimeType;
                if (str4 != null) {
                    str4 = str4.toLowerCase();
                    if (str4.indexOf("jpg") < 0) {
                        obj = 1;
                    } else if (str4.indexOf("jpeg") >= 0) {
                        i9 = 1;
                    }
                    i5 = -1;
                    if (obj != null) {
                        i5 = MMNativeJpeg.queryQuality(str2);
                        i10 = i5;
                        i11 = i5;
                        i = 0;
                        if (obj != null) {
                            fromFile = Exif.fromFile(str2);
                            if (fromFile != null) {
                                i = fromFile.getOrientationInDegree() % 360;
                            }
                            i12 = i;
                            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                            if (JS.outWidth < JS.outHeight * 2) {
                            }
                            if (jP >= i7) {
                            }
                            options = new Options();
                            d.a(options);
                            inputStream = null;
                            inputStream = FileOp.openRead(str2);
                            if (inputStream.markSupported()) {
                            }
                            iVar = inputStream;
                            iVar.mark(1048576);
                            decodeResultLogger = new DecodeResultLogger();
                            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                            iVar.reset();
                            if (decodeStream != null) {
                                if (decodeResultLogger.getDecodeResult() >= 2000) {
                                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                }
                                if (iVar != null) {
                                    iVar.close();
                                }
                                return false;
                            }
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        i12 = 0;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                            if (z3) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    i10 = i5;
                    i11 = i;
                    i = 0;
                    if (obj != null) {
                        fromFile = Exif.fromFile(str2);
                        if (fromFile != null) {
                            i = fromFile.getOrientationInDegree() % 360;
                        }
                        i12 = i;
                        v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                        if (JS.outWidth < JS.outHeight * 2) {
                        }
                        if (jP >= i7) {
                        }
                        options = new Options();
                        d.a(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            if (decodeResultLogger.getDecodeResult() >= 2000) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return false;
                        }
                        d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                        if (z3) {
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return true;
                    }
                    i12 = 0;
                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                    if (JS.outWidth < JS.outHeight * 2) {
                    }
                    if (jP >= i7) {
                    }
                    options = new Options();
                    d.a(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                        if (z3) {
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return true;
                    }
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return false;
                }
            }
            obj = null;
            i5 = -1;
            if (obj != null) {
                i5 = MMNativeJpeg.queryQuality(str2);
                i10 = i5;
                i11 = i5;
                i = 0;
                if (obj != null) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i = fromFile.getOrientationInDegree() % 360;
                    }
                    i12 = i;
                    v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                    if (JS.outWidth < JS.outHeight * 2) {
                    }
                    if (jP >= i7) {
                    }
                    options = new Options();
                    d.a(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        if (decodeResultLogger.getDecodeResult() >= 2000) {
                            com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                    if (z3) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                i12 = 0;
                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                if (JS.outWidth < JS.outHeight * 2) {
                }
                if (jP >= i7) {
                }
                options = new Options();
                d.a(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                iVar = inputStream;
                iVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                    if (z3) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                if (decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            }
            i10 = i5;
            i11 = i;
            i = 0;
            if (obj != null) {
                fromFile = Exif.fromFile(str2);
                if (fromFile != null) {
                    i = fromFile.getOrientationInDegree() % 360;
                }
                i12 = i;
                v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
                if (JS.outWidth < JS.outHeight * 2) {
                }
                if (jP >= i7) {
                }
                options = new Options();
                d.a(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                iVar = inputStream;
                iVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return false;
                }
                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                if (z3) {
                }
                if (iVar != null) {
                    iVar.close();
                }
                return true;
            }
            i12 = 0;
            v.i("MicroMsg.snsMediaStorage", "option info " + JS.outWidth + " " + JS.outHeight + " " + z3 + " origQuality: " + i10 + " degree:" + i12 + " filelen " + jP + " target " + i3 + " " + i2);
            if (JS.outWidth < JS.outHeight * 2) {
            }
            if (jP >= i7) {
            }
            options = new Options();
            d.a(options);
            inputStream = null;
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            iVar = inputStream;
            iVar.mark(1048576);
            decodeResultLogger = new DecodeResultLogger();
            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
            iVar.reset();
            if (decodeStream != null) {
                d.a(d.b(decodeStream, (float) i12), i11, CompressFormat.JPEG, str + str3, true);
                if (z3) {
                }
                if (iVar != null) {
                    iVar.close();
                }
                return true;
            }
            if (decodeResultLogger.getDecodeResult() >= 2000) {
                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
            }
            if (iVar != null) {
                iVar.close();
            }
            return false;
        } catch (Exception e12) {
        }
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3, boolean z) {
        Options JS = d.JS(str);
        if (JS == null || JS.outWidth <= 0 || JS.outHeight <= 0) {
            return false;
        }
        return a(str, JS.outWidth, JS.outHeight, i, i2, compressFormat, i3, str2, str3, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean BH(java.lang.String r9) {
        /*
        r6 = 1;
        r0 = 0;
        r7 = 0;
        r0 = com.tencent.mm.modelsfs.FileOp.openRead(r9);	 Catch:{ Exception -> 0x004b, all -> 0x0053 }
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r2.<init>();	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = 1;
        r2.inJustDecodeBounds = r1;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r5 = new int[r5];	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.MMBitmapFactory.decodeStream(r0, r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = r2.outMimeType;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r2 = "MicroMsg.snsMediaStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r4 = "mineType ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r3 = r3.append(r1);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = r1.toLowerCase();	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r2 = "webp";
        r1 = r1.indexOf(r2);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        if (r1 < 0) goto L_0x0044;
    L_0x003d:
        if (r0 == 0) goto L_0x0042;
    L_0x003f:
        r0.close();	 Catch:{ IOException -> 0x005d }
    L_0x0042:
        r0 = r6;
    L_0x0043:
        return r0;
    L_0x0044:
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x005f }
    L_0x0049:
        r0 = r7;
        goto L_0x0043;
    L_0x004b:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0051:
        r0 = r7;
        goto L_0x0043;
    L_0x0053:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();	 Catch:{ IOException -> 0x0063 }
    L_0x005c:
        throw r0;
    L_0x005d:
        r0 = move-exception;
        goto L_0x0042;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0049;
    L_0x0061:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0063:
        r1 = move-exception;
        goto L_0x005c;
    L_0x0065:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.p.BH(java.lang.String):boolean");
    }

    public static boolean a(String str, String str2, String str3, float f) {
        InputStream inputStream;
        Object obj;
        Object obj2;
        double d;
        Object obj3 = 1;
        InputStream inputStream2 = null;
        int i;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        String str4;
        int i2;
        int i3;
        int i4;
        CompressFormat compressFormat;
        try {
            Options options;
            inputStream2 = FileOp.openRead(str + str2);
            try {
                options = new Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(inputStream2, null, options, null, 0, new int[0]);
                inputStream2.close();
            } catch (Exception e) {
                inputStream = inputStream2;
                i = 1;
                d2 = 0.0d;
                d3 = 0.0d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        d4 = d3;
                        obj = obj2;
                        d5 = 240.0d;
                        d6 = d2;
                        d2 = 240.0d;
                        d = d6;
                    } catch (IOException e2) {
                        d4 = d3;
                        obj = obj2;
                        d5 = 240.0d;
                        d6 = d2;
                        d2 = 240.0d;
                        d = d6;
                        str4 = str + str2;
                        i2 = (int) d4;
                        i3 = (int) d;
                        i4 = (int) d5;
                        i = (int) d2;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                    }
                    str4 = str + str2;
                    i2 = (int) d4;
                    i3 = (int) d;
                    i4 = (int) d5;
                    i = (int) d2;
                    if (obj != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                }
                d4 = d3;
                obj = obj2;
                d5 = 240.0d;
                d6 = d2;
                d2 = 240.0d;
                d = d6;
                str4 = str + str2;
                i2 = (int) d4;
                i3 = (int) d;
                i4 = (int) d5;
                i = (int) d2;
                if (obj != null) {
                    compressFormat = CompressFormat.JPEG;
                } else {
                    compressFormat = CompressFormat.PNG;
                }
                return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
            }
            try {
                d4 = (double) options.outWidth;
                d3 = (double) options.outHeight;
                if (d4 > 120.0d || d3 > 120.0d) {
                    obj3 = null;
                }
                try {
                    double d7;
                    double d8;
                    str4 = options.outMimeType;
                    if (d4 < 0.0d || d3 < 0.0d) {
                        d7 = 240.0d;
                        d8 = 240.0d;
                    } else {
                        d7 = d3;
                        d8 = d4;
                    }
                    double d9 = (double) f;
                    double d10 = (double) ((f / 200.0f) * 44.0f);
                    d = (double) ((f / 200.0f) * 160.0f);
                    if (d8 <= 0.0d || d7 <= 0.0d) {
                        d5 = d;
                        d6 = d;
                        d = d3;
                        obj = obj3;
                        d2 = d6;
                        str4 = str + str2;
                        i2 = (int) d4;
                        i3 = (int) d;
                        i4 = (int) d5;
                        i = (int) d2;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                    }
                    d = Math.min(d9 / d8, d9 / d7);
                    d5 = d8 * d;
                    d *= d7;
                    if (d5 < d10) {
                        d7 = (1.0d * d10) / d5;
                        d5 *= d7;
                        d *= d7;
                    }
                    if (d < d10) {
                        d7 = (1.0d * d10) / d;
                        d5 *= d7;
                        d *= d7;
                    }
                    if (d5 > d9) {
                        d5 = d9;
                    }
                    if (d <= d9) {
                        d9 = d;
                    }
                    d = d3;
                    obj = obj3;
                    d2 = d5;
                    d5 = d9;
                    str4 = str + str2;
                    i2 = (int) d4;
                    i3 = (int) d;
                    i4 = (int) d5;
                    i = (int) d2;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                } catch (Exception e3) {
                    inputStream = null;
                    obj2 = obj3;
                    d2 = d3;
                    d3 = d4;
                    if (inputStream != null) {
                        inputStream.close();
                        d4 = d3;
                        obj = obj2;
                        d5 = 240.0d;
                        d6 = d2;
                        d2 = 240.0d;
                        d = d6;
                        str4 = str + str2;
                        i2 = (int) d4;
                        i3 = (int) d;
                        i4 = (int) d5;
                        i = (int) d2;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                    }
                    d4 = d3;
                    obj = obj2;
                    d5 = 240.0d;
                    d6 = d2;
                    d2 = 240.0d;
                    d = d6;
                    str4 = str + str2;
                    i2 = (int) d4;
                    i3 = (int) d;
                    i4 = (int) d5;
                    i = (int) d2;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                }
            } catch (Exception e4) {
                inputStream = null;
                i = 1;
                d2 = 0.0d;
                d3 = 0.0d;
                if (inputStream != null) {
                    inputStream.close();
                    d4 = d3;
                    obj = obj2;
                    d5 = 240.0d;
                    d6 = d2;
                    d2 = 240.0d;
                    d = d6;
                    str4 = str + str2;
                    i2 = (int) d4;
                    i3 = (int) d;
                    i4 = (int) d5;
                    i = (int) d2;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                }
                d4 = d3;
                obj = obj2;
                d5 = 240.0d;
                d6 = d2;
                d2 = 240.0d;
                d = d6;
                str4 = str + str2;
                i2 = (int) d4;
                i3 = (int) d;
                i4 = (int) d5;
                i = (int) d2;
                if (obj != null) {
                    compressFormat = CompressFormat.PNG;
                } else {
                    compressFormat = CompressFormat.JPEG;
                }
                return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
            }
        } catch (Exception e5) {
            inputStream = inputStream2;
            obj2 = 1;
            d2 = 0.0d;
            d3 = 0.0d;
            if (inputStream != null) {
                inputStream.close();
                d4 = d3;
                obj = obj2;
                d5 = 240.0d;
                d6 = d2;
                d2 = 240.0d;
                d = d6;
                str4 = str + str2;
                i2 = (int) d4;
                i3 = (int) d;
                i4 = (int) d5;
                i = (int) d2;
                if (obj != null) {
                    compressFormat = CompressFormat.PNG;
                } else {
                    compressFormat = CompressFormat.JPEG;
                }
                return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
            }
            d4 = d3;
            obj = obj2;
            d5 = 240.0d;
            d6 = d2;
            d2 = 240.0d;
            d = d6;
            str4 = str + str2;
            i2 = (int) d4;
            i3 = (int) d;
            i4 = (int) d5;
            i = (int) d2;
            if (obj != null) {
                compressFormat = CompressFormat.JPEG;
            } else {
                compressFormat = CompressFormat.PNG;
            }
            return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2, String str3, boolean z) {
        OutputStream outputStream = null;
        try {
            Bitmap c;
            v.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                c = a.c(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                v.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                c = a.c(str, options, decodeResultLogger);
            }
            v.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[]{c});
            if (c == null) {
                if (decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                }
                return false;
            }
            v.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(c.getWidth()), Integer.valueOf(c.getHeight())});
            if (z) {
                int ceil;
                int i6;
                if (d < d2) {
                    ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                    i6 = i4;
                } else {
                    i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                    ceil = i3;
                }
                int JQ = ExifHelper.JQ(str);
                if (JQ == 90 || JQ == 270) {
                    int i7 = ceil;
                    ceil = i6;
                    i6 = i7;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(c, i6, ceil, true);
                if (createScaledBitmap != null) {
                    if (c != createScaledBitmap) {
                        l.wk().e(c);
                    }
                    c = createScaledBitmap;
                }
                v.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(c.getWidth()), Integer.valueOf(c.getHeight())});
            }
            outputStream = FileOp.gt(str2 + str3);
            d.a(c, i5, compressFormat, outputStream, false);
            l.wk().e(c);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", new Object[]{str3});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean b(String str, String str2, String str3, float f) {
        try {
            FileOp.deleteFile(str + str3);
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Options JS = d.JS(str + str2);
            if (JS == null) {
                v.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                return false;
            }
            Bitmap c;
            if (JS.outMimeType == null || !(JS.outMimeType.toLowerCase().endsWith("png") || JS.outMimeType.toLowerCase().endsWith("vcodec"))) {
                int i = JS.outWidth;
                int i2 = JS.outHeight;
                int i3 = (int) f;
                int i4 = (int) f;
                JS.inJustDecodeBounds = false;
                v.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                if (i == i3 && i2 == i4) {
                    c = a.c(str + str2, JS, decodeResultLogger);
                } else {
                    int i5;
                    int ceil;
                    if ((((double) i2) * 1.0d) / ((double) i4) > (((double) i) * 1.0d) / ((double) i3)) {
                        i5 = i3;
                        ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                    } else {
                        i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                        ceil = i4;
                    }
                    v.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(ceil)});
                    JS.inSampleSize = 1;
                    if (i2 > ceil || i > i5) {
                        JS.inSampleSize = 1;
                        if (i2 > ceil || i > i5) {
                            double d = (((double) i2) * 1.0d) / ((double) ceil);
                            double d2 = (((double) i) * 1.0d) / ((double) i5);
                            if (d >= d2) {
                                d2 = d;
                            }
                            JS.inSampleSize = (int) d2;
                            if (JS.inSampleSize <= 1) {
                                JS.inSampleSize = 1;
                            }
                        }
                        while (((i2 * i) / JS.inSampleSize) / JS.inSampleSize > 2764800) {
                            JS.inSampleSize++;
                        }
                    }
                    v.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[]{Integer.valueOf(JS.inSampleSize)});
                    Bitmap c2;
                    if (((float) i2) / ((float) i) == ((float) i4) / ((float) i3)) {
                        c2 = a.c(str + str2, JS, decodeResultLogger);
                        v.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
                        c = c2;
                    } else {
                        float max = Math.max(((float) i5) / ((float) i), ((float) ceil) / ((float) i2));
                        int i6 = (int) (((float) i4) / max);
                        int min = Math.min(i, (int) (((float) i3) / max));
                        i6 = Math.min(i2, i6);
                        i5 = (i2 - i6) >> 1;
                        i3 = Math.max(0, (i - min) >> 1);
                        i5 = Math.max(0, i5);
                        Rect rect = new Rect();
                        rect.left = i3;
                        rect.right = i3 + min;
                        rect.top = i5;
                        rect.bottom = i5 + i6;
                        String str4 = str + str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        c2 = l.wk().a(str4, rect, JS, decodeResultLogger);
                        if (c2 != null) {
                            c2 = com.tencent.mm.plugin.sns.data.i.q(str4, c2);
                        }
                        v.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        v.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[]{Integer.valueOf(min), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Float.valueOf(max)});
                        c = c2;
                    }
                }
            } else {
                c = d.a(str + str2, (int) f, (int) f, true, decodeResultLogger, 0);
            }
            if (c == null) {
                v.i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                if (decodeResultLogger.getDecodeResult() >= 2000) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str + str2, 10, decodeResultLogger));
                }
                FileOp.deleteFile(str + str2);
                return false;
            }
            v.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(c.getWidth()), Integer.valueOf(c.getHeight())});
            Object obj = 1;
            if (c.getHeight() > 120 || c.getWidth() > 120) {
                obj = null;
            }
            d.a(c, 100, obj != null ? CompressFormat.PNG : CompressFormat.JPEG, str + str3, false);
            l.wk().e(c);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.snsMediaStorage", e, "", new Object[0]);
        }
    }

    public static Bitmap BI(String str) {
        int i = 640;
        Options JS = d.JS(str);
        int i2 = JS.outWidth >= JS.outHeight ? 960 : 640;
        if (JS.outWidth < JS.outHeight) {
            i = 960;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        Bitmap a = d.a(str, i, i2, false, decodeResultLogger, 0);
        if (a == null) {
            if (decodeResultLogger.getDecodeResult() >= 2000) {
                com.tencent.mm.plugin.report.service.g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
            }
            return null;
        }
        try {
            Exif exif = new Exif();
            exif.parseFromFile(str);
            return d.b(a, (float) exif.getOrientationInDegree());
        } catch (Throwable e) {
            v.a("MicroMsg.snsMediaStorage", e, "parse exif failed: " + str, new Object[0]);
            return a;
        }
    }
}
