package com.baijiaxiu.services.cloud.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author hujinming
 * @date 2019/9/18 14:57
 */
@Data
@Slf4j
@ApiModel(description = "通用响应体")
@SuppressWarnings("WeakerAccess")
public class CommonResponse<T> {
    private static Logger LOGGER = LoggerFactory.getLogger(CommonResponse.class);
    @ApiModelProperty(value = "时间戳")
    private long timestamp;
    @ApiModelProperty(value = "响应状态码")
    private int status;
    @ApiModelProperty(value = "响应状态吗(内部定义)")
    private int code = 0;
    @ApiModelProperty(value = "错误信息")
    private String message;
    @ApiModelProperty(value = "请求路径")
    private String path;
    @ApiModelProperty(value = "返回实体信息")
    private T entity;

    public static <T> CommonResponse ok(T entity) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.entity = entity;
        commonResponse.timestamp = System.currentTimeMillis();
        commonResponse.status = HttpStatus.OK.value();
        return commonResponse;
    }
    public static <T> CommonResponse error(int status,String message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.timestamp = System.currentTimeMillis();
        commonResponse.status = status;
        commonResponse.message = message;
        commonResponse.code =1;
        return commonResponse;
    }
    @ApiModel(description="通用错误返回对象")
    public static class ErrorResponse extends CommonResponse {
        @Setter
        @Getter
        private List<KeyError> errors;

        public static ErrorResponse error(String path) {
            return error(path, (String) null);
        }

        public static ErrorResponse error(String path, String message) {
            return error(path, HttpStatus.BAD_REQUEST.value(), message, null);
        }

        public static ErrorResponse error(String path, Errors errors) {
            return error(path, HttpStatus.BAD_REQUEST, errors);
        }

        public static ErrorResponse error(String path, HttpStatus status) {
            return error(path, status, null);
        }

        public static ErrorResponse error(String path, HttpStatus status, Errors errors) {
            return error(path, status.value(), status.getReasonPhrase(), errors);
        }

        public static ErrorResponse error(String path, int status, String message) {
            return error(path, status, message, null);
        }
        public static ErrorResponse error(int status, String message, int code) {
            return error(status, message,1);
        }

        public static ErrorResponse error(String path, int status, String message, Errors errors) {
            return error(path, status, message, errors,0);
        }
        public static ErrorResponse error(String path, int status, String message, Errors errors, int code) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setTimestamp(System.currentTimeMillis());
            errorResponse.setPath(path);
            errorResponse.setStatus(status);
            errorResponse.setMessage(message);
            errorResponse.setCode(code);
            errorResponse.setErrors(coverToBeanError(errors));
            log.debug("error response created: {}", errorResponse);
            return errorResponse;
        }


        private static List<KeyError> coverToBeanError(Errors errors) {
            if (Objects.isNull(errors)){
                return null;
            }
            return errors.getAllErrors().stream().map(error -> new KeyError(error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName(),
                    error.getDefaultMessage())).collect(Collectors.toList());
        }


        @NoArgsConstructor
        @Data
        public static class KeyError {
            private String key;
            private String code;

            public KeyError(String key, String code) {
                this.key = key;
                //this.code = code;
                this.code = code;
            }
        }
    }
}
