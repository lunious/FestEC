package com.lunioussky.latte.net;

import com.lunioussky.latte.net.callback.IError;
import com.lunioussky.latte.net.callback.IFailure;
import com.lunioussky.latte.net.callback.IRequest;
import com.lunioussky.latte.net.callback.ISuccess;
import com.lunioussky.latte.net.callback.ResquestCallBacks;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by lunious on 2017/10/9.
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;

    public RestClient(String url, Map<String, Object> params, IRequest request, ISuccess success, IError error, IFailure failure, RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

    private void request(HttpMethed methed){
        final RestService service = RestCreator.getRestService();
        Call<String> call =null;

        if (REQUEST != null){
            REQUEST.onResquestStart();
        }

        switch (methed){
            case GET:
                call = service.get(URL,PARAMS);
                break;
            case POST:
                call = service.post(URL,PARAMS);
                break;
            case PUT:
                call = service.put(URL,PARAMS);
                break;
            case DELETE:
                call = service.delete(URL,PARAMS);
                break;
            default:
                break;
        }

        if (call != null){
            call.enqueue(getResquestCallback());
        }
    }

    private Callback<String> getResquestCallback(){
        return new ResquestCallBacks(REQUEST,SUCCESS,ERROR,FAILURE);
    }

    public final void get(){
        request(HttpMethed.GET);
    }
    public final void post(){
        request(HttpMethed.POST);
    }
    public final void put(){
        request(HttpMethed.PUT);
    }
    public final void delete(){
        request(HttpMethed.DELETE);
    }
}
