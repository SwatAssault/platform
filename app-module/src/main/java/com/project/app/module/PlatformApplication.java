package com.project.app.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.project"})
public class PlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    // TODO не работает. попытка открывать браузер после старта сервера
//    @EventListener({ApplicationReadyEvent.class})
//    public void applicationReadyEvent() {
//        System.out.println("Application started ... launching browser now");
//        browse("http://localhost:{port}/");
//    }
//
//    public static void browse(String url) {
//        if (Desktop.isDesktopSupported()) {
//            Desktop desktop = Desktop.getDesktop();
//            try {
//                desktop.browse(new URI(url));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            Runtime runtime = Runtime.getRuntime();
//            try {
//                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}