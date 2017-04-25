package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.gw;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.modelsearch.t;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pluginsdk.k.a.a.m;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.azc;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.le;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.f;
import com.tencent.mm.t.i;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements e {
    private k cVI = new k(this) {
        final /* synthetic */ a lcT;

        {
            this.lcT = r1;
        }

        public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
            if (list == null || list.size() == 0) {
                v.i("MicroMsg.FTS.FTSWebSearchLogic", "local contact search size 0");
                j.tl(((Integer) lVar.cWP).intValue()).FF("");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (h hVar : list) {
                    if (hVar.type == 131072) {
                        jSONArray2.put(c.a(hVar, str, be.g(strArr)));
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONObject2.put("title", aa.getContext().getString(2131233008));
                jSONObject2.put("count", jSONArray2.length());
                jSONObject2.put(Columns.TYPE, 3);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
                jSONObject.put("ret", 0);
                j.tl(((Integer) lVar.cWP).intValue()).FF(jSONObject.toString());
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.FTSWebSearchLogic", e, "onSearchDone", new Object[0]);
            }
        }

        public final void jI(String str) {
            j.tl(((Integer) this.lcT.lcS.cWP).intValue()).FF("");
        }
    };
    public com.tencent.mm.sdk.c.c lcJ = new com.tencent.mm.sdk.c.c<jz>(this) {
        final /* synthetic */ a lcT;

        {
            this.lcT = r2;
            this.nhz = jz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            jz jzVar = (jz) bVar;
            a aVar = new a(this.lcT);
            aVar.aXp = jzVar.bkG.bkC;
            aVar.cWS = jzVar.bkG.type;
            aVar.scene = jzVar.bkG.scene;
            aVar.lcV = jzVar.bkG.bkH ? 1 : 0;
            aVar.bkI = jzVar.bkG.bkI;
            aVar.bkJ = jzVar.bkG.bkJ;
            aVar.offset = jzVar.bkG.offset;
            aVar.bkK = jzVar.bkG.bkK;
            aVar.bkE = -1;
            aVar.lcU = true;
            aVar.ldb = 2;
            this.lcT.lcQ.a(aVar);
            return true;
        }
    };
    public b lcQ = new b();
    public c lcR = new c();
    public l lcS;

    public class a {
        public String aXp;
        public int bkE;
        public int bkI;
        public String bkJ;
        public boolean bkK;
        public int cWS;
        final /* synthetic */ a lcT;
        public boolean lcU;
        public int lcV;
        public LinkedList<bcy> lcW = new LinkedList();
        public String lcX;
        public String lcY;
        public int lcZ;
        public LinkedList<String> lda = new LinkedList();
        public int ldb;
        public azc ldc;
        public LinkedList<le> ldd = new LinkedList();
        public LinkedList<akj> lde = new LinkedList();
        public int offset;
        public int pRo;
        public String pRp;
        public int scene;

        public a(a aVar) {
            this.lcT = aVar;
        }
    }

    private class b {
        boolean aHp;
        boolean bbq;
        boolean bkK;
        final /* synthetic */ a lcT;
        public com.tencent.mm.modelsearch.c ldf;
        private String ldg;
        private long ldh;

        private b(a aVar) {
            this.lcT = aVar;
        }

        public final void a(a aVar) {
            if (be.kS(aVar.aXp)) {
                v.i("MicroMsg.FTS.FTSWebSearchLogic", "error query %d %d %d %d %s %d %b", new Object[]{Integer.valueOf(aVar.cWS), Integer.valueOf(aVar.scene), Integer.valueOf(aVar.lcV), Integer.valueOf(aVar.bkI), aVar.bkJ, Integer.valueOf(aVar.offset), Boolean.valueOf(aVar.bkK)});
                return;
            }
            com.tencent.mm.modelsearch.c fVar;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(aVar.aXp);
            stringBuffer.append(aVar.cWS);
            stringBuffer.append(aVar.scene);
            stringBuffer.append(aVar.lcV);
            stringBuffer.append(aVar.bkI);
            stringBuffer.append(aVar.offset);
            if (aVar.lde != null) {
                Iterator it = aVar.lde.iterator();
                while (it.hasNext()) {
                    akj com_tencent_mm_protocal_c_akj = (akj) it.next();
                    stringBuffer.append(com_tencent_mm_protocal_c_akj.mLn);
                    stringBuffer.append(com_tencent_mm_protocal_c_akj.mLo);
                    stringBuffer.append(com_tencent_mm_protocal_c_akj.mLp);
                }
            }
            String m = g.m(stringBuffer.toString().getBytes());
            if (!be.kS(this.ldg) && this.ldg.equals(m) && System.currentTimeMillis() - this.ldh <= 8000 && aVar.offset == 0) {
                if (this.bbq) {
                    v.i("MicroMsg.FTS.FTSWebSearchLogic", "hit the search cache %s", new Object[]{aVar.aXp});
                    j.tl(aVar.bkE).az(this.ldf.AI(), this.ldf.If());
                    return;
                } else if (this.aHp) {
                    this.bkK = aVar.bkK;
                    if (this.ldf != null) {
                        this.ldf.cVf = aVar.bkE;
                    }
                    v.i("MicroMsg.FTS.FTSWebSearchLogic", "wait the netscene running");
                    return;
                } else {
                    v.i("MicroMsg.FTS.FTSWebSearchLogic", "netscene error try again");
                }
            }
            v.i("MicroMsg.FTS.FTSWebSearchLogic", "start New NetScene %s %s %b %d", new Object[]{aVar.aXp, m, Boolean.valueOf(aVar.bkK), Integer.valueOf(aVar.bkE)});
            if (this.ldf != null) {
                ak.vy().c(this.ldf);
            }
            b.e eVar = com.tencent.mm.plugin.webview.e.e.biZ().ldr;
            int i = aVar.scene;
            String str = aVar.aXp;
            int i2 = aVar.cWS;
            eVar.bkC = str;
            eVar.scene = i;
            eVar.aWL = false;
            eVar.iHC = i2;
            eVar.ldD = false;
            eVar.ldC = false;
            com.tencent.mm.plugin.webview.e.e.biZ().ldt = aVar.bkE;
            if (aVar.lcU) {
                v.i("MicroMsg.FTS.FTSWebSearchLogic", "setPreWebSearchMD5 %s", new Object[]{m});
                this.ldg = m;
                this.ldh = System.currentTimeMillis();
            }
            this.aHp = true;
            this.bbq = false;
            this.bkK = aVar.bkK;
            if (a.uo(aVar.scene)) {
                gw gwVar = new gw();
                com.tencent.mm.sdk.c.a.nhr.z(gwVar);
                fVar = new f(aVar.aXp, aVar.offset, aVar.bkJ, aVar.ldb, aVar.scene, gwVar.bgz.bgA, aVar.lcX, aVar.pRo, aVar.pRp);
                fVar.cVf = aVar.bkE;
            } else {
                fVar = new d(aVar);
            }
            this.ldf = fVar;
            ak.vy().a(this.ldf.getType(), this.lcT);
            ak.vy().a(this.ldf, 0);
            v.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(this.ldf.getType())});
        }
    }

    private class c {
        public final /* synthetic */ a lcT;
        public t pRq;

        private c(a aVar) {
            this.lcT = aVar;
        }
    }

    static /* synthetic */ boolean uo(int i) {
        return i == 201;
    }

    public a() {
        v.d("MicroMsg.FTS.FTSWebSearchLogic", "create FTSWebSearchLogic");
        com.tencent.mm.sdk.c.a.nhr.e(this.lcJ);
    }

    public final boolean D(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        v.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData: %s", new Object[]{map.toString()});
        a aVar = new a(this);
        aVar.aXp = c.n(map, "query");
        aVar.offset = c.c(map, "offset", 0);
        aVar.cWS = c.c(map, Columns.TYPE, 0);
        aVar.scene = c.c(map, "scene", 3);
        aVar.lcX = c.n(map, "sugId");
        aVar.lcZ = c.c(map, "sugType", 0);
        aVar.lcY = c.n(map, "prefixSug");
        aVar.lcV = c.b(map, "isHomePage", false) ? 1 : 0;
        aVar.bkJ = c.n(map, "searchId");
        aVar.bkI = c.c(map, "sceneActionType", 1);
        aVar.bkK = c.b(map, "needCallback", true);
        aVar.ldb = c.c(map, "displayPattern", 2);
        aVar.pRo = c.c(map, "sugPosition", 0);
        aVar.pRp = c.n(map, "sugBuffer");
        String n = c.n(map, "extReqParams");
        if (!be.kS(n)) {
            try {
                jSONArray = new JSONArray(n);
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    le leVar = new le();
                    leVar.apU = jSONObject.optString("key", "");
                    leVar.mnH = (long) jSONObject.optInt("uintValue", 0);
                    leVar.mnI = jSONObject.optString("textValue", "");
                    aVar.ldd.add(leVar);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FTS.FTSWebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        n = c.n(map, "matchUser");
        if (!be.kS(n)) {
            try {
                JSONObject jSONObject2 = new JSONObject(n);
                bcy com_tencent_mm_protocal_c_bcy = new bcy();
                com_tencent_mm_protocal_c_bcy.gln = jSONObject2.optString("userName");
                com_tencent_mm_protocal_c_bcy.mZa = jSONObject2.optString("matchWord");
                if (!(be.kS(com_tencent_mm_protocal_c_bcy.gln) || be.kS(com_tencent_mm_protocal_c_bcy.mZa))) {
                    aVar.lcW.add(com_tencent_mm_protocal_c_bcy);
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.FTS.FTSWebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        n = c.n(map, "prefixQuery");
        if (!be.kS(n)) {
            try {
                jSONArray = new JSONArray(n);
                for (i = 0; i < jSONArray.length(); i++) {
                    aVar.lda.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                v.a("MicroMsg.FTS.FTSWebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        n = c.n(map, "tagInfo");
        if (!be.kS(n)) {
            try {
                jSONObject2 = new JSONObject(n);
                aVar.ldc = new azc();
                aVar.ldc.mWc = jSONObject2.optString("tagText");
                aVar.ldc.mWb = jSONObject2.optInt("tagType");
                aVar.ldc.mWd = jSONObject2.optString("tagExtValue");
            } catch (Throwable e222) {
                v.a("MicroMsg.FTS.FTSWebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        n = c.n(map, "numConditions");
        if (!be.kS(n)) {
            try {
                jSONArray = new JSONArray(n);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    akj com_tencent_mm_protocal_c_akj = new akj();
                    com_tencent_mm_protocal_c_akj.mLo = jSONObject.optLong("from");
                    com_tencent_mm_protocal_c_akj.mLp = jSONObject.optLong("to");
                    com_tencent_mm_protocal_c_akj.mLn = jSONObject.optInt("field");
                    aVar.lde.add(com_tencent_mm_protocal_c_akj);
                }
            } catch (Throwable e2222) {
                v.a("MicroMsg.FTS.FTSWebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        aVar.bkE = be.n(map.get("webview_instance_id"), -1);
        this.lcQ.a(aVar);
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        String str2 = "MicroMsg.FTS.FTSWebSearchLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(kVar != null ? kVar.getType() : 0);
        v.v(str2, str3, objArr);
        if (kVar instanceof com.tencent.mm.modelsearch.c) {
            ak.vy().b(kVar.getType(), this);
            this.lcQ.aHp = false;
            com.tencent.mm.modelsearch.c cVar = (com.tencent.mm.modelsearch.c) kVar;
            if (i == 0 && i2 == 0) {
                this.lcQ.bbq = true;
                String AI = cVar.AI();
                int AJ = cVar.AJ();
                if (this.lcQ.bkK) {
                    v.i("MicroMsg.FTS.FTSWebSearchLogic", "callback %s", new Object[]{cVar.cVg});
                    j.tl(cVar.cVf).az(AI, cVar.If());
                } else {
                    v.i("MicroMsg.FTS.FTSWebSearchLogic", "no need callback %s", new Object[]{cVar.cVg});
                }
                if (AJ > 0) {
                    v.i("MicroMsg.FTS.FTSWebSearchLogic", "updateCode %d, need update", new Object[]{Integer.valueOf(AJ)});
                    com.tencent.mm.pluginsdk.k.a.a.b.b.bnR();
                    v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[]{Integer.valueOf(27)});
                    boolean uN = ak.uN();
                    boolean equals = ai.cse.A("login_user_name", "").equals("");
                    if (uN || !equals) {
                        ak.vy().a(new m(27), 0);
                        return;
                    } else {
                        v.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
                        return;
                    }
                }
                return;
            }
            v.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", new Object[]{cVar.cVg});
            this.lcQ.bbq = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", 0);
            } catch (JSONException e) {
            }
            j.tl(cVar.cVf).az(jSONObject.toString(), true);
        } else if (kVar instanceof t) {
            ak.vy().b(kVar.getType(), this);
            t tVar = (t) kVar;
            if (i == 0 && i2 == 0) {
                j.tl(tVar.cVf).FF(tVar.AI());
                return;
            }
            v.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", new Object[]{tVar.jVO});
            j.tl(tVar.cVf).FF("{}");
        }
    }

    public final boolean E(Map<String, Object> map) {
        v.i("MicroMsg.FTS.FTSWebSearchLogic", "getSuggestionData %s", new Object[]{map});
        String n = c.n(map, "query");
        try {
            n = URLDecoder.decode(n, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        int c = c.c(map, Columns.TYPE, 0);
        int c2 = c.c(map, "scene", 3);
        boolean b = c.b(map, "isHomePage", false);
        int n2 = be.n(map.get("webview_instance_id"), -1);
        String n3 = c.n(map, "prefixQuery");
        int c3 = c.c(map, "requestType", 0);
        v.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData, webviewID = %d", new Object[]{Integer.valueOf(n2)});
        if (c3 == 0) {
            c cVar = this.lcR;
            long j = (long) c;
            if (cVar.pRq != null) {
                ak.vy().b(cVar.pRq.getType(), cVar.lcT);
                ak.vy().c(cVar.pRq);
                cVar.pRq = null;
            }
            if (cVar.pRq == null) {
                t iVar;
                if (uo(c2)) {
                    gw gwVar = new gw();
                    com.tencent.mm.sdk.c.a.nhr.z(gwVar);
                    iVar = new i(n, c2, gwVar.bgz.bgA, n2);
                } else {
                    iVar = new f(n, b, j, c2, n2, n3);
                }
                cVar.pRq = iVar;
                ak.vy().a(cVar.pRq.getType(), cVar.lcT);
                ak.vy().a(cVar.pRq, 0);
            }
        } else if (!be.kS(n)) {
            if (this.lcS != null) {
                p.a(this.lcS);
                this.lcS = null;
            }
            int[] iArr = null;
            switch (c) {
                case 8:
                    iArr = new int[]{131072};
                    break;
            }
            if (iArr != null) {
                this.lcS = p.a(n, iArr, 5, new HashSet(), p.cWn, this.cVI, null);
                this.lcS.cWP = Integer.valueOf(n2);
            }
        }
        return false;
    }
}
