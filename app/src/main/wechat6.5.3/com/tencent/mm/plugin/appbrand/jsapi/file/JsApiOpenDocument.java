package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public final class JsApiOpenDocument extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 99;
    private static final String NAME = "openDocument";
    private static long dJS = -1;

    private static final class OpenRequest extends ProcessRequest {
        public static final Creator<OpenRequest> CREATOR = new Creator<OpenRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OpenRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenRequest[i];
            }
        };
        public String dCf;
        public String filePath;

        protected final Class<? extends AppBrandProxyUIProcessTask> PF() {
            return a.class;
        }

        protected final void e(Parcel parcel) {
            super.e(parcel);
            this.filePath = parcel.readString();
            this.dCf = parcel.readString();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.filePath);
            parcel.writeString(this.dCf);
        }

        OpenRequest() {
        }

        OpenRequest(Parcel parcel) {
            super(parcel);
        }
    }

    private static final class OpenResult extends ProcessResult {
        public static final Creator<OpenResult> CREATOR = new Creator<OpenResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OpenResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OpenResult[i];
            }
        };
        public int ret;

        protected final void e(Parcel parcel) {
            this.ret = parcel.readInt();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ret);
        }

        OpenResult() {
        }

        OpenResult(Parcel parcel) {
            super(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        static /* synthetic */ boolean a(a aVar) {
            return aVar.dEB == null ? true : aVar.dEB.PM();
        }

        protected final void a(ProcessRequest processRequest) {
            v.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", new Object[]{Integer.valueOf(q.a(PL(), ((OpenRequest) processRequest).filePath, ((OpenRequest) processRequest).dCf, Integer.toString(PL().hashCode()), new ValueCallback<String>(this) {
                final /* synthetic */ a dJU;

                {
                    this.dJU = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    v.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, receiveValue = %s", new Object[]{(String) obj});
                    if ("fileReaderClosed".equals((String) obj) && !a.a(this.dJU)) {
                        this.dJU.a(null);
                    }
                }
            }))});
            ProcessResult openResult = new OpenResult();
            openResult.ret = r0;
            if (openResult.ret != 0) {
                a(openResult);
            } else if (this.dEB != null) {
                this.dEB.b(openResult);
            }
        }

        protected final void PE() {
            super.PE();
            PL().getWindow().setBackgroundDrawableResource(2131690078);
        }
    }

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        super.a(fVar, jSONObject, i);
        long Ni = be.Ni();
        if (Ni - dJS < 1000) {
            fVar.y(i, "document viewer already starting");
            return;
        }
        dJS = Ni;
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (be.kS(optString)) {
            fVar.y(i, c("fail:invalid data", null));
            return;
        }
        AppBrandLocalMediaObject az = c.az(fVar.dzg, optString);
        if (az == null) {
            fVar.y(i, c("fail:file doesn't exist", null));
            return;
        }
        ProcessRequest openRequest = new OpenRequest();
        openRequest.filePath = az.cvK;
        openRequest.dCf = s.Ij(az.mimeType);
        com.tencent.mm.plugin.appbrand.ipc.a.a(nt, openRequest, new b<OpenResult>(this) {
            final /* synthetic */ JsApiOpenDocument dJT;

            public final /* synthetic */ void c(ProcessResult processResult) {
                OpenResult openResult = (OpenResult) processResult;
                if (fVar != null) {
                    if (openResult == null || openResult.ret != 0) {
                        fVar.y(i, this.dJT.c("fail:file type not supported", null));
                    } else {
                        fVar.y(i, this.dJT.c("ok", null));
                    }
                }
            }
        });
    }
}
