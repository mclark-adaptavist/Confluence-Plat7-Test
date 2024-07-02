package matttest.fragments;

import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.ContextProvider;

import java.util.Map;

class SomePanelContext implements ContextProvider {

    Map<String, String> customParams = new java.util.HashMap<>();

    SomePanelContext() {}

    @Override
    public void init(Map<String, String> params) throws PluginParseException {
        //put the params defined in XML into a class level map so we can use them in getContextMap method
        // that will then push the params through to the web panel class
        customParams.putAll(params);
    }

    @Override
    public Map<String, Object> getContextMap(Map<String, Object> context) {
        context.putAll(customParams);
        return context;
    }
}

