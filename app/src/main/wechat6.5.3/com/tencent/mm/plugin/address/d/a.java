package com.tencent.mm.plugin.address.d;

import android.content.Intent;
import com.tencent.mm.plugin.address.c.b;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static Intent b(b bVar) {
        if (bVar == null) {
            v.e("MicroMsg.AddrUtil", "addressObj == null");
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.dxK);
        intent.putExtra("userName", bVar.dxI);
        intent.putExtra("telNumber", bVar.dxJ);
        intent.putExtra("addressPostalCode", bVar.dxG);
        intent.putExtra("proviceFirstStageName", bVar.dxD);
        intent.putExtra("addressCitySecondStageName", bVar.dxE);
        intent.putExtra("addressCountiesThirdStageName", bVar.dxF);
        intent.putExtra("addressDetailInfo", bVar.dxH);
        return intent;
    }
}
