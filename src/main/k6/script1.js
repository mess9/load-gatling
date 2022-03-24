import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    stages: [
        { duration: '30s', target: 700 },  //rump up
        { duration: '30s', target: 700 }, // stay at 100 users for 10 minutes
        { duration: '10s', target: 0 }, // ramp-down to 0 users
    ],
    thresholds: {
        'http_req_duration': ['p(99)<1500'], // 99% of requests must complete below 1.5s
        'logged in successfully': ['p(99)<1500'], // 99% of requests must complete below 1.5s
    },
};

export default function () {

    const token = "eyJ4NXQiOiJZbVEzTW1JeU1qRXpZelJpTURKa1ptUmtZalExTkdVMVl6ZGlPR0U0TVdNNFltRmlNRE14TWpKaE1UWmpaalV3T1RabVlqWTFaamN5WW1Zd01EQm1ZUSIsImtpZCI6IlltUTNNbUl5TWpFell6UmlNREprWm1Sa1lqUTFOR1UxWXpkaU9HRTRNV000WW1GaU1ETXhNakpoTVRaalpqVXdPVFptWWpZMVpqY3lZbVl3TURCbVlRX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJtYXBpYyIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiQ2VqSDN0NUNkYnBKMGpidko4MDZwNzR2TlZ3YSIsIm5iZiI6MTY0NjA2MzA4NywiYXpwIjoiQ2VqSDN0NUNkYnBKMGpidko4MDZwNzR2TlZ3YSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9tYXBpYy52aW1wZWxjb20ucnU6NDQzXC9vYXV0aDJcL3Rva2VuIiwiZXhwIjoxNjQ4NjU1MDg3LCJpYXQiOjE2NDYwNjMwODcsImp0aSI6IjU4YmQ2Nzk3LTNjYjctNDg0ZC1hMTc3LTYyOTI3OTcwNmViOSJ9.ege9Cf-zFdV1K74Irc42wxf07wxMtEKSiayv2Cyb3htTuDitdbS6g2XLyhQeZL-MMyggMsvpIL1X0ckLZ2HSaD9AuRMHcv46MkYG03asm363wjOraRORUZVflNlN39srFGBbAH7kaKEgF8P8TQjnU72dwEA0L9SHzlzcgCsC19ihEUm7Ept8h1znQdedVrBI_RnwmiOfvYjYhk_6WmBvFgxRclXnkiafsx-DUHdfF8O2XoHKV4DxvO5KMRyfvQrkO3tmSDuh6pkpM3NBcpuUIhXJ5rFsIthK7DpPN6BV488g5OUIdhUKpQ1WTBXLXR2Gm7Qk-nQM1kqIZIpgNRcKZw"
    const url = 'https://mapic.vimpelcom.ru/gw/ltc1/1.0.2/Authenticator/WsAuthenticator';
    const authHeaders = {
        headers: {
            Authorization: `Bearer ` + token,
        },
    };

    http.get(url, authHeaders);
}