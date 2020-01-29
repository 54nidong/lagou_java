package resource;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsSteam (String path) {
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(path);

        return inputStream;
    }
}
