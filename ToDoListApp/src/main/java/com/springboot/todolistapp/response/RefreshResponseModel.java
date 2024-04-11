package com.springboot.todolistapp.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RefreshResponseModel {
    private String accessToken;
}
