package jp.yahooapis.im.V4.error;

import java.util.List;

public interface ErrorEntity {

    String getCode();
    
    String getMessage();
    
    String getRequestKey();
    
    List<String> getRequestValue();
}
