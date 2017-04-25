package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class MultiStageCitySelectUI extends MMPreference implements e {
    private static String cQn = null;
    private static String oTT = null;
    private static String oTU = null;
    private a bYl = new a(this) {
        final /* synthetic */ MultiStageCitySelectUI oTZ;

        {
            this.oTZ = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (this.oTZ.cCR != null) {
                if (z) {
                    v.d("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
                    ak.vy().a(new n((double) f2, (double) f), 0);
                } else {
                    this.oTZ.bJq();
                }
                if (this.oTZ.cCR != null) {
                    this.oTZ.cCR.c(this.oTZ.bYl);
                    this.oTZ.cCR = null;
                }
            }
            return false;
        }
    };
    private String bfd = null;
    private c cCR;
    private String cve = null;
    private String cvf = null;
    private f dxf;
    private int dyp = 0;
    private Region[] oTV;
    private boolean oTW = false;
    private boolean oTX = true;
    private ZoneRecommandPreference oTY;

    private void bJo() {
        Region[] bxe = t.kS(this.bfd) ? RegionCodeDecoder.bxc().bxe() : t.kS(this.cvf) ? RegionCodeDecoder.bxc().Np(this.bfd) : RegionCodeDecoder.bxc().dQ(this.bfd, this.cvf);
        this.oTV = bxe;
        if (this.oTV == null || this.oTV.length <= 0) {
            v.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            return;
        }
        this.dxf.removeAll();
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(12324, null);
        ak.yW();
        String str2 = (String) com.tencent.mm.model.c.vf().get(12325, null);
        ak.yW();
        String str3 = (String) com.tencent.mm.model.c.vf().get(12326, null);
        int i = 0;
        while (i < this.oTV.length) {
            if (!(this.oTV[i] == null || t.kS(this.oTV[i].getCode()) || t.kS(this.oTV[i].getName()))) {
                Preference zonePreference = new ZonePreference(this);
                Region region = this.oTV[i];
                if (region == null || t.kS(region.getName()) || t.kS(region.getCode())) {
                    v.e("MicroMsg.ZonePreference", "setZoneItem item = null");
                } else {
                    zonePreference.setKey(region.getCode());
                    zonePreference.oVv = region;
                }
                if (this.dyp == 0 && this.oTV[i].getCode().equalsIgnoreCase(str)) {
                    this.dxf.a(zonePreference, 0);
                    zonePreference.setSummary(2131234960);
                } else if (this.dyp == 1 && this.oTV[i].getCode().equalsIgnoreCase(str2)) {
                    this.dxf.a(zonePreference, 0);
                    zonePreference.setSummary(2131234960);
                } else if (this.dyp == 2 && this.oTV[i].getCode().equalsIgnoreCase(str3)) {
                    this.dxf.a(zonePreference, 0);
                    zonePreference.setSummary(2131234960);
                } else {
                    this.dxf.a(zonePreference);
                }
            }
            i++;
        }
        this.dxf.a(new PreferenceCategory(this.nDR.nEl));
        if (this.dyp == 0) {
            Preference preferenceTitleCategory;
            if (this.oTX) {
                preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(2131234958);
                this.dxf.a(preferenceTitleCategory, 0);
                this.oTY = new ZoneRecommandPreference(this);
                this.oTY.setKey("current_location");
                this.dxf.a(this.oTY, 1);
            }
            preferenceTitleCategory = new PreferenceTitleCategory(this);
            preferenceTitleCategory.setTitle(2131234957);
            if (this.oTX) {
                this.dxf.a(preferenceTitleCategory, 2);
                if (this.cCR == null) {
                    this.cCR = c.FY();
                }
                this.cCR.a(this.bYl, true);
                return;
            }
            this.dxf.a(preferenceTitleCategory, 0);
        }
    }

    private void bJp() {
        switch (this.dyp) {
            case 0:
                this.bfd = null;
                return;
            case 1:
                this.cvf = null;
                return;
            case 2:
                this.cve = null;
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(665, (e) this);
        this.dxf = this.ocZ;
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ak.vy().b(665, (e) this);
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
        super.onDestroy();
    }

    public final int Oo() {
        return 2130904719;
    }

    protected final void NI() {
        vD(2131233981);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MultiStageCitySelectUI oTZ;

            {
                this.oTZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oTZ.bJp();
                this.oTZ.finish();
                return true;
            }
        });
        this.oTW = getIntent().getBooleanExtra("GetAddress", false);
        this.bfd = getIntent().getStringExtra("Country");
        this.cvf = getIntent().getStringExtra("Provice");
        this.oTX = getIntent().getBooleanExtra("IsAutoPosition", true);
        v.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.bfd + " province =" + this.cvf + " city = " + this.cve);
        if (this.bfd == null) {
            this.dyp = 0;
            this.cvf = null;
            this.cve = null;
        } else if (this.cvf == null) {
            this.dyp = 1;
            this.cve = null;
        } else {
            this.dyp = 2;
        }
        bJo();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = null;
        String str2;
        if (preference instanceof ZonePreference) {
            Region region = ((ZonePreference) preference).oVv;
            if (region == null || t.kS(region.getCode())) {
                Object valueOf;
                String str3 = "MicroMsg.MultiStageCitySelectUI";
                StringBuilder stringBuilder = new StringBuilder("onPreferenceTreeClick error item, code:");
                if (region == null) {
                    valueOf = Integer.valueOf(-1);
                } else {
                    valueOf = region.getCode();
                }
                stringBuilder = stringBuilder.append(valueOf).append(" ,name:");
                if (region == null) {
                    str2 = "null";
                } else {
                    str2 = region.getName();
                }
                v.e(str3, stringBuilder.append(str2).toString());
                return false;
            }
            if (this.dyp == 0) {
                this.bfd = region.getCode();
                cQn = region.getName();
            } else if (this.dyp == 1) {
                this.cvf = region.getCode();
                oTT = region.getName();
            } else if (this.dyp == 2) {
                this.cve = region.getCode();
                oTU = region.getName();
            }
            Intent intent;
            if (region.hasChildren()) {
                intent = new Intent(this, MultiStageCitySelectUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("Country", this.bfd);
                bundle.putString("Provice", this.cvf);
                bundle.putBoolean("GetAddress", this.oTW);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            } else {
                if (!this.oTW) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(12324, this.bfd);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(12325, this.cvf);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(12326, this.cve);
                }
                intent = new Intent();
                intent.putExtra("CountryName", cQn);
                intent.putExtra("ProviceName", oTT);
                intent.putExtra("CityName", oTU);
                intent.putExtra("Country", this.bfd);
                intent.putExtra("Contact_Province", this.cvf);
                intent.putExtra("Contact_City", this.cve);
                setResult(-1, intent);
                finish();
            }
            return true;
        }
        if (preference.dnU.equals("current_location")) {
            if ((this.oTY.status == 1 ? 1 : 0) != 0) {
                ZoneRecommandPreference zoneRecommandPreference = this.oTY;
                Region[] regionArr = new Region[]{zoneRecommandPreference.oVy, zoneRecommandPreference.oVz, zoneRecommandPreference.oVA};
                ak.yW();
                com.tencent.mm.model.c.vf().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                ak.yW();
                com.tencent.mm.model.c.vf().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                ak.yW();
                com.tencent.mm.model.c.vf().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
                Intent intent2 = new Intent();
                intent2.putExtra("CountryName", regionArr[0] == null ? null : regionArr[0].getName());
                intent2.putExtra("ProviceName", regionArr[1] == null ? null : regionArr[1].getName());
                intent2.putExtra("CityName", regionArr[2] == null ? null : regionArr[2].getName());
                intent2.putExtra("Country", regionArr[0] == null ? null : regionArr[0].getCode());
                intent2.putExtra("Contact_Province", regionArr[1] == null ? null : regionArr[1].getCode());
                str2 = "Contact_City";
                if (regionArr[2] != null) {
                    str = regionArr[2].getCode();
                }
                intent2.putExtra(str2, str);
                setResult(-1, intent2);
                finish();
            }
        }
        return false;
    }

    public void onBackPressed() {
        bJp();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Region region = null;
        int i3 = 0;
        if (i != 0 || i2 != 0) {
            bJq();
        } else if (kVar.getType() == 665) {
            Region region2;
            Region region3;
            ZoneRecommandPreference zoneRecommandPreference;
            n nVar = (n) kVar;
            v.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", nVar.cJg, nVar.bCk, nVar.bCl);
            for (Region region4 : RegionCodeDecoder.bxc().bxe()) {
                if (region4.getCode().equalsIgnoreCase(r2)) {
                    for (Region region22 : RegionCodeDecoder.bxc().Np(region4.getCode())) {
                        if (region22.getCode().equalsIgnoreCase(r5)) {
                            Region[] dQ = RegionCodeDecoder.bxc().dQ(region4.getCode(), region22.getCode());
                            int length = dQ.length;
                            while (i3 < length) {
                                region3 = dQ[i3];
                                if (region3.getCode().equalsIgnoreCase(r6)) {
                                    region = region22;
                                    region22 = region4;
                                    break;
                                }
                                i3++;
                            }
                            region3 = null;
                            region = region22;
                            region22 = region4;
                            if (region22 != null && region == null && region3 == null) {
                                if (this.oTY != null) {
                                    this.oTY.bJz();
                                    return;
                                }
                                return;
                            } else if (this.oTY == null) {
                                zoneRecommandPreference = this.oTY;
                                zoneRecommandPreference.status = 1;
                                zoneRecommandPreference.oVy = region22;
                                zoneRecommandPreference.oVz = region;
                                zoneRecommandPreference.oVA = region3;
                                zoneRecommandPreference.bJy();
                            }
                        }
                    }
                    region3 = null;
                    region22 = region4;
                    if (region22 != null) {
                    }
                    if (this.oTY == null) {
                        zoneRecommandPreference = this.oTY;
                        zoneRecommandPreference.status = 1;
                        zoneRecommandPreference.oVy = region22;
                        zoneRecommandPreference.oVz = region;
                        zoneRecommandPreference.oVA = region3;
                        zoneRecommandPreference.bJy();
                    }
                }
            }
            region3 = null;
            region22 = null;
            if (region22 != null) {
            }
            if (this.oTY == null) {
                zoneRecommandPreference = this.oTY;
                zoneRecommandPreference.status = 1;
                zoneRecommandPreference.oVy = region22;
                zoneRecommandPreference.oVz = region;
                zoneRecommandPreference.oVA = region3;
                zoneRecommandPreference.bJy();
            }
        }
    }

    private void bJq() {
        if (this.oTY != null) {
            this.oTY.bJz();
        }
    }
}
