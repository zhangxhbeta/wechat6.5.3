package com.tencent.mm.modelcontrol;

import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.b;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements ag {
    private static final int cGa = com.tencent.mm.as.a.d.kT("dscp");
    private a cGb = new a();
    private byte[] cGc = null;
    private b cGd;
    private e[] cGe;
    private e[] cGf;
    private e[] cGg;
    private e[] cGh;
    private e[] cGi;

    private d() {
    }

    private e[] iv(String str) {
        int i = 0;
        String value = j.sU().getValue(str);
        if (be.kS(value)) {
            v.i("MicroMsg.SubCoreVideoControl", "key %s config is null", str);
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[" + value;
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        v.i("MicroMsg.SubCoreVideoControl", "%s=%s ", str, value);
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            v.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", Integer.valueOf(length));
            e[] eVarArr = new e[length];
            while (i < length) {
                eVarArr[i] = b(jSONArray.getJSONObject(i));
                i++;
            }
            return eVarArr;
        } catch (Exception e) {
            v.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            return null;
        }
    }

    private static e b(JSONObject jSONObject) {
        e eVar = new e();
        try {
            String str;
            String string = jSONObject.isNull("time") ? SQLiteDatabase.KeyEmpty : jSONObject.getString("time");
            String string2 = jSONObject.getString("abr");
            String string3 = jSONObject.getString("intval");
            String string4 = jSONObject.getString("prof");
            String string5 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                str = "0";
            } else {
                str = jSONObject.getString("stepbr");
            }
            v.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", string, string2, string3, string4, string5, str);
            eVar.a(string, string2, string3, string4, string5, str);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            List arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : SQLiteDatabase.KeyEmpty, jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !eVar.cGo) {
                int i2 = ((f) arrayList.get(0)).cGw;
                for (int i3 = 1; i3 < arrayList.size(); i3++) {
                    f fVar = (f) arrayList.get(i3);
                    fVar.cGv = i2;
                    i2 = fVar.cGw;
                }
            }
            eVar.cGp = new f[arrayList.size()];
            arrayList.toArray(eVar.cGp);
            v.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", eVar);
            return eVar;
        } catch (Exception e) {
            v.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        if (be.kS(str2) || be.kS(str3) || be.kS(str4)) {
            return false;
        }
        try {
            String[] split;
            if (be.kS(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = be.getInt(split[0], -1);
                pInt2.value = be.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    return false;
                }
            }
            split = str2.split("x");
            pInt3.value = be.getInt(split[0], -1);
            pInt4.value = be.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt3.value < 0) {
                return false;
            }
            pInt5.value = be.getInt(str3, -1);
            pInt6.value = be.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                return false;
            }
            pInt6.value *= 1000;
            v.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value));
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    public final byte[] getWeixinMeta() {
        if (be.bl(this.cGc)) {
            try {
                this.cGc = ("{\"WXVer\":" + com.tencent.mm.protocal.d.lWh + "}").getBytes("UTF-8");
                v.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", r0);
            } catch (Exception e) {
                v.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", e.toString());
            }
        }
        return this.cGc;
    }

    public final boolean iw(String str) {
        Exception e;
        Throwable th;
        if (this.cGd == null) {
            this.cGd = new b();
        }
        b bVar = this.cGd;
        bVar.dfL = -1;
        bVar.dfM = -1;
        bVar.dfN = null;
        long Nj = be.Nj();
        long kQ = this.cGd.kQ(str);
        if (kQ <= 0) {
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(kQ);
                byte[] bArr = new byte[8];
                a aVar = null;
                for (a a = com.tencent.mm.as.a.d.a(randomAccessFile, bArr, a.dfB); a != null; a = com.tencent.mm.as.a.d.a(randomAccessFile, bArr, a.dfB)) {
                    aVar = com.tencent.mm.as.a.d.a(randomAccessFile, bArr, cGa);
                    if (aVar != null) {
                        break;
                    }
                    randomAccessFile.seek(a.KI());
                }
                if (aVar != null) {
                    byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                    randomAccessFile.seek(aVar.dfK + 8);
                    if (randomAccessFile.read(bArr2) > 0) {
                        str2 = new String(bArr2, "UTF-8");
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    v.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(kQ), Long.valueOf(be.az(Nj)), str);
                    if (be.kS(str2)) {
                        return str2.contains("WXVer");
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            v.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            v.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(kQ), Long.valueOf(be.az(Nj)), str);
            if (be.kS(str2)) {
                return str2.contains("WXVer");
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        v.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(kQ), Long.valueOf(be.az(Nj)), str);
        if (be.kS(str2)) {
            return str2.contains("WXVer");
        }
        return false;
    }

    public final VideoTransPara Ej() {
        VideoTransPara Ep;
        boolean z;
        VideoTransPara videoTransPara;
        long Nj = be.Nj();
        if (this.cGe == null) {
            this.cGe = iv("C2CRecordVideoConfig");
        }
        if (this.cGe != null) {
            for (e eVar : this.cGe) {
                if (eVar != null && eVar.Eo()) {
                    v.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    Ep = eVar.Ep();
                    z = eVar.cGo;
                    break;
                }
            }
        }
        Ep = null;
        z = true;
        if (Ep == null) {
            Ep = new VideoTransPara();
            Ep.isDefault = true;
            Ep.width = 540;
            Ep.height = 960;
            Ep.cdg = 30;
            Ep.cGx = 1200000;
            Ep.cGl = 1;
            Ep.cGk = 64000;
            Ep.cGm = 2;
            Ep.cGn = 1;
            videoTransPara = Ep;
        } else {
            videoTransPara = Ep;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.cGl = 1;
        videoTransPara.duration = 10;
        if (z) {
            g.iuh.a(422, 12, 1, false);
        } else {
            g.iuh.a(422, 11, 1, false);
        }
        g.iuh.a(422, (long) be.f((Integer) g.a(videoTransPara.cGx / 1000, new int[]{350, 544, 800, 1200, 1600}, 13, 18)), 1, false);
        v.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", Long.valueOf(be.az(Nj)), videoTransPara, Integer.valueOf(r0));
        return videoTransPara;
    }

    public final VideoTransPara Ek() {
        VideoTransPara Ep;
        boolean z;
        VideoTransPara Em;
        long Nj = be.Nj();
        if (this.cGf == null) {
            this.cGf = iv("SnsRecordVideoConfig");
        }
        if (this.cGf != null) {
            for (e eVar : this.cGf) {
                if (eVar != null && eVar.Eo()) {
                    v.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    Ep = eVar.Ep();
                    z = eVar.cGo;
                    break;
                }
            }
        }
        Ep = null;
        z = true;
        if (Ep == null) {
            Em = Em();
        } else {
            Em = Ep;
        }
        Em.audioSampleRate = 44100;
        Em.cGl = 1;
        Em.duration = 10;
        if (z) {
            g.iuh.a(422, 32, 1, false);
        } else {
            g.iuh.a(422, 31, 1, false);
        }
        g.iuh.a(422, (long) be.f((Integer) g.a(Em.cGx / 1000, new int[]{350, 544, 800, 1200, 1600}, 33, 38)), 1, false);
        v.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", Long.valueOf(be.az(Nj)), Em, Integer.valueOf(r0));
        return Em;
    }

    public final VideoTransPara El() {
        VideoTransPara Ep;
        boolean z;
        VideoTransPara Em;
        long Nj = be.Nj();
        if (this.cGg == null) {
            this.cGg = iv("SnsAlbumVideoConfig");
        }
        if (this.cGg != null) {
            for (e eVar : this.cGg) {
                if (eVar != null && eVar.Eo()) {
                    v.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    Ep = eVar.Ep();
                    z = eVar.cGo;
                    break;
                }
            }
        }
        Ep = null;
        z = true;
        if (Ep == null) {
            Em = Em();
        } else {
            Em = Ep;
        }
        Em.audioSampleRate = 44100;
        Em.cGl = 1;
        if (z) {
            g.iuh.a(422, 22, 1, false);
        } else {
            g.iuh.a(422, 21, 1, false);
        }
        g.iuh.a(422, (long) be.f((Integer) g.a(Em.cGx / 1000, new int[]{350, 544, 800, 1200, 1600}, 23, 28)), 1, false);
        v.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", Long.valueOf(be.az(Nj)), Em, Integer.valueOf(r0));
        return Em;
    }

    public final VideoTransPara a(VideoTransPara videoTransPara) {
        if (videoTransPara.duration >= SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
            v.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", Integer.valueOf(SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD));
            return null;
        }
        e[] eVarArr;
        boolean z;
        int i;
        long Nj = be.Nj();
        VideoTransPara fl = fl(videoTransPara.duration);
        int i2 = 1;
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100157");
        if (Ls.isValid()) {
            i2 = be.getInt((String) Ls.buX().get("VideoEncodeStep"), 1);
        }
        v.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", Integer.valueOf(i2));
        if ((i2 > 0 ? 1 : null) != null) {
            if (this.cGi == null) {
                this.cGi = iv("C2CAlbumVideoStepConfig");
            }
            eVarArr = this.cGi;
        } else {
            if (this.cGh == null) {
                this.cGh = iv("C2CAlbumVideoConfig");
            }
            eVarArr = this.cGh;
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null && eVar.Eo()) {
                    v.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                    int a = a.a(eVar.cGp, videoTransPara, fl);
                    z = eVar.cGo;
                    i = a;
                    break;
                }
            }
            z = true;
            i = 0;
        } else {
            v.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
            i = a.a(null, videoTransPara, fl);
            z = true;
        }
        if (i <= 0) {
            fl = fl(videoTransPara.duration);
        } else {
            fl.isDefault = false;
        }
        if (z) {
            g.iuh.a(422, 2, 1, false);
        } else {
            g.iuh.a(422, 1, 1, false);
        }
        g.iuh.a(422, (long) be.f((Integer) g.a(fl.cGx / 1000, new int[]{350, 544, 800, 1200, 1600}, 3, 8)), 1, false);
        v.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", Long.valueOf(be.az(Nj)), Integer.valueOf(i2), Integer.valueOf(i), fl, videoTransPara);
        return fl;
    }

    private static VideoTransPara Em() {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 540;
        videoTransPara.height = 960;
        videoTransPara.cdg = 30;
        videoTransPara.cGx = 1600000;
        videoTransPara.cGl = 1;
        videoTransPara.cGk = 64000;
        videoTransPara.cGm = 2;
        videoTransPara.cGn = 1;
        return videoTransPara;
    }

    private static VideoTransPara fl(int i) {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.cGl = 1;
        videoTransPara.cGk = 48000;
        videoTransPara.cGm = 2;
        videoTransPara.cGn = 1;
        if (i <= 120) {
            videoTransPara.cdg = 30;
            videoTransPara.width = 540;
            videoTransPara.height = 960;
            videoTransPara.cGx = 1200000;
        } else {
            videoTransPara.cdg = 24;
            videoTransPara.width = 360;
            videoTransPara.height = 640;
            videoTransPara.cGx = 544000;
        }
        return videoTransPara;
    }

    public static d En() {
        d dVar = (d) ak.yP().fY(d.class.getName());
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        ak.yP().a(d.class.getName(), dVar2);
        return dVar2;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        this.cGe = null;
        this.cGf = null;
    }
}
