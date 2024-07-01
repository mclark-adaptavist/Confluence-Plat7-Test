package matttest.fragments;

import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.Condition;

import javax.inject.Named;
import java.util.Map;

@Named
class SomeCondition implements Condition {

    @Override
    public void init(Map<String, String> params) throws PluginParseException {
        Map<String, String> debugHereToSeeParams = params;
    }

    @Override
    public boolean shouldDisplay(Map<String, Object> context) {
        return true;
    }
}
