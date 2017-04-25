package com.tencent.mm.pluginsdk.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import android.provider.MediaStore.Video.Media;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.d;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class h extends Thread {
    private static HashMap<String, b> lzp = new HashMap();
    private static Object lzq = new byte[0];
    private static ap lzr;
    private String bdo;
    private Context context;
    private boolean eUv;
    private Intent intent;
    private List<String> lzi;
    private int lzj;
    private List<Integer> lzk = new ArrayList();
    private List<String> lzl = new ArrayList();
    private List<String> lzm = new ArrayList();
    private List<Integer> lzn = new ArrayList();
    private a lzo;

    public interface a {
        void bmV();
    }

    private static final class b implements com.tencent.mm.sdk.platformtools.ap.a {
        String aST;
        String dgk;
        int lzj;
        String lzt;
        int lzu;
        VideoTransPara lzv;
        private int lzw;
        private int lzx;
        private boolean lzy;
        String toUser;

        private b() {
        }

        public final boolean AZ() {
            synchronized (h.lzq) {
                Object obj = !h.lzp.containsKey(this.aST) ? 1 : null;
            }
            if (obj == null) {
                obj = p.lp(this.aST) == null ? 1 : null;
            }
            if (obj != null) {
                v.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", this.aST);
                return true;
            }
            if (this.lzv == null || this.lzv.isDefault) {
                int[] iArr = new int[2];
                h.a(this.dgk, iArr);
                this.lzw = iArr[0];
                this.lzx = iArr[1];
            } else {
                this.lzw = this.lzv.width;
                this.lzx = this.lzv.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (ak.yW().wM().a(this.dgk, pString, pInt) && j.dz(pString.value, this.lzt)) {
                v.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
                this.lzu = pInt.value;
                this.lzy = false;
                return true;
            }
            if (this.lzv != null) {
                v.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", this.lzv);
                this.lzu = SightVideoJNI.remuxing(this.dgk, this.lzt, this.lzw, this.lzx, this.lzv.cGx, this.lzv.cGn, 8, this.lzv.cGm, 25.0f, (float) this.lzv.cdg, null, 0);
            } else {
                v.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", this.aST);
                this.lzu = SightVideoJNI.remuxing(this.dgk, this.lzt, this.lzw, this.lzx, com.tencent.mm.plugin.sight.base.b.iTu, com.tencent.mm.plugin.sight.base.b.iTt, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.iTv, null, 0);
            }
            v.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.dgk, this.lzt, Integer.valueOf(this.lzu), Integer.valueOf(this.lzw), Integer.valueOf(this.lzx));
            this.lzy = this.lzu >= 0;
            PInt pInt2 = new PInt();
            if (p.a(this.lzt, pInt2, new PInt())) {
                this.lzu = pInt2.value;
            }
            if (this.lzy) {
                v.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                as wM = ak.yW().wM();
                String str = this.dgk;
                String str2 = this.lzt;
                int i = this.lzu;
                if (be.kS(str) || be.kS(str2)) {
                    v.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", str, str2);
                } else {
                    int aQ = e.aQ(str);
                    int aQ2 = e.aQ(str2);
                    if (aQ <= 0 || aQ2 <= 0) {
                        v.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", Integer.valueOf(aQ), Integer.valueOf(aQ2));
                    } else {
                        String aX = g.aX(str);
                        if (be.kS(aX)) {
                            v.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + aQ);
                        } else {
                            long Nj = be.Nj();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("md5", aX);
                            contentValues.put("size", Integer.valueOf(aQ));
                            contentValues.put("createtime", Long.valueOf(be.Ni()));
                            contentValues.put("remuxing", str2);
                            contentValues.put("duration", Integer.valueOf(i));
                            contentValues.put("status", Integer.valueOf(100));
                            long insert = wM.cie.insert("MediaDuplication", SQLiteDatabase.KeyEmpty, contentValues);
                            v.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", Long.valueOf(insert), Integer.valueOf(aQ), aX, str2, str, Integer.valueOf(i), Long.valueOf(be.az(Nj)));
                        }
                    }
                }
            } else {
                v.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                com.tencent.mm.loader.stub.b.deleteFile(this.lzt);
                j.n(this.dgk, this.lzt, false);
            }
            return true;
        }

        public final boolean Ba() {
            int i;
            synchronized (h.lzq) {
                h.lzp.remove(this.aST);
            }
            if (this.lzy) {
                h.bx(this.lzt, this.lzj);
            } else {
                h.bw(this.lzt, this.lzj);
            }
            h.b(this.lzy, this.dgk, this.lzt);
            if (this.lzj == 1) {
                i = 8;
            } else {
                i = 1;
            }
            com.tencent.mm.as.j.KT().a(this.dgk, this.lzt, this.toUser, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, i, this.lzy ? 1 : 3);
            p.f(this.aST, this.lzu, 43);
            p.lk(this.aST);
            return false;
        }
    }

    static /* synthetic */ void bx(String str, int i) {
        if (i == 2) {
            long aQ = (long) e.aQ(str);
            int f = be.f((Integer) com.tencent.mm.plugin.report.service.g.a((int) (aQ / 1024), new int[]{512, 1024, 2048, 5120, 8192, 10240, 15360, 20480}, 247, (int) WebView.NORMAL_MODE_ALPHA));
            com.tencent.mm.plugin.report.service.g.iuh.a(106, (long) f, 1, false);
            com.tencent.mm.plugin.report.service.g.iuh.a(106, 246, 1, false);
            v.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + f + " file len : " + (aQ / 1024) + "K");
        }
    }

    public h(Context context, List<String> list, Intent intent, String str, int i, a aVar) {
        this.context = context;
        this.lzi = list;
        this.intent = intent;
        this.lzo = aVar;
        this.bdo = str;
        this.lzj = i;
    }

    public final void run() {
        if (this.lzi == null || this.lzi.size() <= 0) {
            s(this.context, this.intent);
        } else {
            for (int i = 0; i < this.lzi.size() && !this.eUv; i++) {
                v.i("MicroMsg.ImportMultiVideo", "start to import %s", this.lzi.get(i));
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.lzi.get(i))));
                s(this.context, intent);
            }
        }
        if (this.lzo != null && !this.eUv) {
            ad.o(new Runnable(this) {
                final /* synthetic */ h lzs;

                {
                    this.lzs = r1;
                }

                public final void run() {
                    a e = this.lzs.lzo;
                    this.lzs.lzk;
                    this.lzs.lzl;
                    this.lzs.lzm;
                    this.lzs.lzn;
                    e.bmV();
                }
            });
        }
    }

    private void s(Context context, Intent intent) {
        String str;
        ak.yW();
        String lb = o.lb((String) c.vf().get(2, SQLiteDatabase.KeyEmpty));
        k.KV();
        String ld = o.ld(lb);
        k.KV();
        String lc = o.lc(lb);
        boolean is2G = com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext());
        if (intent == null || intent.getData() == null) {
            v.e("MicroMsg.GetVideoMetadata", "input invalid");
            str = null;
        } else {
            long Nj = be.Nj();
            str = intent.getDataString();
            v.i("MicroMsg.GetVideoMetadata", "get video file name, dataString " + str);
            if (str == null) {
                v.e("MicroMsg.GetVideoMetadata", "dataString empty");
                str = null;
            } else {
                Cursor query;
                String str2;
                ContentResolver contentResolver = context.getContentResolver();
                if (str.startsWith(Media.EXTERNAL_CONTENT_URI.toString())) {
                    query = contentResolver.query(intent.getData(), null, null, null, null);
                    str2 = null;
                } else {
                    String d;
                    if (str.startsWith("content://")) {
                        d = be.d(context, intent.getData());
                    } else if (str.startsWith("file://")) {
                        if (intent.getExtras() != null) {
                            Uri uri = (Uri) intent.getExtras().getParcelable("android.intent.extra.STREAM");
                            if (!(uri == null || be.kS(uri.getPath()))) {
                                d = uri.getPath();
                                if (d == null) {
                                    d = str.substring(7);
                                }
                            }
                        }
                        d = null;
                        if (d == null) {
                            d = str.substring(7);
                        }
                    } else {
                        d = null;
                    }
                    if (d != null) {
                        r8 = d.startsWith("/storage/emulated/legacy") ? com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() + d.substring(24) : d.startsWith("/sdcard") ? com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() + d.substring(7) : d;
                        query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, "_data LIKE " + DatabaseUtils.sqlEscapeString(r8), null, null);
                        str2 = r8;
                    } else {
                        str2 = d;
                        query = null;
                    }
                }
                if (query != null) {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        if (str2 == null) {
                            str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        }
                    }
                    query.close();
                }
                v.i("MicroMsg.GetVideoMetadata", "get video filename:" + str2 + ", cost time: " + be.az(Nj));
                str = str2;
            }
        }
        if (be.kS(str)) {
            v.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, lb, str, 0, null);
            return;
        }
        VideoTransPara videoTransPara;
        int i;
        Object obj;
        int i2;
        boolean kR = d.kR(str);
        int aQ = e.aQ(str);
        if (kR) {
            VideoTransPara videoTransPara2;
            PInt pInt = new PInt();
            if (com.tencent.mm.modelcontrol.d.En().iw(str)) {
                v.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", str);
                pInt.value = 1;
                com.tencent.mm.plugin.report.service.g.iuh.a(422, 51, 1, false);
                videoTransPara2 = null;
            } else {
                VideoTransPara videoTransPara3 = new VideoTransPara();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                PInt pInt6 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(str, pInt2, pInt3, pInt4, pInt5, pInt6);
                videoTransPara3.duration = pInt2.value / 1000;
                videoTransPara3.width = pInt3.value;
                videoTransPara3.height = pInt4.value;
                videoTransPara3.cdg = pInt5.value;
                videoTransPara3.cGx = pInt6.value;
                v.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", videoTransPara3);
                videoTransPara2 = com.tencent.mm.modelcontrol.d.En().a(videoTransPara3);
                if (videoTransPara2 == null) {
                    v.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", videoTransPara3);
                    pInt.value = -5;
                    videoTransPara2 = null;
                } else {
                    v.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", videoTransPara2);
                    if (videoTransPara3.cGx <= 640000 || videoTransPara2.cGx > videoTransPara3.cGx) {
                        v.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", videoTransPara2, videoTransPara3);
                        pInt.value = 1;
                        videoTransPara2 = null;
                    } else {
                        boolean is2G2 = com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext());
                        pInt.value = SightVideoJNI.shouldRemuxing(str, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 26214400, is2G2 ? 60000.0d : 300000.0d, 1000000);
                    }
                }
            }
            videoTransPara = videoTransPara2;
            i = pInt.value;
        } else {
            if (aQ > (is2G ? 10485760 : 26214400)) {
                i = -5;
                videoTransPara = null;
            } else {
                i = 1;
                videoTransPara = null;
            }
        }
        v.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i), Boolean.valueOf(kR), Integer.valueOf(aQ));
        switch (i) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, lb, str, 0, null);
                return;
            case -5:
                a(-50008, lb, str, 0, null);
                return;
            case -1:
                a(-50007, lb, str, 0, null);
                return;
            case 0:
                obj = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (aQ <= 26214400) {
                    obj = null;
                    i2 = 0;
                    break;
                }
                a(-50002, lb, str, 0, null);
                obj = null;
                i2 = -50002;
                break;
            default:
                v.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, lb, str, 0, null);
                return;
        }
        com.tencent.mm.compatible.i.a.a aVar = null;
        try {
            aVar = com.tencent.mm.compatible.i.a.l(context, intent);
        } catch (Throwable e) {
            v.a("MicroMsg.ImportMultiVideo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        if (aVar == null) {
            v.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, lb, str, 0, null);
            return;
        }
        if (obj == null) {
            j.n(str, lc, false);
            bw(lc, this.lzj);
            b(false, str, lc);
        } else {
            i2 = -50006;
        }
        int ee = be.ee((long) aVar.duration);
        Object obj2 = 1;
        if (aVar.bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(aVar.bitmap, 60, CompressFormat.JPEG, ld, true);
                obj2 = null;
                hM(true);
            } catch (Throwable e2) {
                v.a("MicroMsg.ImportMultiVideo", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                hM(false);
                com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.Q(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, ld, true);
            } catch (Throwable e22) {
                v.a("MicroMsg.ImportMultiVideo", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        if (obj == null && !e.aR(lc)) {
            i2 = -50003;
        }
        if (!e.aR(ld)) {
            i2 = -50004;
        }
        a(i2, lb, str, ee, videoTransPara);
    }

    public final void bmS() {
        this.eUv = true;
        interrupt();
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara) {
        v.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        c(i, str, str2, i2);
        int i3;
        if (i == -50002) {
            i3 = this.lzj == 1 ? 230 : 245;
            v.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i3 + " importType : " + this.lzj);
            com.tencent.mm.plugin.report.service.g.iuh.a(106, (long) i3, 1, false);
            ad.o(new Runnable(this) {
                final /* synthetic */ h lzs;

                {
                    this.lzs = r1;
                }

                public final void run() {
                    Toast.makeText(this.lzs.context, this.lzs.context.getString(2131235788), 0).show();
                }
            });
        } else if (i == -50008) {
            com.tencent.mm.plugin.report.service.g.iuh.a(106, 210, 1, false);
            ad.o(new Runnable(this) {
                final /* synthetic */ h lzs;

                {
                    this.lzs = r1;
                }

                public final void run() {
                    Toast.makeText(this.lzs.context, this.lzs.context.getString(2131235786), 0).show();
                }
            });
        } else if (i == -50006) {
            if (p.a(str, 1, this.bdo, str2, 43) < 0) {
                v.e("MicroMsg.ImportMultiVideo", "prepare");
                ad.o(new Runnable(this) {
                    final /* synthetic */ h lzs;

                    {
                        this.lzs = r1;
                    }

                    public final void run() {
                        Toast.makeText(this.lzs.context, this.lzs.context.getString(2131235787), 0).show();
                    }
                });
                return;
            }
            if (lzr == null) {
                lzr = new ap(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            com.tencent.mm.sdk.platformtools.ap.a bVar = new b();
            synchronized (lzq) {
                lzp.put(str, bVar);
            }
            bVar.aST = str;
            bVar.dgk = str2;
            k.KV();
            bVar.lzt = o.lc(str);
            bVar.lzj = this.lzj;
            bVar.toUser = this.bdo;
            bVar.lzv = videoTransPara;
            lzr.c(bVar);
        } else if (i < 0) {
            i3 = this.lzj == 1 ? 229 : 244;
            v.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i3 + " importType : " + this.lzj);
            com.tencent.mm.plugin.report.service.g.iuh.a(106, (long) i3, 1, false);
            ad.o(new Runnable(this) {
                final /* synthetic */ h lzs;

                {
                    this.lzs = r1;
                }

                public final void run() {
                    Toast.makeText(this.lzs.context, this.lzs.context.getString(2131235787), 0).show();
                }
            });
        } else {
            p.b(str, i2, this.bdo, str2);
            p.lk(str);
            int i4 = this.lzj == 1 ? 8 : 1;
            k.KV();
            com.tencent.mm.as.j.KT().a(str2, o.lc(str), this.bdo, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, i4, 2);
        }
    }

    public static void a(String str, int[] iArr) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int i = be.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = be.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        iArr[0] = i;
        iArr[1] = i2;
        int i3 = 0;
        while (i3 < 3) {
            if (i % 2 == 0 && i2 % 2 == 0) {
                if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                    break;
                }
                i /= 2;
                i2 /= 2;
                i3++;
            } else {
                return;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private synchronized void c(int i, String str, String str2, int i2) {
        this.lzk.add(Integer.valueOf(i));
        this.lzl.add(str);
        this.lzm.add(str2);
        this.lzn.add(Integer.valueOf(i2));
    }

    public static void bmT() {
        synchronized (lzq) {
            int size = lzp.size();
            lzp.clear();
        }
        if (lzr == null) {
            v.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", Integer.valueOf(size));
            return;
        }
        v.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", Integer.valueOf(size), Integer.valueOf(lzr.nkz.size()));
        lzr.nkz.clear();
        lzr = null;
    }

    public static boolean Gq(String str) {
        boolean containsKey;
        synchronized (lzq) {
            containsKey = lzp.containsKey(str);
        }
        v.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", str, Boolean.valueOf(containsKey));
        return containsKey;
    }

    public static void Gr(String str) {
        boolean z = true;
        synchronized (lzq) {
            if (lzp.remove(str) == null) {
                z = false;
            }
            v.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", str, Boolean.valueOf(z));
        }
    }

    private void hM(boolean z) {
        int i;
        if (this.lzj == 1) {
            if (z) {
                i = 217;
            } else {
                i = 218;
            }
        } else if (z) {
            i = 231;
        } else {
            i = 232;
        }
        v.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.lzj);
        com.tencent.mm.plugin.report.service.g.iuh.a(106, (long) i, 1, false);
    }

    private static void bw(String str, int i) {
        int i2;
        int i3;
        int i4;
        if (i == 1) {
            i2 = 219;
            i3 = 228;
            i4 = 220;
        } else {
            i2 = 233;
            i3 = 242;
            i4 = 234;
        }
        long aQ = (long) e.aQ(str);
        i3 = be.f((Integer) com.tencent.mm.plugin.report.service.g.a((int) (aQ / 1024), new int[]{512, 1024, 2048, 5120, 8192, 10240, 15360, 20480}, i4, i3));
        com.tencent.mm.plugin.report.service.g.iuh.a(106, (long) i3, 1, false);
        com.tencent.mm.plugin.report.service.g.iuh.a(106, (long) i2, 1, false);
        v.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i3 + " file len : " + (aQ / 1024) + "K");
    }

    private static void b(boolean z, String str, String str2) {
        int i = 1;
        if (!z) {
            i = 0;
        }
        if (be.kS(str) || be.kS(str2)) {
            v.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            return;
        }
        try {
            long aQ = (long) e.aQ(str);
            long aQ2 = (long) e.aQ(str2);
            int i2 = (int) ((100 * aQ2) / aQ);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(aQ).append(";");
            stringBuilder.append(aQ2).append(";").append(i2);
            v.d("MicroMsg.AtomStatUtil", "report video remuxing : " + stringBuilder.toString());
            com.tencent.mm.plugin.report.service.g.iuh.h(11098, Integer.valueOf(8001), r0);
        } catch (Throwable e) {
            v.a("MicroMsg.AtomStatUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
        }
    }
}
