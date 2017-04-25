package com.tencent.mm.plugin.appbrand.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.protocal.c.bq;
import com.tencent.mm.protocal.c.br;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;

final class AddWxAppContactTask extends AppBrandProxyUIProcessTask {
    private AddRequest dDW;
    private p dDX;

    public static final class AddRequest extends ProcessRequest {
        public static final Creator<AddRequest> CREATOR = new Creator<AddRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AddRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddRequest[i];
            }
        };
        public int dDZ;
        public String extInfo;
        public int scene;
        public String username;

        protected final Class<? extends AppBrandProxyUIProcessTask> PF() {
            return AddWxAppContactTask.class;
        }

        protected final void e(Parcel parcel) {
            this.username = parcel.readString();
            this.extInfo = parcel.readString();
            this.scene = parcel.readInt();
            this.dDZ = parcel.readInt();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeString(this.extInfo);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.dDZ);
        }

        AddRequest(Parcel parcel) {
            super(parcel);
        }
    }

    public static final class AddResult extends ProcessResult {
        public static final Creator<AddResult> CREATOR = new Creator<AddResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AddResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddResult[i];
            }
        };
        public String biS;
        public int ret;

        protected final void e(Parcel parcel) {
            this.ret = parcel.readInt();
            this.biS = parcel.readString();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ret);
            parcel.writeString(this.biS);
        }

        AddResult() {
        }

        AddResult(Parcel parcel) {
            super(parcel);
        }
    }

    AddWxAppContactTask() {
    }

    protected final void a(ProcessRequest processRequest) {
        this.dDW = (AddRequest) processRequest;
        MMActivity PL = PL();
        aa.getResources().getString(2131231164);
        this.dDX = g.a(PL, aa.getResources().getString(2131233521), true, new OnCancelListener(this) {
            final /* synthetic */ AddWxAppContactTask dDY;

            {
                this.dDY = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                a.aD(this.dDY);
                this.dDY.a(null);
            }
        });
        a.aC(this);
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/micromsg-bin/addwxapp";
        aVar.czm = 670;
        aVar.czp = 0;
        aVar.czq = 0;
        aVar.czo = new br();
        if (!this.dDW.username.endsWith("@app")) {
            StringBuilder stringBuilder = new StringBuilder();
            AddRequest addRequest = this.dDW;
            addRequest.username = stringBuilder.append(addRequest.username).append("@app").toString();
        }
        bq bqVar = new bq();
        bqVar.gln = this.dDW.username;
        bqVar.maG = this.dDW.scene;
        bqVar.mci = this.dDW.dDZ;
        bqVar.gor = this.dDW.extInfo;
        aVar.czn = bqVar;
        u.a(aVar.Bv(), new u.a(this) {
            final /* synthetic */ AddWxAppContactTask dDY;

            {
                this.dDY = r1;
            }

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                br brVar;
                AddResult addResult;
                if (i == 0 && i2 == 0) {
                    brVar = (br) bVar.czl.czs;
                    addResult = new AddResult();
                    addResult.ret = brVar.mcj;
                    addResult.biS = brVar.fvD;
                    this.dDY.a(addResult);
                    if (addResult.ret == 0) {
                        b bVar2 = com.tencent.mm.plugin.appbrand.a.a.dzQ;
                        String str2 = this.dDY.dDW.username;
                        if (!be.kS(str2)) {
                            a aVar = new a();
                            aVar.field_UserName = str2;
                            if (!bVar2.a(aVar, new String[0])) {
                                bVar2.a(aVar);
                            }
                        }
                    }
                } else {
                    v.e("MicroMsg.AppBrand.AddWxAppContactTask", "AddWxAppContact, username = %s, errType = %d, errCode = %d, errMsg = %s", new Object[]{this.dDY.dDW.username, Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i2 == -101) {
                        brVar = (br) bVar.czl.czs;
                        addResult = new AddResult();
                        addResult.ret = brVar.mcj;
                        addResult.biS = brVar.fvD;
                        this.dDY.a(addResult);
                    } else {
                        AddResult addResult2 = new AddResult();
                        addResult2.ret = i;
                        this.dDY.a(addResult2);
                    }
                }
                return 0;
            }
        }, true);
    }

    protected final void PE() {
        if (this.dDX != null) {
            this.dDX.dismiss();
        }
        a.aD(this);
    }
}
