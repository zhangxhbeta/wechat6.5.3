package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.al.d;
import com.tencent.mm.al.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ar;
import com.tencent.mm.e.a.bu;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.u;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class j {
    private static int fbA = 0;
    private static int fbB = 0;
    private static j fbC;
    private static String fbh = "";
    private static String fbi = "temp";
    public static String fbj = "newemoji";
    public static String fbk = "panel";
    public static String fbl = "suggest";
    public static String fbm = "egg";
    private static String fbn = "search";
    private static String fbo = "config.conf";
    private static String fbp = "emojipanel.zip";
    private static String fbq = "newemoji.zip";
    private static String fbr = "emoji_template.zip";
    private static String fbs = "emojisuggest.zip";
    private static String fbt = "egg.zip";
    public static String fbu = "newemoji-config.xml";
    public static String fbv = "emojipanel-config.xml";
    public static String fbw = "emojisuggest-config.xml";
    public static String fbx = "egg.xml";
    private static int fby = 0;
    private static int fbz = 0;
    public f fbD;

    public enum a {
        EMOJI,
        PANEL,
        SUGGEST,
        SEARCH,
        EGG
    }

    public static j aff() {
        if (fbC == null) {
            synchronized (j.class) {
                fbC = new j();
            }
        }
        return fbC;
    }

    public static String afg() {
        if (be.kS(fbh)) {
            fbh = e.cnh.replace("/data/user/0", "/data/data");
            fbh += "/emoji";
        }
        return fbh;
    }

    public static boolean a(ar arVar, a aVar, String str) {
        File file = new File(arVar.aYn.filePath);
        if (!file.exists() || file.length() <= 0) {
            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", new Object[]{String.valueOf(aVar), file.getAbsolutePath()});
        File file2 = new File(afg(), str);
        if (file2.exists()) {
            com.tencent.mm.a.e.e(file2);
        }
        switch (aVar) {
            case EMOJI:
                str2 = fbq;
                break;
            case PANEL:
                str2 = fbp;
                break;
            case SEARCH:
                str2 = fbr;
                break;
            case SUGGEST:
                str2 = fbs;
                break;
            case EGG:
                str2 = fbt;
                break;
            default:
                v.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", new Object[]{String.valueOf(aVar)});
                str2 = "";
                break;
        }
        File file3 = new File(file2, str2);
        file2.mkdirs();
        com.tencent.mm.a.e.p(file.getAbsolutePath(), file3.getAbsolutePath());
        int dB = be.dB(file3.getAbsolutePath(), file2.getAbsolutePath());
        b.deleteFile(file3.getPath());
        v.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (dB >= 0) {
            return true;
        }
        return false;
    }

    private static int p(File file) {
        Reader inputStreamReader;
        Throwable e;
        Reader reader;
        InputStream inputStream;
        Throwable th;
        Reader reader2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (file.exists()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    reader = null;
                    inputStream = fileInputStream;
                    try {
                        v.e("MicroMsg.emoji.EmojiResUpdateMgr", be.e(e));
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = inputStream;
                        inputStreamReader = reader2;
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    reader = null;
                    inputStreamReader = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
                try {
                    reader = new BufferedReader(inputStreamReader);
                    try {
                        String str = "";
                        while (true) {
                            String readLine = reader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        }
                        i = new JSONObject(str).getInt("version");
                        v.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                    } catch (Exception e3) {
                        e = e3;
                        reader2 = inputStreamReader;
                        inputStream = fileInputStream;
                        v.e("MicroMsg.emoji.EmojiResUpdateMgr", be.e(e));
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th4) {
                        th = th4;
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    reader = null;
                    reader2 = inputStreamReader;
                    inputStream = fileInputStream;
                    v.e("MicroMsg.emoji.EmojiResUpdateMgr", be.e(e));
                    com.tencent.mm.a.e.c(inputStream);
                    com.tencent.mm.a.e.a(reader2);
                    com.tencent.mm.a.e.a(reader);
                    v.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return i;
                } catch (Throwable th5) {
                    th = th5;
                    reader = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                reader = null;
                inputStream = null;
                v.e("MicroMsg.emoji.EmojiResUpdateMgr", be.e(e));
                com.tencent.mm.a.e.c(inputStream);
                com.tencent.mm.a.e.a(reader2);
                com.tencent.mm.a.e.a(reader);
                v.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return i;
            } catch (Throwable th6) {
                th = th6;
                reader = null;
                inputStreamReader = null;
                fileInputStream = null;
                com.tencent.mm.a.e.c(fileInputStream);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
                throw th;
            }
        }
        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", new Object[]{file.getAbsolutePath()});
        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    public final boolean a(ar arVar, a aVar) {
        int p;
        int intValue;
        if (a(arVar, aVar, fbi)) {
            File file = new File(afg(), fbi);
            v.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            p = p(new File(file, fbo));
        } else {
            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", new Object[]{String.valueOf(aVar)});
            p = -1;
        }
        switch (aVar) {
            case EMOJI:
                ak.yW();
                intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.noU, Integer.valueOf(0))).intValue();
                fby = intValue;
                break;
            case PANEL:
                ak.yW();
                intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.noV, Integer.valueOf(0))).intValue();
                fbz = intValue;
                break;
            case SEARCH:
                intValue = com.tencent.mm.z.a.cGy;
                break;
            case SUGGEST:
                ak.yW();
                intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.noW, Integer.valueOf(0))).intValue();
                fbA = intValue;
                break;
            case EGG:
                ak.yW();
                intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.noX, Integer.valueOf(0))).intValue();
                fbB = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", new Object[]{Integer.valueOf(p), Integer.valueOf(intValue)});
        if (p == -1 || intValue >= p) {
            return false;
        }
        return true;
    }

    public static void q(File file) {
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        parse.normalize();
        NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("emoji");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    s sVar = new s();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        String nodeName = item.getNodeName();
                        if (nodeName.equalsIgnoreCase("key")) {
                            sVar.field_key = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("cn-value")) {
                            if (be.kS(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_cnValue = sVar.field_key;
                            } else {
                                try {
                                    sVar.field_cnValue = item.getTextContent();
                                } catch (Exception e) {
                                    v.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig parseXML exception:%s", new Object[]{e.toString()});
                                    return;
                                }
                            }
                        } else if (nodeName.equalsIgnoreCase("qq-value")) {
                            if (be.kS(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_qqValue = sVar.field_key;
                            } else {
                                sVar.field_qqValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("en-value")) {
                            if (be.kS(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_enValue = sVar.field_key;
                            } else {
                                sVar.field_enValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("tw-value")) {
                            if (be.kS(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_twValue = sVar.field_key;
                            } else {
                                sVar.field_twValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("th-value")) {
                            if (be.kS(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                sVar.field_thValue = sVar.field_key;
                            } else {
                                sVar.field_thValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase(DownloadInfo.FILENAME)) {
                            sVar.field_fileName = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("eggIndex")) {
                            int intValue;
                            try {
                                intValue = Integer.valueOf(item.getTextContent()).intValue();
                            } catch (Throwable e2) {
                                v.e("MicroMsg.emoji.EmojiResUpdateMgr", be.e(e2));
                                intValue = -1;
                            }
                            sVar.field_eggIndex = intValue;
                        } else {
                            continue;
                        }
                    }
                    sVar.field_position = -1;
                    v.d("MicroMsg.emoji.EmojiResUpdateMgr", sVar.toString());
                    if (be.kS(sVar.field_key)) {
                        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is empty");
                    } else {
                        arrayList.add(sVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                v.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig smiley list is null.");
            } else if (com.tencent.mm.pluginsdk.j.a.bmr().t(arrayList)) {
                bu buVar = new bu();
                buVar.aZo.aYp = 1;
                com.tencent.mm.sdk.c.a.nhr.z(buVar);
                fby = p(new File(afg() + File.separator + fbj, fbo));
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.noU, Integer.valueOf(fby));
            }
        }
    }

    public static void r(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || be.kS(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            int i2 = 0;
                            while (i2 < toChars.length) {
                                String str = replaceAll + String.valueOf(toChars[i2]);
                                i2++;
                                replaceAll = str;
                            }
                        }
                        u uVar = new u(i, replaceAll);
                        if (be.kS(uVar.field_key)) {
                            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is null.");
                        } else {
                            arrayList.add(uVar);
                        }
                        v.d("MicroMsg.emoji.EmojiResUpdateMgr", uVar.toString());
                    }
                }
                if (arrayList.isEmpty()) {
                    v.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig smiley panel list is null.");
                } else if (com.tencent.mm.pluginsdk.j.a.bmr().u(arrayList)) {
                    bu buVar = new bu();
                    buVar.aZo.aYp = 2;
                    com.tencent.mm.sdk.c.a.nhr.z(buVar);
                    fbz = p(new File(afg() + File.separator + fbk, fbo));
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.noV, Integer.valueOf(fbz));
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void s(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("group");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    if (childNodes != null && childNodes.getLength() > 0) {
                        int length2 = childNodes.getLength();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Node item = childNodes.item(i2);
                            if (item.getNodeName().equals("word")) {
                                String textContent = item.getTextContent();
                                if (!be.kS(textContent)) {
                                    v.d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", new Object[]{textContent});
                                    arrayList2.add(textContent.trim());
                                }
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
                g.afx().fcr.aa(arrayList);
                fbA = p(new File(afg() + File.separator + fbl, fbo));
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.noW, Integer.valueOf(fbA));
            }
        } catch (Exception e) {
            v.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void t(File file) {
        try {
            String aV = com.tencent.mm.a.e.aV(file.getAbsolutePath());
            Map q = bf.q(aV, "EasterEgg");
            v.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:" + aV);
            if (q == null) {
                v.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                return;
            }
            f fVar = new f();
            fVar.cUk = (double) be.KL((String) q.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (q.get(str + ".$name") != null) {
                    d dVar = new d();
                    dVar.name = be.ma((String) q.get(str + ".$name"));
                    dVar.cUc = be.ma((String) q.get(str + ".$langs"));
                    dVar.cTZ = be.KL((String) q.get(str + ".$reportType"));
                    dVar.cUa = be.KC((String) q.get(str + ".$BeginDate"));
                    dVar.cUb = be.KC((String) q.get(str + ".$EndDate"));
                    dVar.cUd = be.ma((String) q.get(str + ".FileName"));
                    dVar.cUe = be.KL((String) q.get(str + ".AnimType"));
                    dVar.cUf = be.KL((String) q.get(str + ".AnimType.$viewcount"));
                    dVar.cUg = be.KL((String) q.get(str + ".AnimType.$minSize"));
                    dVar.maxSize = be.KL((String) q.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        aV = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = aV + ".$lang";
                        if (q.get(aV) == null) {
                            break;
                        }
                        com.tencent.mm.al.e eVar = new com.tencent.mm.al.e();
                        eVar.cUh = be.ma((String) q.get(aV));
                        eVar.cUi = be.ma((String) q.get(str2));
                        dVar.cTX.add(eVar);
                        i2++;
                    }
                    fVar.cUj.add(dVar);
                    i++;
                } else {
                    byte[] toByteArray = fVar.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.xp()).append("eggingfo.ini").toString(), toByteArray, toByteArray.length);
                    fbB = p(new File(afg() + File.separator + fbm, fbo));
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.noX, Integer.valueOf(fbB));
                    return;
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
    }

    public static boolean b(ar arVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.bf.b.buL();
        com.tencent.mm.bf.b.buO();
        long j = com.tencent.mm.bf.b.buL().nnc;
        com.tencent.mm.bf.b.buL();
        int Li = com.tencent.mm.bf.b.Li(arVar.aYn.filePath);
        com.tencent.mm.bf.b.buL();
        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", new Object[]{Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(Li), Long.valueOf(com.tencent.mm.bf.b.Lh(arVar.aYn.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (Li == 1 && r6 > j) {
            return true;
        }
        v.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
        return false;
    }

    public final f afe() {
        try {
            if (this.fbD == null) {
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                byte[] d = com.tencent.mm.a.e.d(stringBuilder.append(c.xp()).append("eggingfo.ini").toString(), 0, -1);
                if (d == null) {
                    v.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.fbD = (f) new f().az(d);
                }
            }
        } catch (Throwable e) {
            v.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", new Object[]{e.getLocalizedMessage()});
            v.a("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
        return this.fbD;
    }
}
