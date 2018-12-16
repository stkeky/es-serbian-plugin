package org.elasticsearch.keky.io;

import org.apache.commons.lang3.StringUtils;

import java.text.Normalizer;

class LatinUtils {

    static String removeAccents(final String origin) {
        final String normalized = Normalizer.normalize(origin, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }


    static String cyrToLatin(final String origin) {
        final String replacedSingles = StringUtils.replaceEach(origin, cyr_plain, lat_plain);
        return StringUtils.replaceEach(replacedSingles, cyr_composite, lat_composite);
    }

    private static String[] cyr_plain = {"\u0410", "\u0411", "\u0412", "\u0413",
            "\u0414", "\u0402", "\u0415", "\u0416", "\u0417", "\u0418",
            "\u0408", "\u041A", "\u041B", "\u041C", "\u041D", "\u041E",
            "\u041F", "\u0420", "\u0421", "\u0422", "\u040B", "\u0423",
            "\u0424", "\u0425", "\u0426", "\u0427", "\u0428", "\u0430",
            "\u0431", "\u0432", "\u0433", "\u0434", "\u0452", "\u0435",
            "\u0436", "\u0437", "\u0438", "\u0458", "\u043A", "\u043B",
            "\u043C", "\u043D", "\u043E", "\u043F", "\u0440", "\u0441",
            "\u0442", "\u045B", "\u0443", "\u0444", "\u0445", "\u0446",
            "\u0447", "\u0448"};

    private static String[] lat_plain = {"A", "B", "V", "G", "D", "Đ", "E",
            "Ž", "Z", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S",
            "T", "Ć", "U", "F", "H", "C", "Č", "Š", "a", "b",
            "v", "g", "d", "đ", "e", "ž", "z", "i", "j", "k", "l",
            "m", "n", "o", "p", "r", "s", "t", "ć", "u", "f", "h", "c",
            "č", "š"};

    private static String[] cyr_composite = {
            "\u0409", "\u040A", "\u040F", "\u0402", "\u0459", "\u045A", "\u045F", "\u0452"
    };

    private static String[] lat_composite = {
            "LJ", "NJ", "D\u017D", "\u0110", "lj", "nj", "d\u017E", "\u0111"
    };

}
