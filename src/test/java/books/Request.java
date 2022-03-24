package books;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.http.HttpDsl.http;

public class Request {

    ChainBuilder getBooks = exec(
            http("books")
                    .get("/books")
    );

}
