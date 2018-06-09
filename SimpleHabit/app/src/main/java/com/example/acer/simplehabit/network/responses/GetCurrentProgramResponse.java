package com.example.acer.simplehabit.network.responses;

import com.example.acer.simplehabit.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by Acer on 5/25/2018.
 */

public class GetCurrentProgramResponse {
    public int code;
    public String message;
    public String apiVersion;
    public CurrentProgramVO currentProgram;

    public String getApiVersion() {
        return apiVersion;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }
}
