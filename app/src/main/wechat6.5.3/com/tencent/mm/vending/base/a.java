package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.e;

public abstract class a<_Struct> extends Vending<_Struct, Class<?>, Void> {

    public interface a extends e {
    }

    public abstract _Struct v(Class<?> cls);

    protected /* bridge */ /* synthetic */ void applyChangeSynchronized(Object obj) {
    }

    protected /* bridge */ /* synthetic */ Object prepareVendingDataAsynchronous() {
        return null;
    }

    public /* synthetic */ Object resolveAsynchronous(Object obj) {
        return v((Class) obj);
    }

    public void notifyVendingDataChange() {
    }

    public void notifyVendingDataChangeSynchronize() {
    }

    protected void destroyAsynchronous() {
    }
}
