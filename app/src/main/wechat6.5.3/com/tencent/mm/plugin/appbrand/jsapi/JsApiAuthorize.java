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
import com.tencent.mm.plugin.appbrand.netscene.b;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends a {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";
    private static AuthorizeTask dFb;

    public static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new Creator<AuthorizeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AuthorizeTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthorizeTask[i];
            }
        };
        public String appId;
        public int bpD;
        d dFc;
        f dFd;
        public int dFe;
        public Bundle dFf;
        public String dFg;
        public String dFh;
        public int dFi;
        public String dFj;
        public String dFk;
        public int dFl;
        public Bundle dFm;
        public String data;

        public interface a {
            void OK();

            void a(LinkedList<arn> linkedList, String str, String str2);

            void onSuccess();
        }

        public AuthorizeTask(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            final a anonymousClass1 = new a(this) {
                final /* synthetic */ AuthorizeTask dFn;

                {
                    this.dFn = r1;
                }

                public final void onSuccess() {
                    v.d("MicroMsg.JsApiAuthorize", "onSuccess !");
                    this.dFn.dFh = "ok";
                    this.dFn.PP();
                }

                public final void OK() {
                    v.e("MicroMsg.JsApiAuthorize", "onFailure !");
                    this.dFn.dFh = "fail";
                    this.dFn.PP();
                }

                public final void a(LinkedList<arn> linkedList, String str, String str2) {
                    v.d("MicroMsg.JsApiAuthorize", "onConfirm !");
                    this.dFn.dFl = linkedList.size();
                    int i = 0;
                    while (i < this.dFn.dFl) {
                        try {
                            this.dFn.dFm.putByteArray(String.valueOf(i), ((arn) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            v.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                            v.a("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                            this.dFn.dFh = "fail";
                            this.dFn.PP();
                            return;
                        }
                    }
                    this.dFn.dFj = str;
                    this.dFn.dFk = str2;
                    this.dFn.dFh = "needConfirm";
                    this.dFn.PP();
                }
            };
            if (this.dFg.equals(JsApiAuthorize.NAME)) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    ak.vy().a(new b(this.appId, linkedList, this.bpD, new com.tencent.mm.plugin.appbrand.netscene.b.a<b>(this) {
                        final /* synthetic */ AuthorizeTask dFn;

                        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                            b bVar = (b) kVar;
                            v.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                            if (i != 0 || i2 != 0) {
                                anonymousClass1.OK();
                            } else if (bVar instanceof b) {
                                aef com_tencent_mm_protocal_c_aef = bVar.cif == null ? null : (aef) bVar.cif.czl.czs;
                                int i3 = com_tencent_mm_protocal_c_aef.mmP.bcd;
                                String str2 = com_tencent_mm_protocal_c_aef.mmP.bce;
                                v.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                                if (i3 == -12000) {
                                    anonymousClass1.a(com_tencent_mm_protocal_c_aef.mvQ, com_tencent_mm_protocal_c_aef.hNZ, com_tencent_mm_protocal_c_aef.maV);
                                } else if (i3 == 0) {
                                    anonymousClass1.onSuccess();
                                } else {
                                    v.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                                    anonymousClass1.OK();
                                }
                            }
                        }
                    }), 0);
                } catch (Exception e) {
                    v.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[]{e.getMessage()});
                    this.dFh = "fail";
                    PP();
                }
            } else if (this.dFg.equals("authorizeConfirm")) {
                a(this.appId, this.dFf, this.bpD, this.dFi, anonymousClass1);
            }
        }

        public final void OM() {
            if (this.dFh.equals("ok")) {
                this.dFd.y(this.dFe, this.dFc.c("ok", null));
            } else if (this.dFh.equals("fail")) {
                this.dFd.y(this.dFe, this.dFc.c("fail", null));
            } else if (this.dFh.equals("needConfirm")) {
                c cVar = new c(d.nt(this.dFd.dzg));
                com.tencent.mm.plugin.appbrand.widget.c.a anonymousClass2 = new com.tencent.mm.plugin.appbrand.widget.c.a(this) {
                    final /* synthetic */ AuthorizeTask dFn;

                    {
                        this.dFn = r1;
                    }

                    public final void c(int i, Bundle bundle) {
                        v.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                        switch (i) {
                            case 1:
                            case 2:
                                this.dFn.dFg = "authorizeConfirm";
                                this.dFn.dFf = bundle;
                                this.dFn.dFi = i;
                                AppBrandMainProcessService.a(this.dFn);
                                if (i == 2) {
                                    this.dFn.dFd.y(this.dFn.dFe, this.dFn.dFc.c("fail auth deny", null));
                                    return;
                                }
                                return;
                            default:
                                v.d("MicroMsg.JsApiAuthorize", "press back button!");
                                this.dFn.dFd.y(this.dFn.dFe, this.dFn.dFc.c("fail auth cancel", null));
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
                        v.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                        v.a("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
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
            this.data = parcel.readString();
            this.dFe = parcel.readInt();
            this.appId = parcel.readString();
            this.dFh = parcel.readString();
            this.dFg = parcel.readString();
            this.dFj = parcel.readString();
            this.dFk = parcel.readString();
            this.dFl = parcel.readInt();
            this.dFm = parcel.readBundle();
            this.dFf = parcel.readBundle();
            this.bpD = parcel.readInt();
            this.dFi = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.data);
            parcel.writeInt(this.dFe);
            parcel.writeString(this.appId);
            parcel.writeString(this.dFh);
            parcel.writeString(this.dFg);
            parcel.writeString(this.dFj);
            parcel.writeString(this.dFk);
            parcel.writeInt(this.dFl);
            parcel.writeBundle(this.dFm);
            parcel.writeBundle(this.dFf);
            parcel.writeInt(this.bpD);
            parcel.writeInt(this.dFi);
        }

        private void a(String str, Bundle bundle, int i, final int i2, final a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            ak.vy().a(new com.tencent.mm.plugin.appbrand.netscene.c(str, linkedList, i, i2, new com.tencent.mm.plugin.appbrand.netscene.c.a<com.tencent.mm.plugin.appbrand.netscene.c>(this) {
                final /* synthetic */ AuthorizeTask dFn;

                public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                    com.tencent.mm.plugin.appbrand.netscene.c cVar = (com.tencent.mm.plugin.appbrand.netscene.c) kVar;
                    v.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        aVar.OK();
                    } else if (!(cVar instanceof com.tencent.mm.plugin.appbrand.netscene.c)) {
                    } else {
                        if (i2 == 2) {
                            v.d("MicroMsg.JsApiAuthorize", "press reject button");
                            return;
                        }
                        aed com_tencent_mm_protocal_c_aed = cVar.cif == null ? null : (aed) cVar.cif.czl.czs;
                        int i3 = com_tencent_mm_protocal_c_aed.mmP.bcd;
                        String str2 = com_tencent_mm_protocal_c_aed.mmP.bce;
                        v.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == 0) {
                            aVar.onSuccess();
                            return;
                        }
                        v.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
                        aVar.OK();
                    }
                }
            }), 0);
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        v.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        AuthorizeTask authorizeTask = new AuthorizeTask();
        dFb = authorizeTask;
        authorizeTask.appId = fVar.dzg;
        dFb.dFg = NAME;
        AppBrandSysConfig mr = a.mr(fVar.dzg);
        if (mr != null) {
            dFb.bpD = mr.dDB.dBr;
        }
        authorizeTask = dFb;
        String jSONObject2 = jSONObject.toString();
        authorizeTask.dFc = this;
        authorizeTask.dFd = fVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.dFe = i;
        authorizeTask.dFm = new Bundle();
        AppBrandMainProcessService.a(dFb);
    }
}
