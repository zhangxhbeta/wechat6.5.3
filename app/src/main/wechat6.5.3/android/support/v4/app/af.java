package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.ag.a;

final class af {
    static RemoteInput[] a(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            remoteInputArr[i] = new Builder(aVar.getResultKey()).setLabel(aVar.getLabel()).setChoices(aVar.getChoices()).setAllowFreeFormInput(aVar.getAllowFreeFormInput()).addExtras(aVar.getExtras()).build();
        }
        return remoteInputArr;
    }
}
