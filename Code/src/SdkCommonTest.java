// >>> Replace "event_notifications" with the correct value for your project (e.g. "platform_services")
package com.ibm.cloud.event_notifications.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.annotations.Test;

// >>> Replace "event_notifications" with the correct value for your project (e.g. "platform_services")
import com.ibm.cloud.event_notifications.common.SdkCommon;

/**
 * This class contains tests for the SdkCommon class.
 */
public class SdkCommonTest {

    @Test
    public void testGetSdkHeaders() {
        Map<String, String> headers = SdkCommon.getSdkHeaders("service1", "v1", "operation1");
        assertNotNull(headers);
        assertFalse(headers.isEmpty());
        assertTrue(headers.containsKey("User-Agent"));
        String userAgent = headers.get("User-Agent");
        System.out.println("User-Agent: " + userAgent);
        String expectedUserAgentRegex = String.format("%s/%s .*", SdkCommon.getProjectName(), SdkCommon.getVersion());
        assertTrue(userAgent.matches(expectedUserAgentRegex));
    }
}
