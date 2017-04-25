package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.a;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wenote.c.c;
import com.tencent.mm.plugin.wenote.c.e;
import com.tencent.mm.plugin.wenote.c.f;
import com.tencent.mm.plugin.wenote.c.g;
import com.tencent.mm.plugin.wenote.c.h;
import com.tencent.mm.plugin.wenote.c.i;
import com.tencent.mm.plugin.wenote.c.k;
import com.tencent.mm.plugin.wenote.c.l;
import com.tencent.mm.plugin.wenote.c.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b {
    public static HashMap<String, g> ltA = new HashMap();
    public static HashMap<String, e> ltB = new HashMap();
    public static String ltF = "";
    public static HashMap<String, JSONArray> ltG = new HashMap();
    public static String ltI = (a.bLM() + "/fav_fileicon_recording.png");
    private static String ltJ = (a.bLM() + "/ofm_file_icon.png");
    static String ltK = (a.bLM() + "/app_attach_file_icon_pic.png");
    public static String ltL = (a.bLM() + "/location_msg.png");
    public static String ltM = (a.bLM() + "/note_fav_not_support.png");
    public static f ltz;
    public String bjI = "WeNote_0";
    private Runnable fNf = new Runnable(this) {
        final /* synthetic */ b ltN;

        {
            this.ltN = r1;
        }

        public final void run() {
            v.d("MicroMsg.WNNoteBase", "refresh adapter");
        }
    };
    public boolean lsA = false;
    public HashMap<String, String> lsz = new HashMap();
    public HashMap<String, pw> ltC = new HashMap();
    public HashMap<String, e> ltD = new HashMap();
    public String ltE = "";
    public qf ltH = new qf();
    public com.tencent.mm.plugin.wenote.ui.a.a lty = null;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b ltN;
        final /* synthetic */ String ltP;

        public AnonymousClass3(b bVar, String str) {
            this.ltN = bVar;
            this.ltP = str;
        }

        public final void run() {
            b.a(this.ltN, this.ltP);
        }
    }

    public abstract void FN(String str);

    public abstract void FO(String str);

    public abstract void FP(String str);

    public abstract String f(pw pwVar);

    public abstract void m(pw pwVar);

    static /* synthetic */ void a(b bVar, String str) {
        List linkedList = new LinkedList();
        linkedList.add(bVar.ltD.get(str));
        qf i = i(null, linkedList);
        if (i.mtR != null && i.mtR.size() > 0 && bVar.ltH != null) {
            bVar.ltH.mtR.add(i.mtR.get(0));
            ((e) bVar.ltD.get(str)).luu = ((pw) i.mtR.get(0)).luu;
            g.bmc();
        }
    }

    public final void cS(Context context) {
        String bLN = a.bLN();
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("key_load_js_without_delay", true);
        intent.putExtra("showShare", false);
        intent.putExtra("from_session", blY());
        intent.putExtra("edit_status", this.lsA);
        intent.putExtra("rawUrl", "file://" + bLN + "/WNNote.html");
        r(context, intent);
    }

    public final void blW() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ b ltN;

            {
                this.ltN = r1;
            }

            public final void run() {
                b bVar = this.ltN;
                List<pw> list = this.ltN.lty.ipS;
                g gVar = new g();
                for (pw pwVar : list) {
                    bVar.ltC.put(pwVar.luu, pwVar);
                    e eVar = new e();
                    eVar.lut = pwVar.msU;
                    String a;
                    if (!be.kS(eVar.lut)) {
                        if (!eVar.lut.equals("-1")) {
                            if (!eVar.lut.equals("WeNoteHtmlFile")) {
                                int i = be.getInt(eVar.lut.substring(7), 0);
                                int i2 = be.getInt(bVar.bjI.substring(7), 0);
                                bVar.bjI = "WeNote_" + (i2 > i ? String.valueOf(i2) : String.valueOf(i));
                                eVar.luu = pwVar.luu;
                                String f;
                                switch (pwVar.aKG) {
                                    case 2:
                                        h hVar = new h();
                                        hVar.lut = eVar.lut;
                                        hVar.type = 2;
                                        hVar.luu = eVar.luu;
                                        hVar.lus = pwVar;
                                        f = bVar.f(pwVar);
                                        if (be.kS(f) || !com.tencent.mm.a.e.aR(f)) {
                                            bVar.m(pwVar);
                                            hVar.luv = false;
                                            hVar.bjG = b.ltK;
                                            bVar.lsz.put(pwVar.luu, eVar.lut);
                                        } else {
                                            hVar.luv = true;
                                            hVar.bjG = com.tencent.mm.plugin.wenote.d.b.FX(f);
                                        }
                                        hVar.luw = f;
                                        b.ltB.put(hVar.lut, hVar);
                                        gVar.lun.add(hVar);
                                        bVar.ltD.put(eVar.lut, hVar);
                                        break;
                                    case 3:
                                        m mVar = new m();
                                        mVar.lut = eVar.lut;
                                        mVar.type = 4;
                                        mVar.luu = eVar.luu;
                                        mVar.lus = pwVar;
                                        f = bVar.f(pwVar);
                                        if (be.kS(f) || !com.tencent.mm.a.e.aR(f)) {
                                            bVar.m(pwVar);
                                            mVar.luv = false;
                                            mVar.luz = aa.getContext().getString(2131232759);
                                            bVar.lsz.put(pwVar.luu, eVar.lut);
                                        } else {
                                            mVar.bjG = f;
                                            mVar.luv = true;
                                            mVar.bjJ = b.ltI;
                                            mVar.length = (int) g.au((long) pwVar.duration);
                                        }
                                        mVar.luy = g.F(aa.getContext(), mVar.length);
                                        mVar.bdX = pwVar.duration;
                                        ez ezVar = new ez();
                                        ezVar.bdQ.type = 17;
                                        ezVar.bdQ.bdS = pwVar;
                                        com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                                        mVar.bdW = ezVar.bdR.ret;
                                        b.ltB.put(mVar.lut, mVar);
                                        gVar.lun.add(mVar);
                                        bVar.ltD.put(eVar.lut, mVar);
                                        break;
                                    case 6:
                                        d dVar = new d();
                                        dVar.bhs = (float) pwVar.msM.mta.lat;
                                        dVar.cNt = (float) pwVar.msM.mta.lng;
                                        dVar.bhu = pwVar.msM.mta.bhu;
                                        dVar.ltV = pwVar.msM.mta.label;
                                        dVar.ltW = pwVar.msM.mta.bkV;
                                        dVar.ltX = pwVar.msU;
                                        a = com.tencent.mm.plugin.wenote.d.b.a(dVar);
                                        if (com.tencent.mm.a.e.aR(a)) {
                                            v.i("MicroMsg.WNNoteBase", "fileExist suc, use getimagelocalpath");
                                        } else {
                                            v.e("MicroMsg.WNNoteBase", "Temp file fileExist fail:%s ,use default file", new Object[]{a});
                                            a = b.ltL;
                                        }
                                        i iVar = new i();
                                        iVar.lut = eVar.lut;
                                        iVar.type = 3;
                                        iVar.luu = eVar.luu;
                                        iVar.lus = pwVar;
                                        iVar.luv = true;
                                        iVar.gUr = dVar.ltW;
                                        iVar.cJf = dVar.ltV;
                                        iVar.lat = (double) dVar.bhs;
                                        iVar.lng = (double) dVar.cNt;
                                        iVar.lux = (double) dVar.bhu;
                                        iVar.bjG = a;
                                        b.ltB.put(iVar.lut, iVar);
                                        gVar.lun.add(iVar);
                                        bVar.ltD.put(eVar.lut, iVar);
                                        break;
                                    case 8:
                                        l lVar = new l();
                                        lVar.lut = eVar.lut;
                                        lVar.type = 5;
                                        lVar.luu = eVar.luu;
                                        lVar.lus = pwVar;
                                        f = bVar.f(pwVar);
                                        if (be.kS(f) || !com.tencent.mm.a.e.aR(f)) {
                                            lVar.luv = false;
                                            bVar.lsz.put(pwVar.luu, eVar.lut);
                                        } else {
                                            lVar.luv = true;
                                            lVar.bjG = f;
                                        }
                                        lVar.bjJ = e.FT(pwVar.msh);
                                        lVar.title = pwVar.title;
                                        lVar.content = pwVar.desc;
                                        if (be.kS(lVar.content)) {
                                            lVar.content = g.N((float) pwVar.msn);
                                        }
                                        b.ltB.put(lVar.lut, lVar);
                                        gVar.lun.add(lVar);
                                        bVar.ltD.put(eVar.lut, lVar);
                                        break;
                                    default:
                                        c cVar = new c();
                                        cVar.lut = eVar.lut;
                                        cVar.type = 0;
                                        cVar.luu = eVar.luu;
                                        cVar.lus = pwVar;
                                        String f2 = bVar.f(pwVar);
                                        cVar.luv = true;
                                        cVar.bjG = f2;
                                        cVar.bjJ = b.ltM;
                                        cVar.title = aa.getContext().getResources().getString(2131232715);
                                        cVar.content = aa.getContext().getResources().getString(2131232696);
                                        b.ltB.put(cVar.lut, cVar);
                                        gVar.lun.add(cVar);
                                        bVar.ltD.put(eVar.lut, cVar);
                                        break;
                                }
                            }
                            a = bVar.f(pwVar);
                            if (be.kS(a) || !com.tencent.mm.a.e.aR(a)) {
                                bVar.m(pwVar);
                                bVar.lsz.put(pwVar.luu, eVar.lut);
                            } else {
                                try {
                                    gVar.bjD = be.e(new FileInputStream(a));
                                    b.ltG.containsKey(gVar.bjD);
                                } catch (Throwable e) {
                                    v.a("MicroMsg.WNNoteBase", e, "", new Object[0]);
                                }
                            }
                        }
                    } else {
                        v.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                        a = bVar.f(pwVar);
                        if (be.kS(a) || !com.tencent.mm.a.e.aR(a)) {
                            bVar.m(pwVar);
                        } else {
                            g.m(bVar.lty.bjH, a);
                        }
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 ltO;

                            {
                                this.ltO = r1;
                            }

                            public final void run() {
                                JSONArray blX = this.ltO.ltN.blX();
                                if (!be.kS(this.ltO.ltN.ltE)) {
                                    jb jbVar = new jb();
                                    jbVar.bjB.type = 0;
                                    jbVar.bjB.bjF = blX;
                                    jbVar.bjB.bjD = this.ltO.ltN.ltE;
                                    jbVar.bjB.bjH = this.ltO.ltN.lty.bjH;
                                    jbVar.bjB.bjI = this.ltO.ltN.bjI;
                                    com.tencent.mm.sdk.c.a.nhr.z(jbVar);
                                }
                            }
                        });
                    }
                }
                if (bVar.lty.bao == -1) {
                    b.ltA.put(Long.toString(bVar.lty.bjH), gVar);
                } else {
                    b.ltA.put(Long.toString(bVar.lty.bao), gVar);
                }
                ad.o(/* anonymous class already generated */);
            }

            public final String toString() {
                return super.toString() + "|dealWNoteInfo";
            }
        });
    }

    public final JSONArray blX() {
        g gVar;
        JSONArray jSONArray = new JSONArray();
        if (this.lty.bao != -1) {
            gVar = (g) ltA.get(Long.toString(this.lty.bao));
        } else {
            gVar = (g) ltA.get(Long.toString(this.lty.bjH));
        }
        if (gVar == null) {
            return null;
        }
        this.ltE = gVar.bjD;
        ltF = this.ltE;
        for (e eVar : gVar.lun) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localEditorId", eVar.lut);
                jSONObject.put("type", eVar.type);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteBase", e, "", new Object[0]);
            }
            switch (eVar.type) {
                case 1:
                    break;
                case 2:
                    try {
                        jSONObject.put("width", ((h) eVar).width);
                        jSONObject.put("height", ((h) eVar).height);
                        jSONObject.put("downloaded", eVar.luv);
                        jSONObject.put("localPath", eVar.bjG);
                        break;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                        break;
                    }
                case 3:
                    try {
                        jSONObject.put("downloaded", eVar.luv);
                        if (eVar.bjG.endsWith("_temp.png")) {
                            String replaceAll = eVar.bjG.replaceAll("_temp.png", ".png");
                            if (com.tencent.mm.a.e.aR(replaceAll)) {
                                v.d("MicroMsg.WNNoteBase", "wenote location thumb use thumbfile");
                                jSONObject.put("localPath", replaceAll);
                            } else {
                                jSONObject.put("localPath", eVar.bjG);
                            }
                        } else {
                            jSONObject.put("localPath", eVar.bjG);
                        }
                        jSONObject.put("poiName", ((i) eVar).gUr);
                        jSONObject.put("address", ((i) eVar).cJf);
                        jSONObject.put("lat", ((i) eVar).lat);
                        jSONObject.put("lng", ((i) eVar).lng);
                        break;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.WNNoteBase", e22, "", new Object[0]);
                        break;
                    }
                case 4:
                    try {
                        jSONObject.put("downloaded", eVar.luv);
                        if (!eVar.luv) {
                            jSONObject.put("lengthStr", ((m) eVar).luy);
                            jSONObject.put("placeHolder", ((m) eVar).luz);
                            break;
                        }
                        jSONObject.put("length", ((m) eVar).length);
                        jSONObject.put("lengthStr", ((m) eVar).luy);
                        jSONObject.put("iconPath", ((m) eVar).bjJ);
                        jSONObject.put("localPath", ((m) eVar).bjG);
                        break;
                    } catch (Throwable e222) {
                        v.a("MicroMsg.WNNoteBase", e222, "", new Object[0]);
                        break;
                    }
                case 5:
                    try {
                        jSONObject.put("downloaded", eVar.luv);
                        jSONObject.put("localPath", eVar.bjG);
                        jSONObject.put("iconPath", ((l) eVar).bjJ);
                        jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, ((l) eVar).title);
                        jSONObject.put("content", ((l) eVar).content);
                        break;
                    } catch (Throwable e2222) {
                        v.a("MicroMsg.WNNoteBase", e2222, "", new Object[0]);
                        break;
                    }
                default:
                    try {
                        jSONObject.put("downloaded", eVar.luv);
                        jSONObject.put("localPath", eVar.bjG);
                        jSONObject.put("iconPath", ((c) eVar).bjJ);
                        jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_TITLE, ((c) eVar).title);
                        jSONObject.put("content", ((c) eVar).content);
                        break;
                    } catch (Throwable e22222) {
                        v.a("MicroMsg.WNNoteBase", e22222, "", new Object[0]);
                        break;
                    }
            }
            jSONArray.put(jSONObject);
        }
        ltG.put(this.ltE, jSONArray);
        return jSONArray;
    }

    public boolean blY() {
        return false;
    }

    public void r(Context context, Intent intent) {
        com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.wenote.WNNoteWebViewUI", intent);
    }

    public static void aB(String str, boolean z) {
        List arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("html");
            boolean z2 = jSONObject.getBoolean("isSuccess");
            if (z || !string.equals(ltF)) {
                int i;
                JSONArray jSONArray = jSONObject.getJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                if (jSONArray != null) {
                    for (i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            arrayList.add(ltB.get(jSONObject2.getString("localEditorId")));
                        } else {
                            v.e("MicroMsg.WNNoteBase", "jsonArray.getJSONObject(%d) is null", new Object[]{Integer.valueOf(i)});
                        }
                    }
                }
                if (z2) {
                    ArrayList FW = com.tencent.mm.plugin.wenote.d.a.FW(string);
                    String str2 = " ";
                    if (FW != null && FW.size() == 1) {
                        str2 = e.FU((String) FW.get(0));
                    }
                    if (FW != null && !be.kS(r0)) {
                        if (FW != null) {
                            if (FW.size() > 0) {
                                Iterator it = FW.iterator();
                                int i2 = 0;
                                while (it.hasNext()) {
                                    str2 = (String) it.next();
                                    if (str2.equals("[ThisisNoteNodeObj]")) {
                                        i2++;
                                    } else {
                                        str2 = str2.trim();
                                        if (str2.length() <= 0) {
                                            i = i2;
                                        } else if (i2 > arrayList.size()) {
                                            v.e("MicroMsg.WNNoteBase", "WeNote: index out of array");
                                            break;
                                        } else {
                                            k kVar = new k();
                                            kVar.content = str2;
                                            arrayList.add(i2, kVar);
                                            i = i2 + 1;
                                        }
                                        i2 = i;
                                    }
                                }
                            }
                        }
                        byte[] bytes = string.getBytes();
                        String bLP = a.bLP();
                        File file = new File(bLP);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        if (com.tencent.mm.a.e.b(bLP, bytes, bytes.length) == 0) {
                            qf i3 = i(string, arrayList);
                            ez ezVar;
                            if (z) {
                                ezVar = new ez();
                                ezVar.bdQ.type = 19;
                                ezVar.bdQ.aZf = i3;
                                ezVar.bdQ.title = string;
                                ezVar.bdQ.aZa = -1;
                                com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                            } else {
                                ezVar = new ez();
                                ezVar.bdQ.type = 19;
                                ezVar.bdQ.aZf = i3;
                                ezVar.bdQ.title = string;
                                ezVar.bdQ.aZa = ltz.field_localId;
                                com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                            }
                            v.i("MicroMsg.WNNoteBase", "write html to file suc");
                        }
                    } else if (!z) {
                        ez ezVar2 = new ez();
                        ezVar2.bdQ.type = 12;
                        ezVar2.bdQ.aZa = ltz.field_localId;
                        com.tencent.mm.sdk.c.a.nhr.z(ezVar2);
                    }
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.WNNoteBase", e, "", new Object[0]);
        } catch (Throwable e2) {
            v.a("MicroMsg.WNNoteBase", e2, "", new Object[0]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.protocal.c.qf i(java.lang.String r11, java.util.List<com.tencent.mm.plugin.wenote.c.e> r12) {
        /*
        r7 = new java.util.LinkedList;
        r7.<init>();
        r8 = new com.tencent.mm.protocal.c.qf;
        r8.<init>();
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r11);
        if (r0 != 0) goto L_0x0042;
    L_0x0010:
        r0 = r11.length();
        if (r0 <= 0) goto L_0x0042;
    L_0x0016:
        r0 = com.tencent.mm.bj.a.bLP();
        r1 = new com.tencent.mm.protocal.c.pw;
        r1.<init>();
        r2 = 8;
        r1.uG(r2);
        r2 = "WeNoteHtmlFile";
        r1.IT(r2);
        r1.IK(r0);
        r2 = 1;
        r1.ip(r2);
        r0 = com.tencent.mm.a.e.aQ(r0);
        r2 = (long) r0;
        r1.dQ(r2);
        r0 = ".htm";
        r1.IG(r0);
        r7.add(r1);
    L_0x0042:
        r9 = r12.iterator();
    L_0x0046:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x0148;
    L_0x004c:
        r6 = r9.next();
        r6 = (com.tencent.mm.plugin.wenote.c.e) r6;
        if (r6 == 0) goto L_0x0046;
    L_0x0054:
        r0 = r6.lus;
        if (r0 == 0) goto L_0x005e;
    L_0x0058:
        r0 = r6.lus;
        r7.add(r0);
        goto L_0x0046;
    L_0x005e:
        r10 = new com.tencent.mm.protocal.c.pw;
        r10.<init>();
        r0 = new com.tencent.mm.protocal.c.px;
        r0.<init>();
        r1 = new com.tencent.mm.protocal.c.py;
        r1.<init>();
        r2 = 6;
        r1.uI(r2);
        r0.c(r1);
        r10.a(r0);
        r0 = r6.type;
        switch(r0) {
            case 1: goto L_0x0132;
            case 2: goto L_0x0085;
            case 3: goto L_0x00b7;
            case 4: goto L_0x0109;
            case 5: goto L_0x00e3;
            default: goto L_0x007c;
        };
    L_0x007c:
        r0 = r6.lut;
        r10.IT(r0);
        r7.add(r10);
        goto L_0x0046;
    L_0x0085:
        r0 = 2;
        r10.uG(r0);
        r1 = r6;
        r1 = (com.tencent.mm.plugin.wenote.c.h) r1;
        r0 = r1.luw;
        r10.IK(r0);
        r1 = r1.toString();
        r1 = com.tencent.mm.plugin.wenote.c.g.FV(r1);
        r10.IJ(r1);
        r1 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r3 = android.graphics.Bitmap.CompressFormat.JPEG;
        r4 = 90;
        r5 = com.tencent.mm.plugin.wenote.c.g.g(r10);
        com.tencent.mm.sdk.platformtools.d.b(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.wenote.c.g.g(r10);
        r10.IL(r0);
        r0 = 2;
        r10.uG(r0);
        goto L_0x007c;
    L_0x00b7:
        r0 = 6;
        r10.uG(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.c.i) r0;
        r1 = new com.tencent.mm.protocal.c.qc;
        r1.<init>();
        r2 = r0.cJf;
        r1.Je(r2);
        r2 = r0.lat;
        r1.k(r2);
        r2 = r0.lng;
        r1.j(r2);
        r2 = r0.lux;
        r2 = (int) r2;
        r1.uJ(r2);
        r0 = r0.gUr;
        r1.Jf(r0);
        r0 = r10.msM;
        r0.a(r1);
        goto L_0x007c;
    L_0x00e3:
        r0 = 8;
        r10.uG(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.c.l) r0;
        r1 = r0.bjG;
        r10.IK(r1);
        r1 = 1;
        r10.ip(r1);
        r1 = r0.title;
        r10.Iw(r1);
        r1 = r0.content;
        r10.Ix(r1);
        r0 = r0.bjG;
        r0 = com.tencent.mm.a.e.aS(r0);
        r10.IG(r0);
        goto L_0x007c;
    L_0x0109:
        r0 = 3;
        r10.uG(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.c.m) r0;
        r1 = r0.bjG;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r2 != 0) goto L_0x0046;
    L_0x0118:
        r2 = r1.length();
        if (r2 == 0) goto L_0x0046;
    L_0x011e:
        r10.IK(r1);
        r0 = r0.length;
        r10.uF(r0);
        r0 = 1;
        r10.ip(r0);
        r0 = "amr";
        r10.IG(r0);
        goto L_0x007c;
    L_0x0132:
        r0 = 1;
        r10.uG(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.c.k) r0;
        r0 = r0.content;
        r10.Ix(r0);
        r0 = r10.desc;
        r0 = r0.length();
        if (r0 == 0) goto L_0x0046;
    L_0x0146:
        goto L_0x007c;
    L_0x0148:
        ad(r7);
        r8.ah(r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.b.b.i(java.lang.String, java.util.List):com.tencent.mm.protocal.c.qf");
    }

    private static void ad(LinkedList<pw> linkedList) {
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String aX;
                String aY;
                pw pwVar = (pw) linkedList.get(i);
                if (be.kS(pwVar.luu)) {
                    pwVar.IJ(g.FV(pwVar.toString()));
                }
                System.currentTimeMillis();
                String str = pwVar.msq;
                if (FileOp.aR(str)) {
                    aX = com.tencent.mm.a.g.aX(str);
                    aY = com.tencent.mm.a.g.aY(str);
                    pwVar.IH(aX);
                    pwVar.II(aY);
                    pwVar.dQ(new File(str).length());
                    ez ezVar = new ez();
                    ezVar.bdQ.type = 27;
                    ezVar.bdQ.bdS = pwVar;
                    com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                    aX = ezVar.bdR.path;
                    if (!(str.equals(aX) || FileOp.aR(aX))) {
                        FileOp.p(str, aX);
                    }
                } else {
                    v.i("MicroMsg.WNNoteBase", "copy file fail, type:%d, %s not exist!", new Object[]{Integer.valueOf(pwVar.aKG), str});
                }
                str = pwVar.mss;
                if (FileOp.aR(str)) {
                    aX = com.tencent.mm.a.g.aX(str);
                    aY = com.tencent.mm.a.g.aY(str);
                    pwVar.IM(aX);
                    pwVar.IN(aY);
                    pwVar.dR(new File(str).length());
                    String g = g.g(pwVar);
                    if (!(str.equals(g) || FileOp.aR(g))) {
                        FileOp.p(str, g);
                    }
                } else {
                    v.i("MicroMsg.WNNoteBase", "copy thumb fail, %s not exist!", new Object[]{str});
                }
            }
        }
    }

    public void FQ(String str) {
    }
}
