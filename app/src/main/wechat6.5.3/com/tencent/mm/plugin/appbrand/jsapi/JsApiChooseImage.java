package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsApiChooseImage extends a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";
    private static volatile boolean dFx = false;

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
        int count;
        boolean dFA;
        boolean dFB;
        boolean dFC;
        boolean dFD;

        protected final Class<? extends AppBrandProxyUIProcessTask> PF() {
            return a.class;
        }

        protected final void e(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.appId = parcel.readString();
            this.count = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.dFA = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.dFB = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.dFC = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.dFD = z2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeString(this.appId);
            parcel.writeInt(this.count);
            if (this.dFA) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.dFB) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.dFC) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.dFD) {
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
        ArrayList<AppBrandLocalMediaObject> dFE;

        protected final void e(Parcel parcel) {
            this.aKK = parcel.readInt();
            this.dFE = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aKK);
            parcel.writeTypedList(this.dFE);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        ChooseRequest dFF;
        ChooseResult dFG = new ChooseResult();
        int dFH;
        private p dFI;
        private OnCancelListener dFJ;

        private a() {
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            aVar.PL().nDS = aVar;
            c.b(aVar.PL(), str, str2, intent, 3);
        }

        protected final void a(ProcessRequest processRequest) {
            boolean z;
            this.dFF = (ChooseRequest) processRequest;
            this.dFF.count = Math.max(1, Math.min(9, this.dFF.count));
            this.dFH = (this.dFF.dFC & this.dFF.dFD) != 0 ? 8 : 7;
            if (be.dX(PL()) > 200) {
                int i = 1;
            } else {
                z = false;
            }
            if (i == 0) {
                s.makeText(PL(), aa.getResources().getString(2131236613), 1).show();
            }
            PL().nDS = this;
            Intent intent = new Intent();
            String str = "key_send_raw_image";
            if (this.dFF.dFC) {
                z = false;
            } else {
                z = true;
            }
            intent.putExtra(str, z);
            intent.putExtra("query_media_type", 1);
            if (this.dFF.dFA && this.dFF.dFB) {
                l.a(PL(), 1, this.dFF.count, this.dFH, intent);
            } else if (this.dFF.dFB) {
                intent.putExtra("show_header_view", false);
                l.a(PL(), 1, this.dFF.count, this.dFH, intent);
            } else if (this.dFF.dFA) {
                l.d(PL(), e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
            } else {
                v.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.dFG.aKK = -2;
                a(this.dFG);
            }
        }

        private static String nu(String str) {
            String str2 = e.cgg + "microMsg." + System.currentTimeMillis() + ".jpg";
            try {
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, 0);
                if (decodeFile == null) {
                    v.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                    return null;
                }
                long Ni = be.Ni();
                v.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[]{Integer.valueOf(n.a(decodeFile, 70, str2)), Long.valueOf(be.Ni() - Ni), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
                return n.a(decodeFile, 70, str2) == 1 ? str2 : str;
            } catch (OutOfMemoryError e) {
                v.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                return null;
            }
        }

        protected final void PE() {
            super.PE();
            if (this.dFI != null) {
                this.dFI.dismiss();
                this.dFI = null;
            }
        }

        public final void a(int i, int i2, Intent intent) {
            if (i2 == 0) {
                this.dFG.aKK = 0;
                a(this.dFG);
                return;
            }
            switch (i) {
                case 1:
                case 3:
                    if (intent == null) {
                        this.dFG.aKK = 0;
                        a(this.dFG);
                        return;
                    }
                    boolean z;
                    final List stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    final boolean z2 = (((!this.dFF.dFD ? 1 : 0) & this.dFF.dFC) == 0 && ((this.dFF.dFC & this.dFF.dFD) & intent.getBooleanExtra("CropImage_Compress_Img", false)) == 0) ? false : true;
                    if (intent.getBooleanExtra("isTakePhoto", false) || intent.getBooleanExtra("isPreviewPhoto", false)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    v.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.dFF.dFC), Boolean.valueOf(this.dFF.dFD), Boolean.valueOf(r5), Boolean.valueOf(z2)});
                    if (z2) {
                        this.dFJ = new OnCancelListener(this) {
                            final /* synthetic */ a dFK;

                            {
                                this.dFK = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.dFK.dFG.aKK = 0;
                                this.dFK.a(this.dFK.dFG);
                            }
                        };
                        MMActivity PL = PL();
                        aa.getResources().getString(2131231164);
                        this.dFI = g.a(PL, aa.getResources().getString(2131236603), true, this.dFJ);
                    }
                    com.tencent.mm.plugin.appbrand.k.a.vA().x(new Runnable(this) {
                        final /* synthetic */ a dFK;

                        public final void run() {
                            final ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
                            for (String str : stringArrayListExtra) {
                                String str2;
                                if (z2) {
                                    str2 = a.nu(str2);
                                }
                                AppBrandLocalMediaObject f = com.tencent.mm.plugin.appbrand.appstorage.c.f(this.dFK.dFF.appId, str2, z | z2);
                                if (f != null) {
                                    arrayList.add(f);
                                } else {
                                    v.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[]{str2});
                                }
                            }
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 dFP;

                                public final void run() {
                                    this.dFP.dFK.dFG.aKK = -1;
                                    this.dFP.dFK.dFG.dFE = arrayList;
                                    this.dFP.dFK.a(this.dFP.dFK.dFG);
                                }
                            });
                        }
                    });
                    return;
                case 2:
                    final String a = l.a(PL().getApplicationContext(), intent, e.cgg);
                    if (be.kS(a)) {
                        v.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
                        this.dFG.aKK = -2;
                        a(this.dFG);
                        return;
                    }
                    v.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[]{a});
                    ad.o(new Runnable(this) {
                        final /* synthetic */ a dFK;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("key_send_raw_image", !this.dFK.dFF.dFC);
                            intent.putExtra("max_select_count", this.dFK.dFF.count);
                            intent.putExtra("query_source_type", this.dFK.dFH);
                            intent.putExtra("isPreviewPhoto", true);
                            intent.putExtra("max_select_count", 1);
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(a);
                            intent.putStringArrayListExtra("preview_image_list", arrayList);
                            intent.putExtra("preview_image", true);
                            intent.addFlags(67108864);
                            a.a(this.dFK, "gallery", ".ui.GalleryEntryUI", intent);
                        }
                    });
                    return;
                default:
                    this.dFG.aKK = -2;
                    a(this.dFG);
                    return;
            }
        }
    }

    JsApiChooseImage() {
    }

    static /* synthetic */ String j(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            v.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put((String) arrayList.get(i));
        }
        return jSONArray.toString();
    }

    static /* synthetic */ JSONArray k(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            v.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put((String) arrayList.get(i));
        }
        return jSONArray;
    }

    public final void a(final f fVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        if (dFx) {
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
        String optString = jSONObject.optString("sizeType");
        v.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[]{optJSONArray, optString, jSONObject.optString("count")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.dFA = true;
            chooseRequest.dFB = true;
        } else {
            chooseRequest.dFA = optJSONArray.toString().contains("camera");
            chooseRequest.dFB = optJSONArray.toString().contains("album");
        }
        if (chooseRequest.dFA) {
            com.tencent.mm.plugin.appbrand.a.a(fVar.dzg, new android.support.v4.app.a.a(this) {
                final /* synthetic */ JsApiChooseImage dFz;

                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 113) {
                        if (iArr[0] == 0) {
                            this.dFz.a(fVar, jSONObject, i);
                        } else {
                            fVar.y(i, this.dFz.c("fail:system permission denied", null));
                        }
                    }
                }
            });
            MMActivity nt2 = d.nt(fVar.dzg);
            if (nt2 == null) {
                fVar.y(i, c("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.i.a.a(nt2, "android.permission.CAMERA", 113, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.mq(fVar.dzg);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        dFx = true;
        if (be.kS(optString)) {
            optString = "compressed";
        }
        chooseRequest.dFC = optString.contains("compressed");
        chooseRequest.dFD = optString.contains("original");
        chooseRequest.count = be.getInt(r5, 9);
        chooseRequest.appId = fVar.dzg;
        com.tencent.mm.plugin.appbrand.ipc.a.a(nt, chooseRequest, new b<ChooseResult>(this) {
            final /* synthetic */ JsApiChooseImage dFz;

            public final /* synthetic */ void c(ProcessResult processResult) {
                ChooseResult chooseResult = (ChooseResult) processResult;
                JsApiChooseImage.dFx = false;
                if (chooseResult != null) {
                    switch (chooseResult.aKK) {
                        case -1:
                            ArrayList arrayList = chooseResult.dFE;
                            if (be.bP(arrayList)) {
                                v.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList(arrayList.size());
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                                if (!(appBrandLocalMediaObject == null || be.kS(appBrandLocalMediaObject.bde))) {
                                    arrayList2.add(appBrandLocalMediaObject.bde);
                                }
                            }
                            v.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", new Object[]{JsApiChooseImage.j(arrayList2)});
                            Map hashMap = new HashMap(1);
                            hashMap.put("tempFilePaths", JsApiChooseImage.k(arrayList2));
                            fVar.y(i, this.dFz.c("ok", hashMap));
                            return;
                        case 0:
                            fVar.y(i, this.dFz.c("cancel", null));
                            return;
                    }
                }
                fVar.y(i, this.dFz.c("fail", null));
            }
        });
    }
}
