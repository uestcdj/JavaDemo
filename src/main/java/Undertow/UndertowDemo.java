package Undertow;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class UndertowDemo {

 public static void main(String[] args) {
  Undertow server = Undertow.builder().addHttpListener(8080, "localhost")
    .setHandler(new HttpHandler() {
    	
     public void handleRequest(HttpServerExchange exchange) throws Exception {
	      exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
	      exchange.getResponseSender().send("HelloWorld");
     }
    }).build();
  server.start();
 }

}