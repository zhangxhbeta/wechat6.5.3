package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class JsApiStartRecordVoice extends a {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String dJc = null;
    private h dIW;
    private StartRecordVoice dJd;

    private static class StartRecordVoice extends MainProcessTask {
        public static final Creator<StartRecordVoice> CREATOR = new Creator<StartRecordVoice>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartRecordVoice(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartRecordVoice[i];
            }
        };
        private String appId;
        private f dFd;
        private int dFe;
        private JsApiStartRecordVoice dJf;
        private boolean dJg = false;
        private String filePath;

        StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, f fVar, int i) {
            this.dJf = jsApiStartRecordVoice;
            this.dFd = fVar;
            this.dFe = i;
            this.appId = fVar.dzg;
            this.filePath = c.av(this.appId, u.lI(this.appId));
        }

        StartRecordVoice(Parcel parcel) {
            f(parcel);
        }

        public final void OL() {
            a.vA().x(new Runnable(this) {
                final /* synthetic */ StartRecordVoice dJh;

                {
                    this.dJh = r1;
                }

                public final void run() {
                    this.dJh.dJg = com.tencent.mm.plugin.appbrand.e.a.a(this.dJh.filePath, new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 dJi;

                        {
                            this.dJi = r1;
                        }

                        public final void run() {
                            this.dJi.dJh.PP();
                        }
                    });
                    if (!this.dJh.dJg) {
                        this.dJh.PP();
                    }
                }
            });
        }

        public final void OM() {
            if (this.dJg) {
                AppBrandLocalMediaObject b = c.b(this.dFd.dzg, this.filePath, "silk", true);
                if (b != null) {
                    Map hashMap = new HashMap(1);
                    hashMap.put("tempFilePath", b.bde);
                    this.dFd.y(this.dFe, this.dJf.c("ok", hashMap));
                    v.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.dJg)});
                    this.dJf.bv(false);
                }
            }
            this.dFd.y(this.dFe, this.dJf.c("fail", null));
            v.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.dJg)});
            this.dJf.bv(false);
        }

        public final void f(Parcel parcel) {
            this.dFe = parcel.readInt();
            this.appId = parcel.readString();
            this.filePath = parcel.readString();
            this.dJg = parcel.readByte() != (byte) 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dFe);
            parcel.writeString(this.appId);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.dJg ? (byte) 1 : (byte) 0);
        }
    }

    JsApiStartRecordVoice() {
    }

    public final void a(final f fVar, final JSONObject jSONObject, final int i) {
        boolean z;
        com.tencent.mm.plugin.appbrand.a.a(fVar.dzg, new android.support.v4.app.a.a(this) {
            final /* synthetic */ JsApiStartRecordVoice dJe;

            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 116) {
                    if (iArr[0] == 0) {
                        this.dJe.a(fVar, jSONObject, i);
                    } else {
                        fVar.y(i, this.dJe.c("fail:system permission denied", null));
                    }
                }
            }
        });
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.i.a.a(nt, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.mq(fVar.dzg);
            }
        }
        if (z) {
            this.dIW = d.a(fVar);
            if (this.dIW == null) {
                fVar.y(i, c("fail", null));
                return;
            }
            this.dIW.a(new h.a(this) {
                final /* synthetic */ JsApiStartRecordVoice dJe;

                {
                    this.dJe = r1;
                }

                public final void Qi() {
                    this.dJe.dIW.og("");
                    if (!be.kS(JsApiStartRecordVoice.dJc)) {
                        AppBrandMainProcessService.a(new StopRecordVoice());
                        JsApiStartRecordVoice.dJc = null;
                    }
                    this.dJe.dIW.b((h.a) this);
                }
            });
            this.dJd = new StartRecordVoice(this, fVar, i);
            dJc = this.dJd.filePath;
            AppBrandMainProcessService.a(this.dJd);
            bv(true);
        }
    }

    private void bv(boolean z) {
        if (this.dIW != null) {
            if (z) {
                this.dIW.og(aa.getContext().getString(2131230947));
                this.dIW.Rr();
                return;
            }
            this.dIW.og(null);
        }
    }
}
