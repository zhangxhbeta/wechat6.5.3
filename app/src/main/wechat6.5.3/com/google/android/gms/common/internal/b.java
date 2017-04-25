package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.b.c;
import com.google.android.gms.b.c.a;

public final class b extends c<u> {
    private static final b anZ = new b();

    private b() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2) {
        return anZ.b(context, i, i2);
    }

    private View b(Context context, int i, int i2) {
        try {
            return (View) com.google.android.gms.b.b.a(((u) B(context)).a(com.google.android.gms.b.b.aa(context), i, i2));
        } catch (Throwable e) {
            throw new a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public final /* synthetic */ Object e(IBinder iBinder) {
        return u.a.j(iBinder);
    }
}
