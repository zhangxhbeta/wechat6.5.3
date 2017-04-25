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
import com.tencent.mm.plugin.appbrand.netscene.d;
import com.tencent.mm.plugin.appbrand.netscene.e;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLogin extends a {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";
    private static LoginTask dHm;

    public static class LoginTask extends MainProcessTask {
        public static final Creator<LoginTask> CREATOR = new Creator<LoginTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LoginTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoginTask[i];
            }
        };
        public String appId;
        public int bpD;
        public String code;
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
        public int dHn;
        public String dHo;
        public String data;

        public interface a {
            void OK();

            void a(LinkedList<arn> linkedList, String str, String str2, String str3);

            void nB(String str);
        }

        public LoginTask(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            final a anonymousClass1 = new a(this) {
                final /* synthetic */ LoginTask dHp;

                {
                    this.dHp = r1;
                }

                public final void nB(String str) {
                    v.d("MicroMsg.JsApiLogin", "onSuccess !");
                    this.dHp.code = str;
                    this.dHp.dFh = "ok";
                    this.dHp.PP();
                }

                public final void OK() {
                    v.e("MicroMsg.JsApiLogin", "onFailure !");
                    this.dHp.dFh = "fail";
                    this.dHp.PP();
                }

                public final void a(LinkedList<arn> linkedList, String str, String str2, String str3) {
                    v.d("MicroMsg.JsApiLogin", "onConfirm !");
                    this.dHp.dFl = linkedList.size();
                    int i = 0;
                    while (i < this.dHp.dFl) {
                        try {
                            this.dHp.dFm.putByteArray(String.valueOf(i), ((arn) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            v.e("MicroMsg.JsApiLogin", "IOException %s", new Object[]{e.getMessage()});
                            v.a("MicroMsg.JsApiLogin", e, "", new Object[0]);
                            this.dHp.dFh = "fail";
                            this.dHp.PP();
                            return;
                        }
                    }
                    this.dHp.dHo = str3;
                    this.dHp.dFj = str;
                    this.dHp.dFk = str2;
                    this.dHp.dFh = "needConfirm";
                    this.dHp.PP();
                }
            };
            if (this.dFg.equals(JsApiLogin.NAME)) {
                LinkedList linkedList = new LinkedList();
                this.dHn = 1;
                this.dHo = "";
                ak.vy().a(new d(this.appId, linkedList, this.dHn, "", this.dHo, this.bpD, new com.tencent.mm.plugin.appbrand.netscene.d.a<d>(this) {
                    final /* synthetic */ LoginTask dHp;

                    public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                        d dVar = (d) kVar;
                        v.d("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i != 0 || i2 != 0) {
                            anonymousClass1.OK();
                        } else if (dVar instanceof d) {
                            aej com_tencent_mm_protocal_c_aej = dVar.cif == null ? null : (aej) dVar.cif.czl.czs;
                            int i3 = com_tencent_mm_protocal_c_aej.mmP.bcd;
                            String str2 = com_tencent_mm_protocal_c_aej.mmP.bce;
                            String str3 = com_tencent_mm_protocal_c_aej.mEL;
                            v.i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                            if (i3 == -12000) {
                                LinkedList linkedList = com_tencent_mm_protocal_c_aej.mvQ;
                                v.d("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", new Object[]{com_tencent_mm_protocal_c_aej.hNZ, com_tencent_mm_protocal_c_aej.maV});
                                anonymousClass1.a(linkedList, str2, r0, str3);
                            } else if (i3 == 0) {
                                anonymousClass1.nB(com_tencent_mm_protocal_c_aej.mEM);
                                v.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                            } else if (i3 == -12001) {
                                anonymousClass1.OK();
                                v.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", new Object[]{str2});
                            } else if (i3 == -12002) {
                                anonymousClass1.OK();
                                v.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", new Object[]{str2});
                            } else if (i3 == -12003) {
                                anonymousClass1.OK();
                                v.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", new Object[]{str2});
                            } else {
                                anonymousClass1.OK();
                                v.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                            }
                        }
                    }
                }), 0);
            } else if (this.dFg.equals("loginConfirm")) {
                a(this.appId, this.dFf, this.dHn, this.dHo, this.bpD, this.dFi, anonymousClass1);
            }
        }

        public final void OM() {
            if (this.dFh.equals("ok")) {
                Map hashMap = new HashMap();
                hashMap.put("code", this.code);
                this.dFd.y(this.dFe, this.dFc.c("ok", hashMap));
            } else if (this.dFh.equals("fail")) {
                this.dFd.y(this.dFe, this.dFc.c("fail", null));
            } else if (this.dFh.equals("needConfirm")) {
                c cVar = new c(d.nt(this.dFd.dzg));
                com.tencent.mm.plugin.appbrand.widget.c.a anonymousClass2 = new com.tencent.mm.plugin.appbrand.widget.c.a(this) {
                    final /* synthetic */ LoginTask dHp;

                    {
                        this.dHp = r1;
                    }

                    public final void c(int i, Bundle bundle) {
                        v.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                        switch (i) {
                            case 1:
                            case 2:
                                this.dHp.dFg = "loginConfirm";
                                this.dHp.dFf = bundle;
                                this.dHp.dFi = i;
                                AppBrandMainProcessService.a(this.dHp);
                                if (i == 2) {
                                    this.dHp.dFd.y(this.dHp.dFe, this.dHp.dFc.c("fail auth deny", null));
                                    return;
                                }
                                return;
                            default:
                                v.d("MicroMsg.JsApiLogin", "press back button!");
                                this.dHp.dFd.y(this.dHp.dFe, this.dHp.dFc.c("fail auth cancel", null));
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
                        v.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[]{e.getMessage()});
                        v.a("MicroMsg.JsApiLogin", e, "", new Object[0]);
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
            this.dFg = parcel.readString();
            this.appId = parcel.readString();
            this.code = parcel.readString();
            this.dFh = parcel.readString();
            this.dHo = parcel.readString();
            this.dHn = parcel.readInt();
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
            parcel.writeString(this.dFg);
            parcel.writeString(this.appId);
            parcel.writeString(this.code);
            parcel.writeString(this.dFh);
            parcel.writeString(this.dHo);
            parcel.writeInt(this.dHn);
            parcel.writeString(this.dFj);
            parcel.writeString(this.dFk);
            parcel.writeInt(this.dFl);
            parcel.writeBundle(this.dFm);
            parcel.writeBundle(this.dFf);
            parcel.writeInt(this.bpD);
            parcel.writeInt(this.dFi);
        }

        private void a(String str, Bundle bundle, int i, String str2, int i2, int i3, a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            final a aVar2 = aVar;
            final int i4 = i3;
            ak.vy().a(new e(str, linkedList, i, str2, i2, i3, new com.tencent.mm.plugin.appbrand.netscene.e.a<e>(this) {
                final /* synthetic */ LoginTask dHp;

                public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
                    e eVar = (e) kVar;
                    v.d("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        aVar2.OK();
                    } else if (!(eVar instanceof e)) {
                    } else {
                        if (i4 == 2) {
                            v.d("MicroMsg.JsApiLogin", "press reject button");
                            return;
                        }
                        aeh com_tencent_mm_protocal_c_aeh = eVar.cif == null ? null : (aeh) eVar.cif.czl.czs;
                        int i3 = com_tencent_mm_protocal_c_aeh.mmP.bcd;
                        String str2 = com_tencent_mm_protocal_c_aeh.mmP.bce;
                        v.i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == 0) {
                            aVar2.nB(com_tencent_mm_protocal_c_aeh.mEM);
                            v.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                            return;
                        }
                        aVar2.OK();
                        v.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", new Object[]{str2});
                    }
                }
            }), 0);
        }
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        LoginTask loginTask = new LoginTask();
        dHm = loginTask;
        loginTask.appId = fVar.dzg;
        dHm.dFg = NAME;
        AppBrandSysConfig mr = a.mr(fVar.dzg);
        if (mr != null) {
            dHm.bpD = mr.dDB.dBr;
        }
        loginTask = dHm;
        String jSONObject2 = jSONObject.toString();
        loginTask.dFc = this;
        loginTask.dFd = fVar;
        loginTask.data = jSONObject2;
        loginTask.dFe = i;
        loginTask.dFm = new Bundle();
        AppBrandMainProcessService.a(dHm);
    }
}
