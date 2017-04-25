package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import java.io.InputStream;

public interface c {

    public interface b {
        void a(e eVar);
    }

    public interface a extends g {
    }

    public interface c extends g {
    }

    public interface d extends f, g {
        InputStream getInputStream();
    }

    e<c> a(com.google.android.gms.common.api.c cVar, Uri uri);

    e<d> a(com.google.android.gms.common.api.c cVar, Asset asset);

    e<a> a(com.google.android.gms.common.api.c cVar, PutDataRequest putDataRequest);
}
