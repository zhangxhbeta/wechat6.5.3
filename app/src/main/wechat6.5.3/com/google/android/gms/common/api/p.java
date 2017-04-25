package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;

public interface p {
    <A extends b, R extends g, T extends a<R, A>> T a(T t);

    void a(ConnectionResult connectionResult, a<?> aVar, int i);

    void bH(int i);

    void begin();

    void connect();

    void disconnect();

    void g(Bundle bundle);

    String getName();
}
