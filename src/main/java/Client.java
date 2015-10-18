import http.HttpRequest;
import http.HttpResponse;

public class Client {
    
    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
