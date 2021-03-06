package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    private Digest digest = DigestFactory.createMD5();

    private byte[] generateDerivedKey(int i) {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        while (true) {
            this.digest.update(this.password, 0, this.password.length);
            this.digest.update(this.salt, 0, this.salt.length);
            this.digest.doFinal(bArr, 0);
            int length = i > bArr.length ? bArr.length : i;
            System.arraycopy(bArr, 0, bArr2, i2, length);
            i2 += length;
            i -= length;
            if (i == 0) {
                return bArr2;
            }
            this.digest.reset();
            this.digest.update(bArr, 0, bArr.length);
        }
    }

    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    public CipherParameters generateDerivedParameters(int i) {
        i /= 8;
        return new KeyParameter(generateDerivedKey(i), 0, i);
    }

    public CipherParameters generateDerivedParameters(int i, int i2) {
        i /= 8;
        i2 /= 8;
        byte[] generateDerivedKey = generateDerivedKey(i + i2);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i), generateDerivedKey, i, i2);
    }

    public void init(byte[] bArr, byte[] bArr2) {
        super.init(bArr, bArr2, 1);
    }
}
