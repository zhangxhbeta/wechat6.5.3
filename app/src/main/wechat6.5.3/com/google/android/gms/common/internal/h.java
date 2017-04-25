package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h {
    public final Account ajj;
    public final Set<Scope> akE;
    private final int akF;
    private final View akG;
    public final String akH;
    final String akI;
    public final e aoA;
    public Integer aoB;
    final Set<Scope> aoy;
    public final Map<com.google.android.gms.common.api.a<?>, a> aoz;

    public static final class a {
        public final Set<Scope> akY;
        public final boolean aoC;
    }

    public h(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, a> map, int i, View view, String str, String str2, e eVar) {
        Map map2;
        this.ajj = account;
        this.akE = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.aoz = map2;
        this.akG = view;
        this.akF = i;
        this.akH = str;
        this.akI = str2;
        this.aoA = eVar;
        Set hashSet = new HashSet(this.akE);
        for (a aVar : this.aoz.values()) {
            hashSet.addAll(aVar.akY);
        }
        this.aoy = Collections.unmodifiableSet(hashSet);
    }
}
