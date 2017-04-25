package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

final class JsApiOperateWXData extends a {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";
    private static OperateWXDataTask dHI;

    public static class OperateWXDataTask extends MainProcessTask {
        public static final Creator<OperateWXDataTask> CREATOR = new Creator<OperateWXDataTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateWXDataTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateWXDataTask[i];
            }
        };
        public String appId;
        public int bpD;
        d dFc;
        f dFd;
        public int dFe;
        public String dFg;
        public String dFh;
        public int dFi;
        public String dFj;
        public String dFk;
        public int dFl;
        public Bundle dFm;
        public String dHJ;
        public String dHK;
        public String dHL;

        public interface a {
            void OK();

            void a(LinkedList<arn> linkedList, String str, String str2);

            void nB(String str);
        }

        public OperateWXDataTask(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            a anonymousClass1 = new a(this) {
                final /* synthetic */ OperateWXDataTask dHM;

                {
                    this.dHM = r1;
                }

                public final void nB(String str) {
                    v.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
                    this.dHM.dHK = str;
                    this.dHM.dFh = "ok";
                    this.dHM.PP();
                }

                public final void OK() {
                    v.e("MicroMsg.JsApiOperateWXData", "onFailure !");
                    this.dHM.dFh = "fail";
                    this.dHM.PP();
                }

                public final void a(LinkedList<arn> linkedList, String str, String str2) {
                    v.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
                    this.dHM.dFl = linkedList.size();
                    int i = 0;
                    while (i < this.dHM.dFl) {
                        try {
                            this.dHM.dFm.putByteArray(String.valueOf(i), ((arn) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            v.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                            v.a("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                            this.dHM.dFh = "fail";
                            this.dHM.PP();
                            return;
                        }
                    }
                    this.dHM.dFj = str;
                    this.dHM.dFk = str2;
                    this.dHM.dFh = "needConfirm";
                    this.dHM.PP();
                }
            };
            if (this.dFg.equals(JsApiOperateWXData.NAME)) {
                a(this.appId, this.dHJ, "", this.bpD, this.dFi, anonymousClass1);
            } else if (this.dFg.equals("operateWXDataConfirm")) {
                a(this.appId, this.dHJ, this.dHL, this.bpD, this.dFi, anonymousClass1);
            }
        }

        public final void OM() {
            if (this.dFh.equals("ok")) {
                Map hashMap = new HashMap();
                hashMap.put("data", this.dHK);
                this.dFd.y(this.dFe, this.dFc.c("ok", hashMap));
            } else if (this.dFh.equals("fail")) {
                this.dFd.y(this.dFe, this.dFc.c("fail", null));
            } else if (this.dFh.equals("needConfirm")) {
                c cVar = new c(d.nt(this.dFd.dzg));
                com.tencent.mm.plugin.appbrand.widget.c.a anonymousClass2 = new com.tencent.mm.plugin.appbrand.widget.c.a(this) {
                    final /* synthetic */ OperateWXDataTask dHM;

                    {
                        this.dHM = r1;
                    }

                    public final void c(int i, Bundle bundle) {
                        v.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                        switch (i) {
                            case 1:
                            case 2:
                                this.dHM.dFg = "operateWXDataConfirm";
                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                if (arrayList == null || arrayList.size() <= 0) {
                                    this.dHM.dHL = "";
                                } else {
                                    this.dHM.dHL = (String) arrayList.get(0);
                                }
                                this.dHM.dFi = i;
                                AppBrandMainProcessService.a(this.dHM);
                                if (i == 2) {
                                    this.dHM.dFd.y(this.dHM.dFe, this.dHM.dFc.c("fail auth deny", null));
                                    return;
                                }
                                return;
                            default:
                                v.d("MicroMsg.JsApiOperateWXData", "press back button!");
                                this.dHM.dFd.y(this.dHM.dFe, this.dHM.dFc.c("fail auth cancel", null));
                                return;
                        }
                    }
                };
                LinkedList linkedList = new LinkedList();
                int i = 0;
                while (i < this.dFl) {
                    byte[] byteArray = this.dFm.getByteArray(String.valueOf(i));
                    arn com_tencent_mm_protocal_c_arn = new arn();
                    try {
                        com_tencent_mm_protocal_c_arn.az(byteArray);
                        linkedList.add(com_tencent_mm_protocal_c_arn);
                        i++;
                    } catch (Throwable e) {
                        v.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                        v.a("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                        this.dFd.y(this.dFe, this.dFc.c("fail", null));
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    cVar.a(linkedList, this.dFj, this.dFk, anonymousClass2);
                } else {
                    this.dFd.y(this.dFe, this.dFc.c("fail", null));
                }
            }
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.dFh = parcel.readString();
            this.dFj = parcel.readString();
            this.dFk = parcel.readString();
            this.dHJ = parcel.readString();
            this.dHK = parcel.readString();
            this.dFe = parcel.readInt();
            this.dFg = parcel.readString();
            this.dHL = parcel.readString();
            this.dFl = parcel.readInt();
            this.dFm = parcel.readBundle();
            this.bpD = parcel.readInt();
            this.dFi = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.dFh);
            parcel.writeString(this.dFj);
            parcel.writeString(this.dFk);
            parcel.writeString(this.dHJ);
            parcel.writeString(this.dHK);
            parcel.writeInt(this.dFe);
            parcel.writeString(this.dFg);
            parcel.writeString(this.dHL);
            parcel.writeInt(this.dFl);
            parcel.writeBundle(this.dFm);
            parcel.writeInt(this.bpD);
            parcel.writeInt(this.dFi);
        }

        private void a(String str, String str2, String str3, int i, final int i2, final a aVar) {
            ak.vy().a(new com.tencent.mm.plugin.appbrand.netscene.f(str, str2, str3, i, i2, new com.tencent.mm.plugin.appbrand.netscene.f.a<com.tencent.mm.plugin.appbrand.netscene.f>(this) {
                final /* synthetic */ OperateWXDataTask dHM;

                public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                    com.tencent.mm.plugin.appbrand.netscene.f fVar = (com.tencent.mm.plugin.appbrand.netscene.f) kVar;
                    v.d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        aVar.OK();
                    } else if (!(fVar instanceof com.tencent.mm.plugin.appbrand.netscene.f)) {
                    } else {
                        if (i2 == 2) {
                            v.d("MicroMsg.JsApiOperateWXData", "press reject button");
                            return;
                        }
                        ael com_tencent_mm_protocal_c_ael = fVar.cif == null ? null : (ael) fVar.cif.czl.czs;
                        int i3 = com_tencent_mm_protocal_c_ael.mmP.bcd;
                        String str2 = com_tencent_mm_protocal_c_ael.mmP.bce;
                        arn com_tencent_mm_protocal_c_arn = com_tencent_mm_protocal_c_ael.mEQ;
                        LinkedList linkedList = new LinkedList();
                        if (com_tencent_mm_protocal_c_arn != null) {
                            linkedList.add(com_tencent_mm_protocal_c_arn);
                        }
                        String str3 = com_tencent_mm_protocal_c_ael.hNZ;
                        String str4 = com_tencent_mm_protocal_c_ael.maV;
                        v.d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == -12000) {
                            aVar.a(linkedList, str3, str4);
                        } else if (i3 == 0) {
                            v.d("MicroMsg.JsApiOperateWXData", "resp data %s", new Object[]{com_tencent_mm_protocal_c_ael.eew.brp()});
                            aVar.nB(r0);
                        } else {
                            v.e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[]{str2});
                            aVar.OK();
                        }
                    }
                }
            }), 0);
        }
    }

    JsApiOperateWXData() {
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        try {
            String string = jSONObject.getString("data");
            OperateWXDataTask operateWXDataTask = new OperateWXDataTask();
            dHI = operateWXDataTask;
            operateWXDataTask.appId = fVar.dzg;
            dHI.dFg = NAME;
            AppBrandSysConfig mr = a.mr(fVar.dzg);
            if (mr != null) {
                dHI.bpD = mr.dDB.dBr;
            }
            operateWXDataTask = dHI;
            operateWXDataTask.dFc = this;
            operateWXDataTask.dFd = fVar;
            operateWXDataTask.dHJ = string;
            operateWXDataTask.dFe = i;
            operateWXDataTask.dFm = new Bundle();
            AppBrandMainProcessService.a(dHI);
        } catch (Exception e) {
            v.e("MicroMsg.JsApiOperateWXData", "Exception %s", new Object[]{e.getMessage()});
            fVar.y(i, c("fail", null));
        }
    }
}
