package io.github.mezk.callbackprocessor;

import org.springframework.stereotype.Component;

@Component("PayOrderCallbackProcessor")
public class CallbackProcessor2 implements CallbackProcessor {
    @Override
    public void process(String callback) {
        System.out.println("PayOrderCallbackProcessor");
    }
}
