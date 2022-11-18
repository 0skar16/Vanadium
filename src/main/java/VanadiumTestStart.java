import dev.ztech.vanadium.Vanadium;

import java.util.Arrays;

public class VanadiumTestStart {
    public static void main(String[] args)
    {

        Vanadium.main(concat(new String[] {"--version", "vanadium", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.7.10", "--userProperties", "{}"}, args));
    }
    public static <T> T[] concat(T[] first, T[] second)
    {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
