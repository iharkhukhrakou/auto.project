package auto.project.core.utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class CountriesUtils {
    private static final Stream<String> countryCodes = Arrays.stream(Locale.getISOCountries());
    private static final Stream<String> i18n = Stream.of("US", "RU");

    private CountriesUtils() {
        throw new Error("no instances");
    }

    public static Map<String, String> getI18n(Locale locale) {
        return i18n.collect(Collectors.toMap(code -> {return code;}, code -> {
            Locale obj = new Locale("",code);
            return obj.getDisplayCountry(locale);
        }));
    }

    public static Map<String, String> getCountries(Locale locale) {
        return countryCodes.collect(Collectors.toMap(code -> {return code;}, code -> {
            Locale obj = new Locale("",code);
            return obj.getDisplayCountry(locale);
        }));
    }
}
