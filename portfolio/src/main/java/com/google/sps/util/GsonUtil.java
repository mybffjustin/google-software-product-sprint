package com.google.sps.util;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Gson util.
 */
public class GsonUtil {
    private static final Logger log     = LogManager.getLogger(GsonUtil.class);
    /**
     * The constant PATTERN.
     */
    public static final  String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";

    private static Gson             gson;
    private static Gson             gsonExpose;
    private static SimpleDateFormat sdf;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Gson getInstance() {
        if (gson == null) {
            gson = getGsonBuilderInstance(false).create();
        }
        return gson;
    }

    /**
     * Gets expose instance.
     *
     * @return the expose instance
     */
    public static Gson getExposeInstance() {
        if (gsonExpose == null) {
            gsonExpose = getGsonBuilderInstance(true).create();
        }
        return gsonExpose;
    }

    /**
     * Gets instance.
     *
     * @param onlyExpose
     *         the only expose
     *
     * @return the instance
     */
    public static Gson getInstance(boolean onlyExpose) {
        if (!onlyExpose) {
            if (gson == null) {
                gson = getGsonBuilderInstance(false).create();
            }
            return gson;
        }
        else {
            if (gsonExpose == null) {
                gsonExpose = getGsonBuilderInstance(true).create();
            }
            return gsonExpose;
        }
    }

    /**
     * Gets sdf instance.
     *
     * @return the sdf instance
     */
    public static SimpleDateFormat getSDFInstance() {
        if (sdf == null) {
            sdf = new SimpleDateFormat(PATTERN);
        }
        return sdf;
    }

    private static GsonBuilder getGsonBuilderInstance(boolean onlyExpose) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (onlyExpose) {
            gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        }
        gsonBuilder.registerTypeAdapter(Date.class,
                                        (JsonDeserializer<Date>) (json, type,
                                                                  arg2) -> {
                                            try {
                                                return getSDFInstance().parse(
                                                        json.getAsString());
                                            }
                                            catch (ParseException e) {
                                                return null;
                                            }
                                        });
        gsonBuilder.registerTypeAdapter(Date.class,
                                        (JsonSerializer<Date>) (src,
                                                                typeOfSrc,
                                                                context) ->
                                                src == null ? null
                                                            : new JsonPrimitive(
                                                                    getSDFInstance().format(
                                                                            src)));
        return gsonBuilder;
    }

    /**
     * From json t.
     *
     * @param <T>
     *         the type parameter
     * @param json
     *         the json
     * @param classOfT
     *         the class of t
     * @param onlyExpose
     *         the only expose
     *
     * @return the t
     */
    public static <T> T fromJson(String json, Class<T> classOfT,
                                 boolean onlyExpose) {
        try {
            return getInstance(onlyExpose).fromJson(json, classOfT);
        }
        catch (Exception ex) {
            log.info(ex);
            return null;
        }
    }
}

