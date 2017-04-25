package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ay.c;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.mm.v.u.a;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiScanCode extends a {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean dHZ = false;

    public static class GetA8KeyTask extends MainProcessTask {
        public static final Creator<GetA8KeyTask> CREATOR = new Creator<GetA8KeyTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                getA8KeyTask.f(parcel);
                return getA8KeyTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetA8KeyTask[i];
            }
        };
        public int actionCode;
        public String dIe;
        public String dIf;
        public Runnable dIg;

        public final void OL() {
            final l lVar = new l(this.dIe, null, 36);
            u.a(lVar.cif, new a(this) {
                final /* synthetic */ GetA8KeyTask dIi;

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        this.dIi.actionCode = lVar.IV();
                        switch (this.dIi.actionCode) {
                            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                                this.dIi.dIf = lVar.IT();
                                break;
                            default:
                                this.dIi.dIf = "";
                                break;
                        }
                        this.dIi.PP();
                    } else {
                        this.dIi.actionCode = -1;
                        this.dIi.PP();
                    }
                    return 0;
                }
            });
        }

        public final void OM() {
            if (this.dIg != null) {
                this.dIg.run();
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.dIe);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.dIf);
        }

        public final void f(Parcel parcel) {
            this.dIe = parcel.readString();
            this.actionCode = parcel.readInt();
            this.dIf = parcel.readString();
        }
    }

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        if (dHZ) {
            fVar.y(i, c("cancel", null));
            return;
        }
        dHZ = true;
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        nt.nDS = new MMActivity.a(this) {
            final /* synthetic */ JsApiScanCode dIa;

            public final void a(int i, int i2, Intent intent) {
                JsApiScanCode.dHZ = false;
                if (i == (this.dIa.hashCode() & 65535)) {
                    switch (i2) {
                        case -1:
                            Object obj;
                            int i3;
                            if (intent == null) {
                                obj = "";
                                i3 = 0;
                            } else {
                                obj = intent.getStringExtra("key_scan_result");
                                i3 = intent.getIntExtra("key_scan_result_type", 0);
                            }
                            final HashMap hashMap = new HashMap();
                            hashMap.put("charSet", ProtocolPackage.ServerEncoding);
                            if (i3 != 1) {
                                String[] split = obj.split(",");
                                String str = "result";
                                if (split.length > 1) {
                                    obj = split[1];
                                }
                                hashMap.put(str, obj);
                                hashMap.put("scanType", split.length > 1 ? split[0] : "");
                                fVar.y(i, this.dIa.c("ok", hashMap));
                                return;
                            }
                            hashMap.put("result", obj);
                            hashMap.put("scanType", "QR_CODE");
                            final MainProcessTask getA8KeyTask = new GetA8KeyTask();
                            getA8KeyTask.dIe = obj;
                            getA8KeyTask.dIg = new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 dId;

                                public final void run() {
                                    getA8KeyTask.PR();
                                    if (getA8KeyTask.actionCode == 26) {
                                        Uri parse = Uri.parse(getA8KeyTask.dIf);
                                        if (com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg).aWH.equals(parse.getQueryParameter("username"))) {
                                            hashMap.put("path", URLDecoder.decode(be.ma(parse.getQueryParameter("path"))));
                                        }
                                    }
                                    fVar.y(i, this.dId.dIa.c("ok", hashMap));
                                }
                            };
                            getA8KeyTask.PQ();
                            AppBrandMainProcessService.a(getA8KeyTask);
                            return;
                        case 0:
                            fVar.y(i, this.dIa.c("cancel", null));
                            return;
                        default:
                            fVar.y(i, this.dIa.c("fail", null));
                            return;
                    }
                }
            }
        };
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_is_finish_on_scanned", true);
        c.a(nt, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & 65535, false);
    }
}
