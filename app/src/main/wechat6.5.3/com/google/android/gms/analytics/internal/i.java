package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;

public final class i extends o {
    SharedPreferences agh;
    private long agi;
    private long agj = -1;
    final a agk = new a("monitoring", ((Long) aj.aiR.get()).longValue());

    public final class a {
        final long agl;
        final /* synthetic */ i agm;
        private final String mName;

        private a(i iVar, String str, long j) {
            this.agm = iVar;
            w.U(str);
            w.ab(j > 0);
            this.mName = str;
            this.agl = j;
        }

        private String hG() {
            return this.mName + ":start";
        }

        void hE() {
            long currentTimeMillis = this.agm.afY.agn.currentTimeMillis();
            Editor edit = this.agm.agh.edit();
            edit.remove(hH());
            edit.remove(hI());
            edit.putLong(hG(), currentTimeMillis);
            edit.commit();
        }

        long hF() {
            return this.agm.agh.getLong(hG(), 0);
        }

        String hH() {
            return this.mName + ":count";
        }

        String hI() {
            return this.mName + ":value";
        }
    }

    protected i(q qVar) {
        super(qVar);
    }

    public final j hA() {
        return new j(this.afY.agn, hz());
    }

    public final long hB() {
        q.if();
        hX();
        if (this.agj == -1) {
            this.agj = this.agh.getLong("last_dispatch", 0);
        }
        return this.agj;
    }

    public final void hC() {
        q.if();
        hX();
        long currentTimeMillis = this.afY.agn.currentTimeMillis();
        Editor edit = this.agh.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.agj = currentTimeMillis;
    }

    public final String hD() {
        q.if();
        hX();
        CharSequence string = this.agh.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    protected final void hm() {
        this.agh = this.afY.mContext.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long hz() {
        q.if();
        hX();
        if (this.agi == 0) {
            long j = this.agh.getLong("first_run", 0);
            if (j != 0) {
                this.agi = j;
            } else {
                j = this.afY.agn.currentTimeMillis();
                Editor edit = this.agh.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    F("Failed to commit first run time");
                }
                this.agi = j;
            }
        }
        return this.agi;
    }

    public final void y(String str) {
        q.if();
        hX();
        Editor edit = this.agh.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            F("Failed to commit campaign data");
        }
    }
}
