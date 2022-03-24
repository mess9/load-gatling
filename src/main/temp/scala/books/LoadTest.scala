//package books
//
//import books.Request.getBooks
//import io.gatling.core.Predef._
//import io.gatling.http.Predef.http
//import io.gatling.http.protocol.HttpProtocolBuilder
//
//import scala.language.postfixOps
//
//class LoadTest extends Simulation {
//
//  val httpConf: HttpProtocolBuilder = http
//    .baseUrl("https://gateway-stage.apps.mn-kp01.vimpelcom.ru/lt/1.0.0")
//    .authorizationHeader("Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJtYXBpYyIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoidlh1ZFBEWjN0UFhtdzNXNHB2WnVyc2FseGFrYSIsIm5iZiI6MTY0NDQ4NjI4NCwiYXpwIjoidlh1ZFBEWjN0UFhtdzNXNHB2WnVyc2FseGFrYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9zdGFnZS5hcHBzLm1uLWtwMDEudmltcGVsY29tLnJ1OjQ0M1wvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY0NzA3ODI4NCwiaWF0IjoxNjQ0NDg2Mjg0LCJqdGkiOiI3MzczYzM2My0xNjJlLTQwM2QtYjU3Ni1iMDRlYmI0OTdiNWMifQ.Eg5Qk_nwk_wAsMixdz_55VirS4fc7h2yFM8kJY2mJdNuNMzFY7LCtLVq0WrS1gXXzBAM4XjZdRv3yY17hGKGa_G00xqfcWhboLqNRfjzkl59Ql1zl9ereSZ41ZaiEZ6FbjymaXmVb6EuC0DZ4y7JQnDW6hQAQbAx31iy-gO-AjjwdhEaR_C5BWAd4G_v1R5xhN5wKYjOMbGvtcyDEPiVKwW-PwEM9ndGAVQ_kCwD2f7JTM1i7HOTjbRBuzSBG09DQGKkrmI3KzbgPZet8Ad4DxPn_fnSyyUhaK_k-mQz12s3Z3woBt1Ogbap1nRA5ZizPdEgPjpBNuk_WZlClpmwAQ")
//
//
//  val scn = scenario("books")
//    .exec(getBooks)
//
//  setUp({
//    scn.inject(rampUsersPerSec(30) to (50) during (60)).protocols(httpConf)
//  })
//
//}
