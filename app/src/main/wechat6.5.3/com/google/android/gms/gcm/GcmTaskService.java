package com.google.android.gms.gcm;

import android.app.Service;
import java.util.HashSet;
import java.util.Set;

public abstract class GcmTaskService extends Service {
    private final Set<String> arj = new HashSet();
}
