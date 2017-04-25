package com.tencent.mm.plugin.accountsync.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.friend.RecommendFriendUI;

public class InviteRecommendChoiceUI extends MMPreference {
    private f dxf;

    protected final boolean On() {
        return false;
    }

    public final int Oo() {
        return 2131099697;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        Intent intent;
        if (str.equals("settings_invite_qq_friends")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mail")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(2));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mb")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(1));
            startActivity(intent);
        } else if (str.equals("settings_invite_mobile_friends")) {
            intent = new Intent("android.intent.action.VIEW");
            Object[] objArr = new Object[1];
            ak.yW();
            objArr[0] = c.vf().get(2, null);
            intent.putExtra("sms_body", getString(2131233326, objArr));
            intent.setType("vnd.android-dir/mms-sms");
            if (be.m(this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, 2131234877, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        return false;
    }

    protected final void NI() {
        vD(2131234903);
        this.dxf = this.ocZ;
        this.dxf.b((IconPreference) this.dxf.Ow("settings_invite_facebook_friends"));
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_invite_qq_friends");
        if (k.xE() == 0) {
            this.dxf.b(iconPreference);
        }
        iconPreference = (IconPreference) this.dxf.Ow("settings_recommend_by_mail");
        if (k.xE() == 0) {
            this.dxf.b(iconPreference);
        }
        iconPreference = (IconPreference) this.dxf.Ow("settings_recommend_by_mb");
        ak.yW();
        if (c.wN().Nr("@t.qq.com") == null) {
            this.dxf.b(iconPreference);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteRecommendChoiceUI dxg;

            {
                this.dxg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dxg.axg();
                this.dxg.finish();
                return true;
            }
        });
    }
}
