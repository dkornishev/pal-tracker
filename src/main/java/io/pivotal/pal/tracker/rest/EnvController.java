package io.pivotal.pal.tracker.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danil Kornishev (danil.kornishev@mastercard.com)
 */
@RestController
public class EnvController {

    private Map<String, String> props = new HashMap<>();

    public EnvController(@Value("${PORT:NOTSET}") String port, @Value("${MEMORY_LIMIT:12g}")String memory, @Value("${CF_INSTANCE_INDEX:10}")String cfInstanceIndex, @Value("${CF_INSTANCE_ADDR:sorrow.com}")String cfInstanceAddress) {
        props.put("PORT", port);
        props.put("MEMORY_LIMIT", memory);
        props.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        props.put("CF_INSTANCE_ADDR", cfInstanceAddress);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return props;
    }
}
