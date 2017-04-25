package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.j.b;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends b implements e {
    public static int iQl = 3;
    private float bYf = -1000.0f;
    private float bYg = -1000.0f;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ h iQm;

        {
            this.iQm = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return true;
            }
            this.iQm.bYf = f2;
            this.iQm.bYg = f;
            this.iQm.iBM = (int) d2;
            return false;
        }
    };
    private c cCR;
    private int iBM = -1000;
    private d iQg;
    public Collection<a> iQh = null;
    private int iQi = 10001;
    private int iQj = 10002;
    private int iQk = 10003;

    public static final class a {
        public double cXH = 0.0d;
        public String gjT = null;
        public String iQn = "";
        public double iQo = 0.0d;
        public int iQp = 0;
        public int major = 0;
        public int minor = 0;
    }

    public h(com.tencent.mm.plugin.shake.b.j.a aVar) {
        super(aVar);
    }

    public final void init() {
        ak.vy().a(658, this);
        aNA();
    }

    public final void reset() {
        if (this.iQg != null) {
            ak.vy().c(this.iQg);
        }
    }

    public final void start() {
        v.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.cCR == null) {
            aNA();
        }
        this.cCR.a(this.bYl);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) aa.getContext().getSystemService("location");
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ h iQm;

                    {
                        this.iQm = r1;
                    }

                    public final void run() {
                        this.iQm.iOn.d(null, 8);
                    }
                }, 1000);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ h iQm;

                {
                    this.iQm = r1;
                }

                public final void run() {
                    this.iQm.iOn.d(null, 9);
                }
            }, 1000);
        } else if (defaultAdapter == null) {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ h iQm;

                {
                    this.iQm = r1;
                }

                public final void run() {
                    this.iQm.iOn.d(null, 10);
                }
            }, 1000);
        } else {
            int size;
            String str = "MicroMsg.ShakeIbeaconService";
            String str2 = "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d";
            Object[] objArr = new Object[1];
            if (this.iQh != null) {
                size = this.iQh.size();
            } else {
                size = 0;
            }
            objArr[0] = Integer.valueOf(size);
            v.i(str, str2, objArr);
            this.iQg = new d(this.iQh, this.bYf, this.bYg, this.iBM);
            ak.vy().a(this.iQg, 0);
        }
    }

    public final void pause() {
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
    }

    public final void resume() {
        if (this.cCR != null) {
            this.cCR.a(this.bYl, true);
        }
    }

    private void aNA() {
        this.cCR = c.FY();
        this.cCR.a(this.bYl, true);
    }

    public final void aNB() {
        super.aNB();
        ak.vy().b(658, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            d dVar = (d) kVar;
            if (658 == kVar.getType() && dVar.action == 1) {
                acq com_tencent_mm_protocal_c_acq = (acq) dVar.cQA.czl.czs;
                if (com_tencent_mm_protocal_c_acq.mDL.mmL == 0) {
                    v.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[]{com_tencent_mm_protocal_c_acq.mDL.gkY, com_tencent_mm_protocal_c_acq.mDL.hQO, Integer.valueOf(com_tencent_mm_protocal_c_acq.mDL.mmL)});
                    try {
                        JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_acq.mDL.gkY);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrn, Integer.valueOf(i3));
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nro, Long.valueOf(j));
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrp, Integer.valueOf(i4));
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nry, Integer.valueOf(i5));
                        v.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        com.tencent.mm.plugin.shake.b.e aNO = com.tencent.mm.plugin.shake.b.k.aNO();
                        aNO.aNG();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                d dVar2 = new d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString("url");
                                String string2 = jSONObject3.getString("content");
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i6 = jSONObject3.getInt("guide_state");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i6 == 1) {
                                    dVar2.field_sex = iQl;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes(ProtocolPackage.ServerEncoding);
                                dVar2.field_insertBatch = 2;
                                list.add(dVar2);
                                aNO.a(dVar2, true);
                                if (dVar2.field_sex == iQl && i3 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.iOn.d(list, 1);
                        return;
                    } catch (Exception e) {
                        v.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[]{be.ma(e.getMessage())});
                        this.iOn.d(null, 1);
                        return;
                    }
                } else if (com_tencent_mm_protocal_c_acq.mDL.mmL == this.iQi) {
                    this.iOn.d(null, 6);
                    return;
                } else if (com_tencent_mm_protocal_c_acq.mDL.mmL == this.iQj) {
                    this.iOn.d(null, 7);
                    return;
                } else if (com_tencent_mm_protocal_c_acq.mDL.mmL == this.iQk) {
                    this.iOn.d(null, 8);
                    return;
                } else {
                    this.iOn.d(null, 1);
                    return;
                }
            }
            return;
        }
        this.iOn.d(null, 3);
    }

    public static void a(d dVar) {
        if (dVar != null && dVar.field_sex == iQl) {
            String str;
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrt, Boolean.valueOf(true));
            long Nh = be.Nh();
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nru, Long.valueOf(Nh));
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeIbeaconService", e, "%s", new Object[]{"Unsupported"});
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrm, Long.valueOf(split[0]));
                }
            }
        }
    }

    public static void b(d dVar) {
        if (dVar != null) {
            String str;
            try {
                str = new String(dVar.field_lvbuffer, ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeIbeaconService", e, "%s", new Object[]{"Unsupported"});
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    a aVar = new a();
                    aVar.gjT = str2;
                    aVar.major = be.getInt(str3, 0);
                    aVar.minor = be.getInt(str, 0);
                }
            }
        }
    }
}
