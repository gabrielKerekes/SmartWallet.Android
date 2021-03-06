package com.mobilewallet.android.ocrahotp;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by GabrielK on 13-Feb-17.
 */

class OcraHotp {
    protected static final int[] DIGITS_POWER = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };

    protected static byte[] generateHmac(String algorithm, byte[] keyBytes, byte[] text) {
        try {
            Mac hmac = Mac.getInstance(algorithm);
            SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");

            hmac.init(macKey);

            return hmac.doFinal(text);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
