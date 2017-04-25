package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.e.a.cc;
import com.tencent.mm.e.b.bk;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class ExdeviceDeviceProfileUI extends MMPreference implements e {
    private String aOw;
    private p dFI;
    private int fAp;
    private p fAx = null;
    private b fBA;
    private String fBu;
    private String fBv;
    private boolean fBw;
    private String fBx;
    private boolean fBy;
    private String fBz;
    private String fto;
    private String ftp;
    private long fuy;
    private String fyJ;
    private String fyr;
    private String fzq;
    private String fzr;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        r10 = this;
        r6 = 2;
        r3 = 1;
        r2 = 0;
        super.onCreate(r11);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$1;
        r0.<init>(r10);
        r10.b(r0);
        r0 = 2131232502; // 0x7f0806f6 float:1.8081115E38 double:1.0529687625E-314;
        r10.vD(r0);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$7;
        r0.<init>(r10);
        r10.fBA = r0;
        r0 = r10.getIntent();
        r1 = "device_mac";
        r1 = r0.getStringExtra(r1);
        r10.aOw = r1;
        r1 = "device_ble_simple_proto";
        r4 = 0;
        r4 = r0.getLongExtra(r1, r4);
        r10.fuy = r4;
        r1 = "device_jump_url";
        r1 = r0.getStringExtra(r1);
        r10.fBu = r1;
        r1 = "device_brand_name";
        r1 = r0.getStringExtra(r1);
        r10.fto = r1;
        r1 = "device_id";
        r1 = r0.getStringExtra(r1);
        r10.ftp = r1;
        r1 = "device_type";
        r1 = r0.getStringExtra(r1);
        r10.fyr = r1;
        r1 = "bind_ticket";
        r1 = r0.getStringExtra(r1);
        r10.fzr = r1;
        r1 = "subscribe_flag";
        r1 = r0.getIntExtra(r1, r2);
        r10.fAp = r1;
        r1 = "device_has_bound";
        r1 = r0.getBooleanExtra(r1, r2);
        r10.fBw = r1;
        r1 = "device_title";
        r1 = r0.getStringExtra(r1);
        r10.fzq = r1;
        r1 = "device_alias";
        r1 = r0.getStringExtra(r1);
        r10.fBv = r1;
        r1 = "device_desc";
        r1 = r0.getStringExtra(r1);
        r10.fyJ = r1;
        r1 = "device_icon_url";
        r0 = r0.getStringExtra(r1);
        r10.fBx = r0;
        r0 = r10.ftp;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x00a6;
    L_0x009e:
        r0 = r10.fyr;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x00cd;
    L_0x00a6:
        r0 = "MicroMsg.ExdeviceDeviceProfileUI";
        r1 = "deviceId or deviceType is null.";
        r4 = new java.lang.Object[r6];
        r5 = r10.ftp;
        r4[r2] = r5;
        r5 = r10.fyr;
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r4);
    L_0x00b9:
        if (r2 != 0) goto L_0x01b6;
    L_0x00bb:
        r0 = r10.nDR;
        r0 = r0.nEl;
        r1 = 2131232546; // 0x7f080722 float:1.8081204E38 double:1.0529687843E-314;
        r0 = android.widget.Toast.makeText(r0, r1, r3);
        r0.show();
        r10.finish();
    L_0x00cc:
        return;
    L_0x00cd:
        r0 = com.tencent.mm.plugin.exdevice.model.ac.ajq();
        r1 = r10.ftp;
        r4 = r10.fyr;
        r0 = r0.bs(r1, r4);
        if (r0 == 0) goto L_0x01ab;
    L_0x00db:
        r10.fBw = r3;
        r1 = r10.fBv;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x00ed;
    L_0x00e5:
        r1 = r0.bLc;
        r1 = com.tencent.mm.sdk.platformtools.be.ma(r1);
        r10.fBv = r1;
    L_0x00ed:
        r1 = r10.fzq;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00f5:
        r1 = r0.bLd;
        r1 = com.tencent.mm.sdk.platformtools.be.ma(r1);
        r10.fzq = r1;
    L_0x00fd:
        r1 = r10.fto;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x010d;
    L_0x0105:
        r1 = r0.field_brandName;
        r1 = com.tencent.mm.sdk.platformtools.be.ma(r1);
        r10.fto = r1;
    L_0x010d:
        r1 = r10.fyJ;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x011d;
    L_0x0115:
        r1 = r0.bLe;
        r1 = com.tencent.mm.sdk.platformtools.be.ma(r1);
        r10.fyJ = r1;
    L_0x011d:
        r1 = r10.fBx;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x012d;
    L_0x0125:
        r1 = r0.iconUrl;
        r1 = com.tencent.mm.sdk.platformtools.be.ma(r1);
        r10.fBx = r1;
    L_0x012d:
        r1 = r10.fBu;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x013d;
    L_0x0135:
        r1 = r0.jumpUrl;
        r1 = com.tencent.mm.sdk.platformtools.be.ma(r1);
        r10.fBu = r1;
    L_0x013d:
        r0 = r0.bLg;
        if (r0 != r6) goto L_0x01b3;
    L_0x0141:
        r10.fBy = r3;
        r0 = r10.fzq;
        r10.fBz = r0;
        r0 = com.tencent.mm.plugin.exdevice.model.ac.ajq();
        r0 = r0.ajZ();
        r4 = r0.iterator();
    L_0x0153:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x01b3;
    L_0x0159:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.exdevice.h.b) r0;
        r1 = r0.field_deviceType;
        r5 = r10.fyr;
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0153;
    L_0x0169:
        r1 = r0.bLl;
        if (r1 == 0) goto L_0x0153;
    L_0x016d:
        r5 = r1.length();
        if (r5 <= 0) goto L_0x0153;
    L_0x0173:
        r5 = ",";
        r5 = r1.split(r5);
        r1 = r2;
    L_0x017b:
        r6 = r5.length;
        if (r1 >= r6) goto L_0x0153;
    L_0x017e:
        r6 = r5[r1];
        r7 = r10.ftp;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x01a3;
    L_0x0188:
        r6 = r0.bLc;
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r6 == 0) goto L_0x01a6;
    L_0x0190:
        r6 = r0.bLd;
        r10.fBz = r6;
    L_0x0194:
        r6 = "MicroMsg.ExdeviceDeviceProfileUI";
        r7 = "mGateWayTitle %s";
        r8 = new java.lang.Object[r3];
        r9 = r10.fBz;
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);
    L_0x01a3:
        r1 = r1 + 1;
        goto L_0x017b;
    L_0x01a6:
        r6 = r0.bLc;
        r10.fBz = r6;
        goto L_0x0194;
    L_0x01ab:
        r0 = r10.fzr;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x00b9;
    L_0x01b3:
        r2 = r3;
        goto L_0x00b9;
    L_0x01b6:
        r10.aki();
        goto L_0x00cc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.onCreate(android.os.Bundle):void");
    }

    private void aki() {
        String str;
        f fVar;
        boolean z;
        h hVar = this.ocZ;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) hVar.Ow("device_profile_header");
        deviceProfileHeaderPreference.a(1, new OnClickListener(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI fBB;

            {
                this.fBB = r1;
            }

            public final void onClick(View view) {
                g.a(this.fBB, this.fBB.getString(2131232541), "", "", 50, this.fBB.fBA);
            }
        });
        deviceProfileHeaderPreference.a(4, new OnClickListener(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI fBB;

            {
                this.fBB = r1;
            }

            public final void onClick(View view) {
                g.a(this.fBB, this.fBB.getString(2131232541), this.fBB.fBv, "", 50, this.fBB.fBA);
            }
        });
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.cy(this.fBx);
        KeyValuePreference keyValuePreference = (KeyValuePreference) hVar.Ow("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) hVar.Ow("user_list");
        ((KeyValuePreference) hVar.Ow("message_manage")).jz(true);
        keyValuePreference.jz(true);
        keyValuePreference2.jz(true);
        hVar.aO("message_manage", true);
        hVar.aO("connect_setting", true);
        hVar.aO("user_list", true);
        if (this.fBy) {
            hVar.aO("sub_device_desc", false);
            hVar.Ow("sub_device_desc").setTitle(getResources().getString(2131232589, new Object[]{this.fBz}));
            hVar.aO("bind_device", true);
            str = "unbind_device";
            fVar = hVar;
            z = true;
        } else {
            hVar.aO("sub_device_desc", true);
            hVar.aO("bind_device", this.fBw);
            String str2 = "unbind_device";
            if (this.fBw) {
                str = str2;
                fVar = hVar;
                z = false;
            } else {
                str = str2;
                fVar = hVar;
                z = true;
            }
        }
        fVar.aO(str, z);
        if (be.kS(this.fBu)) {
            hVar.aO("open_device_panel", true);
        }
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        CharSequence charSequence = be.kS(this.fzq) ? this.fto : this.fzq;
        if (be.kS(this.fBv)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.st("");
            deviceProfileHeaderPreference.z(3, false);
            deviceProfileHeaderPreference.z(4, false);
            deviceProfileHeaderPreference.z(1, this.fBw);
        } else {
            deviceProfileHeaderPreference.setName(this.fBv);
            deviceProfileHeaderPreference.st(getString(2131232534, new Object[]{charSequence}));
            deviceProfileHeaderPreference.z(3, true);
            deviceProfileHeaderPreference.z(4, true);
            deviceProfileHeaderPreference.z(1, false);
        }
        charSequence = this.fyJ;
        deviceProfileHeaderPreference.fyJ = charSequence;
        if (deviceProfileHeaderPreference.fyG != null) {
            deviceProfileHeaderPreference.fyG.setText(charSequence);
        }
    }

    public final int Oo() {
        return 2131099691;
    }

    public final boolean a(f fVar, Preference preference) {
        v.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[]{preference.dnU});
        String str;
        final k kVar;
        if ("bind_device".equals(preference.dnU)) {
            if (be.kS(this.fzr)) {
                v.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                k mVar = new m(com.tencent.mm.plugin.exdevice.j.b.sE(this.aOw), this.fto, "3", this.fuy);
                h(mVar);
                ak.vy().a(1262, this);
                ak.vy().a(mVar, 0);
            } else {
                v.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.fzr;
                int i = this.fAp;
                ak.vy().a(536, this);
                cc ccVar = new cc();
                ccVar.aZF.aZH = str;
                ccVar.aZF.opType = 1;
                ccVar.aZF.aZI = i;
                a.nhr.z(ccVar);
                kVar = ccVar.aZG.aZJ;
                getString(2131231164);
                this.fAx = g.a(this, getString(2131232504), true, new OnCancelListener(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI fBB;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().b(536, this.fBB);
                        cc ccVar = new cc();
                        ccVar.aZF.opType = 2;
                        ccVar.aZF.aZJ = kVar;
                        a.nhr.z(ccVar);
                    }
                });
            }
        } else if ("unbind_device".equals(preference.dnU)) {
            abt com_tencent_mm_protocal_c_abt = new abt();
            com_tencent_mm_protocal_c_abt.eez = this.ftp;
            com_tencent_mm_protocal_c_abt.meq = this.fyr;
            bk bs = ac.ajq().bs(this.ftp, this.fyr);
            if (bs != null) {
                str = bs.bLl;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String bu : split) {
                        ac.ajq().bu(bu, this.fyr);
                    }
                }
            }
            kVar = new x(com_tencent_mm_protocal_c_abt, 2);
            h(kVar);
            ak.vy().a(537, this);
            ak.vy().a(kVar, 0);
        } else if ("open_device_panel".equals(preference.dnU)) {
            com.tencent.mm.plugin.exdevice.model.f.P(this.nDR.nEl, this.fBu);
        } else if ("contact_info_biz_go_chatting".equals(preference.dnU)) {
            ak.yW();
            u LX = c.wH().LX(this.fto);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.ftp);
            intent.putExtra("device_type", this.fyr);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.fzr);
            if (LX != null) {
                if (com.tencent.mm.i.a.ei(LX.field_type) && LX.bvm()) {
                    com.tencent.mm.modelbiz.u.Dy().ho(LX.field_username);
                    intent.putExtra("Chat_User", this.fto);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.b.fqV.e(intent, this.nDR.nEl);
                } else {
                    intent.putExtra("Contact_User", this.fto);
                    intent.putExtra("force_get_contact", true);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.dnU) || "connect_setting".equals(preference.dnU) || "user_list".equals(preference.dnU))) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            v.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            return;
        }
        v.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[]{Integer.valueOf(kVar.getType())});
        if (kVar instanceof l) {
            akc();
            ak.vy().b(kVar.getType(), this);
            if (i == 0 && i2 == 0) {
                akk();
                i(ac.ajq().bs(this.ftp, this.fyr));
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI fBB;

                    {
                        this.fBB = r1;
                    }

                    public final void run() {
                        this.fBB.fBw = true;
                        this.fBB.aki();
                        this.fBB.ocZ.notifyDataSetChanged();
                    }
                });
                return;
            }
            v.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            akj();
        } else if (kVar instanceof m) {
            akc();
            ak.vy().b(kVar.getType(), this);
            r0 = ac.ajq().bq(com.tencent.mm.plugin.exdevice.j.b.sE(this.aOw));
            if (i == 0 && i2 == 0 && r0 != null) {
                i(r0);
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI fBB;

                    {
                        this.fBB = r1;
                    }

                    public final void run() {
                        this.fBB.fBw = true;
                        this.fBB.aki();
                        this.fBB.ocZ.notifyDataSetChanged();
                    }
                });
                akk();
                return;
            }
            v.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            akj();
        } else if (kVar instanceof y) {
            akc();
            ak.vy().b(1263, this);
            if (i == 0 && i2 == 0) {
                this.fBv = ((y) kVar).bLc;
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI fBB;

                    {
                        this.fBB = r1;
                    }

                    public final void run() {
                        this.fBB.a((DeviceProfileHeaderPreference) this.fBB.ocZ.Ow("device_profile_header"));
                    }
                });
                r0 = ac.ajq().bs(this.ftp, this.fyr);
                if (r0 == null) {
                    v.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[]{this.ftp, this.fyr});
                    return;
                }
                r0.bP(this.fBv);
                ac.ajq().a(r0, new String[0]);
                return;
            }
            v.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            Toast.makeText(this.nDR.nEl, getString(2131232539), 1).show();
        } else if (kVar instanceof x) {
            akc();
            if (i == 0 && i2 == 0) {
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI fBB;

                    {
                        this.fBB = r1;
                    }

                    public final void run() {
                        this.fBB.fBv = null;
                        this.fBB.fBw = false;
                        this.fBB.aki();
                        this.fBB.ocZ.notifyDataSetChanged();
                    }
                });
                finish();
                return;
            }
            v.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceDeviceProfileUI fBB;

                {
                    this.fBB = r1;
                }

                public final void run() {
                    Toast.makeText(this.fBB.nDR.nEl, 2131232591, 1).show();
                }
            });
        }
    }

    private void i(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bVar != null) {
            this.ftp = bVar.field_deviceID;
            this.fyr = bVar.field_deviceType;
            this.fBv = be.ma(bVar.bLc);
            this.fzq = be.ma(bVar.bLd);
            this.fto = be.ma(bVar.field_brandName);
            this.fyJ = be.ma(bVar.bLe);
            this.fBx = be.ma(bVar.iconUrl);
            this.fBu = be.ma(bVar.jumpUrl);
        }
    }

    private void akc() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI fBB;

            {
                this.fBB = r1;
            }

            public final void run() {
                if (this.fBB.dFI != null && this.fBB.dFI.isShowing()) {
                    this.fBB.dFI.dismiss();
                }
                if (this.fBB.fAx != null && this.fBB.fAx.isShowing()) {
                    this.fBB.fAx.dismiss();
                }
            }
        });
    }

    private void akj() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI fBB;

            {
                this.fBB = r1;
            }

            public final void run() {
                g.A(this.fBB, this.fBB.getString(2131232497), this.fBB.getString(2131231164));
            }
        });
    }

    private void akk() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI fBB;

            {
                this.fBB = r1;
            }

            public final void run() {
                ExdeviceDeviceProfileUI exdeviceDeviceProfileUI = this.fBB;
                this.fBB.getString(2131231164);
                final p a = g.a(exdeviceDeviceProfileUI, this.fBB.getString(2131232507), false, null);
                new ah(new ah.a(this) {
                    final /* synthetic */ AnonymousClass4 fBC;

                    public final boolean oU() {
                        this.fBC.fBB.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 fBD;

                            {
                                this.fBD = r1;
                            }

                            public final void run() {
                                a.dismiss();
                            }
                        });
                        return true;
                    }
                }, false).ea(1000);
            }
        });
    }

    private void h(final k kVar) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI fBB;

            public final void run() {
                this.fBB.dFI = g.a(this.fBB.nDR.nEl, this.fBB.getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass5 fBE;

                    {
                        this.fBE = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(kVar);
                    }
                });
            }
        });
    }
}
