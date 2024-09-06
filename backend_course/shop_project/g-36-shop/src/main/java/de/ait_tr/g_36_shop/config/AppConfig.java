package de.ait_tr.g_36_shop.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean // помещаем в Spring-контекст
    public AmazonS3 doClient(DOProperties properties){
        // Все значения, применяемые ниже, нужно поместить в переменные окружения

        // аутентификация
        AWSCredentials credentials =
                new BasicAWSCredentials(
                        properties.getAccessKey(),
                        properties.getSecretKey()
                );

        // подключение к дата-центру
        AwsClientBuilder.EndpointConfiguration endpointConfig =
                new AwsClientBuilder.EndpointConfiguration(
                        properties.getUrl(),
                        properties.getRegion()
                );

        AmazonS3ClientBuilder clientBuilder = AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(endpointConfig)
                .withCredentials(new AWSStaticCredentialsProvider(credentials));

        return clientBuilder.build();
    }

}
