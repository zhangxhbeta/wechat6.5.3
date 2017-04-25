package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ag.a;

final class ah {
    static Bundle[] b(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", aVar.getResultKey());
            bundle.putCharSequence("label", aVar.getLabel());
            bundle.putCharSequenceArray("choices", aVar.getChoices());
            bundle.putBoolean("allowFreeFormInput", aVar.getAllowFreeFormInput());
            bundle.putBundle("extras", aVar.getExtras());
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }
}
