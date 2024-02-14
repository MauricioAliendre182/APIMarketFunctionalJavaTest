package org.platzi.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers({
        "Content-Type: application/json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYXBzMTgyIiwiZXhwIjoxNzA3OTUxNjM3LCJuYW1lIjoiTWF1cmljaW8ifQ.AEFR-WpnA6lUSPK0lqEhFfNgeWVJp-y5g5wbtIzX1dI"
})
public interface APIJobs {
    @RequestLine("GET /market/api/clients")
    List<Client> clients(@QueryMap Map<String, Object> queryMap);
}
