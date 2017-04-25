package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.page.h.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

final class JsApiGetLocation extends a {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";
    private static final HashSet<String> dGF;

    private static final class LocationTask extends MainProcessTask implements a {
        public static final Creator<LocationTask> CREATOR = new Creator<LocationTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LocationTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LocationTask[i];
            }
        };
        private double aIp;
        private double aIr;
        private int dFQ;
        private f dGG;
        private WeakReference<h> dGH;
        private JsApiGetLocation dGI;
        private String dGJ;
        private boolean dGK;
        private float dGL;
        private float dGM;
        private com.tencent.mm.modelgeo.a dGN = null;
        private com.tencent.mm.modelgeo.a.a dGO = null;
        private ac dGP;
        private int dGQ = 0;
        private long dGR = 0;

        static /* synthetic */ void a(LocationTask locationTask) {
            com.tencent.mm.plugin.appbrand.k.a.aC(locationTask);
            if (!(locationTask.dGH == null || locationTask.dGH.get() == null)) {
                ((h) locationTask.dGH.get()).a((a) locationTask);
                if (!(locationTask.dGH == null || locationTask.dGH.get() == null)) {
                    ((h) locationTask.dGH.get()).og(aa.getContext().getString(2131230946));
                    ((h) locationTask.dGH.get()).Rr();
                    locationTask.dGR = System.currentTimeMillis();
                }
            }
            locationTask.dGQ = 1;
            AppBrandMainProcessService.a((MainProcessTask) locationTask);
        }

        public final void OM() {
            super.OM();
            Qh();
            com.tencent.mm.plugin.appbrand.k.a.aD(this);
            if (this.dGG == null) {
                return;
            }
            if (this.dGK) {
                Map hashMap = new HashMap(4);
                hashMap.put("latitude", Float.valueOf(this.dGL));
                hashMap.put("longitude", Float.valueOf(this.dGM));
                hashMap.put("speed", Double.valueOf(this.aIr));
                hashMap.put("accuracy", Double.valueOf(this.aIp));
                this.dGG.y(this.dFQ, this.dGI.c("ok", hashMap));
                return;
            }
            this.dGG.y(this.dFQ, this.dGI.c("fail", null));
        }

        public final void OL() {
            com.tencent.mm.plugin.appbrand.k.a.aC(this);
            switch (this.dGQ) {
                case 1:
                    if (this.dGN == null) {
                        this.dGN = c.FY();
                    }
                    if (this.dGN == null) {
                        v.e("MicroMsg.JsApiGetLocation", "getLocationInMMProcess, iGetLocation == null");
                        this.dGK = false;
                        PP();
                        return;
                    }
                    if (this.dGO == null) {
                        this.dGO = new com.tencent.mm.modelgeo.a.a(this) {
                            final /* synthetic */ LocationTask dGS;

                            {
                                this.dGS = r1;
                            }

                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
                                if (!z) {
                                    return true;
                                }
                                v.v("MicroMsg.JsApiGetLocation", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
                                if (this.dGS.dGN != null) {
                                    this.dGS.dGN.c(this.dGS.dGO);
                                }
                                if (this.dGS.dGO == null) {
                                    v.w("MicroMsg.JsApiGetLocation", "already callback");
                                    return false;
                                }
                                this.dGS.dGO = null;
                                this.dGS.dGK = true;
                                this.dGS.dGL = f2;
                                this.dGS.dGM = f;
                                this.dGS.aIr = d;
                                this.dGS.aIp = d2;
                                this.dGS.PP();
                                return false;
                            }
                        };
                    }
                    if (this.dGP == null) {
                        this.dGP = new ac(Looper.getMainLooper());
                    }
                    this.dGP.postDelayed(new Runnable(this) {
                        final /* synthetic */ LocationTask dGS;

                        {
                            this.dGS = r1;
                        }

                        public final void run() {
                            if (this.dGS.Qg()) {
                                this.dGS.dGK = false;
                                this.dGS.PP();
                            }
                        }
                    }, 20000);
                    if (this.dGJ.equalsIgnoreCase("gcj02")) {
                        this.dGN.a(this.dGO);
                        return;
                    } else if (this.dGJ.equalsIgnoreCase("wgs84")) {
                        this.dGN.b(this.dGO);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    Qg();
                    return;
                default:
                    this.dGK = false;
                    PP();
                    return;
            }
        }

        private boolean Qg() {
            if (this.dGN != null) {
                this.dGN.c(this.dGO);
            }
            if (this.dGO == null) {
                v.w("MicroMsg.JsApiGetLocation", "already callback");
                return false;
            }
            this.dGO = null;
            return true;
        }

        private void Qh() {
            if (this.dGH != null && this.dGH.get() != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.dGR;
                if (currentTimeMillis < 3000) {
                    ((h) this.dGH.get()).postDelayed(new Runnable(this) {
                        final /* synthetic */ LocationTask dGS;

                        {
                            this.dGS = r1;
                        }

                        public final void run() {
                            ((h) this.dGS.dGH.get()).og(null);
                        }
                    }, 3000 - currentTimeMillis);
                } else {
                    ((h) this.dGH.get()).og(null);
                }
            }
        }

        public final void Qi() {
            if (!(this.dGH == null || this.dGH.get() == null)) {
                ((h) this.dGH.get()).b((a) this);
            }
            Qh();
            this.dGQ = 2;
            AppBrandMainProcessService.a((MainProcessTask) this);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.dGJ);
            parcel.writeByte(this.dGK ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.dGL);
            parcel.writeFloat(this.dGM);
            parcel.writeDouble(this.aIr);
            parcel.writeDouble(this.aIp);
            parcel.writeInt(this.dGQ);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.dGJ = parcel.readString();
            this.dGK = parcel.readByte() != (byte) 0;
            this.dGL = parcel.readFloat();
            this.dGM = parcel.readFloat();
            this.aIr = parcel.readDouble();
            this.aIp = parcel.readDouble();
            this.dGQ = parcel.readInt();
        }

        LocationTask() {
        }

        LocationTask(Parcel parcel) {
            f(parcel);
        }
    }

    JsApiGetLocation() {
    }

    static {
        HashSet hashSet = new HashSet();
        dGF = hashSet;
        hashSet.add("gcj02");
        dGF.add("wgs84");
    }

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(Columns.TYPE, "wgs84");
        v.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s", new Object[]{optString});
        if (be.kS(optString)) {
            optString = "wgs84";
        }
        if (be.kS(optString) || dGF.contains(optString)) {
            h a = d.a(fVar);
            if (a == null) {
                fVar.y(i, c("fail", null));
                return;
            }
            LocationTask locationTask = new LocationTask();
            locationTask.dGG = fVar;
            locationTask.dFQ = i;
            locationTask.dGI = this;
            locationTask.dGJ = optString;
            locationTask.dGH = new WeakReference(a);
            LocationTask.a(locationTask);
            return;
        }
        v.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[]{optString});
        fVar.y(i, c("geo_location:fail_unsupported_type", null));
    }
}
