package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI extends MMPreference {
    private SharedPreferences cnm = null;
    private f dxf;
    CheckBoxPreference eQC;
    private String eQD;
    private String eQE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.eQD = getIntent().getStringExtra("RoomInfo_Id");
        this.eQE = getIntent().getStringExtra("room_owner_name");
        this.dxf = this.ocZ;
        if (this.dxf != null) {
            vD(2131233807);
            this.eQC = (CheckBoxPreference) this.dxf.Ow("allow_by_identity");
            this.dxf.aO("select_enable_qrcode", true);
            this.dxf.aO("select_into_room_type", true);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ ManageChatroomUI eQF;

                {
                    this.eQF = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.eQF.finish();
                    return true;
                }
            });
        }
    }

    protected void onResume() {
        boolean z = false;
        o LC = ak.yW().wO().LC(this.eQD);
        if (LC != null && this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
            Editor edit = this.cnm.edit();
            String str = "allow_by_identity";
            if (LC.bvf() == 2) {
                z = true;
            }
            edit.putBoolean(str, z).commit();
        }
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int Oo() {
        return 2131099701;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.dnU;
        v.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[]{str});
        if (str.equals("room_transfer_room_ower")) {
            v.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[]{this.eQD});
            str = be.b(i.ej(this.eQD), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", k.xF());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("frome_scene", 2);
            intent.putExtra("RoomInfo_Id", this.eQD);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(2131234662));
            intent.setClass(this, SelectMemberUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.eQC.isChecked();
            g.iuh.a(219, 22, 1, true);
            v.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[]{this.eQD, Boolean.valueOf(isChecked)});
            aim com_tencent_mm_protocal_c_aim = new aim();
            com_tencent_mm_protocal_c_aim.moN = be.ma(this.eQD);
            if (!isChecked) {
                i = 0;
            }
            com_tencent_mm_protocal_c_aim.itI = i;
            a aVar = new a(66, com_tencent_mm_protocal_c_aim);
            ak.yW();
            c.wG().b(aVar);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    v.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[]{this.eQD, Integer.valueOf(intent.getIntExtra("into_room_type", -1))});
                    aim com_tencent_mm_protocal_c_aim = new aim();
                    com_tencent_mm_protocal_c_aim.moN = be.ma(this.eQD);
                    com_tencent_mm_protocal_c_aim.itI = r0;
                    a aVar = new a(66, com_tencent_mm_protocal_c_aim);
                    ak.yW();
                    c.wG().b(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
