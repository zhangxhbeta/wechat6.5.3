package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.g;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindlinkedin.ListLinkedInFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;

public class AddMoreFriendsByOtherWayUI extends MMPreference {
    private f dxf;

    public final int Oo() {
        return 2131099650;
    }

    public final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onResume() {
        super.onResume();
        if (((IconPreference) this.dxf.Ow("find_friends_by_google_account")) != null) {
            if (((k.xQ() & 8388608) == 0 ? 1 : null) == null || !be.He()) {
                this.dxf.Ox("find_friends_by_google_account");
            }
        }
        this.dxf.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        v.d("MicroMsg.AddMoreFriendsByOthersUI", "click %s", new Object[]{preference.dnU});
        Intent intent;
        if ("find_friends_by_mobile".equals(preference.dnU)) {
            if (m.EY() != a.cHR) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.w(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_google_account".equals(preference.dnU)) {
            if (n.Fg()) {
                intent = new Intent(this, GoogleFriendUI.class);
                intent.putExtra("enter_scene", 1);
                startActivity(intent);
                return true;
            }
            intent = new Intent(this, BindGoogleContactUI.class);
            intent.putExtra("enter_scene", 1);
            MMWizardActivity.w(this, intent);
            return true;
        } else if (!"find_friends_by_linkedin".equals(preference.dnU)) {
            return false;
        } else {
            intent = new Intent(this, ListLinkedInFriendUI.class);
            intent.putExtra("KScene", 1);
            startActivity(intent);
            return true;
        }
    }

    protected final void NI() {
        vD(2131230810);
        this.dxf = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AddMoreFriendsByOtherWayUI khl;

            {
                this.khl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.khl.finish();
                return true;
            }
        });
        if ((k.xQ() & 16777216) == 16777216 || !g.sX()) {
            this.dxf.aO("find_friends_by_linkedin", true);
        } else {
            this.dxf.aO("find_friends_by_linkedin", false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
