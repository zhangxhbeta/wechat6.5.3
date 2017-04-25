package com.google.android.gms.common.data;

import com.google.android.gms.common.api.f;

public interface b<T> extends f, Iterable<T> {
    T get(int i);

    int getCount();
}
