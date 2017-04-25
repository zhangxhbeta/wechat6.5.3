package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask extends MainProcessTask {
    public static final Creator<ReportSubmitFormTask> CREATOR = new Creator<ReportSubmitFormTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask();
            reportSubmitFormTask.f(parcel);
            return reportSubmitFormTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportSubmitFormTask[i];
        }
    };
    public String appId;
    public int bpy;
    public String dJA;
    public int dJB;
    public String dJz;
    public int type;

    static /* synthetic */ void a(ReportSubmitFormTask reportSubmitFormTask, LinkedList linkedList) {
        linkedList.addAll(Qq());
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bjh com_tencent_mm_protocal_c_bjh = (bjh) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Columns.TYPE, com_tencent_mm_protocal_c_bjh.type);
                jSONObject.put("appid", com_tencent_mm_protocal_c_bjh.bmJ);
                jSONObject.put("formid", com_tencent_mm_protocal_c_bjh.ndM);
                jSONObject.put("pageid", com_tencent_mm_protocal_c_bjh.ndN);
                jSONObject.put("appstate", com_tencent_mm_protocal_c_bjh.ndO);
                jSONObject.put("appversion", com_tencent_mm_protocal_c_bjh.pRE);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                v.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
            }
        }
        ak.yW();
        c.vf().a(a.ntw, jSONArray.toString());
    }

    public ReportSubmitFormTask(String str) {
        this.appId = str;
        this.dJB = com.tencent.mm.plugin.appbrand.a.mr(str).dDB.dBr;
        this.bpy = com.tencent.mm.plugin.appbrand.a.mr(str).dDB.dBs;
    }

    public final void OL() {
        b.a aVar = new b.a();
        aVar.czn = new fj();
        aVar.czo = new fk();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        aVar.czm = 1129;
        b Bv = aVar.Bv();
        final fj fjVar = (fj) Bv.czk.czs;
        fjVar.mfS = new LinkedList();
        bjh com_tencent_mm_protocal_c_bjh = new bjh();
        com_tencent_mm_protocal_c_bjh.type = this.type;
        com_tencent_mm_protocal_c_bjh.bmJ = this.appId;
        com_tencent_mm_protocal_c_bjh.ndM = this.dJz;
        com_tencent_mm_protocal_c_bjh.ndN = this.dJA;
        com_tencent_mm_protocal_c_bjh.ndO = this.dJB;
        com_tencent_mm_protocal_c_bjh.pRE = this.bpy;
        fjVar.mfS.add(com_tencent_mm_protocal_c_bjh);
        synchronized (getClass()) {
            fjVar.mfS.addAll(Qq());
        }
        u.a(Bv, new u.a(this) {
            final /* synthetic */ ReportSubmitFormTask dJD;

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (!(i == 0 && i2 == 0)) {
                    synchronized (this.dJD.getClass()) {
                        ReportSubmitFormTask.a(this.dJD, fjVar.mfS);
                    }
                    v.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                }
                return 0;
            }
        });
    }

    private static LinkedList<bjh> Qq() {
        LinkedList<bjh> linkedList = new LinkedList();
        ak.yW();
        try {
            JSONArray jSONArray = new JSONArray((String) c.vf().get(a.ntw, null));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                bjh com_tencent_mm_protocal_c_bjh = new bjh();
                com_tencent_mm_protocal_c_bjh.type = jSONObject.getInt(Columns.TYPE);
                com_tencent_mm_protocal_c_bjh.bmJ = jSONObject.getString("appid");
                com_tencent_mm_protocal_c_bjh.ndM = jSONObject.getString("formid");
                com_tencent_mm_protocal_c_bjh.ndN = jSONObject.getString("pageid");
                com_tencent_mm_protocal_c_bjh.ndO = jSONObject.getInt("appstate");
                com_tencent_mm_protocal_c_bjh.pRE = jSONObject.getInt("appversion");
                linkedList.add(com_tencent_mm_protocal_c_bjh);
            }
        } catch (Exception e) {
            v.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
        }
        ak.yW();
        c.vf().a(a.ntw, "");
        return linkedList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.dJz);
        parcel.writeString(this.dJA);
        parcel.writeInt(this.dJB);
        parcel.writeInt(this.bpy);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.dJz = parcel.readString();
        this.dJA = parcel.readString();
        this.dJB = parcel.readInt();
        this.bpy = parcel.readInt();
    }
}
