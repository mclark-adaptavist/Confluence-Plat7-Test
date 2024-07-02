package matttest.fragments;

import com.atlassian.plugin.web.model.WebPanel;

// using new interface does not work as it gives a classCastException trying to cast to the old interface
//import com.atlassian.plugin.web.api.model.WebPanel;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class SomeWebPanel implements WebPanel {

    @Override
    public String getHtml(Map<String, Object> context) {
        // we need access to the web panels XML params here
        String myParam = (String) context.get("providerScript");

        return "<div class='aui-banner aui-banner-error' role='banner' aria-hidden='false'> <strong>Testing123</strong>: Test Web Panel param: "
                + myParam
                + "</div>";
    }

    @Override
    public void writeHtml(Writer writer, Map<String, Object> context) throws IOException {
        getHtml(context);
    }
}