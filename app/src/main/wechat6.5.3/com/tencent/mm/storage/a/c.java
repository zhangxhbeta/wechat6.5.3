package com.tencent.mm.storage.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

public final class c extends aj {
    protected static a chq;
    public static final String fcI = File.separator;
    public static int nwI = -1;
    public static int nwM = 65;
    public static int nwN = 17;
    public static int nwO = 32;
    public static int nwP = 49;
    public static int nwQ = 50;
    public static int nwR = 81;
    public static int nwS = 1;
    public static int nwT = 2;
    public static int nwU = 3;
    public static int nwV = 4;
    public static int nwW = 10;
    public static int nwX = 11;
    public static int nwY = 0;
    public static int nwZ = 1;
    public static int nxa = 3;
    public static int nxb = 4;
    public static int nxc = 8;
    public static int nxd = 0;
    public static int nxe = 1;
    public static int nxf = 0;
    public static int nxg = 1;
    public static int nxh = 1;
    public final String iay;
    private float lOP = 1.5f;

    static {
        a aVar = new a();
        aVar.ddU = new Field[28];
        aVar.bXK = new String[29];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "md5";
        aVar.nmd.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.nmc = "md5";
        aVar.bXK[1] = "svrid";
        aVar.nmd.put("svrid", "TEXT");
        stringBuilder.append(" svrid TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "catalog";
        aVar.nmd.put("catalog", "INTEGER");
        stringBuilder.append(" catalog INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "type";
        aVar.nmd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "size";
        aVar.nmd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "start";
        aVar.nmd.put("start", "INTEGER");
        stringBuilder.append(" start INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "state";
        aVar.nmd.put("state", "INTEGER");
        stringBuilder.append(" state INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "name";
        aVar.nmd.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "content";
        aVar.nmd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "reserved1";
        aVar.nmd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "reserved2";
        aVar.nmd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "reserved3";
        aVar.nmd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "reserved4";
        aVar.nmd.put("reserved4", "INTEGER");
        stringBuilder.append(" reserved4 INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[13] = "app_id";
        aVar.nmd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "groupId";
        aVar.nmd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "lastUseTime";
        aVar.nmd.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[16] = "framesInfo";
        aVar.nmd.put("framesInfo", "TEXT default '' ");
        stringBuilder.append(" framesInfo TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[17] = "idx";
        aVar.nmd.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[18] = "temp";
        aVar.nmd.put("temp", "INTEGER default '0' ");
        stringBuilder.append(" temp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[19] = "source";
        aVar.nmd.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[20] = "needupload";
        aVar.nmd.put("needupload", "INTEGER default '0' ");
        stringBuilder.append(" needupload INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[21] = "designerID";
        aVar.nmd.put("designerID", "TEXT");
        stringBuilder.append(" designerID TEXT");
        stringBuilder.append(", ");
        aVar.bXK[22] = "thumbUrl";
        aVar.nmd.put("thumbUrl", "TEXT");
        stringBuilder.append(" thumbUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[23] = "cdnUrl";
        aVar.nmd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[24] = "encrypturl";
        aVar.nmd.put("encrypturl", "TEXT");
        stringBuilder.append(" encrypturl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[25] = "aeskey";
        aVar.nmd.put("aeskey", "TEXT");
        stringBuilder.append(" aeskey TEXT");
        stringBuilder.append(", ");
        aVar.bXK[26] = "width";
        aVar.nmd.put("width", "INTEGER default '0' ");
        stringBuilder.append(" width INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[27] = "height";
        aVar.nmd.put("height", "INTEGER default '0' ");
        stringBuilder.append(" height INTEGER default '0' ");
        aVar.bXK[28] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public c() {
        ak.yW();
        this.iay = com.tencent.mm.model.c.wY();
        reset();
    }

    public c(String str) {
        this.iay = str;
        reset();
    }

    public final void reset() {
        this.field_md5 = SQLiteDatabase.KeyEmpty;
        this.field_svrid = SQLiteDatabase.KeyEmpty;
        this.field_catalog = nwN;
        this.field_type = nwS;
        this.field_size = 0;
        this.field_start = 0;
        this.field_state = nwY;
        this.field_name = SQLiteDatabase.KeyEmpty;
        this.field_content = SQLiteDatabase.KeyEmpty;
        this.field_reserved1 = SQLiteDatabase.KeyEmpty;
        this.field_reserved2 = SQLiteDatabase.KeyEmpty;
        this.field_reserved3 = 0;
        this.field_reserved4 = 0;
        this.field_app_id = SQLiteDatabase.KeyEmpty;
        this.field_temp = 0;
    }

    public final byte[] cZ(int i, int i2) {
        InputStream ba;
        Throwable e;
        String str;
        Throwable th;
        if (i < 0 || i2 < 0) {
            return null;
        }
        if (this.field_catalog == nwN || this.field_catalog == nwQ || this.field_catalog == nwP) {
            try {
                v.d("MicroMsg.emoji.EmojiInfo", "get name %s", getName());
                ba = ba(aa.getContext(), getName());
                try {
                    ba.skip((long) i);
                    byte[] bArr = new byte[i2];
                    ba.read(bArr, 0, i2);
                    if (ba == null) {
                        return bArr;
                    }
                    try {
                        ba.close();
                        return bArr;
                    } catch (Throwable e2) {
                        v.e("MicroMsg.emoji.EmojiInfo", "exception:%s", be.e(e2));
                        return bArr;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        v.e("MicroMsg.emoji.EmojiInfo", "exception:%s", be.e(e));
                        if (ba != null) {
                            try {
                                ba.close();
                            } catch (Throwable e4) {
                                v.e("MicroMsg.emoji.EmojiInfo", "exception:%s", be.e(e4));
                            }
                        }
                        str = this.iay + EB();
                        if (bxI()) {
                            str = this.iay + this.field_groupId + File.separator + EB();
                        }
                        return e.c(str, this.field_start, i2);
                    } catch (Throwable th2) {
                        e4 = th2;
                        if (ba != null) {
                            try {
                                ba.close();
                            } catch (Throwable e22) {
                                v.e("MicroMsg.emoji.EmojiInfo", "exception:%s", be.e(e22));
                            }
                        }
                        throw e4;
                    }
                }
            } catch (Throwable e222) {
                th = e222;
                ba = null;
                e4 = th;
                v.e("MicroMsg.emoji.EmojiInfo", "exception:%s", be.e(e4));
                if (ba != null) {
                    ba.close();
                }
                str = this.iay + EB();
                if (bxI()) {
                    str = this.iay + this.field_groupId + File.separator + EB();
                }
                return e.c(str, this.field_start, i2);
            } catch (Throwable e2222) {
                th = e2222;
                ba = null;
                e4 = th;
                if (ba != null) {
                    ba.close();
                }
                throw e4;
            }
        }
        str = this.iay + EB();
        if (bxI()) {
            str = this.iay + this.field_groupId + File.separator + EB();
        }
        return e.c(str, this.field_start, i2);
    }

    public final boolean bxE() {
        if (this.field_catalog == nwN || this.field_catalog == nwQ || this.field_catalog == nwP) {
            return true;
        }
        File file;
        if (be.kS(this.field_groupId)) {
            file = new File(this.iay + EB());
        } else {
            file = new File(this.iay + this.field_groupId + File.separator + EB());
        }
        return file.exists() && file.length() > 0;
    }

    public final void bxF() {
        if (this.field_catalog != nwN && this.field_catalog != nwQ && this.field_catalog != nwP) {
            File file;
            if (be.kS(this.field_groupId)) {
                file = new File(this.iay + EB());
            } else {
                file = new File(this.iay + this.field_groupId + File.separator + EB());
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static InputStream ba(Context context, String str) {
        InputStream inputStream = null;
        if (!(context == null || be.kS(str))) {
            try {
                v.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", str.split("\\.")[0]);
                inputStream = context.getResources().openRawResource(context.getResources().getIdentifier(r1, "drawable", context.getPackageName()));
            } catch (Exception e) {
                v.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", e.getMessage());
            }
        }
        return inputStream;
    }

    public final synchronized Bitmap eg(Context context) {
        return eh(context);
    }

    public final synchronized android.graphics.Bitmap eh(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.storage.a.c.eh(android.content.Context):android.graphics.Bitmap. bs: [B:70:0x0105, B:102:0x01be]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
        r9 = this;
        r5 = 19;
        r1 = 0;
        monitor-enter(r9);
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r3 = com.tencent.mm.bd.a.fromDPToPix(r10, r0);	 Catch:{ all -> 0x0065 }
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0065 }
        r2 = nwN;	 Catch:{ all -> 0x0065 }
        if (r0 == r2) goto L_0x0022;	 Catch:{ all -> 0x0065 }
    L_0x0010:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0065 }
        r2 = com.tencent.mm.storage.a.a.nwK;	 Catch:{ all -> 0x0065 }
        if (r0 == r2) goto L_0x0022;	 Catch:{ all -> 0x0065 }
    L_0x0016:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0065 }
        r2 = nwQ;	 Catch:{ all -> 0x0065 }
        if (r0 == r2) goto L_0x0022;	 Catch:{ all -> 0x0065 }
    L_0x001c:
        r0 = r9.field_catalog;	 Catch:{ all -> 0x0065 }
        r2 = nwP;	 Catch:{ all -> 0x0065 }
        if (r0 != r2) goto L_0x00b8;
    L_0x0022:
        r0 = r9.getName();	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        r2 = r9.field_type;	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        r4 = nwT;	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        if (r2 != r4) goto L_0x003a;	 Catch:{ Exception -> 0x0068, all -> 0x009a }
    L_0x002c:
        r0 = r9.pO();	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        if (r0 == 0) goto L_0x004b;	 Catch:{ Exception -> 0x0068, all -> 0x009a }
    L_0x0036:
        r0 = r9.getName();	 Catch:{ Exception -> 0x0068, all -> 0x009a }
    L_0x003a:
        r2 = ba(r10, r0);	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        r0 = r9.lOP;	 Catch:{ Exception -> 0x0317 }
        r0 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(r2, r0, r3, r3);	 Catch:{ Exception -> 0x0317 }
        if (r2 == 0) goto L_0x0049;
    L_0x0046:
        r2.close();	 Catch:{ IOException -> 0x0050 }
    L_0x0049:
        monitor-exit(r9);
        return r0;
    L_0x004b:
        r0 = r9.pO();	 Catch:{ Exception -> 0x0068, all -> 0x009a }
        goto L_0x003a;
    L_0x0050:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x0065 }
        r4[r5] = r1;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        goto L_0x0049;
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0068:
        r0 = move-exception;
        r2 = r1;
    L_0x006a:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0313 }
        r4 = "exception:%s";	 Catch:{ all -> 0x0313 }
        r5 = 1;	 Catch:{ all -> 0x0313 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0313 }
        r6 = 0;	 Catch:{ all -> 0x0313 }
        r0 = com.tencent.mm.sdk.platformtools.be.e(r0);	 Catch:{ all -> 0x0313 }
        r5[r6] = r0;	 Catch:{ all -> 0x0313 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x0313 }
        if (r2 == 0) goto L_0x00b6;
    L_0x007f:
        r2.close();	 Catch:{ IOException -> 0x0084 }
        r0 = r1;
        goto L_0x0049;
    L_0x0084:
        r0 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r0 = com.tencent.mm.sdk.platformtools.be.e(r0);	 Catch:{ all -> 0x0065 }
        r4[r5] = r0;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        r0 = r1;
        goto L_0x0049;
    L_0x009a:
        r0 = move-exception;
    L_0x009b:
        if (r1 == 0) goto L_0x00a0;
    L_0x009d:
        r1.close();	 Catch:{ IOException -> 0x00a1 }
    L_0x00a0:
        throw r0;	 Catch:{ all -> 0x0065 }
    L_0x00a1:
        r1 = move-exception;	 Catch:{ all -> 0x0065 }
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x0065 }
        r4[r5] = r1;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        goto L_0x00a0;
    L_0x00b6:
        r0 = r1;
        goto L_0x0049;
    L_0x00b8:
        r0 = r9.bxI();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        if (r0 == 0) goto L_0x0129;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x00be:
        r0 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r9.EB();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r9.dR(r0, r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        if (r0 != 0) goto L_0x031d;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x00ca:
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r9.iay;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r9.EB();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = "_0";	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r0;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x00f5:
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x00fa:
        r2 = r0.exists();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        if (r2 == 0) goto L_0x018c;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x0100:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r9.lOP;	 Catch:{ FileNotFoundException -> 0x0306, Exception -> 0x02fb, all -> 0x02ef }
        r0 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(r2, r0, r3, r3);	 Catch:{ FileNotFoundException -> 0x0306, Exception -> 0x02fb, all -> 0x02ef }
        r1 = r2;
    L_0x010c:
        if (r1 == 0) goto L_0x0049;
    L_0x010e:
        r1.close();	 Catch:{ IOException -> 0x0113 }
        goto L_0x0049;
    L_0x0113:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x0065 }
        r4[r5] = r1;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        goto L_0x0049;
    L_0x0129:
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.iay;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r2.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.EB();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r2.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = "_thumb";	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r2.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        goto L_0x00fa;
    L_0x014d:
        r0 = move-exception;
        r2 = r1;
        r8 = r0;
        r0 = r1;
        r1 = r8;
    L_0x0152:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02f8 }
        r4 = "exception:%s";	 Catch:{ all -> 0x02f8 }
        r5 = 1;	 Catch:{ all -> 0x02f8 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02f8 }
        r6 = 0;	 Catch:{ all -> 0x02f8 }
        r7 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x02f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x02f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x02f8 }
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02f8 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r1);	 Catch:{ all -> 0x02f8 }
        if (r2 == 0) goto L_0x0049;
    L_0x0171:
        r2.close();	 Catch:{ IOException -> 0x0176 }
        goto L_0x0049;
    L_0x0176:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x0065 }
        r4[r5] = r1;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        goto L_0x0049;
    L_0x018c:
        r0 = r9.bxI();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        if (r0 == 0) goto L_0x0244;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x0192:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        if (r0 >= r5) goto L_0x031a;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
    L_0x0196:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.iay;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.EB();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r9.lOP;	 Catch:{ FileNotFoundException -> 0x0306, Exception -> 0x02fb, all -> 0x02f2 }
        r1 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(r2, r0, r3, r3);	 Catch:{ FileNotFoundException -> 0x0306, Exception -> 0x02fb, all -> 0x02f2 }
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x01c7:
        r0 = r9.bxI();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        if (r0 == 0) goto L_0x026b;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
    L_0x01cd:
        r0 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = "cpan emojiinfo save cover.";	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        com.tencent.mm.sdk.platformtools.v.d(r0, r3);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r0 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r9.iay;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r9.EB();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = "_cover";	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = r3.append(r4);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = r3.toString();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r0.<init>(r3);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r0 = r0.exists();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        if (r0 != 0) goto L_0x0241;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
    L_0x020b:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        if (r0 >= r5) goto L_0x0241;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
    L_0x020f:
        r0 = 100;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = r9.iay;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = r9.field_groupId;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = java.io.File.separator;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = r9.EB();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = "_cover";	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = 0;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        com.tencent.mm.sdk.platformtools.d.a(r2, r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
    L_0x0241:
        r0 = r2;
        goto L_0x010c;
    L_0x0244:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.iay;	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r4 = r9.EB();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x014d, Exception -> 0x0294, all -> 0x02d3 }
        r0 = r9.lOP;	 Catch:{ FileNotFoundException -> 0x0306, Exception -> 0x02fb, all -> 0x02f5 }
        r1 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(r2, r0, r3, r3);	 Catch:{ FileNotFoundException -> 0x0306, Exception -> 0x02fb, all -> 0x02f5 }
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x01c7;
    L_0x026b:
        r0 = 100;
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = r9.iay;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = r9.EB();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = "_thumb";	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r5 = 0;	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        com.tencent.mm.sdk.platformtools.d.a(r2, r0, r3, r4, r5);	 Catch:{ FileNotFoundException -> 0x030c, Exception -> 0x0300, all -> 0x02d3 }
        r0 = r2;
        goto L_0x010c;
    L_0x0294:
        r0 = move-exception;
        r2 = r1;
        r8 = r0;
        r0 = r1;
        r1 = r8;
    L_0x0299:
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02f8 }
        r4 = "exception:%s";	 Catch:{ all -> 0x02f8 }
        r5 = 1;	 Catch:{ all -> 0x02f8 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02f8 }
        r6 = 0;	 Catch:{ all -> 0x02f8 }
        r7 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x02f8 }
        r5[r6] = r7;	 Catch:{ all -> 0x02f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x02f8 }
        r3 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x02f8 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x02f8 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r1);	 Catch:{ all -> 0x02f8 }
        if (r2 == 0) goto L_0x0049;
    L_0x02b8:
        r2.close();	 Catch:{ IOException -> 0x02bd }
        goto L_0x0049;
    L_0x02bd:
        r1 = move-exception;
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x0065 }
        r4[r5] = r1;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        goto L_0x0049;
    L_0x02d3:
        r0 = move-exception;
    L_0x02d4:
        if (r1 == 0) goto L_0x02d9;
    L_0x02d6:
        r1.close();	 Catch:{ IOException -> 0x02da }
    L_0x02d9:
        throw r0;	 Catch:{ all -> 0x0065 }
    L_0x02da:
        r1 = move-exception;	 Catch:{ all -> 0x0065 }
        r2 = "MicroMsg.emoji.EmojiInfo";	 Catch:{ all -> 0x0065 }
        r3 = "exception:%s";	 Catch:{ all -> 0x0065 }
        r4 = 1;	 Catch:{ all -> 0x0065 }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0065 }
        r5 = 0;	 Catch:{ all -> 0x0065 }
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);	 Catch:{ all -> 0x0065 }
        r4[r5] = r1;	 Catch:{ all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x0065 }
        goto L_0x02d9;
    L_0x02ef:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02d4;
    L_0x02f2:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02d4;
    L_0x02f5:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02d4;
    L_0x02f8:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02d4;
    L_0x02fb:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x0299;
    L_0x0300:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0299;
    L_0x0306:
        r0 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x0152;
    L_0x030c:
        r0 = move-exception;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0152;
    L_0x0313:
        r0 = move-exception;
        r1 = r2;
        goto L_0x009b;
    L_0x0317:
        r0 = move-exception;
        goto L_0x006a;
    L_0x031a:
        r2 = r1;
        goto L_0x01c7;
    L_0x031d:
        r2 = r0;
        goto L_0x00f5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.a.c.eh(android.content.Context):android.graphics.Bitmap");
    }

    public final boolean bnk() {
        return this.field_catalog == nwQ || this.field_catalog == nwP;
    }

    public final boolean bxG() {
        return this.field_catalog == nwN || this.field_catalog == nwQ || this.field_catalog == nwP;
    }

    public final boolean bxH() {
        return this.field_type == nwT || this.field_type == nwW;
    }

    public static boolean vk(int i) {
        return i == nwQ || i == nwP;
    }

    public final boolean bxI() {
        if (!be.kS(this.field_app_id) || be.kS(this.field_groupId) || this.field_groupId.equals(String.valueOf(a.nwK)) || this.field_groupId.equals(String.valueOf(a.nwJ)) || this.field_groupId.equals(String.valueOf(a.nwL)) || this.field_groupId.equals(String.valueOf(nwM))) {
            return false;
        }
        return true;
    }

    public final String EB() {
        return this.field_md5 == null ? SQLiteDatabase.KeyEmpty : this.field_md5;
    }

    public final boolean bxJ() {
        return EB().length() == 32;
    }

    public final int bxK() {
        return this.field_catalog;
    }

    public final String getName() {
        return this.field_name == null ? SQLiteDatabase.KeyEmpty : this.field_name;
    }

    public final String pO() {
        return this.field_content == null ? SQLiteDatabase.KeyEmpty : this.field_content;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean bxL() {
        if (this.field_catalog == nwN || this.field_catalog == a.nwK || this.field_catalog == nwQ || this.field_catalog == nwP) {
            return true;
        }
        File file;
        if (bxI()) {
            String dR = dR(this.field_groupId, EB());
            if (dR == null) {
                dR = this.iay + this.field_groupId + File.separator + EB();
            }
            file = new File(dR);
        } else {
            file = new File(this.iay + EB());
        }
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public final String dR(String str, String str2) {
        if (be.kS(str) && be.kS(str2)) {
            v.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. productid and md5 are null.");
            return null;
        } else if (be.kS(str2)) {
            return null;
        } else {
            if (be.kS(str)) {
                return this.iay + str2;
            }
            return this.iay + str + fcI + str2;
        }
    }

    public final boolean equals(Object obj) {
        return bi(obj);
    }

    public final boolean bi(Object obj) {
        if (obj != null && (obj instanceof c) && ((c) obj).EB().equalsIgnoreCase(this.field_md5)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_md5:").append(this.field_md5).append("\n");
        stringBuilder.append("field_svrid:").append(this.field_svrid).append("\n");
        stringBuilder.append("field_catalog:").append(this.field_catalog).append("\n");
        stringBuilder.append("field_type:").append(this.field_type).append("\n");
        stringBuilder.append("field_size:").append(this.field_size).append("\n");
        stringBuilder.append("field_start:").append(this.field_start).append("\n");
        stringBuilder.append("field_state:").append(this.field_state).append("\n");
        stringBuilder.append("field_name:").append(this.field_name).append("\n");
        stringBuilder.append("field_content:").append(this.field_content).append("\n");
        stringBuilder.append("field_reserved1:").append(this.field_reserved1).append("\n");
        stringBuilder.append("field_reserved2:").append(this.field_reserved2).append("\n");
        stringBuilder.append("field_reserved3:").append(this.field_reserved3).append("\n");
        stringBuilder.append("field_reserved4:").append(this.field_reserved4).append("\n");
        stringBuilder.append("field_app_id:").append(this.field_app_id).append("\n");
        stringBuilder.append("field_groupId:").append(this.field_groupId).append("\n");
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        stringBuilder.append("field_framesInfo:").append(this.field_framesInfo).append("\n");
        stringBuilder.append("field_idx:").append(this.field_idx).append("\n");
        stringBuilder.append("field_temp:").append(this.field_temp).append("\n");
        stringBuilder.append("field_source:").append(this.field_source).append("\n");
        stringBuilder.append("field_needupload:").append(this.field_needupload).append("\n");
        stringBuilder.append("field_designerID:").append(this.field_designerID).append("\n");
        stringBuilder.append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
        return stringBuilder.toString();
    }
}
