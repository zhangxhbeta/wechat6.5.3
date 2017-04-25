package com.tencent.mm.plugin.wallet.a;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.mm.e.a.mi;
import com.tencent.mm.e.a.mj;
import com.tencent.mm.e.a.mk;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tenpay.android.jni.Encrypt;
import com.tenpay.bankcard.BankCardReg;

public final class j {
    private BankCardInfo kHT;
    c kHU = new c<mk>(this) {
        final /* synthetic */ j kHX;

        {
            this.kHX = r2;
            this.nhz = mk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.kHX.v((mk) bVar);
        }
    };
    c kHV = new c<mj>(this) {
        final /* synthetic */ j kHX;

        {
            this.kHX = r2;
            this.nhz = mj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.kHX.v((mj) bVar);
        }
    };
    c kHW = new c<mi>(this) {
        final /* synthetic */ j kHX;

        {
            this.kHX = r2;
            this.nhz = mi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.kHX.v((mi) bVar);
        }
    };

    public final boolean v(b bVar) {
        if (bVar instanceof mk) {
            this.kHT = null;
            mk mkVar = (mk) bVar;
            BankCardReg.recognizeBankCardInit(mkVar.bnC.width, mkVar.bnC.height, mkVar.bnC.bnE);
            return true;
        } else if (bVar instanceof mj) {
            mj mjVar = (mj) bVar;
            if (this.kHT == null) {
                this.kHT = new BankCardInfo(mjVar.bnv.width, mjVar.bnv.height);
            }
            mjVar.bnw.aYJ = BankCardReg.recognizeBankCardProcess(mjVar.bnv.bnx, this.kHT, mjVar.bnv.bny);
            if (mjVar.bnw.aYJ != 1) {
                return true;
            }
            mjVar.bnw.bitmapData = this.kHT.bitmapData;
            mjVar.bnw.bitmapLen = this.kHT.bitmapLen;
            mjVar.bnw.cardNum = this.kHT.getCardNum();
            mjVar.bnw.cardNumLen = this.kHT.getCardNumLen();
            mjVar.bnw.width = this.kHT.width;
            mjVar.bnw.height = this.kHT.height;
            mjVar.bnw.rectX = this.kHT.getRectX();
            mjVar.bnw.rectY = this.kHT.getRectY();
            if (mjVar.bnv.bnz) {
                Encrypt encrypt = new Encrypt();
                mjVar.bnw.bnA = encrypt.desedeDecode(mjVar.bnw.cardNum, encrypt.getRandomKey());
                return true;
            }
            mjVar.bnw.bnB = BankCardReg.getBankCardSegmentNumber(this.kHT.getCardNum(), this.kHT.getCardNumLen(), this.kHT.getRectX());
            return true;
        } else if (!(bVar instanceof mi)) {
            return false;
        } else {
            this.kHT = null;
            BankCardReg.recognizeBankCardRelease();
            return true;
        }
    }
}
