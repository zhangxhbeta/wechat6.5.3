package com.tencent.mm.plugin.webview.c;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.nr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.modelsearch.i;
import com.tencent.mm.modelsearch.l;
import com.tencent.mm.modelsearch.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.n;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements com.tencent.mm.sdk.h.g.a, com.tencent.mm.v.e {
    public com.tencent.mm.sdk.c.c dHB = new com.tencent.mm.sdk.c.c<id>(this) {
        final /* synthetic */ b ldu;

        {
            this.ldu = r2;
            this.nhz = id.class.getName().hashCode();
        }

        private boolean a(id idVar) {
            ajr com_tencent_mm_protocal_c_ajr = idVar.bif.bib;
            if (com_tencent_mm_protocal_c_ajr != null && com.tencent.mm.ai.b.d(com_tencent_mm_protocal_c_ajr)) {
                switch (idVar.bif.action) {
                    case 0:
                    case 1:
                        for (Integer intValue : this.ldu.ldn) {
                            j.tl(intValue.intValue()).bu(com_tencent_mm_protocal_c_ajr.mJW, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        for (Integer intValue2 : this.ldu.ldn) {
                            j.tl(intValue2.intValue()).bu(com_tencent_mm_protocal_c_ajr.mJW, 0);
                        }
                        break;
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.c.c jeg = new com.tencent.mm.sdk.c.c<nr>(this) {
        final /* synthetic */ b ldu;

        {
            this.ldu = r2;
            this.nhz = nr.class.getName().hashCode();
        }

        private boolean a(nr nrVar) {
            if ((nrVar instanceof nr) && nrVar.boK.aYt == 2) {
                v.i("MicroMsg.FTS.FTSWebViewLogic", "Download callback %s", new Object[]{nrVar.boK.mediaId});
                if (this.ldu.ldk.containsKey(nrVar.boK.mediaId)) {
                    synchronized (this.ldu.ldk) {
                        int intValue = ((Integer) this.ldu.ldm.get(nrVar.boK.mediaId)).intValue();
                        HashSet hashSet = (HashSet) this.ldu.ldk.get(nrVar.boK.mediaId);
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            String str2 = "weixin://fts/sns?path=" + nrVar.boK.path;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("id", str);
                                jSONObject.put("src", str2);
                            } catch (JSONException e) {
                            }
                            jSONArray.put(jSONObject);
                        }
                        j.tl(intValue).FG(jSONArray.toString());
                        this.ldu.ldk.remove(nrVar.boK.mediaId);
                    }
                }
            }
            return false;
        }
    };
    private HashMap<String, HashSet<String>> ldj;
    HashMap<String, HashSet<String>> ldk;
    private HashMap<String, Integer> ldl;
    HashMap<String, Integer> ldm;
    public Set<Integer> ldn;
    private HashMap<String, b> ldo;
    private s ldp;
    private LinkedList<bcy> ldq = new LinkedList();
    public e ldr = new e(this);
    public List<ajr> lds;
    int ldt;

    private class a implements Runnable {
        public String data;
        final /* synthetic */ b ldu;
        public boolean ldv;

        private a(b bVar) {
            this.ldu = bVar;
        }

        public final void run() {
            Object arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    azr ko = com.tencent.mm.modelsns.d.ko(jSONArray.getString(i));
                    ak.yW();
                    ajr a = com.tencent.mm.ai.b.a(com.tencent.mm.model.c.xq(), ko, 9);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (!this.ldv || this.ldu.lds == null) {
                    this.ldu.lds = arrayList;
                } else {
                    this.ldu.lds.addAll(arrayList);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
        }
    }

    private class b {
        String bfi;
        String bkJ;
        final /* synthetic */ b ldu;
        long ldw;
        long ldx;
        int scene;
        int type;

        private b(b bVar) {
            this.ldu = bVar;
        }
    }

    private class c {
        public String bCj;
        public String bkC;
        public int bkI;
        public String bpB;
        public String cID;
        public String hUf;
        public mc hVh;
        public String ldA;
        final /* synthetic */ b ldu;
        public int ldy;
        public boolean ldz;
        public int position;
        public int scene;
        public String username;

        private c(b bVar) {
            this.ldu = bVar;
        }
    }

    private class d {
        public int bBZ;
        public String bCj;
        public String bCk;
        public String bCl;
        public String bLc;
        public String bkC;
        public String cID;
        public String cJg;
        public int ldB;
        final /* synthetic */ b ldu;
        public int scene;
        public String username;

        private d(b bVar) {
            this.ldu = bVar;
        }
    }

    public class e {
        public boolean aWL;
        public String bkC;
        public int iHC;
        public boolean ldC = true;
        public boolean ldD;
        final /* synthetic */ b ldu;
        public int scene;

        public e(b bVar) {
            this.ldu = bVar;
        }
    }

    public b() {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.ldj = new HashMap();
        this.ldk = new HashMap();
        this.ldl = new HashMap();
        this.ldm = new HashMap();
        this.ldo = new HashMap();
        this.ldn = Collections.synchronizedSet(new HashSet());
        com.tencent.mm.sdk.c.a.nhr.e(this.jeg);
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
        n.Bo().c(this);
    }

    public final boolean F(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", new Object[]{map});
        int c = c.c(map, "scene", 0);
        int c2 = c.c(map, Columns.TYPE, 0);
        int c3 = c.c(map, "requestType", 0);
        int n = be.n(map.get("webview_instance_id"), -1);
        String cM;
        if (c3 == 0) {
            b bVar;
            bhZ();
            cM = cM(c, c2);
            if (this.ldo.get(cM) == null) {
                bVar = new b();
                ahk com_tencent_mm_protocal_c_ahk = new ahk();
                ak.yW();
                File file = new File(com.tencent.mm.model.c.wV(), cM(c, c2));
                byte[] c4 = com.tencent.mm.a.e.c(file.getAbsolutePath(), 0, (int) file.length());
                if (c4 != null) {
                    try {
                        com_tencent_mm_protocal_c_ahk.az(c4);
                        bVar.scene = com_tencent_mm_protocal_c_ahk.scene;
                        bVar.bfi = com_tencent_mm_protocal_c_ahk.min;
                        bVar.ldw = com_tencent_mm_protocal_c_ahk.mGW;
                        bVar.ldx = com_tencent_mm_protocal_c_ahk.mGX;
                        bVar.bkJ = com_tencent_mm_protocal_c_ahk.miU;
                        bVar.type = com_tencent_mm_protocal_c_ahk.efm;
                        v.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(c4.length)});
                    } catch (IOException e) {
                    }
                }
                this.ldo.put(cM, bVar);
            }
            bVar = (b) this.ldo.get(cM);
            if (!be.kS(bVar.bfi)) {
                v.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[]{Integer.valueOf(n)});
                j.tl(n).b(c3, bVar.bfi, 1);
            }
            Object obj = (be.kS(bVar.bfi) || (System.currentTimeMillis() / 1000) - bVar.ldx > bVar.ldw) ? null : 1;
            if (obj != null) {
                v.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d", new Object[]{Integer.valueOf(bVar.scene), Long.valueOf(bVar.ldw), Long.valueOf(bVar.ldx), Integer.valueOf(bVar.type)});
                l.a(bVar.scene, 0, bVar.bkJ, bVar.type, 1, "");
                return false;
            }
            ak.vy().a(1048, this);
            v.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[]{Integer.valueOf(n)});
            this.ldp = new s(c, c2, h.cVT, n);
            ak.vy().a(this.ldp, 0);
        } else {
            ajo Ik = i.Ik();
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (c = Ik.eeu.size() - 1; c >= 0; c--) {
                    JSONObject jSONObject3 = new JSONObject();
                    ajn com_tencent_mm_protocal_c_ajn = (ajn) Ik.eeu.get(c);
                    if (m.eC(com_tencent_mm_protocal_c_ajn.mdw)) {
                        BizInfo hw = com.tencent.mm.modelbiz.e.hw(com_tencent_mm_protocal_c_ajn.mdw);
                        if (hw != null) {
                            jSONObject3.put("avatarUrl", hw.field_brandIconURL);
                            jSONObject3.put("userName", hw.field_username);
                            jSONObject3.put("nickName", com.tencent.mm.model.l.er(hw.field_username));
                            jSONArray2.put(jSONObject3);
                        }
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONObject2.put(Columns.TYPE, 5);
                jSONObject2.put("title", "");
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
                v.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[]{jSONObject.toString()});
                j.tl(n).b(1, cM, 1);
            } catch (Throwable e2) {
                v.a("MicroMsg.FTS.FTSWebViewLogic", e2, "gen mostSearchBizContactList error", new Object[0]);
            }
        }
        return false;
    }

    public final void bhZ() {
        if (this.ldp != null) {
            ak.vy().b(1048, this);
            ak.vy().c(this.ldp);
            this.ldp = null;
        }
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.i iVar) {
        Bundle bundle = null;
        this.ldr.ldD = true;
        boolean b = c.b(map, "isTeachPage", false);
        boolean b2 = c.b(map, "isMoreButton", false);
        if (!(c.c(map, "isFeedBack", 0) == 1)) {
            int c = c.c(map, Columns.TYPE, 0);
            int c2 = c.c(map, "opType", 0);
            String str;
            if (c2 <= 0) {
                Intent intent;
                if (!b2) {
                    str = (String) map.get("url");
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[]{Integer.valueOf(c), str});
                    switch (c) {
                        case 1:
                            a(K(map), false);
                            break;
                        case 2:
                        case 4:
                        case 16:
                            v.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{c.n(map, "jumpUrl")});
                            if (iVar != null) {
                                bundle = iVar.blC();
                            }
                            com.tencent.mm.plugin.webview.e.e.biZ();
                            b(str, bundle);
                            break;
                        case 8:
                            c.n(map, "snsid");
                            str = c.n(map, "objectXmlDesc");
                            String n = c.n(map, "userName");
                            boolean b3 = c.b(map, "fromMusicItem", false);
                            com.tencent.mm.plugin.webview.e.e.biZ();
                            azr ko = com.tencent.mm.modelsns.d.ko(str);
                            intent = new Intent();
                            intent.putExtra("INTENT_TALKER", n);
                            intent.putExtra("INTENT_SNSID", new BigInteger(ko.gID).longValue());
                            intent.putExtra("SNS_FROM_MUSIC_ITEM", b3);
                            try {
                                intent.putExtra("INTENT_SNS_TIMELINEOBJECT", ko.toByteArray());
                            } catch (IOException e) {
                            }
                            com.tencent.mm.ay.c.b(aa.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
                            break;
                        case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                            d dVar = new d();
                            dVar.username = c.n(map, "userName");
                            dVar.cID = c.n(map, "nickName");
                            dVar.bLc = c.n(map, "alias");
                            dVar.bCj = c.n(map, "signature");
                            dVar.bBZ = c.c(map, "sex", 0);
                            dVar.cJg = c.n(map, "country");
                            dVar.bCl = c.n(map, "city");
                            dVar.bCk = c.n(map, "province");
                            dVar.ldB = c.c(map, "snsFlag", 0);
                            String n2 = c.n(map, "query");
                            if (be.kS(n2)) {
                                dVar.scene = 3;
                            } else {
                                if (Character.isDigit(n2.charAt(0))) {
                                    c2 = 15;
                                } else {
                                    c2 = 3;
                                }
                                dVar.scene = c2;
                                if (dVar.scene == 15) {
                                    if ("mobile".equals(c.n(map, "matchType"))) {
                                        dVar.bkC = n2;
                                    } else {
                                        dVar.scene = 1;
                                    }
                                }
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", dVar.username);
                            intent2.putExtra("Contact_Nick", dVar.cID);
                            intent2.putExtra("Contact_Alias", dVar.bLc);
                            intent2.putExtra("Contact_Sex", dVar.bBZ);
                            intent2.putExtra("Contact_Scene", dVar.scene);
                            intent2.putExtra("Contact_KHideExpose", true);
                            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(dVar.cJg, dVar.bCk, dVar.bCl));
                            intent2.putExtra("Contact_Signature", dVar.bCj);
                            intent2.putExtra("Contact_KSnsIFlag", dVar.ldB);
                            intent2.putExtra("Contact_full_Mobile_MD5", dVar.bkC);
                            com.tencent.mm.ay.c.b(aa.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                            break;
                        default:
                            break;
                    }
                }
                str = c.n(map, "query");
                int c3 = c.c(map, "scene", 0);
                String n3 = c.n(map, "searchId");
                intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str);
                intent.putExtra("ftsType", c);
                Map a = h.a(c3, false, c);
                a.put("query", str);
                a.put("searchId", n3);
                intent.putExtra("rawUrl", h.l(a));
                com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", intent);
            } else {
                switch (c2) {
                    case 2:
                        a(K(map), b);
                        break;
                    case 3:
                        c K = K(map);
                        if (!m.eC(K.username)) {
                            a(K, b);
                            break;
                        }
                        i.jF(K.username);
                        Intent intent3 = new Intent();
                        intent3.putExtra("Chat_User", K.username);
                        intent3.putExtra("finish_direct", true);
                        intent3.putExtra("key_temp_session_show_type", 0);
                        com.tencent.mm.ay.c.a(aa.getContext(), ".ui.chatting.ChattingUI", intent3);
                        break;
                    case 4:
                        str = c.n(map, "jumpUrl");
                        if (iVar != null) {
                            bundle = iVar.blC();
                        }
                        com.tencent.mm.plugin.webview.e.e.biZ();
                        b(str, bundle);
                        break;
                    default:
                        break;
                }
            }
        }
        Bundle blC;
        n3 = c.n(map, "jumpUrl");
        if (iVar != null) {
            blC = iVar.blC();
        } else {
            blC = null;
        }
        com.tencent.mm.plugin.webview.e.e.biZ();
        b(n3, blC);
        return false;
    }

    public final boolean G(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[]{map.toString()});
        aqn com_tencent_mm_protocal_c_aqn = new aqn();
        com_tencent_mm_protocal_c_aqn.mPT = c.n(map, "logString");
        ak.vy().a(1134, this);
        ak.vy().a(new e(com_tencent_mm_protocal_c_aqn), 0);
        return false;
    }

    private static void b(String str, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        if (!(bundle == null || be.kS(str))) {
            String str2 = bundle.getString("publishIdPrefix", "gs") + "_" + g.m(str.getBytes());
            intent.putExtra("prePublishId", str2);
            intent.putExtra("KPublisherId", str2);
        }
        com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    private static void a(c cVar, boolean z) {
        int i;
        if (cVar.bkI == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i = 39;
        } else if (cVar.ldz) {
            i = 88;
        } else {
            i = 87;
        }
        i.jF(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.cID);
        intent.putExtra("Contact_BrandIconURL", cVar.hUf);
        intent.putExtra("Contact_Signature", cVar.bCj);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.ldy);
        intent.putExtra("Contact_Scene", i);
        if (cVar.hVh != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.hVh.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.bpB);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.bkC);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.ldA);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.ay.c.b(aa.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    public static int b(Map<String, Object> map, Map<String, Object> map2) {
        try {
            JSONArray jSONArray = new JSONArray(c.n(map, "data"));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("userName");
                String er = com.tencent.mm.model.l.er(string2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", string);
                jSONObject2.put("userName", string2);
                jSONObject2.put("displayName", er);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put("data", jSONArray2.toString());
        } catch (JSONException e) {
        }
        return 0;
    }

    public static boolean H(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "getSearchImageList");
        String n = c.n(map, "data");
        int n2 = be.n(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(n);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONObject jSONObject2 = new JSONObject();
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("imageUrl");
                jSONObject2.put("id", string);
                jSONObject2.put("src", string2);
                jSONArray2.put(jSONObject2);
            }
            j.tl(n2).FG(jSONArray2.toString());
        } catch (JSONException e) {
        }
        return false;
    }

    public final boolean I(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "getSearchAvatarList");
        String n = c.n(map, "data");
        int n2 = be.n(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(n);
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            Object obj = null;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("userName");
                int i2 = jSONObject.getInt(Columns.TYPE);
                Object string3 = jSONObject.getString("imageUrl");
                String string4 = jSONObject.getString("bigImageUrl");
                switch (i2) {
                    case 1:
                    case 4:
                    case 64:
                        break;
                    case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                        com.tencent.mm.u.h hVar = new com.tencent.mm.u.h();
                        hVar.username = string2;
                        hVar.cyD = string4;
                        hVar.cyC = string3;
                        hVar.bkU = -1;
                        hVar.bBY = 3;
                        hVar.aP(true);
                        n.Bo().a(hVar);
                        break;
                }
                n.AX();
                n = com.tencent.mm.u.d.s(string2, false);
                if (FileOp.aR(n)) {
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "avatar file exist %s", new Object[]{n});
                    string3 = "weixin://fts/avatar?path=" + n;
                } else {
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "avatar file not exist %s", new Object[]{n});
                    this.ldl.put(string2, Integer.valueOf(n2));
                    HashSet hashSet = (HashSet) this.ldj.get(string2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(string);
                    this.ldj.put(string2, hashSet);
                    com.tencent.mm.pluginsdk.ui.a.b.box().bg(string2);
                    string3 = obj;
                }
                if (string3 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", string);
                    jSONObject2.put("src", string3);
                    jSONArray2.put(jSONObject2);
                    string3 = null;
                }
                i++;
                obj = string3;
            }
            if (jSONArray2.length() > 0) {
                j.tl(n2).FG(jSONArray2.toString());
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public final boolean J(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "getSearchSnsImageList");
        String n = c.n(map, "data");
        int n2 = be.n(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(n);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("objectXmlDesc");
                int i2 = jSONObject.getInt("index");
                azr ko = com.tencent.mm.modelsns.d.ko(string2);
                if (ko.mWq.mom.size() > i2) {
                    aib com_tencent_mm_protocal_c_aib = (aib) ko.mWq.mom.get(i2);
                    nr nrVar = new nr();
                    nrVar.boK.aYt = 3;
                    nrVar.boK.mediaId = com_tencent_mm_protocal_c_aib.gID;
                    com.tencent.mm.sdk.c.a.nhr.z(nrVar);
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "generatePath: %s", new Object[]{nrVar.boK.path});
                    if (FileOp.aR(nrVar.boK.path)) {
                        obj2 = "weixin://fts/sns?path=" + nrVar.boK.path;
                    } else {
                        synchronized (this.ldk) {
                            HashSet hashSet;
                            if (this.ldk.containsKey(com_tencent_mm_protocal_c_aib.gID)) {
                                hashSet = (HashSet) this.ldk.get(com_tencent_mm_protocal_c_aib.gID);
                            } else {
                                hashSet = new HashSet();
                            }
                            hashSet.add(string);
                            this.ldk.put(com_tencent_mm_protocal_c_aib.gID, hashSet);
                            this.ldm.put(com_tencent_mm_protocal_c_aib.gID, Integer.valueOf(n2));
                        }
                        nrVar = new nr();
                        nrVar.boK.aYt = 1;
                        nrVar.boK.boL = com_tencent_mm_protocal_c_aib;
                        com.tencent.mm.sdk.c.a.nhr.z(nrVar);
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", string);
                        jSONObject2.put("src", obj2);
                        jSONArray2.put(jSONObject2);
                        obj2 = null;
                    }
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (jSONArray2.length() > 0) {
                j.tl(n2).FG(jSONArray2.toString());
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof s) {
            ak.vy().b(1048, this);
            if (i == 0 && i2 == 0) {
                s sVar = (s) kVar;
                b bVar = new b();
                bVar.scene = sVar.scene;
                bVar.ldw = (long) sVar.cWR.mHb;
                bVar.bfi = sVar.cWR.min;
                bVar.ldx = System.currentTimeMillis() / 1000;
                bVar.bkJ = sVar.cWR.mzu;
                bVar.type = sVar.cWS;
                String cM = cM(bVar.scene, bVar.type);
                if (!be.kS(bVar.bfi)) {
                    j.tl(sVar.bkE).b(0, bVar.bfi, 0);
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[]{bVar.bfi});
                }
                this.ldo.put(cM, bVar);
                if (bVar.ldw == 0) {
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", new Object[]{Integer.valueOf(bVar.scene), Integer.valueOf(bVar.type)});
                    ak.yW();
                    new File(com.tencent.mm.model.c.wV(), cM(r0, r2)).delete();
                } else {
                    ahk com_tencent_mm_protocal_c_ahk = new ahk();
                    com_tencent_mm_protocal_c_ahk.scene = bVar.scene;
                    com_tencent_mm_protocal_c_ahk.min = bVar.bfi;
                    com_tencent_mm_protocal_c_ahk.mGW = bVar.ldw;
                    com_tencent_mm_protocal_c_ahk.mGX = bVar.ldx;
                    com_tencent_mm_protocal_c_ahk.miU = bVar.bkJ;
                    com_tencent_mm_protocal_c_ahk.efm = bVar.type;
                    byte[] bArr = null;
                    try {
                        bArr = com_tencent_mm_protocal_c_ahk.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        ak.yW();
                        File file = new File(com.tencent.mm.model.c.wV(), "FTS_BizCacheObj" + bVar.scene);
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                        v.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(bArr.length)});
                    } else {
                        v.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                l.a(bVar.scene, 1, bVar.bkJ, bVar.type, 1, "");
            }
        } else if (kVar instanceof e) {
            ak.vy().b(1134, this);
        }
    }

    private c K(Map<String, Object> map) {
        c cVar = new c();
        cVar.username = c.n(map, "userName");
        cVar.cID = c.n(map, "nickName");
        cVar.hUf = c.n(map, "headHDImgUrl");
        cVar.ldy = c.c(map, "verifyFlag", 0);
        cVar.bCj = c.n(map, "signature");
        cVar.scene = c.c(map, "scene", 0);
        cVar.bkI = c.c(map, "sceneActionType", 1);
        cVar.hVh = new mc();
        cVar.hVh.cHq = c.c(map, "brandFlag", 0);
        cVar.hVh.cHt = c.n(map, "iconUrl");
        cVar.hVh.cHs = c.n(map, "brandInfo");
        cVar.hVh.cHr = c.n(map, "externalInfo");
        cVar.bpB = c.n(map, "searchId");
        cVar.bkC = c.n(map, "query");
        cVar.position = c.c(map, "position", 0);
        cVar.ldz = c.b(map, "isCurrentDetailPage", false);
        cVar.ldA = c.n(map, "extraParams");
        return cVar;
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        if (iVar != null && iVar.obj != null) {
            synchronized (this.ldj) {
                v.i("MicroMsg.FTS.FTSWebViewLogic", "event %s，eventData %s", new Object[]{str, iVar.toString()});
                String obj = iVar.obj.toString();
                if (this.ldj.containsKey(obj) && this.ldl.containsKey(obj)) {
                    v.i("MicroMsg.FTS.FTSWebViewLogic", "notify avatar changed %s", new Object[]{obj});
                    int intValue = ((Integer) this.ldl.get(obj)).intValue();
                    HashSet hashSet = (HashSet) this.ldj.get(obj);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        n.AX();
                        String str3 = "weixin://fts/avatar?path=" + com.tencent.mm.u.d.s(obj, false);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str2);
                            jSONObject.put("src", str3);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    j.tl(intValue).FG(jSONArray.toString());
                    this.ldj.remove(obj);
                    this.ldl.remove(obj);
                }
            }
        }
    }

    private static String cM(int i, int i2) {
        return "FTS_BizCacheObj" + i + "-" + i2;
    }

    public static boolean L(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", new Object[]{map});
        String n = c.n(map, "word");
        boolean b = c.b(map, "isInputChange", false);
        String n2 = c.n(map, "custom");
        String n3 = c.n(map, "tagList");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i tl = j.tl(be.n(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", n);
        bundle.putString("fts_key_custom_query", n2);
        bundle.putBoolean("fts_key_need_keyboard", b);
        bundle.putString("fts_key_tag_list", n3);
        try {
            if (tl.leB != null) {
                tl.leB.g(22, bundle);
            }
        } catch (RemoteException e) {
            v.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        return false;
    }
}
