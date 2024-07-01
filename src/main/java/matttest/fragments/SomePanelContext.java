package matttest.fragments;

import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.ContextProvider;

import java.util.Map;

class SomePanelContext implements ContextProvider {
    SomePanelContext() {}

    @Override
    public void init(Map<String, String> params) throws PluginParseException {
        Map<String, String> debugPointHere = params;
    }

    @Override
    public Map<String, Object> getContextMap(Map<String, Object> context) {
        Map<String, Object> debugPointHere = context;

        return context;
    }
}

