package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.as.a.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsApiChooseVideo extends a {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    private static volatile boolean dFS = false;

    private static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new Creator<ChooseRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ChooseRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }
        };
        String appId;
        boolean dFA;
        boolean dFB;
        int dFU;

        protected final Class<? extends AppBrandProxyUIProcessTask> PF() {
            return a.class;
        }

        protected final void e(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.dFU = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.dFA = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.dFB = z2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.appId);
            parcel.writeInt(this.dFU);
            if (this.dFA) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.dFB) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
        }

        protected final boolean PN() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            e(parcel);
        }
    }

    private static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new Creator<ChooseResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ChooseResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }
        };
        int aKK;
        AppBrandLocalVideoObject dFV;

        protected final void e(Parcel parcel) {
            this.aKK = parcel.readInt();
            this.dFV = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aKK);
            parcel.writeParcelable(this.dFV, i);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            e(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private p dFI;
        private OnCancelListener dFJ;
        private ChooseResult dFW = new ChooseResult();
        private ChooseRequest dFX;
        private String dFY;

        private a() {
        }

        protected final void a(ProcessRequest processRequest) {
            boolean z;
            this.dFX = (ChooseRequest) processRequest;
            this.dFX.dFU = Math.min(Math.max(this.dFX.dFU, 60), 0);
            if (be.dX(PL()) > 200) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                s.makeText(PL(), aa.getResources().getString(2131236613), 1).show();
            }
            PL().nDS = this;
            Intent intent = new Intent();
            intent.putExtra("key_send_raw_image", false);
            intent.putExtra("query_media_type", 2);
            if (this.dFX.dFA && this.dFX.dFB) {
                this.dFY = e.cgg + "microMsg." + System.currentTimeMillis() + ".mp4";
                intent.putExtra("record_video_force_sys_camera", true);
                intent.putExtra("record_video_quality", 1);
                intent.putExtra("record_video_time_limit", this.dFX.dFU);
                intent.putExtra("video_full_path", this.dFY);
                l.c(PL(), 1, 7, intent);
            } else if (this.dFX.dFA) {
                this.dFY = e.cgg + "microMsg." + System.currentTimeMillis() + ".mp4";
                l.a(PL(), this.dFY, 5, this.dFX.dFU, 1, false);
            } else if (this.dFX.dFB) {
                intent.putExtra("show_header_view", false);
                l.c(PL(), 1, 7, intent);
            } else {
                this.dFW.aKK = -2;
                a(this.dFW);
            }
        }

        protected final void PE() {
            super.PE();
            if (this.dFI != null) {
                this.dFI.dismiss();
                this.dFI = null;
            }
        }

        private void PZ() {
            this.dFJ = new OnCancelListener(this) {
                final /* synthetic */ a dFZ;

                {
                    this.dFZ = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.dFZ.dFW.aKK = 0;
                    this.dFZ.a(this.dFZ.dFW);
                }
            };
            MMActivity PL = PL();
            aa.getResources().getString(2131231164);
            this.dFI = g.a(PL, aa.getResources().getString(2131236603), true, this.dFJ);
        }

        public final void a(int i, int i2, Intent intent) {
            if (i2 == 0) {
                this.dFW.aKK = 0;
                a(this.dFW);
            } else if (-1 != i2) {
                this.dFW.aKK = -2;
                a(this.dFW);
            } else {
                switch (i) {
                    case 4:
                        List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (!be.bP(stringArrayListExtra)) {
                            final String str = (String) stringArrayListExtra.get(0);
                            final boolean booleanExtra = intent.getBooleanExtra("key_selected_video_is_from_sys_camera", false);
                            PZ();
                            com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable(this) {
                                final /* synthetic */ a dFZ;

                                public final void run() {
                                    this.dFZ.dFW.aKK = -1;
                                    this.dFZ.dFW.dFV = this.dFZ.K(str, booleanExtra);
                                    this.dFZ.a(this.dFZ.dFW);
                                }
                            });
                            return;
                        }
                        break;
                    case 5:
                        if (!be.kS(this.dFY)) {
                            PZ();
                            com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable(this) {
                                final /* synthetic */ a dFZ;

                                {
                                    this.dFZ = r1;
                                }

                                public final void run() {
                                    if (new File(this.dFZ.dFY).exists()) {
                                        this.dFZ.dFW.aKK = -1;
                                        this.dFZ.dFW.dFV = this.dFZ.K(this.dFZ.dFY, true);
                                        this.dFZ.a(this.dFZ.dFW);
                                        return;
                                    }
                                    this.dFZ.dFW.aKK = -2;
                                    this.dFZ.a(this.dFZ.dFW);
                                }
                            });
                            return;
                        }
                        break;
                }
                this.dFW.aKK = -2;
                a(this.dFW);
            }
        }

        private AppBrandLocalVideoObject K(String str, boolean z) {
            MediaMetadataRetriever mediaMetadataRetriever;
            if (z) {
                try {
                    boolean kR = d.kR(str);
                    v.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", new Object[]{Boolean.valueOf(kR)});
                    int i = -10000;
                    if (kR) {
                        i = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, 1000000);
                        v.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", new Object[]{Integer.valueOf(i)});
                    }
                    if (i == -1 || !kR) {
                        v.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.aQ(str))});
                        i = com.tencent.mm.a.e.aQ(str) > 26214400 ? -1 : 1;
                    }
                    switch (i) {
                        case -6:
                        case -5:
                        case -4:
                        case -3:
                        case ai.CTRL_INDEX /*-2*/:
                        case -1:
                            i = -50002;
                            break;
                        case 0:
                            i = -50006;
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            i = 1;
                            break;
                        default:
                            v.e("MicroMsg.JsApiChooseVideo", "unknown check type");
                            i = -50001;
                            break;
                    }
                    if (i == -50006) {
                        int[] iArr = new int[2];
                        h.a(str, iArr);
                        int i2 = iArr[0];
                        int i3 = iArr[1];
                        String str2 = e.cgg + "microMsg." + System.currentTimeMillis() + ".mp4";
                        i = SightVideoJNI.remuxing(str, str2, i2, i3, b.iTu, b.iTt, 8, 2, 25.0f, b.iTv, null, 0);
                        v.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        str = str2;
                    }
                } catch (Throwable e) {
                    v.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[]{be.e(e)});
                }
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                v.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e2});
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                v.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
                return null;
            }
            int i4 = be.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i2 = be.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i3 = be.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            AppBrandLocalVideoObject ax = c.ax(this.dFX.appId, str);
            ax.duration = (i3 + 500) / BaseReportManager.MAX_READ_COUNT;
            ax.width = i4;
            ax.height = i2;
            ax.size = com.tencent.mm.a.e.aQ(str);
            v.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[]{ax});
            return ax;
        }
    }

    JsApiChooseVideo() {
    }

    public final void a(final f fVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        if (dFS) {
            fVar.y(i, c("cancel", null));
            return;
        }
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        ProcessRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        v.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[]{optJSONArray, jSONObject.optString("maxDuration")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.dFA = true;
            chooseRequest.dFB = true;
        } else {
            chooseRequest.dFA = optJSONArray.toString().contains("camera");
            chooseRequest.dFB = optJSONArray.toString().contains("album");
        }
        if (chooseRequest.dFA) {
            com.tencent.mm.plugin.appbrand.a.a(fVar.dzg, new android.support.v4.app.a.a(this) {
                final /* synthetic */ JsApiChooseVideo dFT;

                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 115) {
                        if (iArr[0] == 0) {
                            this.dFT.a(fVar, jSONObject, i);
                        } else {
                            fVar.y(i, this.dFT.c("fail:system permission denied", null));
                        }
                    }
                }
            });
            MMActivity nt2 = d.nt(fVar.dzg);
            if (nt2 == null) {
                fVar.y(i, c("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.i.a.a(nt2, "android.permission.CAMERA", 115, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.mq(fVar.dzg);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        dFS = true;
        chooseRequest.dFU = be.getInt(r4, 60);
        chooseRequest.appId = fVar.dzg;
        com.tencent.mm.plugin.appbrand.ipc.a.a(nt, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>(this) {
            final /* synthetic */ JsApiChooseVideo dFT;

            public final /* synthetic */ void c(ProcessResult processResult) {
                ChooseResult chooseResult = (ChooseResult) processResult;
                JsApiChooseVideo.dFS = false;
                if (chooseResult != null) {
                    switch (chooseResult.aKK) {
                        case -1:
                            AppBrandLocalVideoObject appBrandLocalVideoObject = chooseResult.dFV;
                            if (appBrandLocalVideoObject == null) {
                                v.e("MicroMsg.JsApiChooseVideo", "choose result code is OK but videoObj null");
                                break;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("tempFilePath", appBrandLocalVideoObject.bde);
                            hashMap.put("duration", Integer.valueOf(appBrandLocalVideoObject.duration));
                            hashMap.put("size", Integer.valueOf(appBrandLocalVideoObject.size));
                            hashMap.put("height", Integer.valueOf(appBrandLocalVideoObject.height));
                            hashMap.put("width", Integer.valueOf(appBrandLocalVideoObject.width));
                            fVar.y(i, this.dFT.c("ok", hashMap));
                            return;
                        case 0:
                            fVar.y(i, this.dFT.c("cancel", null));
                            return;
                    }
                }
                fVar.y(i, this.dFT.c("fail", null));
            }
        });
    }
}
