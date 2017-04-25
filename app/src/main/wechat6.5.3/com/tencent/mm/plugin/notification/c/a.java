package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.notification.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static final String hIK = (e.cnj + "FailMsgFileCache");

    public static class a {
        public b hIL = new b();
        public int hIM;
        public ArrayList<Long> hIN = new ArrayList();
        public ArrayList<Long> hIO = new ArrayList();

        public a(b bVar, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
            this.hIL = bVar;
            this.hIM = i;
            this.hIN = arrayList;
            this.hIO = arrayList2;
        }

        public final String aEx() {
            v.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.hIL.hIJ.size(); i++) {
                    jSONArray.put(this.hIL.get(i));
                }
                v.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
                jSONObject.put("msg_list", jSONArray);
                v.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", new Object[]{Integer.valueOf(this.hIM)});
                jSONObject.put("current_send_index", this.hIM);
                jSONArray = new JSONArray();
                Iterator it = this.hIN.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                v.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
                jSONObject.put("success_msg_list", jSONArray);
                jSONArray = new JSONArray();
                it = this.hIO.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                v.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
                jSONObject.put("fail_msg_list", jSONArray);
                return jSONObject.toString();
            } catch (Throwable e) {
                v.a("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                return null;
            }
        }

        public final void xn(String str) {
            v.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
            try {
                int i;
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
                JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
                JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
                v.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", new Object[]{Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index"))});
                this.hIL.clear();
                this.hIO.clear();
                this.hIN.clear();
                for (i = 0; i < jSONArray.length(); i++) {
                    this.hIL.cp(jSONArray.getLong(i));
                }
                for (i = 0; i < jSONArray2.length(); i++) {
                    this.hIO.add(Long.valueOf(jSONArray2.getLong(i)));
                }
                for (i = 0; i < jSONArray3.length(); i++) {
                    this.hIN.add(Long.valueOf(jSONArray3.getLong(i)));
                }
                this.hIM = r5;
            } catch (Throwable e) {
                v.a("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                v.d("MicroMsg.FailMsgFileCache", "createFromFileContent error:%s", new Object[]{e.getMessage()});
            }
        }
    }

    public static void init() {
        v.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(hIK).mkdirs();
    }

    public static void a(int i, a aVar) {
        String str = null;
        if (i == 1) {
            str = hIK + File.separator + "normalMsg";
        } else if (i == 2) {
            str = hIK + File.separator + "snsMsg";
        }
        if (be.kS(str)) {
            v.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            return;
        }
        v.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", new Object[]{str});
        String aEx = aVar.aEx();
        v.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", new Object[]{aEx});
        if (be.kS(aEx)) {
            v.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
        } else {
            com.tencent.mm.a.e.b(str, aEx.getBytes(), aEx.length());
        }
    }

    public static a nH(int i) {
        String str;
        if (i == 1) {
            str = hIK + File.separator + "normalMsg";
        } else if (i == 2) {
            str = hIK + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (be.kS(str)) {
            v.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            return null;
        }
        v.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", new Object[]{str});
        try {
            v.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", new Object[]{com.tencent.mm.a.e.aV(str)});
            a aVar = new a();
            aVar.xn(r2);
            return aVar;
        } catch (Throwable e) {
            v.a("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            v.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static void nI(int i) {
        String str = null;
        if (i == 1) {
            str = hIK + File.separator + "normalMsg";
        } else if (i == 2) {
            str = hIK + File.separator + "snsMsg";
        }
        if (be.kS(str)) {
            v.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            return;
        }
        v.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", new Object[]{str});
        if (com.tencent.mm.a.e.aR(str)) {
            new File(str).delete();
        }
    }
}
