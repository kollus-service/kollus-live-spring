package net.catenoid.se.kolluslive.util;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));

        String line = null;
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append('\n');
        }

        HttpStatus.Series series = response.getStatusCode().series();
        if (series == HttpStatus.Series.SERVER_ERROR){

        }
        else if(series == HttpStatus.Series.CLIENT_ERROR){
            switch (response.getStatusCode()){
                case NOT_FOUND:
                    break;
                case UNAUTHORIZED:
                    break;
                case BAD_REQUEST:
                    break;
                case UNPROCESSABLE_ENTITY:
                    break;
                case CONFLICT:
                    break;
            }

        }
    }
}
