package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.asi;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements com.tencent.mm.plugin.exdevice.model.e.b, com.tencent.mm.v.e {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ListView Eq;
    private ProgressDialog dwR;
    private TextView eJM;
    private String fto;
    private com.tencent.mm.plugin.exdevice.model.j.a fub;
    private TextView fyP;
    private TextView fyQ;
    private String fyr;
    private a fzD;
    private View fzE;
    private TextView fzF;
    private ImageView fzG;
    private ScrollView fzH;
    private View fzI;
    private int fzJ;
    private String fzK;
    private String fzL;
    private boolean fzM = false;
    private com.tencent.mm.plugin.exdevice.model.j.a fzN;
    private boolean fzO = false;
    private boolean fzP = false;

    private static final class a extends BaseAdapter {
        private String fAa;
        List<f> fzX = new ArrayList();
        private String fzY;
        private int fzZ;
        private com.tencent.mm.ae.a.a.c fzb;

        private static class a {
            TextView eVA;
            ImageView eZn;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kr(i);
        }

        public a(String str, int i, String str2) {
            this.fzY = str;
            this.fzZ = i;
            this.fAa = str2;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPL = 2131689998;
            this.fzb = aVar.GU();
        }

        public final void akd() {
            for (int i = 0; i < this.fzX.size(); i++) {
                f fVar = (f) this.fzX.get(i);
                fVar.fAj = c(fVar);
            }
        }

        public final boolean b(f fVar) {
            if (sy(fVar.getKey()) < 0) {
                return false;
            }
            fVar.fAj = c(fVar);
            return true;
        }

        public final boolean sw(String str) {
            return sy(str) >= 0;
        }

        public final f sx(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            for (int i = 0; i < this.fzX.size(); i++) {
                f fVar = (f) this.fzX.get(i);
                if (!sz(fVar.ake()) && str.equalsIgnoreCase(fVar.ake())) {
                    return fVar;
                }
            }
            return null;
        }

        public final int getCount() {
            int i = 0;
            for (int i2 = 0; i2 < this.fzX.size(); i2++) {
                if (((f) this.fzX.get(i2)).fAj) {
                    i++;
                }
            }
            return i;
        }

        public final f kr(int i) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.fzX.size(); i3++) {
                if (((f) this.fzX.get(i3)).fAj) {
                    i2++;
                }
                if (i2 == i) {
                    return (f) this.fzX.get(i3);
                }
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            f kr = kr(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), 2130903543, null);
                aVar2.eVA = (TextView) view.findViewById(2131756776);
                aVar2.eZn = (ImageView) view.findViewById(2131756775);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (kr.fAo == null) {
                Assert.assertTrue(false);
            } else {
                String str;
                String str2;
                Object obj;
                CharSequence spannableString;
                if (kr.fAk == b.fAc) {
                    v.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[]{Integer.valueOf(i), kr.fAl.fAe, kr.fAl.aOw, kr.fAo.mCT});
                    str = "";
                    str2 = kr.fAo.bLk;
                    if (str2 != null && str2.length() >= 4) {
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else if (kr.fAl.aOw != null && kr.fAl.aOw.length() >= 4) {
                        str = kr.fAl.aOw;
                        str = str.substring(str.length() - 4, str.length());
                    }
                    obj = kr.fAo.mCT + " " + str;
                    spannableString = new SpannableString(obj);
                    spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(2131689792)), kr.fAo.mCT.length() + 1, obj.length(), 17);
                    aVar.eVA.setText(spannableString);
                } else if (kr.fAk == b.fAb) {
                    str = "";
                    str2 = kr.fAo.bLk;
                    if (str2 != null && str2.length() >= 4) {
                        str = str2.substring(str2.length() - 4, str2.length());
                    } else if (kr.fAo.mfU != null && kr.fAo.mfU.length() >= 4) {
                        str = kr.fAo.mfU;
                        str = str.substring(str.length() - 4, str.length());
                    }
                    obj = kr.fAo.mCT + " " + str;
                    spannableString = new SpannableString(obj);
                    spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(2131689792)), kr.fAo.mCT.length() + 1, obj.length(), 17);
                    aVar.eVA.setText(spannableString);
                } else {
                    Assert.assertTrue(false);
                }
                str = kr.fAo.gnp;
                if (!sz(str)) {
                    n.GL().a(str, aVar.eZn, this.fzb);
                }
            }
            return view;
        }

        private int sy(String str) {
            for (int i = 0; i < this.fzX.size(); i++) {
                if (((f) this.fzX.get(i)).getKey().compareTo(str) == 0) {
                    return i;
                }
            }
            return -1;
        }

        final int bv(String str, String str2) {
            for (int i = 0; i < this.fzX.size(); i++) {
                f fVar = (f) this.fzX.get(i);
                String BY = fVar.BY();
                String deviceId = fVar.getDeviceId();
                if (!sz(BY) && !sz(deviceId) && str.compareTo(fVar.BY()) == 0 && str2.compareTo(fVar.getDeviceId()) == 0) {
                    return i;
                }
            }
            return -1;
        }

        final boolean c(f fVar) {
            if (fVar.fAo == null) {
                return false;
            }
            if (this.fzZ == e.fAh) {
                if (fVar.fAo.mCM == null || fVar.fAo.mCM.compareTo(this.fzY) != 0 || fVar.fAo.mCV == null || fVar.fAo.mCV.compareTo(this.fAa) != 0) {
                    return false;
                }
            } else if (this.fzZ != e.fAg) {
                Assert.assertTrue(false);
                return false;
            } else if (fVar.fAo.bLg == 0) {
                return false;
            }
            return true;
        }

        private static boolean sz(String str) {
            return str == null || str.length() == 0;
        }
    }

    enum b {
        ;

        static {
            fAb = 1;
            fAc = 2;
            fAd = new int[]{fAb, fAc};
        }
    }

    private class c {
        public String aOw;
        public String fAe;
        final /* synthetic */ ExdeviceBindDeviceUI fzQ;

        private c(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
            this.fzQ = exdeviceBindDeviceUI;
        }
    }

    private class d {
        public String ftp;
        public String fyr;
        final /* synthetic */ ExdeviceBindDeviceUI fzQ;

        private d(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
            this.fzQ = exdeviceBindDeviceUI;
        }
    }

    private enum e {
        ;

        static {
            fAf = 1;
            fAg = 2;
            fAh = 3;
            fAi = new int[]{fAf, fAg, fAh};
        }
    }

    private class f {
        public boolean fAj;
        public int fAk;
        public c fAl;
        public d fAm;
        public abt fAn;
        public abu fAo;
        public int fAp;
        public ais fAq;
        public String fAr;
        final /* synthetic */ ExdeviceBindDeviceUI fzQ;
        public String fzr;

        private f(ExdeviceBindDeviceUI exdeviceBindDeviceUI) {
            this.fzQ = exdeviceBindDeviceUI;
            this.fAj = false;
            this.fAk = b.fAb;
        }

        public final String getKey() {
            if (this.fAk == b.fAb) {
                return this.fAm.fyr + this.fAm.ftp;
            }
            return this.fAl.aOw;
        }

        public final String ake() {
            if (this.fAk != b.fAb) {
                return this.fAl.aOw;
            }
            if (this.fAo == null) {
                return null;
            }
            return this.fAo.mfU;
        }

        public final String BY() {
            if (this.fAn != null) {
                return this.fAn.meq;
            }
            if (this.fAk == b.fAb) {
                return this.fAm.fyr;
            }
            return null;
        }

        public final String getDeviceId() {
            if (this.fAn != null) {
                return this.fAn.eez;
            }
            if (this.fAk == b.fAb) {
                return this.fAm.ftp;
            }
            return null;
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, k kVar) {
        f fVar = null;
        if (kVar instanceof p) {
            if (exdeviceBindDeviceUI.dwR != null && exdeviceBindDeviceUI.dwR.isShowing()) {
                exdeviceBindDeviceUI.dwR.dismiss();
            }
            exdeviceBindDeviceUI.fzM = false;
            p pVar = (p) kVar;
            if (!(i == 0 && i2 == 0)) {
                v.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
            wi wiVar = (pVar.cif == null || pVar.cif.czl.czs == null) ? null : (wi) pVar.cif.czl.czs;
            exdeviceBindDeviceUI.fzL = wiVar.myN;
            String str2 = exdeviceBindDeviceUI.fzL;
            if (be.kS(str2)) {
                v.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.ay.c.b(exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
        } else if (kVar instanceof t) {
            arp ajm = ((t) kVar).ajm();
            if (i != 0 || i2 != 0) {
                v.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            } else if (ajm.mgn == null) {
                v.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
            } else {
                fVar = exdeviceBindDeviceUI.fzD.sx(ajm.mgn.mfU);
                if (fVar == null) {
                    v.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                } else if (fVar.fAn != null) {
                    v.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                } else {
                    fVar.fAo = ajm.mgn;
                    fVar.fAn = ajm.mgm;
                    fVar.fzr = ajm.mfZ;
                    fVar.fAq = ajm.mga;
                    exdeviceBindDeviceUI.fzD.b(fVar);
                    exdeviceBindDeviceUI.fzD.notifyDataSetChanged();
                    v.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", new Object[]{ajm.mgm.meq, ajm.mgm.eez, ajm.mgn.mCT, ajm.mgn.mfU, Integer.valueOf(ajm.mgn.bLg)});
                }
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.exdevice.model.v)) {
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.exdevice.model.v vVar = (com.tencent.mm.plugin.exdevice.model.v) kVar;
                asi com_tencent_mm_protocal_c_asi = (vVar.cif == null || vVar.cif.czl.czs == null) ? null : (asi) vVar.cif.czl.czs;
                if (com_tencent_mm_protocal_c_asi.mgm == null) {
                    v.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                    return;
                }
                a aVar = exdeviceBindDeviceUI.fzD;
                String str3 = com_tencent_mm_protocal_c_asi.mgm.meq;
                String str4 = com_tencent_mm_protocal_c_asi.mgm.eez;
                if (!(str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0)) {
                    int bv = aVar.bv(str3, str4);
                    if (bv >= 0) {
                        fVar = (f) aVar.fzX.get(bv);
                    }
                }
                if (fVar == null) {
                    v.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    return;
                } else if (fVar.fAn != null) {
                    v.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    return;
                } else {
                    fVar.fAo = com_tencent_mm_protocal_c_asi.mgn;
                    fVar.fAn = com_tencent_mm_protocal_c_asi.mgm;
                    fVar.fzr = com_tencent_mm_protocal_c_asi.mfZ;
                    fVar.fAq = com_tencent_mm_protocal_c_asi.mga;
                    exdeviceBindDeviceUI.fzD.b(fVar);
                    exdeviceBindDeviceUI.fzD.notifyDataSetChanged();
                    v.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", new Object[]{com_tencent_mm_protocal_c_asi.mgm.meq, com_tencent_mm_protocal_c_asi.mgm.eez, com_tencent_mm_protocal_c_asi.mgn.mCT, Integer.valueOf(com_tencent_mm_protocal_c_asi.mgn.bLg)});
                    return;
                }
            }
            v.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        abu com_tencent_mm_protocal_c_abu = fVar.fAo;
        intent.putExtra("device_mac", com_tencent_mm_protocal_c_abu.mfU);
        intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_abu.mCM);
        intent.putExtra("device_desc", com_tencent_mm_protocal_c_abu.mCU);
        intent.putExtra("device_title", com_tencent_mm_protocal_c_abu.mCT);
        intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_abu.gnp);
        intent.putExtra("device_alias", com_tencent_mm_protocal_c_abu.cHh);
        intent.putExtra("device_jump_url", com_tencent_mm_protocal_c_abu.gkT);
        intent.putExtra("bind_ticket", fVar.fzr);
        intent.putExtra("device_type", fVar.fAn.meq);
        intent.putExtra("device_id", fVar.fAn.eez);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.fAp);
        if (fVar.fAk == b.fAc) {
            intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_abu.bLh);
        } else if (fVar.fAk != b.fAb) {
            Assert.assertTrue(false);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        if (fVar == null) {
            v.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
        } else if (fVar.fAq == null) {
            v.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
        } else {
            ais com_tencent_mm_protocal_c_ais = fVar.fAq;
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(m.a(com_tencent_mm_protocal_c_ais.moM));
            Intent intent = new Intent();
            intent.putExtra("device_id", fVar.fAn.eez);
            intent.putExtra("device_type", fVar.fAn.meq);
            intent.putExtra("Contact_User", m.a(com_tencent_mm_protocal_c_ais.moM));
            intent.putExtra("Contact_Scene", com_tencent_mm_protocal_c_ais.mog);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.fzr);
            if (LX != null) {
                if (!com.tencent.mm.i.a.ei(LX.field_type)) {
                    intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_ais.cHh);
                    intent.putExtra("Contact_Nick", com_tencent_mm_protocal_c_ais.mEj.toString());
                    intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_ais.cHf);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_ais.cHl, com_tencent_mm_protocal_c_ais.cHd, com_tencent_mm_protocal_c_ais.cHe));
                    intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_ais.cHc);
                    intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_ais.mFv);
                    intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_ais.mFu);
                    intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_ais.mFy);
                    intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_ais.mFw);
                    intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_ais.mFx);
                    if (com_tencent_mm_protocal_c_ais.mFB != null) {
                        try {
                            intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_ais.mFB.toByteArray());
                        } catch (Throwable e) {
                            v.a("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.ay.c.b(exdeviceBindDeviceUI.nDR.nEl, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903544;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceUI fzQ;

            {
                this.fzQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fzQ.finish();
                return true;
            }
        });
        Intent intent = getIntent();
        this.fzK = intent.getStringExtra("device_category_id");
        this.fto = intent.getStringExtra("device_brand_name");
        this.fyr = intent.getStringExtra("device_type");
        if (this.fyr == null || this.fyr.length() == 0) {
            this.fyr = this.fto;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (be.kS(stringExtra3)) {
            stringExtra3 = this.nDR.nEl.getString(2131232533);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.fzJ = e.fAg;
            str = this.nDR.nEl.getString(2131232491);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.fzJ = e.fAh;
            str = this.nDR.nEl.getString(2131232489);
        } else {
            Assert.assertTrue(false);
        }
        Fd(str);
        if (this.fzJ == e.fAh) {
            this.fzO = stringExtra.contains("wifi");
            this.fzP = stringExtra.contains("blue");
            v.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[]{Boolean.valueOf(this.fzO), Boolean.valueOf(this.fzP)});
        } else if (this.fzJ == e.fAg) {
            this.fzP = true;
            this.fzO = true;
        }
        this.fub = new com.tencent.mm.plugin.exdevice.model.j.a(this) {
            final /* synthetic */ ExdeviceBindDeviceUI fzQ;

            {
                this.fzQ = r1;
            }

            public final void e(int i, Object... objArr) {
                String string;
                Throwable e;
                if (i == 10 && objArr != null) {
                    String str;
                    String string2;
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            string2 = jSONObject2.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                            string2 = null;
                            v.a("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            v.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            str = null;
                            if (string != null) {
                            }
                        }
                        try {
                            if (!jSONObject.isNull("manufacturerData")) {
                                str = jSONObject.getString("manufacturerData");
                                if (string != null && string2 != null) {
                                    final f fVar = new f();
                                    fVar.fAk = b.fAb;
                                    fVar.fAm = new d();
                                    fVar.fAm.fyr = string;
                                    fVar.fAm.ftp = string2;
                                    if (be.kS(str)) {
                                        fVar.fAr = null;
                                    } else {
                                        fVar.fAr = Base64.encodeToString(str.getBytes(), 2);
                                        v.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[]{fVar.fAr});
                                    }
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass3 fzS;

                                        public final void run() {
                                            this.fzS.fzQ.a(fVar);
                                        }
                                    });
                                    return;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            v.a("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            v.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            str = null;
                            if (string != null) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        string2 = null;
                        string = null;
                        v.a("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        v.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                        str = null;
                        if (string != null) {
                        }
                    }
                    str = null;
                    if (string != null) {
                    }
                }
            }
        };
        this.fzN = new com.tencent.mm.plugin.exdevice.model.j.a(this) {
            final /* synthetic */ ExdeviceBindDeviceUI fzQ;

            {
                this.fzQ = r1;
            }

            public final void e(int i, Object... objArr) {
            }
        };
        NI();
        this.eJM.setText(this.nDR.nEl.getString(2131232580, new Object[]{stringExtra3}));
        ak.vy().a(1264, this);
        ak.vy().a(1706, this);
        ak.vy().a(1270, this);
        ak.vy().a(1719, this);
        if (this.fzP) {
            ac.ajB().a(this);
        }
        if (this.fzO) {
            j.ajh().a(10, this.fub);
            j.ajh().a(11, this.fzN);
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    protected void onResume() {
        super.onResume();
        v.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.fzP) {
            ac.ajB();
            com.tencent.mm.plugin.exdevice.model.e.aiS();
        }
        if (this.fzO) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.fzD.akd();
        this.fzD.notifyDataSetChanged();
    }

    protected final void NI() {
        this.Eq = (ListView) findViewById(2131755705);
        View inflate = View.inflate(this, 2130903546, null);
        this.fzI = View.inflate(this, 2130903576, null);
        this.fzE = this.fzI.findViewById(2131756782);
        this.eJM = (TextView) this.fzI.findViewById(2131756783);
        this.fzF = (TextView) findViewById(2131756781);
        this.fzG = (ImageView) findViewById(2131756777);
        this.fyP = (TextView) findViewById(2131756778);
        this.fyQ = (TextView) findViewById(2131756779);
        this.fzH = (ScrollView) findViewById(2131756793);
        this.Eq.addHeaderView(inflate, null, false);
        this.Eq.addFooterView(this.fzI, null, false);
        this.fzD = new a(this.fto, this.fzJ, this.fzK);
        this.Eq.setAdapter(this.fzD);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceUI fzQ;

            {
                this.fzQ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f kr = this.fzQ.fzD.kr(i - ((ListView) adapterView).getHeaderViewsCount());
                if (kr.fAo.bLg != 0) {
                    ExdeviceBindDeviceUI.a(this.fzQ, kr);
                } else {
                    ExdeviceBindDeviceUI.b(this.fzQ, kr);
                }
            }
        });
        if (this.fzP && !this.fzO) {
            if (!com.tencent.mm.plugin.c.a.e.a.by(this.nDR.nEl)) {
                v.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                kp(4);
                return;
            } else if (!com.tencent.mm.plugin.c.a.e.a.Xw()) {
                v.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                kp(3);
                return;
            }
        }
        if (!this.fzP && this.fzO && !com.tencent.mm.sdk.platformtools.ak.isWifi(this.nDR.nEl)) {
            v.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            kp(5);
        } else if (this.fzJ == e.fAg) {
            kp(0);
        } else if (this.fzJ != e.fAh) {
            int i = e.fAf;
            Assert.assertTrue(false);
        } else if (this.fzP && this.fzO) {
            Assert.assertTrue(false);
            kp(1);
        } else if (this.fzP) {
            kp(2);
        } else if (this.fzO) {
            kp(1);
        }
    }

    protected void onPause() {
        super.onPause();
        v.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.fzO) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.fzP) {
            ac.ajC().Xe();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fzO) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ ExdeviceBindDeviceUI fzQ;

                {
                    this.fzQ = r1;
                }

                public final void run() {
                    Java2CExDevice.stopScanWCLanDevice();
                    Java2CExDevice.releaseWCLanDeviceLib();
                }
            });
            j.ajh().b(10, this.fub);
            j.ajh().b(11, this.fzN);
        }
        if (this.fzP) {
            ac.ajB().b(this);
            ac.ajC().Xe();
        }
        ak.vy().b(1264, this);
        ak.vy().b(1706, this);
        ak.vy().b(1270, this);
        ak.vy().b(1719, this);
    }

    public final void h(String str, String str2, boolean z) {
        v.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (be.kS(str2)) {
            v.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        final f fVar = new f();
        fVar.fAk = b.fAc;
        fVar.fAl = new c();
        fVar.fAl.fAe = str;
        fVar.fAl.aOw = com.tencent.mm.plugin.exdevice.j.b.bs(com.tencent.mm.plugin.exdevice.j.b.sE(str2));
        ad.o(new Runnable(this) {
            final /* synthetic */ ExdeviceBindDeviceUI fzQ;

            public final void run() {
                this.fzQ.a(fVar);
            }
        });
    }

    public final void b(String str, int i, long j) {
    }

    public final void c(String str, byte[] bArr, boolean z) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            v.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
            return;
        }
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final k kVar2 = kVar;
        ad.o(new Runnable(this) {
            final /* synthetic */ ExdeviceBindDeviceUI fzQ;

            public final void run() {
                ExdeviceBindDeviceUI.a(this.fzQ, i3, i4, str2, kVar2);
            }
        });
    }

    final void a(f fVar) {
        if (!this.fzD.sw(fVar.getKey())) {
            v.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.ake());
            a aVar = this.fzD;
            if (!(fVar == null || aVar.sw(fVar.getKey()))) {
                fVar.fAj = aVar.c(fVar);
                aVar.fzX.add(fVar);
            }
            this.fzD.notifyDataSetChanged();
            if (fVar.fAk == b.fAc) {
                v.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[]{fVar.fAl.aOw, this.fto, this.fzK});
                ak.vy().a(new t(fVar.fAl.aOw, this.fto, this.fzK), 0);
            } else if (fVar.fAk == b.fAb) {
                v.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[]{fVar.fAm.fyr, fVar.fAm.ftp});
                ak.vy().a(new com.tencent.mm.plugin.exdevice.model.v(fVar.fAm.fyr, fVar.fAm.ftp, fVar.fAr), 0);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.fzD.akd();
        this.fzD.notifyDataSetChanged();
    }

    private void kp(int i) {
        String string;
        String string2;
        CharSequence spannableString;
        switch (i) {
            case 0:
                string = getString(2131232498);
                CharSequence spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(2131689819), 0, string.length(), 33);
                spannableString2.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI fzQ;

                    {
                        this.fzQ = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.exdevice.model.f.P(this.fzQ.nDR.nEl, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, 0, string.length(), 33);
                this.fzF.setMovementMethod(LinkMovementMethod.getInstance());
                this.fzF.setText(spannableString2);
                break;
            case 1:
                string = getString(2131232501);
                string2 = getString(2131232521);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(2131689819), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI fzQ;

                    {
                        this.fzQ = r1;
                    }

                    public final void onClick(View view) {
                        this.fzQ.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.fzF.setMovementMethod(LinkMovementMethod.getInstance());
                this.fzF.setText(spannableString);
                break;
            case 2:
                string = getString(2131232500);
                string2 = getString(2131232499);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(2131689819), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan(this) {
                    final /* synthetic */ ExdeviceBindDeviceUI fzQ;

                    {
                        this.fzQ = r1;
                    }

                    public final void onClick(View view) {
                        this.fzQ.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.fzF.setMovementMethod(LinkMovementMethod.getInstance());
                this.fzF.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.fzG.setImageResource(2131165309);
                this.fyP.setText(2131232508);
                this.fyQ.setText(2131232496);
                break;
            case 4:
                this.fzG.setImageResource(2131165309);
                this.fyP.setText(2131232506);
                this.fyQ.setText("");
                break;
            case 5:
                this.fzG.setImageResource(2131166033);
                this.fyP.setText(2131232508);
                this.fyQ.setText(2131232503);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.fzE.setVisibility(0);
                this.Eq.setVisibility(0);
                this.fzF.setVisibility(0);
                this.fzG.setVisibility(8);
                this.fyP.setVisibility(8);
                this.fyQ.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
                this.fzH.setVisibility(8);
                this.fzE.setVisibility(8);
                this.Eq.setVisibility(8);
                this.fzF.setVisibility(8);
                this.fzG.setVisibility(0);
                this.fyP.setVisibility(0);
                if (i == 4) {
                    this.fyQ.setVisibility(8);
                    return;
                } else {
                    this.fyQ.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
