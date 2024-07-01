You have successfully created an Atlassian Plugin!

Here are the SDK commands you'll use immediately:

* atlas-run   -- installs this plugin into the product and starts it on localhost
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
* atlas-help  -- prints description for all commands in the SDK

Full documentation is always available at:

https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK

# Reproduce WebPanel Problem

Set your hava home to the JDK 17 and make sure your open terminal returns that version with `java -version`

1. Run `atlas-package`
2. Run `atlas-debug`
3. Wait for the terminal where you ran `atlas-debug` to say `confluence started successfully`
4. Open a browser and navigate to `http://localhost:1990/confluence`
5. Check the same terminal window again and you should see the following error:
    ```
    javax.servlet.ServletException: org.apache.velocity.exception.MethodInvocationException:
    Invocation of method 'getDisplayableWebPanels' in  class com.atlassian.confluence.impl.plugin.web.readonly.ReadOnlyWebInterfaceManager
    threw exception java.lang.ClassCastException:
    class matttest.fragments.SomeWebPanel cannot be cast to class com.atlassian.plugin.web.model.WebPanel
    ```
6. Kill the `atlas-debug` process by pressing `Ctrl+C` in the terminal
7. Run `atlas-clean`
8. Edit `matttest.fragments.SomeWebPanel` and change the `import com.atlassian.plugin.web.api.model.WebPanel;`
   to import com.atlassian.plugin.web.model.WebPanel;`
9. Repeat steps 2-5
10. You should not get the error and be able to log into confluence

The WebPanel class is defined in `matttest.fragments.SomeWebPanel`, and used by the `web-panel` with key `test-key` 
located in `src/main/resources/atlassian-plugin.xml`.