package org.ort.starwars.fleet.utils;

import org.apache.logging.log4j.util.Strings;


public class Parsing {

    /**
     * Extrait le chemin relatif d'une URL si celle-ci commence bien par la base_url fournie
     */
    public static String getEndpoint(String baseUrl, String url) {
         if (url != null && url.startsWith(baseUrl)) {
            return url.substring(baseUrl.length());
        } else {
            return url;
        }
    }

    /**
     * Lit un numérique sans tenir compte d'un séparateur de milier "," "." ou l'espace
     */
    public static int getInt(String value, int fallback) {
        var num = value.replace(",", "").replace(".", "").replace(" ", "");
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            return fallback;
        }
    }
    
    /**
     * Extrait les quantités encodées dans un intervalle de la forme xxx-yyy
     */
    public static int[] getRange(String value, int fallback, String sep) {
        if (Strings.isNotEmpty(value)) {
            if ("n/a".equals(value) || "unknown".equals(value)) {
                return new int[] {-1};
            }
            var chunks = value.split("-");
            int count = chunks.length;
            if (count > 0 && count <= 2) {
                int[] range = new int[count];
                for (int i=0; i<count; i++) {
                    range[i] = getInt(chunks[i], fallback);
                }
                return range;
            }
        }
        return new int[] {};
    }

    public static int[] getRange(String value, int fallback) {
        return getRange(value, fallback, "-");
    }

    public static int[] getRange(String value) {
        return getRange(value, -1, "-");
    }
}


