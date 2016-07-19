package org.raowei.test.learnjunit.chapter5;

import org.raowei.test.strategy.Content;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ${DESCRIPTION}
 * create: 2016-07-19 16:04
 *
 * @author admin
 */
public class WebClient {

    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = is.read(buffer))) {
                content.append(new String(buffer,0,count));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
