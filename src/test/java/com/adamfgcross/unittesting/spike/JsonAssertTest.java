package com.adamfgcross.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert() throws JSONException {
        String expected = "{\"id\":1, \"price\":10, \"name\" : \"Ball\", \"quantity\":100}";
        JSONAssert.assertEquals(expected, actualResponse, true);
    }

    @Test
    public void jsonAssert2() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Ball\"}";
        JSONAssert.assertEquals(expected, actualResponse, false);
    }
}
