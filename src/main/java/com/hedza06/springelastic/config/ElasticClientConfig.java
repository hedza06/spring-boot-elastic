package com.hedza06.springelastic.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.hedza06.springelastic.repository")
public class ElasticClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient()
    {
        try
        {
            final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

            return RestClients.create(clientConfiguration).rest();
        }
        catch (Exception e)
        {
            log.error("Error occurred while configuring the client. Message: {}", e.getMessage());
            return null;
        }
    }
}
