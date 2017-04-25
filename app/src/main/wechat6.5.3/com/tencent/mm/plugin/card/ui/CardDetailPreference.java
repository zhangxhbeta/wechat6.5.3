package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    private b eBg;
    private List<com.tencent.mm.plugin.card.model.b> eBl = new ArrayList();
    private TextView eHI;
    f ezq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        this.eBg = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.eBg == null || this.eBg.Zv() == null || this.eBg.Zw() == null) {
            v.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.eBg.Zv().eCC)) {
            stringBuilder.append(this.eBg.Zv().eCC);
        }
        stringBuilder.append(getString(2131231611));
        Fd(stringBuilder.toString());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardDetailPreference eHJ;

            {
                this.eHJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eHJ.finish();
                return true;
            }
        });
        this.ezq = this.ocZ;
        this.eBl.clear();
        if (this.eBg.Zw().mkj != null && this.eBg.Zw().mkj.size() > 0) {
            this.eBl.addAll(j.ac(this.eBg.Zw().mkj));
        }
        if (this.eBg.Zw().mkk != null && this.eBg.Zw().mkk.size() > 0) {
            Collection ac = j.ac(this.eBg.Zw().mkk);
            ((com.tencent.mm.plugin.card.model.b) ac.get(0)).eBV = true;
            this.eBl.addAll(ac);
        }
        abb();
        aba();
        aaZ();
        if (!TextUtils.isEmpty(this.eBg.Zv().mkP)) {
            CardTextPreference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(2130903996);
            cardTextPreference.setTitle(getString(2131231662));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.acM();
            abb();
            this.ezq.a(cardTextPreference);
        }
        if (!TextUtils.isEmpty(this.eBg.Zv().mkM)) {
            abb();
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(2130903996);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle(2131233773);
            cardTextPreference.setSummary(this.eBg.Zv().mkM);
            cardTextPreference.eNB = getResources().getColor(2131689819);
            cardTextPreference.acL();
            this.ezq.a(cardTextPreference);
            qg("");
        }
        if (this.eBg.Zv() != null && !TextUtils.isEmpty(this.eBg.Zv().aHM) && this.eHI != null) {
            this.eHI.setText(this.eBg.Zv().aHM);
            this.eHI.setVisibility(0);
        }
    }

    private void aaZ() {
        for (int i = 0; i < this.eBl.size(); i++) {
            com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.eBl.get(i);
            Preference preference = new Preference(this);
            preference.setLayoutResource(2130903996);
            preference.setKey(bVar.title);
            preference.setTitle(bVar.title);
            if (!TextUtils.isEmpty(bVar.eBN)) {
                preference.setSummary(bVar.eBN);
            }
            if (bVar.eBV) {
                abb();
            }
            this.ezq.a(preference);
        }
    }

    private void aba() {
        if (this.eBg.Zv().mkO != null && this.eBg.Zv().mkO != null) {
            for (int i = 0; i < this.eBg.Zv().mkO.size(); i++) {
                ld ldVar = (ld) this.eBg.Zv().mkO.get(i);
                if (!TextUtils.isEmpty(ldVar.eBN)) {
                    CardTextPreference cardTextPreference = new CardTextPreference(this);
                    cardTextPreference.setLayoutResource(2130903996);
                    cardTextPreference.setTitle(ldVar.eBN);
                    cardTextPreference.acM();
                    qg(ldVar.title);
                    this.ezq.a(cardTextPreference);
                }
            }
            abb();
        }
    }

    private void abb() {
        this.ezq.a(new PreferenceSmallCategory(this));
    }

    private void qg(String str) {
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle(" ");
        } else {
            preferenceTitleCategory.setTitle(str);
        }
        this.ezq.a(preferenceTitleCategory);
    }

    public final int Oo() {
        return 2131099661;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.dnU.equals("card_phone")) {
            String str = this.eBg.Zv().mkM;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("tel:" + str));
            startActivity(intent);
        }
        if (preference.dnU.equals("key_pic_detail")) {
            com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.eBg.Zv().mkP, 0);
        } else {
            for (int i = 0; i < this.eBl.size(); i++) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.eBl.get(i);
                if (!(bVar.title == null || !bVar.title.equals(preference.dnU) || TextUtils.isEmpty(bVar.url))) {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) this, bVar.url, 1);
                }
            }
        }
        return false;
    }

    public final View abc() {
        View inflate = getLayoutInflater().inflate(2130904526, null);
        this.eHI = (TextView) inflate.findViewById(2131758848);
        this.eHI.setVisibility(8);
        return inflate;
    }
}
