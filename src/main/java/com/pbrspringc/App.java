package com.pbrspringc;

import com.pbrspringc.container.AppContainer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App {
    public static void main(String[] args) {
        AppContainer.run(App.class);
    }
}
