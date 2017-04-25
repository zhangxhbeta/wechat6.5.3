package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import com.tencent.mm.bj.a;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wenote.c.g;
import com.tencent.mm.plugin.wenote.c.n;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e {
    private static Map<String, String> fLE;
    public static String ltY = (a.bLM() + "/fav_fileicon_video.png");
    public static String ltZ = (a.bLM() + "/fav_fileicon_music.png");
    public static String lua = (a.bLM() + "/fav_list_img_default.png");
    public static String lub = (a.bLM() + "/fav_fileicon_zip.png");
    public static String luc = (a.bLM() + "/fav_fileicon_word.png");
    public static String lud = (a.bLM() + "/fav_fileicon_ppt.png");
    public static String lue = (a.bLM() + "/fav_fileicon_xls.png");
    public static String luf = (a.bLM() + "/fav_fileicon_txt.png");
    public static String lug = (a.bLM() + "/fav_fileicon_pdf.png");
    public static String luh = (a.bLM() + "/fav_fileicon_unknow.png");

    private static void H(JSONObject jSONObject) {
        jb jbVar = new jb();
        jbVar.bjB.type = 6;
        jbVar.bjB.bjE = jSONObject.toString();
        jbVar.bjB.bjt = "";
        com.tencent.mm.sdk.c.a.nhr.z(jbVar);
    }

    public static void h(Context context, String str, int i) {
        if (!be.kS(str) && new File(str).exists()) {
            JSONObject jSONObject = new JSONObject();
            try {
                int au = (int) g.au((long) i);
                jSONObject.put("type", 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", au);
                jSONObject.put("lengthStr", g.F(context, au));
                jSONObject.put("iconPath", a.bLM() + "/fav_fileicon_recording.png");
                H(jSONObject);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void FR(String str) {
        if (!be.kS(str)) {
            File file = new File(str);
            if (file.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, file.getName());
                    jSONObject.put("content", g.N((float) com.tencent.mm.a.e.aQ(str)));
                    jSONObject.put("iconPath", FT(com.tencent.mm.a.e.aS(str)));
                    jSONObject.put("localPath", str);
                    H(jSONObject);
                } catch (Throwable e) {
                    v.a("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void FS(String str) {
        v.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        v.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = a.bLO() + "/" + com.tencent.mm.a.g.m((new b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt("scale"), 1).toString()).getBytes()) + ".png";
        v.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[]{obj});
        if (FileOp.aR(obj)) {
            v.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (com.tencent.mm.a.e.aR(obj)) {
            v.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            v.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[]{obj});
            obj = b.ltL;
        }
        jSONObject.put("localPath", obj);
        H(jSONObject);
    }

    public static void U(ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put("type", 2);
                jSONObject.put("downloaded", true);
                jSONObject.put("bigImagePath", str);
                str = com.tencent.mm.plugin.wenote.d.b.FX(str);
                if (!be.kS(str)) {
                    jSONObject.put("localPath", str);
                    H(jSONObject);
                } else {
                    return;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void aH(Context context, String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (!be.kS(str)) {
            i = (int) n.bmd().dfS;
            int au = (int) g.au((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", g.F(context, au));
                jSONObject.put("iconPath", a.bLM() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put("type", 4);
        } catch (Throwable e2) {
            v.a("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = n.bmd().luB;
        jb jbVar = new jb();
        jbVar.bjB.type = 6;
        jbVar.bjB.bjE = jSONObject.toString();
        jbVar.bjB.bjt = Integer.toString(i);
        com.tencent.mm.sdk.c.a.nhr.z(jbVar);
    }

    static {
        fLE = new HashMap();
        Map hashMap = new HashMap();
        fLE = hashMap;
        hashMap.put("avi", ltY);
        fLE.put("m4v", ltY);
        fLE.put("vob", ltY);
        fLE.put("mpeg", ltY);
        fLE.put("mpe", ltY);
        fLE.put("asx", ltY);
        fLE.put("asf", ltY);
        fLE.put("f4v", ltY);
        fLE.put("flv", ltY);
        fLE.put("mkv", ltY);
        fLE.put("wmv", ltY);
        fLE.put("wm", ltY);
        fLE.put("3gp", ltY);
        fLE.put("mp4", ltY);
        fLE.put("rmvb", ltY);
        fLE.put("rm", ltY);
        fLE.put("ra", ltY);
        fLE.put("ram", ltY);
        fLE.put("mp3pro", ltZ);
        fLE.put("vqf", ltZ);
        fLE.put("cd", ltZ);
        fLE.put("md", ltZ);
        fLE.put("mod", ltZ);
        fLE.put("vorbis", ltZ);
        fLE.put("au", ltZ);
        fLE.put("amr", ltZ);
        fLE.put("silk", ltZ);
        fLE.put("wma", ltZ);
        fLE.put("mmf", ltZ);
        fLE.put("mid", ltZ);
        fLE.put("midi", ltZ);
        fLE.put("mp3", ltZ);
        fLE.put("aac", ltZ);
        fLE.put("ape", ltZ);
        fLE.put("aiff", ltZ);
        fLE.put("aif", ltZ);
        fLE.put("jfif", lua);
        fLE.put("tiff", lua);
        fLE.put("tif", lua);
        fLE.put("jpe", lua);
        fLE.put("dib", lua);
        fLE.put("jpeg", lua);
        fLE.put("jpg", lua);
        fLE.put("png", lua);
        fLE.put("bmp", lua);
        fLE.put("gif", lua);
        fLE.put("rar", lub);
        fLE.put("zip", lub);
        fLE.put("7z", lub);
        fLE.put("iso", lub);
        fLE.put("cab", lub);
        fLE.put("doc", luc);
        fLE.put("docx", luc);
        fLE.put("ppt", lud);
        fLE.put("pptx", lud);
        fLE.put("xls", lue);
        fLE.put("xlsx", lue);
        fLE.put("txt", luf);
        fLE.put("rtf", luf);
        fLE.put("pdf", lug);
        fLE.put("unknown", luh);
    }

    public static String FT(String str) {
        String str2 = (String) fLE.get(str);
        if (str2 == null) {
            return (String) fLE.get("unknown");
        }
        return str2;
    }

    public static String bJ(List<pw> list) {
        String str = "";
        for (pw pwVar : list) {
            if (!pwVar.msU.equals("-1")) {
                str = str.compareTo(pwVar.msU) > 0 ? str : pwVar.msU;
            }
        }
        return str;
    }

    public static String FU(String str) {
        if (be.kS(str) || str.length() == 0) {
            return str;
        }
        return Pattern.compile("\n", 2).matcher(str).replaceAll("").trim();
    }
}
