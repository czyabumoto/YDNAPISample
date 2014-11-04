package jp.yahooapis.im.V4.error.impl;

import java.util.ArrayList;
import java.util.List;

import jp.yahooapis.im.V4.PlacementUrlIdeaService.Error;
import jp.yahooapis.im.V4.error.ErrorEntity;
import jp.yahooapis.im.V4.error.ErrorEntityFactory;

public class PlacementUrlIdeaServiceErrorEntityFactory implements
        ErrorEntityFactory {

    private final List<Error> errors;
    
    
    public PlacementUrlIdeaServiceErrorEntityFactory(List<Error> errors) {
        this.errors = errors;
    }



    @Override
    public List<ErrorEntity> create() {
        ArrayList<ErrorEntity> list = new ArrayList<ErrorEntity>();
        if(errors != null){
            for (final Error error : errors) {
                list.add(
                  new ErrorEntity() {
                    
                    @Override
                    public List<String> getRequestValue() {
                        return error.getDetail() != null ? error.getDetail().getRequestValue() : null;
                    }
                    
                    @Override
                    public String getRequestKey() {
                        return error.getDetail() != null ? error.getDetail().getRequestKey() : null;
                    }
                    
                    @Override
                    public String getMessage() {
                        return error.getMessage();
                    }
                    
                    @Override
                    public String getCode() {
                        return error.getCode();
                    }
                }
                );
            }
        }

        return list;
    }

}
