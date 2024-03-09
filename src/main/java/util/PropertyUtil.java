package util;

import enums.ConfigProperties;
import exceptions.NoSuchPropertyFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {
    private static Properties prop = new Properties();
    private static final Map<String, String> CONFIG_MAP = new HashMap<>();

    private PropertyUtil() {
    }

    static {

        try (FileInputStream file = new FileInputStream(ConstantsUtil.getConfigFilePath())) {
            prop.load(file);

            for (Map.Entry<Object, Object> entry : prop.entrySet())
                CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());

        } catch (IOException e) {
            e.fillInStackTrace();
            System.exit(0);
        }

    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase())))
            throw new NoSuchPropertyFileException("El nombre de la propiedad: " + key + " no se encuentra. Verifique el archivo config.properties");
        return CONFIG_MAP.get(key.name().toLowerCase());
    }


}
