package books;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Test extends Simulation {

    ProtocolBuilder httpProtocol = http
//            .baseUrl("https://gateway-stage.apps.mn-kp01.vimpelcom.ru/lt/1.0.0")
//            .authorizationHeader("Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJtYXBpYyIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoidlh1ZFBEWjN0UFhtdzNXNHB2WnVyc2FseGFrYSIsIm5iZiI6MTY0NDQ4NjI4NCwiYXpwIjoidlh1ZFBEWjN0UFhtdzNXNHB2WnVyc2FseGFrYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9zdGFnZS5hcHBzLm1uLWtwMDEudmltcGVsY29tLnJ1OjQ0M1wvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY0NzA3ODI4NCwiaWF0IjoxNjQ0NDg2Mjg0LCJqdGkiOiI3MzczYzM2My0xNjJlLTQwM2QtYjU3Ni1iMDRlYmI0OTdiNWMifQ.Eg5Qk_nwk_wAsMixdz_55VirS4fc7h2yFM8kJY2mJdNuNMzFY7LCtLVq0WrS1gXXzBAM4XjZdRv3yY17hGKGa_G00xqfcWhboLqNRfjzkl59Ql1zl9ereSZ41ZaiEZ6FbjymaXmVb6EuC0DZ4y7JQnDW6hQAQbAx31iy-gO-AjjwdhEaR_C5BWAd4G_v1R5xhN5wKYjOMbGvtcyDEPiVKwW-PwEM9ndGAVQ_kCwD2f7JTM1i7HOTjbRBuzSBG09DQGKkrmI3KzbgPZet8Ad4DxPn_fnSyyUhaK_k-mQz12s3Z3woBt1Ogbap1nRA5ZizPdEgPjpBNuk_WZlClpmwAQ");
//            .baseUrl("https://127.0.0.1:8243/5/1.0.6")
//            .baseUrl("http://127.0.0.1:7777");
//            .baseUrl("http://127.0.0.1:7766");

            //DIRECT
//            .baseUrl("http://ms-loadrtst031.bee.vimpelcom.ru:7777");
            //STAGE
            .baseUrl("https://gateway-stage.apps.mn-kp01.vimpelcom.ru/lt4/1.0.1")
            .authorizationHeader("Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJtYXBpYyIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiXzdHZUU1T2lsVk1Vd0dLWjNqZmJxX2IzWldZYSIsIm5iZiI6MTY0NTY5NzU1OCwiYXpwIjoiXzdHZUU1T2lsVk1Vd0dLWjNqZmJxX2IzWldZYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9zdGFnZS5hcHBzLm1uLWtwMDEudmltcGVsY29tLnJ1OjQ0M1wvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY0ODI4OTU1OCwiaWF0IjoxNjQ1Njk3NTU4LCJqdGkiOiIzNDJhNmJkNy02M2FjLTRjZmMtODJkMy02OWNlMWM1YTdhNjkifQ.urGck6ruy3F6NS8YtHqcEqajXOVMrh95uXM7uwRDI4cmdhwttTjD22QBwPWHboyyjQP2tC4zG2HvAedZCSyfsbQioJVr-KfM2itPMaPlsSQrPrRyl_WeyJFaepdvgPtfPNT1jeYBz9Xm_HfN_hzU1AHKOrCXWqWu2V4Y4tP66xvcHmC_r7iayc2wuPBJz6bpT4u6cB7q6B2aGyjvb-grnm4-CosZdk1q563ZIBeuef_7Y54izpvSxwx65W5GY7L3CRQz9JLIZ2YdlX6IPoiu6jeFKDmTohDNpZGxRH59GouDyqGb7KLRHl4B4uKBfcvC66MqfgfFR1UTBm0-kSu0eA");

    //PROD
//            .baseUrl("https://gw.mapic.vimpelcom.ru/ltc1/1.0.2")
//            .authorizationHeader("Bearer eyJ4NXQiOiJZbVEzTW1JeU1qRXpZelJpTURKa1ptUmtZalExTkdVMVl6ZGlPR0U0TVdNNFltRmlNRE14TWpKaE1UWmpaalV3T1RabVlqWTFaamN5WW1Zd01EQm1ZUSIsImtpZCI6IlltUTNNbUl5TWpFell6UmlNREprWm1Sa1lqUTFOR1UxWXpkaU9HRTRNV000WW1GaU1ETXhNakpoTVRaalpqVXdPVFptWWpZMVpqY3lZbVl3TURCbVlRX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJtYXBpYyIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiQ2VqSDN0NUNkYnBKMGpidko4MDZwNzR2TlZ3YSIsIm5iZiI6MTY0NjA2MzA4NywiYXpwIjoiQ2VqSDN0NUNkYnBKMGpidko4MDZwNzR2TlZ3YSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9tYXBpYy52aW1wZWxjb20ucnU6NDQzXC9vYXV0aDJcL3Rva2VuIiwiZXhwIjoxNjQ4NjU1MDg3LCJpYXQiOjE2NDYwNjMwODcsImp0aSI6IjU4YmQ2Nzk3LTNjYjctNDg0ZC1hMTc3LTYyOTI3OTcwNmViOSJ9.ege9Cf-zFdV1K74Irc42wxf07wxMtEKSiayv2Cyb3htTuDitdbS6g2XLyhQeZL-MMyggMsvpIL1X0ckLZ2HSaD9AuRMHcv46MkYG03asm363wjOraRORUZVflNlN39srFGBbAH7kaKEgF8P8TQjnU72dwEA0L9SHzlzcgCsC19ihEUm7Ept8h1znQdedVrBI_RnwmiOfvYjYhk_6WmBvFgxRclXnkiafsx-DUHdfF8O2XoHKV4DxvO5KMRyfvQrkO3tmSDuh6pkpM3NBcpuUIhXJ5rFsIthK7DpPN6BV488g5OUIdhUKpQ1WTBXLXR2Gm7Qk-nQM1kqIZIpgNRcKZw");

    //go-ping
//            .baseUrl("http://localhost:8080");

    ChainBuilder getBooks = exec(
            http("books")
//                    .get("/books")
                    .get("/Authenticator/WsAuthenticator")
//                    .get("/")
                    .check(status().is(200))
    );

    ScenarioBuilder scn = scenario("books")
            .exec(getBooks);

    //open model
    {
        setUp(
                scn.injectOpen(
                        rampUsersPerSec(1).to(700).during(Duration.ofMinutes(2))
//                        ,constantUsersPerSec(1000).during(Duration.ofMinutes(10))
                ).protocols(httpProtocol)
        )
//                .throttle(reachRps(500).in(Duration.ofMinutes(2)))
                .assertions(global().responseTime().max().lt(30000))
        ;
    }

    //closed model
//    {
//        setUp(
//                scn.injectClosed(
//                        rampConcurrentUsers(50).to(1000).during(Duration.ofMinutes(2))
////                        ,constantUsersPerSec(1000).during(Duration.ofMinutes(10))
//                ).protocols(httpProtocol)
//        )
////                .throttle(reachRps(500).in(Duration.ofMinutes(2)))
//                .assertions(global().responseTime().max().lt(30000))
//        ;
//    }


}
